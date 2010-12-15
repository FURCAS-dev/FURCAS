package com.sap.ide.treeprovider.internal.explorer;

import org.eclipse.core.resources.IProject;

import com.sap.ide.treeprovider.internal.explorer.nodes.RootNodeComponent;

/**
 * The tree content provider. Able to provide the virtual "BO Nodes" root and
 * the concrete BO nodes.
 * 
 * @author d046040
 */
public final class ComponentContentProvider extends TreeNodeNavigatorContentProvider {

    public Object[] getChildren(Object parentElement) {
	if (parentElement instanceof IProject) {
	    IProject project = (IProject) parentElement;
	    // safeguard when IDE is shutting down or when project is closing
	    if (!project.isAccessible()) {
		return null;
	    }
	    RootNodeComponent root = new RootNodeComponent(project);
	    return new Object[] { root };
	}
	if (parentElement instanceof RootNodeComponent) {
	    if (!initializeConnectionDeferred((RootNodeComponent) parentElement)) {
		// initialization not finished (yet), so return place holder
		// once a connection is available the tree will be refreshed
		return new Object[] { ITreeNode.LOADING_DATA_NODE };
	    }
	}

	// NOTE: Make sure that this content provider does not provide
	// children of foreign tree nodes.
	//
	// Solution implemented as proposed by MOIN:
	// Define a tag interface (INodeExplorer) that has to be
	// implemented by all tree nodes provided by this content provider and
	// define this interface in the 'navigatorContent' extension point as a
	// triggerpoint or'ed by the corresponding project nature(s)

	return super.getChildren(parentElement);
    }
}
