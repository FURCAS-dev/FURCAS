package com.sap.tc.moin.incubation.mm.internal.creation;

import org.eclipse.pde.ui.templates.ITemplateSection;
import org.eclipse.pde.ui.templates.NewPluginTemplateWizard;

public final class MmTemplateWizard extends NewPluginTemplateWizard {

	@Override
	public ITemplateSection[] createTemplateSections() {
		return new ITemplateSection[] { new MmTemplateSection() };
	}

}
