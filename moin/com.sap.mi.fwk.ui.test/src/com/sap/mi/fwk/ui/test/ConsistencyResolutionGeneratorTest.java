package com.sap.mi.fwk.ui.test;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.commands.CommandManagerCore;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Smoke test for {@link CommandManagerCore} and {@link CommandManager}, that
 * implicitly tests basic connection handling and editor launching as well.
 * 
 * @author d031150
 */
public class ConsistencyResolutionGeneratorTest extends WebDynproProjectTest {

	private static final String DC_NAME = ConsistencyResolutionGeneratorTest.class.getName();

	private static final IPath PARTITION_FOLDER = WebDynproProjectTest.SOURCE_FOLDER_WEBDYNPRO
			.append("com/sap/test/cmdmgr");

	private Component component;
	private View view;
	private Connection connection;

	private LFactory mAbbotFactory;

	public ConsistencyResolutionGeneratorTest() {
		this(ConsistencyResolutionGeneratorTest.class.getName());
	}

	public ConsistencyResolutionGeneratorTest(final String name) {
		super(name);
	}

	@Override
	protected String getDcName() {
		return ConsistencyResolutionGeneratorTest.DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.prepareWorkbench();

		this.connection = createConnection();

		this.component = createComponent(this.connection, getProject(), "Component1");
		final ComponentPackage compPackage = (ComponentPackage) this.component.refImmediatePackage();

		// a View
		final RefClass viewClass = compPackage.getView().getView();
		this.view = (View) viewClass.refCreateInstance();
		this.view.setName("testView");
		this.component.getViews().add(this.view);

		this.mAbbotFactory = FactoryBuilder.newAbbotFactory();
		this.mAbbotFactory.setWaitTimeout(3000);

		// // RootUIElementContainer
		// UielementPackage uielementPackage =
		// compPackage.getView().getUielement();
		// TransparentContainerClass uielementContainerClass =
		// uielementPackage.getTransparentContainer();
		// TransparentContainer rootContainer =
		// uielementContainerClass.createTransparentContainer();
		// rootContainer.setName("RootElement");
		// view.setRootUielementContainer(rootContainer);

		this.connection.save();
	}

	protected Component createComponent(final Connection connection, final IProject project, final String partitionName) {
		final PRI pri = getPri(project, ConsistencyResolutionGeneratorTest.PARTITION_FOLDER.append(partitionName));

		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition);

		ModelAdapter.getInstance().getFile(pri);

		final ComponentPackage compPackage = (ComponentPackage) connection.getPackage(
				WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO, WebDynproProjectTest.PACKAGE_NAME_COMPONENT);
		final Component component = (Component) compPackage.getComponent().refCreateInstance();
		component.setName("testComponent");
		assertNotNull(component);
		partition.assignElement((Partitionable) component);
		return component;
	}

	public void testGetResolutions() {
		//
		// final String ATTR_VIOLATION_ID =
		// accessNonPublicField(DefaultConsistencyListener.class,
		// "ATTR_VIOLATION_ID").toString();
		// final String ATTR_DESCRIPTION =
		// accessNonPublicField(DefaultConsistencyListener.class,
		// "ATTR_DESCRIPTION").toString();
		// final String ATTR_RESOLUTION_ID =
		// accessNonPublicField(DefaultConsistencyListener.class,
		// "ATTR_RESOLUTION_ID").toString();
		//
		// final IMarker mockMarker = createMock(IMarker.class);
		//
		// expect(mockMarker.getAttribute(ATTR_RESOLUTION_ID + "0",
		// null)).andReturn("id 0");
		// expect(mockMarker.getAttribute(ATTR_DESCRIPTION + "0",
		// null)).andReturn("desc 0");
		// expect(mockMarker.getAttribute(ATTR_RESOLUTION_ID + "1",
		// null)).andReturn(null);
		// expect(mockMarker.getResource()).andReturn(this.partFile);
		//
		// final String violationID = "violation id";
		// expect(mockMarker.getAttribute(ATTR_VIOLATION_ID,
		// null)).andReturn(violationID).anyTimes();
		//
		// replay(mockMarker);
		//
		// final ConsistencyResolutionGenerator crGen = new
		// ConsistencyResolutionGenerator();
		// final boolean hasResolutions = crGen.hasResolutions(mockMarker);
		// assertTrue("No resolutions found", hasResolutions);
		//
		// final IMarkerResolution[] resolutions =
		// crGen.getResolutions(mockMarker);
		// assertEquals("Incorrect number of resolutions", 1,
		// resolutions.length);
		//
		// this.mShell.syncExec(new LRunnable<Void>() {
		// public Void run() throws Exception {
		// resolutions[0].run(mockMarker);
		// return null;
		// }
		// });
		//
		// verify(mockMarker);
	}
}
