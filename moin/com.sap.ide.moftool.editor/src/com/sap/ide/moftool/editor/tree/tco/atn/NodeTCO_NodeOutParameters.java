
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1) 
 * (NodeClass_ARTIFICIAL.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tco.atn;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;

import com.sap.ide.moftool.editor.tree.tco.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tco.men.NodeTCO_NodeOperation;
import com.sap.ide.moftool.editor.tree.tco.men.NodeTCO_NodeOutParameter;
import com.sap.mi.fwk.ui.tree.nodes.TreeNode;

/**
 * @generated modified
 */
public class NodeTCO_NodeOutParameters extends TreeNode<Operation> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeTCO_NodeOutParameters(Object parent, Operation modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public NodeTCO_NodeOutParameters(Operation modelElement) {
		super(modelElement);
		//set the parent for this node using the setParent(Object) method otherwise equals(Object) will fail		
		setParent(new NodeTCO_NodeOperation(modelElement));	
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<NodeTCO_NodeOutParameter> children = new ArrayList<NodeTCO_NodeOutParameter>();

		Operation operation = getValue();
		
		for (ModelElement dobj : operation.getContents()) {
			if (dobj instanceof Parameter) {
				if (DirectionKindEnum.OUT_DIR.equals(((Parameter)dobj).getDirection())) {
					NodeTCO_NodeOutParameter ltn = new NodeTCO_NodeOutParameter(this,
							(Parameter)dobj);
					children.add(ltn);
				}
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