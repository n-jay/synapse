/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.util;

import org.apache.axiom.attachments.ByteArrayDataSource;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMDataSource;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.impl.llom.OMSourcedElementImpl;
import org.apache.synapse.transport.base.BaseConstants;
import org.apache.synapse.util.TextFileDataSource;

import junit.framework.TestCase;

public class TextFileDataSourceTest extends TestCase {

    public void testWithXMLChars() throws Exception {
        String testString = "Test string with ampersand (&)";
        OMDataSource dataSource
            = new TextFileDataSource(new ByteArrayDataSource(testString.getBytes("UTF-8")));
        OMFactory omFactory = OMAbstractFactory.getOMFactory();
        OMSourcedElementImpl element
            = new OMSourcedElementImpl(BaseConstants.DEFAULT_TEXT_WRAPPER, omFactory, dataSource);
        assertEquals(testString, element.getText());
    }
}
