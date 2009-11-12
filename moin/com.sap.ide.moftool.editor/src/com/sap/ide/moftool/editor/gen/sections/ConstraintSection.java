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

import com.sap.ide.moftool.editor.gen.composites.ConstraintComposite;

import com.sap.ide.moftool.editor.gen.composites.ConstraintElementsComposite;

public class ConstraintSection extends ModelSectionPart {

	private ConstraintComposite constraintPropertiesComp = null;

	private ConstraintElementsComposite constrainedElementsComp = null;

	public ConstraintSection(Composite parent, IManagedForm managedForm) {
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

		constraintPropertiesComp = new com.sap.ide.moftool.editor.gen.composites.ConstraintComposite(section,
				managedForm.getToolkit(), Messages.ConstraintSection_ConstraintProperties,
				Messages.ConstraintSection_EditPropertiesOfTheConstraint);
		constraintPropertiesComp.createClient();

		section = managedForm.getToolkit().createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(twdy);

		constrainedElementsComp = new com.sap.ide.moftool.editor.gen.composites.ConstraintElementsComposite(section,
				managedForm.getToolkit(), Messages.ConstraintSection_ConstrainedElements,
				Messages.ConstraintSection_SelectTheElementsAffectedByThisConstraint);
		constrainedElementsComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		constraintPropertiesComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		constraintPropertiesComp.dispose();

//		constrainedElementsComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.Constraint element = (com.sap.tc.moin.repository.mmi.model.Constraint) getRefObject(input);

		constraintPropertiesComp.setInput(element);

		constrainedElementsComp.setInput(element);

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
			ConstraintSection part = new com.sap.ide.moftool.editor.gen.sections.ConstraintSection(parent, managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
