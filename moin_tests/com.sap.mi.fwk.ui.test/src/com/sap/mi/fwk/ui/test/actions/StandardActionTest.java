package com.sap.mi.fwk.ui.test.actions;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.replay;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.SubActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.ICommonActionConstants;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.Button;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.TransparentContainer;
import com.sap.ide.metamodel.webdynpro.component.view.uielement.UielementPackage;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.actions.OpenEditorActionProvider;
import com.sap.mi.fwk.ui.actions.OpenWithEditorActionProvider;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

public class StandardActionTest extends WebDynproProjectTest {

	/**
	 * @param name
	 */
	public StandardActionTest(String name) {
		super(name);
	}

	private static final String DC_NAME = StandardActionTest.class.getName();

	private Display display;
	private LShell mShell;
	private LFactory mAbbotFactory;
	private Connection connection;
	private Component component;

	private View mView;

	private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/action");

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);
		display = Display.getDefault();
		mShell = mAbbotFactory.getShell(display);

		PDEUtil.prepareWorkbench();

		connection = createConnection();

		PRI pri = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);
		assertNotNull("Partition creation failed", partition);

		ComponentPackage compPackage = (ComponentPackage) connection.getPackage("sap.com/tc/moin/webdynpro/webdynpro", new String[] {
				"WebDynpro", "component" });
		component = (Component) compPackage.getComponent().refCreateInstance();
		component.setName("testComponent");
		partition.assignElement((Partitionable) component);

		// two Views
		RefClass viewClass = compPackage.getView().getView();
		mView = (View) viewClass.refCreateInstance();
		component.getViews().add(mView);
		mView.setName("testView");
		UielementPackage uielementPackage = compPackage.getView().getUielement();
		TransparentContainer container = (TransparentContainer) uielementPackage.getTransparentContainer().refCreateInstance();
		mView.setRootUielementContainer(container);
		Button button = (Button) uielementPackage.getButton().refCreateInstance();
		container.getChildren().add(button);

		ModelManager.getConnectionManager().save(connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.fwk.test.service.ProjectBasedTest#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		mShell.syncExec(new LRunnable<Void>() {
			public Void run() throws Exception {
				ModelEditorManager.getInstance().closeModelEditors(mView, false);
				return null;
			}
		});
		super.tearDown();
	}

	public void testOpenEditorActionProvider() {

		ISelection sel = new StructuredSelection(mView);
		ActionContext ac = new ActionContext(sel);

		final OpenEditorActionProvider oeap = new OpenEditorActionProvider();

		final IActionBars ab = createNiceMock(IActionBars.class);
		final IActionBars ab2 = new SubActionBars(ab);
		
		final IMenuManager mm = createNiceMock(IMenuManager.class);

		replay(ab);
		oeap.setContext(ac);
		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				oeap.fillActionBars(ab2);
				oeap.fillContextMenu(mm);
				ab2.getGlobalActionHandler(ICommonActionConstants.OPEN).run();
				return null;
			}
		};

		try {
			mShell.syncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		Collection<IEditorPart> editors = ModelEditorManager.getInstance().findEditorParts(mView);
		assertEquals("Editor not open", 1, editors.size());
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

	public void testOpenWithEditorActionProvider() {

		ISelection sel = new StructuredSelection(mView);
		ActionContext ac = new ActionContext(sel);
		final IMenuManager mm = createNiceMock(IMenuManager.class);

		final OpenWithEditorActionProvider oeap = new OpenWithEditorActionProvider();

		oeap.setContext(ac);
		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				oeap.fillContextMenu(mm);
				return null;
			}
		};

		try {
			mShell.syncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}
	}
}