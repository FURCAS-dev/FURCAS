package com.sap.tc.moin.repository.core.checks;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>AssocMustStoreInItsMetamodel_XMSG: Cross-metamodel associations where the association is in a different metamodel than the MofClass at the storage end are not allowed</li>
 * <li>NoStorageOnEitherEnd_XMSG: No storage on either end</li>
 * <li>NoValueForMandatoryFeature_XMSG: No value was found for the mandatory feature "{0}"</li>
 * <li>PackagePrefixOnlyForToplevelPackages_XMSG: Package "{0}" has a prefix but it is not a toplevel package. Package prefixes can only be defined for toplevel packages.</li>
 * <li>StorageOnOneEndMax_XMSG: Storage on more than 1 end is not supported</li>
 * <li>NoSubstituteNameTags_XMSG: Tag "{0}" defines a substitute name. Substitute names are not supported.</li>
 * <li>ImmediatePackageNotNull_XMSG: The Immediate Package of a RefObject must not be null</li>
 * <li>JavaNameXExistsForXInNamespaceX_XMSG: The Java name "{0}" exists already for the model element "{1}" in the extended namespace "{2}".</li>
 * <li>JavaNameXOfXExistsForXInNamespaceX_XMSG: The Java name "{0}" of the model element "{1}" exists already for the model element "{2}" in the extended namespace "{3}".</li>
 * <li>PackageJavaNameXOfXExistsForXInContainerX_XMSG: The Java name "{0}" of the package "{1}" exists already for the package "{2}" in the container "{3}".</li>
 * <li>PackageJavaNameXExistsForXInContainerX_XMSG: The Java package name "{0}" exists already for the package "{1}" in the container "{2}".</li>
 * <li>MofIDNotNull_XMSG: The MofID of a RefObject must not be null</li>
 * <li>WorkspaceNotNull_XMSG: The Workspace of a RefObject must not be null</li>
 * <li>CharXOfLabelXIsNotLetterDigitUnderscore_XMSG: The character "{0}" in the label "{1}" needs to be a letter, a digit or an underscore.</li>
 * <li>CharXOfLabelXIsNotAscii_XMSG: The character "{0}" in the label "{1}" needs to be an ascii character.</li>
 * <li>CharXOfLabelXOfXIsNotLetterDigitUnderscore_XMSG: The character "{0}" in the label "{1}" of the enumeration "{2}" needs to be a letter, a digit or an underscore.</li>
 * <li>CharXOfLabelXOfXIsNotAscii_XMSG: The character "{0}" in the label "{1}" of the enumeration "{2}" needs to be an ascii character.</li>
 * <li>CharXOfNameXIsNotLetterDigitUnderscore_XMSG: The character "{0}" in the name "{1}" needs to be a letter, a digit or an underscore.</li>
 * <li>CharXOfNameXIsNotAscii_XMSG: The character "{0}" in the name "{1}" needs to be an ascii character.</li>
 * <li>CharXOfNameXOfXIsNotLetterDigitUnderscore_XMSG: The character "{0}" in the name "{1}" of the model element "{2}" needs to be a letter, a digit or an underscore.</li>
 * <li>CharXOfNameXOfXIsNotAscii_XMSG: The character "{0}" in the name "{1}" of the model element "{2}" needs to be an ascii character.</li>
 * <li>Underflow_XMSG: The feature "{0}" should have at least {1} values, but only {2} values were found</li>
 * <li>Overflow_XMSG: The feature "{0}" should have at most {1} values, but {2} values were found</li>
 * <li>FirstCharOfLabelXIsNotLetter_XMSG: The first character in the label "{0}" is not a letter.</li>
 * <li>FirstCharOfLabelXOfXIsNotLetter_XMSG: The first character of the label "{0}" of the enumeration "{1}" is not a letter.</li>
 * <li>FirstCharOfNameXIsNotLetter_XMSG: The first character of the name "{0}" is not a letter.</li>
 * <li>FirstCharOfNameXOfXIsNotLetter_XMSG: The first character of the name "{0}" of the model element "{1}" is not a letter.</li>
 * <li>LabelXIsJavaKeyword_XMSG: The label "{0}" is a Java keyword.</li>
 * <li>LabelXOfXIsJavaKeyword_XMSG: The label "{0}" of the Enumeration "{1}" is a Java keyword.</li>
 * <li>LabelIsNull_XMSG: The label is null.</li>
 * <li>LabelLengthIsNull_XMSG: The label length is null.</li>
 * <li>LabelLengthOfXIsNull_XMSG: The label length of the Enumeration "{0}" is null.</li>
 * <li>LabelOfXIsNull_XMSG: The label of the Enumeration "{0}" is null.</li>
 * <li>MetaObjectNotNull_XMSG: The meta object of a RefObject must not be null</li>
 * <li>NameXExistsForXInNamespaceX_XMSG: The name "{0}" exists already for the model element "{1}" in the extended namespace "{2}".</li>
 * <li>NameXIsJavaKeyword_XMSG: The name "{0}" is a Java keyword.</li>
 * <li>InvalidName_XMSG: The name "{0}" is not valid</li>
 * <li>NameXOfXExistsForXInNamespaceX_XMSG: The name "{0}" of the model element "{1}" exists already for the model element "{2}" in the extended namespace "{3}".</li>
 * <li>NameXOfXIsJavaKeyword_XMSG: The name "{0}" of the model element "{1}" is a Java keyword.</li>
 * <li>PackageNameXOfXExistsForXInContainerX_XMSG: The name "{0}" of the package "{1}" exists already for the package "{2}" in the container "{3}".</li>
 * <li>NameIsNull_XMSG: The name is null.</li>
 * <li>NameLengthIsNull_XMSG: The name length is null.</li>
 * <li>NameLengthOfXIsNull_XMSG: The name length of the model element "{0}" is null.</li>
 * <li>NameOfXIsNull_XMSG: The name of the model element "{0}" is null.</li>
 * <li>PackageNameXExistsForXInContainerX_XMSG: The package name "{0}" exists already for the package "{1}" in the container "{2}".</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreChecks.properties
 */
 
public enum CoreChecks implements MoinLocalizedString {


    /**
     * Message: "Cross-metamodel associations where the association is in a different metamodel than the MofClass at the storage end are not allowed"
     */
    ASSOCMUSTSTOREINITSMETAMODEL("AssocMustStoreInItsMetamodel_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The character "{0}" in the label "{1}" needs to be an ascii character."
     */
    CHARXOFLABELXISNOTASCII("CharXOfLabelXIsNotAscii_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The character "{0}" in the label "{1}" needs to be a letter, a digit or an underscore."
     */
    CHARXOFLABELXISNOTLETTERDIGITUNDERSCORE("CharXOfLabelXIsNotLetterDigitUnderscore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The character "{0}" in the label "{1}" of the enumeration "{2}" needs to be an ascii character."
     */
    CHARXOFLABELXOFXISNOTASCII("CharXOfLabelXOfXIsNotAscii_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The character "{0}" in the label "{1}" of the enumeration "{2}" needs to be a letter, a digit or an underscore."
     */
    CHARXOFLABELXOFXISNOTLETTERDIGITUNDERSCORE("CharXOfLabelXOfXIsNotLetterDigitUnderscore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The character "{0}" in the name "{1}" needs to be an ascii character."
     */
    CHARXOFNAMEXISNOTASCII("CharXOfNameXIsNotAscii_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The character "{0}" in the name "{1}" needs to be a letter, a digit or an underscore."
     */
    CHARXOFNAMEXISNOTLETTERDIGITUNDERSCORE("CharXOfNameXIsNotLetterDigitUnderscore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The character "{0}" in the name "{1}" of the model element "{2}" needs to be an ascii character."
     */
    CHARXOFNAMEXOFXISNOTASCII("CharXOfNameXOfXIsNotAscii_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The character "{0}" in the name "{1}" of the model element "{2}" needs to be a letter, a digit or an underscore."
     */
    CHARXOFNAMEXOFXISNOTLETTERDIGITUNDERSCORE("CharXOfNameXOfXIsNotLetterDigitUnderscore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The first character in the label "{0}" is not a letter."
     */
    FIRSTCHAROFLABELXISNOTLETTER("FirstCharOfLabelXIsNotLetter_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The first character of the label "{0}" of the enumeration "{1}" is not a letter."
     */
    FIRSTCHAROFLABELXOFXISNOTLETTER("FirstCharOfLabelXOfXIsNotLetter_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The first character of the name "{0}" is not a letter."
     */
    FIRSTCHAROFNAMEXISNOTLETTER("FirstCharOfNameXIsNotLetter_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The first character of the name "{0}" of the model element "{1}" is not a letter."
     */
    FIRSTCHAROFNAMEXOFXISNOTLETTER("FirstCharOfNameXOfXIsNotLetter_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Immediate Package of a RefObject must not be null"
     */
    IMMEDIATEPACKAGENOTNULL("ImmediatePackageNotNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name "{0}" is not valid"
     */
    INVALIDNAME("InvalidName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Java name "{0}" exists already for the model element "{1}" in the extended namespace "{2}"."
     */
    JAVANAMEXEXISTSFORXINNAMESPACEX("JavaNameXExistsForXInNamespaceX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Java name "{0}" of the model element "{1}" exists already for the model element "{2}" in the extended namespace "{3}"."
     */
    JAVANAMEXOFXEXISTSFORXINNAMESPACEX("JavaNameXOfXExistsForXInNamespaceX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The label is null."
     */
    LABELISNULL("LabelIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The label length is null."
     */
    LABELLENGTHISNULL("LabelLengthIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The label length of the Enumeration "{0}" is null."
     */
    LABELLENGTHOFXISNULL("LabelLengthOfXIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The label of the Enumeration "{0}" is null."
     */
    LABELOFXISNULL("LabelOfXIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The label "{0}" is a Java keyword."
     */
    LABELXISJAVAKEYWORD("LabelXIsJavaKeyword_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The label "{0}" of the Enumeration "{1}" is a Java keyword."
     */
    LABELXOFXISJAVAKEYWORD("LabelXOfXIsJavaKeyword_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The meta object of a RefObject must not be null"
     */
    METAOBJECTNOTNULL("MetaObjectNotNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The MofID of a RefObject must not be null"
     */
    MOFIDNOTNULL("MofIDNotNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name is null."
     */
    NAMEISNULL("NameIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name length is null."
     */
    NAMELENGTHISNULL("NameLengthIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name length of the model element "{0}" is null."
     */
    NAMELENGTHOFXISNULL("NameLengthOfXIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name of the model element "{0}" is null."
     */
    NAMEOFXISNULL("NameOfXIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name "{0}" exists already for the model element "{1}" in the extended namespace "{2}"."
     */
    NAMEXEXISTSFORXINNAMESPACEX("NameXExistsForXInNamespaceX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name "{0}" is a Java keyword."
     */
    NAMEXISJAVAKEYWORD("NameXIsJavaKeyword_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name "{0}" of the model element "{1}" exists already for the model element "{2}" in the extended namespace "{3}"."
     */
    NAMEXOFXEXISTSFORXINNAMESPACEX("NameXOfXExistsForXInNamespaceX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name "{0}" of the model element "{1}" is a Java keyword."
     */
    NAMEXOFXISJAVAKEYWORD("NameXOfXIsJavaKeyword_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No storage on either end"
     */
    NOSTORAGEONEITHEREND("NoStorageOnEitherEnd_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Tag "{0}" defines a substitute name. Substitute names are not supported."
     */
    NOSUBSTITUTENAMETAGS("NoSubstituteNameTags_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No value was found for the mandatory feature "{0}""
     */
    NOVALUEFORMANDATORYFEATURE("NoValueForMandatoryFeature_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The feature "{0}" should have at most {1} values, but {2} values were found"
     */
    OVERFLOW("Overflow_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Java package name "{0}" exists already for the package "{1}" in the container "{2}"."
     */
    PACKAGEJAVANAMEXEXISTSFORXINCONTAINERX("PackageJavaNameXExistsForXInContainerX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Java name "{0}" of the package "{1}" exists already for the package "{2}" in the container "{3}"."
     */
    PACKAGEJAVANAMEXOFXEXISTSFORXINCONTAINERX("PackageJavaNameXOfXExistsForXInContainerX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The package name "{0}" exists already for the package "{1}" in the container "{2}"."
     */
    PACKAGENAMEXEXISTSFORXINCONTAINERX("PackageNameXExistsForXInContainerX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name "{0}" of the package "{1}" exists already for the package "{2}" in the container "{3}"."
     */
    PACKAGENAMEXOFXEXISTSFORXINCONTAINERX("PackageNameXOfXExistsForXInContainerX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Package "{0}" has a prefix but it is not a toplevel package. Package prefixes can only be defined for toplevel packages."
     */
    PACKAGEPREFIXONLYFORTOPLEVELPACKAGES("PackagePrefixOnlyForToplevelPackages_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Storage on more than 1 end is not supported"
     */
    STORAGEONONEENDMAX("StorageOnOneEndMax_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The feature "{0}" should have at least {1} values, but only {2} values were found"
     */
    UNDERFLOW("Underflow_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The Workspace of a RefObject must not be null"
     */
    WORKSPACENOTNULL("WorkspaceNotNull_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreChecks.class );

    private final String myKey;

    private CoreChecks( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + CoreChecks.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  