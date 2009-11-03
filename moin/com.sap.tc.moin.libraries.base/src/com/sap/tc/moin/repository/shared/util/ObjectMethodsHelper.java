package com.sap.tc.moin.repository.shared.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * This class helps to implement methods defined by {@link java.lang.Object}
 * like {@link java.lang.Object#hashCode() hashCode()} or
 * {@link java.lang.Object#equals(java.lang.Object) equals(java.lang.Object)}
 */
public final class ObjectMethodsHelper {

    /**
     * @param arg0 the object
     * @return a hash
     */
    public static int hashCode( Object arg0 ) {

        int result = 17;
        result = 37 * result + ( arg0 != null ? arg0.hashCode( ) : 0 );
        return result;
    }

    /**
     * @param argLeft0 first object
     * @param argRight0 second object
     * @return true if the objects are equal
     */
    public static boolean equals( Object argLeft0, Object argRight0 ) {

        boolean result = false;
        result = ( argLeft0 != null && argLeft0.equals( argRight0 ) || argLeft0 == null && argRight0 == null );
        return result;
    }

    public static String toString( String start, String end, Map atoms, int maxAtomLength, int maxTotalLength, String separator, String assignmentSign ) {

        return toStringInternal( start, end, atoms, maxAtomLength, maxTotalLength, separator, assignmentSign );
    }

    /***************************************************************************
     * private methods
     **************************************************************************/

    private static String toStringInternal( String start, String end, Object atoms, int maxAtomLength, int maxTotalLength, String separator, String assignmentSign ) {

        StringBuilder result = new StringBuilder( );
        int expectedLength = ( start != null ? start.length( ) : 0 ) + ( end != null ? end.length( ) : 0 );
        result.append( start != null ? start : "" ); //$NON-NLS-1$
        if ( atoms != null ) {
            StringBuilder atomBuffer = new StringBuilder( );
            Iterator i = null;
            if ( atoms instanceof Collection ) {
                i = ( (Collection) atoms ).iterator( );
            } else if ( atoms instanceof Map ) {
                i = ( (Map) atoms ).keySet( ).iterator( );
            }
            while ( i != null && i.hasNext( ) ) {
                Object next = i.next( );
                String atom;
                if ( atoms instanceof Collection ) {
                    atom = condenseAtom( next.toString( ), maxAtomLength );
                } else {
                    Object atomValue = ( (Map) atoms ).get( next ) == null ? "null" : ( (Map) atoms ).get( next ); //$NON-NLS-1$
                    atom = condenseAtom( next.toString( ), maxAtomLength ) + ( assignmentSign != null ? assignmentSign : "" ) + condenseAtom( atomValue.toString( ), maxAtomLength ); //$NON-NLS-1$
                }
                expectedLength += atom.length( );
                if ( maxTotalLength > -1 && expectedLength > maxTotalLength ) {
                    atomBuffer.append( "..." ); //$NON-NLS-1$
                    break;
                } else {
                    atomBuffer.append( atom );
                }
                if ( i.hasNext( ) ) {
                    expectedLength += ( separator != null ? separator : "" ).length( ); //$NON-NLS-1$
                    if ( maxTotalLength > -1 && expectedLength > maxTotalLength ) {
                        atomBuffer.append( "..." ); //$NON-NLS-1$
                        break;
                    } else {
                        atomBuffer.append( separator != null ? separator : "" ); //$NON-NLS-1$
                    }
                }
            }
            result.append( atomBuffer );
        }
        result.append( end != null ? end : "" ); //$NON-NLS-1$
        return result.toString( );
    }

    private static String condenseAtom( String atom, int maxAtomLength ) {

        String result = atom;
        if ( maxAtomLength > -1 && atom.length( ) > maxAtomLength ) {
            result = result.substring( 0, maxAtomLength ).concat( "..." ); //$NON-NLS-1$
        }
        return result;
    }
}