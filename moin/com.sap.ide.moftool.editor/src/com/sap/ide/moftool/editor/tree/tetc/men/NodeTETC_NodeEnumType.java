
// TreeTreeEnumTypeConstraints

// NodeTETC_NodeEnumType1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tetc.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;

import com.sap.ide.moftool.editor.tree.tetc.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTETC_NodeEnumType extends TreeNodeRefObject<EnumerationType> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTETC_NodeEnumType(EnumerationType modelElement) {
		super(modelElement, modelElement);

	}

	/**
	 * @modified
	 */
	public NodeTETC_NodeEnumType(Object parent, EnumerationType modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTETC_NodeEnumTypeConstraint> children = new ArrayList<NodeTETC_NodeEnumTypeConstraint>();

		EnumerationType structureType = getValue();
	
		for (ModelElement dobj : structureType.getContents()) {
			if (dobj instanceof Constraint) {				
				NodeTETC_NodeEnumTypeConstraint ltn = new NodeTETC_NodeEnumTypeConstraint(this,
						(Constraint)dobj);
				children.add(ltn);
			}
		}

		return children.toArray();

	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return getChildren().length != 0;
	}
}
