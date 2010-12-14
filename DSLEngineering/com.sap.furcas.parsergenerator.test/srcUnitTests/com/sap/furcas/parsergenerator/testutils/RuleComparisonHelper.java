/**
 * 
 */
package com.sap.furcas.parsergenerator.testutils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * helps with comparing outputs of rule writing classes, by comparing tokens without white spaces.
 */
public class RuleComparisonHelper {

    public static List<String> tokens(String string) {
        return tokens(string, " \n\r\t");
    }
    
    public static List<String> tokens(String string, String delim) {
        StringTokenizer tokens2 = new StringTokenizer( string, delim);
        List<String> list = new ArrayList<String>();
        while (tokens2.hasMoreElements()) {
            String token = (String) tokens2.nextElement();
            if ( ! "".equals(token.trim())) {
                list.add(token);
            }
        }
        return list;
    }
    
    public static void assertEqualTokens(String expected, String result) {
        List<String> tokens = tokens( expected); 
        List<String> tokens2 = tokens( result); 
        assertEquals(expected + "\n!=\n" + result + '\n', tokens, tokens2);
    }
    
    
}
