package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class DataTypesPropertySection {

	public static class DataTypeProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.DataType> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.DataType> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.DataTypeComposite(
					section, formToolkit, Messages.DataTypesSection_DataTypeProperties,
					Messages.DataTypesSection_EditPropertiesOfTheDataType);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
