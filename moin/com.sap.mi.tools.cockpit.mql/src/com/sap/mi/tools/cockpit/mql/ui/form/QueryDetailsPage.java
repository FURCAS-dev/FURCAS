package com.sap.mi.tools.cockpit.mql.ui.form;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.util.StringUtil;
import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.model.Model;
import com.sap.mi.tools.cockpit.mql.model.QueryTemplateNode;
import com.sap.mi.tools.cockpit.mql.preferences.MQLPreferencePage;
import com.sap.mi.tools.cockpit.mql.preferences.MQLPreferencesHelper;
import com.sap.mi.tools.cockpit.mql.search.LocalMQLSearchQuery;
import com.sap.mi.tools.cockpit.mql.search.MQLSearchQuery;
import com.sap.mi.tools.cockpit.mql.search.RemoteMQLSearchQuery;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessorFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * @author d003456
 * 
 */
public class QueryDetailsPage implements IDetailsPage {

	private static final String LIFT_WIDGET_NAME_KEY = "name"; //$NON-NLS-1$

	private static final String LIFT_TEXT_WIDGET_QUERY_TEMPLATE_NAME_ON_DETAILS = "com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.queryTemplateNameText"; //$NON-NLS-1$

	private static final String LIFT_HYPERLINK_WIDGET_PREFERENCES = "com.sap.mi.tools.cockpit.mql.ui.form.QueryDetailsPage.openpreferencepageHyperlink"; //$NON-NLS-1$

	private Hyperlink openpreferencepageHyperlink;

	private static final TracerI tracer = TracingManager.getTracer(MiLocations.MI_MQLVIEW);

	private Button remoteButton;

	private Button localButton;

	private Composite modeComposite;

	@SuppressWarnings("unused")
	private Label modeLabel;

	private Composite queryComposite;

	private ExpandableComposite queryExpandableComposite;

	private Composite queryDetailsComposite;

	private Composite sectionComposite;

	private ExpandableComposite queryDetailsExpandableComposite;

	private Button universeButton;

	private Button visibleButton;

	private Button outerButton;

	private Button innerButton;

	private Composite scopeComposite;

	@SuppressWarnings("unused")
	private Label scopeLabel;

	private Button executeButton;

	private Section section;

	private Text textQuery;

	private CCombo cComboConnection;

	private Text textName;

	private Label connectionLabel;

	@SuppressWarnings("unused")
	private Label nameLabel;

	private IManagedForm managedForm;

	private FormText formText;

	private QueryTemplateNode input;

	private ModifyListener textNameModifyListener;

	private ModifyListener textQueryModifyListener;

	private IQueryListener queryListener;

	private ISearchQuery query;

	private boolean queryOK;

	private boolean templateNameOK;

	private boolean dropDownOK;

	private boolean queryResultOK;

	public enum SCOPE {
		/**
		 * All partitions within one project/DC plus all transient partitions including the null partition.
		 */
		INNER,
		/**
		 * Exposed partitions of all referenced DCs/public parts.
		 */
		OUTER,
		/**
		 * All {@link #INNER inner} plus {@link #OUTER outer} partitions.
		 */
		VISIBLE,
		/**
		 * No scope provided in query.
		 */
		UNIVERSE
	};

	private SCOPE scopeSelected;

	public enum MODE {
		/**
		 * Operates on partitions on local machine.
		 */
		LOCAL,
		/**
		 * Operates on partitions on Team Server.
		 */
		REMOTE
	}

	private MODE modeSelected;

	private final RemoteMqlProcessorFactory remoteMqlProcessorFactory;

	private RemoteMqlProcessor remoteMqlProcessor = null;

	private List<String> facilities = null;

	private Map<String, DataAreaDescriptor> dataAreaDescriptors = null;

	private DataAreaDescriptor selectedDataAreaDescriptor = null;

	private final Map<String, IProject> moinProjects;

	private String selectedProject;

	private MQLPreferencesHelper preferencesHelper = null;

	private static final String DIALOG_USER_CANCELED = Messages.QueryDetailsPage_0_xmsg;

	private static final String DIALOG_CREATE = Messages.QueryDetailsPage_1_xmsg;

	private static final String DIALOG_NOT_CREATED = Messages.QueryDetailsPage_2_xmsg;

	private static final String DIALOG_CONNECT_TO_TEAM_SERVER = Messages.QueryDetailsPage_24_xmsg;

	private final static String SECTION_TITLE = Messages.QueryDetailsPage_3_xhed;

	private final static String SECTION_DESCRIPTION = Messages.QueryDetailsPage_4_xtxt;

	private final static String ERROR_NAME_EXISTS = Messages.QueryDetailsPage_5_xmsg;

	private final static String ERROR_NAME_IS_EMPTY = Messages.QueryDetailsPage_6_xmsg;

	private final static String ERROR_QUERY_IS_EMPTY = Messages.QueryDetailsPage_7_xmsg;

	private final static String ERROR_NO_PROJEKT = Messages.QueryDetailsPage_8_xmsg;

	private static final String ERROR_NO_DATA_AREA = Messages.QueryDetailsPage_25_xmsg;

	private final static String ERROR_CONNECTION_NOT_ALIVE = Messages.QueryDetailsPage_9_xmsg;

	private final static String ERROR_TEAM_SERVER_NOT_ALIVE = Messages.QueryDetailsPage_26_xmsg;

	private final static String ERROR_COULD_NOT_CONNECT = Messages.QueryDetailsPage_27_xmsg;

	private final static String ERROR_COULD_NOT_CONNECT_MSG = Messages.QueryDetailsPage_35_xmsg;

	private final static String LABEL_NAME = Messages.QueryDetailsPage_10_xfld;

	private final static String LABEL_CONNECTION = Messages.QueryDetailsPage_11_xfld;

	private final static String LABEL_DATA_AREA_DESCRIPTOR = Messages.QueryDetailsPage_28_xfld;

	private final static String LABEL_SCOPE = Messages.QueryDetailsPage_12_xfld;

	private final static String LABEL_MODE = Messages.QueryDetailsPage_29_xfld;

	private final static String BUTTON_EXECUTE = Messages.QueryDetailsPage_13_xbut;

	private final static String BUTTON_INNER = Messages.QueryDetailsPage_14_xbut;

	private final static String BUTTON_OUTER = Messages.QueryDetailsPage_15_xbut;

	private final static String BUTTON_VISIBLE = Messages.QueryDetailsPage_16_xbut;

	private final static String BUTTON_UNIVERSE = Messages.QueryDetailsPage_17_xbut;

	private final static String BUTTON_LOCAL = Messages.QueryDetailsPage_30_xtol;

	private final static String BUTTON_REMOTE = Messages.QueryDetailsPage_31_xtol;

	private final static String TOOL_TIP_INNER = Messages.QueryDetailsPage_18_xtol;

	private final static String TOOL_TIP_OUTER = Messages.QueryDetailsPage_19_xtol;

	private final static String TOOL_TIP_VISIBLE = Messages.QueryDetailsPage_20_xtol;

	private final static String TOOL_TIP_UNIVERSE = Messages.QueryDetailsPage_21_xtol;

	private final static String TOOL_TIP_LOCAL = Messages.QueryDetailsPage_32_xtol;

	private final static String TOOL_TIP_REMOTE = Messages.QueryDetailsPage_33_xtol;

	private final static String TOOL_TIP_OPEN_PREFERENCES_DIALOG = Messages.QueryDetailsPage_34_xtol;

	private final static String COMPOSITE_QUERY_DETAILS_TITLE = Messages.QueryDetailsPage_22_xfld;

	private final static String COMPOSITE_QUERY_TITLE = Messages.QueryDetailsPage_23_xfld;

	/**
	 * Creates the details page.
	 */
	public QueryDetailsPage() {

		this.moinProjects = new HashMap<String, IProject>();
		this.queryOK = true;
		this.templateNameOK = true;
		this.dropDownOK = false;
		this.queryResultOK = true;
		this.query = null;
		this.scopeSelected = SCOPE.INNER;
		this.modeSelected = MODE.LOCAL;
		this.remoteMqlProcessorFactory = new RemoteMqlProcessorFactory();
		this.facilities = new ArrayList<String>();
		this.dataAreaDescriptors = new HashMap<String, DataAreaDescriptor>();
		this.preferencesHelper = MQLPreferencesHelper.getInstance();
	}

	/**
	 * Initialize the details page.
	 * 
	 * @param form
	 *            the {@link IManagedForm} form
	 */
	public void initialize(IManagedForm form) {

		this.managedForm = form;

	}

	/**
	 * Listener for {@link MQLSearchQuery} query execution progress. Needed for enabling or disabling {@link Button} <code>Execute</code>.
	 * 
	 * @return {@linkIQueryListener} listener
	 */
	private IQueryListener createQueryListener() {

		return new IQueryListener() {

			public void queryAdded(final ISearchQuery query) {

				final Runnable queryAddedRunnable = new Runnable() {
					public void run() {

						if (query == null || QueryDetailsPage.this.query == null || !QueryDetailsPage.this.query.equals(query)) {
							return;
						}
						QueryDetailsPage.this.queryResultOK = false;
						canExecute();
					}

				};
				asyncExec(queryAddedRunnable);
			}

			public void queryRemoved(final ISearchQuery query) {

				final Runnable queryRemovedRunnable = new Runnable() {
					public void run() {

						if (query == null || QueryDetailsPage.this.query == null || !QueryDetailsPage.this.query.equals(query)) {
							return;
						}
						QueryDetailsPage.this.queryResultOK = true;
						canExecute();
					}

				};
				asyncExec(queryRemovedRunnable);
			}

			public void queryStarting(final ISearchQuery query) {

				final Runnable queryStartingRunnable = new Runnable() {
					public void run() {

						if (query == null || QueryDetailsPage.this.query == null || !QueryDetailsPage.this.query.equals(query)) {
							return;
						}
						QueryDetailsPage.this.queryResultOK = false;
						canExecute();
					}

				};
				asyncExec(queryStartingRunnable);

			}

			public void queryFinished(final ISearchQuery query) {

				final Runnable queryFinishedRunnable = new Runnable() {
					public void run() {

						if (query == null || QueryDetailsPage.this.query == null || !QueryDetailsPage.this.query.equals(query)) {
							return;
						}
						QueryDetailsPage.this.queryResultOK = true;
						canExecute();
					}

				};
				asyncExec(queryFinishedRunnable);
			}
		};
	}

	/**
	 * Execute runnable in UI thread.
	 * 
	 * @param runnable
	 *            the {@link Section Runnable} to be executed
	 */
	private void asyncExec(final Runnable runnable) {

		final Control control = getControl();
		if (control != null && !control.isDisposed()) {
			final Display currentDisplay = Display.getCurrent();
			if (currentDisplay == null || !currentDisplay.equals(control.getDisplay())) {
				// meaning we're not executing on the display thread of the
				// control
				control.getDisplay().asyncExec(new Runnable() {
					public void run() {

						if (!control.isDisposed())
							runnable.run();
					}
				});
			} else {
				runnable.run();
			}
		}

	}

	/**
	 * Create contents of the details page.
	 * 
	 * @param parent
	 *            the {@link Section Composite} parent container
	 */
	public void createContents(Composite parent) {

		final GridLayout sectionGridLayout;
		this.queryListener = createQueryListener();
		final FormToolkit toolkit = this.managedForm.getToolkit();
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		parent.setLayout(gridLayout);

		this.section = toolkit.createSection(parent, ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED
				| ExpandableComposite.TITLE_BAR);
		this.section.setLayoutData(new GridData(GridData.FILL_BOTH));
		this.section.setText(QueryDetailsPage.SECTION_TITLE);
		this.formText = toolkit.createFormText(this.section, true);
		this.section.setDescriptionControl(this.formText);
		setDescription(QueryDetailsPage.SECTION_DESCRIPTION);

		this.sectionComposite = toolkit.createComposite(this.section);
		sectionGridLayout = new GridLayout();
		this.sectionComposite.setLayout(sectionGridLayout);
		toolkit.paintBordersFor(this.sectionComposite);
		this.section.setClient(this.sectionComposite);

		createQueryDetailsExpandableComposite(toolkit);
		createQueryExpandableComposite(toolkit);

		NewSearchUI.addQueryListener(this.queryListener);

	}

	private void createQueryExpandableComposite(final FormToolkit toolkit) {

		final GridData textQueryGridData;
		this.queryExpandableComposite = toolkit.createExpandableComposite(this.sectionComposite, ExpandableComposite.TWISTIE
				| ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
		this.queryExpandableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.queryExpandableComposite.setText(QueryDetailsPage.COMPOSITE_QUERY_TITLE);
		toolkit.paintBordersFor(this.queryExpandableComposite);

		this.queryComposite = toolkit.createComposite(this.queryExpandableComposite, SWT.BORDER);
		final GridLayout gridLayoutQueryComposite = new GridLayout();
		gridLayoutQueryComposite.numColumns = 1;
		this.queryComposite.setLayout(gridLayoutQueryComposite);
		toolkit.paintBordersFor(this.queryComposite);
		this.queryExpandableComposite.setClient(this.queryComposite);

		this.textQuery = new Text(this.queryComposite, SWT.V_SCROLL | SWT.BORDER | SWT.WRAP);
		textQueryGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		this.textQuery.setLayoutData(textQueryGridData);
		this.textQuery.addModifyListener(this.textQueryModifyListener = new ModifyListener() {
			public void modifyText(final ModifyEvent e) {

				// restore description
				setDescription(QueryDetailsPage.SECTION_DESCRIPTION);
				final Text text = (Text) e.getSource();
				if (text != null && !QueryDetailsPage.this.input.getQuery().equals(text.getText())) {
					if (text.getText().equals("")) { //$NON-NLS-1$
						setError(QueryDetailsPage.ERROR_QUERY_IS_EMPTY);
						QueryDetailsPage.this.queryOK = false;
					} else {
						QueryDetailsPage.this.input.setQuery(text.getText());
						QueryDetailsPage.this.queryOK = true;
					}
				} else {
					QueryDetailsPage.this.queryOK = true;
				}
				canExecute();
			}
		});

		this.executeButton = toolkit.createButton(this.queryComposite, QueryDetailsPage.BUTTON_EXECUTE, SWT.LEFT);
		this.executeButton.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false));
		this.executeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				Model.getInstance().saveModel();
				processQuery();
			}
		});
	}

	private void createQueryDetailsExpandableComposite(final FormToolkit toolkit) {

		final GridLayout compositeSectionDridLayout;
		this.queryDetailsExpandableComposite = toolkit.createExpandableComposite(this.sectionComposite, ExpandableComposite.TWISTIE
				| ExpandableComposite.EXPANDED | ExpandableComposite.SHORT_TITLE_BAR);
		this.queryDetailsExpandableComposite.addExpansionListener(new IExpansionListener() {
			public void expansionStateChanged(final ExpansionEvent e) {

				getControl().layout(true);
			}

			public void expansionStateChanging(final ExpansionEvent e) {

				// ignore
			}
		});
		this.queryDetailsExpandableComposite.setText(QueryDetailsPage.COMPOSITE_QUERY_DETAILS_TITLE);
		final GridData gd_queryDetailsExpandableComposite_1 = new GridData(SWT.FILL, SWT.TOP, true, false);
		this.queryDetailsExpandableComposite.setLayoutData(gd_queryDetailsExpandableComposite_1);
		toolkit.paintBordersFor(this.queryDetailsExpandableComposite);

		this.queryDetailsComposite = toolkit.createComposite(this.queryDetailsExpandableComposite, SWT.BORDER);
		compositeSectionDridLayout = new GridLayout();
		compositeSectionDridLayout.numColumns = 2;
		this.queryDetailsComposite.setLayout(compositeSectionDridLayout);
		toolkit.paintBordersFor(this.queryDetailsComposite);
		this.queryDetailsExpandableComposite.setClient(this.queryDetailsComposite);

		createModeControl(toolkit);
		createNameControl(toolkit);
		createConnectionControl(toolkit);
		createScopeControl(toolkit);
	}

	private void createConnectionControl(final FormToolkit toolkit) {

		final GridData cComboConnectionGridData;
		this.connectionLabel = toolkit.createLabel(this.queryDetailsComposite, QueryDetailsPage.LABEL_CONNECTION, SWT.NONE);

		this.cComboConnection = new CCombo(this.queryDetailsComposite, SWT.READ_ONLY | SWT.BORDER);
		this.cComboConnection.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				setDescription(QueryDetailsPage.SECTION_DESCRIPTION);
				final CCombo combo = (CCombo) e.getSource();
				final int index = combo.getSelectionIndex();
				if (index != -1) {
					if (QueryDetailsPage.this.modeSelected == MODE.LOCAL) {
						QueryDetailsPage.this.selectedProject = combo.getItem(index);
					} else {
						final String selectedDad = combo.getItem(index);
						QueryDetailsPage.this.selectedDataAreaDescriptor = QueryDetailsPage.this.dataAreaDescriptors.get(selectedDad);
					}
					QueryDetailsPage.this.dropDownOK = true;
				} else {
					if (QueryDetailsPage.this.modeSelected == MODE.LOCAL) {
						setError(QueryDetailsPage.ERROR_NO_PROJEKT);
					} else {
						setError(QueryDetailsPage.ERROR_NO_DATA_AREA);
					}
					QueryDetailsPage.this.dropDownOK = false;
				}
				canExecute();
			}
		});
		// set items when user clicks control
		this.cComboConnection.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {

				final CCombo combo = (CCombo) e.getSource();
				if (QueryDetailsPage.this.modeSelected == MODE.LOCAL) {
					combo.setItems(getAllMoinDecoratedProjectNames());
				} else {
					combo.setItems(getDataAreaDescriptors().keySet().toArray(new String[getDataAreaDescriptors().size()]));
				}
			}

			public void focusLost(FocusEvent e) {

				// ignore
			}
		});
		cComboConnectionGridData = new GridData(SWT.FILL, SWT.TOP, false, false);
		this.cComboConnection.setLayoutData(cComboConnectionGridData);
		toolkit.adapt(this.cComboConnection, true, true);
	}

	private void createNameControl(final FormToolkit toolkit) {

		final GridData textNameGridData;
		this.nameLabel = toolkit.createLabel(this.queryDetailsComposite, QueryDetailsPage.LABEL_NAME, SWT.NONE);
		this.textName = toolkit.createText(this.queryDetailsComposite, null, SWT.NONE);
		textNameGridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		this.textName.setLayoutData(textNameGridData);
		this.textName.setData(QueryDetailsPage.LIFT_WIDGET_NAME_KEY, QueryDetailsPage.LIFT_TEXT_WIDGET_QUERY_TEMPLATE_NAME_ON_DETAILS);
		this.textName.addModifyListener(this.textNameModifyListener = new ModifyListener() {
			public void modifyText(final ModifyEvent e) {

				// restore description
				setDescription(QueryDetailsPage.SECTION_DESCRIPTION);
				final Text text = (Text) e.getSource();
				if (text != null && !QueryDetailsPage.this.input.getTemplateName().equals(text.getText())) {
					if (text.getText().equals("")) { //$NON-NLS-1$
						setError(QueryDetailsPage.ERROR_NAME_IS_EMPTY);
						QueryDetailsPage.this.templateNameOK = false;
					} else if (Model.getInstance().lookUp(text.getText())) {
						setError(QueryDetailsPage.ERROR_NAME_EXISTS);
						QueryDetailsPage.this.templateNameOK = false;
					} else {
						QueryDetailsPage.this.input.setTemplateName(text.getText());
						QueryDetailsPage.this.templateNameOK = true;
					}
				} else {
					QueryDetailsPage.this.templateNameOK = true;
				}
				canExecute();
			}
		});
	}

	private void createModeControl(final FormToolkit toolkit) {

		final GridLayout modeGridLayout;
		this.modeLabel = toolkit.createLabel(this.queryDetailsComposite, QueryDetailsPage.LABEL_MODE, SWT.NONE);

		this.modeComposite = toolkit.createComposite(this.queryDetailsComposite, SWT.BORDER);
		this.modeComposite.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false));
		modeGridLayout = new GridLayout();
		modeGridLayout.marginHeight = 2;
		modeGridLayout.numColumns = 3;
		this.modeComposite.setLayout(modeGridLayout);
		toolkit.paintBordersFor(this.modeComposite);

		this.localButton = toolkit.createButton(this.modeComposite, "Local", SWT.FLAT | SWT.RADIO); //$NON-NLS-1$
		this.localButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		this.localButton.setText(QueryDetailsPage.BUTTON_LOCAL);
		this.localButton.setToolTipText(QueryDetailsPage.TOOL_TIP_LOCAL);
		this.localButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				setDescription(QueryDetailsPage.SECTION_DESCRIPTION);
				// Button radio = (Button) e.getSource();
				// if (radio.getSelection()) {
				QueryDetailsPage.this.modeSelected = MODE.LOCAL;
				QueryDetailsPage.this.connectionLabel.setText(QueryDetailsPage.LABEL_CONNECTION);
				enableScopeButtons(true);
				deselectScopeButtons();
				QueryDetailsPage.this.innerButton.setSelection(true);
				QueryDetailsPage.this.cComboConnection.deselectAll();
				QueryDetailsPage.this.dropDownOK = false;
				// }
				canExecute();
			}
		});

		this.remoteButton = toolkit.createButton(this.modeComposite, "", SWT.FLAT | SWT.RADIO); //$NON-NLS-1$
		this.remoteButton.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
		this.remoteButton.setToolTipText(QueryDetailsPage.TOOL_TIP_REMOTE);
		this.remoteButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				setDescription(QueryDetailsPage.SECTION_DESCRIPTION);
				final Button radio = (Button) e.getSource();
				if (radio.getSelection()) {
					QueryDetailsPage.this.modeSelected = MODE.REMOTE;
					QueryDetailsPage.this.connectionLabel.setText(QueryDetailsPage.LABEL_DATA_AREA_DESCRIPTOR);
					QueryDetailsPage.this.cComboConnection.deselectAll();
					QueryDetailsPage.this.dropDownOK = false;
					// QueryDetailsPage.this.section.layout(true, true);
					deselectScopeButtons();
					QueryDetailsPage.this.universeButton.setSelection(true);
					enableScopeButtons(false);
					prepareRemoteSession();
				}
				canExecute();
			}
		});

		this.openpreferencepageHyperlink = toolkit.createHyperlink(this.modeComposite, "Remote", SWT.NONE); //$NON-NLS-1$
		this.openpreferencepageHyperlink.setText(QueryDetailsPage.BUTTON_REMOTE);
		this.openpreferencepageHyperlink.setToolTipText(QueryDetailsPage.TOOL_TIP_OPEN_PREFERENCES_DIALOG);
		this.openpreferencepageHyperlink.setData(QueryDetailsPage.LIFT_WIDGET_NAME_KEY, QueryDetailsPage.LIFT_HYPERLINK_WIDGET_PREFERENCES);
		this.openpreferencepageHyperlink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(final HyperlinkEvent e) {

				final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				if (window != null) {
					final PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(window.getShell(),
							MQLPreferencePage.MQL_PREFERENCE_PAGE_ID, new String[] { MQLPreferencePage.PREFERENCE_TEAM_SERVER_URL }, null);
					dialog.open();
				}
			}

			public void linkEntered(HyperlinkEvent e) {

				// ignore
			}

			public void linkExited(HyperlinkEvent e) {

				// ignore
			}
		});
	}

	private void createScopeControl(final FormToolkit toolkit) {

		final GridLayout scopeGridLayout;
		this.scopeLabel = toolkit.createLabel(this.queryDetailsComposite, QueryDetailsPage.LABEL_SCOPE, SWT.NONE);

		this.scopeComposite = toolkit.createComposite(this.queryDetailsComposite, SWT.BORDER | SWT.EMBEDDED);
		scopeGridLayout = new GridLayout();
		scopeGridLayout.marginHeight = 2;
		scopeGridLayout.verticalSpacing = 0;
		scopeGridLayout.numColumns = 4;
		this.scopeComposite.setLayout(scopeGridLayout);
		toolkit.paintBordersFor(this.scopeComposite);

		this.innerButton = toolkit.createButton(this.scopeComposite, QueryDetailsPage.BUTTON_INNER, SWT.FLAT | SWT.RADIO);
		this.innerButton.setText(QueryDetailsPage.BUTTON_INNER);
		this.innerButton.setToolTipText(QueryDetailsPage.TOOL_TIP_INNER);
		this.innerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				QueryDetailsPage.this.scopeSelected = SCOPE.INNER;
			}
		});

		this.outerButton = toolkit.createButton(this.scopeComposite, QueryDetailsPage.BUTTON_OUTER, SWT.FLAT | SWT.RADIO);
		this.outerButton.setToolTipText(QueryDetailsPage.TOOL_TIP_OUTER);
		this.outerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				QueryDetailsPage.this.scopeSelected = SCOPE.OUTER;
			}
		});

		this.visibleButton = toolkit.createButton(this.scopeComposite, QueryDetailsPage.BUTTON_VISIBLE, SWT.FLAT | SWT.RADIO);
		this.visibleButton.setToolTipText(QueryDetailsPage.TOOL_TIP_VISIBLE);
		this.visibleButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				QueryDetailsPage.this.scopeSelected = SCOPE.VISIBLE;
			}
		});

		this.universeButton = toolkit.createButton(this.scopeComposite, QueryDetailsPage.BUTTON_UNIVERSE, SWT.FLAT | SWT.RADIO);
		this.universeButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true));
		this.universeButton.setToolTipText(QueryDetailsPage.TOOL_TIP_UNIVERSE);
		this.universeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				QueryDetailsPage.this.scopeSelected = SCOPE.UNIVERSE;
			}
		});
	}

	/**
	 * Updates the given message and icon information in the section header. Update is done in separate update task if not called from UI
	 * thread.
	 * 
	 * @param message
	 *            the new message to display
	 * @param parseTags
	 *            if <code>true</code>, formatting tags will be parsed. Otherwise, text will be rendered as-is.
	 * @param expandURLs
	 *            if <code>true</code>, URLs found in the untagged text will be converted into hyperlinks.
	 * @param key
	 *            unique key that matches the value of the <code>href</code> attribute.
	 * @param image
	 *            an object of a type <code>Image</code>.
	 */
	private void updateDescription(final String message, final boolean parseTags, final boolean expandURLs, final String imageKey,
			final Image image) {

		if (getControl() != null && !getControl().isDisposed()) {
			final FormText descControl = (FormText) getControl().getDescriptionControl();
			// only asyncExec if not called in UI thread
			if (Display.getCurrent() == null) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {

						if (image != null) {
							descControl.setImage(imageKey, image);
						}
						if (message != null) {
							descControl.setText(message, parseTags, expandURLs);
						}
						getControl().layout(true);
					}
				});
			} else {
				if (image != null) {
					descControl.setImage(imageKey, image);
				}
				if (message != null) {
					descControl.setText(message, parseTags, expandURLs);
				}
				getControl().layout(true);
			}
		}

	}

/**
	 * Sets a styled error text into {@link FormText} <code>formText</code> of the {@link Section.
	 * 
	 * @param message
	 */
	public void setError(String message) {

		final Image image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		final String description = "<form><li style='image' value='image'>" + StringUtil.escapeForHTML(message != null ? message : "") //$NON-NLS-1$ //$NON-NLS-2$
				+ "</li></form>"; //$NON-NLS-1$
		updateDescription(description, true, false, "image", image); //$NON-NLS-1$

	}

	/**
	 * Sets a styled warning text into {@link FormText} <code>formText</code> of the {@link Section}.
	 * 
	 * @param message
	 */
	public void setWarning(String message) {

		final Image image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
		final String description = "<form><li style='image' value='image'>" + StringUtil.escapeForHTML(message != null ? message : "") //$NON-NLS-1$ //$NON-NLS-2$
				+ "</li></form>"; //$NON-NLS-1$
		updateDescription(description, true, false, "image", image); //$NON-NLS-1$

	}

	/**
	 * Sets a styled description text into {@link FormText} <code>formText</code> of the {@link Section}.
	 * 
	 * @param message
	 */
	protected void setDescription(String message) {

		final String description = "<form>" + StringUtil.escapeForHTML(message != null ? message : "") + "</form>"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		updateDescription(description, true, false, null, null);

	}

	/**
	 * required to attach a layout in the TabbedPropertySheet
	 */
	public Section getControl() {

		return this.section;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#dispose()
	 */
	public void dispose() {

		if (this.textName != null) {
			this.textName.removeModifyListener(this.textNameModifyListener);
		}
		if (this.textQuery != null) {
			this.textQuery.removeModifyListener(this.textQueryModifyListener);
		}
		if (this.queryListener != null) {
			NewSearchUI.removeQueryListener(this.queryListener);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#setFocus()
	 */
	public void setFocus() {

		if (this.textQuery != null) {
			this.textQuery.setFocus();
		}

	}

	private void update() {

		if (this.textName != null && this.textQuery != null) {
			this.textName.setText(this.input.getTemplateName());
			this.textQuery.setText(this.input.getQuery());
		}
		// can be empty at an early state
		if (this.cComboConnection != null && this.cComboConnection.getSelectionIndex() == -1) {
			this.cComboConnection.setItems(getAllMoinDecoratedProjectNames());
		}
		if (this.innerButton != null && !this.innerButton.getSelection() && !this.outerButton.getSelection()
				&& !this.visibleButton.getSelection() && !this.universeButton.getSelection()) {
			this.innerButton.setSelection(true);
		}
		if (this.localButton != null && !this.localButton.getSelection() && !this.remoteButton.getSelection()) {
			this.localButton.setSelection(true);
		}

	}

	private void enableScopeButtons(boolean enabled) {

		this.innerButton.setEnabled(enabled);
		this.outerButton.setEnabled(enabled);
		this.visibleButton.setEnabled(enabled);
		this.universeButton.setEnabled(enabled);
	}

	private void deselectScopeButtons() {

		this.innerButton.setSelection(false);
		this.outerButton.setSelection(false);
		this.visibleButton.setSelection(false);
		this.universeButton.setSelection(false);
	}

	private String[] getAllMoinDecoratedProjectNames() {

		this.moinProjects.clear();
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (int i = 0; i < projects.length; i++) {
			if (ModelManager.getInstance().isMoinProject(projects[i]) && projects[i].isAccessible()) {
				final String decoratedProjectName = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(
						projects[i].getName(), projects[i]);
				this.moinProjects.put(decoratedProjectName, projects[i]);
			}
		}
		final Set<String> names = this.moinProjects.keySet();
		return names.toArray(new String[names.size()]);

	}

	/**
	 * Process the query asynchronously in background thread and display results in <code>SearchView</code> afterwards.
	 * 
	 * @param query
	 *            the {@link MQLSearchQuery} to be executed
	 */
	private void processQuery() {

		if (this.modeSelected == MODE.LOCAL) {
			final Connection connection = getOrCreateDefaultConnection(this.moinProjects.get(this.selectedProject));
			if (connection != null && connection.isAlive()) {
				NewSearchUI.activateSearchResultView();
				this.query = new LocalMQLSearchQuery(this.textQuery.getText(), connection, getScopeSelected(), this);
				NewSearchUI.runQueryInBackground(this.query);
			} else {
				setError(QueryDetailsPage.ERROR_CONNECTION_NOT_ALIVE);
				this.cComboConnection.setItems(getAllMoinDecoratedProjectNames());
				this.dropDownOK = false;
				canExecute();
			}
		} else {
			if (this.remoteMqlProcessor != null && this.facilities.size() > 0) {
				NewSearchUI.activateSearchResultView();
				this.query = new RemoteMQLSearchQuery(this.textQuery.getText(), getScopeSelected(), this.remoteMqlProcessor,
						getSelectedDataAreaDescriptor(), this);
				NewSearchUI.runQueryInBackground(this.query);
			} else {
				setError(QueryDetailsPage.ERROR_TEAM_SERVER_NOT_ALIVE);
				this.dropDownOK = false;
				canExecute();
			}
		}
	}

	private Connection getOrCreateDefaultConnection(final IProject project) {

		final Connection[] connections = new Connection[1];
		final IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

				if (monitor != null) {
					monitor.beginTask(QueryDetailsPage.DIALOG_CREATE, IProgressMonitor.UNKNOWN);
				}
				connections[0] = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
			}
		};

		final IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		try {
			ps.busyCursorWhile(operation);
		}
		catch (final InterruptedException e) {
			QueryDetailsPage.tracer.debug(QueryDetailsPage.DIALOG_USER_CANCELED);
			return null;
		}
		catch (final Exception e) {
			QueryDetailsPage.tracer.error(QueryDetailsPage.DIALOG_NOT_CREATED, e);
			throw new RuntimeException(e);
		}
		return connections[0];
	}

	private void prepareRemoteSession() {

		final IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {

				if (monitor != null) {
					monitor.beginTask(QueryDetailsPage.DIALOG_CONNECT_TO_TEAM_SERVER, IProgressMonitor.UNKNOWN);
				}
				try {
					QueryDetailsPage.this.remoteMqlProcessor = QueryDetailsPage.this.remoteMqlProcessorFactory
							.createRemoteMqlProcessor(new URL(QueryDetailsPage.this.preferencesHelper.getTeamServerUrl()));
					QueryDetailsPage.this.facilities = QueryDetailsPage.this.remoteMqlProcessor.getFacilities();
					final List<DataAreaDescriptor> das = QueryDetailsPage.this.remoteMqlProcessor
							.getDataAreas(QueryDetailsPage.this.facilities.get(0));
					for (final DataAreaDescriptor dataAreaDescriptor : das) {
						QueryDetailsPage.this.dataAreaDescriptors.put(dataAreaDescriptor.getDataAreaName(), dataAreaDescriptor);
					}
				}
				catch (final Exception e) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {

							QueryDetailsPage.tracer.error(e.getMessage(), e);
							if (e != null && e.getLocalizedMessage() != null && e.getLocalizedMessage().length() > 0) {
								setError(MessageFormat.format(QueryDetailsPage.ERROR_COULD_NOT_CONNECT_MSG, new Object[] { e
										.getLocalizedMessage() }));
							} else {
								setError(QueryDetailsPage.ERROR_COULD_NOT_CONNECT);
							}
							QueryDetailsPage.this.remoteButton.setSelection(false);
						}
					});
				}
			}
		};
		final IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		try {
			ps.busyCursorWhile(operation);
		}
		catch (final InterruptedException e) {
			QueryDetailsPage.tracer.debug(QueryDetailsPage.DIALOG_USER_CANCELED);
			return;
		}
		catch (final Exception e) {
			QueryDetailsPage.tracer.error(QueryDetailsPage.DIALOG_NOT_CREATED, e);
			throw new RuntimeException(e);
		}
	}

	public boolean setFormInput(Object input) {

		// ignore
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IPartSelectionListener#selectionChanged(org.eclipse.ui.forms.IFormPart,
	 * org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IFormPart part, ISelection selection) {

		final IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		if (structuredSelection.size() == 1) {
			this.input = (QueryTemplateNode) structuredSelection.getFirstElement();
			update();
		} else {
			this.input = null;
		}
		this.queryResultOK = true;
		canExecute();

	}

	/**
	 * Enables or disables {@link Button} <code>this.executeButton</code>.
	 */
	private void canExecute() {

		this.executeButton.setEnabled(this.dropDownOK && this.templateNameOK && this.queryOK && this.queryResultOK);

	}

	public void commit(boolean onSave) {

		// ignore
	}

	public boolean isDirty() {

		// ignore
		return false;
	}

	public boolean isStale() {

		// ignore
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#refresh()
	 */
	public void refresh() {

		update();

	}

	/**
	 * @return the scopeSelected
	 */
	public SCOPE getScopeSelected() {

		return this.scopeSelected;
	}

	/**
	 * @return the dataAreaDescriptors
	 */
	public final Map<String, DataAreaDescriptor> getDataAreaDescriptors() {

		return this.dataAreaDescriptors;
	}

	/**
	 * @return the selectedDataAreaDescriptor
	 */
	public final DataAreaDescriptor getSelectedDataAreaDescriptor() {

		return this.selectedDataAreaDescriptor;
	}

	/**
	 * @return the facilities
	 */
	public final List<String> getFacilities() {

		return this.facilities;
	}

}
