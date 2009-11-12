package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.mi.fwk.ui.editor.ModelDetailsPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import com.sap.ide.moftool.editor.gen.composites.ExceptionComposite;

public class ExceptionsSection extends ModelSectionPart {

	private ExceptionComposite exceptionPropertiesComp = null;

	public ExceptionsSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		exceptionPropertiesComp = new com.sap.ide.moftool.editor.gen.composites.ExceptionComposite(getSection(),
				managedForm.getToolkit(), Messages.ExceptionsSection_ExceptionProperties,
				Messages.ExceptionsSection_EditPropertiesOfTheException);
		exceptionPropertiesComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		exceptionPropertiesComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		exceptionPropertiesComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.MofException element = (com.sap.tc.moin.repository.mmi.model.MofException) getRefObject(input);

		exceptionPropertiesComp.setInput(element);

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
			ExceptionsSection part = new com.sap.ide.moftool.editor.gen.sections.ExceptionsSection(parent, managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
