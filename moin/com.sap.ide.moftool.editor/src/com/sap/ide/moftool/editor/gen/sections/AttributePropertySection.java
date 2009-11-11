package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class AttributePropertySection {

	public static class AttributeDetails extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Attribute> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Attribute> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.AttributeComposite(
					section, formToolkit, Messages.AttributeSection_AttributeDetails,
					Messages.AttributeSection_EditTheDetailsOfTheAttribute);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
