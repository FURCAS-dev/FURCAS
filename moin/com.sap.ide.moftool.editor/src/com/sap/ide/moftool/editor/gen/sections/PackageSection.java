package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.ide.moftool.editor.gen.composites.PackageComposite;

public class PackageSection extends ModelSectionPart {

	private PackageComposite packageComp = null;

	public PackageSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		packageComp = new com.sap.ide.moftool.editor.gen.composites.PackageComposite(getSection(), managedForm
				.getToolkit(), Messages.PackageSection_Package, Messages.PackageSection_EditPropertiesOfThePackage);
		packageComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		packageComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		packageComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.MofPackage element = (com.sap.tc.moin.repository.mmi.model.MofPackage) getRefObject(input);

		packageComp.setInput(element);

		return false;
	}

}
