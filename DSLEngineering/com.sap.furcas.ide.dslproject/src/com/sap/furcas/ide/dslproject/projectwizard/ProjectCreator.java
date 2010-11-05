package com.sap.furcas.ide.dslproject.projectwizard;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.sap.furcas.ide.dslproject.builder.SyntaxGenerationNature;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;
import com.sap.furcas.ide.dslproject.conf.ProjectMetaRefConfFactory;
import com.sap.furcas.utils.projects.EclipseProjectHelper;

/**
 * 
 * Creates a new DSL engineering project in the workspace upon finishing 
 * the new wizard. 
 * A generic pattern is employed to create the project files as well as  the 
 * most important editor and parser files.
 * 
 * @author C5126086 Martin Kuester
 * @see {@link SourceCodeFactory} for the actual source code and project 
 * creation. 
 *
 */
public class ProjectCreator extends WorkspaceModifyOperation {

	protected static final String ORIGINAL_FILE_LOCATION_ROOT = "src";

	// constants
	private static final String[] PLUGIN_REFERENCES = { 
		"org.eclipse.core.runtime",
		"org.eclipse.core.resources", 
		"org.eclipse.jface.text",
		"org.eclipse.ui",
		"org.eclipse.ui.editors",
		"com.sap.ap.metamodel.core", 	// ngpm 
		"com.sap.tc.moin.libraries.api", // MOIN Support
		"com.sap.tc.moin.textual.runtime.moin",
		"com.sap.ide.cts.editor", // editor base classes
		"com.sap.ide.cts.parser", // incremental parser base classes
		"com.sap.mi.fwk",
		"com.sap.mi.fwk.ui",
		"com.sap.mi.textual.parsing",	// includes ModelInjector interface and ANTLR
		"com.sap.mi.textual.parsing.textblocks",
		"com.sap.tcsmeta.mm.eclipse",
		"com.sap.tc.moin.incubation.contentprovider"

	};

	private static final String[] EXTRA_CLASSPATH = { 
		"platform:/plugin/com.sap.mi.textual.parsing/lib/antlr-3.1.1.jar",
		"platform:/plugin/com.sap.mi.textual.parsing/lib/antlr-2.7.7.jar", 
		"platform:/plugin/com.sap.mi.textual.parsing/lib/stringtemplate.jar"
	};

	ProjectInfo pi;
	Shell shell;

	private final IProjectMetaRefConf conf;

	public ProjectCreator(ProjectInfo pi, IProjectMetaRefConf conf, Shell shell) {
		this.pi = pi;
		this.shell = shell;
		this.conf = conf;
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		monitor.beginTask("Creating project " + pi.getProjectName(), 2);

		IProject project = createProject(monitor);

		if (project != null) {
			ProjectMetaRefConfFactory.configure(project, conf);
		}

		//createEditorProject(monitor);

	}

	/**
	 * @param monitor
	 * @return 
	 */
	private IProject createProject(IProgressMonitor monitor) {

		Set<String> refs = new HashSet<String>();
		for (int i = 0; i < PLUGIN_REFERENCES.length; i++) {
			refs.add(PLUGIN_REFERENCES[i]);
		}

		List<String> srcfolders = new ArrayList<String>();
		srcfolders.add("src");
		srcfolders.add("generated");

		List<String> exportedPackages = new ArrayList<String>();
		exportedPackages.add(pi.getBasePackage() + ".editor");
		exportedPackages.add(pi.getBasePackage() + ".parser");
//		exportedPackages.add(pi.getBasePackage() + ".tree");

		List<String> nonSrcFolders = new ArrayList<String>();
		nonSrcFolders.add("resources");
		//nonSrcFolders.add("mappings");

		List<String> extraclasspath = new ArrayList<String>(Arrays.asList(EXTRA_CLASSPATH));

		IProject dslProject = EclipseProjectHelper.createPlugInProject(
				pi.getProjectName(), 
				srcfolders, 
				nonSrcFolders, 
				Collections.<IProject> emptyList(), 
				refs, 
				exportedPackages, 
				extraclasspath, 
				monitor, 
				this.shell,
				SyntaxGenerationNature.NATURE_ID);

		if (dslProject == null) {
			return null;
		}
		monitor.worked(1);

		// 
		IFolder sourceTargetRootFolder = dslProject.getFolder(ORIGINAL_FILE_LOCATION_ROOT);
		assert(sourceTargetRootFolder.exists());
		
		IFolder genRootFolder = dslProject.getFolder('/' + "generated");
		assert (genRootFolder.exists());

		// set up the "plugin.xml" and store in root directory
		EclipseProjectHelper.createFile("plugin.xml", 
				dslProject, 
				SourceCodeFactory.createPluginXML(pi), 
				monitor);

		// create package folder "generated" with contents
		IFolder genSrcFolder = null;
		try {
			genSrcFolder = createGeneratedFolder(genRootFolder, monitor, "");
		} catch (CoreException e) {
			System.out.println(e.getMessage());
		}

		// create package folders under "src"
		try {
			createSource(pi, sourceTargetRootFolder, dslProject, monitor);
		} catch (CoreException e) {
			System.out.println(e.getMessage());
		}
		
		// contents of the generate.properties file
		String props = SourceCodeFactory.createdPropertiesCode(pi);
		EclipseProjectHelper.createFile("generate.properties", sourceTargetRootFolder, props, monitor);

		
		// create a sample TCS file and store it in folder "generated"
		String templateString = SourceCodeFactory.createSampleTCS(pi);
		IFile grammar = EclipseProjectHelper.createFile(pi.getTCSFileName(), genSrcFolder, templateString ,
				monitor);

		monitor.setTaskName("Opening file for editing...");
		BasicNewResourceWizard.selectAndReveal(grammar, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		EclipseProjectHelper.openFileToEdit(this.shell, grammar);
		monitor.worked(1);

		return dslProject;
	}

	private static IFolder createSource(ProjectInfo pi, IFolder srcDir,
			IProject dslProject, IProgressMonitor monitor) throws CoreException {

		String basePath = "";
		String[] split = pi.getBasePackage().split("\\.");
		for (int i=0; i<split.length; i++) {
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

	private static IFolder createGeneratedFolder(IFolder srcDir,
			IProgressMonitor monitor, String basePath) throws CoreException {
		String treeFolderPath = basePath + "/generated";
		IFolder treeFolder = srcDir.getFolder(treeFolderPath);
		if (!treeFolder.exists()) {
			treeFolder.create(false, true, monitor);
		}
		return treeFolder;
	}
	
	private static IFolder createTreeFolder(IFolder srcDir,
			IProgressMonitor monitor, String basePath, ProjectInfo pi) throws CoreException {
		String treeFolderPath = basePath + "/tree";
		IFolder treeFolder = srcDir.getFolder(treeFolderPath);
		if (!treeFolder.exists()) {
			treeFolder.create(false, true, monitor);
		}
		return treeFolder;
	}

	private static IFolder createParserFolder(IFolder srcDir,
			IProgressMonitor monitor, String basePath, ProjectInfo pi) throws CoreException {
		String parserFolderPath = basePath + "/parser";
		IFolder parserFolder = srcDir.getFolder(parserFolderPath);
		if (!parserFolder.exists()) {
			parserFolder.create(false, true, monitor);
		}

		EclipseProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "ParserFactory.java", 
				parserFolder, 
				SourceCodeFactory.createParserFactory(pi), 
				monitor);
		
		return parserFolder;
	}

	private static IFolder createEditorFolder(IFolder srcDir,
			IProgressMonitor monitor, String basePath, ProjectInfo pi) throws CoreException {
		String editorFolderPath = basePath + "/editor";
		IFolder editorFolder = srcDir.getFolder(editorFolderPath);
		if (!editorFolder.exists()) {
			editorFolder.create(false, true, monitor);
		}
		
		EclipseProjectHelper.createFile("Activator.java", 
				editorFolder, 
				SourceCodeFactory.createActivator(pi), 
				monitor);
		EclipseProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "Editor.java", 
				editorFolder, 
				SourceCodeFactory.createEditorCode(pi), 
				monitor);
		EclipseProjectHelper.createFile(capitalizeFirstChar(pi.getLanguageName()) + "Mapper.java", 
				editorFolder, 
				SourceCodeFactory.createMapperCode(pi), 
				monitor);
		
		return editorFolder;
	}
	
	protected static String capitalizeFirstChar(String s) {
		return ("" + s.charAt(0)).toUpperCase() + s.substring(1);
	}

}