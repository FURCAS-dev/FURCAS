package com.sap.tc.moin.xm.generation.core;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;
import com.sap.tc.moin.xm.generation.XmGenerationProtocol;


public final class XmGenerationProtocolImpl implements XmGenerationProtocol {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_GEN, XmGenerationProtocolImpl.class );

    private final List<Message> warnings = new ArrayList<Message>( );

    @Override
    public String toString( ) {

        if ( warnings.isEmpty( ) ) {
            return ""; //$NON-NLS-1$
        } else {
            final StringBuilder sb = new StringBuilder( );
            for ( final Message message : warnings ) {
                sb.append( "\n" ); //$NON-NLS-1$
                sb.append( message.getLocalizedMessage( ) );
                sb.append( "\n" ); //$NON-NLS-1$
            }
            return sb.toString( );
        }
    }

    /**
     * Adds a warning.
     * 
     * @param warning warning localized MOIN message
     * @param args arguments for replacing the parameters in the localized MOIN
     * message, can be <code>null</code>
     * @throws NullPointerException if <tt>warning</tt> is <code>null</code>
     */
    public void addWarning( final MoinLocalizedString warning, final Object... args ) {

        this.warnings.add( new Message( warning, args ) );
        LOGGER.logAndTrace( MoinSeverity.WARNING, warning, args );
    }

    /**
     * Message which contains the reference to the localized texts with
     * parameters and the arguments which can be used to replace the parameters.
     */
    private static final class Message {

        private final MoinLocalizedString myMessage;

        private final Object[] myArgs;


        /**
         * Constructor.
         * 
         * @param message localized MOIN message
         * @param args arguments for replacing the parameters in the localized
         * MOIN message, can be <code>null</code>
         * @throws NullPointerException if <tt>message</tt> is <code>null</code>
         */
        Message( final MoinLocalizedString message, final Object... args ) {

            if ( message == null ) {
                throw new MoinNullPointerException( "message" ); //$NON-NLS-1$
            }
            this.myMessage = message;
            this.myArgs = args;
        }



        /**
         * Returns the localized message with the current locale. The parameters
         * are replaced.
         * 
         * @return localized message
         */
        public String getLocalizedMessage( ) {

            final Locale locale = MoinLocaleProvider.getInstance( ).getCurrentLocale( );
            if ( this.myArgs != null && this.myArgs.length > 0 ) {
                final MessageFormat format = new MessageFormat( this.myMessage.getLocalizedMessage( locale ), locale );
                return format.format( this.myArgs );
            }
            return this.myMessage.getLocalizedMessage( locale );
        }
    }

}
