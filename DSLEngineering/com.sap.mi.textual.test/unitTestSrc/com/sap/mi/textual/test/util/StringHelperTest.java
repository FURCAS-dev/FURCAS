/**
 * 
 */
package com.sap.mi.textual.test.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sap.furcas.parsergenerator.testutils.StringListHelper;

/**
 *
 */
public class StringHelperTest {

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.testutils.StringListHelper#list(java.lang.String[])}.
     */
    @Test
    public void testList() {
        List<String> list = StringListHelper.list((String[])null);
        assertEquals(0, list.size());
        
        list = StringListHelper.list();
        assertEquals(0, list.size());
        
        list = StringListHelper.list("");
        assertEquals(1, list.size());
        assertTrue(list.contains(""));
        
        list = StringListHelper.list("Test");
        assertEquals(1, list.size());
        assertTrue(list.contains("Test"));
        
        list = StringListHelper.list("Test", "Test2", "3Test");
        assertEquals(3, list.size());
        assertTrue(list.get(0).equals("Test"));
        assertTrue(list.get(1).equals("Test2"));
        assertTrue(list.get(2).equals("3Test"));
    }

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.testutils.StringListHelper#multiSimpleList(java.lang.String[])}.
     */
    @Test
    public void testMultiSimpleList() {
        List<List<String>> list = StringListHelper.multiSimpleList((String[])null);
        assertEquals(0, list.size());
        
        list = StringListHelper.multiSimpleList();
        assertEquals(0, list.size());
        
        list = StringListHelper.multiSimpleList("");
        List<String> expect = new ArrayList<String>();
        expect.add("");
        assertEquals(1, list.size());
        assertTrue(list.contains(expect));
        
        list = StringListHelper.multiSimpleList("Test");
        expect = new ArrayList<String>();
        expect.add("Test");
        assertEquals(1, list.size());
        assertTrue(list.contains(expect));
        
        list = StringListHelper.multiSimpleList("Test", "Test2", "3Test");
        
        assertEquals(3, list.size());
        
        expect = new ArrayList<String>();
        expect.add("Test");
        assertTrue(list.get(0).equals(expect));
        
        expect = new ArrayList<String>();
        expect.add("Test2");
        assertTrue(list.get(1).equals(expect));
        
        expect = new ArrayList<String>();
        expect.add("3Test");
        assertTrue(list.get(2).equals(expect));

    }

}
