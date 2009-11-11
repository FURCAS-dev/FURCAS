package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.mi.fwk.ui.editor.ModelDetailsPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import com.sap.ide.moftool.editor.gen.composites.StructureFieldComposite;

public class StructureFieldSection extends ModelSectionPart {

	private StructureFieldComposite structureFieldComp = null;

	public StructureFieldSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		structureFieldComp = new com.sap.ide.moftool.editor.gen.composites.StructureFieldComposite(getSection(),
				managedForm.getToolkit(), Messages.StructureFieldSection_StructureField,
				Messages.StructureFieldSection_EditFieldsOfTheStructureField);
		structureFieldComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		structureFieldComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		structureFieldComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.StructureField element = (com.sap.tc.moin.repository.mmi.model.StructureField) getRefObject(input);

		structureFieldComp.setInput(element);

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
			StructureFieldSection part = new com.sap.ide.moftool.editor.gen.sections.StructureFieldSection(parent,
					managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
