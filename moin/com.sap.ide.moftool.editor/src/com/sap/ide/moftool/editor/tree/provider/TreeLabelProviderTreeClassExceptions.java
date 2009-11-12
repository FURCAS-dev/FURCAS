/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeLabelProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.moftool.editor.provider.MOFToolLabelProvider;
import com.sap.ide.moftool.editor.tree.LocalizationMessages;
import com.sap.ide.moftool.editor.tree.tce.atn.NodeTCE_NodeParameters;
import com.sap.ide.moftool.editor.tree.tce.atn.NodeTCE_NodeTags;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

/**
 * @author SAP AG
 * @generated modified
 */
public class TreeLabelProviderTreeClassExceptions extends MOFToolLabelProvider {

	/**
	 * @modified
	 */
	@Override
	public Image getImage(Object element) {

		// <sw 08092008>
		// if (element instanceof NodeTCE_NodeParameters) {
		// return super.getImage("ATN_" + "tce_TCE_NodeParameters");
		// }
		//
		// if (element instanceof NodeTCE_NodeTags) {
		// return super.getImage("ATN_" + "tce_TCE_NodeTags");
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

		if (element instanceof NodeTCE_NodeParameters) {
			return LocalizationMessages.TreeLabelProviderTreeClassExceptions_0_XTND;

		}

		if (element instanceof NodeTCE_NodeTags) {
			return LocalizationMessages.TreeLabelProviderTreeClassExceptions_1_XTND;

		}

		if (element instanceof ITreeNodeRefObject) {
			return super.getText(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getText(element);
	}
}
