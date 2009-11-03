package com.sap.mi.tools.cockpit.mql.search;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.MODE;
import com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.SCOPE;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLFormatException;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * @author d003456
 * 
 */
public class RemoteMQLSearchQuery extends MQLSearchQuery {

	private static final TracerI tracer = TracingManager.getTracer(MiLocations.MI_MQLVIEW);

	private final RemoteMqlProcessor remoteMqlProcessor;

	private final DataAreaDescriptor dad;

	/**
	 * Creates {@link RemoteMQLSearchQuery}.
	 * 
	 */
	public RemoteMQLSearchQuery(String query, SCOPE scopeSelected, RemoteMqlProcessor remoteMqlProcessor, DataAreaDescriptor dad,
			QueryDetailsPage queryDetailsPage) {

		super(query, queryDetailsPage, MODE.REMOTE);
		this.remoteMqlProcessor = remoteMqlProcessor;
		this.dad = dad;
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

		try {
			setDuration(System.nanoTime());
			this.mqlResultSet = this.remoteMqlProcessor.execute(getQuery(), null, null, new DataAreaDescriptor[] { this.dad },
					RemoteMqlProcessor.SCOPE_GLOBAL, RemoteMqlProcessor.RESULTS_UNLIMITED);
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
				RemoteMQLSearchQuery.tracer.error(io.getMessage(), io);
			}
			finally {
				try {
					out.close();
				}
				catch (final IOException io) {
					RemoteMQLSearchQuery.tracer.error(io.getMessage(), io);
				}
			}
		}
		catch (final MQLExecutionException e) {
			this.queryDetailsPage.setError(e.getLocalizedMessage());
		}

		getSearchResult();
		return Status.OK_STATUS;
	}
}
