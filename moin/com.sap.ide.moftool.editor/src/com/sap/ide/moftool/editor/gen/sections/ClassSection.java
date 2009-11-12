package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.ide.moftool.editor.gen.composites.ClassComposite;

public class ClassSection extends ModelSectionPart {

	private ClassComposite classDetailsComp = null;

	public ClassSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.ClassComposite(getSection(), managedForm
				.getToolkit(), Messages.ClassSection_ClassDetails, Messages.ClassSection_EditTheDetailsOfTheClass);
		classDetailsComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		classDetailsComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		classDetailsComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.MofClass element = (com.sap.tc.moin.repository.mmi.model.MofClass) getRefObject(input);

		classDetailsComp.setInput(element);

		return false;
	}

}
