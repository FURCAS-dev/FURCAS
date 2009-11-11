package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ImportPropertySection {

	public static class ImportProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Import> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Import> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.ImportComposite(
					section, formToolkit, Messages.ImportSection_ImportProperties,
					Messages.ImportSection_EditPropertiesOfTheImport);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
