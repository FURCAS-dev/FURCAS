package com.sap.mi.fwk.ui.internal.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.MarkerManager.MarkerRefreshListener;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.InvalidSessionException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;

/**
 * An Event Adapter for the Project Explorer /Navigator. Hidden Root nodes are
 * not supported by this implementation.
 * 
 * 
 * comments: d026276 registration is done per (root) tree node in getChildren()
 * call if ( and only if ) the input is an IProject the registerListeners()
 * method is called to register. (note how on input changed the adapter is
 * reset(), = cleared , and a new adapter invoked.
 * 
 * 
 * The current adapter strategy is based on a historical model of connection
 * reuse.
 * 
 * @author d022960
 * 
 */
public final class StructuredProjectViewerEventAdapterImpl implements MarkerRefreshListener {
	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_PROJECTS);

	private final Map<EventRegistry, UpdateListener> mRegistryToUpdateListener = new HashMap<EventRegistry, UpdateListener>();
	private final Map<EventRegistry, ChangeListener> mRegistryToExternalChangeListener = new HashMap<EventRegistry, ChangeListener>();
	private final Map<CRI, Set<RootNodeItem>> mContainerToManagedRootNodes = new HashMap<CRI, Set<RootNodeItem>>();
	private final Set<CRI> mContainersToUpdate = Collections.synchronizedSet(new HashSet<CRI>());

	// remove listeners on project close
	private final IResourceChangeListener mResourceChangeListener = new ResourceChangeListener();

	// the viewer instance to refresh
	private StructuredViewer mViewer;

	/**
	 * Enables simplified eventing. - eventChain of commit event no longer
	 * analyzed. - assumes Partition Change events are fired on "other" changes.
	 * 
	 * 
	 * if changes executed within the context of a Default Connection (only)
	 * affect partitions outside this project, the project tree is still
	 * refreshed ( as it is refreshed on *any* UpdateEvent of it's connection (
	 * No analysis of the event-chain projects).
	 * 
	 * Assumes: 1) -> Trees display only content of partitions within their
	 * project 2a) -> PartitionChange Events are ignored if
	 * "TriggeredConnection" is own connection. 2b) -> otherwise they are
	 * analysed if the partition is part of our own project. => no refresh for
	 * project node is only "other projects" partitions affected. (still
	 * multiple refreshs for multiple partition changes (no harm if save
	 * executed in ui-thread, but if done from background thread potentially
	 * multiple refreshs (race condition with syncExec ).
	 * 
	 */
	static boolean SIMPLE_MODEL = true;

	/**
	 * 
	 * @param viewer
	 */
	public StructuredProjectViewerEventAdapterImpl(StructuredViewer viewer) {
		mViewer = viewer;

		// register rescource change listener here as registerListeners might be
		// called multiple times
		ResourcesPlugin.getWorkspace().addResourceChangeListener(mResourceChangeListener);
		// register marker manager
		ModelManager.getMarkerManager().addRefreshListener(this);
	}

	/**
	 * 
	 * 
	 */
	public void dispose() {
		mViewer = null;
		deregisterAllListeners();
		mContainerToManagedRootNodes.clear();
		mContainersToUpdate.clear();

		// remove project close listener
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(mResourceChangeListener);

		// remove marker listener
		ModelManager.getMarkerManager().removeRefreshListener(this);
	}

	/**
	 * Refresh is called by the markerManager
	 * 
	 */
	public void onMarkerChange(IProject affectedProject) {
		CRI container = ModelAdapterUI.getInstance().getContainer(affectedProject);
		if (container != null && !mContainersToUpdate.contains(container)) {
			TreeUpdater updater = new TreeUpdater(container, false);
			Display.getDefault().asyncExec(updater);
		}
	}

	/**
	 * Technically one <code>UpdateListener</code>, one
	 * <code>PartitionChange</code> Listener is created PER EventRegistry.
	 * 
	 * @param rootNode
	 *            The root node that is refreshed in case of a corresponding
	 *            model change.
	 */
	public void registerListeners(ITreeNode<?> rootNode) {
		if (mViewer == null) {
			throw new IllegalStateException("Event adapter has not been fully initialized - Viewer instance is null"); //$NON-NLS-1$
		}
		RootNodeItem newRootNodeItem = new RootNodeItem(rootNode, false);
		if (!containsManagedNode(newRootNodeItem)) {
			Connection conn = (Connection) rootNode.getAdapter(Connection.class);
			EventRegistry eventRegistry = conn.getSession().getEventRegistry();
			if (!mRegistryToUpdateListener.containsKey(eventRegistry)) {
				UpdateListener listener = new TreeUpdateListener(conn); // note
				// how
				// this
				// restricts
				// to
				// one
				// connection
				// per
				// session
				EventFilter eventFilter = createEventFilter();
				eventRegistry.registerUpdateListener(listener, eventFilter);
				mRegistryToUpdateListener.put(eventRegistry, listener);
			}
			if (!mRegistryToExternalChangeListener.containsKey(eventRegistry)) {
				ChangeListener listener = new TreeChangeListener(conn);
				// use PartitionContentChange event in order to allow update
				EventFilter eventFilter = new EventTypeFilter(PartitionChangeEvent.class);
				eventRegistry.registerListener(listener, eventFilter);
				mRegistryToExternalChangeListener.put(eventRegistry, listener);
			}
			addNodeToManagedRootNodes(newRootNodeItem);
		}
	}

	/**
	 * Deregisters all Moin Event listeners which have been registered via
	 * {@link #registerListeners(ITreeNode)}
	 * 
	 */
	public void deregisterAllListeners() {
		// deregister inner session listeners
		Set<Entry<EventRegistry, UpdateListener>> entries = mRegistryToUpdateListener.entrySet();
		for (Entry<EventRegistry, UpdateListener> entry : entries) {
			try {
				entry.getKey().deregister(entry.getValue());
			} catch (InvalidSessionException e) { // $JL-EXC$
			}
		}
		mRegistryToUpdateListener.clear();
		// deregister cross session listeners
		Set<Entry<EventRegistry, ChangeListener>> entries2 = mRegistryToExternalChangeListener.entrySet();
		for (Entry<EventRegistry, ChangeListener> entry : entries2) {
			try {
				entry.getKey().deregister(entry.getValue());
			} catch (InvalidSessionException e) { // $JL-EXC$
			}
		}
		mRegistryToExternalChangeListener.clear();
	}

	private void addNodeToManagedRootNodes(RootNodeItem rootNodeItem) {
		CRI container = ModelAdapterUI.getInstance().getContainer(
				(Connection) rootNodeItem.getNode().getAdapter(Connection.class));
		Set<RootNodeItem> managedNodes = mContainerToManagedRootNodes.get(container);

		// distinguish whether we add additional node to existing managed node
		// set
		if (managedNodes == null) {
			managedNodes = new HashSet<RootNodeItem>();
			managedNodes.add(rootNodeItem);
			mContainerToManagedRootNodes.put(container, managedNodes);
		} else {
			managedNodes.add(rootNodeItem);
		}
	}

	private boolean containsManagedNode(RootNodeItem rootNodeItem) {
		CRI container = ModelAdapterUI.getInstance().getContainer(
				(Connection) rootNodeItem.getNode().getAdapter(Connection.class));
		if (mContainerToManagedRootNodes.containsKey(container)) {
			Set<RootNodeItem> managedNodes = mContainerToManagedRootNodes.get(container);
			return managedNodes.contains(rootNodeItem);
		}
		return false;
	}

	/**
	 * 
	 * Consequences: No support for refactoring (cross project changes within
	 * this partition scope), eventing directly yon commit ( only on save
	 * changes visible in other connections via partition change).
	 * 
	 * @author d026276
	 * 
	 */

	private class TreeUpdateListener implements UpdateListener {
		private Connection mConnection = null;
		private final CRI mContainer;

		public TreeUpdateListener(Connection conn) {
			this.mConnection = conn;
			mContainer = ModelAdapterUI.getInstance().getContainer(conn);
		}

		public void notifyUpdate(EventChain events) {
			if (SIMPLE_MODEL) {
				if (!this.mConnection.isAlive()) {
					return;
				}
				if (!mContainersToUpdate.contains(mContainer)) {
					TreeUpdater updater = new TreeUpdater(mContainer);
					Display.getDefault().asyncExec(updater);
				}
				return;
			}
			Set<CRI> containersToUpdate = new HashSet<CRI>();
			List<ChangeEvent> eventList = events.getEvents();
			for (ChangeEvent event : eventList) {
				List<CRI> containers = getAffectedContainers(event);
				containersToUpdate.addAll(containers);
			}
			Iterator<CRI> iterator = containersToUpdate.iterator();
			while (iterator.hasNext()) {
				CRI container = iterator.next();
				if (!mContainersToUpdate.contains(container)) {
					TreeUpdater updater = new TreeUpdater(mContainer);
					Display.getDefault().asyncExec(updater);
				}
			}
		}
	}

	/**
	 * Change listener is only called for partition change events, we are not
	 * interested in events triggered by our "own" connection
	 * 
	 * @author d026276
	 * 
	 */
	private class TreeChangeListener implements ChangeListener {

		private Connection mConnection = null;
		private final CRI mContainer;

		public TreeChangeListener(Connection conn) {
			this.mConnection = conn;
			/*
			 * Store the connection's container for later use in notify(). This
			 * is done here and not in notify() due to a deadlock risk: the
			 * getContainer() call requires a ConnectionManager lock, which
			 * might be held by a different thread that is about to create a
			 * connection. This thread requires a Moin lock, which our listener
			 * thread currently holds. In general, we should try to keep
			 * listener code as light-weight as possible, since any lock
			 * expansion there might cause deadlocks.
			 */
			mContainer = ModelAdapterUI.getInstance().getContainer(mConnection);
		}

		public void notify(ChangeEvent event) {
			if (event instanceof PartitionChangeEvent) {
				PartitionChangeEvent partitionContentChangeEvent = (PartitionChangeEvent) event;
				Connection connection = partitionContentChangeEvent.getEventTriggerConnection();
				PRI pri = partitionContentChangeEvent.getAffectedPartitionPri();
				CRI affectedContainer = pri.getCri();
				if (SIMPLE_MODEL) {
					// try to prevent Refresh for alterations triggered from our
					// own connectin,
					// as these are covered by the CommitListener on our session
					if (connection.equals(this.mConnection)) {
						return; //
					}

					// this listener checks on this project and referenced
					// projects only!

					if (!mContainer.equals(affectedContainer)) {
						// check whether the affected project is a used project
						Collection<CRI> usedContainers = this.mConnection.getSession().getReferencedContainers(
								mContainer);
						for (CRI usedContainer : usedContainers) {
							if (affectedContainer.equals(usedContainer)) {
								if (!mContainersToUpdate.contains(mContainer)) {
									TreeUpdater updater = new TreeUpdater(mContainer);
									Display.getDefault().asyncExec(updater);
								}
								return;
							}
						}
					} else {
						if (!mContainersToUpdate.contains(affectedContainer)) {
							TreeUpdater updater = new TreeUpdater(affectedContainer);
							Display.getDefault().asyncExec(updater);
						}
					}
				} else if (!mContainersToUpdate.contains(affectedContainer)) {
					TreeUpdater updater = new TreeUpdater(affectedContainer);
					Display.getDefault().asyncExec(updater);
				}
			}
		}

	}

	private class TreeUpdater implements Runnable {
		CRI mContainer;
		boolean mDoRefresh;

		TreeUpdater(CRI container) {
			this(container, true);
		}

		TreeUpdater(CRI container, boolean doRefresh) {
			mContainer = container;
			mDoRefresh = doRefresh;
			StructuredProjectViewerEventAdapterImpl.this.mContainersToUpdate.add(container);
		}

		public void run() {
			sTracer.info("Updating " + mContainer.getContainerName()); //$NON-NLS-1$
			Set<RootNodeItem> rootNodes = mContainerToManagedRootNodes.get(mContainer);
			StructuredProjectViewerEventAdapterImpl.this.mContainersToUpdate.remove(mContainer);
			if (rootNodes != null) {
				for (Iterator<RootNodeItem> iter = rootNodes.iterator(); iter.hasNext();) {
					RootNodeItem rootNodeItem = iter.next();

					// if the root node is hidden, update is done on children
					// level
					ITreeNode<?> rootNode = rootNodeItem.getNode();
					if (rootNodeItem.isHidden()) {
						Object[] children = ((ITreeNode) rootNode).getChildren();
						for (int i = 0; i < children.length; i++) {
							if (mDoRefresh) {
								if (mViewer != null && !mViewer.getControl().isDisposed()) {
									mViewer.refresh(children[i]);
								}
							} else {
								// TODO mViewer.update on all visible nodes
								// would be sufficient
								if (mViewer != null && !mViewer.getControl().isDisposed()) {
									mViewer.refresh(children[i]);
								}
							}
						}
					} else {
						if (mDoRefresh) {
							if (mViewer != null && !mViewer.getControl().isDisposed()) {
								mViewer.refresh(rootNode);
							}
						} else {
							// TODO mViewer.update on all visible nodes would be
							// sufficient
							if (mViewer != null && !mViewer.getControl().isDisposed()) {
								mViewer.refresh(rootNode);
							}
						}
					}
				}
			}
		}
	}

	private class ResourceChangeListener implements IResourceChangeListener {
		public void resourceChanged(IResourceChangeEvent event) {
			IResource resource = event.getResource();

			// remove all listeners registered for this project
			if (resource instanceof IProject
					&& (event.getType() == IResourceChangeEvent.PRE_CLOSE || event.getType() == IResourceChangeEvent.PRE_DELETE)) {
				CRI container = ModelAdapterUI.getInstance().getContainer((IProject) resource);
				if (container != null && mContainerToManagedRootNodes.containsKey(container)) {
					Set<RootNodeItem> rootNodes = mContainerToManagedRootNodes.remove(container);
					if (rootNodes != null) {
						for (Iterator<RootNodeItem> iter = rootNodes.iterator(); iter.hasNext();) {
							RootNodeItem managedNodeItem = iter.next();
							Connection connection = (Connection) managedNodeItem.getNode().getAdapter(Connection.class);
							if (connection != null && connection.isAlive()) {
								EventRegistry registry = connection.getSession().getEventRegistry();
								// remove registry from internal hash as well as
								// corresponding commit listener from registry

								UpdateListener updateListener = mRegistryToUpdateListener.remove(registry);
								if (updateListener != null) {
									registry.deregister(updateListener);
								}

								// remove registry from internal hash as well as
								// corresponding external change listener from
								// registry
								ChangeListener changeListener = mRegistryToExternalChangeListener.remove(registry);
								if (changeListener != null) {
									registry.deregister(changeListener);
								}
								// remove project from internal collections
								mContainerToManagedRootNodes.remove(container);
								mContainersToUpdate.remove(container);
							}
						}
					}
				}
			}

		}
	}

	/**
	 * A <class>RootNodeItem</class> encapsulates the corresponding
	 * <class>TreeNode</class> instance and the information whether this node is
	 * visible in the tree or not. If the node is not visible the refresh is
	 * either performed for the entire <class>TreeViewer</class> or on the
	 * corresponding child nodes in case the node is a
	 * <class>ITreeNodeChildAware</class>. TODO LB: Check whether we really have
	 * to support hidden root nodes
	 */
	private class RootNodeItem {
		private final ITreeNode<?> mNode;
		private final boolean mHidden;

		RootNodeItem(ITreeNode<?> node, boolean hidden) {
			mNode = node;
			mHidden = hidden;
		}

		ITreeNode<?> getNode() {
			return mNode;
		}

		boolean isHidden() {
			return mHidden;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}

			if (obj instanceof RootNodeItem) {
				return mNode.equals(((RootNodeItem) obj).getNode());
			}
			return mNode.equals(obj);
		}

		@Override
		public int hashCode() {
			return mNode.hashCode();
		}
	}

	private List<CRI> getAffectedContainers(ChangeEvent event) {

		List<CRI> affectedContainers = new ArrayList<CRI>();
		Connection connection = event.getEventTriggerConnection();
		if (event instanceof ElementChangeEvent) {
			ElementChangeEvent elementChangeEvent = (ElementChangeEvent) event;
			addAffectedContainer(affectedContainers, connection, elementChangeEvent.getAffectedElementMri());
		} else if (event instanceof LinkChangeEvent) {
			LinkChangeEvent linkChangeEvent = (LinkChangeEvent) event;
			addAffectedContainer(affectedContainers, connection, linkChangeEvent.getStoredLinkEndMri());
			addAffectedContainer(affectedContainers, connection, linkChangeEvent.getStoredLinkEndMri());
		} else if (event instanceof PartitionMembershipChangeEvent) {
			PartitionMembershipChangeEvent partitionMembershipChangeEvent = (PartitionMembershipChangeEvent) event;
			addAffectedContainer(affectedContainers, connection, partitionMembershipChangeEvent
					.getAffectedElementNewMri());
			addAffectedContainer(affectedContainers, connection, partitionMembershipChangeEvent
					.getAffectedElementOldMri());
		}
		return affectedContainers;
	}

	private void addAffectedContainer(List<CRI> affectedContainers, Connection connection, MRI affectedElementMri) {
		if (affectedElementMri == null) {
			return;
		}
		CRI affectedContainer = affectedElementMri.getCri();
		affectedContainers.add(affectedContainer);
	}

	private EventFilter createEventFilter() {

		EventFilter eventFilter = new EventTypeFilter(ModelChangeEvent.class); // equivalent
		// to
		// :
		// EventFilter eventFilter = new OrFilter(new EventTypeFilter(
		// ElementChangeEvent.class), new EventTypeFilter(
		// LinkChangeEvent.class), new EventTypeFilter(
		// PartitionMembershipChangeEvent.class));
		return eventFilter;
	}

	/**
	 * @return the viewer
	 */
	public StructuredViewer getViewer() {
		return mViewer;
	}
}
