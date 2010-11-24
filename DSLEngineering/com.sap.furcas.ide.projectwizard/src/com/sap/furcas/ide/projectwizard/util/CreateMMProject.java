package com.sap.furcas.ide.projectwizard.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
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
import com.sap.furcas.ide.projectwizard.wizards.LanguagePage;



public class CreateMMProject {
    protected static LanguagePage lpage;
    protected static EcorePackage ecorePackage = EcorePackage.eINSTANCE;
    protected static EcoreFactory ecoreFactory = ecorePackage.getEcoreFactory();
    protected static EPackage eP;
    protected static IFile file;
    protected static Shell shell;
    protected static IProgressMonitor progressMonitor;

    public static void create(FurcasWizard wizard, LanguagePage page, Shell sh) {
        lpage = page;
        progressMonitor = new NullProgressMonitor();
        String projectName = page.getProjectInfo().getProjectName() + ".metamodel";
        List<String> srcFolders = new ArrayList<String>();
        srcFolders.add("src");
        List<String> nonSrcFolders = new ArrayList<String>();
        nonSrcFolders.add("model");
        shell = sh;

        // Create the project for the metamodel
        WizardProjectHelper.createPlugInProject(lpage.getProjectInfo(), projectName, srcFolders, nonSrcFolders, Collections.<IProject> emptyList(), null,
                null, progressMonitor, shell, null, true);

        createNewModel();

    }


    protected static EObject createInitialModel() {
        EClass eClass = (EClass) ecorePackage.getEClassifier("EPackage");
        EObject rootObject = ecoreFactory.create(eClass);
        if (rootObject instanceof ENamedElement) {
            ((ENamedElement) rootObject).setName(lpage.getProjectInfo().getLanguageName());
        }
        return rootObject;
    }

    protected static void createNewModel() {
        // Create a resource set
        //
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());

        // Get the URI of the model file.
        //
        String mmprojectpath = lpage.getProjectInfo().getProjectName() + ".metamodel/model/"
                + lpage.getProjectInfo().getLanguageName() + ".ecore";
        URI fileURI = URI.createPlatformResourceURI(mmprojectpath, true);

        // Create a resource for this file. Don't specify a content type, as it could be Ecore or EMOF.
        //
        Resource resource = resourceSet.createResource(fileURI);

        // Add the initial model object to the contents.
        //
        EObject rootObject = createInitialModel();
        if (rootObject != null) {
            if (rootObject instanceof EPackage) {
                eP = (EPackage) rootObject;
                eP.setNsPrefix(lpage.getProjectInfo().getLanguageName());
                eP.setNsURI(lpage.getProjectInfo().getNsURI());
                EClass eC = ecoreFactory.createEClass();
                eC.setName(lpage.getProjectInfo().getClassName());
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
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IProject project = workspace.getRoot().getProject(lpage.getProjectInfo().getProjectName() + ".metamodel");
        try {
            file = WizardProjectHelper.createGenmodel(progressMonitor, project, lpage.getProjectInfo());
        } catch (CoreException e) {
            e.printStackTrace();
        }
        URI newURI = URI.createPlatformResourceURI(file.getProject().getName() + "/" + file.getProjectRelativePath().toString(),
                true);
        genModelGen(newURI);
    }

    @SuppressWarnings("deprecation")
    protected static void genModelGen(URI uri) {
        List<URI> uris = new ArrayList<URI>();
        uris.add(uri);
        List<GenModel> gms = GeneratorUIUtil.loadGenModels(progressMonitor, uris, shell);
        if (gms.get(0).canGenerate()) {
            gms.get(0).generate(progressMonitor);
        }
    }

}
