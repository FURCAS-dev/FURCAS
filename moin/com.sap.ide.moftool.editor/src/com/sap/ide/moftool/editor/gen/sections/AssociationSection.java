package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.mi.fwk.ui.editor.ModelDetailsPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import com.sap.ide.moftool.editor.gen.composites.AssociationComposite;

public class AssociationSection extends ModelSectionPart {

	private AssociationComposite associationPropertiesComp = null;

	public AssociationSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		associationPropertiesComp = new com.sap.ide.moftool.editor.gen.composites.AssociationComposite(getSection(),
				managedForm.getToolkit(), Messages.AssociationSection_AssociationProperties,
				Messages.AssociationSection_EditPropertiesOfTheAssociation);
		associationPropertiesComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		associationPropertiesComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		associationPropertiesComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.Association element = (com.sap.tc.moin.repository.mmi.model.Association) getRefObject(input);

		associationPropertiesComp.setInput(element);

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
			AssociationSection part = new com.sap.ide.moftool.editor.gen.sections.AssociationSection(parent,
					managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
