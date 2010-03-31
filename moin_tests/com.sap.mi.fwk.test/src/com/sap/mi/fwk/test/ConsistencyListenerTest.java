package com.sap.mi.fwk.test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.consistency.DefaultConsistencyListener;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.consistency.ConsistencyCorrectionHandle;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.DuplicateElementConsistencyViolation;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests the MiE consistency listener
 * 
 * @author d024127
 */
public class ConsistencyListenerTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/consistency";

	private Component component;
	private View view;

	private Connection connection;

	public ConsistencyListenerTest() {
		super(ConsistencyListenerTest.DC_NAME);
	}

	@Override
	protected String getDcName() {
		return ConsistencyListenerTest.DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		connection = createConnection();
		connection.getCommandStack().openGroup("create obj");

		// create first partiton
		IFile partFile = getProject().getFolder(ProjectBasedTest.SOURCE_FOLDER).getFile("partition.xmi");

		// and pri
		final PRI pri = ModelManager.getPartitionService().getPRI(getProject(), partFile.getProjectRelativePath());
		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);

		// put something in it
		final ComponentPackage compPackage = (ComponentPackage) connection.getPackage(null, new String[] { "WebDynpro", "component" });
		this.component = (Component) compPackage.getComponent().refCreateInstance( );
		this.component.setName("testComponent");
		assertNotNull(this.component);
		partition.assignElement((Partitionable) this.component);

		// a View
		final RefClass viewClass = compPackage.getView().getView();
		this.view = (View) viewClass.refCreateInstance( );
		this.view.setName("testView");
		this.component.getViews().add(this.view);

		connection.getCommandStack().closeGroup();
		connection.save();
	}

	public void testViolation() {

		MRI mri = ((Partitionable) this.view).get___Mri();

		DuplicateElementConsistencyViolation mockViolation = createMock(DuplicateElementConsistencyViolation.class);
		expect(mockViolation.getAffectedElement()).andReturn(mri);
		expect(mockViolation.getId()).andReturn("xyz");
		expect(mockViolation.getDescription(connection)).andReturn("violation desc");

		ConsistencyCorrectionHandle mockHandle = createMock(ConsistencyCorrectionHandle.class);
		expect(mockHandle.getDescription()).andReturn("handle desc");
		expect(mockHandle.getId()).andReturn("id");

		ConsistencyCorrectionHandle[] handles = new ConsistencyCorrectionHandle[] { mockHandle };
		expect(mockViolation.getCorrectionHandles(connection)).andReturn(handles);

		replay(mockViolation);
		replay(mockHandle);

		DefaultConsistencyListener dcl = new DefaultConsistencyListener();
		ConsistencyViolation[] violations = new ConsistencyViolation[] { mockViolation };
		dcl.onConsistencyViolation(violations, connection);

		verify(mockViolation);

		IMarker[] markers = MarkerManager.getInstance().findMarkers(mri, DefaultConsistencyListener.MARKER_TYPE, true);
		assertTrue("Markers not created", markers.length > 0);
	}

	public void testResolution() {
		MRI mri = ((Partitionable) this.view).get___Mri();

		DuplicateElementConsistencyViolation mockViolation = createMock(DuplicateElementConsistencyViolation.class);
		expect(mockViolation.getAffectedElement()).andReturn(mri);

		replay(mockViolation);

		DefaultConsistencyListener dcl = new DefaultConsistencyListener();
		ConsistencyViolation[] violations = new ConsistencyViolation[] { mockViolation };
		dcl.onConsistencyResolution(violations, connection);

		verify(mockViolation);

		IMarker[] markers = MarkerManager.getInstance().findMarkers(mri, DefaultConsistencyListener.MARKER_TYPE, true);
		assertTrue("Markers not removed", markers.length == 0);
	}

	public void testGetHandles() {
		String ATTR_RESOLUTION_ID = DefaultConsistencyListener.class.getName() + "resolutionid";
		String ATTR_DESCRIPTION = DefaultConsistencyListener.class.getName() + "description";

		IMarker mockMarker = createMock(IMarker.class);
		expect(mockMarker.getAttribute(ATTR_RESOLUTION_ID + "0", null)).andReturn("id 0");
		expect(mockMarker.getAttribute(ATTR_DESCRIPTION + "0", null)).andReturn("desc 0");
		expect(mockMarker.getAttribute(ATTR_RESOLUTION_ID + "1", null)).andReturn(null);

		replay(mockMarker);

		ConsistencyCorrectionHandle[] handles = DefaultConsistencyListener.getHandles(mockMarker);

		verify(mockMarker);

		assertTrue("No handles returned", handles.length == 1);
	}

	public void testGetViolationID() {
		String ATTR_VIOLATION_ID = DefaultConsistencyListener.class.getName() + "violationid";
		IMarker mockMarker = createMock(IMarker.class);
		String violationID = "violation id";
		expect(mockMarker.getAttribute(ATTR_VIOLATION_ID, null)).andReturn(violationID);

		replay(mockMarker);

		String currentViolationID = DefaultConsistencyListener.getViolationID(mockMarker);

		verify(mockMarker);

		assertEquals("Returned id does not match probe", violationID, currentViolationID);
	}
}