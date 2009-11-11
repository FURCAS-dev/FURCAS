package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.mi.fwk.ui.editor.ModelDetailsPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import com.sap.ide.moftool.editor.gen.composites.OperationParameterComposite;

public class ParametersSection extends ModelSectionPart {

	private OperationParameterComposite parameterDetailsComp = null;

	public ParametersSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		parameterDetailsComp = new com.sap.ide.moftool.editor.gen.composites.OperationParameterComposite(getSection(),
				managedForm.getToolkit(), Messages.ParametersSection_ParameterDetails,
				Messages.ParametersSection_EditThePropertiesOfTheParameter);
		parameterDetailsComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		parameterDetailsComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		parameterDetailsComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.Parameter element = (com.sap.tc.moin.repository.mmi.model.Parameter) getRefObject(input);

		parameterDetailsComp.setInput(element);

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
			ParametersSection part = new com.sap.ide.moftool.editor.gen.sections.ParametersSection(parent, managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
