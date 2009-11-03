package com.sap.tc.moin.xm.generation.core;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>AttributeWildcardIgnored_XMSG: </li>
 * <li>CreatingDataTypeForSimpleType_XMSG: </li>
 * <li>DataTypeForTypeOfAttribute_XMSG: </li>
 * <li>DataTypeForTypeOfElement_XMSG: </li>
 * <li>ElementWithType_XMSG: </li>
 * <li>GlobalElementWithIconsistentType_XMSG: </li>
 * <li>InvalidPrimitiveMofType_XMSG: </li>
 * <li>MixedIgnored_XMSG: </li>
 * <li>RepeatingModelGroup_XMSG: </li>
 * <li>NoMoinPackageForNamespace_XMSG: </li>
 * <li>NoBuildInTypeForSimpleType_XMSG: </li>
 * <li>NoNamespaceForPrefix_XMSG: </li>
 * <li>NoPrefixForNamespace_XMSG: </li>
 * <li>AttributeWithoutType_XMSG: </li>
 * <li>ReferenceToRepeatingModelGroupDef_XMSG: </li>
 * <li>RestrictionsOfComplexTypeIgnored_XMSG: </li>
 * <li>SimpleTypeSubstitutionGroupIgnored_XMSG: </li>
 * <li>TargetNamespaceNotURI_XMSG: </li>
 * <li>NoValidFeatureName_XMSG: </li>
 * <li>NoValidMOFPackageName_XMSG: </li>
 * <li>NotAvalidMetamodelElementName_XMSG: </li>
 * <li>UnexpectedParticleContentType_XMSG: </li>
 * <li>WildcardIgnored_XMSG: </li>
 * <li>InvalidXmlSchema_XMSG: </li>
 * </ol>
 * <p>
 * <p>Message Constants generated from XmGenerationMessages.properties
 */
 
public enum XmGenerationMessages implements MoinLocalizedString {


    /**
     * Message: "Attribute wildcard "{0}" of complex type definition "{1}" ignored"
     */
    ATTRIBUTEWILDCARDIGNORED("AttributeWildcardIgnored_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No type definition found for attribute declaration "{0}".  Assuming type is " {1}"."
     */
    ATTRIBUTEWITHOUTTYPE("AttributeWithoutType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Creating  "{0}" data type for simple type definition "{1}" of variety "{2}""
     */
    CREATINGDATATYPEFORSIMPLETYPE("CreatingDataTypeForSimpleType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Data type "{0}" created for type definition "{1}" of attribute declaration "{2}""
     */
    DATATYPEFORTYPEOFATTRIBUTE("DataTypeForTypeOfAttribute_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Data type "{0}" created for type definition "{1}" of element declaration "{2}""
     */
    DATATYPEFORTYPEOFELEMENT("DataTypeForTypeOfElement_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Empty MOIN class created for type definition "{1}" of element declaration "{0}""
     */
    ELEMENTWITHTYPE("ElementWithType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Global element declaration" {0}"has inconsistent type definition "{1}""
     */
    GLOBALELEMENTWITHICONSISTENTTYPE("GlobalElementWithIconsistentType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid primitive MOF type {0}"
     */
    INVALIDPRIMITIVEMOFTYPE("InvalidPrimitiveMofType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "XML schema for namespace "{0}" is invalid: {1}"
     */
    INVALIDXMLSCHEMA("InvalidXmlSchema_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Mixed attribute of complex type definition "{0}" ignored"
     */
    MIXEDIGNORED("MixedIgnored_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No XSD build-in type definition found for simple type definition "{0}". Assuming to be "{1}"."
     */
    NOBUILDINTYPEFORSIMPLETYPE("NoBuildInTypeForSimpleType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No MOIN package found for target namespace "{0}""
     */
    NOMOINPACKAGEFORNAMESPACE("NoMoinPackageForNamespace_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No namespace registered for prefix "{0}" "
     */
    NONAMESPACEFORPREFIX("NoNamespaceForPrefix_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No prefix for namespace "{0}" registered"
     */
    NOPREFIXFORNAMESPACE("NoPrefixForNamespace_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name {0} is not a valid MOF feature name. Therefore the name {1} is used."
     */
    NOVALIDFEATURENAME("NoValidFeatureName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name {0} is not a valid MOF package name. Therefore the package name {1} is used."
     */
    NOVALIDMOFPACKAGENAME("NoValidMOFPackageName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name {0} is not a valid metamodel element name. Therefore the name {1} is used."
     */
    NOTAVALIDMETAMODELELEMENTNAME("NotAvalidMetamodelElementName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Reference to model group definition "{0}" has multiplicity {1}. Multiplicity forwarded to single child particles."
     */
    REFERENCETOREPEATINGMODELGROUPDEF("ReferenceToRepeatingModelGroupDef_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Model group "{0}" with multiplicity {1} encountered. Multiplicity forwarded to single child particles."
     */
    REPEATINGMODELGROUP("RepeatingModelGroup_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Restrictions of complex type definition "{0}" ignored"
     */
    RESTRICTIONSOFCOMPLEXTYPEIGNORED("RestrictionsOfComplexTypeIgnored_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Substitution group "{0}" with simple type definition ignored"
     */
    SIMPLETYPESUBSTITUTIONGROUPIGNORED("SimpleTypeSubstitutionGroupIgnored_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Target namespace "{0}" is not a correct URI"
     */
    TARGETNAMESPACENOTURI("TargetNamespaceNotURI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected particle content type "{0}" encountered"
     */
    UNEXPECTEDPARTICLECONTENTTYPE("UnexpectedParticleContentType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Wildcard "{0}" ignored"
     */
    WILDCARDIGNORED("WildcardIgnored_XMSG"); //$NON-NLS-1$

    private final static class LocalizedResourceBundleAccessorApi {

        private final String resourceBundleName;

        private final HashMap<Locale, ResourceBundle> bundles = new HashMap<Locale, ResourceBundle>( 2 );

        private final ClassLoader classLoader;

        /**
         * @param accessorClass
         */
        @SuppressWarnings( "unchecked" )
        LocalizedResourceBundleAccessorApi( Class accessorClass ) {

            this.resourceBundleName = accessorClass.getName( );
            this.classLoader = accessorClass.getClassLoader( );
        }

        /**
         * @param locale the requested {@link Locale}
         * @param bundleKey the key in the {@link ResourceBundle}
         * @return the localized message
         */
        String getMessageText( Locale locale, String bundleKey ) {

            synchronized ( this.bundles ) {

                try {
                
                    return getMessageTextUnchecked( locale, bundleKey );
                    
                } catch ( RuntimeException e ) {
                
                    return "Localization failed for ResourceBundle " + this.resourceBundleName + " Key: " + bundleKey + " Locale: " + locale.toString( ) + " Original Exception message: " + e.getMessage( ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                    
                }

            }

        }

        /**
         * Formats the message in English.
         * <p>
         * There is no Exception handling in this method.
         * 
         * @param bundleKey
         * @param args
         * @return the formatted message
         */
        String format( String bundleKey, Object... args ) {

            synchronized ( this.bundles ) {

                try {
                    String pattern = this.getMessageTextUnchecked( Locale.ENGLISH, bundleKey );

                    if ( args != null && args.length > 0 ) {
                    
                        MessageFormat format = new MessageFormat( pattern, Locale.ENGLISH );
                        
                        return format.format( args );
                    }
                    
                    return pattern;
                    
                } catch ( RuntimeException e ) {
                
                    StringBuilder sb = new StringBuilder( );
                    
                    int i = 0;
                    if ( args != null && args.length > 0 ) {
                     
                        while ( i < args.length ) {
                        
                            sb.append( " Parameter" ); //$NON-NLS-1$
                            
                            sb.append( i );
                            
                            sb.append( ": " ); //$NON-NLS-1$
                            
                            sb.append( String.valueOf( args[i] ) );
                            
                            i++;
                        }
                    } else {
                        sb.append( " No parameters" ); //$NON-NLS-1$
                    }
                
                    return "Localization failed for ResourceBundle " + this.resourceBundleName + " Key: " + bundleKey + " Locale: " + Locale.ENGLISH.toString( ) + sb.toString() + " Original Exception message: " + e.getMessage( ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                    
                }
            }

        }
        
        private String getMessageTextUnchecked( Locale locale, String bundleKey ) {

            ResourceBundle rb = this.bundles.get( locale );

            if ( rb == null ) {

                rb = ResourceBundle.getBundle( this.resourceBundleName, locale, this.classLoader );

                this.bundles.put( locale, rb );
                return rb.getString( bundleKey );

            }

           return rb.getString( bundleKey );

        }

    }

    private final static LocalizedResourceBundleAccessorApi ACCESSOR = new LocalizedResourceBundleAccessorApi( XmGenerationMessages.class );

    private final String myKey;

    private XmGenerationMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            // $JL-EXC$
            return "Localization failed for ResourceBundle " + XmGenerationMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  