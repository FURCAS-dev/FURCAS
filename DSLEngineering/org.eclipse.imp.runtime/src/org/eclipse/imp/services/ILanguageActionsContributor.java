/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

/**
 * 
 */
package org.eclipse.imp.services;

import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.language.ILanguageService;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;

public interface ILanguageActionsContributor extends ILanguageService {
   
    
    /**
     * Implement this method to add any kind of action to the popup
     * menu of an editor.
     * 
     * @param editor
     * @param menuManager
     */
    public void contributeToEditorMenu(final UniversalEditor editor, IMenuManager menuManager);
    
    /**
     * Implement this method to add any kind of element to the toolbar
     * for this editor.
     * 
     * @param editor
     * @param toolbarManager
     */
    public void contributeToToolBar(final UniversalEditor editor, IToolBarManager toolbarManager);
    
    
    /**
     * Implement this method to add any kind of element to the statusline
     * for this editor.
     * 
     * @param editor
     * @param toolbarManager
     */
    public void contributeToStatusLine(final UniversalEditor editor, IStatusLineManager statusLineManager);

    /**
     * Implement this method to add any kind of element to the menu bar
     * for this editor.
     * 
     * @param editor
     * @param toolbarManager
     */
	public void contributeToMenuBar(final UniversalEditor editor, IMenuManager menu);
}