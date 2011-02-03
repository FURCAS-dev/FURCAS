/**
 * 
 */
package com.sap.furcas.parsergenerator.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sap.furcas.parsergenerator.util.StringConcatUtil;

/**
 *
 */
public class TestStringConcat {

    @Test
    public void testConcatUtil() throws Exception {
        assertEquals("Test1234hello", StringConcatUtil.concat("Test", 1234, "hello"));
        assertEquals("", StringConcatUtil.concat());
        assertEquals("Test", StringConcatUtil.concat("Test"));
        assertEquals("Test",StringConcatUtil.concat( new Object() {@Override
        public String toString() {
            return "Test";}}));
        
    }
    
    @org.junit.Test
    public void testConcatUtil2() throws Exception {
        assertEquals("Test1234hello", StringConcatUtil.concatBuf("Test", 1234, "hello").toString());
        assertEquals("", StringConcatUtil.concatBuf().toString());
        assertEquals("Test", StringConcatUtil.concatBuf("Test").toString());
        assertEquals("Test", (StringConcatUtil.concatBuf( new Object() {@Override
        public String toString() {
            return "Test";}})).toString());
        assertTrue(StringConcatUtil.concatBuf("Test") instanceof StringBuilder);
    }
    
    
}
