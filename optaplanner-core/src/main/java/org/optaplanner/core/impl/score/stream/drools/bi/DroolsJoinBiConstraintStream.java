/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.optaplanner.core.impl.score.stream.drools.bi;

import org.drools.model.Declaration;
import org.drools.model.PatternDSL;
import org.optaplanner.core.api.score.stream.bi.BiJoiner;
import org.optaplanner.core.impl.score.stream.bi.AbstractBiJoiner;
import org.optaplanner.core.impl.score.stream.common.JoinerType;
import org.optaplanner.core.impl.score.stream.drools.DroolsConstraintFactory;
import org.optaplanner.core.impl.score.stream.drools.uni.DroolsAbstractUniConstraintStream;

public class DroolsJoinBiConstraintStream<Solution_, A, B> extends DroolsAbstractBiConstraintStream<Solution_, A, B> {

    private final DroolsAbstractUniConstraintStream<Solution_, A> leftParentStream;
    private final DroolsAbstractUniConstraintStream<Solution_, B> rightParentStream;
    private final AbstractBiJoiner<A, B> biJoiner;
    private final PatternDSL.PatternDef<B> bPattern;

    public DroolsJoinBiConstraintStream(DroolsConstraintFactory<Solution_> constraintFactory,
            DroolsAbstractUniConstraintStream<Solution_, A> parent,
            DroolsAbstractUniConstraintStream<Solution_, B> otherStream, BiJoiner<A, B> biJoiner) {
        super(constraintFactory, null);
        this.leftParentStream = parent;
        this.rightParentStream = otherStream;
        this.biJoiner = (AbstractBiJoiner<A, B>) biJoiner;
        this.bPattern = otherStream.getAPattern().expr(getAVariableDeclaration(), (b, a) -> matches(a, b));
    }

    public DroolsAbstractUniConstraintStream<Solution_, A> getLeftParentStream() {
        return leftParentStream;
    }

    public DroolsAbstractUniConstraintStream<Solution_, B> getRightParentStream() {
        return rightParentStream;
    }

    @Override
    public Declaration<A> getAVariableDeclaration() {
        return leftParentStream.getAVariableDeclaration();
    }

    @Override
    public PatternDSL.PatternDef<A> getAPattern() {
        return leftParentStream.getAPattern();
    }

    @Override
    public Declaration<B> getBVariableDeclaration() {
        return rightParentStream.getAVariableDeclaration();
    }

    @Override
    public PatternDSL.PatternDef<B> getBPattern() {
        return bPattern;
    }

    private boolean matches(A left, B right) {
        Object[] leftMappings = biJoiner.getLeftCombinedMapping().apply(left);
        Object[] rightMappings = biJoiner.getRightCombinedMapping().apply(right);
        JoinerType[] joinerTypes = biJoiner.getJoinerTypes();
        for (int i = 0; i < joinerTypes.length; i++) {
            JoinerType joinerType = joinerTypes[i];
            if (!joinerType.matches(leftMappings[i], rightMappings[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "BiJoin() with " + childStreamList.size()  + " children";
    }

}
