package com.sap.mi.fwk.ui.test;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;

import abbot.WaitTimedOutError;

import com.sap.ide.dii05.lib.api.modeledit.DiiModelEditService;
import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IPublicPart;
import com.sap.ide.dii05.util.api.job.JobUtil;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.Keys;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LMenu;
import com.sap.ide.junit.ui.lift.LMenuItem;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.TextPool;
import com.sap.mi.fwk.ui.internal.TextPool.UIText;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Test for DC fwk's action to repair the DC (pp) structure
 * 
 * @author d031150
 */
public class RepairDcActionTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/repairdc";

	private LFactory mAbbotFactory;

	private LShell mShell;

	public RepairDcActionTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	@Override
	protected boolean deleteProjectOnTearDown() {
		return true;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.prepareWorkbench();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(10000); // give Dii some more time

		mShell = mAbbotFactory.getShell(Display.getDefault());
	}

	@Override
	protected void tearDown() throws Exception {
		// close potentially remaining dialogs
		Keys esc = mAbbotFactory.key().esc();
		mShell.enter(esc).enter(esc).enter(esc);

		super.tearDown();
	}

	@SuppressWarnings("unchecked")
	public void testRepairAction() throws Exception {
		IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(getProject());
		List<IPublicPart> pps = dc.getLocalState().getPublicParts();
		int ppCountBefore = pps.size();
		String ppName = pps.get(0).getName();

		// remove whole pp and repair DC afterwards
		DiiModelEditService.deletePublicPart(dc.getLocalState(), ppName, null);
		pps = dc.getLocalState().getPublicParts();
		assertEquals("Public part must have been removed: " + pps, ppCountBefore - 1, pps.size());

		startRepairAction();
		ensureNoErrorDialog();

		boolean ppCreated = false;
		pps = dc.getLocalState().getPublicParts();
		for (IPublicPart pp : pps) {
			if (ppName.equals(pp.getName())) {
				ppCreated = true;
				break;
			}
		}
		assertTrue("Public part must have been repaired. Public parts: " + pps, ppCreated);
	}

	@SuppressWarnings("unchecked")
	public void testRepairActionNegative() throws Exception {
		// test error behavior: a dialog must appear
		IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(getProject());
		List<IPublicPart> pps = dc.getLocalState().getPublicParts();
		String ppName = pps.get(0).getName();

		// set .pp file readonly to provoke an error
		IFile ppFile = getProject().getFile(new Path("def").append(ppName).addFileExtension("pp"));
		ResourceAttributes atts = ppFile.getResourceAttributes();
		atts.setReadOnly(true);
		ppFile.setResourceAttributes(atts);

		startRepairAction();

		// Failed Dii jobs are causing job manager dialogs to appear and
		// disappear. Wait a moment so that our error dialog
		// is the only one on the screen,
		mAbbotFactory.delay(1500);

		confirmErrorDialog();
	}

	private void startRepairAction() throws Exception {
		final CommonNavigator explorerPart = (CommonNavigator) PDEUtil
				.showView("org.eclipse.ui.navigator.ProjectExplorer");
		Tree tree = mShell.syncExec(new LRunnable<Tree>() {
			public Tree run() throws Exception {
				CommonViewer viewer = explorerPart.getCommonViewer();
				viewer.refresh();
				return viewer.getTree();
			}
		});

		String projectLabel = MiFwkUIPlugin.getProjectLabel(getProject());
		LTreeItem projectItem = mAbbotFactory.widgetFor(tree).resolve().treeItem().withText(projectLabel).andShows();
		mShell.rightClickOn(projectItem);
		LMenuItem modelingItem = mShell.menuItem().withText(
				"/.*" + TextPool.getString(UIText._menu_name_modeling) + ".*/").andShows();
		LMenu modelingMenu = mShell.contextMenu().withItem(modelingItem).resolve();
		mShell.clickOn(modelingItem);
		LMenuItem actionItem = modelingMenu.hasItem(mShell.menuItem().withText("/.*Repair Project.*/")).andShows();
		mShell.clickOn(actionItem);
		mAbbotFactory.delay(2000);

		JobUtil.waitForDiiJobs(mAbbotFactory.getWaitTimeout());
	}

	private void ensureNoErrorDialog() throws Exception {
		LShell dialog = mShell.childShell().withName(ExtendedMessageDialog.class.getName());
		try {
			dialog = mShell.waitForShowing(dialog);
			fail("Error dialog not expected: " + dialog);
		} catch (WaitTimedOutError expected) {
		}
	}

	private void confirmErrorDialog() throws Exception {
		LShell dialog = mShell.childShell().withName(ExtendedMessageDialog.class.getName());
		dialog = mShell.waitForShowing(dialog);
		dialog.clickOn(dialog.button().ok());
		dialog.waitForClosed();
	}

}