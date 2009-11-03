/**
 * 
 */
package com.sap.mi.textual.util.test;

import static org.junit.Assert.assertEquals;

import com.sap.mi.textual.util.VarStringBuffer;

/**
 *
 */
public class VarStringBufferTest {

    @org.junit.Test
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
