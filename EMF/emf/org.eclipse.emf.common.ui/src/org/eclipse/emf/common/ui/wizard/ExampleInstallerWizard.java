/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: ExampleInstallerWizard.java,v 1.4 2006/12/28 06:42:02 marcelop Exp $
 */
package org.eclipse.emf.common.ui.wizard;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.util.URI;

/**
 * <p>Default implementation of {@link AbstractExampleInstallerWizard} which can be declared 
 * directly in the plugin.xml using the <tt>org.eclipse.ui.newWizards</tt> and
 * <tt>org.eclipse.emf.common.ui.examples</tt> extension points.</p>
 * 
 * <p>When declaring this wizard, it is necessary to define a unique id for it.</p>
 * 
 * @since 2.2.0
 */
public class ExampleInstallerWizard extends AbstractExampleInstallerWizard implements IExecutableExtension
{
  protected IConfigurationElement wizardConfigurationElement;
  protected List<ProjectDescriptor> projectDescriptors;
  protected List<FileToOpen> filesToOpen;
  
  public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException
  {
    wizardConfigurationElement = config;
  }  
  
  @Override
  protected List<ProjectDescriptor> getProjectDescriptors()
  {
    if (projectDescriptors == null)
    {
      loadFromExtensionPoints();
    }
    return projectDescriptors;
  }
  
  @Override
  protected List<FileToOpen> getFilesToOpen()
  {
    if (filesToOpen == null)
    {
      loadFromExtensionPoints();
    }
    return filesToOpen;
  }

  protected void loadFromExtensionPoints()
  {
    projectDescriptors = new ArrayList<ProjectDescriptor>();
    filesToOpen = new ArrayList<FileToOpen>();
    
    String wizardID = wizardConfigurationElement.getAttribute("id");
    
    IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(CommonUIPlugin.INSTANCE.getSymbolicName(), "examples");
    IConfigurationElement[] exampleElements = extensionPoint.getConfigurationElements();
    for (int i = 0; i < exampleElements.length; i++)
    {
      IConfigurationElement exampleElement = exampleElements[i];
      if ("example".equals(exampleElement.getName()) && wizardID.equals(exampleElement.getAttribute("wizardID")))
      {
        IConfigurationElement[] projectDescriptorElements = exampleElement.getChildren("projectDescriptor");
        for (int j = 0; j < projectDescriptorElements.length; j++)
        {
          IConfigurationElement projectDescriptorElement = projectDescriptorElements[j];
          String projectName = projectDescriptorElement.getAttribute("name");
          if (projectName != null)
          {
            String contentURI = projectDescriptorElement.getAttribute("contentURI");
            if (contentURI != null)
            {
              AbstractExampleInstallerWizard.ProjectDescriptor projectDescriptor = new AbstractExampleInstallerWizard.ProjectDescriptor();
              projectDescriptor.setName(projectName);
              
              URI uri = URI.createURI(contentURI);
              if (uri.isRelative())
              {
                uri = URI.createPlatformPluginURI(projectDescriptorElement.getContributor().getName() + "/" + contentURI, true);
              }
              projectDescriptor.setContentURI(uri);
              
              projectDescriptor.setDescription(projectDescriptorElement.getAttribute("description"));
              
              projectDescriptors.add(projectDescriptor);
            }
          }
        }
        
        if (!projectDescriptors.isEmpty())
        {
          IConfigurationElement[] openElements = exampleElement.getChildren("fileToOpen");
          for (int j = 0; j < openElements.length; j++)
          {
            IConfigurationElement openElement = openElements[j];
            String location = openElement.getAttribute("location");
            if (location != null)
            {
              AbstractExampleInstallerWizard.FileToOpen fileToOpen = new AbstractExampleInstallerWizard.FileToOpen();
              fileToOpen.setLocation(location);                
              fileToOpen.setEditorID(openElement.getAttribute("editorID"));
              filesToOpen.add(fileToOpen);
            }
          }
          
          String imagePath = exampleElement.getAttribute("pageImage");
          if (imagePath != null)
          {
            imagePath = imagePath.replace('\\', '/');
            if (!imagePath.startsWith("/"))
            {
              imagePath = "/" + imagePath;
            }

            Bundle pluginBundle = Platform.getBundle(exampleElement.getDeclaringExtension().getContributor().getName());
            try
            {
              ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(pluginBundle.getEntry(imagePath));
              setDefaultPageImageDescriptor(imageDescriptor);
            }
            catch (Exception e)
            {
              // Ignore
            }
          }
                    
          //Only one example per wizard
          break;
        }
      }
    }
  }
}
