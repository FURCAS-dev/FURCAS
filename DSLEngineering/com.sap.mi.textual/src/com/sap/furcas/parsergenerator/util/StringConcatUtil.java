/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.util;

/**
 *
 */
public class StringConcatUtil {

    public static String concat(Object... strings ) {
        StringBuilder buf = new StringBuilder(strings.length * 10);
        for (Object string : strings) {
            buf.append(string);
        }
        return buf.toString();
    }
    
    public static StringBuilder concatBuf(Object... strings ) {
        StringBuilder buf = new StringBuilder(strings.length * 10);
        for (Object string : strings) {
            buf.append(string);
        }
        return buf;
    }
    
}
