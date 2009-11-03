package com.sap.tc.moin.js.query.service.client.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.namespace.QName;

import com.sap.tc.moin.js.query.service.InvalidResourceIdentifierFault;
import com.sap.tc.moin.js.query.service.KVList;
import com.sap.tc.moin.js.query.service.ObjectFactory;
import com.sap.tc.moin.js.query.service.Query;
import com.sap.tc.moin.js.query.service.QueryExecutionFault;
import com.sap.tc.moin.js.query.service.QueryFormatFault;
import com.sap.tc.moin.js.query.service.QueryService;
import com.sap.tc.moin.js.query.service.WsQueryScope;
import com.sap.tc.moin.js.query.service.WsStackTraceElement;
import com.sap.tc.moin.js.query.service.WsThrowable;
import com.sap.tc.moin.js.query.service.client.GenericResourceIdentifierFactory;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.ProcessMessage;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ProcessWarning;
import com.sap.tc.moin.repository.exception.MoinBaseException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseException;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ProcessMessages;
import com.sap.tc.moin.repository.util.MoinLocaleProvider;


/**
 * Implements {@link RemoteMqlProcessor} API.
 * 
 * @author D044522
 */
public class WsMqlProcessorImpl implements RemoteMqlProcessor {

    private final static QName QUERYSERVICE_QNAME = new QName( "http://sap.com/tc/moin/js/query/service/", "QueryService" ); //$NON-NLS-1$ //$NON-NLS-2$

    private final Query qsp;

    public static final String LS = System.getProperty( "line.separator" ); //$NON-NLS-1$

    private List<String> facilities;

    static final ObjectFactory of = new ObjectFactory( );

    private final static MoinLogger _log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN, MoinLocationEnum.MOIN_QUERY_MQL, WsMqlProcessorImpl.class );

    public WsMqlProcessorImpl( URL serviceUrl ) {

        // null argument check is already done by RemoteMqlProcessorFactory
        assert ( serviceUrl != null );
        final ClassLoader oldClassLoader = Thread.currentThread( ).getContextClassLoader( );
        final ClassLoader newClassLoader = com.sap.engine.services.webservices.espbase.configuration.ConfigurationRoot.class.getClassLoader( );
        QueryService qss = null;
        try {
            Thread.currentThread( ).setContextClassLoader( newClassLoader );
            qss = new QueryService( serviceUrl, QUERYSERVICE_QNAME );
        } finally {
            Thread.currentThread( ).setContextClassLoader( oldClassLoader );
        }
        this.qsp = qss.getQueryBeanPort( );
        if ( _log.isLoggedOrTraced( MoinSeverity.INFO ) ) {
            _log.logAndTrace( MoinSeverity.INFO, Localization.MQL_PROCESSOR_CREATED, WsMqlProcessorImpl.class.getCanonicalName( ), serviceUrl );
        }
    }

    public WsMqlProcessorImpl( Query qsp ) {

        assert ( qsp != null );
        this.qsp = qsp;
    }

    public MQLResultSet execute( String query, PRI[] pris, CRI[] cris, DataAreaDescriptor[] das, int scopeOperation, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        try {
            final WsQueryScope scope = of.createWsQueryScope( );

            if ( cris != null && cris.length > 0 ) {
                final List<String> cs = scope.getContainerScope( );
                for ( int i = 0; i < cris.length; i++ ) {
                    cs.add( cris[i].toString( ) );
                }
            }
            if ( pris != null && pris.length > 0 ) {
                final List<String> ps = scope.getPartitionScope( );
                for ( int i = 0; i < pris.length; i++ ) {
                    ps.add( pris[i].toString( ) );
                }
            }
            if ( das != null && das.length > 0 ) {
                final List<String> dataAreas = scope.getDataAreaScope( );
                for ( int i = 0; i < das.length; i++ ) {
                    dataAreas.add( das[i].toString( ) );
                }
            }
            scope.setScopeOperation( scopeOperation );
            final MQLResultSet mrs = new WsMqlResultSetImpl( qsp.executeQuery( query, scope, Integer.valueOf( numberOfResults ) ) );
            if ( _log.isLoggedOrTraced( MoinSeverity.INFO ) ) {
                _log.logAndTrace( MoinSeverity.INFO, Localization.TEAM_SERVER_RETURNED_RESULT, mrs );
            }
            return mrs;
        } catch ( QueryExecutionFault qef ) {
            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.TEAM_SERVER_RETURNED_EXCEPTION, qef );
            }
            throw createMQLExecutionException( qef );
        } catch ( QueryFormatFault qff ) {
            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.TEAM_SERVER_RETURNED_EXCEPTION, qff );
            }
            throw createMQLFormatException( qff );
        }
    }


    public List<DataAreaDescriptor> getDataAreas( String facilityId ) throws InvalidResourceIdentifierException {

        try {
            final List<String> das = qsp.getDataAreas( facilityId );
            if ( das == null ) {
                return null;
            }
            final List<DataAreaDescriptor> dads = new ArrayList<DataAreaDescriptor>( das.size( ) );
            for ( String da : das ) {
                // TODO Filter MetaModelDataArea and TransientDataArea!?!
                dads.add( StringWrapperResourceIdentifierFactory.getInstance( ).createDataAreaDescriptor( da ) );
            }
            return dads;
        } catch ( InvalidResourceIdentifierFault e ) {
            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.TEAM_SERVER_RETURNED_EXCEPTION, e );
            }
            throw new InvalidResourceIdentifierException( Localization.TEAM_SERVER_RETURNED_EXCEPTION, e.getMessage( ) );
        }
    }

    public List<String> getFacilities( ) {

        if ( facilities == null || facilities.isEmpty( ) ) {
            facilities = qsp.getFacilities( null ).getFacilityId( );
        }
        return facilities;
    }

    public Map<String, String> getDataAreaConfig( DataAreaDescriptor dataArea ) throws InvalidResourceIdentifierException {

        KVList kvl = null;
        try {
            kvl = qsp.getDataAreaConfig( dataArea.toString( ) );
        } catch ( InvalidResourceIdentifierFault e ) {
            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.TEAM_SERVER_RETURNED_EXCEPTION, e );
            }
            throw new InvalidResourceIdentifierException( Localization.TEAM_SERVER_RETURNED_EXCEPTION, e.getMessage( ) );
        }
        Map<String, String> rv = null;
        if ( kvl != null ) {
            final List<KVList.Entry> kvle = kvl.getEntry( );
            rv = new HashMap<String, String>( kvle.size( ) );
            for ( KVList.Entry entry : kvle ) {
                rv.put( entry.getKey( ), entry.getValue( ) );
            }
        }
        return rv;
    }

    public DataAreaDescriptor getDataArea( Map<String, String> dataAreaConfig ) throws InvalidResourceIdentifierException {

        String dataArea = null;
        final KVList daConfig = of.createKVList( );
        final List<KVList.Entry> kvlel = daConfig.getEntry( );
        for ( Map.Entry<String, String> entry : dataAreaConfig.entrySet( ) ) {
            KVList.Entry kvle = of.createKVListEntry( );
            kvle.setKey( entry.getKey( ) );
            kvle.setValue( entry.getValue( ) );
            kvlel.add( kvle );
        }
        try {
            dataArea = qsp.getDataArea( daConfig );
        } catch ( InvalidResourceIdentifierFault e ) {
            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.TEAM_SERVER_RETURNED_EXCEPTION, e );
            }
            throw new InvalidResourceIdentifierException( Localization.TEAM_SERVER_RETURNED_EXCEPTION, e.getMessage( ) );
        }
        return ( dataArea == null ) ? null : StringWrapperResourceIdentifierFactory.getInstance( ).createDataAreaDescriptor( dataArea );

    }

    private MQLFormatException createMQLFormatException( QueryFormatFault qff ) {

        final ProcessReport mpr = new WsProcessReportImpl( qff.getFaultInfo( ) );
        final MQLFormatException mfe = new MQLFormatException( mpr );
        return mfe;
    }

    private MQLExecutionException createMQLExecutionException( QueryExecutionFault qef ) {

        return new MQLExecutionException( Localization.TEAM_SERVER_RETURNED_EXCEPTION, qef.getMessage( ) );
    }


    private static final class WsProcessReportImpl implements ProcessReport {

        private static final String MSG_PR_READ_ONLY = Localization.CLASS_READ_ONLY.format( WsProcessReportImpl.class.getCanonicalName( ) );

        private final com.sap.tc.moin.js.query.service.ProcessReport pr;

        private List<ProcessError> errors = null;

        private List<ProcessWarning> warnings = null;

        public WsProcessReportImpl( com.sap.tc.moin.js.query.service.ProcessReport pr ) {

            if ( pr == null ) {
                // set an empty PR to prevent later NullPointerExceptions 
                this.pr = of.createProcessReport( );
            } else {
                this.pr = pr;
            }
        }

        public void failProcess( ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public List<ProcessError> getErrors( ) {

            if ( errors == null ) {

                final List<com.sap.tc.moin.js.query.service.ProcessError> wpes = pr.getErrors( );
                errors = new ArrayList<ProcessError>( wpes.size( ) );
                for ( Iterator<com.sap.tc.moin.js.query.service.ProcessError> iterator = wpes.iterator( ); iterator.hasNext( ); ) {
                    final com.sap.tc.moin.js.query.service.ProcessError processError = iterator.next( );
                    final ProcessError mpe = new WsProcessErrorImpl( processError );
                    errors.add( mpe );
                }
            }
            return errors;
        }

        public int getProcessStatus( ) {

            return pr.getProcessStatus( );
        }

        public List<ProcessWarning> getWarnings( ) {

            if ( warnings == null ) {

                final List<com.sap.tc.moin.js.query.service.ProcessWarning> wpes = pr.getWarnings( );
                warnings = new ArrayList<ProcessWarning>( wpes.size( ) );
                for ( Iterator<com.sap.tc.moin.js.query.service.ProcessWarning> iterator = wpes.iterator( ); iterator.hasNext( ); ) {
                    final com.sap.tc.moin.js.query.service.ProcessWarning processWarning = iterator.next( );
                    final ProcessWarning mpe = new WsProcessWarningImpl( processWarning );
                    warnings.add( mpe );
                }
            }
            return warnings;
        }

        public void printReport( OutputStream out ) throws IOException {

            final BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( out, "UTF-8" ) ); //$NON-NLS-1$
            bw.write( toString( ) );
            bw.flush( );

        }

        public void printLocalizedReport( OutputStream out ) throws IOException {

            printReport( MoinLocaleProvider.getInstance( ).getCurrentLocale( ), out );

        }

        public void printReport( Locale locale, OutputStream out ) throws IOException {

            final BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( out, "UTF-8" ) ); //$NON-NLS-1$
            bw.write( toString( locale ) );
            bw.flush( );

        }

        /**
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString( ) {

            return this.toString( Locale.getDefault( ) );
        }

        private String toString( Locale locale ) {

            final StringBuilder s = new StringBuilder( );
            final int errSize = this.getErrors( ).size( );
            final int warnSize = this.getWarnings( ).size( );
            if ( errSize > 0 ) {
                for ( Iterator<ProcessError> i = this.getErrors( ).iterator( ); i.hasNext( ); ) {
                    s.append( i.next( ).toString( locale ) );
                    s.append( LS );
                }
            }
            if ( warnSize > 0 ) {
                for ( Iterator<ProcessWarning> i = this.getWarnings( ).iterator( ); i.hasNext( ); ) {
                    s.append( i.next( ).toString( locale ) );
                    s.append( LS );
                }
            }
            String pattern = ProcessMessages.PROCESS_REPORT.getLocalizedMessage( locale );
            final MessageFormat format = new MessageFormat( pattern, locale );
            s.append( format.format( new Object[] { errSize, warnSize } ) );
            s.append( LS );

            return s.toString( );
        }

        public void reportCompletion( ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }

            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public void reportError( ProcessError error ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }

            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public void reportError( MoinBaseException error ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public void reportFatalError( ProcessError error ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public void reportFatalError( MoinBaseException error ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public void reportWarning( ProcessWarning warning ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public void reportWarning( String warning ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public void setProcessStatus( int status ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

        public void reportError( MoinLocalizedBaseException error ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PR_READ_ONLY );

        }

    }

    private static abstract class WsProcessMessageImpl implements ProcessMessage {

        private static final String MSG_PM_READ_ONLY = Localization.CLASS_READ_ONLY.format( WsProcessMessageImpl.class.getCanonicalName( ) );


        protected final com.sap.tc.moin.js.query.service.ProcessMessage wpm;

        public WsProcessMessageImpl( com.sap.tc.moin.js.query.service.ProcessMessage wpm ) {

            assert ( wpm != null );
            this.wpm = wpm;
        }

        public int getEndColumn( ) {

            return wpm.getEndColumn( );
        }

        public int getEndLine( ) {

            return wpm.getEndLine( );
        }

        public int getEndPosition( ) {

            return wpm.getEndPosition( );
        }

        public String getMessage( ) {

            return wpm.getMessage( );
        }

        public String getMessage( Locale locale ) {

            // TODO in the future we should not transmit messages translated with the server's Locale but message codes, which can be resolved on the client! 
            return wpm.getMessage( );
        }

        public int getStartColumn( ) {

            return wpm.getStartColumn( );
        }

        public int getStartLine( ) {

            return wpm.getStartLine( );
        }

        public int getStartPosition( ) {

            return wpm.getStartPosition( );
        }

        public void setEndColumn( int endColumn ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }

            throw new UnsupportedOperationException( MSG_PM_READ_ONLY );

        }

        public void setEndLine( int endLine ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PM_READ_ONLY );

        }

        public void setEndPosition( int endPosition ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PM_READ_ONLY );

        }

        public void setStartColumn( int startColumn ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PM_READ_ONLY );

        }

        public void setStartLine( int startLine ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PM_READ_ONLY );

        }

        public void setStartPosition( int startPosition ) {

            if ( _log.isLoggedOrTraced( MoinSeverity.WARNING ) ) {
                _log.logAndTrace( MoinSeverity.WARNING, Localization.CLASS_READ_ONLY );
            }
            throw new UnsupportedOperationException( MSG_PM_READ_ONLY );

        }

    }

    private static final class WsProcessErrorImpl extends WsProcessMessageImpl implements ProcessError {

        private MoinBaseException mbe = null;

        public WsProcessErrorImpl( com.sap.tc.moin.js.query.service.ProcessError wpe ) {

            super( wpe );

        }

        public MoinBaseException getRootCause( ) {

            if ( mbe == null ) {
                final WsThrowable cause = ( (com.sap.tc.moin.js.query.service.ProcessError) wpm ).getRootCause( );
                if ( cause != null ) {
                    mbe = new WsMoinBaseException( cause );
                }
            }
            return mbe;
        }

        public String toString( Locale locale ) {

            String actMessage = getMessage( locale );
            if ( actMessage == null && getRootCause( ) != null ) {
                actMessage = getRootCause( ).getMessage( );
            }
            String pattern;
            if ( getStartLine( ) < 0 ) {
                pattern = ProcessMessages.PROCESS_ERROR.getLocalizedMessage( locale );
            } else {
                pattern = ProcessMessages.PROCESS_ERROR_LOC.getLocalizedMessage( locale );
            }
            MessageFormat format = new MessageFormat( pattern, locale );
            if ( getStartLine( ) < 0 ) {
                return format.format( new Object[] { actMessage } );
            }
            return format.format( new Object[] { this.getStartLine( ), this.getStartColumn( ), this.getEndLine( ), this.getEndColumn( ), actMessage } );
        }

        /**
         * Returns a textual representation of the ProcessError
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString( ) {

            return toString( Locale.getDefault( ) );
        }


    }

    private static final class WsMoinBaseException extends MoinLocalizedBaseException {

        private static final long serialVersionUID = 1L;

        private final WsThrowable wt;

        private StackTraceElement[] st = null;

        private Throwable cause = null;

        public WsMoinBaseException( WsThrowable wt ) {

            super( Localization.TEAM_SERVER_RETURNED_EXCEPTION, wt.getMessage( ) );
            this.wt = wt;
        }

        @Override
        public Throwable getCause( ) {

            if ( cause == null ) {
                final WsThrowable wCause = wt.getCause( );
                if ( wCause != null ) {
                    cause = new WsMoinBaseException( wCause );
                }
            }
            return cause;
        }

        @Override
        public StackTraceElement[] getStackTrace( ) {

            if ( st == null ) {
                final List<WsStackTraceElement> wst = wt.getStackTrace( );
                st = new StackTraceElement[wst.size( )];
                for ( int i = 0; i < st.length; i++ ) {
                    final WsStackTraceElement wste = wst.get( i );
                    st[i] = new StackTraceElement( wste.getClassName( ), wste.getMethodName( ), wste.getFileName( ), wste.getLineNumber( ) );
                }
            }
            return st;
        }

    }

    private static final class WsProcessWarningImpl extends WsProcessMessageImpl implements ProcessWarning {

        private StackTraceElement[] st = null;

        public WsProcessWarningImpl( com.sap.tc.moin.js.query.service.ProcessWarning wpm ) {

            super( wpm );

        }

        public StackTraceElement[] getStackTrace( ) {

            if ( st == null ) {
                final List<WsStackTraceElement> wst = ( (com.sap.tc.moin.js.query.service.ProcessWarning) wpm ).getStackTrace( );
                st = new StackTraceElement[wst.size( )];
                for ( int i = 0; i < st.length; i++ ) {
                    final WsStackTraceElement wste = wst.get( i );
                    st[i] = new StackTraceElement( wste.getClassName( ), wste.getMethodName( ), wste.getFileName( ), wste.getLineNumber( ) );
                }
            }
            return st;
        }

        public String toString( Locale locale ) {

            String actMessage = getMessage( locale );
            String pattern;
            if ( getStartLine( ) < 0 ) {
                pattern = ProcessMessages.PROCESS_WARNING.getLocalizedMessage( locale );
            } else {
                pattern = ProcessMessages.PROCESS_WARNING_LOC.getLocalizedMessage( locale );
            }
            MessageFormat format = new MessageFormat( pattern, locale );
            if ( getStartLine( ) < 0 ) {
                return format.format( new Object[] { actMessage } );
            }
            return format.format( new Object[] { this.getStartLine( ), this.getStartColumn( ), this.getEndLine( ), this.getEndColumn( ), actMessage } );
        }

        /**
         * Returns a textual representation of the ProcessError
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString( ) {

            return toString( Locale.getDefault( ) );
        }
    }

    public GenericResourceIdentifierFactory getResourceIdentifierFactory( ) {

        return StringWrapperResourceIdentifierFactory.getInstance( );
    }
}
