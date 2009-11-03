package com.sap.mi.tools.mmdeploy.internal.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;
import org.eclipse.ui.progress.WorkbenchJob;

import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;
import com.sap.mi.tools.mmdeploy.internal.messages.MmDeploymentMessages;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * The content provider for the deployment view. The first time it fetches the
 * metamodels in a background job and triggers an update afterwards.
 * 
 * @author d031150
 */
final class MmContentProvider implements ITreeContentProvider {

	private volatile boolean mMetamodelsFetched = false;
	private final MmDeploymentView mView;
	private AbstractTreeViewer mViewer;

	MmContentProvider(MmDeploymentView view) {
		mView = view;
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		mViewer = (AbstractTreeViewer) v;
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		return getChildren(parent);
	}

	public Object[] getChildren(Object parent) {
		if (parent instanceof MmWorkingSetNode) {
			MmWorkingSetNode set = (MmWorkingSetNode) parent;
			MmNode[] nodes = toMmNodes(set);
			return nodes;
		} else if (parent instanceof IViewSite) { // top level
			if (!mMetamodelsFetched) {
				scheduleFetchMetamodels();
				return new Object[] { MmPendingNode.INSTANCE };
			}

			Collection<MmDeploymentInfo> metamodels = MetamodelManager.getInstance().getDeployedMetamodels();
			Collection<IWorkingSet> sets = MetamodelManagerUI.getInstance().getMetamodelWorkingSets();
			if (MmDeploymentView.showWorkingSets()) {
				// grouped by working sets
				MmWorkingSetNode[] nodes = toWorkingSetNodes(sets, metamodels);
				return nodes;
			} else { // flat list of metamodels
				// We want to be stable with the selection when switching
				// between the two modes.
				// To achieve that find for each metamodel to return the first
				// working set node it is contained in and use this as the
				// parent for the metamodel node.
				MmNode[] nodes = new MmNode[metamodels.size()];
				int i = 0;
				for (MmDeploymentInfo metamodel : metamodels) {
					IWorkingSet set = findMetamodelInWorkingSets(metamodel, sets);
					// set may be null here, which indicates the Others
					// parentNode
					MmWorkingSetNode parentNode = toWorkingSetNode(set);
					MmNode node = toMmNode(metamodel, parentNode);
					nodes[i++] = node;
				}
				return nodes;
			}
		}
		return new Object[0];
	}

	public Object getParent(Object element) {
		if (element instanceof MmNode && MmDeploymentView.showWorkingSets()) {
			MmNode node = (MmNode) element;
			return node.getWorkingSet();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof MmWorkingSetNode) {
			MmWorkingSetNode cat = (MmWorkingSetNode) element;
			return cat.getMetamodels().size() > 0;
		}
		return false;
	}

	private static MmNode toMmNode(MmDeploymentInfo metamodel, MmWorkingSetNode parent) {
		MmNode node = toMmNodes(Collections.singleton(metamodel), parent)[0];
		return node;
	}

	private static MmNode[] toMmNodes(MmWorkingSetNode parent) {
		Collection<MmDeploymentInfo> metamodels = parent.getMetamodels();
		return toMmNodes(metamodels, parent);
	}

	private static MmNode[] toMmNodes(Collection<MmDeploymentInfo> metamodels, MmWorkingSetNode parent) {
		MmNode[] nodes = new MmNode[metamodels.size()];
		int i = 0;
		for (MmDeploymentInfo metamodel : metamodels) {
			nodes[i++] = new MmNode(metamodel, parent);
		}
		return nodes;
	}

	static MmWorkingSetNode toWorkingSetNode(IWorkingSet set) {
		Collection<MmDeploymentInfo> allMetamodels = MetamodelManager.getInstance().getDeployedMetamodels();
		MmWorkingSetNode node;
		if (set == null)
			node = toOthersNode(allMetamodels);
		else
			node = toWorkingSetNodes(Collections.singleton(set), allMetamodels)[0];
		return node;
	}

	private static MmWorkingSetNode[] toWorkingSetNodes(Collection<IWorkingSet> sets,
			Collection<MmDeploymentInfo> allMetamodels) {
		Collection<MmDeploymentInfo> all = new HashSet<MmDeploymentInfo>(allMetamodels);
		Collection<MmWorkingSetNode> result = new ArrayList<MmWorkingSetNode>(sets.size() + 1);

		for (IWorkingSet set : sets) {
			Collection<MmDeploymentInfo> metamodels = toMetamodels(set);
			result.add(new MmWorkingSetNode(metamodels, set));
			all.removeAll(metamodels);
		}

		// add "Other" if necessary
		if (!all.isEmpty())
			result.add(toOthersNode(all));
		return result.toArray(new MmWorkingSetNode[result.size()]);
	}

	private static MmWorkingSetNode toOthersNode(Collection<MmDeploymentInfo> metamodels) {
		return new MmWorkingSetNode(metamodels, null);
	}

	private static Collection<MmDeploymentInfo> toMetamodels(IWorkingSet set) {
		IAdaptable[] elements = set.getElements();
		Collection<MmDeploymentInfo> result = new ArrayList<MmDeploymentInfo>(elements.length);
		for (int i = 0; i < elements.length; i++) {
			MmDeploymentInfo metamodel = (MmDeploymentInfo) elements[i].getAdapter(MmDeploymentInfo.class);
			if (metamodel != null)
				result.add(metamodel);
		}
		return result;
	}

	private static IWorkingSet findMetamodelInWorkingSets(MmDeploymentInfo metamodel, Collection<IWorkingSet> sets) {
		for (IWorkingSet set : sets) {
			Collection<MmDeploymentInfo> metamodels = toMetamodels(set);
			if (metamodels.contains(metamodel))
				return set;
		}
		return null;
	}

	private void scheduleFetchMetamodels() {
		Job job = new FetchMetamodelsJob();
		job.setRule(MmSchedulingRule.INSTANCE);
		job.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				mMetamodelsFetched = true;
				scheduleUpdateTree();
			}
		});

		IWorkbenchSiteProgressService progressService = (IWorkbenchSiteProgressService) mView.getSite().getAdapter(
				IWorkbenchSiteProgressService.class);
		progressService.schedule(job);
	}

	private void scheduleUpdateTree() {
		if (isUiAlive()) {
			Job job = new TreeUpdateJob();
			job.setSystem(true);
			job.schedule();
		}
	}

	private boolean isUiAlive() {
		return mViewer != null && !mViewer.getControl().isDisposed();
	}

	private static final class FetchMetamodelsJob extends Job {
		public FetchMetamodelsJob() {
			super(MmDeploymentMessages.contentProvider_loading);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			MetamodelManager.getInstance().getDeployedMetamodels();
			return Status.OK_STATUS;
		}
	}

	private final class TreeUpdateJob extends WorkbenchJob {
		public TreeUpdateJob() {
			super(mViewer.getControl().getDisplay(), MmDeploymentMessages.contentProvider_updating);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if (isUiAlive()) {
				mView.refresh();
				return Status.OK_STATUS;
			}
			return Status.CANCEL_STATUS;
		}
	}
}