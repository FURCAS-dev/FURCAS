



/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
  * (MITG:V0.1)
 *  (FilterClass_CANONIC.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.prop.filt.mm;

import com.sap.tc.moin.repository.mmi.model.EnumerationType; 
// import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import org.eclipse.jface.viewers.IFilter;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
/***
 * @author Schubert/Forstmann
 */
public class FilterMM_EnumerationType implements IFilter {

	protected boolean accept(RefObject obj) {
		
		if (obj instanceof EnumerationType) 
			return true;
		return false;
	}

	final public boolean select(Object object) {
		RefObject obj = MOFToolEditorPlugin.getBusinessRefObject(object);
		return accept(obj); 
	}
}

