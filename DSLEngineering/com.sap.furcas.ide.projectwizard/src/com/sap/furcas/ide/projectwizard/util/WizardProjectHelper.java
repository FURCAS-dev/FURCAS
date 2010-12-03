package com.sap.furcas.ide.projectwizard.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * Supplies the wizard with methods to build pluginprojects and necessary files for the Furcas Workbench, Works together with the
 * classes CreateProject and SourceCodeFactory in the wizards package.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class WizardProjectHelper {

    /**
     * Generates a fresh plugin project for eclipse.
     * 
     * @param pi
     *            The user input from the wizard.
     * @param srcFolders
     *            List of all src folders
     * @param nonSrcFolders
     *            List of all non source folders
     * @param exportedPackages
     *            List of all exported packages
     * @param progressMonitor
     *            The ProgressMonitor
     * @param theShell
     *            The Window containing the wizard.
     * @param metamodel
     *            States wether this is the metamodel project or not. This is used for including different natures and builders
     *            and a different project name.
     * @return The generated project.
     * @throws CodeGenerationException
     */
    public static IProject createPlugInProject(final ProjectInfo pi, final List<String> srcFolders,
            final List<String> nonSrcFolders, final List<String> exportedPackages, final IProgressMonitor progressMonitor,
            final Shell theShell, final boolean metamodel) throws CodeGenerationException {
        IProject project = null;
        final String projectName;
        // Check if this is the creation of the metamodel project or not.
        //
        if (metamodel)
            projectName = pi.getProjectName() + ".metamodel";
        else
            projectName = pi.getProjectName();

        progressMonitor.beginTask("", 10);
        progressMonitor.subTask("Creating project " + projectName);
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        project = workspace.getRoot().getProject(projectName);

        if (project.exists()) {
            deleteOldProject(progressMonitor, theShell, project, projectName);
        }

        // Create the project
        //
        IJavaProject javaProject = JavaCore.create(project);
        IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
        projectDescription.setLocation(null);
        try {
            project.create(projectDescription, new SubProgressMonitor(progressMonitor, 1));
        } catch (CoreException e) {
            throw new CodeGenerationException("Error while creating project: " + project.getName(), e.getCause());
        }
        List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();

        // Add the required natures depending on wether this is a dsl project or a metamodelproject.
        //
        if (!metamodel) {
            projectDescription.setNatureIds(new String[] { "com.sap.furcas.ide.dslproject.syntaxGenerationNature",
                    JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature" });
        } else
            projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature" });

        addBuilders(progressMonitor, metamodel, project, projectDescription);

        setClasspath(srcFolders, nonSrcFolders, progressMonitor, project, javaProject, classpathEntries);

        try {
            javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), new SubProgressMonitor(progressMonitor, 1));
        } catch (JavaModelException e) {
            throw new CodeGenerationException("Error while setting output location: "+"/" + projectName + "/bin", e.getCause());
        }

        if (!metamodel) {
            createManifestAndBuildProps(pi, progressMonitor, project);
        }

        progressMonitor.done();

        return project;
    }

    /**
     * Create the manifest and build properties. If it's a metamodel project those files are created automatically.
     * 
     * @param pi
     * @param progressMonitor
     * @param project
     * @throws CoreException
     */
    private static void createManifestAndBuildProps(final ProjectInfo pi, final IProgressMonitor progressMonitor, IProject project)
            throws CodeGenerationException {
        SourceCodeFactory scf = new SourceCodeFactory();
        createFile("build.properties", project, scf.createBuildProbCode(), progressMonitor);
        IFolder metaInf = project.getFolder("META-INF");
        try {
            metaInf.create(false, true, new SubProgressMonitor(progressMonitor, 1));
        } catch (CoreException e) {
            throw new CodeGenerationException("Failed to create folder 'META-INF'", e.getCause());
        }
        createFile("MANIFEST.MF", metaInf, scf.createManifest(pi), progressMonitor);
    }

    /**
     * 
     * Set the classpath entries for the source folders
     * 
     * @param srcFolders
     * @param nonSrcFolders
     * @param progressMonitor
     * @param project
     * @param javaProject
     * @param classpathEntries
     * @throws CoreException
     * @throws JavaModelException
     */
    private static void setClasspath(final List<String> srcFolders, final List<String> nonSrcFolders,
            final IProgressMonitor progressMonitor, IProject project, IJavaProject javaProject,
            List<IClasspathEntry> classpathEntries) throws CodeGenerationException {
        Collections.reverse(srcFolders);
        for (String src : srcFolders) {
            IFolder srcContainer = project.getFolder(src);
            if (!srcContainer.exists()) {
                try {
                    srcContainer.create(false, true, new SubProgressMonitor(progressMonitor, 1));
                } catch (CoreException e) {
                    throw new CodeGenerationException("Failed to create source folder 'src'", e.getCause());
                }
            }
            IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(srcContainer.getFullPath());
            classpathEntries.add(0, srcClasspathEntry);
        }

        if (nonSrcFolders != null) {
            for (String src : nonSrcFolders) {
                IFolder srcContainer = project.getFolder(src);
                if (!srcContainer.exists()) {
                    try {
                        srcContainer.create(false, true, new SubProgressMonitor(progressMonitor, 1));
                    } catch (CoreException e) {
                        throw new CodeGenerationException("Failed to create source folder 'src'", e.getCause());
                    }
                }
            }
        }

        classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER")));
        classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));

        try {
            javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
                    new SubProgressMonitor(progressMonitor, 1));
        } catch (JavaModelException e) {
            throw new CodeGenerationException("Failed to set projects classpath", e.getCause());
        }
    }

    /**
     * 
     * Add the required builders depending on wether this is a dsl project or a metamodelproject.
     * 
     * @param progressMonitor
     * @param metamodel
     * @param project
     * @param projectDescription
     * @throws CoreException
     */
    private static void addBuilders(final IProgressMonitor progressMonitor, final boolean metamodel, IProject project,
            IProjectDescription projectDescription) throws CodeGenerationException {
        ICommand java = projectDescription.newCommand();
        java.setBuilderName(JavaCore.BUILDER_ID);

        ICommand manifest = projectDescription.newCommand();
        manifest.setBuilderName("org.eclipse.pde.ManifestBuilder");

        ICommand schema = projectDescription.newCommand();
        schema.setBuilderName("org.eclipse.pde.SchemaBuilder");

        if (!metamodel) {
            ICommand furcas = projectDescription.newCommand();
            furcas.setBuilderName("com.sap.furcas.ide.dslproject.syntaxBuilder");

            projectDescription.setBuildSpec(new ICommand[] { furcas, java, manifest, schema });
        } else {
            projectDescription.setBuildSpec(new ICommand[] { java, manifest, schema });
        }

        try {
            project.open(new SubProgressMonitor(progressMonitor, 1));
            project.setDescription(projectDescription, new SubProgressMonitor(progressMonitor, 1));
        } catch (CoreException e) {
            throw new CodeGenerationException("Failed to set projects builders", e.getCause());
        }

    }

    /**
     * 
     * Clean up any old project information.
     * 
     * @param progressMonitor
     * @param theShell
     * @param project
     * @param projectName
     * @throws CoreException
     */
    private static void deleteOldProject(final IProgressMonitor progressMonitor, final Shell theShell, IProject project,
            final String projectName) throws CodeGenerationException {
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
            try {
                project.delete(true, true, new SubProgressMonitor(progressMonitor, 1));
            } catch (CoreException e) {
                throw new CodeGenerationException("Failed to delete existing project with same name", e.getCause());
            }
        } else {
            return;
        }
    }

    /**
     * Creates a file.
     * 
     * @param name
     *            The name of the file.
     * @param container
     *            The container in which the file is to be created.
     * @param content
     *            The content of the file.
     * @param progressMonitor
     *            The Progress Monitor.
     * @return The file.
     * @throws CodeGenerationException
     */
    public static IFile createFile(String name, IContainer container, String content, IProgressMonitor progressMonitor)
            throws CodeGenerationException {
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
            throw new CodeGenerationException("Failed to create file '" + name + "'", e.getCause());
        }
        progressMonitor.worked(1);

        return file;
    }

    /**
     * Creates a .genmodel file for the ecore metamodel. See {@link}CreateMMProject.
     * 
     * @param progressMonitor
     *            The progress monitor
     * @param project
     *            the project where the genmodel is to be created
     * @param pi
     *            The user input
     * @return The .genmodel file
     * @throws CoreException
     */
    public static IFile createGenmodel(final IProgressMonitor progressMonitor, IProject project, ProjectInfo pi)
            throws CodeGenerationException {
        SourceCodeFactory scf = new SourceCodeFactory();
        IFolder folder = project.getFolder("model");
        return createFile(CreateProject.capitalizeFirstChar(pi.getLanguageName()) + ".genmodel", folder,
                scf.createGenmodelCode(pi), progressMonitor);
    }

    /**
     * @param name
     *            of the destination file
     * @param container
     *            directory containing the the destination file
     * @param contentUrl
     *            Url pointing to the src of the content
     * @param progressMonitor
     *            used to interact with and show the user the current operation status
     * @return
     * @throws CodeGenerationException
     */
    public static IFile createFile(String name, IContainer container, URL contentUrl, IProgressMonitor progressMonitor)
            throws CodeGenerationException {

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
            throw new CodeGenerationException("Failed to create File: '" + name + "'", e.getCause());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new CodeGenerationException("Failed to close inputStream while creating file: '" + name + "'",
                            e.getCause());
                }
            }
        }
        progressMonitor.worked(1);

        return file;
    }

    /**
     * Assert that c exists. If it doesn't exist. It will be created.
     * 
     * @param c
     *            The container whose existence is checked.
     * @throws CodeGenerationException
     */
    private static void assertExist(IContainer c) throws CodeGenerationException {
        if (!c.exists()) {
            if (!c.getParent().exists()) {
                assertExist(c.getParent());
            }
            if (c instanceof IFolder) {
                try {
                    ((IFolder) c).create(false, true, new NullProgressMonitor());
                } catch (CoreException e) {
                    throw new CodeGenerationException("Failed to create container: " + c.getName(), e.getCause());
                }
            }

        }

    }

    /**
     * Opens a file for editing in the Shell.
     * 
     * @param s
     *            The shell where to open it.
     * @param file
     *            The file to open.
     */
    public static void openFileToEdit(Shell s, final IFile file) {
        s.getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    IDE.openEditor(page, file, true);
                } catch (PartInitException e) {
                    Throwable realException = e.getCause();
                    MessageDialog.openError(page.getWorkbenchWindow().getShell(), "Error", realException.getMessage());
                }
            }
        });
    }
}
