/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.List;

import tcs.QualifiedNamedElement;
import tcs.Template;

import com.sap.mi.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.moinlookup.util.MetamodelNameResolvingException;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;
import com.sap.mi.textual.tcs.util.SyntaxLookup;
import com.sap.mi.textual.util.StringConcatUtil;

/**
 * Reasonably simple stub for naming.
 */
public class TemplateNamingHelperStub<Type extends Object> extends TemplateNamingHelper<Type> {

    /**
     * @param lookup
     * @param separator
     */
    public TemplateNamingHelperStub() {
        super(null);
    }

    
    @Override
    public String getConcreteRuleNameForTemplate(Template template, SyntaxLookup lookup)
	    throws SyntaxElementException {
	return getRuleName(template) + "__impl";
    }


    @Override
    public String getMetaTypeListParameter(
            ResolvedNameAndReferenceBean<Type> reference)
            throws SyntaxElementException {
        return StringConcatUtil.concat("\"",reference.getNames(),"\"");
    }

    @Override
    public String getMetaTypeListParameter(Template template)
            throws SyntaxElementException {
        return StringConcatUtil.concat(template.getNames().toArray());
    }


    @Override
    public String getRuleNameForMode(QualifiedNamedElement namedElement,
            String mode) throws SyntaxElementException {
        if (mode != null) {
            return getRuleName(namedElement)+ "_" + mode;
        } else {
            return getRuleName(namedElement);
        }
    }



    @Override
    public String buildRuleName(ResolvedNameAndReferenceBean<Type> refBean) {
        return StringConcatUtil.concat(refBean.getNames().toArray());
    }

    @Override
    public String getRuleName(QualifiedNamedElement element)
            throws SyntaxElementException {
        return StringConcatUtil.concat(element.getNames().toArray());
    }

    @Override
    public String getMetaTypeListParameter(List<String> names)
            throws MetamodelNameResolvingException {
        return StringConcatUtil.concat(names.toArray());
    }



}
