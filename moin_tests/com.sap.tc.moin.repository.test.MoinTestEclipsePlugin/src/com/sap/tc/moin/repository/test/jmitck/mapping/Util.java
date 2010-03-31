/*
 * Util.java Copyright 2002 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 */

package com.sap.tc.moin.repository.test.jmitck.mapping;

import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;

/**
 * Some static methods to support tests.
 */
@SuppressWarnings( "nls" )
public class Util {

    public static String extractTypeName( String fullMemberName ) {

        String answer = null;
        int pos = fullMemberName.lastIndexOf( "." );
        if ( pos != -1 ) {
            answer = fullMemberName.substring( 0, pos );
        }
        return answer;
    }

    public static String extractMemberName( String fullMemberName ) {

        String answer = null;
        int pos = fullMemberName.lastIndexOf( "." );
        if ( pos != -1 ) {
            answer = fullMemberName.substring( pos + 1 );
        } else {
            answer = fullMemberName;
        }
        return answer;
    }

    public static String getTestId( TestDescription td ) {

        return td.getId( );
    }
}
