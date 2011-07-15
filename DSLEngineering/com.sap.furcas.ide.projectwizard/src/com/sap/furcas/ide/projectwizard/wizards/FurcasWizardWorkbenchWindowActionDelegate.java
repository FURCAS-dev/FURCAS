/*******************************************************************************
* Copyright (c) 2011 SAP AG and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     SAP AG - initial API and implementation
******************************************************************************/
 
package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * This class starts the FURCAS wizard if the user clicks on the corresponding menubar icon.
 * 
 * @author Sebastian Schlag (D049672)
 *
 */
public class FurcasWizardWorkbenchWindowActionDelegate implements IWorkbenchWindowActionDelegate {

    private IWorkbenchWindow window;

    @Override
    public void dispose() {     
    }

    
    @Override
    public void run(IAction action) {
        Shell shell = window.getShell();
        FurcasWizard wizard = new FurcasWizard();
        wizard.init(window.getWorkbench(), null);
        WizardDialog dialog = new WizardDialog(shell, wizard);
        dialog.open();
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        
    }

    @Override
    public void init(IWorkbenchWindow window){
        this.window = window;
    }

}
