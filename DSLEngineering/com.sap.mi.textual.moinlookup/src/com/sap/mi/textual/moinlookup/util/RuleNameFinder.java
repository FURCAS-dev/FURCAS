package com.sap.mi.textual.moinlookup.util;

import tcs.Template;

import com.sap.mi.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.common.interfaces.IRuleName;
import com.sap.mi.textual.moinlookup.MoinMetaLookup;
import com.sap.mi.textual.tcs.util.MetaModelElementResolutionHelper;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class RuleNameFinder implements IRuleName {

	@Override
	public String getRuleName(Template tmpl, String mode) {
		TemplateNamingHelper<RefObject> namingHelper = new TemplateNamingHelper<RefObject>(
				new MetaModelElementResolutionHelper<RefObject>(
						new MoinMetaLookup(tmpl.get___Connection(), null)));
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
