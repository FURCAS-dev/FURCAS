package com.sap.mi.fwk.ui.test.suites;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.test.service.DisposingTestSuite;
import com.sap.mi.fwk.ui.dnd.ModelClipboardTest;
import com.sap.mi.fwk.ui.internal.RefreshClientSpecActionTest;
import com.sap.mi.fwk.ui.test.CommandGroupWizardTest;
import com.sap.mi.fwk.ui.test.CommandManagerTest;
import com.sap.mi.fwk.ui.test.CommandManagerTestSmoke;
import com.sap.mi.fwk.ui.test.ConnectionManagerUITest;
import com.sap.mi.fwk.ui.test.ConsistencyResolutionGeneratorTest;
import com.sap.mi.fwk.ui.test.DcWizardTest;
import com.sap.mi.fwk.ui.test.MarkerManagerTest;
import com.sap.mi.fwk.ui.test.MetamodelManagerUITest;
import com.sap.mi.fwk.ui.test.MmPropertySourceTest;
import com.sap.mi.fwk.ui.test.ModelAdapterUITest;
import com.sap.mi.fwk.ui.test.ModelEditorInputTest;
import com.sap.mi.fwk.ui.test.ModelEditorLauncherTest;
import com.sap.mi.fwk.ui.test.ModelEditorManagerTest;
import com.sap.mi.fwk.ui.test.ModelEditorTest;
import com.sap.mi.fwk.ui.test.ProjectSelectionDialogTest;
import com.sap.mi.fwk.ui.test.QuickfixCommandTest;
import com.sap.mi.fwk.ui.test.RefObjectPropertySourceTest;
import com.sap.mi.fwk.ui.test.RepairDcActionTest;
import com.sap.mi.fwk.ui.test.actions.StandardActionTest;
import com.sap.mi.fwk.ui.test.databinding.controls.DataBoundSectionCompositeTest;
import com.sap.mi.fwk.ui.test.handler.AbstractCommandHandlerTest;
import com.sap.mi.fwk.ui.test.handler.StandardHandlerTest;
import com.sap.mi.fwk.ui.test.tree.EditorTreeEventingTest;
import com.sap.mi.fwk.ui.test.tree.NavigatorTreeCopyPasteTest;
import com.sap.mi.fwk.ui.test.tree.NavigatorTreeDragDropTest;
import com.sap.mi.fwk.ui.test.tree.NavigatorTreeEventingTest;
import com.sap.tc.logging.Location;
import com.sap.tc.logging.Severity;

/**
 * Suite for UI-related tests (mainly in plugin <code>com.sap.mi.fwk.ui</code>).
 *
 * @author d031150
 */
public class MiFwkUiTests {

	public static Test suite() {
		TestSuite suite = new DisposingTestSuite(MiFwkUiTests.class.getName()) {
			private final Location[] locs = new Location[] { Location.getLocation(MiLocations.MI_TOOLMODELING),
					Location.getLocation("com.sap.moin.model") };

			@Override
			protected void suiteSetUp() throws Exception {
				super.suiteSetUp();
				for (Location loc : locs) {
					loc.setEffectiveSeverity(Severity.ALL);
				}
			}
		};

		suite.addTestSuite(CommandManagerTestSmoke.class);
		suite.addTestSuite(CommandGroupWizardTest.class);
		suite.addTestSuite(CommandManagerTest.class);
		suite.addTestSuite(ConnectionManagerUITest.class);
		suite.addTestSuite(ConsistencyResolutionGeneratorTest.class);
		suite.addTestSuite(DcWizardTest.class);
		suite.addTestSuite(RepairDcActionTest.class);
		suite.addTestSuite(ModelEditorManagerTest.class);
		suite.addTestSuite(ModelEditorInputTest.class);
		suite.addTestSuite(ModelEditorLauncherTest.class);
		suite.addTestSuite(ModelEditorTest.class);
		suite.addTestSuite(ModelAdapterUITest.class);
		suite.addTestSuite(MarkerManagerTest.class);
		suite.addTestSuite(MetamodelManagerUITest.class);
		suite.addTestSuite(MmPropertySourceTest.class);
		suite.addTestSuite(ProjectSelectionDialogTest.class);
		suite.addTestSuite(QuickfixCommandTest.class);
		suite.addTestSuite(RefObjectPropertySourceTest.class);
		suite.addTestSuite(ModelClipboardTest.class);

		suite.addTestSuite(NavigatorTreeEventingTest.class);
		suite.addTestSuite(EditorTreeEventingTest.class);

		suite.addTestSuite(NavigatorTreeCopyPasteTest.class);
		suite.addTestSuite(NavigatorTreeDragDropTest.class);

		suite.addTestSuite(AbstractCommandHandlerTest.class);
		suite.addTestSuite(StandardHandlerTest.class);
		suite.addTestSuite(StandardActionTest.class);

		suite.addTestSuite(RefreshClientSpecActionTest.class);

		suite.addTestSuite(DataBoundSectionCompositeTest.class);

		return suite;
	}
}
