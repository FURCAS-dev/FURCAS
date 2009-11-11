
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeLabelProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.ide.moftool.editor.provider.MOFToolLabelProvider;
import com.sap.ide.moftool.editor.tree.LocalizationMessages;
import com.sap.ide.moftool.editor.tree.tcnf.NodeMofRoot;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfAssocContainer;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

/**
 * @author SAP AG
 * @generated 
 */
public class TreeLabelProviderMofTreeCNF extends MOFToolLabelProvider {

	/**
	 * @generated
	 */
	public Image getImage(Object element) {

		if (element instanceof NodeMofRoot) {
			return super.getImage("ATN_" + "tcnf_MofRoot"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if (element instanceof NodeCnfAssocContainer) {
			return super.getImage(MOFToolEditorPlugin.ATN_tcnf_AssocContainer);
		}

		if (element instanceof ITreeNodeRefObject) {
			return super.getImage(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {

		if (element instanceof NodeMofRoot) {
			return LocalizationMessages.TreeLabelProviderMofTreeCNF_0_XTND;

		}
		
		if (element instanceof NodeCnfAssocContainer) {
			return LocalizationMessages.TreeLabelProviderMofTreeCNF_1_XTND;
		}
		

		if (element instanceof ITreeNodeRefObject) {
			return super.getText(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getText(element);
	}
}
