package com.sap.ap.cts.monet.tree;

import modelmanagement.NamedElement;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.TextLabelProvider;

import data.classes.Signature;
import data.classes.TypeDefinition;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.VariableExpression;

public class RunletTreeLabelProvider implements TextLabelProvider {
    @Override
    public String getText(Object treenode) {
	if (treenode instanceof TreeNodeRefObject<?>) {
	    TreeNodeRefObject<?> node = (TreeNodeRefObject<?>) treenode;
	    String roleName = "";
	    if (node instanceof GenericRefObjectNode) {
		String nodeRoleName = ((GenericRefObjectNode) node).getRoleName();
		if (nodeRoleName != null) {
		    roleName = nodeRoleName+": ";
		}
	    }
	    if (node.getValue() instanceof Signature) {
		return roleName+StringFormatter.toString((Signature) node.getValue());
	    } else if (node.getValue() instanceof TypeDefinition) {
		return roleName+StringFormatter.toString((TypeDefinition) node.getValue());
	    } else if (node.getValue() instanceof NamedElement) {
		return roleName+((NamedElement) node.getValue()).getName();
	    } else if (node.getValue() instanceof MethodCallExpression) {
		return roleName+ "[MethodCallExpression] " + (((MethodCallExpression) node.getValue()).getMethodSignature() != null ?
			((MethodCallExpression) node.getValue()).getMethodSignature().getName() :
			    ((MethodCallExpression) node.getValue()).refMofId());
	    } else if (node.getValue() instanceof VariableExpression) {
		return roleName+ "[VariableExpression] variable: " + (((VariableExpression) node.getValue()).getVariable() != null ?
			((VariableExpression) node.getValue()).getVariable().getName() :
			"<null>");
	    }
	}
	return null;
    }
}
