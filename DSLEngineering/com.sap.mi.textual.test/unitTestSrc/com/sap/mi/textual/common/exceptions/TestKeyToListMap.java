/**
 * 
 */
package com.sap.mi.textual.common.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import com.sap.furcas.runtime.common.util.KeyToListMap;

/**
 *
 */
public class TestKeyToListMap {    
    
    @Test
    public void testKeyToListMap() throws Exception {
        Integer val1 = new Integer(1);
        Integer val2 = new Integer(2);
        Integer val3 = new Integer(3);
        
        Integer val4 = new Integer(4);
        Integer val5 = new Integer(5);
        
        Integer val6 = new Integer(6);
        
        KeyToListMap<String, Integer> string2IntList = new KeyToListMap<String, Integer>();
        string2IntList.put("key1", val1);
        string2IntList.put("key1", val2);
        string2IntList.put("key1", val3);
        
        string2IntList.put("key2", val4);
        string2IntList.put("key2", val5);
        
        string2IntList.put("key3", val6);
        
        Iterator<Entry<String, List<Integer>>> it = string2IntList.entryIterator();
        
        
        boolean set1found = false;
        boolean set2found = false;
        boolean set3found = false;

        for (int i = 0; i < 3; i++) {


            Entry<String, List<Integer>> result = it.next();
            assertNotNull(result);

            if (result.getKey().equals("key1")) {
                set1found = true;
                List<Integer> list = result.getValue();
                assertNotNull(list);
                assertEquals(3, list.size());
                assertTrue(list.contains(val1));
                assertTrue(list.contains(val2));
                assertTrue(list.contains(val3));
            } else if (result.getKey().equals("key2")) {
                set2found = true;
                List<Integer> list = result.getValue();
                assertNotNull(list);
                assertEquals(2, list.size());
                assertTrue(list.contains(val4));
                assertTrue(list.contains(val5));
            } else if (result.getKey().equals("key3")) {
                set3found = true;
                List<Integer> list = result.getValue();
                assertNotNull(list);
                assertEquals(1, list.size());
                assertTrue(list.contains(val6));
            } else {
                fail("Map contains element that it should not: " + result);
            }
        }
    }
}
