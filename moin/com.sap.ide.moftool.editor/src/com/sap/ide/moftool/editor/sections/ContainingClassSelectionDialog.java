package com.sap.ide.moftool.editor.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.ide.moftool.editor.fwk.ConverterUtil;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;

public class ContainingClassSelectionDialog extends ListWidgetHelper {

	@Override
	protected ModelElement[] executeQuery(Connection con, RefBaseObject modelElement) {
		// The containing class can be either the one of the association end itself
		// or one of its direct or indirect subtypes
		// All allowed objects currently have to be stored in the currently edited project
		// not in any of the referenced projects. This check is done by comparing the
		// containername of the found object with the one of the currently edited project
		// that was retrieved above
		if (modelElement instanceof MofClass) {
			MofClass referencingClass = (MofClass) modelElement;
			
			List<MofClass> containingClasses = new ArrayList<MofClass>();
			ClassService.addRecursivelyAllSubClasses(referencingClass, containingClasses);
			return containingClasses.toArray(new ModelElement[0]);
			
//			String currentContainerName = ModelAdapter.getInstance().getContainerUsingConnection(referencingClass).getContainerName();
//			if (currentContainerName == null) {
//				return new ModelElement[0];
//			}
//
//			Collection<MofClass> classes = MofService.getAvailableClasses(con);
//			Collection<ModelElement> containingClasses = new ArrayList<ModelElement>();
//			for (MofClass mofClass : classes) {
//				String containerName = ModelAdapter.getInstance().getContainerUsingConnection(mofClass).getContainerName();
//				if (currentContainerName.equals(containerName)) {
//					containingClasses.add(mofClass);
//				}
//			}
//			return containingClasses.toArray(new ModelElement[0]);
		}
		return new ModelElement[0];
	}

	@Override
	public IConverter getToModelConverter(Connection con) {
		return new ConverterUtil.Model.Qn2Classifier(con);
	}

	@Override
	protected String getMessage() {
		return LocalizationMessages.ContainingClassSelectionDialog_0_XMSG;
	}

	@Override
	protected String getTitle() {
		return LocalizationMessages.ContainingClassSelectionDialog_1_XGRP;
	}

}
