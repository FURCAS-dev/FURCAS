package com.sap.mi.fwk.ui.test.editors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.IPartSelectionListener;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.ide.IGotoMarker;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.ViewElement;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.dnd.CopyPasteActionGroup;
import com.sap.mi.fwk.ui.dnd.ModelDragDropSupport;
import com.sap.mi.fwk.ui.editor.ModelDetailsPage;
import com.sap.mi.fwk.ui.editor.ModelFormEditorPart;
import com.sap.mi.fwk.ui.editor.ModelFormPage;
import com.sap.mi.fwk.ui.test.MiFwkUiTestFragment;
import com.sap.mi.fwk.ui.test.commands.CreateRootElementCommand;
import com.sap.mi.fwk.ui.test.commands.CreateUIElementCommand;
import com.sap.mi.fwk.ui.test.commands.CreateViewContainerCommand;
import com.sap.mi.fwk.ui.test.commands.DeleteElementCommand;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.tssap.util.ui.dialog.ObjectSelectionDialog;

/**
 * Shows the {@link View} UI element hierarchy in a tree in a master section and
 * properties of the selected elements in a detail section
 * 
 * @author d031150
 */
public final class ViewEditor extends ModelFormEditorPart implements IGotoMarker, ISelectionListener {

	public static final String ID = "com.sap.mi.fwk.test.editors.ViewEditor"; //$NON-NLS-1$

	public static ViewEditor open(View view) throws PartInitException {
		ViewEditor editor = (ViewEditor) TestUtil.openModelEditor(view, ID);
		return editor;
	}

	private List<IAction> actions = new ArrayList<IAction>();

	private ChangeListener myListener;

	private View view;

	private CopyPasteActionGroup mCopyPasteActionGroup;

	private IMarker marker;

	@Override
	protected boolean useDeferredInitialization() {
		return true;
	}

	@Override
	protected void initDeferred(IEditorSite site, IEditorInput input) {
		super.initDeferred(site, input);
		view = ((View) input.getAdapter(View.class));
		if (view == null) {
			throw new IllegalStateException("No view in input " + input);
		}
		setPartName(view.getName());

		final Display display = site.getShell().getDisplay();
		myListener = new ChangeListener() {
			public void notify(ChangeEvent event) {
				display.asyncExec(new Runnable() {
					public void run() {
						IFormPage page = getActivePageInstance();
						if (page != null)
							page.getManagedForm().refresh();
						if (marker != null) {
							gotoMarker(marker);
							marker = null;
						}
					}
				});
			}
		};
		EventFilter filter = new OrFilter(new EventTypeFilter(ModelChangeEvent.class));
		EventRegistry eventRegistry = getWorkingConnection().getSession().getEventRegistry();
		eventRegistry.registerListener(myListener, filter);
	}

	public View getView() {
		return view;
	}

	@Override
	public void dispose() {
		EventRegistry eventRegistry = getWorkingConnection().getSession().getEventRegistry();
		eventRegistry.deregister(myListener);

		super.dispose();
	}

	@Override
	public void setFocus() {
		IFormPage page = getActivePageInstance();
		if (page != null)
			page.setFocus();
	}

	public void gotoMarker(IMarker marker) {
		Connection con = getWorkingConnection();
		if (con == null || !con.isAlive()) {
			this.marker = marker;
			return;
		}

		RefBaseObject obj = ModelManager.getMarkerManager().getObject(getWorkingConnection(), marker);
		IFormPage page = getActivePageInstance();
		if (page != null)
			page.selectReveal(obj);
	}

	@Override
	protected void addPagesDeferred() {
		try {
			addPage(new MainPage());
			setActivePage(0);
		} catch (PartInitException e) {
			throw new RuntimeException(e);
		}
	}

	private void fillContextMenu(IMenuManager manager) {
		mCopyPasteActionGroup.fillContextMenu(manager, IWorkbenchActionConstants.GROUP_REORGANIZE);
		manager.add(new Separator());

		for (IAction action : actions) {
			if (action != null) {
				manager.add(action);
			} else {
				manager.add(new Separator());
			}
		}

		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void contributeToActionBars() {
		IActionBars bars = getEditorSite().getActionBars();
		mCopyPasteActionGroup.fillActionBars(bars);
	}

	public class ViewEditorProvider extends LabelProvider implements ITreeContentProvider, ITableLabelProvider {

		public Object[] getChildren(Object parentElement) {
			Collection<RefObject> children = Collections.emptyList();
			if (parentElement instanceof RefObject) {
				RefObject o = (RefObject) parentElement;
				if (((Partitionable) o).is___Alive()) {
					children = ModelAdapterUI.getInstance().getJmiHelper(o).getCompositeChildrenStable(o, false);
				}
			}
			return children.toArray(new RefObject[children.size()]);
		}

		public Object getParent(Object element) {
			RefObject o = (RefObject) element;
			if (((Partitionable) o).is___Alive())
				return o.refImmediateComposite();
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof View) {
				View view = (View) inputElement;
				UielementContainer container = view.getRootUielementContainer();
				if (container != null)
					return new Object[] { container };
			}
			return new Object[0];
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == 0) {
				String type = ((ModelElement) ((RefBaseObject) element).refMetaObject()).getName();
				return MiFwkUiTestFragment.getImageRegistry().get(type);
			}
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element != null && ((Partitionable) element).is___Alive()) {
				switch (columnIndex) {
				case 0:
					return ModelManager.getInstance().getObjectName(element);
				case 1:
					return ((ModelElement) ((RefBaseObject) element).refMetaObject()).getName();
				case 2:
					AssociationEnd aggr = getContainingAggregation((RefObject) element);
					return aggr != null ? aggr.otherEnd().getName() : "?";
				default:
					break;
				}
			}
			return "";
		}
	}

	private AssociationEnd getContainingAggregation(RefObject objectTarget) {
		RefObject parent = (RefObject)objectTarget.refImmediateComposite();
		
		if (parent != null) {
			JmiHelper jmiHelper = parent.get___Connection().getJmiHelper();
			Set<AssociationEnd> assocEnds = jmiHelper.getAssociationEnds((MofClass) parent.refMetaObject(), true);
		
			for (AssociationEnd assocEnd : assocEnds) {
				Association aggr = (Association)assocEnd.refImmediateComposite();
				
				if (assocEnd.equals(jmiHelper.getCompositeAssociationEnd(aggr))) {
					RefAssociation refassoc = jmiHelper.getRefAssociationForAssociation(aggr);
					if (refassoc != null) {
						String assocEndName = assocEnd.getName();
						Collection<RefObject> refObjects = refassoc.refQuery(assocEndName, parent);
						for (RefObject refObject : refObjects) {
							if (objectTarget.equals(refObject)) {
								return assocEnd;
							}
						} 
					}
				}
			}
		}
		return null;
	}

	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		IFormPage page = getActivePageInstance();
		if (page == null) {
			return;
		}

		IStructuredSelection strSel = (IStructuredSelection) selection;

		Object obj = strSel.getFirstElement();
		RefObject refObj = ModelAdapter.getInstance().adaptObject(obj, RefObject.class);
		if (refObj != null) {
			// creates a new selection which the local tree understands
			// local tree contains native metadata objects and therefore
			// it is neccessary to unadapt the object and put it in the
			// new selection
			page.selectReveal(refObj);
		}
	}

	final class DragListener extends DragSourceAdapter {
		private final TreeViewer treeViewer;

		DragListener(TreeViewer treeViewer) {
			this.treeViewer = treeViewer;
		}

		public void dragStart(DragSourceEvent event) {
			System.out.println("DragListener.dragStart()");
			List<RefObject> selectedObjects = getSelectedObjects();
			event.doit = !selectedObjects.isEmpty();
			if (event.doit)
				LocalSelectionTransfer.getTransfer().setSelection(new StructuredSelection(selectedObjects));
		}

		public void dragSetData(DragSourceEvent event) {
			System.out.println("DragListener.dragSetData()");
			LocalSelectionTransfer localTransfer = LocalSelectionTransfer.getTransfer();
			IStructuredSelection selection = (IStructuredSelection) localTransfer.getSelection();
			ModelDragDropSupport.dragSetData(selection, event);
		}

		private List<RefObject> getSelectedObjects() {
			IStructuredSelection sel = (IStructuredSelection) treeViewer.getSelection();
			List<RefObject> result = new ArrayList<RefObject>(sel.size());
			Object[] objects = sel.toArray();
			for (Object object : objects) {
				if (!(object instanceof RefObject))
					return Collections.emptyList();
				result.add((RefObject) object);
			}
			return result;
		}
	}

	final class DropListener extends ViewerDropAdapter {
		DropListener(TreeViewer treeViewer) {
			super(treeViewer);
		}

		@Override
		public void dragEnter(DropTargetEvent event) {
			event.detail = DND.DROP_COPY;
			ModelDragDropSupport.dragEnter(event);

			super.dragEnter(event);
		}

		@Override
		public boolean validateDrop(Object target, int operation, TransferData transferType) {
			setFeedbackEnabled(false);
			if (target == null)
				return false;

			boolean valid = ModelDragDropSupport.validateDropForCopy(target, transferType);
			return valid;
		}

		@Override
		public boolean performDrop(Object data) {
			Object target = getCurrentTarget();
			if (!(target instanceof RefObject))
				return false;
			DeepCopyResultSet result = ModelDragDropSupport.copyFromDropData(data, target);
			return result != null;
		}
	}

	private final class MainPage extends ModelFormPage {

		public MainPage() {
			super(ViewEditor.this, MainPage.class.getName(), "View");

		}

		@Override
		protected void createFormContent(IManagedForm managedForm) {
			managedForm.getForm().setText("View Editor");

			MasterPart part = new MasterPart(this);
			part.createContent(managedForm);
		}
	}

	private final class MasterPart extends MasterDetailsBlock {

		private final IFormPage page;
		private MasterSection mMasterPart;

		public MasterPart(IFormPage page) {
			this.page = page;
		}

		@Override
		protected void createMasterPart(final IManagedForm managedForm, Composite parent) {
			sashForm.setOrientation(SWT.VERTICAL);

			Composite composite = managedForm.getToolkit().createComposite(parent);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setLayout(new GridLayout());

			mMasterPart = new MasterSection(composite, managedForm);

			GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
			mMasterPart.getSection().setLayoutData(gridData);
			managedForm.addPart(mMasterPart);
			mMasterPart.setFormInput(view);
		}

		@Override
		protected void createToolBarActions(IManagedForm managedForm) {
		}

		@Override
		protected void registerPages(DetailsPart detailsPart) {
			detailsPart.setPageProvider(new DetailsPageProvider(page));

			sashForm.setWeights(new int[] { 4, 1 });
		}
	}

	private final class MasterSection extends SectionPart {

		private TreeViewer treeViewer;

		public MasterSection(Composite parent, final IManagedForm managedForm) {
			super(parent, managedForm.getToolkit(), Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
			FormToolkit toolkit = managedForm.getToolkit();

			Section section = getSection();
			section.setText("UI Elements");
			FormText ft = managedForm.getToolkit().createFormText(section, true);
			ft.setText("Shows the UI tree", false, false);
			section.setDescriptionControl(ft);

			Tree tree = toolkit.createTree(section, SWT.MULTI | SWT.FULL_SELECTION);
			section.setClient(tree);
			treeViewer = new TreeViewer(tree);
			TreeColumn col = new TreeColumn(tree, SWT.NONE);
			col.setText("Name");
			col.setWidth(300);
			col = new TreeColumn(tree, SWT.NONE);
			col.setText("Type");
			col.setWidth(200);
			col = new TreeColumn(tree, SWT.NONE);
			col.setText("Aggregation");
			col.setWidth(200);
			tree.setHeaderVisible(true);

			ViewEditorProvider provider = new ViewEditorProvider();
			treeViewer.setContentProvider(provider);
			treeViewer.setLabelProvider(provider);
			treeViewer.setInput(view);
			treeViewer.expandToLevel(2);
			getSite().setSelectionProvider(treeViewer);

			treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				public void selectionChanged(SelectionChangedEvent event) {
					managedForm.fireSelectionChanged(MasterSection.this, event.getSelection());
				}
			});

			createActions();

			contributeToActionBars();

			initDragDrop();

			MenuManager menuMgr = new MenuManager("#PopupMenu");
			menuMgr.setRemoveAllWhenShown(true);
			menuMgr.addMenuListener(new IMenuListener() {
				public void menuAboutToShow(IMenuManager manager) {
					ViewEditor.this.fillContextMenu(manager);
				}
			});
			Menu menu = menuMgr.createContextMenu(tree);
			tree.setMenu(menu);
			getSite().registerContextMenu(menuMgr, treeViewer);

			getSite().setSelectionProvider(treeViewer);
		}

		@Override
		public boolean setFormInput(Object input) {
			if (input instanceof IStructuredSelection)
				input = ((IStructuredSelection) input).getFirstElement();

			if (input instanceof ViewElement) {
				if (treeViewer != null && !treeViewer.getControl().isDisposed()) {
					treeViewer.setSelection(new StructuredSelection(input), true);
				}
			}
			return super.setFormInput(input);
		}

		@Override
		public void setFocus() {
			if (treeViewer != null)
				treeViewer.getControl().setFocus();
		}

		@Override
		public void refresh() {
			super.refresh();
			if (treeViewer != null)
				treeViewer.refresh();
		}

		@Override
		public boolean isStale() {
			return true;
		}

		@Override
		public void dispose() {
			getSite().setSelectionProvider(null);
			super.dispose();
		}

		private void initDragDrop() {
			treeViewer.addDragSupport(DND.DROP_COPY, ModelDragDropSupport.getTransfersDragSource(), new DragListener(
					treeViewer));

			treeViewer.addDropSupport(DND.DROP_COPY, ModelDragDropSupport.getTypicalTransfersDropTarget(),
					new DropListener(treeViewer));
		}

		protected void createActions() {
			mCopyPasteActionGroup = new CopyPasteActionGroup(treeViewer);

			BaseSelectionListenerAction action = new BaseSelectionListenerAction("Create view container") {
				public void run() {
					InputDialog dlg = new InputDialog(getSite().getShell(), "Create View Container",
							"Enter the view container name", null, null);
					if (dlg.open() == Window.OK) {
						CreateViewContainerCommand cvcCmd = new CreateViewContainerCommand(getWorkingConnection(),
								view, dlg.getValue());
						cvcCmd.execute();
						treeViewer.refresh();
					}
				}

				@Override
				protected boolean updateSelection(IStructuredSelection selection) {
					RefObject firstElement = (RefObject) selection.getFirstElement();
					if (firstElement == null)
						return false;
					return firstElement.refImmediateComposite() instanceof View;
				}
			};
			action.setToolTipText("Creates a view container for the current view");
			action.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_OBJS_INFO_TSK));
			treeViewer.addSelectionChangedListener(action);
			actions.add(action);

			action = new BaseSelectionListenerAction("Create UI element") {
				public void run() {
					IStructuredSelection sel = (IStructuredSelection) treeViewer.getSelection();
					if (!sel.isEmpty()) {

						ObjectSelectionDialog dlg = new ObjectSelectionDialog(getSite().getShell(),
								"Select UI Element", "Select the type of UI element");
						dlg.setSingleSelection(true);
						dlg.setLabelProvider(new LabelProvider() {
							public String getText(Object element) {
								RefClass clazz = ((RefClass) element);
								String name = ((ModelElement) clazz.refMetaObject()).getName();
								return name;
							}

							public Image getImage(Object element) {
								RefClass clazz = ((RefClass) element);
								String name = ((ModelElement) clazz.refMetaObject()).getName();
								return MiFwkUiTestFragment.getImageRegistry().get(name);
							}
						});
						UielementPackage pack = (UielementPackage) view.refImmediatePackage().refPackage("uielement");
						Object[] selection = dlg.openDialog(new RefClass[] { pack.getButton(), pack.getGroup(),
								pack.getInputField(), pack.getLabel(), pack.getTable() });
						if (selection != null) {
							InputDialog inDlg = new InputDialog(getSite().getShell(), "Create UI Element",
									"Enter the UI element name", null, null);
							if (inDlg.open() == Window.OK) {
								Object firstElement = sel.getFirstElement();
								UielementContainer container = (UielementContainer) firstElement;
								CreateUIElementCommand cvcUICmd = new CreateUIElementCommand(getWorkingConnection(),
										container, (RefClass) selection[0], inDlg.getValue());
								cvcUICmd.execute();
								treeViewer.refresh();
								treeViewer.setSelection(new StructuredSelection(cvcUICmd.getUiElement()), true);
							}
						}
					}
				}

				@Override
				protected boolean updateSelection(IStructuredSelection selection) {
					Object firstElement = selection.getFirstElement();
					return firstElement instanceof UielementContainer;
				}
			};
			action.setToolTipText("Creates a UI element in the current view");
			action.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_OBJS_INFO_TSK));
			treeViewer.addSelectionChangedListener(action);
			actions.add(action);

			UielementPackage pack = (UielementPackage) view.refImmediatePackage().refPackage("uielement");
			final CreateRootElementCommand cmd = new CreateRootElementCommand(view, pack.getTransparentContainer(),
					"RootElement");
			action = new BaseSelectionListenerAction("Create Root Container") {
				public void run() {
					cmd.execute();
					treeViewer.refresh();
				}

				@Override
				protected boolean updateSelection(IStructuredSelection selection) {
					return cmd.canExecute();
				}
			};
			action.setToolTipText("Creates a root element for the current view");
			treeViewer.addSelectionChangedListener(action);
			actions.add(action);

			action = new BaseSelectionListenerAction("Add error marker") {
				public void run() {
					IStructuredSelection sel = (IStructuredSelection) treeViewer.getSelection();
					RefBaseObject obj = (RefBaseObject) sel.getFirstElement();
					if (obj != null) {
						ModelManager.getMarkerManager().createMarker(obj, IMarker.PROBLEM, IMarker.SEVERITY_ERROR,
								"This is the error message");
					} else {
						ModelManager.getMarkerManager().createMarker(view, IMarker.PROBLEM, IMarker.SEVERITY_ERROR,
								"This is the error message");
					}
				}
			};
			action.setToolTipText("Creates a marker");
			action.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_OBJS_INFO_TSK));
			treeViewer.addSelectionChangedListener(action);
			actions.add(action);

			action = new BaseSelectionListenerAction("Add warning marker") {
				public void run() {
					ModelManager.getMarkerManager().createMarker(view, IMarker.PROBLEM, IMarker.SEVERITY_WARNING,
							"This is the warning message");
				}
			};
			action.setToolTipText("Creates a marker");
			action.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_OBJS_INFO_TSK));
			treeViewer.addSelectionChangedListener(action);
			actions.add(action);

			action = new BaseSelectionListenerAction("Rename") {
				public void run() {
					IStructuredSelection sel = getStructuredSelection();
					if (!sel.isEmpty()) {
						RefObject refObj = (RefObject) sel.getFirstElement();
						RefObject metaObject = refObj.refMetaObject();
						Attribute attr = ((Partitionable) refObj).get___Connection().getJmiHelper().getAttributeByName(
								(MofClass) metaObject, "name", true);
						InputDialog inDlg = new InputDialog(getSite().getShell(), "Rename UI Element",
								"Enter the UI element name", String.valueOf(refObj.refGetValue(attr)), null);
						if (inDlg.open() == Window.OK) {
							SetAttributeCommand cmd = new SetAttributeCommand(refObj, attr, inDlg.getValue());
							cmd.execute();
							treeViewer.refresh();
						}
					}
				}

				@Override
				protected boolean updateSelection(IStructuredSelection selection) {
					return super.updateSelection(selection) && selection.size() == 1;
				}
			};
			action.setToolTipText("rename");
			getEditorSite().getActionBars().setGlobalActionHandler(ActionFactory.RENAME.getId(), action);
			treeViewer.addSelectionChangedListener(action);
			actions.add(action);

			actions.add(null);

			action = new BaseSelectionListenerAction("Delete") {
				public void run() {
					Object[] elements = getStructuredSelection().toArray();
					List<RefObject> objects = new ArrayList<RefObject>(elements.length);
					for (Object element : elements) {
						if (element instanceof RefObject)
							objects.add((RefObject) element);
					}
					DeleteElementCommand duieCmd = new DeleteElementCommand(objects);
					duieCmd.execute();
				}

				@Override
				protected boolean updateSelection(IStructuredSelection selection) {
					if (!super.updateSelection(selection))
						return false;
					Object firstElement = selection.getFirstElement();
					if (firstElement instanceof RefObject) {
						if (((RefObject) firstElement).refImmediateComposite() instanceof View)
							return false;
					}
					return true;
				}
			};
			action.setToolTipText("delete");
			action.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_TOOL_DELETE));
			getEditorSite().getActionBars().setGlobalActionHandler(ActionFactory.DELETE.getId(), action);
			treeViewer.addSelectionChangedListener(action);
			actions.add(action);

			actions.add(null);

			action = new BaseSelectionListenerAction("Quickfix") {
				public void run() {

					long start = System.nanoTime();
					IMarker[] markers = ModelManager.getMarkerManager().findMarkers(
							((RefObject) view).refImmediateComposite(), null, true, IResource.DEPTH_INFINITE);
					System.out.println((System.nanoTime() - start) / 1000000 + "ms");
					for (IMarker marker : markers) {
						try {
							System.out.println(marker.getAttribute(IMarker.LOCATION));
						} catch (CoreException e) {
							throw new RuntimeException(e);
						}
					}
				}
			};
			action.setToolTipText("Quickfix");
			action.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_OBJS_INFO_TSK));
			treeViewer.addSelectionChangedListener(action);
			actions.add(action);
		}

	}

	private final class DetailsPageProvider implements IDetailsPageProvider {

		private final IFormPage page;

		DetailsPageProvider(IFormPage page) {
			this.page = page;
		}

		public IDetailsPage getPage(Object key) {
			Class<?> clazz = (Class<?>) key;
			if (ViewElement.class.isAssignableFrom(clazz))
				return new DetailsPage(page.getManagedForm());
			if (View.class.isAssignableFrom(clazz))
				return new DetailsPage(page.getManagedForm());
			return null;
		}

		public Object getPageKey(Object object) {
			RefBaseObject refBaseObject = ModelAdapterUI.getInstance().getRefBaseObject(object);
			if (refBaseObject instanceof ViewElement)
				return ViewElement.class;
			if (refBaseObject instanceof View)
				return View.class;
			return null;
		}

	}

	private final class DetailsPage extends ModelDetailsPage {

		public DetailsPage(IManagedForm managedForm) {
			super(managedForm);
		}

		private DetailsSection section;

		public void initialize(IManagedForm form) {
		}

		@Override
		protected SectionPart createDetailsPart(Composite parent, IManagedForm managedForm) {
			parent.setLayout(new GridLayout());

			section = new DetailsSection(parent, managedForm);
			GridData gd = new GridData(GridData.FILL, GridData.FILL, true, true);
			section.getSection().setLayoutData(gd);

			managedForm.addPart(section);
			return section;
		}
	}

	private final class DetailsSection extends SectionPart implements IPartSelectionListener {

		private Text text;
		private ViewElement element;

		public DetailsSection(Composite parent, IManagedForm managedForm) {
			super(parent, managedForm.getToolkit(), Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
			FormToolkit toolkit = managedForm.getToolkit();

			Section section = getSection();
			section.setText("Details");

			Composite composite = toolkit.createComposite(section);
			section.setClient(composite);
			composite.setLayout(new GridLayout(2, false));

			toolkit.createLabel(composite, "&Name");
			text = toolkit.createText(composite, "");

			text.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					String text = ((Text) e.widget).getText();
					if (text != null && element != null && !text.equals(element.getName())) {
						new SetAttributeCommand(element, "name", text).execute();
					}
				}
			});
		}

		@Override
		public boolean setFormInput(Object input) {
			if (input instanceof IStructuredSelection)
				input = ((IStructuredSelection) input).getFirstElement();

			if (input instanceof ViewElement) {
				element = (ViewElement) input;
				if (text != null) {
					String name = element.getName();
					if (name != null && !name.equals(text.getText()))
						text.setText(name);
				}
			}
			return super.setFormInput(input);
		}

		@Override
		public void setFocus() {
			if (text != null)
				text.setFocus();
		}

		@Override
		public boolean isStale() {
			return true;
		}

		public void selectionChanged(IFormPart part, ISelection selection) {
			Object object = ((IStructuredSelection) selection).getFirstElement();
			setFormInput(object);
		}

		@Override
		public void refresh() {
			super.refresh();
			if (element != null && ((Partitionable) element).is___Alive() && text != null && !text.isDisposed()) {
				String name = element.getName();
				if (name != null && !name.equals(text.getText()))
					text.setText(name);
			}
		}
	}

	private static final class SetAttributeCommand extends Command {

		private RefObject refObj;
		private Attribute attr;
		private Object value;

		public SetAttributeCommand(RefObject refObj, String attrName, String value) {
			this(refObj, getAttribute(refObj, attrName), value);
		}

		public SetAttributeCommand(RefObject refObj, Attribute attr, String value) {
			super(ModelAdapter.getInstance().getConnection(refObj), "Set " + attr.getName());
			this.refObj = refObj;
			this.attr = attr;
			this.value = value;
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			Partitionable partitionable = (Partitionable) refObj;
			PRI pri = partitionable.get___Partition().getPri();
			PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
			return Collections.singleton(editOperation);
		}

		@Override
		public void doExecute() {
			refObj.refSetValue(attr, value);
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		private static Attribute getAttribute(RefObject refObj, String attrName) {
			JmiHelper jmiHelper = ModelAdapter.getInstance().getConnection(refObj).getJmiHelper();
			return jmiHelper.getAttributeByName((MofClass) refObj.refMetaObject(), attrName, true);
		}
	}

}