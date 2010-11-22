/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub;

import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.parsergenerator.util.StringConcatUtil;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 * Reasonably simple stub for naming.
 */
public class TemplateNamingHelperStub<Type> extends TemplateNamingHelper<Type> {

    /**
     * @param lookup
     * @param separator
     */
    public TemplateNamingHelperStub() {
        super(null);
    }

    
    @Override
    public String getConcreteRuleNameForTemplate(Template template, SyntaxLookup lookup) {
	return getRuleName(template) + "__impl";
    }


    @Override
    public String getMetaTypeListParameter(
            ResolvedNameAndReferenceBean<Type> reference) {
        return StringConcatUtil.concat("\"",reference.getNames(),"\"");
    }

    @Override
    public String getMetaTypeListParameter(Template template) {
        return StringConcatUtil.concat(template.getNames().toArray());
    }


    @Override
    public String getRuleNameForMode(QualifiedNamedElement namedElement,
            String mode) {
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
    public String getRuleName(QualifiedNamedElement element) {
        return StringConcatUtil.concat(element.getNames().toArray());
    }

    @Override
    public String getMetaTypeListParameter(List<String> names) {
        return StringConcatUtil.concat(names.toArray());
    }



}
