/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-21 13:10:46 +0200 (Fr, 21 Aug 2009) $
 * @version $Revision: 7738 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.textual.tcs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.metamodel.TCS.LocatedElement;
import com.sap.furcas.metamodel.TCS.OperatorList;
import com.sap.furcas.metamodel.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.TCS.Symbol;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.textual.common.exceptions.SyntaxElementException;
import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.furcas.textual.common.interfaces.ResolvedNameAndReferenceBean;


/**
 * convenience class for looking up information in a SyntaxDefinition.
 * 
 * @author C5107456
 */
public class SyntaxLookup {

	/** The syntax. */
	private final com.sap.furcas.metamodel.TCS.ConcreteSyntax syntax;
	
	/** The keyword set. */
	private Set<Keyword> keywordSet;

    private final MetaModelElementResolutionHelper<?> resolutionHelper;

    private List<PrimitiveTemplate> primitiveTemplates;
    
    private final Map<QualifiedNamedElement, List<String>> qualifiednamesCache = new HashMap<QualifiedNamedElement, List<String>>();

    //private AlternativeSequence alternativeSequenceAssoc;

	/**
	 * Instantiates a new syntax lookup.
	 * 
	 * @param syntax the syntax
	 * @param keywordSet the keyword set
	 * @param resolutionHelper 
	 * @param keywordSet 
	 */
	public SyntaxLookup(ConcreteSyntax syntax, Set<Keyword> keywordSet, MetaModelElementResolutionHelper<?> resolutionHelper) {
		super();
		this.syntax = syntax;
		this.keywordSet = keywordSet;
		if (this.keywordSet == null) {
		    this.keywordSet = new HashSet<Keyword>();
		}
		if (syntax != null) {
		    this.keywordSet.addAll(syntax.getKeywords()); // declared vs. used keywords
//		    if(syntax.eContainer() != null) {
//		    	this.alternativeSequenceAssoc = ((TcsPackage)syntax.refImmediatePackage()).getAlternativeSequence();
//		    }
		    
		}
		this.resolutionHelper = resolutionHelper;

		// initialize list of primitive templates for getDefault Primitive....
		initializePrimitiveTemplatesList(syntax);
	}



    private void initializePrimitiveTemplatesList(ConcreteSyntax syntax) {
        primitiveTemplates = new ArrayList<PrimitiveTemplate>();
		if (syntax != null) {
		    Collection<Template> templates = syntax.getTemplates();
		    if (templates != null ) {
		        for (Iterator<Template> iterator = templates.iterator(); iterator.hasNext();) {
		            Template template = iterator.next();
		            if (template instanceof PrimitiveTemplate) {
		                primitiveTemplates.add((PrimitiveTemplate) template);
		            }
		        }
		    }
		}
    }
	
	

	public Set<Keyword> getAllKeywords () {
	    return keywordSet;
	}



	 /**
	  * If the type passed is a primitive, then this allows to get the right primitveTemplate.
 	 * If there is a  default  primitive template rule for this type, this method returns the template for this.
 	 * Else, it returns the last one. There should always be a default one per Datatype, so the behavior when there
 	 * is not is unspecified.
 	 * 
 	 * @param metaModelTypeOfPropertyReference the property type
 	 * 
 	 * @return the primitive template rule
 	 */
	public PrimitiveTemplate getDefaultPrimitiveTemplateRule( ResolvedNameAndReferenceBean<?> metaModelTypeOfPropertyReference) throws SyntaxElementException {
	    if (metaModelTypeOfPropertyReference == null || metaModelTypeOfPropertyReference.getNames() == null) {
	        return null;
	    }
	    
	    // loop over primitive Templates
	    PrimitiveTemplate returnTemplate = null;
	    for (Iterator<PrimitiveTemplate> iterator = primitiveTemplates.iterator(); iterator.hasNext();) {
	        PrimitiveTemplate candidatePrimTemp = iterator.next();

	        List<String> candidateQualifiedName = getQualifiedNameOfMetaModelElement(candidatePrimTemp);
	        // TODO compare references instead of names?
	        if (metaModelTypeOfPropertyReference.getNames().equals(candidateQualifiedName)) {
	            returnTemplate = candidatePrimTemp;
	            if (candidatePrimTemp.isIsDefault()) {
	                break;
	            }

	        }
	    }
	    return returnTemplate;
	}
	
	 /**
 	 * Gets the symbol rule.
 	 * 
 	 * @param literal the literal
 	 * 
 	 * @return the symbol rule
 	 */
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
	 * returns TCS template in the syntax for a given type name of a metamodel element
	 * 
	 * @param typeName the sub type
	 * 
	 * @return the TCS template
	 * @throws SyntaxElementException 
	 */
	public Collection<Template> getTCSTemplate(ResolvedNameAndReferenceBean<?> resolvedName, String mode) throws SyntaxElementException {
	    Collection<Template> returnTemplate = new ArrayList<Template>(1);
		// loop over all templates and return the first with the same name.
		Collection<Template> templates = syntax.getTemplates();

		if (templates != null ) {
		    for (Iterator<Template> iterator = templates.iterator(); iterator.hasNext();) {
		        Template template = iterator.next();
		        
		        
		        if (template instanceof FunctionTemplate) {
		            continue;
		        }
		       if (template instanceof ClassTemplate) {
		         ClassTemplate ct = (ClassTemplate) template;
		         if (mode != null) {
		             if (! mode.equals(ct.getMode() )) {
		                    continue;
		                }
		            } else {
		                if (ct.getMode() != null) {
		                    continue;
		                }
		            }
		        }
		       if(template instanceof OperatorTemplate) {
			   //operators do not support modes yet
		           if (resolvedName.getOperators() != null ) {
		               if( ! resolvedName.getOperators().containsAll(
		                       ((OperatorTemplate) template).getOperators())) {
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
	
	public <Type> List<ClassTemplate> getNonPrimaries(
		    List<ResolvedNameAndReferenceBean<Type>> subtypes)
		    throws SyntaxElementException {
		ArrayList<ClassTemplate> nonPrimaries = new ArrayList<ClassTemplate>();
	        for (Iterator<ResolvedNameAndReferenceBean<Type>> iterator = subtypes.iterator(); iterator.hasNext();) {
	            ResolvedNameAndReferenceBean<Type> subType = iterator.next();
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
	
	public <Type> List<ClassTemplate> getPrimaries(
		    List<ResolvedNameAndReferenceBean<Type>> subtypes, IMetaModelLookup<Type> metaLookup)
		    throws SyntaxElementException, NameResolutionFailedException, MetaModelLookupException {
		ArrayList<ClassTemplate> primaries = new ArrayList<ClassTemplate>();
		if(subtypes != null) {
        	    for (Iterator<ResolvedNameAndReferenceBean<Type>> iterator = subtypes
        		    .iterator(); iterator.hasNext();) {
        		ResolvedNameAndReferenceBean<Type> subType = iterator.next();
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
                                List<ResolvedNameAndReferenceBean<Type>> subsubtypes = metaLookup
                                        .getDirectSubTypes(subType);
                                List<ClassTemplate> subsubtypesPrimaries = getPrimaries(
                                        subsubtypes, metaLookup);
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
	        for (Iterator<OperatorList> iterator = opListList.iterator(); iterator.hasNext();) {
	            OperatorList opList = iterator.next();
	            if (opList.getName() == null || opList.getName().equals("")) {
	                returnOpList = opList;
	                break;
	            } 
	        }
	    }
	    return returnOpList;
	}
	
	
//  Probably never used anyways.
//	/**
//	 * as operators for some reason (?) sometimes do not refer to their literals, need to look them up. Used in OperatorHandler
//	 * 
//	 * @param operator the operator
//	 * 
//	 * @return the literal for operator
//	 */
//	protected Literal getLiteralForOperator(Operator operator) {
//		Literal returnLiteral = null;
//		List<Symbol> symbolList = syntax.getSymbols();
//		if (symbolList != null) {
//		    for (Iterator<Symbol> iterator = symbolList.iterator(); iterator.hasNext();) {
//		        Symbol symbol = (Symbol) iterator.next();
//		        List<Operator> opList = symbol.getOperators();
//		        for (Iterator<Operator> iterator2 = opList.iterator(); iterator2.hasNext();) {
//		            Operator loopOp = (Operator) iterator2.next();
//		            if (loopOp == operator) {
//		                if (returnLiteral == null) {
//		                    returnLiteral = symbol; 
//		                }
//		            }
//		        }
//		    }
//		}
//		
//		if (keywordSet != null) {
//		    for (Iterator<Keyword> iterator = keywordSet.iterator(); iterator.hasNext();) {
//		        Keyword keyword = (Keyword) iterator.next();
//		        List<Operator> opList = keyword.getOperators();
//		        for (Iterator<Operator> iterator2 = opList.iterator(); iterator2.hasNext();) {
//		            Operator loopOp = (Operator) iterator2.next();
//		            if (loopOp == operator) {
//		                if (returnLiteral == null) {
//		                    returnLiteral = keyword; 
//		                } 
//		            }
//		        }
//		    }
//		}
//
//		return returnLiteral;
//	}

   
    /**
     * for the syntaxElement (i.e. a property, or a SeuqenceElement), find the qualified name of the metamodel element,
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
     * util method to call namingHelper.getQualifiedTemplateReferenceName
     * @param template
     * @return
     * @throws SyntaxElementException
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



    /**
     * @param asRule
     */
    public boolean hasPrimitiveRule(String templateName) {
        for (Iterator<PrimitiveTemplate> iterator = primitiveTemplates.iterator(); iterator.hasNext();) {
            PrimitiveTemplate primTemp = iterator.next();
            if (templateName.equals(primTemp.getTemplateName())) {
                return true;
            }
        }
        return false;
    }

}
