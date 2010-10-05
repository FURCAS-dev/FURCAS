/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-05-20 15:12:26 +0200 (Do, 20 Mai 2010) $
 * @version $Revision: 9718 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.TCS.Operator;
import com.sap.furcas.metamodel.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.textual.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.furcas.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.textual.tcs.MetaModelElementResolutionHelper;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.SemanticErrorBucket;



/**
 * The Class UniquenessValidation.
 */
public class TemplateNameValidation implements ISyntaxValidationRule {

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.tcs.t2m.validation.ISyntaxValidationRule#validate(TCS.ConcreteSyntax)
     */
    public void validate(ConcreteSyntax syntax, IMetaModelLookup<?> metaLookup, SemanticErrorBucket errorBucket) {
        Set<Collection<String>> names = new HashSet<Collection<String>>();
        Collection<Template> templates = syntax.getTemplates();
        MetaModelElementResolutionHelper resolutionHelper = new MetaModelElementResolutionHelper(metaLookup);  
        for (Iterator<Template> iterator = templates.iterator(); iterator.hasNext();) {
            Template template = (Template) iterator.next();
            if ( template.getMetaReference() == null 
                    &&  (template.getNames() == null ||  template.getNames().size() == 0) ) {
                errorBucket.addError("Template has null or empty name reference.", template);
            } else {
                if (! (template instanceof PrimitiveTemplate) && !(template instanceof FunctionTemplate) ) { // Primitive and function Templates may reference a datatype more than once

                    ResolvedNameAndReferenceBean resolutionBean;
                    List<String> templatename;
                    try {
                        resolutionBean = resolutionHelper.resolve(template);
                        templatename = resolutionBean.getNames();
                    } catch (NameResolutionFailedException e) {
                        // can ignore this, as this validator is merely concerned with naming, not with resolution.
                        templatename = template.getNames();
                        // in case this was a textual reference, need to compare names still
                        if (templatename == null || templatename.size() == 0) {
                            continue;
                        }
                    }
                    
                    if (template instanceof ClassTemplate) {
                        ClassTemplate ct = (ClassTemplate) template;
                        if (ct.getMode() != null) {
                            templatename = new ArrayList<String>(templatename); // clone list before adding!
                            templatename.add(ct.getMode());
                        }
                    }
                    if(template instanceof OperatorTemplate) {
                        OperatorTemplate ot = (OperatorTemplate) template;
                        for (Operator op : ot.getOperators()) {
                            templatename = new ArrayList<String>(templatename); // clone list before adding!
                            templatename.add(op.getName());
                        }
                    }

                    if (names.contains(templatename)) {
                	// FIXME trying to manage multiple operatorTemplate specifications for distinct operator sets
                        errorBucket.addError("Duplicate template for same metamodel element " + templatename, template);
                    } else {

                        names.add(templatename);
                    }
                }
            }
        }
    }

}
