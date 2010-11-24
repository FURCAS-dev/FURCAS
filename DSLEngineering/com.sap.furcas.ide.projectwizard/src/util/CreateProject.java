package util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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



/* 
 * This class is called by the doFinish() method of the Wizard. It creates the Language Project and the necessary
 * files etc with the help of the classes SourceCodeFactory and WizardProjectHelper.
 * 
 * */
public class CreateProject extends WorkspaceModifyOperation {
    protected static final String ORIGINAL_FILE_LOCATION_ROOT = "src";

    private static final String[] EXTRA_CLASSPATH = {/*
                                                      * "platform:/plugin/com.sap.mi.textual.parsing/lib/antlr-3.1.1.jar",
                                                      * "platform:/plugin/com.sap.mi.textual.parsing/lib/antlr-2.7.7.jar",
                                                      * "platform:/plugin/com.sap.mi.textual.parsing/lib/stringtemplate.jar"
                                                      */
    };
    ProjectInfo pi;
    Shell shell;
    FurcasWizard wizard;
    public IProject iP;
    static SourceCodeFactory scf;

    public CreateProject(ProjectInfo pi, Shell shell) {
        this.pi = pi;
        this.shell = shell;
        
        scf = new SourceCodeFactory();

    }

    protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
        monitor.beginTask("Creating project " + pi.getProjectName(), 2);

        IProject project = createProject(monitor);
        iP = project;
    }

    private IProject createProject(IProgressMonitor monitor) {

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

        List<String> extraclasspath = new ArrayList<String>(Arrays.asList(EXTRA_CLASSPATH));

        IProject dslProject = WizardProjectHelper.createPlugInProject(pi, pi.getProjectName(), srcfolders, nonSrcFolders,
                Collections.<IProject> emptyList(), exportedPackages, extraclasspath, monitor, this.shell, null, false);

        if (dslProject == null) {
            return null;
        }
        monitor.worked(1);

        //
        IFolder sourceTargetRootFolder = dslProject.getFolder(ORIGINAL_FILE_LOCATION_ROOT);
        assert (sourceTargetRootFolder.exists());

        IFolder genRootFolder = dslProject.getFolder('/' + "generated");
        assert (genRootFolder.exists());

        // set up the "plugin.xml" and store in root directory
        WizardProjectHelper.createFile("plugin.xml", dslProject, scf.createPluginXML(pi), monitor);

        // create package folder "generated" with contents
        IFolder genSrcFolder = null;
        try {
            genSrcFolder = createGeneratedFolder(genRootFolder, monitor, "");
        } catch (CoreException e) {
            System.out.println("Fehlerquelle I");
        }

        // create package folders under "src"
        try {
            createSource(pi, sourceTargetRootFolder, dslProject, monitor);
        } catch (CoreException e) {
            System.out.println("Fehlerquelle II");
        }

        // contents of the generate.properties file
        String props = scf.createdPropertiesCode(pi);
        WizardProjectHelper.createFile("generate.properties", sourceTargetRootFolder, props, monitor);

        // create a sample TCS file and store it in folder "generated"
        String templateString = scf.createSampleTCS(pi);
        IFile grammar = WizardProjectHelper.createFile(pi.getTCSFileName(), genSrcFolder, templateString, monitor);

        monitor.setTaskName("Opening file for editing...");
        BasicNewResourceWizard.selectAndReveal(grammar, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
        monitor.worked(1);

        return dslProject;
    }

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

    private static IFolder createGeneratedFolder(IFolder srcDir, IProgressMonitor monitor, String basePath) throws CoreException {
        String treeFolderPath = basePath + "/generated";
        IFolder treeFolder = srcDir.getFolder(treeFolderPath);
        if (!treeFolder.exists()) {
            treeFolder.create(false, true, monitor);
        }
        return treeFolder;
    }

    private static IFolder createTreeFolder(IFolder srcDir, IProgressMonitor monitor, String basePath, ProjectInfo pi)
            throws CoreException {
        String treeFolderPath = basePath + "/tree";
        IFolder treeFolder = srcDir.getFolder(treeFolderPath);
        if (!treeFolder.exists()) {
            treeFolder.create(false, true, monitor);
        }
        return treeFolder;
    }

    private static IFolder createParserFolder(IFolder srcDir, IProgressMonitor monitor, String basePath, ProjectInfo pi)
            throws CoreException {
        String parserFolderPath = basePath + "/parser";
        IFolder parserFolder = srcDir.getFolder(parserFolderPath);
        if (!parserFolder.exists()) {
            parserFolder.create(false, true, monitor);
        }

        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "ParserFactory.java", parserFolder,
                scf.createParserFactory(pi), monitor);

        return parserFolder;
    }

    private static IFolder createEditorFolder(IFolder srcDir, IProgressMonitor monitor, String basePath, ProjectInfo pi)
            throws CoreException {
        String editorFolderPath = basePath + "/editor";
        IFolder editorFolder = srcDir.getFolder(editorFolderPath);
        if (!editorFolder.exists()) {
            editorFolder.create(false, true, monitor);
        }

        WizardProjectHelper.createFile("Activator.java", editorFolder, scf.createActivator(pi), monitor);
        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "Editor.java", editorFolder,
                scf.createEditorCode(pi), monitor);
        WizardProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "Mapper.java", editorFolder,
                scf.createMapperCode(pi), monitor);

        return editorFolder;
    }

    public static String capitalizeFirstChar(String s) {
        return ("" + s.charAt(0)).toUpperCase() + s.substring(1);
    }

}
