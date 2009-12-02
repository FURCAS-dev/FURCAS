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
	if (treenode instanceof TreeNodeRefObject<?>) {
	    TreeNodeRefObject<?> node = (TreeNodeRefObject<?>) treenode;
	    if (node instanceof GenericRefObjectNode) {
		String nodeRoleName = ((GenericRefObjectNode) node).getRoleName();
		if (nodeRoleName != null) {
		    result.append(nodeRoleName);
		    result.append(": ");
		}
	    }
	    if (node.getValue() instanceof Parameter) {
		result.append(((Parameter) node.getValue()).getDirection().toString());
		result.append(' ');
	    }
	    if (node.getValue() instanceof NamedElement) {
		result.append(((NamedElement) node.getValue()).getName());
	    } else if (node.getValue() instanceof Literal) {
		result.append(((Literal) node.getValue()).getLiteral());
	    }
	    if (node.getValue() instanceof TypedElement) {
		if (((TypedElement) node.getValue()).getType() != null) {
		    result.append(':');
		    result.append(((TypedElement) node.getValue()).getType().getName());
		} else {
		    result.append("<unknown type>");
		}
	    }
	    if (node.getValue() instanceof Field) {
		Field f = (Field) node.getValue();
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
	    }
	}
	return result.length() > 0 ? result.toString() : null;
    }
}
