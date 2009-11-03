package com.sap.tc.moin.repository.core.xmi.util;

import com.sap.tc.moin.repository.core.xmi.XmiConstants;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.messages.core.XMI;

/**
 * @author d027299
 */
public class XmiHrefUtil {

    public static void checkHref( String href ) {

        if ( href == null || href.equals( "" ) ) { //$NON-NLS-1$
            throw new MoinLocalizedBaseRuntimeException( XMI.INVALIDHREF, href );
        }
        // Check for the existence of the delimiter character ('|' or '#').
        int delimPos = getDelimiterPosition( href );
        if ( delimPos < 0 ) {
            throw new MoinLocalizedBaseRuntimeException( XMI.INVALIDHREFMISSINGDELIM, href );
        }
    }

    /**
     * Takes the String value of a 'href' attribute and extracts and returns the
     * XMI-ID (if <code>partitionMode == false</code>) or the MOF-ID (if
     * <code>partitionMode == true</code>).
     */
    public static String getIdPart( String href, boolean partitionMode ) {

        if ( partitionMode ) {
            return href.substring( href.indexOf( ':' ) + 1 );
        } else {
            int delimPos = getDelimiterPosition( href );
            if ( delimPos == -1 ) {
                return ""; //$NON-NLS-1$
            }
            return href.substring( delimPos + 1 ).trim( );
        }
    }

    public static String getLocationPart( String href ) {

        int delimPos = getDelimiterPosition( href );
        if ( delimPos != -1 ) {
            return href.substring( 0, delimPos ).trim( );
        }
        return href;
    }

    public static int getDelimiterPosition( String href ) {

        int pos = href.indexOf( XmiConstants.XMI_HREF_DELIMITER_12 );
        if ( pos == -1 ) {
            // compatibility: some XMI 1.0 files contain '#' as delimiter
            pos = href.indexOf( XmiConstants.XMI_HREF_DELIMITER_20 );
        }
        return pos;
    }
}