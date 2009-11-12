
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.tree.tstc.men.NodeTSTC_NodeStructureType;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeContentProvider;

/**
 * @author SAP AG
 * @generated modified
 */

public class TreeProviderTreeStructureTypeConstraints extends TreeNodeContentProvider {

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {

		return super.getChildren(parentElement);
	}

	/**
	 * Given the input, return the top level entities; 
	 * This is generated from the  <Root> contents
	 * It can be used to use one and the same tree with different input to display subtrees
	 * Root entries are directly returned, 
	 * @modified
	 */
	public Object[] getElements(Object inputElement) {

		if (inputElement instanceof StructureType) {
			ITreeNode<?> newNode = new NodeTSTC_NodeStructureType(inputElement, (StructureType)inputElement);
			return getChildren(newNode);
		}
		return null;
	}

}
