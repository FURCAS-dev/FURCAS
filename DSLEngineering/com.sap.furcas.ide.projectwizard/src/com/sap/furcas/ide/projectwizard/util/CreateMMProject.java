package com.sap.furcas.ide.projectwizard.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.presentation.GeneratorUIUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.swt.widgets.Shell;

import com.sap.furcas.ide.projectwizard.wizards.FurcasWizard;

/**
 * This class is able to generate a java project with a fresh .ecore metamodel. The metamodel already contains a class. The name
 * of this class is chosen by the user of the wizard. It also creates a .genmodel file for the metamodel and generates the model
 * code for it. So in the end there should be a complete metamodel project with successfully building java classes. This class is
 * only called when the user choosen to connect his language project to a new metamodel!
 * <p>
 * The class gets help from the class {@link WizardProjectHelper}, which generates the fundamental parts of the project.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class CreateMMProject {
    /**
     * Is used to get user input, shell etc.
     */
    protected static FurcasWizard wizard;
    /**
     * The singleton instance of the EcorePackage. It's used in the process of creating a new EPackage.
     */
    protected static EcorePackage ecorePackage = EcorePackage.eINSTANCE;
    /**
     * The EcoreFactory of the singleton instance of the EcorePackage.
     */
    protected static EcoreFactory ecoreFactory = ecorePackage.getEcoreFactory();
    /**
     * This shell represents the wizard window.
     */
    protected static Shell shell;
    /**
     * The progressmonitor used for all the different creation processes in this class.
     */
    protected static IProgressMonitor progressMonitor;

    /**
     * This class is called in the <code>doAdditional()</code> method of the {@link}FurcasWizard to start the generation of the
     * metamodel project.
     * 
     * @param wiz
     *            See global variable <code>wizard</code> for information
     */
    public static void create(FurcasWizard wiz, IProgressMonitor monitor) {
        // Set all the important variables for generating the Project
        //
        wizard = wiz;
        progressMonitor = monitor;
        ProjectInfo pi = wizard.getPage().getProjectInfo();
        List<String> srcFolders = new ArrayList<String>();
        srcFolders.add("src");
        List<String> nonSrcFolders = new ArrayList<String>();
        nonSrcFolders.add("model");
        shell = wizard.getShell();

        // Create the project for the metamodel
        //
        WizardProjectHelper.createPlugInProject(pi, srcFolders, nonSrcFolders, null, progressMonitor, shell, true);

        // Create the ecore file
        //
        createNewModel();

    }

    /**
     * Creates the metamodels .ecore and .genmodel files. It also creates the first class in the metamodel.
     */
    protected static void createNewModel() {
        ProjectInfo pi = wizard.getPage().getProjectInfo();
        // Create a resource set
        //
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());

        // Get the URI of the model file.
        //
        String mmprojectpath = pi.getProjectName() + ".metamodel/model/"
                + CreateProject.capitalizeFirstChar(pi.getLanguageName()) + ".ecore";
        URI fileURI = URI.createPlatformResourceURI(mmprojectpath, true);

        // Create a resource for this file.
        //
        Resource resource = resourceSet.createResource(fileURI);

        // Add the initial model object to the contents.
        // And create the first class with the user chosen name.
        //
        EObject rootObject = createInitialModel();
        if (rootObject != null) {
            if (rootObject instanceof EPackage) {
                EPackage eP;
                eP = (EPackage) rootObject;
                eP.setNsPrefix(pi.getLanguageName());
                eP.setNsURI(pi.getNsURI());
                EClass eC = ecoreFactory.createEClass();
                eC.setName(pi.getClassName());
                eP.getEClassifiers().add(eC);
                resource.getContents().add(eP);
            } else
                resource.getContents().add(rootObject);
        }

        // Save the contents of the resource to the file system.
        //
        Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_ENCODING, "UTF-8");
        try {
            resource.save(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create the .genmodel file
        //
        IFile file = null;
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IProject project = workspace.getRoot().getProject(pi.getProjectName() + ".metamodel");
        try {
            file = WizardProjectHelper.createGenmodel(progressMonitor, project, pi);
        } catch (CoreException e) {
            e.printStackTrace();
        }
        URI newURI = URI.createPlatformResourceURI(file.getProject().getName() + "/" + file.getProjectRelativePath().toString(),
                true);
        // Generate the model code. (e.g. the java classes and the plugin.xml)
        //
        genModelGen(newURI);
    }

    /**
     * Creates the initial model.
     * 
     * @return The model as a EObject.
     */
    protected static EObject createInitialModel() {
        EClass eClass = (EClass) ecorePackage.getEClassifier("EPackage");
        EObject rootObject = ecoreFactory.create(eClass);
        if (rootObject instanceof ENamedElement) {
            ((ENamedElement) rootObject).setName(CreateProject.capitalizeFirstChar(wizard.getPage().getProjectInfo()
                    .getLanguageName()));
        }
        return rootObject;
    }

    /**
     * Generates the model code for the model. As one would be clicking Generate->Generate Model code in the UI, when .genmodel is
     * loaded in workspace.
     * 
     * @param uri
     *            nsURI of the model.
     */
    @SuppressWarnings("deprecation")
    protected static void genModelGen(URI uri) {
        // Method can easily be converted to a method that generates modelcode for several models.
        //
        List<URI> uris = new ArrayList<URI>();
        uris.add(uri);
        List<GenModel> gms = GeneratorUIUtil.loadGenModels(progressMonitor, uris, shell);
        if (gms.get(0).canGenerate()) {
            // The actual process of generating.
            //
            gms.get(0).generate(progressMonitor);
        }
    }

}
