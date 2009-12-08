package com.sap.mi.tools.mmbuilder.internal;

/**
 * Copyright (c) 2008 by SAP AG, Walldorf. http://www.sap.com All rights
 * reserved.
 *
 * This software is the confidential and proprietary information of SAP AG,
 * Walldorf. You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered
 * into with SAP.
 *
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.osgi.util.NLS;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmExecutableInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerationBaseInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerationInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerator;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;

public final class MetamodelBuilder extends IncrementalProjectBuilder {

	private static final Logger stracer = Logger.getLogger(MiLocations.MI_METAMODELBUILDER);
	
	public static final String PROPERTY_NAME_FACILITY_NAME = "facilityName"; //$NON-NLS-1$
	public static final String PROPERTY_NAME_METAMODEL_VERSION = "metamodelVersion"; //$NON-NLS-1$

	static class XMIFileFinder implements IResourceVisitor, IResourceDeltaVisitor {

		private final IPath outputLocation;
		private final List<String> xmiFiles = new ArrayList<String>();
		private final List<IFile> xmiIFiles = new ArrayList<IFile>();

		/**
		 * @return the xmiIFiles
		 */
		public List<IFile> getXmiIFiles() {
			return xmiIFiles;
		}

		public XMIFileFinder(final IPath outputLocation) {
			this.outputLocation = outputLocation;
		}

		public boolean visit(final IResource resource) {
			if (this.outputLocation != null && this.outputLocation.isPrefixOf(resource.getFullPath())) {
				return true;
			}
			if (resource.exists() && resource instanceof IFile
					&& MetaModelCatalog.META_MODEL_EXTENSION.equals("." + resource.getFileExtension())) { //$NON-NLS-1$
				this.xmiFiles.add(resource.getLocation().toOSString());
				this.xmiIFiles.add((IFile) resource);
			}
			// return true to continue visiting children.
			return true;
		}

		public boolean visit(final IResourceDelta delta) {
			if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
				final IResource resource = delta.getResource();
				if (this.outputLocation != null && this.outputLocation.isPrefixOf(resource.getFullPath())) {
					return true;
				}
				if (resource.exists() && resource instanceof IFile
						&& MetaModelCatalog.META_MODEL_EXTENSION.equals("." + resource.getFileExtension())) { //$NON-NLS-1$
					this.xmiFiles.add(resource.getLocation().toOSString());
					// for now we can return here since a full build will be
					// triggered anyway
					// TODO remove when increment build is available
					return false;
				}
			}
			// return true to continue visiting children.
			return true;
		}

		public String[] getXmiFilePaths() {
			return this.xmiFiles.toArray(new String[this.xmiFiles.size()]);
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected IProject[] build(final int kind, final Map args, IProgressMonitor monitor) throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
			fullBuild(monitor);
		} else {
			final IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	@Override
	protected void clean(final IProgressMonitor monitor) throws CoreException {
		ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
			public void run(final IProgressMonitor monitor) throws CoreException {
				final String msg = NLS.bind(MMBuilderMessages.MB_Cleaning, getProject().getName());
				monitor.subTask(msg);

				final IFolder srcFolder = getJavaSourceFolder();
				if (srcFolder.exists()) {
					srcFolder.delete(true, false, monitor);
				}
				srcFolder.create(true, true, monitor);
				// getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
			}
		}, monitor);
		super.clean(monitor);
	}

	protected void fullBuild(IProgressMonitor monitor) throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		clean(monitor);

		final String msg = NLS.bind(MMBuilderMessages.MB_Scanning, getProject().getName());
		monitor.subTask(msg);

		createJmiJavaFiles(getMetamodelPartitionFiles(getProject()), monitor);

		// augmentManifest(getProject(), monitor);
	}

	protected void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
		final String msg = NLS.bind(MMBuilderMessages.MB_Scanning, getProject().getName());
		monitor.subTask(msg);
		final XMIFileFinder visitor = new XMIFileFinder(getOutputLocation(getProject()));
		delta.accept(visitor);
		final String[] files = visitor.getXmiFilePaths();
		if (files.length > 0) {
			fullBuild(monitor);
		}
		// augmentManifest(getProject(), monitor);
	}

	private static IPath getOutputLocation(final IProject project) throws CoreException {

		if (project.isOpen() && project.hasNature(JavaCore.NATURE_ID)) {
			final IJavaProject javaProject = JavaCore.create(project);
			return javaProject.getOutputLocation();
		}

		return null;
	}

	private IFolder getJavaSourceFolder() {
		final IFolder srcFolder = getProject().getFolder(MMBuilderConstants.JMI_SRC_PATH);
		return srcFolder;
	}

	@SuppressWarnings("deprecation")
	private void createJmiJavaFiles(final File[] metamodelPartitionFiles, final IProgressMonitor monitor) throws CoreException {

		final File srcFolder = new File(getJavaSourceFolder().getLocation().toOSString());

		Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider = null;
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (final IProject project : projects) {
			if (project.isAccessible() && project.isNatureEnabled(MMBuilderConstants.NATURE_ID) && (!getProject().equals(project))) {
				final Properties buildFileProperties = getMetamodelProperties(project);
				if (buildFileProperties != null) {
					if (additionalMetamodelsToConsider == null) {
						additionalMetamodelsToConsider = new ArrayList<MmGenerationBaseInfo>();
					}
					final String sourcePath = getMetamodelPartitionFilesSourcePath(project);
					final MmGenerationBaseInfo baseInfo = new MmGenerationBaseInfo(sourcePath, buildFileProperties
							.getProperty(MmGenerator.CONTAINER));
					additionalMetamodelsToConsider.add(baseInfo);
				} else {
					MetamodelBuilder.stracer.log(Level.SEVERE, "Invalid project: " + project.getName()); // TODO//$NON-NLS-1$
				}
			}
		}

		final File outputLocation = new File(getProject().getLocation().append(getOutputLocation(getProject()).removeFirstSegments(1))
				.toOSString());

		String msg = NLS.bind(MMBuilderMessages.MB_Creating, getProject().getName());
		monitor.subTask(msg);
		final Properties buildFileProperties = getMetamodelProperties(getProject());
		if (buildFileProperties == null) {
			throw new IllegalStateException("Metamodel information could not be found"); //$NON-NLS-1$
		}

		boolean[] flags;
		try {
			flags = getAdditionalFlags(getProject());
		} catch (final IOException e1) {
			throw new RuntimeException("Project not found due to IOException", e1); //$NON-NLS-1$
		}
		final boolean ignoreMetamodelChecks = flags[0];
		final boolean generateMof = flags[1];

		// TODO remove by christmas eve
		if (buildFileProperties.containsKey("DisableClassProxies")) { //$NON-NLS-1$
			try {
				Method method = System.class.getMethod("setProperty", String.class, String.class); //$NON-NLS-1$
				method.invoke(null, "com.sap.tc.moin.noclassproxy", "true"); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (Exception e) {
			}
		}

		try {
			String metamodelPartitionFilesSourcePath = getMetamodelPartitionFilesSourcePath(getProject());
			MoinFactory.getMmGenerator().generate(
					new MmGenerationInfo(metamodelPartitionFilesSourcePath, metamodelPartitionFiles, srcFolder, outputLocation,
							buildFileProperties, generateMof, ignoreMetamodelChecks), additionalMetamodelsToConsider);
		} catch (final Exception e) {
			stracer.log(Level.SEVERE, "Exception during jmi java file generation", e); //$NON-NLS-1$
		}

		// TODO remove by christmas eve
		if (buildFileProperties.containsKey("DisableClassProxies")) { //$NON-NLS-1$
			try {
				Method method = System.class.getMethod("setProperty", String.class, String.class); //$NON-NLS-1$
				method.invoke(null, "com.sap.tc.moin.noclassproxy", ""); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (Exception e) {
			}
		}

		msg = NLS.bind(MMBuilderMessages.MB_Refreshing, getProject().getName());
		monitor.subTask(msg);
		getJavaSourceFolder().refreshLocal(IResource.DEPTH_INFINITE, monitor);

		// For some reasons the Java model is not uptodate after the
		// previous refresh on clean builds, which leads to PDE's manifest
		// validator (a successor builder) to yield some "exported
		// packages are not existing" markers. Fix is to checkpoint here
		// leading to resource change events being broadcasted. This
		// apparently makes the Java model consistent.
		getProject().getWorkspace().checkpoint(false);
	}

	private static Properties getMetamodelProperties(final IProject project) throws CoreException {

		// handle japro wrapper plugins
		Properties buildFileProperties = MmBuildJaproParser.getMetamodelProperties(getMmJaproBuildFile(project));
		if (buildFileProperties != null) {
			return buildFileProperties;
		}

		// handle dc wrapper projects
		final IFolder moinFolder = getTargetMoinFolder(project);
		if (moinFolder != null) {
			final IProject moinProject = moinFolder.getProject();
//			Properties dcInfo = DCHelper.getInstance().getDCInfo(moinProject);
//			if (dcInfo != null) {
//        			String name = (String) dcInfo.get(DCHelper.NAME);
//        			String vendor = (String) dcInfo.get(DCHelper.VENDOR);
//        
//        			String facility = DCHelper.getInstance().getDCProperty(moinProject, MoinProject.PROP_MOIN_NAMESPACE,
//        					PROPERTY_NAME_FACILITY_NAME);
//        			if (facility == null) {
//        				facility = "PF"; //$NON-NLS-1$
//        			}
//        			String metamodelVersion = DCHelper.getInstance().getDCProperty(moinProject, MoinProject.PROP_MOIN_NAMESPACE,
//        					PROPERTY_NAME_METAMODEL_VERSION);
//        			if (metamodelVersion == null) {
//        				metamodelVersion = "1.0"; //$NON-NLS-1$
//        			}
//        
//        			buildFileProperties = new Properties();
//        			buildFileProperties.put(MmGenerator.CONTAINER, vendor + "/" + name); //$NON-NLS-1$
//        			buildFileProperties.put(MmGenerator.DC_DESCRIPTION, dcInfo.get(DCHelper.DESCRIPTION));
//        			buildFileProperties.put(MmGenerator.DC_NAME, name);
//        			buildFileProperties.put(MmGenerator.DC_VENDOR, vendor);
//        			buildFileProperties.put(MmGenerator.FACILITY_NAME, facility);
//        			buildFileProperties.put(MmGenerator.DC_VERSION, metamodelVersion);
//			}
		}

		return buildFileProperties;
	}

	private static IFolder getTargetMoinFolder(final IProject project) {
		IFolder folder = project.getFolder(MMBuilderConstants.XMI_SRC_PATH);
		if (folder.exists()) {
			folder = folder.getFolder(MMBuilderConstants.MOIN_FOLDER);
			if (folder.exists() && folder.isLinked()) {
				final IPath path = folder.getLocation();
				final IContainer[] containers = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocation(path);
				IFolder moinFolder = null;
				IProject moinProject = null;
				for (final IContainer container : containers) {
					if (container instanceof IFolder) {
						moinFolder = (IFolder) container;
						moinProject = moinFolder.getProject();
						if (!project.equals(moinProject)) {
							// Stop at first location that is not inside the
							// wrapper project
							return moinFolder;
						}
					}
				}
			}
		}

		return null;
	}

	private static String getMetamodelPartitionFilesSourcePath(final IProject project) {
		final IFolder xmiSrc = project.getFolder(MMBuilderConstants.XMI_SRC_PATH);
		if (xmiSrc.exists()) {
			IFolder moinsrc = xmiSrc.getFolder(MMBuilderConstants.MOIN_SRC_FOLDER);
			if (moinsrc.exists()) {
				return moinsrc.getLocation().toOSString();
			} else {
				// must be format where moin/meta is located directly
				// under the xmisrc
				IFolder moin = xmiSrc.getFolder(MMBuilderConstants.MOIN_FOLDER);
				if (moin.exists()) {
					if (xmiSrc.isLinked()) {
						// old format japro case
						return xmiSrc.getLocation().toOSString();
					} else {
						// DC case
						moin = getTargetMoinFolder(project);
						if (moin != null) {
							IContainer _compFolder = moin.getParent();
							if (_compFolder != null) {
								return _compFolder.getLocation().toOSString();
							}
						}
					}

				}
			}
		}

		throw new IllegalStateException(
				"Couldn't determine source path where metamodel partitions should be located for project " + project.getLocation().toOSString()); //$NON-NLS-1$
	}

	private static File[] getMetamodelPartitionFiles(final IProject project) throws CoreException {
		final XMIFileFinder visitor = new XMIFileFinder(getOutputLocation(project));
		project.accept(visitor);
		final String[] files = visitor.getXmiFilePaths();

		final File[] metamodelPartitionFiles = new File[files.length];
		for (int i = 0; i < files.length; i++) {
			metamodelPartitionFiles[i] = new File(files[i]);
		}

		return metamodelPartitionFiles;
	}

	static IFile[] getMetamodelPartitionIFiles(final IProject project) throws CoreException {
		final XMIFileFinder visitor = new XMIFileFinder(getOutputLocation(project));
		project.accept(visitor);
		List<IFile> xmiIFiles = visitor.getXmiIFiles();
		return xmiIFiles.toArray(new IFile[xmiIFiles.size()]);
	}

	private static boolean[] getAdditionalFlags(final IProject project) throws CoreException, IOException {
		// ignoreChecks=true since we do not want to abort the build due to some
		// (minor) constraint violations
		final boolean[] result = new boolean[] { true, false };

		final MmJaproBuildFinder mmJaproBuildFinder = new MmJaproBuildFinder(getOutputLocation(project));
		project.accept(mmJaproBuildFinder);
		File additionalBuildInfoPropertiesFile = mmJaproBuildFinder.getSubProjectPropFile();

		if (additionalBuildInfoPropertiesFile == null) {
			// wasn't found, could be a dc-japro project
			additionalBuildInfoPropertiesFile = getJaproDcBuildProperties(project);
		}

		if (additionalBuildInfoPropertiesFile != null && additionalBuildInfoPropertiesFile.exists()) {
			final Properties properties = new Properties();
			final FileInputStream inputStream = new FileInputStream(additionalBuildInfoPropertiesFile);
			properties.load(inputStream);
			inputStream.close();
			String propertyIgnoreChecks = properties.getProperty(MmGenerator.IGNORE_CHECKS);
			if (propertyIgnoreChecks != null) {
				result[0] = Boolean.parseBoolean(propertyIgnoreChecks);
			}
			result[1] = Boolean.parseBoolean(properties.getProperty(MmGenerator.GENERATE_MOF));
		}

		return result;
	}

	private static File getJaproDcBuildProperties(final IProject project) {
		final IFolder targetMoinFolder = getTargetMoinFolder(project);
		if (targetMoinFolder != null) {
			final IContainer parent = targetMoinFolder.getParent();
			// parent is the _comp folder
			if (parent != null) {
				final IContainer cfg = (IContainer) parent.findMember(MMBuilderConstants.CFG_FOLDER);
				if (cfg != null) {
					final IResource buildProperties = cfg.findMember(MMBuilderConstants.BUILD_PROPERTIES);
					if (buildProperties != null) {
						return new File(buildProperties.getLocation().toOSString());
					}
				}
			}
		}

		return null;
	}

	private static File getMmJaproBuildFile(final IProject project) throws JavaModelException, CoreException {

		final MmJaproBuildFinder mmJaproBuildFinder = new MmJaproBuildFinder(

		getOutputLocation(project));
		project.accept(mmJaproBuildFinder);
		return mmJaproBuildFinder.getJaproBuildFile();

	}

	private static class MmJaproBuildFinder implements IResourceVisitor {

		private File buildFile;
		private File subProjectPropFile;
		private IPath outputLocation;

		public File getJaproBuildFile() {
			return this.buildFile;
		}

		public File getSubProjectPropFile() {
			return this.subProjectPropFile;
		}

		public MmJaproBuildFinder(final IPath outputLocation) {
		    this.outputLocation = outputLocation;
		}

		public boolean visit(final IResource resource) {

			if (this.outputLocation != null) {
				if (this.outputLocation.isPrefixOf(resource.getFullPath())) {
					return true;
				}
			}

			if (resource.getType() == IResource.FOLDER && resource.getName().equals(MMBuilderConstants.MMR)) {
				final IContainer cfg = (IContainer) resource.getParent().findMember(MMBuilderConstants.CFG_FOLDER);
				if (cfg != null) {
					final IResource buildJapro = cfg.findMember(MMBuilderConstants.JAPRO_BUILD_FILENAME);
					final IResource subProject = cfg.findMember(MMBuilderConstants.SUB_PROP_FILENAME);
					if (buildJapro != null) {
						this.buildFile = new File(buildJapro.getLocation().toOSString());
					}

					if (subProject != null) {
						this.subProjectPropFile = new File(subProject.getLocation().toOSString());
					}

					return false;
				}
			}
			return true;
		}
	}

	@SuppressWarnings("deprecation")
	public static void convertXMIFiles(final IProject currentProject, final IProgressMonitor monitor) throws CoreException {

		if (!MetamodelBuildNature.isJaproProject(currentProject)) {
			return;
		}

		Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider = null;
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (final IProject project : projects) {
			if (project.isAccessible() && project.isNatureEnabled(MMBuilderConstants.NATURE_ID) && (!currentProject.equals(project))) {
				final Properties buildFileProperties = getMetamodelProperties(project);
				if (buildFileProperties != null) {
					if (additionalMetamodelsToConsider == null) {
						additionalMetamodelsToConsider = new ArrayList<MmGenerationBaseInfo>();
					}

					final IFolder xmiSrc = project.getFolder(MMBuilderConstants.XMI_SRC_PATH);
					if (xmiSrc == null || !xmiSrc.isAccessible()) {
						throw new IllegalStateException("xmisrc folder not found. Must be located under the project root."); //$NON-NLS-1$
					}

					final MmGenerationBaseInfo baseInfo = new MmGenerationBaseInfo(xmiSrc.getLocation().toOSString(), buildFileProperties
							.getProperty(MmGenerator.CONTAINER));
					additionalMetamodelsToConsider.add(baseInfo);
				} else {
					MetamodelBuilder.stracer.log(Level.SEVERE, ""); //$NON-NLS-1$ //TODO
				}
			}
		}

		String msg = NLS.bind(MMBuilderMessages.ConvertXMI_convertingFiles, currentProject.getName());
		monitor.subTask(msg);

		final Properties buildFileProperties = getMetamodelProperties(currentProject);
		if (buildFileProperties == null) {
			throw new IllegalStateException("Build file properties not found."); //$NON-NLS-1$ //TODO
		}

		final IFolder xmiSrc = currentProject.getFolder(MMBuilderConstants.XMI_SRC_PATH);
		boolean[] flags;
		try {
			flags = getAdditionalFlags(currentProject);
		} catch (final IOException e1) {
			throw new RuntimeException("Project not found due to IOException", e1); //$NON-NLS-1$
		}
		final boolean ignoreMetamodelChecks = flags[0];
		final boolean generateMof = flags[1];
		final MmExecutableInfo metamodelToBeConverted = new MmExecutableInfo(xmiSrc.getLocation().toOSString(), buildFileProperties
				.getProperty(MmGenerator.CONTAINER), generateMof, ignoreMetamodelChecks);

		MoinFactory.getMmGenerator().convertXmi(metamodelToBeConverted, additionalMetamodelsToConsider);

		msg = NLS.bind(MMBuilderMessages.ConvertXMI_refreshing, currentProject.getName());
		monitor.subTask(msg);
		currentProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

	// private void augmentManifest(IProject project, IProgressMonitor monitor)
	// {
	//
	// // get the manifest file
	//		IFile manifestFile = project.getFile("META-INF/MANIFEST.MF"); //$NON-NLS-1$
	//
	// InputStream is = null;
	// Manifest manifest = null;
	// try {
	//
	// // open stream
	// is = new FileInputStream(manifestFile.getRawLocation().toOSString());
	// manifest = new Manifest(is);
	//
	// } catch (Exception e) {
	//			stracer.log(Level.SEVERE, "Error while reading manifest file", e);//$NON-NLS-1$
	// // if manifest cannot be parsed, it makes no sense to continue
	// return;
	// } finally {
	// if (is != null) {
	// try {
	// is.close();
	// } catch (IOException e) {
	//					stracer.log(Level.SEVERE, "Error while closing input stream");//$NON-NLS-1$
	// }
	// }
	// }
	//
	// try {
	// // splits according to ',' including "aaa , bbb" , "aaa,bbb",
	// // "aaa,   bbb"
	// String entryString =
	// manifest.getMainAttributes().getValue(Constants.EXPORT_PACKAGE);
	//
	// Set<String> oldPackages;
	// if (entryString == null) {
	// oldPackages = new HashSet<String>(0);
	// } else {
	//				String[] oldEntries = entryString.split("\\s*,\\s*"); //$NON-NLS-1$
	// oldPackages = new HashSet<String>(Arrays.asList(oldEntries));
	// }
	// Set<String> newPackages = getPackages(project, monitor);
	//
	// // compare export entries and avoid manipulation file if nothing has
	// // changed
	// if (!(oldPackages.equals(newPackages))) {
	//
	// // try to check out file
	// IStatus status = ResourcesPlugin.getWorkspace().validateEdit(new IFile[]
	// { manifestFile }, null);
	// if (!status.isOK()) {
	//					stracer.log(Level.SEVERE, "Metamodelbuilder: Manifest file could not be checked out"); //$NON-NLS-1$
	// return;
	// }
	//
	// StringBuilder sb = new StringBuilder();
	// for (String string : newPackages) {
	// if (sb.length() != 0) {
	//						sb.append(",\n "); //$NON-NLS-1$
	// }
	// sb.append(string);
	// }
	// manifest.getMainAttributes().putValue(Constants.EXPORT_PACKAGE,
	// sb.toString());
	// // out = new
	// // FileOutputStream(file.getRawLocation().toOSString());
	// // manifest.write(out);
	// // out.flush();
	// formatAndWriteManifestFile(manifest, manifestFile, monitor);
	// }
	//
	// } catch (Exception e) {
	//			stracer.log(Level.SEVERE, "Error while setting export entry in manifest", e);//$NON-NLS-1$
	// }
	// }

	/**
	 * Writes the manifest to the file system.
	 *
	 * @param manifest
	 * @throws IOException
	 * @throws CoreException
	 */

	// private void formatAndWriteManifestFile(Manifest manifest, IFile
	// manifestFile, IProgressMonitor monitor)
	// throws IOException, CoreException {
	//
	// // get content from manifest object
	// ByteArrayOutputStream bos = new ByteArrayOutputStream();
	// try {
	// manifest.write(bos);
	// bos.flush();
	// } finally {
	// bos.close();
	// }
	//
	// ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
	// String fileContent = null;
	// try {
	// fileContent = streamToString(bais);
	// } finally {
	// bais.close();
	// }
	//
	// // format manifest content
	//		fileContent = fileContent.replaceAll("\n+ +", ""); //$NON-NLS-1$ //$NON-NLS-2$
	//		String[] parts = fileContent.split("\n"); //$NON-NLS-1$
	// StringBuilder formattedContent = new StringBuilder();
	// for (int i = 0; i < parts.length; i++) {
	//			String[] itemParts = parts[i].split(": "); //$NON-NLS-1$
	//			if (itemParts[0].equals("Export-Package") || itemParts[0].equals("Import-Package") || itemParts[0].equals("Require-Bundle")) { //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
	//				itemParts[1] = itemParts[1].replace(",", ",\n "); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	//			formattedContent.append(itemParts[0]).append(": ").append(itemParts[1]).append("\n"); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	//		formattedContent.append("\n"); //$NON-NLS-1$
	//
	// // write manifest content to file
	// InputStream is = new
	// ByteArrayInputStream(formattedContent.toString().getBytes());
	// try {
	// manifestFile.setContents(is, IFile.FORCE, monitor);
	// } finally {
	// is.close();
	// }
	// }
	public String streamToString(InputStream is) throws IOException {
		Reader fr = null;
		BufferedReader br = null;
		try {
			fr = new InputStreamReader(is, "utf-8"); //$NON-NLS-1$
			br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String s = ""; //$NON-NLS-1$
			while (null != (s = br.readLine())) {
				sb.append(s).append("\n"); //$NON-NLS-1$
			}
			return sb.toString();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
	}

	// private Set<String> getPackages(IProject project, IProgressMonitor
	// monitor) throws CoreException {
	//
	// Set<String> result = new HashSet<String>();
	// IJavaProject javaProject = JavaCore.create(project);
	// IClasspathEntry[] classpathEntries = javaProject.getRawClasspath();
	// for (IClasspathEntry classpathEntry : classpathEntries) {
	//
	// // inspect only real source folders, no jars, binaries etc
	// if (IClasspathEntry.CPE_SOURCE == classpathEntry.getEntryKind()) {
	// IPath[] exclusionPatterns = classpathEntry.getExclusionPatterns();
	// IPath folderPath = classpathEntry.getPath().removeFirstSegments(1);
	// IFolder folder = project.getFolder(folderPath);
	//
	// PackageFinder pf = new PackageFinder(exclusionPatterns);
	// folder.accept(pf);
	// result.addAll(pf.getPackages());
	// }
	// }
	// // return sorted set to avoid sorting at every add call
	// return new TreeSet<String>(result);
	// }

	// private Set<String> getPackages2(IProject project, IProgressMonitor
	// monitor) throws CoreException {
	//
	// IJavaProject javaProject = JavaCore.create(project);
	// long start = System.currentTimeMillis();
	// while (System.currentTimeMillis() - start < 10000) {
	// }
	//
	// Set<String> result = new HashSet<String>();
	// IPackageFragmentRoot[] packageFragmentRoots =
	// javaProject.getAllPackageFragmentRoots();
	// for (IPackageFragmentRoot packageFragmentRoot : packageFragmentRoots) {
	// if (!packageFragmentRoot.isArchive()) {
	// IJavaElement[] packages = packageFragmentRoot.getChildren();
	// for (IJavaElement javaElement : packages) {
	// if (javaElement instanceof IPackageFragment) {
	// IPackageFragment fragment = (IPackageFragment) javaElement;
	// Object[] nonJavaResources = fragment.getNonJavaResources();
	// if (fragment.containsJavaResources() || nonJavaResources.length > 0) {
	// result.add(fragment.getElementName());
	// }
	// }
	// }
	// }
	// }
	// return new TreeSet<String>(result);
	//
	// // PackageFinder pf = new PackageFinder();
	// // IFolder srcFolder =
	// project.getFolder(MMBuilderConstants.JMI_SRC_PATH);
	// // srcFolder.accept(pf);
	// // return pf.getPackages();
	// }

	// private static class PackageFinder implements IResourceVisitor {
	//
	// // at least two entries will be created, tc.moin and packageuuid
	// // use hashset for fast access
	// private final Set<String> packages = new HashSet<String>(2);
	//
	// private int rootSegmentCount = -1;
	// private final Set<String> exclusionPatternsSet;
	//
	// public Set<String> getPackages() {
	// return packages;
	// }
	//
	// public PackageFinder(IPath[] exclusionPatterns) {
	// if (exclusionPatterns.length > 0) {
	// this.exclusionPatternsSet = new
	// HashSet<String>(exclusionPatterns.length);
	// for (IPath path : exclusionPatterns) {
	// this.exclusionPatternsSet.add(path.removeTrailingSeparator().toPortableString());
	// }
	// } else {
	// exclusionPatternsSet = null;
	// }
	// }
	//
	// public boolean visit(final IResource resource) {
	// int segmentCount = resource.getProjectRelativePath().segmentCount();
	// if (rootSegmentCount == -1) {
	// // set the root segment count on first hit
	// // this makes it obsolete to hand over the root path in the
	// // constructor
	// rootSegmentCount = segmentCount;
	// }
	//
	// if (resource instanceof IFolder) {
	// if (exclusionPatternsSet != null) {
	// // get the last segment of the current folder
	// String segment = resource.getProjectRelativePath().segment(segmentCount -
	// 1);
	// if (exclusionPatternsSet.contains(segment)) {
	// // if it's excluded do not continue
	// return false;
	// }
	// }
	//
	// IResource[] members = null;
	// try {
	// members = ((IFolder) resource).members();
	// for (IResource member : members) {
	// if (!(member instanceof IFolder)) {
	// // this member is a file
	// IPath path = resource.getProjectRelativePath();
	//
	// // Remove leading segments so they won't pollute the
	// // package
	// // eg. project relative
	// // path="src/bla/blubb/com/sap/hugo.java"
	// // should result in package com.sap
	// path = path.removeFirstSegments(rootSegmentCount);
	// if (!path.isEmpty()) {
	// String packageName = path.toString();
	// packageName = packageName.replace('/', '.');
	// packages.add(packageName);
	// return true;
	// }
	// }
	// }
	// } catch (CoreException e) {
	//					stracer.log(Level.SEVERE, "MetamodelBuilder: error while getting folder members", e); //$NON-NLS-1$
	// }
	// }
	// return true;
	// }
	// }
}