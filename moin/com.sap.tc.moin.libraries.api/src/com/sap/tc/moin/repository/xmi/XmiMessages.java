package com.sap.tc.moin.repository.xmi;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * <p>
 * <p>
 * Localized Messages in alphabetical order:
 * <ol>
 * <li>UnsupportedUriScheme_XMSG: Unsupported URI scheme: {0}</li>
 * </ol>
 * <p>
 * <p>
 * Message Constants generated from XmiMessages.properties
 */

public enum XmiMessages implements MoinLocalizedString {


    /**
     * Message: "Unsupported URI scheme: {0}"
     */
    UNSUPPORTEDURISCHEME( "UnsupportedUriScheme_XMSG" ); //$NON-NLS-1$

    private final static class LocalizedResourceBundleAccessor {

        private final String resourceBundleName;

        private final HashMap<Locale, ResourceBundle> bundles = new HashMap<Locale, ResourceBundle>( 2 );

        private final ClassLoader classLoader;

        /**
         * @param accessorClass
         */
        @SuppressWarnings( "unchecked" )
        LocalizedResourceBundleAccessor( Class accessorClass ) {

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


                ResourceBundle rb = this.bundles.get( locale );

                if ( rb == null ) {

                    rb = ResourceBundle.getBundle( this.resourceBundleName, locale, this.classLoader );

                    this.bundles.put( locale, rb );
                    return rb.getString( bundleKey );

                }
                return rb.getString( bundleKey );

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

                String pattern = this.getMessageText( Locale.ENGLISH, bundleKey );

                if ( args != null && args.length > 0 ) {
                    MessageFormat format = new MessageFormat( pattern, Locale.ENGLISH );
                    return format.format( args );
                }
                return pattern;
            }

        }
    }

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( XmiMessages.class );

    private final String myKey;

    private XmiMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + XmiMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}