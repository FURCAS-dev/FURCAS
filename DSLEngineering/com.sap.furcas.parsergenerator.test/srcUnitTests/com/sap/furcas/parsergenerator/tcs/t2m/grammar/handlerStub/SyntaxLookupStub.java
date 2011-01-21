/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub;

import static com.sap.furcas.test.testutils.StringListHelper.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.PrimitiveTemplateStub;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.tcs.SyntaxLookup;

/**
 *
 */
public class SyntaxLookupStub extends SyntaxLookup {

    public int highestIndex;
    public Template typeTemplate=null;
    public HashMap<String, Template> subtemplates;
    public Template enclosingName;
    public Set<Keyword> keywords;
    public List<ClassTemplate> nonPrimaries = new ArrayList<ClassTemplate>();
    public List<ClassTemplate> primaries = new ArrayList<ClassTemplate>();

    /**
     * @param syntax
     * @param keywordSet
     */
    public SyntaxLookupStub() {
        super(null, null, null,null,null);
        subtemplates = new HashMap<String, Template>();
    }


    @Override
    public OperatorList getAnonymousOperatorList() {
        return null;
    }

    @Override
    public PrimitiveTemplate getDefaultPrimitiveTemplateRule(ResolvedNameAndReferenceBean<?> bean) {
        return null;
    }

    @Override
    public String getSymbolRule(String literal) {
        return "Rule-" + literal;
    }

    @Override
    public Template getEnclosingQualifiedElement(LocatedElement syntaxElement)  {
        return enclosingName;
    }

    @Override
    public Set<Keyword> getAllKeywords() {
        return keywords;
    }

    @Override
    public Collection<Template> getTCSTemplate(Template typeTemplate, ResolvedNameAndReferenceBean<?> refBean, String mode) {
        return Collections.singleton(typeTemplate);
    }


	@Override
	public boolean hasPrimitiveRule(String templateName) {
		if(typeTemplate instanceof PrimitiveTemplateStub) {
			return ((PrimitiveTemplateStub)typeTemplate).names.equals(list(templateName));
		} else {
			return false;
		}
	}


	@Override
	public <Type> List<ClassTemplate> getNonPrimaries(Template typeTemplate,
		List<ResolvedNameAndReferenceBean<Type>> subtypes) {
	    return nonPrimaries;
	}


	@Override
	public <Type> List<ClassTemplate> getPrimaries(Template typeTemplate,
		List<ResolvedNameAndReferenceBean<Type>> subtypes, IMetaModelLookup<Type> metaLookup) {
	    return primaries;
	}

	public void addSubtemplate(String name, Template tmpl) {
		subtemplates.put(name, tmpl);
	}
    
}
