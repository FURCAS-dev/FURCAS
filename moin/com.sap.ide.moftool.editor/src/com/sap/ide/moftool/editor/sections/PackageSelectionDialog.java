package com.sap.ide.moftool.editor.sections;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.ConverterUtil;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.tc.moin.repository.Connection;

public class PackageSelectionDialog extends ListWidgetHelper {
	@Override
	protected ModelElement[] executeQuery(Connection con, RefBaseObject modelElement) {
		Collection<? extends ModelElement> packages = MofService.getAvailablePackages(con);
		return packages.toArray(new ModelElement[0]);
	}

	@Override
	protected String getMessage() {
		return LocalizationMessages.PackageSelectionDialog_0_XMSG;
	}

	@Override
	protected String getTitle() {
		return LocalizationMessages.PackageSelectionDialog_1_XGRP;
	}

	@Override
	public IConverter getToModelConverter(Connection con) {
		return new ConverterUtil.Model.Qn2Classifier(con);
	}
}
