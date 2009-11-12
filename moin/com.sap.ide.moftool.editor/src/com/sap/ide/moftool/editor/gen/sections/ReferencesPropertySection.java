package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ReferencesPropertySection {

	public static class ReferenceProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Reference> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Reference> classDetailsComp = new com.sap.ide.moftool.editor.composites.ReferenceComposite(
					section, formToolkit, Messages.ReferencesSection_ReferenceProperties,
					Messages.ReferencesSection_EditPropertiesOfTheReference);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

	public static class ExposedEnd extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.AssociationEnd> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.AssociationEnd> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.AssociationEndComposite(
					section, formToolkit, Messages.ReferencesSection_ExposedEnd,
					Messages.ReferencesSection_EditPropertiesOfTheExposedEnd);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

	public static class ReferencedEnd extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.AssociationEnd> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.AssociationEnd> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.AssociationEndComposite(
					section, formToolkit, Messages.ReferencesSection_ReferencedEnd,
					Messages.ReferencesSection_EditPropertiesOfTheReferencedEnd);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
