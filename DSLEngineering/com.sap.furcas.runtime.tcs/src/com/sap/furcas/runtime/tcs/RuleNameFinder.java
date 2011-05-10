package com.sap.furcas.runtime.tcs;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.modeladaptation.emf.lookup.FileResourceHelper;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IRuleName;

public class RuleNameFinder implements IRuleName {

    @Override
    public String getRuleName(Template template, String mode) throws SyntaxElementException {
        TemplateNamingHelper<EObject> namingHelper = new TemplateNamingHelper<EObject>(
                new MetaModelElementResolutionHelper<EObject>(new QueryBasedEcoreMetaModelLookUp(
                        template.eResource().getResourceSet(),
                        FileResourceHelper.getResourceSetAsScope(template.eResource().getResourceSet()))));
        
        if (template instanceof ClassTemplate && ((ClassTemplate) template).getMode() != null) {
            mode = ((ClassTemplate) template).getMode();
        }
        return namingHelper.getRuleNameForMode(template, mode);
    }

}
