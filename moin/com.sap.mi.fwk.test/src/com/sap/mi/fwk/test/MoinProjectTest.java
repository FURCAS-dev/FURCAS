package com.sap.mi.fwk.test;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import junit.framework.AssertionFailedError;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.sap.ide.dii05.lib.api.modeledit.DiiModelEditService;
import com.sap.ide.dii05.lib.api.modeledit.IMeCommonEntity;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPart;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.ICommonEntity;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.ICustomProperty;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IPublicPart;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.MoinFolderInfo;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests {@link MoinProject} and related classes
 * 
 * @author d031150
 */
public class MoinProjectTest extends ExtendedTestCase {

	private static final String DC_NAME = "test/moinproject";
	private IProject mProject;
	private IDevelopmentComponent mDc;
	private Connection mConnection;
	private Boolean mWasAutoBuilding;

	public MoinProjectTest() {
		super(DC_NAME);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		IProject project = TestUtil.getLocalMoinDCProject(DC_NAME);
		if (project != null)
			TestUtil.deleteLocalMoinDCProject(project);
	}

	@Override
	protected void tearDown() throws Exception {
		if (mDc != null)
			MoinProject.deleteLocalDc(mDc, true, null);

		if (mProject != null && mProject.exists())
			MoinProject.deleteLocalDc(mProject, null);

		if (mConnection != null)
			mConnection.close();

		if (mWasAutoBuilding != null)
			PDEUtil.setAutoBuilding(mWasAutoBuilding);

		super.tearDown();
	}

	@SuppressWarnings("unchecked")
	public void testCreateLocalDc() throws Exception {
		mProject = MoinProject.createLocalDc(DC_NAME, null, MoinTestDcType.getDcType(), null);
		assertNotNull("Project must not be null", mProject);
		assertTrue("Project must be accessible (open!)", mProject.isAccessible());

		mDc = DiiResourceService.getDevelopmentComponent(mProject);
		List<IPublicPart> pps = mDc.getLocalState().getPublicParts();
		assertEquals("Default public part must have been created: " + pps, 1, pps.size());
	}

	public void testCreateLocalDcNoProject() throws Exception {
		mDc = MoinProject.createLocalDc(DC_NAME, null, MoinTestDcType.getDcType(), new MoinDcOptions() {
			@Override
			public boolean createProject(IDevelopmentComponent dc) throws CoreException {
				return false;
			}
		}, null);
		assertNotNull("DC must not be null", mDc);
		IProject project = DiiResourceService.getProject(mDc);
		assertNull("No project must have been created: " + project, project);
	}

	@SuppressWarnings("unchecked")
	public void testCreateLocalDcCustomDcType() throws Exception {
		IComponentType dcType = MoinProject.getDcType(TestDcType.DC_TYPE_ID, MoinProject.VENDOR_SAP, null);
		assertNotNull("DC type not found: " + TestDcType.DC_TYPE_ID, dcType);
		mProject = MoinProject.createLocalDc(DC_NAME, null, dcType, null);
		assertNotNull("Project must not be null", mProject);
		assertTrue("Project must be accessible (open!)", mProject.isAccessible());

		mDc = DiiResourceService.getDevelopmentComponent(mProject);
		List<IPublicPart> pps = mDc.getLocalState().getPublicParts();
		assertEquals("One custom public part must have been created: " + pps, 1, pps.size());
		assertEquals("Custom public part name expected", TestDcType.PP_NAME, pps.get(0).getName());
	}

	/*
	 * Test whether listener gets notified after all natures and builders are
	 * set
	 */
	public void testCreateLocalDCListenerUpdate() throws Exception {
		final boolean[] listenerCalled = new boolean[] { false };
		String[] natures = new String[] { TestNature.NATURE_ID, "com.sap.mi.fwk.dcfwk.MoinNature" };
		IResourceChangeListener listener = new ProjectCreationListener(listenerCalled, natures, TestNature.BUILDER_ID,
				TestDcType.FOLDERS);
		try {

			ResourcesPlugin.getWorkspace().addResourceChangeListener(listener, IResourceChangeEvent.POST_CHANGE);

			IComponentType dcType = MoinProject.getDcType(TestDcType.DC_TYPE_ID, MoinProject.VENDOR_SAP, null);
			mProject = MoinProject.createLocalDc(DC_NAME, null, dcType, null);
			assertTrue("Creation listener must be called", listenerCalled[0]);
		} finally {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(listener);
		}
	}

	public void testDeleteLocalDC() throws Exception {
		mProject = MoinProject.createLocalDc(DC_NAME, null, MoinTestDcType.getDcType(), null);

		MoinProject.deleteLocalDc(mProject, null);
		assertFalse("Project must not be accessible", mProject.isAccessible());
	}

	public void testDeleteClosedLocalDC() throws Exception {
		mProject = MoinProject.createLocalDc(DC_NAME, null, MoinTestDcType.getDcType(), null);

		mProject.close(null);
		MoinProject.deleteLocalDc(mProject, null);
		assertFalse("Project must not exist", mProject.exists());
	}

	public void testMoinFolderInfo() throws Exception {
		// valid cases
		IPath path = new Path("myFolder");
		new MoinFolderInfo(path, true);
		new MoinFolderInfo(path, true, false, false);
		new MoinFolderInfo(path, false, false, true);
		new MoinFolderInfo(path, false, true, false);
		new MoinFolderInfo(path, false, true, true);
		new MoinFolderInfo(path, true, false, true);

		// invalid cases
		try {
			MoinFolderInfo info = new MoinFolderInfo(null, true);
			fail("FolderInfo must not be valid: " + info);
		} catch (RuntimeException expected) {
		}
		try {
			MoinFolderInfo info = new MoinFolderInfo(Path.EMPTY, true);
			fail("FolderInfo must not be valid: " + info);
		} catch (RuntimeException expected) {
		}
		try {
			MoinFolderInfo info = new MoinFolderInfo(path, true, true, false);
			fail("FolderInfo must not be valid: " + info);
		} catch (RuntimeException expected) {
		}
		// try {
		// MoinFolderInfo info = new MoinFolderInfo(path, true, false, true);
		// fail("FolderInfo must not be valid: " + info);
		// } catch (RuntimeException expected) {
		// }
		try {
			MoinFolderInfo info = new MoinFolderInfo(path, true, true, true);
			fail("FolderInfo must not be valid: " + info);
		} catch (RuntimeException expected) {
		}
	}

	@SuppressWarnings("unchecked")
	public void testEnableForMoin() throws Exception {
		// disable autobuild so that our test resource listeners are not called
		// from a builder by coincidence
		mWasAutoBuilding = PDEUtil.setAutoBuilding(false);

		// create a Java Dc
		IComponentType dcType = MoinProject.getDcType("Java", MoinProject.VENDOR_SAP, null);
		mProject = MoinProject.createLocalDc("test/javadc", null, dcType, null);
		assertNotNull("Project must not be null", mProject);

		// install listener to check when changes are visible
		final MoinFolderInfo[] resFolders = new MoinFolderInfo[] { new MoinFolderInfo(new Path("core"), true) };
		final MoinFolderInfo[] allFolders = new MoinFolderInfo[] { resFolders[0],
				new MoinFolderInfo(new Path("other"), false, true, true) };

		// 1. enable partition 'core' with refresh
		MoinProject.enableForMoin(mProject, new MoinDcOptions() {
			@Override
			public MoinFolderInfo[] getFolders() throws CoreException {
				return allFolders;
			}
		}, null);
		mDc = DiiResourceService.getDevelopmentComponent(mProject);

		List<IPath> resourceFolders = Arrays.asList(ModelManager.getInstance().getMoinResourceFolders(mProject));
		for (MoinFolderInfo folder : resFolders) {
			IPath path = folder.getPath();
			assertTrue("Resource folders must contain '" + path + "': " + resourceFolders, resourceFolders
					.contains(path));
		}

		List<IPublicPart> pps = mDc.getLocalState().getPublicParts();
		assertTrue("No public parts must have been created: " + pps, pps.isEmpty());

		mConnection = ConnectionManager.getInstance().createConnection(mProject);
		PRI pri = ModelManager.getPartitionService().getPRI(mProject, new Path("core/aPartition.xmi"));
		int counter = 0;
		while (mConnection.partitionExists(pri)) {
			sleep(1000);
			counter++;
			if (counter > 20) {
				break;
			}
		}
		ModelPartition partition = mConnection.createPartition(pri);
		assertNotNull("Resource folder 'core' must be available for Moin, failed to create partition.", partition);

		try {
			ModelManager.getPartitionService().getPRI(mProject, new Path("other/aPartition.xmi"));
			fail("Resource folder 'other' must not be available for Moin since it has been marked as exclueded.");
		} catch (RuntimeException expected) {
		}
		try {
			ModelManager.getPartitionService().getPRI(mProject, new Path("api/aPartition.xmi"));
			fail("Resource folder 'api' must not be available for Moin since it has been marked as exclueded.");
		} catch (RuntimeException expected) {
		}
		ConnectionManager.getInstance().save(mConnection);

		IPath addFolder = new Path("api");
		final MoinFolderInfo[] additionalFolders = new MoinFolderInfo[] { new MoinFolderInfo(addFolder, true),
				new MoinFolderInfo(new Path("java"), MoinFolderInfo.DC_FOLDER_TYPE_PACKAGE, false, false, false) };
		// 2. test adding new resource folder WITHOUT refresh -> causes
		// InvalidResourceIdentifierException
		// negative test not possible as MOIN might have already been notified
		// via eventing (resource/DII)

		// 3. test adding new resource folder WITH refresh
		MoinProject.enableForMoin(mProject, new MoinDcOptions() {
			@Override
			public MoinFolderInfo[] getFolders() throws CoreException {
				return additionalFolders;
			}

			@Override
			public boolean refreshMoin(IDevelopmentComponent dc) {
				return true;
			}
		}, null);

		pri = ModelManager.getPartitionService().getPRI(mProject, new Path("api/aPartition.xmi"));
		partition = mConnection.createPartition(pri);
		assertNotNull("Resource folder 'api' must be available for Moin, failed to create partition.", partition);
		ConnectionManager.getInstance().save(mConnection);

		// check whether Moin accepts data in the new folders
		InputStream data = getClass().getResourceAsStream("MoinProjectTestData.zap");
		TestUtil.loadData(data, mProject);
		List<Component> components = QueryService.getInstance().queryInstances(mProject, mConnection,
				WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO, WebDynproProjectTest.TYPE_NAME_COMPONENT);
		assertTrue("Content in folder 'api' not recognized " + components, components.size() > 0);

		IPath[] paths = ModelManager.getInstance().getMoinResourceFolders(mProject);
		int noAddFolderInAllFolders = 0;
		for (IPath folderInfo : paths) {
			if (folderInfo.equals(addFolder))
				noAddFolderInAllFolders++;
		}
		assertEquals("Additional folder '" + addFolder + "' must appear once: " + paths, 1, noAddFolderInAllFolders);
	}

	@SuppressWarnings("unchecked")
	public void testEnableProjectForMoin() throws Exception {
		// Disable autobuild so that our test resource listeners are not called
		// from a builder by coincidence
		mWasAutoBuilding = PDEUtil.setAutoBuilding(false);

		// Create a Java Dc
		IComponentType dcType = MoinProject.getDcType("Java", MoinProject.VENDOR_SAP, null);
		mProject = MoinProject.createLocalDc("test/javadc2", null, dcType, null);
		assertNotNull("Project must not be null", mProject);

		// Try to establish Moin settings on project only. Must fail since the
		// DC does not have a MOIN DC type
		MoinFolderInfo[] resFolders = new MoinFolderInfo[] { new MoinFolderInfo(new Path("api"), true),
				new MoinFolderInfo(new Path("core"), true) };
		final MoinFolderInfo[] folders = new MoinFolderInfo[] { resFolders[0], resFolders[1],
				new MoinFolderInfo(new Path("other"), false, true, true) };
		try {
			MoinProject.enableProjectForMoin(mProject, new MoinDcOptions() {
				@Override
				public MoinFolderInfo[] getFolders() throws CoreException {
					return folders;
				}

				@Override
				public boolean refreshMoin(IDevelopmentComponent dc) {
					return true;
				}
			}, null);

			// This point should not be reached
			fail("'EnableProjectForMoin' did not fail on a Java DC");
		} catch (CoreException e) {
			// This is the intended exception
		}

		Long timeStamp = mProject.getFile(".dcdef").getLocalTimeStamp();

		// This time really enhance the Java DC to a Moin DC
		MoinProject.enableForMoin(mProject, new MoinDcOptions() {
			@Override
			public MoinFolderInfo[] getFolders() throws CoreException {
				return folders;
			}

			@Override
			public boolean refreshMoin(IDevelopmentComponent dc) {
				return true;
			}
		}, null);
		mDc = DiiResourceService.getDevelopmentComponent(mProject);

		List<IPath> resourceFolders = Arrays.asList(ModelManager.getInstance().getMoinResourceFolders(mProject));
		for (MoinFolderInfo folder : resFolders) {
			IPath path = folder.getPath();
			assertTrue("Resource folders must contain '" + path + "': " + resourceFolders, resourceFolders
					.contains(path));
		}

		List<IPublicPart> pps = mDc.getLocalState().getPublicParts();
		assertTrue("No public parts must have been created: " + pps, pps.isEmpty());

		// Wait for the the framework to update the dcdef file and then
		// get the time stamp of the dcdef file
		Long newTimeStamp = mProject.getFile(".dcdef").getLocalTimeStamp();
		int count = 0;
		while (newTimeStamp.equals(timeStamp) && count < 20) {
			sleep(100);
			count++;
			newTimeStamp = mProject.getFile(".dcdef").getLocalTimeStamp();
		}
		System.out.println("dcdef updated after " + count * 100 + "ms");

		// Add additional folders
		final MoinFolderInfo[] addResFolders = new MoinFolderInfo[] { new MoinFolderInfo(new Path("addApi"), true),
				new MoinFolderInfo(new Path("addCore"), true) };
		MoinProject.enableProjectForMoin(mProject, new MoinDcOptions() {
			@Override
			public MoinFolderInfo[] getFolders() throws CoreException {
				return addResFolders;
			}

			@Override
			public boolean refreshMoin(IDevelopmentComponent dc) {
				return true;
			}
		}, null);

		// Check that the additional folders exist
		for (int i = 0; i < addResFolders.length; i++) {
			IFolder folder = mProject.getFolder(addResFolders[i].getPath());
			assertNotNull("Folder '" + addResFolders[i].toString() + "' is null", folder);
			assertTrue("Folder '" + addResFolders[i].toString() + "' does not exist", folder.exists());
		}

		// Ensure that the dcdef file has not been touched (taken as indication
		// that the DC metadata has not been changed; there is no way to ask the
		// in-memory DC metamodel for that information)
		assertEquals("dcdef file has been modified", newTimeStamp, (Long) mProject.getFile(".dcdef")
				.getLocalTimeStamp());
	}

	public void testDisableMoin() throws Exception {
		mProject = TestUtil.createLocalMoinDCProject(DC_NAME);
		Connection connection = TestUtil.createConnection(mProject, getName());
		connection.close();
		connection = null;

		MoinProject.disableMoin(mProject, null, null);

		assertFalse("Must no longer be a Moin project: " + mProject, ModelManager.getInstance().isMoinProject(mProject));
		try {
			connection = TestUtil.createConnection(mProject, getName());
			connection.close();
			fail("Connection must not be available for deconfigured project: " + mProject);
		} catch (RuntimeException expected) {
		} catch (AssertionFailedError expected) {
		}
	}

	@SuppressWarnings("unchecked")
	public void testRepairDc() throws Exception {
		IComponentType dcType = MoinProject.getDcType(TestDcType.DC_TYPE_ID, MoinProject.VENDOR_SAP, null);
		mProject = MoinProject.createLocalDc(DC_NAME, null, dcType, null);
		mDc = DiiResourceService.getDevelopmentComponent(mProject);
		String srcFolder = TestDcType.SOURCE_FOLDER.getPath().toString();

		{
			List<IPublicPart> pps = mDc.getLocalState().getPublicParts();
			assertEquals("One custom public part must have been created: " + pps, 1, pps.size());
			assertEquals("Custom public part name expected", TestDcType.PP_NAME, pps.get(0).getName());
		}
		{
			// remove whole pp and repair DC afterwards
			DiiModelEditService.deletePublicPart(mDc.getLocalState(), TestDcType.PP_NAME, null);
			List<IPublicPart> pps = mDc.getLocalState().getPublicParts();
			assertEquals("Public part must have been removed: " + pps, 0, pps.size());

			MoinProject.repairDc(mDc, null, null);
			pps = mDc.getLocalState().getPublicParts();
			assertEquals("One custom public part must have been created: " + pps, 1, pps.size());
			assertEquals("Custom public part name expected", TestDcType.PP_NAME, pps.get(0).getName());
		}

		List<IPublicPart> pps = mDc.getLocalState().getPublicParts();
		// remove single entity and repair DC afterwards
		IMePublicPart editablePp = DiiModelEditService.newEditablePublicPart(mDc.getLocalState(), TestDcType.PP_NAME,
				pps.get(0).getPurpose(), null, true);
		List<IMeCommonEntity> editEntities = editablePp.getEntities();
		for (Iterator<IMeCommonEntity> iter = editEntities.iterator(); iter.hasNext();) {
			if (srcFolder.equals(iter.next().getName())) {
				iter.remove();
				break;
			}
		}
		DiiModelEditService.commitChangesAndRefresh(editablePp);

		{
			// first tell infrastructure not to manage pps
			// -> nothing must be touched
			MoinProject.repairDc(mDc, new MoinDcOptions() {
				@Override
				public boolean createPublicPart(Purpose publicPartPurpose) {
					return false;
				}
			}, null);
			pps = mDc.getLocalState().getPublicParts();
			List<ICommonEntity> entities = pps.get(0).getEntities();
			for (Iterator<ICommonEntity> iter = entities.iterator(); iter.hasNext();) {
				if (srcFolder.equals(iter.next().getName())) {
					fail("Entity must not have been created by repairDc. Entities: " + entities);
				}
			}
		}
		{
			// now do the repair
			MoinProject.repairDc(mDc, null, null);
			pps = mDc.getLocalState().getPublicParts();
			List entities = pps.get(0).getEntities();
			boolean entityCreated = false;
			for (Iterator<ICommonEntity> iter = entities.iterator(); iter.hasNext();) {
				if (srcFolder.equals(iter.next().getName())) {
					entityCreated = true;
					break;
				}
			}
			assertTrue("Entity must have been created by repairDc. Entities: " + entities, entityCreated);
		}
	}

	private static final class ProjectCreationListener implements IResourceChangeListener {
		private final boolean[] mCalled;
		private final String[] mNatures;
		private final String mBuilder;
		private final MoinFolderInfo[] mFolders;

		private ProjectCreationListener(boolean[] called, String[] natures, String builder,
				MoinFolderInfo[] sourceFolders) {
			mCalled = called;
			mNatures = natures;
			mBuilder = builder;
			mFolders = sourceFolders;
		}

		public void resourceChanged(IResourceChangeEvent event) {
			if (mCalled[0])
				return; // only react once

			try {
				IResourceDelta delta = event.getDelta();
				if (delta == null)
					return;
				delta.accept(new IResourceDeltaVisitor() {

					@SuppressWarnings("unchecked")
					public boolean visit(IResourceDelta delta) throws CoreException {
						IResource resource = delta.getResource();
						if (resource instanceof IProject && ((IProject) resource).isAccessible()) {
							IProject project = ((IProject) resource);
							mCalled[0] = true;

							// natures
							List<String> natureIds = Arrays.asList(project.getDescription().getNatureIds());
							for (String nature : mNatures) {
								assertTrue("Listener must see nature '" + nature
										+ "' right after creation. Current natures: " + natureIds, natureIds
										.contains(nature));
							}

							// builders
							boolean builderFound = false;
							ICommand[] buildSpec = project.getDescription().getBuildSpec();
							for (ICommand command : buildSpec) {
								if (mBuilder.equals(command.getBuilderName())) {
									builderFound = true;
									break;
								}
							}
							assertTrue("Listener must see builder ids right after creation. Current builders: "
									+ Arrays.asList(buildSpec), builderFound);

							// folders
							for (MoinFolderInfo info : mFolders) {
								IFolder folder = project.getFolder(info.getPath());
								assertNotNull("Folder must be created: " + info, folder);
								assertTrue("Folder must exist: " + folder, folder.exists());
							}

							// custom configuration via IMoinDcType.configure()
							IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(project);
							List<ICustomProperty> props = dc.getLocalState().getCustomProperties();
							boolean propertyFound = false;
							for (ICustomProperty prop : props) {
								if (TestDcType.PROP_NAME.equals(prop.getName())) {
									propertyFound = true;
									break;
								}
							}
							assertTrue("Listener must see custom propertys right after creation. Current properties: "
									+ props, propertyFound);

							return false;
						}
						return true;
					}
				});
			} catch (CoreException e) {
				fail(e);
			}
		}
	}

	// private static final class EnableForMoinListener implements
	// IResourceChangeListener {
	// private final boolean[] mCalled;
	// private final MoinFolderInfo[] mFolders;
	//
	// private EnableForMoinListener(boolean[] called, MoinFolderInfo[]
	// sourceFolders) {
	// mCalled = called;
	// mFolders = sourceFolders;
	// }
	//
	// public void resourceChanged(IResourceChangeEvent event) {
	// if (mCalled[0])
	// return; // only react once
	//
	// try {
	// IResourceDelta delta = event.getDelta();
	// if (delta == null)
	// return;
	// delta.accept(new IResourceDeltaVisitor() {
	//
	// @SuppressWarnings("unchecked")
	// public boolean visit(IResourceDelta delta) throws CoreException {
	// IResource resource = delta.getResource();
	// if (resource instanceof IProject && ((IProject) resource).isAccessible())
	// {
	// IProject project = ((IProject) resource);
	// mCalled[0] = true;
	//
	// // folders
	// for (MoinFolderInfo info : mFolders) {
	// IFolder folder = project.getFolder(info.getPath());
	// assertNotNull("Folder must be created: " + info, folder);
	// assertTrue("Folder must exist: " + folder, folder.exists());
	// }
	//
	// return false;
	// }
	// return true;
	// }
	// });
	// } catch (CoreException e) {
	// fail(e);
	// }
	// }
	// }

}
