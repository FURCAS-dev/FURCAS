package com.sap.mi.tools.cockpit.mql.ui.form;

import java.io.File;
import java.util.Collections;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.mql.Messages;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.model.ArtificialRootNode;
import com.sap.mi.tools.cockpit.mql.model.IModelChangedListener;
import com.sap.mi.tools.cockpit.mql.model.Model;
import com.sap.mi.tools.cockpit.mql.model.OP;
import com.sap.mi.tools.cockpit.mql.model.QueryTemplateNode;
import com.sap.mi.tools.cockpit.mql.wizard.QueryTemplateWizard;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * @author d003456
 * 
 */
public final class QueryMasterDetailPart extends MasterDetailsBlock implements IModelChangedListener {

	private static final TracerI tracer = TracingManager.getTracer(MiLocations.MI_MQLVIEW);

	private final static String FORM_TITLE = Messages.QueryMasterDetailPart_0_xhed;

	private final static String EXPORT_DIALOG_TITLE = Messages.QueryMasterDetailPart_1_xhed;

	private final static String IMPORT_DIALOG_TITLE = Messages.QueryMasterDetailPart_2_xhed;

	private final static String DIALOG_MESSAGE = Messages.QueryMasterDetailPart_3_xmsg;

	private final static String TOOL_TIP_HORIZONTAL = Messages.QueryMasterDetailPart_4_xtol;

	private final static String TOOL_TIP_VERTICAL = Messages.QueryMasterDetailPart_5_xtol;

	private final static String XML_EXTENSION = "*.xml"; //$NON-NLS-1$

	private TemplatesViewPart templatesViewPart;

	private IStructuredSelection currSelection;

	private TreeViewer treeViewer;

	private final ArtificialRootNode root;

	private final Model model;

	private final QueryDetailsPage page;

	private DetailsPart detailsPart;

	/**
	 * Creates {@link QueryMasterDetailPart}.
	 */
	public QueryMasterDetailPart() {

		this.page = new QueryDetailsPage();
		this.model = Model.getInstance();
		this.root = new ArtificialRootNode();
	}

	/**
	 * Create contents of the master details block.
	 * 
	 * @param managedForm
	 * @param parent
	 */
	@Override
	protected void createMasterPart(final IManagedForm managedForm, Composite parent) {

		final FormToolkit toolkit = managedForm.getToolkit();
		this.templatesViewPart = new TemplatesViewPart(parent, this, toolkit, ExpandableComposite.TWISTIE | Section.DESCRIPTION
				| ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
		this.treeViewer = this.templatesViewPart.getTreeViewer();

		addSelectionListenersToButtons();
		this.treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {

				final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				QueryMasterDetailPart.this.currSelection = selection;
				managedForm.fireSelectionChanged(QueryMasterDetailPart.this.templatesViewPart, event.getSelection());
			}
		});
		// Label provider for the tree
		final ILabelProvider labelProvider = new LabelProvider() {
			@Override
			public Image getImage(Object element) {

				if (element instanceof QueryTemplateNode) {
					return QueryConsole.getDefault().getImage(QueryConsole.TEMPLATE_QUERY_IMAGE);
				}
				return super.getImage(element);
			}

			@Override
			public String getText(Object element) {

				if (element instanceof QueryTemplateNode) {
					return ((QueryTemplateNode) element).getTemplateName();
				}
				return super.getText(element);
			}
		};

		final TreeContentProvider contentProvider = new TreeContentProvider();
		this.treeViewer.setContentProvider(contentProvider);
		this.treeViewer.setLabelProvider(labelProvider);
		this.model.addModelChangedListener(this);
		managedForm.getForm().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {

				QueryMasterDetailPart.this.model.removeModelChangedListener(QueryMasterDetailPart.this);

			}
		});
	}

	private void addSelectionListenersToButtons() {

		this.templatesViewPart.getDeleteButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				doDelete();
			}
		});
		this.templatesViewPart.getAddButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {

				doAdd();
			}
		});
		this.templatesViewPart.getResetButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				doReset();
			}
		});
		this.templatesViewPart.getImportButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				doImport();
			}
		});
		this.templatesViewPart.getExportButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				doExport();
			}
		});
		this.templatesViewPart.getUpButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				doMoveUp();
			}
		});
		this.templatesViewPart.getDownButton().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				doMoveDown();
			}
		});
	}

	public void setInput() {

		this.model.setRoot(this.root);
		this.treeViewer.setInput(this.root);
		if (this.root.hasChildren()) {
			changeButtonsState(true);
			setSelectionToFirstElement();
		} else {
			changeButtonsState(false);
		}
	}

	private void doDelete() {

		if (this.currSelection != null && !this.currSelection.isEmpty()) {
			final ArtificialRootNode parent = ((QueryTemplateNode) this.currSelection.getFirstElement()).getParent();
			parent.removeChildren((QueryTemplateNode) this.currSelection.getFirstElement());
			this.model.saveModel();
		}
	}

	private void doAdd() {

		final QueryTemplateWizard wizard = new QueryTemplateWizard();
		wizard.init(PlatformUI.getWorkbench(), this.currSelection);
		final WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
		dialog.setPageSize(100, 30);
		dialog.open();
		this.model.saveModel();
	}

	private void doReset() {

		this.model.resetModel();
		this.model.saveModel();
	}

	private void doImport() {

		boolean importOK = true;
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		final FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		dialog.setText(QueryMasterDetailPart.IMPORT_DIALOG_TITLE);
		dialog.setFilterExtensions(new String[] { QueryMasterDetailPart.XML_EXTENSION });

		final String fileName = dialog.open();
		if (fileName != null && new Path(fileName).isValidPath(fileName)) {
			final File file = new File(fileName);
			try {
				this.model.importModel(file);
				importOK = true;
			}
			catch (final Exception ex) {
				importOK = false;
				QueryMasterDetailPart.tracer.error(ex.getMessage(), ex);
			}
		}
		if (!importOK) {
			MessageDialog.openError(shell, QueryMasterDetailPart.IMPORT_DIALOG_TITLE, QueryMasterDetailPart.DIALOG_MESSAGE);
		}
	}

	private void doExport() {

		boolean exportOK = true;
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		final FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setText(QueryMasterDetailPart.EXPORT_DIALOG_TITLE);
		dialog.setFilterExtensions(new String[] { QueryMasterDetailPart.XML_EXTENSION });

		final String fileName = dialog.open();
		if (fileName != null && new Path(fileName).isValidPath(fileName)) {
			final File file = new File(fileName);
			try {
				this.model.exportModel(file);
				exportOK = true;
			}
			catch (final Exception ex) {
				exportOK = false;
				QueryMasterDetailPart.tracer.error(ex.getMessage(), ex);
			}
		}
		if (!exportOK) {
			MessageDialog.openError(shell, QueryMasterDetailPart.EXPORT_DIALOG_TITLE, QueryMasterDetailPart.DIALOG_MESSAGE);
		}
	}

	private void doMoveUp() {

		if (this.currSelection != null && !this.currSelection.isEmpty() && this.root.getChildren().size() > 1) {
			this.root.moveUp((QueryTemplateNode) this.currSelection.getFirstElement());
		}
	}

	private void doMoveDown() {

		if (this.currSelection != null && !this.currSelection.isEmpty() && this.root.getChildren().size() > 1) {
			this.root.moveDown((QueryTemplateNode) this.currSelection.getFirstElement());
		}
	}

	/**
	 * Register the pages.
	 * 
	 * @param part
	 */
	@Override
	protected void registerPages(DetailsPart part) {

		this.detailsPart = part;
		this.detailsPart.registerPage(QueryTemplateNode.class, this.page);
	}

	/**
	 * Create the tool bar actions.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createToolBarActions(IManagedForm managedForm) {

		final ScrolledForm form = managedForm.getForm();
		final Action horizontalAction = new Action("hor", IAction.AS_RADIO_BUTTON) { //$NON-NLS-1$
			@Override
			public void run() {

				QueryMasterDetailPart.this.sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		horizontalAction.setChecked(true);
		horizontalAction.setToolTipText(QueryMasterDetailPart.TOOL_TIP_HORIZONTAL);
		horizontalAction.setImageDescriptor(QueryConsole.getDefault().getImageRegistry().getDescriptor(
				QueryConsole.HORIZONTAL_ORIENTATION_IMAGE));
		final Action verticalAction = new Action("ver", IAction.AS_RADIO_BUTTON) { //$NON-NLS-1$
			@Override
			public void run() {

				QueryMasterDetailPart.this.sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		verticalAction.setChecked(false);
		verticalAction.setToolTipText(QueryMasterDetailPart.TOOL_TIP_VERTICAL);
		verticalAction.setImageDescriptor(QueryConsole.getDefault().getImageRegistry().getDescriptor(
				QueryConsole.VERTICAL_ORIENTATION_IMAGE));
		form.getToolBarManager().add(horizontalAction);
		form.getToolBarManager().add(verticalAction);

	}

	public void setSelectionToFirstElement() {

		if (this.root.getChildren().size() > 0 && ((ITreeSelection) this.treeViewer.getSelection()).getFirstElement() == null) {
			this.treeViewer.setSelection(new StructuredSelection(this.root.getChildren().get(0)), true);
			setFocus();
			setFocusToDetails();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.MasterDetailsBlock#createContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	public void createContent(IManagedForm managedForm) {

		super.createContent(managedForm);
		// resize master part to 45% of total length
		super.sashForm.setWeights(new int[] { 45, 55 });
		final ScrolledForm form = managedForm.getForm();
		form.setText(QueryMasterDetailPart.FORM_TITLE);
		form.setBackgroundImage(QueryConsole.getDefault().getImage(QueryConsole.FORM_BG_IMAGE));

	}

	public boolean setFocus() {

		if (this.treeViewer != null) {
			if (this.treeViewer.getControl() != null && !this.treeViewer.getControl().isDisposed()) {
				return this.treeViewer.getControl().setFocus();
			}
		}
		return false;
	}

	public void setFocusToDetails() {

		if (this.detailsPart != null) {
			final IDetailsPage page = this.detailsPart.getCurrentPage();
			if (page != null) {
				page.setFocus();
			}
		}

	}

	private void changeButtonsState(boolean enabled) {

		this.templatesViewPart.getDeleteButton().setEnabled(enabled);
		this.templatesViewPart.getExportButton().setEnabled(enabled);
		if (enabled && this.root.getChildren().size() > 1) {
			this.templatesViewPart.getUpButton().setEnabled(enabled);
			this.templatesViewPart.getDownButton().setEnabled(enabled);
		} else {
			this.templatesViewPart.getUpButton().setEnabled(false);
			this.templatesViewPart.getDownButton().setEnabled(false);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.mql.model.IModelChangedListener#modelChanged(java.lang.Object, com.sap.mi.tools.cockpit.mql.model.OP)
	 */
	public void modelChanged(Object obj, OP operation) {

		if (this.root.hasChildren()) {
			changeButtonsState(true);
		} else {
			changeButtonsState(false);
		}

		if (obj instanceof ArtificialRootNode) {
			setSelectionToFirstElement();
			return;
		}
		if (operation == OP.MODIFIED) {
			// let label provider change template name
			this.treeViewer.update(new Object[] { obj }, null);
			return;
		}

		// only asyncExec if not called in UI thread
		if (Display.getCurrent() == null) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {

					QueryMasterDetailPart.this.treeViewer.refresh();
				}
			});
		} else {
			this.treeViewer.refresh();
		}

		if (operation == OP.ADDED) {
			this.treeViewer.setSelection(new StructuredSelection(obj), true);
		} else {
			setSelectionToFirstElement();
		}
	}

	public void saveModel() {

		this.model.saveModel();
	}

	/**
	 * @return the templatesViewPart
	 */
	public final TemplatesViewPart getTemplatesViewPart() {

		return this.templatesViewPart;
	}

	final class TreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		public void dispose() {

		}

		public Object[] getElements(Object inputElement) {

			return getChildren(inputElement);
		}

		public Object[] getChildren(Object parentElement) {

			if (parentElement instanceof ArtificialRootNode) {

				return ((ArtificialRootNode) parentElement).getChildren().toArray();
			}
			return Collections.EMPTY_LIST.toArray();
		}

		public Object getParent(Object element) {

			if (element != null && element instanceof QueryTemplateNode) {
				return ((QueryTemplateNode) element).getParent();
			}
			return null;
		}

		public boolean hasChildren(Object element) {

			if (element instanceof ArtificialRootNode) {

				return ((ArtificialRootNode) element).hasChildren();
			}
			return false;
		}
	}

	final class TreeLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {

			return super.getText(element);
		}

		@Override
		public Image getImage(Object element) {

			return QueryConsole.getDefault().getImage(QueryConsole.TEMPLATE_QUERY_IMAGE);
		}
	}

}
