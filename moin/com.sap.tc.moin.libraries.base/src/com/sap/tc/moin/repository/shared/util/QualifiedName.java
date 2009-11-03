/*
 * Created on 11.08.2005
 */
package com.sap.tc.moin.repository.shared.util;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.List;


/**
 * This object represents the qualified name of a ModelElement and is immutable
 * or unmodifiable. This class tries to consume as little memory as possible
 * because the qualified name will be contained in each single ModelElement we
 * store in MOIN. By extending {@link AbstractList} which extends
 * {@link AbstractCollection} we inherit two variables, <code>int size</code>
 * and <code>Iterator iterator</code>. This class defines also the
 * <code>String[] names</code>. These are the only variables which are used.
 * There might be a way to get this even cheaper by implementing List directly
 * and getting rid off the size variable which can be calc. by the expression
 * <code>names.length</code>.
 * 
 * @author d024227
 */
@SuppressWarnings( "unchecked" )
public final class QualifiedName extends AbstractList {

    /**
     * Separator in MOF qualified name
     */
    private static final char QUALIFIED_NAME_SEPARATOR = '.';

    private String[] names;

    /**
     * This private no-arg constructor avoids that a default public constructor
     * is generated.
     */
    private QualifiedName( ) {

        // intentionally does nothing
    }

    /**
     * Creates a QualifiedName with the String[] provided
     * 
     * @param names the content of the QualifiedName
     */
    private QualifiedName( String[] names ) {

        this.names = names;
    }

    /**
     * Creates a QualifiedName with the content of the supported List. If the
     * List is instanceof {@link QualifiedName}, the supported qualifiedName is
     * simply returned. The List may only contain String objects.
     * 
     * @param qualifiedName the List the content of which is to be used to
     * create a QualifiedName
     * @return the created QualifiedName or the supported qualifiedName in case
     * it is of instance QualifiedName
     */
    @SuppressWarnings( "unchecked" )
    public static QualifiedName createQualifiedName( List qualifiedName ) {

        QualifiedName result;
        if ( qualifiedName instanceof QualifiedName ) {
            result = (QualifiedName) qualifiedName;
        } else {
            result = new QualifiedName( (String[]) qualifiedName.toArray( new String[] {} ) );
        }
        return result;
    }

    /**
     * Creates a QualifiedName with the String[] provided
     * 
     * @param qualifiedName the content of the QualifiedName
     * @return the created QualifiedName
     */
    public static QualifiedName createQualifiedName( String[] qualifiedName ) {

        QualifiedName result;
        String[] temp = new String[qualifiedName.length];
        System.arraycopy( qualifiedName, 0, temp, 0, qualifiedName.length );
        result = new QualifiedName( temp );
        return result;
    }

    /**
     * Creates a QualifiedName by splitting the provided String in single name
     * components. Each occurance of the "." is used as a split point. The "."
     * character itself is filtered out and does not make it into the name
     * components
     * 
     * @param dotSeparatedQualifiedName the content of the QualifiedName
     * @return the created QualifiedName
     */
    public static QualifiedName createQualifiedName( String dotSeparatedQualifiedName ) {

        return new QualifiedName( StringUtils.split( dotSeparatedQualifiedName, '.' ) );
    }

    /**
     * Creates a dot-separated String from the List entries. On each entry of
     * the passed List the toString method is invoked to get a String.
     * 
     * @param qualifiedName the qualified name in {@link List} format
     * @return the dot-separated String which represents the qualifiedName
     */
    public static final String toDotSeparatedString( List<String> qualifiedName ) {

        int size = qualifiedName.size( );
        int len = 0;
        for ( int i = 0; i < size; i++ ) {
            len += qualifiedName.get( i ).length( );
            if ( i > 0 ) {
                len++; // space for the dot separator
            }
        }
        StringBuilder result = new StringBuilder( len );
        for ( int i = 0; i < size; i++ ) {
            if ( i > 0 ) {
                result.append( QUALIFIED_NAME_SEPARATOR );
            }
            result.append( qualifiedName.get( i ) );
        }
        return result.toString( );
    }

    @Override
    public Object get( int index ) {

        return names[index];
    }

    @Override
    public int size( ) {

        return names.length;
    }

    /**
     * Creates a dot-separated String from this {@link QualifiedName}.
     * 
     * @return the dot-separated String which represents the qualifiedName
     */
    public String toDotSeparatedString( ) {

        int len = 0;
        for ( int i = 0; i < names.length; i++ ) {
            len += names[i].length( );
            if ( i > 0 ) {
                len++; // space for the dot separator
            }
        }
        StringBuilder result = new StringBuilder( len );
        for ( int i = 0; i < names.length; i++ ) {
            if ( i > 0 ) {
                result.append( QUALIFIED_NAME_SEPARATOR );
            }
            result.append( names[i] );
        }
        return result.toString( );
    }
}