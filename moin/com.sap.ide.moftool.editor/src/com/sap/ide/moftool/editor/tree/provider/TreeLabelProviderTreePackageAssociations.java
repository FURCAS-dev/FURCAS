/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeLabelProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import com.sap.tc.moin.repository.mmi.model.Reference;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.moftool.editor.provider.MOFToolLabelProvider;
import com.sap.ide.moftool.editor.tree.LocalizationMessages;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeAssociationEnds;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeConstraints;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeReferences;
import com.sap.ide.moftool.editor.tree.tpa.atn.NodeTPA_NodeTags;
import com.sap.ide.moftool.editor.tree.tpa.men.NodeTPA_NodeReference;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

/**
 * @author SAP AG
 * @generated
 */
public class TreeLabelProviderTreePackageAssociations extends MOFToolLabelProvider {

	/**
	 * @generated
	 */
	@Override
	public Image getImage(Object element) {

		if (element instanceof NodeTPA_NodeReferences) {
			return super.getImage("ATN_" + "tpa_TPA_NodeReferences"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// <sw 08092008>
		// if (element instanceof NodeTPA_NodeAssociationEnds) {
		// return super.getImage("ATN_" + "tpa_TPA_NodeAssociationEnds");
		// }
		//		
		// if (element instanceof NodeTPA_NodeConstraints) {
		// return super.getImage("ATN_" + "tpa_TPA_NodeConstraints");
		// }
		//
		// if (element instanceof NodeTPA_NodeTags) {
		// return super.getImage("ATN_" + "tpa_TPA_NodeTags");
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

		if (element instanceof NodeTPA_NodeAssociationEnds) {
			return LocalizationMessages.TreeLabelProviderTreePackageAssociations_0_XTND;

		}

		if (element instanceof NodeTPA_NodeReferences) {
			return LocalizationMessages.TreeLabelProviderTreePackageAssociations_1_XTND;

		}

		if (element instanceof NodeTPA_NodeConstraints) {
			return LocalizationMessages.TreeLabelProviderTreePackageAssociations_2_XTND;

		}

		if (element instanceof NodeTPA_NodeTags) {
			return LocalizationMessages.TreeLabelProviderTreePackageAssociations_3_XTND;

		}

		if (element instanceof ITreeNodeRefObject) {

			if (element instanceof NodeTPA_NodeReference) {
				Reference reference = ((NodeTPA_NodeReference) element).getValue();
				return super.getText(reference) + " (" + LocalizationMessages.TreeLabelProviderTreePackageAssociations_0_XMSG +" '" + reference.getContainer().getName() + "')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			return super.getText(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getText(element);
	}
}
