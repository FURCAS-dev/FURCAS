package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ClassPropertySection {

	public static class ClassDetails extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofClass> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofClass> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.ClassComposite(
					section, formToolkit, Messages.ClassSection_ClassDetails,
					Messages.ClassSection_EditTheDetailsOfTheClass);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
