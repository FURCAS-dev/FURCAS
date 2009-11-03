package com.sap.mi.tools.mmbuilder.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

public class MetamodelBuildNature implements IProjectNature {

	private static final Set<String> JAVA_SUB_FOLDERS = new HashSet<String>(Arrays.asList("ps", "eh", "s2x", "mm")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

	private IProject project;

	private static class FolderVisitor implements IResourceVisitor {

		private IFolder mmrFolder;
		private IFolder moinFolder;

		public boolean visit(IResource resource) throws CoreException {
			String name = resource.getName();
			if (resource instanceof IFolder && resource.isLinked()) {
				// check if japro
				if (name.endsWith(MMBuilderConstants.MMR_FOLDER_SUFFIX)) {
					mmrFolder = (IFolder) resource;
					return false;
				}
			} else if (resource instanceof IFolder) {
				// check DC
				if (name.equals(MMBuilderConstants.XMI_SRC_PATH)) {
					IFolder folder = (IFolder) resource;
					folder = folder.getFolder(MMBuilderConstants.MOIN_FOLDER);
					if (folder.exists() && folder.isLinked()) {
						moinFolder = (IFolder) resource;
						return false;
					}
				}
			}
			return true;
		}

		public IFolder getJaproMMRFolder() {
			return mmrFolder;
		}

		public IFolder getDCMoinFolder() {
			return moinFolder;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#configure()
	 */
	public void configure() throws CoreException {
		FolderVisitor visitor = new FolderVisitor();
		project.accept(visitor);
		IFolder japroMMRFolder = visitor.getJaproMMRFolder();
		IFolder dcMOINFolder = visitor.getDCMoinFolder();

		if (japroMMRFolder == null && dcMOINFolder == null) {
			throw new IllegalArgumentException("Project contains no " + //$NON-NLS-1$
					"(linked) metamodel folder ending with '" //$NON-NLS-1$
					+ MMBuilderConstants.MMR_FOLDER_SUFFIX + "'. project: " + project.getName()); //$NON-NLS-1$
		}

		if (japroMMRFolder != null && dcMOINFolder != null) {
			throw new IllegalArgumentException("Project contains both " + //$NON-NLS-1$
					"(linked) metamodel folder ending with '" //$NON-NLS-1$
					+ MMBuilderConstants.MMR_FOLDER_SUFFIX + "' and an " + MMBuilderConstants.XMI_SRC_PATH //$NON-NLS-1$
					+ " folder. project: " + project.getName()); //$NON-NLS-1$
		}

		IFolder xmiFolder = getProject().getFolder(MMBuilderConstants.XMI_SRC_PATH);
		if (japroMMRFolder != null) {
			if (!xmiFolder.exists()) {
				IPath mmrPath = japroMMRFolder.getLocation().removeLastSegments(1);
				xmiFolder.createLink(mmrPath, IResource.NONE, null);
			}
		}

		IJavaProject javaProject = JavaCore.create(project);
		IFolder jmiFolder = project.getFolder(MMBuilderConstants.JMI_SRC_PATH);
		if (!jmiFolder.exists()) {
			jmiFolder.create(true, true, null);
		}

		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();
		ICommand builderCommand = desc.newCommand();
		builderCommand.setBuilderName(MMBuilderConstants.BUILDER_ID);

		List<ICommand> builderList = new ArrayList<ICommand>(commands.length + 1);
		builderList.addAll(Arrays.asList(commands));
		if (!builderList.contains(builderCommand)) {
			builderList.add(0, builderCommand);
			desc.setBuildSpec(builderList.toArray(new ICommand[builderList.size()]));
			project.setDescription(desc, null);
		}

		IClasspathEntry[] classpathEntries = javaProject.getRawClasspath();
		final Set<IClasspathEntry> classpathEntriesSet = new HashSet<IClasspathEntry>(classpathEntries.length + 2);
		classpathEntriesSet.addAll(Arrays.asList(classpathEntries));
		classpathEntriesSet.add(JavaCore.newSourceEntry(jmiFolder.getFullPath()));

		// if xmisrc contains folder moinsrc ->
		// xmisrc excludes moinsrc
		// moinsrc added to java classpath

		// must be java source folder to be able to export "moin.meta"
		IFolder moinSrcFolder = xmiFolder.getFolder(MMBuilderConstants.MOIN_SRC_FOLDER);
		classpathEntriesSet.addAll(calculateClasspath(moinSrcFolder, xmiFolder));

		javaProject.setRawClasspath(classpathEntriesSet.toArray(new IClasspathEntry[classpathEntriesSet.size()]), null);
	}

	private Set<IClasspathEntry> calculateClasspath(final IFolder moinSrcFolder, final IFolder xmiFolder) throws CoreException {
		final Set<IClasspathEntry> classpathEntriesSet = new HashSet<IClasspathEntry>();
		if (moinSrcFolder.exists()) {
			// japro
			classpathEntriesSet.add(JavaCore.newSourceEntry(xmiFolder.getFullPath(), new IPath[] { new Path(
					MMBuilderConstants.MOIN_SRC_FOLDER + IPath.SEPARATOR) }));

			final IFolder javaFolder = moinSrcFolder.getFolder(MMBuilderConstants.JAVA_SRC_FOLDER);
			if (javaFolder.exists()) {
				IResource[] members = javaFolder.members();
				Set<IPath> excludeJavaSubSrcs = new HashSet<IPath>();
				for (IResource resource : members) {
					if (resource instanceof IFolder && JAVA_SUB_FOLDERS.contains(resource.getName())) {
						classpathEntriesSet.add(JavaCore.newSourceEntry(resource.getFullPath()));
						excludeJavaSubSrcs.add(new Path(resource.getName() + IPath.SEPARATOR));
					}
				}

				classpathEntriesSet.add(JavaCore.newSourceEntry(javaFolder.getFullPath(), excludeJavaSubSrcs
						.toArray(new IPath[excludeJavaSubSrcs.size()])));

				classpathEntriesSet.add(JavaCore.newSourceEntry(moinSrcFolder.getFullPath(), new IPath[] { new Path(
						MMBuilderConstants.JAVA_SRC_FOLDER + IPath.SEPARATOR) }));
			} else {
				classpathEntriesSet.add(JavaCore.newSourceEntry(moinSrcFolder.getFullPath()));
			}

		} else {
			// dc
			IFolder javaFolder = xmiFolder.getFolder(MMBuilderConstants.JAVA_SRC_FOLDER);
			if (javaFolder.exists()) {
				classpathEntriesSet.add(JavaCore.newSourceEntry(javaFolder.getFullPath()));
				classpathEntriesSet.add(JavaCore.newSourceEntry(xmiFolder.getFullPath(), new IPath[] { new Path(
						MMBuilderConstants.JAVA_SRC_FOLDER + IPath.SEPARATOR) }));
			} else {
				classpathEntriesSet.add(JavaCore.newSourceEntry(xmiFolder.getFullPath()));
			}
		}
		return classpathEntriesSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();
		ICommand builderCommand = desc.newCommand();
		builderCommand.setBuilderName(MMBuilderConstants.BUILDER_ID);

		Set<ICommand> builderSet = new HashSet<ICommand>(commands.length);
		builderSet.addAll(Arrays.asList(commands));
		if (builderSet.remove(builderCommand)) {
			desc.setBuildSpec(builderSet.toArray(new ICommand[builderSet.size()]));
			project.setDescription(desc, null);
		}

		IFolder jmiFolder = project.getFolder(MMBuilderConstants.JMI_SRC_PATH);
		IFolder xmiFolder = project.getFolder(MMBuilderConstants.XMI_SRC_PATH);
		IFolder moinSrcFolder = xmiFolder.getFolder(MMBuilderConstants.MOIN_SRC_FOLDER);

		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] classpathEntries = javaProject.getRawClasspath();
		final Set<IClasspathEntry> classpathEntriesSet = new HashSet<IClasspathEntry>(classpathEntries.length);
		classpathEntriesSet.addAll(Arrays.asList(classpathEntries));

		IClasspathEntry jmiPathEntry = JavaCore.newSourceEntry(jmiFolder.getFullPath());
		IClasspathEntry xmiPathEntry = JavaCore.newSourceEntry(xmiFolder.getFullPath());
		IClasspathEntry moinSrcPathEntry = JavaCore.newSourceEntry(moinSrcFolder.getFullPath());
		IClasspathEntry xmiPathExclEntry = JavaCore.newSourceEntry(xmiFolder.getFullPath(), new IPath[] { new Path(
				MMBuilderConstants.MOIN_SRC_FOLDER + IPath.SEPARATOR) });

		IClasspathEntry moinSrcExclEntry = JavaCore.newSourceEntry(moinSrcFolder.getFullPath(), new IPath[] { new Path(
				MMBuilderConstants.JAVA_SRC_FOLDER + IPath.SEPARATOR) });

		classpathEntriesSet.remove(jmiPathEntry);
		classpathEntriesSet.remove(xmiPathEntry);
		classpathEntriesSet.remove(xmiPathExclEntry);
		classpathEntriesSet.remove(moinSrcPathEntry);
		classpathEntriesSet.remove(moinSrcExclEntry);

		classpathEntriesSet.removeAll(calculateClasspath(moinSrcFolder, xmiFolder));

		javaProject.setRawClasspath(classpathEntriesSet.toArray(new IClasspathEntry[classpathEntriesSet.size()]), null);

		if (jmiFolder.exists()) {
			jmiFolder.delete(true, false, null);
		}
		if (xmiFolder.exists()) {
			xmiFolder.delete(true, false, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core .resources.IProject)
	 */
	public void setProject(IProject project) {
		this.project = project;
	}

	/**
	 * Checks whether a given project is a metamodel project
	 * 
	 * @param project
	 * @return
	 */
	public static final boolean isJaproProject(IProject project) {
		FolderVisitor visitor = new FolderVisitor();
		try {
			project.accept(visitor);
		} catch (CoreException e) { // $JL-EXC$
			return false;
		}
		IFolder mmrFolder = visitor.getJaproMMRFolder();
		return mmrFolder != null;
	}

	/**
	 * Checks whether a given project is metamodel build or not. Returns false in case of any exception during the check.
	 * 
	 * @param project
	 * @return True, if project is a metamodelbuild project
	 */
	public static final boolean hasMetamodelBuilderNature(IProject project) {
		try {
			return project.hasNature(MMBuilderConstants.NATURE_ID);
		} catch (Exception e) { // $JL-EXC$
			return false;
		}
	}
}
