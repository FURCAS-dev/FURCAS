package com.sap.furcas.ide.projectwizard.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.sap.furcas.ide.projectwizard.wizards.FurcasWizard;

/**
 * This class is called by the doFinish() method of the Wizard. It creates the Language Project and the necessary files etc with
 * the help of the classes {@link}SourceCodeFactory and {@link}WizardProjectHelper.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class CreateProject extends WorkspaceModifyOperation {
    /**
     * The source folder of the new project.
     */
    protected static final String ORIGINAL_FILE_LOCATION_ROOT = "src";
    /**
     * Used to access the user input.
     */
    ProjectInfo pi;
    /**
     * Represents the wizards window.
     */
    Shell shell;
    /**
     * Used to access methods or variables of the wizard.
     */
    FurcasWizard wizard;
    /**
     * Reference to the generated project.
     */
    public IProject project;
    /**
     * Instance of the {@link}SourceCodeFactory used to built files from text templates.
     */
    static SourceCodeFactory codeFactory;

    /**
     * Give the user input to the instance.
     * 
     * @param pi
     *            The user input.
     * @param shell
     *            The window containing the wizard.
     */
    public CreateProject(ProjectInfo pi, Shell shell) {
        this.pi = pi;
        this.shell = shell;

        codeFactory = new SourceCodeFactory();

    }

    /**
     * Starts the process of project creation.
     */
    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
        monitor.beginTask("Creating project " + pi.getProjectName(), 2);

        IProject project;
        try {
            project = createProject(monitor);
        } catch (CodeGenerationException e) {
            // TODO Auto-generated catch block
            throw new InterruptedException(e.getMessage());
        }
        this.project = project;
    }

    /**
     * This class does all the needed steps to set the variables for the {@link}WizardProjectHelper and the calling of it's
     * methods. Afterwords all other furcas specific files are built.
     * 
     * @param monitor
     *            The progress monitor for the process of file creation
     * @return The generated project.
     * @throws CodeGenerationException
     */
    private IProject createProject(IProgressMonitor monitor) throws CodeGenerationException {

        List<String> srcfolders = new ArrayList<String>();
        srcfolders.add("src");
        srcfolders.add("generated");

        List<String> exportedPackages = new ArrayList<String>();
        exportedPackages.add(pi.getProjectName() + ".editor");
        exportedPackages.add(pi.getProjectName() + ".parser");
        // exportedPackages.add(pi.getBasePackage() + ".tree");

        List<String> nonSrcFolders = new ArrayList<String>();
        nonSrcFolders.add("resources");
        nonSrcFolders.add("mappings");

        IProject dslProject = WizardProjectHelper.createPlugInProject(pi, srcfolders, nonSrcFolders, exportedPackages, monitor,
                this.shell, false);

        if (dslProject == null) {
            return null;
        }
        monitor.worked(1);

        IFolder sourceTargetRootFolder = dslProject.getFolder(ORIGINAL_FILE_LOCATION_ROOT);
        assert (sourceTargetRootFolder.exists());

        IFolder genRootFolder = dslProject.getFolder('/' + "generated");
        assert (genRootFolder.exists());

        WizardProjectHelper.createFile("plugin.xml", dslProject, codeFactory.createPluginXML(pi), monitor);

        IFolder genSrcFolder = null;
        try {
            genSrcFolder = createGeneratedFolder(genRootFolder, monitor, "");
        } catch (CoreException e) {
            throw new CodeGenerationException("Failed to generate folder '/generated'", (e.getCause()));
        }

        try {
            createSource(pi, sourceTargetRootFolder, dslProject, monitor);
        } catch (CoreException e) {
            throw new CodeGenerationException("Failed to generate source folder '/src'");
        }

        String props = codeFactory.createdPropertiesCode(pi);
        WizardProjectHelper.createFile("generate.properties", sourceTargetRootFolder, props, monitor);

        String templateString = codeFactory.createSampleTCS(pi);
        IFile grammar = WizardProjectHelper.createFile(pi.getTCSFileName(), genSrcFolder, templateString, monitor);

        // Opening the file for editing. Note that the wizard later on opens the .ecore file if the user
        // chose to build a new metamodel project, so you won't see the effect of this coding in that case.
        //
        monitor.setTaskName("Opening file for editing...");
        BasicNewResourceWizard.selectAndReveal(grammar, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
        monitor.worked(1);

        return dslProject;
    }

    /**
     * Generates the source folder.
     * 
     * @param pi
     *            The user input.
     * @param srcDir
     *            The folder where the source package is to be created.
     * @param dslProject
     *            The project where it's created.
     * @param monitor
     *            The progressmonitor for the process of creation.
     * @return The source Folder.
     * @throws CoreException
     */
    private static IFolder createSource(ProjectInfo pi, IFolder srcDir, IProject dslProject, IProgressMonitor monitor)
            throws CoreException {

        String basePath = "";
        String[] split = pi.getProjectName().split("\\.");
        for (int i = 0; i < split.length; i++) {
            basePath += '/' + split[i];
            IFolder f = srcDir.getFolder(basePath);
            if (!f.exists()) {
                f.create(false, true, monitor);
            }
        }

        createEditorFolder(srcDir, monitor, basePath, pi);
        createParserFolder(srcDir, monitor, basePath, pi);
        createTreeFolder(srcDir, monitor, basePath, pi);

        return srcDir;
    }

    /**
     * Generates the "generated" folder.
     * 
     * @param srcDir
     *            The folder in which to look for the generated folder.
     * @param monitor
     *            The progress monitor for generating the folder.
     * @param basePath
     *            The basePath of the project.
     * @return The generated folder.
     * @throws CoreException
     */
    private static IFolder createGeneratedFolder(IFolder srcDir, IProgressMonitor monitor, String basePath) throws CoreException {
        String generatedFolderPath = basePath + "/generated";
        IFolder generatedFolder = srcDir.getFolder(generatedFolderPath);
        if (!generatedFolder.exists()) {
            generatedFolder.create(false, true, monitor);
        }
        return generatedFolder;
    }

    /**
     * Generates the tree folder
     * 
     * @param srcDir
     *            Where to look for the folder.
     * @param monitor
     *            The progress monitor.
     * @param basePath
     *            The project's basepath
     * @param pi
     *            The user input
     * @return The Tree Folder.
     * @throws CoreException
     */
    private static IFolder createTreeFolder(IFolder srcDir, IProgressMonitor monitor, String basePath, ProjectInfo pi)
            throws CoreException {
        String treeFolderPath = basePath + "/tree";
        IFolder treeFolder = srcDir.getFolder(treeFolderPath);
        if (!treeFolder.exists()) {
            treeFolder.create(false, true, monitor);
        }
        return treeFolder;
    }

    /**
     * Generates the Parserfolder and the ParserFactory.java file
     * 
     * @param srcDir
     *            Where to look for the folder.
     * @param monitor
     *            The progress monitor.
     * @param basePath
     *            The project's basepath
     * @param pi
     *            The user input
     * @return The Parser Folder.
     * @throws CoreException
     */
    private static IFolder createParserFolder(IFolder srcDir, IProgressMonitor monitor, String basePath, ProjectInfo pi)
            throws CoreException {
        String parserFolderPath = basePath + "/parser";
        IFolder parserFolder = srcDir.getFolder(parserFolderPath);
        if (!parserFolder.exists()) {
            parserFolder.create(false, true, monitor);
        }

        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "ParserFactory.java", parserFolder,
                codeFactory.createParserFactory(pi), monitor);

        return parserFolder;
    }

    /**
     * Generates the Parserfolder and the Activator.java, Editor.java, Mapper.java files
     * 
     * @param srcDir
     *            Where to look for the folder.
     * @param monitor
     *            The progress monitor.
     * @param basePath
     *            The project's basepath
     * @param pi
     *            The user input
     * @return The Editor folder.
     * @throws CoreException
     */
    private static IFolder createEditorFolder(IFolder srcDir, IProgressMonitor monitor, String basePath, ProjectInfo pi)
            throws CoreException {
        String editorFolderPath = basePath + "/editor";
        IFolder editorFolder = srcDir.getFolder(editorFolderPath);
        if (!editorFolder.exists()) {
            editorFolder.create(false, true, monitor);
        }

        WizardProjectHelper.createFile("Activator.java", editorFolder, codeFactory.createActivator(pi), monitor);
        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "Editor.java", editorFolder,
                codeFactory.createEditorCode(pi), monitor);
        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "Mapper.java", editorFolder,
                codeFactory.createMapperCode(pi), monitor);

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
