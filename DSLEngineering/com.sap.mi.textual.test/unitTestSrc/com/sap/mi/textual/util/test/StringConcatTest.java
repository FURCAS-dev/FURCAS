/**
 * 
 */
package com.sap.mi.textual.util.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.sap.mi.textual.util.StringConcatUtil;

/**
 *
 */
public class StringConcatTest {

    @org.junit.Test
    public void testConcatUtil() throws Exception {
        assertEquals("Test1234hello", StringConcatUtil.concat("Test", 1234, "hello"));
        assertEquals("", StringConcatUtil.concat());
        assertEquals("Test", StringConcatUtil.concat("Test"));
        assertEquals("Test",StringConcatUtil.concat( new Object() {public String toString() {
            return "Test";}}));
        
    }
    
    @org.junit.Test
    public void testConcatUtil2() throws Exception {
        assertEquals("Test1234hello", StringConcatUtil.concatBuf("Test", 1234, "hello").toString());
        assertEquals("", StringConcatUtil.concatBuf().toString());
        assertEquals("Test", StringConcatUtil.concatBuf("Test").toString());
        assertEquals("Test", (StringConcatUtil.concatBuf( new Object() {public String toString() {
            return "Test";}})).toString());
        assertTrue(StringConcatUtil.concatBuf("Test") instanceof StringBuilder);
    }
    
    
}
