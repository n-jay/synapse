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
package org.apache.synapse.config.xml.endpoints;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.config.xml.AbstractTestCase;
import org.apache.synapse.endpoints.WSDLEndpoint;

public class WSDLEndpointSerializationTest extends AbstractTestCase {

        public void testWSDLEndpointScenarioOne() throws Exception {
            String inputXML = "<endpoint>\n" +
                                    "<wsdl uri=\"file:repository/conf/sample/resources/proxy/sample_proxy_1.wsdl\"\n" +
                                    "service=\"SimpleStockQuoteService\"\n" +
                                    "port=\"SimpleStockQuoteServiceHttpSoap11Endpoint\"/>\n" +
                                "</endpoint>";
            OMElement inputElement = createOMElement(inputXML);
            WSDLEndpoint endpoint = (WSDLEndpoint) WSDLEndpointFactory.getEndpointFromElement(inputElement,
                    true, null);

            OMElement serializedOut = WSDLEndpointSerializer.getElementFromEndpoint(endpoint);
            assertTrue(compare(serializedOut,inputElement));

        }
}
