package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class AssociationEndPropertySection {

	public static class AssociationEndProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.AssociationEnd> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.AssociationEnd> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.AssociationEndComposite(
					section, formToolkit, Messages.AssociationEndSection_AssociationEndProperties,
					Messages.AssociationEndSection_EditPropertiesOfTheAssociationEnd);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
