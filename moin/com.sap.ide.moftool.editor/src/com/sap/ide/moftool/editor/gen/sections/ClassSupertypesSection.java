package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.ide.moftool.editor.gen.composites.ClassSupertypesComposite;

public class ClassSupertypesSection extends ModelSectionPart {

	private ClassSupertypesComposite classSupertypesComp = null;

	public ClassSupertypesSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		classSupertypesComp = new com.sap.ide.moftool.editor.gen.composites.ClassSupertypesComposite(getSection(),
				managedForm.getToolkit(), Messages.ClassSupertypesSection_ClassSupertypes,
				Messages.ClassSupertypesSection_EditTheSupertypesOfTheClass);
		classSupertypesComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		classSupertypesComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		classSupertypesComp.dispose();

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

		classSupertypesComp.setInput(element);

		return false;
	}

}
