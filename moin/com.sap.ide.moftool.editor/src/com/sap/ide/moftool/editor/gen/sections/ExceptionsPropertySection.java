package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ExceptionsPropertySection {

	public static class ExceptionProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofException> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofException> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.ExceptionComposite(
					section, formToolkit, Messages.ExceptionsSection_ExceptionProperties,
					Messages.ExceptionsSection_EditPropertiesOfTheException);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
