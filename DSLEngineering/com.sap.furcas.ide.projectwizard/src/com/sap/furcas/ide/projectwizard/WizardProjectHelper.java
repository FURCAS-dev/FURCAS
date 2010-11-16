/*Supplies the wizard with methods to build pluginprojects and necessary files for the Furcas Workbench,
 * Works together with the classes CreateProject and SourceCodeFactory in the wizards package.
 * */

package com.sap.furcas.ide.projectwizard;

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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.sap.furcas.ide.projectwizard.wizards.SourceCodeFactory;

public class WizardProjectHelper {

    public static IProject createPlugInProject(final String projectName, final List<String> srcFolders,
            final List<String> nonSrcFolders, final List<IProject> referencedProjects, final List<String> exportedPackages,
            final List<String> extraClasspathEntries, final IProgressMonitor progressMonitor, final Shell theShell, String nature) {
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

            projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", "com.sap.furcas.ide.dslproject.syntaxGenerationNature"});

            ICommand java = projectDescription.newCommand();
            java.setBuilderName(JavaCore.BUILDER_ID);

            ICommand manifest = projectDescription.newCommand();
            manifest.setBuilderName("org.eclipse.pde.ManifestBuilder");

            ICommand schema = projectDescription.newCommand();
            schema.setBuilderName("org.eclipse.pde.SchemaBuilder");

            ICommand furcas = projectDescription.newCommand();
            furcas.setBuilderName("com.sap.furcas.ide.dslproject.syntaxBuilder");

            projectDescription.setBuildSpec(new ICommand[] { java, manifest, schema, furcas });

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
            createManifest(projectName, progressMonitor, project);
            createBuildProps(progressMonitor, project, srcFolders, extraClasspathEntries);
        } catch (Exception exception) {
            System.out.println("Error while creating the project.");
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
            System.out.println("Failed to create file ");
        }
        progressMonitor.worked(1);

        return file;
    }

    private static void createBuildProps(final IProgressMonitor progressMonitor, IProject project, List<String> srcFolders,
            final List<String> extraClassPathEntries) {
        SourceCodeFactory scf = new SourceCodeFactory();
        createFile("build.properties", project, scf.createBuildProbCode(), progressMonitor);
    }

    private static void createManifest(final String projectName, final IProgressMonitor progressMonitor, IProject project)
            throws CoreException {
        SourceCodeFactory scf = new SourceCodeFactory();

        IFolder metaInf = project.getFolder("META-INF");
        metaInf.create(false, true, new SubProgressMonitor(progressMonitor, 1));
        createFile("MANIFEST.MF", metaInf, scf.createManifest(projectName), progressMonitor);
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
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
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
                }
            }
        });
    }
}
