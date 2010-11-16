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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
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

/*
 * This Wizard creates a pair of projects for the Furcas DSL project. It generates the necessary folder,
 * packages, files and first lines of code that help to quickly be able to create the DSL.
 */
public class FurcasWizard extends Wizard implements INewWizard {
    protected FurcasWizardLanguagePage page;
    protected FurcasWizardMMSelectionPage page2;
    public boolean createmm;
    public boolean lpe;

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
        lpe = false;
        createmm = false;
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


    protected Collection<String> getInitialObjectNames() {
        if (initialObjectNames == null) {
            initialObjectNames = new ArrayList<String>();
            for (EClassifier eClassifier : ecorePackage.getEClassifiers()) {
                if (eClassifier instanceof EClass) {
                    EClass eClass = (EClass) eClassifier;
                    if (!eClass.isAbstract()) {
                        initialObjectNames.add(eClass.getName());
                    }
                }
            }
            Collections.sort(initialObjectNames, CommonPlugin.INSTANCE.getComparator());
        }
        return initialObjectNames;
    }

    protected EObject createInitialModel() {
        EClass eClass = (EClass) ecorePackage.getEClassifier("EPackage");
        EObject rootObject = ecoreFactory.create(eClass);
        if (rootObject instanceof ENamedElement) {
            ((ENamedElement) rootObject).setName("");
        }
        return rootObject;
    }

    /* This method is called, when pressing the finish button in the wizard. It calls the doFinish method.
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
     * This method actually does all the work, after the Finish button is pressed. First it creates a new
     * instance of the CreateProject class and calls its run() method. This leads to the creation of the 
     * Language Project with all its generated files, packages, folders and code.
     * Afterwards createMMProject() creates another project for the MetaModel and doAdditional() creates the
     * new .ecore file. loadmm() leads to loading an existing Metamodel into the new one.
     * After all the method generateSpecific() generates all the MetaModel related files and coding into
     * the Language Project.
     * */
    void doFinish(final ProjectInfo pi, IProgressMonitor monitor) {
        new UIJob("creating FURCAS projects...") {
            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {

                try {
                    new CreateProject(pi, getShell()).run(monitor);
                    if (createmm || lpe) {
                        createMMProject(monitor);
                        doAdditional();//TODO see method below
                    }
                    if (lpe) {
                        loadmm();//TODO see method below
                    }
                    generateSpecific();

                } catch (InvocationTargetException e) {
                } catch (InterruptedException e) {
                }

                return Status.OK_STATUS;
            }

        }.schedule();
    }

    public void doAdditional() {
        IWorkbenchPage wpage = null;
        try {

            // Do the work within an operation.
            //
            WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
                @Override
                protected void execute(IProgressMonitor progressMonitor) {
                    try {
                        // Create a resource set
                        //
                        ResourceSet resourceSet = new ResourceSetImpl();
                        resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());

                        // Get the URI of the model file.
                        //
                        String mmprojectpath = page.getProjectInfo().getProjectName() + ".metamodel/"
                                + page.getProjectInfo().getLanguageName() + ".ecore";
                        URI fileURI = URI.createPlatformResourceURI(mmprojectpath, true);

                        // Create a resource for this file. Don't specify a content type, as it could be Ecore or EMOF.
                        //
                        Resource resource = resourceSet.createResource(fileURI);

                        // Add the initial model object to the contents.
                        //
                        EObject rootObject = createInitialModel();
                        if (rootObject != null) {
                            resource.getContents().add(rootObject);
                        }

                        // Save the contents of the resource to the file system.
                        //
                        Map<Object, Object> options = new HashMap<Object, Object>();
                        options.put(XMLResource.OPTION_ENCODING, "UTF-8");
                        resource.save(options);
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
        createmm = false;
        page = new FurcasWizardLanguagePage(selection);
        addPage(page);
        page2 = new FurcasWizardMMSelectionPage(selection, this);
        addPage(page2);

    }

    /**
     * Get the file. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public IFile getModelFile() {
        Path path = new Path(page.getProjectInfo().getProjectName() + ".metamodel/" + page.getProjectInfo().getLanguageName()
                + ".ecore");

        return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    }

    public void addMMP() {
        createmm = true;
    }

    public void enableLoadPage() {
        lpe = true;
    }

    /*
     * This method provides the generation of the MetaModelspecific files and coding in the dsl project.
     */
    protected void generateSpecific() {
        // TODO see above
    }

    /*
     * This method opens the load ressources dialog.
     */

    protected void loadmm() {
//        ExtendedLoadResourceAction lR = new ExtendedLoadResourceAction();
//        lR.run();
    }

    public void createMMProject(IProgressMonitor monitor) {
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
            e.printStackTrace();
        }

    }

}
