
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG:V0.1)
 *  (TreeLabelProviderClass_NEW.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.provider;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.moftool.editor.provider.MOFToolLabelProvider;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNodeRefObject;

/**
 * @author SAP AG
 * @generated 
 */
public class TreeLabelProviderTreeClassAttributes extends MOFToolLabelProvider {

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
	 * @generated
	 */
	public String getText(Object element) {
		String text = null;		
		if (element instanceof ITreeNodeRefObject) {
			Object value = ((ITreeNodeRefObject<?>)element).getValue();
			text = super.getText(value);
			if (value instanceof Attribute) {
				Classifier type = ((Attribute)value).getType();
				if (type != null) {
					text = text + " : " + type.getName(); //$NON-NLS-1$
				}
			}	
			return text;
		}
		return super.getText(element);

	}
}
