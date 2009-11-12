package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;

import com.sap.ide.moftool.editor.fwk.ModelSectionPart;

import com.sap.mi.fwk.ui.editor.ModelDetailsPage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import com.sap.ide.moftool.editor.gen.composites.OperationComposite;

import com.sap.ide.moftool.editor.gen.composites.OperationReturnParameterCompositeBase;

import com.sap.ide.moftool.editor.gen.composites.OperationExceptionComposite;

public class OperationsSection extends ModelSectionPart {

	private OperationComposite operationPropertiesComp = null;

	private OperationReturnParameterCompositeBase returnTypeComp = null;

	private OperationExceptionComposite exceptionsRaisedByTheOperationComp = null;

	public OperationsSection(Composite parent, IManagedForm managedForm) {
		super(parent, managedForm);

		Composite composite = managedForm.getToolkit().createComposite(getSection());
		TableWrapLayout layout = new TableWrapLayout();
		composite.setLayout(layout);
		getSection().setClient(composite);

		Section section = null;
		TableWrapData twdy = null;

		section = managedForm.getToolkit().createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(twdy);

		operationPropertiesComp = new com.sap.ide.moftool.editor.gen.composites.OperationComposite(section, managedForm
				.getToolkit(), Messages.OperationsSection_OperationProperties,
				Messages.OperationsSection_EditPropertiesOfTheOperation);
		operationPropertiesComp.createClient();

		section = managedForm.getToolkit().createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(twdy);

		returnTypeComp = new com.sap.ide.moftool.editor.composites.OperationReturnParameterComposite(section,
				managedForm.getToolkit(), Messages.OperationsSection_ReturnType, ""); //$NON-NLS-1$
		returnTypeComp.createClient();

		section = managedForm.getToolkit().createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(twdy);

		exceptionsRaisedByTheOperationComp = new com.sap.ide.moftool.editor.gen.composites.OperationExceptionComposite(
				section, managedForm.getToolkit(), Messages.OperationsSection_ExceptionsRaisedByTheOperation, ""); //$NON-NLS-1$
		exceptionsRaisedByTheOperationComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		operationPropertiesComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		operationPropertiesComp.dispose();
//
//		returnTypeComp.dispose();
//
//		exceptionsRaisedByTheOperationComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.Operation element = (com.sap.tc.moin.repository.mmi.model.Operation) getRefObject(input);

		operationPropertiesComp.setInput(element);

		returnTypeComp.setInput(element);

		exceptionsRaisedByTheOperationComp.setInput(element);

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
			OperationsSection part = new com.sap.ide.moftool.editor.gen.sections.OperationsSection(parent, managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
