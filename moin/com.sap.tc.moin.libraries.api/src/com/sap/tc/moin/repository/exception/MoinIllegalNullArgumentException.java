package com.sap.tc.moin.repository.exception;

import java.text.MessageFormat;
import java.util.Locale;

import com.sap.tc.moin.repository.util.MoinLocaleProvider;


/**
 * Thrown if a required parameter is null
 */
public class MoinIllegalNullArgumentException extends IllegalArgumentException {


    private static final long serialVersionUID = 1L;

    private final Object[] myParameterName;

    /**
     * Message: "Parameter "{0}" must not be null"
     * 
     * @param parameterName argument 0
     */
    public MoinIllegalNullArgumentException( String parameterName ) {

        super( ExceptionWrapperMessages.PARAMETERMUSTNOTBENULL.format( parameterName ) );
        this.myParameterName = new Object[] { parameterName };

    }

    @Override
    public String getLocalizedMessage( ) {

        Locale locale = MoinLocaleProvider.getInstance( ).getCurrentLocale( );
        MessageFormat format = new MessageFormat( ExceptionWrapperMessages.PARAMETERMUSTNOTBENULL.getLocalizedMessage( locale ), locale );
        return format.format( this.myParameterName );
    }

    /**
     * See
     * {@link com.sap.tc.moin.repository.exception.MoinLocalizedBaseException#toString()}
     * for an explanation of this
     */
    @Override
    public String toString( ) {

        String s = getClass( ).getName( );
        String message = getMessage( );
        return ( message != null ) ? ( s + ": " + message ) : s; //$NON-NLS-1$
    }

    /**
     * Convenience method for checking if a parameter is <code>null</code>.
     * 
     * @param parameterName the name of the parameter
     * @param parameter the parameter to be checked
     * @throw {@link MoinIllegalNullArgumentException} if <code>parameter</code>
     * is <code>null</code>
     */
    public static final void check( String parameterName, Object parameter ) {

        if ( parameter == null ) {
            throw new MoinIllegalNullArgumentException( parameterName );
        }
    }
}
