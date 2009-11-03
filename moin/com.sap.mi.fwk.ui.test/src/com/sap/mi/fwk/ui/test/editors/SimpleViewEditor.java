package com.sap.mi.fwk.ui.test.editors;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewContainer;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.fwk.ui.editor.ModelMultiPageEditorPart;
import com.sap.mi.fwk.ui.test.commands.CreateViewContainerCommand;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.PartitionFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * A view editor showing a basic UI element tree. For testing purposes only.
 *
 * @author d031150
 */
public final class SimpleViewEditor extends ModelMultiPageEditorPart {

	public static final String ID = "com.sap.mi.fwk.test.editors.SimpleViewEditor"; //$NON-NLS-1$

	public static SimpleViewEditor open(View view) {
		return open(view, true);
	}

	public static SimpleViewEditor open(View view, boolean wait) {
		SimpleViewEditor editor = (SimpleViewEditor) TestUtil.openModelEditor(view, ID, wait);
		return editor;
	}

	private static boolean sErrorOnSelectionChange;

	private static final TracerI sTracer = TracingManager.getTracer(SimpleViewEditor.class);

	private ModelEditorInput mModelEditorInput;
	private View mView;
	private final ViewChangeListener mViewChangeListener = new ViewChangeListener();
	private final ExternalViewChangeListener mExternalViewChangeListener = new ExternalViewChangeListener();

	TreeViewer mTreeViewer;

	private FormToolkit formToolkit;

	@Override
	protected boolean useDeferredInitialization() {
		return true;
	}

	@Override
	protected void initDeferred(IEditorSite site, IEditorInput input) {
		super.initDeferred(site, input);
		mModelEditorInput = (ModelEditorInput) input;
		mView = (View) mModelEditorInput.getAdapter(View.class);
		setPartName(mView.refImmediateComposite().refGetValue("name") + "." + mView.getName());
		registerChangeListeners();
	}

	@Override
	protected void createPagesDeferred() {
		formToolkit = new FormToolkit(getContainer().getDisplay());

		Composite root = formToolkit.createComposite(getContainer());
		GridLayout gridLayout = new GridLayout(2, true);
		root.setLayout(gridLayout);

		Tree tree = formToolkit.createTree(root, SWT.MULTI | SWT.FULL_SELECTION);
		tree.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, true, true));
		mTreeViewer = new TreeViewer(tree);
		getSite().setSelectionProvider(mTreeViewer);
		mTreeViewer.setContentProvider(new TreeContentProvider());
		mTreeViewer.setLabelProvider(new TreeLabelProvider());
		mTreeViewer.setInput(this);
		mTreeViewer.expandAll();

		Composite buttonArea = formToolkit.createComposite(root, SWT.NO_FOCUS);
		buttonArea.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, true));
		gridLayout = new GridLayout();
		buttonArea.setLayout(gridLayout);
		Button button1 = formToolkit.createButton(buttonArea, "Create ViewContainer using &Command", SWT.PUSH);
		button1.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {
				createViewContainer();
			}
		});
		Button button2 = formToolkit.createButton(buttonArea, "Create ViewContainer using Command &Group", SWT.PUSH);
		button2.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {
				createViewContainerUsingCommandGroup();
			}
		});

		Button button3 = formToolkit.createButton(buttonArea, "Create ViewContainer using direct &JMI Call", SWT.PUSH);
		button3.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {
				createViewContainerUsingJmi();
			}
		});

		// according to eclipse ui spec: editor tabs show object's name
		setPartName(mView.getName());

		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				SimpleViewEditor.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(tree);
		tree.setMenu(menu);
		getSite().registerContextMenu(menuMgr, mTreeViewer);
		getSite().setSelectionProvider(mTreeViewer);

		addPage(root);
		setPageText(0, "View");
		setActivePage(0);
	}

	protected void fillContextMenu(IMenuManager manager) {
		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	@Override
	public void setFocus() {
		if (mTreeViewer != null) {
			mTreeViewer.getControl().setFocus();
		}
	}

	@Override
	public void dispose() {
		EventRegistry eventRegistry = getWorkingConnection().getSession().getEventRegistry();
		eventRegistry.deregister(mViewChangeListener);
		eventRegistry.deregister(mExternalViewChangeListener);
		getSite().setSelectionProvider(null);
		mModelEditorInput = null;
		mView = null;

		if (formToolkit != null) {
			formToolkit.dispose();
		}

		super.dispose();
	}

	public static void setErrorOnSelectionChange(boolean enable) {
		sErrorOnSelectionChange = enable;
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (sErrorOnSelectionChange) {
			throw new RuntimeException("Simulated exception in selection listener");
		}
		super.selectionChanged(part, selection);
	}

	private void createViewContainer() {
		CreateViewContainerCommand command = new CreateViewContainerCommand(getWorkingConnection(), mView);
		command.execute();
		refreshUI();
	}

	private void createViewContainerUsingCommandGroup() {
		CreateViewContainerCommand command = new CreateViewContainerCommand(getWorkingConnection(), mView);
		getWorkingConnection().getCommandStack().openGroup("Create View Container");

		command.doExecute(); // reuse JMI code of the command for this
		// example
		getWorkingConnection().getCommandStack().closeGroup();

		mTreeViewer.refresh();
		mTreeViewer.expandAll();
	}

	private void createViewContainerUsingJmi() {
		ViewContainer vc = CreateViewContainerCommand.exec(mView, null);
		if (vc == null) {
			return;
		}

		mTreeViewer.refresh();
		mTreeViewer.expandAll();
	}

	private class TreeContentProvider implements ITreeContentProvider {
		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof View) {
				View view = (View) parentElement;
				if (((Partitionable) view).is___Alive()) {
					Collection<?> viewContainers = view.getViewContainers();
					return viewContainers.toArray(new Object[viewContainers.size()]);
				}
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if (element instanceof RefObject) {
				RefObject refObject = (RefObject) element;
				return refObject.refImmediateComposite();
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			return element instanceof View;
		}

		public Object[] getElements(Object inputElement) {
			if (!(inputElement instanceof SimpleViewEditor)) {
				return new Object[0];
			}
			return new Object[] { mView };
		}
	}

	private class TreeLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			String objName = element.toString();
			return objName;
		}
	}

	private void registerChangeListeners() {
		ModelPartition viewPartition = ((Partitionable) mView).get___Partition();
		if (viewPartition == null) {
			sTracer.error("could not get View partition");
			return;
		}
		// reigister listener for external changes on the view (e.g. save in
		// other session)
		EventRegistry eventRegistry = getWorkingConnection().getSession().getEventRegistry();
		EventFilter filter = new PartitionFilter(viewPartition);
		eventRegistry.registerListener(mExternalViewChangeListener, filter);
		// register listener for changes on the view (e.g. save in other
		// session)
		filter = new PartitionFilter(viewPartition);
		eventRegistry.registerListener(mViewChangeListener, filter);
	}

	private class ExternalViewChangeListener implements ChangeListener {

		public void notify(ChangeEvent event) {
			refreshUI();
		}

	}

	private class ViewChangeListener implements ChangeListener {

		public void notify(ChangeEvent event) {
			if (!event.getEventTriggerConnection().equals(getWorkingConnection())) {
				refreshUI();
			}
		}

	}

	private void refreshUI() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (mTreeViewer.getControl().isDisposed()) {
					return;
				}
				mTreeViewer.refresh();
				mTreeViewer.expandAll();
			}
		});
	}

}
