package com.sap.mi.fwk.ui.test;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Display;

import abbot.WaitTimedOutError;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDcMetadataState;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IPublicPart;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.ui.internal.i18n.CommonMessages;
import com.sap.ide.dii05.util.api.job.JobUtil;
import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.Keys;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LMenu;
import com.sap.ide.junit.ui.lift.LMenuItem;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LText;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.dcfwk.ui.NewMoinDcWizard;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.test.wizards.TestNewWizard;
import com.sap.tc.moin.nwdi.dctype.MoinTestDcType;

/**
 * Tests the custom New DC wizard functionality ({@link NewMoinDcWizard}).
 * 
 * @author d031150
 */
public class DcWizardTest extends ExtendedTestCase {

	private static final String DC_NAME = "test/dcwizard";
	// must match to plugin.xml
	private static final String NAME_TEST_DC_WIZARD = "Test for Custom DC New Wizard";

	private static final String ID_COMPONENT_BROWSER = "com.sap.ide.dii05.ui.internal.views.browser.ComponentBrowserView";

	private LFactory mAbbotFactory;
	private LShell mShell;
	private Display mDisplay;
	private IDevelopmentComponent mDc;

	public DcWizardTest() {
		super(DcWizardTest.class.getName());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.prepareWorkbench();
		PDEUtil.openResourcePerspective();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(10000); // give Dii some more time

		mDisplay = Display.getDefault();
		mShell = mAbbotFactory.getShell(mDisplay);

		IProject project = TestUtil.getLocalMoinDCProject(DC_NAME);
		if (project != null)
			TestUtil.deleteLocalMoinDCProject(project);
	}

	@Override
	protected void tearDown() throws Exception {
		// close potentially remaining dialogs
		Keys esc = mAbbotFactory.key().esc();
		mShell.enter(esc).enter(esc).enter(esc);

		if (mDc != null)
			TestUtil.deleteLocalMoinDc(mDc, true, false);

		IProject project = TestUtil.getLocalMoinDCProject(DC_NAME);
		if (project != null)
			TestUtil.deleteLocalMoinDCProject(project);

		mAbbotFactory = null;
		mDisplay = null;
		mShell = null;

		super.tearDown();
	}

	@SuppressWarnings("unchecked")
	public void testCreateDcViaCustomNewWizard() throws Exception {
		LMenuItem wizardItem = getMenuItemForNewDcWizard();
		mShell.clickOn(wizardItem);

		final LShell wizard = waitForDcCreationWizard();
		LButton finishButton = wizard.button().finish().resolve();
		LTreeItem scItem = getTreeItemForLocalSC(wizard);
		wizard.clickOn(scItem);
		LButton nextButton = wizard.button().next();
		wizard.clickOn(nextButton);

		LText nameInput = getInputFieldForDcName(wizard);
		wizard.clickOn(nameInput);
		wizard.enter(DC_NAME);

		// flip to properties page
		nextButton = wizard.button().next();
		assertTrue("Next button must be enabled: " + nextButton, nextButton.isEnabled());
		wizard.clickOn(nextButton);

		// deselect public part creation
		LButton ppCompCheckbox = wizard.button().withName(
				"CreateDefaultPublicPart.checkbox_" + Purpose.COMPILATION_LITERAL.getLiteral());
		LButton ppAssmblCheckbox = wizard.button().withName(
				"CreateDefaultPublicPart.checkbox_" + Purpose.ASSEMBLY_LITERAL.getLiteral());
		LButton ppInfraCheckbox = wizard.button().withName(
				"CreateDefaultPublicPart.checkbox_" + Purpose.INFRASTRUCTURE_LITERAL.getLiteral());
		wizard.waitForShowing(ppCompCheckbox); // wait for page flipping
		assertTrue("Checkbox must be enabled: " + ppCompCheckbox, ppCompCheckbox.isEnabled());
		assertFalse("Checkbox must not be enabled: " + ppAssmblCheckbox, ppAssmblCheckbox.isEnabled());
		assertTrue("Checkbox must be selected: " + ppCompCheckbox, ppCompCheckbox.getSelection());
		assertFalse("Checkbox must not be selected: " + ppAssmblCheckbox, ppAssmblCheckbox.getSelection());
		wizard.clickOn(ppCompCheckbox);
		assertFalse("Checkbox must be deselected: " + ppCompCheckbox, ppCompCheckbox.getSelection());
		try {
			ppInfraCheckbox = ppInfraCheckbox.resolve();
			fail("Infrastructure option must not be visible: " + ppInfraCheckbox);
		} catch (WidgetException expected) {
		}

		wizard.clickOn(finishButton);
		waitForDii(20000);

		IProject project = TestUtil.getLocalMoinDCProject(DC_NAME, "demo.sap.com");
		assertNotNull("Project for DC " + DC_NAME + " must not be null", project);
		assertTrue("Project for DC must exist", project.exists());

		mDc = DiiResourceService.getDevelopmentComponent(project);
		assertNotNull("DC with name " + DC_NAME + " must not be null", mDc);
		IDcMetadataState localState = mDc.getLocalState();
		assertNotNull("Local state for DC " + DC_NAME + " must not be null. Location state: "
				+ mDc.getLocationStateOfLocalState(), localState);
		List<IPublicPart> pps = localState.getPublicParts();
		assertTrue("Default public part must not have been created: " + pps, pps.isEmpty());
	}

	public void testCreateProjectForDc() throws Exception {
		// create a DC without a project
		mDc = TestUtil.createLocalMoinDC(DC_NAME, MoinTestDcType.getDcType());
		assertNotNull("Dc must have been created" + DC_NAME, mDc);
		IProject project = TestUtil.getLocalMoinDCProject(DC_NAME);
		assertNull("No project must have been created for DC " + mDc.getName(), project);

		// show it in component browser
		LTreeItem dcNode = revealDcNodeInBrowser(mDc);

		// context menu for creating a project
		mShell.rightClickOn(dcNode);
		LMenuItem projectItem = mShell.menuItem().withText("/Sync.*Create Pro&ject.*/");
		LMenu projectMenu = mShell.menu().withItem(projectItem).resolve();
		mShell.clickOn(projectItem);
		LMenuItem createItem = mShell.menuItem().withText("Create &Project");
		projectMenu.hasItem(createItem).resolve();
		mShell.clickOn(createItem);

		confirmSyncDialog();

		// now project must be there
		project = TestUtil.getLocalMoinDCProject(DC_NAME);
		assertNotNull("Project must have been created for DC " + mDc.getName(), project);
		assertTrue("Project must be open: " + project.getName(), project.isOpen());
	}

	private LMenuItem getMenuItemForNewDcWizard() throws WidgetException {
		// start with Window menu since this is unqiue in the workbench UI
		// (while File is not)
		LMenu mainMenu = mShell.menu().withItem(mShell.menuItem().withText("&Window")).resolve();
		LMenuItem file = mainMenu.hasDirectItem(mShell.menuItem().withText("&File"));
		mShell.clickOn(file);

		LMenuItem newItem = file.getMenu().hasDirectItem(mShell.menuItem().withText("/.*&New.*/"));
		mShell.clickOn(newItem);

		LMenuItem wizardItem = newItem.getMenu().hasDirectItem(mShell.menuItem().withText(NAME_TEST_DC_WIZARD));
		return wizardItem.resolve();
	}

	private LText getInputFieldForDcName(LShell wizard) throws WidgetException {
		return wizard.text().withName("dcname").andShows().resolve();
	}

	private LTreeItem getTreeItemForLocalSC(LShell wizard) throws Exception {
		LTreeItem rootItem = wizard.treeItem().withText("/.*LocalDevelopment.*/");
		LTree tree = rootItem.getParent();
		tree.expand(rootItem);
		LTreeItem scItem = tree.treeItem().withText("/.*MyComponents.*/");
		tree.expand(scItem);
		tree.show(scItem);
		waitForDii(10000);
		mAbbotFactory.delay(10000);
		return scItem;
	}

	private LShell waitForDcCreationWizard() throws WidgetException {
		LShell dialog = mShell.waitForShowing(mShell.childShell().withText(TestNewWizard.WIZARD_TITLE));
		return dialog;
	}

	private void confirmSyncDialog() throws Exception {
		// next operation may last extraordinary long
		// since dependencies are resolved by Dii
		mAbbotFactory.setWaitTimeout(120000);
		try {
			LShell syncDialog = mShell.waitForShowing(mShell.childShell().withText("/.*Sync Sources.*/"));
			LButton deselectButton = syncDialog.button().withText(CommonMessages.Action_deselectAll_acc_XBUT);
			syncDialog.clickOn(deselectButton);
			LButton buildCheckbox = syncDialog.button().withText("/.*Build DCs.*/");
			syncDialog.clickOn(buildCheckbox);
			LButton okButton = syncDialog.button().ok();
			syncDialog.clickOn(okButton);
			syncDialog.waitForClosed();
			// give Dii some more time
			waitForDii(mAbbotFactory.getWaitTimeout());
		} catch (WaitTimedOutError e) {
			fail("Waited for Sync Dialog for at least " + mAbbotFactory.getWaitTimeout() + "ms", e);
		}
	}

	private LTreeItem revealDcNodeInBrowser(IDevelopmentComponent dc) throws WidgetException {
		PDEUtil.hideView(ID_COMPONENT_BROWSER);
		PDEUtil.showView(ID_COMPONENT_BROWSER);

		LTreeItem compartmentItem = mShell.treeItem().withText("/.*LocalDevelopment.*/");
		LTree tree = compartmentItem.getParent();
		tree.show(compartmentItem);
		tree.expand(compartmentItem);
		LTreeItem scItem = tree.treeItem().withText("/.*MyComponents.*/");
		tree.show(scItem);
		tree.expand(scItem);

		LTreeItem dcItem = tree.treeItem().withText("/.*" + dc.getName() + ".*/");
		tree.show(dcItem);

		return dcItem;
	}

	private void waitForDii(int timeout) throws InterruptedException {
		// wait an additional time to give Dii jobs the chance to start
		mAbbotFactory.delay(2000);
		JobUtil.waitForDiiJobs(timeout);
	}

}