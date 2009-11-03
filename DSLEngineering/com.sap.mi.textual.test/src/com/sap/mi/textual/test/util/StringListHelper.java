/**
 * 
 */
package com.sap.mi.textual.test.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to deal with test creation for all these qualified Names.
 */
public class StringListHelper {

    public static List<String> list(String... entries) {
        ArrayList<String> list = new ArrayList<String>();
        if (entries != null) {
            for (int i = 0; i < entries.length; i++) {
                String entry = entries[i];
                list.add(entry);    
            }
        }
        return list;
    }

    public static List<List<String>> multiSimpleList(String... entries) {
        ArrayList<List<String>> list = new ArrayList<List<String>>();
        if (entries != null) {
            for (int i = 0; i < entries.length; i++) {
                ArrayList<String> innerlist = new ArrayList<String>();
                String entry = entries[i];
                innerlist.add(entry);   
                list.add(innerlist);
            }
        }
        return list;
    }
 

}
