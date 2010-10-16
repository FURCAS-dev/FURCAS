/**
 * 
 */
package com.sap.furcas.modeladaptation.emf;

import java.util.Iterator;
import java.util.List;

/**
 * util class for formatting Exception messages
 */
public class MessageUtil {
    
    public static String asModelName(List<String> names) {
        if (names == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Iterator<String> iterator = names.iterator(); iterator.hasNext();) {
            String name = iterator.next();
            builder.append(name);
            if (iterator.hasNext()) {
               builder.append("::");
            }
        }
        return builder.toString();
        
    }
}
