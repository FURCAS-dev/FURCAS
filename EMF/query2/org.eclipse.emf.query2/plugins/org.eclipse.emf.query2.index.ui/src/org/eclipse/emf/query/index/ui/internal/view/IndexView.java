package org.eclipse.emf.query.index.ui.internal.view;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query.index.event.IndexChangeEvent;
import org.eclipse.emf.query.index.event.IndexChangeListener;
import org.eclipse.emf.query.index.event.IndexChangeListenerRegistry;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableIndexImpl;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.internal.Activator;
import org.eclipse.emf.query.index.ui.internal.Messages;
import org.eclipse.emf.query.index.ui.internal.images.IndexUIImageRegistry;
import org.eclipse.emf.query.index.ui.internal.properties.IndexViewProperty;
import org.eclipse.emf.query.index.ui.internal.view.legends.DisplayLegendsAction;
import org.eclipse.emf.query.index.ui.internal.view.legends.ILegendManager;
import org.eclipse.emf.query.index.ui.internal.view.legends.impl.IndexViewLegendManager;
import org.eclipse.emf.query.index.ui.internal.view.tree.IndexComparator;
import org.eclipse.emf.query.index.ui.internal.view.tree.IndexViewTreeContentProvider;
import org.eclipse.emf.query.index.ui.internal.view.tree.IndexViewTreeLabelProvider;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IndexTypeURI;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceType;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * Index View helps the users to view all the resources which are indexed.
 * 
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
public class IndexView extends ViewPart implements IDoubleClickListener, IndexChangeListener {

	public static final String ID = "org.eclipse.emf.query2.index.ui.indexview"; //$NON-NLS-1$
	private static TreeViewer treeViewer;
	private PropertySheetPage propertiesPage;
	private static Action actionEObjectTable;
	private static Action actionInComingLinks;
	private static Action actionOutgoingLinks;
	private Action actionDisplayLegends;
	private TreeViewer viewer;
	private static Action userDataTable;

	public IndexView() {
		setTitleToolTip(Messages.Query2IndexUI_IndexView_ToolTip);
		setPartName(Messages.Query2IndexUI_IndexView_PartName);
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@SuppressWarnings("deprecation")
	public void createPartControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		composite.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		SashForm sashForm = new SashForm(composite, SWT.NONE);
		sashForm.setLayout(new GridLayout(1, false));
		sashForm.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		sashForm.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		Composite container = new Composite(sashForm, SWT.BORDER);
		GridLayout gd = new GridLayout(1, false);
		gd.marginBottom = 0;
		gd.marginHeight = 0;
		gd.marginLeft = 0;
		gd.marginRight = 0;
		gd.marginTop = 0;
		gd.marginWidth = 0;
		container.setLayout(gd);
		container.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		container.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		Composite propertiesContainer = new Composite(sashForm, SWT.BORDER);
		GridLayout layout = new GridLayout(1, false);
		layout.marginBottom = 0;
		layout.marginHeight = 0;
		layout.marginLeft = 0;
		layout.marginRight = 0;
		layout.marginTop = 0;
		layout.marginWidth = 0;
		propertiesContainer.setLayout(layout);
		propertiesContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		propertiesContainer.setBackground(composite.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		// Create a tree with text filter.
		PatternFilter patternFilter = new PatternFilter();
		final FilteredTree filteredTree = new FilteredTree(container, SWT.VIRTUAL | SWT.H_SCROLL | SWT.V_SCROLL, patternFilter);
		treeViewer = filteredTree.getViewer();

		treeViewer.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL));
		IndexComparator comparator = new IndexComparator();
		treeViewer.setContentProvider(new IndexViewTreeContentProvider(comparator));
		treeViewer.setLabelProvider(new IndexViewTreeLabelProvider());
		treeViewer.setInput(getInput());

		getSite().setSelectionProvider(treeViewer);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateActionEnablement();
			}
		});
		// Create the context menu for the view.
		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		// Create menu.
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);
		treeViewer.addDoubleClickListener(this);
		IndexChangeListenerRegistry indexChangeRegistry = new IndexChangeListenerRegistry() {
			
			public void removeIndexChangeListener(IndexChangeListener listener) {
			}

			
			public void addIndexChangeListener(IndexChangeListener listener) {
			}
		};
		indexChangeRegistry.addIndexChangeListener(this);
		getSite().registerContextMenu(menuMgr, treeViewer);
		getSite().setSelectionProvider(treeViewer);
		
		// Property Sheet for the Index View
		viewer = new TreeViewer(propertiesContainer);
		viewer.setContentProvider(new IndexViewTableContentProvider());
		viewer.setLabelProvider(new IndexViewTableLabelProvider());
		Tree tree = viewer.getTree();
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.setAutoExpandLevel(2);
		
		TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
		column1.setText("Property");
		column1.setWidth(200);
		TreeColumn column2 = new TreeColumn(tree, SWT.LEFT);
		column2.setText("Value");
		column2.setWidth(500);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		
		createActions();
		initializeMenu();
	}

	/**
	 * Retrieve the selected element in the Tree Viewer.
	 * 
	 * @return Object representing the selected node in the tree viewer.
	 */
	public Object getSelectedElement() {
		IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
		Object firstElement = selection.getFirstElement();
		return firstElement;
	}

	/**
	 * Retrieve the input for the Tree Viewer.
	 * 
	 * @return The Global tables retrieved from the Indices.
	 */
	private Object getInput() {
		Index index = IndexFactory.getInstance();
		GlobalTables globalTables = ((PageableIndexImpl) index).getGlobalTables();
		return globalTables;
	}

	protected void updateActionEnablement() {
		Object selectedObj = getSelectedElement();
		if(isIndexedObject(selectedObj))
			viewer.setInput(selectedObj);
		else
			viewer.setInput(null);
	}
	
	/**
	 * Checks if the object is indexed, before setting it as input to the properties treeviewer
	 * @param selectedObj
	 * @return
	 */
	private boolean isIndexedObject(Object selectedObj) {
		boolean isValid = false;
		if(selectedObj!=null){
			if(selectedObj instanceof EReferenceDescriptor || 
					selectedObj instanceof	EObjectDescriptor || 
						selectedObj instanceof ResourceType || 
						selectedObj instanceof IndexTypeURI || 
						selectedObj instanceof ResourceDescriptor ||
						selectedObj instanceof IndexViewProperty)
				isValid = true;
		}
		return isValid;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			actionEObjectTable = new Action(Messages.Query2IndexUI_IndexView_EObjectGroup) {

				
				public void run() {
					treeViewer.refresh();
				}

			};
			actionEObjectTable.setChecked(true);
		}
		{
			actionInComingLinks = new Action(Messages.Query2IndexUI_IndexView_IncomingLinksGroup) {
				
				public void run() {
					treeViewer.refresh();
				}
			};
			actionInComingLinks.setChecked(true);
		}
		{
			actionOutgoingLinks = new Action(Messages.Query2IndexUI_IndexView_OutgoingLinksGroup) {
				
				public void run() {
					treeViewer.refresh();
				}
			};
			actionOutgoingLinks.setChecked(true);
		}
		{
			userDataTable = new Action(Messages.Query2IndexUI_IndexViewTreeLabelProvider_UserDataTable){
				public void run(){
					treeViewer.refresh();
				}
			};
			userDataTable.setChecked(false);
			}

		{
			actionDisplayLegends = new Action(Messages.Query2IndexUI_IndexView_ActionDisplayLegends_Text, IndexUIImageRegistry.getImageDescriptor(IndexUIImageRegistry.LEGEND_ICON)) {

				
				public void run() {
					ILegendManager legendManager = new IndexViewLegendManager();
					new DisplayLegendsAction(Messages.Query2IndexUI_IndexView_Legend, legendManager).run();
				}

			};
		}
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager indexViewMenuManager = getViewSite().getActionBars().getMenuManager();

		MenuManager tableFilters = new MenuManager(Messages.Query2IndexUI_IndexView_TableFilters_Text, IndexUIImageRegistry.getImageDescriptor(IndexUIImageRegistry.FILTER_ICON),
				"indexView.TableFilter"); //$NON-NLS-1$
		indexViewMenuManager.add(tableFilters);
		tableFilters.add(actionEObjectTable);
		tableFilters.add(actionInComingLinks);
		tableFilters.add(actionOutgoingLinks);
		tableFilters.add(userDataTable);
		Separator separator = new Separator();
		indexViewMenuManager.add(separator);
		indexViewMenuManager.add(actionDisplayLegends);
	}

	
	public void setFocus() {
		// Set the focus
	}

	public static boolean isActionEObjectTableChecked() {
		return actionEObjectTable.isChecked();
	}

	public static boolean isActionIncomingLinksTableChecked() {
		return actionInComingLinks.isChecked();
	}

	public static boolean isActionOutgoingLinksTableChecked() {
		return actionOutgoingLinks.isChecked();
	}
	
	public static boolean isUserDataTableChecked(){
		return userDataTable.isChecked();
	}

	
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
		openInEditor(selectedElement);
	}

	public static void openInEditor(Object selectedElement) {
		if (selectedElement != null) {
			if (selectedElement instanceof ResourceDescriptor) {
				URI resourceURI = ((ResourceDescriptor) selectedElement).getURI();
				openEditorFromURI(resourceURI);
			} else if (selectedElement instanceof EObjectDescriptor) {
				URI resourceURI = ((EObjectDescriptor) selectedElement).getResourceURI();
				openEditorFromURI(resourceURI);
			} else if (selectedElement instanceof EReferenceDescriptor) {
				URI sourceResourceURI = ((EReferenceDescriptor) selectedElement).getSourceResourceURI();
				openEditorFromURI(sourceResourceURI);
				URI targetResourceURI = ((EReferenceDescriptor) selectedElement).getTargetResourceURI();
				openEditorFromURI(targetResourceURI);
			} else if (selectedElement instanceof IndexTypeURI) {
				URI resourceURI = ((IndexTypeURI) selectedElement).getURI();
				openEditorFromURI(resourceURI);
			}else if(selectedElement instanceof IndexViewProperty){
				Object parent = ((IndexViewProperty)selectedElement).getParent();
				if(parent!=null){
					if(parent instanceof EObjectDescriptor){
						openEditorFromURI( ((EObjectDescriptor) parent).getResourceURI());
					}
					else if(parent instanceof ResourceDescriptor){
						openEditorFromURI( ((ResourceDescriptor) parent).getURI());
					}
				}
			}

		}
	}


	public static void openEditorFromURI(URI resourceURI) {
		IPath path;
		IFile file;
		URI fileURI = CommonPlugin.resolve(resourceURI);
		if (fileURI != null) {
			if (fileURI.toFileString() != null) {
				path = new Path(fileURI.toFileString());
				file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
				if (file != null) {
					try {
						IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);

					} catch (PartInitException e) {
						e.printStackTrace();
					}
				} else {
					IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.Query2IndexUI_IndexView_FileNotFound);
					ErrorDialog.openError(Display.getDefault().getActiveShell(), Messages.Query2IndexUI_IndexView_ErrorInOpeningEditor,
							Messages.Query2IndexUI_IndexView_InvalidFileForEditor, status);

				}
			} else {
				MessageDialog.openError(Display.getDefault().getActiveShell(), Messages.Query2IndexUI_IndexView_ErrorInOpeningEditor,
						Messages.Query2IndexUI_IndexView_InvalidFileForEditor);
			}
		} else {
			MessageDialog.openError(Display.getDefault().getActiveShell(), Messages.Query2IndexUI_IndexView_ErrorInOpeningEditor,
					Messages.Query2IndexUI_IndexView_InvalidFileForEditor);
		}
	}


	
	public void indexChanged(IndexChangeEvent event) {
		treeViewer.refresh();
	}

	public static TreeViewer getTreeViewer() {
		return treeViewer;
	}
}
