package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ReferencePropertiesPropertySection {

	public static class ReferenceProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Reference> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Reference> classDetailsComp = new com.sap.ide.moftool.editor.composites.ReferenceComposite(
					section, formToolkit, Messages.ReferencePropertiesSection_ReferenceProperties,
					Messages.ReferencePropertiesSection_EditPropertiesOfTheReference);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
