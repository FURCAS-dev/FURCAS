package com.sap.furcas.parsergenerator.emf.lookup;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IRuleName;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

public class RuleNameFinder implements IRuleName {

    @Override
    public String getRuleName(Template template, String mode) throws SyntaxElementException {
        TemplateNamingHelper<EObject> namingHelper = new TemplateNamingHelper<EObject>(
                new MetaModelElementResolutionHelper<EObject>(new QueryBasedEcoreMetaModelLookUp(template.eResource().getResourceSet())));
        return namingHelper.getRuleNameForMode(template, mode);
    }

}
