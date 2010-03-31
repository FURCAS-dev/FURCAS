package com.sap.mi.fwk.ui.internal;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.navigator.CommonNavigator;

import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

public class RefreshClientSpecActionTest extends WebDynproProjectTest {

	private CommonNavigator projectExplorer;
	private ICommandService cmdService;
	private IHandlerService hndService;
	private Command cmd;

	public RefreshClientSpecActionTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		if (PDEUtil.closeWelcomePage()) {
			PDEUtil.restoreActivePage();
		}

		projectExplorer = (CommonNavigator) PDEUtil.showView("org.eclipse.ui.navigator.ProjectExplorer");

		cmdService = (ICommandService) projectExplorer.getSite().getService(ICommandService.class);
		hndService = (IHandlerService) projectExplorer.getSite().getService(IHandlerService.class);
		cmd = cmdService.getCommand("com.sap.mi.fwk.ui.commands.refreshclientspec");
	}

	@Override
	protected String getDcName() {
		return getClass().getName();
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	public void testEnabled() throws Exception {
		assertFalse(cmd.isEnabled());

		selectProjectInExplorer();

		assertTrue(cmd.isEnabled());
	}

	public void testExecute_CleanConnection() throws Exception {
		selectProjectInExplorer();

		execute();
		assertFalse("Save dialog must not have been shown", TestRefreshClientSpecAction.saveDialogShown());
		assertTrue("Refresh must have been called", TestRefreshClientSpecAction.refreshCalled());
	}

	public void testExecute_DirtyConnection() throws Exception {
		selectProjectInExplorer();

		IPreferenceStore prefStore = MiFwkUIPlugin.getDefault().getPreferenceStore();

		// suppress dialog
		{
			prefStore.setValue(RefreshClientSpecAction.PREF_KEY_SUPPRESS_SAVE_DIALOG_ON_REFRESH, true);

			createElement();
			execute();
			assertFalse("Save dialog must not have been shown", TestRefreshClientSpecAction.saveDialogShown());
			assertTrue("Refresh must have been called", TestRefreshClientSpecAction.refreshCalled());
		}
		// allow dialog
		{
			prefStore.setValue(RefreshClientSpecAction.PREF_KEY_SUPPRESS_SAVE_DIALOG_ON_REFRESH, false);

			createElement();
			execute();
			assertTrue("Save dialog must have been shown", TestRefreshClientSpecAction.saveDialogShown());
			assertTrue("Refresh must have been called", TestRefreshClientSpecAction.refreshCalled());
		}
		// allow dialog, simulate cancellation
		{
			prefStore.setValue(RefreshClientSpecAction.PREF_KEY_SUPPRESS_SAVE_DIALOG_ON_REFRESH, false);
			TestRefreshClientSpecAction.saveDialogResult = null; // means cancel

			createElement();
			execute();
			assertTrue("Save dialog must have been shown", TestRefreshClientSpecAction.saveDialogShown());
			assertFalse("Refresh must not have been called", TestRefreshClientSpecAction.refreshCalled());
		}
	}

	private void createElement() {
		Connection connection = createConnection();
		PRI pri = getPri(getProject(), new Path("src/partition.xmi"));
		ModelPartition partition = connection.getPartition(pri);
		if (partition == null) {
			partition = connection.createPartition(pri);
		}
		connection.createElementInPartition(Component.class, partition).setName("component");
	}

	private void selectProjectInExplorer() {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				projectExplorer.selectReveal(new StructuredSelection(getProject()));
			}
		});
	}

	private void execute() {
		final Exception[] ex = new Exception[1];
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					ExecutionEvent executionEvent = hndService.createExecutionEvent(cmd, null);
					RefreshClientSpecAction handler = new TestRefreshClientSpecAction();
					handler.execute(executionEvent);
				} catch (Exception e) {
					ex[0] = e;
				}
			}
		});

		if (ex[0] != null) {
			fail(ex[0]);
		}
	}

	private static class TestRefreshClientSpecAction extends RefreshClientSpecAction {

		private static TestRefreshClientSpecAction instance;
		private volatile boolean saveDialogShown;
		private volatile boolean refreshCalled;
		static volatile Boolean saveDialogResult = true;

		public TestRefreshClientSpecAction() {
			instance = this;
		}

		@Override
		protected Boolean showSaveDialog(MessageDialogWithToggle dialog) {
			saveDialogShown = true;
			Boolean result = saveDialogResult;
			saveDialogResult = true;
			return result;
		}

		@Override
		protected void doRefresh(IProject project) {
			super.doRefresh(project);
			refreshCalled = true;
		}

		static boolean refreshCalled() {
			return instance.refreshCalled;
		}

		static boolean saveDialogShown() {
			return instance.saveDialogShown;
		}
	}

}
