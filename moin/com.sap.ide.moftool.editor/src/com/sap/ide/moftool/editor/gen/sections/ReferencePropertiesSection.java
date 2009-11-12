package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.mi.fwk.ui.editor.ModelDetailsPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import com.sap.ide.moftool.editor.gen.composites.ReferenceCompositeBase;

public class ReferencePropertiesSection extends ModelSectionPart {

	private ReferenceCompositeBase referencePropertiesComp = null;

	public ReferencePropertiesSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		referencePropertiesComp = new com.sap.ide.moftool.editor.composites.ReferenceComposite(getSection(),
				managedForm.getToolkit(), Messages.ReferencePropertiesSection_ReferenceProperties,
				Messages.ReferencePropertiesSection_EditPropertiesOfTheReference);
		referencePropertiesComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		referencePropertiesComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		referencePropertiesComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.Reference element = (com.sap.tc.moin.repository.mmi.model.Reference) getRefObject(input);

		referencePropertiesComp.setInput(element);

		return false;
	}

	public static class DetailsPage extends ModelDetailsPage {

		public DetailsPage(IManagedForm managedForm) {
			super(managedForm);
		}

		@Override
		protected org.eclipse.ui.forms.SectionPart createDetailsPart(Composite parent, IManagedForm managedForm) {
			GridLayout layout = new GridLayout();
			parent.setLayout(layout);
			ReferencePropertiesSection part = new com.sap.ide.moftool.editor.gen.sections.ReferencePropertiesSection(
					parent, managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
