package com.sap.furcas.ide.projectwizard.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.ecore.presentation.EcoreEditorPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
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

import com.sap.furcas.ide.dslproject.conf.EcoreMetaProjectConf;
import com.sap.furcas.ide.dslproject.conf.ProjectMetaRefConfFactory;
import com.sap.furcas.ide.projectwizard.util.CodeGenerationException;
import com.sap.furcas.ide.projectwizard.util.CreateMMProject;
import com.sap.furcas.ide.projectwizard.util.CreateProject;
import com.sap.furcas.ide.projectwizard.util.ProjectInfo;

/**
 * This Wizard creates a pair of projects for the Furcas DSL project. It generates the necessary folder, packages, files and first
 * lines of code that help to quickly be able to create the DSL.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class FurcasWizard extends Wizard implements INewWizard {
    /**
     * The first page of the wizard.
     */
    protected LanguagePage page;

    /**
     * @return The first page of the wizard.
     */
    public LanguagePage getPage() {
        return page;
    }

    /**
     * The second page of the wizard.
     */
    protected SelectionPage page2;

    /**
     * @return The second page of the wizard.
     */
    public SelectionPage getPage2() {
        return page2;
    }

    /**
     * @return The FurcasWizard instance.
     */
    public FurcasWizard getFurcasWizard() {
        return this;
    }

    boolean hadError = false;

    /**
     * @return the hadError
     */
    public boolean isHadError() {
        return hadError;
    }

    /**
     * @param hadError
     *            the hadError to set
     */
    public void setHadError(boolean hadError) {
        this.hadError = hadError;
    }

    /**
     * Sets the Window title, calls the super constructor.
     */
    public FurcasWizard() {
        super();
        setNeedsProgressMonitor(true);
        setWindowTitle(Messages.FurcasWizard_1);
    }

    /**
     * User's workbench.
     */
    protected IWorkbench workbench;
    /**
     * Wizard's classLoader
     */
    private ClassLoader cL;

    /**
     * This method loads the image stored in the icons folder. It is displayed in the upper right corner of the wizard.
     * 
     * @return The image descriptor of the image. (The furcas logo)
     */
    protected ImageDescriptor getDefaultImageDescriptor() {
        cL = this.getClass().getClassLoader();
        ImageDescriptor iD = null;
        URL url = cL.getResource("icons/furcasdeath.gif"); //$NON-NLS-1$
        iD = ImageDescriptor.createFromURL(url);
        return iD;
    }

    /**
     * This method is called, when pressing the finish button in the wizard. It calls the doFinish method.
     * {@link #doFinish(ProjectInfo, IProgressMonitor) doFinish}
     * TODO
     */
    @Override
    public boolean performFinish() {
        final ProjectInfo pi = page.getProjectInfo();

        IRunnableWithProgress op = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                doFinish(pi, monitor);

                monitor.done();
            }
        };

        try {
            getContainer().run(true, false, op);
        } catch (InvocationTargetException e) {
            MessageDialog.openError(getShell(), "Error", //$NON-NLS-1$
                    Messages.FurcasWizard_3 + e.getMessage());
        } catch (InterruptedException e) {
            MessageDialog.openError(getShell(), "Error", //$NON-NLS-1$
                    Messages.FurcasWizard_5 + e.getMessage());
        }

        return true;

    }

    /**
     * This method actually does all the work, after the Finish button is pressed. First it creates a new instance of the {@link}
     * CreateProject class and calls its <code>run()</code> method. This leads to the creation of the Language Project with all
     * its generated files, packages, folders and code. Afterwards {@link}createMMProject() creates another project for the
     * MetaModel and doAdditional() creates the new .ecore file. loadmm() leads to loading an existing metamodel into the new one.
     * But those steps only happen if the user wants to create a fresh metamodel project. Afterwards the method
     * <code>generateSpecific()</code> generates all the MetaModel related files and coding into the Language Project.
     * 
     * @param pi
     *            The user input.
     * @param monitor
     *            The progress monitor.
     */
    public void doFinish(final ProjectInfo pi, IProgressMonitor monitor) {
        new UIJob(Messages.FurcasWizard_0) {
            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {

                structuredProcess(pi, monitor);

                return Status.OK_STATUS;
            }

        }.schedule();
    }

    /**
     * This method gets called when an error occured making sure that unneccessary projects in workspace get cleaned up.
     */
    public void deleteJunk(ProjectInfo pi, IProgressMonitor monitor) {
        if (!pi.isLoadMetamodel()) {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IProject metamodelProject = workspace.getRoot().getProject(pi.getProjectName() + ".metamodel"); //$NON-NLS-1$
            try {
                metamodelProject.delete(true, new SubProgressMonitor(monitor, 1));
            } catch (CoreException e) {
                // Nothing happens as there is no project to delete.
            }
        }
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IProject languageProject = workspace.getRoot().getProject(pi.getProjectName());
        try {
            languageProject.delete(true, new SubProgressMonitor(monitor, 1));
        } catch (CoreException e) {
            // Nothing happens as there is no project to delete.
        }

    }

    /**
     * This method is only called if the user chooses to create a new Metamodel Project. It uses the <code>create()</code> method
     * of {@link}CreateMMProject to generate the project. And it then opens the file in the editor.
     * 
     * @param pi
     *            The user input.
     * @throws CodeGenerationException
     * @throws InterruptedException
     * @throws InvocationTargetException
     */
    public void doAdditional(final ProjectInfo pi) throws CodeGenerationException, InvocationTargetException,
            InterruptedException {
        IWorkbenchPage wpage = null;

        // Do the work within an operation.
        //
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
            @Override
            protected void execute(IProgressMonitor progressMonitor) {

                try {
                    CreateMMProject.create(getFurcasWizard(), progressMonitor, pi);
                } catch (CodeGenerationException e) {
                    getFurcasWizard().setHadError(true);
                    MessageDialog.openError(getShell(), "Error", e.getMessage()); //$NON-NLS-1$
                }

            }
        };
        if (getContainer() != null) {
            getContainer().run(false, false, operation);

            // Select the new .ecore file.
            //
            final IFile modelFile = getModelFile();

            IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
            wpage = workbenchWindow.getActivePage();
            final IWorkbenchPart activePart = wpage.getActivePart();
            if (activePart instanceof ISetSelectionTarget) {
                final ISelection targetSelection = new StructuredSelection(modelFile);
                getShell().getDisplay().asyncExec(new Runnable() {
                    public void run() {
                        ((ISetSelectionTarget) activePart).selectReveal(targetSelection);
                    }
                });
            }

            // Open an editor on the file.
            //
            try {
                IEditorDescriptor defaultEditor = workbench.getEditorRegistry().getDefaultEditor(
                        modelFile.getFullPath().toString());
                wpage.openEditor(new FileEditorInput(modelFile),
                        defaultEditor == null ? "org.eclipse.emf.ecore.presentation.EcoreEditorID" : defaultEditor.getId()); //$NON-NLS-1$
            } catch (PartInitException exception) {
                MessageDialog.openError(workbenchWindow.getShell(),
                        EcoreEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage()); //$NON-NLS-1$
            }

        } else {
            // That should only run if called by a test
            //
            NullProgressMonitor monitor = new NullProgressMonitor();
            CreateMMProject.create(getFurcasWizard(), monitor, pi);
        }
    }

    /**
     * Adds the first two pages to the wizard (as they're always part of the wizard irrespective of the user input.
     */
    @Override
    public void addPages() {
        page = new LanguagePage();
        addPage(page);
        page2 = new SelectionPage(this, page.getProjectInfo());
        addPage(page2);

    }

    /**
     * Get the model file.
     */
    public IFile getModelFile() {
        Path path = new Path(page.getProjectInfo().getProjectName() + ".metamodel/model/" //$NON-NLS-1$
                + CreateProject.capitalizeFirstChar(page.getProjectInfo().getLanguageName()) + ".ecore"); //$NON-NLS-1$

        return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    }

    /**
     * This method provides the generation of the MetaModelspecific files and coding in the dsl project. Since these are the last
     * lines of code called by the wizard it also builds, refreshs and cleans the project for the purpose of generating all files
     * at once, as some generators don't see previously generated files if the project is not rebuild/refreshed/cleaned.
     * 
     * @param project
     *            The language project
     * @param pi
     *            The user input
     * @throws CodeGenerationException
     */
    protected void generateSpecific(IProject project, ProjectInfo pi, IProgressMonitor monitor) throws CodeGenerationException {
        if (project != null) {
            EcoreMetaProjectConf conf;
            if (!pi.isFromWorkspace()) {
                // instantiates the configuration take a look at EcoreMetaProjectConf for more details
                // uses the new PRI list in the ReferenceScope to load the referenced metamodel from registered packages
                //
                conf = new EcoreMetaProjectConf(project, "", pi.getNsURI()); //$NON-NLS-1$
            } else {
                // instantiates the configuration, take a look at EcoreMetaProjectConf for more details
                // uses the ResourceSet in the ReferenceScope to load the referenced metamodel in the workspace
                //
                conf = new EcoreMetaProjectConf(project, pi.getModelPath(), pi.getNsURI());
            }
            ;

            try {
                ProjectMetaRefConfFactory.configure(project, conf);
            } catch (CoreException e) {
                throw new CodeGenerationException(Messages.FurcasWizard_14, e.getCause());
            }

            // Builds, refreshs, cleans the project to make sure, that all files will be found and generated
            //
            monitor.subTask(Messages.FurcasWizard_15);
            try {
                project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
                IFolder folder = project.getFolder("generated").getFolder("generated"); //$NON-NLS-1$ //$NON-NLS-2$
                folder.refreshLocal(1, new NullProgressMonitor());
                project.build(IncrementalProjectBuilder.CLEAN_BUILD, monitor);
                project.build(IncrementalProjectBuilder.FULL_BUILD, monitor);

            } catch (CoreException e) {
                throw new CodeGenerationException(Messages.FurcasWizard_18, e.getCause());
            } 

        }
    }

    /**
     * Initializes this creation wizard using the passed workbench and object selection.
     * <p>
     * This method is called after the no argument constructor and before other methods are called.
     * </p>
     * <p>
     * Selection will always be empty in FurcasWizard and has no effect here.
     * </p>
     * 
     * @param workbench
     *            the current workbench
     * @param selection
     *            the current object selection -- no effect
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        setWindowTitle(EcoreEditorPlugin.INSTANCE.getString("_UI_Wizard_label")); //$NON-NLS-1$
        setDefaultPageImageDescriptor(getDefaultImageDescriptor());
    }


    public void structuredProcess(final ProjectInfo pi, IProgressMonitor monitor) {
        CreateProject cP = new CreateProject(pi, getShell(), getFurcasWizard());
        // All in one try block, add comments
        //
        try {
            cP.run(monitor);
        } catch (InvocationTargetException e) {
            hadError = true;
            MessageDialog.openError(getShell(), "Error", //$NON-NLS-1$
                    Messages.FurcasWizard_21 + e.getMessage());
        } catch (InterruptedException e) {
            hadError = true;
            MessageDialog.openError(getShell(), "Error", e.getMessage()); //$NON-NLS-1$
        }
        IProject project = cP.project;

        if (!pi.isLoadMetamodel() && !hadError) {
            try {
                doAdditional(pi);
            } catch (CodeGenerationException e) {
                hadError = true;
                MessageDialog.openError(getShell(), "Error", e.getMessage()); //$NON-NLS-1$
            } catch (InvocationTargetException e) {
                hadError = true;
                MessageDialog.openError(getShell(), "Error", //$NON-NLS-1$
                        Messages.FurcasWizard_25 + e.getMessage());
            } catch (InterruptedException e) {
                hadError = true;
                MessageDialog.openError(getShell(), "Error", e.getMessage()); //$NON-NLS-1$
            }
        }
        if (!hadError) {
            try {
                generateSpecific(project, pi, monitor);
            } catch (CodeGenerationException e) {
                hadError = true;
                MessageDialog.openError(getShell(), "Error", e.getMessage()); //$NON-NLS-1$
            }
        }
        if (hadError) {
            deleteJunk(pi, monitor);
        }
    }

}
