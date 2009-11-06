package com.sap.mi.tools.cockpit.mql.ui.search.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.ui.search.MQLSearchResultPage;

/**
 * Saves the query as Comma-Separated-Value file with {@link FileDialog} dialog.
 * 
 * @author d003456
 * 
 */
public final class SaveQueryResultAction extends Action {

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MQLVIEW);

	private final MQLSearchResultPage page;

	private final static String SAVE_QUERY_ACTION_LABEL = Messages.SaveQueryResultAction_0_xmit;

	private final static String SAVE_QUERY_ACTION_TOOLTIP = Messages.SaveQueryResultAction_1_xtol;

	private final static String SAVE_DIALOG_TITLE = Messages.SaveQueryResultAction_2_xhed;

	private static final String LIFT_FILE_DIALOG_WIDGET_NAME = "com.sap.mi.tools.cockpit.mql.ui.search.action.FileDialog"; //$NON-NLS-1$

	private static final String LIFT_WIDGET_NAME_KEY = "name"; //$NON-NLS-1$

	private final static String CSV_EXTENSION = "*.csv"; //$NON-NLS-1$

	/**
	 * Creates <code>SaveQueryResultAction</code>.
	 * 
	 * @param page
	 */
	public SaveQueryResultAction(MQLSearchResultPage page) {

		super("saveQueryResultAction");//$NON-NLS-1$
		Assert.isNotNull(page);
		setImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.EXPORT_IMAGE));
		setDisabledImageDescriptor(QueryConsole.getDefault().getImageDescriptor(QueryConsole.EXPORT_IMAGE_DISABLED));
		setToolTipText(SaveQueryResultAction.SAVE_QUERY_ACTION_TOOLTIP);
		setText(SaveQueryResultAction.SAVE_QUERY_ACTION_LABEL);
		this.page = page;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		final FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setText(SaveQueryResultAction.SAVE_DIALOG_TITLE);
		dialog.setFilterExtensions(new String[] { SaveQueryResultAction.CSV_EXTENSION });
		dialog.getParent().setData(SaveQueryResultAction.LIFT_WIDGET_NAME_KEY, SaveQueryResultAction.LIFT_FILE_DIALOG_WIDGET_NAME);

		final String fileName = dialog.open();
		if (fileName != null && new Path(fileName).isValidPath(fileName)) {
			final File file = new File(fileName);
			BufferedWriter writer = null;
			try {
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
				this.page.getInput().getResult().asCSV(writer);
			}
			catch (final Exception ex) {
				SaveQueryResultAction.tracer.log(Level.SEVERE, ex.getMessage(), ex);
			}
			finally {
				if (writer != null) {
					try {
						writer.close();
					}
					catch (final IOException e) {
						SaveQueryResultAction.tracer.log(Level.SEVERE, e.getMessage(), e);
					}
				}
			}
		}
	}
}
