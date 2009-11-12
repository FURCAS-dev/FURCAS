package com.sap.ide.moftool.editor.action.prov;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;

import com.sap.ide.moftool.editor.action.ActionActionCreateTag;
import com.sap.ide.moftool.editor.action.ActionActionDeleteModelelement;

public abstract class AbstractActionProvider extends ActionGroup {

	/**
	 * @generated
	 */
	private List<Object> mMenuItems;

	public AbstractActionProvider() {
		super();
	}

	/**
	 * @generated
	 */
	public void init(IWorkbenchPart part) {
	
	}

	/**
	 * @generated
	 */
	@Override
	public void setContext(ActionContext context) {
		super.setContext(context);
		createContextMenuItems(context);
	}

	/**
	 * Adds the applicable actions to a part's action bars, including setting any global action handlers.
	 * 
	 * @generated
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
		ActionContext context = getContext();
		if (context != null) {
			for (Object item : mMenuItems) {
				if (item instanceof IAction) {
					IAction action = (IAction) item;
	
					if (action instanceof ActionActionDeleteModelelement) {
						actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), action);
					}
	
				} else if (item instanceof ActionGroup) {
					((ActionGroup) item).fillActionBars(actionBars);
				}
			}
		}
	}

	/**
	 * Adds the applicable actions to a context menu, based on the state of the <code>ActionContext</code>.
	 * 
	 * @generated
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		ActionContext context = getContext();
		if (context != null) {
			for (Object item : mMenuItems) {
	
				if (item instanceof IAction) {
					IAction action = (IAction) item;
	
					if (action instanceof ActionActionDeleteModelelement) {
						menu.appendToGroup(IWorkbenchActionConstants.GROUP_REORGANIZE, action);
						continue;
					}
	
					menu.appendToGroup(IWorkbenchActionConstants.MB_ADDITIONS, action);
				} else if (item instanceof ActionGroup) {
					((ActionGroup) item).fillContextMenu(menu);
				} else if (item instanceof GroupMarker) {
					menu.add((GroupMarker) item);
				} else if (item instanceof Separator) {
					menu.add((Separator) item);
				} else {
					throw new IllegalStateException("Unrecognized Menu Item " //$NON-NLS-1$
							+ item);
				}
			}
		}
	}

	/**
	 * The dispose method has to be called in order to deregister any listeners
	 * 
	 * @generated
	 */
	@Override
	public void dispose() {
		for (Object item : mMenuItems) {
			if (item instanceof ActionGroup) {
				((ActionGroup) item).dispose();
			}
		}
		mMenuItems.clear();
		super.dispose();
	}

	/**
	 * Creates the context menu structure and the user defined actions
	 * 
	 * @param context
	 *            the context to use
	 * @generated
	 */
	private void createContextMenuItems(ActionContext context) {
		if (mMenuItems == null) {
			mMenuItems = new ArrayList<Object>();
		} else {
			mMenuItems.clear();
		}
	
		if (context != null) {
			createContextMenuStructure();
			createActions(context);
		}
	}

	/**
	 * Creates the user defined actions according to the current selection
	 * 
	 * @param context
	 *            the context to use
	 * @generated
	 */
	private void createActions(ActionContext context) {
	
		createActionsInternal(context);
	
		addToContextMenu(ActionActionDeleteModelelement.createActionForSelection((IStructuredSelection) context.getSelection())); //
	
	}

	protected abstract void createActionsInternal(ActionContext context);

	/**
	 * Creates the standard menu structure of the context menu.
	 * 
	 * @generated
	 */
	private void createContextMenuStructure() {
		// build menu structure
		mMenuItems.add(new Separator());
		mMenuItems.add(new GroupMarker(IWorkbenchActionConstants.M_NAVIGATE));
		mMenuItems.add(new Separator());
		mMenuItems.add(new GroupMarker(IWorkbenchActionConstants.GROUP_REORGANIZE));
		mMenuItems.add(new Separator());
		mMenuItems.add(new Separator(IContextMenuConstants.GROUP_SEARCH));
		mMenuItems.add(new Separator(IContextMenuConstants.GROUP_SEARCH + "-end")); //$NON-NLS-1$
		mMenuItems.add(new Separator());
		mMenuItems.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		mMenuItems.add(new Separator());
	}

	/**
	 * Helper which adds the the given menu item to the list of context menu items.
	 * 
	 * @param item
	 *            the menu item to add, the value might be <code>null</code>.
	 * @generated
	 */
	protected void addToContextMenu(Object item) {
		if (item != null) {
			mMenuItems.add(item);
		}
	}

}