package com.sap.tc.moin.repository.xm.parser;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>SAPExceptionReported_XMSG: </li>
 * <li>ProblemDuringParsing_XMSG: </li>
 * <li>ProblemDuringSerializing_XMSG: </li>
 * <li>ProblemOccured: </li>
 * <li>ErrorHandlerMissing_XMSG: </li>
 * <li>MethodMustBeCalled_XMSG: </li>
 * <li>SecondForNamespace_YMSG: </li>
 * <li>PrefixAlreadyRegistered_YMSG: </li>
 * <li>PrefixNotRegistered_XMSG: </li>
 * <li>PrefixForNamespaceNotRegistered_XMSG: </li>
 * <li>RootElementNotInParser_XMSG: </li>
 * <li>StringParameterEmpty_XMSG: </li>
 * </ol>
 * <p>
 * <p>Message Constants generated from XmApiMessages.properties
 */
 
public enum XmApiMessages implements MoinLocalizedString {


    /**
     * Message: "Error handler is missing for the XML schema"
     */
    ERRORHANDLERMISSING("ErrorHandlerMissing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method {0} must be called before this method is called"
     */
    METHODMUSTBECALLED("MethodMustBeCalled_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Prefix "{0}" is already registered for the namespace "{1}". You must choose another prefix for the namespace "{2}"."
     */
    PREFIXALREADYREGISTERED("PrefixAlreadyRegistered_YMSG"), //$NON-NLS-1$

    /**
     * Message: "Prefix for the namespace "{0}" is not registered"
     */
    PREFIXFORNAMESPACENOTREGISTERED("PrefixForNamespaceNotRegistered_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Prefix "{0}" is not registered"
     */
    PREFIXNOTREGISTERED("PrefixNotRegistered_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A problem in the custom XM parser occured: {0}"
     */
    PROBLEMDURINGPARSING("ProblemDuringParsing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A problem in the custom XM serializer occured: {0}"
     */
    PROBLEMDURINGSERIALIZING("ProblemDuringSerializing_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A problem occured: {0}"
     */
    PROBLEMOCCURED("ProblemOccured"), //$NON-NLS-1$

    /**
     * Message: "Root element with local name "{0}" and namespace "{1}" is not registered as root element in the XM Parser "{2}""
     */
    ROOTELEMENTNOTINPARSER("RootElementNotInParser_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A SAX Exception was reported, message: {0}"
     */
    SAPEXCEPTIONREPORTED("SAPExceptionReported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Namespace "{0}" has already the  prefix "{1}" . You cannot register a second prefix "{2}"."
     */
    SECONDFORNAMESPACE("SecondForNamespace_YMSG"), //$NON-NLS-1$

    /**
     * Message: "String parameter {0} is empty"
     */
    STRINGPARAMETEREMPTY("StringParameterEmpty_XMSG"); //$NON-NLS-1$

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

    private final static LocalizedResourceBundleAccessorApi ACCESSOR = new LocalizedResourceBundleAccessorApi( XmApiMessages.class );

    private final String myKey;

    private XmApiMessages( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + XmApiMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  