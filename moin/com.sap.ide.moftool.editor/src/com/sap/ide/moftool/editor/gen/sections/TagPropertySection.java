package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class TagPropertySection {

	public static class TagProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Tag> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Tag> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.TagComposite(
					section, formToolkit, Messages.TagSection_TagProperties, Messages.TagSection_EditPropertiesOfTheTag);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

	public static class TagValues extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Tag> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Tag> classDetailsComp = new com.sap.ide.moftool.editor.composites.TagValuesComposite(
					section, formToolkit, Messages.TagSection_TagValues, Messages.TagSection_EditValuesOfTheTag);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

	public static class TaggedElements extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Tag> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Tag> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.TaggedElementsComposite(
					section, formToolkit, Messages.TagSection_TaggedElements, ""); //$NON-NLS-1$ 
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
