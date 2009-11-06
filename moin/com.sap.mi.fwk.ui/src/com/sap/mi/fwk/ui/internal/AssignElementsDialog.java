package com.sap.mi.fwk.ui.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.services.local.help.MiHelp;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.help.MiFwkUiHelpContext;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * A dialog that shows the content of the given connection's null partition as
 * well as the connection's
 * {@link Connection#getReferencedTransientElements() referenced transient elements}.
 * Lists all partitions of the project (or all dirty partitions of the
 * connection), among which one can be selected.
 * 
 * @author d031150
 */
public final class AssignElementsDialog extends MessageDialog {

	/**
	 * The return code of the "Clear Null Partition" button
	 */
	public static final int CLEAR = 42;

	private static final int ID_CLEAR = CLEAR;
	private static final Map<String, Integer> sButtonLabelsAndIds = getButtonLabelsAndIds();

	// Attached to controls that are referenced by UI tests
	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$

	public static final String SHELL_NAME = AssignElementsDialog.class.getSimpleName();
	public static final String SHELL_NAME_PARTITION_INPUT = PartitionInputDialog.class.getSimpleName();
	public static final String BUTTON_NAME_CLEAR = SHELL_NAME + ".Button.Clear"; //$NON-NLS-1$
	public static final String BUTTON_NAME_NEW = SHELL_NAME + ".Button.New"; //$NON-NLS-1$
	public static final String TABLE_NAME_PARTITIONS = SHELL_NAME + ".Table.Partitions"; //$NON-NLS-1$
	public static final String TEXT_NAME_ELEMENTS = SHELL_NAME + ".Text.Elements"; //$NON-NLS-1$
	public static final String TEXT_NAME_PARTITION_INPUT = SHELL_NAME_PARTITION_INPUT + ".Text.PartitionInput"; //$NON-NLS-1$

	private final Connection mConnection;
	private final IProject mProject;
	private final PartitionService mPartitionService = PartitionService.getInstance();
	private final List<PRI> mCreatedPartitions = new ArrayList<PRI>();
	private PRI mSelectedPri;

	/**
	 * Creates the dialog
	 */
	public AssignElementsDialog(Connection connection, IProject project, Shell parentShell) {
		super(parentShell, MiFwkUiMessages.AssignElementsDialog_title, null, null, ERROR, sButtonLabelsAndIds.keySet()
				.toArray(new String[sButtonLabelsAndIds.keySet().size()]), 0);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		mConnection = connection;
		mProject = project;
		message = getMessageText();
	}

	/**
	 * @return the selected partition. Must be ignored if return code
	 *         {@link AssignElementsDialog#CLEAR} or {@link Window#CANCEL} is
	 *         set.
	 */
	public ModelPartition getSelectedPartition() {
		return mConnection.getPartition(mSelectedPri);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		// attach a name for testing purposes
		shell.setData(WIDGET_DATA_NAME, SHELL_NAME);
	}

	private String getMessageText() {
		boolean elementsInNullPartition = mConnection.getNullPartition().getElements().size() > 0;
		boolean transientElements = mConnection.getReferencedTransientElements().size() > 0;
		if (elementsInNullPartition) {
			if (transientElements) {
				return MiFwkUiMessages.AssignElementsDialog_text_null_transient;
			} else {
				return MiFwkUiMessages.AssignElementsDialog_text_null;
			}
		} else {
			return MiFwkUiMessages.AssignElementsDialog_text_transient;
		}
	}

	@Override
	protected Control createContents(Composite parent) {
		Dialog.applyDialogFont(parent);
		initializeDialogUnits(parent);
		Control contents = super.createContents(parent);
		
		// install help
		MiHelp.setHelp(contents, MiFwkUiHelpContext.AssignElementsDialog);
		
		return contents;
	}
	
	@Override
	protected Control createCustomArea(Composite parent) {
		SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Composite partitionPane = new Composite(sashForm, SWT.NONE);
		partitionPane.setLayout(new GridLayout());

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		Label labelPartitions = new Label(partitionPane, SWT.NONE);
		labelPartitions.setText(MiFwkUiMessages.bind(MiFwkUiMessages.AssignElementsDialog_partitions_label,
				MiFwkUIPlugin.getProjectLabel(mProject)));
		labelPartitions.setLayoutData(gd);

		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		final TableViewer tableDirtyPartitions = new TableViewer(partitionPane, SWT.SINGLE | SWT.FULL_SELECTION
				| SWT.BORDER);
		TableColumn col = new TableViewerColumn(tableDirtyPartitions, SWT.NONE).getColumn();
		Table table = tableDirtyPartitions.getTable();
		table.setLayoutData(gd);
		col.setWidth(convertHorizontalDLUsToPixels(300));
		col.setText("Id"); //$NON-NLS-1$
		table.setHeaderVisible(false);
		table.setLinesVisible(true);
		setHeightForItems(table, 5);
		table.setData(WIDGET_DATA_NAME, TABLE_NAME_PARTITIONS); // for testing
		final IStructuredContentProvider partitionsTableContentProvider = new PartitionsTableContentProvider();
		tableDirtyPartitions.setContentProvider(partitionsTableContentProvider);
		tableDirtyPartitions.setLabelProvider(new PartitionsTableLabelProvider());
		tableDirtyPartitions.addSelectionChangedListener(new PartitionsTableSelectionChangedListener());
		tableDirtyPartitions.addDoubleClickListener(new PartitionsDoubleClickListener());
		//TODO ToolTipSupport.activateToolTips(tableDirtyPartitions);
		tableDirtyPartitions.setInput(mConnection);

		// Set initial selection async since sel. listener needs complete UI to
		// be there, and we're just in the middle of creating it.
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				PRI pri = getInitialSelection(partitionsTableContentProvider);
				if (pri != null)
					tableDirtyPartitions.setSelection(new StructuredSelection(pri));
			}
		});

		Button button = new Button(partitionPane, SWT.PUSH);
		button.setText(MiFwkUiMessages.AssignElementsDialog_newButton_text);
		button.setToolTipText(MiFwkUiMessages.AssignElementsDialog_newButton_tooltip);
		button.setData(WIDGET_DATA_NAME, BUTTON_NAME_NEW);
		setButtonLayoutData(button);
		((GridData) button.getLayoutData()).horizontalAlignment = SWT.END;

		button.addSelectionListener(new NewPartitionListener(tableDirtyPartitions));

		Group infoPane = new Group(sashForm, SWT.NONE);
		infoPane.setLayout(new GridLayout());
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		infoPane.setLayoutData(gd);
		infoPane.setText(MiFwkUiMessages.AssignElementsDialog_elements_group);

		String partitionInfo = getPartitionInfo(mConnection);
		Text textInfo = new Text(infoPane, SWT.MULTI | SWT.READ_ONLY | SWT.V_SCROLL | SWT.H_SCROLL);
		gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		textInfo.setLayoutData(gd);
		textInfo.setText(partitionInfo);
		setHeightForItems(textInfo, 5);
		textInfo.setData(WIDGET_DATA_NAME, TEXT_NAME_ELEMENTS); // for testing

		sashForm.setWeights(new int[] { 3, 2 });

		applyDialogFont(sashForm);

		return parent;
	}

	/**
	 * Overridden because super impl. assignes a running id to each button (in
	 * the order they appear). This changes the indexes of the default Ok and
	 * Cancel buttons in our scenario since we want to have a button in between.
	 * Fix is to assign ids explictly.
	 * 
	 * @see #getButtonLabelsAndIds()
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		String[] buttonLabels = getButtonLabels();
		Button[] buttons = new Button[buttonLabels.length];
		int defaultButtonIndex = getDefaultButtonIndex();
		for (int i = 0; i < buttonLabels.length; i++) {
			String label = buttonLabels[i];
			int id = sButtonLabelsAndIds.get(label);
			Button button = createButton(parent, id, label, defaultButtonIndex == i);
			buttons[i] = button;
		}
		setButtons(buttons);
	}

	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		Button button = super.createButton(parent, id, label, defaultButton);

		// also attach names for testing purposes
		if (ID_CLEAR == id) {
			button.setToolTipText(MiFwkUiMessages.AssignElementsDialog_clearButton_text);
			button.setData(WIDGET_DATA_NAME, BUTTON_NAME_CLEAR);
		}
		return button;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (ID_CLEAR == buttonId)
			clearPressed();
		else
			super.buttonPressed(buttonId);
	}

	private void clearPressed() {
		setReturnCode(CLEAR);
		close();
	}

	private PRI getInitialSelection(IStructuredContentProvider contentProvider) {
		Object[] partitions = contentProvider.getElements(mConnection);
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
		if (selection != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) selection;
			RefBaseObject object = ModelAdapterUI.getInstance().getRefBaseObject(sel);
			if (object != null) {
				PRI pri = ((Partitionable) object).get___Partition().getPri();
				if (Arrays.asList(partitions).contains(pri)) {
					return pri;
				}
			}
		}

		if (partitions.length > 0)
			return (PRI) partitions[0];
		return null;
	}

	private String getPartitionInfo(Connection connection) {
		Set<StringBuilder> nullInfos = getNullElementsInfo(connection);
		Map<PRI, Set<StringBuilder>> transientInfos = getTransientElementsInfo(connection);

		String lineSep = System.getProperty("line.separator"); //$NON-NLS-1$
		StringBuilder result = new StringBuilder();

		boolean hasNullPartitionCaption = nullInfos.size() > 0 && transientInfos.size() > 0;
		if (hasNullPartitionCaption)
			result.append(MiFwkUiMessages.AssignElementsDialog_elementInfo_null).append(lineSep);
		for (Iterator<StringBuilder> iter = nullInfos.iterator(); iter.hasNext();) {
			StringBuilder info = iter.next();
			if (hasNullPartitionCaption)
				result.append("\t"); //$NON-NLS-1$
			result.append(info);
			if (iter.hasNext()) {
				result.append(lineSep);
			}
		}

		if (transientInfos.size() > 0)
			result.append(lineSep);

		Set<Entry<PRI, Set<StringBuilder>>> transientEntries = transientInfos.entrySet();
		for (Iterator<Entry<PRI, Set<StringBuilder>>> iter = transientEntries.iterator(); iter.hasNext();) {
			Entry<PRI, Set<StringBuilder>> entry = iter.next();
			String partitionName = new Path(entry.getKey().getPartitionName()).segment(1);
			result.append(partitionName).append(':').append(lineSep);
			Set<StringBuilder> infos = entry.getValue();
			for (StringBuilder info : infos)
				result.append('\t').append(info).append(lineSep);
			if (iter.hasNext())
				result.append(lineSep);
		}

		return result.toString();
	}

	private Set<StringBuilder> getNullElementsInfo(Connection connection) {
		// sort all entries alphabetically
		Set<StringBuilder> infos = new TreeSet<StringBuilder>(new Comparator<StringBuilder>() {
			public int compare(StringBuilder o1, StringBuilder o2) {
				return o1.toString().compareToIgnoreCase(o2.toString());
			}
		});
		Collection<Partitionable> nullElements = mPartitionService.getRootElements(connection.getNullPartition());
		for (Partitionable nullElement : nullElements) {
			infos.add(getElementInfo((RefObject) nullElement));
		}
		return infos;
	}

	private Map<PRI, Set<StringBuilder>> getTransientElementsInfo(Connection connection) {
		// sort all entries alphabetically
		Map<PRI, Set<StringBuilder>> transientInfos = new TreeMap<PRI, Set<StringBuilder>>(new Comparator<PRI>() {
			public int compare(PRI o1, PRI o2) {
				return o1.toString().compareToIgnoreCase(o2.toString());
			}
		});
		Collection<MRI> transientElements = connection.getReferencedTransientElements();
		for (MRI mri : transientElements) {
			RefBaseObject element = connection.getElement(mri);
			if (element instanceof RefObject) {
				PRI pri = mri.getPri();
				StringBuilder info = getElementInfo((RefObject) element);
				Set<StringBuilder> infos = transientInfos.get(pri);
				if (infos == null) {
					infos = new TreeSet<StringBuilder>(new Comparator<StringBuilder>() {
						public int compare(StringBuilder o1, StringBuilder o2) {
							return o1.toString().compareToIgnoreCase(o2.toString());
						}
					});
					transientInfos.put(pri, infos);
				}
				infos.add(info);
			}
		}
		return transientInfos;
	}

	private StringBuilder getElementInfo(RefObject element) {
		StringBuilder info = new StringBuilder();

		String type = ((ModelElement) element.refMetaObject()).getName();
		info.append(type);
		info.append(": "); //$NON-NLS-1$

		Map<Attribute, Object> attributes = ModelAdapterUI.getInstance().getJmiHelper(element).getAttributesWithValues(
				element, true);
		StringBuilder id = new StringBuilder();
		for (Entry<Attribute, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey().getName();
			if ("name".equalsIgnoreCase(attributeName)) { //$NON-NLS-1$
				id.append(attributeName);
				id.append(" = "); //$NON-NLS-1$
				id.append(String.valueOf(entry.getValue()));
				break;
			} else if ("id".equalsIgnoreCase(attributeName)) { //$NON-NLS-1$
				id.append(attributeName);
				id.append(" = "); //$NON-NLS-1$
				id.append(String.valueOf(entry.getValue()));
				break;
			}
		}
		if (id.length() == 0)
			id.append(((Partitionable) element).get___Mri().getMofId());

		return info.append(id);
	}

	private static Map<String, Integer> getButtonLabelsAndIds() {
		Map<String, Integer> buttons = new LinkedHashMap<String, Integer>(3);
		buttons.put(IDialogConstants.OK_LABEL, IDialogConstants.OK_ID);
		buttons.put(MiFwkUiMessages.AssignElementsDialog_deleteButton_text, ID_CLEAR);
		buttons.put(IDialogConstants.CANCEL_LABEL, IDialogConstants.CANCEL_ID);
		return buttons;
	}

	private void setHeightForItems(Table table, int itemCount) {
		Object data = table.getLayoutData();
		if (data instanceof GridData) {
			int listHeight = table.getItemHeight() * itemCount;
			Rectangle trim = table.computeTrim(0, 0, 0, listHeight);
			((GridData) data).heightHint = trim.height;
		}
	}

	private void setHeightForItems(Text text, int itemCount) {
		Object data = text.getLayoutData();
		if (data instanceof GridData) {
			int listHeight = text.getLineHeight() * itemCount;
			Rectangle trim = text.computeTrim(0, 0, 0, listHeight);
			((GridData) data).heightHint = trim.height;
		}
	}

	private final class NewPartitionListener implements SelectionListener {
		private final TableViewer mTablePartition;

		private NewPartitionListener(TableViewer partitions) {
			mTablePartition = partitions;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			widgetSelected(e);
		}

		public void widgetSelected(SelectionEvent e) {
			InputDialog dialog = new PartitionInputDialog(mConnection, mProject, mTablePartition.getSelection(),
					getShell());
			if (dialog.open() != Window.OK)
				return;

			String value = dialog.getValue();
			ModelPartition partition = mPartitionService.createPartition(mConnection, mProject, new Path(value), null);
			if (partition != null) {
				PRI pri = partition.getPri();
				mCreatedPartitions.add(pri);
				mTablePartition.refresh();
				mTablePartition.setSelection(new StructuredSelection(pri));
			}
		}
	}

	private static final class PartitionInputDialog extends InputDialog {
		private PartitionInputDialog(final Connection connection, final IProject project, ISelection tableSelection,
				Shell shell) {
			super(shell, MiFwkUiMessages.AssignElementsDialog_inputDialog_title,
					MiFwkUiMessages.AssignElementsDialog_inputDialog_text, getPartitionPathProposal(connection,
							project, tableSelection), new IInputValidator() {
						public String isValid(String newText) {
							if (newText != null && newText.length() == 0)
								return null;
							IPath path = new Path(newText);
							try {
								PRI pri = PartitionService.getInstance().getPRI(project, path);
								if (connection.partitionExists(pri)) {
									return MiFwkUiMessages.bind(
											MiFwkUiMessages.AssignElementsDialog_inputDialog_partitionExists_error, pri
													.toString());
								}
							} catch (RuntimeException e) { // $JL-EXC$
								String msg = e.getLocalizedMessage();
								if (msg == null)
									msg = e.getMessage();
								if (msg == null) { // exception without message
									msg = MiFwkUiMessages.bind(
											MiFwkUiMessages.AssignElementsDialog_inputDialog_partitionInvalid_error,
											path);
								}
								return msg;
							}
							return null;
						}
					});
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setData(WIDGET_DATA_NAME, SHELL_NAME_PARTITION_INPUT);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Control control = super.createDialogArea(parent);
			getText().setData(WIDGET_DATA_NAME, TEXT_NAME_PARTITION_INPUT);
			return control;
		}

		private static String getPartitionPathProposal(Connection connection, IProject project, ISelection selection) {
			// consider selection in table
			PRI pri = (PRI) ((IStructuredSelection) selection).getFirstElement();
			if (pri == null) {
				// consider first partition
				Collection<PRI> partitions = PartitionService.getInstance().getPartitions(connection, project);
				if (partitions.size() > 0)
					pri = partitions.iterator().next();
			}

			if (pri != null) {
				String name = pri.getPartitionName();
				IPath path = new Path(name);
				String extension = path.getFileExtension();
				path = path.removeFileExtension().removeLastSegments(1);
				path = path.append("newPartition").addFileExtension(extension); //$NON-NLS-1$
				return path.toString();
			}

			return null;
		}
	}

	private final class PartitionsTableContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			Collection<PRI> partitions = mPartitionService.getPartitions(mConnection, mProject);
			Collection<PRI> result = new TreeSet<PRI>(new Comparator<PRI>() {
				public int compare(PRI o1, PRI o2) {
					int i = o1.toString().compareToIgnoreCase(o2.toString());
					return i;
				}
			});
			result.addAll(partitions);
			result.addAll(mCreatedPartitions);
			return result.toArray(new PRI[result.size()]);
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private static final class PartitionsTableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			PRI pri = ((PRI) element);
			switch (columnIndex) {
				case 0:
					String partitionName = pri.getPartitionName();
					return partitionName;
				default:
					break;
			}
			return null;
		}

		public String getTooltipText(Object element) {
			PRI pri = (PRI) element;
			if (pri != null)
				return pri.toString();
			return null;
			// element may be null when hovering over whole table
		}
	}

	private final class PartitionsTableSelectionChangedListener implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			IStructuredSelection selection = (IStructuredSelection) event.getSelectionProvider().getSelection();
			boolean enabled = !selection.isEmpty();
			getButton(IDialogConstants.OK_ID).setEnabled(enabled);
			mSelectedPri = (PRI) selection.getFirstElement();
		}
	}

	private final class PartitionsDoubleClickListener implements IDoubleClickListener {
		public void doubleClick(DoubleClickEvent event) {
			IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			if (!selection.isEmpty()) {
				mSelectedPri = (PRI) selection.getFirstElement();
				event.getViewer().getControl().getDisplay().asyncExec(new Runnable() {
					public void run() {
						okPressed();
					}
				});
			}
		}
	}

}
