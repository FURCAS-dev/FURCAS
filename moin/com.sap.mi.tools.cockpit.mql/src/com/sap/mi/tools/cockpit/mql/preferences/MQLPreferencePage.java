package com.sap.mi.tools.cockpit.mql.preferences;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessorFactory;

/**
 * Preference page for MOIN cockpit.
 * 
 * @author d003456
 * 
 */
public class MQLPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MQLVIEW);

	public static final String PREFERENCE_TEAM_SERVER_URL = "com.sap.mi.tools.cockpit.mql.preferences.teamserverurl"; //$NON-NLS-1$

	public static final String MQL_PREFERENCE_PAGE_ID = "com.sap.mi.tools.cockpit.mql.preferences.MQLPreferencePage"; //$NON-NLS-1$
	
	private static final String LIFT_WIDGET_NAME_KEY = "name"; //$NON-NLS-1$

	private static final String LIFT_TEXT_WIDGET_URL = "com.sap.mi.tools.cockpit.mql.preferences.MQLPreferencePage.teamserverurl"; //$NON-NLS-1$

	private static final String PREFERENCE_TEAM_SERVER_URL_LABEL = Messages.MQLPreferencePage_0_xfld;

	private static final String PREFERENCE_PAGE_DESCRIPTION = Messages.MQLPreferencePage_1_xhed;

	private static final String PREFERENCE_TEAM_SERVER_URL_CHANGE_BUTTON = Messages.MQLPreferencePage_2_xbut;

	private static final String ERROR_TEAM_SERVER_NOT_REACHED = Messages.MQLPreferencePage_3_xmsg;

	private static final String ERROR_TEAM_SERVER_NOT_REACHED_WITH_MSG = Messages.MQLPreferencePage_6_xmsg;

	private static final String MSG_TEAM_SERVER_REACHED = Messages.MQLPreferencePage_4_xmsg;

	private static final String ERROR_NO_FACILITY = Messages.MQLPreferencePage_5_xmsg;

	private final static String ERROR_MALFORMED_URL_WITH_MSG = Messages.MQLPreferencePage_7_xmsg;

	private final static String ERROR_MALFORMED_URL = Messages.MQLPreferencePage_8_xmsg;

	private StringButtonFieldEditor teamServer = null;

	/**
	 * Create {@link MQLPreferencePage}.
	 */
	public MQLPreferencePage() {

		super(FieldEditorPreferencePage.GRID);
		setPreferenceStore(QueryConsole.getDefault().getPreferenceStore());
		setDescription(MQLPreferencePage.PREFERENCE_PAGE_DESCRIPTION);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditorPreferencePage#createFieldEditors()
	 */
	@Override
	protected void createFieldEditors() {

		Composite parent = getFieldEditorParent();
		this.teamServer = new StringButtonFieldEditor(MQLPreferencePage.PREFERENCE_TEAM_SERVER_URL,
				MQLPreferencePage.PREFERENCE_TEAM_SERVER_URL_LABEL, parent) {
			@Override
			protected String changePressed() {

				URL teamServerUrl = null;
				final String url = getStringValue();
				
				try {
					teamServerUrl = new URL(url);
				}
				catch (final MalformedURLException e) {
					if (e != null && e.getLocalizedMessage() != null && e.getLocalizedMessage().length() > 0) {
						showErrorMessage(MessageFormat.format(MQLPreferencePage.ERROR_MALFORMED_URL_WITH_MSG, new Object[] { e
								.getLocalizedMessage() }));
					} else {
						showErrorMessage(MQLPreferencePage.ERROR_MALFORMED_URL);
					}
					return url;
				}
				RemoteMqlProcessor remoteMqlProcessor = null;
				final RemoteMqlProcessorFactory remoteMqlProcessorFactory = new RemoteMqlProcessorFactory();
				try {
					remoteMqlProcessor = remoteMqlProcessorFactory.createRemoteMqlProcessor(teamServerUrl);
				}
				catch (final Exception e) {
					if (e != null && e.getLocalizedMessage() != null && e.getLocalizedMessage().length() > 0) {
						showErrorMessage(MessageFormat.format(MQLPreferencePage.ERROR_TEAM_SERVER_NOT_REACHED_WITH_MSG, new Object[] { e
								.getLocalizedMessage() }));
					} else {
						showErrorMessage(MQLPreferencePage.ERROR_TEAM_SERVER_NOT_REACHED);
					}
					return url;
				}
				// ping team server
				final List<String> facilities = remoteMqlProcessor.getFacilities();
				if (facilities == null || facilities.size() == 0) {
					showErrorMessage(MQLPreferencePage.ERROR_NO_FACILITY);
				} else {
					getPage().setMessage(MQLPreferencePage.MSG_TEAM_SERVER_REACHED);
				}
				return url;
			}
		};

		this.teamServer.setChangeButtonText(MQLPreferencePage.PREFERENCE_TEAM_SERVER_URL_CHANGE_BUTTON);
		this.teamServer.getTextControl(parent).setData(LIFT_WIDGET_NAME_KEY, LIFT_TEXT_WIDGET_URL);
		addField(this.teamServer);

		if (MQLPreferencePage.tracer.isLoggable(Level.FINE)) {
			MQLPreferencePage.tracer.logp(Level.FINE, "MQLPreferencePage", "createFieldEditors", "Fields created"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
