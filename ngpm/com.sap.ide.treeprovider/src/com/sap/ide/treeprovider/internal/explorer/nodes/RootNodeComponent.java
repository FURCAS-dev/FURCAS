package com.sap.ide.treeprovider.internal.explorer.nodes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;

import com.sap.ide.treeprovider.INodeExplorer;
import com.sap.ide.treeprovider.RootNodeProvider;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeDomainRoot;
import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * Root tree node for simple component sample
 * 
 * @author D046040
 */
public final class RootNodeComponent extends TreeNodeDomainRoot implements INodeExplorer {

    public RootNodeComponent(IProject project) {
	super(project, project);
    }

    @Override
    public boolean hasChildren() {
	// Simply return true in order to avoid loading MOIN just for
	// calculation of the expansion state
	return true;
    }
    
    public boolean isConnectionInitialized() {
	return getConnection() != null;
    }

    @Override
    public Object[] getChildren() {
	List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();
	IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry().getExtensionPoint(
		"com.sap.ide.treeprovider.rootNodeDefinition");
	for (IConfigurationElement element : eventListenerPoint.getConfigurationElements()) {
	    if (element.getName().equals("rootNodeProvider")) {
		RootNodeProvider provider;
		try {
		    provider = (RootNodeProvider) element.createExecutableExtension("classname");
		    children.addAll(provider.getChildren(this, getValue(), getConnection()));
		} catch (CoreException e) {
		    throw new RuntimeException(e);
		}
	    }
	}
	return children.toArray();
    }

    public List<MofClass> getTopLevelModelElementTypes() {
	List<MofClass> result = new ArrayList<MofClass>();
	IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry().getExtensionPoint(
		"com.sap.ide.treeprovider.rootNodeDefinition");
	for (IConfigurationElement element : eventListenerPoint.getConfigurationElements()) {
	    if (element.getName().equals("rootNodeProvider")) {
		RootNodeProvider provider;
		try {
		    provider = (RootNodeProvider) element.createExecutableExtension("classname");
		    result.addAll(provider.getTopLevelModelElementTypes(getConnection()));
		} catch (CoreException e) {
		    throw new RuntimeException(e);
		}
	    }
	}
	return result;
	
    }
}