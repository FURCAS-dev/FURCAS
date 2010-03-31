package com.sap.mi.tools.mmdeploy.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

import com.sap.ide.junit.extensions.ActiveSWTTestSuite;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.Keys;
import com.sap.ide.junit.ui.lift.LButton;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LMenu;
import com.sap.ide.junit.ui.lift.LMenuItem;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTable;
import com.sap.ide.junit.ui.lift.LTableItem;
import com.sap.ide.junit.ui.lift.LText;
import com.sap.ide.junit.ui.lift.LToolItem;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.ui.lift.LShell.AsyncWaiter;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.test.service.MetamodelBasedTest;
import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;
import com.sap.mi.tools.mmdeploy.internal.view.EditWorkingSetsAction;
import com.sap.mi.tools.mmdeploy.internal.view.MmDeploymentView;
import com.sap.mi.tools.mmdeploy.internal.view.MmSorter.MmSortListener;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests the metamodel deployment view
 * 
 * @author d031150
 */
public final class MmDeploymentViewTest extends MetamodelBasedTest {

	private static final String MM_CONTAINER_GFW = "sap.com/com/sap/mi/gfw/mm";

	private static final String DIALOG_NAME_EDIT_WORKINGSET = "Edit Working Set";
	private static final String DIALOG_NAME_NEW_WORKINGSET = "New Working Set";
	private static final String DIALOG_NAME_SELECT_WORKINGSETS = "/.*Select Working Sets.*/";

	private static final String PROPERTY_LABEL_MM_NAME = "container name";
	private static final String WORKINGSET_PAGE_INPUT_NAME = "MmWorkingSetPage.nameWorkingSet";
	private static final String WORKINGSET_PAGE_TABLE = "MmWorkingSetPage.tableWorkingSets";

	private static final String TOOLTIP_SHOW_WORKING_SETS = "Show the metamodel working sets";
	private static final String NAME_TREE = "MmDeploymentView.Tree";

	//d003456: menus must have ampersands due to globalization
	private static final String MENU_TEXT_COPY = "/.*C&opy.*/";
	private static final String MENU_TEXT_PROPERTIES = "/.*P&roperties.*/";
	private static final String MENU_EDIT_WORKINGSET = "/.*Conf&igure.*/";

	private LFactory mAbbotFactory;
	private LShell mShell;
	private IViewPart mView;

	public MmDeploymentViewTest() {
		super(MmDeploymentViewTest.class.getName());
	}

	@Override
	protected String[] getMetamodels() {
		return new String[] { WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO, MM_CONTAINER_GFW };
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ActiveSWTTestSuite.requestScreenShotFor(this);

		PDEUtil.prepareWorkbench();
		PDEUtil.hideView(MetamodelManagerUI.ID_DEPLOY_VIEW);
		mView = PDEUtil.showView(MetamodelManagerUI.ID_DEPLOY_VIEW);

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);

		mShell = mAbbotFactory.getShell(Display.getDefault());

		switchOffWorkingSets();
	}

	@Override
	protected void tearDown() throws Exception {
		// close menu in either case (could still be open in case of disabled
		// menu entry)
		mShell.enter(mAbbotFactory.key().esc());

		super.tearDown();
	}

	public void testActionCopyMmInfo() throws Exception {
		LTreeItem[] mmItems = getTreeItemsForImportedMetamodels();
		// select multiple items
		Keys ctrl = mAbbotFactory.key().ctrl();
		for (LTreeItem item : mmItems)
			mShell.clickOn(ctrl, item);
		LTreeItem[] selection = mmItems[0].getParent().getSelection();
		assertEquals(mmItems.length + " items must be selected: " + Arrays.toString(selection), mmItems.length,
				selection.length);

		LMenuItem copyMenuItem = getCopyMenuItem(mmItems[0]);
		mShell.clickOn(copyMenuItem);
		String clipboardString = mShell.syncExec(new LRunnable<String>() {
			public String run() throws Exception {
				Clipboard clipboard = new Clipboard(Display.getCurrent());
				try {
					String contents = (String) clipboard.getContents(TextTransfer.getInstance());
					return contents;
				} finally {
					clipboard.dispose();
				}
			}
		});
		assertTrue("Clipboard must contain metamodel id " + WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO + ": "
				+ clipboardString, clipboardString.contains(WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO));
		assertTrue("Clipboard must contain metamodel id " + MM_CONTAINER_GFW + ": " + clipboardString, clipboardString
				.contains(MM_CONTAINER_GFW));
	}

	public void testActionShowProperties() throws Exception {
		PDEUtil.hideView(IPageLayout.ID_PROP_SHEET);

		LTreeItem[] mmItems = getTreeItemsForImportedMetamodels();
		mShell.clickOn(mmItems[0]);

		LMenuItem menuItem = getPropertiesMenuItem(mmItems[0]);
		mShell.clickOn(menuItem);
		IViewPart propertyView = mShell.syncExec(new LRunnable<IViewPart>() {
			public IViewPart run() throws Exception {
				IViewReference propRef = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.findViewReference(IPageLayout.ID_PROP_SHEET);
				if (propRef != null)
					return propRef.getView(false);
				return null;
			}
		});
		assertNotNull("Property view must be visible", propertyView);

		LTreeItem containerNameItem = mShell.treeItem().withText(PROPERTY_LABEL_MM_NAME).andShows().resolve();
		String value = containerNameItem.getText(1);
		assertEquals("Property value must contain metamodel name", getMetamodels()[0], value);
	}

	public void testActionEditWorkingSets() throws Exception {
		AsyncWaiter waiter = mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				ICommandService cmdService = (ICommandService) mView.getSite().getService(ICommandService.class);
				IHandlerService hndService = (IHandlerService) mView.getSite().getService(IHandlerService.class);
				Command cmd = cmdService.getCommand(EditWorkingSetsAction.COMMAND_ID);
				IEvaluationContext context = hndService.getCurrentState();
				ExecutionEvent event = new ExecutionEvent(cmd, Collections.emptyMap(), null, context);
				cmd.executeWithChecks(event);
				return null;
			}
		});
		LShell dialog = mShell.childShell().withText(DIALOG_NAME_SELECT_WORKINGSETS);
		waiter.waitForShowing(dialog);
		dialog.clickOn(dialog.button().cancel());
	}

	public void testActionEditWorkingSet() throws Exception {
		removeAllWorkingSets();

		Collection<MmDeploymentInfo> metamodels = getMetamodelInfo();
		IWorkingSet set = MetamodelManagerUI.getInstance().createMetamodelWorkingSet(metamodels);

		// show the working sets
		mShell.clickOn(mShell.toolItem().withToolTip(TOOLTIP_SHOW_WORKING_SETS).resolve());

		// click on "Configure"
		LTreeItem wsItem = mShell.treeItem().withText(set.getName()).andShows().resolve();
		mShell.rightClickOn(wsItem);
		LMenuItem editItem = mShell.contextMenuItem().withText(MENU_EDIT_WORKINGSET).andShows().resolve();
		mShell.clickOn(editItem);

		// cancel dialog
		LShell dialog = mShell.waitForShowing(mShell.childShell().withText(DIALOG_NAME_EDIT_WORKINGSET));
		dialog.clickOn(dialog.button().cancel());
	}

	public void testShowWorkingSetsNewDialog() throws Exception {
		removeAllWorkingSets();

		LToolItem item = mShell.toolItem().withToolTip(TOOLTIP_SHOW_WORKING_SETS).andShows().resolve();
		mShell.clickOn(item);

		LShell dialog = mShell.waitForShowing(mShell.childShell().withText(DIALOG_NAME_NEW_WORKINGSET));
		LText textWsName = dialog.text().withName(WORKINGSET_PAGE_INPUT_NAME);
		LButton okButton = dialog.button().finish();

		dialog.enter("  Invalid text   ");
		assertFalse("Finish button must not be enabled: " + okButton, okButton.isEnabled());

		textWsName.setText("");
		assertFalse("Finish button must not be enabled: " + okButton, okButton.isEnabled());

		String wsTextWebDynpro = "My new working set";
		dialog.enter(wsTextWebDynpro);
		assertTrue("Finish button must be enabled (though no items selected): " + okButton, okButton.isEnabled());

		LTable table = dialog.table().withName(WORKINGSET_PAGE_TABLE);
		final LTableItem wdItem = table.tableItem().withText("Web Dynpro");
		wdItem.resolve();

		wdItem.setChecked(true);
		assertTrue("Item must be checked: " + wdItem, wdItem.getChecked());
		assertTrue("Finish button must be enabled: " + okButton, okButton.isEnabled());

		dialog.clickOn(okButton);

		Collection<IWorkingSet> newSets = MetamodelManagerUI.getInstance().getMetamodelWorkingSets();
		assertEquals("A new working set should have been created: " + newSets, 1, newSets.size());
	}

	public void testSorter() throws Exception {
		// Lift/abbot currently do not support clicking on TreeColumns
		// so create an artifical event and call the sort listener directly
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				TreeViewer viewer = ((MmDeploymentView) mView).getTreeviewer();
				Event event = new Event();
				Tree tree = viewer.getTree();
				event.widget = tree.getColumn(1);
				new MmSortListener(viewer).handleEvent(event);
				assertEquals("Sort column must have changed", tree.getColumn(1), tree.getSortColumn());

				new MmSortListener(viewer).handleEvent(event);

				return null;
			}
		});
	}

	public void testShowWorkingSets() throws Exception {
		LToolItem item = mShell.toolItem().withToolTip(TOOLTIP_SHOW_WORKING_SETS).resolve();
		boolean on = item.getSelection();
		mShell.clickOn(item);

		// In case the "New Working Set" dialog raises (no sets defined), cancel
		// it. We don't want to test it here, and also we don't want to rely on
		// testShowWorkingSetsNewDialog() executed before, which actually should
		// have prevented the dialog from being raised.
		mShell.enter(mAbbotFactory.key().esc());

		// hide and show again
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				IWorkbenchPage page = mView.getSite().getPage();
				page.hideView(mView);
				MetamodelManagerUI.getInstance().showDeploymentView();
				return null;
			}
		});

		// test whether action keeps its state,
		// i.e. whether preference was saved
		item = mShell.toolItem().withToolTip(TOOLTIP_SHOW_WORKING_SETS).resolve();
		assertEquals("Action state should have changed and persisted", on, !item.getSelection());
	}

	private void switchOffWorkingSets() throws WidgetException {
		// switch off working sets
		LToolItem item = mShell.toolItem().withToolTip(TOOLTIP_SHOW_WORKING_SETS).resolve();
		boolean on = item.getSelection();
		if (on)
			mShell.clickOn(item);
	}

	private void removeAllWorkingSets() {
		IWorkingSetManager setManager = PlatformUI.getWorkbench().getWorkingSetManager();
		Collection<IWorkingSet> sets = MetamodelManagerUI.getInstance().getMetamodelWorkingSets();
		// remove existing sets
		for (IWorkingSet set : sets)
			setManager.removeWorkingSet(set);
	}

	private LTreeItem[] getTreeItemsForImportedMetamodels() throws Exception {
		String[] metamodels = getMetamodels();
		LTreeItem[] items = new LTreeItem[metamodels.length];
		for (int i = 0; i < metamodels.length; i++) {
			MmDeploymentInfo mm = MetamodelManager.getInstance().getDeployedMetamodel(metamodels[i]);
			items[i] = getTreeItemForMetamodel(mm);

		}
		return items;
	}

	private LTreeItem getTreeItemForMetamodel(MmDeploymentInfo mm) throws Exception {
		LTree tree = mShell.tree().withName(NAME_TREE).resolve();
		LTreeItem item = tree.treeItem().withText(mm.getLabel()).andTextAtColumn(mm.getContainerName(), 1);
		return item;
	}

	private LMenuItem getCopyMenuItem(LTreeItem mmItem) throws WidgetException {
		mShell.rightClickOn(mmItem);
		LMenuItem copyItem = mShell.menuItem().withText(MENU_TEXT_COPY);
		final LMenu contextMenu = mShell.waitForShowing(mShell.contextMenu().withItem(copyItem).andItem(
				mShell.menuItem().withText(MENU_TEXT_PROPERTIES)));
		copyItem = contextMenu.hasDirectItem(copyItem);
		return copyItem;
	}

	private LMenuItem getPropertiesMenuItem(LTreeItem mmItem) throws WidgetException {
		mShell.rightClickOn(mmItem);
		LMenuItem propertiesItem = mShell.menuItem().withText(MENU_TEXT_PROPERTIES);
		final LMenu contextMenu = mShell.waitForShowing(mShell.contextMenu().withItem(propertiesItem).andItem(
				mShell.menuItem().withText(MENU_TEXT_COPY)));
		propertiesItem = contextMenu.hasDirectItem(propertiesItem);
		return propertiesItem;
	}

	private Collection<MmDeploymentInfo> getMetamodelInfo() {
		String[] metamodelNames = getMetamodels();
		Collection<MmDeploymentInfo> metamodels = new ArrayList<MmDeploymentInfo>(metamodelNames.length);
		for (String name : metamodelNames) {
			MmDeploymentInfo metamodel = MetamodelManager.getInstance().getDeployedMetamodel(name);
			metamodels.add(metamodel);
		}
		return metamodels;
	}

}