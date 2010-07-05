package com.sap.mi.textual.moinlookup.util;

import com.sap.furcas.metamodel.TCS.Template;
import com.sap.mi.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.common.interfaces.IRuleName;
import com.sap.mi.textual.moinlookup.MoinMetaLookup;
import com.sap.mi.textual.tcs.util.MetaModelElementResolutionHelper;

public class RuleNameFinder implements IRuleName {

	@Override
	public String getRuleName(Template tmpl, String mode) {
		TemplateNamingHelper<EObject> namingHelper = new TemplateNamingHelper<EObject>(
				new MetaModelElementResolutionHelper<EObject>(
						new MoinMetaLookup(tmpl.eResource().getResourceSet(), null)));
		try {
			return namingHelper.getRuleNameForMode(tmpl, mode);
		} catch (SyntaxElementException e) {
			// TODO do right stuff here
			System.err
					.println("Error in DelayedReferenceHelper Method getRuleName.");
		}
		return null;
	}

}
