package com.sap.furcas.utils.projects;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.sap.furcas.utils.Activator;


public class EclipseProjectHelper {

    public static IProject createPlugInProject(final String projectName, final List<String> srcFolders,
	    final List<String> nonSrcFolders, final List<IProject> referencedProjects, final Set<String> requiredBundles,
	    final List<String> exportedPackages, final List<String> extraClasspathEntries,
	    final IProgressMonitor progressMonitor, final Shell theShell, String nature) {
	IProject project = null;
	try {
	    progressMonitor.beginTask("", 10);
	    progressMonitor.subTask("Creating project " + projectName);
	    IWorkspace workspace = ResourcesPlugin.getWorkspace();
	    project = workspace.getRoot().getProject(projectName);

	    // Clean up any old project information.
	    if (project.exists()) {
		final boolean[] result = new boolean[1];
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
		    @Override
		    public void run() {
			result[0] = MessageDialog.openQuestion(theShell, "Do you want to overwrite the project " + projectName,
				"Note that everything inside the project '" + projectName
					+ "' will be deleted if you confirm this dialog.");
		    }
		});
		if (result[0]) {
		    project.delete(true, true, new SubProgressMonitor(progressMonitor, 1));
		} else {
		    return null;
		}
	    }

	    IJavaProject javaProject = JavaCore.create(project);
	    IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
	    projectDescription.setLocation(null);
	    project.create(projectDescription, new SubProgressMonitor(progressMonitor, 1));
	    List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
	    if (referencedProjects.size() != 0) {
		projectDescription.setReferencedProjects(referencedProjects.toArray(new IProject[referencedProjects.size()]));
		for (IProject referencedProject : referencedProjects) {
		    IClasspathEntry referencedProjectClasspathEntry = JavaCore.newProjectEntry(referencedProject.getFullPath());
		    classpathEntries.add(referencedProjectClasspathEntry);
		}
	    }
	    
	    projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature",
		    nature}); // XtendXpandNature.NATURE_ID });

	    ICommand java = projectDescription.newCommand();
	    java.setBuilderName(JavaCore.BUILDER_ID);

	    ICommand manifest = projectDescription.newCommand();
	    manifest.setBuilderName("org.eclipse.pde.ManifestBuilder");

	    ICommand schema = projectDescription.newCommand();
	    schema.setBuilderName("org.eclipse.pde.SchemaBuilder");

	    // ICommand oaw = projectDescription.newCommand();
	    // oaw.setBuilderName(XtendXpandBuilder.getBUILDER_ID());

	    projectDescription.setBuildSpec(new ICommand[] { java, manifest, schema }); // ,
											// oaw
											// });

	    project.open(new SubProgressMonitor(progressMonitor, 1));
	    project.setDescription(projectDescription, new SubProgressMonitor(progressMonitor, 1));

	    Collections.reverse(srcFolders);
	    for (String src : srcFolders) {
		IFolder srcContainer = project.getFolder(src);
		if (!srcContainer.exists()) {
		    srcContainer.create(false, true, new SubProgressMonitor(progressMonitor, 1));
		}
		IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(srcContainer.getFullPath());
		classpathEntries.add(0, srcClasspathEntry);
	    }

	    if (nonSrcFolders != null) {
		for (String src : nonSrcFolders) {
		    IFolder srcContainer = project.getFolder(src);
		    if (!srcContainer.exists()) {
			srcContainer.create(false, true, new SubProgressMonitor(progressMonitor, 1));
		    }
		}
	    }

	    classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER")));
	    classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));

	    javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
		    new SubProgressMonitor(progressMonitor, 1));

	    javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), new SubProgressMonitor(progressMonitor, 1));
	    createManifest(projectName, requiredBundles, exportedPackages, progressMonitor, project);
	    createBuildProps(progressMonitor, project, srcFolders, extraClasspathEntries);
	} catch (Exception exception) {
	    Activator.logger.logError("Failed to create plug-in project " + projectName, exception);
	} finally {
	    progressMonitor.done();
	}

	return project;
    }

    public static IFile createFile(String name, IContainer container, String content, IProgressMonitor progressMonitor) {
	IFile file = container.getFile(new Path(name));
	assertExist(file.getParent());
	try {
	    InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
	    if (file.exists()) {
		file.setContents(stream, true, true, progressMonitor);
	    } else {
		file.create(stream, true, progressMonitor);
	    }
	    stream.close();
	} catch (Exception e) {
	    Activator.logger.logError("Failed to create file " + name, e);
	}
	progressMonitor.worked(1);

	return file;
    }

    private static void createBuildProps(final IProgressMonitor progressMonitor, IProject project, List<String> srcFolders,
	    final List<String> extraClassPathEntries) {

	StringBuilder bpContent = new StringBuilder();
	if (srcFolders != null && !srcFolders.isEmpty()) {
	    bpContent.append("source.. = ");

	    for (Iterator<String> iterator = srcFolders.iterator(); iterator.hasNext();) {
		String entry = iterator.next();
		bpContent.append(" " + entry + "/");
		if (iterator.hasNext()) {
		    bpContent.append(", ");
		} else {
		    bpContent.append("\n");
		}
	    }
	}
	if (extraClassPathEntries != null && !extraClassPathEntries.isEmpty()) {
	    bpContent.append("jars.extra.classpath = " + extraClassPathEntries.get(0));
	    for (int i = 1, x = extraClassPathEntries.size(); i < x; i++) {
		bpContent.append(",\\\n " + extraClassPathEntries.get(i));
	    }
	    bpContent.append("\n");
	}

	bpContent.append("bin.includes = META-INF/,.\n");
	createFile("build.properties", project, bpContent.toString(), progressMonitor);
    }

    private static void createManifest(final String projectName, final Set<String> requiredBundles,
	    final List<String> exportedPackages, final IProgressMonitor progressMonitor, IProject project) throws CoreException {
	StringBuilder maniContent = new StringBuilder("Manifest-Version: 1.0\n");
	maniContent.append("Bundle-ManifestVersion: 2\n");
	maniContent.append("Bundle-Name: " + projectName + "\n");
	maniContent.append("Bundle-SymbolicName: " + projectName + "; singleton:=true\n");
	maniContent.append("Bundle-Version: 1.0.0\n");
	// maniContent.append("Bundle-Localization: plugin\n");
	maniContent.append("Require-Bundle: ");

	for (Iterator<String> iterator = requiredBundles.iterator(); iterator.hasNext();) {
	    String entry = iterator.next();
	    maniContent.append(" " + entry);
	    if (iterator.hasNext()) {
		maniContent.append(",\n");
	    } else {
		maniContent.append("\n");
	    }
	}

	// maniContent.append(" org.openarchitectureware.dependencies\n");

	if (exportedPackages != null && !exportedPackages.isEmpty()) {
	    maniContent.append("Export-Package: " + exportedPackages.get(0));
	    for (int i = 1, x = exportedPackages.size(); i < x; i++) {
		maniContent.append(",\n " + exportedPackages.get(i));
	    }
	    maniContent.append("\n");
	}

	IFolder metaInf = project.getFolder("META-INF");
	metaInf.create(false, true, new SubProgressMonitor(progressMonitor, 1));
	createFile("MANIFEST.MF", metaInf, maniContent.toString(), progressMonitor);
    }

    /**
     * @param name
     *            of the destination file
     * @param container
     *            directory containing the the destination file
     * @param contentUrl
     *            Url pointing to the src of the content
     * @param progressMonitor
     *            used to interact with and show the user the current operation
     *            status
     * @return
     */
    public static IFile createFile(String name, IContainer container, URL contentUrl, IProgressMonitor progressMonitor) {

	IFile file = container.getFile(new Path(name));
	InputStream inputStream = null;
	try {
	    inputStream = contentUrl.openStream();
	    if (file.exists()) {
		file.setContents(inputStream, true, true, progressMonitor);
	    } else {
		file.create(inputStream, true, progressMonitor);
	    }
	    inputStream.close();
	} catch (Exception e) {
	    Activator.logger.logError("Failed to create file " + name, e);
	} finally {
	    if (null != inputStream) {
		try {
		    inputStream.close();
		} catch (IOException e) {
		    Activator.logger.logError("Failed to create file " + name, e);
		}
	    }
	}
	progressMonitor.worked(1);

	return file;
    }

    private static void assertExist(IContainer c) {
	if (!c.exists()) {
	    if (!c.getParent().exists()) {
		assertExist(c.getParent());
	    }
	    if (c instanceof IFolder) {
		try {
		    ((IFolder) c).create(false, true, new NullProgressMonitor());
		} catch (CoreException e) {
		    Activator.logger.logError("Folder not found", e);
		}
	    }

	}

    }

    public static void openFileToEdit(Shell s, final IFile file) {
	s.getDisplay().asyncExec(new Runnable() {
	    @Override
	    public void run() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
		    IDE.openEditor(page, file, true);
		} catch (PartInitException e) {
		    Activator.logger.logError("Could not open editor on " + file, e);
		}
	    }
	});
    }
}
