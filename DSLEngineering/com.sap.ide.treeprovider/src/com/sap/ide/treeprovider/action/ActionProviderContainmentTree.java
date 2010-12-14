package com.sap.ide.treeprovider.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.INodeExplorer;
import com.sap.ide.treeprovider.internal.explorer.nodes.RootNodeComponent;

/**
 * ActionProvider that provides actions for context menus based on the current
 * tree selection and underlying meta model.
 * 
 * @author D046040
 * 
 */
public class ActionProviderContainmentTree extends CommonActionProvider {

    /**
     * @generated
     */
    private List<EObject> mMenuItems;
    public static final String NEW_SUBMENU_ID = ActionProviderContainmentTree.class.getName() + ".new.submenu.id";
    private CopyPasteActionGroup mCopyPasteActionGroup;
    
    @Override
    public void init(ICommonActionExtensionSite site) {
	super.init(site);
	mCopyPasteActionGroup = new CopyPasteActionGroup(site.getViewSite().getSelectionProvider());

    }

    /**
     * @generated
     */
    @Override
    public void setContext(ActionContext context) {
	super.setContext(context);

	if (mMenuItems == null) {
	    mMenuItems = new ArrayList<EObject>();
	} else {
	    mMenuItems.clear();
	}

	if (context != null) {
	    createActions(context);
	}
    }

    /**
     * Adds the applicable actions to a part's action bars, including setting
     * any global action handlers.
     * 
     * @generated
     */
    @Override
    public void fillActionBars(IActionBars actionBars) {
	ActionContext context = getContext();
	if (context != null) {
	    for (EObject item : mMenuItems) {
		if (item instanceof IAction) {
		    IAction action = (IAction) item;
		    if (action instanceof DeleteElementAction) {
			actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), action);
			continue;
		    }

		} else if (item instanceof ActionGroup) {
		    ((ActionGroup) item).fillActionBars(actionBars);
		}
	    }
	}
	mCopyPasteActionGroup.fillActionBars(actionBars);
    }

    /**
     * Adds the applicable actions to a context menu, based on the state of the
     * <code>ActionContext</code>.
     * 
     * @generated
     */
    @Override
    public void fillContextMenu(IMenuManager menu) {
	ActionContext context = getContext();
	if (context != null) {
	    for (EObject item : mMenuItems) {

		if (item instanceof IAction) {
		    IAction action = (IAction) item;

		    if (action instanceof DeleteElementAction) {
			menu.appendToGroup(ICommonMenuConstants.GROUP_REORGANIZE, action);
		    } else {
			menu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS, action);
		    }
		} else if (item instanceof ActionGroup) {
		    ((ActionGroup) item).fillContextMenu(menu);
		} else if (item instanceof GroupMarker) {
		    menu.add((GroupMarker) item);
		} else if (item instanceof Separator) {
		    menu.add((Separator) item);
		} else {
		    throw new IllegalStateException("Unrecognized Menu Item " + item);
		}
	    }

	    // selection specific actions
	    TreeSelection selection = (TreeSelection) context.getSelection();
	    if (selection.size() == 1) {
		MenuManager subMenuManager = new MenuManager("New", NEW_SUBMENU_ID);
		EObject firstElement = selection.getFirstElement();

		if (firstElement instanceof GenericRefObjectNode) {
		    GenericRefObjectNode node = (GenericRefObjectNode) firstElement;
		    EObject modelElement = node.getValue();

		    // find project
		    while (!(node.getParent() instanceof RootNodeComponent)) {
			if (!(node.getParent() instanceof GenericRefObjectNode)) {
			    node = (GenericRefObjectNode) node.getParent();
			}
			node = (GenericRefObjectNode) node.getParent();
		    }
		    IProject project = (IProject) ((RootNodeComponent) node.getParent()).getParent();
		    
		    Map<EReference, Set<EClass>> concreteCompositeChildClasses = GenericRefObjectNode
			    .getConcreteCompositeChildClasses((EClass) modelElement.refMetaObject());

		    // add a CreateElementAction for each concrete composite
		    // child class
		    for (EReference ae : concreteCompositeChildClasses.keySet()) {
			for (EClass clazz : concreteCompositeChildClasses.get(ae)) {
			    CreateElementAction action = new CreateElementAction(clazz, ae, (INodeExplorer) firstElement, project);
			    subMenuManager.add(action);
			}
		    }
		} else if (firstElement instanceof RootNodeComponent) {
		    RootNodeComponent rootNode = (RootNodeComponent) firstElement;
		    if (rootNode.isConnectionInitialized()) {
			IProject project = (IProject) rootNode.getParent();
			List<EClass> classes = rootNode.getTopLevelModelElementTypes();
			for (EClass mofClass : classes) {
			    subMenuManager.add(new CreateTopLevelElementAction(mofClass, project));
			}
		    }
		}

		menu.insertBefore(ICommonMenuConstants.GROUP_OPEN, subMenuManager);
	    }
	    mCopyPasteActionGroup.fillContextMenu(menu, IWorkbenchActionConstants.GROUP_REORGANIZE);
	}
    }

    /**
     * The dispose method has to be called in order to de-register any listeners
     * 
     * @generated
     */
    @Override
    public void dispose() {
	for (EObject item : mMenuItems) {
	    if (item instanceof ActionGroup) {
		((ActionGroup) item).dispose();
	    }
	}
	mMenuItems.clear();
	super.dispose();
    }

    /**
     * Creates the user defined actions according to the current selection
     * 
     * @param context
     *            the context to use
     */
    private void createActions(ActionContext context) {
	addToContextMenu(DeleteElementAction.createActionForSelection((IStructuredSelection) context.getSelection()));
    }

    /**
     * Helper which adds the the given menu item to the list of context menu
     * items.
     * 
     * @param item
     *            the menu item to add, the value might be <code>null</code>.
     * @generated
     */
    private void addToContextMenu(EObject item) {
	if (item != null) {
	    mMenuItems.add(item);
	}
    }

}
