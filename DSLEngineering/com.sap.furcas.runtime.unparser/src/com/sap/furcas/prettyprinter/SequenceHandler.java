/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.prettyprinter;

import static com.sap.furcas.prettyprinter.TextBlocksFactory.getLengthOf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator;
import com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.Formatter.Type;
import com.sap.furcas.prettyprinter.context.PrintContext;
import com.sap.furcas.prettyprinter.context.PrintResult;
import com.sap.furcas.prettyprinter.context.PrintResult.LeafResult;
import com.sap.furcas.prettyprinter.context.PrintResult.NullResult;
import com.sap.furcas.prettyprinter.context.PrintResult.ResultContainer;
import com.sap.furcas.prettyprinter.exceptions.AlternativeChoiceMismatch;
import com.sap.furcas.prettyprinter.exceptions.NoMatchingTemplateException;
import com.sap.furcas.prettyprinter.exceptions.PropertyInitMismatchException;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.BlockArgumentUtil;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.PrettyPrinterUtil;
import com.sap.furcas.unparser.EMFModelInspector;
import com.sap.furcas.unparser.TCSConditionEvaluator;

/**
 * This is the primary serialization component of the {@link PrettyPrinter}. It pretty prints
 * TCS {@link Sequence Sequences} and their contained {@link SequenceElement}s
 * to lists of formatted {@link DocumentNode}s.
 * <p>
 * This class is called by {@link TemplateHandler}.
 * </p>
 * 
 * @author Stephan Erb
 *
 */
public class SequenceHandler {

    private final TextBlocksFactory tbFactory;
    private final TemplateHandler templateHandler;
    private final TemplateFinder templateFinder;
    private final TCSSpecificOCLEvaluator oclEvaluator;
    private final SequenceElementValidator seValidator;
    private final Formatter formatter;

    public SequenceHandler(TextBlocksFactory factory, TemplateFinder templateFinder, TemplateHandler templateHandler,
            TCSSpecificOCLEvaluator oclEvaluator, SequenceElementValidator validator, Formatter formatter) {
        this.tbFactory = factory;
        this.templateFinder = templateFinder;
        this.templateHandler = templateHandler;
        this.oclEvaluator = oclEvaluator;
        this.seValidator = validator;
        this.formatter = formatter;
    }

    /**
     * Serailize sequences such as: "keyword" "{" propertyName "}" {{property=1}}
     */
    public ResultContainer serializeSequence(EObject modelElement, Sequence sequence, PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {
        ResultContainer result = new ResultContainer(context.getPendingFormattingRequest());
        result.configureFormattingBetweenBlockElements(context.getBlockFormattingBetweenElements());

        Iterator<SequenceElement> iter = sequence.getElements().iterator();
        while (iter.hasNext()) {
            SequenceElement seqElem = iter.next();
            PrintResult subResult = serializeSequenceElement(modelElement, seqElem, result.asSubContext(context), policy);
            
            if (iter.hasNext() && subResult.hasSyntacticContribution()) {
                subResult.appendFormatRequests(context.getBlockFormattingBetweenElements());
            }
            result.merge(subResult);
        }
        return result;
    }

    /**
     * Serialize the individual elements of a sequence such as: "keyword", "{", or propertyName
     */
    private PrintResult serializeSequenceElement(EObject modelElement, SequenceElement seqElem, PrintContext context,
            PrintPolicy policy) throws SyntaxMismatchException {

        switch (seqElem.eClass().getClassifierID()) {
        case TCSPackage.PROPERTY:
            Object value = TcsUtil.getPropertyValue(modelElement, ((Property) seqElem).getPropertyReference());
            return serializeProperty(modelElement, (Property) seqElem, value, context, policy);
        case TCSPackage.LITERAL_REF:
            return serializeLiteralRef((LiteralRef) seqElem, context, policy);
        case TCSPackage.ALTERNATIVE:
            return serializeAlternative(modelElement, (Alternative) seqElem, context, policy);
        case TCSPackage.BLOCK:
            return serializeBlock(modelElement, (Block) seqElem, context, policy);
        case TCSPackage.FUNCTION_CALL:
            // create subcontext to clear formatting between elements
            ResultContainer result = new ResultContainer(context.getPendingFormattingRequest());
            result.merge(serializeSequence(modelElement, ((FunctionCall) seqElem).getCalledFunction().getFunctionSequence(),
                    result.asSubContext(context), policy));
            return result;
        case TCSPackage.CONDITIONAL_ELEMENT:
            return serializeConditionalElement(modelElement, (ConditionalElement) seqElem, context, policy);
        case TCSPackage.CUSTOM_SEPARATOR:
            return serializeCustomSeparator((CustomSeparator) seqElem, context);
        case TCSPackage.INJECTOR_ACTIONS_BLOCK:
            return validateInjectorActionsBlock(modelElement, (InjectorActionsBlock) seqElem, context);
        default:
            Activator.logger.logError("Unable to serialize unknwon sequence elmenet of type "
                    + EMFModelInspector.getTypeName(seqElem) + ". Skipping.");
            return new NullResult();
        }
    }

    /**
     * Serialize keywords (e.g., "class") or symbols (e.g., ";", "{", ...).
     */
    private PrintResult serializeLiteralRef(LiteralRef seqElem, PrintContext context, PrintPolicy policy) {
        List<OmittedToken> formatting = formatter.translateToTokens(getLeadingSymbolFormatting(seqElem, context, policy), context);

        List<DocumentNode> tokens = new ArrayList<DocumentNode>(formatting);
        tokens.add(tbFactory.createLexedToken(seqElem.getReferredLiteral().getValue(), seqElem,
                getLengthOf(formatting, context.getNextOffset())));
        
        LeafResult result = new LeafResult(tokens);
        
        appendFollowingSymbolFormatting(seqElem, result);
        return result;
    }
    
    private List<FormatRequest> getLeadingSymbolFormatting(LiteralRef seqElem, PrintContext context, PrintPolicy policy) {
        List<FormatRequest> formatRequests = new ArrayList<FormatRequest>(context.getPendingFormattingRequest());
        formatRequests = policy.getOverruledFormattingOf(formatRequests);

        if (seqElem.getReferredLiteral() instanceof Symbol) {
            Symbol symbol = ((Symbol) seqElem.getReferredLiteral());
            if (symbol.getSpaces().contains(SpaceKind.LEFT_NONE)) {
                formatRequests.add(FormatRequest.create(Type.SKIP_SPACE));
            } else if (symbol.getSpaces().contains(SpaceKind.LEFT_SPACE)) {
                formatRequests.add(FormatRequest.create(Type.ADD_SPACE));
            } 
        } else {
            formatRequests.add(FormatRequest.create(Type.ADD_OPTIONAL_SPACE));
        }
        return formatRequests;
    }

    private void appendFollowingSymbolFormatting(LiteralRef seqElem, LeafResult result) {
        if (seqElem.getReferredLiteral() instanceof Symbol) {
            Symbol symbol = ((Symbol) seqElem.getReferredLiteral());
            if (symbol.getSpaces().contains(SpaceKind.RIGHT_SPACE)) {
                result.appendFormatRequest(FormatRequest.create(Type.ADD_SPACE));
            } else if (symbol.getSpaces().contains(SpaceKind.RIGHT_NONE)) {
                result.appendFormatRequest(FormatRequest.create(Type.SKIP_SPACE));
            } else {
                result.appendFormatRequest(FormatRequest.create(Type.SKIP_OPTIONAL_SPACE));
            }
        }
    }

    /**
     * Serialize the given property of the model element
     */
    private PrintResult serializeProperty(EObject modelElement, Property seqElem, Object value, PrintContext context,
            PrintPolicy policy) throws SyntaxMismatchException {
        try {
            seValidator.validateBounds(modelElement, seqElem, value);

            if (isPrimitive(value)) {
                return templateHandler.serializePrimitiveTemplate(value, seqElem,
                        templateFinder.findPrimitiveTemplate(seqElem), context, policy);
                
            } else if (value instanceof Enum) {
                return templateHandler.serializeEnumerationTemplate((Enum<?>) value,
                        templateFinder.findEnumerationTemplate(seqElem)); 
                    
            } else if (value instanceof Collection) {
                return serializePropertyWithCollectionValue(modelElement, seqElem, (Collection<?>) value, context, policy);
                
            } else if (value instanceof EObject) {
                return serializePropertyWithEObjectValue(modelElement, seqElem, (EObject) value, context, policy);

            } else {
                Activator.logger.logError("Unable to serialize property value of unknown type "
                        + value.getClass().getName() + ". Skipping.");
                return new NullResult();
            }
        } catch (SyntaxMismatchException e) {
            if (PropertyArgumentUtil.containsPartialPArg(seqElem)) {
                return new NullResult(); // ignore exception
            } else {
                throw e; // not partial, has to be printed without errors
            }
        }
    }
    
    /**
     * Serialize the given property of EObject type by calling a matching template for this particular type.
     */
    private PrintResult serializePropertyWithEObjectValue(EObject modelElement, Property seqElem, EObject propertyValue,
            PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {

        if (isRefererence(seqElem)) {
            Object reference = policy.getReferenceValueReplacementFor(getReferenceValue(seqElem, propertyValue));
            LeafResult result = templateHandler.serializePrimitiveTemplate(reference, seqElem,
                    templateFinder.findPrimitiveTemplate(seqElem), context, policy);
            setReferencedModelElementInResult(result, propertyValue);
            return result;

        } else {
            for (ContextTemplate template : policy.getPreferredTemplateOrderOf(propertyValue, seqElem,
                    templateFinder.findMatchingContextTemplates(propertyValue, TcsUtil.getMode(seqElem)))) {
                try {
                    PrintPolicy subPolicy = policy.getPolicyFor(modelElement, seqElem, propertyValue, template);
                    return templateHandler.serializeContextTemplate(propertyValue, template, seqElem, context, subPolicy);
                } catch (SyntaxMismatchException e) {
                    // try next  
                }
            }
            throw new NoMatchingTemplateException();
        }
    }

    private Object getReferenceValue(Property seqElem, EObject propertyValue) {
        RefersToPArg refersTo = PropertyArgumentUtil.getRefersToPArg(seqElem);
        if (refersTo == null) {
            try {
                return PrettyPrinterUtil.invertReferenceByQuery(propertyValue, seqElem, oclEvaluator);
            } catch (ModelAdapterException e) {
                throw new RuntimeException("Failed to serialize reference", e);
            }
        } else {
            return EMFModelInspector.get(propertyValue, refersTo.getPropertyName());
        }
    }

    private void setReferencedModelElementInResult(LeafResult result, EObject propertyValue) {
        LexedToken token = (LexedToken) result.getNodes().get(result.getNodes().size()-1);
        token.getReferencedElements().add(propertyValue);
    }

    /**
     * Serialize the given property of type Collection<?> by individually serializing all elements in the colleciton.
     */
    private PrintResult serializePropertyWithCollectionValue(EObject modelElement, Property seqElem, Collection<?> propertyValue,
            PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {
        ResultContainer result = new ResultContainer(context.getPendingFormattingRequest());

        Sequence separatorSeq = getSeparatorSequence(seqElem);
        Iterator<?> iter = policy.getPreferredCollectionOrderOf(modelElement, seqElem, propertyValue).iterator();

        while (iter.hasNext()) {
            Object currentValue = iter.next();
            result.merge(serializeProperty(modelElement, seqElem, currentValue, result.asSubContext(context), policy));

            if (iter.hasNext()) {
                if (separatorSeq != null) {
                    result.merge(serializeSequence(modelElement, separatorSeq, result.asSubContext(context), policy));
                }
                result.appendFormatRequests(context.getBlockFormattingBetweenElements());
            }
        }
        return result;
    }

    /**
     * Execute all injector actions in the given block. If the actual model element values differ from the
     * values expected by the actions, backtrack by throwing an exception. 
     */
    private PrintResult validateInjectorActionsBlock(EObject modelElement, InjectorActionsBlock seqElem, PrintContext context) throws PropertyInitMismatchException {
        for (InjectorAction action : seqElem.getInjectorActions()) {
            switch (action.eClass().getClassifierID()) {
            case TCSPackage.PRIMITIVE_PROPERTY_INIT:
                seValidator.validatePrimitivePropertyInit(modelElement, (PrimitivePropertyInit) action, context);
                break;
            case TCSPackage.LOOKUP_PROPERTY_INIT:
                seValidator.validateLookupPropertyInit(modelElement, (LookupPropertyInit) action, context);
                break;
            default:
                Activator.logger.logError("Unable to serialize injector action of unknown type "
                        + EMFModelInspector.getTypeName(action) + ". Skipping.");
            }
        }
        return new NullResult();
    }

    /**
     * Serialize forced, custom separators formatting information
     */
    private PrintResult serializeCustomSeparator(CustomSeparator seqElem, PrintContext context) {
        PrintResult result = new ResultContainer(context.getPendingFormattingRequest());

        String name = seqElem.getName();
        if (name.equals("no_space")) {
            result.appendFormatRequest(FormatRequest.create(Type.SKIP_SPACE));
        } else if (name.equals("space")) {
            result.appendFormatRequest(FormatRequest.create(Type.ADD_FORCED_SPACE));
        } else if (name.equals("newline")) {
            result.appendFormatRequest(FormatRequest.createNewline(context.getIndenationLevel()));
        } else if (name.equals("tab")) {
            result.appendFormatRequest(FormatRequest.create(Type.ADD_TAB));
        } else {
            Activator.logger.logError("Unable to serialize custom separator of unknown type " + name + ". Skipping.");
            return new NullResult();
        }
        result.hasSyntacticContribution(true);
        return result;
    }

    /**
     * Serialize blocks such as: [ ... ]{blockArg=foo}
     */
    private PrintResult serializeBlock(EObject modelElement, Block seqElem, PrintContext context, PrintPolicy policy) throws SyntaxMismatchException {
        // number of new lines before each element in the block
        int numOfNewLinesBeforeEachElement = 1;
        NbNLBArg nbNLBArg = BlockArgumentUtil.getNbNLBArg(seqElem);
        if (nbNLBArg != null) {
            numOfNewLinesBeforeEachElement = nbNLBArg.getValue();
        }
        // how much to increase the indentation level for elements within the block
        IndentIncrBArg indentIncrBArg = BlockArgumentUtil.getIndentIncrBArg(seqElem);
        int indentationIncrmentor = 1;
        if (indentIncrBArg != null) {
            indentationIncrmentor = indentIncrBArg.getValue();
        }
        // print empty, indented line after the block content was printed
        boolean endBlockWithNewLine = true;
        EndNLBArg endNLBArg = BlockArgumentUtil.getEndNLBArg(seqElem);
        if (endNLBArg != null) {
            endBlockWithNewLine = endNLBArg.isValue();
        }
        int indentation = context.getIndenationLevel() + indentationIncrmentor;
        
        List<FormatRequest> formattingOfBlockStart = getFormattingOfBlockStart(seqElem, context, numOfNewLinesBeforeEachElement, indentation);
        List<FormatRequest> formattingBetweenElements = getFormattingBetweenElements(numOfNewLinesBeforeEachElement, indentation);
        
        ResultContainer result = new ResultContainer(context.getPendingFormattingRequest());
        result.appendFormatRequests(formattingOfBlockStart);
        result.configureIndentationLevelIncrement(indentationIncrmentor);
        result.configureFormattingBetweenBlockElements(formattingBetweenElements);
        
        result.merge(serializeSequence(modelElement, seqElem.getBlockSequence(), result.asSubContext(context), policy));

        if (endBlockWithNewLine) {
            result.appendFormatRequest(FormatRequest.createNewline(context.getIndenationLevel()));
        }
        return result;
    }

    private List<FormatRequest> getFormattingBetweenElements(int numOfNewLinesBeforeEachElement, int indentation) {
        List<FormatRequest> formattingBetweenElements = new ArrayList<FormatRequest>();
        if (numOfNewLinesBeforeEachElement == 0) {
            // no new lines wanted; use the standard spacing instead
            formattingBetweenElements.add(FormatRequest.create(Type.ADD_SPACE));
        } else {
            for (int i = 0; i < numOfNewLinesBeforeEachElement; i++) {
                formattingBetweenElements.add(FormatRequest.createNewline(indentation));
            }
        }
        return formattingBetweenElements;
    }

    private List<FormatRequest> getFormattingOfBlockStart(Block seqElem, PrintContext context, int numOfNewLinesBeforeEachElement, int indentation) {
        // by default, startNbNL = nbNL // says how many lines we want at the beginning of the block
        int numOfNewLinesAtBlockStart = numOfNewLinesBeforeEachElement;
        StartNbNLBArg startNbNLBArg = BlockArgumentUtil.getStartNbNLBArg(seqElem);
        if (startNbNLBArg != null) {
            numOfNewLinesAtBlockStart = startNbNLBArg.getValue();
        }
        // start to print block on a new line
        boolean startBlockWithNewLine = true;
        StartNLBArg startNLBArg = BlockArgumentUtil.getStartNLBArg(seqElem);
        if (startNLBArg != null) {
            startBlockWithNewLine = startNLBArg.isValue();
        }
        List<FormatRequest> formattingOfBlockStart = new ArrayList<FormatRequest>(context.getPendingFormattingRequest());
        if (startBlockWithNewLine) {
            for (int i = 0; i < numOfNewLinesAtBlockStart; i++) {
                formattingOfBlockStart.add(FormatRequest.createNewline(indentation));
            }
        }
        return formattingOfBlockStart;
    }

    /**
     * Serialize an alternative with different choices such as: [[ choiceA | choiceB | ... ]]
     */
    private PrintResult serializeAlternative(EObject modelElement, Alternative seqElem, PrintContext context, PrintPolicy policy)
            throws AlternativeChoiceMismatch {
        ResultContainer result = new ResultContainer(context.getPendingFormattingRequest());
        result.configureAlternativeNestingLevel(1, context);

        for (SequenceInAlternative choice : policy.getPreferredAlternativeChoiceOrderOf(seqElem.getSequences())) {
            try {
                PrintResult subResult = serializeSequence(modelElement, choice, result.asSubContext(context), policy);
                // serialization worked
                result.mergeChosenAlternative(seqElem, getSequenceChoiceIndex(choice, seqElem), subResult);
                return result;
            } catch (SyntaxMismatchException e) {
                // try next  
            }
        }
        if (seqElem.isIsMulti()) {
            return result;
        } else {
            throw new AlternativeChoiceMismatch();
        }
    }

    private int getSequenceChoiceIndex(Sequence choice, Alternative alt) {
        ArrayList<Sequence> list = new ArrayList<Sequence>(alt.getSequences());
        return list.indexOf(choice);
    }

    /**
     * Serialize a conditional such as: (isDefined(propertyName) ? propertyName)  
     */
    private PrintResult serializeConditionalElement(EObject modelElement, ConditionalElement seqElem, PrintContext context,
            PrintPolicy policy) throws SyntaxMismatchException {
        ResultContainer result = new ResultContainer(context.getPendingFormattingRequest());
        result.configureAlternativeNestingLevel(1, context);

        if (TCSConditionEvaluator.eval(modelElement, seqElem.getCondition())) {
            Sequence tseq = seqElem.getThenSequence();
            if (tseq != null) {
                PrintResult subResult = serializeSequence(modelElement, tseq, result.asSubContext(context), policy);
                result.mergeChosenAlternative(seqElem, 0, subResult);
            }
        } else {
            Sequence eseq = seqElem.getElseSequence();
            if (eseq != null) {
                PrintResult subResult = serializeSequence(modelElement, eseq, result.asSubContext(context), policy);
                result.mergeChosenAlternative(seqElem, 1, subResult);
            }
        }
        return result;
    }

    private static Sequence getSeparatorSequence(Property seqElem) {
        SeparatorPArg separator = PropertyArgumentUtil.getSeparatorPArg(seqElem);
        if (separator == null) {
            return null;
        } else {
            return separator.getSeparatorSequence();
        }
    }

    private static boolean isRefererence(Property seqElem) {
        return PropertyArgumentUtil.containsReferenceByPArg(seqElem) || PropertyArgumentUtil.containsRefersToArg(seqElem);
    }

    private static boolean isPrimitive(Object value) {
        return ((value instanceof String) || (value instanceof Boolean) || (value instanceof Double) || (value instanceof Integer));
    }

}
