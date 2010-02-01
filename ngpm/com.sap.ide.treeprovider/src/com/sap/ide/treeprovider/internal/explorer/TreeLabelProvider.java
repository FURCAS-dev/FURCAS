package com.sap.ide.treeprovider.internal.explorer;

import java.lang.reflect.Method;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.TextLabelProvider;
import com.sap.ide.treeprovider.internal.Activator;
import com.sap.ide.treeprovider.internal.explorer.nodes.RootNodeComponent;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeLabelProvider;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Provides images and texts for the tree nodes. By default, the
 * {@link Activator#getImage(com.sap.tc.moin.repository.mmi.reflect.RefObject)}
 * method is used to determine the image for the tree node. The root node and
 * nodes that are not of type {@link TreeNodeRefObject} get handled
 * specifically.
 * <p>
 * 
 * The text label is determined bz {@link #getText(Object)}. TODO That method
 * needs refactoring. It currently does a set of <tt>instanceof</tt> checks and
 * utilizes {@link StringFormatter} for a few special types such as
 * <tt>TypeDefinition</tt> and <tt>Signature</tt>.
 * 
 * @author D046040
 * 
 */
public final class TreeLabelProvider extends TreeNodeLabelProvider {

    public TreeLabelProvider() {
	super();
    }

    @Override
    public String getText(Object treenode) {
	String result = super.getText(treenode);
	if (result == null) {
	    // specials for RootNode and Loading Node
	    if (treenode instanceof RootNodeComponent) {
		result = "Model";
	    } else {
		// ask providers
		IExtensionPoint eventListenerPoint = Platform.getExtensionRegistry().getExtensionPoint(
			"com.sap.ide.treeprovider.textLabelProvider");
		for (IConfigurationElement e : eventListenerPoint.getConfigurationElements()) {
		    if (e.getName().equals("textLabelProvider")) {
			TextLabelProvider provider;
			try {
			    provider = (TextLabelProvider) e.createExecutableExtension("classname");
			    result = provider.getText(treenode);
			    if (result != null) {
				break;
			    }
			} catch (CoreException ex) {
			    throw new RuntimeException(ex);
			}
		    }
		}
	    }
	    // default handling
	    if (result == null) {
		// if it has a name: show the name
		TreeNodeRefObject<?> node = (TreeNodeRefObject<?>) treenode;
		RefObject modelElement = node.getValue();
		try {
		    Method getName = modelElement.getClass().getMethod("getName", String.class);
		    String name = (String) getName.invoke(modelElement);
		    return name;
		} catch (NoSuchMethodException e) {
		    // has no name
		    // if not: optional role name + class name + MOF ID
		    String roleName = "";
		    if (treenode instanceof GenericRefObjectNode) {
			String nodeRoleName = ((GenericRefObjectNode) treenode).getRoleName();
			if (nodeRoleName != null) {
			    roleName = nodeRoleName + ": ";
			}
		    }
		    return roleName + "[" + ((MofClass) node.getValue().refMetaObject()).getName() + "] MOF ID "
			    + node.getValue().refMofId();
		} catch (Exception e) {
		    throw new RuntimeException(e);
		}
	    }
	}
	return result;
    }

    @Override
    public Image getImage(Object treenode) {

	if (treenode instanceof RootNodeComponent) {
	    return Activator.getImageModelRoot();
	}

	if (treenode instanceof TreeNodeRefObject<?>) {
	    Image image = Activator.getImage(((TreeNodeRefObject<?>) treenode).getValue());
	    if (image != null) {
		return image;
	    }
	}
	return super.getImage(treenode);
    }
}
