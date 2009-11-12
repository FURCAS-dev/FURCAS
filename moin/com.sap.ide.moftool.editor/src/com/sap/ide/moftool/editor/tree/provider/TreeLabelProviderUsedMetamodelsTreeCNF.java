/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeLabelProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.moftool.editor.provider.MOFToolLabelProvider;
import com.sap.ide.moftool.editor.tree.LocalizationMessages;
import com.sap.ide.moftool.editor.tree.tumcnf.NodeUsedMMRoot;
import com.sap.ide.moftool.editor.tree.tumcnf.men.NodeUsedMMDCs;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;
import com.sap.tc.moin.repository.CRI;

/**
 * @author SAP AG
 * @generated modified
 */
public class TreeLabelProviderUsedMetamodelsTreeCNF extends MOFToolLabelProvider {

	/**
	 * @modified
	 */
	@Override
	public Image getImage(Object element) {

		if (element instanceof NodeUsedMMRoot) {
			element = "ATN_" + "tumcnf_UsedMMRoot"; //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (element instanceof NodeUsedMMDCs) {
			element = "ATN_" + "tumcnf_UsedMMDCs"; //$NON-NLS-1$ //$NON-NLS-2$
		}

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

		if (element instanceof NodeUsedMMRoot) {
			return LocalizationMessages.TreeLabelProviderUsedMetamodelsTreeCNF_0_XTND;

		}

		if (element instanceof NodeUsedMMDCs) {
			CRI container = ((NodeUsedMMDCs) element).getNodeContainer();
			return container.getContainerName();
		}

		if (element instanceof ITreeNodeRefObject) {
			return super.getText(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getText(element);
	}
}
