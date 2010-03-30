package de.hpi.sam.bp2009.solution.scopeProvider.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * Implements simple tests to explore the eclipse environment.
 * 
 */
public class ProjectCreator {

	// the plugins workspace
	private IWorkspace workspace;

	// constructor
	public ProjectCreator(final IWorkspace workspace) {
		this.workspace = workspace;
	}

	/**
	 * 
	 * @return the workspace
	 */
	public IWorkspace getWorkspace() {
		return workspace;
	}



//	private void addSystemLibraries(final IJavaProject javaProject)
//			throws JavaModelException {
//		IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
//		IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
//		System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
//		newEntries[oldEntries.length] = JavaRuntime
//				.getDefaultJREContainerEntry();
//		javaProject.setRawClasspath(newEntries, null);
//	}

	/**
	 * Creates a java project int the workspace.
	 * @return 
	 * 
	 */
	IProject createProject(String projectName) {
		// create project as java project
		IProject proj = workspace.getRoot().getProject(projectName);
		// System.out.println(proj);

		IProjectDescription desc = workspace
				.newProjectDescription(projectName);
		// String[] ids = desc.getNatureIds();
//		String[] ids = { JavaCore.NATURE_ID };
//		desc.setNatureIds(ids);

		try {
			// desc = proj.getDescription();
			proj.create(desc, null);
			proj.open(new NullProgressMonitor());
		} catch (CoreException ex) {
			ex.printStackTrace();
		}

//		try {
//			if (!proj.hasNature(JavaCore.NATURE_ID)) {
//				IProjectDescription descriptions = proj.getDescription();
//				String[] oldIds = descriptions.getNatureIds();
//				String[] newIds = new String[oldIds.length + 1];
//				System.arraycopy(oldIds, 0, newIds, 0, oldIds.length);
//				newIds[oldIds.length] = JavaCore.NATURE_ID;
//				descriptions.setNatureIds(newIds);
//			}
//		} catch (CoreException e) {
//			e.printStackTrace();
//		}

//		try {
//			// JupePlugin.addJupeBuildNature(proj);
//			if (!proj.hasNature(org.jupe.plugin.JupeNature.NATURE_ID)) {
//
//				IProjectDescription description = proj.getDescription();
//				String[] oldids = description.getNatureIds();
//				String[] newIds = new String[oldids.length + 1];
//				System.arraycopy(oldids, 0, newIds, 0, oldids.length);
//				// System.out.println("adding JupeNature");
//				newIds[oldids.length] = org.jupe.plugin.JupeNature.NATURE_ID;
//				// newIds[oldids.length] = JavaCore.NATURE_ID;
//				description.setNatureIds(newIds);
//				proj.setDescription(description, null);
//			}
//		} catch (CoreException e) {
//			e.printStackTrace();
//			IStatus[] stats = e.getStatus().getChildren();
//			for (int i = 0; i < stats.length; i++) {
//				IStatus status = stats[i];
//				System.out.println("Status child " + i + ": "
//						+ status.getMessage());
//			}
//		}
//
//		IJavaProject javaproj = JavaCore.create(proj);
//
//		try {
//			// javaproj.setRawClasspath(new IClasspathEntry[0], null);
//			addSystemLibraries(javaproj);
//		} catch (JavaModelException e3) {
//			e3.printStackTrace();
//		}

		/*
		 * trying to create a package without success; How to do?
		 * 
		 * IJavaProject javaproj = JavaCore.create(proj); IPackageFragmentRoot
		 * packageFragmentRoot = javaproj.getPackageFragmentRoot(proj);
		 * //packageFragmentRoot.getPackageFragment(""); //default package
		 * 
		 * IPackageFragment pfragment =
		 * packageFragmentRoot.getPackageFragment("org.Blubb.newFolder");
		 * System.out.println(pfragment.exists());
		 * 
		 * NullProgressMonitor moni = new NullProgressMonitor(); try {
		 * pfragment.makeConsistent(moni);
		 * System.out.println(pfragment.exists()); pfragment.save(moni, true);
		 * System.out.println(pfragment.exists()); } catch (JavaModelException
		 * e3) { e3.printStackTrace(); }
		 */

		IFolder folder3 = proj.getFolder("org");
		IFolder folder2 = folder3.getFolder("Blubb");
		IFolder folder = folder2.getFolder("newFolder");

		NullProgressMonitor monitor = new NullProgressMonitor();

		// "creating package = 3 folders"
		try {
			folder3.create(false, true, monitor);
			folder2.create(false, true, monitor);
			folder.create(false, true, monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// create file: get it, create it and create it...
		IFile file = folder.getFile("Baa.java");
		String fullpath = file.getLocation().toString();
		// System.out.println(fullpath);
		File realfile = new File(fullpath);
		try {
			realfile.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		FileInputStream fileinputstream = null;
		try {
			fileinputstream = new FileInputStream(fullpath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			file.create(fileinputstream, true, monitor);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// IJavaElement pack =
//		JavaCore.create(folder);
//		// System.out.println(pack instanceof IPackageFragment);
//		ICompilationUnit javaFile = JavaCore.createCompilationUnitFrom(file);
//
//		// filling the java file
//		try {
//			javaFile.createPackageDeclaration("org.Blubb.newFolder", monitor);
//			javaFile.createImport("java.util.HashMap", null, monitor);
//			IType type = javaFile.createType("public class Baa {\n}", null,
//					true, monitor);
//			// System.out.println(type);
//			// IField ifield =
//			type.createField("HashMap map;", null, true, monitor);
//			// System.out.println("ifield: " + ifield);
//			// IMethod imethod =
//			type.createMethod("public void main(String[] args) {\n}", null,
//					true, monitor);
//			// System.out.println("isMainMethod(): " + imethod.isMainMethod());
//		} catch (JavaModelException e) {
//			e.printStackTrace();
//		}

		// add a listener for the JavaCore
		// JavaCore.addElementChangedListener(new
		// ConcreteElementChangedListener());

		// add a listener to workspace ot listen to all resource changes
		// workspace.addResourceChangeListener(new
		// ConcreteResourceChangedListener());
		return proj;
	}
}

