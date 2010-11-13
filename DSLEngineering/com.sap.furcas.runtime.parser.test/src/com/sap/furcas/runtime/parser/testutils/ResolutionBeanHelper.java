/**
 * 
 */
package com.sap.furcas.runtime.parser.testutils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;


/**
 * Helper class to deal with test creation for all these qualified Names.
 */
public class ResolutionBeanHelper {

    public static ResolvedNameAndReferenceBean<EObject> refE(String... entries) {
        
        ArrayList<String> list = new ArrayList<String>();
        if (entries != null) {
            for (String entry : entries) {
                list.add(entry);    
            }
        }
        ResolvedNameAndReferenceBean<EObject> stub = new ResolvedNameAndReferenceBean<EObject>(list, null);
        return stub;
    }

    public static ResolvedNameAndReferenceBean<EObject> refM(String... entries) {


        ArrayList<String> list = new ArrayList<String>();
        if (entries != null) {
            for (String entry : entries) {
                list.add(entry);    
            }
        }
        ResolvedNameAndReferenceBean<EObject> stub = new ResolvedNameAndReferenceBean<EObject>(list, null);
        return stub;
    }
    
    public static List<ResolvedNameAndReferenceBean<EObject>> multiSimpleList(String... entries) {
        List<ResolvedNameAndReferenceBean<EObject>> list = new ArrayList<ResolvedNameAndReferenceBean<EObject>>();
        if (entries != null) {
            for (String entry : entries) {
                ArrayList<String> innerlist = new ArrayList<String>();
                innerlist.add(entry);   
                list.add(new ResolvedNameAndReferenceBean<EObject>(innerlist, null));
            }
        }
        return list;
    }


}
