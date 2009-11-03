package com.sap.mi.tcs.editor.tree;

import tcs.ClassTemplate;
import tcs.LiteralRef;
import tcs.NamedElement;
import tcs.Operator;
import tcs.OperatorTemplate;
import tcs.Property;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.TextLabelProvider;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

public class TcsTreeLabelProvider implements TextLabelProvider {
	@Override
	public String getText(Object treenode) {
		if (treenode instanceof TreeNodeRefObject) {
			TreeNodeRefObject<?> node = (TreeNodeRefObject<?>) treenode;
			String roleName = "";
			if (node instanceof GenericRefObjectNode) {
				String nodeRoleName = ((GenericRefObjectNode) node).getRoleName();
				if (nodeRoleName != null) {
					roleName = nodeRoleName + ": ";
				}
			}
			if (node.getValue() instanceof ClassTemplate) {
				ClassTemplate ct = (ClassTemplate) node.getValue();
				String name;
				if (ct.getMetaReference() != null) {
					name = roleName + ct.getMetaReference().getName();
				} else {
					name = roleName + ct.getNames().toString();
				}
				if (ct.getMode() != null) {
					name += "#" + ct.getMode();
				}
				return name;
			}
			if (node.getValue() instanceof OperatorTemplate) {
				OperatorTemplate ot = (OperatorTemplate) node.getValue();
				String name = "<";
				for (Operator op : ot.getOperators()) {
					name +=  op.getName() + " "; 
				}
				name += ">";
				if (ot.getMetaReference() != null) {
					name = roleName + name + ot.getMetaReference().getName();
				} else {
					name = roleName + name + ot.getNames().toString();
				}
				return name;
			}
			if (node.getValue() instanceof NamedElement) {
				return roleName + ((NamedElement) node.getValue()).getName();
			}
			if (node.getValue() instanceof LiteralRef) {
				return roleName
					+ ((LiteralRef) node.getValue()).getReferredLiteral()
						.getValue();
			}
			if (node.getValue() instanceof Property) {
				return roleName
					+ ((Property) node.getValue()).getPropertyReference().getStrucfeature()
						.getName();
			}
		}
		return null;
	}
}
