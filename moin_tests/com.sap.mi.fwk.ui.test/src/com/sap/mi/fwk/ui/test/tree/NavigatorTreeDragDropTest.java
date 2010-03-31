package com.sap.mi.fwk.ui.test.tree;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.fwk.ui.internal.dnd.DNDHelper;
import com.sap.mi.fwk.ui.internal.dnd.DefaultTreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler;
import com.sap.mi.fwk.ui.tree.dnd.TreeNodeDropListener;
import com.sap.mi.fwk.ui.tree.dnd.TreeNodeNavigatorDropAssistant;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler.TransferOperationEnum;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;

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
 * @author d022960
 */
public class NavigatorTreeDragDropTest extends ProjectBasedTest {

	private static final String DC_NAME = "test/navigatortreedragdrop";

	private Connection connection;

	public NavigatorTreeDragDropTest() {
		super(NavigatorTreeDragDropTest.DC_NAME);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		connection = createConnection();

	}

	@Override
	protected String getDcName() {
		return NavigatorTreeDragDropTest.DC_NAME;
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return true;
	}

	@Override
	protected boolean deleteProjectOnTearDown() {
		return true;
	}

	public void testValidateDropTreeNode() {
		TreeNodeNavigatorDropAssistant tnnda = new TreeNodeNavigatorDropAssistant();

		ITreeNode<?> mockNode = createMock(ITreeNode.class);
		IStructuredSelection strSel = new StructuredSelection();

		ITreeNodeTransferHandler mockTransfer = createMock(ITreeNodeTransferHandler.class);
		expect(mockNode.getAdapter(ITreeNodeTransferHandler.class)).andReturn(mockTransfer).anyTimes();
		expect(mockNode.getAdapter(Connection.class)).andReturn(connection).anyTimes();

		TransferOperationEnum operation = DNDHelper.getOperation(DND.DROP_COPY);
		DefaultTreeNodeTransfer dtnf = new DefaultTreeNodeTransfer(strSel, operation);
		setNonPublicField(tnnda, "transfer", dtnf);

		expect(mockTransfer.isTransferAllowed(mockTransfer, dtnf)).andReturn(true);

		replay(mockNode, mockTransfer);

		Object validateDropResult = runNonPublicMethod(tnnda, "validateDrop", new Class[] { IStructuredSelection.class,
				Integer.TYPE, Object.class }, new Object[] { strSel, DND.DROP_COPY, mockNode });

		assertTrue("Drop not validated", ((IStatus) validateDropResult).isOK());
	}

	public void testValidateDropRefObject() {
		TreeNodeNavigatorDropAssistant tnnda = new TreeNodeNavigatorDropAssistant();

		RefBaseObject mockRefObj = createMock(RefBaseObject.class);
		IAdaptable mockAdapter = createMock(IAdaptable.class);
		IStructuredSelection strSel = new StructuredSelection(mockRefObj);

		ITreeNodeTransferHandler mockTransfer = createMock(ITreeNodeTransferHandler.class);
		expect(mockAdapter.getAdapter(RefBaseObject.class)).andReturn(mockRefObj).anyTimes();
		expect(mockAdapter.getAdapter(RefObject.class)).andReturn(mockRefObj).anyTimes();

		replay(mockAdapter, mockRefObj, mockTransfer);

		Object validateDropResult = runNonPublicMethod(tnnda, "validateDrop", new Class[] { IStructuredSelection.class,
				Integer.TYPE, Object.class }, new Object[] { strSel, DND.DROP_COPY, mockAdapter });

		assertTrue("Drop not validated", ((IStatus) validateDropResult).isOK());
	}

	public void testHandleDropTreeNode() {
		TreeNodeNavigatorDropAssistant tnnda = new TreeNodeNavigatorDropAssistant();

		ITreeNode<?> mockNode = createMock(ITreeNode.class);
		IStructuredSelection strSel = new StructuredSelection();

		ITreeNodeTransferHandler mockTransfer = createMock(ITreeNodeTransferHandler.class);
		expect(mockNode.getAdapter(ITreeNodeTransferHandler.class)).andReturn(mockTransfer).anyTimes();
		expect(mockNode.getAdapter(Connection.class)).andReturn(connection).anyTimes();

		TransferOperationEnum operation = DNDHelper.getOperation(DND.DROP_COPY);
		DefaultTreeNodeTransfer dtnf = new DefaultTreeNodeTransfer(strSel, operation);
		setNonPublicField(tnnda, "transfer", dtnf);

		expect(mockTransfer.handleTransfer(mockTransfer, dtnf)).andReturn(true);

		replay(mockNode, mockTransfer);

		Object handleDropResult = runNonPublicMethod(tnnda, "handleDrop", new Class[] { IStructuredSelection.class,
				Integer.TYPE, Object.class }, new Object[] { strSel, DND.DROP_COPY, mockNode });

		assertTrue("Drop not validated", ((IStatus) handleDropResult).isOK());
	}

	public void testHandleDropRefObject() {
		TreeNodeNavigatorDropAssistant tnnda = new TreeNodeNavigatorDropAssistant();

		RefBaseObject mockRefObj = createMock(RefBaseObject.class);
		IAdaptable mockAdapter = createMock(IAdaptable.class);
		IStructuredSelection strSel = new StructuredSelection(mockRefObj);

		expect(mockAdapter.getAdapter(RefBaseObject.class)).andReturn(mockRefObj).anyTimes();
		expect(mockAdapter.getAdapter(RefObject.class)).andReturn(mockRefObj).anyTimes();
		expect(mockAdapter.getAdapter(ITreeNodeTransferHandler.class)).andReturn(null).anyTimes();

		replay(mockAdapter, mockRefObj);

		Object handleDropResult = runNonPublicMethod(tnnda, "handleDrop", new Class[] { IStructuredSelection.class,
				Integer.TYPE, Object.class }, new Object[] { strSel, DND.DROP_COPY, mockAdapter });

		assertTrue("Drop not validated", ((IStatus) handleDropResult).isOK());
	}

	public void testTreeNodeDropListener() throws Exception, IllegalAccessException {
		TreeNodeDropListener tndl = new TreeNodeDropListener();
		ITreeNode<?> mockNode = createNiceMock(ITreeNode.class);
		ITreeNodeTransferHandler mockHandler = createNiceMock(ITreeNodeTransferHandler.class);
		expect(mockNode.getAdapter(ITreeNodeTransferHandler.class)).andReturn(mockHandler).anyTimes();
		expect(mockNode.getAdapter(IProject.class)).andReturn(getProject()).anyTimes();

		// ensure default connection exists
		ConnectionManager.getInstance().getOrCreateDefaultConnection(getProject());

		replay(mockHandler, mockNode);

		LocalSelectionTransfer.getTransfer().setSelection(new StructuredSelection(mockNode));

		runNonPublicMethod(tndl, "drop", new Class[] { ITreeNode.class }, new Object[] { mockNode });

		runNonPublicMethod(tndl, "dragOver", new Class[] { ITreeNode.class }, new Object[] { mockNode });
	}
}

// Class<?> dndEventClass = findNonPublicClass("org.eclipse.swt.dnd.DNDEvent",
// "org.eclipse.swt");
// Object dndEvent = newNonPublicInstance(dndEventClass, new Class[] {}, new
// Object[] {});
//
// ITreeNodeTransferHandler mockNodeHandler =
// createNiceMock(ITreeNodeTransferHandler.class);
// replay(mockNodeHandler);
//
// LocalSelectionTransfer.getTransfer().setSelection(new
// StructuredSelection(mockNodeHandler));
// setNonPublicField(dndEvent, "widget", shell.getWidget());
// setNonPublicField(dndEvent, "item", mockNodeHandler);
//
// final DropTargetEvent dte = newNonPublicInstance(DropTargetEvent.class, new
// Class[] { dndEventClass }, new Object[] { dndEvent });
//
// shell.syncExec(new LRunnable<Void>() {
// public Void run() throws Exception {
// TreeNodeDropListener tndl = new TreeNodeDropListener();
// tndl.dragOver(dte);
//
// return null;
// }
// });