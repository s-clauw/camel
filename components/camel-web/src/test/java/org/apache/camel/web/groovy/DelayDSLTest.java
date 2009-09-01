/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.camel.web.groovy;

import org.junit.Test;

/**
 * a test case for delay DSL: from().delay().to()
 */
public class DelayDSLTest extends GroovyRendererTestSupport {

    @Test
    public void testSimpleDelay() throws Exception {
        String dsl = "from(\"direct:start\").delay(1000).to(\"mock:result\")";
        assertEquals(dsl, render(dsl));
    }

    @Test
    public void testDelayWithHeaderParameter() throws Exception {
        String dsl = "from(\"direct:start\").delay(header(\"MyDelay\")).to(\"mock:result\")";
        String expected = "from(\"direct:start\").delay().header(\"MyDelay\").to(\"mock:result\")";

        assertEquals(expected, render(dsl));
    }

    @Test
    public void testDelayWithHeaderMehtod() throws Exception {
        String dsl = "from(\"direct:start\").delay().header(\"MyDelay\").to(\"mock:result\")";
        assertEquals(dsl, render(dsl));
    }
}
