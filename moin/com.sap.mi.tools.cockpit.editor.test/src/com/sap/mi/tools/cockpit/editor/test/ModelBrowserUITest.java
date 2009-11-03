package com.sap.mi.tools.cockpit.editor.test;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;

import abbot.WaitTimedOutError;
import abbot.tester.swt.Robot;
import abbot.tester.swt.WidgetLocator;
import abbot.tester.swt.WidgetTester;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LCondition;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.ui.lift.LShell.AsyncWaiter;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;

/**
 * @author d003456
 * 
 */
public class ModelBrowserUITest extends ProjectBasedTest {

	private static final String DC_NAME = "testproject-ModelBrowserUITest"; //$NON-NLS-1$

	private static final String ID_COCKPIT_PERSPECTIVE = "com.sap.mi.tools.cockpit.editor.perspective.CockpitPerspective";//$NON-NLS-1$

	private static final String ID_MODEL_BROWSER_VIEW = "com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView";//$NON-NLS-1$

	/**
	 * Messages
	 */
	private static final String MSG_METAMODELS_NOT_DEPLOYED = "Metamodels are not deployed.";//$NON-NLS-1$

	private static final String MSG_PROJECT_NOT_CREATED = "Project not created.";//$NON-NLS-1$

	private static final String MSG_METAMODELMANAGER_NOT_INSTANTIATED = "Meta Model Manager is not instantiated.";//$NON-NLS-1$

	/**
	 * Metamodel wsdl2
	 */
	private static final String METAMODEL_WSDL2 = "sap.com/tc/esmp/model/wsdl2"; //$NON-NLS-1$

	/**
	 * Metamodel xsd1
	 */
	private static final String METAMODEL_XSD1 = "sap.com/tc/esmp/model/xsd1"; //$NON-NLS-1$

	/**
	 * Metamodel Galaxy
	 */
	private static final String METAMODEL_GALAXY = "sap.com/glx/ide"; //$NON-NLS-1$

	/**
	 * Relativ path to zip file with partitions
	 */
	private static final String MODEL_BROWSER_TEST_DATA = "/resources/ModelBrowserTestData.zap"; //$NON-NLS-1$

	/**
	 * Facility to access and import Moin Metamodels
	 */
	protected MetamodelManager mmManager = null;

	private LFactory abbotFactory;

	private Display display;

	private MOINBrowserView viewer;

	private LShell shell;

	private LTreeItem projectNode;

	private LTreeItem srcNode;

	private LTreeItem currNode;

	private LTree modelTree;

	/**
	 * Constructor.
	 */
	public ModelBrowserUITest() {

		super();
		assertNotNull(ModelBrowserUITest.MSG_METAMODELMANAGER_NOT_INSTANTIATED, this.mmManager = MetamodelManager.getInstance());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getDcName()
	 */
	@Override
	protected String getDcName() {

		return ModelBrowserUITest.DC_NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getMetamodels()
	 */
	@Override
	protected String[] getMetamodels() {

		return new String[] { ModelBrowserUITest.METAMODEL_WSDL2, ModelBrowserUITest.METAMODEL_XSD1, ModelBrowserUITest.METAMODEL_GALAXY };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getProjectContentAsStream()
	 */
	@Override
	protected InputStream getProjectContentAsStream() {

		return ModelBrowserUITest.class.getResourceAsStream(ModelBrowserUITest.MODEL_BROWSER_TEST_DATA);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {

		MOINBrowserView.setInitSynchronous(true);

		super.setUp();

		assertNotNull(ModelBrowserUITest.MSG_PROJECT_NOT_CREATED, getProject());

		assertTrue(ModelBrowserUITest.MSG_METAMODELS_NOT_DEPLOYED, this.mmManager.isMetamodelImported(getMetamodels()));

		this.abbotFactory = FactoryBuilder.newAbbotFactory();
		this.display = Display.getDefault();
		this.shell = this.abbotFactory.getShell(this.display);
		this.abbotFactory.setFindTimeOut(200000);
		this.abbotFactory.setWaitTimeout(200000);

		PDEUtil.closeWelcomePage();

		PDEUtil.openPerspective(ModelBrowserUITest.ID_COCKPIT_PERSPECTIVE);

		PDEUtil.maximizeWorkbenchAndRequestFocus();
		PDEUtil.assertDisplayIsActiveWindow();

		this.viewer = (MOINBrowserView) PDEUtil.showView(ModelBrowserUITest.ID_MODEL_BROWSER_VIEW);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {

		MOINBrowserView.setInitSynchronous(false);

		for (int i = 0; i < 25; i++) {
			this.shell.enter(this.abbotFactory.key().esc());
		}

		PDEUtil.restoreCurrentView();
		this.display = null;
		this.shell = null;
		super.tearDown();
		this.abbotFactory = null;

	}

	@SuppressWarnings("nls")
	public void testHierarchyOfPartition() throws Exception {

		this.abbotFactory.delay(5000);
		PDEUtil.maximizeCurrentView();
		//
		// src
		//
		findSrcNode(getProject());

		assertTrue("Node \"xml_schema.types\" could not be revealed.", revealNodeFromParent("xml_schema.types", this.srcNode));
		assertTrue("Node \"sap.com/tc/esmp/model/xsd1\" could not be revealed.", revealNodeFromParent("sap.com/tc/esmp/model/xsd1",
				this.currNode));

		assertTrue("Node \"moin/meta\"  could not be revealed.", revealNodeFromParent("moin/meta", this.srcNode));
		assertTrue("Node \"Metamodel.moinmm\"  could not be revealed.", revealNodeFromParent("Metamodel.moinmm", this.currNode));

		assertTrue("Node \"rules/sap.com/bpem\"  could not be revealed.", revealNodeFromParent("rules/sap.com/bpem", this.srcNode));
		final LTreeItem rulesNode = this.currNode;

		assertTrue("Node \"and.function\"  could not be revealed.", revealNodeFromParent("and.function", rulesNode));
		assertTrue("Node \"zodiac.bpmn\"  could not be revealed.", revealNodeFromParent("zodiac.bpmn", rulesNode));
		assertTrue("Node \"zodiac.diagram\"  could not be revealed.", revealNodeFromParent("zodiac.diagram", rulesNode));
		assertTrue("Node \"glx/built-in\"  could not be revealed.", revealNodeFromParent("glx/built-in", rulesNode));
		final LTreeItem glxNode = this.currNode;

		assertTrue("Node \"boolean\"  could not be revealed.", revealNodeFromParent("boolean", glxNode));
		final LTreeItem booleanNode = this.currNode;
		assertTrue("Node \"boolean-equal.function\"  could not be revealed.", revealNodeFromParent("boolean-equal.function", booleanNode));

		assertTrue("Node \"date\"  could not be revealed.", revealNodeFromParent("date", glxNode));
		final LTreeItem dateNode = this.currNode;
		assertTrue("Node \"datetime-equal.function\"  could not be revealed.", revealNodeFromParent("datetime-equal.function", dateNode));
		assertTrue("Node \"datetime.function\"  could not be revealed.", revealNodeFromParent("datetime.function", dateNode));
		//
		// src/wsdl
		//
		assertTrue("Node \"wsdl\" could not be revealed.", revealNodeFromParent("wsdl", this.srcNode));
		final LTreeItem wsdlNode = this.currNode;
		assertTrue("Node \"sap.com.glx.services\" could not be revealed.", revealNodeFromParent("sap.com.glx.services", wsdlNode));
		assertTrue("Node \"sap.com.glx.types\" could not be revealed.", revealNodeFromParent("sap.com.glx.types", wsdlNode));
		assertTrue("Node \"www.example.org.testdt.services\" could not be revealed.", revealNodeFromParent(
				"www.example.org.testdt.services", wsdlNode));
		assertTrue("Node \"www.example.org.testdt.types\" could not be revealed.", revealNodeFromParent("www.example.org.testdt.types",
				wsdlNode));
		assertTrue("Node \"xml_namespace.types\" could not be revealed.", revealNodeFromParent("xml_namespace.types", wsdlNode));
		//
		// src/wsdl/wsdl_1
		//
		assertTrue("Node \"wsdl_1\" could not be revealed.", revealNodeFromParent("wsdl_1", wsdlNode));
		final LTreeItem wsdl_1Node = this.currNode;
		assertTrue("Node \"concat.function\" could not be revealed.", revealNodeFromParent("concat.function", wsdl_1Node));
		assertTrue("Node \"wsdl_1-1\" could not be revealed.", revealNodeFromParent("wsdl_1_1", wsdl_1Node));
		final LTreeItem wsdl_1_1Node = this.currNode;
		assertTrue("Node \"contains.function\" could not be revealed.", revealNodeFromParent("contains.function", wsdl_1_1Node));
		assertTrue("Node \"wsdl_1_1_1\" could not be revealed.", revealNodeFromParent("wsdl_1_1_1", wsdl_1_1Node));
		final LTreeItem wsdl_1_1_1Node = this.currNode;
		assertTrue("Node \"ends-with.function\" could not be revealed.", revealNodeFromParent("ends-with.function", wsdl_1_1_1Node));
		assertTrue("Node \"wsdl_1_1_1_1\" could not be revealed.", revealNodeFromParent("wsdl_1_1_1_1", wsdl_1_1_1Node));
		assertTrue("Node \"years-from-duration.function\" could not be revealed.", revealNodeFromParent("years-from-duration.function",
				this.currNode));
		//
		// src/wsdl_2
		//
		assertTrue("Node \"wsdl_2\" could not be revealed.", revealNodeFromParent("wsdl_2", wsdlNode));
		final LTreeItem wsdl_2Node = this.currNode;
		assertTrue("Node \"datetime-equal.function\" could not be revealed.", revealNodeFromParent("datetime-equal.function", wsdl_2Node));
		assertTrue("Node \"year-from-datetime.function\" could not be revealed.", revealNodeFromParent("year-from-datetime.function",
				wsdl_2Node));
		assertTrue("Node \"wsdl_2_1\" could not be revealed.", revealNodeFromParent("wsdl_2_1", wsdl_2Node));
		final LTreeItem wsdl_2_1Node = this.currNode;
		assertTrue("Node \"subtract-daytimeduration-from-datetime.function\" could not be revealed.", revealNodeFromParent(
				"subtract-daytimeduration-from-datetime.function", wsdl_2_1Node));
		assertTrue("Node \"subtract-yearmonthduration-from-datetime.function\" could not be revealed.", revealNodeFromParent(
				"subtract-yearmonthduration-from-datetime.function", wsdl_2_1Node));
		assertTrue("wsdl_2_1Node.isDisposed()", !(wsdl_2_1Node.isDisposed()));
		assertTrue("Node \"wsdl_2_1_1\" could not be revealed.", revealNodeFromParent("wsdl_2_1_1", wsdl_2_1Node));
		final LTreeItem wsdl_2_1_1Node = this.currNode;
		assertTrue("Node \"subtract-datetimes-as-milliseconds.function\" could not be revealed.", revealNodeFromParent(
				"subtract-datetimes-as-milliseconds.function", wsdl_2_1_1Node));
		assertTrue("Node \"subtract-days-from-datetime.function\" could not be revealed.", revealNodeFromParent(
				"subtract-days-from-datetime.function", wsdl_2_1_1Node));
		assertTrue("Node \"wsdl_2_1_1\" could not be revealed.", revealNodeFromParent("wsdl_2_1_1_1", wsdl_2_1_1Node));
		final LTreeItem wsdl_2_1_1_1 = this.currNode;
		assertTrue("Node \"minutes-from-duration.function\" could not be revealed.", revealNodeFromParent("minutes-from-duration.function",
				wsdl_2_1_1_1));
		assertTrue("Node \"seconds-from-duration.function\" could not be revealed.", revealNodeFromParent("seconds-from-duration.function",
				wsdl_2_1_1_1));
		//
		// src/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1
		//
		assertTrue("Node \"wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1\" could not be revealed.", revealNodeFromParent(
				"wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1", wsdlNode));
		final LTreeItem wsdl_3_1_1_1_1Node = this.currNode;
		assertTrue("Node \"getprincipal.function\" could not be revealed.", revealNodeFromParent("getprincipal.function",
				wsdl_3_1_1_1_1Node));
		assertTrue("Node \"getprincipalbyuniquename.function\" could not be revealed.", revealNodeFromParent(
				"getprincipalbyuniquename.function", wsdl_3_1_1_1_1Node));
		assertTrue("Node \"getprincipals.function\" could not be revealed.", revealNodeFromParent("getprincipals.function",
				wsdl_3_1_1_1_1Node));

		assertTrue("Cannot collapse \"src\" node.", openNodeAndCollapse(this.srcNode, "src"));
	}

	@SuppressWarnings("nls")
	public void testFlatOfPartition() throws Exception {

		PDEUtil.maximizeCurrentView();
		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToFlat().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());

		assertTrue("Cannot reveal node \"src/xml_schema.types\".", revealNode("src/xml_schema.types"));
		assertEquals("Node \"src/xml_schema.types\" should have position = 0", 0, this.projectNode.indexOf(this.currNode));
		assertTrue("Cannot reveal node \"src/moin/meta/Metamodel.moinmm\".", revealNode("src/moin/meta/Metamodel.moinmm"));
		assertEquals("Node \"src/moin/meta/Metamodel.moinmm\" should have position = 1", 1, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/rules/sap.com/bpem/and.function\".", revealNode("src/rules/sap.com/bpem/and.function"));
		assertEquals("Node \"src/rules/sap.com/bpem/and.function\" should have position = 2", 2, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/rules/sap.com/bpem/zodiac.bpmn\".", revealNode("src/rules/sap.com/bpem/zodiac.bpmn"));
		assertEquals("Node \"src/rules/sap.com/bpem/zodiac.bpmn\" should have position = 3", 3, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/rules/sap.com/bpem/zodiac.diagram\".", revealNode("src/rules/sap.com/bpem/zodiac.diagram"));
		assertEquals("Node \"src/rules/sap.com/bpem/zodiac.diagram\" should have position = 4", 4, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/rules/sap.com/bpem/glx/built-in/boolean/boolean-equal.function\".",
				revealNode("src/rules/sap.com/bpem/glx/built-in/boolean/boolean-equal.function"));
		assertEquals("Node \"src/rules/sap.com/bpem/glx/built-in/boolean/boolean-equal.function\" should have position = 5", 5,
				this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/rules/sap.com/bpem/glx/built-in/date/datetime-equal.function\".",
				revealNode("src/rules/sap.com/bpem/glx/built-in/date/datetime-equal.function"));
		assertEquals("Node \"src/rules/sap.com/bpem/glx/built-in/date/datetime-equal.function\" should have position = 6", 6,
				this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/rules/sap.com/bpem/glx/built-in/date/datetime.function\".",
				revealNode("src/rules/sap.com/bpem/glx/built-in/date/datetime.function"));
		assertEquals("Node \"src/rules/sap.com/bpem/glx/built-in/date/datetime.function\" should have position = 7", 7, this.projectNode
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/sap.com.glx.services\".", revealNode("src/wsdl/sap.com.glx.services"));
		assertEquals("Node \"src/wsdl/sap.com.glx.services\" should have position = 8", 8, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/sap.com.glx.types\".", revealNode("src/wsdl/sap.com.glx.types"));
		assertEquals("Node \"src/wsdl/sap.com.glx.types\" should have position = 9", 9, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/soap-encoding.types\".", revealNode("src/wsdl/soap-encoding.types"));
		assertEquals("Node \"src/wsdl/soap-encoding.types\" should have position = 10", 10, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/www.example.org.testdt.services\".",
				revealNode("src/wsdl/www.example.org.testdt.services"));
		assertEquals("Node \"src/wsdl/www.example.org.testdt.services\" should have position = 11", 11, this.projectNode
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/www.example.org.testdt.types\".", revealNode("src/wsdl/www.example.org.testdt.types"));
		assertEquals("Node \"src/wsdl/www.example.org.testdt.types\" should have position = 12", 12, this.projectNode
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/xml_namespace.types\".", revealNode("src/wsdl/xml_namespace.types"));
		assertEquals("Node \"src/wsdl/xml_namespace.types\" should have position = 13", 13, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_1/concat.function\".", revealNode("src/wsdl/wsdl_1/concat.function"));
		assertEquals("Node \"src/wsdl/wsdl_1/concat.function\" should have position = 14", 14, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_1/wsdl_1_1/contains.function\".",
				revealNode("src/wsdl/wsdl_1/wsdl_1_1/contains.function"));
		assertEquals("Node \"src/wsdl/wsdl_1/wsdl_1_1/contains.function\" should have position = 15", 15, this.projectNode
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_1/wsdl_1_1/wsdl_1_1_1/ends-with.function\".",
				revealNode("src/wsdl/wsdl_1/wsdl_1_1/wsdl_1_1_1/ends-with.function"));
		assertEquals("Node \"src/wsdl/wsdl_1/wsdl_1_1/wsdl_1_1_1/ends-with.function\" should have position = 16", 16, this.projectNode
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_1/wsdl_1_1/wsdl_1_1_1/wsdl_1_1_1_1/years-from-duration.function\".",
				revealNode("src/wsdl/wsdl_1/wsdl_1_1/wsdl_1_1_1/wsdl_1_1_1_1/years-from-duration.function"));
		assertEquals("Node \"src/wsdl/wsdl_1/wsdl_1_1/wsdl_1_1_1/wsdl_1_1_1_1/years-from-duration.function\" should have position = 17",
				17, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_2/datetime-equal.function\".", revealNode("src/wsdl/wsdl_2/datetime-equal.function"));
		assertEquals("Node \"src/wsdl/wsdl_2/datetime-equal.function\" should have position = 18", 18, this.projectNode
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_2/year-from-datetime.function\".",
				revealNode("src/wsdl/wsdl_2/year-from-datetime.function"));
		assertEquals("Node \"src/wsdl/wsdl_2/year-from-datetime.function\" should have position = 19", 19, this.projectNode
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_2/wsdl_2_1/subtract-daytimeduration-from-datetime.function\".",
				revealNode("src/wsdl/wsdl_2/wsdl_2_1/subtract-daytimeduration-from-datetime.function"));
		assertEquals("Node \"src/wsdl/wsdl_2/wsdl_2_1/subtract-daytimeduration-from-datetime.function\" should have position = 20", 20,
				this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_2/wsdl_2_1/subtract-yearmonthduration-from-datetime.function\".",
				revealNode("src/wsdl/wsdl_2/wsdl_2_1/subtract-yearmonthduration-from-datetime.function"));
		assertEquals("Node \"src/wsdl/wsdl_2/wsdl_2_1/subtract-yearmonthduration-from-datetime.function\" should have position = 21", 21,
				this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/subtract-datetimes-as-milliseconds.function\".",
				revealNode("src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/subtract-datetimes-as-milliseconds.function"));
		assertEquals("Node \"src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/subtract-datetimes-as-milliseconds.function\" should have position = 22",
				22, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/subtract-days-from-datetime.function\".",
				revealNode("src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/subtract-days-from-datetime.function"));
		assertEquals("Node \"src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/subtract-days-from-datetime.function\" should have position = 23", 23,
				this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/wsdl_2_1_1_1/minutes-from-duration.function\".",
				revealNode("src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/wsdl_2_1_1_1/minutes-from-duration.function"));
		assertEquals("Node \"src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/wsdl_2_1_1_1/minutes-from-duration.function\" should have position = 24",
				24, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/wsdl_2_1_1_1/seconds-from-duration.function.function\".",
				revealNode("src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/wsdl_2_1_1_1/seconds-from-duration.function"));
		assertEquals("Node \"src/wsdl/wsdl_2/wsdl_2_1/wsdl_2_1_1/wsdl_2_1_1_1/seconds-from-duration.function\" should have position = 25",
				25, this.projectNode.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipal.function\".",
				revealNode("src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipal.function"));
		assertEquals(
				"Node \"src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipal.function\" should have position = 26",
				26, this.projectNode.indexOf(this.currNode));
		assertTrue(
				"Cannot reveal node \"src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipalbyuniquename.function\".",
				revealNode("src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipalbyuniquename.function"));
		assertEquals(
				"Node \"src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipalbyuniquename.function\" should have position = 27",
				27, this.projectNode.indexOf(this.currNode));
		assertTrue("Cannot reveal node \"src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipals.function\".",
				revealNode("src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipals.function"));
		assertEquals(
				"Node \"src/wsdl/wsdl_3/wsdl_3_1/wsdl_3_1_1/wsdl_3_1_1_1/wsdl_3_1_1_1_1/getprincipals.function\" should have position = 28",
				28, this.projectNode.indexOf(this.currNode));

	}

	@SuppressWarnings("nls")
	public void testHierarchyOfMetaModel() throws Exception {

		PDEUtil.maximizeCurrentView();

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToMetaModelNames().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());
		//
		// glx
		//
		assertTrue("Cannot reveal node \"sap.com/glx/ide\".", revealNodeFromParent("sap.com/glx/ide", this.projectNode));
		final LTreeItem glxMeta = this.currNode;
		assertTrue("Cannot reveal node \"Galaxy\".", revealNodeFromParent("Galaxy", glxMeta));
		final LTreeItem galaxyPck = this.currNode;
		assertTrue("Cannot reveal node \"Rule\".", revealNodeFromParent("Rule", galaxyPck));
		final LTreeItem rulePck = this.currNode;
		assertTrue("Cannot reveal node \"EjbFunction\".", revealNodeFromParent("EjbFunction", rulePck));
		assertTrue("Cannot reveal node \"JavaFunction\".", revealNodeFromParent("JavaFunction", rulePck));
		assertTrue("Cannot reveal node \"Literal\".", revealNodeFromParent("Literal", galaxyPck));
		final LTreeItem literalPck = this.currNode;
		assertTrue("Cannot reveal node \"Galaxy.Rule.Literal\".", revealNodeFromParent("Galaxy.Rule.Literal", literalPck));
		//
		// wsdl2
		//
		assertTrue("Cannot reveal node \"sap.com/tc/esmp/model/wsdl2\".", revealNodeFromParent("sap.com/tc/esmp/model/wsdl2",
				this.projectNode));
		final LTreeItem wsdlMeta = this.currNode;
		assertTrue("Cannot reveal node \"WSDL2\".", revealNodeFromParent("WSDL2", wsdlMeta));
		assertTrue("Cannot reveal node \"Binding\".", revealNode("Binding"));
		assertTrue("Cannot reveal node \"BindingMessageReference\".", revealNode("BindingMessageReference"));
		assertTrue("Cannot reveal node \"BindingOperation\".", revealNode("BindingOperation"));
		assertTrue("Cannot reveal node \"BindingType\".", revealNode("BindingType"));
		assertTrue("Cannot reveal node \"Description\".", revealNode("Description"));
		assertTrue("Cannot reveal node \"Endpoint\".", revealNode("Endpoint"));
		assertTrue("Cannot reveal node \"EndpointAddress\".", revealNode("EndpointAddress"));
		assertTrue("Cannot reveal node \"Interface\".", revealNode("Interface"));
		assertTrue("Cannot reveal node \"MessageExchangePattern\".", revealNode("MessageExchangePattern"));
		assertTrue("Cannot reveal node \"MessageReference\".", revealNode("MessageReference"));
		assertTrue("Cannot reveal node \"Operation\".", revealNode("Operation"));
		assertTrue("Cannot reveal node \"Service\".", revealNode("Service"));
		assertTrue("Cannot reveal node \"Types\".", revealNode("Types"));
		assertTrue("Cannot reveal node \"UnknownExtensibilityAttribute\".", revealNode("UnknownExtensibilityAttribute"));
		assertTrue("Cannot reveal node \"UnknownExtensibilityElement\".", revealNode("UnknownExtensibilityElement"));
		//
		// XSD1
		//
		assertTrue("Cannot reveal node \"sap.com/tc/esmp/model/xsd1\".", revealNodeFromParent("sap.com/tc/esmp/model/xsd1",
				this.projectNode));
		final LTreeItem xsdMeta = this.currNode;
		assertTrue("Cannot reveal node \"XSD1\".", revealNodeFromParent("XSD1", xsdMeta));
		final LTreeItem xsdPck = this.currNode;
		assertTrue("Cannot reveal node \"dom\".", revealNodeFromParent("dom", xsdPck));
		final LTreeItem domPck = this.currNode;
		assertTrue("Cannot reveal node \"DomAttribute\".", revealNodeFromParent("DomAttribute", domPck));
		assertTrue("Cannot reveal node \"DomElement\".", revealNodeFromParent("DomElement", domPck));
		assertTrue("Cannot reveal node \"DomText\".", revealNodeFromParent("DomText", domPck));
		assertTrue("Cannot reveal node \"XsdAnnotation\".", revealNode("XsdAnnotation"));
		assertTrue("Cannot reveal node \"XsdAttributeDeclaration\".", revealNode("XsdAttributeDeclaration"));
		assertTrue("Cannot reveal node \"XsdAttributeGroupDefinition\".", revealNode("XsdAttributeGroupDefinition"));
		assertTrue("Cannot reveal node \"XsdAttributeUse\".", revealNode("XsdAttributeUse"));
		assertTrue("Cannot reveal node \"XsdComplexTypeDefinition\".", revealNode("XsdComplexTypeDefinition"));
		assertTrue("Cannot reveal node \"XsdElementDeclaration\".", revealNode("XsdElementDeclaration"));
		assertTrue("Cannot reveal node \"XsdEnumerationFacet\".", revealNode("XsdEnumerationFacet"));
		assertTrue("Cannot reveal node \"XsdFractionDigitsFacet\".", revealNode("XsdFractionDigitsFacet"));
		assertTrue("Cannot reveal node \"XsdMaxInclusiveFacet\".", revealNode("XsdMaxInclusiveFacet"));
		assertTrue("Cannot reveal node \"XsdMinInclusiveFacet\".", revealNode("XsdMinInclusiveFacet"));
		assertTrue("Cannot reveal node \"XsdMinLengthFacet\".", revealNode("XsdMinLengthFacet"));
		assertTrue("Cannot reveal node \"XsdModelGroup\".", revealNode("XsdModelGroup"));
		assertTrue("Cannot reveal node \"XsdModelGroupDefinition\".", revealNode("XsdModelGroupDefinition"));
		assertTrue("Cannot reveal node \"XsdParticle\".", revealNode("XsdParticle"));
		assertTrue("Cannot reveal node \"XsdPatternFacet\".", revealNode("XsdPatternFacet"));
		assertTrue("Cannot reveal node \"XsdSchemaDocument\".", revealNode("XsdSchemaDocument"));
		assertTrue("Cannot reveal node \"XsdSimpleTypeDefinition\".", revealNode("XsdSimpleTypeDefinition"));
		assertTrue("Cannot reveal node \"XsdWhiteSpaceFacet\".", revealNode("XsdWhiteSpaceFacet"));
		assertTrue("Cannot reveal node \"XsdWildcard\".", revealNode("XsdWildcard"));
	}

	@SuppressWarnings("nls")
	public void testOrderOfAssociations() throws Exception {

		PDEUtil.maximizeCurrentView();

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToPartitions().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToHierarchical().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());
		findSrcNode(getProject());

		assertTrue("Cannot reveal node \"xml_schema.types\".", revealNodeFromParent("xml_schema.types", this.srcNode));
		assertTrue("Cannot reveal node \"sap.com/tc/esmp/model/xsd1\".", revealNodeFromParent("sap.com/tc/esmp/model/xsd1", this.currNode));
		assertTrue("Cannot reveal node \"XsdSchemaDocument\".", revealNodeFromParent("XsdSchemaDocument", this.currNode));
		final LTreeItem schemaDocument = this.currNode;
		assertTrue("Cannot reveal node \"XSD1.XsdSchemaDocument: http://www.w3.org/2001/XMLSchema.xsd\".", revealNodeFromParent(
				"XSD1.XsdSchemaDocument: http://www.w3.org/2001/XMLSchema.xsd", schemaDocument));

		// root for following order tests
		final LTreeItem schemaDocumentRefObj = this.currNode;

		assertTrue("Cannot reveal node \"AnnotationsForSchema -> annotations\".", revealNode("AnnotationsForSchema -> annotations"));
		assertEquals("Node \" \" should have position = 10", 10, schemaDocumentRefObj.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"AttributeDeclarationsForSchema -> attributeDeclarations <Empty>\".",
				revealNode("AttributeDeclarationsForSchema -> attributeDeclarations <Empty>"));
		assertEquals("Node \"AttributeDeclarationsForSchema -> attributeDeclarations <Empty>\" should have position = 11", 11,
				schemaDocumentRefObj.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"AttributeGroupDefinitionsForSchema -> attributeGroupDefinitions <Empty>\".",
				revealNode("AttributeGroupDefinitionsForSchema -> attributeGroupDefinitions <Empty>"));
		assertEquals("Node \"AttributeGroupDefinitionsForSchema -> attributeGroupDefinitions <Empty>\" should have position = 12", 12,
				schemaDocumentRefObj.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"DirectivesForSchema -> referencingDirectives <Empty>\".",
				revealNode("DirectivesForSchema -> referencingDirectives <Empty>"));
		assertEquals("Node \"DirectivesForSchema -> referencingDirectives <Empty>\" should have position = 13", 13, schemaDocumentRefObj
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"ElementDeclarationsForSchema -> elementDeclarations <Empty>\".",
				revealNode("ElementDeclarationsForSchema -> elementDeclarations <Empty>"));
		assertEquals("Node \"ElementDeclarationsForSchema -> elementDeclarations <Empty>\" should have position = 14", 14,
				schemaDocumentRefObj.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"InlinedSchemas -> descriptions <Empty>\".", revealNode("InlinedSchemas -> descriptions <Empty>"));
		assertEquals("Node \"InlinedSchemas -> descriptions <Empty>\" should have position = 15", 15, schemaDocumentRefObj
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"ModelGroupDefinitionsForSchema -> modelGroupDefinitions <Empty>\".",
				revealNode("ModelGroupDefinitionsForSchema -> modelGroupDefinitions <Empty>"));
		assertEquals("Node \"ModelGroupDefinitionsForSchema -> modelGroupDefinitions <Empty>\" should have position = 16", 16,
				schemaDocumentRefObj.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"NotationDeclarationsForSchema -> notationDeclarations <Empty>\".",
				revealNode("NotationDeclarationsForSchema -> notationDeclarations <Empty>"));
		assertEquals("Node \"NotationDeclarationsForSchema -> notationDeclarations <Empty>\" should have position = 17", 17,
				schemaDocumentRefObj.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"ReferencedSchemaForSchemaImport -> wsdlSchemaImports <Empty>\".",
				revealNode("ReferencedSchemaForSchemaImport -> wsdlSchemaImports <Empty>"));
		assertEquals("Node \"ReferencedSchemaForSchemaImport -> wsdlSchemaImports <Empty>\" should have position = 18", 18,
				schemaDocumentRefObj.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"ReferencedSchemaOfRedefineOrInclude -> compositor <Empty>\".",
				revealNode("ReferencedSchemaOfRedefineOrInclude -> compositor <Empty>"));
		assertEquals("Node \"ReferencedSchemaOfRedefineOrInclude -> compositor <Empty>\" should have position = 19", 19,
				schemaDocumentRefObj.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"SchemaForImportLocation -> xsdImports <Empty>\".",
				revealNode("SchemaForImportLocation -> xsdImports <Empty>"));
		assertEquals("Node \"SchemaForImportLocation -> xsdImports <Empty>\" should have position = 20", 20, schemaDocumentRefObj
				.indexOf(this.currNode));

		assertTrue("Cannot reveal node \"TypeDefinitionsForSchema -> typeDefinitions\".",
				revealNode("TypeDefinitionsForSchema -> typeDefinitions"));
		assertEquals("Node \"TypeDefinitionsForSchema -> typeDefinitions\" should have position = 22", 22, schemaDocumentRefObj
				.indexOf(this.currNode));

	}

	@SuppressWarnings("nls")
	public void testModelElementsForPartitionAndShowProps() throws Exception {

		PDEUtil.maximizeCurrentView();

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToPartitions().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToHierarchical().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());
		findSrcNode(getProject());

		assertTrue("Cannot reveal node \"xml_schema.types\".", revealNodeFromParent("xml_schema.types", this.srcNode));
		assertTrue("Cannot reveal node \"sap.com/tc/esmp/model/xsd1\".", revealNodeFromParent("sap.com/tc/esmp/model/xsd1", this.currNode));
		assertTrue("Cannot reveal node \"XsdSimpleTypeDefinition\".", revealNodeFromParent("XsdSimpleTypeDefinition", this.currNode));
		final LTreeItem simpleType = this.currNode;
		assertTrue("Cannot reveal node \"XSD1.XsdSimpleTypeDefinition: string\".", revealNodeFromParent(
				"XSD1.XsdSimpleTypeDefinition: string", simpleType));
		final LTreeItem simpleTypeRefObj = this.currNode;
		this.shell.clickOn(simpleTypeRefObj);

		assertTrue("Cannot reveal node \"refMetaObject\".", revealNodeFromParent("refMetaObject", simpleTypeRefObj));
		assertTrue("Cannot reveal node \"Model.Class: XsdSimpleTypeDefinition\".", revealNodeFromParent(
				"Model.Class: XsdSimpleTypeDefinition", this.currNode));
		this.shell.clickOn(this.currNode);

		assertTrue("Cannot reveal node \"attributes, DomAttribute: [Class]\".", revealNodeFromParent("attributes, DomAttribute: [Class]",
				simpleTypeRefObj));
		assertTrue("Cannot reveal node \"XSD1.dom.DomAttribute: id\".", revealNodeFromParent("XSD1.dom.DomAttribute: id", this.currNode));
		this.shell.clickOn(this.currNode);

		assertTrue("Cannot reveal node \"validPrimitiveTypeFacets, String: [PrimitiveType]\".", revealNodeFromParent(
				"validPrimitiveTypeFacets, String: [PrimitiveType]", simpleTypeRefObj));
		final LTreeItem validPrimitiveTypeFacets = this.currNode;
		assertNotNull("Cannot reveal node \"length\".", validPrimitiveTypeFacets.hasItem(this.shell.treeItem().withText("length")));
		assertNotNull("Cannot reveal node \"minLength\".", validPrimitiveTypeFacets.hasItem(this.shell.treeItem().withText("minLength")));
		assertNotNull("Cannot reveal node \"maxLength\".", validPrimitiveTypeFacets.hasItem(this.shell.treeItem().withText("maxLength")));
		assertNotNull("Cannot reveal node \"pattern\".", validPrimitiveTypeFacets.hasItem(this.shell.treeItem().withText("pattern")));
		assertNotNull("Cannot reveal node \"enumeration\".", validPrimitiveTypeFacets
				.hasItem(this.shell.treeItem().withText("enumeration")));
		assertNotNull("Cannot reveal node \"whiteSpace\".", validPrimitiveTypeFacets.hasItem(this.shell.treeItem().withText("whiteSpace")));

		assertTrue("Cannot reveal node \"FacetContentsForSimpleTypeDefinition -> facetContents\".", revealNodeFromParent(
				"FacetContentsForSimpleTypeDefinition -> facetContents", simpleTypeRefObj));
		assertTrue("Cannot reveal node \"XSD1.XsdWhiteSpaceFacet\".", revealNodeFromParent("XSD1.XsdWhiteSpaceFacet", this.currNode));
		this.shell.clickOn(this.currNode);

		assertTrue("Cannot reveal node \"TypeDefinitionsForSchema -> schema\".", revealNodeFromParent("TypeDefinitionsForSchema -> schema",
				simpleTypeRefObj));
		assertTrue("Cannot reveal node \"XSD1.XsdSchemaDocument: http://www.w3.org/2001/XMLSchema.xsd\".", revealNodeFromParent(
				"XSD1.XsdSchemaDocument: http://www.w3.org/2001/XMLSchema.xsd", this.currNode));
		this.shell.clickOn(this.currNode);

		// let us go for a Structure Type
		assertTrue("Cannot reveal node \"moin/meta\".", revealNodeFromParent("moin/meta", this.srcNode));
		assertTrue("Cannot reveal node \"Metamodel.moinmm\".", revealNodeFromParent("Metamodel.moinmm", this.currNode));
		assertTrue("Cannot reveal node \"sap.com/tc/moin/mof_1.4\".", revealNodeFromParent("sap.com/tc/moin/mof_1.4", this.currNode));
		assertTrue("Cannot reveal node \"Package\".", revealNodeFromParent("Package", this.currNode));
		assertTrue("Cannot reveal node \"Model.Package: pack_1\".", revealNodeFromParent("Model.Package: pack_1", this.currNode));
		// this.shell.clickOn(this.currNode);
		// assertTrue("Cannot reveal node \"DependsOn -> provider\".",
		// revealNodeFromParent("DependsOn -> provider", this.currNode));
		// assertTrue("Cannot reveal node \"Model.Attribute:
		// oneToOneAttribute\".", revealNodeFromParent("Model.Attribute:
		// oneToOneAttribute",
		// this.currNode));
		// this.shell.clickOn(this.currNode);
		// assertTrue("Cannot reveal node \"multiplicity, MultiplicityType\".",
		// revealNodeFromParent("multiplicity, MultiplicityType",
		// this.currNode));
		// LTreeItem multiplicity = this.currNode;
		// assertNotNull("Cannot reveal node \"lower, Integer: 1\".",
		// multiplicity
		// .hasItem(this.shell.treeItem().withText("lower, Integer: 1")));
		// assertNotNull("Cannot reveal node \"upper, Integer: 1\".",
		// multiplicity
		// .hasItem(this.shell.treeItem().withText("upper, Integer: 1")));
		// assertNotNull("Cannot reveal node \"isOrdered, Boolean: false\".",
		// multiplicity.hasItem(this.shell.treeItem().withText(
		// "isOrdered, Boolean: false")));
		// assertNotNull("Cannot reveal node \"isUnique, Boolean: false\".",
		// multiplicity.hasItem(this.shell.treeItem().withText(
		// "isUnique, Boolean: false")));
	}

	public void testReload() throws Exception {

		this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.expandToLevel(5);
				return null;
			}
		});
		this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getReloadAction().run();
				return null;
			}
		});
		this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.expandToLevel(5);
				return null;
			}
		});
		this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				return null;
			}
		});
	}

	@SuppressWarnings("nls")
	public void testPropertiesHierarchy() throws Exception {

		PDEUtil.restoreCurrentView();

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToPartitions().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToHierarchical().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());
		findSrcNode(getProject());

		assertTrue("Cannot reveal node \"xml_schema.types\".", revealNodeFromParent("xml_schema.types", this.srcNode));
		assertTrue("Cannot reveal node \"sap.com/tc/esmp/model/xsd1\".", revealNodeFromParent("sap.com/tc/esmp/model/xsd1", this.currNode));
		assertTrue("Cannot reveal node \"XsdSimpleTypeDefinition\".", revealNodeFromParent("XsdSimpleTypeDefinition", this.currNode));
		final LTreeItem simpleType = this.currNode;
		assertTrue("Cannot reveal node \"XSD1.XsdSimpleTypeDefinition: string\".", revealNodeFromParent(
				"XSD1.XsdSimpleTypeDefinition: string", simpleType));
		final LTreeItem simpleTypeRefObj = this.currNode;

		// force properties are displayed and property view has focus
		this.shell.clickOn(simpleTypeRefObj);
		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getShowPropertiesViewAction().run();
				return null;
			}
		});

		final LTree propTree = this.shell.has(this.shell.tree().withItem(this.shell.treeItem().withText("Meta model info")).andItem(
				this.shell.treeItem().withText("Model attributes")));
		assertNotNull("Property tree could not be obtained.", propTree);

		// collection attributes
		final LTreeItem domAttrItem = propTree.treeItem().withText("attributes, DomAttribute: [Class] 0..*");
		assertNotNull("Cannot reveal node \"attributes, DomAttribute: [Class] 0..*\"", domAttrItem);

		// reveal single value of collections
		propTree.expand(domAttrItem).andShows();
		checkCollectionValue(propTree, "XSD1.dom.DomAttribute: id");

		// collection validPrimitiveTypeFacets
		final LTreeItem validTypeFacets = propTree.treeItem().withText("validPrimitiveTypeFacets, String: [PrimitiveType] 0..*").andShows();
		assertNotNull("Cannot reveal node \"validPrimitiveTypeFacets, String: [PrimitiveType] 0..*\"", validTypeFacets);
		propTree.expand(validTypeFacets).andShows();
		checkCollectionValue(propTree, "length");
		checkCollectionValue(propTree, "minLength");
		checkCollectionValue(propTree, "maxLength");
		checkCollectionValue(propTree, "pattern");
		checkCollectionValue(propTree, "enumeration");
		checkCollectionValue(propTree, "whiteSpace");

		PDEUtil.closeCurrentView();

	}

	/**
	 * Test for CSN 1359030. Collection with Objects of StructureType are revealed. Causes NPE before.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("nls")
	public void testPropertiesHierarchyWithCollectionOfStructureTypes() throws Exception {

		PDEUtil.restoreCurrentView();

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToPartitions().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToHierarchical().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());
		findSrcNode(getProject());

		assertTrue("Cannot reveal node \"rules/sap.com/bpem\".", revealNodeFromParent("rules/sap.com/bpem", this.srcNode));
		assertTrue("Cannot reveal node \"zodiac.diagram\".", revealNodeFromParent("zodiac.diagram", this.currNode));
		assertTrue("Cannot reveal node \"sap.com/com/sap/mi/gfw/mm\".", revealNodeFromParent("sap.com/com/sap/mi/gfw/mm", this.currNode));
		assertTrue("Cannot reveal node \"Diagram\".", revealNodeFromParent("Diagram", this.currNode));
		assertTrue("Cannot reveal node \"pictograms.Diagram: zodiac\".", revealNodeFromParent("pictograms.Diagram: zodiac", this.currNode));

		final LTreeItem zodiacRefObj = this.currNode;

		// force properties are displayed and property view has focus
		this.shell.clickOn(zodiacRefObj);
		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getShowPropertiesViewAction().run();
				return null;
			}
		});

		final LTree propTree = this.shell.has(this.shell.tree().withItem(this.shell.treeItem().withText("Meta model info")).andItem(
				this.shell.treeItem().withText("Model attributes")));
		assertNotNull("Property tree could not be obtained.", propTree);

		// collection properties
		final LTreeItem propertiesItem = propTree.treeItem().withText("properties, Property: [StructureType] 0..*").andShows();
		assertNotNull("Cannot reveal node \"properties, Property: [StructureType] 0..*\"", propertiesItem);

		propTree.expand(propertiesItem).andShows();
		checkCollectionValue(propTree, "/.*dataFlowVisible.*/");
		checkCollectionValue(propTree, "/.*dataObjectsVisible.*/");
		checkCollectionValue(propTree, "/.*annotationsFlowVisible.*/");
		checkCollectionValue(propTree, "/.*orientationVertical.*/");

		PDEUtil.closeCurrentView();
	}

	@SuppressWarnings("nls")
	public void testEditValuesOfProperties() throws Exception {

		PDEUtil.restoreCurrentView();

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToPartitions().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToHierarchical().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());
		findSrcNode(getProject());

		assertTrue("Cannot reveal node \"xml_schema.types\".", revealNodeFromParent("xml_schema.types", this.srcNode));
		assertTrue("Cannot reveal node \"sap.com/tc/esmp/model/xsd1\".", revealNodeFromParent("sap.com/tc/esmp/model/xsd1", this.currNode));
		assertTrue("Cannot reveal node \"XsdSimpleTypeDefinition\".", revealNodeFromParent("XsdSimpleTypeDefinition", this.currNode));
		LTreeItem simpleType = this.currNode;
		assertTrue("Cannot reveal node \"XSD1.XsdSimpleTypeDefinition: string\".", revealNodeFromParent(
				"XSD1.XsdSimpleTypeDefinition: string", simpleType));
		LTreeItem simpleTypeRefObj = this.currNode;

		// force properties are displayed and property view has focus
		this.shell.clickOn(simpleTypeRefObj);
		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getShowPropertiesViewAction().run();
				return null;
			}
		});

		final LTree propTree = this.shell.has(this.shell.tree().withItem(this.shell.treeItem().withText("Meta model info")).andItem(
				this.shell.treeItem().withText("Model attributes")));
		assertNotNull("Property tree could not be obtained.", propTree);
		// find value "string" of attribute "name"
		checkCollectionValue(propTree, "string");
		// edit value
		this.shell.enter("ja");
		// enter value
		this.shell.enter(SWT.CR);

		// validate new value in property view
		checkCollectionValue(propTree, "ja");

		// close property view
		PDEUtil.closeCurrentView();

		// get simpleType again, because it can be disposed from refresh
		simpleType = this.shell.treeItem().withText("XsdSimpleTypeDefinition");

		// validate RefObject is updated in Model Browser; attribute "name" is
		// suffix of the name of the RefObject
		this.currNode = simpleType.hasItem(this.shell.treeItem().withText("XSD1.XsdSimpleTypeDefinition: ja"));
		simpleTypeRefObj = this.currNode;
		if (!simpleTypeRefObj.isResolved()) {
			this.shell.waitForShowing(simpleTypeRefObj);
		}
		assertNotNull("Cannot reveal node \"XSD1.XsdSimpleTypeDefinition: ja\"; node was not updated after editing.", simpleTypeRefObj);

		PDEUtil.closeCurrentView();

	}

	/**
	 * Test for CSN 1359030.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("nls")
	public void testEditBooleanValuesOfProperties() throws Exception {

		PDEUtil.restoreCurrentView();

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToPartitions().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToHierarchical().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());
		findSrcNode(getProject());

		assertTrue("Cannot reveal node \"rules/sap.com/bpem\".", revealNodeFromParent("rules/sap.com/bpem", this.srcNode));
		assertTrue("Cannot reveal node \"and.function\".", revealNodeFromParent("and.function", this.currNode));
		assertTrue("Cannot reveal node \"sap.com/glx/ide\".", revealNodeFromParent("sap.com/glx/ide", this.currNode));
		assertTrue("Cannot reveal node \"FunctionInterface\".", revealNodeFromParent("FunctionInterface", this.currNode));
		assertTrue("Cannot reveal node \"Galaxy.Rule.FunctionInterface: false\".", revealNodeFromParent(
				"Galaxy.Rule.FunctionInterface: false", this.currNode));

		final LTreeItem javaFunRefObj = this.currNode;

		// force properties are displayed and property view has focus
		this.shell.clickOn(javaFunRefObj);
		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getShowPropertiesViewAction().run();
				return null;
			}
		});

		final LTree propTree = this.shell.has(this.shell.tree().withItem(this.shell.treeItem().withText("Meta model info")).andItem(
				this.shell.treeItem().withText("Model attributes")));
		assertNotNull("Property tree could not be obtained.", propTree);

		// boolean property -> dropdown
		final LTreeItem documentationTranslatable = propTree.treeItem().withText("documentationTranslatable: Boolean");

		// validate value in property view
		{
			checkValue(documentationTranslatable, "false");

			this.shell.clickOn(documentationTranslatable);
			// switch from false to true
			this.shell.enter(this.abbotFactory.key().arrowUp());
			// enter value
			this.shell.enter(SWT.CR);

			this.shell.wait(new LCondition() {
				public boolean test() throws Exception {

					return documentationTranslatable.getText(1).equals("true");
				}
			});
			// validate new value in property view
			checkValue(documentationTranslatable, "true");
		}
		// validate it again
		{
			// click on another node
			final LTreeItem nameTranslatable = propTree.treeItem().withText("nameTranslatable: Boolean");
			this.shell.clickOn(nameTranslatable);
			// validate value of nameTranslatable
			checkValue(nameTranslatable, "false");
			// validate value of documentationTranslatable again
			checkValue(documentationTranslatable, "true");
		}
		// rewind it to false
		{
			this.shell.clickOn(documentationTranslatable);
			// switch from true to false
			this.shell.enter(this.abbotFactory.key().arrowDown());
			// enter value
			this.shell.enter(SWT.CR);
			this.shell.wait(new LCondition() {
				public boolean test() throws Exception {

					return documentationTranslatable.getText(1).equals("false");
				}
			});
			// validate new value in property view
			checkValue(documentationTranslatable, "false");
		}

		PDEUtil.closeCurrentView();

	}

	/**
	 * Test for CSN 1358958.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("nls")
	public void testDanglingReferencesInCollection() throws Exception {

		PDEUtil.restoreCurrentView();

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToPartitions().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToHierarchical().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());
		findSrcNode(getProject());

		assertTrue("Cannot reveal node \"rules/sap.com/bpem\".", revealNodeFromParent("rules/sap.com/bpem", this.srcNode));
		assertTrue("Cannot reveal node \"zodiac.diagram\".", revealNodeFromParent("zodiac.diagram", this.currNode));
		assertTrue("Cannot reveal node \"sap.com/com/sap/mi/gfw/mm\".", revealNodeFromParent("sap.com/com/sap/mi/gfw/mm", this.currNode));
		assertTrue("Cannot reveal node \"Diagram\".", revealNodeFromParent("Diagram", this.currNode));
		assertTrue("Cannot reveal node \"pictograms.Diagram: zodiac\".", revealNodeFromParent("pictograms.Diagram: zodiac", this.currNode));
		assertTrue("Cannot reveal node \"StyleContainerContainsStyles -> styles\".", revealNodeFromParent(
				"StyleContainerContainsStyles -> styles", this.currNode));
		assertTrue("Cannot reveal node \"pictograms.Style: STYLES\".", revealNodeFromParent("pictograms.Style: STYLES", this.currNode));
		assertTrue("Cannot reveal node \"pictograms.Style: STYLES\".", revealNodeFromParent("renderingStyle, RenderingStyle: [Class]",
				this.currNode));

		// reveal dangling reference
		try {
			assertTrue("Cannot reveal node \"<null>\".", revealNodeFromParent("<null>", this.currNode));
		}
		catch (final Exception cause) {
			fail("Dangling reference in collection renderingStyle cannot reveal node \"<null>\"", cause);
		}
	}

	@SuppressWarnings("nls")
	public void testMoveToPartitionWithDragAndDropAndMenu() throws Exception {

		PDEUtil.maximizeCurrentView();
		getProjectNodeAndModelTree(getProject());
		findSrcNode(getProject());
		assertTrue("Cannot reveal node \"rules/sap.com/bpem\".", revealNodeFromParent("rules/sap.com/bpem", this.srcNode));
		final LTreeItem bpem = this.currNode;
		assertTrue("Cannot reveal node \"zodiac.bpmn\".", revealNodeFromParent("zodiac.bpmn", this.currNode));
		assertTrue("Cannot reveal node \"sap.com/glx/ide\".", revealNodeFromParent("sap.com/glx/ide", this.currNode));
		assertTrue("Cannot reveal node \"Collaboration\".", revealNodeFromParent("Collaboration", this.currNode));
		assertTrue("Cannot reveal node \"Galaxy.Workflow.Collaboration: true\".", revealNodeFromParent(
				"Galaxy.Workflow.Collaboration: true", this.currNode));
		final LTreeItem dragSource = this.currNode;
		assertTrue("Cannot reveal node \"zodiac.diagram\".", revealNodeFromParent("zodiac.diagram", bpem));
		final LTreeItem dropTarget = this.currNode;

		dragAndDropTreeItem(this.modelTree, dropTarget, dragSource);

		assertTrue("Cannot reveal (refactored)metamodel node \"sap.com/glx/ide", revealNodeFromParent("sap.com/glx/ide", dropTarget));
		assertTrue("Cannot reveal (refactored) type node \"Collaboration\".", revealNodeFromParent("Collaboration", this.currNode));
		assertTrue("Cannot reveal dropped/refactored model element node \"Galaxy.Workflow.Collaboration: true\".", revealNodeFromParent(
				"Galaxy.Workflow.Collaboration: true", this.currNode));
		
		//reverse operation with menu
		this.shell.clickOn(this.currNode);
		final AsyncWaiter waiter = this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getMoveModelElementToPartionAction().run();
				return null;
			}
		});
		LShell dialog = this.shell.childShell().withText("Select Partition As Move Target");
		dialog = waiter.waitForShowing(dialog);
		assertNotNull("Partition dialog not found.", dialog);
		
		dialog.enter("zodiac");
		dialog.clickOn(dialog.button().ok());
		dialog.waitForClosed();
		
		assertTrue("Cannot reveal node \"zodiac.bpmn\".", revealNodeFromParent("zodiac.bpmn", bpem));
		assertTrue("Cannot reveal (reverse refactored) node \"sap.com/glx/ide\".", revealNodeFromParent("sap.com/glx/ide", this.currNode));
		assertTrue("Cannot reveal (reverse refactored) node \"Collaboration\".", revealNodeFromParent("Collaboration", this.currNode));
		assertTrue("Cannot reveal (reverse refactored) node \"Galaxy.Workflow.Collaboration: true\".", revealNodeFromParent(
				"Galaxy.Workflow.Collaboration: true", this.currNode));
	}

	@SuppressWarnings("nls")
	public void testShowLegend() throws Exception {

		PDEUtil.restoreCurrentView();

		final AsyncWaiter waiter = this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getShowLegendAction().run();
				return null;
			}
		});

		LShell legendDialog = this.shell.childShell().withText("Legend - Legend for MOIN Model Browser");
		legendDialog = waiter.waitForShowing(legendDialog);
		assertNotNull("Legend dialog not found.", legendDialog);
		final LButton closeButton = legendDialog.button().withText("&Close").andShows();

		assertTrue(closeButton.isVisible() && closeButton.isEnabled());
		legendDialog.clickOn(closeButton);
		legendDialog.waitForClosed();

	}

	@SuppressWarnings("nls")
	public void testOpenObjectAction() throws WidgetException {

		PDEUtil.restoreCurrentView();
		final AsyncWaiter waiter = this.shell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				ModelBrowserUITest.this.viewer.getCollapseAllAction().run();
				ModelBrowserUITest.this.viewer.getToggleTopLevelToPartitions().run();
				ModelBrowserUITest.this.viewer.getContainerPresentationToHierarchical().run();
				ModelBrowserUITest.this.viewer.getOpenObjectAction().run();
				return null;
			}
		});
		final LShell dialog = this.shell.childShell().withText("/.*Open Object And Reveal In Browser.*/");
		waiter.waitForShowing(dialog);
		this.abbotFactory.delay(2000);
		dialog.clickOn(dialog.button().ok());
		dialog.waitForClosed();
	}

	@SuppressWarnings("nls")
	private void dragAndDropTreeItem(LTree explorerTree, LTreeItem dropTarget, LTreeItem dragSource) throws WidgetException {

		explorerTree.expand(dropTarget);

		try {
			explorerTree.expand(dragSource);
		}
		catch (final Exception e) {
			fail("Drag and drop failed. Could not expand the drag source node.");
		}

		final WidgetTester t = new WidgetTester();
		final Widget source = dragSource.getWidget();
		final Widget target = dropTarget.getWidget();
		final Rectangle[] bounds = new Rectangle[2];

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {

				bounds[0] = WidgetLocator.getBounds(source);
				bounds[1] = WidgetLocator.getBounds(target);
				return null;
			}
		});
		final Rectangle sourceBounds = bounds[0];
		final int sourceX = sourceBounds.x + sourceBounds.width / 2;
		final int sourceY = sourceBounds.y + sourceBounds.height / 2;

		Event ev = new Event();
		ev.type = SWT.MouseMove;
		ev.x = sourceX;
		ev.y = sourceY;
		this.display.post(ev);
		System.out.println("x-------> Moved to drag source");

		// this.abbotFactory.delay(1000);

		Robot.waitForIdle(this.display);

		t.mousePress(SWT.BUTTON1);

		// this.abbotFactory.delay(1000);

		ev = new Event();
		ev.type = SWT.MouseMove;
		ev.x = sourceBounds.x + 1;
		ev.y = sourceY;
		ev.button = SWT.BUTTON1;
		this.display.post(ev);
		System.out.println("x-------> Moved on source");

		// this.abbotFactory.delay(1000);

		Robot.waitForIdle(this.display);
		this.display.syncExec(new Runnable() {
			public void run() {

				bounds[0] = WidgetLocator.getBounds(source);
				bounds[1] = WidgetLocator.getBounds(target);
			}
		});
		final Rectangle targetBounds = bounds[1];
		final int targetX = targetBounds.x + targetBounds.width / 2;
		final int targetY = targetBounds.y + targetBounds.height / 2;

		ev = new Event();
		ev.type = SWT.MouseMove;
		ev.x = targetX;
		ev.y = targetY;
		ev.button = SWT.BUTTON1;
		this.display.post(ev);
		System.out.println("x-------> Moved to target");

		// this.abbotFactory.delay(1000);

		Robot.waitForIdle(this.display);

		ev = new Event();
		ev.type = SWT.MouseMove;
		ev.x = targetBounds.x + 1;
		ev.y = targetY;
		ev.button = SWT.BUTTON1;
		this.display.post(ev);
		System.out.println("x-------> Moved on target");
		Robot.waitForIdle(this.display);

		// this.abbotFactory.delay(1000);

		ev = new Event();
		ev.type = SWT.MouseUp;
		ev.button = SWT.BUTTON1;
		this.display.post(ev);
		System.out.println("x-------> Released button");
		t.mouseRelease(SWT.BUTTON1);
		Robot.waitForIdle(this.display);

		// this.abbotFactory.delay(2000);
	}

	@SuppressWarnings("nls")
	private void checkCollectionValue(LTree tree, String name) {

		LTreeItem value = null;
		try {
			value = tree.treeItem().withTextAtColumn(name, 1).resolve();
			assertNotNull("Cannot reveal value: \"" + name + "\"", value);
			this.shell.clickOn(value);
		}
		catch (final Exception cause) {
			fail("Cannot reveal value: \"" + name + "\" and click on  it.", cause);
		}

	}

	@SuppressWarnings("nls")
	private void checkValue(LTreeItem item, String value) {

		try {
			final String text = item.getText(1);
			assertTrue(text + " should have value: " + value, text.equals(value));
		}
		catch (final Exception cause) {
			fail("Cannot get value: " + value, cause);
		}

	}

	@SuppressWarnings("nls")
	private void getProjectNodeAndModelTree(IProject project) {

		this.modelTree = null;
		this.projectNode = null;

		try {
			this.projectNode = this.shell.treeItem().withText(getProjectDisplayName(project)).andShows();
		}
		catch (final Exception e) {
			fail("The project node could not be revealed.", e);
		}
		try {
			this.modelTree = this.projectNode.getParent();
		}
		catch (final Exception e) {
			fail("The model tree could not be obtained.", e);
		}
		try {
			this.modelTree.expand(this.projectNode).andShows();
		}
		catch (final Exception e) {
			fail("The project node could not be expanded.", e);
		}

	}

	private String getProjectDisplayName(IProject project) {

		final String decoratedProjectName = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(
				project.getName(), project);

		if (decoratedProjectName != null && decoratedProjectName.length() > 0) {
			return decoratedProjectName;
		}

		return project.getName();
	}

	@SuppressWarnings("nls")
	private boolean revealNodeFromParent(String nodeName, LTreeItem parent) {

		boolean result = false;
		try {
			this.currNode = parent.hasItem(this.shell.treeItem().withText(nodeName));
			if (!this.currNode.isResolved()) {
				this.shell.waitForShowing(this.currNode);
			}
			this.modelTree.expand(this.currNode).andShows();
			result = true;
		}
		catch (final WidgetException e) {
			fail("Node \"" + nodeName + "\" not found in model browser tree.", e);
		}
		catch (final WaitTimedOutError err) {
			fail("Timout when finding node " + nodeName + " not found in model browser tree.", err);
		}

		assertTrue("Cannot resovle node " + nodeName, this.currNode.isResolved());
		return result;

	}

	@SuppressWarnings("nls")
	private boolean revealNode(String nodeName) {

		boolean result = false;

		try {
			this.currNode = this.projectNode.hasItem(this.shell.treeItem().withText(nodeName));
			if (!this.currNode.isResolved()) {
				this.shell.waitForShowing(this.currNode);
			}
			this.modelTree.expand(this.currNode).andShows();
			result = true;
		}
		catch (final WidgetException e) {
			fail("Node \"" + nodeName + "\" not found in model browser tree.", e);
		}
		catch (final WaitTimedOutError err) {
			fail("Timout when finding node " + nodeName + " not found in model browser tree.", err);
		}

		assertTrue("Cannot resovle node " + nodeName, this.currNode.isResolved());
		return result;
	}

	@SuppressWarnings("nls")
	private void findSrcNode(IProject project) {

		try {
			this.projectNode = this.shell.treeItem().withText(getProjectDisplayName(project)).andShows();
		}
		catch (final Exception e) {
			fail("The project node could not be revealed.", e);
		}
		this.modelTree = null;

		try {
			this.modelTree = this.projectNode.getParent();
		}
		catch (final Exception e) {
			fail("The model tree could not be obtained.", e);
		}

		try {
			this.modelTree.expand(this.projectNode);
			this.srcNode = this.projectNode.hasItem(this.shell.treeItem().withText("src"));
			int i = 0;
			while (i < 10) {
				this.modelTree.expand(this.srcNode).andShows();
				i = i + 1;
			}

		}
		catch (final Exception e) {
			fail("The node \"src\" could not be revealed.", e);
		}

	}

	@SuppressWarnings("nls")
	private boolean openNodeAndCollapse(LTreeItem node, String nodeName) {

		boolean result;

		result = revealNode(nodeName);
		try {
			this.shell.clickOn(node);
		}
		catch (final Exception e) {
			fail("Could not click on \"" + nodeName + "\".", e);
		}
		result = true;
		this.shell.enter(this.abbotFactory.key().shift().arrowLeft());
		return result;
	}
}
