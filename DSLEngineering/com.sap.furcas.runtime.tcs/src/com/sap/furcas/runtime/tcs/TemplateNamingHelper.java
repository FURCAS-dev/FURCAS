/**
 * 
 */
package com.sap.furcas.runtime.tcs;

import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;


/**
 * Helps dealing with qualified names in syntaxes. Uses the Metamodel to qualify unqualified names when necessary and possible.
 */
public class TemplateNamingHelper<Type extends Object> {

    public static final String ABSTRACT_CONTENTS_SUFFIX = "_abstractContents";
    private final MetaModelElementResolutionHelper<Type> resolutionHelper;
    
    /**
     * Creates a new Helper that can use the Metamodel to resolve unqualified names.
     * @param lookup
     * @param separator
     * @param resolutionHelper 
     */
    public TemplateNamingHelper(MetaModelElementResolutionHelper<Type> resolutionHelper) {
        this.resolutionHelper = resolutionHelper;
    }
    
    
    
    /**
     * return rulename modified to allow for mode
     * @param qNamedElement
     * @param mode
     * @return
     * @throws SyntaxElementException
     */
    public String getRuleNameForMode(QualifiedNamedElement qNamedElement, String mode ) throws SyntaxElementException {
        String result = getRuleName(qNamedElement);
        if (mode != null) {
            if ( ! mode.trim().equals("")) {
                {
                    result += getModeSuffix(mode);
                }
            }
        }
        return result;
    }

    public static String getModeSuffix(String mode) {
        return '_' + mode;
    }
    
    /**
     * gets the ANTLR grammar rule name for the metamodel element referenced in the template.
     * For primitive templates, this is the templateName, and not the name of the DataType, as in TCS
     * on DataType may have several templates.
     * @param qNamedElement
     * @return
     * @throws SyntaxParsingException
     * @throws SyntaxElementException 
     */
    public String getRuleName(QualifiedNamedElement qNamedElement ) throws SyntaxElementException {
        if (qNamedElement instanceof PrimitiveTemplate) {
            return ((PrimitiveTemplate) qNamedElement).getTemplateName();
        }
        if (qNamedElement instanceof FunctionTemplate) {
            return ((FunctionTemplate) qNamedElement).getFunctionName().toLowerCase();
        }
        
        try {
            ResolvedNameAndReferenceBean<Type> resolvedName = resolutionHelper.resolve(qNamedElement);
            return buildRuleName(resolvedName);
        } catch (NameResolutionFailedException e) {
            throw new SyntaxElementException(e.getMessage(), qNamedElement);
        }
    }

//    public String getRuleName(ResolvedNameAndReferenceBean refBean ) throws SyntaxElementException, MetaModelLookupException, MetamodelNameResolvingException {
//        if (refBean == null) {
//            return null;
//        }
//        return resolveAndGetRuleName(refBean.getNames());
//    }

    /** 
     * resolves name against metamodel (non-qualified to qualified), then builds String by concatenating name parts.
     * @param qualifiedName
     * @return
     */
    public String buildRuleName(ResolvedNameAndReferenceBean<Type> refBean) {
        
        List<String> nameList = refBean.getNames();
        String result = null;
        if (nameList.size() == 1) { 
            // used unqualified name, returning direct to avoid Stringbuilder creation for nothing
            result = nameList.get(0).toLowerCase(); 
        } else {
            StringBuilder builder = new StringBuilder(nameList.size() * 10);
            for (Iterator<String> iterator = nameList.iterator(); iterator.hasNext();) {
                String name = iterator.next();

                builder.append(name.toLowerCase());
                if (iterator.hasNext()) {
                    builder.append('_');
                }
            }
            // TODO check generated name does not conflict with other similar intended name
            result = builder.toString();
        }
        if(refBean.getOperators() != null) {
            StringBuilder builder = new StringBuilder(refBean.getOperators().size() * 10);
            for (String op : refBean.getOperators()) {
                builder.append('_');
                builder.append(op);
            }
            result += builder.toString();
        }
        return result;
    }
    

//    /**
//     * private util method dealing with resolving names against metamodel.
//     * Will return the same output as input if no extra qualification was needed.
//     * Only returns null if metamodel returns null as a naming candidate.
//     * @param names
//     * @return
//     * @throws MetaModelLookupException 
//     * @throws SyntaxParsingException
//     */
//    private ResolvedNameAndReferenceBean<Type> resolveName(List<String> names) throws MetamodelNameResolvingException, MetaModelLookupException {
//        if (names == null || names.size() == 0) {
//            return null;
//        }
//       
//        ResolvedNameAndReferenceBean<Type> resolvedName = null;
//        // is name a valid metamodel element?
//        // TODO change interface isClassName() to getClassName
//        if (! mmLookup.isClassName(names)) {
//            
//            // was name used unqualified?
//            if (names.size() == 1) {
//                
//                // use metamodel to try qualify name if it was unqualified
//                String name = names.iterator().next();
//       
//                // get the real name of this element
//               List<ResolvedNameAndReferenceBean<Type>> candidates = mmLookup.qualifyName(name);
//                if (candidates == null || candidates.size() == 0) {
//                    throw new MetamodelNameResolvingException("Unknown classifier :" + names);
//                } else if (candidates.size() > 1) {
//                    throw new MetamodelNameResolvingException("Ambiguous classifier : " + names);
//                } 
//                resolvedName = (ResolvedNameAndReferenceBean<Type>) candidates.get(0);
//            } else { 
//                // is qualified, but not recognized by metamodel
//                throw new MetamodelNameResolvingException("Unknown or ambiguous qualified classifier :" + names);
//            }
//            
//        } else {
//            resolvedName = new ResolvedNameAndReferenceBean<Type>(names, null);
//        }
//      
//        return resolvedName;
//    }

   
    /**
     * return a String by which other code may identify a ModelElement.
     * @param reference
     * @return
     * @throws SyntaxParsingException 
     */
    public String getMetaTypeListParameter(ResolvedNameAndReferenceBean<Type> reference) {
        String returnName = createListParameter(reference);
        return returnName;
    }
    
    /**
     * qualifies template name if unqualified, and returns a String by which other code may identify a ModelElement.
     * @param reference
     * @return
     * @throws SyntaxParsingException 
     */
    public String getMetaTypeListParameter(Template template) throws SyntaxElementException {
        ResolvedNameAndReferenceBean<Type> refBean;
        try {
            refBean = resolutionHelper.resolve(template);
        } catch (NameResolutionFailedException e) {
            throw new SyntaxElementException(e.getMessage(), template);
        }
        String returnName = createListParameter(refBean);
        return returnName;
    }
    
    /**
     * @param metaModelTypeOfPropertyListName
     * @return
     * @throws MetamodelNameResolvingException 
     * @throws MetaModelLookupException 
     */
    public String getMetaTypeListParameter(
            List<String> names) throws MetamodelNameResolvingException, MetaModelLookupException {
        ResolvedNameAndReferenceBean<Type> qname = resolutionHelper.resolve(names);
        if (qname != null) {
            return createListParameter(qname);
        } else {
            throw new MetamodelNameResolvingException("Could not resolve name " + names);
        }
    }

    /**
     * creates a String saying 'list("name1", "name2")' which supposedly is a method call that will return a List of Strings.
     * @param refBean
     * @return
     */
    private String createListParameter(ResolvedNameAndReferenceBean<Type> refBean) {
        List<String> stringList = refBean.getNames();
        StringBuilder builder = new StringBuilder(stringList.size() );
        builder.append("list(");
        String returnName;

        for (Iterator<String> iterator = stringList.iterator(); iterator.hasNext();) {
            String name = iterator.next();
            builder.append('\"');
            builder.append(name);
            builder.append('\"');
            if (iterator.hasNext()) {
                builder.append(',');
            }
        }
        builder.append(')');
        returnName = builder.toString();

        return returnName;
    }



    public String getRuleNameForTemplate(com.sap.furcas.metamodel.TCS.Template template) throws SyntaxElementException {
	if(template instanceof ClassTemplate) {
	    if(((ClassTemplate)template).getMode() != null){
		return getRuleNameForMode(template, ((ClassTemplate)template).getMode());
	    }
	}
	return getRuleName(template);	
    }



    /**
     * Gives the name of the grammar rule resulting from the given template.
     * 
     * @param template
     * @param syntaxLookup the {@link SyntaxLookup} that should be used in order to resolve the templates
     * @return
     * @throws SyntaxElementException
     */
    public String getConcreteRuleNameForTemplate(Template template, SyntaxLookup syntaxLookup) throws SyntaxElementException {
	try {
    	List<ResolvedNameAndReferenceBean<Type>> subtypes = null;
    	
            ResolvedNameAndReferenceBean<Type> resolvedBean = resolutionHelper.resolve(template);
            subtypes = this.resolutionHelper.getMetaLookup().getDirectSubTypes(resolvedBean);
            String ruleNameForTemplate = getRuleNameForTemplate(template);
            if(TcsUtil.areSubTypesWithTemplates(subtypes, TcsUtil.getTemplateMode(template), syntaxLookup)) {
    	    	return ruleNameForTemplate + "__impl";
            } else {
                return ruleNameForTemplate;
            }
        } catch (NameResolutionFailedException e) {
            throw new SyntaxElementException(e.getMessage(), template);
        } catch (MetaModelLookupException e) {
            throw new SyntaxElementException(e.getMessage(), template);
	}    
    }
    
}
