/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.core.impl.score.stream.drools.common.rules;

import org.optaplanner.core.api.function.TriFunction;

final class TriGroupBy2Map0CollectMutator<A, B, C, NewA, NewB>
        extends TriGroupBy2Map1CollectMutator<A, B, C, NewA, NewB, Void> {

    public TriGroupBy2Map0CollectMutator(TriFunction<A, B, C, NewA> groupKeyMappingA,
            TriFunction<A, B, C, NewB> groupKeyMappingB) {
        super(groupKeyMappingA, groupKeyMappingB, null);
    }

    @Override
    public AbstractRuleAssembler apply(AbstractRuleAssembler ruleAssembler) {
        TriRuleAssembler newRuleAssembler = (TriRuleAssembler) super.apply(ruleAssembler);
        return downgrade(newRuleAssembler);
    }
}
