package com.sap.ide.moftool.editor.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.ConverterUtil;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.tc.moin.repository.Connection;

public class TaggedElementsSelectionDialog extends ListWidgetHelper {

	@Override
	protected ModelElement[] executeQuery(Connection con, RefBaseObject modelElement) {
		Collection<ModelElement> availableModelElements = MofService.getAvailableModelElements(con);		
		List<ModelElement> result = new ArrayList<ModelElement>();	
		String[] sa = null;
		for (ModelElement element : availableModelElements) {
			if (!(element instanceof Tag)) {				
				if (element.getQualifiedName()!= null) {
					sa = element.getQualifiedName().toArray(new String[0]);
					// exclude ocl artefacts and predefined types
					// TODO find a better way to exclude them
					if (sa[0].startsWith("OclGenerated")) {									 //$NON-NLS-1$
						continue;
					}
					if (sa[0].startsWith("PrimitiveTypes")) {									 //$NON-NLS-1$
						continue;
					}
					if (sa[0].startsWith("Reflect")) {									 //$NON-NLS-1$
						continue;
					}
				}
				result.add(element);

			}
		}		
		ModelElement[] array = result.toArray(new ModelElement[0]);
		return array;		
	}

	@Override
	protected String getMessage() {
		return LocalizationMessages.TaggedElementsSelectionDialog_0_XMSG;
	}

	@Override
	protected String getTitle() {
		return LocalizationMessages.TaggedElementsSelectionDialog_1_XGRP;
	}

	@Override
	public IConverter getToModelConverter(Connection con) {
		return new ConverterUtil.Model.Qn2ModelElement(con);
	}

}
