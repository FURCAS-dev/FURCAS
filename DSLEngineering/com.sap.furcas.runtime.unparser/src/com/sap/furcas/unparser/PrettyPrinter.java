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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
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
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.BlockArgumentUtil;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.PrettyPrinterUtil;
import com.sap.furcas.unparser.PrettyPrintExceptions.ForcedBoundsException;
import com.sap.furcas.unparser.PrettyPrintExceptions.NoTemplateMatchFoundException;
import com.sap.furcas.unparser.PrettyPrintExceptions.OperatorTemplateOperatorMissmatchException;
import com.sap.furcas.unparser.PrettyPrintExceptions.PropertyInitException;
import com.sap.furcas.unparser.PrettyPrintExceptions.SyntaxMismatchException;
import com.sap.furcas.unparser.extraction.TCSExtractorStream;

/**
 * @author Frédéric Jouault
 * @author Mikaël Barbero
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
    
    private final SyntaxLookup syntaxLookup;
    private final IMetaModelLookup<EObject> metamodelLookup;
    private final TCSSpecificOCLEvaluator oclEvaluator;

    private TCSExtractorStreamPrinter printer;
    private PrettyPrintContext currentContext;
    private final Map<Integer, PrettyPrintContext> backtrackingContextBackup = new HashMap<Integer, PrettyPrintContext>();

    private final PrettyPrintingPolicy policy;
    private final PrettyPrintingTracer tracer;
    private final ConcreteSyntax syntax;
    
    
    public PrettyPrinter(ConcreteSyntax syntax, IMetaModelLookup<EObject> metamodelLookup) {
	this(new DefaultPolicy(), new NullTracer(), syntax, metamodelLookup);
    }
    
    public PrettyPrinter(PrettyPrintingPolicy policy, PrettyPrintingTracer tracer, ConcreteSyntax syntax, IMetaModelLookup<EObject> metamodelLookup) {
        this.currentContext = new PrettyPrintContext();
        this.policy = policy;
        this.tracer = tracer;
        this.metamodelLookup = metamodelLookup;
        this.oclEvaluator = new TCSSpecificOCLEvaluator();

        this.syntax = syntax;
        MetaModelElementResolutionHelper<EObject> resolutionHelper = new MetaModelElementResolutionHelper<EObject>(metamodelLookup);
        this.syntaxLookup = new SyntaxLookup(syntax, resolutionHelper);
    }
    
    /**
     * Pretty print the given root model element.
     * 
     * @param modelElementToPrint
     * @param targetOutputStream
     *                       
     * @throws SyntaxAndModelMismatchException
     */
    public void prettyPrint(EObject modelElementToPrint, TCSExtractorStream targetOutputStream) throws SyntaxAndModelMismatchException {
	prettyPrint(modelElementToPrint, targetOutputStream, /*template*/ null, /*preconfiguredPrettyPrintContext*/ null);
    }
        
    /**
     * Pretty print the given model element. The model element does not need to be a root model element.
     * This however requires knowledge about the correct template and a prepared pretty print context.
     * 
     * @param modelElementToPrint
     * @param targetOutputStream
     * @param template Template for the corresponding ModelElement
     * @param currentContext if Template is no main Template a context has to be built
     *                       first otherwise this can be null
     *                       
     * @throws SyntaxAndModelMismatchException
     */
    public void prettyPrint(EObject modelElementToPrint, TCSExtractorStream targetOutputStream, Template template,
	    PrettyPrintContext preconfiguredPrettyPrintContext) throws SyntaxAndModelMismatchException {
        
        if (preconfiguredPrettyPrintContext == null && template != null && (!(template instanceof ClassTemplate) ||
                !((ClassTemplate) template).isIsMain())) {
            throw new IllegalArgumentException("Non-Main templates must provide prettyprint context");
        }
	if (preconfiguredPrettyPrintContext != null) {
	    this.currentContext = preconfiguredPrettyPrintContext;
	}

        printer = new TCSExtractorStreamPrinter(syntax, targetOutputStream, currentContext, policy, tracer);

	currentContext.getPriorities().push(Integer.MAX_VALUE);
	int handle = createSafePoint();
	try {
	    if (template == null || !(template instanceof ClassTemplate)) {
		serialize(modelElementToPrint, /*mode*/ null);
	    } else {
		ClassTemplate clsTemplate = (ClassTemplate) template;
		serialize(modelElementToPrint, clsTemplate.getMode());
	    }
	} catch (SyntaxMismatchException e) {
	    resetToSafePoint(handle);
	    throw new SyntaxAndModelMismatchException(e);
	}
	printer.close();
    }
    
    private void serialize(EObject modelElement, String mode) throws SyntaxMismatchException {
        if (currentContext.getVisitedModelElements().contains(modelElement)) { // FIXME: should that be template specific?
            // don't visit model elements recursively
            return;
        } else {
            currentContext.getVisitedModelElements().add(modelElement);
        }

        printer.useDefaultSeparator();
        try {
            for (Template template : findBestMatchingTemplates(modelElement.eClass(), mode)) {
                int handle = createSafePoint();
                try {
                    debug("processing " + EMFModelInspector.getTypeName(modelElement));
                    debug("Applying template type " + EMFModelInspector.getTypeName(template));
                    if (template instanceof ClassTemplate) {
                        debug("with mode: " + ((ClassTemplate) template).getMode());
                        serializeClassTemplate(modelElement, (ClassTemplate) template);
                    } else if (template instanceof OperatorTemplate) {
                        serializeOperatorTemplate(modelElement, (OperatorTemplate) template);
                    }
                    return; // only print with one template
                } catch (SyntaxMismatchException e) {
                    resetToSafePoint(handle);
                }
            }
            throw new NoTemplateMatchFoundException(currentContext, modelElement,
                    EMFModelInspector.getTypeName(modelElement), mode);
        } finally {
            // remove element so it can be prettyprinted in other places
            currentContext.getVisitedModelElements().remove(modelElement);
            printer.resetSeparator();
        }
    }
    
    private Collection<Template> findBestMatchingTemplates(EClass eClass, String mode) {
        Collection<Template> templates = new ArrayList<Template>(1);
        try {
            ResolvedNameAndReferenceBean<EObject> resolvedName = metamodelLookup.resolveReferenceName(eClass);
            Collection<Template> candidates = syntaxLookup.getTCSTemplate(resolvedName, mode);
            for (Template  candidate : candidates) {
                if (candidate instanceof OperatorTemplate) {
                    templates.add(candidate);
                }
                if (candidate instanceof ClassTemplate && !((ClassTemplate) candidate).isIsAbstract()) {
                    templates.add(candidate);
                }
            }
            if (templates.isEmpty() ) {
                for (EClass supertype : eClass.getESuperTypes()) {
                    templates.addAll(findBestMatchingTemplates(supertype, mode));
                }
            }
            return templates;
        } catch (MetaModelLookupException e) {
            throw new RuntimeException(e);
        } catch (SyntaxElementException e) {
            throw new RuntimeException(e);
        }
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
		throw new OperatorTemplateOperatorMissmatchException(currentContext, op, template);
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
		serialize(source, /*mode*/null);
		if (literal != null) {
		    printer.printLiteral(literal);
		}
	    } else {
		if (literal != null) {
		    printer.printLiteral(literal);
		}
		serialize(source, /*mode*/null);
	    }
	} else {
	    serialize(source, /*mode*/null);
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
		    serialize(((EObject) i.next()), /*mode*/null);
		}
	    } else {
		if (!isUnary) {
		    serialize(((EObject) r), /*mode*/null);
		}
	    }
	}
	currentContext.getPriorities().pop();
	if (paren) {
	    printer.printSymbol(")");
	}

	printer.endClassTemplate(handle);
    }

    private void serializePrimitiveTemplate(Object value, PrimitiveTemplate template) {
	if (value instanceof String) {
	    if (template != null) {
	        printer.printDefault(PrettyPrinterUtil.escapeUsingSerializer((String) value, template));
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

    private void serializeProperty(Object element, Object value, Property property, boolean checkBounds) throws SyntaxMismatchException {
	if (checkBounds) {
	    validateBounds(element, property, value);
	}
	if (value == null) {
	    return;
	}

	RefersToPArg refersToPArg = PropertyArgumentUtil.getRefersToPArg(property);
	LookupScopePArg scope = PropertyArgumentUtil.getLookupScopePArg(property);
	AsPArg asPArg = PropertyArgumentUtil.getAsPArg(property);
	
        PrimitiveTemplate primitiveTemplate = null;
        if (asPArg != null && asPArg.getTemplate() instanceof PrimitiveTemplate) {
            primitiveTemplate = (PrimitiveTemplate) asPArg.getTemplate();
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
	} else if (value instanceof Enum) {
	    EnumerationTemplate template = findEnumerationTemplate((EEnum) TcsUtil.getType(property));
	    String enumLiteral = value.toString();
	    if (template.isAutomatic()) {
	        printer.printDefault(enumLiteral);
	    } else {
	        for (EnumLiteralMapping mapping : template.getMappings()) {
	            if (mapping.getLiteral().getName().equals(enumLiteral)) {
	                serializeSequenceElement(element, mapping.getElement());
	                break;
	            }
	        }
	    }
	} else if (value instanceof EObject) {
	    EObject valueME = (EObject) value;
	    printer.printIndentationIfNeeded();

	    if (scope != null) {
	        try {
		    this.serializePrimitiveTemplate(PrettyPrinterUtil.invertReferenceByQuery(valueME, property, oclEvaluator), primitiveTemplate);
		} catch (ModelAdapterException e) {
		    error("Unable to serialize referenced model element: " + e.getMessage());
		}
	    } else if (refersToPArg == null) {
		String mode = TcsUtil.getMode(property);
		serialize(valueME, mode);
	    } else {
		Object v = EMFModelInspector.get(valueME, refersToPArg.getPropertyName());
		serializePrimitiveTemplate(v, primitiveTemplate);
	    }
	} else if (EMFModelInspector.isPrimitive(value)) {
	    printer.printIndentationIfNeeded();
	    serializePrimitiveTemplate(value, primitiveTemplate);
	} else {
	    error("unsupported " + value.getClass());
	}
    }

    private EnumerationTemplate findEnumerationTemplate(EEnum eenum) throws NoTemplateMatchFoundException {
        try {
            ResolvedNameAndReferenceBean<EObject> resolvedName = metamodelLookup.resolveReferenceName(eenum);
            Collection<Template> templates = syntaxLookup.getTCSTemplate(resolvedName, /*mode*/null);
            
            if (templates.size() != 1 || !(templates.iterator().next() instanceof EnumerationTemplate)) {
                throw new NoTemplateMatchFoundException(currentContext, eenum, TcsUtil.joinNameList(resolvedName.getNames()),
                        /*mode*/ null);
            }
            return (EnumerationTemplate) templates.iterator().next();
            
        } catch (MetaModelLookupException e) {
            throw new RuntimeException(e);
        } catch (SyntaxElementException e) {
            throw new RuntimeException(e);
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
	
	switch (seqElem.eClass().getClassifierID()) {
        case TCSPackage.PROPERTY:
            Property prop = (Property) seqElem;
            Object v = TcsUtil.getPropertyValue((EObject) element, prop.getPropertyReference());
            serializePropertyCheckingPartial(element, v, prop, true);
            break;
        case TCSPackage.LITERAL_REF:
            printer.printLiteral(((LiteralRef) seqElem).getReferredLiteral());
            break;
        case TCSPackage.ALTERNATIVE:
            serializeSEAlternative(element, (Alternative) seqElem);
            break;
        case TCSPackage.BLOCK:
            serializeSEBlock(element, (Block) seqElem);
            break;
        case TCSPackage.FUNCTION_CALL:
            serializeSequence(element, ((FunctionCall) seqElem).getCalledFunction().getFunctionSequence());
            break;
        case TCSPackage.CONDITIONAL_ELEMENT:
            serializeSEConditional(element, (ConditionalElement) seqElem);
            break;
        case TCSPackage.CUSTOM_SEPARATOR:
            serializeSECustomSeparator((CustomSeparator) seqElem);
            break;
        case TCSPackage.INJECTOR_ACTIONS_BLOCK:
            serializeSEInjectorActionsBlock(element, (InjectorActionsBlock) seqElem);
            break;
        default:
            error("unsupported: " + EMFModelInspector.getTypeName(seqElem));
	}
	printer.exitSequenceElement();
    }

    private void serializeSEInjectorActionsBlock(Object element, InjectorActionsBlock iab) throws PropertyInitException {
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
		// alternative is not multi (with *), re-throw exception
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
	NbNLBArg nbNLBArg = BlockArgumentUtil.getNbNLBArg(block);
	StartNbNLBArg startNbNLBArg = BlockArgumentUtil.getStartNbNLBArg(block);
	IndentIncrBArg indentIncrBArg = BlockArgumentUtil.getIndentIncrBArg(block);
	StartNLBArg startNLBArg = BlockArgumentUtil.getStartNLBArg(block);
	EndNLBArg endNLBArg = BlockArgumentUtil.getEndNLBArg(block);
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

    private void serializeSECustomSeparator(CustomSeparator seqElem) {
	String name = seqElem.getName();
	if (name.equals("no_space")) {
	    currentContext.setTypeLast(TYPE_SYMBOL + SYMBOL_RIGHT_NONE);
	} else if (name.equals("space")) {
	    printer.printCustomWhiteSpace(" ");
	} else if (name.equals("newline")) {
	    printer.printCustomWhiteSpace(LINE_FEED + currentContext.getCurIndent());
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
	if (element == null || p == null || p.isDefault()) {
	    // only validate PropertyInit, if it is mandatory and not just a
	    // default for the parser
	    return;
	}
        String oclQuery = p.getValue();
        EObject contextObject = computeContextObject(oclQuery);
        try {
            if (element instanceof EObject) {
                // keyValue is always null for LookUpPropertyInits
                // in QueryPArg it denotes the RefersToPArg propertyValue
                Collection<?> expectedValue = oclEvaluator.findElementsWithOCLQuery((EObject) element, /*key*/null, oclQuery,
                        contextObject, /*foreachObject*/null);

                Object actualValue = TcsUtil.getPropertyValue((EObject) element, p.getPropertyReference());
                if (!TcsUtil.isPropValueAndOclResultEqual(actualValue, expectedValue)) {
                    throw new PropertyInitException(element, p, currentContext);
                }
            }
        } catch (ModelAdapterException e) {
            throw new PropertyInitException(element, p, currentContext);
        }
    }
    
    private EObject computeContextObject(String oclQuery) {
	String tag = TcsUtil.getContextTag(oclQuery);
	return PrettyPrintContext.getContextElement(currentContext, tag);
    }

    private void validatePrimitivePropertyInit(Object element, PrimitivePropertyInit p) throws PropertyInitException {
        if (element == null || p == null || p.isDefault()) {
            // only validate PropertyInit, if it is mandatory and not just a
            // default for the parser
            return;
        }

       Object prop = TcsUtil.getPropertyValue((EObject) element, p.getPropertyReference());

        String actualValue = "";
        if (prop != null) {
            if (prop instanceof EEnum) {
                actualValue = prop.getClass().getName() + "." + prop.toString().toUpperCase();
            } else {
                actualValue = prop.toString();
            }
        }

        String expectedValue = p.getValue();
        // TODO this is a HACK until no more java code allowed in
        // primitive property inits
        if (expectedValue != null) {
            if (expectedValue.startsWith("\"")) {
                expectedValue = expectedValue.substring(1, expectedValue.length() - 1);
            }
        }
        if (!actualValue.equals(expectedValue)) {
            throw new PropertyInitException(element, p, currentContext);
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
