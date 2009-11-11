package com.sap.ide.moftool.editor.sections;

import com.sap.tc.moin.repository.mmi.model.Reference;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.gen.sections.ReferencesSectionBase;

public class ReferencesSection extends ReferencesSectionBase {

	public ReferencesSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);
	}

	@Override
	protected Object getInputForExposedEnd(Reference element) {
		return element.getExposedEnd();
	}

	@Override
	protected Object getInputForReferencedEnd(Reference element) {
		return element.getReferencedEnd();
	}

}
