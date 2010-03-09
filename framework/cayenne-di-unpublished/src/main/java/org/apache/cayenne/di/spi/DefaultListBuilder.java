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
package org.apache.cayenne.di.spi;

import org.apache.cayenne.ConfigurationException;
import org.apache.cayenne.di.ListBuilder;

/**
 * @since 3.1
 */
class DefaultListBuilder<T> implements ListBuilder<T> {

    private DefaultInjector injector;
    private String implementationTypeKey;

    DefaultListBuilder(Class<T> implementationType, DefaultInjector injector) {
        this.injector = injector;
        implementationTypeKey = DIUtil.toKey(implementationType);
    }

    public <E> ListBuilder<T> add(Class<? extends E> interfaceType)
            throws ConfigurationException {

        ListProvider listProvider = injector.getListConfigurations().get(
                implementationTypeKey);
        if (listProvider == null) {
            listProvider = new ListProvider();
            injector.getListConfigurations().put(implementationTypeKey, listProvider);
        }

        listProvider.add(injector.getProvider(interfaceType));
        return this;
    }

    public <E> ListBuilder<T> add(E value) throws ConfigurationException {

        InstanceProvider<E> provider = new InstanceProvider<E>(value);

        ListProvider listProvider = injector.getListConfigurations().get(
                implementationTypeKey);
        if (listProvider == null) {
            listProvider = new ListProvider();
            injector.getListConfigurations().put(implementationTypeKey, listProvider);
        }

        listProvider.add(provider);
        return this;
    }

}