/**
 * <copyright>
 *
 * Copyright (c) 2005-2006 IBM Corporation and others.
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
 * $Id: EMFProjectWizard.java,v 1.9 2006/12/28 06:53:13 marcelop Exp $
 */
package org.eclipse.emf.importer.ui;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.importer.ImporterPlugin;
import org.eclipse.emf.importer.ui.contribution.IModelImporterWizard;
import org.eclipse.emf.importer.ui.contribution.ModelImporterDescriptor;
import org.eclipse.emf.importer.ui.contribution.ModelImporterManager;


/**
 * @since 2.1.0
 */
public class EMFProjectWizard extends EMFModelWizard
{
  protected IPath projectLocation;
  protected IPath projectPath;

  public EMFProjectWizard()
  {
    super();
    setWindowTitle(ImporterPlugin.INSTANCE.getString("_UI_EMFProjectWizard_title"));
  }
  
  @Override
  protected ImageDescriptor getDefaultImageDescriptor()
  {
    return ExtendedImageRegistry.INSTANCE.getImageDescriptor(ImporterPlugin.INSTANCE.getImage("full/wizban/NewEMFProject"));
  }

  @Override
  public void addPages()
  {
    WizardNewProjectCreationPage page = new WizardNewProjectCreationPage("NewProjectCreationPage")
      {
        @Override
        protected boolean validatePage()
        {
          if (super.validatePage())
          {
            IPath locationPath = getLocationPath();
            projectLocation = Platform.getLocation().equals(locationPath) ? null : locationPath;
            projectPath = getProjectHandle().getFullPath();
            return true;
          }
          else
          {
            return false;
          }
        }
      };
    page.setTitle(ImporterPlugin.INSTANCE.getString("_UI_EMFProjectWizard_name"));
    page.setDescription(ImporterPlugin.INSTANCE.getString("_UI_CreateEMFProject_label"));
    addPage(page);

    if (defaultPath != null)
    {
      String path = defaultPath.removeLastSegments(defaultPath.segmentCount()-1).toString();
      page.setInitialProjectName(path.charAt(0) == '/' ? path.substring(1) : path);
      page.setPageComplete(page.isPageComplete());    
    }
    
    addSelectionPage();
  }

  @Override
  protected List<ModelImporterDescriptor> getModelImporterDescriptors()
  {
    return ModelImporterManager.INSTANCE.filterModelImporterDescriptors(ModelImporterDescriptor.TYPE_PROJECT);
  }
  
  @Override
  protected void adjustModelImporterWizard(IModelImporterWizard modelImporterWizard, ModelImporterDescriptor modelImporterDescriptor)
  {
    super.adjustModelImporterWizard(modelImporterWizard, modelImporterDescriptor);

    if (isValidNewValue(projectLocation, modelImporterWizard.getGenModelProjectLocation()))
    {
      modelImporterWizard.setGenModelProjectLocation(projectLocation);
    }
    if (isValidNewValue(projectPath, modelImporterWizard.getGenModelProjectPath()))
    {
      modelImporterWizard.setGenModelProjectPath(projectPath);
    }
  }
}
