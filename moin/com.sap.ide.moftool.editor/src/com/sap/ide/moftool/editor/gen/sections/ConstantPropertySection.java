package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ConstantPropertySection {

	public static class ConstantProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Constant> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Constant> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.ConstantComposite(
					section, formToolkit, Messages.ConstantSection_ConstantProperties,
					Messages.ConstantSection_EditPropertiesOfTheConstant);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
