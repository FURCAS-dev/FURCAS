package com.sap.mi.fwk.ui.test;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.fwk.ui.test.editors.TestEditorInput;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests {@link ModelEditorInput}
 * 
 * @author d024127
 */
public class ModelEditorInputTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/modeleditor/input";
	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/me/input");

	private Component component;
	private View view;
	private Connection connection;

	public ModelEditorInputTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
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

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage("sap.com/tc/moin/webdynpro/webdynpro",
				new String[] { "WebDynpro", "component" });
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
	}

	@Override
	protected void tearDown() throws Exception {
		connection = null;
		component = null;
		view = null;

		super.tearDown();
	}

	public void testCreateInput() {
		String probe = ModelAdapterUI.getInstance().getMri(component).toString();
		ModelEditorInput in = new TestEditorInput(probe);
		in.setEditorConnection(connection);
		in.setProjectName(getProject().getName());

		assertEquals("Input size not as expected", probe, in.getMriString());
		assertTrue("Input answers exists() == false", in.exists());
	}

	public void testGetAdapter() {
		final String compMriString = ((Partitionable) component).get___Mri().toString();
		final ModelEditorInput compInput = new TestEditorInput(compMriString);
		compInput.setEditorConnection(connection);
		final String viewMriName = ((Partitionable) view).get___Mri().toString();
		final ModelEditorInput viewInput = new TestEditorInput(viewMriName);
		viewInput.setEditorConnection(connection);

		RefBaseObject object = (RefBaseObject) compInput.getAdapter(RefBaseObject.class);
		String actual = ((Partitionable) object).get___Mri().toString();
		assertEquals(compMriString, actual);

		Connection adapterCon = (Connection) compInput.getAdapter(Connection.class);
		assertEquals(connection, adapterCon);

		object = (RefBaseObject) compInput.getAdapter(Component.class);
		assertNotNull("Adapted object must not be null", object);
		assertEquals("Must return component", component, object);

		object = (RefBaseObject) viewInput.getAdapter(Component.class);
		assertNotNull("Adapted object must not be null", object);
		assertEquals("Must return component", component, object);

		IProject p = (IProject) compInput.getAdapter(IProject.class);
		assertEquals("Adapted project does not match expected", getProject(), p);
	}

	public void testObjectName() {
		MRI compMri = ((Partitionable) component).get___Mri();
		ModelEditorInput compInput = new TestEditorInput(compMri);
		runNonPublicMethod(compInput, "hasName", new Object[0]);
		runNonPublicMethod(compInput, "getExceptionText", new Object[0]);
		compInput.hashCode();
		compInput.toString();
	}
}
