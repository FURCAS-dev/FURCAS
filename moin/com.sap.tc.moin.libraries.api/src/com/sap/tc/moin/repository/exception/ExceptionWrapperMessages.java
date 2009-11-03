package com.sap.tc.moin.repository.exception;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>IllegalArgumentValue_XMSG: </li>
 * <li>IllegalArgument_XMSG: </li>
 * <li>IndexOutOfBounds_XMSG: </li>
 * <li>IndexOutOfBoundsParam_XMSG: </li>
 * <li>Illegal_Argument_Method_Value_XMSG: </li>
 * <li>UnsupportedOperation_XMSG: </li>
 * <li>ParameterMustNotBeNull_XMSG: </li>
 * <li>UnsupportedOperationNoArg_XMSG: </li>
 * <li>MustOverrideThisAbstractMethod_XMSG: </li>
 * <li>Unknown_Enum_Value_Detected_XMSG: </li>
 * </ol>
 * <p>
 * <p>Message Constants generated from ExceptionWrapperMessages.properties
 */
 
public enum ExceptionWrapperMessages implements MoinLocalizedString {


    /**
     * Message: "Argument with name "{0}"  has an illegal value "{1}""
     */
    ILLEGALARGUMENTVALUE("IllegalArgumentValue_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Argument with name "{0}" is illegal"
     */
    ILLEGALARGUMENT("IllegalArgument_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method "{0}": Argument with name "{1}" has an illegal value "{2}""
     */
    ILLEGAL_ARGUMENT_METHOD_VALUE("Illegal_Argument_Method_Value_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Index: {0} Size: {1}"
     */
    INDEXOUTOFBOUNDSPARAM("IndexOutOfBoundsParam_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Index is outside the legal bounds"
     */
    INDEXOUTOFBOUNDS("IndexOutOfBounds_XMSG"), //$NON-NLS-1$

    /**
     * Message: "This method must be overridden by a concrete subclass"
     */
    MUSTOVERRIDETHISABSTRACTMETHOD("MustOverrideThisAbstractMethod_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Parameter "{0}" must not be null"
     */
    PARAMETERMUSTNOTBENULL("ParameterMustNotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unable to handle unknown enumeration value of type {0}: {1}"
     */
    UNKNOWN_ENUM_VALUE_DETECTED("Unknown_Enum_Value_Detected_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The called operation is not supported"
     */
    UNSUPPORTEDOPERATIONNOARG("UnsupportedOperationNoArg_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Operation "{0}" is not supported"
     */
    UNSUPPORTEDOPERATION("UnsupportedOperation_XMSG"); //$NON-NLS-1$

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

    private final static LocalizedResourceBundleAccessorApi ACCESSOR = new LocalizedResourceBundleAccessorApi( ExceptionWrapperMessages.class );

    private final String myKey;

    private ExceptionWrapperMessages( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + ExceptionWrapperMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  