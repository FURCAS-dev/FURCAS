package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class AssociationPropertySection {

	public static class AssociationProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Association> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Association> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.AssociationComposite(
					section, formToolkit, Messages.AssociationSection_AssociationProperties,
					Messages.AssociationSection_EditPropertiesOfTheAssociation);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
