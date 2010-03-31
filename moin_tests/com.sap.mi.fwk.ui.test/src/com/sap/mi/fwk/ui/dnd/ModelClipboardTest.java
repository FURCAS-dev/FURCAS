package com.sap.mi.fwk.ui.dnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ResourceTransfer;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.Keys;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.LTable;
import com.sap.ide.junit.ui.lift.LTableItem;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.ui.lift.LShell.AsyncWaiter;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.common.CommonDevelopmentObject;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentInterface;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.ComponentUsage;
import com.sap.ide.metamodel.webdynpro.component.LocalComponentInterface;
import com.sap.ide.metamodel.webdynpro.component.controller.Controller;
import com.sap.ide.metamodel.webdynpro.component.controller.ControllerPackage;
import com.sap.ide.metamodel.webdynpro.component.controller.ControllerUsage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.ViewPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Button;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Caption;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Group;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Table;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TableColumn;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Uielement;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.ViewElement;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.ViewElementAggregation;
import com.sap.ide.metamodel.webdynpro.enums.ComponentLifecycleEnumEnum;
import com.sap.ide.metamodel.webdynpro.enums.ViewLifespanEnumEnum;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.dnd.ModelClipboard.TransferLog;
import com.sap.mi.fwk.ui.internal.dnd.CopyObjectsAction;
import com.sap.mi.fwk.ui.internal.dnd.PasteObjectsAction;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Tests <code>com.sap.mi.fwk.ui.dnd</code> package
 * 
 * @author d031150
 */
public class ModelClipboardTest extends WebDynproProjectTest {

	private static final String DC_NAME = "test/clipboard";

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/clp");

	private Connection mConnectionSource;
	private Connection mConnectionTarget;

	private Component mComponentSource;
	private View mViewSource;
	private Controller mViewControllerSource;
	private Component mUsedComponentSource;
	private Group mGroupSource;
	private Caption mCaptionSource;
	private TransparentContainer mContainer1;
	private TransparentContainer mContainer2;
	private ComponentPackage mComponentPackageSource;

	private Component mComponentTarget;

	private final TestTransferExtensionsFactory mExtensionsFactory = new TestTransferExtensionsFactory();

	private LFactory mAbbotFactory;
	private LShell mShell;
	private Clipboard mClipboard;

	public ModelClipboardTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void tearDown() throws Exception {
		if (mClipboard != null) {
			mShell.syncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					mClipboard.dispose();
					return null;
				}
			});
		}

		Platform.getAdapterManager().unregisterAdapters(mExtensionsFactory);
		TestTransferTarget.sTargetObject = null;
		ModelClipboard.getDefault().setLogClass(null);

		// close potentially remaining dialogs
		Keys esc = mAbbotFactory.key().esc();
		mShell.enter(esc).enter(esc).enter(esc);

		super.tearDown();
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	@Override
	protected void setUp() throws Exception {
		PDEUtil.prepareWorkbench();
		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);
		mShell = mAbbotFactory.getShell(Display.getDefault());
		setDeleteProjectOnTearDown();

		super.setUp();

		IAdapterManager adapterManager = Platform.getAdapterManager();
		adapterManager.registerAdapters(mExtensionsFactory, Component.class);
		adapterManager.registerAdapters(mExtensionsFactory, View.class);
		adapterManager.registerAdapters(mExtensionsFactory, getClass());

		mClipboard = mShell.syncExec(new LRunnable<Clipboard>() {
			public Clipboard run() throws Exception {
				return new Clipboard(Display.getCurrent());
			}
		});

		mConnectionSource = createConnection();
		mConnectionTarget = createConnection();

		PRI priSource = getPri(getProject(), PARTITION_FOLDER.append("component_Source"));
		ModelPartition partitionSource = mConnectionSource.getPartition(priSource);
		if (partitionSource != null)
			partitionSource.delete();
		partitionSource = mConnectionSource.createPartition(priSource);
		assertTrue("Partition must not be null and be empty, was just created. Problably Moin bug: " + partitionSource,
				partitionSource.getElements().isEmpty());

		PRI priTarget = getPri(getProject(), PARTITION_FOLDER.append("component_Target"));
		ModelPartition partitionTarget = mConnectionTarget.getPartition(priTarget);
		if (partitionTarget != null)
			partitionTarget.delete();
		partitionTarget = mConnectionTarget.createPartition(priTarget);
		assertTrue("Partition must not be null and be empty, was just created. Problably Moin bug: " + partitionTarget,
				partitionTarget.getElements().isEmpty());

		mComponentPackageSource = (ComponentPackage) mConnectionSource.getPackage(CONTAINER_NAME_WEBDYNPRO,
				PACKAGE_NAME_COMPONENT);
		mComponentSource = (Component) mComponentPackageSource.getComponent().refCreateInstance();
		mComponentSource.setName("component_Source");
		partitionSource.assignElement((Partitionable) mComponentSource);

		// a View
		RefClass viewClass = mComponentPackageSource.getView().getView();
		mViewSource = (View) viewClass.refCreateInstance();
		mViewSource.setName("view_Source");
		mViewSource.setLifespan(ViewLifespanEnumEnum.WHEN_VISIBLE);
		mComponentSource.getViews().add(mViewSource);

		ViewPackage viewPackage = (ViewPackage) mViewSource.refClass().refImmediatePackage();
		UielementPackage elementsPack = viewPackage.getUielement();
		UielementContainer rootContainer = (UielementContainer) elementsPack.getTransparentContainer()
				.refCreateInstance();
		rootContainer.setName("RootElement");
		mViewSource.setRootUielementContainer(rootContainer);
		Table table = (Table) elementsPack.getTable().refCreateInstance();
		table.setName("Table");
		TableColumn col = (TableColumn) elementsPack.getTableColumn().refCreateInstance();
		col.setName("Column");
		table.getColumns().add(col);
		rootContainer.getChildren().add(table);
		ViewElementAggregation aggr = (ViewElementAggregation) elementsPack.getViewElementAggregation()
				.refCreateInstance();
		aggr.setName("GroupedColumns");
		table.getOutgoingAggregations().add(aggr);
		TableColumn col2 = (TableColumn) elementsPack.getTableColumn().refCreateInstance();
		col2.setName("GroupedColumn");
		aggr.getAggregatedObjects().add(col2);
		mCaptionSource = (Caption) elementsPack.getCaption().refCreateInstance();
		mCaptionSource.setName("Caption");
		table.setHeader(mCaptionSource);
		mGroupSource = (Group) elementsPack.getGroup().refCreateInstance();
		mGroupSource.setName("Group");
		rootContainer.getChildren().add(mGroupSource);
		mContainer1 = (TransparentContainer) elementsPack.getTransparentContainer().refCreateInstance();
		mContainer1.setName("ContainerWithManyElements_Source");
		rootContainer.getChildren().add(mContainer1);
		for (int i = 0; i < 20; i++) {
			Button button = (Button) elementsPack.getButton().refCreateInstance();
			button.setName(String.valueOf(i));
			mContainer1.getChildren().add(button);
		}
		mContainer2 = (TransparentContainer) elementsPack.getTransparentContainer().refCreateInstance();
		mContainer2.setName("ContainerWithManyElements_Target");
		rootContainer.getChildren().add(mContainer2);

		ControllerPackage controllerPack = mComponentPackageSource.getController();
		RefClass controllerClass = controllerPack.getController();
		mViewControllerSource = (Controller) controllerClass.refCreateInstance();
		mViewSource.setViewController(mViewControllerSource);
		mComponentSource.getControllers().add(mViewControllerSource);
		ControllerUsage contrUsage = (ControllerUsage) controllerPack.getControllerUsage().refCreateInstance();
		mViewControllerSource.getOutgoingControllerUsages().add(contrUsage);
		// a second, associated component
		mUsedComponentSource = (Component) mComponentPackageSource.getComponent().refCreateInstance();
		mUsedComponentSource.setName("usedComponent_Source");
		partitionSource.assignElement((Partitionable) mUsedComponentSource);
		Controller compController = (Controller) controllerClass.refCreateInstance();
		mUsedComponentSource.getControllers().add(compController);
		mUsedComponentSource.setComponentController(compController);
		contrUsage.setUsedController(compController);

		LocalComponentInterface usedInterf = (LocalComponentInterface) mComponentPackageSource
				.getLocalComponentInterface().refCreateInstance();
		mUsedComponentSource.setLocalInterface(usedInterf);

		ComponentUsage compUsage = (ComponentUsage) mComponentPackageSource.getComponentUsage().refCreateInstance();
		compUsage.setName("usage_Source");
		compUsage.setLifecycleControl(ComponentLifecycleEnumEnum.CREATE_ON_DEMAND);
		mComponentSource.getComponentUsages().add(compUsage);
		compUsage.setUsedComponent(usedInterf);

		ComponentPackage compPackageTarget = (ComponentPackage) mConnectionTarget.getPackage(CONTAINER_NAME_WEBDYNPRO,
				PACKAGE_NAME_COMPONENT);
		mComponentTarget = (Component) compPackageTarget.getComponent().refCreateInstance();
		mComponentTarget.setName("component_Target");
		assertNotNull("Component creation not successful in class proxy " + compPackageTarget.getComponent(),
				mComponentTarget);
		partitionTarget.assignElement((Partitionable) mComponentTarget);

		assertConnectionSave(mConnectionSource);
		assertConnectionSave(mConnectionTarget);

	}

	public void testSetContent() throws Exception {
		{
			final ModelClipboard cb = ModelClipboard.getDefault();
			final RefBaseObject[] all = new RefBaseObject[] { mComponentSource, mViewSource };

			final List<IResource> iFileList = new ArrayList<IResource>(1);
			final List<String> filePaths = new ArrayList<String>(1);
			String text = mShell.syncExec(new LRunnable<String>() {
				public String run() throws Exception {
					cb.setContent(all);
					cb.getContent();
					IResource[] files = (IResource[]) mClipboard.getContents(ResourceTransfer.getInstance());
					iFileList.addAll(Arrays.asList(files));
					String[] paths = (String[]) mClipboard.getContents(FileTransfer.getInstance());
					filePaths.addAll(Arrays.asList(paths));
					return (String) mClipboard.getContents(TextTransfer.getInstance());
				}
			});

			assertNotNull("Clipboard text must not be null", text);
			String expected = ((Partitionable) mViewSource).get___Mri().toString();
			assertTrue("Clipboard text must contain '" + expected + "': " + text, text.contains(expected));
			assertTrue("Clipboard text must contain 'lifespan' attribute: " + text, text.contains(expected));
			expected = mViewSource.getLifespan().toString();
			assertTrue("Clipboard text must contain '" + expected + "': " + text, text.contains(expected));

			IFile viewFile = ModelAdapterUI.getInstance().getFile(mViewSource);
			assertTrue("Clipboard must contain '" + viewFile + "': " + iFileList, iFileList.contains(viewFile));
			expected = viewFile.getLocation().toOSString();
			assertTrue("Clipboard must contain '" + expected + "': " + filePaths, filePaths.contains(expected));
		}
		{
			final ModelClipboard cb = new ModelClipboard();
			final RefBaseObject[] all = new RefBaseObject[] { mComponentSource };

			String[] texts = mShell.syncExec(new LRunnable<String[]>() {
				public String[] run() throws Exception {
					String oldText = (String) mClipboard.getContents(TextTransfer.getInstance());
					cb.setContent(all);
					cb.getContent();
					String newText = (String) mClipboard.getContents(TextTransfer.getInstance());
					return new String[] { oldText, newText };
				}
			});
			assertEquals("Clipboard text must be the same before and after the copy", texts[0], texts[1]);
		}
	}

	public void testGetContentAs() {
		ModelClipboard cb = new ModelClipboard();
		{
			RefBaseObject[] all = new RefBaseObject[] { mComponentSource, mViewSource, mComponentPackageSource };
			cb.setContent(all);

			RefObject[] actual = cb.getContentAsRefObjects(mConnectionTarget);
			assertEquals("Source connection must be used to read content", mConnectionSource, ModelAdapterUI
					.getInstance().getConnection(actual[0]));
			RefObject[] expected = new RefObject[] { mComponentSource, mUsedComponentSource, mViewSource,
					mViewControllerSource };
			assertEquals("Expected array did not match returned", Arrays.asList(expected), Arrays.asList(actual));
		}
		{
			RefBaseObject[] all = new RefBaseObject[] { mComponentPackageSource, mComponentSource, mViewSource };
			cb.setContent(all);

			RefBaseObject[] expected = new RefBaseObject[] { mComponentPackageSource, mComponentSource,
					mUsedComponentSource, mViewSource, mViewControllerSource };
			RefBaseObject[] actual = cb.getContentAsRefBaseObjects(null);
			assertEquals("Expected array did not match returned", Arrays.asList(expected), Arrays.asList(actual));
		}
	}

	public void testClear() {
		ModelClipboard cb = new ModelClipboard();
		RefBaseObject[] expected = new RefBaseObject[] { mComponentSource, mViewSource };
		cb.setContent(expected);
		assertTrue("Clipboard must not be empty", cb.hasContent());

		cb.clear();
		RefBaseObject[] actual = cb.getContentAsRefBaseObjects(null);
		assertEquals("Expected array must be empty", 0, actual.length);
	}

	public void testMriTransferData() {
		// test equals
		RefBaseObject[] objects = new RefBaseObject[] { mComponentSource, mViewSource, mComponentPackageSource };
		List<String> objectList = new ArrayList<String>(objects.length);
		for (int i = 0; i < objects.length; i++) {
			RefBaseObject o = objects[i];
			objectList.add(((Partitionable) o).get___Mri().toString());
		}
		MriTransferData data1 = new MriTransferData(objectList);
		MriTransferData data2 = new MriTransferData(objectList);
		assertEquals("Mri data must be equal", data1, data2);

		// test hashCode()
		Set<MriTransferData> set = new HashSet<MriTransferData>();
		set.add(data1);
		set.add(data2);
		assertEquals("Set must contain only one Mri data entry: " + set, 1, set.size());

		objects = new RefBaseObject[] { mViewSource, mComponentSource, mComponentPackageSource };
		objectList = new ArrayList<String>(objects.length);
		for (int i = 0; i < objects.length; i++) {
			RefBaseObject o = objects[i];
			objectList.add(((Partitionable) o).get___Mri().toString());
		}
		data2 = new MriTransferData(objectList);
		assertFalse("Mri data must not be equal: " + data1 + " / " + data2, data1.equals(data2));
	}

	public void testCopyRootObject() throws Exception {
		final ModelClipboard cb = new ModelClipboard();
		RefBaseObject[] original = new RefBaseObject[] { mComponentSource };
		cb.setContent(original);
		{
			AsyncWaiter waiter = mShell.asyncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					// arbitrary object as input for newParent -> must be
					// ignored after having tried to extract a RefObject
					DeepCopyResultSet result = cb.duplicateAndPaste(ModelClipboardTest.this, mConnectionTarget);
					assertNull("Result must be null", result);
					return null;
				}
			});
			LShell partDialog = mShell.childShell().withName("PartitionInputDialog");
			partDialog = waiter.waitForShowing(partDialog);
			// cancel
			partDialog.clickOn(partDialog.button().cancel());
			partDialog.waitForClosed();
		}
		// copy again
		{
			RefBaseObject[] all = cb.getContentAsRefBaseObjects(null);
			final DeepCopyResultSet[] result = new DeepCopyResultSet[1];
			AsyncWaiter waiter = mShell.asyncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					// arbitrary object as input for newParent -> must be
					// ignored after having tried to extract a RefObject
					result[0] = cb.duplicateAndPaste(ModelClipboardTest.this, mConnectionTarget);
					assertNotNull("Result must not be null", result[0]);
					return null;
				}
			});
			mAbbotFactory.delay(500);
			LShell partDialog = mShell.childShell().withName("PartitionInputDialog");
			partDialog = waiter.waitForShowing(partDialog);
			partDialog.enter("newName");
			partDialog.clickOn(partDialog.button().ok());
			mAbbotFactory.delay(200);

			assertSame("Custom target must be called with this object", this, TestTransferTarget.sTargetObject);

			assertFalse("Connection must be clean ", mConnectionTarget.isDirty());
			Collection<RefObject> copies = result[0].getCopiedElements();
			ModelPartition partition = ((Partitionable) copies.iterator().next()).get___Partition();
			String partName = partition.getPri().getPartitionName();
			assertTrue("New partition must have entered name: " + partName, partName.contains("newName"));
			Collection<Partitionable> rootElements = PartitionService.getInstance().getRootElements(partition);
			assertEquals("Root elements of partition should only contain copied elements: " + rootElements, all.length,
					rootElements.size());
		}
	}

	public void testCopyAggregatedObject() throws Exception {
		final ModelClipboard cb = new ModelClipboard();
		{
			RefBaseObject[] all = new RefBaseObject[] { mViewSource };
			cb.setContent(all);

			AsyncWaiter waiter = mShell.asyncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					DeepCopyResultSet result = cb.duplicateAndPaste(mComponentTarget, mConnectionTarget);
					assertNotNull("Result must not be null", result);
					return null;
				}
			});
			LShell errorDialog = mShell.childShell().withName(ExtendedMessageDialog.class.getName());
			try {
				errorDialog = waiter.waitForShowing(errorDialog);
				errorDialog.clickOn(errorDialog.button().ok());
				fail("No paste errors expected. See log.");
			} catch (WidgetException expected) {
			}
			List<View> views = mComponentTarget.getViews();
			assertTrue("View must have been copied to component " + mComponentTarget, views.size() == 1);
			assertFalse("Connection must be clean ", mConnectionTarget.isDirty());
		}
		// object order must be preserved
		{
			List<Uielement> orderedChildren = mContainer1.getChildren();
			RefBaseObject[] all = orderedChildren.toArray(new RefBaseObject[orderedChildren.size()]);
			cb.setContent(all);

			DeepCopyResultSet result = cb.duplicateAndPaste(mContainer2, null);
			assertNotNull("Result must not be null", result);
			List<Uielement> copiedChildren = mContainer2.getChildren();
			for (int i = 0; i < copiedChildren.size(); i++) {
				ViewElement child = copiedChildren.get(i);
				assertEquals("Position must be preserved in children " + copiedChildren, String.valueOf(i), child
						.getName());
			}
		}
	}

	public void testCopyAssociationsPreselected() throws Exception {
		final ModelClipboard cb = new ModelClipboard();
		RefBaseObject[] all = new RefBaseObject[] { mCaptionSource };
		cb.setContent(all);

		final Association targetAssoc = getChildrenAssociation();
		assertNotNull("No association 'Children' found", targetAssoc);
		final DeepCopyResultSet[] result = new DeepCopyResultSet[1];
		AsyncWaiter waiter = mShell.asyncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				// null for connection -> extracted from newParent
				IModelTransferTarget customTarget = new TestTransferTargetWithAssociation(targetAssoc);
				result[0] = cb.duplicateAndPaste(mGroupSource, null, customTarget);
				assertNotNull("Result must not be null", result[0]);
				return null;
			}
		});
		try {
			LShell assocDialog = mShell.childShell().withName("AssociationInputDialog");
			assocDialog = waiter.waitForShowing(assocDialog);
			assocDialog.clickOn(assocDialog.button().cancel());
			fail("Selection dialog for associations must not have been raised.");
		} catch (WidgetException expected) {
		}

		assertFalse("Connection must be clean ", mConnectionTarget.isDirty());
		assertTrue("Caption must have been copied", mGroupSource.getChildren().size() == 1);
	}

	public void testCopyAssociationsDialog() throws Exception {
		final ModelClipboard cb = new ModelClipboard();
		RefBaseObject[] all = new RefBaseObject[] { mCaptionSource };
		cb.setContent(all);

		{
			AsyncWaiter waiter = mShell.asyncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					DeepCopyResultSet result = cb.duplicateAndPaste(mGroupSource, null);
					assertNull("Result must be null", result);
					return null;
				}
			});
			LShell assocDialog = mShell.childShell().withName("AssociationInputDialog");
			assocDialog = waiter.waitForShowing(assocDialog);
			// cancel
			assocDialog.clickOn(assocDialog.button().cancel());
			assocDialog.waitForClosed();
		}
		// copy again
		{
			final DeepCopyResultSet[] result = new DeepCopyResultSet[1];
			AsyncWaiter waiter = mShell.asyncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					result[0] = cb.duplicateAndPaste(mGroupSource, null);
					assertNotNull("Result must not be null", result[0]);
					return null;
				}
			});
			LShell assocDialog = mShell.childShell().withName("AssociationInputDialog");
			assocDialog = waiter.waitForShowing(assocDialog);
			LTableItem headerItem = assocDialog.tableItem().withText("Header");
			LTableItem childrenItem = assocDialog.tableItem().withText("Children");
			LTable table = assocDialog.table().withItem(headerItem).andItem(childrenItem);
			// disable multiple clicks since the dialog's closing leads to a
			// warning message (... reports not being clicked)
			mAbbotFactory.setTryMultipleClicks(false);
			table.clickOn(childrenItem);
			table.clickOn(headerItem);
			assocDialog.clickOn(assocDialog.button().ok());
			mAbbotFactory.setTryMultipleClicks(true);
			mAbbotFactory.delay(200);

			assertFalse("Connection must be clean ", mConnectionTarget.isDirty());
			Caption newHeader = mGroupSource.getHeader();
			assertNotNull("Caption must have been copied as header", newHeader);
		}
	}

	public void testCopyTransferTarget() throws Exception {
		final ModelClipboard cb = new ModelClipboard();
		RefBaseObject[] original = new RefBaseObject[] { mViewSource };
		cb.setContent(original);
		// issue cancel
		{
			TestTransferTarget.sCancel = true;
			DeepCopyResultSet result = cb.duplicateAndPaste(mComponentTarget, null);
			assertNull("Result must be null", result);
		}
		// issue custom exception
		{
			TestTransferTarget.sThrowException = true;
			DeepCopyResultSet result = cb.duplicateAndPaste(mComponentTarget, null);
			assertNull("Result must be null", result);
		}
		// issue new partition
		{
			PRI pri = getPri(getProject(), new Path(getName()));
			TestTransferTarget.sPartition = mConnectionTarget.createPartition(pri);
			DeepCopyResultSet result = cb.duplicateAndPaste(mComponentTarget, null);
			assertNotNull("Result must not be null", result);
			List<View> views = mComponentTarget.getViews();
			assertTrue("View must have been copied", views.size() > 0);
		}
	}

	public void testCopyInvalidObject() throws Exception {
		final ModelClipboard cb = new ModelClipboard();
		{
			RefBaseObject[] all = new RefBaseObject[] { mComponentSource };
			cb.setContent(all);

			try {
				cb.duplicateAndPaste(null, null);
				fail("Should not accept both connection and parent being null");
			} catch (RuntimeException expected) {
			}
		}
		{
			Association assoc = getChildrenAssociation();
			DeepCopyResultSet result = cb.duplicateAndPaste(null, mConnectionTarget,
					new TestTransferTargetWithAssociation(assoc));
			assertNull("Should not accept a custom association without a parent: " + assoc.getName(), result);

			try {
				assertNotNull(
						"Component must not be null. Was created on setup and not touched anymore. Probably Moin bug.",
						mComponentTarget);
				cb.duplicateAndPaste(mComponentTarget, mConnectionSource);
				fail("Should not accept ambiguous connections");
			} catch (RuntimeException expected) {
			}
		}
		{
			// incompatible parent and clipboard content
			final DeepCopyResultSet[] result = new DeepCopyResultSet[1];
			AsyncWaiter waiter = mShell.asyncExec(new LRunnable<Void>() {
				public Void run() throws Exception {
					result[0] = cb.duplicateAndPaste(mComponentTarget, mConnectionTarget);
					return null;
				}
			});
			LShell errorDialog = mShell.childShell().withName(ExtendedMessageDialog.class.getName());
			errorDialog = waiter.waitForShowing(errorDialog);
			errorDialog.clickOn(errorDialog.button().ok());
			assertNull("Result must be null", result[0]);

			assertFalse("Connection must be clean ", mConnectionTarget.isDirty());
		}
		{
			RefBaseObject[] all = new RefBaseObject[] { mCaptionSource };
			cb.setContent(all);

			// multiple associations but not in UI thread
			DeepCopyResultSet result = cb.duplicateAndPaste(mGroupSource, null);
			assertNull("Result must be null", result);

			assertNull("Caption must not have been copied", mGroupSource.getHeader());
			assertTrue("Caption must not have been copied", mGroupSource.getChildren().isEmpty());
			assertFalse("Connection must be clean ", mConnectionTarget.isDirty());
		}
	}

	public void testActions() throws Exception {
		// use headless transfer log to avoid UI dialogs in syncExec, which
		// would halt the test
		ModelClipboard.getDefault().setLogClass(HeadlessTestTransferLog.class);

		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				{
					TestSelectionProvider selProvider = new TestSelectionProvider();
					CopyPasteActionGroup actionGroup = new CopyPasteActionGroup(selProvider);
					CopyObjectsAction copyAction = actionGroup.getCopyAction();
					PasteObjectsAction pasteAction = actionGroup.getPasteAction();
					assertFalse("Copy action must not be enabled", copyAction.isEnabled());
					assertFalse("Paste action must not be enabled", pasteAction.isEnabled());
				}
				{
					TestSelectionProvider selProvider = new TestSelectionProvider();
					CopyPasteActionGroup actionGroup = new CopyPasteActionGroup(selProvider);
					CopyObjectsAction copyAction = actionGroup.getCopyAction();
					PasteObjectsAction pasteAction = actionGroup.getPasteAction();
					selProvider.setSelection(new StructuredSelection(new Object()));
					assertFalse("Copy action must not be enabled", copyAction.isEnabled());
					assertFalse("Paste action must not be enabled", pasteAction.isEnabled());
				}
				{
					TestSelectionProvider selProvider = new TestSelectionProvider();
					CopyPasteActionGroup actionGroup = new CopyPasteActionGroup(selProvider);
					CopyObjectsAction copyAction = actionGroup.getCopyAction();
					selProvider.setSelection(new StructuredSelection(mViewSource));
					assertTrue("Copy action must be enabled", copyAction.isEnabled());
				}
				{
					TestSelectionProvider selProvider = new TestSelectionProvider();
					CopyPasteActionGroup actionGroup = new CopyPasteActionGroup(selProvider);
					CopyObjectsAction copyAction = actionGroup.getCopyAction();
					PasteObjectsAction pasteAction = actionGroup.getPasteAction();
					selProvider.setSelection(new StructuredSelection(mViewSource));
					copyAction.run();
					assertFalse("Paste action must not be enabled", pasteAction.isEnabled());
				}
				{
					TestSelectionProvider selProvider = new TestSelectionProvider();
					CopyPasteActionGroup actionGroup = new CopyPasteActionGroup(selProvider);
					CopyObjectsAction copyAction = actionGroup.getCopyAction();
					PasteObjectsAction pasteAction = actionGroup.getPasteAction();
					selProvider.setSelection(new StructuredSelection(mViewSource));
					copyAction.run();
					selProvider.setSelection(new StructuredSelection(mComponentSource));
					assertTrue("Paste action must be enabled", pasteAction.isEnabled());
				}
				{
					TestSelectionProvider selProvider = new TestSelectionProvider();
					CopyPasteActionGroup actionGroup = new CopyPasteActionGroup(selProvider);
					CopyObjectsAction copyAction = actionGroup.getCopyAction();
					PasteObjectsAction pasteAction = actionGroup.getPasteAction();
					selProvider.setSelection(new StructuredSelection(mComponentSource));
					copyAction.run();
					selProvider.setSelection(new StructuredSelection(new ConnectionAdaptable(mConnectionTarget)));
					assertTrue(
							"Paste action must be enabled for an connection-adaptable object which is not a RefObject",
							pasteAction.isEnabled());
				}
				{
					TestSelectionProvider selProvider = new TestSelectionProvider();
					CopyPasteActionGroup actionGroup = new CopyPasteActionGroup(selProvider);
					CopyObjectsAction copyAction = actionGroup.getCopyAction();
					PasteObjectsAction pasteAction = actionGroup.getPasteAction();
					selProvider.setSelection(new StructuredSelection(mViewSource));
					copyAction.run();
					selProvider.setSelection(new StructuredSelection(mComponentSource));
					pasteAction.run();
					DeepCopyResultSet result = pasteAction.getResult();
					assertNotNull("Result must not be null", result);
					actionGroup.dispose();
					assertFalse("Actions must have been deregistered", selProvider.hasListeners());
				}
				return null;
			}
		});
	}

	public void testCopyClosedSourceConnection() {
		ModelClipboard cb = new ModelClipboard();
		RefBaseObject[] expected = new RefBaseObject[] { mComponentSource };
		cb.setContent(expected);

		// simulate close of editor with source objects
		mConnectionSource.close();

		RefBaseObject[] content = cb.getContentAsRefBaseObjects(null);
		assertTrue("Content must not be empty: " + cb, content.length > 0);
	}

	private Association getChildrenAssociation() {
		JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(mGroupSource);
		Collection<Association> assocs = jmiHelper.getCompositeAssociations((MofClass) mGroupSource.refMetaObject(),
				(MofClass) mCaptionSource.refMetaObject());
		Association targetAssoc = null;
		for (Association assoc : assocs) {
			AssociationEnd end = jmiHelper.getCompositeAssociationEnd(assoc).otherEnd();
			if ("Children".equals(end.getName())) {
				targetAssoc = assoc;
				break;
			}
		}
		return targetAssoc;
	}

	private static final class TestTransferExtender implements IModelTransferExtender<CommonDevelopmentObject> {
		public RefBaseObject[] getAdditionalObjects(CommonDevelopmentObject toExtend, RefBaseObject[] originalObjects) {
			if (toExtend instanceof View) {
				View view = (View) toExtend;
				return new RefBaseObject[] { view.getViewController() };
			} else if (toExtend instanceof Component) {
				Component comp = (Component) toExtend;
				List<ComponentUsage> usages = comp.getComponentUsages();
				Set<Component> result = new LinkedHashSet<Component>(usages.size());
				for (ComponentUsage usage : usages) {
					ComponentInterface usedComp = usage.getUsedComponent();
					if (usedComp instanceof LocalComponentInterface) {
						LocalComponentInterface local = (LocalComponentInterface) usedComp;
						Component used = local.getComponent();
						if (!used.equals(usage.getUsingComponent()))
							result.add(used);
					}
				}
				return result.toArray(new Component[result.size()]);
			}
			return new RefBaseObject[0];
		}
	}

	private static final class TestTransferTarget extends DefaultModelTransferTarget {
		static volatile Object sTargetObject = null;
		static volatile boolean sCancel = false;
		static volatile boolean sThrowException = false;
		static volatile ModelPartition sPartition;

		public Collection<ModelPartition> handleTransfer(Object target, RefBaseObject[] objectsToTransfer,
				IModelTransferLog log) throws OperationCanceledException {
			sTargetObject = target;
			if (sCancel) {
				sCancel = false;
				throw new OperationCanceledException();
			} else if (sThrowException) {
				sThrowException = false;
				throw new RuntimeException("To simulate an exception in custom transfer target");
			}

			if (target instanceof Component) {
				Component comp = (Component) target;
				for (RefBaseObject o : objectsToTransfer) {
					if (o instanceof View)
						comp.getViews().add((View) o);
					else if (o instanceof Controller)
						comp.getControllers().add((Controller) o);
					else
						throw new UnsupportedOperationException("Not able to handle " + o);
				}
			} else if (target instanceof ModelClipboardTest) {
			}
			ModelPartition part = sPartition;
			if (part != null) {
				sPartition = null;
				return Collections.singleton(part);
			}
			// by intention return null instead of empty collection
			return null;
		}
	}

	private static final class TestTransferTargetWithAssociation extends DefaultModelTransferTarget {
		private final Association mAssoc;

		public TestTransferTargetWithAssociation(Association targetAssoc) {
			mAssoc = targetAssoc;
		}

		public Collection<ModelPartition> handleTransfer(Object target, RefBaseObject[] objectsToTransfer,
				IModelTransferLog log) throws OperationCanceledException {
			ModelClipboard.addToCompositeParent((RefObject) target, objectsToTransfer, mAssoc, log);
			// by intention return null instead of empty collection
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static final class TestTransferExtensionsFactory implements IAdapterFactory {
		public Object getAdapter(Object adaptableObject, Class adapterType) {
			if (IModelTransferExtender.class == adapterType)
				return new TestTransferExtender();
			if (IModelTransferTarget.class == adapterType)
				return new TestTransferTarget();

			return null;
		}

		public Class[] getAdapterList() {
			return new Class[] { IModelTransferExtender.class, IModelTransferTarget.class };
		}
	}

	private static final class TestSelectionProvider extends EventManager implements ISelectionProvider {

		private IStructuredSelection mSelection = StructuredSelection.EMPTY;

		public ISelection getSelection() {
			return mSelection;
		}

		public void setSelection(ISelection selection) {
			mSelection = (IStructuredSelection) selection;
			SelectionChangedEvent event = new SelectionChangedEvent(this, selection);
			Object[] listeners = getListeners();
			for (Object l : listeners)
				((ISelectionChangedListener) l).selectionChanged(event);
		}

		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			addListenerObject(listener);
		}

		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			removeListenerObject(listener);
		}

		boolean hasListeners() {
			return isListenerAttached();
		}
	}

	private static final class ConnectionAdaptable implements IAdaptable {
		private final Connection mConnection;

		public ConnectionAdaptable(Connection connectionTarget) {
			mConnection = connectionTarget;
		}

		@SuppressWarnings("unchecked")
		public Object getAdapter(Class adapter) {
			if (Connection.class == adapter)
				return mConnection;
			return null;
		}
	}

	// must be package-protected as instantiated via reflection
	static final class HeadlessTestTransferLog extends TransferLog {
		@Override
		protected void flushToUi(IStatus status) {
			// redirect UI requests to normal logging
			flushToLog(status);
		}

		@Override
		protected void flushToLog(IStatus status) {
			if (status.getSeverity() == IStatus.ERROR)
				fail(status.getMessage(), status.getException());
			else
				super.flushToLog(status);
		}
	}

}