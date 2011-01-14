package com.sap.furcas.ide.editor.contentassist;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.TcsDebugUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * Parsing Observer, that gathers all information necessary for ContentAssist.
 * 
 * @author D052602
 * 
 */
public class CtsContentAssistParsingHandler implements IParsingObserver {

    private static Resource transientPartition;

    /**
     * clears the parsing handler transient partition on this connection
     * 
     * @param c
     */
    public static void clearTransientPartition(ResourceSet c) {
        transientPartition.getContents().clear();
    }

    ConcreteSyntax syntax;

    /**
     * set to true after an error is found
     */
    private Boolean foundError = false;

    public CtsContentAssistParsingHandler(ConcreteSyntax syntax) {
        Assert.isNotNull(syntax);
        this.syntax = syntax;
        
        transientPartition = EcoreHelper.createTransientParsingResource(syntax.eResource().getResourceSet(),
                TCSPackage.eINSTANCE);

        classTemplateMap = TcsUtil.createClassTemplateMap(syntax);
        operatorTemplateMap = TcsUtil.createOperatorTemplateMap(syntax);
    }

    /**
     * contains a mapping of qualifiedName + Mode to ClassTemplate of all
     * ClassTemplates contained in the ConcreteSyntax passed to the constructor
     */
    Map<List<String>, Map<String, ClassTemplate>> classTemplateMap;

    /**
     * contains a mapping of qualifiedName to OperatorTemplate of all
     * OperatorTemplates contained in the ConcreteSyntax passed to the
     * constructor
     */
    Map<List<String>, OperatorTemplate> operatorTemplateMap;

    SortedMap<TextPosition, CtsContentAssistContext> positionMap = new TreeMap<TextPosition, CtsContentAssistContext>(
            new TextPositionComparator());

    /**
     * for unit test setup only!
     */
    public SortedMap<TextPosition, CtsContentAssistContext> getPositionMap() {
        return positionMap;
    }

    Stack<Sequence> currentSequenceStack = new Stack<Sequence>();
    Stack<SequenceElement> currentSequenceElementStack = new Stack<SequenceElement>();
    Stack<FunctionCall> currentParentFunctionCallStack = new Stack<FunctionCall>();
    Stack<Property> currentParentPropertyStack = new Stack<Property>();
    Stack<Template> currentParentTemplateStack = new Stack<Template>();
    boolean currentIsOperator = false;

    private final int loglevel = 0; // 0 = no log, 1 = errorsonly, 2 = all

    @Override
    public void reset() {
        foundError = false;
        positionMap.clear();
        currentSequenceStack.clear();
        currentSequenceElementStack.clear();
        currentParentFunctionCallStack.clear();
        currentParentPropertyStack.clear();
        currentParentTemplateStack.clear();
    }

    public Map<List<String>, Map<String, ClassTemplate>> getClassTemplateMap() {
        return classTemplateMap;
    }

    /**
     * Can be called after parsing is complete to check for a valid finish
     * state.
     */
    public void assertValidFinishState() {
        Assert.isTrue(
                currentSequenceStack.isEmpty(),
                "currentSequenceStack still contains "
                        + currentSequenceStack.size() + " elements");
        Assert.isTrue(currentSequenceElementStack.isEmpty(),
                "currentSequenceElementStack still contains "
                        + currentSequenceElementStack.size() + " elements");
        Assert.isTrue(currentParentFunctionCallStack.isEmpty(),
                "currentParentFunctionCallStack still contains "
                        + currentParentFunctionCallStack.size() + " elements");
        Assert.isTrue(currentParentPropertyStack.isEmpty(),
                "currentParentPropertyStack still contains "
                        + currentParentPropertyStack.size() + " elements");
        Assert.isTrue(currentParentTemplateStack.isEmpty(),
                "currentParentTemplateStack still contains "
                        + currentParentTemplateStack.size() + " elements");
    }

    public CtsContentAssistContext getFloorContext(int line,
            int charPositionInLine) {
        return getFloorContext(new TextPosition(line, charPositionInLine));
    }

    public CtsContentAssistContext getFloorContext(TextPosition position) {
        if (positionMap.containsKey(position)) {
            return positionMap.get(position);
        }

        // return nearest entry before position
        SortedMap<TextPosition, CtsContentAssistContext> headMap = positionMap
                .headMap(position);
        if (headMap.size() != 0) {
            return headMap.get(headMap.lastKey());
        }

        return null;
    }

    private void resolveNextSequenceElement() {
        try {
            SequenceElement currentSequenceElement = currentSequenceElementStack
                    .pop();

            if (currentSequenceElement == null) {
                currentSequenceElement = TcsUtil
                        .getFirstSequenceElement(currentSequenceStack.peek());
            } else {
                currentSequenceElement = TcsUtil
                        .getNextSequenceElement(currentSequenceElement);
            }

            currentSequenceElementStack.push(currentSequenceElement);
        } catch (EmptyStackException e) {
            currentSequenceElementStack.push(null);
            logError("could not resolve sequence element, stack empty");

        }
    }

    private void pushSequenceIfNecessary() {
        SequenceElement currentSequenceElement = currentSequenceElementStack
                .peek();
        if (currentSequenceElement instanceof FunctionCall) {
            FunctionCall call = (FunctionCall) currentSequenceElement;
            logInfo("push function call");

            currentParentFunctionCallStack.push(call);

            pushNonEmptySequence(call.getCalledFunction().getFunctionSequence());

        }

        if (currentSequenceElement instanceof Block) {
            Block block = (Block) currentSequenceElement;

            pushNonEmptySequence(block.getBlockSequence());
        }

        // ConditionalElement and Alternative are pushed in the
        // notifyEnterSequenceAlternative()
    }

    /**
     * Only push non-empty Sequences, as empty Sequences will never trigger
     * notifyExitSequenceElement(), and thus never get popped
     * 
     * @param seq
     *            Sequence to push
     */
    private void pushNonEmptySequence(Sequence seq) {
        if (seq == null) {
            logInfo("no push of null sequence");
            return;
        }

        if (seq.getElements() == null) {
            logInfo("no push of sequence with null elements");
            return;
        }

        if (seq.getElements().size() > 0) {
            logInfo("push sequence");
            currentSequenceStack.push(seq);
            currentSequenceElementStack.push(null);
        } else {
            logInfo("no push of empty sequence");
        }
    }

    private void popSequenceIfNecessary() {
        try {
            SequenceElement currentSequenceElement = currentSequenceElementStack
                    .peek();
            if (TcsUtil.isLastSequenceElement(currentSequenceElement)) {
                logInfo("pop Sequence");
                Sequence currentSequence = currentSequenceStack.pop();
                currentSequenceElementStack.pop();
                if (currentSequence.getFunctionContainer() != null) {
                    logInfo("pop parentFunctionCall");
                    currentParentFunctionCallStack.pop();
                }
            }
        } catch (EmptyStackException e) {
            logError("tried to pop empty stack");
        }

    }

    @Override
    public void notifyEnterRule(List<String> createdElement, String mode) {
        logInfo("notifyEnterRule " + createdElement + " " + mode);

        ClassTemplate resolved = TcsUtil.resolveClassTemplate(createdElement,
                mode, classTemplateMap);

        if (resolved != null) {
            logInfo("push parentTemplate");
            currentParentTemplateStack.push(resolved);
            pushNonEmptySequence(resolved.getTemplateSequence());
        } else {
            // check if we have an operatorTemplate

            OperatorTemplate ot = operatorTemplateMap.get(createdElement);
            if (ot != null) {
                logInfo("push parentTemplate");
                currentParentTemplateStack.push(resolved);
                pushNonEmptySequence(ot.getTemplateSequence());
            } else {

                logError("resolved null Template " + createdElement);
            }
        }
    }

    @Override
    public void notifyEnterSequenceAlternative(int choice) {
        logInfo("notifyEnterSequenceAlternative " + choice);

        SequenceElement currentSequenceElement = currentSequenceElementStack
                .peek();

        if (currentSequenceElement instanceof ConditionalElement) {
            ConditionalElement cond = (ConditionalElement) currentSequenceElement;
            if (choice == 0) {
                pushNonEmptySequence(cond.getThenSequence());
            } else {
                pushNonEmptySequence(cond.getElseSequence());
            }
        }

        if (currentSequenceElement instanceof Alternative) {
            Alternative alt = (Alternative) currentSequenceElement;
            // TODO why is Alternative.getSequences() a collection? Should be
            // ordered.
            List<SequenceInAlternative> sequences = new ArrayList<SequenceInAlternative>(
                    alt.getSequences());

            if (choice < sequences.size()) {
                pushNonEmptySequence(sequences.get(choice));
            } else {
                logError("invalid choice " + choice + " for "
                        + TcsDebugUtil.prettyPrint(alt));
            }
        }

    }

    @Override
    public void notifyEnterSequenceElement() {
        resolveNextSequenceElement();

        SequenceElement currentSequenceElement = currentSequenceElementStack
                .peek();

        if (currentSequenceElement != null) {
            logInfo("notifyEnterSequenceElement "
                    + TcsDebugUtil.prettyPrint(currentSequenceElement));

            if (currentSequenceElement instanceof Property) {
                Property prop = (Property) currentSequenceElement;
                if (isParentProperty(prop)) {
                    // further class templates belong to this Property, until it
                    // is left
                    logInfo("push parent property "
                            + TcsUtil.getPropertyName(prop
                                    .getPropertyReference()));
                    currentParentPropertyStack.push(prop);
                }

                if (TcsUtil.isEnumeration(prop)) {
                    // create dummy sequence and push it onto the sequence
                    // stack.
                    // this is necessary, as EnumerationKinds have no sequence,
                    // but reference
                    // literals directly

                    // TODO: once EnumerationKinds have a Sequence, push that
                    // Sequence directly
                    pushDummySequence("ENUMERATION_VALUE");
                }
            }

            pushSequenceIfNecessary();

        } else {
            logError("resolved null SequenceElement");
        }

    }

    @Override
    public void notifyEnterSequenceElement(String mri) {
        notifyEnterSequenceElement();
    }

    @Override
    public void notifyErrorInRule(RecognitionException re) {
        logInfo("notifyErrorInRule " + re);

        foundError = true;

        // mark last created context as error context
        if (getLastContext() != null) {
            getLastContext().setErrorContext(true);
        }

    }

    private CtsContentAssistContext getLastContext() {
        if (positionMap.size() > 0) {
            return positionMap.get(positionMap.lastKey());
        }

        return null;
    }

    @Override
    public void notifyExitRule(List<String> createdElementType) {
        logInfo("notifyExitRule " + createdElementType);

        try {
            logInfo("pop parentTemplate");
            currentParentTemplateStack.pop();
        } catch (EmptyStackException e) {
            logError("tried to pop empty stack");
        }

        // remaining pop of stacks is handled in
        // notifyExitSequenceElement()
    }

    @Override
    public void notifyExitSequenceAlternative() {
        logInfo("notifyExitSequenceAlternative");

        // do nothing, as pop of stacks is handled in
        // notifyExitSequenceElement()
    }

    @Override
    public void notifyExitSequenceElement() {
        try {
            SequenceElement top = currentSequenceElementStack.peek();
            logInfo("notifyExitSequenceElement "
                    + TcsDebugUtil.prettyPrint(top));

            if (top instanceof Property) {
                Property prop = (Property) top;
                if (isParentProperty(prop)) {
                    // no more class templates that belong to this Property
                    logInfo("pop parent property "
                            + TcsUtil.getPropertyName(prop
                                    .getPropertyReference()));
                    currentParentPropertyStack.pop();
                }
            }

            popSequenceIfNecessary();

        } catch (EmptyStackException e) {
            System.err
                    .println("sequence element stack empty on notifyExitSequenceElement");
        }
    }

    boolean isParentProperty(Property p) {
        return !TcsUtil.isAtomic(p, classTemplateMap)
                || PropertyArgumentUtil.containsSeparatorArg(p) || TcsUtil.isEnumeration(p);
    }

    @Override
    public void notifyCommittedModelElementCreation(Object newModelElement) {
        logInfo("notifyModelElementResolved " + newModelElement);

        // do nothing
    }

    @Override
    public void notifyModelElementResolvedOutOfContext(Object modelElement,
            Object contextModelElement, Token referenceLocation,
            DelayedReference reference) {
        logInfo("notifyModelElementResolvedOutOfContext " + modelElement + " "
                + contextModelElement + " " + referenceLocation);

        // TODO check if action is needed

    }

    @Override
    public void notifyTokenConsume(Token token) {
        if (token != null) {

            logInfo("notifyTokenConsume " + token.getText() + " ["
                    + token.getLine() + ", " + token.getCharPositionInLine()
                    + "]");

            if (token.getText() == null) {
                // special case for eos token
                return;
            }

            if (foundError) {
                logInfo("skipping context creation");
                return;
            }

            try {
                CtsContentAssistContext context = createContextFromToken(token);
                addContextToPositionMap(context);

            } catch (EmptyStackException e) {
                System.err
                        .println("could not create context, sequence element stack is empty");
            }
        } else {
            logError("consumed null token");
        }

    }

    private void addContextToPositionMap(CtsContentAssistContext context) {
        positionMap.put(
                new TextPosition(CtsContentAssistUtil.getLine(context
                        .getToken()), CtsContentAssistUtil
                        .getCharPositionInLine(context.getToken())), context);
    }

    private CtsContentAssistContext createContextFromToken(Token token) {
        CtsContentAssistContext context = new CtsContentAssistContext();
        context.setToken(token);
        context.setSequenceElement(currentSequenceElementStack.peek());
        context.setParentFunctionCallStack(TcsUtil
                .duplicateFunctionCallStack(currentParentFunctionCallStack));
        context.setParentPropertyStack(TcsUtil
                .duplicatePropertyStack(currentParentPropertyStack));
        context.setParentTemplateStack(TcsUtil
                .duplicateTemplateStack(currentParentTemplateStack));
        context.setOperator(currentIsOperator);

        // reset, as only the first token is the operator
        currentIsOperator = false;
        return context;
    }

    @Override
    public void notifyTokenConsumeWithError(Token token) {
        logInfo("notifyTokenConsumeWithError " + token);

        if (foundError) {
            logInfo("skipping context creation");
            return;
        }
        foundError = true;

        if (token != null) {
            if (token.getText() == null) {
                // seems to be an unlexed token.
                // fix location. text is fixed in parsing handler where document
                // text is available
                if (getLastContext() != null) {
                    Token lastContextToken = getLastContext().getToken();
                    if (lastContextToken != null
                            && lastContextToken.getText() != null) {
                        token.setLine(lastContextToken.getLine());
                        token.setCharPositionInLine(lastContextToken
                                .getCharPositionInLine()
                                + lastContextToken.getText().length());
                    }
                }
            }

            CtsContentAssistContext context = createContextFromToken(token);
            context.setErrorContext(true);

            addContextToPositionMap(context);
        }
    }

    @Override
    public void notifyCommitModelElementFailed() {
        logInfo("notifyModelElementResolutionFailed");

    }

    /**
     * @param string
     */
    private void logInfo(String string) {
        if (loglevel > 1) {
            System.out.println(string);
        }
    }

    /**
     * @param string
     */
    private void logError(String string) {
        if (loglevel > 0) {
            System.out.println("ERROR: " + string);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterSeparatorSequence
     * ()
     */
    @Override
    public void notifyEnterSeparatorSequence() {
        logInfo("notifyEnterSeparatorSequence");

        try {
            Property prop = currentParentPropertyStack.peek();
            if (prop != null) {
                SeparatorPArg sepArg = PropertyArgumentUtil.getSeparatorPArg(prop);
                if (sepArg != null) {
                    pushNonEmptySequence(sepArg.getSeparatorSequence());
                } else {
                    logError("notifyEnterSeparatorSequence called, but parentProperty has no SeparatorParg");
                }
            } else {
                logError("notifyEnterSeparatorSequence called, but parentProperty is null");
            }
        } catch (EmptyStackException e) {
            logError("tried to peek empty stack");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitSeparatorSequence
     * ()
     */
    @Override
    public void notifyExitSeparatorSequence() {
        logInfo("notifyExitSeparatorSequence");

        // do nothing, as pop of stacks is handled in
        // notifyExitSequenceElement()
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterOperatorSequence
     * (java.lang.String, int, boolean)
     */
    @Override
    public void notifyEnterOperatorSequence(String operator, int arity,
            boolean isUnaryPostfix) {
        logInfo("notifyEnterOperatorSequence operator: " + operator
                + " arity: " + arity + " isUnaryPostfix: " + isUnaryPostfix);

        currentIsOperator = true;

        // create dummy sequence and push it onto the sequence stack.
        // this is necessary, as Operator has no sequence, but references a
        // literal directly

        // TODO: once Operator has a Sequence, push that Sequence directly
        pushDummySequence(operator);

    }

    void pushDummySequence(String dummyKeywordName) {
        TCSFactory c = TCSFactory.eINSTANCE;
        Sequence dummy = c.createSequence();
        transientPartition.getContents().add(dummy);
        
        LiteralRef litRef = c.createLiteralRef();
        transientPartition.getContents().add(litRef);

        Keyword keyword = c.createKeyword();
        keyword.setValue(dummyKeywordName);
        transientPartition.getContents().add(keyword);

        litRef.setReferredLiteral(keyword);

        dummy.getElements().add(litRef);

        pushNonEmptySequence(dummy);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatorSequence
     * ()
     */
    @Override
    public void notifyExitOperatorSequence() {
        logInfo("notifyExitOperatorSequence");

        // do nothing, as pop of stacks is handled in
        // notifyExitSequenceElement()
    }

    /*
     * (non-Javadoc)
     * 
     * @seecom.sap.mi.textual.grammar.impl.IParsingObserver#
     * notifyEnterOperatoredBrackettedSequence()
     */
    @Override
    public void notifyEnterOperatoredBrackettedSequence() {
        logInfo("notifyEnterOperatoredBrackettedSequence");

    }

    /*
     * (non-Javadoc)
     * 
     * @seecom.sap.mi.textual.grammar.impl.IParsingObserver#
     * notifyExitOperatoredBrackettedSequence()
     */
    @Override
    public void notifyExitOperatoredBrackettedSequence() {
        logInfo("notifyExitOperatoredBrackettedSequence");

    }

    @Override
    public void notifyElementAddedToContext(Object element) {
        logInfo("notifyElementAddedToContext");

    }

    @Override
    public void notifyDelayedReferenceCreated(DelayedReference ref) {
        logInfo("notifyDelayedReferenceCreated");

    }

    @Override
    public void notifyEnterInjectorAction() {
        logInfo("notifyEnterInjectorAction");

    }

    @Override
    public void notifyExitInjectorAction() {
        logInfo("notifyExitInjectorAction");

    }

}
