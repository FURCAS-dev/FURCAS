package com.sap.mi.fwk.ui.tree.provider;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;

import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.tree.StructuredViewerEventAdapterImpl;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;

/**
 * Content provider implementation for editor tree implementations. Methods
 * {@link #getChildren(Object)} and {@link #hasChildren(Object)} delegate to
 * <code>ITreeNode</code> if such an instance is passed in.
 * 
 * @author d024127
 * @author d022960
 */
public class TreeNodeContentProvider extends TreeNodeContentProviderBase {

	/**
	 * The event adapter that listens on model changes, updates are performed
	 * for the entire tree. The root node has to be passed using method
	 * {@link #registerListeners(ITreeNode)}.
	 * <p>
	 * May be null in case the content provider is used in head-less test
	 * scenarios.
	 */
	private StructuredViewerEventAdapterImpl mAdapter = null;

	/**
	 * Notifies this content provider that the given viewer's input has been
	 * switched to a different element. This will deregister all event
	 * listeners.
	 * 
	 * @param viewer
	 *            the tree viewer
	 * @param oldInput
	 *            {@inheritDoc}
	 * @param newInput
	 *            {@inheritDoc}
	 */
	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		Assert.isLegal(viewer != null, "The viewer must not be null - this method must not be called in headless mode"); //$NON-NLS-1$
		if (newInput != null) {
			if (this.mAdapter == null) {
				this.mAdapter = new StructuredViewerEventAdapterImpl((StructuredViewer) viewer);
			}
		}

		// when tree is disposed, this method is called with newInput = null
		if (this.mAdapter != null) {
			this.mAdapter.deregisterAllListeners();
			RefBaseObject refBaseObject = ModelAdapterUI.getInstance().getRefBaseObject(newInput);
			if (refBaseObject != null) {
				this.mAdapter.registerListeners(refBaseObject);
			}
		}
	}

	/**
	 * Register model change listeners for the given tree node. The scope for
	 * events of type <code>ModelChangeEvent</code> is defined by the
	 * <code>Connection</code> retrieved from the given node.
	 * 
	 * @param rootNode
	 *            the tree node to refresh
	 */
	protected final void registerListeners(final ITreeNode<?> rootNode) {
		Assert.isLegal(rootNode != null, "The passed root node must not be null"); //$NON-NLS-1$
		if (this.mAdapter != null) {
			final Object value = rootNode.getValue();
			if (value instanceof RefBaseObject) {
				this.mAdapter.registerListeners((RefBaseObject) value);
			}
		}
	}

	public void dispose() {
		if (this.mAdapter != null) {
			this.mAdapter.dispose();
			this.mAdapter = null;
		}
	}

	/**
	 * Returns the current viewer, or <code>null</code> if no viewer is
	 * associated.
	 * 
	 * @return The current viewer, or <code>null</code> if no viewer is
	 *         associated.
	 */
	public StructuredViewer getViewer() {
		if (this.mAdapter != null) {
			return this.mAdapter.getViewer();
		}
		return null;
	}
}