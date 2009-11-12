package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ParametersPropertySection {

	public static class ParameterDetails extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Parameter> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Parameter> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.OperationParameterComposite(
					section, formToolkit, Messages.ParametersSection_ParameterDetails,
					Messages.ParametersSection_EditThePropertiesOfTheParameter);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
