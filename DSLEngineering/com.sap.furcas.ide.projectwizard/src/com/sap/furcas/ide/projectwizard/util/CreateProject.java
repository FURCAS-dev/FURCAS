package com.sap.furcas.ide.projectwizard.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * This class is called by the doFinish() method of the Wizard. It creates the Language Project and the necessary files etc with
 * the help of the classes {@link SourceCodeFactory} and {@link WizardProjectHelper}.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class CreateProject {

    private static final String ORIGINAL_FILE_LOCATION_ROOT = "src";
    
    private final ProjectInfo projectInfo;
    private final SourceCodeFactory codeFactory;

    /**
     * Give the user input to the instance.
     */
    public CreateProject(ProjectInfo pi) {
        this.projectInfo = pi;
        this.codeFactory = new SourceCodeFactory();
    }

    /**
     * This class does all the needed steps to set the variables for the {@link WizardProjectHelper} and the calling of it's
     * methods. Afterwords all other furcas specific files are built.
     * 
     * @param monitor
     *            The progress monitor for the process of file creation
     * @return The generated project.
     * @throws CodeGenerationException
     */
    public IProject createProject(IProgressMonitor monitor) throws CodeGenerationException {

        List<String> srcfolders = new ArrayList<String>();
        srcfolders.add("src");
        srcfolders.add("generated");

        List<String> exportedPackages = new ArrayList<String>();
        exportedPackages.add(projectInfo.getProjectName() + ".editor");
        exportedPackages.add(projectInfo.getProjectName() + ".parser");

        List<String> nonSrcFolders = new ArrayList<String>();
        nonSrcFolders.add("mapping");
        nonSrcFolders.add("syntaxdefinition");

        IProject dslProject = WizardProjectHelper.createPlugInProject(projectInfo, srcfolders, nonSrcFolders, exportedPackages, monitor, false);
        if (dslProject == null) {
            return null;
        }
        monitor.worked(1);
        WizardProjectHelper.createFile("plugin.xml", dslProject, codeFactory.createPluginXML(projectInfo), monitor);
        
        IFolder sourceTargetRootFolder = dslProject.getFolder(ORIGINAL_FILE_LOCATION_ROOT);
        assert (sourceTargetRootFolder.exists());
        createSourceFolder(projectInfo, sourceTargetRootFolder, monitor);

        IFolder genRootFolder = dslProject.getFolder('/' + "generated");
        assert (genRootFolder.exists());

        createGeneratedFolder(genRootFolder, monitor, "");

        IFolder syntaxDefFolder = dslProject.getFolder("syntaxdefinition");
        assert (syntaxDefFolder.exists());
        
        String templateString = codeFactory.createSampleTCS(projectInfo);
        IFile grammar = WizardProjectHelper.createFile(projectInfo.getTCSFileName(), syntaxDefFolder, templateString, monitor);

        // Opening the file for editing. Note that the wizard later on opens the .ecore file if the user
        // chose to build a new metamodel project, so you won't see the effect of this coding in that case.
        //
        monitor.setTaskName("Opening file for editing...");
        
        // FIXME: Disabled because it prevents the this class from being used in headless mode and subsequently
        //        from working in our hudson infrastructure.
        //BasicNewResourceWizard.selectAndReveal(grammar, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
        monitor.worked(1);
        
        return dslProject;
    }

    private IFolder createSourceFolder(ProjectInfo pi, IFolder srcDir, IProgressMonitor monitor) throws CodeGenerationException {
        String basePath = "";
        String[] split = pi.getProjectName().split("\\.");
        for (int i = 0; i < split.length; i++) {
            basePath += '/' + split[i];
            IFolder f = srcDir.getFolder(basePath);
            if (!f.exists()) {
                try {
                    f.create(false, true, monitor);
                } catch (CoreException e) {
                    throw new CodeGenerationException("Failed to create source: " + srcDir.getName(), e.getCause());
                }
            }
        }
        createEditorFolder(srcDir, monitor, basePath, pi);
        createParserFolder(srcDir, monitor, basePath, pi);
        return srcDir;
    }

    private IFolder createGeneratedFolder(IFolder srcDir, IProgressMonitor monitor, String basePath)
            throws CodeGenerationException {
        IFolder generatedFolder = srcDir.getFolder(basePath + "/generated");
        if (!generatedFolder.exists()) {
            try {
                generatedFolder.create(false, true, monitor);
            } catch (CoreException e) {
                throw new CodeGenerationException("Failed to create folder '/generated'", e.getCause());
            }
        }
        return generatedFolder;
    }

    private IFolder createParserFolder(IFolder srcDir, IProgressMonitor monitor, String basePath, ProjectInfo pi)
            throws CodeGenerationException {
        IFolder parserFolder = srcDir.getFolder(basePath + "/parser");
        if (!parserFolder.exists()) {
            try {
                parserFolder.create(false, true, monitor);
            } catch (CoreException e) {
                throw new CodeGenerationException("Failed to create folder '/parser'", e.getCause());
            }
        }
        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "ParserFactory.java", parserFolder,
                codeFactory.createParserFactory(pi), monitor);

        return parserFolder;
    }

    private IFolder createEditorFolder(IFolder srcDir, IProgressMonitor monitor, String basePath, ProjectInfo pi)
            throws CodeGenerationException {
        String editorFolderPath = basePath + "/editor";
        IFolder editorFolder = srcDir.getFolder(editorFolderPath);
        if (!editorFolder.exists()) {
            try {
                editorFolder.create(false, true, monitor);
            } catch (CoreException e) {
                throw new CodeGenerationException("Failed to create folder '/editor'", e.getCause());
            }
        }
        WizardProjectHelper.createFile("Activator.java", editorFolder, codeFactory.createActivator(pi), monitor);
        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "Editor.java", editorFolder,
                codeFactory.createEditorCode(pi), monitor);
        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "TokenColorer.java", editorFolder,
                codeFactory.createColorerCode(pi), monitor);
        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "ParseController.java", editorFolder,
                codeFactory.crateParseController(pi), monitor);
        return editorFolder;
    }

    /**
     * Makes the first char of a string an upper case letter.
     * 
     * @param s
     *            The string where the first letter will be set to upper case.
     * @return The string with an upper case letter in first place.
     */
    public static String capitalizeFirstChar(String s) {
        return ("" + s.charAt(0)).toUpperCase() + s.substring(1);
    }

}
