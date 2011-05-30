/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CommandStackExceptionHandler.java,v 1.2 2007/06/07 14:25:36 cdamus Exp $
 */
package com.sap.furcas.ide.editor.imp;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.ExceptionHandler;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.sap.furcas.ide.editor.CtsActivator;

/**
 * An exception handler for the shared editing domain's command stack, that
 * shows errors in a pop-up dialog.
 *
 * @author Christian W. Damus (cdamus)
 */
public class CommandStackExceptionHandler implements ExceptionHandler {

    // Documentation copied from the inherited specification
    @Override
    public void handleException(final Exception e) {
        PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                Shell shell = null;
                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                if (window != null) {
                    shell = window.getShell();
                }
                
                if (e instanceof RollbackException) {
                    RollbackException rbe = (RollbackException) e;
                    ErrorDialog.openError(shell, "Command failed", "An exception occured during rollback", rbe.getStatus());
                } else {
                    ErrorDialog.openError(shell, "Command failed", "An exception occured", new Status(IStatus.ERROR,
                            CtsActivator.PLUGIN_ID, 1, e.getLocalizedMessage(), e));
                }
            }
        });
    }

}