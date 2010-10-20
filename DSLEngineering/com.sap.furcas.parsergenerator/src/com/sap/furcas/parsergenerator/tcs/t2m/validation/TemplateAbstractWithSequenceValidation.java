/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-08-28 16:28:55 +0200 (Do, 28 Aug 2008) $
 * @version $Revision: 1625 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.validation;

import java.util.Collection;
import java.util.Iterator;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.SemanticErrorBucket;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;



/**
 * The Class UniquenessValidation.
 */
public class TemplateAbstractWithSequenceValidation implements ISyntaxValidationRule {

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.tcs.t2m.validation.ISyntaxValidationRule#validate(TCS.ConcreteSyntax)
     */
    @Override
    public void validate(ConcreteSyntax syntax, IMetaModelLookup metaLookup, SemanticErrorBucket errorBucket) {
        Collection<Template> templates = syntax.getTemplates();
        MetaModelElementResolutionHelper<?> resolutionHelper = new MetaModelElementResolutionHelper(metaLookup);  
        for (Iterator<Template> iterator = templates.iterator(); iterator.hasNext();) {
            Template template = iterator.next();
            if ( template.getMetaReference() != null ||  (template.getNames() != null ) ) {


                if (template instanceof ClassTemplate) {
                    ClassTemplate ct = (ClassTemplate) template;
                    ResolvedNameAndReferenceBean resolutionBean;
                    try {
                        resolutionBean = resolutionHelper.resolve(template);
                        if (resolutionBean != null && metaLookup.isAbstract(resolutionBean) && ct.getTemplateSequence() != null) {
                            // TODO allow for templates which serve to locate references only
//                            errorBucket.addError("Abstract ModelElement "+resolutionBean.getNames()+" modeled by Classtemplates with method body.", ct.getTemplateSequence());
                        }
                    } catch (NameResolutionFailedException e) {
                      // ignore
                    } catch (MetaModelLookupException e) {
                     // ignore
                    }                }
            }
        }
    }
}
