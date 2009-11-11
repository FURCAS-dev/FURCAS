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

import com.sap.ide.moftool.editor.gen.composites.ReferenceCompositeBase;

import com.sap.ide.moftool.editor.gen.composites.AssociationEndComposite;

public abstract class ReferencesSectionBase extends ModelSectionPart {

	private ReferenceCompositeBase referencePropertiesComp = null;

	private AssociationEndComposite exposedEndComp = null;

	private AssociationEndComposite referencedEndComp = null;

	protected ReferencesSectionBase(Composite parent, IManagedForm managedForm) {
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

		referencePropertiesComp = new com.sap.ide.moftool.editor.composites.ReferenceComposite(section, managedForm
				.getToolkit(), Messages.ReferencesSection_ReferenceProperties,
				Messages.ReferencesSection_EditPropertiesOfTheReference);
		referencePropertiesComp.createClient();

		section = managedForm.getToolkit().createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(twdy);

		exposedEndComp = new com.sap.ide.moftool.editor.gen.composites.AssociationEndComposite(section, managedForm
				.getToolkit(), Messages.ReferencesSection_ExposedEnd,
				Messages.ReferencesSection_EditPropertiesOfTheExposedEnd);
		exposedEndComp.createClient();

		section = managedForm.getToolkit().createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(twdy);

		referencedEndComp = new com.sap.ide.moftool.editor.gen.composites.AssociationEndComposite(section, managedForm
				.getToolkit(), Messages.ReferencesSection_ReferencedEnd,
				Messages.ReferencesSection_EditPropertiesOfTheReferencedEnd);
		referencedEndComp.createClient();

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
//
//		exposedEndComp.dispose();
//
//		referencedEndComp.dispose();

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

		exposedEndComp.setInput(getInputForExposedEnd(element));

		referencedEndComp.setInput(getInputForReferencedEnd(element));

		return false;
	}

	protected abstract Object getInputForExposedEnd(com.sap.tc.moin.repository.mmi.model.Reference element);

	protected abstract Object getInputForReferencedEnd(com.sap.tc.moin.repository.mmi.model.Reference element);

	public static class DetailsPage extends ModelDetailsPage {

		public DetailsPage(IManagedForm managedForm) {
			super(managedForm);
		}

		@Override
		protected org.eclipse.ui.forms.SectionPart createDetailsPart(Composite parent, IManagedForm managedForm) {
			GridLayout layout = new GridLayout();
			parent.setLayout(layout);
			ReferencesSectionBase part = new com.sap.ide.moftool.editor.sections.ReferencesSection(parent, managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
