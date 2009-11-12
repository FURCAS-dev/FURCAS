
// TreeTreeStructureTypeConstraints

// NodeTSTC_NodeStructureType1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tstc.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.tree.tstc.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

/**
 * @generated modified
 */
public class NodeTSTC_NodeStructureType extends TreeNodeRefObject<StructureType> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTSTC_NodeStructureType(StructureType modelElement) {
		super(modelElement, modelElement);

	}

	/**
	 * @modified
	 */
	public NodeTSTC_NodeStructureType(Object parent, StructureType modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTSTC_NodeStructureTypeConstraint> children = new ArrayList<NodeTSTC_NodeStructureTypeConstraint>();

		StructureType structureType = getValue();
	
		for (ModelElement dobj : structureType.getContents()) {
			if (dobj instanceof Constraint) {				
				NodeTSTC_NodeStructureTypeConstraint ltn = new NodeTSTC_NodeStructureTypeConstraint(this,
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
