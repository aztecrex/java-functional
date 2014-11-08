/**
 * Licensed to Media Science International (MSI) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. MSI
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.msiops.footing.functional;

import java.util.function.Function;

@FunctionalInterface
public interface FunX4<T1, T2, T3, T4, R, X extends Throwable> extends
        Function<T1, FunX3<T2, T3, T4, R, X>> {

    @Override
    default FunX3<T2, T3, T4, R, X> apply(final T1 t1) {
        return (t2, t3, t4) -> apply(t1, t2, t3, t4);
    }

    default FunX2<T3, T4, R, X> apply(final T1 t1, final T2 t2) {
        return (t3, t4) -> apply(t1, t2, t3, t4);
    }

    default FunX1<T4, R, X> apply(final T1 t1, final T2 t2, final T3 t3) {
        return (t4) -> apply(t1, t2, t3, t4);
    }

    R apply(T1 t1, T2 t2, T3 t3, T4 t4) throws X;

}
