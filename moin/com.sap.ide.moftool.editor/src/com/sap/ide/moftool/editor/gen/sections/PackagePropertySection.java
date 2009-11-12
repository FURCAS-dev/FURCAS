package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class PackagePropertySection {

	public static class Package extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofPackage> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.MofPackage> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.PackageComposite(
					section, formToolkit, Messages.PackageSection_Package,
					Messages.PackageSection_EditPropertiesOfThePackage);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
