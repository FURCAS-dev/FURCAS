/**
 * 
 */
package com.sap.mi.textual.test.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;


/**
 * Helper class to deal with test creation for all these qualified Names.
 */
public class ResolutionBeanHelper {

    public static ResolvedNameAndReferenceBean<Object> refE(String... entries) {
        
        
        ArrayList<String> list = new ArrayList<String>();
        if (entries != null) {
            for (int i = 0; i < entries.length; i++) {
                String entry = entries[i];
                list.add(entry);    
            }
        }
        ResolvedNameAndReferenceBean<Object> stub = new ResolvedNameAndReferenceBean<Object>(list, null);
        return stub;
    }

    public static ResolvedNameAndReferenceBean<EObject> refM(String... entries) {


        ArrayList<String> list = new ArrayList<String>();
        if (entries != null) {
            for (int i = 0; i < entries.length; i++) {
                String entry = entries[i];
                list.add(entry);    
            }
        }
        ResolvedNameAndReferenceBean<EObject> stub = new ResolvedNameAndReferenceBean<EObject>(list, null);
        return stub;
    }
    
    public static List<ResolvedNameAndReferenceBean<Object>> multiSimpleList(String... entries) {
        List<ResolvedNameAndReferenceBean<Object>> list = new ArrayList<ResolvedNameAndReferenceBean<Object>>();
        if (entries != null) {
            for (int i = 0; i < entries.length; i++) {
                ArrayList<String> innerlist = new ArrayList<String>();
                String entry = entries[i];
                innerlist.add(entry);   
                list.add(new ResolvedNameAndReferenceBean<Object>(innerlist, null));
            }
        }
        return list;
    }


}
