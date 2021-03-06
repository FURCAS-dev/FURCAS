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

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
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
    public PrimitiveTemplate defaultPrimitiveTemplate;

    /**
     * @param syntax
     * @param keywordSet
     */
    public SyntaxLookupStub() {
        super(null, null);
        subtemplates = new HashMap<String, Template>();
    }


    @Override
    public OperatorList getAnonymousOperatorList() {
        return null;
    }

    @Override
    public PrimitiveTemplate getDefaultPrimitiveTemplateRule(ResolvedNameAndReferenceBean<?> bean) {
        return defaultPrimitiveTemplate;
    }

    @Override
    public String getSymbolRule(String literal) {
        return "Rule-" + literal;
    }

    @Override
    public Template getEnclosingQualifiedElement(EObject syntaxElement)  {
        return enclosingName;
    }

    @Override
    public Set<Keyword> getAllKeywords() {
        return keywords;
    }

    @Override
    public Collection<Template> getTCSTemplate(ResolvedNameAndReferenceBean<?> refBean, String mode) {
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
	public <Type> List<ClassTemplate> getNonPrimaries(
		List<ResolvedNameAndReferenceBean<Type>> subtypes) {
	    return nonPrimaries;
	}


	@Override
	public <Type> List<ClassTemplate> getPrimaries(
		List<ResolvedNameAndReferenceBean<Type>> subtypes, IMetaModelLookup<Type> metaLookup) {
	    return primaries;
	}

	public void addSubtemplate(String name, Template tmpl) {
		subtemplates.put(name, tmpl);
	}
    
}
