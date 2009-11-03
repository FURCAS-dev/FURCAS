package com.sap.mi.fwk.ui.internal.mm;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetPage;

import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * The selection page for the metamodels working set
 * 
 * @author d031150
 */
public final class MmWorkingSetPage extends WizardPage implements IWorkingSetPage {

	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$

	private static final TracerI sTracer = TracingManager.getTracer(MmWorkingSetPage.class);

	private IWorkingSet mWorkingSet;
	private CheckboxTableViewer mViewer;
	private Text mText;
	private boolean mFirstCheck = true;

	public MmWorkingSetPage() {
		super(MmWorkingSetPage.class.getName());
		setTitle(MiFwkUiMessages.MmWorkingSetPage_title);
		setDescription(MiFwkUiMessages.MmWorkingSetPage_description);
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		enableProgressMonitor();

		Font font = parent.getFont();

		Composite root = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		root.setLayout(layout);
		root.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		setControl(root);

		Label label = new Label(root, SWT.WRAP);
		label.setText(MiFwkUiMessages.MmWorkingSetPage_name_label);
		GridData data = new GridData();
		label.setLayoutData(data);
		label.setFont(font);

		mText = new Text(root, SWT.SINGLE | SWT.BORDER);
		data = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL);
		mText.setLayoutData(data);
		mText.setFont(font);

		mText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				validateInput();
			}
		});
		mText.setData(WIDGET_DATA_NAME, "MmWorkingSetPage.nameWorkingSet"); //$NON-NLS-1$ for testing

		label = new Label(root, SWT.WRAP);
		label.setText(MiFwkUiMessages.MmWorkingSetPage_content_label);
		data = new GridData();
		label.setLayoutData(data);
		label.setFont(font);

		mViewer = CheckboxTableViewer.newCheckList(root, SWT.BORDER | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);
		Table table = mViewer.getTable();
		data = new GridData(GridData.FILL_BOTH | GridData.GRAB_VERTICAL);
		data.heightHint = convertHeightInCharsToPixels(15);
		table.setLayoutData(data);

		mViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				validateInput();

				// Convenience: if no working set name has been entered and one
				// element
				// is checked, take this metamodels name.
				String text = mText.getText();
				if (event.getChecked() && (text == null || text.length() == 0)) {
					IAdaptable element = (IAdaptable) event.getElement();
					MmDeploymentInfo metamodel = (MmDeploymentInfo) element.getAdapter(MmDeploymentInfo.class);
					mText.setText(metamodel.getLabel());
				}
			}
		});
		final MmContentProvider contentProvider = new MmContentProvider();
		mViewer.setContentProvider(contentProvider);
		mViewer.setLabelProvider(new MmLabelProvider());
		mViewer.setComparator(new ViewerComparator());
		mViewer.setData(WIDGET_DATA_NAME, "MmWorkingSetPage.tableWorkingSets"); //$NON-NLS-1$ for testing
		mViewer.setInput(this);

		Composite buttonComposite = new Composite(root, SWT.NONE);
		buttonComposite.setLayout(new GridLayout(2, false));
		buttonComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		Button selectAllButton = new Button(buttonComposite, SWT.PUSH);
		selectAllButton.setText(MiFwkUiMessages.MmWorkingSetPage_selectAllButton_text);
		selectAllButton.setToolTipText(MiFwkUiMessages.MmWorkingSetPage_selectAllButton_tooltip);
		selectAllButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent selectionEvent) {
				mViewer.setCheckedElements(contentProvider.getElements(mViewer.getInput()));
				validateInput();
			}
		});
		selectAllButton.setFont(font);
		setButtonLayoutData(selectAllButton);

		Button deselectAllButton = new Button(buttonComposite, SWT.PUSH);
		deselectAllButton.setText(MiFwkUiMessages.MmWorkingSetPage_deselectAllButton_text);
		deselectAllButton.setToolTipText(MiFwkUiMessages.MmWorkingSetPage_deselectAllButton_tooltip);
		deselectAllButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent selectionEvent) {
				mViewer.setCheckedElements(new Object[0]);
				validateInput();
			}
		});
		deselectAllButton.setFont(font);
		setButtonLayoutData(deselectAllButton);

		setPageComplete(false);
	}

	public void finish() {
		Object[] content = mViewer.getCheckedElements();
		IAdaptable[] elements = new IAdaptable[content.length];
		System.arraycopy(content, 0, elements, 0, content.length);

		if (mWorkingSet == null) {
			IWorkingSetManager workingSetManager = PlatformUI.getWorkbench().getWorkingSetManager();
			mWorkingSet = workingSetManager.createWorkingSet(mText.getText(), elements);
		} else {
			mWorkingSet.setName(mText.getText());
			mWorkingSet.setElements(elements);
		}
	}

	public IWorkingSet getSelection() {
		return mWorkingSet;
	}

	public void setSelection(IWorkingSet workingSet) {
		mWorkingSet = workingSet;
	}

	@Override
	public boolean isPageComplete() {
		return validate();
	}

	private void initializeUI() {
		if (mWorkingSet != null) {
			IAdaptable[] elements = mWorkingSet.getElements();
			mViewer.setCheckedElements(elements);
			mText.setText(mWorkingSet.getName());
			mViewer.getControl().setFocus();
		} else {
			mText.setFocus();
		}
	}

	private void validateInput() {
		mFirstCheck = false;
		validate();
		getContainer().updateButtons();
	}

	/**
	 * Validates the working set name and the selection state of the viewer
	 */
	private boolean validate() {
		String errorMessage = null;
		String infoMessage = null;
		if (mText == null)
			return false;

		String newText = mText.getText();

		if (newText.equals(newText.trim()) == false) {
			errorMessage = MiFwkUiMessages.MmWorkingSetPage_name_whitespace_error;
		} else if (newText.length() == 0) {
			errorMessage = MiFwkUiMessages.MmWorkingSetPage_name_empty_error;
		}
		if (errorMessage == null && (mWorkingSet == null || !newText.equals(mWorkingSet.getName()))) {
			IWorkingSet[] workingSets = PlatformUI.getWorkbench().getWorkingSetManager().getWorkingSets();
			for (int i = 0; i < workingSets.length; i++) {
				if (newText.equals(workingSets[i].getName())) {
					errorMessage = MiFwkUiMessages.MmWorkingSetPage_set_exists_error;
				}
			}
		}
		if (mViewer.getCheckedElements().length == 0) {
			infoMessage = MiFwkUiMessages.MmWorkingSetPage_noSet_info;
		}

		if (!mFirstCheck) {
			setMessage(infoMessage, INFORMATION);
			setErrorMessage(errorMessage);
		}
		return errorMessage == null;
	}

	private void enableProgressMonitor() {
		IWizard iWizard = getWizard();
		if (iWizard instanceof Wizard) {
			Wizard wizard = (Wizard) iWizard;
			wizard.setNeedsProgressMonitor(true);
		}
	}

	private final class MmContentProvider implements IStructuredContentProvider {
		private boolean mMetamodelsFetched = false;
		private Viewer mViewer;

		public Object[] getElements(Object inputElement) {
			if (!mMetamodelsFetched) {
				scheduleFetchMetamodels();
				return new Object[] { MiFwkUiMessages.MmWorkingSetPage_pendingNode_label };
			}

			Collection<MmDeploymentInfo> metamodels = MetamodelManager.getInstance().getDeployedMetamodels();
			IAdaptable[] result = new MmAdaptable[metamodels.size()];
			int i = 0;
			for (MmDeploymentInfo metamodel : metamodels)
				result[i++] = new MmAdaptable(metamodel);
			return result;
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			mViewer = viewer;
		}

		private void scheduleFetchMetamodels() {
			final IRunnableWithProgress op = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					monitor.beginTask(MiFwkUiMessages.MmWorkingSetPage_task_fetching, 10);
					MetamodelManager.getInstance().getDeployedMetamodels();
					mMetamodelsFetched = true;
					monitor.worked(10);
					monitor.done();
				}
			};

			// Schedule async since otherwise UI is blocked until operation has
			// finished, but we want to display the pending node in the
			// meanwhile.
			mViewer.getControl().getDisplay().asyncExec(new Runnable() {
				public void run() {
					try {
						getContainer().run(true, false, op);
						mViewer.refresh();
						initializeUI(); // set checked items correctly
					} catch (InvocationTargetException e) { // $JL-EXC$
						Throwable cause = e.getCause();
						MiFwkUIPlugin.showErrorDialog(cause, "Unable to retrieve metamodels", null, sTracer); //$NON-NLS-1$
					} catch (InterruptedException e) { // $JL-EXC$
					}
				}
			});
		}

	}

	private static final class MmLabelProvider extends LabelProvider {
		public String getText(Object element) {
			if (element instanceof IAdaptable) {
				MmDeploymentInfo mm = (MmDeploymentInfo) ((IAdaptable) element).getAdapter(MmDeploymentInfo.class);
				return mm.getLabel();
			}
			return super.getText(element);
		}
	}

}
