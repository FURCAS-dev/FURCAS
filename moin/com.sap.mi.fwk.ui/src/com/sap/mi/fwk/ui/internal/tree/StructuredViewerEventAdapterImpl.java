package com.sap.mi.fwk.ui.internal.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * An Event Adapter for the Project Explorer /Navigator <br>
 * TODO optimize event handling
 * 
 * @author d022960
 * 
 */
public final class StructuredViewerEventAdapterImpl {

	private static final boolean DEFERRED_UPDATE = true;

	private final Map<EventRegistry, EventListener> mRegistryToEventListener = new HashMap<EventRegistry, EventListener>();

	protected StructuredViewer mViewer = null;

	public StructuredViewerEventAdapterImpl(final StructuredViewer viewer) {
		this.mViewer = viewer;
	}

	public void dispose() {
		this.mViewer = null;
		deregisterAllListeners();
	}

	/**
	 * 
	 * @param rootNode
	 * @deprecated use {@link #registerListeners(ITreeNode)}
	 */
	@Deprecated
	public void registerListeners(final ITreeNode<?> rootNode) {
		if (rootNode != null) {
			final Object value = rootNode.getValue();
			registerListeners((RefBaseObject) value);
		}
	}

	/**
	 * 
	 * @param modelElement
	 *            the
	 */
	public void registerListeners(final RefBaseObject modelElement) {
		if (this.mViewer == null) {
			throw new IllegalStateException("Event adapter has not been fully initialized - Viewer instance is null"); //$NON-NLS-1$
		}
		final Connection connection = ModelAdapter.getInstance().getConnection(modelElement);

		if (connection == null) {
			throw new IllegalStateException("No connection found for tree definition"); //$NON-NLS-1$
		}
		final EventRegistry eventRegistry = connection.getSession().getEventRegistry();

		if (!this.mRegistryToEventListener.containsKey(eventRegistry)) {
			final EventTypeFilter modelChangeEventFilter = new EventTypeFilter(ModelChangeEvent.class);
			OrFilter orFilter = null;

			// TODO this version registers for any partition changes which is
			// quite expensive. We could optimize that if we knew the
			// relevant partition set
			orFilter = new OrFilter(modelChangeEventFilter, new EventTypeFilter(PartitionChangeEvent.class));

			UpdateListener updateListener = null;
			if (StructuredViewerEventAdapterImpl.DEFERRED_UPDATE) {
				updateListener = new DeferredUpdateListener(this.mViewer);
			} else {
				updateListener = new UpdateListener() {
					public void notifyUpdate(final EventChain events) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								if (StructuredViewerEventAdapterImpl.this.mViewer != null
										&& !StructuredViewerEventAdapterImpl.this.mViewer.getControl().isDisposed()) {
									StructuredViewerEventAdapterImpl.this.mViewer.refresh();
								}
							}
						});
					}
				};
			}
			eventRegistry.registerUpdateListener(updateListener, orFilter);
			this.mRegistryToEventListener.put(eventRegistry, updateListener);
		}
	}

	/**
	 * An UpdateListener which is only (re-)invoked if no prior request is
	 * pending. The Delay time is EVENT_DELAY
	 * 
	 * @author d026276
	 * 
	 */
	static class DeferredUpdateListener implements UpdateListener {

		private final StructuredViewer mViewer;

		private RefreshJob lastRefreshJob = null;

		public DeferredUpdateListener(final StructuredViewer viewer) {
			this.mViewer = viewer;
		}

		boolean hasPendingRefresh() {
			return this.lastRefreshJob != null && this.lastRefreshJob.isAlive()
					&& this.lastRefreshJob.checkWait() == true;
		}

		void startRefresh() {
			this.lastRefreshJob = new RefreshJob(this.mViewer);
			this.lastRefreshJob.start();
		}

		public void notifyUpdate(final EventChain events) {
			synchronized (this.mViewer) {

				if (hasPendingRefresh()) {
					return;
				}
				startRefresh();
			}

		}

		private static final long EVENT_DELAY = 1000; // 1 sec.

		public class RefreshJob extends Thread {
			volatile boolean waiting = true;
			volatile long t_limit = 0;
			StructuredViewer mViewer = null;
			volatile public boolean mcancelled = false;

			public RefreshJob(final StructuredViewer viewer) {
				this.mViewer = viewer;
				this.waiting = true;
			}

			// there still is a slight race condition ( on the t_limit test ).

			public synchronized boolean checkWait() {
				if (this.waiting == true) {
					this.t_limit = System.currentTimeMillis() + DeferredUpdateListener.EVENT_DELAY;
					return true;
				}
				return false;
			}

			@Override
			public void run() {
				this.t_limit = System.currentTimeMillis() + DeferredUpdateListener.EVENT_DELAY;
				long t = 0;
				while (t < this.t_limit) {
					try {
						Thread.sleep(100);
					} catch (final InterruptedException e) {
						this.waiting = false;
						return; // die;
					}
					t = System.currentTimeMillis();
				}
				executeRefresh();
			}

			public synchronized void executeRefresh() {
				{
					this.waiting = false;
					DeferredUpdateListener.this.lastRefreshJob = null;
					if (this.mcancelled) {
						return;
					}
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (RefreshJob.this.mcancelled) {
								return;
							}
							if (RefreshJob.this.mViewer != null && !RefreshJob.this.mViewer.getControl().isDisposed()) {
								RefreshJob.this.mViewer.refresh();
							}
						}
					});
				}
			}

		}

		public void cancelJobs() {
			final RefreshJob rJob = this.lastRefreshJob;
			if (rJob != null) {
				rJob.mcancelled = true;
			}
		}
	}

	/**
	 * Deregisters all Moin Event listeners which have been registered via
	 * {@link #registerListeners(ITreeNode)}
	 */
	public void deregisterAllListeners() {
		// deregister inner session listeners
		final Set<Entry<EventRegistry, EventListener>> entries = this.mRegistryToEventListener.entrySet();
		for (final Entry<EventRegistry, EventListener> entry : entries) {
			final EventListener elistener = entry.getValue();
			if (elistener instanceof DeferredUpdateListener) {
				((DeferredUpdateListener) elistener).cancelJobs();
			}
			entry.getKey().deregister(elistener);
		}
		this.mRegistryToEventListener.clear();
	}

	/**
	 * @return the viewer
	 */
	public StructuredViewer getViewer() {
		return this.mViewer;
	}
}
