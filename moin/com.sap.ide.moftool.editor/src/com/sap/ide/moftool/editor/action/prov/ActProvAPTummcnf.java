/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (ActionProvider_NAVIGATOR.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.action.prov;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

/**
 * Constructs list of actions for programmatic construction of a context menu Determines action applicability is determined on the
 * individual action
 * 
 * @author SAP AG
 * @generated
 */
public class ActProvAPTummcnf extends CommonActionProvider {

	/**
	 * @generated
	 */
	private List<Object> mMenuItems;

	@Override
	public void init(ICommonActionExtensionSite site) {

		super.init(site);
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
				// if (item instanceof IAction) {
				// IAction action = (IAction)item;
				//
				// if (action instanceof ActionStdOPENEDITOR) {
				// actionBars.setGlobalActionHandler(
				// ICommonActionConstants.OPEN, action);
				// continue;
				// }
				//
				// } else
				if (item instanceof ActionGroup) {
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

					// if (action instanceof ActionStdOPENEDITOR) {
					// menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN,
					// action);
					// } else
					//
					// {
					menu.appendToGroup(ICommonMenuConstants.GROUP_ADDITIONS, action);
					// }
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

		// addToContextMenu(ActionStdOPENEDITOR
		// .createActionForSelection((IStructuredSelection)context
		// .getSelection()));

	}
}
