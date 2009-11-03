package com.sap.mi.tools.cockpit.mql.search;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;

import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.MODE;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.SCOPE;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * @author d003456
 * 
 */
public class LocalMQLSearchQuery extends MQLSearchQuery {

	private static final TracerI tracer = TracingManager.getTracer(MiLocations.MI_MQLVIEW);

	private final Connection connection;

	private final SCOPE scope;

	private final QueryService queryService;

	private final PartitionService partitionService;

	/**
	 * Creates {@link LocalMQLSearchQuery}.
	 * 
	 * @param query
	 * @param connection
	 * @param scope
	 * @param queryDetailsPage
	 */
	public LocalMQLSearchQuery(String query, Connection connection, SCOPE scope, QueryDetailsPage queryDetailsPage) {

		super(query, queryDetailsPage, MODE.LOCAL);
		this.connection = connection;
		this.scope = scope;
		this.queryService = QueryService.getInstance();
		this.partitionService = PartitionService.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.mql.search.MQLSearchQuery#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {

		if (monitor != null) {
			monitor.beginTask(MQLSearchQuery.START_QUERY + getQuery(), IProgressMonitor.UNKNOWN);
		}

		final MQLProcessor mqlProcessor = this.connection.getMQLProcessor();

		try {
			setDuration(System.nanoTime());
			if (this.scope == SCOPE.UNIVERSE) {
				this.mqlResultSet = mqlProcessor.execute(getQuery());
			} else {
				this.mqlResultSet = mqlProcessor.execute(getQuery(), getQueryScopeProvider(this.connection, this.scope));
			}

			setDuration((System.nanoTime() - this.duration) / 1000000);
			this.searchResult.setResult(this.mqlResultSet);
		}
		catch (final MQLFormatException e) {
			final ProcessReport report = e.getPreparationReport();
			final OutputStream out = new ByteArrayOutputStream();
			try {
				report.printReport(Locale.getDefault(), out);
				this.queryDetailsPage.setError(out.toString());
			}
			catch (final IOException io) {
				LocalMQLSearchQuery.tracer.error(io.getMessage(), io);
			}
			finally {
				try {
					out.close();
				}
				catch (final IOException io) {
					LocalMQLSearchQuery.tracer.error(io.getMessage(), io);
				}
			}

		}
		catch (final MQLExecutionException e) {
			this.queryDetailsPage.setError(e.getLocalizedMessage());
		}

		getSearchResult();
		return Status.OK_STATUS;
	}

	private QueryScopeProvider getQueryScopeProvider(Connection connection, SCOPE scope) {

		IPartitionScopeProvider partitionScopeProvider = null;

		if (scope == SCOPE.INNER) {
			partitionScopeProvider = this.partitionService.getPartitionScopeProvider(connection, PartitionScope.INNER);
		} else if (scope == SCOPE.OUTER) {
			partitionScopeProvider = this.partitionService.getPartitionScopeProvider(connection, PartitionScope.OUTER);
		} else if (scope == SCOPE.VISIBLE) {
			partitionScopeProvider = this.partitionService.getPartitionScopeProvider(connection, PartitionScope.VISIBLE);
		}
		return this.queryService.getQueryScopeProvider(partitionScopeProvider);

	}

}
