package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class StructureFieldPropertySection {

	public static class StructureField extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.StructureField> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.StructureField> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.StructureFieldComposite(
					section, formToolkit, Messages.StructureFieldSection_StructureField,
					Messages.StructureFieldSection_EditFieldsOfTheStructureField);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
