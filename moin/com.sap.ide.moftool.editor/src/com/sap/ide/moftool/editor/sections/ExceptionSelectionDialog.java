package com.sap.ide.moftool.editor.sections;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.ConverterUtil;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.tc.moin.repository.Connection;

public class ExceptionSelectionDialog extends ListWidgetHelper {

	@Override
	protected ModelElement[] executeQuery(Connection con, RefBaseObject modelElement) {		
		Collection<MofException> availableMofExceptions = MofService.getAvailableMofExceptions(con);
		ModelElement[] array = availableMofExceptions.toArray(new ModelElement[0]);
		return array;	
		
	}

	@Override
	protected String getMessage() {		
		return LocalizationMessages.ExceptionSelectionDialog_0_XMSG;		
	}

	@Override
	protected String getTitle() {			
		return LocalizationMessages.ExceptionSelectionDialog_1_XGRP;
	}

	@Override
	public IConverter getToModelConverter(Connection con) {
		return new ConverterUtil.Model.Qn2Exception(con);
	}

}
