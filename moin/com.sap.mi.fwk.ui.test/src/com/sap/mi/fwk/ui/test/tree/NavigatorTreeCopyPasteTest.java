package com.sap.mi.fwk.ui.test.tree;

import java.util.HashMap;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISources;

import com.sap.demo.components.SimpleComponent;
import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.ui.lift.WidgetException;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.dnd.ModelClipboard;
import com.sap.mi.fwk.ui.handler.CopyHandler;
import com.sap.mi.fwk.ui.handler.PasteHandler;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeCopyHandler;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;

/**
 * Test for StructuredViewer based event adapters. This test class contains
 * tests that ensure that a viewer refresh is triggered in different model
 * change scenarios.
 * 
 * TODO: Currently the test testProjectEventAdapterUsingDifferentDC is based on
 * corresponding projects in the workspace, we should also check whether the
 * refresh happens if the used DC is only available as archive (build of used DC
 * and project close required in this scenario)
 * 
 * @author d024127
 */
public class NavigatorTreeCopyPasteTest extends ProjectBasedTest {

	private static final String DC_NAME = "test/navigatortreecopypaste";

	private Connection connection;
	private LFactory factory = null;
	private LShell shell = null;
	private ModelPartition partition;
	private Display display;

	public NavigatorTreeCopyPasteTest() {
		super(DC_NAME);
	}

	protected void setUp() throws Exception {
		// delete used project here as well to be symmetric
		// with other/using project
		deleteUsedProject();
		super.setUp();

		connection = createConnection();
		PRI pri = ModelManager.getPartitionService().getPRI(getProject(),
				new Path("src/com/sap/test/used/Component.xmi"));
		partition = connection.getPartition(pri);
		if (partition != null)
			partition.delete();
		partition = connection.createPartition(pri);
		connection.save();

		assertNotNull("Partition file is null", ModelAdapterUI.getInstance().getFile(partition.getPri()));
		assertTrue("Partition file does not exist", ModelAdapterUI.getInstance().getFile(partition.getPri())
				.isAccessible());

		factory = FactoryBuilder.newAbbotFactory();

		// wait 3 sec for editor startup
		factory.setWaitTimeout(3000);
		display = Display.getDefault();
		shell = factory.getShell(display);

		PDEUtil.closeWelcomePage();
		PDEUtil.prepareWorkbench();
		PDEUtil.maximizeWorkbenchAndRequestFocus();
		PDEUtil.assertDisplayIsActiveWindow();

		// disable OCL Constraint Checker
		PDEUtil.setAutoBuilding(false);
	}

	@SuppressWarnings("unchecked")
	public void testCopyGeneric() {

		SimpleComponent sc = createComponent(connection, "simple component");

		ISelection sel = new StructuredSelection(sc);
		IEvaluationContext context = new EvaluationContext(null, sel);
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, sel);
		final ExecutionEvent event = new ExecutionEvent(null, new HashMap(), this, context);

		final CopyHandler copyHandler = new CopyHandler();
		LRunnable<MRI[]> runnable = new LRunnable<MRI[]>() {
			public MRI[] run() throws Exception {
				copyHandler.execute(event);
				ModelClipboard cp = ModelClipboard.getDefault();
				return cp.getContent();
			}
		};

		MRI[] content = null;
		try {
			content = shell.syncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		assertEquals("Only copied element in clipboard", 1, content.length);
		assertEquals("Wrong object in clipboard", ((Partitionable) sc).get___Mri(), content[0]);
	}

	@SuppressWarnings("unchecked")
	public void testCopyTreeNode() {

		SimpleComponent sc = createComponent(connection, "simple component");
		TestTreeNode ttn = new TestTreeNode(sc);

		ISelection sel = new StructuredSelection(ttn);
		IEvaluationContext context = new EvaluationContext(null, sel);
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, sel);
		final ExecutionEvent event = new ExecutionEvent(null, new HashMap(), this, context);

		final CopyHandler copyHandler = new CopyHandler();
		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				copyHandler.execute(event);
				return null;
			}
		};

		try {
			shell.syncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		assertEquals("Transfer source does not match real source ", ttn, ttn.object);
		assertEquals("Transfer selection does not match real selection ", sel, ttn.transfer.getSelection());
	}

	public void testIsEnabledTreeNode() {

		SimpleComponent sc = createComponent(connection, "simple component");
		TestTreeNode ttn = new TestTreeNode(sc);

		final ISelection sel = new StructuredSelection(ttn);
		final PasteHandler pasteHandler = new PasteHandler();

		LRunnable<Boolean> runnable = new LRunnable<Boolean>() {
			public Boolean run() throws Exception {
				Object isEnabled = runNonPublicMethod(pasteHandler, "isEnabled",
						new Class[] { IStructuredSelection.class }, new Object[] { sel });
				return (Boolean) isEnabled;
			}
		};

		try {
			Boolean isEnabled = shell.syncExec(runnable);
			assertTrue(isEnabled);
		} catch (WidgetException e) {
			fail(e);
		}
	}

	public void testIsEnabledGeneric() {

		SimpleComponent sc = createComponent(connection, "simple component");

		final ISelection sel = new StructuredSelection(sc);
		IEvaluationContext context = new EvaluationContext(null, sel);
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, sel);
		// final ExecutionEvent event = new ExecutionEvent(null, new HashMap(),
		// this, context);
		final PasteHandler pasteHandler = new PasteHandler();

		LRunnable<Boolean> runnable = new LRunnable<Boolean>() {
			public Boolean run() throws Exception {
				Object isEnabled = runNonPublicMethod(pasteHandler, "isEnabled",
						new Class[] { IStructuredSelection.class }, new Object[] { sel });
				return (Boolean) isEnabled;
			}
		};

		try {
			ModelClipboard.getDefault().clear();
			Boolean isEnabled = shell.syncExec(runnable);
			assertFalse(isEnabled);
		} catch (WidgetException e) {
			fail(e);
		}
	}

	@SuppressWarnings("unchecked")
	public void testPasteTreeNode() {

		SimpleComponent sc = createComponent(connection, "simple component");
		TestTreeNode ttn = new TestTreeNode(sc);

		ISelection sel = new StructuredSelection(ttn);
		IEvaluationContext context = new EvaluationContext(null, sel);
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, sel);
		final ExecutionEvent event = new ExecutionEvent(null, new HashMap(), this, context);
		final PasteHandler pasteHandler = new PasteHandler();

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				pasteHandler.execute(event);
				return null;
			}
		};

		try {
			shell.syncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		assertEquals("Transfer source does not match real source ", ttn, ttn.object);
		assertEquals("Transfer selection does not match real selection ", sel, ttn.transfer.getSelection());
	}

	@SuppressWarnings("unchecked")
	public void testPasteGeneric() {

		SimpleComponent sc = createComponent(connection, "simple component");

		ISelection sel = new StructuredSelection(sc);
		IEvaluationContext context = new EvaluationContext(null, sel);
		context.addVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME, sel);
		final ExecutionEvent event = new ExecutionEvent(null, new HashMap(), this, context);
		final PasteHandler pasteHandler = new PasteHandler();

		LRunnable<Void> runnable = new LRunnable<Void>() {
			public Void run() throws Exception {
				pasteHandler.execute(event);
				return null;
			}
		};

		try {
			shell.syncExec(runnable);
		} catch (WidgetException e) {
			fail(e);
		}

		// must not fail :-)
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
	protected void tearDown() throws Exception {
		if (connection != null && connection.isAlive()) {
			connection.close();
		}
		super.tearDown();
	}

	@Override
	public void dispose() throws Exception {
		super.dispose();
		// delete used project here as we try to be symmetric
		// with other/using project
		deleteUsedProject();
	}

	private SimpleComponent createComponent(Connection connection, String name) {
		SimpleComponent component = partition.createElement(SimpleComponent.CLASS_DESCRIPTOR);
		component.setName(name);
		return component;
	}

	private void deleteUsedProject() {
		IProject usedProject = TestUtil.getLocalMoinDCProject(DC_NAME);
		if (usedProject != null)
			TestUtil.deleteLocalMoinDCProject(usedProject);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	private static final class TestTreeNode extends TreeNodeRefObject<SimpleComponent> implements ITreeNodeCopyHandler,
			ITreeNodeTransferHandler {

		public TestTreeNode(SimpleComponent modelElement) {
			super(modelElement);
		}

		ITreeNodeTransfer transfer;
		Object object;

		public boolean handleCopy(Object source, ITreeNodeTransfer transfer) {
			this.object = source;
			this.transfer = transfer;
			return true;
		}

		public Object[] getChildren() {
			return null;
		}

		public boolean hasChildren() {
			return false;
		}

		public boolean handleTransfer(Object target, ITreeNodeTransfer transfer) {
			this.object = target;
			this.transfer = transfer;
			return true;
		}

		public boolean isTransferAllowed(Object target, ITreeNodeTransfer transfer) {
			this.object = target;
			this.transfer = transfer;
			return true;
		}
	}
}