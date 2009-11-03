package com.sap.tc.moin.repository.localization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sap.tc.moin.repository.exception.MoinExternalizedString;

/**
 * A class loader-backed ResourceBundle access class
 * <p>
 * This is tailored for use in generated {@link MoinExternalizedString}
 * implementations and holds a reference to the English bundle
 */
public class ExternalizedResourceBundleAccessor {

    private final String resourceBundleName;

    private ResourceBundle myBundle;

    private final ClassLoader classLoader;

    /**
     * @param accessorClass the class
     */
    @SuppressWarnings( "unchecked" )
    public ExternalizedResourceBundleAccessor( Class accessorClass ) {

        this.resourceBundleName = accessorClass.getName( );
        this.classLoader = accessorClass.getClassLoader( );
    }


    /**
     * Formats the message using {@link Locale#ENGLISH}.
     * <p>
     * There is no Exception handling in this method.
     * 
     * @param bundleKey bundle key
     * @param args arguments, if any
     * @return the formatted message
     */
    public String format( String bundleKey, Object... args ) {

        // TODO is this the right way for synchronization?
        synchronized ( this ) {
            try {
                if ( this.myBundle == null ) {

                    this.myBundle = ResourceBundle.getBundle( this.resourceBundleName, Locale.ENGLISH, this.classLoader );

                }
                String pattern = this.myBundle.getString( bundleKey );


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
                return "Externalization failed for ResourceBundle " + this.resourceBundleName + " Key: " + bundleKey + sb.toString( ) + " Original Exception message: " + e.getMessage( ); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
            }
        }

    }

    /**
     * Return the unformatted message
     * 
     * @param bundleKey the bundle key
     * @return the message
     */
    public String getMessageText( String bundleKey ) {

        // TODO is this the right way for synchronization?
        synchronized ( this ) {
            try {
                return getMessageTextUnchecked( bundleKey );
            } catch ( RuntimeException e ) {
                return "Externalization failed for ResourceBundle " + this.resourceBundleName + " Key: " + bundleKey; //$NON-NLS-1$//$NON-NLS-2$
            }

        }

    }

    private String getMessageTextUnchecked( String bundleKey ) {


        if ( this.myBundle == null ) {

            this.myBundle = ResourceBundle.getBundle( this.resourceBundleName, Locale.ENGLISH, this.classLoader );

        }
        return this.myBundle.getString( bundleKey );


    }
}
