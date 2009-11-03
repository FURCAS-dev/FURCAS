package com.sap.coghead.tree;

import coghead.Field;
import coghead.Variable;
import coghead.action.MultiplicityEnum;
import coghead.packages.NamedElement;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.TextLabelProvider;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

public class CogheadTreeLabelProvider implements TextLabelProvider {

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
	    if (node.getValue() instanceof Field) {
		Field f = (Field) node.getValue();
		return f.getName()+" : "+f.getType()+formatCardinality(f.getCardinality());
	    } else if (node.getValue() instanceof Variable) {
		Variable v = (Variable) node.getValue();
		return v.getName()+" : "+((v.getSchemaType() != null)?v.getSchemaType().getCollection().getName():
		    v.getElementaryType())+((v.getMultiplicity()==MultiplicityEnum.COLLECTION)?"[]":"");
	    } else if (node.getValue() instanceof NamedElement) {
		return roleName+((NamedElement) node.getValue()).getName();
	    }
	}
	return null;
    }
    
    private String formatCardinality(int cardinality) {
	if (cardinality == 1) {
	    return "";
	} else if (cardinality == -1) {
	    return "[]";
	} else {
	    return "["+cardinality+"]";
	}
    }

}
