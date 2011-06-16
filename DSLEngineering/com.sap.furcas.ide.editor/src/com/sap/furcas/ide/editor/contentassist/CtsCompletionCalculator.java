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

package com.sap.furcas.ide.editor.contentassist;

import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.createKeywordProposal;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.createPropValueProposal;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.createPropertyProposal;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.createTemplateProposal;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.duplicateFunctionCallStack;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.duplicatePropertyStack;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.getOffset;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.isAtomic;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.isContained;
import static com.sap.furcas.runtime.tcs.PropertyArgumentUtil.containsForcedLowerArg;
import static com.sap.furcas.runtime.tcs.PropertyArgumentUtil.containsForcedUpperArgOfOne;
import static com.sap.furcas.runtime.tcs.TcsUtil.getClassTemplates;
import static com.sap.furcas.runtime.tcs.TcsUtil.getFirstSequenceElement;
import static com.sap.furcas.runtime.tcs.TcsUtil.getMode;
import static com.sap.furcas.runtime.tcs.TcsUtil.getNextSequenceElement;
import static com.sap.furcas.runtime.tcs.TcsUtil.getParentAlternative;
import static com.sap.furcas.runtime.tcs.TcsUtil.getParentSequenceElement;
import static com.sap.furcas.runtime.tcs.TcsUtil.getParentTemplate;
import static com.sap.furcas.runtime.tcs.TcsUtil.getResourceSetFromEObject;
import static com.sap.furcas.runtime.tcs.TcsUtil.getSequence;
import static com.sap.furcas.runtime.tcs.TcsUtil.getType;
import static com.sap.furcas.runtime.tcs.TcsUtil.isMultiValued;
import static com.sap.furcas.runtime.tcs.TcsUtil.isOperatored;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;

/**
 * Used by the {@link CtsContentAssistProcessor} to calculate possible inputs after a given SequenceElement.
 * 
 * <b>Terminology:</b>
 * Atomic SequenceElement is one of: Property points to an Attribute or a Reference with the refersTo argument,
 * LiteralRef.
 * 
 * The other SequenceElements are composite in the sense, that they contain child-Sequences, and will not contain any input-tokens
 * directly.
 * 
 * CustomSeparators are ignored, as they do not contain any input-tokens and no child Sequences.
 * 
 * @author D052602
 * 
 * @author Philipp Meier
 *
 */
public class CtsCompletionCalculator {
    
    private static final URI TRANSIENT_PARTITION_NAME = URI.createURI("http://www.furcas.org/TcsUtilTransientPartition");

    
    /**
     * Caches LiteralRefs that are created to be returned as atomic sequence elements for each operator literal
     */
    private static Map<Operator, LiteralRef> operatorToLiteralRefMap = new HashMap<Operator, LiteralRef>();

    /**
    * clears the TcsUtil transient partition on this connection
    * 
    * @param c
    */
    public static void clearTransientPartition(ResourceSet c) {
        Resource transientPartition = c.getResource(TRANSIENT_PARTITION_NAME, false);
        if (transientPartition != null) {
            transientPartition.getContents().clear();
        }

        // also clear operatorToLiteralRefMap which would otherwise refer to
        // deleted elements
        operatorToLiteralRefMap.clear();
    }
    
    public static List<ICompletionProposal> createFirstPossibleProposals(ConcreteSyntax syntax,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, ITextViewer viewer, int line, int charPositionInLine,
            Token token, TextBlocksModel tbModel, TCSSpecificOCLEvaluator oclEvaluator) {
        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

        for (SequenceElement atomic : getMainTemplatePossibleFirstAtomicSequenceElements(syntax, classTemplateMap)) {
            results.addAll(createProposalsFromAtomicSequenceElement(syntax, classTemplateMap, atomic, viewer, line,
                    charPositionInLine, token, tbModel, oclEvaluator));
        }

        return results;
    }
    
    private static List<SequenceElement> getMainTemplatePossibleFirstAtomicSequenceElements(ConcreteSyntax syntax,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap) {

        ClassTemplate main = TcsUtil.getMainClassTemplate(syntax);
        Set<Template> visitedTemplates = new HashSet<Template>();
        visitedTemplates.add(main);
        
        if (main.isIsAbstract()) {
            return getPossibleFirstAtomicSequenceElements((EClass) main.getMetaReference(), main.getMode(), classTemplateMap,
                    visitedTemplates, syntax, getResourceSetFromEObject(main));
        } else {
            return getPossibleFirstAtomicSequenceElements(main.getTemplateSequence(), classTemplateMap, visitedTemplates, syntax);
        }
    }
    
    private static void cacheOperatorLiteral(OperatorList operatorList, Operator op) {
        ResourceSet c = TcsUtil.getResourceSetFromEObject(operatorList);
        Resource transientPartition = c.getResource(TRANSIENT_PARTITION_NAME, true);
        LiteralRef litRef = TCSFactory.eINSTANCE.createLiteralRef();
        transientPartition.getContents().add(litRef);
        litRef.setReferredLiteral(op.getLiteral());
        operatorToLiteralRefMap.put(op, litRef);
    }
    
    
    /**
     * Returns a list of the first possible atomic SequenceElements of the given SequenceElement.
     * 
     * Composite SequenceElements return the possible first atomic SequenceElements of each of their children merged into a single
     * list, atomic SequenceElements return a list containing themselves.
     * 
     * @param e
     *            SequenceElement to get the first possible atomic SequenceElements from
     * @param visitedTemplates
     * @return first possible atomic SequenceElements
     */
    public static List<SequenceElement> getPossibleFirstAtomicSequenceElements(SequenceElement e,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates, ConcreteSyntax syntax) {

        assert (visitedTemplates != null);

        List<SequenceElement> results = new ArrayList<SequenceElement>();

        // check for composite SequenceElements
        if (e instanceof Alternative) {
            Alternative alt = (Alternative) e;

            if (alt.isIsMulti()) {
                // isMulti Alternative is optional
                results.add(null);
            }

            for (Sequence s : alt.getSequences()) {
                addAllIfNotNull(
                        results,
                        getPossibleFirstAtomicSequenceElements(s, classTemplateMap, new HashSet<Template>(visitedTemplates),
                                syntax));
            }
            return results;
        }

        else if (e instanceof ConditionalElement) {
            ConditionalElement cond = (ConditionalElement) e;
            addAllIfNotNull(
                    results,
                    getPossibleFirstAtomicSequenceElements(cond.getThenSequence(), classTemplateMap, new HashSet<Template>(
                            visitedTemplates), syntax));
            addAllIfNotNull(
                    results,
                    getPossibleFirstAtomicSequenceElements(cond.getElseSequence(), classTemplateMap, new HashSet<Template>(
                            visitedTemplates), syntax));
            return results;
        }

        else if (e instanceof Block) {
            Block block = (Block) e;
            addAllIfNotNull(results,
                    getPossibleFirstAtomicSequenceElements(block.getBlockSequence(), classTemplateMap, visitedTemplates, syntax));
            return results;
        }

        else if (e instanceof FunctionCall) {
            FunctionCall call = (FunctionCall) e;
            addAllIfNotNull(results,
                    getPossibleFirstAtomicSequenceElements(call.getCalledFunction(), classTemplateMap, visitedTemplates, syntax));
            return results;
        }

        else if (e instanceof CustomSeparator) {
            // CustomSeparators do not contain any SequenceElements
            results.add(null);
            return results;
        }

        else if (e instanceof InjectorActionsBlock) {
            // InjectorActionsBlocks do not contain any SequenceElements
            results.add(null);
            return results;
        }

        else if (e instanceof Property) {
            Property prop = (Property) e;

            // if we have a multi-valued Property, add corresponding
            // elements as well
            if (isMultiValued(prop) && !containsForcedLowerArg(prop)) {

                results.add(null);
            }

            if (isAtomic(prop, classTemplateMap)) {
                results.add(e);
                return results;
            } else {
                addAllIfNotNull(
                        results,
                        getPossibleFirstAtomicSequenceElements((EClass) getType(prop), getMode(prop), classTemplateMap,
                                visitedTemplates, syntax, getResourceSetFromEObject(prop)));
                return results;
            }
        }

        else {
            // atomic SequenceElement or null
            results.add(e);

            return results;
        }

    }
    
    /**
     * Returns a list of all possible atomic SequenceElements, that directly follow the given SequenceElement, or indirectly
     * follow it through SequenceElements that may have no tokens (i.e null Sequences in ConditionalElement).
     * 
     * The parentFunctionCallMap parameter is needed to disambiguate between the different FunctionCalls that reference the
     * FunctionTemplate this SequenceElement is part of. The map is needed, as functions can contain other functions.
     * 
     * @param e
     *            SequenceElement after which to look
     * @param parentFunctionCallMap
     *            maps the correct parent FunctionCall for each FunctionTemplate this SequenceElement is part of
     * @return all possible SequenceElements that are directly following
     */
    public static List<SequenceElement> getPossibleAtomicFollows(SequenceElement e, Stack<FunctionCall> parentFunctionCallStack,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Stack<Property> parentPropertyStack,
            boolean isOperator, ConcreteSyntax syntax) {

        // we will modify the stack, make a copy first
        Stack<Property> copiedParentPropertyStack = duplicatePropertyStack(parentPropertyStack);
        Stack<FunctionCall> copiedParentFunctionCallStack = duplicateFunctionCallStack(parentFunctionCallStack);

        String operatorValue = null;
        if (isOperator) {
            // e is a literal ref referring to the operator value
            LiteralRef ref = (LiteralRef) e;
            operatorValue = ref.getReferredLiteral().getValue();
        }

        List<SequenceElement> results = new ArrayList<SequenceElement>();

        // counts how often getParent() has been called
        int orderOfParent = 0;

        SequenceElement current = e;
        while (current != null) {

            if (current instanceof Property) {
                Property prop = (Property) current;

                SeparatorPArg sepArg = PropertyArgumentUtil.getSeparatorPArg(prop);
                if (sepArg != null) {
                    // add separator sequence proposals as well
                    Sequence sepSeq = sepArg.getSeparatorSequence();
                    results.addAll(getPossibleFirstAtomicSequenceElements(sepSeq, classTemplateMap,
                            new HashSet<Template>(), syntax));
                } else {
                    if (isMultiValued(prop) && !containsForcedUpperArgOfOne(prop)) {

                        // add the first elements of this property to
                        // the follows-set

                        addAllIfNotNull(results,
                                getPossibleFirstAtomicSequenceElements(prop, classTemplateMap, new HashSet<Template>(), syntax));
                    }
                }

                // operator handling
                if (isOperatored(prop, classTemplateMap)) {
                    if (isOperator && orderOfParent == 1) {
                        // we are at an operator
                        // if the corresponding OperatorTemplates have a sequence, add the possible first atomic of that sequence.
                        // if this is not the case for at least one matching OperatorTemplate, add first elements of parent
                        // property

                        boolean otWithoutSequenceFound = false;

                        for (OperatorTemplate ot : findOperatorTemplatesByOperatorLiteralValue(operatorValue,
                                (EClass) getType(prop), syntax)) {
                            
                            HashSet<Template> visitedTemplates = new HashSet<Template>();
                            visitedTemplates.add(ot);
                            
                            if (ot.getTemplateSequence() != null) {
                                addAllIfNotNull(
                                        results,
                                        getPossibleFirstAtomicSequenceElements(ot.getTemplateSequence(), classTemplateMap,
                                                visitedTemplates, syntax));
                            } else {
                                otWithoutSequenceFound = true;
                            }
                        }

                        if (otWithoutSequenceFound) {

                            addAllIfNotNull(
                                    results,
                                    getPossibleFirstAtomicSequenceElements(prop, classTemplateMap, new HashSet<Template>(),
                                            syntax));
                        }

                    } else {
                        // we are before or past an operator and thus add all
                        // valid operators to the proposals
                        for (ClassTemplate ct : getClassTemplates((EClass) getType(prop), getMode(prop), classTemplateMap,
                                getResourceSetFromEObject(prop))) {
                            addAllIfNotNull(results, getOperatorsAsAtomicSequenceElements(getOperatorList(ct, syntax)));
                        }
                    }
                }
            }

            if (current instanceof Alternative) {
                Alternative alt = (Alternative) current;
                if (alt.isIsMulti()) {
                    addAllIfNotNull(results,
                            getPossibleFirstAtomicSequenceElements(alt, classTemplateMap, new HashSet<Template>(), syntax));
                }
            }

            Sequence parentSeq = current.getElementSequence();
            if (parentSeq.getSeparatorContainer() != null) {
                // we are in a separator sequence, add parent property to
                // proposals

                try {
                    Property parentProp = copiedParentPropertyStack.peek();
                    addAllIfNotNull(results, getPossibleFirstAtomicSequenceElements(parentProp, classTemplateMap,
                            new HashSet<Template>(), syntax));
                    // after separator, no other tokens are possible
                    return results;
                } catch (Exception ex) {
                    // do nothing
                }
            }

            SequenceElement next = getNextSequenceElement(current);

            while (next != null) {
                List<SequenceElement> nextElementResults = new ArrayList<SequenceElement>();

                addAllIfNotNull(nextElementResults,
                        getPossibleFirstAtomicSequenceElements(next, classTemplateMap, new HashSet<Template>(), syntax));

                results.addAll(nextElementResults);
                if (nextElementResults.contains(null)) {
                    next = getNextSequenceElement(next);

                } else {
                    // next SequenceElement is guaranteed to need a Token
                    return results;
                }
            }

            current = getParentSequenceElement(current, copiedParentFunctionCallStack, copiedParentPropertyStack,
                    classTemplateMap);

            orderOfParent++;
        }

        // special handling of operatored main template
        // don't need to check current == null because current has been used before
        if (syntax != null) {
            ClassTemplate main = TcsUtil.getMainClassTemplate(syntax);
            if (main.isIsOperatored()) {

                if (isOperator && orderOfParent == 1) {
                    // we are at an operator, add first elements of parent
                    // property
                    addAllIfNotNull(
                            results,
                            getPossibleFirstAtomicSequenceElements((EClass) main.getMetaReference(), main.getMode(), classTemplateMap,
                                    new HashSet<Template>(), syntax, getResourceSetFromEObject(main)));

                    // also add prefix operators
                    addAllIfNotNull(results, getPrefixOperatorsAsAtomicSequenceElements(getOperatorList(main, syntax)));

                } else {
                    // we are before or past an operator and thus add all
                    // valid operators to the proposals
                    addAllIfNotNull(results, getOperatorsAsAtomicSequenceElements(getOperatorList(main, syntax)));
                }
            }

        }

        return results;
    }
    
    private static Collection<OperatorTemplate> findOperatorTemplatesByOperatorLiteralValue(String operatorValue, EClass type,
            ConcreteSyntax syntax) {
        List<OperatorTemplate> result = new ArrayList<OperatorTemplate>();
        Collection<EClass> subTypes = TcsUtil.getAllSubtypes(type);
        for (Template t : syntax.getTemplates()) {
            if (t instanceof OperatorTemplate) {
                OperatorTemplate ot = (OperatorTemplate) t;
                for (EClass subType : subTypes) {
                    if (ot.getMetaReference() != null && ot.getMetaReference().equals(subType)) {
                        if (ot.getOperators() != null) {
                            for (Operator op : ot.getOperators()) {
                                // assumes that not two operators within the
                                // used
                                // operator list have the same literal
                                if (op.getLiteral().getValue().equals(operatorValue)) {
                                    result.add(ot);
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    private static OperatorList getOperatorList(ClassTemplate ct, ConcreteSyntax syntax) {
        OperatorList mainClassOpList = ct.getOperatorList();
        if (mainClassOpList != null) {
            return mainClassOpList;
        }

        // no operator list name specified, query operator lists of syntax
        // instead
        for (OperatorList opList : syntax.getOperatorLists()) {
            if (opList.getName() == null) {
                return opList;
            }
        }

        return null;
    }

    private static List<SequenceElement> getOperatorsAsAtomicSequenceElements(OperatorList operatorList) {
        if (operatorList == null) {
            return null;
        }

        List<SequenceElement> results = new ArrayList<SequenceElement>();
        for (Priority prio : operatorList.getPriorities()) {
            for (Operator op : prio.getOperators()) {
                if (!operatorToLiteralRefMap.containsKey(op)) {
                    cacheOperatorLiteral(operatorList, op);

                }
                results.add(operatorToLiteralRefMap.get(op));
            }
        }

        return results;
    }

    private static List<SequenceElement> getPrefixOperatorsAsAtomicSequenceElements(OperatorList operatorList) {
        if (operatorList == null) {
            return null;
        }

        // prefix means arity of 1 and left associativity and not postfix

        List<SequenceElement> results = new ArrayList<SequenceElement>();
        for (Priority prio : operatorList.getPriorities()) {
            if (prio.getAssociativity() == Associativity.LEFT) {
                for (Operator op : prio.getOperators()) {
                    if (op.getArity() == 1 && !op.isPostfix()) {
                        if (!operatorToLiteralRefMap.containsKey(op)) {
                            cacheOperatorLiteral(operatorList, op);

                        }
                        results.add(operatorToLiteralRefMap.get(op));
                    }
                }
            }
        }

        return results;
    }
    

    /**
     * Returns a list of the first possible atomic SequenceElements of the given Sequence.
     * 
     * @param s
     *            Sequence to get the first possible atomic SequenceElements from
     * @return first possible atomic SequenceElements
     */
    public static List<SequenceElement> getPossibleFirstAtomicSequenceElements(Sequence s,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates, ConcreteSyntax syntax) {

        assert (visitedTemplates != null);

        SequenceElement e = getFirstSequenceElement(s);

        List<SequenceElement> results = new ArrayList<SequenceElement>();

        List<SequenceElement> elementResults;
        do {
            elementResults = getPossibleFirstAtomicSequenceElements(e, classTemplateMap, new HashSet<Template>(visitedTemplates),
                    syntax);
            addAllIfNotNull(results, elementResults);
            e = getNextSequenceElement(e);
        } while (elementResults.contains(null) && e != null);

        return results;
    }
    
    
    /**
     * Returns a list of the first possible atomic SequenceElements of the given FunctionTemplate.
     * 
     * @param t
     *            FunctionTemplate to get the first possible atomic SequenceElements from
     * @return first possible atomic SequenceElements
     */
    private static List<SequenceElement> getPossibleFirstAtomicSequenceElements(FunctionTemplate t,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates, ConcreteSyntax syntax) {

        assert (visitedTemplates != null);

        if (t != null) {
            if (!visitedTemplates.contains(t)) {
                visitedTemplates.add(t);
                return getPossibleFirstAtomicSequenceElements(t.getFunctionSequence(), classTemplateMap, visitedTemplates, syntax);
            } else {
                return null;
            }

        }
        return createListWithEntry(null);
    }

    private static List<SequenceElement> createListWithEntry(SequenceElement e) {
        List<SequenceElement> result = new ArrayList<SequenceElement>();
        result.add(e);
        return result;
    }

    private static List<SequenceElement> getPossibleFirstAtomicSequenceElements(EClass type, String mode,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, Set<Template> visitedTemplates,
            ConcreteSyntax syntax, ResourceSet connection) {
        List<SequenceElement> results = new ArrayList<SequenceElement>();

        Collection<ClassTemplate> classTemplates = getClassTemplates(type, mode, classTemplateMap, connection);
        classTemplates.removeAll(visitedTemplates); // reduce classTemplates to the templates which have not yet been visited 
        visitedTemplates.addAll(classTemplates);

        for (ClassTemplate ct : classTemplates) {
            if (!ct.isIsAbstract()) {
                addAllIfNotNull(
                        results,
                        getPossibleFirstAtomicSequenceElements(ct.getTemplateSequence(), classTemplateMap, visitedTemplates,
                                syntax));
            } else {
                if (ct.isIsOperatored()) {
                    // add prefix operators
                    addAllIfNotNull(results, getPrefixOperatorsAsAtomicSequenceElements(getOperatorList(ct, syntax)));
                }
            }
        }
        return results;
    }

    public static List<ICompletionProposal> createFollowProposalsFromContext(ConcreteSyntax syntax,
            CtsContentAssistContext context, Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, ITextViewer viewer,
            int line, int charPositionInLine, Token token, TextBlocksModel tbModel, TCSSpecificOCLEvaluator oclEvaluator) {
        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

        if (context == null) {
            return results;
        }

        for (SequenceElement atomic : getPossibleAtomicFollows(context.getSequenceElement(),
                context.getParentFunctionCallStack(), classTemplateMap, context.getParentPropertyStack(), context.isOperator(),
                syntax)) {

            results.addAll(createProposalsFromAtomicSequenceElement(syntax, classTemplateMap, atomic, viewer, line,
                    charPositionInLine, token, tbModel, oclEvaluator));
        }

        return results;
    }
    
    
    private static List<ICompletionProposal> createProposalsFromAtomicSequenceElement(ConcreteSyntax syntax,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, SequenceElement e, ITextViewer viewer, int line,
            int charPositionInLine, Token token, TextBlocksModel tbModel, TCSSpecificOCLEvaluator oclEvaluator) {

        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

        if (e != null && syntax != null) {

            List<String> templateStrings = new ArrayList<String>();

            Template parentTemplate = getParentTemplate(e, syntax);
            Sequence parentSequence = getSequence(parentTemplate);
            Set<SequenceElement> templateFirstAtomicSet = new HashSet<SequenceElement>(
                    getPossibleFirstAtomicSequenceElements(parentSequence, classTemplateMap, new HashSet<Template>(),
                            syntax));

            if (isContained(e, templateFirstAtomicSet)) {
                // add template proposals starting at the parent template
                templateStrings.addAll(generateFollowTemplateProposalStrings(parentSequence, classTemplateMap, syntax,
                        new HashSet<Template>()));
            }

            Alternative parentAlternative = getParentAlternative(e);
            if (parentAlternative != null) {
                Set<SequenceElement> alternativeFirstAtomicSet = new HashSet<SequenceElement>(
                        getPossibleFirstAtomicSequenceElements(parentAlternative, classTemplateMap,
                                new HashSet<Template>(), syntax));

                if (isContained(e, alternativeFirstAtomicSet)) {
                    // add template proposals starting at each alternative
                    for (Sequence s : parentAlternative.getSequences()) {
                        templateStrings.addAll(generateFollowTemplateProposalStrings(s, classTemplateMap, syntax,
                                new HashSet<Template>()));
                    }
                }

            }

            for (String templateString : templateStrings) {
                // check if we actually have a template proposal and not
                // just a single keyword
                if (templateString.contains(" ")) {
                    String displayString = templateString;
                    String replacementString = displayString;
                    results.add(createTemplateProposal(displayString, replacementString, viewer, line, charPositionInLine, token));
                }
            }

        }

        if (e instanceof LiteralRef) {
            LiteralRef lit = (LiteralRef) e;
            if (lit.getReferredLiteral() != null) {
                String literalValue = lit.getReferredLiteral().getValue();
                String displayString = literalValue;
                String replacementString = displayString;
                results.add(createKeywordProposal(displayString, replacementString, viewer, line, charPositionInLine, token));
            }
        } else if (e instanceof Property) {
            Property prop = (Property) e;

            assert (isAtomic(prop, classTemplateMap));

            if (TcsUtil.isEnumeration(prop)) {
                // propose the enum values

                for (EnumLiteralMapping mapping : TcsUtil.getEnumTemplateForType(syntax, prop.getPropertyReference()
                        .getStrucfeature().getEType())) {

                    LiteralRef ref = (LiteralRef) mapping.getElement();
                    if (ref.getReferredLiteral() != null) {
                        String displayString = ref.getReferredLiteral().getValue();
                        String replacementString = displayString;
                        results.add(createPropValueProposal(displayString, replacementString, viewer, line,
                                charPositionInLine, token));
                    }
                }
            }

            RefersToPArg refersToArg = PropertyArgumentUtil.getRefersToPArg(prop);
            ReferenceByPArg referenceByArg = PropertyArgumentUtil.getReferenceByPArg(prop);
            LookupScopePArg lookupScopeArg = PropertyArgumentUtil.getLookupScopePArg(prop);

            if (referenceByArg != null && lookupScopeArg != null) {
                // first find all elements in the lookup scope, then apply referenceBy OCL expression to
                // map the individual elements into its string representation
                String invert = PropertyArgumentUtil.getReferenceByAsOCL(referenceByArg);
   
                Collection<EObject> allElementsInLookupScope = findAllElementsInLookupScope(viewer, line, charPositionInLine, tbModel,
                        lookupScopeArg, oclEvaluator);

                for (EObject candidateInScope : allElementsInLookupScope) {
                    String displayString = null;
                    String replacementString = null;
                    try {
                        // We don't have to pass in a context or foreach element: The invert/referenceBy query
                        // is directly executed on the elements in the lookupScope 
                        Object result = oclEvaluator.findElementsWithOCLQuery(candidateInScope, /*keyValue*/ null, invert,
                                /*context*/ null, /*foreach*/ null);

                        if (result instanceof Collection<?>) {
                            result = ((Collection<?>) result).iterator().next();
                        }
                        if (result instanceof String) {
                            replacementString = (String) result;
                            replacementString = PropertyArgumentUtil.stripPrefixPostfix(replacementString,
                                    PropertyArgumentUtil.getPrefixPArg(prop), PropertyArgumentUtil.getPostfixPArg(prop));
                            
                            displayString = replacementString + " : " + candidateInScope.eClass().getName()
                                    + " (by: " + invert + ")";
                        }
                    } catch (Exception e1) {
                        //this is not necessarily an error
                        //as we investigate whether the current property fits the element
                        //if this is not the case this caught exception may occur
                    }
                    if (displayString != null) {
                        results.add(createPropValueProposal(displayString, replacementString, viewer, line,
                                charPositionInLine, token));
                    }
                }
            }

            if (refersToArg != null) {
                // propose referenced feature of model elements queried by type
                EStructuralFeature propFeature = TcsUtil.getStructuralFeature(prop);
                if (propFeature != null) {
                    String featureName = PropertyArgumentUtil.getRefersToPArg(prop).getPropertyName();
                    List<String> propValues = queryPropertyValues(propFeature.getEType(), featureName, prop.eResource()
                            .getResourceSet());

                    for (String propValue : propValues) {
                        String displayString = propValue + " : " + propFeature.getEType().getName();
                        String replacementString = propValue;
                        results.add(createPropValueProposal(displayString, replacementString, viewer, line, charPositionInLine,
                                token));
                    }

                }
            }

            if (TcsUtil.isMultiValued(prop)) {
                // we have a multivalued primitive types property
                // name is likely to be plural so we add Entry to make the
                // proposal singular

                String displayString = TcsUtil.getPropertyName(prop.getPropertyReference()) + "Entry";
                String replacementString = displayString;
                results.add(createPropertyProposal(displayString, replacementString, viewer, line, charPositionInLine, token));
            } else {
                String displayString = TcsUtil.getPropertyName(prop.getPropertyReference());
                String replacementString = displayString;
                results.add(createPropertyProposal(displayString, replacementString, viewer, line, charPositionInLine, token));
            }

        }

        return results;
    }
    
    /**
     * Execute the lookupScope OCL query to find all elements which can potentially be bound.
     */
    @SuppressWarnings("unchecked")
    private static Collection<EObject> findAllElementsInLookupScope(ITextViewer viewer, int line, int charPositionInLine,
            TextBlocksModel textBlocksModel, LookupScopePArg queryArg, TCSSpecificOCLEvaluator oclEvaluator) {
        
        TextBlock currentVersion = TbVersionUtil.getOtherVersion(textBlocksModel.getRoot(), Version.CURRENT);
        if (currentVersion != null) {
            textBlocksModel = new TextBlocksModel(currentVersion);
        }
        // currentTbModel is non-null at this point
        if (textBlocksModel.getRoot() != null) {
            
            AbstractToken floorToken = textBlocksModel.getFloorTokenInRoot(getOffset(viewer, line, charPositionInLine));
            TextBlock parentBlock = floorToken.getParent();
            
            while (parentBlock != null && parentBlock.getCorrespondingModelElements().size() < 1) {
                parentBlock = parentBlock.getParent();
            }

            if (parentBlock != null) {
                // we found a parent block with attached model
                // element(s)

                EObject element = parentBlock.getCorrespondingModelElements().get(0);
                EObject contextElement = getContextElement(parentBlock, TcsUtil.getContextTag(queryArg.getQuery()));
                EObject foreachObject = getForeachElement(TcsUtil.getContextTag(queryArg.getQuery()));
                
                try {
                    return (Collection<EObject>) oclEvaluator.findElementsWithOCLQuery(element, /*keyValue*/ null,
                            queryArg.getQuery(), contextElement, foreachObject);

                } catch (Exception e1) {
                    System.out.println("Error executing ocl query: " + e1.getMessage());
                    // do nothing, just omit proposals
                }
            }
        }
        return Collections.emptyList();
    }

    /**
     * @param contextTag  
     */
    private static EObject getForeachElement(String contextTag) {
        // currently the ForeachElement is only used in queries of model elements without
        // syntactical elements and is thus currently irrelevant for content assist
        
        // once this changes a new testcase needs to be created and this implementation
        // can be derived from getContextElement()
        
        // do nothing
        return null;
    }

    private static EObject getContextElement(TextBlock parentBlock, String tag) {
        TextBlock curBlock = parentBlock;
        while (curBlock != null && curBlock.getCorrespondingModelElements().size() > 0) {
            Template t = curBlock.getType();
            if (t instanceof ClassTemplate) {
                ClassTemplate ct = (ClassTemplate) t;
                if (TcsUtil.matchesContext(ct, tag)) {
                    return curBlock.getCorrespondingModelElements().get(0);
                }
            }

            if (t instanceof OperatorTemplate) {
                OperatorTemplate ot = (OperatorTemplate) t;
                if (TcsUtil.matchesContext(ot, tag)) {
                    return curBlock.getCorrespondingModelElements().get(0);
                }
            }

            curBlock = curBlock.getParent();
        }

        return null;
    }
    
    private static List<String> queryPropertyValues(EClassifier type, String featureName, ResourceSet conn) {

        // TODO limit query to a single partition or use model information from
        // parsing handler instead?

        String query = "select ofClass from [" + EcoreUtil.getURI(type) + "] as ofClass";

        ResultSet resultSet;
        try {
            resultSet = EcoreHelper.executeQuery(query, EcoreHelper.getQueryContext(conn));
        } catch (MetaModelLookupException e1) {
            e1.printStackTrace();
            return Collections.emptyList();
        }

        URI[] resultElements = resultSet.getUris("ofClass");

        List<String> results = new ArrayList<String>();

        for (URI elemURI : resultElements) {
            try {
                EObject element = conn.getEObject(elemURI, false);
                Object featureValue = element.eGet(element.eClass().getEStructuralFeature(featureName));
                if (featureValue instanceof Integer) {
                    results.add("" + featureValue);
                }

                if (featureValue instanceof String) {
                    results.add((String) featureValue);
                }
            } catch (Exception e) {
                System.err.println("TcsUtil.queryPropertyValues encountered the following error: cannot read feature "
                        + featureName + " from element " + elemURI.toString());
            }

            // TODO need to add more type checks?
        }

        /*
         * System.out.println("TcsUtil.queryPropertyValues(" + joinNameList(type.getQualifiedName()) + ", " + featureName + ");");
         * System.out.println(query); System.out.println(results);
         */

        return results;

    }
    
    
    /**
     * generate all possible template strings of this sequence
     * 
     * @param s
     * @return
     */
    private static List<String> generateFollowTemplateProposalStrings(Sequence s,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, ConcreteSyntax syntax,
            HashSet<Template> visitedTemplates) {

        List<String> results = new ArrayList<String>();

        if (s == null) {
            return results;
        }

        results.add("");

        for (SequenceElement e : s.getElements()) {
            List<String> newResults = new ArrayList<String>();
            for (String result : results) {
                for (String templateProposal : generateFollowTemplateProposalStrings(e, classTemplateMap, syntax,
                        new HashSet<Template>(visitedTemplates))) {
                    String newResult = result + " " + templateProposal;
                    newResults.add(newResult.trim());
                }
            }
            if (!newResults.isEmpty()) {
                results = newResults;
            }
        }
        return results;
    }

    /**
     * generate all possible template strings of this sequence element
     * 
     * @param e
     * @return
     */
    private static List<String> generateFollowTemplateProposalStrings(SequenceElement e,
            Map<List<String>, Map<String, ClassTemplate>> classTemplateMap, ConcreteSyntax syntax,
            HashSet<Template> visitedTemplates) {
        List<String> results = new ArrayList<String>();

        if (e == null) {
            results.add("");
            return results;
        }

        List<SequenceElement> firstElements = getPossibleFirstAtomicSequenceElements(e, classTemplateMap,
                new HashSet<Template>(), syntax);
        if (!firstElements.contains(null)) {
            // we have a required SequenceElement

            // special handling of container sequence elements
            if (e instanceof Alternative) {
                Alternative alt = (Alternative) e;
                for (Sequence s : alt.getSequences()) {
                    results.addAll(generateFollowTemplateProposalStrings(s, classTemplateMap, syntax, new HashSet<Template>(
                            visitedTemplates)));
                }

                return results;
            }

            if (e instanceof ConditionalElement) {
                ConditionalElement cond = (ConditionalElement) e;
                results.addAll(generateFollowTemplateProposalStrings(cond.getThenSequence(), classTemplateMap, syntax,
                        new HashSet<Template>(visitedTemplates)));
                results.addAll(generateFollowTemplateProposalStrings(cond.getElseSequence(), classTemplateMap, syntax,
                        new HashSet<Template>(visitedTemplates)));

                return results;
            }

            if (e instanceof Block) {
                Block b = (Block) e;
                return generateFollowTemplateProposalStrings(b.getBlockSequence(), classTemplateMap, syntax, visitedTemplates);
            }

            if (e instanceof FunctionCall) {
                FunctionCall call = (FunctionCall) e;
                FunctionTemplate func = call.getCalledFunction();
                if (!visitedTemplates.contains(func)) {
                    visitedTemplates.add(func);
                    return generateFollowTemplateProposalStrings(func.getFunctionSequence(), classTemplateMap, syntax,
                            visitedTemplates);
                }
            }

            if (e instanceof Property) {
                Property p = (Property) e;
                if (!isAtomic(p, classTemplateMap)) {
                    
                    Collection<ClassTemplate> classTemplates = TcsUtil.getClassTemplates((EClass) TcsUtil.getType(p),
                            TcsUtil.getMode(p), classTemplateMap, p.eResource().getResourceSet());
                    classTemplates.removeAll(visitedTemplates); // reduce classTemplates to the templates which have not yet been visited 
                    visitedTemplates.addAll(classTemplates);

                    for (ClassTemplate ct : classTemplates) {
                        HashSet<Template> subVisited = new HashSet<Template>(visitedTemplates);
                        results.addAll(generateFollowTemplateProposalStrings(ct.getTemplateSequence(), classTemplateMap, syntax,
                                subVisited));
                    }

                    return results;
                }
            }

            // no composite
            String firstElemDisplayString = "";
            if (e instanceof LiteralRef) {
                LiteralRef ref = (LiteralRef) e;
                if (ref.getReferredLiteral() != null) {
                    firstElemDisplayString = ref.getReferredLiteral().getValue();
                }

            } else if (e instanceof Property) {
                Property prop = (Property) e;

                if (TcsUtil.isMultiValued(prop)) {
                    firstElemDisplayString = TcsUtil.getPropertyName(prop.getPropertyReference()) + "Entry";

                } else {
                    firstElemDisplayString = TcsUtil.getPropertyName(prop.getPropertyReference());
                }
            }

            results.add(firstElemDisplayString);

        }

        return results;
    }
    
    private static void addAllIfNotNull(List<SequenceElement> output, List<SequenceElement> input) {
        if (input != null) {
            output.addAll(input);
        }
    }
    
    
    
}
