package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class EnumLabelPropertySection {

	public static class EnumerationTypeLabels extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.EnumerationType> createContentsInternal(
				FormToolkit formToolkit, Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.EnumerationType> classDetailsComp = new com.sap.ide.moftool.editor.composites.EnumLabelComposite(
					section, formToolkit, Messages.EnumLabelSection_EnumerationTypeLabels,
					Messages.EnumLabelSection_EditLabelsOfTheEnumerationType);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
