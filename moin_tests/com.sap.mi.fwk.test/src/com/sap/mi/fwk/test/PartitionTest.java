package com.sap.mi.fwk.test;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.runtime.IPath;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test expectations on Moin's partition assignment
 * 
 * @author d031150
 */
public class PartitionTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/partition";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/partition");
	private static final String PARTITION_NAME = "Partition.xmi";

	private Connection connection;
	private ModelPartition partition;
	private Component component;
	private View view;

	public PartitionTest() {
		super(DC_NAME);
	}
	
	@Override
	protected String getDcName() {
		return DC_NAME;
	}
	
	@Override
	protected boolean deleteProjectOnTearDown() {
		return true;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		connection = createConnection();
		partition = createNewPartition(PARTITION_NAME);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Only assigns a root object (component) without children to the partition.  
	 * The view should remain unassigned.
	 */
	public void testAssignParentOnly() {
		createComponentAndView();
		
		partition.assignElement(component);
		
		Collection<Partitionable> elements = connection.getNullPartition().getElements();
		assertTrue("View is not in null partition ", elements.contains(view));
		
		try {
			connection.save();
			fail("Saving connection unexpectedly successful");
		} catch (Exception e) { //$JL-EXC$
		}
	}

	/**
	 * Implicitly assigns the root object (component) to the partition 
	 * Its children (view) should remain in the null partition.
	 */
	
	public void testAssignParentIncludingChildrenImplicit() {
		createComponentAndView();
		component.getViews().add(view);
		
		partition.assignElement(component);
		
		Collection<Partitionable> elements = connection.getNullPartition().getElements();
		assertTrue("View is not in null partition ", elements.contains(view));
		
		try {
			connection.save();
			fail("Saving connection unexpectedly successful");
		} catch (Exception e) { //$JL-EXC$
		}
	}

	/**
	 * Explicitly assigns the root object (component) to the partition, and 
	 * then creates the children (view).
	 * The null partition should be empty afterwards, connection can be saved.
	 */
	
	public void testAssignParentIncludingChildrenImplicit2() {
		createComponent();
		
		partition.assignElement(component);
		createView();
		component.getViews().add(view);
		
		Collection<Partitionable> elements = connection.getNullPartition().getElements();
		assertTrue("Null partition not empty: " + elements, elements.isEmpty());
		
		assertConnectionSave(connection);
	}

	/**
	 * Explicitly assigns the root object (component) to the partition 
	 * together with its children (view).
	 * The null partition should be empty afterwards, connection can be saved.
	 */
	public void testAssignParentIncludingChildrenExplicit() {
		createComponentAndView();
		component.getViews().add(view);
		
		partition.assignElementIncludingChildren(component);
		
		Collection<Partitionable> elements = connection.getNullPartition().getElements();
		assertTrue("Null partition not empty: " + elements, elements.isEmpty());
		
		assertConnectionSave(connection);
	}
	
	public void testCreatePartition() throws Exception {
		partition = createNewPartition(PARTITION_NAME);
		try {
			createNewPartition(PARTITION_NAME);
		} catch (RuntimeException e) {
			fail("Moin now detects duplicate partition creation: " + partition.getPri(), e);
		}
	}
	
	private void createComponentAndView() {
		createComponent();
		createView();
	}

	private void createComponent() {
		ComponentPackage compPackage = (ComponentPackage) connection.getPackage(
				CONTAINER_NAME_WEBDYNPRO, 
				PACKAGE_NAME_COMPONENT);
		assertNotNull("Component package not found", compPackage);
		
		component = (Component) compPackage.getComponent().refCreateInstance( );
		component .setName("testComponent");
		assertNotNull(component);
	}

	private void createView() {
		ViewPackage viewPackage = (ViewPackage) connection.getPackage(
				CONTAINER_NAME_WEBDYNPRO, 
				PACKAGE_NAME_VIEW);
		assertNotNull("View package not found", viewPackage);
		
		RefClass viewClass = viewPackage.getView();
		view = (View) viewClass.refCreateInstance( );
		view.setName("testView");
		assertNotNull(view);
	}

	private ModelPartition createNewPartition(String name) throws Exception {
		PRI partitionMRI = getPri(getProject(), PARTITION_FOLDER.append(name));

		ModelPartition partition = connection.getPartition(partitionMRI);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(partitionMRI);
		return partition;
	}

}
