package com.sap.mi.tools.cockpit.editor.test;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import abbot.WaitTimedOutError;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;

/**
 * No meta models needed, meta model is MOF here.
 * 
 * @author d003456
 * 
 */
public class ModelBrowserUITest2 extends ProjectBasedTest {

	private static final String DC_NAME = "testproject-ModelBrowserUITest2";
	private static final String ID_COCKPIT_PERSPECTIVE = "com.sap.mi.tools.cockpit.editor.perspective.CockpitPerspective";
	private static final String ID_MODEL_BROWSER_VIEW = "com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView";
	/**
	 * Message
	 */
	private static final String MSG_PROJECT_NOT_CREATED = "Project not created.";

	/**
	 * Relativ path to zip file with partitions
	 */
	private static final String MODEL_BROWSER_TEST_DATA_2 = "/resources/ModelBrowserTestData2.zap";

	private LFactory abbotFactory;
	private Display display;
	private MOINBrowserView viewer;
	private LShell shell;
	private LTreeItem projectNode;
	private LTreeItem currNode;

	private LTree modelTree;

	/**
	 * Constructor.
	 */
	public ModelBrowserUITest2() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getDcName()
	 */
	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#getProjectContentAsStream()
	 */
	@Override
	protected InputStream getProjectContentAsStream() {
		return ModelBrowserUITest.class.getResourceAsStream(MODEL_BROWSER_TEST_DATA_2);
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

		assertNotNull(MSG_PROJECT_NOT_CREATED, getProject());

		this.abbotFactory = FactoryBuilder.newAbbotFactory();
		this.display = Display.getDefault();
		this.shell = this.abbotFactory.getShell(this.display);
		this.abbotFactory.setFindTimeOut(50000);
		this.abbotFactory.setWaitTimeout(50000);

		PDEUtil.closeWelcomePage();

		PDEUtil.openPerspective(ID_COCKPIT_PERSPECTIVE);

		PDEUtil.maximizeWorkbenchAndRequestFocus();
		PDEUtil.assertDisplayIsActiveWindow();
		this.viewer = (MOINBrowserView) PDEUtil.showView(ID_MODEL_BROWSER_VIEW);

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

	/**
	 * Test for CSN 946505 2008. There exist only one object which should be
	 * inspected in Meta model based view.
	 * 
	 * @throws Exception
	 */
	public void testHierarchyOfMetaModelWithOneObject() throws Exception {

		this.shell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				ModelBrowserUITest2.this.viewer.getToggleTopLevelToMetaModelNames().run();
				return null;
			}
		});

		getProjectNodeAndModelTree(getProject());

		assertTrue("Cannot reveal node \"sap.com/tc/moin/mof_1.4\".", revealNodeFromParent("sap.com/tc/moin/mof_1.4",
				this.projectNode));
		LTreeItem moinMof = this.currNode;

		assertTrue("Cannot reveal node \"MOIN\".", revealNodeFromParent("MOIN", moinMof));
		LTreeItem moinPck = this.currNode;

		assertTrue("Cannot reveal node \"Model\".", revealNodeFromParent("Model", moinPck));
		LTreeItem modelPck = this.currNode;

		assertTrue("Cannot reveal node \"Package\".", revealNodeFromParent("Package", modelPck));
		LTreeItem packageType = this.currNode;

		assertTrue("Cannot reveal node \"Package\".", revealNodeFromParent("Model.Package: test", packageType));

	}

	private void getProjectNodeAndModelTree(IProject project) {

		this.modelTree = null;
		this.projectNode = null;

		try {
			this.projectNode = this.shell.treeItem().withText(getProjectDisplayName(project)).andShows();
		} catch (Exception e) {
			fail("The project node could not be revealed.", e);
		}
		try {
			this.modelTree = this.projectNode.getParent();
		} catch (Exception e) {
			fail("The model tree could not be obtained.", e);
		}
		try {
			this.modelTree.expand(this.projectNode);
		} catch (Exception e) {
			fail("The project node could not be expanded.", e);
		}

	}

	private String getProjectDisplayName(IProject project) {

		String decoratedProjectName = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(
				project.getName(), project);

		if (decoratedProjectName != null && decoratedProjectName.length() > 0) {
			return decoratedProjectName;
		}

		return project.getName();
	}

	private boolean revealNodeFromParent(String nodeName, LTreeItem parent) {
		boolean result = false;

		try {
			this.currNode = parent.hasItem(this.shell.treeItem().withText(nodeName));
			if (!this.currNode.isResolved()) {
				this.shell.waitForShowing(this.currNode);
			}
			this.modelTree.expand(this.currNode).andShows();
			result = true;
		} catch (WidgetException e) {
			fail("Node \"" + nodeName + "\" not found in model browser tree.", e);
		} catch (WaitTimedOutError err) {
			fail("Timout when finding node " + nodeName + " not found in model browser tree.", err);
		}

		assertTrue("Cannot resovle node " + nodeName, this.currNode.isResolved());
		return result;

	}

}
