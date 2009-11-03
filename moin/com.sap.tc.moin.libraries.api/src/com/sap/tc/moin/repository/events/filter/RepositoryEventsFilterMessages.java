package com.sap.tc.moin.repository.events.filter;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>FilterCannotMergeWith_XMSG: </li>
 * </ol>
 * <p>
 * <p>Message Constants generated from RepositoryEventsFilterMessages.properties
 */
 
public enum RepositoryEventsFilterMessages implements MoinLocalizedString {


    /**
     * Message: "Filter cannot merge with {0}"
     */
    FILTERCANNOTMERGEWITH("FilterCannotMergeWith_XMSG"); //$NON-NLS-1$

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

    private final static LocalizedResourceBundleAccessorApi ACCESSOR = new LocalizedResourceBundleAccessorApi( RepositoryEventsFilterMessages.class );

    private final String myKey;

    private RepositoryEventsFilterMessages( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + RepositoryEventsFilterMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  