package com.sap.mi.fwk.ui.test;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import javax.management.ObjectName;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTable;
import com.sap.ide.junit.ui.lift.LTableItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Uielement;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.MoinConstraintChecker;
import com.sap.mi.fwk.MarkerManager.MarkerRefreshListener;
import com.sap.mi.fwk.mbeans.MarkerManagerMBean;
import com.sap.mi.fwk.ui.MarkerManagerUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests {@link MarkerManager}
 * 
 * @author d024127
 */
public class MarkerManagerTest extends WebDynproProjectTest {

	private static final String VIOLATION_ID = "test violation id";

	private static final String DC_NAME = "test/markermanager";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/marker");
	private static final String SHELL_MARKER_SELECTION_DIALOG = "MarkerSelectionDialog.SelectMarker"; // class
	// name
	private static final String SHELL_QUICKFIX_SELECTION_DIALOG = "QuickfixSelectionDialog.SelectQuickfix"; // class
	private static final String TEST_MARKER_TYPE = "com.sap.mi.fwk.ui.test.testmarker";

	// name
	private Connection connection;
	private IFile partitionFile;

	private Component component;
	private View view;
	private View view1;

	private Uielement uiElem;

	private LShell mShell;
	private Display mDisplay;
	private LFactory mAbbotFactory;

	private boolean lastAutoBuildState;

	public MarkerManagerTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.prepareWorkbench();
		lastAutoBuildState = PDEUtil.setAutoBuilding(false);

		connection = createConnection();

		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage("sap.com/tc/moin/webdynpro/webdynpro",
				new String[] { "WebDynpro", "component" });
		component = (Component) compPackage.getComponent().refCreateInstance( );
		component.setName("testComponent");
		partition.assignElement((Partitionable) component);

		// a View
		RefClass viewClass = compPackage.getView().getView();
		view = (View) viewClass.refCreateInstance( );
		view.setName("testView");
		view1 = (View) viewClass.refCreateInstance( );
		view1.setName("testView1");
		component.getViews().add(view);
		component.getViews().add(view1);

		// RootUIElementContainer
		UielementPackage uielementPackage = compPackage.getView().getUielement();
		RefClass uielementContainerClass = uielementPackage.getTransparentContainer();
		TransparentContainer rootContainer = (TransparentContainer) uielementContainerClass.refCreateInstance( );
		rootContainer.setName("RootElement");
		view.setRootUielementContainer(rootContainer);

		uiElem = (Uielement) compPackage.getView().getUielement().getUielement().refCreateInstance( );
		view.getRootUielementContainer().getChildren().add(uiElem);

		ModelManager.getConnectionManager().save(connection);

		// retrieve file after connection.save() because file may not be there
		// before
		partitionFile = ModelAdapter.getInstance().getFile(pri);
		// clean all markers before next test
		if (partitionFile != null && partitionFile.exists())
			partitionFile.deleteMarkers(null, true, IResource.DEPTH_INFINITE);

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(5000);
		mDisplay = Display.getDefault();
		mShell = mAbbotFactory.getShell(mDisplay);
	}

	@Override
	protected void tearDown() throws Exception {
		connection.close();
		connection = null;
		component = null;
		view = null;

		partitionFile.deleteMarkers(null, true, IResource.DEPTH_INFINITE);
		partitionFile = null;

		// close a potentially remaining dialog
		mShell.enter(mAbbotFactory.key().esc());

		PDEUtil.setAutoBuilding(lastAutoBuildState);

		super.tearDown();
	}

	public void testInitCache() {
		Object cache = getMarkerCache();
		runNonPublicMethod(cache, "clear", new Object[0]);
	}
	
	public void testDeleteObjectFewMarkers() {

		addMarker("1", IMarker.PROBLEM, component);
		addMarker("2", IMarker.PROBLEM, view);
		addMarker("3", IMarker.PROBLEM, view1);

		IMarker[] markers = MarkerManager.getInstance().findMarkers(view1, IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		assertTrue(markers.length == 1);

		MRI mri = ((Partitionable) view1).get___Mri();
		connection.getCommandStack().openGroup("Delete obj");
		view1.refDelete();
		connection.getCommandStack().closeGroup();

		markers = MarkerManager.getInstance().findMarkers(mri, IMarker.PROBLEM, true);
		assertTrue(markers.length == 1);

		try {
			connection.save();
		} catch (Exception e) {
			fail(e);
		}

		markers = MarkerManager.getInstance().findMarkers(mri, IMarker.PROBLEM, true);
		assertTrue(markers.length == 0);
	}

	public void testDeleteObjectManyMarkers() {

		addMarker("1", IMarker.PROBLEM, component);
		addMarker("2", IMarker.PROBLEM, view);
		addMarker("3", IMarker.PROBLEM, view1);

		IWorkspaceRunnable operation = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				for (int i = 0; i < 1000; i++) {
					addMarker("marker" + i, "some type", view1);
				}
			}
		};
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		try {
			workspace.run(operation, null, IWorkspace.AVOID_UPDATE, null);
		} catch (Exception e) {
			fail(e);
		}

		IMarker[] markers = MarkerManager.getInstance().findMarkers(view1, IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		assertTrue(markers.length == 1);

		MRI mri = ((Partitionable) view1).get___Mri();
		connection.getCommandStack().openGroup("Delete obj");
		view1.refDelete();
		connection.getCommandStack().closeGroup();

		markers = MarkerManager.getInstance().findMarkers(mri, IMarker.PROBLEM, true);
		assertTrue(markers.length == 1);

		try {
			connection.save();
		} catch (Exception e) {
			fail(e);
		}

		markers = MarkerManager.getInstance().findMarkers(mri, IMarker.PROBLEM, true);
		assertTrue(markers.length == 0);
	}

	/**
	 * This test creates two objects in two partitons along with markers and
	 * deletes the objects. Afterwards all markers must be gone
	 */
	public void testDeleteObjectsInMultiplePartitons() {
		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("Partition1"));
		ModelPartition partition1 = connection.getPartition(pri);
		if (partition1 != null) {
			partition1.delete();
		}
		partition1 = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition1);

		pri = getPri(getProject(), PARTITION_FOLDER.append("Partition2"));
		ModelPartition partition2 = connection.getPartition(pri);
		if (partition2 != null) {
			partition2.delete();
		}
		partition2 = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition2);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage("sap.com/tc/moin/webdynpro/webdynpro",
				new String[] { "WebDynpro", "component" });
		Component component1 = (Component) compPackage.getComponent().refCreateInstance( );
		component1.setName("testComponent");
		partition1.assignElement((Partitionable) component1);

		Component component2 = (Component) compPackage.getComponent().refCreateInstance( );
		component2.setName("testComponent");
		partition2.assignElement((Partitionable) component2);

		try {
			connection.save();
		} catch (Exception e) {
			fail(e);
		}

		ModelManager.getMarkerManager().createMarker(component1, IMarker.PROBLEM, IMarker.SEVERITY_ERROR,
				"message marker 1");
		ModelManager.getMarkerManager().createMarker(component2, IMarker.PROBLEM, IMarker.SEVERITY_ERROR,
				"message marker 2");

		IMarker[] markers = ModelManager.getMarkerManager().findMarkers(component1, null, true,
				IResource.DEPTH_INFINITE);
		assertTrue("Markers not found", markers.length > 0);
		markers = ModelManager.getMarkerManager().findMarkers(component2, null, true, IResource.DEPTH_INFINITE);
		assertTrue("Markers not found", markers.length > 0);

		MRI mri1 = ((Partitionable) component1).get___Mri();
		MRI mri2 = ((Partitionable) component2).get___Mri();

		connection.getCommandStack().openGroup("Delete obj");
		component1.refDelete();
		component2.refDelete();
		connection.getCommandStack().closeGroup();

		try {
			connection.save();
		} catch (Exception e) {
			fail(e);
		}

		markers = ModelManager.getMarkerManager().findMarkers(mri1, null, true);
		assertTrue("Markers must be deleted", markers.length == 0);
		markers = ModelManager.getMarkerManager().findMarkers(mri2, null, true);
		assertTrue("Markers must be deleted", markers.length == 0);
	}

	public void testTimeRecOverhead() {
		// this test does nothing but testing how long it takes the framework to
		// execute it
	}

	public void testCreateMarker1() {

		try {
			IMarker marker = ModelManager.getMarkerManager().createMarker(component, IMarker.PROBLEM,
					IMarker.SEVERITY_ERROR, "message");

			assertNotNull(partitionFile.findMarker(marker.getId()));

			assertEquals("Marker message did not match", "message", marker.getAttribute(IMarker.MESSAGE));
			assertEquals("Marker severity did not match", IMarker.SEVERITY_ERROR, marker.getAttribute(IMarker.SEVERITY));

			marker.delete();
			assertNull(partitionFile.findMarker(marker.getId()));

		} catch (Exception e) {
			fail(e);
		}
	}

	public void testCreateMarker2() {

		try {
			IMarker marker = addMarker("1", IMarker.PROBLEM, component);
			String mriName = ((Partitionable) component).get___Mri().toString();

			assertNotNull(partitionFile.findMarker(marker.getId()));
			assertEquals("OBJ_MRI not identical", mriName, marker.getAttribute(MarkerManager.ATTRIBUTE_OBJ_MRI));
			marker.delete();
		} catch (Exception e) {
			fail(e);
		}
	}

	public void testCreateMarker3() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attribute", "value");
		IMarker marker = ModelManager.getMarkerManager().createMarker(component, IMarker.PROBLEM,
				IMarker.SEVERITY_ERROR, "message ", map);
		assertNotNull(marker);
		String attribute = marker.getAttribute("attribute", null);
		assertEquals("Attribute value not set", "value", attribute);
	}

	public void testCreateMarkerSecObjects1() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attribute", "value");
		Set<RefBaseObject> secObjects = new HashSet<RefBaseObject>(1);
		secObjects.add(view);
		IMarker marker = ModelManager.getMarkerManager().createMarker(component, secObjects, IMarker.PROBLEM,
				IMarker.SEVERITY_ERROR, "message ", map);
		assertNotNull(marker);
		String attribute = marker.getAttribute("attribute", null);
		assertEquals("Attribute value not set", "value", attribute);
	}

	public void testDeleteMarker() {
		IMarker marker = addMarker("2", IMarker.PROBLEM, component);
		ModelManager.getMarkerManager().deleteMarker(marker);
		try {
			assertNull(partitionFile.findMarker(marker.getId()));
			marker.delete();
		} catch (Exception e) {
			fail("Marker not deleted", e);
		}
	}

	public void testDepthInfiniteDeleteManyMarkers() {
		for (int i = 0; i < 50; i++) {
			addMarker("1", IMarker.PROBLEM, component);
			addMarker("2", IMarker.PROBLEM, view);
			addMarker("3", IMarker.PROBLEM, uiElem);
		}

		ModelManager.getMarkerManager().deleteMarkers(component, null, true, IResource.DEPTH_INFINITE);
		try {
			assertEquals("Marker array must be empty", 0, partitionFile.findMarkers(null, true,
					IResource.DEPTH_INFINITE).length);
		} catch (CoreException e) {
			fail(e);
		}
	}

	public void testRemoveAllMarkersObject() {

		addMarker("1", IMarker.PROBLEM, component);
		addMarker("2", IMarker.PROBLEM, component);
		addMarker("3", IMarker.PROBLEM, component);
		addMarker("4", IMarker.PROBLEM, component);
		ModelManager.getMarkerManager().deleteMarkers(component, null, true, IResource.DEPTH_INFINITE);
		try {
			IMarker[] markers = partitionFile.findMarkers(null, true, IResource.DEPTH_INFINITE);
			assertTrue("Not all markers deleted: " + markers, markers.length == 0);
		} catch (CoreException e) {
			fail("Marker not deleted", e);
		}
	}

	public void testRemoveAllMarkersPartition() {

		addMarker("1", IMarker.PROBLEM, component);
		addMarker("2", IMarker.PROBLEM, component);
		addMarker("3", IMarker.PROBLEM, component);
		addMarker("4", IMarker.PROBLEM, component);
		ModelManager.getMarkerManager().deleteMarkers(((Partitionable) component).get___Partition(), null, true,
				IResource.DEPTH_INFINITE);
		try {
			IMarker[] markers = partitionFile.findMarkers(null, true, IResource.DEPTH_INFINITE);
			assertTrue("Not all markers deleted: " + markers, markers.length == 0);
		} catch (CoreException e) {
			fail("Marker not deleted", e);
		}
	}

	public void testFindMarkersMRI() {
		Set<IMarker> expected = new HashSet<IMarker>();
		expected.add(addMarker("1", IMarker.PROBLEM, component));
		expected.add(addMarker("2", IMarker.PROBLEM, component));
		addMarker("3", IMarker.PROBLEM, view);
		addMarker("4", IMarker.PROBLEM, uiElem);

		MRI mri = ((Partitionable) component).get___Mri();
		IMarker[] result = ModelManager.getMarkerManager().findMarkers(mri, null, true);
		assertEquals(expected, asSet(result));
	}

	public void testFindMarkersObject() {
		Set<IMarker> expected = new HashSet<IMarker>();
		expected.add(addMarker("1", IMarker.PROBLEM, component));
		expected.add(addMarker("2", IMarker.PROBLEM, component));
		addMarker("3", IMarker.PROBLEM, view);
		addMarker("4", IMarker.PROBLEM, uiElem);

		IMarker[] result = ModelManager.getMarkerManager().findMarkers(component, null, true, IResource.DEPTH_ZERO);
		assertEquals(expected, asSet(result));
	}

	public void testDepthOneFindMarkersObject() {
		Set<IMarker> expected = new HashSet<IMarker>();
		expected.add(addMarker("1", IMarker.PROBLEM, component));
		expected.add(addMarker("2", IMarker.PROBLEM, view));

		IMarker[] result = ModelManager.getMarkerManager().findMarkers(component, null, true, IResource.DEPTH_ONE);
		assertEquals(expected, asSet(result));
	}

	public void testDepthInfiniteFindMarkersObject() {
		Set<IMarker> expected = new HashSet<IMarker>();
		expected.add(addMarker("1", IMarker.PROBLEM, component));
		expected.add(addMarker("2", IMarker.PROBLEM, view));
		expected.add(addMarker("3", IMarker.PROBLEM, uiElem));

		IMarker[] result = ModelManager.getMarkerManager().findMarkers(component, null, true, IResource.DEPTH_INFINITE);
		assertEquals(expected, asSet(result));
	}

	public void testFindMarkersPartiton() {
		Set<IMarker> expected = new HashSet<IMarker>();
		// add marker to object contained in partition
		expected.add(addMarker("1", IMarker.PROBLEM, view));
		expected.add(addMarker("2", IMarker.PROBLEM, view));

		IMarker[] result = ModelManager.getMarkerManager().findMarkers(((Partitionable) component).get___Partition(),
				null, true, IResource.DEPTH_INFINITE);
		assertEquals(expected, asSet(result));
	}

	public void testFindMarkersTypeObject() {
		Set<IMarker> expected = new HashSet<IMarker>();
		expected.add(addMarker("1", IMarker.PROBLEM, component));
		expected.add(addMarker("2", IMarker.PROBLEM, component));

		Set<IMarker> expected2 = new HashSet<IMarker>();
		expected2.add(addMarker("1", IMarker.TASK, component));

		addMarker("2", IMarker.BOOKMARK, component);

		IMarker[] result = ModelManager.getMarkerManager().findMarkers(component, IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		assertEquals(expected, asSet(result));

		result = ModelManager.getMarkerManager().findMarkers(component, IMarker.TASK, true, IResource.DEPTH_INFINITE);
		assertEquals(expected2, asSet(result));
	}

	public void testFindMarkersTypePartition() {
		Set<IMarker> expected = new HashSet<IMarker>();
		expected.add(addMarker("1", IMarker.PROBLEM, component));
		expected.add(addMarker("2", IMarker.PROBLEM, component));

		Set<IMarker> expected2 = new HashSet<IMarker>();
		expected2.add(addMarker("1", IMarker.TASK, component));

		addMarker("2", IMarker.BOOKMARK, component);

		IMarker[] result = ModelManager.getMarkerManager().findMarkers(((Partitionable) component).get___Partition(),
				IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		assertEquals(expected, asSet(result));

		result = ModelManager.getMarkerManager().findMarkers(component, IMarker.TASK, true, IResource.DEPTH_INFINITE);
		assertEquals(expected2, asSet(result));
	}

	public void testGetObject() {
		IMarker marker = addMarker("testGetObject 1", IMarker.PROBLEM, component);
		RefBaseObject obj = ModelManager.getMarkerManager().getObject(connection, marker);
		assertEquals("Returned object is not equal to expected", component, obj);
	}

	public void testAddListener() {
		MarkerRefreshListener listener = new MarkerRefreshListener() {
			public void onMarkerChange(IProject affectedProject) {
			}
		};
		boolean result = ModelManager.getMarkerManager().addRefreshListener(listener);
		assertTrue("Listener not added", result);

		result = ModelManager.getMarkerManager().addRefreshListener(listener);
		assertFalse("Listener added twice", result);

		ModelManager.getMarkerManager().removeRefreshListener(listener);
	}

	public void testRemoveListener() {
		MarkerRefreshListener listener = new MarkerRefreshListener() {
			public void onMarkerChange(IProject affectedProject) {
			}
		};
		boolean result = ModelManager.getMarkerManager().addRefreshListener(listener);
		assertTrue("Listener not added", result);

		result = ModelManager.getMarkerManager().removeRefreshListener(listener);
		assertTrue("Listener not removed", result);

		result = ModelManager.getMarkerManager().removeRefreshListener(listener);
		assertFalse("Listener removed twice", result);
	}

	public void testFireEvents() {

		final boolean[] eventFired = new boolean[] { false };
		MarkerRefreshListener listener = new MarkerRefreshListener() {
			public void onMarkerChange(IProject affectedProject) {
				eventFired[0] = true;
			}
		};
		ModelManager.getMarkerManager().addRefreshListener(listener);

		IMarker marker = ModelManager.getMarkerManager().createMarker(component, "dummy", IMarker.SEVERITY_ERROR,
				"testmarker");
		try {
			assertNotNull(partitionFile.findMarker(marker.getId()));
		} catch (CoreException e) {
			fail(e);
		}

		// give resource change listener a chance to fire events
		long start = System.currentTimeMillis();
		while (!eventFired[0] && (System.currentTimeMillis() - start) < 5000) {
			// wait
		}

		assertTrue("Event not fired", eventFired[0]);

		ModelManager.getMarkerManager().removeRefreshListener(listener);
	}

	public void testCreateMarkerSecObjects2() {
		Set<RefBaseObject> secondaryObjects = new HashSet<RefBaseObject>();
		secondaryObjects.add(view);
		secondaryObjects.add(view1);
		Set<String> expectedMriSet = new HashSet<String>();
		for (RefBaseObject obj : secondaryObjects) {
			expectedMriSet.add(((Partitionable) obj).get___Mri().toString());
		}

		IMarker marker = ModelManager.getMarkerManager().createMarker(component, secondaryObjects, IMarker.PROBLEM,
				IMarker.SEVERITY_ERROR, "marker w/ secondary objects");

		String[] secondaryObjMris = ModelManager.getMarkerManager().getSecondaryObjectMris(marker);
		Set<String> actualMriSet = asSet(secondaryObjMris);
		assertEquals(expectedMriSet, actualMriSet);
	}

	public void testQuickfixCancel() throws InterruptedException {
		IMarker marker1 = addMarker("1", "dummy", component);
		IMarker marker2 = addMarker("2", "dummy", component);

		// PDEUtil.safeJoinAutoBuild(mAbbotFactory.getWaitTimeout());

		IMarker[] probe = ModelManager.getMarkerManager().findMarkers(component, "dummy", true,
				IResource.DEPTH_INFINITE);
		assertEquals(2, probe.length);

		final IMarker[] markers = { marker1, marker2 };

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				MarkerManagerUI.getInstance().runQuickfix(markers);
				return null;
			}
		};

		try {
			mShell.asyncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		LShell dialogShell;
		try {
			dialogShell = waitForDialog(mShell, SHELL_MARKER_SELECTION_DIALOG);
			pressCancel(dialogShell);
		} catch (Exception e) {
			fail(e);
		}

		/*
		 * TestUtil.runAsyncAndWait(new Callable<IStatus>() { public IStatus
		 * call() throws Exception { boolean result = return result ?
		 * Status.OK_STATUS : Status.CANCEL_STATUS; } }, new Callable<Void>() {
		 * public Void call() throws Exception { LShell dialogShell =
		 * waitForDialog(mShell, SHELL_MARKER_SELECTION_DIALOG);
		 * pressCancel(dialogShell); return null; } }, true // do not fail on
		 * cancellation );
		 */
		probe = ModelManager.getMarkerManager().findMarkers(component, "dummy", true, IResource.DEPTH_INFINITE);
		assertEquals(2, probe.length);
	}

	public void testHasQuickfix() {
		MoinConstraintChecker checker = new MoinConstraintChecker();
		final IMarker marker1 = addMarker("1", checker.getMarkerType(), component);
		final IMarker marker2 = addMarker("2", checker.getMarkerType(), component);

		IMarker[] markers = new IMarker[] { marker1, marker2 };
		assertTrue("Quickfixes must be available for markers: " + Arrays.toString(markers), MarkerManagerUI
				.getInstance().hasQuickfixes(markers));
	}

	public void testQuickfixSelect() {
		final IMarker marker1 = addMarker("1", TEST_MARKER_TYPE, component);
		final IMarker marker2 = addMarker("2", TEST_MARKER_TYPE, component);

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				ModelManagerUI.getMarkerManagerUI().runQuickfix(new IMarker[] { marker1, marker2 });
				return null;
			}
		};

		try {
			mShell.asyncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		try {
			mAbbotFactory.setTryMultipleClicks(false);
			LShell dialogShell = waitForDialog(mShell, SHELL_MARKER_SELECTION_DIALOG);
			LTable table = dialogShell.table().withName("MarkerSelectionDialog.SelectMarker.list");
			LTableItem markerItem = table.tableItem().withText("message 2").resolve();
			mShell.clickOn(markerItem);
			pressOk(dialogShell);

			dialogShell = waitForDialog(mShell, SHELL_QUICKFIX_SELECTION_DIALOG);
			table = dialogShell.table().withName("QuickfixSelectionDialog.SelectQuickfix.list");
			LTableItem quickfixItem = table.tableItem().withText("testquickfix true");
			quickfixItem.resolve();
			mShell.clickOn(quickfixItem);
			pressOk(dialogShell);
			mAbbotFactory.setTryMultipleClicks(true);
		} catch (Exception e) {
			fail(e);
		}

		ModelManager.getMarkerManager().findMarkers(component, TEST_MARKER_TYPE, true, IResource.DEPTH_INFINITE);
	}

	public void testNullMarkerQuickfix() {
		boolean result = ModelManagerUI.getMarkerManagerUI().runQuickfix(new IMarker[] { null });
		assertFalse(result);
	}

	public void testFindMaxProblemSeverity() {
		IMarker marker = ModelManager.getMarkerManager().createMarker(component, "dummy", IMarker.SEVERITY_INFO,
				"message 1");
		assertNotNull(marker);
		int maxSeverity = ModelManager.getMarkerManager().findMaxProblemSeverity(component, "dummy", true,
				IResource.DEPTH_INFINITE);
		assertEquals("Max severity should be info", IMarker.SEVERITY_INFO, maxSeverity);

		marker = ModelManager.getMarkerManager()
				.createMarker(component, "dummy", IMarker.SEVERITY_WARNING, "message 2");
		assertNotNull(marker);
		maxSeverity = ModelManager.getMarkerManager().findMaxProblemSeverity(component, "dummy", true,
				IResource.DEPTH_INFINITE);
		assertEquals("Max severity should be warning", IMarker.SEVERITY_WARNING, maxSeverity);

		marker = ModelManager.getMarkerManager().createMarker(component, "dummy", IMarker.SEVERITY_ERROR, "message 3");
		assertNotNull(marker);
		maxSeverity = ModelManager.getMarkerManager().findMaxProblemSeverity(component, "dummy", true,
				IResource.DEPTH_INFINITE);
		assertEquals("Max severity should be error", IMarker.SEVERITY_ERROR, maxSeverity);

	}

	public void testBean() throws Exception {

		boolean jmxEnabled = (System.getProperty("com.sun.management.jmxremote.port") != null);
		assertTrue("JMX is not enabled", jmxEnabled);

		// create mbean
		ModelManager.getMarkerManager();

		Field f = MarkerManager.class.getDeclaredField("JMX_NAME");
		f.setAccessible(true);
		String name = (String) f.get(null);
		ObjectName mBeanName = new ObjectName(name);
		assertTrue("MBean not registered in MBeanServer", ManagementFactory.getPlatformMBeanServer().isRegistered(
				mBeanName));

		// ManagementFactory.getPlatformMBeanServer().

		Method getBean = MarkerManager.class.getDeclaredMethod("getBean", (Class[]) null);
		getBean.setAccessible(true);
		MarkerManagerMBean bean = (MarkerManagerMBean) getBean.invoke(MarkerManager.getInstance(), (Object[]) null);
		assertNotNull("JMX bean was null", bean);

		MarkerRefreshListener listener = new MarkerRefreshListener() {
			public void onMarkerChange(IProject affectedProject) {
			}
		};
		ModelManager.getMarkerManager().addRefreshListener(listener);

		String[] listenerNames = bean.getListeners();
		boolean found = false;
		for (String string : listenerNames) {
			if (listener.toString().equals(string)) {
				found = true;
				break;
			}
		}
		assertTrue("Listerner not registered", found);

		ModelManager.getMarkerManager().removeRefreshListener(listener);

		listenerNames = bean.getListeners();
		found = false;
		for (String string : listenerNames) {
			if (listener.getClass().getName().equals(string)) {
				found = true;
				break;
			}
		}
		assertFalse("Listerner not deregistered", found);
	}

	private final Object getMarkerCache() {
		Object cache = null;
		try {
			Field cacheField = MarkerManager.class.getDeclaredField("markerCache");
			cacheField.setAccessible(true);
			cache = cacheField.get(MarkerManager.getInstance());
		} catch (Exception e) {
			fail(e);
		}
		return cache;
	}

	private static LShell waitForDialog(LShell parent, String name) throws WidgetException {
		LShell dialogShell = parent.waitForShowing(parent.childShell().withName(name));
		assertNotNull("No Dialog shell found", dialogShell);
		return dialogShell;
	}

	private void pressCancel(LShell dialog) throws Exception {
		LButton button = dialog.button().cancel();
		assertNotNull("No Cancel button found", button);
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	private void pressOk(LShell dialog) throws Exception {
		LButton button = dialog.button().ok();
		assertNotNull("No Ok button found", button);
		dialog.clickOn(button);
		dialog.waitForClosed();
	}

	private IMarker addMarker(String id, String type, RefBaseObject obj) {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put(MoinConstraintChecker.ATT_VIOLATION_ID, VIOLATION_ID);
		IMarker marker = ModelManager.getMarkerManager().createMarker(obj, type, IMarker.SEVERITY_ERROR,
				"message " + id, attributes);
		assertNotNull(marker);
		assertTrue("Marker does not exist", marker.exists());
		return marker;
	}

	private <T> Set<T> asSet(T... arg) {
		Set<T> result = new HashSet<T>(arg.length);
		for (T o : arg) {
			result.add(o);
		}
		return result;
	}
}
