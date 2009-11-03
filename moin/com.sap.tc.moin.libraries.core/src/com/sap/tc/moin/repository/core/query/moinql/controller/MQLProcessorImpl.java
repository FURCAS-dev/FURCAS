/*
 * Created on 30.01.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.controller;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.MOIN_DOMAIN;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.getExceptionAsString;
import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.registerBroadcastingMBean;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.management.MBeanNotificationInfo;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.ProcessWarning;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.query.fql.engine.BasicQueryProcessorMemoryEstimationImpl;
import com.sap.tc.moin.repository.core.query.fql.engine.BasicQueryProcessorMemoryEstimationVariantImpl;
import com.sap.tc.moin.repository.core.query.fql.engine.BasicQueryProcessorMemoryImpl;
import com.sap.tc.moin.repository.core.query.messages.FQLTraceMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLApiMessages;
import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.engine.MQLInterpreterImpl;
import com.sap.tc.moin.repository.core.query.moinql.engine.MQLSchedulerImpl;
import com.sap.tc.moin.repository.core.query.moinql.internal.InternalQuery;
import com.sap.tc.moin.repository.core.query.moinql.parser.MqlParser;
import com.sap.tc.moin.repository.core.query.moinql.preprocessor.MQLExpander;
import com.sap.tc.moin.repository.core.query.moinql.preprocessor.MQLExpanderImpl;
import com.sap.tc.moin.repository.core.query.moinql.preprocessor.MQLFacilityAssigner;
import com.sap.tc.moin.repository.core.query.moinql.preprocessor.MQLFacilityAssignerImpl;
import com.sap.tc.moin.repository.core.query.moinql.preprocessor.MQLTypeCheckerImpl;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.jmx.MqlProcessorMBean;
import com.sap.tc.moin.repository.mql.MQLColumnType;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLNotSupportedException;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLPreprocessorException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;
import com.sap.tc.moin.repository.shared.util.WeakReferenceWithObjectName;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityFullIndexQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacilitySlimIndexQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiFacilitySlimVariantIndexQueryService;
import com.sap.tc.moin.repository.spi.facility.SpiMQLQueryService;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFacilityQueryLanguage;

/**
 * This is the controller class for the MQL Processor. It is the implementation
 * of the MQL service exported to clients.
 */
public class MQLProcessorImpl implements MQLProcessor {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_QUERY_MQL, MQLProcessorImpl.class );

    // important constants
    private static final int MAX_NUMBER_OF_ERRORS = 100;

    private static final int DEFAULT_MAX_RESULT_SET_SIZE = 10000;

    private static final int DEFAULT_THRESHOLD_FOR_NUMBER_OF_RELEVANT_PARTITIONS = 20;

    private static final int DEFAULT_THRESHOLD_FOR_NUMBER_OF_ELEMENTS_IN_PARTITION = 500;

    /**
     * We keep a parser for the MQL concrete syntax
     */
//    private MqlParser mqlParser; // FIXME sync fix
    /**
     * Synchronization manager
     */
    protected SynchronizationManager syncManager;

    /**
     * We keep the memory FQL processor
     */
    private SpiFacilityQueryLanguage memoryFQLProcessor;

    /**
     * A MQL processor maintains a registry of FQL processors per facility
     */
    private Map<String, SpiFacilityQueryLanguage> fqlProcessors;

    /**
     * An MQL processor instance is provided per connection, which the
     * MQLProcessor has to keep a reference to
     */
    protected CoreConnection conn;

    /**
     * We need MOIN as well
     */
    private CoreMoin moin;

    /**
     * If a result set is larger than the maxResultSetSize, the engine stops
     * execution with an exception! The default is 10000
     */
    private int maxResultSetSize = DEFAULT_MAX_RESULT_SET_SIZE;

    /**
     * The name identifying this MQLProcessorImpl instance in JMX.
     */
    private ObjectName objectName;

    /**
     * The MBean instance that gets registered in the MBeanServer. We need it
     * for the emission of JMX notifications.
     */
    private JmxAdapter jmxAdapter;

    /**
     * Whether the emission of JMX notifications is currently enabled.
     */
    public volatile boolean jmxNotificationsEnabled;

    /**
     * we only do a pre-optimization of a query during scheduling if the number
     * of relevant partition does not exceed this threshold. This should be
     * larger than 2 to make sure dirty null and transient partitions are
     * excluded where appropriate. The default is 10.
     */
    private int thresholdForNumberOfRelevantPartitionsForOptimization = DEFAULT_THRESHOLD_FOR_NUMBER_OF_RELEVANT_PARTITIONS;

    /**
     * per partitions, we only do a pre-optimization during scheduling of a
     * query if the number of elements does not exceed this threshold. The
     * default is 500.
     */
    private int thresholdForNumberOfElementsInPartitionForOptimization = DEFAULT_THRESHOLD_FOR_NUMBER_OF_ELEMENTS_IN_PARTITION;

    /**
     * The MQL expander, which splits the query in strong clusters and avoids
     * multiple assocPredicates between 2 atomic entries
     */
    private MQLExpander mqlExpander;

    /**
     * The MQL facility assigned spreads the query over multiple facilities
     */
    private MQLFacilityAssigner mqlFacilityAssigner;

    /**
     * We need a bunch of auxiliar services too
     */
    private MQLAuxServices mqlAuxServices;

    /**
     * The data areas relevant for the session
     */
    private Set<DataAreaDescriptor> sessionRelevantDataAreaDescriptors;

    public MQLProcessorImpl( Connection conn, Collection<SpiMQLQueryService> queryServices, Set<DataAreaDescriptor> sessionRelevantDataAreas ) {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_OBTAINED_FOR_CONNECTION, conn.getId( ) );
        }
        // connection
        this.conn = (CoreConnection) conn;
        this.moin = this.conn.getSession( ).getMoin( );

        // parser
//        this.mqlParser = new MqlParser( MAX_NUMBER_OF_ERRORS, this.moin ); // FIXME sync fix

        // sync manager
        this.syncManager = this.conn.getSession( ).getWorkspaceSet( ).getSynchronizationManager( );

        // transformation service
        this.mqlAuxServices = new MQLAuxServices( );

        // set the one memory implementation, which is always used for scheduling
        this.memoryFQLProcessor = new BasicQueryProcessorMemoryImpl( );

        // initialize the FQL registry
        this.fqlProcessors = new HashMap<String, SpiFacilityQueryLanguage>( queryServices.size( ) );

        // register all assigned SpiMQLQueryServices, 
        for ( SpiMQLQueryService queryService : queryServices ) {

            // depending on the type of query language, we have to construct a full facility query language with core means
            SpiFacilityQueryLanguage fql = null;
            if ( queryService instanceof SpiFacilitySlimVariantIndexQueryService ) {
                fql = new BasicQueryProcessorMemoryEstimationVariantImpl( (SpiFacilitySlimVariantIndexQueryService) queryService );
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_SLIM_VARIANT_INDEX_FOR_FACILITY, queryService.getFacilityId( ), this.conn.getId( ) );
                }
            } else if ( queryService instanceof SpiFacilitySlimIndexQueryService ) {
                fql = new BasicQueryProcessorMemoryEstimationImpl( (SpiFacilitySlimIndexQueryService) queryService );
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_SLIM_INDEX_FOR_FACILITY, queryService.getFacilityId( ), this.conn.getId( ) );
                }
            } else if ( queryService instanceof SpiFacilityFullIndexQueryService ) {
                // currently no support
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_FULL_INDEX_FOR_FACILITY, queryService.getFacilityId( ), this.conn.getId( ) );
                }
                throw new MQLNotSupportedException( MQLApiMessages.FIFQL_NOT_SUPPORTED );
            } else if ( queryService instanceof SpiFacilityQueryLanguage ) {
                fql = (SpiFacilityQueryLanguage) queryService;
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_FACILITY_QUERY_LANGUAGE_FOR_FACILITY, queryService.getFacilityId( ), this.conn.getId( ) );
                }
            } else {
                // unknown Query Language
                throw new MQLNotSupportedException( MQLApiMessages.UNKNOWN_FACILITY_QUERY_LANGUAGE );
            }

            // sanity checks
            if ( fql.getFacilityId( ).equals( this.memoryFQLProcessor.getFacilityId( ) ) ) {
                throw new MQLBugException( MQLBugMessages.MEMORY_FQL_USED_IN_FACILITY );
            }
            if ( this.fqlProcessors.containsKey( fql.getFacilityId( ) ) ) {
                throw new MQLBugException( MQLBugMessages.MORE_THAN_ONE_FQL_PER_FACILITY );
            }

            // register
            this.fqlProcessors.put( fql.getFacilityId( ), fql );
        }

        if ( this.fqlProcessors.size( ) == 0 ) {
            // no facility query service registered at all
            throw new MQLExecutionException( MQLApiMessages.NO_QUERY_SERVICE_FOUND );
        }

        /* remember session relevant data areas for creating the scheduler */
        this.sessionRelevantDataAreaDescriptors = sessionRelevantDataAreas;

        /* obtain an expander for the connection */
        this.mqlExpander = new MQLExpanderImpl( this.mqlAuxServices );

        /* obtain an assigner for the connection */
        this.mqlFacilityAssigner = new MQLFacilityAssignerImpl( this.fqlProcessors.values( ), this.mqlAuxServices );

        if ( JMX_ENABLED ) {
            this.registerMBean( );
        }

    }

    /*
     * The scheduler uses certain thresholds to perform a certain optimization.
     * These methods permit them to be turned on/off. This is mainly for testing
     * purposes
     */

    public void turnOffOptimizationForElementsDuringScheduling( ) {

        this.thresholdForNumberOfElementsInPartitionForOptimization = 0;
    }

    public void turnOffOptimizationForPartitionsDuringScheduling( ) {

        this.thresholdForNumberOfRelevantPartitionsForOptimization = 0;
    }

    public void turnOnOptimizationDuringScheduling( ) {

        this.thresholdForNumberOfElementsInPartitionForOptimization = DEFAULT_THRESHOLD_FOR_NUMBER_OF_ELEMENTS_IN_PARTITION;
        this.thresholdForNumberOfRelevantPartitionsForOptimization = DEFAULT_THRESHOLD_FOR_NUMBER_OF_RELEVANT_PARTITIONS;
    }


    /**
     * This method parses and then prepares the query
     */
    private MQLPreparedQuery prepareInternal( String query ) throws MQLFormatException {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_PREPARATION_START_CST );
        }

        MQLQuery parsedQuery = null;
        MqlParser mqlParser = new MqlParser( MAX_NUMBER_OF_ERRORS, this.moin );

        try {
            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_SYNTACTIC_PARSING_OF_CST_QUERY, "\n", query.toString( ) ); //$NON-NLS-1$
            }

            parsedQuery = mqlParser.parse( query, this );
//            parsedQuery = this.mqlParser.parse( query, this ); // FIXME sync fix

        } catch ( MQLFormatException e ) {
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, FQLTraceMessages.MQL_PROCESSOR_QUERY_DOES_NOT_PARSE, "\n", query, "\n" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            throw e;
        }

        return this.prepareInternal( parsedQuery, mqlParser.getReport( ) );
//        return this.prepareInternal( parsedQuery, this.mqlParser.getReport( ) ); // FIXME sync fix
    }

    /**
     * This method prepares an MQL AST Query
     */
    private MQLPreparedQuery prepareInternal( MQLQuery query, ProcessReport report ) throws MQLPreprocessorException {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_PREPARATION_START_AST );
        }
        InternalQuery internalQuery = null;

        if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
            this.jmxAdapter.queryPrepareStart( Thread.currentThread( ).getStackTrace( ) );
        }

        long timeStamp = System.nanoTime( );

        try {

            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_TYPE_AND_FORMAT_CHECKING_OF_AST_QUERY, "\n", query ); //$NON-NLS-1$
            }

            /* Type and Format Checking */
            /* -------------------------- */

            /*
             * convert the query into the internal structure and check for
             * format and type errors
             */
            internalQuery = new MQLTypeCheckerImpl( this.conn ).convert( query, report );
//            internalQuery = this.mqlTypeChecker.convert( query, report ); // FIXME sync fix

            // possibly, the type checker found problems, in which case we have
            // to abort already only warnings keep living
            if ( report.getProcessStatus( ) == ProcessReport.FAILED ) {
                if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                    logger.trace( MoinSeverity.ERROR, FQLTraceMessages.MQL_PROCESSOR_THE_FOLLOWING_QUERY_HAS_TYPE_ERRORS, "\n", query ); //$NON-NLS-1$
                }
                // if we had type check errors, we stop
                throw new MQLFormatException( report );
            }

            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_FURTHER_PRE_PROCESSING_OF_INTERNAL_QUERY, "\n", internalQuery ); //$NON-NLS-1$
            }

            /* Expanding */
            /* ----------- */

            /* expand so it can be executed by the mixer */
            internalQuery = this.mqlExpander.expand( internalQuery );

            /* Assigning */
            /* ----------- */

            /* assign the different BQL processors (if they exist) */
            internalQuery = this.mqlFacilityAssigner.assign( internalQuery );

            /*
             * Before releasing the query as prepared, remove possible empty
             * parts
             */
            internalQuery = this.mqlAuxServices.reduceQueryAfterScopeChanges( internalQuery );

        } catch ( MQLPreprocessorException e ) {

            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, FQLTraceMessages.MQL_PROCESSOR_QUERY_PREPARATION_ABORTED, "\n", ( internalQuery == null ? "NULL query" : internalQuery ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            throw e;

        } finally {
            long queryTime = ( System.nanoTime( ) - timeStamp ) / 1000000;

            // we are done with the preprocessing
            report.reportCompletion( );

            // provide the report in the prepared query   
            if ( internalQuery != null ) {
                internalQuery.setReport( report );
            }

            // report warnings if there were any
            if ( logger.isTraced( MoinSeverity.WARNING ) ) {
                if ( report.getProcessStatus( ) == ProcessReport.SUCCESSFUL_WITH_WARNINGS ) {
                    List<ProcessWarning> warnings = report.getWarnings( );
                    logger.trace( MoinSeverity.WARNING, FQLTraceMessages.MQL_PROCESSOR_FOUND_WARNINGS_DURING_PREPARATION_OF_THE_FOLLOWING_QUERY, "\n", ( internalQuery == null ? "NULL query" : internalQuery ) ); //$NON-NLS-1$ //$NON-NLS-2$
                    for ( ProcessWarning warning : warnings ) {
                        logger.trace( MoinSeverity.WARNING, warning.getMessage( ) );
                    }
                }
            }

            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                this.jmxAdapter.queryPrepareEnd( ( internalQuery == null ? "NULL query" : internalQuery.toString( ) ), queryTime ); //$NON-NLS-1$
            }

            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_PREPARATION_FINISHED, queryTime, "\n", ( internalQuery == null ? "NULL query" : internalQuery ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }

            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_PREPARATION_STOP );
            }
        }

        return internalQuery;
    }

    /**
     * Execution method
     */
    private MQLResultSet executeInternal( MQLPreparedQuery preparedQuery, boolean schedulingWanted, boolean globalScopeIncluded, PRI[] globalPartitionScope, CRI[] globalContainerScope, int numberOfResults ) throws MQLExecutionException {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_EXECUTION_START );
        }

        MQLResultSet result = null;

        if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
            this.jmxAdapter.queryExecuteStart( Thread.currentThread( ).getStackTrace( ) );
        }

        long timeStamp = System.nanoTime( );

        InternalQuery internalQuery = (InternalQuery) preparedQuery;

        try {

            // We want to assure that no other threads can write and this also
            // avoid the eviction manager from changing anything. At best, more partitions are loaded, which is safe
            this.syncManager.acquireReadLock( );
            try {
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_SCHEDULING_QUERY, "\n", internalQuery ); //$NON-NLS-1$
                }

                /* schedule the prepared query for execution */
                MQLSchedulerImpl scheduler = new MQLSchedulerImpl( this.conn, this.memoryFQLProcessor, this.mqlAuxServices, sessionRelevantDataAreaDescriptors );
                internalQuery = scheduler.schedule( internalQuery, schedulingWanted, globalScopeIncluded, globalPartitionScope, globalContainerScope, this.thresholdForNumberOfRelevantPartitionsForOptimization, this.thresholdForNumberOfElementsInPartitionForOptimization );

                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_INTERPRETING_QUERY, "\n", internalQuery ); //$NON-NLS-1$
                }

                /* execute the internal query */
                MQLInterpreterImpl interpreter = new MQLInterpreterImpl( this.conn, this.memoryFQLProcessor, this, this.mqlAuxServices );
                result = interpreter.execute( internalQuery, this.maxResultSetSize, numberOfResults );
            } finally {
                // we're done. Release
                this.syncManager.releaseReadLock( );
            }

            if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
                logger.trace( MoinSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_QUERY_PRODUCED_RESULT_SET, "\n", internalQuery, "\n", "\n", result ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }

        } catch ( MQLExecutionException e ) {
            if ( logger.isTraced( MoinSeverity.ERROR ) ) {
                logger.trace( MoinSeverity.ERROR, FQLTraceMessages.MQL_PROCESSOR_ABORTED_EXECUTION_OF_QUERY, "\n", ( internalQuery == null ? "NULL query" : internalQuery ) ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            throw e;

        } finally {

            long queryTime = ( System.nanoTime( ) - timeStamp ) / 1000000;

            if ( JMX_ENABLED && this.jmxNotificationsEnabled ) {
                this.jmxAdapter.queryExecuteEnd( ( internalQuery == null ? "NULL query" : internalQuery.toString( ) ), queryTime, result ); //$NON-NLS-1$
            }

            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_QUERY_EXECUTION_FINISHED, queryTime );
            }

            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_EXECUTION_STOP );
            }

        }

        return result;
    }

    /**
     * This method first prepares and then executes the query (convenience)
     */
    private MQLResultSet executeInternal( MQLQuery selectQuery, boolean schedulingWanted, boolean globalScopeIncluded, PRI[] globalPartitionScope, CRI[] globalContainerScope, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        // first prepare and then immediately execute the provided query
        MQLPreparedQuery preparedQuery = null;
        try {
            preparedQuery = this.prepare( selectQuery );
        } catch ( MQLPreprocessorException e ) {
            if ( e instanceof MQLFormatException ) {
                throw e;
            }
            // we wrap all non-FormatExceptions exception as an execution exception
            throw new MQLExecutionException( e, MQLApiMessages.MQL_PREPROCESSOR_PROBLEM );
        }

        return this.executeInternal( preparedQuery, schedulingWanted, globalScopeIncluded, globalPartitionScope, globalContainerScope, numberOfResults );
    }

    /*
     * Public methods
     */

    public MQLPreparedQuery prepare( MQLQuery query ) throws MQLPreprocessorException {

        return this.prepareInternal( query, new ProcessReportImpl( MAX_NUMBER_OF_ERRORS ) );
    }

    public MQLPreparedQuery prepare( String query ) throws MQLPreprocessorException {

        return this.prepareInternal( query );
    }

    public MQLResultSet execute( MQLPreparedQuery preparedQuery ) throws MQLExecutionException {

        return this.executeInternal( preparedQuery, true, false, null, null, -1 );
    }

    public MQLResultSet execute( MQLQuery query ) throws MQLExecutionException, MQLFormatException {

        return this.executeInternal( query, true, false, null, null, -1 );
    }

    public MQLResultSet execute( String query ) throws MQLExecutionException, MQLFormatException {

        MQLPreparedQuery preparedQuery = this.prepareInternal( query );
        return this.executeInternal( preparedQuery, true, false, null, null, -1 );
    }

    public MQLResultSet execute( MQLPreparedQuery query, QueryScopeProvider scopeProvider ) throws MQLExecutionException {

        return this.executeInternal( query, true, scopeProvider.isInclusiveScope( ), scopeProvider.getPartitionScope( ), scopeProvider.getContainerScope( ), -1 );
    }

    public MQLResultSet execute( MQLQuery query, QueryScopeProvider scopeProvider ) throws MQLExecutionException, MQLFormatException {

        return this.executeInternal( query, true, scopeProvider.isInclusiveScope( ), scopeProvider.getPartitionScope( ), scopeProvider.getContainerScope( ), -1 );
    }

    public MQLResultSet execute( String query, QueryScopeProvider scopeProvider ) throws MQLExecutionException, MQLFormatException {

        MQLPreparedQuery preparedQuery = this.prepareInternal( query );
        return this.executeInternal( preparedQuery, true, scopeProvider.isInclusiveScope( ), scopeProvider.getPartitionScope( ), scopeProvider.getContainerScope( ), -1 );
    }

    public MQLResultSet execute( MQLPreparedQuery query, int numberOfResults ) throws MQLExecutionException {

        return this.executeInternal( query, true, false, null, null, numberOfResults );
    }

    public MQLResultSet execute( MQLQuery query, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        return this.executeInternal( query, true, false, null, null, numberOfResults );
    }

    public MQLResultSet execute( String query, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        MQLPreparedQuery preparedQuery = this.prepareInternal( query );
        return this.executeInternal( preparedQuery, true, false, null, null, numberOfResults );
    }

    public MQLResultSet execute( MQLPreparedQuery query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException {

        return this.executeInternal( query, true, scopeProvider.isInclusiveScope( ), scopeProvider.getPartitionScope( ), scopeProvider.getContainerScope( ), numberOfResults );
    }

    public MQLResultSet execute( MQLQuery query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        return this.executeInternal( query, true, scopeProvider.isInclusiveScope( ), scopeProvider.getPartitionScope( ), scopeProvider.getContainerScope( ), numberOfResults );
    }

    public MQLResultSet execute( String query, QueryScopeProvider scopeProvider, int numberOfResults ) throws MQLExecutionException, MQLFormatException {

        MQLPreparedQuery preparedQuery = this.prepareInternal( query );
        return this.executeInternal( preparedQuery, true, scopeProvider.isInclusiveScope( ), scopeProvider.getPartitionScope( ), scopeProvider.getContainerScope( ), numberOfResults );
    }

    public QueryScopeProvider getGlobalQueryScopeProvider( ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return false;
            }

            public CRI[] getContainerScope( ) {

                return new CRI[0];
            }

            public PRI[] getPartitionScope( ) {

                return new PRI[0];
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getQueryScopeProvider( final boolean scopeInclusive, final PRI[] partitionScope, final CRI[] containerScope ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return scopeInclusive;
            }

            public CRI[] getContainerScope( ) {

                if ( containerScope == null ) {
                    return new CRI[0];
                } else {
                    return containerScope;
                }
            }

            public PRI[] getPartitionScope( ) {

                if ( partitionScope == null ) {
                    return new PRI[0];
                } else {
                    return partitionScope;
                }
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getQueryScopeProvider( final boolean scopeInclusive, final PRI[] partitionScope, final String[] containerScope ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return scopeInclusive;
            }

            public CRI[] getContainerScope( ) {

                if ( containerScope == null ) {
                    return new CRI[0];
                } else {
                    return MQLProcessorImpl.this.getCrisForContainerNames( containerScope );
                }
            }

            public PRI[] getPartitionScope( ) {

                if ( partitionScope == null ) {
                    return new PRI[0];
                } else {
                    return partitionScope;
                }
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getQueryScopeProvider( final boolean scopeInclusive, final Set<PRI> partitionScope, final Set<CRI> containerScope ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return scopeInclusive;
            }

            public CRI[] getContainerScope( ) {

                if ( containerScope == null ) {
                    return new CRI[0];
                } else {
                    return containerScope.toArray( new CRI[containerScope.size( )] );
                }
            }

            public PRI[] getPartitionScope( ) {

                if ( partitionScope == null ) {
                    return new PRI[0];
                } else {
                    return partitionScope.toArray( new PRI[partitionScope.size( )] );
                }
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getInclusiveCriScopeProvider( final CRI... containerScope ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return true;
            }

            public CRI[] getContainerScope( ) {

                if ( containerScope == null ) {
                    return new CRI[0];
                } else {
                    return containerScope;
                }
            }

            public PRI[] getPartitionScope( ) {

                return new PRI[0];
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getInclusiveVisibleCriScopeProvider( final CRI cri ) {


        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return true;
            }

            public CRI[] getContainerScope( ) {

                return new CRI[0];
            }

            public PRI[] getPartitionScope( ) {

                Collection<PRI> outerPris = MQLProcessorImpl.this.conn.getSession( ).getOuterPartitions( cri );
                Collection<PRI> innerPris = MQLProcessorImpl.this.conn.getSession( ).getInnerPartitions( cri );

                PRI[] resultPris = new PRI[outerPris.size( ) + innerPris.size( ) + 1];
                int i = 0;
                for ( Iterator<PRI> iterator = innerPris.iterator( ); iterator.hasNext( ); i++ ) {
                    PRI pri = iterator.next( );
                    resultPris[i] = pri;
                }
                for ( Iterator<PRI> iterator = outerPris.iterator( ); iterator.hasNext( ); i++ ) {
                    PRI pri = iterator.next( );
                    resultPris[i] = pri;
                }
                // add the null-partition
                resultPris[i] = MQLProcessorImpl.this.conn.getNullPartition( ).getPri( );

                return resultPris;
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getInclusiveContainerScopeProvider( final String... containerScope ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return true;
            }

            public CRI[] getContainerScope( ) {

                if ( containerScope == null ) {
                    return new CRI[0];
                } else {
                    return MQLProcessorImpl.this.getCrisForContainerNames( containerScope );
                }
            }

            public PRI[] getPartitionScope( ) {

                return new PRI[0];
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getInclusiveQueryScopeProvider( final PRI[] partitionScope, final CRI[] containerScope ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return true;
            }

            public CRI[] getContainerScope( ) {

                if ( containerScope == null ) {
                    return new CRI[0];
                } else {
                    return containerScope;
                }
            }

            public PRI[] getPartitionScope( ) {

                if ( partitionScope == null ) {
                    return new PRI[0];
                } else {
                    return partitionScope;
                }
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getInclusivePartitionScopeProvider( final PRI... partitionScope ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return true;
            }

            public CRI[] getContainerScope( ) {

                return new CRI[0];
            }

            public PRI[] getPartitionScope( ) {

                if ( partitionScope == null ) {
                    return new PRI[0];
                } else {
                    return partitionScope;
                }
            }
        };

        return queryScopeProvider;
    }

    public QueryScopeProvider getInclusiveQueryScopeProvider( final Set<PRI> partitionScope, final Set<CRI> containerScope ) {

        QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {

            public boolean isInclusiveScope( ) {

                return true;
            }

            public CRI[] getContainerScope( ) {

                if ( containerScope == null ) {
                    return new CRI[0];
                } else {
                    return containerScope.toArray( new CRI[containerScope.size( )] );
                }
            }

            public PRI[] getPartitionScope( ) {

                if ( partitionScope == null ) {
                    return new PRI[0];
                } else {
                    return partitionScope.toArray( new PRI[partitionScope.size( )] );
                }
            }
        };

        return queryScopeProvider;
    }

    public int getMaxResultSetSize( ) {

        return this.maxResultSetSize;
    }

    public void setMaxResultSetSize( int _maxResultSetSize ) {

        this.maxResultSetSize = _maxResultSetSize;
    }

    public CRI[] getCrisForContainerNames( String... containerNames ) {

        Collection<Facility> facilities = this.moin.getFacilities( );

        Set<CRI> cris = new HashSet<CRI>( );

        if ( containerNames != null ) {
            for ( Facility facility : facilities ) {
                ResourceIdentifierFactory riFactory = facility.getRIFactory( );
                Collection<String> dataAreaNames = facility.getDataAreaNames( );
                for ( String dataAreaName : dataAreaNames ) {
                    for ( String containerName : containerNames ) {
                        cris.add( riFactory.createCri( dataAreaName, containerName ) );
                    }
                }
            }
        }

        return cris.toArray( new CRI[cris.size( )] );
    }

    /**
     * This operation executes the {@link MQLPreparedQuery} <b>without</b>
     * considering dirty state. It returns a {@link MQLResultSet}. Note: the
     * results of this type of execution may be incorrect if dirty state exists!
     * Execution errors are throw as an {@link MQLExecutionException} and should
     * not occur during normal operation.
     */
    public MQLResultSet executeIgnoringDirtyState( MQLPreparedQuery preparedQuery ) throws MQLExecutionException {

        if ( false ) {
            return executeInternal( preparedQuery, false, false, null, null, -1 );
        }
        throw new MQLNotSupportedException( MQLApiMessages.IGNOREDIRTY_NOT_SUPPORTED );
    }

    /**
     * This operation executes the {@link MQLQuery} <b>without</b> considering
     * dirty state. It first prepares the query by means of
     * {@link #prepare(MQLQuery)} and returns an {@link MQLResultSet}. To avoid
     * repeated preparation, use {@link #prepare(MQLQuery)} first and then
     * {@link #executeIgnoringDirtyState(MQLPreparedQuery)}. Note: the results
     * of this type of execution may be incorrect if dirty state exists!
     * Execution errors are throw as an {@link MQLExecutionException} and should
     * not occur during normal operation.
     */
    public MQLResultSet executeIgnoringDirtyState( MQLQuery query ) throws MQLExecutionException, MQLFormatException {

        if ( false ) {
            return executeInternal( query, false, false, null, null, -1 );
        }
        throw new MQLNotSupportedException( MQLApiMessages.IGNOREDIRTY_NOT_SUPPORTED );
    }

    /*
     * JMX Stuff
     */

    private void registerMBean( ) {

        try {
            String sessionId = this.conn.getId( );
            if ( sessionId != null ) {
                int pos = sessionId.indexOf( '-' );
                if ( pos != -1 ) {
                    String connId = sessionId.substring( pos + 1 );
                    sessionId = sessionId.substring( 0, pos );
                    this.objectName = new ObjectName( MOIN_DOMAIN + "type=MqlProcessor,moin=" + this.conn.getSession( ).getMoin( ).getId( ) + ",session=" + sessionId + ",connection=" + connId ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                }
            } else {
                // Mock connection... yuck!
                this.objectName = new ObjectName( MOIN_DOMAIN + "type=MqlProcessor,moin=" + this.conn.getSession( ).getMoin( ).getId( ) + ",session=" + System.identityHashCode( this.conn.getSession( ) ) + ",connection=" + System.identityHashCode( this.conn ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            }
        } catch ( MalformedObjectNameException e ) {
            throw new RuntimeException( e );
        } catch ( NullPointerException e ) {
            throw new RuntimeException( e );
        }
        this.jmxAdapter = new JmxAdapter( this, this.objectName, this.conn.getSession( ).getMoin( ).getReferenceQueue( ) );
    }

    public void leafQueryExecuted( String selectExpression, long duration ) {

        this.jmxAdapter.leafQueryExecuted( selectExpression, duration );
    }

    public ObjectName getObjectName( ) {

        return this.objectName;
    }

    private static final class JmxAdapter extends NotificationBroadcasterSupport implements MqlProcessorMBean {

        private static final CompositeType compositeTypeForQueryIssues;

        private static final TabularType tabularTypeForQueryIssues;

        static {
            try {
                compositeTypeForQueryIssues = new CompositeType( "QueryIssueInfo", "QueryIssueInfo", new String[] { "1: Severity", "2: Text" }, new String[] { "1: Severity", "2: Text" }, new OpenType[] { SimpleType.STRING, SimpleType.STRING } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
                tabularTypeForQueryIssues = new TabularType( "QueryIssues", "Errors and warnings of MQL concrete syntax", compositeTypeForQueryIssues, new String[] { "1: Severity" } ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            } catch ( OpenDataException e ) {
                throw new RuntimeException( e ); // not expected to occur
            }
        }

        /**
         * Sequence number if JMX notifications need to be emitted.
         */
        private AtomicLong seqNo = new AtomicLong( 0 );

        private final WeakReferenceWithObjectName<MQLProcessorImpl> mqlProcessorRef;

        private final ObjectName objectName;

        private final String processorId;

        @SuppressWarnings( "unchecked" )
        JmxAdapter( MQLProcessorImpl processor, ObjectName objectName, ReferenceQueue refQueue ) {

            this.objectName = objectName;
            this.mqlProcessorRef = new WeakReferenceWithObjectName<MQLProcessorImpl>( processor, objectName, refQueue );
            registerBroadcastingMBean( this, MqlProcessorMBean.class, objectName );
            this.processorId = "Session=" + objectName.getKeyProperty( "session" ) + ",Connection=" + objectName.getKeyProperty( "connection" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        }

        @Override
        public MBeanNotificationInfo[] getNotificationInfo( ) {

            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( MqlProcessorMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by an MQLProcessor MBean" ) }; //$NON-NLS-1$
            return notifsInfo;
        }

        public void startNotifications( ) throws IOException {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                processor.jmxNotificationsEnabled = true;
            }
        }

        public boolean notificationsStarted( ) throws IOException {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                return processor.jmxNotificationsEnabled;
            }
            return false;
        }

        public void stopNotifications( ) throws IOException {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                processor.jmxNotificationsEnabled = false;
            }
        }

        public void mqlFormatError( String concreteSyntax, ProcessReport report ) {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                StringBuilder message = new StringBuilder( );
                message.append( "Failed to parse MQL concrete syntax string:\n\n" ).append( concreteSyntax ).append( "\n\n" ).append( report.toString( ) ); //$NON-NLS-1$//$NON-NLS-2$
                Notification notification = new Notification( MqlProcessorMBean.MQL_FORMAT_ERROR, this.objectName, this.seqNo.incrementAndGet( ), message.toString( ) );
                notification.setUserData( this.processorId );
                this.sendNotification( notification );
            }
        }

        public void queryPrepareStart( StackTraceElement[] stackTrace ) {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                Notification notification = new Notification( MqlProcessorMBean.QUERY_PREPARE_START, this.objectName, this.seqNo.incrementAndGet( ), this.processorId );
                notification.setUserData( stackTrace );
                this.sendNotification( notification );
            }
        }

        public void queryPrepareEnd( String msg, long duration ) {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                Notification notification = new Notification( MqlProcessorMBean.QUERY_PREPARE_END, this.objectName, this.seqNo.incrementAndGet( ), msg );
                if ( duration > 0 ) {
                    notification.setUserData( "Time=" + duration + "ms" ); //$NON-NLS-1$//$NON-NLS-2$
                }
                this.sendNotification( notification );
            }
        }

        public void queryExecuteStart( StackTraceElement[] stackTrace ) {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                Notification notification = new Notification( MqlProcessorMBean.QUERY_EXECUTE_START, this.objectName, this.seqNo.incrementAndGet( ), this.processorId );
                notification.setUserData( stackTrace );
                this.sendNotification( notification );
            }
        }

        public void queryExecuteEnd( String msg, long duration, MQLResultSet resultSet ) {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                String message = msg;
                if ( resultSet.getSize( ) > 0 ) {
                    StringBuilder _message = new StringBuilder( msg );
                    _message.append( "\n\nResultSet:\n\n" ).append( resultSet.toString( ) ); //$NON-NLS-1$
                    message = _message.toString( );
                }
                Notification notification = new Notification( MqlProcessorMBean.QUERY_EXECUTE_END, this.objectName, this.seqNo.incrementAndGet( ), message );
                StringBuilder userData = new StringBuilder( );
                if ( duration > 0 ) {
                    userData.append( "Time=" ).append( duration ).append( "ms," ); //$NON-NLS-1$//$NON-NLS-2$
                }
                userData.append( "ResultSetSize=" ).append( resultSet.getSize( ) ); //$NON-NLS-1$
                notification.setUserData( userData.toString( ) );
                this.sendNotification( notification );
            }
        }

        public void leafQueryExecuted( String msg, long duration ) {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                Notification notification = new Notification( MqlProcessorMBean.LEAF_QUERY_EXECUTED, this.objectName, this.seqNo.incrementAndGet( ), msg );
                if ( duration > 0 ) {
                    notification.setUserData( "Time=" + duration + "ms" ); //$NON-NLS-1$//$NON-NLS-2$
                }
                this.sendNotification( notification );
            }
        }

        public TabularData query( String mqlString ) throws IOException {

            MQLProcessorImpl processor = this.mqlProcessorRef.get( );
            if ( processor != null ) {
                try {
                    processor.syncManager.acquireReadLock( );
                    try {
                        MQLPreparedQuery preparedQuery = null;
                        try {
                            preparedQuery = processor.prepare( mqlString );
                        } catch ( MQLFormatException ex ) {
                            return getErrorOrWarning( Severity.ERROR, ex.getPreparationReport( ).toString( ) );
                        } catch ( Exception ex ) {
                            return getErrorOrWarning( Severity.ERROR, getExceptionAsString( ex ) );
                        }
                        try {
                            long duration = System.nanoTime( );
                            MQLResultSet resultSet = processor.execute( preparedQuery );
                            duration = ( System.nanoTime( ) - duration ) / 1000000;
                            return computeTabularData( resultSet, duration );
                        } catch ( Exception ex ) {
                            return getErrorOrWarning( Severity.ERROR, getExceptionAsString( ex ) );
                        }
                    } finally {
                        processor.syncManager.releaseReadLock( );
                    }
                } catch ( RuntimeException e ) {
                    throw e;
                } catch ( Exception e ) {
                    throw new RuntimeException( e );
                }
            }
            return null;
        }

        private enum Severity {
            ERROR, WARNING
        }

        @SuppressWarnings( "unchecked" )
        private TabularData getErrorOrWarning( Severity severity, String message ) {

            TabularData result = new TabularDataSupport( tabularTypeForQueryIssues );
            Map rows = new HashMap( );
            rows.put( "1: Severity", severity.toString( ) ); //$NON-NLS-1$
            rows.put( "2: Text", message ); //$NON-NLS-1$
            CompositeDataSupport compositeData;
            try {
                compositeData = new CompositeDataSupport( compositeTypeForQueryIssues, rows );
            } catch ( OpenDataException ex ) {
                throw new RuntimeException( ex );
            }
            result.put( compositeData );
            return result;
        }

        @SuppressWarnings( "unchecked" )
        private TabularData computeTabularData( MQLResultSet resultSet, long duration ) {

            MQLColumnType[] queryColumnTypes = resultSet.getQueryColumnTypes( );
            List<String> itemNamesList = new ArrayList<String>( );
            List<String> itemDescriptionList = new ArrayList<String>( );
            List<OpenType> itemTypesList = new ArrayList<OpenType>( );
            for ( int i = 0; i < queryColumnTypes.length; i++ ) {
                MQLColumnType columnType = queryColumnTypes[i];
                if ( columnType.attribute == null ) {
                    itemNamesList.add( i + columnType.alias );
                    itemDescriptionList.add( "MRI" ); //$NON-NLS-1$
                    itemTypesList.add( SimpleType.STRING );
                } else {
                    itemNamesList.add( i + columnType.alias + "." + columnType.attribute ); //$NON-NLS-1$
                    if ( columnType.multiValued ) {
                        String description = null;
                        if ( columnType.isOrdered ) {
                            description = "LIST&lt;" + columnType.typeName + "&gt;"; //$NON-NLS-1$ //$NON-NLS-2$
                        } else {
                            description = "COLLECTION&lt;" + columnType.typeName + "&gt;"; //$NON-NLS-1$ //$NON-NLS-2$
                        }
                        if ( columnType.isUnique ) {
                            description += ", UNIQUE"; //$NON-NLS-1$
                        }
                        itemDescriptionList.add( description );
                    } else {
                        itemDescriptionList.add( columnType.typeName );
                    }
                    itemTypesList.add( SimpleType.STRING );
                }
            }
            itemNamesList.add( "DUMMY" ); //$NON-NLS-1$
            itemDescriptionList.add( "Dummy column for keeping the insertion order" ); //$NON-NLS-1$
            itemTypesList.add( SimpleType.INTEGER );
            try {
                String[] itemNames = itemNamesList.toArray( new String[itemNamesList.size( )] );
                String[] itemDescriptions = itemDescriptionList.toArray( new String[itemDescriptionList.size( )] );
                OpenType[] itemTypes = itemTypesList.toArray( new OpenType[itemTypesList.size( )] );
                CompositeType compositeType = new CompositeType( "ResultSetInfo", "ResultSetInfo", itemNames, itemDescriptions, itemTypes ); //$NON-NLS-1$ //$NON-NLS-2$
                StringBuilder tabDescription = new StringBuilder( );
                tabDescription.append( duration ).append( "###" ).append( resultSet.getSize( ) ); //$NON-NLS-1$
                if ( resultSet.getSize( ) > 0 ) {
                    StringWriter writer = new StringWriter( );
                    resultSet.asCSV( writer );
                    tabDescription.append( "###" ).append( writer.toString( ) ); //$NON-NLS-1$
                }
                TabularType tabularType = new TabularType( "ResultSetContent", tabDescription.toString( ), compositeType, itemNames ); //$NON-NLS-1$
                TabularData result = new TabularDataSupport( tabularType );
                for ( int i = 0; i < resultSet.getSize( ); i++ ) {
                    Map rowData = new HashMap( );
                    rowData.put( "DUMMY", i ); //$NON-NLS-1$
                    for ( int j = 0; j < itemNames.length - 1; j++ ) {
                        if ( queryColumnTypes[j].attribute == null ) {
                            rowData.put( itemNames[j], resultSet.getMri( i, queryColumnTypes[j].alias ).toString( ) );
                        } else {
                            Object value = resultSet.getAttribute( i, queryColumnTypes[j].alias, queryColumnTypes[j].attribute );
                            if ( value instanceof Object[] ) {
                                Object[] values = (Object[]) value;
                                StringBuilder data = new StringBuilder( "[" ); //$NON-NLS-1$
                                for ( int k = 0; k < values.length; k++ ) {
                                    data.append( String.valueOf( values[k] ) );
                                    if ( k < values.length - 1 ) {
                                        data.append( ',' );
                                    }
                                }
                                data.append( ']' );
                                rowData.put( itemNames[j], data.toString( ) );
                            } else {
                                rowData.put( itemNames[j], String.valueOf( value ) );
                            }
                        }
                    }
                    CompositeDataSupport compositeData = new CompositeDataSupport( compositeType, rowData );
                    result.put( compositeData );
                }
                return result;
            } catch ( OpenDataException e ) {
                throw new RuntimeException( e );
            }
        }

    }
}
