/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

package org.apache.cayenne.exp.parser;

import org.apache.cayenne.exp.Expression;
import org.apache.cayenne.util.ConversionUtil;

/**
 * @since 4.0
 */
public class ASTTrim extends ASTFunctionCall {

    ASTTrim(int id) {
        super(id, "TRIM");
    }

    public ASTTrim(Expression path) {
        super("TRIM", path);
    }

    @Override
    protected String getExpressionOperator(int index) {
        return null;
    }

    @Override
    protected Object evaluateNode(Object o) throws Exception {
        String s1 = ConversionUtil.toString(evaluateChild(0, o));
        if (s1 == null) {
            return null;
        }

        return s1.trim();
    }

    @Override
    public int getType() {
        return Expression.FUNCTION_CALL;
    }

    @Override
    public Expression shallowCopy() {
        return new ASTTrim(id);
    }
}
