package com.sap.ide.moftool.editor.fwk;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.part.IPageSite;

import com.sap.mi.fwk.ui.ModelAdapterUI;

public abstract class TreeSection extends SectionPart implements ISelectionChangedListener {

	private TreeViewer mTreeViewer = null;
	private ActionGroup mActionProvider;
	private MenuManager menuManager;
	private final IWorkbenchPart part;

	public TreeSection(final IWorkbenchPart part, Composite parent, final IManagedForm managedForm, String title) {
		super(parent, managedForm.getToolkit(), Section.EXPANDED | Section.TITLE_BAR);
		this.part = part;
		initialize(managedForm);

		getSection().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
		getSection().setText(title);
		TableWrapData twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		twdy.grabHorizontal = true;
		twdy.grabVertical = true;
		getSection().setLayoutData(twdy);

		Composite rootComposite = managedForm.getToolkit().createComposite(getSection());
		managedForm.getToolkit().paintBordersFor(rootComposite);
		if (getSection().getLayout() instanceof FormLayout) {
			FormData fd = new FormData();
			fd.top = new FormAttachment(0);
			fd.right = new FormAttachment(100);
			fd.left = new FormAttachment(0);
			fd.bottom = new FormAttachment(100);
			rootComposite.setLayoutData(fd);
		} else if (getSection().getLayout() instanceof GridLayout) {
			rootComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		}

		getSection().setClient(rootComposite);

		GridLayout layout = new GridLayout(1, false);
		rootComposite.setLayout(layout);
		rootComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		mTreeViewer = new TreeViewer(managedForm.getToolkit().createTree(rootComposite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL));
		mTreeViewer.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TREE_BORDER);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.minimumHeight = 100;
		mTreeViewer.getTree().setLayoutData(gridData);
		mTreeViewer.setContentProvider(createContentProvider());
		mTreeViewer.setLabelProvider(createLabelProvider());
		mTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				managedForm.fireSelectionChanged(TreeSection.this, event.getSelection());
			}
		});

		mTreeViewer.addSelectionChangedListener(this);

		menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);

		createGroupsInMenu(menuManager);

		menuManager.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				updateActions(mTreeViewer.getSelection());
			}
		});

		// create context menu
		Menu menu = ((MenuManager) menuManager).createContextMenu(mTreeViewer.getControl());
		mTreeViewer.getControl().setMenu(menu);
		// register context menu for extension

		if (part != null) {
			part.getSite().registerContextMenu((MenuManager) menuManager, mTreeViewer);
		}

	}

	protected void createGroupsInMenu(MenuManager menuManager) {
		menuManager.add(new Separator());
		menuManager.add(new GroupMarker(IWorkbenchActionConstants.M_NAVIGATE));
		menuManager.add(new Separator());
		menuManager.add(new GroupMarker(IWorkbenchActionConstants.GROUP_REORGANIZE));
		menuManager.add(new Separator());
		menuManager.add(new Separator(IContextMenuConstants.GROUP_SEARCH));
		menuManager.add(new Separator(IContextMenuConstants.GROUP_SEARCH + "-end")); //$NON-NLS-1$
		menuManager.add(new Separator());
		menuManager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuManager.add(new Separator());
	}

	private void updateActions(ISelection selection) {
		IActionBars actionBars = null;
		IWorkbenchPartSite site = part.getSite();

		if (site instanceof IViewSite)
			actionBars = ((IViewSite) site).getActionBars();
		else if (site instanceof IEditorSite)
			actionBars = ((IEditorSite) site).getActionBars();
		else if (site instanceof IPageSite)
			actionBars = ((IPageSite) site).getActionBars();

		if (mActionProvider == null) {
			mActionProvider = getActionProvider(part);
		}
		ActionContext context = new ActionContext(selection);
		context.setInput(mTreeViewer.getInput());

		mActionProvider.setContext(context);
		mActionProvider.fillContextMenu(menuManager);

		if (actionBars != null) {
			mActionProvider.fillActionBars(actionBars);
			actionBars.updateActionBars();
		}

	}

	protected ActionGroup getActionProvider(IWorkbenchPart part) {
		return new ActionGroup() {
		};
	}

	protected abstract IBaseLabelProvider createLabelProvider();

	protected abstract ITreeContentProvider createContentProvider();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {
		mTreeViewer.getTree().setFocus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * This implementation forces a SelectionChangeEvent whenever the
	 * RefBaseObject instance represented by <code>input</code> changes. This is
	 * required in order to update the details part of a MasterDetailPart in
	 * case a PartitionChangeEvent should be propagated.
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		RefBaseObject refBaseObject = ModelAdapterUI.getInstance().getRefBaseObject(input);
		if (mTreeViewer.getInput() != refBaseObject) {
			mTreeViewer.setInput(refBaseObject);
			// propagate update to details part even if selection does not
			// change, otherwise details part is not updated in case of
			// PartitionChangeEvents
			mTreeViewer.setSelection(mTreeViewer.getSelection());
		}
		return true;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		StructuredSelection selection = (StructuredSelection) event.getSelection();

		updateActions(selection);
	}
	
	public TreeViewer test___getTreeViewer() {
		return mTreeViewer;
	}

}
