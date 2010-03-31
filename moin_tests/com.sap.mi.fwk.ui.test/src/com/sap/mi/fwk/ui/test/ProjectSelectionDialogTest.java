package com.sap.mi.fwk.ui.test;

import org.eclipse.core.resources.IProject;
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
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.fwk.ui.projectselection.ProjectSelectionDialog;

/**
 * Tests the project selection dialog
 */
public class ProjectSelectionDialogTest extends ProjectBasedTest {

	private static final String DC_NAME = "test/projectselection";

	private LFactory mAbbotFactory;
	private Display mDisplay;
	private LShell mShell;

	public ProjectSelectionDialogTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setDeleteProjectOnTearDown();
		
		PDEUtil.prepareWorkbench();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);
		mDisplay = Display.getDefault();
		mShell = mAbbotFactory.getShell(mDisplay);
	}

	public void testOpenDialog() {

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				//error with 3.4. IDE - instantiate dialog in UI thread, 
				//otherwise JFaceResources does not find the current display
				ProjectSelectionDialog dlg = new ProjectSelectionDialog();
				IProject project = dlg.openDialog();
				IProject result = getProject();
				assertEquals(project, result);
				return null;
			}
		};

		try {
			mShell.asyncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		try {
			LShell dialogShell = waitForDialog(mShell, ProjectSelectionDialog.SHELL_PROJECT_SELECTION_DIALOG);
			LTable table = dialogShell.table().withName("ProjectSelectionDialog.SelectProject.list");
			LTableItem markerItem = table.tableItem().withText("/.*" + DC_NAME + ".*/").resolve();
			mShell.clickOn(markerItem);

			if (!dialogShell.isDisposed())
				pressOk(dialogShell);
		} catch (Exception e) {
			fail(e);
		}
	}

	private static LShell waitForDialog(LShell parent, String name) throws WidgetException {
		LShell dialogShell = parent.waitForShowing(parent.childShell().withName(name));
		assertNotNull("No Dialog shell found", dialogShell);
		return dialogShell;
	}

	private void pressOk(LShell dialog) throws Exception {
		LButton button = dialog.button().ok();
		assertNotNull("No Ok button found", button);
		dialog.clickOn(button);
		dialog.waitForClosed();
	}
}
