/*******************************************************************************
* Copyright (c) 2008 
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Jurgen Vinju (jurgenv@cwi.nl) - initial API and implementation
*******************************************************************************/

package org.eclipse.imp.services.base;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.services.ILanguageActionsContributor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;

public class DefaultLanguageActionsContributor implements ILanguageActionsContributor {

	/**
     * Override this method to add any kind of action to the popup
     * menu of an editor. The default implementation uses
     * the deprecated getEditorActions method to provide backward compatibility.
     * 
     * @param editor
     * @param menuManager
     */
	public void contributeToEditorMenu(final UniversalEditor editor, IMenuManager menuManager) {
		IMenuManager subMenu = new MenuManager(editor.fLanguage.getName());
		
		try {
			IAction[] actions = getEditorActions(editor);
			
			if (actions != null && actions.length > 0) {
		      for (IAction action : actions) {
			    subMenu.add(action);
		      }
		      
		      menuManager.add(subMenu);
		    }
		}
		catch (Exception e) {
			RuntimePlugin.getInstance().logException(
					"Unable to create language actions for contributor "
							+ this, e);
		}
	}

	public void contributeToStatusLine(final UniversalEditor editor, IStatusLineManager statusLineManager) {
       // do nothing, subclasses can override to implement
	}

	public void contributeToToolBar(final UniversalEditor editor, IToolBarManager toolbarManager) {
       // do nothing, subclasses can override to implement
	}

	public void contributeToMenuBar(final UniversalEditor editor, IMenuManager menuManager) {
	       // do nothing, subclasses can override to implement
	}
	
	 /**
     * Implement this method to add actions to a submenu labelled by the
     * language name.
     * 
     * @deprecated use contributeToEditorMenu() instead
     * @param editor
     * @return
     */
	@Deprecated()
	public IAction[] getEditorActions(UniversalEditor editor) {
		return null;
	}
}
