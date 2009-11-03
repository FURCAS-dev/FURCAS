package com.sap.mi.fwk.test;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.controller.Controller;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.IPartitionScopes;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link PartitionService}
 * 
 * @author d031150
 */
public class PartitionServiceTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/partitionservice";
	private static final String DC_NAME_USED = "test/partitionservice/used";
	private Connection mConnection;
	private final PartitionService mPartitionService;
	private Component mCompUsed;
	private Connection mConnectionUsed;

	public PartitionServiceTest() {
		super(DC_NAME);
		mPartitionService = ModelManager.getPartitionService();
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected InputStream getProjectContentAsStream() {
		return PartitionServiceTest.class.getResourceAsStream("PartitionServiceTestData.zap");
	}

	@Override
	protected void setUp() throws Exception {
		// delete used project here as weel to be symmetric
		// with other/using project
		deleteUsedProject();
		super.setUp();

		mConnection = createConnection();
	}

	@Override
	protected void tearDown() throws Exception {
		if (mConnectionUsed != null)
			mConnectionUsed.close();

		super.tearDown();
	}

	@Override
	public void dispose() throws Exception {
		super.dispose();
		// delete used project here as weel to be symmetric
		// with other/using project
		deleteUsedProject();
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	private void deleteUsedProject() {
		IProject usedProject = TestUtil.getLocalMoinDCProject(DC_NAME_USED);
		if (usedProject != null)
			TestUtil.deleteLocalMoinDCProject(usedProject);
	}

	public void testIsMoinPartition() {
		ModelPartition part = getPartition();
		IFile file = ModelAdapter.getInstance().getFile(part.getPri());
		assertTrue("Must be Moin partiton", PartitionService.getInstance().isMoinPartition(file));

		IPath path = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		IFolder root = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
		assertFalse("Must NOT be Moin partiton", PartitionService.getInstance().isMoinPartition(root));

		// create bad partition like file
		IFile dummy = getProject().getFile("dummy." + MetaModelCatalog.META_MODEL_EXTENSION);
		assertFalse("Must NOT be Moin partiton", PartitionService.getInstance().isMoinPartition(dummy));
	}

	public void testGetPartitions() {
		Collection<PRI> partitions = ModelManager.getPartitionService().getPartitions(mConnection, getProject());
		assertTrue("MUst be one partition: " + partitions, partitions.size() == 1);

		ModelPartition partition = mConnection.getPartition(partitions.iterator().next());
		assertNotNull("Partition not resolvable", partition);
	}

	public void testGetDirtyPartitions() {
		Component oldComp = getComponent();
		ModelPartition oldPart = ((Partitionable) oldComp).get___Partition();

		// modified null partition
		Component component = createComponent();
		ModelPartition part = ((Partitionable) component).get___Partition();
		Collection<ModelPartition> dirtyPartitions = mPartitionService.getDirtyPartitions(mConnection);
		assertTrue("Partitions " + dirtyPartitions + " should contain " + part.getPri(), dirtyPartitions.contains(part));

		// modified normal partition
		oldPart.assignElement(component);
		dirtyPartitions = mPartitionService.getDirtyPartitions(mConnection);
		assertTrue("Partitions " + dirtyPartitions + " should contain " + oldPart.getPri(), dirtyPartitions
				.contains(oldPart));

		// close connection
		mConnection.close();
		try {
			mPartitionService.getDirtyPartitions(mConnection);
			fail("Exception expected for closed connection: " + mConnection);
		} catch (RuntimeException e) { // $JL-EXC$
		}
	}

	public void testGetRootElements() {
		Component component = getComponent();

		Collection<Partitionable> rootElements = mPartitionService.getRootElements(getPartition());
		assertTrue("Must be one root element in partition: " + rootElements, rootElements.size() == 1);
		assertEquals("Component must be root element", component, rootElements.iterator().next());
	}

	public void testGetPRI() {
		IProject project = getProject();

		PRI pri = mPartitionService.getPRI(project, createPath("newPartition"));
		assertNotNull(pri);
		IPath name = new Path(pri.getPartitionName());
		assertEquals("Partition name must include the source folder", MoinTestDcType.SOURCE_FOLDER.toString(), name
				.segment(0));

		try {
			pri = mPartitionService.getPRI(project, Path.EMPTY);
			fail("Empty path is not allowed");

			pri = mPartitionService.getPRI(project, null);
			fail("Path == null is not allowed");
		} catch (RuntimeException e) { // $JL-EXC$
		}
	}

	public void testClearNullPartition() {
		createComponent();
		mPartitionService.clearNullPartition(mConnection, null);
		Collection<Partitionable> elementsInNull = mConnection.getNullPartition().getElements();
		assertTrue("Null partition must be empty: " + elementsInNull, elementsInNull.isEmpty());

		createComponent();
		PRI pri = mPartitionService.getPRI(getProject(), createPath("newPartition"));
		ModelPartition partition = mConnection.createPartition(pri);
		mPartitionService.clearNullPartition(mConnection, partition);
		elementsInNull = mConnection.getNullPartition().getElements();
		assertTrue("Null partition must be empty: " + elementsInNull, elementsInNull.isEmpty());
	}

	public void testClearReferencedTransientElements() {
		ModelPartition transientPartition = mConnection.getOrCreateTransientPartition("transientPartition");
		Component componentPersistent = getComponent();
		{
			final Controller transientController = transientPartition.createElement(Controller.class);
			transientController.setName("transientController");
			componentPersistent.setComponentController(transientController);

			mPartitionService.clearReferencedTransientElements(mConnection, null);
			Collection<Partitionable> transientElements = transientPartition.getElements();
			assertTrue("Transient partition must be empty: " + transientElements, transientElements.isEmpty());
		}
		{
			final Controller transientController = transientPartition.createElement(Controller.class);
			transientController.setName("transientController");
			componentPersistent.setComponentController(transientController);

			PRI pri = mPartitionService.getPRI(getProject(), createPath("newPartition"));
			ModelPartition partition = mConnection.createPartition(pri);
			mPartitionService.clearReferencedTransientElements(mConnection, partition);

			Collection<Partitionable> transientElements = transientPartition.getElements();
			assertTrue("Transient partition must be empty: " + transientElements, transientElements.isEmpty());
			Collection<Partitionable> elements = partition.getElements();
			assertTrue("Element must be contained in partition. Element's partition: "
					+ ((Partitionable) transientController).get___Partition(), elements.contains(transientController));
		}
	}

	public void testCreatePartition() {
		ModelPartition partition1 = mPartitionService.createPartition(mConnection, getProject(),
				createPath("partition1"), null);
		assertNotNull("Partition must not be null: ", partition1);
		Collection<Partitionable> elements = partition1.getElements();
		assertEquals("Partition must be empty: " + partition1, 0, elements.size());

		Component newComponent = createComponent();
		ModelPartition partition2 = mPartitionService.createPartition(mConnection, getProject(),
				createPath("partition2"), newComponent);
		assertNotNull("Partition must not be null", partition2);
		Collection<Partitionable> rootElements = mPartitionService.getRootElements(partition2);
		assertEquals("Component must be assigned to partition" + partition2, 1, rootElements.size());

		try {
			ModelPartition partition3 = mPartitionService.createPartition(mConnection, getProject(),
					createPath("partition3"), newComponent.refMetaObject());
			fail("Assignment of metamodel object '" + newComponent.refMetaObject() + "' to partition '"
					+ partition3.getPri() + "' is not allowed");
		} catch (RuntimeException e) { // $JL-EXC$
		}
	}

	public void testMoveElements() {
		Component component = getComponent();

		ModelPartition newPartition = mPartitionService.createPartition(mConnection, getProject(),
				createPath("newPartition"), null);

		ModelPartition oldPartition = getPartition();
		mPartitionService.moveElements(oldPartition, newPartition);
		assertTrue("New partition must contain moved component", newPartition.getElements().contains(component));
		assertTrue("Old partition must be empty", oldPartition.getElements().isEmpty());
	}

	public void testRenameElements() {
		IProject project = getProject();

		ModelPartition partition = getPartition();
		IPath newPath = createPath("newPartition");
		ModelPartition newPartition = mPartitionService.renamePartition(mConnection, partition, newPath);
		assertNotNull("New partition must not be null", newPartition);
		assertFalse("Old partition must not be alive anymore: " + partition.getPri(), partition.isAlive());

		partition = mConnection.createPartition(mPartitionService.getPRI(project, createPath("partition")));
		try {
			mPartitionService.renamePartition(mConnection, partition, getPartitionPath(newPartition));
			fail("Partition already exists: " + newPartition.getPri());
		} catch (RuntimeException e) { // $JL-EXC$
		}

		try {
			newPartition = mPartitionService.renamePartition(mConnection, mConnection.getNullPartition(),
					createPath("newPartition2"));
			fail("Null partition cannot be deleted: " + mConnection.getNullPartition().getPri());
		} catch (RuntimeException e) { // $JL-EXC$
		}
	}

	public void testPartitionScopes() throws Exception {
		createUsedDc();

		IPartitionScopes scopes = mPartitionService.getPartitionScopes();

		Set<PRI> inner = scopes.getInnerPartitions(mConnection);
		assertTrue("At least 2 inner partitions expected: " + inner, inner.size() >= 2);
		assertTrue("Null partition must be contained: " + inner, inner
				.contains(mConnection.getNullPartition().getPri()));

		Set<PRI> outer = scopes.getOuterPartitions(mConnection);
		assertTrue("Referenced partitions expected: " + outer, outer.size() > 0);

		Set<PRI> visible = scopes.getVisiblePartitions(mConnection);
		assertEquals("Referenced partitions expected: " + outer, inner.size() + outer.size(), visible.size());
	}

	public void testPartitionScopeProvider() throws Exception {
		createUsedDc();

		IPartitionScopeProvider provider = mPartitionService.getPartitionScopeProvider(mConnection,
				PartitionScope.INNER);

		Set<PRI> inner = provider.getPartitions();
		assertTrue("At least 2 inner partitions expected: " + inner, inner.size() >= 2);
		assertTrue("Null partition must be contained: " + inner, inner
				.contains(mConnection.getNullPartition().getPri()));
		provider = mPartitionService.getPartitionScopeProvider(mConnection, PartitionScope.OUTER);

		Set<PRI> outer = provider.getPartitions();
		assertTrue("Referenced partitions expected: " + outer, outer.size() > 0);

		provider = mPartitionService.getPartitionScopeProvider(mConnection, PartitionScope.VISIBLE);
		Set<PRI> visible = provider.getPartitions();
		assertEquals("Referenced partitions expected: " + outer, inner.size() + outer.size(), visible.size());
	}

	private void createUsedDc() throws Exception {
		IProject projectUsed = TestUtil.createLocalMoinDCProject(DC_NAME_USED, MoinTestDcType.getDcType());
		mConnectionUsed = ConnectionManager.getInstance().createConnection(projectUsed);

		mCompUsed = createComponent(mConnectionUsed);
		PRI pri = getPri(projectUsed, new Path("src/com/sap/test/used/Component"));
		ModelPartition partition = mConnectionUsed.getPartition(pri);
		if (partition != null)
			partition.delete();
		partition = mConnectionUsed.createPartition(pri);
		partition.assignElementIncludingChildren(mCompUsed);
		mConnectionUsed.save();

		TestUtil.addPublicPartDependency(getProject(), DC_NAME_USED, MoinProject.VENDOR_SAP,
				MoinTestDcType.PP_NAME_COMPILATION, true, false, false);
	}

	private static IPath createPath(String partitionName) {
		return WebDynproProjectTest.SOURCE_FOLDER_WEBDYNPRO.append(partitionName).removeFileExtension()
				.addFileExtension(WebDynproProjectTest.PARTITION_EXTENSION_WEBDYNPRO);
	}

	private Component getComponent() {
		List<Component> components = QueryService.getInstance().queryInstances(getProject(), mConnection,
				CONTAINER_NAME_WEBDYNPRO, TYPE_NAME_COMPONENT);
		assertTrue("No Component found in " + components, components.size() == 1);
		return components.get(0);
	}

	private Component createComponent() {
		return getComponent( ).get___Connection( ).createElementInPartition( Component.class, null );
	}

	private Component createComponent(Connection connection) {
		Component component = connection.createElementInPartition( Component.class, null );
		component.setName("comp");
		return component;
	}

	private ModelPartition getPartition() {
		Component component = getComponent();
		ModelPartition partition = ((Partitionable) component).get___Partition();
		assertNotNull("Partition must not be null for " + component, partition);
		return partition;
	}

	private IPath getPartitionPath(ModelPartition newPartition) {
		return new Path(newPartition.getPri().getPartitionName());
	}

	private static void assertNotNull(PRI pri) {
		assertNotNull("Pri must not be null", pri);
	}

}
