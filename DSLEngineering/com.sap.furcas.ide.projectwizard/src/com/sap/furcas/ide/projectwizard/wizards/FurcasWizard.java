package com.sap.furcas.ide.projectwizard.wizards;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
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
import com.sap.furcas.ide.projectwizard.util.CreateMMProject;
import com.sap.furcas.ide.projectwizard.util.CreateProject;
import com.sap.furcas.ide.projectwizard.util.ProjectInfo;

/*
 * This Wizard creates a pair of projects for the Furcas DSL project. It generates the necessary folder,
 * packages, files and first lines of code that help to quickly be able to create the DSL.
 */
public class FurcasWizard extends Wizard implements INewWizard {
    protected LanguagePage page;
    protected SelectionPage page2;

    public Wizard getWiz() {
        return this;
    }

    public FurcasWizard getFurcasWizard() {
        return this;
    }

    public FurcasWizard() {
        super();
        setNeedsProgressMonitor(true);
        setWindowTitle("Furcas DSL Engineering Project Creator");
    }

    /* The following variables are used for the creation of a fresh .ecore model file. */
    public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays.asList(EcoreEditorPlugin.INSTANCE
            .getString("_UI_EcoreEditorFilenameExtensions").split("\\s*,\\s*")));
    public static final String FORMATTED_FILE_EXTENSIONS = EcoreEditorPlugin.INSTANCE.getString(
            "_UI_EcoreEditorFilenameExtensions").replaceAll("\\s*,\\s*", ", ");
    protected EcorePackage ecorePackage = EcorePackage.eINSTANCE;
    protected EcoreFactory ecoreFactory = ecorePackage.getEcoreFactory();
    protected IStructuredSelection selection;
    protected IWorkbench workbench;
    protected List<String> initialObjectNames;
    private ClassLoader cL;

    /*
     * This method loads the image stored in the icons folder. It is displayed in the upper right corner of the wizard.
     */
    protected ImageDescriptor getDefaultImageDescriptor() {
        cL = this.getClass().getClassLoader();
        ImageDescriptor iD = null;
        URL url = cL.getResource("icons/furcasdeath.gif");
        iD = ImageDescriptor.createFromURL(url);
        return iD;
    }

    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.workbench = workbench;
        this.selection = selection;
        setWindowTitle(EcoreEditorPlugin.INSTANCE.getString("_UI_Wizard_label"));
        setDefaultPageImageDescriptor(getDefaultImageDescriptor());
    }

    /*
     * This method is called, when pressing the finish button in the wizard. It calls the doFinish method.
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

    /*
     * This method actually does all the work, after the Finish button is pressed. First it creates a new instance of the
     * CreateProject class and calls its run() method. This leads to the creation of the Language Project with all its generated
     * files, packages, folders and code. Afterwards createMMProject() creates another project for the MetaModel and
     * doAdditional() creates the new .ecore file. loadmm() leads to loading an existing Metamodel into the new one. After all the
     * method generateSpecific() generates all the MetaModel related files and coding into the Language Project.
     */
    void doFinish(final ProjectInfo pi, IProgressMonitor monitor) {
        new UIJob("creating FURCAS projects...") {
            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                try {
                    CreateProject cP = new CreateProject(pi, getShell());
                    cP.run(monitor);
                    IProject project = cP.iP;
                    if (!pi.isLoadMetamodel()) {
                        doAdditional(pi);
                    }
                    generateSpecific(project, pi);

                } catch (InvocationTargetException e) {
                } catch (InterruptedException e) {
                }

                return Status.OK_STATUS;
            }

        }.schedule();
    }

    public void doAdditional(final ProjectInfo pi) {
        IWorkbenchPage wpage = null;
        try {

            // Do the work within an operation.
            //
            WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
                @Override
                protected void execute(IProgressMonitor progressMonitor) {
                    try {
                        CreateMMProject.create(getFurcasWizard(), page, getShell());
                    } catch (Exception exception) {
                        EcoreEditorPlugin.INSTANCE.log(exception);
                    } finally {
                        progressMonitor.done();
                    }
                }
            };

            getContainer().run(false, false, operation);

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

            // Open an editor on the new file.
            //
            try {
                IEditorDescriptor defaultEditor = workbench.getEditorRegistry().getDefaultEditor(
                        modelFile.getFullPath().toString());
                wpage.openEditor(new FileEditorInput(modelFile),
                        defaultEditor == null ? "org.eclipse.emf.ecore.presentation.EcoreEditorID" : defaultEditor.getId());
            } catch (PartInitException exception) {
                MessageDialog.openError(workbenchWindow.getShell(),
                        EcoreEditorPlugin.INSTANCE.getString("_UI_OpenEditorError_label"), exception.getMessage());
            }

        } catch (Exception exception) {
            EcoreEditorPlugin.INSTANCE.log(exception);
        }
    }

    @Override
    public void addPages() {
        page = new LanguagePage(selection);
        addPage(page);
        page2 = new SelectionPage(selection, this, page.getProjectInfo());
        addPage(page2);

    }

    /**
     * Get the file. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public IFile getModelFile() {
        Path path = new Path(page.getProjectInfo().getProjectName() + ".metamodel/model/"
                + CreateProject.capitalizeFirstChar(page.getProjectInfo().getLanguageName()) + ".ecore");

        return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    }

    /*
     * This method provides the generation of the MetaModelspecific files and coding in the dsl project.
     */
    protected void generateSpecific(IProject project, ProjectInfo pi) {
        if (project != null) {
            EcoreMetaProjectConf conf;
            if (!pi.isFromWorkspace())
                conf = new EcoreMetaProjectConf(project, "", pi.getNsURI());
            else
                conf = new EcoreMetaProjectConf(project, pi.getModelPath(), pi.getNsURI());
            try {
                ProjectMetaRefConfFactory.configure(project, conf);
            } catch (CoreException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
