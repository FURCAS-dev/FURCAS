package com.sap.ide.moftool.editor.sections;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.ConverterUtil;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.tc.moin.repository.Connection;

public class ConstraintSelectionDialog extends ListWidgetHelper {

	@Override
	protected ModelElement[] executeQuery(Connection con, RefBaseObject modelElement) {
		return MofService.getAvailableConstraints(con).toArray(new Constraint[0]);
	}

	@Override
	public IConverter getToModelConverter(Connection con) {
		return new ConverterUtil.Model.Qn2Constraint(con);
	}

	@Override
	protected String getTitle() {
		return LocalizationMessages.ConstraintSelectionDialog_0_XGRP;
	}

	@Override
	protected String getMessage() {
		return LocalizationMessages.ConstraintSelectionDialog_1_XMSG;
	}

}
