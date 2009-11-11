package com.sap.ide.moftool.editor.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.ConverterUtil;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.tc.moin.repository.Connection;

public class TypeSelectionDialog extends ListWidgetHelper {

	@Override
	protected ModelElement[] executeQuery(Connection con, RefBaseObject modelElement) {	
//		Collection<? extends RefObject> availableClasses = MofService.getAvailableClasses(con);
//		List<ModelElement> result = new ArrayList<ModelElement>();
//		for (MofClass mofClass : availableClasses) {
//			if (!modelElement.equals(mofClass)) {
//				result.add(mofClass);
//			}
//		}
//		ModelElement[] array = result.toArray(new ModelElement[0]);
		Collection<MofClass> availableMofClasses = MofService.getAvailableClasses(con);
		availableMofClasses.remove(modelElement);
		ModelElement[] array = availableMofClasses.toArray(new ModelElement[0]);
		return array;		
	}

	@Override
	protected String getMessage() {		
		return LocalizationMessages.TypeSelectionDialog_0_XMSG;
	}

	@Override
	protected String getTitle() {		
		return LocalizationMessages.TypeSelectionDialog_1_XGRP;
	}

	@Override
	public IConverter getToModelConverter(Connection con) {		
		return new ConverterUtil.Model.Qn2Classifier(con);
	}

}
