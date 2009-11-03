package com.sap.tc.moin.xm.generation.core.code.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.eclipse.xsd.XSDAttributeGroupContent;
import org.eclipse.xsd.XSDAttributeGroupDefinition;
import org.eclipse.xsd.XSDComplexTypeDefinition;

import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmClass;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmXsdComponentKind;

/**
 * Utility methods for the Parser/Serializer Mapping XML creation.
 */
public final class PSUtil {

    /* no instance. */
    private PSUtil( ) {

    }

    // TODO copied from  com.sap.tc.moin.repository.shared.util.StringUtils
    /**
     * Split a CamelCase String into a String separated by the specified
     * <code>separatorString</code>.
     * 
     * @param inputString the String you wish to split
     */
    public static String unCamelize( final String inputString, final String separatorString ) {

        final StringBuilder result = new StringBuilder( );

        boolean inited = false;
        boolean mode = false;
        int insertedSeparators = 0;
        for ( int i = 0, n = inputString.length( ); i < n; i++ ) {
            final char c = inputString.charAt( i );
            if ( ( c >= 'a' && c <= 'z' ) || ( c >= 'A' && c <= 'Z' ) ) {
                if ( !inited ) {
                    mode = Character.isLowerCase( c );
                    inited = true;
                    result.append( c );
                } else {
                    final boolean lowerCase = Character.isLowerCase( c );
                    if ( mode == lowerCase ) {
                        result.append( c );
                    } else {
                        mode = lowerCase;
                        if ( !lowerCase ) {
                            // lowercase -> uppercase switch
                            result.append( separatorString );
                            insertedSeparators++;
                        } else {
                            // uppercase -> lowercase switch
                            if ( i > 2 && Character.isUpperCase( inputString.charAt( i - 2 ) ) ) {
                                result.insert( i - 1 + ( insertedSeparators * separatorString.length( ) ), separatorString );
                            }
                        }
                        result.append( c );
                    }
                }
            } else {
                result.append( c );
            }
        }
        return result.toString( );
    }

    /**
     * Returns the resolved attribute group definitions of a complex type
     * definitions which are contained in the attribute content of the complex
     * type definition. Also the attribute groups which are referenced directly
     * or indirectly be the contained attribute group definitions are returned.
     * 
     * @param complexType complex type definition, must not be <code>null</code>
     * @return attribute group definitions, cannot be <code>null</code>
     */
    public static List<XSDAttributeGroupDefinition> getAttributeGroups( final XSDComplexTypeDefinition complexType ) {

        final List<XSDAttributeGroupDefinition> attgroups = new ArrayList<XSDAttributeGroupDefinition>( );
        for ( final XSDAttributeGroupContent content : complexType.getAttributeContents( ) ) {
            if ( content instanceof XSDAttributeGroupDefinition ) {
                final XSDAttributeGroupDefinition attrGroup = ( (XSDAttributeGroupDefinition) content ).getResolvedAttributeGroupDefinition( );
                attgroups.add( attrGroup );
                appendReferencedAttrGroups( attrGroup, attgroups );
            }
        }
        return attgroups;
    }

    private static void appendReferencedAttrGroups( final XSDAttributeGroupDefinition attrGroup, final List<XSDAttributeGroupDefinition> attgroups ) {

        for ( final XSDAttributeGroupContent content : attrGroup.getContents( ) ) {
            if ( content instanceof XSDAttributeGroupDefinition ) {
                final XSDAttributeGroupDefinition attrGroupNew = ( (XSDAttributeGroupDefinition) content ).getResolvedAttributeGroupDefinition( );
                attgroups.add( attrGroupNew );
                appendReferencedAttrGroups( attrGroupNew, attgroups );
            }
        }
    }


    /**
     * Replaces the non java identifier parts by '_'.
     * 
     * @param string
     * @return changed string or the same string if the string does not contain
     * non-java-identifier-parts
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public static String replaceNonJavaCharacters( final String string ) {

        if ( string == null ) {
            throw new MoinNullPointerException( "string" ); //$NON-NLS-1$
        }
        if ( containsNonJavaCharacters( string ) ) {
            final char[] result = new char[string.length( )];
            for ( int i = 0; i < string.length( ); i++ ) {
                final char ch = string.charAt( i );
                if ( !Character.isJavaIdentifierPart( ch ) ) {
                    result[i] = '_';
                } else {
                    result[i] = ch;
                }
            }
            return new String( result );
        } else {
            return string;
        }
    }

    private static boolean containsNonJavaCharacters( final String string ) {

        if ( string == null ) {
            throw new MoinNullPointerException( "string" ); //$NON-NLS-1$
        }
        for ( int i = 0; i < string.length( ); i++ ) {
            final char ch = string.charAt( i );
            if ( !Character.isJavaIdentifierPart( ch ) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Calculates the java method or class name for the complex type method or
     * handler class.
     * 
     * @param localName
     * @param prefix
     * @param kind
     * @param isMethod
     * @return method or class name, cannot be <code>null</code>
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public static String getMethodOrClassName( final String localName, final String prefix, final XmXsdComponentKind kind, final boolean isMethod ) {

        if ( localName == null ) {
            throw new MoinNullPointerException( "localName" ); //$NON-NLS-1$
        }
        if ( prefix == null ) {
            throw new MoinNullPointerException( "prefix" ); //$NON-NLS-1$
        }
        if ( kind == null ) {
            throw new MoinNullPointerException( "kind" ); //$NON-NLS-1$
        }

        final StringBuilder sb = new StringBuilder( );
        if ( isMethod ) {
            sb.append( "write" ); //$NON-NLS-1$
        }
        if ( prefix != null && !prefix.equals( "" ) ) { //$NON-NLS-1$
            final String first = prefix.substring( 0, 1 );
            sb.append( first.toUpperCase( Locale.ENGLISH ) );
            if ( prefix.length( ) > 1 ) {
                sb.append( prefix.substring( 1 ) );
            }
        }

        switch ( kind ) {
            case GlobalComplexType:
                sb.append( 'C' );
                break;
            case GlobalElement:
                sb.append( 'E' );
                break;
            case SubstitutionGroupHead:
                sb.append( 'S' );
                break;
            case DocumentRoot:
                sb.append( 'R' );
                break;
            default:
                throw new MoinIllegalArgumentException( "kind ", kind ); //$NON-NLS-1$
        }

        final char first = localName.charAt( 0 );
        if ( Character.isUpperCase( first ) ) {
            sb.append( localName );
        } else {
            sb.append( Character.toUpperCase( first ) );
            if ( localName.length( ) > 1 ) {
                sb.append( localName.substring( 1 ) );
            }
        }
        return PSUtil.replaceNonJavaCharacters( sb.toString( ) );
    }


    /**
     * Returns data for a sub-handler and complex type method. The class name of
     * the sub-handler is calculated from the XML global element or global
     * complex type local name and the prefix. The class name must be unique,
     * therefore this method can only be used for global element declarations or
     * global complex type definitions or the document root. The method name is
     * calculated in the same way as the class name, additionally "write" is
     * added at the beginning
     * 
     * @param moinClas MOIN class to which the hander and complex type method
     * correspond
     * @param prefix prefix
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IndexOutOfBoundsException if the string <tt>localName</tt> or
     * <tt>prefix</tt> are empty
     * @throws IllegalArgumentException if <tt>type</tt> neither
     * {@link XmXsdComponentKind#GlobalElement} nor
     * {@link XmXsdComponentKind#GlobalComplexType}
     */
    public static HandlerAndComplexTypeMethodData getHandlerAndComplexTypeMethodData( final XmClass moinClass, final String prefix ) {


        final XsdKind xsdKind;
        if ( XmXsdComponentKind.GlobalComplexType.equals( moinClass.getXsdComponentKind( ) ) ) {
            xsdKind = XsdKind.GLOBAL_COMPLEX_TYPE;
        } else if ( XmXsdComponentKind.GlobalElement.equals( moinClass.getXsdComponentKind( ) ) ) {
            xsdKind = XsdKind.GLOBAL_ELEMENT;
        } else if ( XmXsdComponentKind.DocumentRoot.equals( moinClass.getXsdComponentKind( ) ) ) {
            xsdKind = XsdKind.DOCUMENT_ROOT;
        } else {
            throw new MoinIllegalArgumentException( "type ", moinClass.getXsdComponentKind( ) ); //$NON-NLS-1$ 
        }
        final String namespace;
        if ( moinClass.getXsdNamespace( ) == null ) {
            namespace = ""; //$NON-NLS-1$
        } else {
            namespace = moinClass.getXsdNamespace( );
        }
        return new HandlerAndComplexTypeMethodData( xsdKind, moinClass.getXSDName( ), namespace, PSUtil.getMethodOrClassName( moinClass.getXSDName( ), prefix, moinClass.getXsdComponentKind( ), false ), moinClass );
    }


    public static String getXmlEntityQName( final HandlerAndComplexTypeMethodData data ) {

        if ( data == null ) {
            throw new MoinNullPointerException( "data" ); //$NON-NLS-1$
        }

        String result = data.getKind( ).toString( ) + "\"" + data.getLocalName( ); //$NON-NLS-1$
        if ( data.getNamespace( ).length( ) == 0 ) {
            result = result + "\""; //$NON-NLS-1$
        } else {
            result = result + " (" + data.getNamespace( ) + ")\""; //$NON-NLS-1$//$NON-NLS-2$
        }
        return result;
    }


}
