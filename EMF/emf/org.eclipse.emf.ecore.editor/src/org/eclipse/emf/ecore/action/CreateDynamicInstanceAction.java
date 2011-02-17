/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
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
 * $Id: CreateDynamicInstanceAction.java,v 1.6 2007/05/11 15:54:31 emerks Exp $
 */
package org.eclipse.emf.ecore.action;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.presentation.DynamicModelWizard;


/**
 * Create a dynamic instance of an {@link EClass}.
 */
public class CreateDynamicInstanceAction 
  extends ActionDelegate
  implements IActionDelegate
{
  protected static final URI PLATFORM_RESOURCE = URI.createPlatformResourceURI("/", false);

  protected EClass eClass;

  public CreateDynamicInstanceAction()
  {
    super();
  }

  @Override
  public void run(IAction action)
  {
    URI uri = eClass.eResource().getURI();
    IStructuredSelection selection = StructuredSelection.EMPTY;
    if (uri != null && uri.isHierarchical())
    {
      if (uri.isRelative() || (uri = uri.deresolve(PLATFORM_RESOURCE)).isRelative())
      {
        IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toString()));
        if (file.exists())
        {
          selection = new StructuredSelection(file);
        }
      }
    }

    DynamicModelWizard dynamicModelWizard = new DynamicModelWizard(eClass);
    dynamicModelWizard.init(PlatformUI.getWorkbench(), selection);
    WizardDialog wizardDialog = 
      new WizardDialog
        (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),  
         dynamicModelWizard);

    wizardDialog.open();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) 
  {
    if (selection instanceof IStructuredSelection)
    {
      Object object = ((IStructuredSelection)selection).getFirstElement();
      if (object instanceof EClass)
      {
        eClass = (EClass)object;

        action.setEnabled(!eClass.isAbstract());
        return;
      }
    }
    eClass = null;
    action.setEnabled(false);
  }
}
