package com.sap.tc.moin.xm.generation.core.metamodel.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.eclipse.xsd.XSDImport;
import org.eclipse.xsd.XSDSchema;
import org.eclipse.xsd.XSDSchemaCompositor;
import org.eclipse.xsd.XSDSchemaContent;

import com.sap.guid.GUIDGeneratorFactory;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.generation.core.XmGenerationMessages;

/**
 * Builds from XML names MOF names.
 */
public final class XmMofNameBuilder {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XmMofNameBuilder.class );

    /** "package" string constant. */
    public static String PACKAGE = "package"; //$NON-NLS-1$

    private XmMofNameBuilder( ) {

        // no instance
    }

    /**
     * Checks whether a word ia a java key word.
     * 
     * @param word word to be tested, can be <code>null</code>
     * @return <tt>true</tt> if the given word is a java key word, otherwise
     * <tt>false</tt>
     */
    public static boolean isJavaKeyWord( final String word ) {

        return JavaIdentifierCheck.isJavaKeyWord( word );
    }


    /**
     * Builds a MOF package name from an identifier.
     * <p>
     * The entered name is split by '.', '-', '/', '\', ':', and combining
     * characters. The resulting word list is treated by the method
     * {@link #buildMofModelElementName(List)}.
     * <p>
     * The resulting concatenated words are put to lower cases. Then, if the
     * resulting string is a java key word the string "package" is appended.
     * 
     * @param identifier string to be transformed
     * @return MOF package name, or empty string, if the identifier is null or
     * the identifier does contain only invalid characters, cannot be
     * <code>null</code>
     * @throws NullPointerException if <tt>identifier</tt> is <code>null</code>
     */
    public static String buildMofPackageName( final String identifier ) {

        if ( identifier.length( ) == 0 ) {
            return identifier;
        }
        String result = buildMofModelElementName( splitByDotMinusSignSlashBackSlashColonAndCombiningCharacters( identifier ) );
        result = result.toLowerCase( Locale.ENGLISH );
        if ( JavaIdentifierCheck.isJavaKeyWord( result ) ) {
            result = result + PACKAGE;
        }
        if ( result.length( ) == 0 ) {
            LOGGER.logAndTrace( MoinSeverity.WARNING, XmGenerationMessages.NOVALIDMOFPACKAGENAME, new Object[] { identifier, "package" } ); //$NON-NLS-1$
        }
        return result;
    }


    /**
     * Returns a concatenation of {@link #PACKAGE}, underscore, and GUID.
     * 
     * @return package name with GUID, cannot be <code>null</code>
     */
    public static String getPackageNameWithGuid( ) {

        // GUID is added because the MOFIDs are calculated from the qualified name and the java prefix (which is in this case empty)!
        return PACKAGE + "_" + GUIDGeneratorFactory.getInstance( ).createGUIDGenerator( ).createGUID( ).toHexString( ); //$NON-NLS-1$
    }

    /**
     * Builds a name according to the MOF recommendation on model element names
     * from a list of words. The only deviation from MOF is, that white spaces
     * are not allowed. The following operations are executed on each word:
     * <ul>
     * <li>If the word contains a character which is neither a digit nor a
     * letter nor a underscore, then the character is removed</li>
     * <li>Non 7-bit ASCII characters are removed</li>
     * <li>If the first character is a letter, then the character is put to
     * upper case</li>
     * </ul>
     * Afterwards the words are concatenated. Finally, it is ensured that the
     * resulting name starts with an upper case letter; if the first character
     * is not a letter, then the character 'V' is added at the beginning.
     * 
     * @param words word list
     * @return MOF name, cannot be <code>null</code>, but may be empty because
     * the entered word list was empty or all words only contain illegal
     * characters
     * @throws MoinIllegalNullArgumentException if the parameter is
     * <code>null</code>
     * @throws MoinIllegalArgumentException if the size of the words list is 0
     */
    private static final String buildMofModelElementName( final List<String> words ) {

        final String result = UtilitiesFactory.getModelElementNameGenerator( ).buildMoinCompliantModelElementName( words, "V" ); //$NON-NLS-1$
        if ( result == null ) {
            return ""; //$NON-NLS-1$
        } else {
            return result;
        }
    }



    /**
     * Builds out of an XML element/attribute, type name a MOIN meta-model
     * element name.
     * <p>
     * The entered name is split by '.', '-', '/', '\', ':', and combining
     * characters. The resulting word list is treated by the method
     * {@link #buildMofModelElementName(List)}.
     * <p>
     * If the result has the length 0, then "Type" is returned.
     * <p>
     * If the result ends with "Class" then "Class" is removed and "Clazz" is
     * added. This is done in order to avoid clashes during the JMI generation
     * (for each MOF Class with name "X" an additional JMI interface with
     * "XClass" is generated).
     * 
     * @param identifier XML element/attribute or XSD type name
     * @return MOIN meta-model element name, cannot be <code>null</code>
     * @throws NullPointerException if the parameter is <code>null</code>
     * @throws IllegalArgumentException if the length of <tt>identifier</tt> is
     * 0
     */
    public static String buildMetaModelElementName( final String identifier ) {

        final String result = buildMofModelElementName( splitByDotMinusSignSlashBackSlashColonAndCombiningCharacters( identifier ) );
        if ( result.length( ) == 0 ) {
            LOGGER.logAndTrace( MoinSeverity.WARNING, XmGenerationMessages.NOTAVALIDMETAMODELELEMENTNAME, new Object[] { identifier, "Type" } ); //$NON-NLS-1$
            // be tolerant
            return "Type"; //$NON-NLS-1$
        } else if ( result.endsWith( "Class" ) ) { //$NON-NLS-1$
            return result.substring( 0, result.length( ) - 5 ) + "Clazz"; //$NON-NLS-1$
        }
        return result;
    }

    /**
     * Splits a string by '.', '-', '/', '\', ':', and the combining characters
     * (defined in http://www.w3.org/TR/REC-xml/#CharClasses) into words.
     * 
     * @param identifier
     * @return list of split words, cannot be <code>null</code> or empty
     * @throws NullPointerException if the parameter is <code>null</code>
     * @throws IllegalArgumentException if the length of <tt>identifier</tt> is
     * 0
     */
    private static List<String> splitByDotMinusSignSlashBackSlashColonAndCombiningCharacters( final String identifier ) {

        if ( identifier == null ) {
            throw new MoinNullPointerException( "identifier" ); //$NON-NLS-1$
        }
        if ( identifier.length( ) == 0 ) {
            throw new MoinIllegalArgumentException( "identifier", "" ); //$NON-NLS-1$//$NON-NLS-2$
        }
        final List<String> result = new ArrayList<String>( );
        final StringBuilder word = new StringBuilder( );
        for ( int i = 0; i < identifier.length( ); i++ ) {
            final char ch = identifier.charAt( i );
            if ( isCombiningChar( ch ) || ch == '-' || ch == '.' || ch == '/' || ch == '\\' || ch == ':' ) {
                if ( word.length( ) > 0 ) {
                    result.add( word.toString( ) );
                    word.setLength( 0 );
                }
            } else {
                word.append( ch );
            }
        }
        if ( word.length( ) > 0 ) {
            result.add( word.toString( ) );
            word.setLength( 0 );
        }
        return result;
    }

    public static String convertFirstCharToLower( final String input ) {

        if ( !Character.isLowerCase( input.charAt( 0 ) ) && input.length( ) > 1 ) {
            return input.substring( 0, 1 ).toLowerCase( Locale.ENGLISH ) + input.subSequence( 1, input.length( ) );
        } else {
            return input;
        }
    }

    /**
     * Builds out of an XML element/attribute a MOIN feature name.
     * <p>
     * The same transformation as described in
     * {@link #buildMetaModelElementName(String)} is done. If the resulting name
     * is empty, then "value" is returned. Otherwise the first letter of the
     * resulting name is converted to lower case. If then the resulting name is
     * equal to a java key word, then "value" is added.
     * 
     * @param identifier XML element/attribute name
     * @return MOIN meta-model element name, cannot be <code>null</code>
     * @throws NullPointerException if the parameter is <code>null</code>
     * @throws IllegalArgumentException if the length of <tt>identifier</tt> is
     * 0
     */
    public static String buildMofFeatureName( final String identifier ) {

        String result = buildMofModelElementName( splitByDotMinusSignSlashBackSlashColonAndCombiningCharacters( identifier ) );
        if ( result.length( ) == 0 ) {
            LOGGER.logAndTrace( MoinSeverity.WARNING, XmGenerationMessages.NOVALIDFEATURENAME, new Object[] { identifier, "value" } ); //$NON-NLS-1$
            // be tolerant
            return "value"; //$NON-NLS-1$
        }
        result = convertFirstCharToLower( result );
        if ( JavaIdentifierCheck.isJavaKeyWord( result ) ) {
            result = result + "Value"; //$NON-NLS-1$
        }
        return result;
    }

    private static boolean isCombiningChar( final char ch ) {

        return ( ( ( ch >= 0x0300 ) && ( ch <= 0x0345 ) ) || ( ( ch >= 0x0360 ) && ( ch <= 0x0361 ) ) || ( ( ch >= 0x0483 ) && ( ch <= 0x0486 ) ) || ( ( ch >= 0x0591 ) && ( ch <= 0x05A1 ) ) || ( ( ch >= 0x05A3 ) && ( ch <= 0x05B9 ) ) || ( ( ch >= 0x05BB ) && ( ch <= 0x05BD ) ) || ( ch == 0x05BF )
                 || ( ( ch >= 0x05C1 ) && ( ch <= 0x05C2 ) ) || ( ch == 0x05C4 ) || ( ( ch >= 0x064B ) && ( ch <= 0x0652 ) ) || ( ch == 0x0670 ) || ( ( ch >= 0x06D6 ) && ( ch <= 0x06DC ) ) || ( ( ch >= 0x06DD ) && ( ch <= 0x06DF ) ) || ( ( ch >= 0x06E0 ) && ( ch <= 0x06E4 ) )
                 || ( ( ch >= 0x06E7 ) && ( ch <= 0x06E8 ) ) || ( ( ch >= 0x06EA ) && ( ch <= 0x06ED ) ) || ( ( ch >= 0x0901 ) && ( ch <= 0x0903 ) ) || ( ch == 0x093C ) || ( ( ch >= 0x093E ) && ( ch <= 0x094C ) ) || ( ch == 0x094D ) || ( ( ch >= 0x0951 ) && ( ch <= 0x0954 ) )
                 || ( ( ch >= 0x0962 ) && ( ch <= 0x0963 ) ) || ( ( ch >= 0x0981 ) && ( ch <= 0x0983 ) ) || ( ch == 0x09BC ) || ( ch == 0x09BE ) || ( ch == 0x09BF ) || ( ( ch >= 0x09C0 ) && ( ch <= 0x09C4 ) ) || ( ( ch >= 0x09C7 ) && ( ch <= 0x09C8 ) ) || ( ( ch >= 0x09CB ) && ( ch <= 0x09CD ) )
                 || ( ch == 0x09D7 ) || ( ( ch >= 0x09E2 ) && ( ch <= 0x09E3 ) ) || ( ch == 0x0A02 ) || ( ch == 0x0A3C ) || ( ch == 0x0A3E ) || ( ch == 0x0A3F ) || ( ( ch >= 0x0A40 ) && ( ch <= 0x0A42 ) ) || ( ( ch >= 0x0A47 ) && ( ch <= 0x0A48 ) ) || ( ( ch >= 0x0A4B ) && ( ch <= 0x0A4D ) )
                 || ( ( ch >= 0x0A70 ) && ( ch <= 0x0A71 ) ) || ( ( ch >= 0x0A81 ) && ( ch <= 0x0A83 ) ) || ( ch == 0x0ABC ) || ( ( ch >= 0x0ABE ) && ( ch <= 0x0AC5 ) ) || ( ( ch >= 0x0AC7 ) && ( ch <= 0x0AC9 ) ) || ( ( ch >= 0x0ACB ) && ( ch <= 0x0ACD ) ) || ( ( ch >= 0x0B01 ) && ( ch <= 0x0B03 ) )
                 || ( ch == 0x0B3C ) || ( ( ch >= 0x0B3E ) && ( ch <= 0x0B43 ) ) || ( ( ch >= 0x0B47 ) && ( ch <= 0x0B48 ) ) || ( ( ch >= 0x0B4B ) && ( ch <= 0x0B4D ) ) || ( ( ch >= 0x0B56 ) && ( ch <= 0x0B57 ) ) || ( ( ch >= 0x0B82 ) && ( ch <= 0x0B83 ) ) || ( ( ch >= 0x0BBE ) && ( ch <= 0x0BC2 ) )
                 || ( ( ch >= 0x0BC6 ) && ( ch <= 0x0BC8 ) ) || ( ( ch >= 0x0BCA ) && ( ch <= 0x0BCD ) ) || ( ch == 0x0BD7 ) || ( ( ch >= 0x0C01 ) && ( ch <= 0x0C03 ) ) || ( ( ch >= 0x0C3E ) && ( ch <= 0x0C44 ) ) || ( ( ch >= 0x0C46 ) && ( ch <= 0x0C48 ) ) || ( ( ch >= 0x0C4A ) && ( ch <= 0x0C4D ) )
                 || ( ( ch >= 0x0C55 ) && ( ch <= 0x0C56 ) ) || ( ( ch >= 0x0C82 ) && ( ch <= 0x0C83 ) ) || ( ( ch >= 0x0CBE ) && ( ch <= 0x0CC4 ) ) || ( ( ch >= 0x0CC6 ) && ( ch <= 0x0CC8 ) ) || ( ( ch >= 0x0CCA ) && ( ch <= 0x0CCD ) ) || ( ( ch >= 0x0CD5 ) && ( ch <= 0x0CD6 ) )
                 || ( ( ch >= 0x0D02 ) && ( ch <= 0x0D03 ) ) || ( ( ch >= 0x0D3E ) && ( ch <= 0x0D43 ) ) || ( ( ch >= 0x0D46 ) && ( ch <= 0x0D48 ) ) || ( ( ch >= 0x0D4A ) && ( ch <= 0x0D4D ) ) || ( ch == 0x0D57 ) || ( ch == 0x0E31 ) || ( ( ch >= 0x0E34 ) && ( ch <= 0x0E3A ) )
                 || ( ( ch >= 0x0E47 ) && ( ch <= 0x0E4E ) ) || ( ch == 0x0EB1 ) || ( ( ch >= 0x0EB4 ) && ( ch <= 0x0EB9 ) ) || ( ( ch >= 0x0EBB ) && ( ch <= 0x0EBC ) ) || ( ( ch >= 0x0EC8 ) && ( ch <= 0x0ECD ) ) || ( ( ch >= 0x0F18 ) && ( ch <= 0x0F19 ) ) || ( ch == 0x0F35 ) || ( ch == 0x0F37 )
                 || ( ch == 0x0F39 ) || ( ch == 0x0F3E ) || ( ch == 0x0F3F ) || ( ( ch >= 0x0F71 ) && ( ch <= 0x0F84 ) ) || ( ( ch >= 0x0F86 ) && ( ch <= 0x0F8B ) ) || ( ( ch >= 0x0F90 ) && ( ch <= 0x0F95 ) ) || ( ch == 0x0F97 ) || ( ( ch >= 0x0F99 ) && ( ch <= 0x0FAD ) )
                 || ( ( ch >= 0x0FB1 ) && ( ch <= 0x0FB7 ) ) || ( ch == 0x0FB9 ) || ( ( ch >= 0x20D0 ) && ( ch <= 0x20DC ) ) || ( ch == 0x20E1 ) || ( ( ch >= 0x302A ) && ( ch <= 0x302F ) ) || ( ch == 0x3099 ) || ( ch == 0x309A ) );
    }


    // A extender character extends the preceding character, so it is not necessary to have them in the MOF Name
//    private static boolean isExtender( final char ch ) {
//
//        return ( ( ch == 0x00B7 ) || ( ch == 0x02D0 ) || ( ch == 0x02D1 ) || ( ch == 0x0387 ) || ( ch == 0x0640 ) || ( ch == 0x0E46 ) || ( ch == 0x0EC6 ) || ( ch == 0x3005 ) || ( ( ch >= 0x3031 ) && ( ch <= 0x3035 ) ) || ( ( ch >= 0x309D ) && ( ch <= 0x309E ) ) || ( ( ch >= 0x30FC ) && ( ch <= 0x30FE ) ) );
//    }

    private static final class JavaIdentifierCheck {

        private static Set<String> JAVA_KEYWORDS_AND_RESERVED_WORDS = new HashSet<String>( Arrays.asList( new String[] { "abstract", //$NON-NLS-1$
            "assert", //$NON-NLS-1$
            "boolean", //$NON-NLS-1$
            "break", //$NON-NLS-1$
            "byte", //$NON-NLS-1$
            "case", //$NON-NLS-1$
            "catch", //$NON-NLS-1$
            "char", //$NON-NLS-1$
            "class", //$NON-NLS-1$
            "const", //$NON-NLS-1$
            "continue", //$NON-NLS-1$
            "default", //$NON-NLS-1$
            "do", //$NON-NLS-1$
            "double", //$NON-NLS-1$
            "else", //$NON-NLS-1$
            "enum", //$NON-NLS-1$
            "extends", //$NON-NLS-1$
            "false", //$NON-NLS-1$
            "final", //$NON-NLS-1$
            "finally", //$NON-NLS-1$
            "float", //$NON-NLS-1$
            "for", //$NON-NLS-1$
            "goto", //$NON-NLS-1$
            "if", //$NON-NLS-1$
            "implements", //$NON-NLS-1$
            "import", //$NON-NLS-1$
            "instanceof", //$NON-NLS-1$
            "int", //$NON-NLS-1$
            "interface", //$NON-NLS-1$
            "long", //$NON-NLS-1$
            "native", //$NON-NLS-1$
            "new", //$NON-NLS-1$
            "null", //$NON-NLS-1$
            "package", //$NON-NLS-1$
            "private", //$NON-NLS-1$
            "protected", //$NON-NLS-1$
            "public", //$NON-NLS-1$
            "return", //$NON-NLS-1$
            "short", //$NON-NLS-1$
            "static", //$NON-NLS-1$
            "strictfp", //$NON-NLS-1$
            "super", //$NON-NLS-1$
            "switch", //$NON-NLS-1$
            "synchronized", //$NON-NLS-1$
            "this", //$NON-NLS-1$
            "throw", //$NON-NLS-1$
            "throws", //$NON-NLS-1$
            "transient", //$NON-NLS-1$
            "true", //$NON-NLS-1$
            "try", //$NON-NLS-1$
            "void", //$NON-NLS-1$
            "volatile", //$NON-NLS-1$
            "while" } ) ); //$NON-NLS-1$

        private JavaIdentifierCheck( ) {

            // do not use
        }

        public static final boolean isJavaKeyWord( final String s ) {

            return JAVA_KEYWORDS_AND_RESERVED_WORDS.contains( s );
        }

//        public static final boolean isValid7BitAscii( final char c ) {
//
//            return c < 0x80;
//        }
    }


    /**
     * Determines the target namespace of the XML schema and the target
     * namespaces of the direct and indirect imported schemas. The no-namespace
     * is not returned.
     * 
     * @param schema XML schema
     * @return set of target namespaces, or an empty set, if the schema does
     * have the no-namespace and does not import direct or indirectly other
     * target schemas, cannot be <code>null</code>; if the root schema has a
     * namespace different from the no-namespace, then the sets iterator will
     * return this target namespace first
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public static Set<String> getTargetNamespaces( final XSDSchema schema ) {

        // create a linked hash set which preserves the order, the first entry should be the target namespace of the 
        // root schema!
        final Set<String> targetNamespaces = new LinkedHashSet<String>( );
        final String ns = schema.getTargetNamespace( );
        if ( ns != null && ns.length( ) > 0 ) {
            targetNamespaces.add( ns );
        }
        // collect the already investigated schemas in order to avoid cycles
        final Set<XSDSchema> alreadyInvestigatedSchemas = new HashSet<XSDSchema>( );
        alreadyInvestigatedSchemas.add( schema );
        getTargetNamespacesOfImports( schema, alreadyInvestigatedSchemas, targetNamespaces );
        return targetNamespaces;
    }

    /**
     * Collects the target namespaces of the direct and indirect imported
     * schemas.
     * 
     * @param schema
     * @param alreadyInvestigatedSchemas
     * @param targetNamespaces
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    private static void getTargetNamespacesOfImports( final XSDSchema schema, final Set<XSDSchema> alreadyInvestigatedSchemas, final Set<String> targetNamespaces ) {

        for ( final XSDSchemaContent directive : schema.getContents( ) ) {
            if ( directive instanceof XSDImport ) {
                addTargetNamespace( ( (XSDImport) directive ).getResolvedSchema( ), alreadyInvestigatedSchemas, targetNamespaces );
            } else if ( directive instanceof XSDSchemaCompositor ) {
                addTargetNamespace( ( (XSDSchemaCompositor) directive ).getIncorporatedSchema( ), alreadyInvestigatedSchemas, targetNamespaces );
            } else {
                // do nothing
            }
        }
    }

    private static void addTargetNamespace( final XSDSchema schema, final Set<XSDSchema> alreadyInvestigatedSchemas, final Set<String> targetNamespaces ) {

        if ( alreadyInvestigatedSchemas.contains( schema ) ) {
            // do nothing
        } else if ( schema != null ) {
            alreadyInvestigatedSchemas.add( schema );
            final String namespace = schema.getTargetNamespace( );
            if ( namespace != null && namespace.length( ) > 0 ) {
                targetNamespaces.add( namespace );
            }
            // recursion
            getTargetNamespacesOfImports( schema, alreadyInvestigatedSchemas, targetNamespaces );
        } else {
            // do nothing
        }
    }
}
