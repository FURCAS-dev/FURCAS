package com.sap.mi.fwk.ui.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageLayout;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LCCombo;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTree;
import com.sap.ide.junit.ui.lift.LTreeItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.common.TranslatableText;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Table;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TableDesignEnum;
import com.sap.ide.metamodel.webdynpro.enums.ViewTypeEnum;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.properties.RefObjectPropertySourceManager;
import com.sap.mi.fwk.ui.test.editors.ViewEditor;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link RefObjectPropertySourceManager}
 * 
 * @author d031150
 */
public class RefObjectPropertySourceTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/refobjectproperty";

	private LFactory mAbbotFactory;
	private Display mDisplay;
	private LShell mShell;

	private View mView;
	private Set<IEditorPart> mParts;

	private Connection mConnection;

	public RefObjectPropertySourceTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		mConnection = createConnection();
		mView = getView();

		PDEUtil.prepareWorkbench();
		PDEUtil.showView(IPageLayout.ID_PROP_SHEET);

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);

		mDisplay = Display.getDefault();
		mShell = mAbbotFactory.getShell(mDisplay);

		mParts = new HashSet<IEditorPart>(2);
	}

	@Override
	protected InputStream getProjectContentAsStream() {
		return getClass().getResourceAsStream("RefObjectPropertySourceTest.zap");
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	@Override
	protected void tearDown() throws Exception {
		if (mParts != null) {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					for (IEditorPart part : mParts) {
						if (part != null) {
							part.getSite().getPage().closeEditor(part, false);
						}
					}
					return null;
				}
			});
			// mParts = null;

			for (IEditorPart part : mParts) {
				IEditorInput input = part.getEditorInput();
				IEditorPart part2 = part.getSite().getPage().findEditor(input);
				int count = 0;
				while (part2 != null && count < 10) {
					mAbbotFactory.delay(200);
					part2 = part.getSite().getPage().findEditor(input);
					count++;
				}
			}
			mParts = null;
		}

		super.tearDown();
	}

	public void testPropertiesEditable() throws Exception {
		final ViewEditor editor = openViewEditor(mView);
		View view = (View) editor.getEditorInput().getAdapter(View.class);
		final Table table = (Table) view.getRootUielementContainer().getChildren().get(0);
		// select the table element
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				editor.getSite().getSelectionProvider().setSelection(new StructuredSelection(table));
				return null;
			}
		});

		LTree propTree = mShell.has(mShell.tree().withItem(mShell.treeItem().withText("design")).andItem(
				mShell.treeItem().withText("width")));

		LTreeItem nameItem = propTree.treeItem().withText("name");
		assertTextNotEmptyAt(nameItem, 1);

		{
			// String property -> text editor
			LTreeItem widthItem = propTree.treeItem().withText("width"); // width
			// is a string property (CSS size)
			assertNull("Property 'width' must be null: " + table.getWidth(), table.getWidth());
			mShell.clickOn(widthItem);
			// switch from empty to some string
			String newValue = "fooBar";
			mShell.enter(newValue);
			// move focus to a different item so that changed value is saved
			mShell.clickOn(nameItem);
			assertEquals("Property 'width' must have new value", newValue, table.getWidth());
		}
		{
			// boolean property -> dropdown
			LTreeItem enabledItem = propTree.treeItem().withText("enabled");
			assertFalse("Property 'enabled' must be false", table.isEnabled());
			mShell.clickOn(enabledItem);
			// switch from false to true
			mShell.enter(mAbbotFactory.key().arrowUp());
			// move focus to a different item so that changed value is saved
			mShell.clickOn(nameItem);
			assertTrue("Property 'enabled' must be true", table.isEnabled());

			// check for the property's annotation set as description
			// in the status line
			mShell.clickOn(enabledItem);
			mShell.cLabel().withText("/Determines whether.*enabled.*/").resolve();
		}
		{
			// enum property -> dropdown
			LTreeItem designItem = propTree.treeItem().withText("design");
			assertNull("Property 'design' must be null: " + table.getDesign(), table.getDesign());
			mShell.clickOn(designItem);

			// check available items
			LCCombo designCombo = propTree.ccombo().withItem(TableDesignEnum.ALTERNATING.toString()).resolve();
			List<String> labels = getAttributeLabels(table, "design");
			List<String> items = new ArrayList<String>(Arrays.asList(designCombo.getItems()));
			assertTrue("Empty label must be in the combo: " + items, items.remove(""));
			assertEquals("All labels must be in the combo", labels, items);

			// switch value from empty to alternating
			mShell.enter(mAbbotFactory.key().arrowDown());
			// move focus to a different item so that changed value is saved
			mShell.clickOn(nameItem);
			assertEquals("Property 'design' must have value 'alternative'", TableDesignEnum.ALTERNATING.toString(), String.valueOf(table
					.getDesign()));
		}
		{
			// int property -> dropdown
			LTreeItem rowItem = propTree.treeItem().withText("firstVisibleRow");
			assertEquals("Property 'firstVisibleRow' must have value 0", 0, table.getFirstVisibleRow());
			mShell.clickOn(rowItem);
			// enter an invalid string
			mShell.enter("foobar");
			// move focus to a different item so that changed value is saved
			mShell.clickOn(nameItem);
			assertEquals("Property 'firstVisibleRow' must still have old value", 0, table.getFirstVisibleRow());
			mShell.clickOn(rowItem);
			// enter a valid string
			int newValue = -1;
			mShell.enter(String.valueOf(newValue));
			// move focus to a different item so that changed value is saved
			mShell.clickOn(nameItem);
			assertEquals("Property 'firstVisibleRow' must now have new value", newValue, table.getFirstVisibleRow());
		}
		{
			// Unsupported complex property -> readonly editor
			LTreeItem tooltipItem = propTree.treeItem().withText("tooltip"); // of
			// type TranslatableText
			TranslatableText oldValue = table.getTooltip();
			mShell.clickOn(tooltipItem);
			// try to enter some string
			String newValue = "fooBar";
			mShell.enter(newValue);
			// move focus to a different item so that changed value is saved
			mShell.clickOn(nameItem);
			assertEquals("Property 'tooltip' must still have old value", oldValue, table.getTooltip());
		}
	}

	public void testPropertiesNotEditable() throws Exception {
		// select the object in a view part
		mShell.syncExec(new LRunnable<TestView>() {
			public TestView run() throws Exception {
				// Need to close all instances of the view before
				// since otherwise stale objects may be present from previous
				// test runs that could cause exeptions when setting a selection
				// (RefBaseObjectWrapperImpl.equals() throws an exception in
				// case of closed connections).
				PDEUtil.hideView(TestView.ID_VIEW);

				// we use our own test view here since big explorer trees are
				// more complex to handle
				TestView view = (TestView) PDEUtil.showView(TestView.ID_VIEW);
				view.setInputAndSelect(mView);
				return view;
			}
		});

		// again make the property view visible since it might be
		// hidden by the test view
		PDEUtil.showView(IPageLayout.ID_PROP_SHEET);

		LTree propTree = mShell.has(mShell.tree().withItem(mShell.treeItem().withText("name")).andItem(mShell.treeItem().withText("type")));
		// all properties must readonly - test is to try to enter something
		LTreeItem nameItem = propTree.treeItem().withText("name");
		LTreeItem tooltipItem = propTree.treeItem().withText("type");
		ViewTypeEnum oldValue = mView.getType();
		mShell.clickOn(tooltipItem);
		// try to enter some string
		String newValue = "fooBar";
		mShell.enter(newValue);
		// move focus to a different item so that changed value is saved
		mShell.clickOn(nameItem);
		assertEquals("Property 'type' must still have old value", oldValue, mView.getType());

		// test partition properties
		{
			LTreeItem fileItem = propTree.treeItem().withText("file").resolve();
			String fileText = assertTextNotEmptyAt(fileItem, 1);
			String filePath = ModelAdapter.getInstance().getFile(mView).getLocation().toOSString();
			assertEquals("Partition file path expected", filePath, fileText);
		}
		{
			LTreeItem idItem = propTree.treeItem().withText("id").resolve();
			String priText = assertTextNotEmptyAt(idItem, 1);
			PRI pri = ModelAdapter.getInstance().getPri(mView);
			assertEquals("Partition file path expected", pri.toString(), priText);
		}
	}

	private ViewEditor openViewEditor(final View view) throws Exception {
		return mShell.syncExec(new LRunnable<ViewEditor>() {
			public ViewEditor run() throws Exception {
				ViewEditor editor = ViewEditor.open(view);
				mParts.add(editor);
				return editor;
			}
		});
	}

	private static String assertTextNotEmptyAt(LTreeItem item, int col) throws WidgetException {
		String text = item.getText(col);
		assertNotNull("Text must not be null for tree item " + item, text);
		assertTrue("Text must not be empty for tree item " + item, text.length() > 0);
		return text;
	}

	private List<String> getAttributeLabels(RefObject object, String attributeName) {
		RefObject metaObject = object.refMetaObject();
		JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(object);
		Attribute attr = jmiHelper.getAttributeByName((MofClass) metaObject, attributeName, true);
		Classifier type = jmiHelper.getNonAliasType(attr.getType());
		return ((EnumerationType) type).getLabels();
	}

	private View getView() {
		List<Component> components = QueryService.getInstance().queryInstances(getProject(), mConnection, CONTAINER_NAME_WEBDYNPRO,
				TYPE_NAME_COMPONENT);
		assertTrue("No Component found in " + components, components.size() > 0);
		Component component = components.get(0);
		List<View> views = component.getViews();
		assertTrue("No view found in component" + component, views.size() > 0);
		return views.get(0);
	}

	// 
	// private View createView() throws Exception {
	// final IPath PARTITION_FOLDER =
	// SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/prop");
	// PRI partitionMRI = getPri(getProject(),
	// PARTITION_FOLDER.append("Partition"));
	// ModelPartition partition = mConnection.getPartition(partitionMRI);
	// if (partition != null) {
	// partition.delete();
	// }
	// partition = mConnection.createPartition(partitionMRI);
	// assertNotNull("Partition creation failed", partition);
	//
	// ComponentPackage compPackage = (ComponentPackage)
	// mConnection.getPackage(CONTAINER_NAME_WEBDYNPRO,
	// PACKAGE_NAME_COMPONENT);
	// Component component =
	// compPackage.getComponent().createComponent("testComponent");
	// partition.assignElement((Partitionable) component);
	//
	// ViewClass viewClass = compPackage.getView().getView();
	// View view = viewClass.createView();
	// component.getViews().add(view);
	// view.setName("testView1");
	// view.setType(ViewTypeEnumEnum.NORMAL);
	//
	// ViewPackage viewPackage = (ViewPackage)
	// view.refClass().refImmediatePackage();
	// UielementPackage elementsPack = viewPackage.getUielement();
	// UielementContainer container = elementsPack.getTransparentContainer()
	// .createTransparentContainer();
	// container.setName("RootElement");
	// view.setRootUielementContainer(container);
	// Table table = elementsPack.getTable().createTable();
	// table.setName("Table");
	// container.getChildren().add(table);
	//        
	// ModelManager.getConnectionManager().save(mConnection);
	// return view;
	// }

}
