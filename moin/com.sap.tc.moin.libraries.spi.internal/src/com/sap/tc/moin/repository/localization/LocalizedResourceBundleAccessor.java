package com.sap.tc.moin.repository.localization;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * A class loader-backed ResourceBundle access class
 * <p>
 * Keeps a Locale/ResourceBundle map to avoid repeated lookups for the same
 * Locale.
 * <p>
 * Note that this does not do any Exception handling whatsoever, so callers or
 * {@link #getMessageText(Locale, String)} should handle Exceptions by
 * themselves.
 */
public class LocalizedResourceBundleAccessor {

    private final String resourceBundleName;

    private final HashMap<Locale, ResourceBundle> bundles = new HashMap<Locale, ResourceBundle>( 2 );

    private final ClassLoader classLoader;

    /**
     * @param accessorClass the class
     */
    @SuppressWarnings( "unchecked" )
    public LocalizedResourceBundleAccessor( Class accessorClass ) {

        this.resourceBundleName = accessorClass.getName( );
        this.classLoader = accessorClass.getClassLoader( );
    }

    /**
     * @param locale the requested {@link Locale}
     * @param bundleKey the key in the {@link ResourceBundle}
     * @return the localized message
     */
    public String getMessageText( Locale locale, String bundleKey ) {

        synchronized ( this.bundles ) {
            try {
                return getMessageTextUnchecked( locale, bundleKey );
            } catch ( RuntimeException e ) {
                return "Localization failed for ResourceBundle " + this.resourceBundleName + " Key: " + bundleKey + " Locale: " + locale.toString( ) + " Original Exception message: " + e.getMessage( ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
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

    /**
     * Formats the message in English.
     * <p>
     * There is no Exception handling in this method.
     * 
     * @param bundleKey the bundle key
     * @param args the arguments, if any
     * @return the formatted message
     */
    public String format( String bundleKey, Object... args ) {

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
                return "Localization failed for ResourceBundle " + this.resourceBundleName + " Key: " + bundleKey + " Locale: " + Locale.ENGLISH.toString( ) + sb.toString( ) + " Original Exception message: " + e.getMessage( ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            }
        }

    }
}
