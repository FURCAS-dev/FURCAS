package com.sap.finex.tree;

import structure.Field;
import structure.TypedElement;
import behavior.expressions.literals.Literal;
import behavior.functions.Parameter;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.TextLabelProvider;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

import finex.modelmanagement.NamedElement;

public class FinexTreeLabelProvider implements TextLabelProvider {
    @Override
    public String getText(Object treenode) {
	StringBuilder result = new StringBuilder();
	if (treenode instanceof TreeNodeRefObject) {
	    TreeNodeRefObject<?> node = (TreeNodeRefObject<?>) treenode;
	    String roleName = "";
	    if (node instanceof GenericRefObjectNode) {
		String nodeRoleName = ((GenericRefObjectNode) node).getRoleName();
		if (nodeRoleName != null) {
		    roleName = nodeRoleName+": ";
		}
	    }
	    if (node.getValue() instanceof Parameter) {
		result.append(((Parameter) node.getValue()).getDirection().toString());
		result.append(' ');
	    }
	    if (node.getValue() instanceof NamedElement) {
		result.append(roleName);
		result.append(((NamedElement) node.getValue()).getName());
	    } else if (node.getValue() instanceof Literal) {
		    result.append(((Literal) node.getValue()).getLiteral());
	    }
	    if (node.getValue() instanceof Field) {
		Field f = (Field) node.getValue();
		result.append(roleName);
		if (f.isMandatory()) {
		    result.append(" [1..");
		} else {
		    result.append(" [0..");
		}
		if (f.isSingleMultiplicity()) {
		    result.append("1]");
		} else {
		    result.append("*]");
		}
		if (f.getType() != null) {
		    result.append(':');
		    result.append(f.getType().getName());
		} else {
		    result.append("<unknown type>");
		}
	    }
	    else if (node.getValue() instanceof TypedElement) {
		result.append(roleName);
		if (((TypedElement) node.getValue()).getType() != null) {
		    result.append(':');
		    result.append(((TypedElement) node.getValue()).getType().getName());
		} else {
		    result.append("<unknown type>");
		}
	    }
	}
	return result.length() > 0 ? result.toString() : null;
    }
}
