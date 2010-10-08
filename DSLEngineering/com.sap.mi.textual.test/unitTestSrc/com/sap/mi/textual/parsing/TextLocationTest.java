/**
 * 
 */
package com.sap.mi.textual.parsing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.impl.TextLocation;

/**
 *
 */
public class TextLocationTest {

    /**
     * Test method for {@link com.sap.furcas.runtime.parser.impl.TextLocation#TextLocation(int, int, int, int)}.
     */
    @Test
    public void testTextLocationIntIntIntInt() {
        TextLocation loc = new TextLocation(7,6, 1, 2, 3, 4);
        assertEquals(1, loc.getStartLine());
        assertEquals(2, loc.getStartPosition());
        assertEquals(3, loc.getEndLine());
        assertEquals(4, loc.getEndPosition());
        assertEquals(7, loc.getIndex());
        assertEquals(6, loc.getStopIndex());
        
        //  test against constants
        loc = new TextLocation(8,7,2, 1, 4, 3);
        assertEquals(2, loc.getStartLine());
        assertEquals(1, loc.getStartPosition());
        assertEquals(4, loc.getEndLine());
        assertEquals(3, loc.getEndPosition());
        
    //  test against singleDigit
        loc = new TextLocation(107, 108, 112, 121, 134, 143);
        assertEquals(112, loc.getStartLine());
        assertEquals(121, loc.getStartPosition());
        assertEquals(134, loc.getEndLine());
        assertEquals(143, loc.getEndPosition());
    }


    /**
     * Test method for {@link com.sap.furcas.runtime.parser.impl.TextLocation#TextLocation(java.lang.String)}.
     */
    @Test
    public void testTextLocationStringNull() {


            TextLocation loc = new TextLocation((ANTLR3LocationToken) null);
            assertEquals(0, loc.getStartLine());
            assertEquals(0, loc.getStartPosition());
            assertEquals(0, loc.getEndLine());
            assertEquals(0, loc.getEndPosition());
    }
    
  
    
    /**
     * Test method for {@link com.sap.furcas.runtime.parser.impl.TextLocation#TextLocationToString()}.
     */
    @Test
    public void testTextLocationToString() {
        TextLocation loc = new TextLocation(7, 6, 1, 2, 3, 4);
        assertEquals("1:2-3:4", loc.toString());
        loc = new TextLocation(9, 7, 2, 1, 4, 3);
        assertEquals("2:1-4:3", loc.toString());
        loc = new TextLocation(102, 104, 112, 121, 134, 143);
        assertEquals("112:121-134:143", loc.toString());
    }
    
}
