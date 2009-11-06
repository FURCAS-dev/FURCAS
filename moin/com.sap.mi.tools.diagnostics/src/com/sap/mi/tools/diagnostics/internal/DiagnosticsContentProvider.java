package com.sap.mi.tools.diagnostics.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.management.ObjectName;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Control;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.diagnostics.internal.MoinJmxClient.MBeanChangeListener;
import com.sap.mi.tools.diagnostics.internal.model.EditorRegistryNode;
import com.sap.mi.tools.diagnostics.internal.model.MoinNode;
import com.sap.mi.tools.diagnostics.internal.model.NoJmxDummyNode;
import com.sap.mi.tools.diagnostics.internal.model.TreeNode;
import com.sap.tc.moin.repository.jmx.MoinMBean;

/**
 * Content provider of the diagnostic viewer
 * 
 * @author d031150
 */
public class DiagnosticsContentProvider implements ITreeContentProvider {
	
	static final String NAME_DIAGNOSTICS_TREE = "DiagnosticsTree"; //$NON-NLS-1$

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_DIAGNOSTICS);

    private static final Object[] NO_ELEMENTS = new Object[0];
	private final TreeExpandListener mExpandListener = new TreeExpandListener();
	private final DiagnosticDoubleClickListener mDoubleClickListener = new DiagnosticDoubleClickListener();
    private AbstractTreeViewer mViewer;
	private MoinJmxClient mMoinClient;

	private List<MoinNode> mMoinNodes;

	private DiagnosticsUpdater mUpdater;

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement) {
    	if (mMoinClient != null) {
            // Store child node to stay stable with the children.  See ConnectionsNode
            // for details.
    		List<TreeNode> elements;
    		if (mMoinNodes == null || mMoinNodes.isEmpty()) {
	    		Map<ObjectName, MoinMBean> moins = mMoinClient.getMoins();
	    		mMoinNodes = new ArrayList<MoinNode>(moins.size());
	    		elements = new ArrayList<TreeNode>(mMoinNodes.size() + 1);
    			for (Entry<ObjectName, MoinMBean> moinEntry : moins.entrySet()) {
    				mMoinNodes.add(new MoinNode(moinEntry.getValue(), moinEntry.getKey(), mMoinClient));
    				elements.addAll(mMoinNodes);
    			}
    		}
    		else {
    			elements = new ArrayList<TreeNode>(mMoinNodes.size() + 1);
    			elements.addAll(mMoinNodes);
    		}
        	EditorRegistryNode regNode = new EditorRegistryNode(mMoinClient);
        	elements.add(regNode);
        	return elements.toArray(new TreeNode[elements.size()]);
    	}
    	
    	// general JMX connection problems
    	return new TreeNode[] {new NoJmxDummyNode()};
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    public Object[] getChildren(Object parentElement) {
        if (parentElement instanceof TreeNode) {
            TreeNode node = (TreeNode) parentElement;
            Object[] children = node.getChildren();
            return children;
        }
        return NO_ELEMENTS;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    public Object getParent(Object element) {
        if (element instanceof TreeNode) {
            TreeNode node = (TreeNode) element;
            Object parent = node.getParent();
            return parent;
        }
        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    public boolean hasChildren(Object element) {
        if (element instanceof TreeNode) {
            TreeNode node = (TreeNode) element;
            boolean hasChildren = node.hasChildren();
            return hasChildren;
        }
        return false;
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#dispose()
     */
    public void dispose() {
    	if (mUpdater != null) {
    		sTracer.log(Level.FINE, "Cancelling update for viewer: " + mViewer); //$NON-NLS-1$
    		mUpdater.cancel();
    		mUpdater = null;
    	}
    	
        if (!mViewer.getControl().isDisposed()) {
            mViewer.removeTreeListener(mExpandListener);
            mViewer.removeDoubleClickListener(mDoubleClickListener);
        }
        if (mMoinClient != null) {
        	mMoinClient.disconnect();
        	mMoinClient = null;
        }
    }

    /**
     * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        mViewer = (AbstractTreeViewer) viewer;
        viewer.getControl().setData("name", NAME_DIAGNOSTICS_TREE); //$NON-NLS-1$
        
        if (newInput != null) {
            ((AbstractTreeViewer) viewer).addTreeListener(mExpandListener);
            mViewer.addDoubleClickListener(mDoubleClickListener);
            try {
            	mMoinClient = new MoinJmxClient(new MoinBeanChangedListener());
            } 
            catch (IOException e) { //$JL-EXC$
            	// ignore - we detect absence of MoinJmxClient lateron
            }
            
            sTracer.log(Level.FINE, "Registering update for viewer: " + mViewer); //$NON-NLS-1$
            mUpdater = new DiagnosticsUpdater(mViewer);
            Timer timer = new Timer("Diagnotics View Updater", true); //$NON-NLS-1$
			timer.schedule(mUpdater, new Date(System.currentTimeMillis()), 10000);
        }
    }
    
	private final class MoinBeanChangedListener implements MBeanChangeListener {
		public void mBeanChanged(ObjectName name) {
			sTracer.log(Level.FINE, "Received notification for name: " + name.toString()); //$NON-NLS-1$
			Control control = mViewer.getControl();
			// watch out for an already disposed UI
			if (mMoinClient != null && !control.isDisposed()) {
				// Notification is done in a background thread!
				control.getDisplay().asyncExec(new Runnable() {
					public void run() {
						if (mViewer.getControl().isDisposed())
							return;
						mViewer.refresh();
						sTracer.log(Level.FINE, "Refreshed viewer"); //$NON-NLS-1$
					}
				});
			}
		}
	}


}
