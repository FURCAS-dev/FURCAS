/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeLabelProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.moftool.editor.provider.MOFToolLabelProvider;
import com.sap.ide.moftool.editor.tree.LocalizationMessages;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

/**
 * @author SAP AG
 * @generated modified
 */
public class TreeLabelProviderTreeClassReferences extends MOFToolLabelProvider {

	/**
	 * @generated
	 */
	public Image getImage(Object element) {

		if (element instanceof ITreeNodeRefObject) {
			return super.getImage(((ITreeNodeRefObject<?>) element).getValue());
		}
		return super.getImage(element);
	}

	/**
	 * @modified
	 */
	public String getText(Object element) {
		
		if (element instanceof ITreeNodeRefObject) {			
			if (((ITreeNodeRefObject<?>) element).getValue() instanceof Reference) {
				Reference reference = (Reference)((ITreeNodeRefObject<?>) element).getValue();
				Namespace namespace = reference.getExposedEnd().getContainer();
				if (namespace instanceof Association) {
					return super.getText(((ITreeNodeRefObject<?>) element).getValue()) + " (" + LocalizationMessages.TreeLabelProviderTreeClassReferences_0_XMSG +" '" + namespace.getName() + "')"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				}
			}
		}
		return super.getText(element);
	}
}
