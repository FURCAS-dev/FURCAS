package com.sap.tc.moin.repository.mmi.reflect;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>Duplicate_XMSG: </li>
 * <li>CompositionRuleViolated_XMSG: </li>
 * <li>MalformedXmi_XMSG: </li>
 * <li>InvalidName_XMSG: </li>
 * <li>InvalidCallNoInfo_XMSG: </li>
 * <li>InvalidCallWithInfo_XMSG: </li>
 * <li>TypeMismatchWithInfo_XMSG: </li>
 * <li>TypeMismatchNoInfo_XMSG: </li>
 * <li>UnexpectedException_XMSG: </li>
 * <li>UnRecoverableExceptionOccured_XMSG: </li>
 * <li>WrongSizeWithInfo_XMSG: </li>
 * <li>DuplicateElements_XMSG: </li>
 * <li>ObjectAlreadyExists_XMSG: </li>
 * <li>ClosureRulesViolated_XMSG: </li>
 * <li>ActionCanceled_XMSG: </li>
 * <li>TransientPartitionMustBeEmpty_XMSG: </li>
 * </ol>
 * <p>
 * <p>Message Constants generated from JmiExceptionMessages.properties
 */
 
public enum JmiExceptionMessages implements MoinLocalizedString {


    /**
     * Message: "The command was canceled"
     */
    ACTIONCANCELED("ActionCanceled_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Reference or composition closure rule is violated"
     */
    CLOSURERULESVIOLATED("ClosureRulesViolated_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A composition violation was encountered (an object has more than one composite parent)"
     */
    COMPOSITIONRULEVIOLATED("CompositionRuleViolated_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Duplicate elements were found, MRI list: {0}"
     */
    DUPLICATEELEMENTS("DuplicateElements_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A collection marked as "unique" contained the same element more than once, additional technical information: {0}"
     */
    DUPLICATE("Duplicate_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An invalid operation call was encountered"
     */
    INVALIDCALLNOINFO("InvalidCallNoInfo_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An invalid operation call was encountered, additional technical information: {0}"
     */
    INVALIDCALLWITHINFO("InvalidCallWithInfo_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An invalid name was encountered: {0}"
     */
    INVALIDNAME("InvalidName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An Exception occurred while processing an XMI document, message: {0} "
     */
    MALFORMEDXMI("MalformedXmi_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Object with MRI "{0}" already exists"
     */
    OBJECTALREADYEXISTS("ObjectAlreadyExists_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The transient partition of the connection must be empty before saving, PRI "{0}", remaining elements: "{1}""
     */
    TRANSIENTPARTITIONMUSTBEEMPTY("TransientPartitionMustBeEmpty_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An type mismatch condition was encountered, no additional information available"
     */
    TYPEMISMATCHNOINFO("TypeMismatchNoInfo_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An type mismatch condition was encountered, additional technical information: {0}"
     */
    TYPEMISMATCHWITHINFO("TypeMismatchWithInfo_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An unrecoverable Exception was encountered"
     */
    UNRECOVERABLEEXCEPTIONOCCURED("UnRecoverableExceptionOccured_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An unexpected Exception was encountered, message: {0}"
     */
    UNEXPECTEDEXCEPTION("UnexpectedException_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An wrong size condition was encountered, additional technical information: {0}"
     */
    WRONGSIZEWITHINFO("WrongSizeWithInfo_XMSG"); //$NON-NLS-1$

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

    private final static LocalizedResourceBundleAccessorApi ACCESSOR = new LocalizedResourceBundleAccessorApi( JmiExceptionMessages.class );

    private final String myKey;

    private JmiExceptionMessages( String bundleKey ) {

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
            return "Localization failed for ResourceBundle " + JmiExceptionMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  
