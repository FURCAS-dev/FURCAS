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

import com.sap.ide.moftool.editor.gen.composites.TagComposite;

import com.sap.ide.moftool.editor.gen.composites.TagValuesCompositeBase;

import com.sap.ide.moftool.editor.gen.composites.TaggedElementsComposite;

public class TagSection extends ModelSectionPart {

	private TagComposite tagPropertiesComp = null;

	private TagValuesCompositeBase tagValuesComp = null;

	private TaggedElementsComposite taggedElementsComp = null;

	public TagSection(Composite parent, IManagedForm managedForm) {
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

		tagPropertiesComp = new com.sap.ide.moftool.editor.gen.composites.TagComposite(section, managedForm
				.getToolkit(), Messages.TagSection_TagProperties, Messages.TagSection_EditPropertiesOfTheTag);
		tagPropertiesComp.createClient();

		section = managedForm.getToolkit().createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(twdy);

		tagValuesComp = new com.sap.ide.moftool.editor.composites.TagValuesComposite(section, managedForm.getToolkit(),
				Messages.TagSection_TagValues, Messages.TagSection_EditValuesOfTheTag);
		tagValuesComp.createClient();

		section = managedForm.getToolkit().createSection(composite,
				Section.TITLE_BAR | Section.EXPANDED | Section.TWISTIE);
		twdy = new TableWrapData(TableWrapData.FILL_GRAB);
		section.setLayoutData(twdy);

		taggedElementsComp = new com.sap.ide.moftool.editor.gen.composites.TaggedElementsComposite(section, managedForm
				.getToolkit(), Messages.TagSection_TaggedElements, ""); //$NON-NLS-1$
		taggedElementsComp.createClient();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.SectionPart#setFocus()
	 */
	@Override
	public void setFocus() {

		tagPropertiesComp.setFocus();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#dispose()
	 */
	@Override
	public void dispose() {

//		tagPropertiesComp.dispose();
//
//		tagValuesComp.dispose();
//
//		taggedElementsComp.dispose();

		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {
		com.sap.tc.moin.repository.mmi.model.Tag element = (com.sap.tc.moin.repository.mmi.model.Tag) getRefObject(input);

		tagPropertiesComp.setInput(element);

		tagValuesComp.setInput(element);

		taggedElementsComp.setInput(element);

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
			TagSection part = new com.sap.ide.moftool.editor.gen.sections.TagSection(parent, managedForm);
			part.getSection().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			return part;
		}
	}

}
