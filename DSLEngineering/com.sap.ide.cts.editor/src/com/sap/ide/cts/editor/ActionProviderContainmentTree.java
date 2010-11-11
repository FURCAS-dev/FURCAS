package com.sap.ide.cts.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.sap.ide.cts.editor.action.PrettyPrintAction;
import com.sap.ide.treeprovider.GenericRefObjectNode;

/**
 * ActionProvider that provides actions for context menus based on the current
 * tree selection and underlying meta model.
 * 
 * @author D046040
 * 
 */
public class ActionProviderContainmentTree extends CommonActionProvider
{
	
	/**
	 * @generated
	 */
	private List<Object> mMenuItems;
	public static final String NEW_SUBMENU_ID = ActionProviderContainmentTree.class
			.getName()
			+ ".new.submenu.id";
	
	@Override
	public void init(ICommonActionExtensionSite site)
	{
		super.init(site);
		
	}
	
	/**
	 * @generated
	 */
	@Override
	public void setContext(ActionContext context)
	{
		super.setContext(context);
		
		if(mMenuItems == null)
		{
			mMenuItems = new ArrayList<Object>();
		}
		else
		{
			mMenuItems.clear();
		}
		
		if(context != null)
		{
			// createActions(context);
		}
	}
	
	/**
	 * Adds the applicable actions to a part's action bars, including setting
	 * any global action handlers.
	 * 
	 * @generated
	 */
	@Override
	public void fillActionBars(IActionBars actionBars)
	{
	}
	
	/**
	 * Adds the applicable actions to a context menu, based on the state of the
	 * <code>ActionContext</code>.
	 * 
	 * @generated
	 */
	@Override
	public void fillContextMenu(IMenuManager menu)
	{
		ActionContext context = getContext();
		if(context != null)
		{
			for(Object item : mMenuItems)
			{
				if(item instanceof IAction)
				{
					IAction action = (IAction) item;
				}
				else if(item instanceof ActionGroup)
				{
					((ActionGroup) item).fillContextMenu(menu);
				}
				else if(item instanceof GroupMarker)
				{
					menu.add((GroupMarker) item);
				}
				else if(item instanceof Separator)
				{
					menu.add((Separator) item);
				}
				else
				{
					throw new IllegalStateException("Unrecognized Menu Item "
							+ item);
				}
			}
			
			// selection specific actions
			TreeSelection selection = (TreeSelection) context.getSelection();
			if(selection.size() == 1)
			{
				MenuManager subMenuManager = new MenuManager("Pretty Print",
						NEW_SUBMENU_ID);
				Object firstElement = selection.getFirstElement();
				
				if(firstElement instanceof GenericRefObjectNode)
				{
					GenericRefObjectNode node = (GenericRefObjectNode) firstElement;
					EObject modelElement = node.getValue();
					EClass clazz = (EClass) modelElement.refMetaObject();
					
					PrettyPrintAction action = new PrettyPrintAction(clazz,
							modelElement, true);
					subMenuManager.add(action);
				}
				menu.insertAfter(ICommonMenuConstants.GROUP_NEW, subMenuManager);
			}
		}
	}
	
	/**
	 * The dispose method has to be called in order to de-register any listeners
	 * 
	 * @generated
	 */
	@Override
	public void dispose()
	{
		for(Object item : mMenuItems)
		{
			if(item instanceof ActionGroup)
			{
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
	public void createActions(ActionContext context)
	{
	}
	
	/**
	 * Helper which adds the the given menu item to the list of context menu
	 * items.
	 * 
	 * @param item
	 *            the menu item to add, the value might be <code>null</code>.
	 * @generated
	 */
	public void addToContextMenu(Object item)
	{
		if(item != null)
		{
			mMenuItems.add(item);
		}
	}
	
}
