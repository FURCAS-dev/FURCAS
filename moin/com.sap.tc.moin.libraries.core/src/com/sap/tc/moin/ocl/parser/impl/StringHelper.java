package com.sap.tc.moin.ocl.parser.impl;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;

import com.sap.tc.moin.ocl.utils.OclConstants;

/**
 * Provides some methods for string handling. It offeres some C-like methods for
 * convenient String output -- a bit like printf().
 * 
 * @author Thomas Hettel (D039141)
 */
public class StringHelper {

    private StringHelper( ) {

        // static only
    }

    /**
     * this method return a different string representation of objects. it
     * doesn't use toString(). If o is a Classifier its name is returned. If o
     * is a List a comma seperated list of recursive printObject() calls is
     * returned.
     * 
     * @param o the Object to print
     * @return a more meaningfull string representation is returned
     */
    private static String printObject( List<Classifier> l ) {

        if ( l == null ) {
            return "null"; //$NON-NLS-1$
        }

        StringBuilder s = new StringBuilder( );

        int len = l.size( );
        if ( len > 0 ) {
            s.append( printObject( l.get( 0 ) ) );
            for ( int i = 1; i < len; i++ ) {
                s.append( ", " ); //$NON-NLS-1$
                s.append( printObject( l.get( i ) ) );
            }
        }
        return s.toString( );

    }

    private static String printObject( Classifier o ) {

        if ( o == null ) {
            return "null"; //$NON-NLS-1$
        }
        return toString( o );

    }

    /**
     * Takes a List of names (i.e. the fully qualified name) and returns a
     * String where each element in <tt>pathName</tt> is separated by a double
     * colon '::'. E.g. 'myPackage::anotherPackage::Class'
     * 
     * @param pathName the path name
     * @return the path name represented by the List <tt>pathName</tt>
     */
    public static String toPathName( List<String> pathName ) {

        StringBuilder buf = new StringBuilder( );
        int len = pathName.size( );
        if ( len > 0 ) {
            buf.append( pathName.get( 0 ) );
            for ( int i = 1; i < len; i++ ) {
                buf.append( OclConstants.PATHSEP );
                buf.append( pathName.get( i ) );
            }
        }
        return buf.toString( );
    }

    /**
     * Creates a string representation of Classifier c
     * 
     * @param c the Classifier
     * @return a string representation of Classifier c
     */
    public static String toString( Classifier c ) {

        return c.getName( );
    }

    /**
     * Creates a string representation of a list. Therefore it creates the
     * string representation of each element in the list seperated by comas
     * 
     * @param l the list
     * @return a string representation of a list
     */
    public static String toString( List<Classifier> l ) {

        return printObject( l );
    }

    /**
     * turns an array representing a pathname into a string "::" seperating the
     * different parts
     * 
     * @param pathName the path name
     * @return string "::" seperating the different parts of the pathname
     */
    public static String toPathName( String[] pathName ) {

        if ( pathName == null ) {
            return OclConstants.EMPTY;
        }
        StringBuffer s = new StringBuffer( );
        if ( pathName.length > 0 ) {
            s.append( pathName[0] );
            for ( int i = 1; i < pathName.length; i++ ) {
                s.append( OclConstants.PATHSEP );
                s.append( pathName[i] );
            }
        }
        return s.toString( );
    }
}