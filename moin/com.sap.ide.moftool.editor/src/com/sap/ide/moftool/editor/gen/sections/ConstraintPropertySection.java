package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class ConstraintPropertySection {

	public static class ConstraintProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Constraint> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Constraint> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.ConstraintComposite(
					section, formToolkit, Messages.ConstraintSection_ConstraintProperties,
					Messages.ConstraintSection_EditPropertiesOfTheConstraint);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

	public static class ConstrainedElements extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Constraint> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Constraint> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.ConstraintElementsComposite(
					section, formToolkit, Messages.ConstraintSection_ConstrainedElements,
					Messages.ConstraintSection_SelectTheElementsAffectedByThisConstraint);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
