/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: PrettyPrinter.java,v 1.7 2008/07/02 18:33:39 fjouault Exp $
 */
package com.sap.ide.cts.editor.prettyprint.imported;

import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.LINE_FEED;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.SYMBOL_RIGHT_NONE;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintConstants.TYPE_SYMBOL;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintDebugHelper.debug;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintDebugHelper.debugPropertyInitException;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintDebugHelper.debugWhiteSpace;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintHelper.findSupertypeTemplate;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintHelper.getBlockArgument;
import static com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintHelper.getPropertyArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tcs.Alternative;
import tcs.AsParg;
import tcs.Block;
import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import tcs.ConditionalElement;
import tcs.CustomSeparator;
import tcs.EnumLiteralMapping;
import tcs.EnumerationTemplate;
import tcs.FilterParg;
import tcs.ForcedLowerParg;
import tcs.ForcedUpperParg;
import tcs.InjectorAction;
import tcs.InjectorActionsBlock;
import tcs.Keyword;
import tcs.LiteralRef;
import tcs.LookupPropertyInit;
import tcs.ModeParg;
import tcs.Operator;
import tcs.OperatorTemplate;
import tcs.PartialParg;
import tcs.PrimitivePropertyInit;
import tcs.PrimitiveTemplate;
import tcs.Priority;
import tcs.Property;
import tcs.RefersToParg;
import tcs.Sequence;
import tcs.SequenceElement;
import tcs.SequenceInAlternative;
import tcs.Template;

import com.sap.ide.cts.editor.prettyprint.MOINImportedModelAdapter;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintExceptions.ForcedBoundsException;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintExceptions.NoTemplateMatchFoundException;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintExceptions.PropertyInitException;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintExceptions.SyntaxMismatchException;
import com.sap.ide.cts.parser.Activator;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;
import com.sap.tc.moin.textual.moinadapter.adapter.AdapterJMIHelper;

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
	public void notifyStartedClassTemplateForObject(int handle, RefObject object, Template template) {}
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

    private AdapterJMIHelper oclHelper;
    private boolean serializeComments = PrettyPrintConstants.SERIALIZE_COMMENTS;

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
    public void prettyPrint(RefObject modelElementToPrint, ConcreteSyntax syntax, TCSExtractorStream targetOutputStream) throws SyntaxAndModelMismatchException {
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
    public void prettyPrint(RefObject modelElementToPrint, ConcreteSyntax syntax, TCSExtractorStream targetOutputStream, Template template) throws SyntaxAndModelMismatchException {
	
	if (template == null || (template instanceof ClassTemplate) && ((ClassTemplate) template).isMain()) {
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
    public void prettyPrint(RefObject modelElementToPrint, ConcreteSyntax syntax, TCSExtractorStream targetOutputStream, Template template,
	    PrettyPrintContext preconfiguredPrettyPrintContext) throws SyntaxAndModelMismatchException {

	if (preconfiguredPrettyPrintContext != null) {
	    this.currentContext = preconfiguredPrettyPrintContext;
	}
	initializeTemplateDataStructures(syntax);
	
	Connection con = TcsUtil.getConnectionFromRefObject(modelElementToPrint);
	oclHelper = new AdapterJMIHelper(modelElementToPrint.refOutermostPackage(), con, con.getJmiHelper(), /*scope*/null, /*additional scope*/ null);
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
    
    private void serialize(RefObject ame) throws SyntaxMismatchException {
	serialize(ame, /*mode*/null, /*template*/null);
    }

    private void serialize(RefObject ame, String mode, Template template) throws SyntaxMismatchException {
	if (currentContext.getVisitedModelElements().contains(ame)) {
	    // don't visit model elements recursively
	    return;
	} else {
	    // add the model element to the visited list.
	    // it is removed again at the end of this method
	    currentContext.getVisitedModelElements().add(ame);
	}

	String typeName = MOINImportedModelAdapter.getTypeName(ame);
	debug("processing " + typeName);
	if (template == null) {
	    template = findTemplate(ame, mode, typeName);
	}
	
	String templateTypeName = MOINImportedModelAdapter.getTypeName(template);
	debug("Applying template type " + templateTypeName);
	if (template instanceof ClassTemplate) {
	    debug("with mode: " + ((ClassTemplate) template).getMode());
	}

	printer.useDefaultSeparator();
	serializeBeforeComments(ame);
	if (templateTypeName.equals("TCS::ClassTemplate")) {
	    serializeClassTemplate(ame, template);
	} else if (templateTypeName.equals("TCS::OperatorTemplate")) {
	    serializeOperatorTemplate(ame, template);
	} else {
	    error("unsupported template type: " + templateTypeName);
	}
	serializeAfterComments(ame);
	printer.resetSeparator();

	// remove element so it can be prettyprinted in other places
	currentContext.getVisitedModelElements().remove(ame);
    }
    
    private void serializeBeforeComments(RefObject ame) {
	if (serializeComments) {
	    try {
		boolean first = true;
		boolean nl = false;
		for (Iterator<?> i = MOINImportedModelAdapter.getCol(ame, "commentsBefore"); i.hasNext();) {
		    String c = MOINImportedModelAdapter.nextString(i);
		    if (c.equals("\n")) {
			nl = true;
		    } else {
			debug("printing comment: \"" + c + "\"");
			if (first && !nl) {
			    printer.printComment(c);
			    // out.print("SHOULD-BE-NONL");
			} else {
			    printer.printComment(c);
			}
			printer.printCustomWhiteSpace(LINE_FEED + currentContext.getCurIndent());
			first = false;
		    }
		}
	    } catch (Exception e) {
		error("Warning: could not get comments of " + ame + ", disabling further comments serialization");
		serializeComments = false;
	    }
	}
    }
    
    private void serializeAfterComments(RefObject ame) {
	if (serializeComments) {
	    try {
		for (Iterator<?> i = MOINImportedModelAdapter.getCol(ame, "commentsAfter"); i.hasNext();) {
		    String c = MOINImportedModelAdapter.nextString(i);
		    if (c.equals("\n")) {

		    } else {
			printer.printComment(c);
			printer.printCustomWhiteSpace(LINE_FEED + currentContext.getCurIndent());
		    }
		}
	    } catch (Exception e) {
		error("Warning: could not get comments of " + ame + ", disabling further comments serialization");
		serializeComments = false;
	    }
	}
    }
    
    private Template findTemplate(RefObject ame, String mode, String typeName) throws NoTemplateMatchFoundException {
	Template template = null;
	ClassTemplate ct = TcsUtil.resolveClassTemplate(MOINImportedModelAdapter.getQualifiedName(ame), mode, classTemplateMap);
	if (ct != null && !ct.isAbstract()) {
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
    
    private void serializeClassTemplate(RefObject ame, Template template) throws SyntaxMismatchException {
	currentContext.getPriorities().push(Integer.MAX_VALUE);
	currentContext.getClassTemplates().push((ClassTemplate) template);
	currentContext.getParentRefObjects().push(ame);
	int handle = printer.startClassTemplateForObject(ame, template);

	serializeSequence(ame, MOINImportedModelAdapter.getME(template, "templateSequence"));

	printer.endClassTemplate(handle);
	currentContext.getParentRefObjects().pop();
	currentContext.getClassTemplates().pop();
	currentContext.getPriorities().pop();
    }

    private void serializeOperatorTemplate(RefObject ame, Template template) throws SyntaxMismatchException {
	int handle = printer.startClassTemplateForObject(ame, template);
	OperatorTemplate ot = (OperatorTemplate) template;
	String sourcePropName = TcsUtil.getPropertyName(ot.getStoreLeftSideTo());
	String opPropName = TcsUtil.getPropertyName(ot.getStoreOperatorTo());
	String rightPropName = TcsUtil.getPropertyName(ot.getStoreRightSideTo());
	debug("OperatorTemplate: left = " + sourcePropName + " ; operator = " + opPropName + " ; right = " + rightPropName);

	Object r = null;
	boolean isPostfix = false; // only valid for unary operators
	boolean isUnary = false;
	if (rightPropName != null) {
	    r = MOINImportedModelAdapter.get(ame, rightPropName);
	    if (r instanceof Collection<?>) {
		isUnary = (((Collection<?>) r).size() == 0);
	    } else {
		isUnary = r == null;
	    }
	} else {
	    isUnary = true;
	}
	debug("rightPropName = " + rightPropName + " ; isUnary = " + isUnary);

	Object operator = null;
	if (opPropName != null) {
	    String op = MOINImportedModelAdapter.getString(ame, opPropName);
	    if (op == null) {
		throw new RuntimeException("Property " + opPropName + " has not been set in " + ame + " ("
			+ MOINImportedModelAdapter.getMetaobject(ame) + ")");
	    }
	    for (Iterator<?> i = MOINImportedModelAdapter.getCol(template, "operators"); i.hasNext() && (operator == null);) {
		Object opme = i.next();
		Object literal = MOINImportedModelAdapter.getME((RefObject) opme, "literal");
		String opmes = null;
		if (literal == null) {
		    opmes = "";
		} else {
		    opmes = MOINImportedModelAdapter.getString((RefObject) literal, "value");
		}
		int arity = MOINImportedModelAdapter.getInt((RefObject) opme, "arity");
		if (op.equals(opmes)) {
		    if (rightPropName != null) {
			if ((isUnary && (arity == 1)) || ((!isUnary) && (arity == 2))) {
			    operator = opme;
			}
		    } else {
			operator = opme;
			isPostfix = MOINImportedModelAdapter.getBool((RefObject) opme, "isPostfix");
		    }
		}
	    }
	    if (operator == null) {
		System.err.println("Error: could not find operator \"" + op + "\"");
	    }
	} else {
	    operator = MOINImportedModelAdapter.getCol(template, "operators").next();
	    isUnary = MOINImportedModelAdapter.getInt((RefObject) operator, "arity") == 1;
	    if (isUnary) {
		isPostfix = MOINImportedModelAdapter.getBool((RefObject) operator, "isPostfix");
	    }
	}
	int curPrio = currentContext.getPriorities().peek().intValue();
	Operator op = (Operator) operator;
	int priority = ((Priority) op.refImmediateComposite()).getValue();
	boolean paren = priority > curPrio;
	currentContext.getPriorities().push(priority);
	RefObject literal = MOINImportedModelAdapter.getME((RefObject) operator, "literal");
	debug("PRIORITY = " + priority + " ; CURPRIO = " + curPrio + " ; OPERATOR = "
		+ ((literal != null) ? MOINImportedModelAdapter.getString(literal, "value") : "") + " ; paren = " + paren);

	if (paren) {
	    printer.printSymbol("(");
	}

	RefObject source = MOINImportedModelAdapter.getME(ame, sourcePropName);
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

	RefObject seq = MOINImportedModelAdapter.getME(template, "otSequence");
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
		    serialize((RefObject) i.next());
		}
	    } else {
		if (!isUnary) {
		    serialize((RefObject) r);
		}
	    }
	}
	currentContext.getPriorities().pop();
	if (paren) {
	    printer.printSymbol(")");
	}

	printer.endClassTemplate(handle);
    }

    private void serializeStruct(RefStruct s, String mode, Connection connection) throws SyntaxMismatchException {
	String typeName = TcsUtil.joinNameList(s.refTypeName());
	debug("processing " + typeName);

	Object template = findTemplateForStruct(s, mode, connection, typeName);
	String templateTypeName = MOINImportedModelAdapter.getTypeName((RefObject) template);
	debug("Applying template type " + templateTypeName);

	if (template instanceof ClassTemplate) {
	    debug("with mode: " + ((ClassTemplate) template).getMode());
	}

	printer.useDefaultSeparator();
	if (templateTypeName.equals("TCS::ClassTemplate")) {
	    currentContext.getPriorities().push(Integer.MAX_VALUE);
	    currentContext.getClassTemplates().push((ClassTemplate) template);
             
	    serializeSequence(s, MOINImportedModelAdapter.getME((RefObject) template, "templateSequence"));

	    currentContext.getClassTemplates().pop();
	    currentContext.getPriorities().pop();
	    
	} else if (templateTypeName.equals("TCS::OperatorTemplate")) {
	    throw new RuntimeException("OperatorTemplates are not yet supported for StructureTypes");
	} else {
	    error("unsupported template type: " + templateTypeName);
	}
	printer.resetSeparator();
    }

    private Object findTemplateForStruct(RefStruct s, String mode, Connection connection, String typeName)
	    throws NoTemplateMatchFoundException {
	Object template = null;
	ClassTemplate ct = TcsUtil.resolveClassTemplate(s.refTypeName(), mode, classTemplateMap);
	if (ct != null && !ct.isAbstract()) {
	    template = ct;
	}

	if (template == null) {
	    // look for non-abstract template for supertype
	    template = findSupertypeTemplate(s, mode, classTemplateMap, connection);
	}

	if (template == null) {
	    // look for non-class templates
	    template = nonClassTemplates.get(typeName);
	}

	if (template == null) {
	    if (mode != null) {
		error("unknown template for " + typeName + " #" + mode);
	    } else {
		error("unknown template for " + typeName);
	    }
	    throw new NoTemplateMatchFoundException(currentContext, s, typeName, mode);
	}
	return template;
    }

    private void serializePrimitive(Object value, String as) {
	if (value instanceof String) {
	    // TODO what about serializer attribute?
	    RefObject template = primitiveTemplates.get(as);
	    if (template != null && template instanceof PrimitiveTemplate) {
		if (((PrimitiveTemplate) template).getSerializer() != null
			&& !((PrimitiveTemplate) template).getSerializer().equals("")) {
		    PrimitiveTemplate primTemplate = (PrimitiveTemplate) template;
		    if (primTemplate.getSerializer().contains("%value%")) {
			printer.printCustomStringLiteral(primTemplate.getSerializer().replaceAll("%value%",
				java.util.regex.Matcher.quoteReplacement(((String) value).replaceAll("\"", "\\\\\\\""))), "");
		    }
		} else {
		    printer.printDefault((String) value);
		}
	    }
	    // TODO what about tokens and token attribute?
	    else if ("stringSymbol".equals(as)) {
		printer.printStringLiteral((String) value);
	    } else {
		boolean orKeyword = false;
		if (template != null) {
		    orKeyword = MOINImportedModelAdapter.getBoolUndefinedIsFalse(template, "orKeyword");
		}
		printer.printIdentifier((String) value, orKeyword);
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

	RefersToParg refersToParg = (RefersToParg) getPropertyArgument(property, "RefersTo");
	AsParg asParg = (AsParg) getPropertyArgument(property, "As");
	RefObject query = getPropertyArgument(property, "Query");
	String primitiveTemplateName = null;

	if (asParg != null) {
	    Template asTemplate = asParg.getTemplate();
	    if (asTemplate instanceof PrimitiveTemplate) {
		PrimitiveTemplate prim = (PrimitiveTemplate) asTemplate;
		primitiveTemplateName = prim.getTemplateName();
	    }
	}

	if (value == null) {
	    return;
	}
	if (value instanceof Collection) {
	    RefObject sep = getPropertyArgument(property, "Separator");
	    if (sep != null) {
		sep = MOINImportedModelAdapter.getME(sep, "separatorSequence");
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
	} else if (value instanceof RefStruct) {
	    RefStruct s = (RefStruct) value;
	    ModeParg modeArg = (ModeParg) getPropertyArgument(property, "Mode");
	    String mode = null;
	    if (modeArg != null) {
		mode = modeArg.getMode();
	    }

	    serializeStruct(s, mode, property.get___Connection());
	} else if (value instanceof RefEnum) {
	    RefEnum e = (RefEnum) value;
	    String enumName = TcsUtil.joinNameList(e.refTypeName());
	    @SuppressWarnings("unchecked")
	    Map<String, SequenceElement> mappings = (Map<String, SequenceElement>) nonClassTemplates.get(enumName);
	    SequenceElement seqElem = mappings.get(MOINImportedModelAdapter.getEnumLiteralName(e));
	    serializeSequenceElement(element, seqElem);
	} else if (value instanceof RefObject) {
	    RefObject valueME = (RefObject) value;
	    printer.printIndentationIfNeeded();

	    if (asParg != null && query != null) {
		FilterParg filter = (FilterParg) getPropertyArgument(property, "Filter");
		String invertQuery = filter.getInvert();
		try {
		    String refValue = (String) oclHelper.findElementWithOCLQuery(valueME, null, null, invertQuery, null, valueME
			    .get___Connection().getJmiHelper().getRefClassForMofClass(
				    (MofClass) property.getPropertyReference().getStrucfeature().getType()), null);

		    this.serializePrimitive(refValue, primitiveTemplateName);
		} catch (Exception e) {
		    String defaultName = (String) valueME.refGetValue("name");
		    this.serializePrimitive(defaultName, primitiveTemplateName);
		}
	    } else if (refersToParg == null) {
		ModeParg modeArg = (ModeParg) getPropertyArgument(property, "Mode");
		String mode = null;
		if (modeArg != null) {
		    mode = modeArg.getMode();
		}

		serialize(valueME, mode, null);
	    } else {
		// TODO hack to add autocreated instances of TCS::Keyword to
		// the keywords list
		if (valueME instanceof Keyword) {
		    printer.addAutoCreatedKeyword((Keyword) value);
		}

		Object v = MOINImportedModelAdapter.get(valueME, MOINImportedModelAdapter.getString(refersToParg, "propertyName"));
		serializePrimitive(v, primitiveTemplateName);
	    }
	} else if (MOINImportedModelAdapter.isPrimitive(value)) {
	    printer.printIndentationIfNeeded();
	    serializePrimitive(value, primitiveTemplateName);
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
	PartialParg partialArg = (PartialParg) getPropertyArgument(property, "Partial");
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

    private void serializeSequence(Object ame, RefObject seq) throws SyntaxMismatchException {
	if (seq != null) {
	    for (Iterator<?> i = MOINImportedModelAdapter.getCol(seq, "elements"); i.hasNext();) {
		Object e = i.next();
		serializeSequenceElement(ame, (SequenceElement) e);
	    }
	}
    }

    private void serializeSequenceElement(Object element, SequenceElement seqElem) throws SyntaxMismatchException {
	printer.enterSequenceElement(seqElem);
	
	String tn = MOINImportedModelAdapter.getTypeName(seqElem);
	debug("serializing seq elem " + tn);
	if (tn.equals("TCS::Property")) {
	    serializeSEProperty(element, (Property) seqElem);
	} else if (tn.equals("TCS::LiteralRef")) {
	    serializeSELiteralRef((LiteralRef) seqElem);
	} else if (tn.equals("TCS::Alternative")) {
	    serializeSEAlternative(element, (Alternative) seqElem);
	} else if (tn.equals("TCS::Block")) {
	    serializeSEBlock(element, (Block) seqElem);
	} else if (tn.equals("TCS::FunctionCall")) {
	    serializeSequence(element, MOINImportedModelAdapter.getME(MOINImportedModelAdapter.getME(seqElem, "calledFunction"), "functionSequence"));
	} else if (tn.equals("TCS::ConditionalElement")) {
	    serializeSEConditional(element, (ConditionalElement) seqElem);
	} else if (tn.equals("TCS::CustomSeparator")) {
	    serializeSECustomSeparator((CustomSeparator) seqElem);
	} else if (tn.equals("TCS::InjectorActionsBlock")) {
	    serializeSEInjectorActionsBlock(element, (InjectorActionsBlock) seqElem);
	} else {
	    error("unsupported: " + tn);
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
		if (i == sortedAlternativeSequences.size() - 1 && !alt.isMulti()) {
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

    private void serializeSEConditional(Object element, ConditionalElement seqElem) throws SyntaxMismatchException {
	RefObject condition = MOINImportedModelAdapter.getME(seqElem, "condition");
	if (TCSConditionEvaluator.eval(element, condition)) {
	    RefObject tseq = MOINImportedModelAdapter.getME(seqElem, "thenSequence");
	    if (tseq != null) {
		printer.printIndentationIfNeeded();
		serializeSequence(element, tseq);
	    }
	} else {
	    RefObject eseq = MOINImportedModelAdapter.getME(seqElem, "elseSequence");
	    debug("ELSE SEQ = " + eseq);
	    if (eseq != null) {
		printer.printIndentationIfNeeded();
		serializeSequence(element, eseq);
	    }
	}
    }

    private void serializeSEBlock(Object element, Block seqElem) throws SyntaxMismatchException {
	debugWhiteSpace("<block>");
	Object nbNLBArg = getBlockArgument(seqElem, "NbNL");
	Object startNbNLBArg = getBlockArgument(seqElem, "StartNbNL");
	Object indentIncrBArg = getBlockArgument(seqElem, "IndentIncr");
	Object startNLBArg = getBlockArgument(seqElem, "StartNL"); 
	Object endNLBArg = getBlockArgument(seqElem, "EndNL");
	int indentIncr = 1; // how much to increase the indentation level
	int nbNL = 1; // number of new lines before each element in the block
	boolean startNL = true; // start to print block on a new line
	boolean endNL = true; // print empty, indented line after the block content was printed

	if (nbNLBArg != null) {
	    nbNL = MOINImportedModelAdapter.getInt((RefObject) nbNLBArg, "value");
	}
	int startNbNL = nbNL; // by default, startNbNL = nbNL // says how many lines we want at the beginning of the block
	if (startNbNLBArg != null) {
	    startNbNL = MOINImportedModelAdapter.getInt((RefObject) startNbNLBArg, "value");
	}
	if (indentIncrBArg != null) {
	    indentIncr = MOINImportedModelAdapter.getInt((RefObject) indentIncrBArg, "value");
	}
	if (startNLBArg != null) {
	    startNL = MOINImportedModelAdapter.getBool((RefObject) startNLBArg, "value");
	}
	if (endNLBArg != null) {
	    endNL = MOINImportedModelAdapter.getBool((RefObject) endNLBArg, "value");
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
	serializeSequence(element, MOINImportedModelAdapter.getME(seqElem, "blockSequence"));
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
	if (element instanceof RefStruct) {
	    v = TcsUtil.getPropertyValue((RefStruct) element, prop.getPropertyReference());

	} else if (element instanceof RefObject) {
	    v = TcsUtil.getPropertyValue((RefObject) element, prop.getPropertyReference());
	}
	// also check for partial property arg
	serializePropertyCheckingPartial(element, v, prop, true);
    }

    private void serializeSECustomSeparator(CustomSeparator seqElem) {
	String name = MOINImportedModelAdapter.getString(seqElem, "name");
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
	ForcedLowerParg lowerArg = (ForcedLowerParg) getPropertyArgument(p, "ForcedLower");
	ForcedUpperParg upperArg = (ForcedUpperParg) getPropertyArgument(p, "ForcedUpper");

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
	    if (element instanceof RefStruct) {
		prop = TcsUtil.getPropertyValue((RefStruct) element, p.getPropertyReference());
	    } else if (element instanceof RefObject) {
		prop = TcsUtil.getPropertyValue((RefObject) element, p.getPropertyReference());
	    }

	    String oclQuery = p.getValue();
	    RefObject contextObject = computeContextObject(oclQuery);
	    RefObject foreachObject = computeForeachObject(oclQuery);

	    Object expectedValue = null;
	    try {
		if (element instanceof RefObject) {
		    // keyValue is always null for LookUpPropertyInits
		    // in QueryPArg it denotes the RefersToParg propertyValue
		    expectedValue = TcsUtil.executeOclQuery((RefObject) element, oclQuery, contextObject, foreachObject, null);
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
    
    private RefObject computeContextObject(String oclQuery) {
	String tag = TcsUtil.getContextTag(oclQuery);
	return PrettyPrintContext.getContextElement(currentContext, tag);
    }

    private RefObject computeForeachObject(String oclQuery) {
	// TODO Auto-generated method stub
	return null;
    }

    private void validatePrimitivePropertyInit(Object element, PrimitivePropertyInit p) throws PropertyInitException {

	if (element != null && p != null) {

	    // only validate PropertyInit, if it is mandatory and not just a
	    // default for the parser
	    if (p.isDefault()) {
		return;
	    }

	    Object prop = null;
	    if (element instanceof RefStruct) {
		prop = TcsUtil.getPropertyValue((RefStruct) element, p.getPropertyReference());
	    } else if (element instanceof RefObject) {
		prop = TcsUtil.getPropertyValue((RefObject) element, p.getPropertyReference());
	    }

	    String propValue = "";
	    if (prop != null) {
		if (prop instanceof RefEnum) {
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
	Activator.logError(errogMsg);
    }

}
