package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.mi.fwk.ui.editor.ModelDetailsPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import com.sap.ide.moftool.editor.gen.composites.AssociationEndComposite;

public class AssociationEndSection extends ModelSectionPart {

	private AssociationEndComposite associationEndPropertiesComp = null;

	public AssociationEndSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		associationEndPropertiesComp = new com.sap.ide.moftool.editor.gen.composites.AssociationEndComposite(
				getSection(), managedForm.getToolkit(), Messages.AssociationEndSection_AssociationEndProperties,
				Messages.AssociationEndSection_EditPropertiesOfTheAssociationEnd);
		associationEndPropertiesComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		associationEndPropertiesComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		associationEndPropertiesComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.AssociationEnd element = (com.sap.tc.moin.repository.mmi.model.AssociationEnd) getRefObject(input);

		associationEndPropertiesComp.setInput(element);

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
			AssociationEndSection part = new com.sap.ide.moftool.editor.gen.sections.AssociationEndSection(parent,
					managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
