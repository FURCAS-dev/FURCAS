package com.sap.tc.moin.repository.s2x;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>SerializationCallbackHandlerIsNull: Error during the S2X serialization. The serialization callback handler is null. A metamodel that uses TranslatableTextFragments has to define a serialization callback handler.</li>
 * <li>TranslationUnitIsNull: Error during the S2X serialization. The translation unit from the customer callback "{0}" is null.</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from S2XSerializerMessages.properties
 */
 
public enum S2XSerializerMessages implements MoinLocalizedString {


    /**
     * Message: "Error during the S2X serialization. The serialization callback handler is null. A metamodel that uses TranslatableTextFragments has to define a serialization callback handler."
     */
    SERIALIZATIONCALLBACKHANDLERISNULL("SerializationCallbackHandlerIsNull"), //$NON-NLS-1$

    /**
     * Message: "Error during the S2X serialization. The translation unit from the customer callback "{0}" is null."
     */
    TRANSLATIONUNITISNULL("TranslationUnitIsNull"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( S2XSerializerMessages.class );

    private final String myKey;

    private S2XSerializerMessages( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + S2XSerializerMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  