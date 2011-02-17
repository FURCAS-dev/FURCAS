/**
 * <copyright>
 *
 * Copyright (c) 2006-2008 IBM Corporation and others.
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
 * $Id: AbstractExampleInstallerWizard.java,v 1.9 2009/04/16 18:41:06 davidms Exp $
 */
package org.eclipse.emf.common.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.RenameResourceAction;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.ide.undo.DeleteResourcesOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.eclipse.ui.wizards.datatransfer.ZipFileStructureProvider;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.CommonUIPlugin;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;


/**
 * <p>This abstract example installer wizard simply copies or unzips a number of files and
 * directories into the workspace, creating the projects to hold them. This wizard can be 
 * added as a new wizard to the new wizards dialog through the 
 * <tt>org.eclipse.ui.newWizards</tt> extension point.</p>
 * 
 * <p>Clients should subclass this class and override the {@link #getProjectDescriptors()}
 * method to provide the location and name of the project content that should be added to the 
 * workspace. Note that any projects that are already in the workspace will <i>not</i> be 
 * overwritten because the user could have made changes to them that would be lost.</p>
 * 
 * <p>It is highly recommended when registering subclasses to the new wizards extension point 
 * that the wizard declaration should have canFinishEarly = true. Any label and icon can be 
 * freely given to the wizard to suit the needs of the client.</p>
 * 
 * @since 2.2.0
 */
public abstract class AbstractExampleInstallerWizard extends Wizard implements INewWizard, IShellProvider
{
  public static class ProjectDescriptor
  {
    protected String name;
    protected URI contentURI;
    protected String description;

    protected IProject project;

    public URI getContentURI()
    {
      return contentURI;
    }

    public void setContentURI(URI contentURI)
    {
      this.contentURI = contentURI;
    }

    public String getName()
    {
      return name;
    }

    public void setName(String name)
    {
      this.name = name;
    }

    public String getDescription()
    {
      return description;
    }

    public void setDescription(String description)
    {
      this.description = description;
    }

    public IProject getProject()
    {
      if (project == null)
      {
        project = ResourcesPlugin.getWorkspace().getRoot().getProject(getName());
      }
      return project;
    }
  }
  
  public static class FileToOpen
  {
    protected String location;
    protected String editorID;
    
    protected IFile workspaceFile;
    
    public String getEditorID()
    {
      return editorID;
    }
    
    public void setEditorID(String editorID)
    {
      this.editorID = editorID;
    }
    
    public String getLocation()
    {
      return location;
    }
    
    public void setLocation(String location)
    {
      this.location = location;
    }
   
    public IFile getWorkspaceFile()
    {
      if (workspaceFile == null)
      {
        workspaceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(getLocation()));
      }
      return workspaceFile;
    }
  }

  public class ProjectPage extends WizardPage
  {
    protected org.eclipse.swt.widgets.List projectList;
    protected Text descriptionText;
    protected Button renameButton;

    public ProjectPage(String pageName, String title, ImageDescriptor titleImage)
    {
      super(pageName, title, titleImage);
    }

    public void createControl(Composite parent)
    {
      SashForm sashForm = new SashForm(parent, SWT.VERTICAL);
      sashForm.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.GRAB_VERTICAL));

      projectList = new org.eclipse.swt.widgets.List(sashForm, SWT.SINGLE | SWT.BORDER);
      projectList.setLayoutData(new GridData(GridData.FILL_BOTH));
      projectList.addSelectionListener(new SelectionAdapter()
        {
          @Override
          public void widgetSelected(SelectionEvent e)
          {
            itemSelected();
          }
        });
      projectList.setFocus();
      
      Composite composite = new Composite(sashForm, SWT.NONE);
      {
        GridLayout layout = new GridLayout(2, false);
        int margin = -5;
        int spacing = 3;
        layout.marginTop = margin;
        layout.marginLeft = margin;
        layout.marginRight = margin;
        layout.marginBottom = margin;
        layout.horizontalSpacing = spacing;
        layout.verticalSpacing = spacing;
        composite.setLayout(layout);
      }

      descriptionText = new Text(composite, SWT.READ_ONLY | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
      {
        GridData gridData = new GridData(GridData.FILL_BOTH);
        gridData.heightHint = convertHeightInCharsToPixels(2);
        gridData.grabExcessVerticalSpace = true;
        descriptionText.setLayoutData(gridData);
      }

      Composite buttonComposite = new Composite(composite, SWT.NONE);
      buttonComposite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.HORIZONTAL_ALIGN_END));
      buttonComposite.setLayout(new GridLayout());
      {
        GridLayout layout = new GridLayout();
        int margin = -5;
        int spacing = 3;
        layout.marginTop = margin;
        layout.marginLeft = margin;
        layout.marginRight = margin;
        layout.marginBottom = margin;
        layout.horizontalSpacing = spacing;
        layout.verticalSpacing = spacing;
        buttonComposite.setLayout(layout);
      }

      renameButton = new Button(buttonComposite, SWT.PUSH);
      renameButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.FILL_HORIZONTAL));
      renameButton.setText(CommonUIPlugin.INSTANCE.getString("_UI_Rename_label"));
      renameButton.addSelectionListener(new SelectionAdapter()
        {
          @Override
          public void widgetSelected(SelectionEvent e)
          {
            renameExistingProject();
          }
        });
      renameButton.setEnabled(false);

      refresh();
      sashForm.setWeights(new int []{ 70, 30 });
      setControl(sashForm);
    }

    public void refresh()
    {
      if (getProjectDescriptors().isEmpty())
      {
        setErrorMessage(CommonUIPlugin.INSTANCE.getString("_UI_NoProjectError_message"));
        setPageComplete(false);
      }
      else
      {
        setErrorMessage(null);
        
        int selectionIndex = projectList.getSelectionIndex();
        if (selectionIndex < 0)
        {
          selectionIndex = 0;
        }

        projectList.removeAll();
        for (ProjectDescriptor projectDescriptor : getProjectDescriptors())
        {
          String name = projectDescriptor.getName();
          boolean exists = projectDescriptor.getProject().exists();
          String item = exists
            ? CommonUIPlugin.INSTANCE.getString("_UI_ExistingProjectName_message", new String []{ name })
            : name;
          projectList.add(item);

          projectList.setData(item, projectDescriptor);
        }

        if (getControl() != null)
        {
          projectList.setSelection(selectionIndex);
          itemSelected();
        }
        
        setPageComplete(true);
      }
    }
    
    @Override
    public void setVisible(boolean visible)
    {
      if (visible && 
          projectList.getItemCount() > 0 &&
          projectList != null && 
          projectList.getSelectionCount() == 0)
      {
        int index = 0;
        int count = 0;
        for (ProjectDescriptor projectDescriptor : getProjectDescriptors())
        {
          if (projectDescriptor.getProject().exists())
          {
            index = count;
            break;
          }
          count++;
        }        
        projectList.select(index);
        refresh();
      }
      super.setVisible(visible);
    }
    
    protected ProjectDescriptor getSelectedProjectDescriptor()
    {
      return projectList.getSelectionCount() == 0 ?
        null :
        (ProjectDescriptor)projectList.getData(projectList.getSelection()[0]);
    }

    protected void itemSelected()
    {
      ProjectDescriptor projectDescriptor = getSelectedProjectDescriptor();
      if (projectDescriptor != null)
      {
        boolean exists = projectDescriptor.getProject().exists();
        renameButton.setEnabled(exists);
  
        String description = projectDescriptor.getDescription() != null ? projectDescriptor.getDescription() : "";
        if (exists)
        {
          String renameMessage = CommonUIPlugin.INSTANCE.getString("_UI_ProjectRename_message");
          description = description == "" ?
            renameMessage :
            CommonUIPlugin.INSTANCE.getString("_UI_ProjectDescriptionAndRename_message", new String[] {description, renameMessage});
        }
        descriptionText.setText(description);
      }
    }

    protected void renameExistingProject()
    {
      ProjectDescriptor projectDescriptor = getSelectedProjectDescriptor();
      if (projectDescriptor != null && projectDescriptor.getProject().exists())
      {
        RenameResourceAction renameResourceAction = new RenameResourceAction(AbstractExampleInstallerWizard.this);
        renameResourceAction.selectionChanged(new StructuredSelection(projectDescriptor.getProject()));
        renameResourceAction.run();
        projectDescriptor.project = null;
        refresh();
      }
    }
  }

  protected static final IOverwriteQuery OVERWRITE_ALL_QUERY = new IOverwriteQuery()
    {
      public String queryOverwrite(String pathString)
      {
        return IOverwriteQuery.ALL;
      }
    };

  protected IWorkbench workbench;
  protected IStructuredSelection structuredSelection;

  public AbstractExampleInstallerWizard()
  {
    setNeedsProgressMonitor(true);
    setWindowTitle(CommonUIPlugin.INSTANCE.getString("_UI_ExampleInstallerWizard_title"));
  }

  public void init(IWorkbench workbench, IStructuredSelection selection)
  {
    this.workbench = workbench;
    this.structuredSelection = selection;
  }

  /**
   * Returns the project descriptors to be used by this wizard.  This method is
   * called multiple times, so subclasses are expected to cache this information 
   * if necessary.
   * @return a list of ProjectDescriptors
   */
  protected abstract List<ProjectDescriptor> getProjectDescriptors();
  protected abstract List<FileToOpen> getFilesToOpen();

  protected ProjectPage projectPage;

  @Override
  public void dispose()
  {
    projectPage = null;
    super.dispose();
  }

  @Override
  public void addPages()
  {
    projectPage = new ProjectPage("projectPage", CommonUIPlugin.INSTANCE.getString("_UI_ProjectPage_title"), null);
    projectPage.setDescription(CommonUIPlugin.INSTANCE.getString("_UI_ProjectPage_description"));
    addPage(projectPage);
  }

  @Override
  public boolean performFinish()
  {
    final Exception exceptionWrapper = new Exception();

    try
    {
      getContainer().run(false, true, new IRunnableWithProgress()
        {
          public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException
          {
            monitor.beginTask(CommonUIPlugin.INSTANCE.getString("_UI_InstallingExample_message"), 3);

            WorkspaceModifyOperation op = new WorkspaceModifyOperation()
              {
                @Override
                protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException
                {
                  Diagnostic diagnostic = deleteExistingProjects(new SubProgressMonitor(monitor, 1));
                  if (diagnostic.getSeverity() != Diagnostic.OK)
                  {
                    exceptionWrapper.initCause(new DiagnosticException(diagnostic));
                    throw new InterruptedException();
                  }
                  
                  try
                  {
                    installExample(monitor);
                  }
                  catch (Exception e)
                  {
                    exceptionWrapper.initCause(e);
                    throw new InterruptedException();
                  }
                }
              };  
            op.run(new SubProgressMonitor(monitor, 1));
            
            openFiles(new SubProgressMonitor(monitor, 1));
            monitor.done();
          }
        });
      
      return true;
    }
    catch (InterruptedException e)
    {
      if (exceptionWrapper.getCause() != null)
      {
        openErrorDialog(CommonUIPlugin.INSTANCE.getString("_UI_InstallExampleError_message"), exceptionWrapper.getCause());
      }
    }
    catch (InvocationTargetException e)
    {
      CommonUIPlugin.INSTANCE.log(e);
    }

    if (projectPage != null && !projectPage.getControl().isDisposed())
    {
      projectPage.refresh();
    }
    return false;
  }
  
  protected Diagnostic deleteExistingProjects(IProgressMonitor monitor)
  {
    StringBuilder projectNames = new StringBuilder();
    List<IProject> projects = new ArrayList<IProject>();
    for (ProjectDescriptor projectDescriptor : getProjectDescriptors())
    {
      IProject project = projectDescriptor.getProject();
      if (project.exists())
      {
        projectNames.append(", '").append(project.getName()).append("'");
        projects.add(project);
      }
    }
    
    if (!projects.isEmpty())
    {
      projectNames.delete(0, ", ".length());
            
      String title = null;
      String message = null;
      if (projects.size() == 1)
      {
        title = CommonUIPlugin.INSTANCE.getString("_UI_ConfirmSingleDeletion_title");
        message = CommonUIPlugin.INSTANCE.getString("_UI_ConfirmSingleDeletion_message", new String[]{projectNames.toString()});
      }
      else
      {
        title = CommonUIPlugin.INSTANCE.getString("_UI_ConfirmMultipleDeletion_title");
        message = CommonUIPlugin.INSTANCE.getString("_UI_ConfirmMultipleDeletion_message", new String[]{projectNames.toString()});
      }
      
      if (MessageDialog.openConfirm(getShell(), title, message))
      {
        DeleteResourcesOperation op = 
          new DeleteResourcesOperation(projects.toArray(new IProject[projects.size()]), "deleteprojects", true);
        try
        {
          return BasicDiagnostic.toDiagnostic(op.execute(new SubProgressMonitor(monitor, 1), null));
        }
        catch (ExecutionException e)
        {
          return BasicDiagnostic.toDiagnostic(e);
        }
      }
      else
      {
        return Diagnostic.CANCEL_INSTANCE;
      }
    }
    return Diagnostic.OK_INSTANCE;
  }

  /**
   * Installs the projects described by {@link #getProjectDescriptors}.
   * <p>
   * In EMF 2.4, this worked by obtaining an {@link ImportOperation} for each descriptor from {@link #createImportOperation}, and then creating the project and running the operation.
   * Beginning in EMF 2.5, {@link #createImportOperation} returns null by default, and {@link #installProject(ProjectDescriptor, IProgressMonitor)} is called to create the project, create the operation, and run it.
   * This allows the same code that creates the operation to do any cleanup required after executing it. This change was needed to stop extending {@link ImportOperation}, which was an API violation.
   * <p>
   * Note that existing overrides of {@link #createImportOperation} and the methods it calls are still supported; however, it is recommended to switch over to the new design.
   */
  protected void installExample(IProgressMonitor progressMonitor) throws Exception
  {
    List<ProjectDescriptor> projectDescriptors = getProjectDescriptors();
    progressMonitor.beginTask(CommonUIPlugin.INSTANCE.getString("_UI_CreatingProjects_message"), 2 * projectDescriptors.size());
    for (ProjectDescriptor projectDescriptor : projectDescriptors)
    {
      ImportOperation importOperation = createImportOperation(projectDescriptor);
      if (importOperation != null)
      {
        installProject(projectDescriptor, importOperation, progressMonitor);
      }
      else
      {
        installProject(projectDescriptor, progressMonitor);
      }
    }
    progressMonitor.done();
  }

  protected void openFiles(IProgressMonitor progressMonitor)
  {
    List<FileToOpen> filesToOpen = getFilesToOpen();
    if (!filesToOpen.isEmpty())
    {
      progressMonitor.beginTask(CommonUIPlugin.INSTANCE.getString("_UI_OpeningFiles_message"), filesToOpen.size());
      for (FileToOpen fileToOpen : filesToOpen)
      {
        IFile workspaceFile = fileToOpen.getWorkspaceFile();
        if (workspaceFile != null && workspaceFile.exists())
        {
          try
          {
            openEditor(workspaceFile, fileToOpen.getEditorID());
            progressMonitor.worked(1);
          }
          catch (PartInitException e)
          {
            CommonUIPlugin.INSTANCE.log(e);
          }
        }
      }
      progressMonitor.done();
    }    
  }

  protected void openErrorDialog(String message, Throwable throwable)
  {
    DiagnosticDialog.open(getShell(), CommonUIPlugin.INSTANCE.getString("_UI_Error_label"), message, BasicDiagnostic.toDiagnostic(throwable));
  }

  /**
   * Creates the project described by the given <code>projectDescriptor</code> and imports its contents using the given <code>importOperation</code>.
   * @since 2.5
   */
  protected void installProject(ProjectDescriptor projectDescriptor, ImportOperation importOperation, IProgressMonitor progressMonitor) throws Exception
  {
    createProject(projectDescriptor, new SubProgressMonitor(progressMonitor, 1));
    importOperation.setContext(getShell());
    importOperation.run(new SubProgressMonitor(progressMonitor, 1));    
  }

  protected void createProject(ProjectDescriptor projectDescriptor, IProgressMonitor monitor) throws CoreException
  {
    monitor.beginTask(CommonUIPlugin.INSTANCE.getString("_UI_CreateProject_message", new String []{ projectDescriptor.getName() }), 3);

    IProject project = projectDescriptor.getProject();
    project.create(new SubProgressMonitor(monitor, 1));
    project.open(new SubProgressMonitor(monitor, 1));

    monitor.done();
  }

  /**
   * Installs the project described by the given <code>projectDescriptor</code>.
   * This implementation simply looks at the form of its content URI and delegates to {@link #installProjectFromDirectory}
   * or {@link #installProjectFromFile}, as appropriate.
   * @since 2.5
   */
  protected void installProject(ProjectDescriptor projectDescriptor, IProgressMonitor progressMonitor) throws Exception
  {
    URI contentURI = projectDescriptor.getContentURI();
    if (contentURI.hasTrailingPathSeparator())
    {
      installProjectFromDirectory(projectDescriptor, progressMonitor);
    }
    else
    {
      installProjectFromFile(projectDescriptor, progressMonitor);
    }
  }

  /**
   * This method was used in EMF 2.4 and earlier to obtain an <code>ImportOperation</code> for installing a project.
   * This implementation now merely returns null (or throws an exception for unsupported content forms). 
   * @deprecated Use {@link #installProject(ProjectDescriptor, IProgressMonitor)}, which also actually creates the project and performs the import.
   */
  @Deprecated
  protected ImportOperation createImportOperation(ProjectDescriptor projectDescriptor) throws Exception
  {
    URI contentURI = projectDescriptor.getContentURI();
    if (contentURI.hasTrailingPathSeparator())
    {
      return createDirectoryImportOperation(projectDescriptor);
    }
    else
    {
      return createFileImportOperation(projectDescriptor);
    }
  }

  /**
   * Installs the project described by the given <code>projectDescriptor</code> from a directory.
   * This implementation should handle the directory scenario completely, but will throw an exception if the specified directory is not found or readable.
   * @since 2.5
   */
  protected void installProjectFromDirectory(ProjectDescriptor projectDescriptor, IProgressMonitor progressMonitor) throws Exception
  {
    URI contentURI = projectDescriptor.getContentURI();
    if (contentURI.isPlatform())
    {
      contentURI = CommonPlugin.asLocalURI(contentURI);
    }

    ImportOperation importOperation = null;
    String location = contentURI.toFileString();
    if (location != null)
    {
      File directory = new File(location);
      if (directory.isDirectory() && directory.canRead())
      {
        List<File> filesToImport = new ArrayList<File>();
        filesToImport.addAll(Arrays.asList(directory.listFiles()));

        importOperation = new ImportOperation(
          projectDescriptor.getProject().getFullPath(),
          directory,
          FileSystemStructureProvider.INSTANCE,
          OVERWRITE_ALL_QUERY,
          filesToImport);
        importOperation.setCreateContainerStructure(false);
      }
    }

    if (importOperation != null)
    {
      installProject(projectDescriptor, importOperation, progressMonitor);
    }
    else
    {
      throw new Exception(CommonUIPlugin.INSTANCE.getString("_UI_DirectoryError_message", new String [] { contentURI.toString() }));
    }
  }

  /**
   * This method was used in EMF 2.4 and earlier to obtain an <code>ImportOperation</code> for installing a project from a directory.
   * This implementation now merely returns null. 
   * @deprecated Use {@link #installProjectFromDirectory}, which also actually creates the project and performs the import.
   */
  @Deprecated
  protected ImportOperation createDirectoryImportOperation(ProjectDescriptor projectDescriptor) throws Exception
  {
    return null;
  }

  /**
   * Installs the project described by the given <code>projectDescriptor</code> from a file.
   * This implementation only handles zip files, throwing an exception otherwise. It may be overridden to handle other cases.
   * @since 2.5
   */
  protected void installProjectFromFile(ProjectDescriptor projectDescriptor, IProgressMonitor progressMonitor) throws Exception
  {
    URI contentURI = projectDescriptor.getContentURI();
    if (contentURI.isPlatform())
    {
      contentURI = CommonPlugin.asLocalURI(contentURI);
    }

    ImportOperation importOperation = null;
    ZipFile zipFile = null;
    try
    {
      String location = contentURI.toFileString();
      if (location != null)
      {
        File file = new File(location);
        if (file.isFile() && file.canRead())
        {
          zipFile = createZipFile(file);
          if (zipFile != null)
          {
            ZipFileStructureProvider structureProvider = new ZipFileStructureProvider(zipFile);
            importOperation = new ImportOperation(
              projectDescriptor.getProject().getFullPath(),
              structureProvider.getRoot(),
              structureProvider,
              OVERWRITE_ALL_QUERY);
          }
        }
      }
  
      if (importOperation != null)
      {
        installProject(projectDescriptor, importOperation, progressMonitor);
      }
      else
      {
        throw new Exception(CommonUIPlugin.INSTANCE.getString("_UI_FileError_message", new String [] { contentURI.toString() }));
      }
    }
    finally
    {
      if (zipFile != null)
      {
        try
        {
          zipFile.close();
        }
        catch (IOException e)
        {
          // Ignore.
        }
      }      
    }
  }

  /**
   * This method was used in EMF 2.4 and earlier to obtain an <code>ImportOperation</code> for installing a project from a file.
   * This implementation now merely returns null (or throws an exception for unsupported files).
   * @deprecated Use {@link #installProjectFromFile}, which also actually creates the project and performs the import.
   */
  @Deprecated
  protected ImportOperation createFileImportOperation(ProjectDescriptor projectDescriptor) throws Exception
  {
    URI contentURI = projectDescriptor.getContentURI();
    if (contentURI.isPlatform())
    {
      contentURI = CommonPlugin.asLocalURI(contentURI);
    }

    String location = contentURI.toFileString();
    if (location != null)
    {
      File file = new File(location);
      if (file.isFile() && file.canRead())
      {
        if (isZipFile(file))
        {
          return createZipImportOperation(projectDescriptor, file);
        }
      }
    }

    throw new Exception(CommonUIPlugin.INSTANCE.getString("_UI_FileError_message", new String []{ contentURI.toString() }));
  }

  /**
   * Returns a <code>ZipFile</code> for reading from the given file, if it is in fact a zip file; null otherwise.
   * The client is responsible for closing the zip file if it is non-null.
   * @since 2.5
   */
  protected ZipFile createZipFile(File file)
  {
    try
    {
      return new ZipFile(file);
    }
    catch (ZipException e)
    {
      // Ignore
    }
    catch (IOException e)
    {
      // Ignore
    }
    return null;
  }

  /**
   * This method was used in EMF 2.4 and earlier to test if a <code>File</code> represents a zip file.
   * @deprecated Use {@link #createZipFile}, which doesn't require creating another {@link ZipFile}.
   */
  @Deprecated
  protected boolean isZipFile(File file)
  {
    try
    {
      ZipFile zipFile = new ZipFile(file);
      zipFile.close();
      return true;
    }
    catch (ZipException e)
    {
      // Ignore
    }
    catch (IOException e)
    {
      // Ignore
    }
    return false;
  }

  /**
   * This method was used in EMF 2.4 and earlier to obtain an <code>ImportOperation</code> for installing a project from a zip file.
   * This implementation now merely returns null.
   * @deprecated Use {@link #installProjectFromFile}, which handles zip files directly, and also actually creates the project and performs the import.
   */
  @Deprecated
  protected ImportOperation createZipImportOperation(ProjectDescriptor projectDescriptor, File file) throws Exception
  {
    return null;
  }
  
  protected IWorkbench getWorkbench()
  {
    return workbench;
  }

  protected IStructuredSelection getSelection()
  {
    return structuredSelection;
  }  
  
  protected void openEditor(IFile file, String editorID) throws PartInitException
  {
    IEditorRegistry editorRegistry = getWorkbench().getEditorRegistry();
    if (editorID == null || editorRegistry.findEditor(editorID) == null)
    {
      editorID = getWorkbench().getEditorRegistry().getDefaultEditor(file.getFullPath().toString()).getId();
    }
    
    IWorkbenchPage page = getWorkbench().getActiveWorkbenchWindow().getActivePage();
    page.openEditor(new FileEditorInput(file), editorID, true, IWorkbenchPage.MATCH_ID);
  }  
}
