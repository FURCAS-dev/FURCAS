/**
 * 
 */
package com.sap.furcas.parsergenerator.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.parsergenerator.util.VarStringBuffer;

/**
 *
 */
public class TestVarStringBuffer {

    @Test
    public void testConcatUtil() throws Exception {
        VarStringBuffer buf = new VarStringBuffer();
        assertEquals(0, buf.length());
        buf.append('c');
        assertEquals("c", buf.toString());
        buf.append("S");
        assertEquals("cS", buf.toString());
        buf.append("1", 2, "3");
        assertEquals("cS123", buf.toString());
        
        StringBuilder builder = new StringBuilder("Test");
        VarStringBuffer buf2 = new VarStringBuffer(builder );
        assertEquals("Test", buf2.toString());
        
        buf.append(buf2);
        assertEquals("cS123Test", buf.toString());
    }
    
    @org.junit.Test
    public void testConcatUtilNull() throws Exception {
        VarStringBuffer buf = new VarStringBuffer();
        assertEquals(0, buf.length());
        buf.append((Object)null);
        assertEquals("", buf.toString());
        buf.append((Object[])null);
        assertEquals("", buf.toString());
    }
    
    
}
