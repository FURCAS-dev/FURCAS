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
package com.sap.furcas.ide.projectwizard.util;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.sap.furcas.ide.projectwizard.wizards.FurcasWizard;

public class CreateProjectOperation extends WorkspaceModifyOperation {
    
    /**
     * Used to access the user input.
     */
    private final ProjectInfo pi;
    /**
     * Represents the wizards window.
     */
    private final Shell shell;
    /**
     * Used to access methods or variables of the wizard.
     */
    private final FurcasWizard wizard;
    /**
     * Reference to the generated project.
     */
    public IProject project;

    /**
     * Give the user input to the instance.
     * 
     * @param pi
     *            The user input.
     * @param shell
     *            The window containing the wizard.
     */
    public CreateProjectOperation(ProjectInfo pi, Shell shell, FurcasWizard wizard) {
        this.pi = pi;
        this.shell = shell;
        this.wizard = wizard;
    }

    /**
     * Starts the process of project creation.
     */
    @Override
    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
        monitor.beginTask("Creating project " + pi.getProjectName(), 2);
        try {
            CreateProject creator = new CreateProject(pi);
            project = creator.createProject(monitor);
        } catch (CodeGenerationException e) {
            wizard.setHadError(true);
            MessageDialog.openError(this.shell, "Error", e.getMessage());
        }
    }

}
