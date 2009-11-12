// TreeMofTreeCNF

// NodeCnfDiagramsInPackages1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcnf.men;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.tree.tcnf.IThisTreeNode;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.gfw.mm.pictograms.Diagram;

/**
 * @generated modified
 */
public class NodeCnfDiagramsInPackages extends TreeNodeRefObject<Diagram> implements IThisTreeNode {

	/**
	 * @modified
	 */
	public NodeCnfDiagramsInPackages(Diagram modelElement) {
		super(modelElement);
		// initialize the parent for this node using the method
		// setParent(Object)
		MofPackage diagramPackage = DiagramService.getDiagramPackage(modelElement);
		setParent(new NodeCnfPackages(diagramPackage));

	}

	/**
	 * @modified
	 */
	public NodeCnfDiagramsInPackages(Object parent, Diagram modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @generated
	 */
	public Object[] getChildren() {
		return ITreeNode.EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return false;
	}
}
