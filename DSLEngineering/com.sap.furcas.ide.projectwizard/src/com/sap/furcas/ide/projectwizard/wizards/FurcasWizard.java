
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
package com.sap.furcas.ide.projectwizard.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.progress.UIJob;

import org.eclipse.emf.importer.ImporterPlugin;
import org.eclipse.emf.importer.ui.EMFModelWizard;
import org.eclipse.emf.importer.ui.contribution.IModelImporterWizard;
import org.eclipse.emf.importer.ui.contribution.ModelImporterDescriptor;
import org.eclipse.emf.importer.ui.contribution.ModelImporterManager;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;


/**
 * @since 2.1.0
 */
public class FurcasWizard extends EMFModelWizard
{
  protected FurcasWizardLanguagePage page;
  protected FurcasWizardMMSelectionPage page2;
  protected IPath projectLocation;
  protected IPath projectPath;
  public boolean createmm;
  public Wizard getWiz() {
	return this;
  }

  public FurcasWizard()
  {
    super();
    setNeedsProgressMonitor(true);
    setWindowTitle("Furcas DSL Engineering Project Creator");
  }
  
  @Override
  protected ImageDescriptor getDefaultImageDescriptor()
  {
	  ClassLoader cL = this.getClass().getClassLoader();
	  ImageDescriptor iD = null;
	  URL url=cL.getResource("icons/furcasdeath.gif");
	  iD=ImageDescriptor.createFromURL(url);
	  return iD;
  }
  public WizardNewProjectCreationPage addMMP(){
	  createmm = true;
	  WizardNewProjectCreationPage page3 = new WizardNewProjectCreationPage("NewProjectCreationPage")
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
    page3.setTitle(ImporterPlugin.INSTANCE.getString("_UI_EMFProjectWizard_name"));
    page3.setDescription(ImporterPlugin.INSTANCE.getString("_UI_CreateEMFProject_label"));
    addPage(page3);

    if (defaultPath != null)
    {
      String path = defaultPath.removeLastSegments(defaultPath.segmentCount()-1).toString();
      page3.setInitialProjectName(path.charAt(0) == '/' ? path.substring(1) : path);
      page3.setPageComplete(page3.isPageComplete());    
    }
    
    addSelectionPage();
	return page3;
  }
 
  @Override
  public void addPages()
  {
	createmm=false;
	page = new FurcasWizardLanguagePage(selection);
	addPage(page);
	page2 = new FurcasWizardMMSelectionPage(selection,this);
	addPage(page2);

    
  }
  
  @Override
public boolean performFinish() {
	  

	  final ProjectInfo pi = page.getProjectInfo();

	  if (page.valid) {

		  IRunnableWithProgress op = new IRunnableWithProgress() {
			  @Override
			  public void run(IProgressMonitor monitor) throws InvocationTargetException {

				  doFinish(pi, monitor);

				  monitor.done();
			  }
		  };

		  try {
    		getContainer().run(true, false, op);
		  } catch (InterruptedException e) {
			  return false;
		  } catch (InvocationTargetException e) {
			  Throwable realException = e.getTargetException();
			  MessageDialog.openError(getShell(), "Error", realException.getMessage());
			  return false;
		  }
		  return true;
	  	} else {
		  return false;
	  	}
  }
  
void doFinish(final ProjectInfo pi, IProgressMonitor monitor) {
	new UIJob("creating FURCAS projects...") {
	    @Override
	    public IStatus runInUIThread(IProgressMonitor monitor) {
	    
	    try {	
			if (createmm) 
		    	selectionPage.performFinish();
			new CreateProject(pi, getShell()).run(monitor);
		} catch (InvocationTargetException e) {
		} catch (InterruptedException e) {
		}


		return Status.OK_STATUS;
	    }

	}.schedule();
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
  @Override
  public boolean canFinish()
  {
	  IWizardPage[] pages = getPages();
      // Default implementation is to check if all pages are complete.
      for (int i = 0; i < pages.length; i++) {
          if (!pages[i].isPageComplete()) {
				return false;
			}
          if (pages.length==4)
        	  return false;
      }
      return true;
  }
}

///*******************************************************************************
// *
// *******************************************************************************/
//package com.sap.furcas.ide.wiz.wizards;
//
//import java.lang.reflect.InvocationTargetException;
//
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.IStatus;
//import org.eclipse.core.runtime.Status;
//import org.eclipse.jface.dialogs.MessageDialog;
//import org.eclipse.jface.operation.IRunnableWithProgress;
//import org.eclipse.jface.viewers.ISelection;
//import org.eclipse.jface.viewers.IStructuredSelection;
//import org.eclipse.jface.wizard.Wizard;
//import org.eclipse.ui.INewWizard;
//import org.eclipse.ui.IWorkbench;
//import org.eclipse.ui.IWorkbenchWizard;
//import org.eclipse.ui.progress.UIJob;
//
//
//public class FurcasWizard extends Wizard implements INewWizard {
//
//	protected FurcasWizardLanguagePage page;
//	protected FurcasWizardMMSelectionPage page2;
//    private ISelection selection;
//    public Wizard getWiz() {
//    	return this;
//    }
//
//    public FurcasWizard() {
//	super();
//	setNeedsProgressMonitor(true);
//    }
//
//    @Override
//    public void addPages() {
//	page = new FurcasWizardLanguagePage(selection);
//	addPage(page);
//	Wizard wiz;
//	wiz=getWiz();
//	page2 = new FurcasWizardMMSelectionPage(selection,wiz);
//	addPage(page2);
//
//    }
//
//    @Override
//public boolean performFinish() {
//final ProjectInfo pi = page.getProjectInfo();
//
//if (page.valid) {
//
//    IRunnableWithProgress op = new IRunnableWithProgress() {
//	@Override
//	public void run(IProgressMonitor monitor) throws InvocationTargetException {
//
//		doFinish(pi, monitor);
//
//		monitor.done();
//	}
//    };
//
//    try {
//	getContainer().run(true, false, op);
//    } catch (InterruptedException e) {
//	return false;
//    } catch (InvocationTargetException e) {
//	Throwable realException = e.getTargetException();
//	MessageDialog.openError(getShell(), "Error", realException.getMessage());
//	return false;
//    }
//    return true;
//} else {
//    return false;
//}
//}
//    
//    void doFinish(final ProjectInfo pi, IProgressMonitor monitor) {
//	new UIJob("creating FURCAS projects...") {
//	    @Override
//	    public IStatus runInUIThread(IProgressMonitor monitor) {
//	    
//	    try {	    	
//			new CreateProject(pi, getShell()).run(monitor);
//		} catch (InvocationTargetException e) {
//		} catch (InterruptedException e) {
//		}
//
//
//		return Status.OK_STATUS;
//	    }
//
//	}.schedule();
//
//    }
//
//    /**
//     * We will accept the selection in the workbench to see if we can initialize
//     * from it.
//     * 
//     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
//     */
//    @Override
//    public void init(IWorkbench workbench, IStructuredSelection selection) {
//	this.selection = selection;
//    }
//}