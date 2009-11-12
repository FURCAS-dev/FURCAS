package com.sap.ide.moftool.editor.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.fwk.ConverterUtil;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.tc.moin.repository.Connection;

public class ConstraintElementsSelectionDialog extends ListWidgetHelper {

	@Override
	protected ModelElement[] executeQuery(Connection con, RefBaseObject modelElement) {		
		Namespace parent = ((ModelElement)modelElement).getContainer();		
		if (parent instanceof MofClass) {			
			// Show the class itself and its inner data types, no further objects allowed
			Collection<Classifier> availableClassifiers = MofService.getAvailableClassifiers(con);
			List<ModelElement> result = new ArrayList<ModelElement>();
			for (Classifier classifier : availableClassifiers) {
				if ((classifier instanceof MofClass)||(classifier instanceof DataType)) {
					if ((parent.equals(classifier))||(parent.equals(classifier.getContainer()))) {
						result.add(classifier);
					}
				}
			}			
			ModelElement[] array = result.toArray(new ModelElement[0]);
			return array;	
		}
		else if (parent instanceof MofPackage) {
			// Show the contained classes, data types and associations of the package			
			Collection<Classifier> availableClassifiers = MofService.getAvailableClassifiers(con);
			List<ModelElement> result = new ArrayList<ModelElement>();
			for (Classifier classifier : availableClassifiers) {
				if (isAncestor(parent, classifier)) {
					result.add(classifier);
				}
			}			
			ModelElement[] array = result.toArray(new ModelElement[0]);
			return array;	
		}
		else if (parent instanceof Association || parent instanceof DataType) {
			// show only the parent itself
			List<ModelElement> result = new ArrayList<ModelElement>();
			result.add(parent);
			ModelElement[] array = result.toArray(new ModelElement[0]);
			return array;				
		}
		else { 
			// Show all elements that are defined or inherited by the container of the constraint
			// including the container (C-51)
			// Tags, Constraints, Imports and Constants cannot be constrained (C-50)
			// TODO: offer only the parent ?
		}
		return null;
	}

	@Override
	protected String getMessage() {
		return LocalizationMessages.ConstraintElementsSelectionDialog_0_XMSG;
	}

	@Override
	protected String getTitle() {		
		return LocalizationMessages.ConstraintElementsSelectionDialog_1_XGRP;
	}

	@Override
	public IConverter getToModelConverter(Connection con) {
		return new ConverterUtil.Model.Qn2ModelElement(con);
	}
	
	private boolean isAncestor(ModelElement parent, ModelElement element) {
		if (parent.equals(element)) {
			return true;
		} else if (element.getContainer() != null) {
			return isAncestor(parent, element.getContainer());
		} else {
			return false;
		}
	}

}
