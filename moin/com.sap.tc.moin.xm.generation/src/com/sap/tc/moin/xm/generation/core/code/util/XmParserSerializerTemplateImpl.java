package com.sap.tc.moin.xm.generation.core.code.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.XmGenerationMessages;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmNamespace;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmRootPackage;


public abstract class XmParserSerializerTemplateImpl implements XmParserSerializerTemplate {

    private final String javaClassName;

    private final String javaPackageName;

    private final String schemaName;

    private final List<PrefixAndNamespace> prefixAndNamespaceList = new ArrayList<PrefixAndNamespace>( );

    private final Map<String, String> namespace2prefix = new LinkedHashMap<String, String>( );

    /**
     * Constructor.
     * 
     * @param aJavaClassName
     * @param aJavaPackageName
     * @param aSchemaName
     * @throws NullPointerException f <tt>schemaName</tt> is <code>null</code>
     */
    public XmParserSerializerTemplateImpl( final String aJavaClassName, final String aJavaPackageName, final String aSchemaName ) {

        if ( aSchemaName == null ) {
            throw new MoinNullPointerException( "aSchemaName" ); //$NON-NLS-1$
        }
        this.javaClassName = aJavaClassName;
        this.javaPackageName = aJavaPackageName;
        this.schemaName = aSchemaName;

    }

    /**
     * Adds an entry to the prefix to the namespace map.
     * 
     * @param prefix
     * @param namespace
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public void addPrefix( final String prefix, final String namespace ) {

        if ( prefix == null ) {
            throw new MoinNullPointerException( "prefix" ); //$NON-NLS-1$
        }
        if ( namespace == null ) {
            throw new MoinNullPointerException( "namespace" ); //$NON-NLS-1$
        }
        this.prefixAndNamespaceList.add( new PrefixAndNamespaceImpl( prefix, namespace ) );
        this.namespace2prefix.put( namespace, prefix );
    }

    /**
     * Returns the prefix for a namespace. If the namespace is null or the empty
     * string, then the empty string is returned.
     * 
     * @param namespace
     * @return prefix, cannot be <code>null</code>
     * @throws IllegalStateException if a prefix for the namespace is not found
     */
    public String getPrefix( final String namespace ) {

        if ( namespace == null || namespace.length( ) == 0 ) {
            return ""; //$NON-NLS-1$
        } else {
            final String result = this.namespace2prefix.get( namespace );
            if ( result == null ) {
                throw new MoinIllegalStateException( XmGenerationMessages.NOPREFIXFORNAMESPACE, namespace );
            }
            return result;
        }
    }

    public List<String> getImplements( ) {

        return Collections.emptyList( );
    }


    /**
     * Returns the java class name.
     * 
     * @return java class name, or <code>null</code> if a java class name was
     * not provided in the constructor
     */
    public String getJavaName( ) {

        return this.javaClassName;
    }


    /**
     * Returns the java package name.
     * 
     * @return java package name, or <code>null</code> if a java package name
     * was not provided in the constructor
     */
    public String getPackageName( ) {

        return this.javaPackageName;
    }



    public String getPreamble( ) {

        return XmGenerationConstants.PREAMBLE;
    }


    public List<PrefixAndNamespace> getPrefixes( ) {

        return this.prefixAndNamespaceList;
    }


    public String getSchemaName( ) {

        return this.schemaName;
    }


    /**
     * Calculates the dot separated qualified java class name from a MOIN
     * namespace and a MOF name.
     * 
     * @param moinNamespace MOIN namespace
     * @param mofName MOF name
     * @return dot separated qualified name
     */
    public static String getQualifiedJmiClassName( final XmNamespace moinNamespace, final String mofName ) {

        if ( moinNamespace == null ) {
            throw new NullPointerException( "moinNamespace is null" ); //$NON-NLS-1$
        }
        if ( mofName == null ) {
            throw new NullPointerException( "mofName is null" ); //$NON-NLS-1$
        }
        final StringBuilder sb = new StringBuilder( );
        final List<String> packages = new ArrayList<String>( 3 );
        for ( XmNamespace namespace = moinNamespace; namespace != null; ) {

            packages.add( namespace.getMofName( ) );
            if ( namespace instanceof XmRootPackage ) {
                final String javaPrefix = ( (XmRootPackage) namespace ).getJavaPrefix( );
                if ( javaPrefix.length( ) > 0 ) {
                    packages.add( javaPrefix );
                }
            }
            namespace = namespace.getNamespace( );
        }
        for ( int i = packages.size( ) - 1; i > -1; i-- ) {
            sb.append( correctName( packages.get( i ) ).toLowerCase( Locale.ENGLISH ) );
            sb.append( '.' );
        }
        sb.append( correctName( mofName ) );
        return sb.toString( );
    }

    private static final String NON_SIG_CHARS = " _-\n\r\t"; //$NON-NLS-1$

    /* Calculates the java class name. TODO Copied from JmiHelperImpl. */
    private static String correctName( final String name ) {

        if ( name == null ) {
            return null;
        }
        // JMI specification 4.7.1 and 4.7.2 (page 53ff)
        // remove non-sig ::= {'_' | '-' | white-space }
        final StringBuilder sb = new StringBuilder( );
        final StringTokenizer st = new StringTokenizer( name, NON_SIG_CHARS );
        while ( st.hasMoreTokens( ) ) {
            StringBuilder s = correctWord( st.nextToken( ) );
            if ( s.charAt( 0 ) == '_' ) {
                s = (StringBuilder) s.subSequence( 1, s.length( ) - 1 );
            }
            if ( s.charAt( s.length( ) - 1 ) == '_' ) {
                s = (StringBuilder) s.subSequence( 0, s.length( ) - 1 );
            }
            sb.append( s );
//            if ( forConstant && st.hasMoreTokens( ) ) {
//                sb.append( '_' );
//            }
        }
//        if ( forConstant ) {
//            return sb.toString( ).toUpperCase( Locale.ENGLISH );
//        } else {
        return sb.toString( );
//        }
    }

    /* TODO Copied from JmiHelperImpl. */
    private static StringBuilder correctWord( final String word ) {

        final StringBuilder b = new StringBuilder( word.length( ) );
        // s = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        // first char must be upper
        // Specification says: All others must be lower
        // Conflict: The word may already contain a 'SmallTalk'-like name with upper/lower
        char cLast = ' ';
        for ( int i = 0; i < word.length( ); i++ ) {
            final char c = word.charAt( i );
            if ( i == 0 ) {
                b.append( Character.toUpperCase( c ) );
            } else {
                if ( Character.isUpperCase( c ) ) {
                    if ( Character.isUpperCase( cLast ) ) {
                        b.append( Character.toLowerCase( c ) );
                    } else {
//                        if ( forConstant ) {
//                            b.append( '_' );
//                        }
                        b.append( c );
                    }
                } else {
                    b.append( c );
                }
            }
            cLast = c;
        }
        return b;
    }



}
