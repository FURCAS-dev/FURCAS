package com.sap.mi.fwk.test;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link ModelAdapter}
 * 
 * @author d031150
 */
public class ModelAdapterTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/modeladapter";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/adp");
	private static final String DC_NAME_USED = "test/modeladapter/used";

	private ModelAdapter mModelAdapter;

	private Connection mConnection;
	private Connection mConnectionUsed;

	private Component mComponent;
	private Component mCompTransient;
	private Component mComponentUsed;
	private View mView;

	private TestAdapterFactory mAdapterFactory;
	private Connection mConnectionTransient;
	private Component mCompTransientConnection;

	public ModelAdapterTest() {
		super(DC_NAME);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mConnection = createConnection();

		mModelAdapter = ModelAdapter.getInstance();

		PRI partitionMRI = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = mConnection.getPartition(partitionMRI);
		if (partition != null) {
			partition.delete();
		}
		partition = mConnection.createPartition(partitionMRI);

		mComponent = partition.createElement(Component.CLASS_DESCRIPTOR);

		mView = partition.createElement(View.CLASS_DESCRIPTOR);
		mView.setName("testView");
		mComponent.getViews().add(mView);

		createComponentTransientPartition();
		createComponentTransientConnection();

		mConnection.save();

		mAdapterFactory = new TestAdapterFactory();
		Platform.getAdapterManager().registerAdapters(mAdapterFactory, ModelAdapterTest.class);
	}

	@Override
	protected void tearDown() throws Exception {
		Platform.getAdapterManager().unregisterAdapters(mAdapterFactory, ModelAdapterTest.class);
		if (mConnectionUsed != null)
			mConnectionUsed.close();
		if (mConnectionTransient != null)
			mConnectionTransient.close();

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
	protected String getDcName() {
		return DC_NAME;
	}

	public void testProject_RefBaseObject() throws Exception {
		IProject project = getProject();
		IProject projectUsed = createUsedDc();

		{
			IProject result = mModelAdapter.getProject(mView);
			assertEquals("RefBaseObject -> IProject", project, result);
		}
		{
			IProject result = mModelAdapter.getProject(mComponent.refMetaObject());
			assertEquals("MetaObject -> IProject", null, result);
		}
		{
			Component newComp = (Component) mComponent.refClass().refCreateInstance();
			IProject result = mModelAdapter.getProject(newComp);
			assertEquals("RefBaseObject from null partition -> IProject", project, result);
		}
		{
			IProject result = mModelAdapter.getProject(mCompTransient);
			assertEquals("RefBaseObject from transient partition -> IProject", project, result);
		}
		{
			IProject result = mModelAdapter.getProject(mComponentUsed);
			assertEquals("RefBaseObject of used project -> IProject", projectUsed, result);
		}
	}

	public void testProject_UsingConnection() throws Exception {
		IProject project = getProject();
		createUsedDc();

		{
			IProject result = mModelAdapter.getProjectUsingConnection(mView);
			assertEquals("RefBaseObject -> IProject", project, result);
		}
		{
			IProject result = mModelAdapter.getProjectUsingConnection(mComponent.refMetaObject());
			assertEquals("MetaObject -> IProject", project, result);
		}
		{
			Component newComp = (Component) mComponent.refClass().refCreateInstance();
			IProject result = mModelAdapter.getProjectUsingConnection(newComp);
			assertEquals("RefBaseObject from null partition -> IProject", project, result);
		}
		{
			IProject result = mModelAdapter.getProjectUsingConnection(mCompTransient);
			assertEquals("RefBaseObject from transient partition -> IProject", project, result);
		}
		{
			IProject result = mModelAdapter.getProjectUsingConnection(mComponentUsed);
			assertEquals("RefBaseObject of used project -> IProject", project, result);
		}
	}

	public void testProject_Connection() throws Exception {
		IProject project = getProject();
		{
			IProject result = mModelAdapter.getProject(((Partitionable) mComponent).get___Connection());
			assertEquals("Connection -> IProject", project, result);
		}
		{
			IProject result = mModelAdapter.getProject(((Partitionable) mComponent.refMetaObject()).get___Connection());
			assertEquals("Connection of MetaObject -> IProject", project, result);
		}
	}

	public void testProject_CRI() throws Exception {
		IProject project = getProject();
		{
			IProject result = mModelAdapter.getProject(((Partitionable) mView).get___Mri().getCri());
			assertEquals("CRI -> IProject", project, result);
		}
		{
			IProject result = mModelAdapter.getProject(((Partitionable) mCompTransient).get___Mri().getCri());
			assertEquals("CRI of transient object -> IProject", null, result);
		}
	}

	public void testContainer_RefBaseObject() throws Exception {
		CRI projectContainer = mModelAdapter.getContainer(getProject());
		CRI projectContainerUsed = mModelAdapter.getContainer(createUsedDc());
		{
			// M1 data
			CRI result = mModelAdapter.getContainer(mComponent);
			assertEquals("Assigned object -> CRI : ", projectContainer, result);
		}
		{
			// M1 data - null partition
			Component unassignedComp = (Component) mComponent.refClass().refCreateInstance();
			CRI result = mModelAdapter.getContainer(unassignedComp);
			assertEquals("Object in null partition -> CRI : " + result, projectContainer, result);
		}
		{
			// M1 data - transient partition
			CRI result = mModelAdapter.getContainer(mCompTransient);
			assertEquals("Object in transient partition -> CRI : " + result, projectContainer, result);
		}
		{
			// M1 data - transient connection
			CRI result = mModelAdapter.getContainer(mCompTransientConnection);
			assertEquals("Object in transient partition -> CRI : " + result, null, result);
		}
		{
			// M2 data (Web Dynpro metamodel)
			CRI result = mModelAdapter.getContainer(mComponent.refMetaObject());
			assertNotNull("Meta object -> CRI : ", result);
			assertEquals("Meta object -> CRI : ", CONTAINER_NAME_WEBDYNPRO, result.getContainerName());
		}
		{
			// M1 data - used project
			CRI result = mModelAdapter.getContainer(mComponentUsed);
			assertEquals("Object from used project -> CRI : ", projectContainerUsed, result);
		}
	}

	public void testContainer_UsingConnection() throws Exception {
		CRI projectContainer = mModelAdapter.getContainer(getProject());
		createUsedDc();
		{
			// M1 data
			CRI result = mModelAdapter.getContainerUsingConnection(mComponent);
			assertEquals("Assigned object -> CRI : ", projectContainer, result);
		}
		{
			// M1 data - null partition
			Component unassignedComp = (Component) mComponent.refClass().refCreateInstance();
			CRI result = mModelAdapter.getContainerUsingConnection(unassignedComp);
			assertEquals("Object in null partition -> CRI : " + result, projectContainer, result);
		}
		{
			// M1 data - transient partition
			CRI result = mModelAdapter.getContainerUsingConnection(mCompTransient);
			assertEquals("Object in transient partition -> CRI : " + result, projectContainer, result);
		}
		{
			// M1 data - transient connection
			CRI result = mModelAdapter.getContainerUsingConnection(mCompTransientConnection);
			assertEquals("Object in transient connection -> CRI : " + result, null, result);
		}
		{
			// M2 data (Web Dynpro metamodel)
			CRI result = mModelAdapter.getContainerUsingConnection(mComponent.refMetaObject());
			assertNotNull("Meta object -> CRI : ", result);
			assertEquals("Meta object -> CRI : ", projectContainer, result);
		}
		{
			// M1 data - used project
			CRI result = mModelAdapter.getContainerUsingConnection(mComponentUsed);
			assertEquals("Object from used project -> CRI : ", projectContainer, result);
		}
	}

	public void testContainer_Project() {
		{
			CRI result = mModelAdapter.getContainer(getProject());
			assertNotNull("Project -> CRI : ", result);
			assertEquals("Project -> CRI", getProjectContainerName(), result.getContainerName());
		}
	}

	public void testContainer_Connection() {
		{
			CRI result = mModelAdapter.getContainer(mConnection);
			assertEquals("Connection -> Container", getProjectContainerName(), result.getContainerName());
		}
		{
			CRI result = mModelAdapter.getContainer(mConnectionTransient);
			assertEquals("Transient connection -> Container", null, result);
		}
	}

	// public void testContainer_ForMetamodel() {
	// {
	// CRI result =
	// mModelAdapter.getContainerForMetamodel(CONTAINER_NAME_WEBDYNPRO);
	// assertNotNull("Metamodel name -> CRI : ", result);
	// assertEquals("Metamodel name -> CRI", CONTAINER_NAME_WEBDYNPRO,
	// result.getContainerName());
	// }
	// {
	// // Moin also accepts invalid metamodel result names
	// CRI result = mModelAdapter.getContainerForMetamodel("foobar");
	// assertNotNull("Container must be returned", result);
	// }
	// }

	public void testFile_RefBaseObject() {
		// existing partition
		{
			Partitionable p = (Partitionable) mComponent;
			PRI pri = p.get___Mri().getPri();

			IFile probe = mModelAdapter.getFile(mComponent);
			assertNotNull("Object in persistent partition -> IFile: " + pri, probe);
			assertTrue("Object in persistent partition -> IFile. File must exist: " + probe, probe.exists());
		}
		// metamodel partition
		{
			Partitionable p = (Partitionable) mComponent.refMetaObject();
			PRI pri = p.get___Mri().getPri();

			IFile probe = mModelAdapter.getFile(mComponent.refMetaObject());
			assertNull("Object in metamodel partition -> IFile: " + pri, probe);
		}
		// null partition
		{
			Component newComp = (Component) mComponent.refClass().refCreateInstance();
			Partitionable p = (Partitionable) newComp;
			PRI pri = p.get___Mri().getPri();

			IFile probe = mModelAdapter.getFile(newComp);
			assertNull("Object in null partition -> IFile: " + pri, probe);
		}
		// transient partition
		{
			IFile probe = mModelAdapter.getFile(mCompTransient);
			assertNull("Object in transient partition -> IFile: " + ((Partitionable) mCompTransient).get___Partition(),
					probe);
		}
		// transient connection
		{
			IFile probe = mModelAdapter.getFile(mCompTransientConnection);
			assertNull("Object in transient connection -> IFile: "
					+ ((Partitionable) mCompTransientConnection).get___Partition(), probe);
		}
		// new partition
		{
			PRI pri = getPri(getProject(), PARTITION_FOLDER.append(getName()));
			ModelPartition partition = mConnection.createPartition(pri);
			Component newComp = partition.createElement(Component.CLASS_DESCRIPTOR);

			IFile probe = mModelAdapter.getFile(newComp);
			assertNull("Object in transient partition -> IFile: " + probe, probe);
		}
	}

	public void testPri_File() {
		// existing file
		{
			IFile file = mModelAdapter.getFile(mComponent);
			Partitionable p = (Partitionable) mComponent;
			PRI probe = p.get___Mri().getPri();

			PRI result = mModelAdapter.getPri(file, null);
			assertNotNull("IFile for persistent partition -> PRI: " + probe, result);

			result = mModelAdapter.getPri(file, mConnection);
			assertNotNull("IFile for persistent partition -> PRI: " + probe, result);
		}
		// not existing file
		{
			IFile file = getProject().getFile("src/someFile.xmi");

			PRI result = mModelAdapter.getPri(file, null);
			assertNotNull("IFile for not existing partition -> PRI: " + file, result);

			result = mModelAdapter.getPri(file, mConnection);
			assertNull("IFile for not existing partition -> PRI: " + file, result);
		}
		// not existing file with invalid file name
		{
			IFile file = getProject().getFile("someFile.txt");

			PRI result = mModelAdapter.getPri(file, null);
			assertNull("IFile for invalid partition -> PRI: " + file, result);

			result = mModelAdapter.getPri(file, mConnection);
			assertNull("IFile for invalid partition -> PRI: " + file, result);
		}
	}

	public void testResolveObjectInConnection_Connection() {
		{
			final Connection otherConnection = createConnection();
			assertNotSame("Connections must be different", mConnection, otherConnection);

			RefBaseObject resolved = mModelAdapter.resolveInConnection(mView, otherConnection);
			Partitionable resolvedPart = (Partitionable) resolved;
			assertEquals("Resolved object must have other connection", otherConnection, resolvedPart.get___Connection());
			assertEquals("Objects must be equal", mView, resolved);
		}
		{
			RefBaseObject resolved = mModelAdapter.resolveInConnection(mView, mConnection);
			Partitionable resolvedPart = (Partitionable) resolved;
			assertEquals("Resolved object must have same connection", mConnection, resolvedPart.get___Connection());
			assertEquals("Objects must be equal", mView, resolved);
		}
	}

	public void testResolveObjectInConnection_RefBaseObject() {
		{
			final Connection otherConnection = createConnection();
			RefBaseObject objectFromOtherConnection = createComponent(otherConnection);

			RefBaseObject resolved = mModelAdapter.resolveInConnection(mView, objectFromOtherConnection);
			Partitionable resolvedPart = (Partitionable) resolved;
			assertEquals("Resolved object must have other connection", otherConnection, resolvedPart.get___Connection());
			assertEquals("Objects must be equal", mView, resolved);
		}
	}

	public void testJmiInterface() {
		{
			Class<View> result = mModelAdapter.getJmiInterface(mView);
			assertSame("RefBaseObject -> Jmi class", View.class, result);
		}
		{
			Class<RefObject> result = mModelAdapter.getJmiInterface(mComponent.refMetaObject());
			assertSame("MetaObject -> Jmi class", MofClass.class, result);
		}
		{
			try {
				Class<?> result = mModelAdapter.getJmiInterface((RefBaseObject) null);
				fail("Exception expected on null -> Jmi class: " + result);
			} catch (RuntimeException expected) {
			}
		}
	}

	public void testPartitionable() {
		Partitionable result = mModelAdapter.getPartitionable(mView);
		assertSame("RefBaseObject -> Partitionable", mView, result);
	}

	public void testAdaptObject() {
		{
			Void result = mModelAdapter.adaptObject(null, Void.class);
			assertEquals("null -> Void", null, result);
		}
		{
			View result = mModelAdapter.adaptObject(mView, View.class);
			assertEquals("InstanceOf", mView, result);
		}
		{
			IAdaptable adaptable = new TestAdaptable();
			View result = mModelAdapter.adaptObject(adaptable, View.class);
			assertEquals("IAdaptable -> RefBaseObject", mView, result);
		}
		{
			View result = mModelAdapter.adaptObject(this, View.class);
			assertEquals("IAdapterManager -> RefBaseObject", mView, result);
		}
		{
			try {
				Object result = mModelAdapter.adaptObject(null, null);
				fail("null -> null. Result was " + result);
			} catch (RuntimeException expected) {
			}
		}
	}

	private IProject createUsedDc() throws Exception {
		IProject projectUsed = TestUtil.createLocalMoinDCProject(DC_NAME_USED, MoinTestDcType.getDcType());
		mConnectionUsed = ConnectionManager.getInstance().createConnection(projectUsed);

		Component componentUsed = createComponent(mConnectionUsed);
		PRI pri = getPri(projectUsed, new Path("src/com/sap/test/used/Component"));
		ModelPartition partition = mConnectionUsed.getPartition(pri);
		if (partition != null)
			partition.delete();
		partition = mConnectionUsed.createPartition(pri);
		partition.assignElementIncludingChildren(componentUsed);
		mConnectionUsed.save();

		TestUtil.addPublicPartDependency(getProject(), DC_NAME_USED, MoinProject.VENDOR_SAP,
				MoinTestDcType.PP_NAME_COMPILATION, true, false, false);

		mComponentUsed = (Component) mConnection.getElement(((Partitionable) componentUsed).get___Mri());
		assertNotNull("Must be resolvable in using connection: " + componentUsed, mComponentUsed);
		return projectUsed;
	}

	private void deleteUsedProject() {
		IProject usedProject = TestUtil.getLocalMoinDCProject(DC_NAME_USED);
		if (usedProject != null)
			TestUtil.deleteLocalMoinDCProject(usedProject);
	}

	private void createComponentTransientConnection() {
		mConnectionTransient = ConnectionManager.getInstance().createTransientConnection();
		mCompTransientConnection = createComponent(mConnectionTransient);
	}

	private void createComponentTransientPartition() {
		ModelPartition transientPartition = mConnection.getOrCreateTransientPartition("transientPartition");
		mCompTransient = createComponent(mConnection);
		transientPartition.assignElement(mCompTransient);
	}

	private Component createComponent(Connection connection) {
		RefClass componentClass = connection.getClass(Component.CLASS_DESCRIPTOR);
		Component component = (Component) componentClass.refCreateInstance();
		component.setName("comp");
		return component;
	}

	private String getProjectContainerName() {
		return "sap.com/" + getDcName();
	}

	private final class TestAdaptable implements IAdaptable {

		@SuppressWarnings("unchecked")
		public Object getAdapter(Class adapter) {
			if (RefBaseObject.class.isAssignableFrom(adapter))
				return mView;
			return null;
		}
	}

	private final class TestAdapterFactory implements IAdapterFactory {

		@SuppressWarnings("unchecked")
		public Object getAdapter(Object adaptableObject, Class adapterType) {
			if (View.class.isAssignableFrom(adapterType))
				return mView;
			return null;
		}

		public Class<?>[] getAdapterList() {
			return new Class[] { View.class };
		}
	}

}