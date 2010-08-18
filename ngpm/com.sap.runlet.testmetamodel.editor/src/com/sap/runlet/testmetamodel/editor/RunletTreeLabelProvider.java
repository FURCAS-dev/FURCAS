package com.sap.runlet.testmetamodel.editor;

import java.lang.reflect.Method;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.TextLabelProvider;

public class RunletTreeLabelProvider implements TextLabelProvider {
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
	    Object o = node.getValue();
	    try {
		Method getName = o.getClass().getMethod("getName");
		String name = (String) getName.invoke(node.getValue());
		return roleName+name;
	    } catch (Exception e) {
		return null;
	    }
	}
	return null;
    }
}
