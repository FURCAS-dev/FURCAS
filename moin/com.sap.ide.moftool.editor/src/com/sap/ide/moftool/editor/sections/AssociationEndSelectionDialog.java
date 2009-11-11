package com.sap.ide.moftool.editor.sections;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.ConverterUtil;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.tc.moin.repository.Connection;

public class AssociationEndSelectionDialog extends ListWidgetHelper {

	@Override
	protected ModelElement[] executeQuery(Connection con, RefBaseObject modelElement) {
		Collection<MofClass> classes = MofService.getAvailableClasses(con);
		return classes.toArray(new ModelElement[0]);
	}

	@Override
	protected String getMessage() {
		return LocalizationMessages.AssociationEndSelectionDialog_0_XMSG;
	}

	@Override
	protected String getTitle() {
		return LocalizationMessages.AssociationEndSelectionDialog_1_XGRP;
	}

	@Override
	public IConverter getToModelConverter(Connection con) {
		return new ConverterUtil.Model.Qn2Classifier(con);
	}

}
