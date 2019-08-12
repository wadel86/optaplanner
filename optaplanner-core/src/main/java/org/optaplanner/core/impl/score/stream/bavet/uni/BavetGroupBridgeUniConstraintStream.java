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

package org.optaplanner.core.impl.score.stream.bavet.uni;

import java.util.function.Function;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.stream.uni.UniConstraintCollector;
import org.optaplanner.core.impl.score.stream.bavet.BavetConstraint;
import org.optaplanner.core.impl.score.stream.bavet.bi.BavetGroupBiConstraintStream;
import org.optaplanner.core.impl.score.stream.bavet.bi.BavetGroupBiNode;
import org.optaplanner.core.impl.score.stream.bavet.common.BavetNodeBuildPolicy;

public final class BavetGroupBridgeUniConstraintStream<Solution_, A, GroupKey_, ResultContainer_, Result_>
        extends BavetAbstractUniConstraintStream<Solution_, A> {

    private final BavetGroupBiConstraintStream<Solution_, GroupKey_, ResultContainer_, Result_> biStream;
    private final Function<A, GroupKey_> groupKeyMapping;
    private final UniConstraintCollector<A, ResultContainer_, Result_> collector;

    public BavetGroupBridgeUniConstraintStream(BavetConstraint<Solution_> bavetConstraint,
            BavetGroupBiConstraintStream<Solution_, GroupKey_, ResultContainer_, Result_> biStream,
            Function<A, GroupKey_> groupKeyMapping, UniConstraintCollector<A, ResultContainer_, Result_> collector) {
        super(bavetConstraint);
        this.biStream = biStream;
        this.groupKeyMapping = groupKeyMapping;
        this.collector = collector;
    }

    // ************************************************************************
    // Node creation
    // ************************************************************************

    @Override
    protected BavetGroupBridgeUniNode<A, GroupKey_, ResultContainer_, Result_> createNode(BavetNodeBuildPolicy<Solution_> buildPolicy,
            Score<?> constraintWeight, int nodeOrder, BavetAbstractUniNode<A> parentNode) {
        // TODO create bridge first. Move this to createChildNodeChains
        BavetGroupBiNode<GroupKey_, ResultContainer_, Result_> biNode = biStream.createNodeChain(buildPolicy, constraintWeight, nodeOrder + 1, null);
        BavetGroupBridgeUniNode<A, GroupKey_, ResultContainer_, Result_> node = new BavetGroupBridgeUniNode<>(
                buildPolicy.getSession(), nodeOrder, parentNode, groupKeyMapping, collector, biNode);
        return node;
    }

    @Override
    protected void createChildNodeChains(BavetNodeBuildPolicy<Solution_> buildPolicy, Score<?> constraintWeight, int nodeOrder, BavetAbstractUniNode<A> node) {
        if (!childStreamList.isEmpty()) {
            throw new IllegalStateException("Impossible state: the stream (" + this
                    + ") has an non-empty childStreamList (" + childStreamList + ") but it's a groupBy bridge.");
        }
    }

    @Override
    public String toString() {
        return "GroupBridge()";
    }

    // ************************************************************************
    // Getters/setters
    // ************************************************************************

}