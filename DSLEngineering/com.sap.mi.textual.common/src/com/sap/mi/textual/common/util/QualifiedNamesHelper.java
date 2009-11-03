/**
 * 
 */
package com.sap.mi.textual.common.util;

import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class QualifiedNamesHelper {

    public static String getQualifiedString(List<String> nameList) {
        StringBuilder qualifiedname = new StringBuilder();
        
        for (Iterator<String> iterator = nameList.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            qualifiedname.append(string);
            if (iterator.hasNext()) {
                qualifiedname.append("::");
            }
        }
        return qualifiedname.toString();        
    }
    
}
