/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/*
 * Created on 30.01.2006
 */
package org.eclipse.emf.query2.internal.moinql.controller;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.management.ObjectName;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.query.QueryCommandWithResult;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryExecutionException;
import org.eclipse.emf.query2.QueryFormatException;
import org.eclipse.emf.query2.QueryPreprocessorException;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.TypeScopeProvider;
import org.eclipse.emf.query2.internal.bql.engine.BasicQueryProcessorMemoryEstimationImpl;
import org.eclipse.emf.query2.internal.bql.engine.BasicQueryProcessorMemoryImpl;
import org.eclipse.emf.query2.internal.fql.SpiFacilityQueryLanguage;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.messages.ApiMessages;
import org.eclipse.emf.query2.internal.messages.FQLTraceMessages;
import org.eclipse.emf.query2.internal.moinql.ast.InternalQuery;
import org.eclipse.emf.query2.internal.moinql.ast.PreparedQuery;
import org.eclipse.emf.query2.internal.moinql.engine.InterpreterImpl;
import org.eclipse.emf.query2.internal.moinql.engine.Scheduler;
import org.eclipse.emf.query2.internal.moinql.engine.SchedulerImpl;
import org.eclipse.emf.query2.internal.moinql.parser.MqlParser;
import org.eclipse.emf.query2.internal.moinql.preprocessor.Expander;
import org.eclipse.emf.query2.internal.moinql.preprocessor.ExpanderImpl;
import org.eclipse.emf.query2.internal.moinql.preprocessor.FacilityAssigner;
import org.eclipse.emf.query2.internal.moinql.preprocessor.FacilityAssignerImpl;
import org.eclipse.emf.query2.internal.moinql.preprocessor.TypeCheckerImpl;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.EmfHelper;
import org.eclipse.emf.query2.report.ProcessReport;
import org.eclipse.emf.query2.report.ProcessReportImpl;
import org.eclipse.emf.query2.report.ProcessWarning;

/**
 * This is the controller class for the MQL Processor. It is the implementation
 * of the MQL service exported to clients.
 */
public class QueryProcessorImpl implements QueryProcessor {

	// trace setup
	private static final QueryLogger logger = LoggerFactory.getLogger(QueryProcessorImpl.class);

	// important constants
	private static final int MAX_NUMBER_OF_ERRORS = 100;

	private static final int DEFAULT_MAX_RESULT_SET_SIZE = 10000;

	private static final int DEFAULT_THRESHOLD_FOR_NUMBER_OF_RELEVANT_PARTITIONS = 20;

	private static final int DEFAULT_THRESHOLD_FOR_NUMBER_OF_ELEMENTS_IN_PARTITION = 500;

	/**
	 * We keep a parser for the MQL concrete syntax
	 */
	// private MqlParser mqlParser; // FIXME sync fix
	/**
	 * Synchronization manager
	 */
	// protected SynchronizationManager syncManager;
	/**
	 * We keep the memory FQL processor
	 */
	private SpiFacilityQueryLanguage memoryFQLProcessor;

	/**
	 * A MQL processor maintains a registry of FQL processors per facility
	 */
	// private Map<String, SpiFacilityQueryLanguage> fqlProcessors;
	/**
	 * An MQL processor instance is provided per connection, which the
	 * MQLProcessor has to keep a reference to
	 */
	// protected CoreConnection conn;
	/**
	 * We need MOIN as well
	 */
	// private EmfHelper emfHelper;
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
	// private JmxAdapter jmxAdapter;
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
	private Expander mqlExpander;

	/**
	 * The MQL facility assigned spreads the query over multiple facilities
	 */
	private FacilityAssigner mqlFacilityAssigner;

	/**
	 * We need a bunch of auxiliar services too
	 */
	private AuxServices mqlAuxServices;

	private final Index index;

	/**
	 * The data areas relevant for the session
	 */
	// private Set<DataAreaDescriptor> sessionRelevantDataAreaDescriptors;
	public QueryProcessorImpl(Index index) {
		// public MQLProcessorImpl(ResourceSet rs,
		// Collection<SpiMQLQueryService> queryServices) {

		this.index = index;
		if (logger.isTraced(LogSeverity.INFO)) {
			// logger.trace( MoinSeverity.INFO,
			// FQLTraceMessages.MQL_PROCESSOR_OBTAINED_FOR_CONNECTION,
			// conn.getId( ) );
		}
		// connection
		// this.conn = (CoreConnection) conn;
		// this.emfHelper = new EmfHelper(rs, queryServices);

		// parser
		// this.mqlParser = new MqlParser( MAX_NUMBER_OF_ERRORS, this.moin ); //
		// FIXME sync fix

		// sync manager
		// this.syncManager = this.emfHelper.getSynchronizationManager( );

		// transformation service
		this.mqlAuxServices = new AuxServices();

		// set the one memory implementation, which is always used for
		// scheduling
		this.memoryFQLProcessor = new BasicQueryProcessorMemoryImpl();

		// initialize the FQL registry
		// this.fqlProcessors = new HashMap<String,
		// SpiFacilityQueryLanguage>(queryServices.size());

		// // register all assigned SpiMQLQueryServices,
		// for (SpiMQLQueryService queryService : queryServices) {
		//
		// // depending on the type of query language, we have to construct a
		// // full facility query language with core means
		// SpiFacilityQueryLanguage fql = null;
		// if (queryService instanceof SpiFacilitySlimVariantIndexQueryService)
		// {
		// fql = new
		// BasicQueryProcessorMemoryEstimationVariantImpl((SpiFacilitySlimVariantIndexQueryService)
		// queryService);
		// if (logger.isTraced(MoinSeverity.INFO)) {
		// // logger.trace( MoinSeverity.INFO,
		// //
		// FQLTraceMessages.MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_SLIM_VARIANT_INDEX_FOR_FACILITY,
		// // queryService.getFacilityId( ), this.conn.getId( ) );
		// }
		// } else if (queryService instanceof SpiFacilitySlimIndexQueryService)
		// {
		// fql = new
		// BasicQueryProcessorMemoryEstimationImpl((SpiFacilitySlimIndexQueryService)
		// queryService);
		// if (logger.isTraced(MoinSeverity.INFO)) {
		// // logger.trace( MoinSeverity.INFO,
		// //
		// FQLTraceMessages.MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_SLIM_INDEX_FOR_FACILITY,
		// // queryService.getFacilityId( ), this.conn.getId( ) );
		// }
		// // } else if ( queryService instanceof
		// // SpiFacilityFullIndexQueryService ) {
		// // // currently no support
		// // if ( logger.isTraced( MoinSeverity.INFO ) ) {
		// // // logger.trace( MoinSeverity.INFO,
		// //
		// FQLTraceMessages.MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_FULL_INDEX_FOR_FACILITY,
		// // queryService.getFacilityId( ), this.conn.getId( ) );
		// // }
		// // throw new MQLNotSupportedException(
		// // MQLApiMessages.FIFQL_NOT_SUPPORTED );
		// } else if (queryService instanceof SpiFacilityQueryLanguage) {
		// fql = (SpiFacilityQueryLanguage) queryService;
		// if (logger.isTraced(MoinSeverity.INFO)) {
		// // logger.trace( MoinSeverity.INFO,
		// //
		// FQLTraceMessages.MQL_PROCESSOR_REGISTERING_MQLQUERYSERVICE_BASED_ON_THE_FACILITY_QUERY_LANGUAGE_FOR_FACILITY,
		// // queryService.getFacilityId( ), this.conn.getId( ) );
		// }
		// } else {
		// // unknown Query Language
		// throw new
		// MQLNotSupportedException(MQLApiMessages.UNKNOWN_FACILITY_QUERY_LANGUAGE);
		// }
		//
		// // sanity checks
		// if
		// (fql.getFacilityId().equals(this.memoryFQLProcessor.getFacilityId()))
		// {
		// throw new
		// MQLBugException(MQLBugMessages.MEMORY_FQL_USED_IN_FACILITY);
		// }
		// if (this.fqlProcessors.containsKey(fql.getFacilityId())) {
		// throw new
		// MQLBugException(MQLBugMessages.MORE_THAN_ONE_FQL_PER_FACILITY);
		// }
		//
		// // register
		// this.fqlProcessors.put(fql.getFacilityId(), fql);
		// }
		//
		// if (this.fqlProcessors.size() == 0) {
		// // no facility query service registered at all
		// // throw new MQLExecutionException(
		// // MQLApiMessages.NO_QUERY_SERVICE_FOUND );
		// }

		/* remember session relevant data areas for creating the scheduler */
		// this.sessionRelevantDataAreaDescriptors = sessionRelevantDataAreas;
		/* obtain an expander for the connection */
		this.mqlExpander = new ExpanderImpl(this.mqlAuxServices);

		/* obtain an assigner for the connection */
		this.mqlFacilityAssigner = new FacilityAssignerImpl(this.mqlAuxServices);

		// if (JMX_ENABLED) {
		// this.registerMBean();
		// }

	}

	/*
	 * The scheduler uses certain thresholds to perform a certain optimization.
	 * These methods permit them to be turned on/off. This is mainly for testing
	 * purposes
	 */

	public void turnOffOptimizationForElementsDuringScheduling() {

		this.thresholdForNumberOfElementsInPartitionForOptimization = 0;
	}

	public void turnOffOptimizationForPartitionsDuringScheduling() {

		this.thresholdForNumberOfRelevantPartitionsForOptimization = 0;
	}

	public void turnOnOptimizationDuringScheduling() {

		this.thresholdForNumberOfElementsInPartitionForOptimization = DEFAULT_THRESHOLD_FOR_NUMBER_OF_ELEMENTS_IN_PARTITION;
		this.thresholdForNumberOfRelevantPartitionsForOptimization = DEFAULT_THRESHOLD_FOR_NUMBER_OF_RELEVANT_PARTITIONS;
	}

	/**
	 * This method parses and then prepares the query
	 */
	private PreparedQuery prepareInternal(String query, QueryContext context, EmfHelper emfHelper) throws QueryFormatException {

		if (logger.isTraced(LogSeverity.INFO)) {
			logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_PREPARATION_START_CST);
		}

		Query parsedQuery = null;
		MqlParser mqlParser = new MqlParser(MAX_NUMBER_OF_ERRORS, emfHelper);

		try {
			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_SYNTACTIC_PARSING_OF_CST_QUERY, "\n", query.toString()); //$NON-NLS-1$
			}

			parsedQuery = mqlParser.parse(query, this);

		} catch (QueryFormatException e) {
			if (logger.isTraced(LogSeverity.ERROR)) {
				logger.trace(LogSeverity.ERROR, FQLTraceMessages.MQL_PROCESSOR_QUERY_DOES_NOT_PARSE, "\n", query, "\n"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			throw e;
		}

		return this.prepareInternal(parsedQuery, mqlParser.getReport(), context, emfHelper);
	}

	/**
	 * This method prepares an MQL AST Query
	 */
	private PreparedQuery prepareInternal(Query query, ProcessReport report, QueryContext context, EmfHelper emfHelper) throws QueryPreprocessorException {

		if (logger.isTraced(LogSeverity.INFO)) {
			logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_PREPARATION_START_AST);
		}
		InternalQuery internalQuery = null;

		// if (JMX_ENABLED && this.jmxNotificationsEnabled) {
		// this.jmxAdapter.queryPrepareStart(Thread.currentThread().getStackTrace());
		// }

		long timeStamp = System.nanoTime();

		try {

			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_TYPE_AND_FORMAT_CHECKING_OF_AST_QUERY, "\n", query); //$NON-NLS-1$
			}

			/* Type and Format Checking */
			/* -------------------------- */

			/*
			 * convert the query into the internal structure and check for
			 * format and type errors
			 */
			TypeCheckerImpl typeChecker = new TypeCheckerImpl(emfHelper);
			internalQuery = typeChecker.convert(query, report);
			// internalQuery = this.mqlTypeChecker.convert( query, report ); //
			// FIXME sync fix
			// possibly, the type checker found problems, in which case we have
			// to abort already only warnings keep living
			if (report.getProcessStatus() == ProcessReport.FAILED) {
				if (logger.isTraced(LogSeverity.ERROR)) {
					logger.trace(LogSeverity.ERROR, FQLTraceMessages.MQL_PROCESSOR_THE_FOLLOWING_QUERY_HAS_TYPE_ERRORS, "\n", query); //$NON-NLS-1$
				}
				// if we had type check errors, we stop
				throw new QueryFormatException(report);
			}

			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_FURTHER_PRE_PROCESSING_OF_INTERNAL_QUERY, "\n", internalQuery); //$NON-NLS-1$
			}

			/* Expanding */
			/* ----------- */

			/* expand so it can be executed by the mixer */
			internalQuery = this.mqlExpander.expand(internalQuery);

			/* Assigning */
			/* ----------- */

			/* assign the different BQL processors (if they exist) */
			internalQuery = this.mqlFacilityAssigner.assign(internalQuery, Collections.singletonList((SpiFacilityQueryLanguage) new BasicQueryProcessorMemoryEstimationImpl(
					this.index)));

			/*
			 * Before releasing the query as prepared, remove possible empty
			 * parts
			 */
			internalQuery = this.mqlAuxServices.reduceQueryAfterScopeChanges(internalQuery);

		} catch (QueryPreprocessorException e) {

			if (logger.isTraced(LogSeverity.ERROR)) {
				logger.trace(LogSeverity.ERROR, FQLTraceMessages.MQL_PROCESSOR_QUERY_PREPARATION_ABORTED, "\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
			throw e;

		} finally {
			long queryTime = (System.nanoTime() - timeStamp) / 1000000;

			// we are done with the preprocessing
			report.reportCompletion();

			// provide the report in the prepared query
			if (internalQuery != null) {
				internalQuery.setReport(report);
			}

			// report warnings if there were any
			if (logger.isTraced(LogSeverity.WARNING)) {
				if (report.getProcessStatus() == ProcessReport.SUCCESSFUL_WITH_WARNINGS) {
					List<ProcessWarning> warnings = report.getWarnings();
					logger.trace(LogSeverity.WARNING, FQLTraceMessages.MQL_PROCESSOR_FOUND_WARNINGS_DURING_PREPARATION_OF_THE_FOLLOWING_QUERY,
							"\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
					for (ProcessWarning warning : warnings) {
						logger.trace(LogSeverity.WARNING, warning.getMessage());
					}
				}
			}

			// if (JMX_ENABLED && this.jmxNotificationsEnabled) {
			//				this.jmxAdapter.queryPrepareEnd((internalQuery == null ? "NULL query" : internalQuery.toString()), queryTime); //$NON-NLS-1$
			// }

			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_PREPARATION_FINISHED, queryTime, "\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}

			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_PREPARATION_STOP);
			}
		}

		return internalQuery;
	}

	/**
	 * Execution method
	 */
	private ResultSet executeInternal(final PreparedQuery preparedQuery, final EmfHelper emfHelper, final boolean schedulingWanted, final boolean globalScopeIncluded,
			final QueryContext scopeProvider, final URI[] globalContainerScope, final int numberOfResults) throws QueryExecutionException {
		QueryCommandWithResult<ResultSet> command = new QueryCommandWithResult<ResultSet>() {

			public void execute(QueryExecutor queryExecutor) {
				this.setResult(executeSecuredInternal(preparedQuery, emfHelper, schedulingWanted, globalScopeIncluded, scopeProvider.getResourceScope(), globalContainerScope,
						numberOfResults));
			}
		};
		emfHelper.getIndex().executeQueryCommand(command);
		return command.getResult();
	}

	private ResultSet executeSecuredInternal(PreparedQuery preparedQuery, EmfHelper emfHelper, boolean schedulingWanted, boolean globalScopeIncluded, URI[] globalPartitionScope,
			URI[] globalContainerScope, int numberOfResults) throws QueryExecutionException {

		emfHelper.createDirtyIndex();

		if (logger.isTraced(LogSeverity.INFO)) {
			logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_EXECUTION_START);
		}

		ResultSet result = null;

		// if (JMX_ENABLED && this.jmxNotificationsEnabled) {
		// this.jmxAdapter.queryExecuteStart(Thread.currentThread().getStackTrace());
		// }

		long timeStamp = System.nanoTime();

		InternalQuery internalQuery = (InternalQuery) preparedQuery;

		try {

			// We want to assure that no other threads can write and this also
			// avoid the eviction manager from changing anything. At best, more
			// partitions are loaded, which is safe
			// this.syncManager.acquireReadLock( );
			try {
				if (logger.isTraced(LogSeverity.INFO)) {
					logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_SCHEDULING_QUERY, "\n", internalQuery); //$NON-NLS-1$
				}

				/* schedule the prepared query for execution */
				Scheduler scheduler = new SchedulerImpl(emfHelper, this.memoryFQLProcessor, this.mqlAuxServices);
				internalQuery = scheduler.schedule(internalQuery, schedulingWanted, globalScopeIncluded, globalPartitionScope, globalContainerScope,
						this.thresholdForNumberOfRelevantPartitionsForOptimization, this.thresholdForNumberOfElementsInPartitionForOptimization);
				// System.err.println(internalQuery);
				if (logger.isTraced(LogSeverity.INFO)) {
					logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_INTERPRETING_QUERY, "\n", internalQuery); //$NON-NLS-1$
				}

				/* execute the internal query */
				InterpreterImpl interpreter = new InterpreterImpl(emfHelper, this.memoryFQLProcessor, this, this.mqlAuxServices);
				result = interpreter.execute(internalQuery, this.maxResultSetSize, numberOfResults);
			} finally {
				// we're done. Release
				// this.syncManager.releaseReadLock( );
			}

			if (logger.isTraced(LogSeverity.DEBUG)) {
				logger.trace(LogSeverity.DEBUG, FQLTraceMessages.MQL_PROCESSOR_QUERY_PRODUCED_RESULT_SET, "\n", internalQuery, "\n", "\n", result); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}

		} catch (QueryExecutionException e) {
			if (logger.isTraced(LogSeverity.ERROR)) {
				logger.trace(LogSeverity.ERROR, FQLTraceMessages.MQL_PROCESSOR_ABORTED_EXECUTION_OF_QUERY, "\n", (internalQuery == null ? "NULL query" : internalQuery)); //$NON-NLS-1$ //$NON-NLS-2$
			}
			throw e;

		} finally {

			long queryTime = (System.nanoTime() - timeStamp) / 1000000;

			// if (JMX_ENABLED && this.jmxNotificationsEnabled) {
			//				this.jmxAdapter.queryExecuteEnd((internalQuery == null ? "NULL query" : internalQuery.toString()), queryTime, result); //$NON-NLS-1$
			// }

			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_QUERY_EXECUTION_FINISHED, queryTime);
			}

			if (logger.isTraced(LogSeverity.INFO)) {
				logger.trace(LogSeverity.INFO, FQLTraceMessages.MQL_PROCESSOR_EXECUTION_STOP);
			}

		}

		return result;
	}

	/**
	 * This method first prepares and then executes the query (convenience)
	 */
	private ResultSet executeInternal(Query selectQuery, QueryContext context, boolean schedulingWanted, URI[] globalContainerScope, int numberOfResults)
			throws QueryExecutionException, QueryFormatException {

		// first prepare and then immediately execute the provided query
		EmfHelper emfHelper = this.getEmfHelper(context);
		PreparedQuery preparedQuery = null;
		try {
			preparedQuery = this.prepareInternal(selectQuery, new ProcessReportImpl(MAX_NUMBER_OF_ERRORS), context, emfHelper);
		} catch (QueryPreprocessorException e) {
			if (e instanceof QueryFormatException) {
				throw e;
			}
			// we wrap all non-FormatExceptions exception as an execution
			// exception
			throw new QueryExecutionException(e, ApiMessages.MQL_PREPROCESSOR_PROBLEM);
		}

		return this.executeInternal(preparedQuery, emfHelper, schedulingWanted, true, context, globalContainerScope, numberOfResults);
	}

	/*
	 * Public methods
	 */

	// public MQLPreparedQuery prepare(MQLQuery query) throws
	// MQLPreprocessorException {
	//
	// return this.prepareInternal(query, new
	// ProcessReportImpl(MAX_NUMBER_OF_ERRORS));
	// }
	//
	// public MQLPreparedQuery prepare(String query) throws
	// MQLPreprocessorException {
	//
	// return this.prepareInternal(query);
	// }
	//
	// public MQLResultSet execute(MQLPreparedQuery preparedQuery) throws
	// MQLExecutionException {
	//
	// return this.executeInternal(preparedQuery, true, false, null, null, -1);
	// }
	//
	// public MQLResultSet execute(MQLQuery query) throws MQLExecutionException,
	// MQLFormatException {
	//
	// return this.executeInternal(query, true, false, null, null, -1);
	// }
	//
	// public MQLResultSet execute(String query) throws MQLExecutionException,
	// MQLFormatException {
	//
	// MQLPreparedQuery preparedQuery = this.prepareInternal(query);
	// return this.executeInternal(preparedQuery, true, false, null, null, -1);
	// }
	//
	// public MQLResultSet execute(MQLPreparedQuery query, QueryScopeProvider
	// scopeProvider) throws MQLExecutionException {
	//
	// return this.executeInternal(query, true,
	// scopeProvider.isInclusiveScope(), scopeProvider.getPartitionScope(),
	// null, -1);
	// }
	public ResultSet execute(Query query, QueryContext scopeProvider) throws QueryExecutionException, QueryFormatException {
		// public MQLResultSet execute(MQLQuery query, QueryScopeProvider
		// scopeProvider) throws MQLExecutionException, MQLFormatException {

		return this.executeInternal(query, scopeProvider, true, null, -1);
	}

	public ResultSet execute(String query, QueryContext scopeProvider) throws QueryExecutionException, QueryFormatException {

		return this.execute(query, scopeProvider, -1);
	}

	private EmfHelper getEmfHelper(QueryContext context) {
		return new EmfHelper(context, this.index);
	}

	// public MQLResultSet execute(MQLPreparedQuery query, int numberOfResults)
	// throws MQLExecutionException {
	//
	// return this.executeInternal(query, true, false, null, null,
	// numberOfResults);
	// }
	//
	// public MQLResultSet execute(MQLQuery query, int numberOfResults) throws
	// MQLExecutionException, MQLFormatException {
	//
	// return this.executeInternal(query, true, false, null, null,
	// numberOfResults);
	// }
	//
	// public MQLResultSet execute(String query, int numberOfResults) throws
	// MQLExecutionException, MQLFormatException {
	//
	// MQLPreparedQuery preparedQuery = this.prepareInternal(query);
	// return this.executeInternal(preparedQuery, true, false, null, null,
	// numberOfResults);
	// }
	//
	// public MQLResultSet execute(MQLPreparedQuery query, QueryScopeProvider
	// scopeProvider, int numberOfResults) throws MQLExecutionException {
	//
	// return this
	// .executeInternal(query, true, scopeProvider.isInclusiveScope(),
	// scopeProvider.getPartitionScope(), null, numberOfResults);
	// }

	public ResultSet execute(Query query, QueryContext scopeProvider, int numberOfResults) throws QueryExecutionException, QueryFormatException {
		// public MQLResultSet execute(MQLQuery query, QueryScopeProvider
		// scopeProvider, int numberOfResults) throws MQLExecutionException,
		// MQLFormatException {

		return this.executeInternal(query, scopeProvider, true, null, numberOfResults);
	}

	public ResultSet execute(String query, QueryContext scopeProvider, int numberOfResults) throws QueryExecutionException, QueryFormatException {

		EmfHelper emfHelper = this.getEmfHelper(scopeProvider);
		PreparedQuery preparedQuery = this.prepareInternal(query, scopeProvider, emfHelper);
		return this.executeInternal(preparedQuery, emfHelper, true, true, scopeProvider, null, numberOfResults);
	}

	// public QueryScopeProvider getGlobalQueryScopeProvider() {
	//
	// QueryScopeProvider queryScopeProvider = new QueryScopeProvider() {
	//
	// public boolean isInclusiveScope() {
	//
	// return false;
	// }
	//
	// // public URI[] getContainerScope( ) {
	// //
	// // return new URI[0];
	// // }
	//
	// public URI[] getPartitionScope() {
	//
	// return new URI[0];
	// }
	// };
	//
	// return queryScopeProvider;
	// }
	//
	public TypeScopeProvider getQueryScopeProvider(final boolean scopeInclusive, final URI[] partitionScope) {

		TypeScopeProvider queryScopeProvider = new TypeScopeProvider() {

			public boolean isInclusiveScope() {

				return scopeInclusive;
			}

			// public URI[] getContainerScope( ) {
			//
			// if ( containerScope == null ) {
			// return new URI[0];
			// } else {
			// return containerScope;
			// }
			// }

			public URI[] getPartitionScope() {

				if (partitionScope == null) {
					return new URI[0];
				} else {
					return partitionScope;
				}
			}
		};

		return queryScopeProvider;
	}

	//
	// // public QueryScopeProvider getQueryScopeProvider( final boolean
	// // scopeInclusive, final URI[] partitionScope, final String[]
	// containerScope
	// // ) {
	// //
	// // QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {
	// //
	// // public boolean isInclusiveScope( ) {
	// //
	// // return scopeInclusive;
	// // }
	// //
	// // public URI[] getContainerScope( ) {
	// //
	// // if ( containerScope == null ) {
	// // return new URI[0];
	// // } else {
	// // return MQLProcessorImpl.this.getCrisForContainerNames( containerScope
	// );
	// // }
	// // }
	// //
	// // public URI[] getPartitionScope( ) {
	// //
	// // if ( partitionScope == null ) {
	// // return new URI[0];
	// // } else {
	// // return partitionScope;
	// // }
	// // }
	// // };
	// //
	// // return queryScopeProvider;
	// // }
	//
	public TypeScopeProvider getQueryScopeProvider(final boolean scopeInclusive, final Set<URI> partitionScope) {

		TypeScopeProvider queryScopeProvider = new TypeScopeProvider() {

			public boolean isInclusiveScope() {

				return scopeInclusive;
			}

			// public URI[] getContainerScope( ) {
			//
			// if ( containerScope == null ) {
			// return new URI[0];
			// } else {
			// return containerScope.toArray( new URI[containerScope.size( )] );
			// }
			// }

			public URI[] getPartitionScope() {

				if (partitionScope == null) {
					return new URI[0];
				} else {
					return partitionScope.toArray(new URI[partitionScope.size()]);
				}
			}
		};

		return queryScopeProvider;
	}

	// public QueryScopeProvider getInclusiveCriScopeProvider( final URI...
	// containerScope ) {
	//
	// QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {
	//
	// public boolean isInclusiveScope( ) {
	//
	// return true;
	// }
	//
	// public URI[] getContainerScope( ) {
	//
	// if ( containerScope == null ) {
	// return new URI[0];
	// } else {
	// return containerScope;
	// }
	// }
	//
	// public URI[] getPartitionScope( ) {
	//
	// return new URI[0];
	// }
	// };
	//
	// return queryScopeProvider;
	// }

	// public QueryScopeProvider getInclusiveVisibleCriScopeProvider( final URI
	// cri ) {
	//
	//
	// QueryScopeProvider queryScopeProvider = new QueryScopeProvider( ) {
	//
	// public boolean isInclusiveScope( ) {
	//
	// return true;
	// }
	//
	// public URI[] getContainerScope( ) {
	//
	// return new URI[0];
	// }
	//
	// public URI[] getPartitionScope( ) {
	//
	// Collection<URI> outerPris = MQLProcessorImpl.this.conn.getSession(
	// ).getOuterPartitions( cri );
	// Collection<URI> innerPris = MQLProcessorImpl.this.conn.getSession(
	// ).getInnerPartitions( cri );
	//
	// URI[] resultPris = new URI[outerPris.size( ) + innerPris.size( ) + 1];
	// int i = 0;
	// for ( Iterator<URI> iterator = innerPris.iterator( ); iterator.hasNext(
	// ); i++ ) {
	// URI pri = iterator.next( );
	// resultPris[i] = pri;
	// }
	// for ( Iterator<URI> iterator = outerPris.iterator( ); iterator.hasNext(
	// ); i++ ) {
	// URI pri = iterator.next( );
	// resultPris[i] = pri;
	// }
	// // add the null-partition
	// resultPris[i] = MQLProcessorImpl.this.conn.getNullPartition( ).getPri( );
	//
	// return resultPris;
	// }
	// };
	//
	// return queryScopeProvider;
	// // }
	//
	// public QueryScopeProvider getInclusiveContainerScopeProvider(final
	// String... containerScope) {
	//
	// QueryScopeProvider queryScopeProvider = new QueryScopeProvider() {
	//
	// public boolean isInclusiveScope() {
	//
	// return true;
	// }
	//
	// public URI[] getContainerScope() {
	//
	// if (containerScope == null) {
	// return new URI[0];
	// } else {
	// return MQLProcessorImpl.this.getCrisForContainerNames(containerScope);
	// }
	// }
	//
	// public URI[] getPartitionScope() {
	//
	// return new URI[0];
	// }
	// };
	//
	// return queryScopeProvider;
	// }

	public TypeScopeProvider getInclusiveQueryScopeProvider(final URI[] partitionScope) {

		TypeScopeProvider queryScopeProvider = new TypeScopeProvider() {

			public boolean isInclusiveScope() {

				return true;
			}

			// public URI[] getContainerScope( ) {
			//
			// if ( containerScope == null ) {
			// return new URI[0];
			// } else {
			// return containerScope;
			// }
			// }

			public URI[] getPartitionScope() {

				if (partitionScope == null) {
					return new URI[0];
				} else {
					return partitionScope;
				}
			}
		};

		return queryScopeProvider;
	}

	public TypeScopeProvider getInclusivePartitionScopeProvider(final URI... partitionScope) {

		TypeScopeProvider queryScopeProvider = new TypeScopeProvider() {

			public boolean isInclusiveScope() {

				return true;
			}

			// public URI[] getContainerScope( ) {
			//
			// return new URI[0];
			// }

			public URI[] getPartitionScope() {

				if (partitionScope == null) {
					return new URI[0];
				} else {
					return partitionScope;
				}
			}
		};

		return queryScopeProvider;
	}

	public TypeScopeProvider getInclusiveQueryScopeProvider(final Set<URI> partitionScope) {

		TypeScopeProvider queryScopeProvider = new TypeScopeProvider() {

			public boolean isInclusiveScope() {

				return true;
			}

			// public URI[] getContainerScope( ) {
			//
			// if ( containerScope == null ) {
			// return new URI[0];
			// } else {
			// return containerScope.toArray( new URI[containerScope.size( )] );
			// }
			// }

			public URI[] getPartitionScope() {

				if (partitionScope == null) {
					return new URI[0];
				} else {
					return partitionScope.toArray(new URI[partitionScope.size()]);
				}
			}
		};

		return queryScopeProvider;
	}

	public int getMaxResultSetSize() {

		return this.maxResultSetSize;
	}

	public void setMaxResultSetSize(int _maxResultSetSize) {

		this.maxResultSetSize = _maxResultSetSize;
	}

	// public URI[] getCrisForContainerNames( String... containerNames ) {
	//
	// Collection<Facility> facilities = this.moin.getFacilities( );
	//
	// Set<URI> cris = new HashSet<URI>( );
	//
	// if ( containerNames != null ) {
	// for ( Facility facility : facilities ) {
	// ResourceIdentifierFactory riFactory = facility.getRIFactory( );
	// Collection<String> dataAreaNames = facility.getDataAreaNames( );
	// for ( String dataAreaName : dataAreaNames ) {
	// for ( String containerName : containerNames ) {
	// cris.add( riFactory.createCri( dataAreaName, containerName ) );
	// }
	// }
	// }
	// }
	//
	// return cris.toArray( new URI[cris.size( )] );
	// }

	// /**
	// * This operation executes the {@link MQLPreparedQuery} <b>without</b>
	// * considering dirty state. It returns a {@link MQLResultSet}. Note: the
	// * results of this type of execution may be incorrect if dirty state
	// exists!
	// * Execution errors are throw as an {@link MQLExecutionException} and
	// should
	// * not occur during normal operation.
	// */
	// public MQLResultSet executeIgnoringDirtyState(MQLPreparedQuery
	// preparedQuery) throws MQLExecutionException {
	//
	// if (false) {
	// return this.executeInternal(preparedQuery, false, false, null, null, -1);
	// }
	// throw new
	// MQLNotSupportedException(MQLApiMessages.IGNOREDIRTY_NOT_SUPPORTED);
	// }
	//
	// /**
	// * This operation executes the {@link MQLQuery} <b>without</b> considering
	// * dirty state. It first prepares the query by means of
	// * {@link #prepare(MQLQuery)} and returns an {@link MQLResultSet}. To
	// avoid
	// * repeated preparation, use {@link #prepare(MQLQuery)} first and then
	// * {@link #executeIgnoringDirtyState(MQLPreparedQuery)}. Note: the results
	// * of this type of execution may be incorrect if dirty state exists!
	// * Execution errors are throw as an {@link MQLExecutionException} and
	// should
	// * not occur during normal operation.
	// */
	// public MQLResultSet executeIgnoringDirtyState(MQLQuery query) throws
	// MQLExecutionException, MQLFormatException {
	//
	// if (false) {
	// return this.executeInternal(query, false, false, null, null, -1);
	// }
	// throw new
	// MQLNotSupportedException(MQLApiMessages.IGNOREDIRTY_NOT_SUPPORTED);
	// }
	//
	// /*
	// * JMX Stuff
	// */
	//
	// private void registerMBean() {
	//
	// // try {
	// // String sessionId = this.conn.getId( );
	// // if ( sessionId != null ) {
	// // int pos = sessionId.indexOf( '-' );
	// // if ( pos != -1 ) {
	// // String connId = sessionId.substring( pos + 1 );
	// // sessionId = sessionId.substring( 0, pos );
	//		//                    this.objectName = new ObjectName( MOIN_DOMAIN + "type=MqlProcessor,moin=" + this.conn.getSession( ).getMoin( ).getId( ) + ",session=" + sessionId + ",connection=" + connId ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	// // }
	// // } else {
	// // // Mock connection... yuck!
	//		//                this.objectName = new ObjectName( MOIN_DOMAIN + "type=MqlProcessor,moin=" + this.conn.getSession( ).getMoin( ).getId( ) + ",session=" + System.identityHashCode( this.conn.getSession( ) ) + ",connection=" + System.identityHashCode( this.conn ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	// // }
	// // } catch ( MalformedObjectNameException e ) {
	// // throw new RuntimeException( e );
	// // } catch ( NullPointerException e ) {
	// // throw new RuntimeException( e );
	// // }
	// // this.jmxAdapter = new JmxAdapter( this, this.objectName,
	// // this.conn.getSession( ).getMoin( ).getReferenceQueue( ) );
	// }

	// public void leafQueryExecuted(String selectExpression, long duration) {
	//
	// this.jmxAdapter.leafQueryExecuted(selectExpression, duration);
	// }

	// public ObjectName getObjectName() {
	//
	// return this.objectName;
	// }

	// private static final class JmxAdapter extends
	// NotificationBroadcasterSupport implements MqlProcessorMBean {
	//
	// private static final CompositeType compositeTypeForQueryIssues;
	//
	// private static final TabularType tabularTypeForQueryIssues;
	//
	// static {
	// try {
	// compositeTypeForQueryIssues = new CompositeType(
	//						"QueryIssueInfo", "QueryIssueInfo", new String[] { "1: Severity", "2: Text" }, new String[] { "1: Severity", "2: Text" }, new OpenType[] { SimpleType.STRING, SimpleType.STRING }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
	// tabularTypeForQueryIssues = new TabularType(
	//						"QueryIssues", "Errors and warnings of MQL concrete syntax", compositeTypeForQueryIssues, new String[] { "1: Severity" }); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	// } catch (OpenDataException e) {
	// throw new RuntimeException(e); // not expected to occur
	// }
	// }
	//
	// /**
	// * Sequence number if JMX notifications need to be emitted.
	// */
	// private AtomicLong seqNo = new AtomicLong(0);
	//
	// private final WeakReferenceWithObjectName<MQLProcessorImpl>
	// mqlProcessorRef;
	//
	// private final ObjectName objectName;
	//
	// private final String processorId;
	//
	// @SuppressWarnings("unchecked")
	// JmxAdapter(MQLProcessorImpl processor, ObjectName objectName,
	// ReferenceQueue refQueue) {
	//
	// this.objectName = objectName;
	// this.mqlProcessorRef = new
	// WeakReferenceWithObjectName<MQLProcessorImpl>(processor, objectName,
	// refQueue);
	// registerBroadcastingMBean(this, MqlProcessorMBean.class, objectName);
	//			this.processorId = "Session=" + objectName.getKeyProperty("session") + ",Connection=" + objectName.getKeyProperty("connection"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	// }
	//
	// 
	// public MBeanNotificationInfo[] getNotificationInfo() {
	//
	// MBeanNotificationInfo[] notifsInfo = { new
	// MBeanNotificationInfo(MqlProcessorMBean.ALL_NOTIFICATION_TYPES,
	// Notification.class
	//					.getName(), "Notifications sent by an MQLProcessor MBean") }; //$NON-NLS-1$
	// return notifsInfo;
	// }
	//
	// public void startNotifications() throws IOException {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// processor.jmxNotificationsEnabled = true;
	// }
	// }
	//
	// public boolean notificationsStarted() throws IOException {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// return processor.jmxNotificationsEnabled;
	// }
	// return false;
	// }
	//
	// public void stopNotifications() throws IOException {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// processor.jmxNotificationsEnabled = false;
	// }
	// }
	//
	// public void mqlFormatError(String concreteSyntax, ProcessReport report) {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// StringBuilder message = new StringBuilder();
	// message
	//						.append("Failed to parse MQL concrete syntax string:\n\n").append(concreteSyntax).append("\n\n").append(report.toString()); //$NON-NLS-1$//$NON-NLS-2$
	// Notification notification = new
	// Notification(MqlProcessorMBean.MQL_FORMAT_ERROR, this.objectName,
	// this.seqNo
	// .incrementAndGet(), message.toString());
	// notification.setUserData(this.processorId);
	// this.sendNotification(notification);
	// }
	// }
	//
	// public void queryPrepareStart(StackTraceElement[] stackTrace) {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// Notification notification = new
	// Notification(MqlProcessorMBean.QUERY_PREPARE_START, this.objectName,
	// this.seqNo
	// .incrementAndGet(), this.processorId);
	// notification.setUserData(stackTrace);
	// this.sendNotification(notification);
	// }
	// }
	//
	// public void queryPrepareEnd(String msg, long duration) {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// Notification notification = new
	// Notification(MqlProcessorMBean.QUERY_PREPARE_END, this.objectName,
	// this.seqNo
	// .incrementAndGet(), msg);
	// if (duration > 0) {
	//					notification.setUserData("Time=" + duration + "ms"); //$NON-NLS-1$//$NON-NLS-2$
	// }
	// this.sendNotification(notification);
	// }
	// }
	//
	// public void queryExecuteStart(StackTraceElement[] stackTrace) {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// Notification notification = new
	// Notification(MqlProcessorMBean.QUERY_EXECUTE_START, this.objectName,
	// this.seqNo
	// .incrementAndGet(), this.processorId);
	// notification.setUserData(stackTrace);
	// this.sendNotification(notification);
	// }
	// }
	//
	// public void queryExecuteEnd(String msg, long duration, MQLResultSet
	// resultSet) {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// String message = msg;
	// if (resultSet.getSize() > 0) {
	// StringBuilder _message = new StringBuilder(msg);
	//					_message.append("\n\nResultSet:\n\n").append(resultSet.toString()); //$NON-NLS-1$
	// message = _message.toString();
	// }
	// Notification notification = new
	// Notification(MqlProcessorMBean.QUERY_EXECUTE_END, this.objectName,
	// this.seqNo
	// .incrementAndGet(), message);
	// StringBuilder userData = new StringBuilder();
	// if (duration > 0) {
	//					userData.append("Time=").append(duration).append("ms,"); //$NON-NLS-1$//$NON-NLS-2$
	// }
	//				userData.append("ResultSetSize=").append(resultSet.getSize()); //$NON-NLS-1$
	// notification.setUserData(userData.toString());
	// this.sendNotification(notification);
	// }
	// }
	//
	// public void leafQueryExecuted(String msg, long duration) {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// Notification notification = new
	// Notification(MqlProcessorMBean.LEAF_QUERY_EXECUTED, this.objectName,
	// this.seqNo
	// .incrementAndGet(), msg);
	// if (duration > 0) {
	//					notification.setUserData("Time=" + duration + "ms"); //$NON-NLS-1$//$NON-NLS-2$
	// }
	// this.sendNotification(notification);
	// }
	// }
	//
	// public TabularData query(String mqlString) throws IOException {
	//
	// MQLProcessorImpl processor = this.mqlProcessorRef.get();
	// if (processor != null) {
	// try {
	// // processor.syncManager.acquireReadLock( );
	// try {
	// MQLPreparedQuery preparedQuery = null;
	// try {
	// preparedQuery = processor.prepare(mqlString);
	// } catch (MQLFormatException ex) {
	// return this.getErrorOrWarning(Severity.ERROR,
	// ex.getPreparationReport().toString());
	// } catch (Exception ex) {
	// return this.getErrorOrWarning(Severity.ERROR, getExceptionAsString(ex));
	// }
	// try {
	// long duration = System.nanoTime();
	// MQLResultSet resultSet = processor.execute(preparedQuery);
	// duration = (System.nanoTime() - duration) / 1000000;
	// return this.computeTabularData(resultSet, duration);
	// } catch (Exception ex) {
	// return this.getErrorOrWarning(Severity.ERROR, getExceptionAsString(ex));
	// }
	// } finally {
	// // processor.syncManager.releaseReadLock( );
	// }
	// } catch (RuntimeException e) {
	// throw e;
	// } catch (Exception e) {
	// throw new RuntimeException(e);
	// }
	// }
	// return null;
	// }
	//
	// private enum Severity {
	// ERROR, WARNING
	// }
	//
	// @SuppressWarnings("unchecked")
	// private TabularData getErrorOrWarning(Severity severity, String message)
	// {
	//
	// TabularData result = new TabularDataSupport(tabularTypeForQueryIssues);
	// Map rows = new HashMap();
	//			rows.put("1: Severity", severity.toString()); //$NON-NLS-1$
	//			rows.put("2: Text", message); //$NON-NLS-1$
	// CompositeDataSupport compositeData;
	// try {
	// compositeData = new CompositeDataSupport(compositeTypeForQueryIssues,
	// rows);
	// } catch (OpenDataException ex) {
	// throw new RuntimeException(ex);
	// }
	// result.put(compositeData);
	// return result;
	// }
	//
	// @SuppressWarnings("unchecked")
	// private TabularData computeTabularData(MQLResultSet resultSet, long
	// duration) {
	//
	// MQLColumnType[] queryColumnTypes = resultSet.getQueryColumnTypes();
	// List<String> itemNamesList = new ArrayList<String>();
	// List<String> itemDescriptionList = new ArrayList<String>();
	// List<OpenType> itemTypesList = new ArrayList<OpenType>();
	// for (int i = 0; i < queryColumnTypes.length; i++) {
	// MQLColumnType columnType = queryColumnTypes[i];
	// if (columnType.attribute == null) {
	// itemNamesList.add(i + columnType.alias);
	//					itemDescriptionList.add("MRI"); //$NON-NLS-1$
	// itemTypesList.add(SimpleType.STRING);
	// } else {
	//					itemNamesList.add(i + columnType.alias + "." + columnType.attribute); //$NON-NLS-1$
	// if (columnType.multiValued) {
	// String description = null;
	// if (columnType.isOrdered) {
	//							description = "LIST&lt;" + columnType.typeName + "&gt;"; //$NON-NLS-1$ //$NON-NLS-2$
	// } else {
	//							description = "COLLECTION&lt;" + columnType.typeName + "&gt;"; //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// if (columnType.isUnique) {
	//							description += ", UNIQUE"; //$NON-NLS-1$
	// }
	// itemDescriptionList.add(description);
	// } else {
	// itemDescriptionList.add(columnType.typeName);
	// }
	// itemTypesList.add(SimpleType.STRING);
	// }
	// }
	//			itemNamesList.add("DUMMY"); //$NON-NLS-1$
	//			itemDescriptionList.add("Dummy column for keeping the insertion order"); //$NON-NLS-1$
	// itemTypesList.add(SimpleType.INTEGER);
	// try {
	// String[] itemNames = itemNamesList.toArray(new
	// String[itemNamesList.size()]);
	// String[] itemDescriptions = itemDescriptionList.toArray(new
	// String[itemDescriptionList.size()]);
	// OpenType[] itemTypes = itemTypesList.toArray(new
	// OpenType[itemTypesList.size()]);
	//				CompositeType compositeType = new CompositeType("ResultSetInfo", "ResultSetInfo", itemNames, itemDescriptions, itemTypes); //$NON-NLS-1$ //$NON-NLS-2$
	// StringBuilder tabDescription = new StringBuilder();
	//				tabDescription.append(duration).append("###").append(resultSet.getSize()); //$NON-NLS-1$
	// if (resultSet.getSize() > 0) {
	// StringWriter writer = new StringWriter();
	// resultSet.asCSV(writer);
	//					tabDescription.append("###").append(writer.toString()); //$NON-NLS-1$
	// }
	//				TabularType tabularType = new TabularType("ResultSetContent", tabDescription.toString(), compositeType, itemNames); //$NON-NLS-1$
	// TabularData result = new TabularDataSupport(tabularType);
	// for (int i = 0; i < resultSet.getSize(); i++) {
	// Map rowData = new HashMap();
	//					rowData.put("DUMMY", i); //$NON-NLS-1$
	// for (int j = 0; j < itemNames.length - 1; j++) {
	// if (queryColumnTypes[j].attribute == null) {
	// rowData.put(itemNames[j], resultSet.getMri(i,
	// queryColumnTypes[j].alias).toString());
	// } else {
	// Object value = resultSet.getAttribute(i, queryColumnTypes[j].alias,
	// queryColumnTypes[j].attribute);
	// if (value instanceof Object[]) {
	// Object[] values = (Object[]) value;
	//								StringBuilder data = new StringBuilder("["); //$NON-NLS-1$
	// for (int k = 0; k < values.length; k++) {
	// data.append(String.valueOf(values[k]));
	// if (k < values.length - 1) {
	// data.append(',');
	// }
	// }
	// data.append(']');
	// rowData.put(itemNames[j], data.toString());
	// } else {
	// rowData.put(itemNames[j], String.valueOf(value));
	// }
	// }
	// }
	// CompositeDataSupport compositeData = new
	// CompositeDataSupport(compositeType, rowData);
	// result.put(compositeData);
	// }
	// return result;
	// } catch (OpenDataException e) {
	// throw new RuntimeException(e);
	// }
	// }
	//
	// }
}
