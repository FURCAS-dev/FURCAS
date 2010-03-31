package com.sap.tc.moin.repository.test.jmitck;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.FILE_SEPARATOR;

/**
 * Utilitiy class for JMI TCK
 * 
 * @author SAP AG, Christian Muenkel (D025744)
 */
public class JmiTckUtils {

    /**
     * Returns source directory for imported XMI file.
     * 
     * @param rootDir JMI TCK root directory
     * @param xmiImportPath XMI import path
     * @return source directory
     */
    public static String getXmiSourceDirectory( String rootDir, String xmiImportPath ) {

        String fileSep = System.getProperty( FILE_SEPARATOR );
        int endIndex = xmiImportPath.lastIndexOf( "/" ); //$NON-NLS-1$
        String subFolder = xmiImportPath.substring( 0, endIndex );
        return rootDir + fileSep + subFolder + fileSep;
    }

    /**
     * Returns file name for imported XMI file.
     * 
     * @param xmiImportPath XMI import path
     * @return XMI file name
     */
    public static String getXmiFileName( String xmiImportPath ) {

        int endIndex = xmiImportPath.lastIndexOf( "/" ); //$NON-NLS-1$
        return xmiImportPath.substring( endIndex + 1 );
    }

}
