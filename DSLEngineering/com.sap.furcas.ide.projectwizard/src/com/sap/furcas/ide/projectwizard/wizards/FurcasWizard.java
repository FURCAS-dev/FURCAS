/* <copyright>
 *
 * Copyright (c) 2004-2007 IBM Corporation and others.
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
 * $Id: EcoreModelWizard.java,v 1.17 2008/04/27 20:30:36 davidms Exp $
 */
package com.sap.furcas.ide.projectwizard.wizards;


import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.progress.UIJob;


/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FurcasWizard extends Wizard implements INewWizard
{
	  protected FurcasWizardLanguagePage page;
	  protected FurcasWizardMMSelectionPage page2;
	  public boolean createmm;
	  public boolean lpe;
	  public Wizard getWiz() {
		return this;
	  }


	  public FurcasWizard()
	  {
	    super();
	    setNeedsProgressMonitor(true);
	    setWindowTitle("Furcas DSL Engineering Project Creator");
	    lpe = false;
	    createmm=false;
	  }
  /**
   * The supported extensions for created files.
   * <!-- begin-user-doc -->
   * @since 2.4
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<String> FILE_EXTENSIONS =
    Collections.unmodifiableList(Arrays.asList(EcoreEditorPlugin.INSTANCE.getString("_UI_EcoreEditorFilenameExtensions").split("\\s*,\\s*")));

  /**
   * A formatted list of supported file extensions, suitable for display.
   * <!-- begin-user-doc -->
   * @since 2.4
   * <!-- end-user-doc -->
   * @generated
   */
  public static final String FORMATTED_FILE_EXTENSIONS =
    EcoreEditorPlugin.INSTANCE.getString("_UI_EcoreEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");

  /**
   * This caches an instance of the model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EcorePackage ecorePackage = EcorePackage.eINSTANCE;

  /**
   * This caches an instance of the model factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EcoreFactory ecoreFactory = ecorePackage.getEcoreFactory();


  /**
   * This is the initial object creation page.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  /**
   * Remember the selection during initialization for populating the default container.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IStructuredSelection selection;

  /**
   * Remember the workbench during initialization.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IWorkbench workbench;

  /**
   * Caches the names of the types that can be created as the root object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected List<String> initialObjectNames;
  
  protected ImageDescriptor getDefaultImageDescriptor()
  {
	  ClassLoader cL = this.getClass().getClassLoader();
	  ImageDescriptor iD = null;
	  URL url=cL.getResource("icons/furcasdeath.gif");
	  iD=ImageDescriptor.createFromURL(url);
	  return iD;
  }


  /**
   * This just records the information.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void init(IWorkbench workbench, IStructuredSelection selection)
  {
    this.workbench = workbench;
    this.selection = selection;
    setWindowTitle(EcoreEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
    setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(EcoreEditorPlugin.INSTANCE.getImage("full/wizban/NewEcore")));
  }

  /**
   * Returns the names of the types that can be created as the root object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection<String> getInitialObjectNames()
  {
    if (initialObjectNames == null)
    {
      initialObjectNames = new ArrayList<String>();
      for (EClassifier eClassifier : ecorePackage.getEClassifiers())
      {
        if (eClassifier instanceof EClass)
        {
          EClass eClass = (EClass)eClassifier;
          if (!eClass.isAbstract())
          {
            initialObjectNames.add(eClass.getName());
          }
        }
      }
      Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
    }
    return initialObjectNames;
  }

  /**
   * Create a new model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  protected EObject createInitialModel()
  {
    EClass eClass = (EClass)ecorePackage.getEClassifier("EPackage");
    EObject rootObject = ecoreFactory.create(eClass);

    // We can't have a null name, in case we're using EMOF serialization.
    //
    if (rootObject instanceof ENamedElement)
    {
      ((ENamedElement)rootObject).setName("");
    }
    return rootObject;
  }

  /**
   * Do the work after everything is specified.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  
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
  			new CreateProject(pi, getShell()).run(monitor);
  			if (createmm || lpe){
  				createMMProject(monitor);
  		    	doAdditional();
  		    	generateSpecific();
  			}
  			if (lpe){
  				loadmm(); //TODO
  			}
  			
  		} catch (InvocationTargetException e) {
  		} catch (InterruptedException e) {
  		}


  		return Status.OK_STATUS;
  	    }

  	}.schedule();
  }
  

  public void doAdditional()
  {
	IWorkbenchPage wpage = null;
    try
    {

      // Do the work within an operation.
      //
      WorkspaceModifyOperation operation =
        new WorkspaceModifyOperation()
        {
          @Override
          protected void execute(IProgressMonitor progressMonitor)
          {
            try
            {
              // Create a resource set
              //
              ResourceSet resourceSet = new ResourceSetImpl();
              resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());

              // Get the URI of the model file.
              //
              String mmprojectpath = page.getProjectInfo().getProjectName() + ".metamodel/"+
              		page.getProjectInfo().getLanguageName() + ".ecore";
              URI fileURI = URI.createPlatformResourceURI(mmprojectpath, true);

              // Create a resource for this file. Don't specify a content type, as it could be Ecore or EMOF.
              //
              Resource resource = resourceSet.createResource(fileURI);

              // Add the initial model object to the contents.
              //
              EObject rootObject = createInitialModel();
              if (rootObject != null)
              {
                resource.getContents().add(rootObject);
              }

              // Save the contents of the resource to the file system.
              //
              Map<Object, Object> options = new HashMap<Object, Object>();
              options.put(XMLResource.OPTION_ENCODING, "UTF-8");
              resource.save(options);
            }
            catch (Exception exception)
            {
              EcoreEditorPlugin.INSTANCE.log(exception);
            }
            finally
            {
              progressMonitor.done();
            }
          }
        };

      getContainer().run(false, false, operation);
      
      final IFile modelFile = getModelFile();
      
      IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
      wpage = workbenchWindow.getActivePage();
      final IWorkbenchPart activePart = wpage.getActivePart();
      if (activePart instanceof ISetSelectionTarget)
      {
        final ISelection targetSelection = new StructuredSelection(modelFile);
        getShell().getDisplay().asyncExec
          (new Runnable()
           {
             public void run()
             {
               ((ISetSelectionTarget)activePart).selectReveal(targetSelection);
             }
           });
      }

      // Open an editor on the new file.
      //
      try
      {
        IEditorDescriptor defaultEditor = 
          workbench.getEditorRegistry().getDefaultEditor(modelFile.getFullPath().toString());
          wpage.openEditor
          (new FileEditorInput(modelFile),
           defaultEditor == null ? "org.eclipse.emf.ecore.presentation.EcoreEditorID" : defaultEditor.getId());
       }
      catch (PartInitException exception)
      {
        MessageDialog.openError(workbenchWindow.getShell(), EcoreEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
      }

    }
    catch (Exception exception)
    {
      EcoreEditorPlugin.INSTANCE.log(exception);
    }
  }



  /**
   * This is the page where the type of object to create is selected.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */

  /**
   * The framework calls this to create the contents of the wizard.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void addPages()  {
		createmm=false;
		page = new FurcasWizardLanguagePage(selection);
		addPage(page);
		page2 = new FurcasWizardMMSelectionPage(selection,this);
		addPage(page2);
    
  }

  /**
   * Get the file.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IFile getModelFile()
  {
	Path path = new Path(page.getProjectInfo().getProjectName() + ".metamodel/"+
      		page.getProjectInfo().getLanguageName() + ".ecore");
	
    return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
  }
  
  public void addMMP(){
	  createmm = true;
  }

  public void enableLoadPage() {
	  lpe=true;	
  }
  
  /*  This method provides the generation of the MetaModelspecific 
  files and coding in the dsl project.*/
  protected void generateSpecific(){
	  //	  TODO see above
  }
  /* This method generates a modelfile in the project folder and opens the load ressources dialog.
   Afterwords it also generates the MetaModelspecific files and coding in the project.*/
 
  protected void loadmm() {
	}
  
	public void createMMProject(IProgressMonitor monitor){
		ProjectInfo info = page.getProjectInfo();
		String projectname = info.getProjectName() + ".metamodel";
		IProjectDescription description;
		try {
			IProgressMonitor progressMonitor = new NullProgressMonitor();

			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IProject project = root.getProject(projectname);
			project.create(progressMonitor);
			project.open(progressMonitor);
			description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = JavaCore.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, progressMonitor);
			@SuppressWarnings("unused")
			IJavaProject javaProject = JavaCore.create(project);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
/*	  Used to see when to enable the Finish button. Has to be changed when changing the 
	  amount of pages in the wizard.*/
	  @Override
	  public boolean canFinish()
	  {
		  IWizardPage[] pages = getPages();
	      for (int i = 0; i < pages.length; i++) {
	    	  if (!createmm && lpe)
	    		  return true;
	          if (!pages[i].isPageComplete())
	        	  return false;
	      }
	      return true;
	  }

}








/*
*//**
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
 *//*
package com.sap.furcas.ide.projectwizard.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.progress.UIJob;

import org.eclipse.emf.converter.ui.ModelConverterDescriptorSelectionPage;
import org.eclipse.emf.importer.ImporterPlugin;
import org.eclipse.emf.importer.ui.EMFModelWizard;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

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
  public boolean lpe;

  public FurcasWizard()
  {
    super();
    setNeedsProgressMonitor(true);
    setWindowTitle("Furcas DSL Engineering Project Creator");
    lpe = false;
    createmm=false;
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
  public ModelConverterDescriptorSelectionPage addMMP(){
	  createmm = true;
	    addSelectionPage();
	return selectionPage;
  }
  @Override
  protected void addSelectionPage()
  {
    selectionPage = new SelectionPage("ModelImporterDescriptorSelectionPage", workbench, selection);
    selectionPage.setTitle(ImporterPlugin.INSTANCE.getString("_UI_SelectModelImporters_title"));
    selectionPage.setModeConverterWizardDefaultImageDescriptor(getDefaultImageDescriptor());
    selectionPage.setModelConverterDescriptor(computeSuggestedDescriptor());     
    addPage(selectionPage);
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
			if (createmm){
				createMMProject(monitor);
		    	selectionPage.performFinish();
		    	generateSpecific();
			}
			if (!createmm && lpe){
				loadmm();
			}
			new CreateProject(pi, getShell()).run(monitor);
		} catch (InvocationTargetException e) {
		} catch (InterruptedException e) {
		}


		return Status.OK_STATUS;
	    }

	}.schedule();
}




  
  Used to see when to enable the Finish button. Has to be changed when changing the 
  amount of pages in the wizard.
  @Override
  public boolean canFinish()
  {
	  IWizardPage[] pages = getPages();
      for (int i = 0; i < pages.length; i++) {
    	  if (!createmm && lpe)
    		  return true;
          if (!pages[i].isPageComplete())
        	  return false;
          if (pages.length==4 && lpe==false)
        	  return false;
          if (pages.length==5 && lpe==true)
        	  return false;
      }
      return true;
  }

  public void enableLoadPage() {
	  lpe=true;	
  }
  
  This method provides the generation of the MetaModelspecific 
  files and coding in the dsl project.
  protected void generateSpecific(){
//	  TODO see above
  }
 This method generates a modelfile in the project folder and opens the load ressources dialog.
   Afterwords it also generates the MetaModelspecific files and coding in the project.*
 
  protected void loadmm() {
		// TODO see above
		
	}
  
  
	@SuppressWarnings("null")
	public void createMMProject(IProgressMonitor monitor){
		final ProjectInfo info = page.getProjectInfo();
		IProject mmproject = null;
		String mmProjectName = info.getProjectName()+".metamodel";
	    @SuppressWarnings("unused")
		IJavaProject javaProject = JavaCore.create(mmproject);
	    IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(mmProjectName);
	    projectDescription.setLocation(null);
	    try {
			mmproject.create(projectDescription,1, monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
	}




}
*/
