package com.sap.mi.fwk.ui.test.helper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.tools.services.ui.dialog.MessageDialogWithRadioButtons;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.services.local.ZipService;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Migrates all partitions in a number of projects. Also considers zip files.
 * 
 * @author d031150
 */
public final class MigratePartitionsAction extends AbstractHandler {

	private static final Logger stracer = Logger.getLogger(MigratePartitionsAction.class);

	private final Set<IProject> mTmpProjects = new HashSet<IProject>(2);

	private int mMode;

	private Connection mConnectionToSave;

	public MigratePartitionsAction() {
		super();
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart targetPart = HandlerUtil.getActivePartChecked(event);
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);

		Object[] selectionElements = selection.toArray();
		final List<IProject> projects = new ArrayList<IProject>(selectionElements.length);
		for (Object element : selectionElements) {
			if (element instanceof IProject)
				projects.add((IProject) element);
		}

		String msg = "This touches all partitions in the project, including all archives in the project. "
				+ "What do you want to do?";
		String[] options = new String[] { "Only &touch partitions", "Change &MOF ids of all elements" };
		MessageDialogWithRadioButtons dialog = new MessageDialogWithRadioButtons(targetPart.getSite().getShell(),
				"Migrate Partitions", null, msg, MessageDialog.QUESTION, new String[] { IDialogConstants.OK_LABEL,
						IDialogConstants.CANCEL_LABEL }, 0, options, 0);
		if (dialog.open() != Window.OK)
			return null;
		mMode = dialog.getSelectedAlternative();

		// trigger migrate in background with blocking dialog
		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				if (monitor == null)
					monitor = new NullProgressMonitor();
				try {
					monitor.beginTask("Migrating...", projects.size() * 20);
					try {
						// use workspace runnable to not let builders run after
						// each file change
						ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
							public void run(IProgressMonitor monitor) throws CoreException {
								for (IProject project : projects) {
									migrateProject(project, null, new SubProgressMonitor(monitor, 10));
									migrateArchives(project, new SubProgressMonitor(monitor, 10));
								}
								// delete temporary projects
								for (IProject p : mTmpProjects) {
									if (p.exists())
										p.delete(true, monitor);
								}
								mTmpProjects.clear();
							}
						}, monitor);
					} catch (CoreException e) {
						throw new InvocationTargetException(e);
					}
				} finally {
					monitor.done();
				}
			}
		};

		try {
			IWorkbench workbench = targetPart.getSite().getWorkbenchWindow().getWorkbench();
			workbench.getProgressService().busyCursorWhile(op);

			if (mConnectionToSave != null) {
				ConnectionManagerUI.getInstance().save(mConnectionToSave,
						ModelAdapterUI.getInstance().getProject(mConnectionToSave), null);
			}
		} catch (InvocationTargetException e) { // $JL-EXC$
			Throwable cause = e.getCause();
			MiFwkUIPlugin.showErrorDialog(cause, "Migration failed", "Error in Migration", sTracer);
		} catch (InterruptedException e) { // $JL-EXC$
		} catch (OperationCanceledException e) { // $JL-EXC$
		}

		return null;
	}

	private void migrateProject(IProject project, String archiveHint, IProgressMonitor monitor) throws CoreException {
		Connection connection = ConnectionManager.getInstance().createConnection(project);
		try {
			IStatus result = ModelManager.getInstance().refreshFromFileSystem(project, monitor);
			if (!result.isOK()) {
				if (IStatus.CANCEL == result.getSeverity())
					throw new OperationCanceledException();
				else
					throw new CoreException(result);
			}
			migratePartitions(project, connection, archiveHint, monitor);
		} catch (PartitionsNotSavedException e) {
			IStatus status = MiFwkUIPlugin.createStatus(IStatus.ERROR, e.getMessage(), e);
			throw new CoreException(status);
		} finally {
			if (!connection.isDirty())
				connection.close();
		}
	}

	private void migratePartitions(IProject project, final Connection connection, String archiveHint,
			IProgressMonitor monitor) throws PartitionsNotSavedException {
		final Collection<PRI> partitions = PartitionService.getInstance().getPartitions(connection, project);
		if (partitions.isEmpty())
			return;
		if (archiveHint == null)
			monitor.beginTask(project.getName(), partitions.size());

		switch (mMode) {
		case 0:
			touchPartitions(partitions, connection, archiveHint, monitor);
			break;
		case 1:
			changeMofIds(partitions, connection, project, archiveHint, monitor);
			break;
		default:
			throw new IllegalStateException("Unknown option: " + mMode);
		}

		if (archiveHint == null)
			monitor.done();
	}

	private void touchPartitions(final Collection<PRI> partitions, final Connection connection, String archiveHint,
			IProgressMonitor monitor) throws PartitionsNotSavedException {
		for (PRI pri : partitions) {
			if (monitor.isCanceled())
				throw new OperationCanceledException();
			String taskName = pri.getPartitionName();
			if (archiveHint != null)
				taskName += " [" + archiveHint + "]";
			monitor.subTask(taskName);
			ModelPartition partition = connection.getPartition(pri);
			Tag someTag = connection.createElement( Tag.class );
			partition.assignElement(someTag);
			ConnectionManager.getInstance().save(connection);
			someTag.refDelete();
			ConnectionManager.getInstance().save(connection);

			monitor.worked(1);
		}
	}

	private void changeMofIds(final Collection<PRI> partitions, final Connection connection, IProject project,
			String archiveHint, IProgressMonitor monitor) throws PartitionsNotSavedException {
		Collection<RefObject> elements = new ArrayList<RefObject>();
		for (PRI pri : partitions) {
			if (monitor.isCanceled())
				throw new OperationCanceledException();
			String taskName = pri.getPartitionName();
			if (archiveHint != null)
				taskName += " [" + archiveHint + "]";
			monitor.subTask(taskName);

			// duplicate all root elements and delete originals
			ModelPartition partition = connection.getPartition(pri);
			Collection<Partitionable> rootElements = PartitionService.getInstance().getRootElements(partition);
			for (Partitionable p : rootElements)
				elements.add((RefObject) p);
		}

		DeepCopyResultSet copyResult = connection.deepCopy(elements, null, false);
		Map<MRI, MRI> inverseMriMappingTable = copyResult.getInverseMriMappingTable();
		Collection<Partitionable> nullElements = connection.getNullPartition().getElements();
		for (Partitionable newElement : nullElements) {
			MRI mri = inverseMriMappingTable.get(newElement.get___Mri());
			if (mri == null) {
				System.err.println("No orginal element found for "
						+ ModelManager.getInstance().getObjectNameAttribute((RefObject) newElement));
				continue;
			}
			PRI pri = mri.getPri();
			connection.getPartition(pri).assignElement(newElement);
		}
		for (RefObject e : elements)
			e.refDelete();

		mConnectionToSave = connection;
	}

	private void migrateArchives(IProject project, IProgressMonitor monitor) throws CoreException {
		ProjectVisitor visitor = new ProjectVisitor();
		project.accept(visitor);
		if (visitor.zips.isEmpty())
			return;

		for (IFile zip : visitor.zips) {
			if (monitor.isCanceled())
				throw new OperationCanceledException();
			try {
				ResourceAttributes atts = zip.getResourceAttributes();
				if (atts.isReadOnly()) {
					atts.setReadOnly(false);
					zip.setResourceAttributes(atts);
				}

				String targetDcType = determineDcType(zip);
				IProject targetProject = createMigrationProject(zip.getProject(), targetDcType);
				String targetDirectory = targetProject.getLocation().toOSString();
				String zipLocation = zip.getLocation().toOSString();

				ZipService.unzipDir(zipLocation, targetDirectory);

				migrateProject(targetProject, zip.getProjectRelativePath().toString(), monitor);

				String srcDir = getSourceFolderLocations(targetProject)[0].toOSString();
				ZipService.zipDir(new File(zipLocation), new File(srcDir), new File(targetProject.getLocation()
						.toOSString()));

				project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			} catch (IOException e) {
				IStatus status = MiFwkUIPlugin.createStatus(IStatus.ERROR, "Error while processing archive "
						+ zip.getProjectRelativePath(), e);
				throw new CoreException(status);
			}
		}

		monitor.done();
	}

	private IProject createMigrationProject(IProject source, String dcTypeName) throws CoreException {
		IDevelopmentComponent srcDc = DiiResourceService.getDevelopmentComponent(source);
		if (srcDc == null)
			return null;
		String dcName = "mig/tmp/" + dcTypeName.replace('.', '/');
		IDevelopmentComponent dc = MoinProject.getLocalDC(dcName, MoinProject.VENDOR_SAP);
		if (dc != null)
			MoinProject.deleteLocalDc(dc, true, null);
		IComponentType dcType = MoinProject.getDcType(dcTypeName, MoinProject.VENDOR_SAP, null);
		IProject dcProject = MoinProject.createLocalDc(dcName, MoinProject.VENDOR_SAP, dcType, null);
		mTmpProjects.add(dcProject);
		return dcProject;
	}

	private String determineDcType(IFile zipFile) throws IOException {
		ZipFile f = new ZipFile(zipFile.getLocation().toOSString());
		try {
			Enumeration<? extends ZipEntry> e = f.entries();
			while (e.hasMoreElements()) {
				ZipEntry en = e.nextElement();
				String dirEntry = en.getName();
				if (en.isDirectory()) {
					if (dirEntry.contains("meta"))
						return "com.sap.tc.moin.nwdi.dctype.mm";
				}
				// not a directory entry, but one for a file with some name like
				// "moin\meta\file.xmi"
				else if (dirEntry.contains("moin") && dirEntry.contains("meta")) {
					return "com.sap.tc.moin.nwdi.dctype.mm";
				}
			}
			return "com.sap.tc.moin.nwdi.dctype.Moin";
		} finally {
			try {
				f.close();
			} catch (IOException e) { // $JL-EXC$
			}
		}
	}

	/**
	 * Returns the <em>absolute</em> paths to the source folders of the given
	 * project. Note that only the paths registered at Dii are taken into
	 * account, potential Java source folders are ignored.
	 * 
	 * @param project
	 *            the project whose source folders are to be queried
	 * @return the absolute paths to the source folders
	 */
	private IPath[] getSourceFolderLocations(IProject project) {
		IPath[] folders = ModelManager.getInstance().getMoinResourceFolders(project);
		IPath[] locations = new IPath[folders.length];
		for (int i = 0; i < folders.length; i++) {
			IResource folder = project.findMember(folders[i]);
			locations[i] = folder.getLocation();
		}
		return locations;
	}

	private static final class ProjectVisitor implements IResourceVisitor {
		final List<IFile> zips = new ArrayList<IFile>();

		public boolean visit(IResource resource) throws CoreException {
			if (resource == null || !resource.exists() || resource.getType() != IResource.FILE)
				return true;
			String extension = resource.getFileExtension();
			if (!"zip".equals(extension) && !"zap".equals(extension))
				return true;
			zips.add((IFile) resource);
			return false;
		}
	}
}
