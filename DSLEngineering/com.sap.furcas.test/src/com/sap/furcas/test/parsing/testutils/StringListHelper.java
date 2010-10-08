/**
 * 
 */
package com.sap.furcas.test.parsing.testutils;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

/**
 * Helper class to deal with test creation for all these qualified Names.
 */
public class StringListHelper {

    public static EList<String> list(String... entries) {
        EList<String> list = new BasicEList<String>();
        if (entries != null) {
            for (int i = 0; i < entries.length; i++) {
                String entry = entries[i];
                list.add(entry);    
            }
        }
        return list;
    }

    public static EList<List<String>> multiSimpleList(String... entries) {
        EList<List<String>> list = new BasicEList<List<String>>();
        if (entries != null) {
            for (int i = 0; i < entries.length; i++) {
                EList<String> innerlist = new BasicEList<String>();
                String entry = entries[i];
                innerlist.add(entry);   
                list.add(innerlist);
            }
        }
        return list;
    }
 

}
