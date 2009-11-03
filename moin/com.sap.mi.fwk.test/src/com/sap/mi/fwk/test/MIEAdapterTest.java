package com.sap.mi.fwk.test;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.MieAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link MieAdapter}
 * 
 * @author d031150
 */
public class MIEAdapterTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/mieadapter";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/adp");

	private Connection connection;
	private Component component;
	private View view;
	private TestAdapterFactory mAdapterFactory;

	public MIEAdapterTest() {
		super(DC_NAME);
	}

	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		connection = createConnection();

		PRI partitionMRI = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = connection.getPartition(partitionMRI);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(partitionMRI);
		assertNotNull("Partition creation failed", partition);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(null, new String[] { "WebDynpro",
				"component" });
		component = (Component) compPackage.getComponent().refCreateInstance( );
		component.setName("testComponent");
		assertNotNull(component);
		partition.assignElement((Partitionable) component);

		// a View
		RefClass viewClass = compPackage.getView().getView();
		view = (View) viewClass.refCreateInstance( );
		view.setName("testView");
		component.getViews().add(view);

		connection.save();
		
		mAdapterFactory = new TestAdapterFactory();
		Platform.getAdapterManager().registerAdapters(mAdapterFactory, MIEAdapterTest.class);
	}

	@Override
	protected void tearDown() throws Exception {
		Platform.getAdapterManager().unregisterAdapters(mAdapterFactory, MIEAdapterTest.class);
		connection = null;
		super.tearDown();
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@SuppressWarnings("deprecation")
	public void testAdaptTo() {
		{
			Void result = MieAdapter.adaptTo(null, Void.class);
			assertEquals("null -> null", null, result);
		}
		{
			View result = MieAdapter.adaptTo(view, View.class);
			assertEquals("InstanceOf", view, result);
		}
		{
			IAdaptable adaptable = new TestAdaptable();
			View result = MieAdapter.adaptTo(adaptable, View.class);
			assertEquals("IAdaptable -> RefBaseObject", view, result);
		}
		{
			View result = MieAdapter.adaptTo(this, View.class);
			assertEquals("IAdapterManager -> RefBaseObject", view, result);
		}
		{
			Connection result = MieAdapter.adaptTo(view, Connection.class);
			assertEquals("RefBaseObject -> Connection", connection, result);
		}
		{
			IResource resource = getProject().getFile(new Path(".project"));
			IProject result = MieAdapter.adaptTo(resource, IProject.class);
			assertEquals("IResource -> IProject", getProject(), result);
		}
		{
			IProject result = MieAdapter.adaptTo(view, IProject.class);
			assertEquals("RefBaseObject -> IProject", getProject(), result);
		}
		{
			IProject result = MieAdapter.adaptTo(connection, IProject.class);
			assertEquals("Connection -> IProject", getProject(), result);
		}
		{
			IAdaptable adaptable = new TestAdaptable();
			IProject result = MieAdapter.adaptTo(adaptable, IProject.class);
			assertEquals("IAdaptable -> IProject", getProject(), result);
		}
		{
			JmiHelper result = MieAdapter.adaptTo(view, JmiHelper.class);
			assertEquals("RefBaseObject -> JmiHelper", connection.getJmiHelper(), result);
		}
	}

	@SuppressWarnings("deprecation")
	public void testGetProject() {
		IProject result = MieAdapter.getProject(view);
		assertEquals("MRI -> IProject", getProject(), result);
	}

	@SuppressWarnings("deprecation")
	public void testGetElementInConnection() {

		Connection newConnection = createConnection();
		assertNotSame("Connections must be different", connection, newConnection);
		Partitionable part = (Partitionable) view;

		View newView = MieAdapter.getElementInConnection(view, newConnection);
		Partitionable newPart = (Partitionable) newView;

		assertEquals("Original connection for view must not change", connection, part.get___Connection());
		assertEquals("Original connection for newView must be new connection", newConnection, newPart
				.get___Connection());

		assertEquals("Objects must be equal", view, newView);
	}

	private final class TestAdaptable implements IAdaptable {
		
		@SuppressWarnings("unchecked")
		public Object getAdapter(Class adapter) {
			if (RefBaseObject.class.isAssignableFrom(adapter))
				return view;
			return null;
		}
	}

	private final class TestAdapterFactory implements IAdapterFactory {
		
		@SuppressWarnings("unchecked")
		public Object getAdapter(Object adaptableObject, Class adapterType) {
			if (View.class.isAssignableFrom(adapterType))
				return view;
			return null;
		}

		
		public Class<?>[] getAdapterList() {
			return new Class[] {View.class};
		}
	}

}