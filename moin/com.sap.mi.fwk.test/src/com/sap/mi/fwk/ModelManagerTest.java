package com.sap.mi.fwk;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;

import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.Window;
import com.sap.ide.metamodel.webdynpro.component.viewset.ViewUsage;
import com.sap.ide.metamodel.webdynpro.component.viewset.ViewsetPackage;
import com.sap.mi.fwk.ModelManager.IMoinOpRunnable;
import com.sap.mi.fwk.dcfwk.MoinFolderInfo;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.internal.MiFwkPlugin;
import com.sap.mi.fwk.test.TestDcType;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link ModelManager}
 * 
 * @author d031150
 */
public final class ModelManagerTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/modelmanager";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap");
	private final ModelManager mModelManager;
	private Connection mConnection;

	public ModelManagerTest() {
		super(DC_NAME);
		mModelManager = ModelManager.getInstance();
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected IComponentType getDcType() {
		return MoinProject.getDcType(TestDcType.DC_TYPE_ID, null, null);
	}

	@Override
	protected InputStream getProjectContentAsStream() {
		return ModelManagerTest.class.getResourceAsStream("ModelManagerTestData.zap");
	}

	@Override
	protected void setUp() throws Exception {
		if (Display.getCurrent() != null) {
			throw new IllegalStateException("Test must not be executed in the UI thread");
		}

		super.setUp();
		mConnection = createConnection();
	}

	@SuppressWarnings("deprecation")
	public void testRefreshFromFileSystem() {
		IProject project = getProject();

		// Create a new partition, assign an element, save.
		// Then delete the partition file directly, refresh and check
		// whether partition is alive.
		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("partition"));
		final ModelPartition partition = mConnection.createPartition(pri);
		Component componentInNewPart = createComponent();
		partition.assignElement(componentInNewPart);

		assertConnectionSave(mConnection, true);

		IFile iFile = ModelAdapter.getInstance().getFile(componentInNewPart);
		assertNotNull("No file for partition: " + pri, iFile);

		// Wait for partition to get alive (MOIN notification may take a while -
		// without waiting the partition will not yet be alive although the file
		// has already been deleted)
		while (!partition.isAlive()) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				fail(e);
			}
		}
		final File file = new File(iFile.getLocation().toOSString());

		// Wrap the deletion of the file and the check for the partition being
		// alive into a workspace runnable in order to avoid in between resource
		// update notifications to MOIN
		try {
			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
				public void run(IProgressMonitor monitor) throws CoreException {
					boolean success = file.delete();
					assertTrue("File has not been deleted: " + file, success);
					// before refresh: Moin still thinks partition is alive
					assertTrue("Partition must be alive", partition.isAlive());
				}
			}, iFile, IWorkspace.AVOID_UPDATE, null);
		} catch (CoreException e) {
			fail(e);
		}

		mModelManager.refreshFromFileSystem(project);

		// created partition is not alive
		// TODO [Projects] Check whether this test still fails
		// and whether this is correct.
		// assertFalse("Partition must not be alive", partition.isAlive());
	}

	public void testRefreshFromFileSystemNegative() {
		IProject project = getProject();
		final Component oldComponent = getComponent();

		// Also create an object in the old partition transiently (use case
		// of an unsaved editor).
		// Check whether object is alive after refresh.
		Component componentInOldPart = createComponent();
		((Partitionable) oldComponent).get___Partition().assignElement(componentInOldPart);

		mModelManager.refreshFromFileSystem(project, null);
		assertTrue("Dirty partitions expected: " + ModelManager.getPartitionService().getDirtyPartitions(mConnection).toArray(),
				mConnection.isDirty());
		assertTrue("Newly created object must still be valid", componentInOldPart.is___Alive());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIsMoinProject() {
		boolean isMoinProject = mModelManager.isMoinProject(getProject());
		assertTrue("Project is not a Moin project", isMoinProject);
	}

	public void testIsMoinProjectInitialized() {
		boolean isMoinProject = mModelManager.isMoinProjectInitialized(getProject());
		assertTrue("Project is not a Moin project", isMoinProject);
	}

	public void testGetResourceFolders() throws Exception {
		List<IPath> resourceFolders = Arrays.asList(mModelManager.getMoinResourceFolders(getProject()));
		for (MoinFolderInfo folder : TestDcType.RESOURCE_FOLDERS) {
			IPath path = folder.getPath();
			assertTrue("Resource folders must contain '" + path + "': " + resourceFolders, resourceFolders.contains(path));
		}
	}

	public void testGetObjectName() {
		Component component = getComponent();
		ViewsetPackage viewSetPack = mConnection.getPackage(ViewsetPackage.PACKAGE_DESCRIPTOR);
		ViewUsage usage = (ViewUsage) viewSetPack.getViewUsage().refCreateInstance();

		String objectName = mModelManager.getObjectName(component);
		assertEquals("Component name expected", component.getName(), objectName);

		usage.setId("viewUsageId");
		objectName = mModelManager.getObjectName(usage);
		assertEquals("ViewUsage id expected", usage.getId(), objectName);

		usage.setName("viewUsageName");
		objectName = mModelManager.getObjectName(usage);
		assertEquals("ViewUsage name expected", usage.getName(), objectName);

		Window window = (Window) ((ComponentPackage) component.refImmediatePackage()).getWindow().refCreateInstance();
		objectName = mModelManager.getObjectName(window);
		String mofId = ((Partitionable) window).get___Mri().getMofId();
		assertEquals("Window Mof Id expected", mofId, objectName);
	}

	/**
	 * Dedicated test for {@link ModelManager#runMoinOpWithResourceLock()} due
	 * to its complexity. Implicitly covered via calls to
	 * {@link ModelManager#refreshFromFileSystem(IProject, IProgressMonitor)}
	 * and {@link ConnectionManager#createConnection(IProject)}.
	 */
	public void testRunMoinOpWithLock() throws Exception {
		final IProject project = getProject();
		final IMoinOpRunnable<Object> nop = new IMoinOpRunnable<Object>() {
			public Object run(ContainerInitializationState initState) throws InvocationTargetException, InterruptedException {
				return this;
			}
		};

		// tests the normal execution without exception
		{
			IProgressMonitor monitor = new TestProgressMonitor();
			Object result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.INITIALIZED, nop, monitor);
			assertEquals("Operation's result expected", nop, result);
		}

		// tests exception is thrown in case of a failing
		// operation
		{
			final IMoinOpRunnable<Object> failingOpWithUncheckedException = new IMoinOpRunnable<Object>() {
				public Object run(ContainerInitializationState initState) throws InvocationTargetException, InterruptedException {
					throw new RuntimeException("Intentionally fails");
				}
			};
			final IMoinOpRunnable<Object> failingOpWithError = new IMoinOpRunnable<Object>() {
				public Object run(ContainerInitializationState initState) throws InvocationTargetException, InterruptedException {
					throw new Error("Intentionally fails");
				}
			};

			IProgressMonitor monitor = new TestProgressMonitor();
			try {
				Object result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.INITIALIZED,
						failingOpWithUncheckedException, monitor);
				fail("Exception expected. Result: " + result);
			} catch (RuntimeException expected) {
			}
			try {
				Object result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.INITIALIZED,
						failingOpWithError, monitor);
				fail("Error expected. Result: " + result);
			} catch (Error expected) {
			}
		}

		// tests whether a cancellation of a Moin op issues an
		// OperationCanceledException
		{
			final IMoinOpRunnable<Object> cancelledOp = new IMoinOpRunnable<Object>() {
				public Object run(ContainerInitializationState initState) throws InvocationTargetException, InterruptedException {
					throw new OperationCanceledException("Intentionally cancelled");
				}
			};
			try {
				IProgressMonitor monitor = new TestProgressMonitor();
				Object result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.INITIALIZED, cancelledOp,
						monitor);
				fail("InterruptedException expected after cancellation. Result: " + result);
			} catch (OperationCanceledException expected) {
			}
		}

		// Tests whether a cancellation of the *progress monitor* of the Moin
		// op issues an OperationCanceledException. The call to
		// monitor.setCanceled(true) simulates a user's pressing the cancel
		// button in the IDE's Job-blocking dialog.
		{
			final CountDownLatch startLatch = new CountDownLatch(1);
			final CountDownLatch stopLatch = new CountDownLatch(1);
			Job job = new Job("Test job locking project " + project.getName()) {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					// send run signal
					startLatch.countDown();

					// wait for the stop signal
					try {
						stopLatch.await(3000, TimeUnit.MILLISECONDS);
						return Status.OK_STATUS;
					} catch (InterruptedException e) {
						return MiFwkPlugin.createStatus(IStatus.ERROR, "Interrupted", e);
					}
				}

			};
			// use project as rule to enforce conflict with operation below
			job.setRule(project);
			job.schedule();

			// wait for the job to run
			startLatch.await(3000, TimeUnit.MILLISECONDS);

			try {
				// Instrument the monitor to always answer isCanceled=true
				// since ModalContext first calls setCanceled(false) on any
				// passed monitor.
				TestProgressMonitor monitor = new TestProgressMonitor();
				monitor.setAlwaysCanceled(true);
				// use CLIENT_SPEC_ONLY_INITIALIZED to enforce a project rule
				Object result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.CLIENT_SPEC_ONLY_INITIALIZED,
						nop, monitor);
				fail("OperationCanceledException expected after cancellation. Result: " + result);
			} catch (OperationCanceledException expected) {
			} finally {
				// make sure our job ends also in case of failures
				stopLatch.countDown();
			}
		}
	}

	/**
	 * Tests ModalContext variant of
	 * {@link ModelManager#runMoinOpWithResourceLock()} if called from UI thread
	 */
	public void testRunMoinOpWithLock_ModalContext() throws Exception {
		final IProject project = getProject();
		LShell shell = FactoryBuilder.newAbbotFactory().getShell(Display.getDefault());
		final IMoinOpRunnable<Object> nop = new IMoinOpRunnable<Object>() {
			public Object run(ContainerInitializationState initState) throws InvocationTargetException, InterruptedException {
				return this;
			}
		};

		// tests execution in the UI thread
		{
			shell.syncExec(new LRunnable<Object>() {
				public Object run() throws Exception {
					Object result = null;
					try {
						result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.INITIALIZED, nop, null);
						fail("Exception expected. Result: " + result);
					} catch (IllegalStateException expected) {
					}
					return result;
				}
			});
		}

		// tests exception is thrown in case of a failing operation
		{
			final IMoinOpRunnable<Object> failingOpWithUncheckedException = new IMoinOpRunnable<Object>() {
				public Object run(ContainerInitializationState initState) throws InvocationTargetException, InterruptedException {
					throw new RuntimeException("Intentionally fails");
				}
			};
			final IMoinOpRunnable<Object> failingOpWithCheckedException = new IMoinOpRunnable<Object>() {
				public Object run(ContainerInitializationState initState) throws InvocationTargetException, InterruptedException {
					Throwable cause = new ClassNotFoundException("Intentionally fails");
					throw new InvocationTargetException(cause);
				}
			};
			shell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					try {
						Object result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.INITIALIZED,
								failingOpWithUncheckedException, null);
						fail("Exception expected. Result: " + result);
					} catch (RuntimeException expected) {
					}
					// use a checked exception for the cause this time
					try {
						Object result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.INITIALIZED,
								failingOpWithCheckedException, null);
						fail("Exception expected. Result: " + result);
					} catch (RuntimeException expected) {
					}
					return null;
				}
			});
		}

		// tests exception is thrown for execution in the UI thread holding a
		// resource lock
		{
			shell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {
						public void run(IProgressMonitor monitor) throws CoreException {
							try {
								Object result = ModelManager.runMoinOpWithResourceLock(project, ContainerInitializationState.INITIALIZED,
										nop, monitor);
								fail("Exception expected for execution in resource-locked main thread. Result: " + result);
							} catch (RuntimeException expected) {
							}
						}
					}, project, IWorkspace.AVOID_UPDATE, null);
					return null;
				}
			});
		}
	}

	private Component getComponent() {
		List<Component> components = QueryService.getInstance().queryInstances(getProject(), mConnection, CONTAINER_NAME_WEBDYNPRO,
				TYPE_NAME_COMPONENT);
		assertTrue("No Component found in " + components, components.size() > 0);
		return components.get(0);
	}

	private Component createComponent() {
		RefClass componentClass = getComponent().refClass();
		return (Component) componentClass.refCreateInstance();
	}

	private static final class TestProgressMonitor implements IProgressMonitor {

		private volatile boolean canceled;
		private volatile boolean canceledAlways;

		public void beginTask(String name, int totalWork) {
		}

		public void done() {
		}

		public void internalWorked(double work) {
		}

		public boolean isCanceled() {
			if (this.canceledAlways)
				return true;
			return this.canceled;
		}

		public void setCanceled(boolean canceled) {
			this.canceled = canceled;
		}

		public void setAlwaysCanceled(boolean canceled) {
			this.canceledAlways = canceled;
		}

		public void setTaskName(String name) {
		}

		public void subTask(String name) {
		}

		public void worked(int work) {
		}
	}

}
