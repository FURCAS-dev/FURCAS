/*******************************************************************************
 * Copyright (c) 2008-2011 INRIA and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *     SAP AG - API and implementation enhancements
 ******************************************************************************/
package com.sap.furcas.unparser;

import static com.sap.furcas.unparser.PrettyPrintConstants.LINE_FEED;
import static com.sap.furcas.unparser.PrettyPrintConstants.SYMBOL_RIGHT_NONE;
import static com.sap.furcas.unparser.PrettyPrintConstants.TYPE_SYMBOL;
import static com.sap.furcas.unparser.PrettyPrintDebugHelper.debug;
import static com.sap.furcas.unparser.PrettyPrintDebugHelper.debugPropertyInitException;
import static com.sap.furcas.unparser.PrettyPrintDebugHelper.debugWhiteSpace;
import static com.sap.furcas.unparser.PrettyPrintHelper.findSupertypeTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator;
import com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PartialPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.unparser.PrettyPrintExceptions.ForcedBoundsException;
import com.sap.furcas.unparser.PrettyPrintExceptions.NoTemplateMatchFoundException;
import com.sap.furcas.unparser.PrettyPrintExceptions.PropertyInitException;
import com.sap.furcas.unparser.PrettyPrintExceptions.SyntaxMismatchException;
import com.sap.furcas.unparser.extraction.TCSExtractorStream;

/**
 * @author Fr�d�ric Jouault
 * @author Mika�l Barbero
 * 
 *         enhanced by 	Philipp Meier 2009
 *              	Andreas Landerer 2010
 *              	Stephan Erb (d049157) 2010
 * 
 */
public class PrettyPrinter {

    private static class DefaultPolicy implements PrettyPrintingPolicy {

	@Override
	public List<SequenceInAlternative> getSequenceElementsOfCurrentAlternativeInPreferredOrder(Alternative alternative) {
	    // use order as found within the TCS file
	    return new ArrayList<SequenceInAlternative>(alternative.getSequences());
	}

	@Override
	public String adaptWhiteSpace(String tcsImpliedWhiteSpace) {
	    // use the whitespace as TCS tells us to do so
	    return tcsImpliedWhiteSpace;
	}
	
	@Override
	public Boolean desiresAdditionalWhiteSpace() {
	    return false;
	}
    }
    
    /**
     * A tracer that does just nothing.
     */
    private static class NullTracer implements PrettyPrintingTracer {
	@Override
	public void notifyStartedClassTemplateForObject(int handle, EObject object, Template template) {}
	@Override
	public void notifyEndedClassTemplate(int handle) {}
	@Override
	public void notifyEnteredSequenceElement(SequenceElement e) {}
	@Override
	public void notifyExitedSequenceElement() {}
	@Override
	public void notifyEnteredAlternative(Alternative alt) {}
	@Override
	public void notifyBeganAlternativeChoice(int choiceIndexInAlternative) {}
	@Override
	public void notifyExitedAlternative() {}
	@Override
	public void notifyAboutToPrintToken() {}
	@Override
	public void notifyPrintedToken() {}
	@Override
	public void notifyAboutToPrintWhiteSpace() {}
	@Override
	public void notifyPrintedWhiteSpace(String ws) {}
	@Override
	public void notifySafePointCreated(int handle) {}
	@Override
	public void notifyResettedToSafePoint(int handle) {}
	
    }
        
    /**
     * Mapping of qualifiedName + Mode to ClassTemplate of all
     * ClassTemplates contained in the ConcreteSyntax
     */
    private Map<List<String>, Map<String, ClassTemplate>> classTemplateMap;
   
    /**
     * Mapping of qualifiedName to all Template of all templates which are 
     * no ClassTemplates
     */
    private final Map<String, Object> nonClassTemplates = new HashMap<String, Object>();
    
    /**
     * Mapping of primitive template names to PrimitiveTemplate of all
     * ClassTemplates contained in the ConcreteSyntax
     */
    private final Map<String, PrimitiveTemplate> primitiveTemplates = new HashMap<String, PrimitiveTemplate>();

    private TCSExtractorStreamPrinter printer;
    private PrettyPrintContext currentContext;
    private final Map<Integer, PrettyPrintContext> backtrackingContextBackup = new HashMap<Integer, PrettyPrintContext>();

    private final PrettyPrintingPolicy policy;
    private final PrettyPrintingTracer tracer;
    
    
    public PrettyPrinter() {
	this(new DefaultPolicy(), new NullTracer());
    }
    
    public PrettyPrinter(PrettyPrintingPolicy policy, PrettyPrintingTracer tracer) {
	currentContext = new PrettyPrintContext();
	this.policy = policy;
	this.tracer = tracer;
    }
    
    /**
     * Pretty print the given root model element.
     * 
     * @param modelElementToPrint
     * @param syntax Syntax in which the ModelElement shall be represented
     * @param targetOutputStream
     * @param template Main Template for the corresponding ModelElement
     *                       
     * @throws SyntaxAndModelMismatchException
     */
    public void prettyPrint(EObject modelElementToPrint, ConcreteSyntax syntax, TCSExtractorStream targetOutputStream) throws SyntaxAndModelMismatchException {
	prettyPrint(modelElementToPrint, syntax, targetOutputStream, /*template*/ null, /*preconfiguredPrettyPrintContext*/ null);
    }
    
    /**
     * Pretty print the given root model element.
     * 
     * @param modelElementToPrint
     * @param syntax Syntax in which the ModelElement shall be represented
     * @param targetOutputStream
     * @param template Main Template for the corresponding ModelElement
     *                       
     * @throws SyntaxAndModelMismatchException
     */
    public void prettyPrint(EObject modelElementToPrint, ConcreteSyntax syntax, TCSExtractorStream targetOutputStream, Template template) throws SyntaxAndModelMismatchException {
	
	if (template == null || (template instanceof ClassTemplate) && ((ClassTemplate) template).isIsMain()) {
	    prettyPrint(modelElementToPrint, syntax, targetOutputStream, template, /*preconfiguredPrettyPrintContext*/ null);
	} else {
	    throw new IllegalArgumentException("Non-Main templates must provide prettyprint context");
	}
    }
    
    /**
     * Pretty print the given model element. The model element does not need to be a root model element.
     * This however requires knowledge about the correct template and a prepared pretty print context.
     * 
     * @param modelElementToPrint
     * @param syntax Syntax in which the ModelElement shall be represented
     * @param targetOutputStream
     * @param template Template for the corresponding ModelElement
     * @param currentContext if Template is no main Template a context has to be built
     *                       first otherwise this can be null
     *                       
     * @throws SyntaxAndModelMismatchException
     */
    public void prettyPrint(EObject modelElementToPrint, ConcreteSyntax syntax, TCSExtractorStream targetOutputStream, Template template,
	    PrettyPrintContext preconfiguredPrettyPrintContext) throws SyntaxAndModelMismatchException {

	if (preconfiguredPrettyPrintContext != null) {
	    this.currentContext = preconfiguredPrettyPrintContext;
	}
	initializeTemplateDataStructures(syntax);
	
	printer = new TCSExtractorStreamPrinter(syntax, targetOutputStream, currentContext, policy, tracer);

	currentContext.getPriorities().push(Integer.MAX_VALUE);
	int handle = createSafePoint();
	try {
	    if (template == null || !(template instanceof ClassTemplate)) {
		serialize(modelElementToPrint);
	    } else {
		ClassTemplate clsTemplate = (ClassTemplate) template;
		serialize(modelElementToPrint, clsTemplate.getMode(), template);
	    }
	} catch (SyntaxMismatchException e) {
	    resetToSafePoint(handle);
	    throw new SyntaxAndModelMismatchException(e);
	}
	printer.close();
    }

    @SuppressWarnings("unchecked")
    private void initializeTemplateDataStructures(ConcreteSyntax syntax) {
	classTemplateMap = TcsUtil.createClassTemplateMap(syntax);

	for (Template t : syntax.getTemplates()) {
	    List<String> name = TcsUtil.getQualifiedName(t);
	    if (t instanceof EnumerationTemplate) {
		EnumerationTemplate et = (EnumerationTemplate) t;
		Map<String, SequenceElement> mappings = new HashMap<String, SequenceElement>();
		for (EnumLiteralMapping mapping : et.getMappings()) {
		    mappings.put(mapping.getLiteral().getName(), mapping.getElement());
		}
		nonClassTemplates.put(TcsUtil.joinNameList(name), mappings);
	    } else if (t instanceof PrimitiveTemplate) {
		PrimitiveTemplate pt = (PrimitiveTemplate) t;
		primitiveTemplates.put(pt.getTemplateName(), pt);
		Collection<Object> c = (Collection<Object> ) nonClassTemplates.get(TcsUtil.joinNameList(name));
		if (c == null) {
		    c = new ArrayList<Object>();
		    nonClassTemplates.put(TcsUtil.joinNameList(name), c);
		}
		c.add(pt);
	    } else {
		// ClassTemplate handled by classTemplateMap instead
		if (!(t instanceof ClassTemplate)) {
		    nonClassTemplates.put(TcsUtil.joinNameList(name), t);
		}
	    }
	}
    }
    
    private void serialize(EObject ame) throws SyntaxMismatchException {
	serialize(ame, /*mode*/null, /*template*/null);
    }

    private void serialize(EObject ame, String mode, Template template) throws SyntaxMismatchException {
	if (currentContext.getVisitedModelElements().contains(ame)) {
	    // don't visit model elements recursively
	    return;
	} else {
	    // add the model element to the visited list.
	    // it is removed again at the end of this method
	    currentContext.getVisitedModelElements().add(ame);
	}

	debug("processing " + EMFModelInspector.getTypeName(ame));
	if (template == null) {
	    template = findTemplate(ame, mode, EMFModelInspector.getTypeName(ame));
	}
	
	debug("Applying template type " + EMFModelInspector.getTypeName(template));
	if (template instanceof ClassTemplate) {
	    debug("with mode: " + ((ClassTemplate) template).getMode());
	}

	printer.useDefaultSeparator();
	if (template instanceof ClassTemplate) {
	    serializeClassTemplate(ame, (ClassTemplate) template);
	} else if (template instanceof OperatorTemplate) {
	    serializeOperatorTemplate(ame, (OperatorTemplate) template);
	} else {
	    error("unsupported template type: " + EMFModelInspector.getTypeName(template));
	}
	printer.resetSeparator();

	// remove element so it can be prettyprinted in other places
	currentContext.getVisitedModelElements().remove(ame);
    }
    
    
    private Template findTemplate(EObject ame, String mode, String typeName) throws NoTemplateMatchFoundException {
	Template template = null;
	ClassTemplate ct = TcsUtil.resolveClassTemplate(TcsUtil.getQualifiedName(ame.eClass()), mode, classTemplateMap);
	if (ct != null && !ct.isIsAbstract()) {
	    template = ct;
	}
	if (template == null) {
	    // look for non-abstract template for supertype
	    template = findSupertypeTemplate(ame, mode, classTemplateMap);
	}

	if (template == null) {
	    template = (nonClassTemplates.get(typeName) instanceof Template) ? (Template) nonClassTemplates.get(typeName) : null;
	}

	if (template == null) {
	    if (mode != null) {
		error("unknown template for " + typeName + " #" + mode);
	    } else {
		error("unknown template for " + typeName);
	    }
	    throw new NoTemplateMatchFoundException(currentContext, ame, typeName, mode);
	}
	return template;
    }
    
    private void serializeClassTemplate(EObject ame, ClassTemplate template) throws SyntaxMismatchException {
	currentContext.getPriorities().push(Integer.MAX_VALUE);
	currentContext.getClassTemplates().push(template);
	currentContext.getParentEObjects().push(ame);
	int handle = printer.startClassTemplateForObject(ame, template);

	serializeSequence(ame, template.getTemplateSequence());

	printer.endClassTemplate(handle);
	currentContext.getParentEObjects().pop();
	currentContext.getClassTemplates().pop();
	currentContext.getPriorities().pop();
    }

    private void serializeOperatorTemplate(EObject ame, OperatorTemplate template) throws SyntaxMismatchException {
	int handle = printer.startClassTemplateForObject(ame, template);
	String sourcePropName = TcsUtil.getPropertyName(template.getStoreLeftSideTo());
	String opPropName = TcsUtil.getPropertyName(template.getStoreOperatorTo());
	String rightPropName = TcsUtil.getPropertyName(template.getStoreRightSideTo());
	debug("OperatorTemplate: left = " + sourcePropName + " ; operator = " + opPropName + " ; right = " + rightPropName);

	Object r = null;
	boolean isPostfix = false; // only valid for unary operators
	boolean isUnary = false;
	if (rightPropName != null) {
	    r = EMFModelInspector.get(ame, rightPropName);
	    if (r instanceof Collection<?>) {
		isUnary = (((Collection<?>) r).size() == 0);
	    } else {
		isUnary = r == null;
	    }
	} else {
	    isUnary = true;
	}
	debug("rightPropName = " + rightPropName + " ; isUnary = " + isUnary);

	Operator operator = null;
	if (opPropName != null) {
	    String op = EMFModelInspector.getString(ame, opPropName);
	    if (op == null) {
		throw new RuntimeException("Property " + opPropName + " has not been set in " + ame);
	    }
	    for (Iterator<Operator> i = template.getOperators().iterator(); i.hasNext() && (operator == null);) {
	        Operator opme = i.next();
		Literal literal = opme.getLiteral();
		String opmes = null;
		if (literal == null) {
		    opmes = "";
		} else {
		    opmes = literal.getValue();
		}
		int arity = opme.getArity();
		if (op.equals(opmes)) {
		    if (rightPropName != null) {
			if ((isUnary && (arity == 1)) || ((!isUnary) && (arity == 2))) {
			    operator = opme;
			}
		    } else {
			operator = opme;
			isPostfix = opme.isPostfix();
		    }
		}
	    }
	    if (operator == null) {
		System.err.println("Error: could not find operator \"" + op + "\"");
	    }
	} else {
	    operator = template.getOperators().iterator().next();
	    isUnary = operator.getArity() == 1;
	    if (isUnary) {
		isPostfix = operator.isPostfix();
	    }
	}
	int curPrio = currentContext.getPriorities().peek().intValue();
	Operator op = operator;
	int priority = ((Priority) op.eContainer()).getValue();
	boolean paren = priority > curPrio;
	currentContext.getPriorities().push(priority);
	Literal literal = operator.getLiteral();
	debug("PRIORITY = " + priority + " ; CURPRIO = " + curPrio + " ; OPERATOR = "
		+ ((literal != null) ? literal.getValue() : "") + " ; paren = " + paren);

	if (paren) {
	    printer.printSymbol("(");
	}

	EObject source = (EObject) EMFModelInspector.get(ame, sourcePropName);
	if (isUnary) {
	    if (isPostfix) {
		serialize(source);
		if (literal != null) {
		    printer.printLiteral(literal);
		}
	    } else {
		if (literal != null) {
		    printer.printLiteral(literal);
		}
		serialize(source);
	    }
	} else {
	    serialize(source);
	    if (literal != null) {
		printer.printLiteral(literal);
	    }
	}

	Sequence seq = template.getTemplateSequence();
	if (rightPropName == null) {
	    currentContext.getPriorities().push(Integer.MAX_VALUE);
	    serializeSequence(ame, seq);
	    currentContext.getPriorities().pop();
	} else {
	    if (seq != null) {
		serializeSequence(ame, seq);
	    }
	    if (r instanceof Collection<?>) {
		for (Iterator<?> i = ((Collection<?>) r).iterator(); i.hasNext();) {
		    serialize((EObject) i.next());
		}
	    } else {
		if (!isUnary) {
		    serialize((EObject) r);
		}
	    }
	}
	currentContext.getPriorities().pop();
	if (paren) {
	    printer.printSymbol(")");
	}

	printer.endClassTemplate(handle);
    }

// FIXME: Structure types not yet supported
//    private void serializeStruct(RefStruct s, String mode, Connection connection) throws SyntaxMismatchException {
//	String typeName = TcsUtil.joinNameList(s.refTypeName());
//	debug("processing " + typeName);
//
//	Object template = findTemplateForStruct(s, mode, connection, typeName);
//	String templateTypeName = MOINImportedModelAdapter.getTypeName((EObject) template);
//	debug("Applying template type " + templateTypeName);
//
//	if (template instanceof ClassTemplate) {
//	    debug("with mode: " + ((ClassTemplate) template).getMode());
//	}
//
//	printer.useDefaultSeparator();
//	if (templateTypeName.equals("FURCAS::TCS::ClassTemplate")) {
//	    currentContext.getPriorities().push(Integer.MAX_VALUE);
//	    currentContext.getClassTemplates().push((ClassTemplate) template);
//             
//	    serializeSequence(s, MOINImportedModelAdapter.getME((EObject) template, "templateSequence"));
//
//	    currentContext.getClassTemplates().pop();
//	    currentContext.getPriorities().pop();
//	    
//	} else if (templateTypeName.equals("FURCAS::TCS::OperatorTemplate")) {
//	    throw new RuntimeException("OperatorTemplates are not yet supported for StructureTypes");
//	} else {
//	    error("unsupported template type: " + templateTypeName);
//	}
//	printer.resetSeparator();
//    }

// FIXME: Structure types not yet supported
//    private Object findTemplateForStruct(RefStruct s, String mode, Connection connection, String typeName)
//	    throws NoTemplateMatchFoundException {
//	Object template = null;
//	ClassTemplate ct = TcsUtil.resolveClassTemplate(s.refTypeName(), mode, classTemplateMap);
//	if (ct != null && !ct.isIsAbstract()) {
//	    template = ct;
//	}
//
//	if (template == null) {
//	    // look for non-abstract template for supertype
//	    template = findSupertypeTemplate(s, mode, classTemplateMap, connection);
//	}
//
//	if (template == null) {
//	    // look for non-class templates
//	    template = nonClassTemplates.get(typeName);
//	}
//
//	if (template == null) {
//	    if (mode != null) {
//		error("unknown template for " + typeName + " #" + mode);
//	    } else {
//		error("unknown template for " + typeName);
//	    }
//	    throw new NoTemplateMatchFoundException(currentContext, s, typeName, mode);
//	}
//	return template;
//    }

    private void serializePrimitiveTemplate(Object value, String as) {
	if (value instanceof String) {
	    // TODO what about serializer attribute?
	    PrimitiveTemplate template = primitiveTemplates.get(as);
	    if (template != null) {
	        if (template.getSerializer() != null && !template.getSerializer().equals("")) {
	            printer.printCustomStringLiteral(template.getSerializer().replaceAll("%value%",
	                   Matcher.quoteReplacement(((String) value).replaceAll("\"", "\\\\\\\""))), "");
		} else {
		    printer.printDefault((String) value);
		}
	    } else if ("stringSymbol".equals(as)) {
	        // TODO what about tokens and token attribute?
		printer.printStringLiteral((String) value);
	    } else {
                printer.printIdentifier((String) value, /*orKeyword*/ false);
	    }
	} else if (value instanceof Integer) {
	    printer.printIntegerLiteral((Integer) value);
	} else if (value instanceof Double) {
	    printer.printRealLiteral(((Double) value));
	} else if (value instanceof Boolean) {
	    printer.printBooleanLiteral(((Boolean) value));
	}
    }

    private void serializeProperty(Object element, Object value, Property property, boolean checkBounds)
	    throws SyntaxMismatchException {
	if (checkBounds) {
	    validateBounds(element, property, value);
	}

	RefersToPArg refersToPArg = PropertyArgumentUtil.getRefersToPArg(property);
	AsPArg asPArg = PropertyArgumentUtil.getAsPArg(property);
	LookupScopePArg scope = PropertyArgumentUtil.getLookupScopePArg(property);
	String primitiveTemplateName = null;

	if (asPArg != null) {
	    Template asTemplate = asPArg.getTemplate();
	    if (asTemplate instanceof PrimitiveTemplate) {
		PrimitiveTemplate prim = (PrimitiveTemplate) asTemplate;
		primitiveTemplateName = prim.getTemplateName();
	    }
	}

	if (value == null) {
	    return;
	}
	if (value instanceof Collection) {
	    SeparatorPArg separator = PropertyArgumentUtil.getSeparatorPArg(property);
	    Sequence sep = null; 
	    if (separator != null) {
		sep = separator.getSeparatorSequence();
	    }
	    boolean first = true;
	    for (Iterator<?> i = ((Collection<?>) value).iterator(); i.hasNext();) {
		if (first) {
		    printer.printIndentationIfNeeded();
		    first = false;
		} else {
		    printer.printSeparatorIfNeeded();
		}

		Object currentPropValue = i.next();
		serializePropertyCheckingPartial(element, currentPropValue, property, false /* bounds already checked */);
		if (i.hasNext()) {
		    if (sep != null) {
			serializeSequence(null, sep);
		    }
		}
	    }
// FIXME: Structure types not yet supported
//	} else if (value instanceof RefStruct) {
//	    RefStruct s = (RefStruct) value;
//	    ModePArg modeArg = (ModePArg) getPropertyArgument(property, "Mode");
//	    String mode = null;
//	    if (modeArg != null) {
//		mode = modeArg.getMode();
//	    }
//
//	    serializeStruct(s, mode, property.get___Connection());
	} else if (value instanceof Enum) {
	    EEnum eenum = (EEnum) TcsUtil.getType(property);
	    String enumName = TcsUtil.joinNameList(EcoreHelper.getQualifiedName(eenum));
	    String enumLiteral = value.toString();
	    @SuppressWarnings("unchecked")
            Map<String, SequenceElement> mappings = (Map<String, SequenceElement>) nonClassTemplates.get(enumName);
	    serializeSequenceElement(element, mappings.get(enumLiteral));
	} else if (value instanceof EObject) {
	    EObject valueME = (EObject) value;
	    printer.printIndentationIfNeeded();

	    if (scope != null) {
	        ReferenceByPArg referenceBy = PropertyArgumentUtil.getReferenceByPArg(property);
		String invertQuery = PropertyArgumentUtil.getReferenceByAsOCL(referenceBy);
		try {
		    TCSSpecificOCLEvaluator oclEvaluator = new TCSSpecificOCLEvaluator();
		    String refValue = (String) oclEvaluator.findElementsWithOCLQuery(valueME, /*keyValue*/ null, invertQuery).iterator().next();
		    refValue = PropertyArgumentUtil.stripPrefixPostfix(refValue, PropertyArgumentUtil.getPrefixPArg(property), PropertyArgumentUtil.getPostfixPArg(property));
		    this.serializePrimitiveTemplate(refValue, primitiveTemplateName);
		} catch (ModelAdapterException e) {
		    error("Unable to serialize referenced model element: " + e.getMessage());
		}
	    } else if (refersToPArg == null) {
		String mode = TcsUtil.getMode(property);
		serialize(valueME, mode, /*template*/ null);
	    } else {
		Object v = EMFModelInspector.get(valueME, refersToPArg.getPropertyName());
		serializePrimitiveTemplate(v, primitiveTemplateName);
	    }
	} else if (EMFModelInspector.isPrimitive(value)) {
	    printer.printIndentationIfNeeded();
	    serializePrimitiveTemplate(value, primitiveTemplateName);
	} else {
	    error("unsupported " + value.getClass());
	}
    }

    /**
     * 	Ignore PropertyInitExceptions on a per entry basis of the collection if partial is set
     */
    private void serializePropertyCheckingPartial(Object element, Object currentPropValue, Property property, boolean checkBounds)
	    throws SyntaxMismatchException {
	// partial properties emit nothing on model validation errors
	// instead of  throwing an exception

	int handle = 0;
	PartialPArg partialArg = PropertyArgumentUtil.getPartialPArg(property);
	if (partialArg != null) {
	    handle = createSafePoint();
	}

	try {
	    serializeProperty(element, currentPropValue, property, checkBounds);
	} catch (SyntaxMismatchException e) {
	    debugPropertyInitException(e);
	    if (partialArg != null) {
		debugPropertyInitException("is ignored due to partial property");
		// remove partial output of this property and remove the exception
		resetToSafePoint(handle);
	    } else {
		// re-throw exception, this property has to be printed
		// without errors
		throw e;
	    }
	}
    }

    private void serializeSequence(Object ame, Sequence sequence) throws SyntaxMismatchException {
	if (sequence != null) {
	    for (SequenceElement element : sequence.getElements()) {
		serializeSequenceElement(ame, element);
	    }
	}
    }

    private void serializeSequenceElement(Object element, SequenceElement seqElem) throws SyntaxMismatchException {
	printer.enterSequenceElement(seqElem);
	
	debug("serializing seq elem " + EMFModelInspector.getTypeName(seqElem));
	if (seqElem instanceof Property) {
	    serializeSEProperty(element, (Property) seqElem);
	} else if (seqElem instanceof LiteralRef) {
	    serializeSELiteralRef((LiteralRef) seqElem);
	} else if (seqElem instanceof Alternative) {
	    serializeSEAlternative(element, (Alternative) seqElem);
	} else if (seqElem instanceof Block) {
	    serializeSEBlock(element, (Block) seqElem);
	} else if (seqElem instanceof FunctionCall) {
	    serializeSequence(element, ((FunctionCall) seqElem).getCalledFunction().getFunctionSequence());
	} else if (seqElem instanceof ConditionalElement) {
	    serializeSEConditional(element, (ConditionalElement) seqElem);
	} else if (seqElem instanceof CustomSeparator) {
	    serializeSECustomSeparator((CustomSeparator) seqElem);
	} else if (seqElem instanceof InjectorActionsBlock) {
	    serializeSEInjectorActionsBlock(element, (InjectorActionsBlock) seqElem);
	} else {
	    error("unsupported: " + EMFModelInspector.getTypeName(seqElem));
	}
	printer.exitSequenceElement();
    }

    private void serializeSELiteralRef(LiteralRef litRef) {
	printer.printLiteral(litRef.getReferredLiteral());
    }

    private void serializeSEInjectorActionsBlock(Object element, InjectorActionsBlock iab)
	    throws PropertyInitException {
	// check all contained property inits
	for (InjectorAction action : iab.getInjectorActions()) {
	    if (action instanceof PrimitivePropertyInit) {
		validatePrimitivePropertyInit(element, (PrimitivePropertyInit) action);
	    }

	    if (action instanceof LookupPropertyInit) {
		validateLookupPropertyInit(element, (LookupPropertyInit) action);
	    }
	}
    }

    private void serializeSEAlternative(Object element, Alternative alt) throws SyntaxMismatchException {
	printer.printIndentationIfNeeded();
	printer.enterAlternative(alt);
	
	List<SequenceInAlternative> sortedAlternativeSequences = policy.getSequenceElementsOfCurrentAlternativeInPreferredOrder(alt);

	// try each sequence and backtrack on InjectorActionError
	for (int i = 0; i < sortedAlternativeSequences.size(); i++) {
	    Sequence choice = sortedAlternativeSequences.get(i);
	    int choiceIndex  = getOriginalSequenceChoiceIndex(choice, alt);
	    int handle = 0;
	    try {
		handle = createSafePoint();
		printer.beginAlternativeChoice(choiceIndex);
		serializeSequence(element, choice);
		// successful print, don't print other alternatives
		break;
	    } catch (SyntaxMismatchException e) {
		debugPropertyInitException(e);

		// unsuccessful print, try other alternatives
		resetToSafePoint(handle);
		
		// if this is the last possible alternative and the
		// alternative is not multi (with *), re-throw
		// exception
		if (i == sortedAlternativeSequences.size() - 1 && !alt.isIsMulti()) {
		    debugPropertyInitException("is last alternative" + choiceIndex + ". Giving up.");
		    throw (e);
		} else {
		    debugPropertyInitException("is alternative " + choiceIndex + " which failed. Trying next one.");
		}
	    }
	}
	printer.exitAlternative();
    }
    
    private int getOriginalSequenceChoiceIndex(Sequence choice, Alternative alt) {
	ArrayList<Sequence> list = new ArrayList<Sequence>(alt.getSequences());
	return list.indexOf(choice);
    }

    private void serializeSEConditional(Object element, ConditionalElement conditionalElement) throws SyntaxMismatchException {
	if (TCSConditionEvaluator.eval(element, conditionalElement.getCondition())) {
	    Sequence tseq = conditionalElement.getThenSequence();
	    if (tseq != null) {
		printer.printIndentationIfNeeded();
		serializeSequence(element, tseq);
	    }
	} else {
	    Sequence eseq = conditionalElement.getElseSequence();
	    debug("ELSE SEQ = " + eseq);
	    if (eseq != null) {
		printer.printIndentationIfNeeded();
		serializeSequence(element, eseq);
	    }
	}
    }

    private void serializeSEBlock(Object element, Block block) throws SyntaxMismatchException {
	debugWhiteSpace("<block>");
	NbNLBArg nbNLBArg = TcsUtil.getNbNLBArg(block);
	StartNbNLBArg startNbNLBArg = TcsUtil.getStartNbNLBArg(block);
	IndentIncrBArg indentIncrBArg = TcsUtil.getIndentIncrBArg(block);
	StartNLBArg startNLBArg = TcsUtil.getStartNLBArg(block);
	EndNLBArg endNLBArg = TcsUtil.getEndNLBArg(block);
	int indentIncr = 1; // how much to increase the indentation level
	int nbNL = 1; // number of new lines before each element in the block
	boolean startNL = true; // start to print block on a new line
	boolean endNL = true; // print empty, indented line after the block content was printed

	if (nbNLBArg != null) {
	    nbNL = nbNLBArg.getValue();
	}
	int startNbNL = nbNL; // by default, startNbNL = nbNL // says how many lines we want at the beginning of the block
	if (startNbNLBArg != null) {
	    startNbNL = startNbNLBArg.getValue();
	}
	if (indentIncrBArg != null) {
	    indentIncr = indentIncrBArg.getValue();
	}
	if (startNLBArg != null) {
	    startNL = startNLBArg.isValue();
	}
	if (endNLBArg != null) {
	    endNL = endNLBArg.isValue();
	}
	debug("nbNL = " + nbNL + " ; indentIncr = " + indentIncr);
	currentContext.incIndentLevel(indentIncr);


	if (nbNL == 0) {
	    // no new lines wanted; use the standard spacing instead
	    printer.useDefaultSeparator();
	} else {
	    printer.useCustomSeparator(getLineFeeds(nbNL) + currentContext.getCurIndent());
	}
	
	debugWhiteSpace("<BeforeFirstWS/>");
	if (startNL) {
	    if (startNbNL == 0) {
		printer.printCustomWhiteSpace("");
	    } else if (nbNL == startNbNL) {
		printer.printSeparator();
	    } else {
		printer.printCustomWhiteSpace(getLineFeeds(startNbNL) + currentContext.getCurIndent());
	    }
	} else {
	    debugWhiteSpace("<BeforeNonStartNLWS/>");
	    printer.printCustomWhiteSpace(""); // to make sure the last item was a TYPE_SPACE
	    debugWhiteSpace("<AfterNonStartNLWS/>");
	}
	debugWhiteSpace("<blockContent>");
	serializeSequence(element, block.getBlockSequence());
	debugWhiteSpace("</blockContent>");

	currentContext.decIndentLevel(indentIncr);
	if (endNL) {
	    printer.printCustomWhiteSpace(LINE_FEED + currentContext.getCurIndent());
	}
	printer.resetSeparator();
	debugWhiteSpace("</block>");

    }
    
    private String getLineFeeds(int n) {
	String ret = "";
	for (int i = 0; i < n; i++) {
	    ret += LINE_FEED;
	}
	return ret;
    }

    private void serializeSEProperty(Object element, Property prop) throws SyntaxMismatchException {
	Object v = null;
// FIXME: Structure types not yet supported
//	if (element instanceof RefStruct) {
//	    v = TcsUtil.getPropertyValue((RefStruct) element, prop.getPropertyReference());
//
//	} else if (element instanceof EObject) {
	    v = TcsUtil.getPropertyValue((EObject) element, prop.getPropertyReference());
//	}
	// also check for partial property arg
	serializePropertyCheckingPartial(element, v, prop, true);
    }

    private void serializeSECustomSeparator(CustomSeparator seqElem) {
	String name = seqElem.getName();
	if (name.equals("no_space")) {
	    currentContext.setTypeLast(TYPE_SYMBOL + SYMBOL_RIGHT_NONE);
	} else if (name.equals("space")) {
	    printer.printCustomWhiteSpace(" ");
	} else if (name.equals("newline")) {
	    printer.printCustomWhiteSpace(LINE_FEED);
	} else if (name.equals("tab")) {
	    printer.printCustomWhiteSpace("\t");
	}
    }

    private void validateBounds(Object element, Property p, Object propValue) throws ForcedBoundsException {

	// check for forced upper and forced lower validity of model element
	ForcedLowerPArg lowerArg = PropertyArgumentUtil.getForcedLowerPArg(p);
	ForcedUpperPArg upperArg = PropertyArgumentUtil.getForcedUpperPArg(p);

	if (lowerArg != null) {

	    int lowerBound = lowerArg.getValue();

	    if (propValue == null) {
		if (lowerBound != 0) {
		    throw new ForcedBoundsException(element, p, lowerArg, upperArg, currentContext);
		}
	    }

	    if (propValue instanceof Collection<?>) {
		Collection<?> c = (Collection<?>) propValue;
		if (lowerBound > c.size()) {
		    throw new ForcedBoundsException(element, p, lowerArg, upperArg, currentContext);
		}
	    } else {
		if (lowerBound > 1) {
		    throw new ForcedBoundsException(element, p, lowerArg, upperArg, currentContext);
		}
	    }
	}

	if (upperArg != null) {
	    int upperBound = upperArg.getValue();

	    if (propValue instanceof Collection<?>) {
		Collection<?> c = (Collection<?>) propValue;
		if (upperBound < c.size()) {
		    // TODO find out what should happen. not possible to
		    // identify element or should throw exception?
		    // throw new Exception();
		}
	    }
	}
    }

    private void validateLookupPropertyInit(Object element, LookupPropertyInit p) throws PropertyInitException {

	if (element != null && p != null) {
	    // only validate PropertyInit, if it is mandatory and not just a
	    // default for the parser
	    if (p.isDefault()) {
		return;
	    }

	    Object prop = null;
// FIXME: Structure types not yet supported
//	    if (element instanceof RefStruct) {
//		prop = TcsUtil.getPropertyValue((RefStruct) element, p.getPropertyReference());
//	    } else if (element instanceof EObject) {
		prop = TcsUtil.getPropertyValue((EObject) element, p.getPropertyReference());
//	    }

	    String oclQuery = p.getValue();
	    EObject contextObject = computeContextObject(oclQuery);

	    Collection<?> expectedValue = null;
	    try {
		if (element instanceof EObject) {
		    // keyValue is always null for LookUpPropertyInits
		    // in QueryPArg it denotes the RefersToPArg propertyValue
		    expectedValue = TcsUtil.executeOclQuery((EObject) element, oclQuery, contextObject, /*foreachObject*/ null, null);
		}
	    } catch (ModelAdapterException e) {
		throw new PropertyInitException(element, p, currentContext);
	    }

	    // oclHelper.findElementWithOCLQuery returns null for empty
	    // collections
	    // TODO incremental pretty printing of templates that are partial in
	    // main template context fail
	    if (!TcsUtil.isPropValueAndOclResultEqual(prop, expectedValue)) {
		throw new PropertyInitException(element, p, currentContext);
	    }

	}
    }
    
    private EObject computeContextObject(String oclQuery) {
	String tag = TcsUtil.getContextTag(oclQuery);
	return PrettyPrintContext.getContextElement(currentContext, tag);
    }

    private void validatePrimitivePropertyInit(Object element, PrimitivePropertyInit p) throws PropertyInitException {

	if (element != null && p != null) {

	    // only validate PropertyInit, if it is mandatory and not just a
	    // default for the parser
	    if (p.isDefault()) {
		return;
	    }

	    Object prop = null;
// FIXME: Structure types not yet supported
//	    if (element instanceof RefStruct) {
//		prop = TcsUtil.getPropertyValue((RefStruct) element, p.getPropertyReference());
//	    } else if (element instanceof EObject) {
		prop = TcsUtil.getPropertyValue((EObject) element, p.getPropertyReference());
//	    }

	    String propValue = "";
	    if (prop != null) {
		if (prop instanceof EEnum) {
		    propValue = prop.getClass().getName() + "." + prop.toString().toUpperCase();
		} else {
		    propValue = prop.toString();
		}
	    }

	    String expectedValue = p.getValue();

	    // TODO this is a HACK until no more java code allowed in
	    // primitive
	    // property inits
	    if (expectedValue != null) {
		if (expectedValue.startsWith("\"")) {
		    expectedValue = expectedValue.substring(1, expectedValue.length() - 1);
		}
	    }

	    if (!propValue.equals(expectedValue)) {
		throw new PropertyInitException(element, p, currentContext);
	    }
	}
    }

    private int createSafePoint() {
	int handle = printer.createSafePoint();
	backtrackingContextBackup.put(handle, currentContext.clone());
	return handle;
    }
    
    private void resetToSafePoint(int handle) {
	currentContext = backtrackingContextBackup.get(handle);
	printer.resetToSafePoint(handle, currentContext);
    }
    
    private void error(String msg) {
	String errogMsg = msg + " at " + Arrays.toString(new RuntimeException().getStackTrace());
	System.out.println("ERROR: " + errogMsg);
    }

}
