/*
 * Copyright (c) 2016 Network New Technologies Inc.
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

package com.networknt.utility;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilTest {

    @Test
    public void testGetJarVersion() {
        String ver = Util.getJarVersion();
        System.out.println("ver =" + ver);
    }

    @Test
    public void testSubVariables() {
        Map<String, String> variables = new HashMap<>();
        variables.put("v1", "abc");
        variables.put("v2", "def");

        String text = "This is a test for ${v1} and ${v2}";
        String expect = "This is a test for abc and def";

        Assert.assertEquals(expect, Util.substituteVariables(text, variables));

    }

    @Test
    public void testParseAttributes() {
        String attributesString = "department^=^Engineering~location^=^New York City~project^=^Project Alpha";
        Map<String, String> parsedAttributes = Util.parseAttributes(attributesString);
        System.out.println("Parsed Attributes: " + parsedAttributes);
        // Expected Output: Parsed Attributes: {location=New York City, project=Project Alpha, department=Engineering}

        String attributesStringWithNoSpace = "department^=^Engineering~location^=^NewYorkCity";
        Map<String, String> parsedAttributes2 = Util.parseAttributes(attributesStringWithNoSpace);
        System.out.println("Parsed Attributes: " + parsedAttributes2);
        // Expected Output: Parsed Attributes: {location=NewYorkCity, department=Engineering}

        String emptyAttributesString = null;
        Map<String, String> parsedAttributes3 = Util.parseAttributes(emptyAttributesString);
        System.out.println("Parsed Attributes: " + parsedAttributes3);
        // Expected Output: Parsed Attributes: {}

        String attributesStringWithEmptyValue = "department^=^~location^=^New York City";
        Map<String, String> parsedAttributes4 = Util.parseAttributes(attributesStringWithEmptyValue);
        System.out.println("Parsed Attributes: " + parsedAttributes4);
        // Expected Output: Parsed Attributes: {location=New York City, department=}

    }
}
