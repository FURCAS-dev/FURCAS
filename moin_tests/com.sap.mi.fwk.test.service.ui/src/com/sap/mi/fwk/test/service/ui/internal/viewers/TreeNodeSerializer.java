package com.sap.mi.fwk.test.service.ui.internal.viewers;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.test.service.viewers.IStructuredContentVisitor;
import com.sap.mi.fwk.test.service.viewers.VisitorFactory;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

/**
 * This implementation of {@link IStructuredContentVisitor} visits all children
 * for the given input element and creates a corresponding textual
 * representation. The given <code>IContentProvider</code> and
 * <code>ILabelProvider</code> instance is used for the tree content traversal.
 * <p>
 * The implementation checks for recursions - predecessors of recursive nodes
 * will be added.
 * 
 * @author d022960
 * 
 */
public class TreeNodeSerializer implements IStructuredContentVisitor {

	/**
	 * Maximum indent level - for optimization purposes. There is no restriction
	 * regarding the nesting level.
	 */
	private static int MAX_INDENT = 20;

	private int depth = 1;
	private int indentLevel = 0;
	private StringBuilder buffer;
	private ITreeContentProvider contentProvider;
	private ILabelProvider labelProvider;
	private int serializeDetails;

	/**
	 * Construction
	 * 
	 * @param contentProvider
	 *            the content provider used for retrieving the children of the
	 *            given input element.
	 * @param labelProvider
	 *            the label provider used for retrieving the text and image
	 *            information for a given node.
	 * @param serializeOptions
	 *            defines whether the class and / or label textual information
	 *            should be added
	 * @param depth
	 *            defines the maximum nesting level for the tree traversal or
	 *            <code>VisitorFactory.ALL_LEVELS</code> in case all children
	 *            should be traversed.
	 */
	public TreeNodeSerializer(ITreeContentProvider contentProvider, ILabelProvider labelProvider, int serializeOptions,
			int depth) {
		Assert.isLegal(contentProvider != null, "The content provider must not be null");
		Assert
				.isLegal(
						(labelProvider == null && (serializeOptions == VisitorFactory.SERIALIZE_CLASS_NAMES_AND_LABELS || serializeOptions == VisitorFactory.SERIALIZE_LABELS))
								|| labelProvider != null,
						"The label provider must not be null in case the serializeDetails value is either 'SERIALIZE_CLASS_NAMES_AND_LABELS' or 'SERIALIZE_LABELS'");
		this.depth = (depth == VisitorFactory.ALL_LEVELS) ? Integer.MAX_VALUE : depth;
		this.indentLevel = 0;
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
		this.serializeDetails = serializeOptions;
		this.buffer = new StringBuilder();
	}

	/**
	 * This implementation creates a textual implementation of the entire tree
	 * content.
	 * <p>
	 * {@inheritDoc}
	 */
	public void visit(Object inputElement) {
		Assert.isLegal(inputElement != null, "inputElement must not be null");

		// start from scratch
		setIndentLevel(0);
		Object[] elements = getContentProvider().getElements(inputElement);
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] instanceof ITreeNode) {
				doVisit((ITreeNode<?>) elements[i]);
			} else {
				appendIndent();
				getBuffer().append("Not supported tree element type: ");
				getBuffer().append(elements[i].getClass().getName());
				getBuffer().append('\n');
			}
			setIndentLevel(getIndentLevel() + 1);
			try {
				doVisitChildren(elements[i]);
			} finally {
				setIndentLevel(getIndentLevel() - 1);
			}
		}
	}

	/**
	 * Returns the serialized tree content. The return type is a copy of the
	 * internal <code>StringBuffer</code>.
	 */
	public Object getResult() {
		return new StringBuffer(getBuffer());
	}

	/**
	 * Returns the serialized tree content as <code>String</code>.
	 */
	public String getResultAsString() {
		return getBuffer().toString();
	}

	private void serializeNodeClass(ITreeNode<?> treeNode) {
		if (treeNode instanceof ITreeNodeRefObject) {
			getBuffer().append("[TreeNodeRefObject class] ");
		} else {
			getBuffer().append("[TreeNode class] ");
		}
		getBuffer().append(treeNode.getClass().getName());
	}

	private void serializeValueClass(Object value) {
		getBuffer().append(" [Value class] ");
		if (value != null) {
			if (value instanceof RefBaseObject) {
				RefBaseObject entity = (RefBaseObject) value;
				Class<RefBaseObject> jmiClass = ModelAdapter.getInstance().getJmiInterface(entity);
				if (jmiClass != null) {
					getBuffer().append(jmiClass.getName());
				} else {
					getBuffer().append("null");
				}
			} else {
				getBuffer().append(value.getClass().getName());
			}
		} else {
			getBuffer().append("null");
		}
	}

	private void serializeLabel(ITreeNode<?> treeNode) {
		getBuffer().append(" [Image ");
		Image image = getLabelProvider().getImage(treeNode);
		getBuffer().append(image != null ? "+]" : "-]");
		getBuffer().append(" [Text] ");
		getBuffer().append(getLabelProvider().getText(treeNode));
	}

	/**
	 * The method retrieves the children for the given parent element in case
	 * depth does not exceed the defined limit - defined by
	 * {@link #TreeNodeSerializer(ITreeContentProvider, ILabelProvider, int, int)}
	 * . In case of recursion further traversing is stopped.
	 * 
	 * @param parent
	 *            the parent for which the children will be visited
	 */
	protected void doVisitChildren(Object parent) {
		if (getIndentLevel() < getDepth()) {
			// this increases the test coverage and ensures a correct contract
			// of hasChildren(parent) and getChildren(parent)
			if (getContentProvider().hasChildren(parent)) {
				Object[] children = getContentProvider().getChildren(parent);
				for (int i = 0; i < children.length; i++) {
					if (children[i].getClass().getName().equals("com.sap.mi.fwk.ui.internal.tree.HourglassTreeNode")) {
						delay(5000);
						doVisitChildren(parent);
						return;
					}
					if (children[i] instanceof ITreeNode) {
						// check for recursion
						if (!isRecursive((ITreeNode<?>) children[i])) {
							doVisit(((ITreeNode<?>) children[i]));
						} else {
							// do not visit children
							continue;
						}
					} else {
						appendIndent();
						getBuffer().append("Not supported tree element type: ");
						getBuffer().append(children[i].getClass().getName());
						getBuffer().append('\n');
					}
					setIndentLevel(getIndentLevel() + 1);
					try {
						doVisitChildren(children[i]);
					} finally {
						setIndentLevel(getIndentLevel() - 1);
					}
				}
			}
		}
	}
	
	public static void delay(int ms){
		final Display display = Display.getCurrent(); 
		if (display == null) {
			// Not in UI thread, so just wait. 
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
			}
			return;
		}
		final boolean[] continueWait = new boolean[] { true };
		display.timerExec(ms, new Runnable() {
			public void run() {
				continueWait[0] = false;
				// Makes sure we wake up and see the flag has been turned off. 
				display.asyncExec(null);
			}
		});
		while (continueWait[0]) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Visits the corresponding node and stores a textual representation. It
	 * does not visit its children.
	 * 
	 * @param treeNode
	 *            the node to visit
	 */
	protected void doVisit(ITreeNode<?> treeNode) {
		appendIndent();

		if (serializeDetails == VisitorFactory.SERIALIZE_CLASS_NAMES
				|| serializeDetails == VisitorFactory.SERIALIZE_CLASS_NAMES_AND_LABELS) {
			serializeNodeClass(treeNode);
			serializeValueClass(treeNode.getValue());
		}
		if (serializeDetails == VisitorFactory.SERIALIZE_LABELS
				|| serializeDetails == VisitorFactory.SERIALIZE_CLASS_NAMES_AND_LABELS) {
			serializeLabel(treeNode);
		}
		getBuffer().append("\n");

	}

	/**
	 * Append a string with level space
	 * 
	 * @param level
	 */
	protected void appendIndent() {
		if (getIndentLevel() >= 0) {
			if (getIndentLevel() <= MAX_INDENT) {
				getBuffer().append(sIndent[getIndentLevel()]);
				return;
			} else {
				getBuffer().append(getIndentLevel());
				for (int i = 0; i <= getIndentLevel(); i++) {
					getBuffer().append(' ');
				}
			}
		}
	}

	/**
	 * Sets the maximum level for the tree traversal.
	 * 
	 * @param depth
	 *            the maximum nesting level for the traversal.
	 *            <code>VisitorFactory.ALL_LEVELS</code> means traversing all
	 *            child nodes in case there is no recursion - otherwise last
	 *            element before recursion.
	 */
	protected final void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * Returns the maximum level for the tree traversal.
	 * 
	 * @return the maximum depth level
	 */
	protected final int getDepth() {
		return depth;
	}

	/**
	 * Sets the current indent level of the tree traversal.
	 * 
	 * @param indentLevel
	 *            the ident level - must not exceed <code>MAX_INDENT</code>.
	 */
	protected final void setIndentLevel(int indentLevel) {
		this.indentLevel = indentLevel;
	}

	/**
	 * Returns the current indent level.
	 * 
	 * @return the current indent level.
	 */
	protected final int getIndentLevel() {
		return indentLevel;
	}

	/**
	 * Returns the internal buffer
	 * 
	 * @return the internal <code>StringBuilder</code>instance - not
	 *         synchronized.
	 */
	protected final StringBuilder getBuffer() {
		return buffer;
	}

	protected final ITreeContentProvider getContentProvider() {
		return contentProvider;
	}

	protected final ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	private boolean isRecursive(ITreeNode<?> treeNode) {
		ITreeNode<?> current = treeNode;
		Object parent = treeNode.getParent();

		while (parent != null) {
			if (!treeNode.equals(parent)) {
				if (parent instanceof ITreeNode) {
					current = (ITreeNode<?>) parent;
					parent = current.getParent();
				} else {
					// root reached
					parent = null;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * Optimization for indenting.
	 */
	private static final String[] sIndent = new String[] { "0 ", "1  ", "2   ", "3    ", "4     ", "5      ",
			"6       ", "7        ", "8         ", "9          ", "10           ", "11            ", "12             ",
			"13              ", "14               ", "15                ", "16                 ",
			"17                  ", "18                   ", "19                    ", "20                     " };
}
