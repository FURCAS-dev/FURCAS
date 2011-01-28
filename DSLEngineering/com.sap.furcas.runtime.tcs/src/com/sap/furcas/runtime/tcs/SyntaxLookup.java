/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-21 13:10:46 +0200 (Fr, 21 Aug 2009) $
 * @version $Revision: 7738 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.tcs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCL;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;

/**
 * Convenience class for looking up information in a SyntaxDefinition.
 * 
 * @author C5107456
 */
public class SyntaxLookup {

    private final ConcreteSyntax syntax;
    private final MetaModelElementResolutionHelper<?> resolutionHelper;
    private List<PrimitiveTemplate> primitiveTemplates;
    private final Map<QualifiedNamedElement, List<String>> qualifiednamesCache = new HashMap<QualifiedNamedElement, List<String>>();

    /**
     * Instantiates a new syntax lookup.
     * 
     * @param syntax the syntax
     * @param keywordSet the keyword set
     * @param resolutionHelper 
     * @param keywordSet 
     */
    public SyntaxLookup(ConcreteSyntax syntax, MetaModelElementResolutionHelper<?> resolutionHelper) {
        super();
        this.syntax = syntax;
        this.resolutionHelper = resolutionHelper;

        initializePrimitiveTemplatesList(syntax);
    }

    private void initializePrimitiveTemplatesList(ConcreteSyntax syntax) {
        primitiveTemplates = new ArrayList<PrimitiveTemplate>();
        if (syntax != null) {
            Collection<Template> templates = syntax.getTemplates();
            for (Template template : templates) {
                if (template instanceof PrimitiveTemplate) {
                    primitiveTemplates.add((PrimitiveTemplate) template);
                }
            }
        }
    }

    public Set<Keyword> getAllKeywords() {
        return new HashSet<Keyword>(syntax.getKeywords());
    }

   /**
    * If the type passed is a primitive, then this allows to get the right primitveTemplate.
    * If there is a  default  primitive template rule for this type, this method returns the template for this.
    * Otherwise, a random primitive template for this type is returned.
    * 
    * @param metaModelTypeOfPropertyReference the property type. The type can be either a metamodel primitive or a
    *   primitive as used by OCL.
    */
    public PrimitiveTemplate getDefaultPrimitiveTemplateRule(ResolvedNameAndReferenceBean<?> metaModelTypeOfPropertyReference) throws SyntaxElementException {
        if (metaModelTypeOfPropertyReference == null || metaModelTypeOfPropertyReference.getNames() == null) {
            return null;
        }
        PrimitiveTemplate returnTemplate = null;
        
        for (PrimitiveTemplate candidatePrimTemp : primitiveTemplates) {
            // Retrieve the equivalent OCL primitive for this type (e.g., OCL maps ecore::EString to oclstdlib::String).
            // Comparing to OCL primitives allows clients to find templates suitable for the return types of OCL expressions
            Object oclType = OCL.newInstance().getEnvironment().getUMLReflection().asOCLType(candidatePrimTemp.getMetaReference());
            boolean isSuitableTemplateForOCLPrimitive = oclType != null && oclType.equals(metaModelTypeOfPropertyReference.getReference());
            
            // TODO compare references instead of names when the "->" referencing hack is removed 
            List<String> candidateQualifiedName = getQualifiedNameOfMetaModelElement(candidatePrimTemp);
            if (metaModelTypeOfPropertyReference.getNames().equals(candidateQualifiedName) || isSuitableTemplateForOCLPrimitive) {
                returnTemplate = candidatePrimTemp;
                if (candidatePrimTemp.isDefault()) {
                    break;
                }
            }
        }
        return returnTemplate;
    }

    public String getSymbolRule(String literal) {
        String symbolRule = null;
        Collection<Symbol> list = syntax.getSymbols();
        if (list != null) {
            Symbol symbol;
            for (Iterator<Symbol> iterator = list.iterator(); iterator.hasNext();) {
                symbol = iterator.next();
                if (literal.equals(symbol.getValue())) {
                    symbolRule = ' ' + symbol.getName().toUpperCase() + ' ';
                    break;
                }
            }
        }

        if (symbolRule == null) {
            symbolRule = '\'' + literal + '\'';
        }
        return symbolRule;
    }

    /**
     * Teturns TCS template in the syntax for a given type name of a metamodel element
     * 
     * @param typeName the sub type
     * 
     * @return the TCS template
     * @throws SyntaxElementException 
     */
    public Collection<Template> getTCSTemplate(ResolvedNameAndReferenceBean<?> resolvedName, String mode)
            throws SyntaxElementException {
        Collection<Template> returnTemplate = new ArrayList<Template>(1);
        // loop over all templates and return the first with the same name.
        Collection<Template> templates = syntax.getTemplates();

        if (templates != null) {
            for (Template template : templates) {
                if (template instanceof FunctionTemplate) {
                    continue;
                }
                if (template instanceof ClassTemplate) {
                    ClassTemplate ct = (ClassTemplate) template;
                    if (mode != null) {
                        if (!mode.equals(ct.getMode())) {
                            continue;
                        }
                    } else {
                        if (ct.getMode() != null) {
                            continue;
                        }
                    }
                }
                if (template instanceof OperatorTemplate) {
                    //operators do not support modes yet
                    if (resolvedName.getOperators() != null) {
                        if (!resolvedName.getOperators().containsAll(((OperatorTemplate) template).getOperators())) {
                            continue;
                        }
                    }
                    if (mode != null) {
                        continue;
                    }
                }

                List<String> name = getQualifiedNameOfMetaModelElement(template);
                if (name != null && name.equals(resolvedName.getNames())) {
                    returnTemplate.add(template);
                    //		            if (returnTemplate == null) {
                    //		                returnTemplate = template;
                    //		            } else {
                    //	                	// FIXME trying to manage multiple operatorTemplate specifications for distinct operator sets
                    //		                throw new SyntaxElementException("Duplicate Template referring to " + name, template);
                    //		            }
                }
            }
        }
        return returnTemplate;
    }

    public <Type> List<ClassTemplate> getNonPrimaries(List<ResolvedNameAndReferenceBean<Type>> subtypes)
            throws SyntaxElementException {
        ArrayList<ClassTemplate> nonPrimaries = new ArrayList<ClassTemplate>();
        for (ResolvedNameAndReferenceBean<Type> subType : subtypes) {
            Collection<Template> subtemps = null;

            subtemps = getTCSTemplate(subType, null);

            for (Template subtemp : subtemps) {
                if (subtemp instanceof ClassTemplate) {
                    ClassTemplate classSubTemp = (ClassTemplate) subtemp;
                    if (classSubTemp.isIsNonPrimary()) { // Non Primaries not added to primary rule
                        nonPrimaries.add(classSubTemp);
                        continue;
                    }
                }
            }
        }
        return nonPrimaries;
    }

    public <Type> List<ClassTemplate> getPrimaries(List<ResolvedNameAndReferenceBean<Type>> subtypes,
            IMetaModelLookup<Type> metaLookup) throws SyntaxElementException, NameResolutionFailedException,
            MetaModelLookupException {
        ArrayList<ClassTemplate> primaries = new ArrayList<ClassTemplate>();
        if (subtypes != null) {
            for (ResolvedNameAndReferenceBean<Type> subType : subtypes) {
                Collection<Template> subtemps = null;
                subtemps = getTCSTemplate(subType, null);
                for (Template subtemp : subtemps) {

                    if (subtemp != null && subtemp instanceof ClassTemplate) {
                        ClassTemplate classSubTemp = (ClassTemplate) subtemp;
                        if (!classSubTemp.isIsNonPrimary()) { // Non Primaries not
                            // added to primary rule
                            primaries.add(classSubTemp);
                            continue;
                        }
                    } else {
                        // not a class template or no template found at all
                        // continue to look for primaries recursively in
                        // subtypes of subType
                        List<ResolvedNameAndReferenceBean<Type>> subsubtypes = metaLookup.getDirectSubTypes(subType);
                        List<ClassTemplate> subsubtypesPrimaries = getPrimaries(subsubtypes, metaLookup);
                        primaries.addAll(subsubtypesPrimaries);
                    }
                }
            }
        }
        return primaries;
    }

    /**
     * since TCS treats the anonymous OperatorList special, we 
     * need to retrieve it from the Syntax in ClassTemplateHandler.
     * 
     * @return the anonymous operator list
     */
    public OperatorList getAnonymousOperatorList() {
        OperatorList returnOpList = null;
        Collection<OperatorList> opListList = syntax.getOperatorLists();
        if (opListList != null) {
            for (OperatorList opList : opListList) {
                if (opList.getName() == null || opList.getName().equals("")) {
                    returnOpList = opList;
                    break;
                }
            }
        }
        return returnOpList;
    }

    /**
     * For the syntaxElement (i.e. a property, or a SeuqenceElement), find the qualified name of the metamodel element,
     * in whose template the syntaxElement has been used..
     * To achieve this, get the first Template going upwards in the containment hierarchy. 
     * The template should have a qualified name pointing to a metamodel class to which this property
     * belongs to.
     * 
     * @param syntaxElement the prop
     * 
     * @return the property class
     * @throws SyntaxParsingException 
     */
    public Template getEnclosingQualifiedElement(LocatedElement syntaxElement) {
        // TODO refactor SyntaxModel to have explicit reference to parent template?
        EObject parent = syntaxElement.eContainer();
        while (parent != null && !(parent instanceof Template)) {
            if (parent instanceof EObject) {
                EObject refParent = parent;
                parent = refParent.eContainer();
            } else {
                throw new RuntimeException("Bug: composite parent of Element " + parent + " not instance of RefObject.");
            }
        }
        if (parent != null) {
            return (Template) parent;
        } else {
            throw new RuntimeException("Template parent of Element " + syntaxElement + " expected, but not found.");
        }
    }

    /**
     * Util method to call namingHelper.getQualifiedTemplateReferenceName
     */
    private List<String> getQualifiedNameOfMetaModelElement(QualifiedNamedElement template) throws SyntaxElementException {
        List<String> qualifiedName = qualifiednamesCache.get(template);
        if (qualifiedName == null) {
            ResolvedNameAndReferenceBean<?> reference;
            try {
                reference = resolutionHelper.resolve(template);
            } catch (NameResolutionFailedException e) {
                throw new SyntaxElementException(e.getMessage(), template, e);
            }
            if (reference != null) {
                qualifiedName = reference.getNames();
                qualifiednamesCache.put(template, qualifiedName);
            }
        }
        return qualifiedName;
    }

    public boolean hasPrimitiveRule(String templateName) {
        for (PrimitiveTemplate primTemp : primitiveTemplates) {
            if (templateName.equals(primTemp.getTemplateName())) {
                return true;
            }
        }
        return false;
    }

}
