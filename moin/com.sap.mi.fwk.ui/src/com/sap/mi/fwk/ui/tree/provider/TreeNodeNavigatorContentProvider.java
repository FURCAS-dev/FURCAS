package com.sap.mi.fwk.ui.tree.provider;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.internal.tree.StructuredProjectViewerEventAdapterImpl;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeDomainRoot;
import com.sap.tc.moin.repository.Connection;

/**
 * Content provider implementation for project explorer tree implementations. It
 * supports optimized event handling and deferred connection initialization. The
 * corresponding label provider implementation should inherit from
 * {@link TreeNodeLabelProvider} in order to get the standard hourclass image
 * and corresponding text.
 * <p>
 * Methods delegate to <code>ITreeNode</code> if such an instance is passed in.
 * <p>
 * NOTE:<br>
 * Do not provide children for nodes from other navigator content providers.
 * <li>Tree nodes may implement domain specific tag interface which is defined
 * for triggerPoints and possibleChildren extension element within
 * navigatorContent extension point
 * <li>Content provider checks whether the passed parent node belongs to this
 * content provider:
 * <code>if(parentElement.getClass().getPackage().equals(PACKAGE_OWN_EXPLORER)) {</code>
 * 
 * @author d024127
 * @author d022960
 * 
 */
public class TreeNodeNavigatorContentProvider extends TreeNodeContentProviderBase {

	/**
	 * The event adapter that listens on model changes, updates are performed on
	 * root node level. The root node is either passed using
	 * {@link #initializeConnectionDeferred(TreeNodeDomainRoot)} for
	 * asynchronous connection initialization or with
	 * {@link #registerListeners(ITreeNode)} in case the connection has already
	 * been created.
	 * <p>
	 * May be null in case the content provider is used in head-less test
	 * scenarios.
	 */
	private StructuredProjectViewerEventAdapterImpl mAdapter = null;

	/**
	 * Registers model change listeners for the given root node. The scope for
	 * events of type <code>ModelChangeEvent</code> is defined by the <code>
	 * Connection</code>
	 * retrieved from the given node. A tree refresh is performed on root node
	 * granularity.
	 * 
	 * @param rootNode
	 *            The root node to refresh in case of any model changes
	 */
	protected final void registerListeners(final ITreeNode<?> rootNode) {
		Assert.isLegal(rootNode != null, "The passed root node must not be null"); //$NON-NLS-1$
		if (this.mAdapter != null) {
			this.mAdapter.registerListeners(rootNode);
		}
	}

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
				this.mAdapter = new StructuredProjectViewerEventAdapterImpl((StructuredViewer) viewer);
			}
		}
		if (this.mAdapter != null) {
			// no listener registration because MOIN is not initialized
			// registration done in deferred handler
			this.mAdapter.deregisterAllListeners();
		}
	}

	public void dispose() {
		if (this.mAdapter != null) {
			this.mAdapter.dispose();
			this.mAdapter = null;
		}
	}

	/**
	 * Initializes the default connection asynchronous. In case the connection
	 * could be retrieved immediately - meaning Moin has already been
	 * initialized - <code>true</code> is returned. <code>false</code> is
	 * returned in case a job for initialization has been scheduled.
	 * 
	 * @param rootNode
	 *            the
	 * @return <code>true</code> in case initialization is finished, <code>false
	 *         </code>
	 *         in case a job has been scheduled for deferred connection
	 *         initialization.
	 */
	protected final boolean initializeConnectionDeferred(final TreeNodeDomainRoot rootNode) {
		final IRunnableWithConnection runnable = new IRunnableWithConnection() {
			public void run(final Connection connection, final IProgressMonitor monitor) {
				// the event adapter may be null in case of headless test
				// scenarios
				registerListeners(rootNode);
				final StructuredViewer viewer = getViewer();
				if (viewer != null) {
					if (!viewer.getControl().isDisposed()) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								if (!viewer.getControl().isDisposed()) {
									viewer.refresh(rootNode);
								}
							}
						});
					}
				}
			}
		};

		final Connection connection = ConnectionManagerUI.getInstance().getOrCreateDefaultConnectionAsync(rootNode.getValue(), runnable);
		// if the connection has already been initialized the runnable is
		// not
		// executed. In this case we have to register the listeners here.
		if (connection != null) {
			registerListeners(rootNode);
			return true;
		}
		return false;
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