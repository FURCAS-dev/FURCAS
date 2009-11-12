/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeLabelProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.moftool.editor.provider.MOFToolLabelProvider;
import com.sap.ide.moftool.editor.tree.LocalizationMessages;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeInOutParameters;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeInParameters;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeOutParameters;
import com.sap.ide.moftool.editor.tree.tco.atn.NodeTCO_NodeTags;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

/**
 * @author SAP AG
 * @generated modified
 */
public class TreeLabelProviderTreeClassOperations extends MOFToolLabelProvider {

	/**
	 * @modified
	 */
	@Override
	public Image getImage(Object element) {

		// <sw 08092008>
		// if (element instanceof NodeTCO_NodeInParameters) {
		// return super.getImage("ATN_" + "tco_TCO_NodeInParameters");
		// }
		//
		// if (element instanceof NodeTCO_NodeOutParameters) {
		// return super.getImage("ATN_" + "tco_TCO_NodeOutParameters");
		// }
		//
		// if (element instanceof NodeTCO_NodeInOutParameters) {
		// return super.getImage("ATN_" + "tco_TCO_NodeInOutParameters");
		// }
		//
		// if (element instanceof NodeTCO_NodeTags) {
		// return super.getImage("ATN_" + "tco_TCO_NodeTags");
		// }
		// </sw 08092008>

		if (element instanceof ITreeNodeRefObject) {
			return super.getImage(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	@Override
	public String getText(Object element) {

		if (element instanceof NodeTCO_NodeInParameters) {
			return LocalizationMessages.TreeLabelProviderTreeClassOperations_0_XTND;

		}

		if (element instanceof NodeTCO_NodeOutParameters) {
			return LocalizationMessages.TreeLabelProviderTreeClassOperations_1_XTND;

		}

		if (element instanceof NodeTCO_NodeInOutParameters) {
			return LocalizationMessages.TreeLabelProviderTreeClassOperations_2_XTND;

		}

		if (element instanceof NodeTCO_NodeTags) {
			return LocalizationMessages.TreeLabelProviderTreeClassOperations_3_XTND;

		}

		if (element instanceof ITreeNodeRefObject) {
			return super.getText(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getText(element);
	}
}
