package com.sap.mi.fwk.test;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.runtime.IPath;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test expectations on Moin {@link Connection connections} and proxies
 * 
 * @author d031150
 */
public class ConnectionTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/connection";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/conn");

	private Connection connection1;
	private Connection connection2;

	public ConnectionTest() {
		super(DC_NAME);
	}
	
	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		connection1 = createConnection();
		connection2 = createConnection();
	}

	@Override
	protected void tearDown() throws Exception {
		connection1 = null;
		connection2 = null;
		
		super.tearDown();
	}
	
	public void testObjectEquality() {
		Component component1 = createComponent(connection1, true, true);
		MRI mri1 = ModelAdapter.getInstance().getMri(component1);
		
		Component component2 = (Component) connection2.getElement(mri1);
		assertNotNull("MRI " + mri1 + " could not be resolved with connection " + connection2, component2);
		
		assertNotSame(
				"Components from two connections are identical: " + connection1 + ", " + connection2, 
				component1, component2);
		assertEquals(
				"Components from two connections are not equal: " + connection1 + ", " + connection2, 
				mri1, ModelAdapter.getInstance().getMri(component2));
	}

	public void testConnectionSwitching() {
		Component component = createComponent(connection1, true, true);
		View view = createView(connection2, ((Partitionable) component).get___Partition(), true);
		try {
			component.getViews().add(view);
			Connection viewConn = ((Partitionable) view).get___Connection();
			// Moin internally works with parent's connection, but leaves the proxy's connection untouched
			assertFalse(
					"Child view proxy has switched to parent proxy's connection", 
					connection1.equals(viewConn));
		} catch (RuntimeException e) {
			fail(e);
		}
	}
	
	public void testGetPartitionsToBeSaved() {
		Component component = createComponent(connection1, true, false);
		ModelPartition partition = ((Partitionable) component).get___Partition();
		Collection<ModelPartition> partitions = connection1.getPartitionsToBeSaved();
		assertTrue("Partition is not dirty: " + partition.getPri(), partitions.contains(partition));
		
		component = createComponent(connection1, false, false);
		partition = ((Partitionable) component).get___Partition();
		partitions = connection1.getPartitionsToBeSaved();
		assertFalse("Null Partition must not be contained in the dirty partition set: " 
				+ partitions, partitions.contains(partition));
	}

	public void testIsDirty() {
		Component component = createComponent(connection1, false, false);
		ModelPartition partition = ((Partitionable) component).get___Partition();
		assertTrue("Connection.isDirty must answer true for null partition: " 
				+ partition, connection1.isDirty());
	}

	private Component createComponent(Connection connection, boolean assign, boolean save) {
		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(
				CONTAINER_NAME_WEBDYNPRO, 
				PACKAGE_NAME_COMPONENT);
		assertNotNull("Component package not found", compPackage);
		
		Component component = (Component) compPackage.getComponent().refCreateInstance( );
		component.setName("testComponent");
		
		if (assign) {
			ModelPartition partition = createNewPartition(connection);
			partition.assignElement(component);
		}
		
		if (save)
			assertConnectionSave(connection, true);

		return component;
	}

	private View createView(Connection connection, ModelPartition partition, boolean save) {
		ViewPackage viewPackage = (ViewPackage) connection.getPackage(
				CONTAINER_NAME_WEBDYNPRO, 
				PACKAGE_NAME_VIEW);
		assertNotNull("View package not found", viewPackage);
		
		RefClass viewClass = viewPackage.getView();
		View view = (View) viewClass.refCreateInstance( );
		view.setName("testView");
		
		if (partition != null) {
			try {
				// Next call fails since partition's connection cannot obtain lock for 
				// view's current partition (null partition).
				partition.assignElement(view);
				fail("Partition assignment shouldn't work (see CSN 1007955): " + view + "->" + partition);
			} catch (RuntimeException e) {
				// Instead resolve partition view's connection, which already has the lock.
				connection.getPartition(partition.getPri()).assignElement(view);
			}
		}
		
		if (save)
			assertConnectionSave(connection, true);

		return view;
	}

	private ModelPartition createNewPartition(Connection connection) {
		PRI partitionMRI = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = connection.getPartition(partitionMRI);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(partitionMRI);
		return partition;
	}

}
