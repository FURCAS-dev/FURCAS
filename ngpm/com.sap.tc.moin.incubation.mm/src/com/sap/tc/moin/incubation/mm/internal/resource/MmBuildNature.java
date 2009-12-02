package com.sap.tc.moin.incubation.mm.internal.resource;

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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

public final class MmBuildNature implements IProjectNature {

	private IProject project;

	public void configure() throws CoreException {
		IJavaProject javaProject = JavaCore.create(project);
		IFolder jmiFolder = project.getFolder(MmBuilder.JMI_SRC_PATH);
		if (!jmiFolder.exists()) {
			jmiFolder.create(true, true, null);
		}

		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();
		ICommand builderCommand = desc.newCommand();
		builderCommand.setBuilderName(MmBuilder.BUILDER_ID);

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

		javaProject.setRawClasspath(classpathEntriesSet.toArray(new IClasspathEntry[classpathEntriesSet.size()]), null);
	}

	public void deconfigure() throws CoreException {
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();
		ICommand builderCommand = desc.newCommand();
		builderCommand.setBuilderName(MmBuilder.BUILDER_ID);

		Set<ICommand> builderSet = new HashSet<ICommand>(commands.length);
		builderSet.addAll(Arrays.asList(commands));
		if (builderSet.remove(builderCommand)) {
			desc.setBuildSpec(builderSet.toArray(new ICommand[builderSet.size()]));
			project.setDescription(desc, null);
		}

		IFolder jmiFolder = project.getFolder(MmBuilder.JMI_SRC_PATH);

		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] classpathEntries = javaProject.getRawClasspath();
		final Set<IClasspathEntry> classpathEntriesSet = new HashSet<IClasspathEntry>(classpathEntries.length);
		classpathEntriesSet.addAll(Arrays.asList(classpathEntries));

		IClasspathEntry jmiPathEntry = JavaCore.newSourceEntry(jmiFolder.getFullPath());

		classpathEntriesSet.remove(jmiPathEntry);

		javaProject.setRawClasspath(classpathEntriesSet.toArray(new IClasspathEntry[classpathEntriesSet.size()]), null);

		if (jmiFolder.exists()) {
			jmiFolder.delete(true, false, null);
		}
	}

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	/**
	 * Checks whether a given project is metamodel build or not. Returns false
	 * in case of any exception during the check.
	 *
	 * @param project
	 * @return True, if project is a metamodelbuild project
	 */
	public static final boolean hasMetamodelBuilderNature(IProject project) {
		try {
			return project.hasNature(MmBuilder.NATURE_ID);
		} catch (Exception e) { // $JL-EXC$
			return false;
		}
	}
}
