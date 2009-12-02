package com.sap.tc.moin.incubation.mm.internal.resource;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
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
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.ExportPackageDescription;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.logging.Location;
import com.sap.tc.moin.incubation.mm.internal.Activator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerationBaseInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerationInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerator;
import com.sap.tc.moin.repository.jmigenerator.controller.MoinMMGeneration;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;

public final class MmBuilder extends IncrementalProjectBuilder {

	public static final String BUILDER_ID = "com.sap.tc.moin.metamodel.Builder"; //$NON-NLS-1$
	public static final String NATURE_ID = "com.sap.tc.moin.metamodel.BuildNature"; //$NON-NLS-1$
	public static final String MARKER_TYPE_PROBLEM = "com.sap.tc.moin.metamodel.problemMarker";
	public static final String MARKER_ATT_MISSING_PACKAGES = "missingPackageExports";

	public static final String JMI_SRC_PATH = "jmisrc"; //$NON-NLS-1$
	public static final String MOIN_FOLDER = "moin"; //$NON-NLS-1$
	public static final String MOIN_SRC_FOLDER = "moinsrc"; //$NON-NLS-1$
	public static final String JAVA_SRC_FOLDER = "java"; //$NON-NLS-1$
	public static final String MANIFEST_PATH = "META-INF/MANIFEST.MF";

	public static final String VENDOR_DEFAULT = "sap.com";

	static final String PACKAGELIST_SEPARATOR = "; ";

	@Override
	@SuppressWarnings("unchecked")
	protected IProject[] build(final int kind, final Map args, IProgressMonitor monitor) throws CoreException {
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
				final String msg = NLS.bind("Cleaning {0}", getProject().getName());
				monitor.subTask(msg);

				final IFolder srcFolder = getJmiFolder();
				if (srcFolder.exists()) {
					srcFolder.delete(true, false, monitor);
				}
				srcFolder.create(true, true, monitor);

				IResource manifest = getManifest(getProject());
				manifest.deleteMarkers(MARKER_TYPE_PROBLEM, false, IResource.DEPTH_INFINITE);
			}
		}, monitor);
		super.clean(monitor);
	}

	protected void fullBuild(IProgressMonitor monitor) throws CoreException {
		clean(monitor);

		final String msg = NLS.bind("Building {0}", getProject().getName());
		monitor.subTask(msg);

		List<IFile> partitionFiles = getMetamodelPartitionIFiles(getProject());
		createJmiJavaFiles(partitionFiles, monitor);
	}

	protected void incrementalBuild(final IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
		final String msg = NLS.bind("Building {0}", getProject().getName());
		monitor.subTask(msg);
		final XMIFileFinder visitor = new XMIFileFinder(getOutputLocation(getProject()));
		delta.accept(visitor);
		if (visitor.hasRelevantChanges()) {
			fullBuild(monitor);
		}
	}

	private static IPath getOutputLocation(final IProject project) throws CoreException {
		if (project.isOpen() && project.hasNature(JavaCore.NATURE_ID)) {
			final IJavaProject javaProject = JavaCore.create(project);
			return javaProject.getOutputLocation();
		}

		return null;
	}

	private IFolder getJmiFolder() {
		final IFolder srcFolder = getProject().getFolder(MmBuilder.JMI_SRC_PATH);
		return srcFolder;
	}

	@SuppressWarnings("deprecation")
	private void createJmiJavaFiles(final List<IFile> partitionFiles, final IProgressMonitor monitor) throws CoreException {
		IProject project = getProject();

		IPath jmiFolderPath = getJmiFolder().getLocation();

		Collection<MmGenerationBaseInfo> additionalMetamodelsToConsider = null;
		final Properties buildFileProperties = getMetamodelProperties(project);
		if (buildFileProperties == null) {
			throw new IllegalStateException("Metamodel information could not be found"); //$NON-NLS-1$
		}

		if (additionalMetamodelsToConsider == null) {
			additionalMetamodelsToConsider = new ArrayList<MmGenerationBaseInfo>();
		}

		IFolder moinFolder = getTargetMoinFolder(project);
		if (moinFolder == null) {
			return;
		}
		String containerName = buildFileProperties.getProperty(MmGenerator.CONTAINER);
		final MmGenerationBaseInfo baseInfo = new MmGenerationBaseInfo(moinFolder.getLocation().toOSString(), containerName);
		additionalMetamodelsToConsider.add(baseInfo);

		IPath outputPath = project.getLocation().append(getOutputLocation(project).removeFirstSegments(1));
		final File outputLocation = new File(outputPath.toOSString());

		try {
			String metamodelPartitionFilesSourcePath = getMetamodelPartitionFilesSourcePath(project);
			File[] files = new File[partitionFiles.size()];
			for (int i = 0; i < files.length; i++) {
				files[i] = new File(partitionFiles.get(i).getLocation().toOSString());
			}
			final File jmiFolder = new File(jmiFolderPath.toOSString());
			MoinFactory.getMmGenerator().generate(
					new MmGenerationInfo(metamodelPartitionFilesSourcePath, files, jmiFolder, outputLocation, buildFileProperties, false,
							false), additionalMetamodelsToConsider);
		} catch (final IllegalStateException e) { // $JL-EXC$
			// This is a hack since the generation above crashes due to its own
			// misconfigured connection. However, we need the partial results
			// (moinarch.properties...). Fix is to call the underlying code
			// generator directly.
			MoinMMGeneration generation = completeBuild(project, jmiFolderPath, containerName, partitionFiles);

			String msg = NLS.bind("Refreshing {0}", project.getName());
			monitor.subTask(msg);
			getJmiFolder().refreshLocal(IResource.DEPTH_INFINITE, monitor);

			// For some reasons the Java model is not uptodate after the
			// previous refresh on clean builds, which leads to PDE's manifest
			// validator (a successor builder) to yield some "exported
			// packages are not existing" markers. Fix is to checkpoint here
			// leading to resource change events being broadcasted. This
			// apparently makes the Java model consistent.
			project.getWorkspace().checkpoint(false);

			markMissingPackageExports(project, generation.getGeneratedPathFragments());
		} catch (final Exception e) {
			Activator.error("Exception during jmi java file generation", e, Location.getLocation(this)); //$NON-NLS-1$
		}
	}

	private static Properties getMetamodelProperties(final IProject project) throws CoreException {
		IPluginBase plugin = PluginRegistry.findModel(project).getPluginBase();
		String name = plugin.getId();
		String vendor = plugin.getProviderName();
		String desc = plugin.getName();

		Properties buildFileProperties = new Properties();
		buildFileProperties.put(MmGenerator.CONTAINER, getContainerName(name, vendor));
		buildFileProperties.put(MmGenerator.DC_DESCRIPTION, desc);
		buildFileProperties.put(MmGenerator.DC_NAME, name);
		buildFileProperties.put(MmGenerator.DC_VENDOR, vendor != null ? vendor : VENDOR_DEFAULT);
		buildFileProperties.put(MmGenerator.DC_VERSION, plugin.getVersion());
		buildFileProperties.put(MmGenerator.FACILITY_NAME, "PF"); //$NON-NLS-1$

		return buildFileProperties;
	}

	private static IFolder getTargetMoinFolder(final IProject project) {
		IFolder folder = project.getFolder(MOIN_FOLDER + "/meta");
		if (folder.exists()) {
			return folder;
		}

		return null;
	}

	private static String getMetamodelPartitionFilesSourcePath(final IProject project) throws CoreException {
		return getTargetMoinFolder(project).getLocation().toString();
	}

	static List<IFile> getMetamodelPartitionIFiles(final IProject project) throws CoreException {
		final XMIFileFinder visitor = new XMIFileFinder(getOutputLocation(project));
		project.accept(visitor);
		List<IFile> xmiFiles = visitor.getPartitionFiles();
		return xmiFiles;
	}

	public static String getContainerName(String name, String vendor) {
		if (vendor == null || vendor.length() == 0) {
			vendor = VENDOR_DEFAULT;
		}
		return vendor.trim() + "/" + name.trim(); //$NON-NLS-1$
	}

	private MoinMMGeneration completeBuild(IProject project, IPath outputLocation, String containerName, List<IFile> xmiFiles) {
		Connection connection = ConnectionManager.getInstance().createConnection(project);
		connection.setLabel(NLS.bind("JMI generation for {0}", project.getName()));

		try {
			MoinMMGeneration generation = new MoinMMGeneration(null, null);
			generation.setDestPathJmi(outputLocation.toOSString());
			generation.setGenerateMof(false);
			// ignoreChecks=true since we do not want to abort the build due to some
			// (minor) constraint violations
			generation.setIgnoreMetamodelCheck(true);

			Set<ModelPartition> mps = new HashSet<ModelPartition>();
			for (IFile file : xmiFiles) {
				PRI pri = ModelAdapter.getInstance().getPri(file, connection);
				ModelPartition partition = connection.getPartition(pri);
				if (partition != null) {
					mps.add(partition);
				}
			}

			generation.execute(connection, mps, containerName);
			return generation;
		} finally {
			connection.close();
		}
	}

	private void markMissingPackageExports(IProject project, Set<List<String>> mmPackages) throws CoreException {
		BundleDescription bundleDescription = PluginRegistry.findModel(project).getBundleDescription();
		if (bundleDescription == null) {
			// may happen for corrupt manifest files
			return;
		}

		ExportPackageDescription[] exportPackages = bundleDescription.getExportPackages();
		Set<String> exportedPackageNames = new HashSet<String>(exportPackages.length);
		for (ExportPackageDescription pack : exportPackages) {
			exportedPackageNames.add(pack.getName());
		}

		IJavaProject javaProject = JavaCore.create(project);

		StringBuilder missingPackages = new StringBuilder();
		for (List<String> mmPackageList : mmPackages) {
			StringBuilder packBuilder = new StringBuilder();
			for (Iterator<String> iterator = mmPackageList.iterator(); iterator.hasNext();) {
				String pack = iterator.next();
				packBuilder.append(pack);
				if (iterator.hasNext()) {
					packBuilder.append('.');
				}
			}

			String packString = packBuilder.toString();
			if (!exportedPackageNames.contains(packString) && isJavaPackage(packString, project, javaProject)) {
				missingPackages.append(packString).append(PACKAGELIST_SEPARATOR);
			}
		}

		if (missingPackages.length() == 0) {
			return;
		}

		IFile manifest = getManifest(project);
		IMarker marker = manifest.createMarker(MARKER_TYPE_PROBLEM);
		String[] attNames = new String[] { IMarker.SEVERITY, IMarker.MESSAGE, MARKER_ATT_MISSING_PACKAGES };
		String msg = NLS.bind("The following metamodel packages are not exported in plugin's manifest: {0}", missingPackages.substring(0,
				missingPackages.length() - PACKAGELIST_SEPARATOR.length()));
		Object[] attValues = new Object[] { IMarker.SEVERITY_ERROR, msg, missingPackages.toString()};
		marker.setAttributes(attNames, attValues);
	}

	private boolean isJavaPackage(String packageName, IProject project, IJavaProject javaProject) throws CoreException {
		IPath packPath = project.getFolder(JMI_SRC_PATH).getFullPath().append(packageName.replace('.', '/'));
		IPackageFragment packageFragment = javaProject.findPackageFragment(packPath);
		if (packageFragment != null && packageFragment.containsJavaResources()) {
			return true;
		}
		return false;
	}

	private IFile getManifest(IProject project) {
		IFile manifest = (IFile) project.findMember(MANIFEST_PATH);
		return manifest;
	}

	private static final class XMIFileFinder implements IResourceVisitor, IResourceDeltaVisitor {

		private final IPath outputLocation;
		private final List<IFile> xmiIFiles = new ArrayList<IFile>();
		private final List<IFile> relevantFiles = new ArrayList<IFile>();

		/**
		 * @return the xmiIFiles
		 */
		public List<IFile> getPartitionFiles() {
			return xmiIFiles;
		}

		public XMIFileFinder(final IPath outputLocation) {
			this.outputLocation = outputLocation;
		}

		public boolean visit(final IResource resource) {
			if (this.outputLocation != null && this.outputLocation.isPrefixOf(resource.getFullPath())) {
				return true;
			}
			if (resource.exists() && resource instanceof IFile) {
				if (MetaModelCatalog.META_MODEL_EXTENSION.equals("." + resource.getFileExtension())) {
					this.xmiIFiles.add((IFile) resource);
					this.relevantFiles.add((IFile) resource);
				}
				IPath filePath = resource.getProjectRelativePath();
				if (filePath.equals(new Path(MANIFEST_PATH))) {
					this.relevantFiles.add((IFile) resource);
					return false;
				}
				if (filePath.equals(new Path("plugin.xml"))) {
					this.relevantFiles.add((IFile) resource);
					return false;
				}
			}
			// return true to continue visiting children.
			return true;
		}

		public boolean visit(final IResourceDelta delta) throws CoreException {
			if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
				final IResource resource = delta.getResource();
				if (this.outputLocation != null && this.outputLocation.isPrefixOf(resource.getFullPath())) {
					return true;
				}
				if (resource.exists() && resource instanceof IFile) {
					if (MetaModelCatalog.META_MODEL_EXTENSION.equals("." + resource.getFileExtension())) {
						this.xmiIFiles.add((IFile) resource);
						this.relevantFiles.add((IFile) resource);
						// for now we can return here since a full build will be
						// triggered anyway
						// TODO remove when increment build is available
						return false;
					}
					IPath filePath = resource.getProjectRelativePath();
					if (filePath.equals(new Path(MANIFEST_PATH))) {
						this.relevantFiles.add((IFile) resource);
						return false;
					}
					if (filePath.equals(new Path("plugin.xml"))) {
						this.relevantFiles.add((IFile) resource);
						return false;
					}
				}
			}
			// return true to continue visiting children.
			return true;
		}

		public boolean hasRelevantChanges() {
			return relevantFiles.size() > 0;
		}

	}

}
