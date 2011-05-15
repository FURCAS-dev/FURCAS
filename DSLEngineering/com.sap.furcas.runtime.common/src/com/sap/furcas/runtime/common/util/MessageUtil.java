/**
 * 
 */
package com.sap.furcas.runtime.common.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;

/**
 * Util class for formatting Exception messages
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

    public static String asMetaModelNames(Set<URI> metaModelURIs) {
        StringBuilder builder = new StringBuilder();
        for (Iterator<URI> iterator = metaModelURIs.iterator(); iterator.hasNext();) {
            URI uri = iterator.next();
            builder.append(uri.toString());
            if (iterator.hasNext()) {
               builder.append(", ");
            }
        }
        return builder.toString();
    }
}
