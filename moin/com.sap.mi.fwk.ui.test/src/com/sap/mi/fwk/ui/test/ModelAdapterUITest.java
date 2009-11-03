package com.sap.mi.fwk.ui.test;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link ModelAdapterUI}
 * 
 * @author d031150
 */
public class ModelAdapterUITest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/modeladapter/ui";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/adp/ui");
	private static final String DC_NAME_USED = "test/modeladapter/ui/used";

	private ModelAdapterUI mModelAdapter;

	private Connection mConnection;
	private Connection mConnectionUsed;

	private Component mComponent;
	private Component mComponentUsed;
	private View mView;

	private TestAdapterFactory mAdapterFactory;

	public ModelAdapterUITest() {
		super(DC_NAME);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mConnection = createConnection();

		mModelAdapter = ModelAdapterUI.getInstance();

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

		mConnection.save();

		mAdapterFactory = new TestAdapterFactory();
		Platform.getAdapterManager().registerAdapters(mAdapterFactory, ModelAdapterUITest.class);
	}

	@Override
	protected void tearDown() throws Exception {
		Platform.getAdapterManager().unregisterAdapters(mAdapterFactory, ModelAdapterUITest.class);
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
	protected String getDcName() {
		return DC_NAME;
	}

	public void testProject() throws Exception {
		IProject project = getProject();

		{
			IStructuredSelection selection = new StructuredSelection(mView);
			IProject result = mModelAdapter.getProject(selection);
			assertEquals("Selection(RefBaseObject) -> IProject", project, result);
		}
		{
			IStructuredSelection selection = StructuredSelection.EMPTY;
			IProject result = mModelAdapter.getProject(selection);
			assertEquals("Selection(<EMPTY>) -> IProject", null, result);
		}
		{
			IProject result = mModelAdapter.getProject((Object) null);
			assertEquals("null -> IProject", null, result);
		}
	}

	public void testProject_UsingConnection() throws Exception {
		IProject project = getProject();
		createUsedDc();

		{
			IStructuredSelection selection = new StructuredSelection(mComponentUsed);
			IProject result = mModelAdapter.getProjectUsingConnection(selection);
			assertEquals("Selection(RefBaseObject) -> IProject", project, result);
		}
		{
			IStructuredSelection selection = StructuredSelection.EMPTY;
			IProject result = mModelAdapter.getProjectUsingConnection(selection);
			assertEquals("Selection(<EMPTY>) -> IProject", null, result);
		}
		{
			IProject result = mModelAdapter.getProjectUsingConnection((Object) null);
			assertEquals("null -> IProject", null, result);
		}
	}

	public void testRefBaseObject() throws Exception {
		{
			IStructuredSelection selection = new StructuredSelection(this);
			RefBaseObject result = mModelAdapter.getRefBaseObject(selection);
			assertEquals("Selection(Adaptable) -> RefBaseObject", mView, result);
		}
		{
			IStructuredSelection selection = StructuredSelection.EMPTY;
			RefBaseObject result = mModelAdapter.getRefBaseObject(selection);
			assertEquals("Selection(<EMPTY>) -> RefBaseObject", null, result);
		}
		{
			RefBaseObject result = mModelAdapter.getRefBaseObject((Object) null);
			assertEquals("null -> RefBaseObject", null, result);
		}
	}

	public void testRefObject() throws Exception {
		{
			IStructuredSelection selection = new StructuredSelection(this);
			RefObject result = mModelAdapter.getRefObject(selection);
			assertEquals("Selection(Adaptable) -> RefObject", mView, result);
		}
		{
			IStructuredSelection selection = StructuredSelection.EMPTY;
			RefObject result = mModelAdapter.getRefObject(selection);
			assertEquals("Selection(<EMPTY>) -> RefObject", null, result);
		}
		{
			RefObject result = mModelAdapter.getRefObject((Object) null);
			assertEquals("null -> RefObject", null, result);
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

	private Component createComponent(Connection connection) {
		RefClass componentClass = connection.getClass(Component.CLASS_DESCRIPTOR);
		Component component = (Component) componentClass.refCreateInstance( );
		component.setName("comp");
		return component;
	}

	private final class TestAdapterFactory implements IAdapterFactory {

		@SuppressWarnings("unchecked")
		public Object getAdapter(Object adaptableObject, Class adapterType) {
			if (RefBaseObject.class.isAssignableFrom(adapterType))
				return mView;
			return null;
		}

		public Class<?>[] getAdapterList() {
			return new Class[] { RefBaseObject.class, RefObject.class };
		}
	}

}