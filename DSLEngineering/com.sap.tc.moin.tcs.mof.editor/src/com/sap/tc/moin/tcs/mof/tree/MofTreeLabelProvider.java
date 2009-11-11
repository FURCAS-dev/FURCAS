package com.sap.tc.moin.tcs.mof.tree;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.TextLabelProvider;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.TypedElement;

public class MofTreeLabelProvider implements TextLabelProvider {
    @Override
    public String getText(Object treenode) {
	if (treenode instanceof TreeNodeRefObject) {
	    TreeNodeRefObject<?> node = (TreeNodeRefObject<?>) treenode;
	    String roleName = "";
	    if (node instanceof GenericRefObjectNode) {
		String nodeRoleName = ((GenericRefObjectNode) node).getRoleName();
		if (nodeRoleName != null) {
		    roleName = nodeRoleName+": ";
		}
	    }
	    if (node.getValue() instanceof TypedElement) {
		String typename = ((TypedElement) node.getValue()).getType() == null ? "<null>" : 
		    ((TypedElement) node.getValue()).getType().getName();
		return roleName+((TypedElement) node.getValue()).getName() + " : " + typename;
	    }
	    else if (node.getValue() instanceof ModelElement) {
		return roleName+((ModelElement) node.getValue()).getName();
	    }
	}
	return null;
    }
}
