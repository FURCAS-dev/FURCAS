package com.sap.mi.fwk.ui.test.tree;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.mi.fwk.ui.tree.TreeNodeDecorator;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;

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
public class TreeNodeDecoratorTest extends ExtendedTestCase {

	public void testDecorateText() {
		TreeNodeDecorator tnd = new TreeNodeDecorator();
		String probe = "test";
		String text = tnd.decorateText(probe, new Object());
		assertEquals("Decorator must return same text", probe, text);
	}

	public void testDecorateImage() {
		Image image = Display.getDefault().getSystemImage(SWT.ICON_WARNING);
		TreeNodeDecorator tnd = new TreeNodeDecorator();
		ITreeNode<?> mock = createNiceMock(ITreeNode.class);

		expect(mock.getAdapter(RefObject.class)).andReturn(null).anyTimes();

		replay(mock);
		tnd.decorateImage(image, mock);

		tnd.decorateImage(image, mock);

		verify(mock);
	}

	public void testDecorate() {
		ITreeNode<?> mockNode = createNiceMock(ITreeNode.class);
		IDecoration mockDecoration = createNiceMock(IDecoration.class);
		TreeNodeDecorator tnd = new TreeNodeDecorator();

		expect(mockNode.getAdapter(RefObject.class)).andReturn(null).anyTimes();

		mockDecoration.addOverlay(ImageDescriptor.createFromImage(Display.getDefault().getSystemImage(SWT.ICON_WARNING)));

		replay(mockNode);

		tnd.decorate(mockNode, mockDecoration);

		verify(mockNode);
	}
}
