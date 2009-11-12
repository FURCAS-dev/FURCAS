package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.ide.moftool.editor.gen.composites.EnumLabelCompositeBase;

public class EnumLabelSection extends ModelSectionPart {

	private EnumLabelCompositeBase enumerationTypeLabelsComp = null;

	public EnumLabelSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		enumerationTypeLabelsComp = new com.sap.ide.moftool.editor.composites.EnumLabelComposite(getSection(),
				managedForm.getToolkit(), Messages.EnumLabelSection_EnumerationTypeLabels,
				Messages.EnumLabelSection_EditLabelsOfTheEnumerationType);
		enumerationTypeLabelsComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		enumerationTypeLabelsComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		enumerationTypeLabelsComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.EnumerationType element = (com.sap.tc.moin.repository.mmi.model.EnumerationType) getRefObject(input);

		enumerationTypeLabelsComp.setInput(element);

		return false;
	}

}
