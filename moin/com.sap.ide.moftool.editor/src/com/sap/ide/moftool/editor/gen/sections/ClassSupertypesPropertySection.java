package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ClassSupertypesPropertySection {

	public static class ClassSupertypes extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofClass> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofClass> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.ClassSupertypesComposite(
					section, formToolkit, Messages.ClassSupertypesSection_ClassSupertypes,
					Messages.ClassSupertypesSection_EditTheSupertypesOfTheClass);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
