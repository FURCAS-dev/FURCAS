package com.sap.furcas.runtime.parser.textblocks.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.implementation.ResolvedModelElementProxy;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.parser.impl.ParserScope;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.textblocks.TbUtil;

/**
 * This class handles the connection between the parser and the textblocks
 * the connection between the parser and the textblocks
 * model.
 * 
 * IMPORTANT NOTE: The current assumption is that the smallest unit of re-use is
 * a whole textblock. This means that whenever {@link #notifyEnterRule(List)} is
 * called and the contents of the block are not consistent to the parse rule
 * anymore, the whole textblock is deleted and re-constructed according to the
 * called rules.
 * 
 * @author C5106462
 * 
 */
public class ParserTextBlocksHandler implements IParsingObserver {

    /**
     * used to track current context in virtual tree in parallel to existing
     * tree
     */
    private TextBlockTraverser traverser;
    private final ITextBlocksTokenStream input;

    /**
     * Flag to indicate whether root rule has been entered yet or not.<p>
     * 
     * ruleDepth == -1 means we are outside root context of traverser <p>
     * ruleDepth == 0 means we are in root context of traverser
     */
    private int ruleDepth = -1;
    private static final int EOF = -1;

    private final OppositeEndFinder textBlocksOnlyOppositeEndFinder;
    private final ParserScope parserScope;
    private final PartitionAssignmentHandler partitionAssignmentHandler;
    private TextBlock existingRoot;

    /**
     * Constructs a new Handler which will read from the TextBlocksTokenStream
     * on Parser events, and build up a textBlocks model
     * 
     * @param partitionAssignmentHandler to retrieve information about the location of textblocks
     * @param injector used for error reporting 
     */
    public ParserTextBlocksHandler(ITextBlocksTokenStream input, ParserScope parserScope,
            PartitionAssignmentHandler partitionAssignmentHandler) {
        this.parserScope = parserScope;
        this.input = input;
        this.partitionAssignmentHandler = partitionAssignmentHandler;

        this.traverser = new TextBlockTraverser();
        //      TODO: Disabled until the PartitonAssignmentHandler does no longer assign TextBlocks to
        //      domain model resources.  Stephan Erb, 17.05.2011     
        //      this.textBlocksOnlyOppositeEndFinder = new Query2OppositeEndFinder(new TextBlocksPartitonQueryContextProvider());
        this.textBlocksOnlyOppositeEndFinder = DefaultOppositeEndFinder.getInstance();
    }

    /**
     * returns the current TextBlockProxy of the TextBlockTraverser.
     * @return
     */
    public TextBlockProxy getCurrentTbProxy() {
        return traverser.getCurrent();
    }

    /**
     * This method is called at the start of a parse rule.
     * 
     * NOTE: It is assumed that currently the relationship between a parse
     * rule/a template to the structure of the textblocks is one-to-one.
     * Furthermore re-use of textblocks is done only using their ordering. An
     * incremental parsing technique will be employed instead of this once it
     * becomes available.
     */
    @Override
    public void notifyEnterRule(String templateURI) {
        if (ruleDepth > -1) {
            traverser.enterNextChild();
        }
        Template template = (Template) parserScope.getResourceSet().getEObject(URI.createURI(templateURI), true);
        if (template != null) {
            traverser.getCurrent().setTemplate(template);
            ruleDepth++;
        } else {
            failWithError("Could not resolve TCS template " + templateURI
                    + ". This indicates that parser and mapping are not in sync.");
        }
        
    }

    /**
     * It navigates to the textblock that belongs to the given context within
     * the {@link #currentTextBlock} which is then used during parsing to add
     * all matched token elements and subblocks to it.
     */
    @Override
    public void notifyEnterSequenceAlternative(int choice) {
        traverser.enterAlternative(choice);
    }

    @Override
    public void notifyExitSequenceAlternative() {
        traverser.exitAlternative();
    }

    /**
     * Marks the current textblock as incomplete. This is to be set by the
     * parser when it cannot match the a rule to the tokens in its token stream.
     */
    @Override
    public void notifyErrorInRule(RecognitionException re) {
        TextBlockProxy currentBlock = traverser.getCurrent();
        if (currentBlock != null) {
            currentBlock.setComplete(false);
        }

    }

    /**
     * Exits the current textblock context by setting the parent textblock of
     * the current textblock as new current textblock.
     */
    @Override
    public void notifyExitRule() {
        if (ruleDepth < 0) { // cannot leave root context depth
            throw new IllegalStateException("Attempt to leave root context more than once");
        }
        try {
            /*
             * complete filling and setting of textblock that was started on
             * enterRule
             */
            TextBlockProxy currentTextBlock = traverser.getCurrent();

            // ruleDepth == -1 means we are outside root context of traverser
            // ruleDepth == 0 means we are in root context of traverser
            /*
             * do not leave root even if new depth will be == 0, because
             * some tokens may still be consumed, those will be added on EOF
             * no need to leave child, as there is no parent in traverser,
             * no need to save to parent
             */
            if (ruleDepth > 0) {
                /* Now leave the current context with all the required side effects */
                traverser.leaveChild();

                TextBlockProxy contextTextBlock = traverser.getCurrent();
                if (currentTextBlock.getSubNodes().size() == 0) {
                    //textblock has no tokens and was only used to
                    //instanciate additional model elements so add them to the elements of this block
                    //and remove empty block;
                    contextTextBlock.addAdditionalTemplate(currentTextBlock.getTemplate());
                    contextTextBlock.addCorrespondingModelElementProxies(currentTextBlock.getCorrespondingModelElementProxies());
                    contextTextBlock.addAdditionalTemplates(currentTextBlock.getAdditionalTemplates());
                    contextTextBlock.removeSubNode(currentTextBlock);
                } else {
                    // we have no textblock to add, so ignore
                }
            }
        } catch (RuntimeException jmie) {
            // should never happen, but happens. Exceptions get swallowed in the call trace else,
            // due to consequent Exceptions
            jmie.printStackTrace();
            throw jmie;
        } finally {
            // (-1 is still allowed, we assign tokens to rootblock then)
            ruleDepth--; // needs to be called even on exceptions to prevent trying to leave root.
        }
    }

    @Override
    public void notifyTokenConsume(Token token) {
        consumeToken(token);
    }

    @Override
    public void notifyTokenConsumeWithError(Token token) {
        consumeToken(token);
    }

    /**
     * add all omitted tokens that were skipped so far to the text block as well
     * TODO check this behaviour, it might be necessary to make this
     * configurable because there might be different expectations on where
     * omitted tokens get stored (before, behind, in current textblock etc.)
     * 
     * @param token
     */
    private void consumeToken(Token token) {
        if (token.getType() != EOF) {
            AbstractToken tokenToRelocate = input.consumeTokenModelElementForParserToken(token);
            Collection<? extends AbstractToken> offChannelTokens = input.consumeOffChannelTokensUpTo(tokenToRelocate);

            // add the tokenToRelocate after adding all skipped tokens
            for (AbstractToken offChannelToken : offChannelTokens) {
                traverser.addSubNode(offChannelToken);
            }
            traverser.addSubNode(tokenToRelocate);

        } else {
            // consume all left tokens
            List<? extends AbstractToken> offChannelTokens = input.consumeOffChannelTokensUpTo(null);
            traverser.addSubNodes(offChannelTokens);
        }
    }

    @Override
    public void notifyEnterSequenceElement() {
    }

    @Override
    public void notifyEnterSequenceElement(String sequenceElementURI) {
        SequenceElement sequenceElement = (SequenceElement) parserScope.getResourceSet().getEObject(
                URI.createURI(sequenceElementURI), true);
        if (sequenceElement != null) {
            traverser.setCurrentSequenceElement(sequenceElement);
        } else {
            failWithError("Could not resolve TCS sequence element " + sequenceElementURI
                    + ". This indicates that parser and mapping are not in sync.");
        }
    }

    @Override
    public void notifyEnterInjectorAction() {
        SequenceElement sequenceElement = traverser.getCurrentSequenceElement();
        if (sequenceElement instanceof InjectorActionsBlock) {
            InjectorAction oldAction = traverser.getCurrent().getInjectorAction();
            InjectorAction currentAction = null;
            if (oldAction == null) {
                currentAction = ((InjectorActionsBlock) sequenceElement).getInjectorActions().iterator().next();
            } else {
                boolean next = false;
                for (InjectorAction action : ((InjectorActionsBlock) sequenceElement).getInjectorActions()) {
                    if (action.equals(oldAction)) {
                        next = true;
                        continue;
                    }
                    if (next) {
                        currentAction = action;
                        break;
                    }
                }
            }
            traverser.getCurrent().setInjectorAction(currentAction);
        }
    }

    @Override
    public void notifyExitInjectorAction() {
        // TODO Auto-generated method stub

    }

    @Override
    public void notifyExitSequenceElement() {
        if (traverser.isOperatorToken()) {
            //matching of operator tokenalways is surrounded with enterEqEl and exitSeqEl directly. So we need
            //to switch operator token off here, otherwise elements from this point to to the 
            //exitOperatorSequence will also get operatorToken set to true.
            traverser.setOperatorToken(false);
        }
    }

    /**
     * The given <code>newModelElement</code> is added to the
     * {@link DocumentNode#getCorrespondingModelElements()} of the
     * {@link #currentTextBlock}.
     */
    @Override
    public void notifyCommittedModelElementCreation(Object newModelElement) {
        if (newModelElement == null) {
            throw new IllegalArgumentException("Notified with null");
        }
        if (newModelElement instanceof IModelElementProxy) {
            TextBlockProxy currentTextBlock = traverser.getCurrent();
            currentTextBlock.getCorrespondingModelElementProxies().add(0, //always add at first position as it is the "leading" element
                    (IModelElementProxy) newModelElement);
            ((ModelElementProxy) newModelElement).setTextBlock(currentTextBlock);
            if (currentTextBlock.getTemplate() instanceof OperatorTemplate
                    && ((OperatorTemplate) currentTextBlock.getTemplate()).getStoreLeftSideTo() != null) {
                //need to add left hand side textblock to current one as child to correctly represent 
                //composition
                String storeLeftToProperty = ((OperatorTemplate) currentTextBlock.getTemplate()).getStoreLeftSideTo()
                        .getStrucfeature().getName();
                ModelElementProxy leftHandSide = (ModelElementProxy) ((Collection<Object>) ((ModelElementProxy) newModelElement)
                        .getAttributeMap().get(storeLeftToProperty)).iterator().next();
                TextBlockProxy leftHandSideTBProxy = (TextBlockProxy) leftHandSide.getTextBlock();
                //add all consumed tokens and textblock starting from the lefthand side proxy to the current textblock
                TextBlockProxy parent = leftHandSideTBProxy.getParent();
                if (parent != null) {
                    int index = parent.getSubNodes().indexOf(leftHandSideTBProxy);
                    List<Object> elementsMoved = new ArrayList<Object>();
                    for (; index < parent.getSubNodes().size(); index++) {
                        Object element = parent.getSubNodes().get(index);
                        elementsMoved.add(element);
                    }
                    int position = 0;
                    for (Object object : elementsMoved) {
                        if (!currentTextBlock.equals(object)) {
                            // remove elements from their original parent
                            parent.getSubNodes().remove(object);
                            if (object instanceof TextBlockProxy) {
                                ((TextBlockProxy) object).setParent(currentTextBlock);
                            }
                            // add elements to current proxy at start index
                            currentTextBlock.addSubNodeAt(object, position++);
                        }
                    }
                }
            }
        } else {
            throw new RuntimeException("Expected IModelElementProxy but got: " + newModelElement.getClass().getCanonicalName());
        }
    }

    /**
     * The given <code>modelElement</code> is added to the
     * {@link DocumentNode#getReferencedElements()} of the
     * corresponding {@link AbstractToken} of the <code>referenceLocation</code>
     * {@link Token}. The <code>referenceType</code> indicates what the type of the
     * {@link DelayedReference} was that was resolved. That can be e.g., {@link DelayedReference#SEMANTIC_PREDICATE}
     * meaning that the delayed reference was created for a things like a {@link ForeachPredicatePropertyInit}.
     * 
     */
    @Override
    public void notifyModelElementResolvedOutOfContext(Object modelElement, Object contextModelElement, Token referenceLocation,
            DelayedReference reference) {
        if (contextModelElement instanceof ResolvedModelElementProxy) {
            contextModelElement = ((ResolvedModelElementProxy) contextModelElement).getRealObject();
        }

        if (modelElement instanceof Collection && ((Collection<?>) modelElement).size() == 1) {
            modelElement = ((Collection<?>) modelElement).iterator().next();
        }

        TextBlock contextBlock = getTextBlockForElementAt((EObject) contextModelElement, (ANTLR3LocationToken) referenceLocation);
        if (contextBlock != null && modelElement instanceof EObject) {

            if (reference.getType() == DelayedReference.ReferenceType.TYPE_FOREACH_PREDICATE) {
                // this means we are in the resolving of a foreachproperty init
                // thus we have to add the curently set template to the
                // additionalTemplates of
                // of the contextBlock. This will make all injectoractions
                // associated with the template
                // available for the GDR for the given model element
                contextBlock.getAdditionalTemplates().add(getCurrentTbProxy().getTemplate());
                contextBlock.getCorrespondingModelElements().add((EObject) modelElement);

            } else {
                AbstractToken referenceToken = navigateToToken(contextBlock, referenceLocation);
                if (referenceToken != null && referenceToken instanceof LexedToken) {
                    ((LexedToken) referenceToken).getReferencedElements().add((EObject) modelElement);
                }
            }
        }
    }

    /**
     * Attaches the current {@link SequenceElement} or {@link InjectorAction} to the given
     * {@link DelayedReference}.
     */
    @Override
    public void notifyDelayedReferenceCreated(DelayedReference ref) {
        if (traverser.getCurrentSequenceElement() instanceof InjectorActionsBlock) {
            ref.setQueryElement(traverser.getCurrent().getInjectorAction());
        } else {
            ref.setQueryElement(traverser.getCurrent().getSequenceElement());
        }
        ref.setTextBlock(traverser.getCurrent());
    }

    @Override
    public void notifyElementAddedToContext(Object element) {
        traverser.addToContext(element);
    }

    /**
     * Navigates to the corresponding AbstractToken of the given
     * referenceLocation within the <code>contextBlock</code>.
     * 
     * @param contextBlock
     *            Block from where to start navigation, has to be the direct
     *            owner of the token that is searched for.
     * @param referenceLocation
     *            The ANLTR token that denotes the position of the corresponind
     *            modelelement token.
     * @return the model element token that corresponds to the given
     *         referenceLocation
     */
    private AbstractToken navigateToToken(TextBlock contextBlock, Token referenceLocation) {
        if (referenceLocation != null) {
            int absoluteLocation = ((ANTLR3LocationToken) referenceLocation).getStartIndex();
            int relativeLocation = absoluteLocation - TbUtil.getAbsoluteOffset(contextBlock);
            for (AbstractToken tok : contextBlock.getTokens()) {
                if (tok.getOffset() == relativeLocation) {
                    return tok;
                }
            }
        }
        return null;
    }

    // /**
    // * Adds the given <code>subBlock</code> to the <code>parentBlock</code>
    // * including the re-computation of its offset.
    // *
    // * @param parentBlock
    // * @param subBlock
    // *
    // */
    // private void connectSubBlock(TextBlock parentBlock, TextBlock subBlock) {
    // parentBlock.getSubBlocks().add(subBlock);
    // // make offset relative to root
    // subBlock.setOffset(subBlock.getOffset() - parentBlock.getOffset());
    // subBlock.setOffsetRelative(true);
    // }

    /**
     * Uses {@link DocumentNodeReferencesCorrespondingModelElement} to find a corresponding {@link TextBlock} for the
     * given <code>element</code>.
     * 
     * @param element the element to get the {@link TextBlock} for
     * @return the corresponding {@link TextBlock} for the given element
     */
    private TextBlock getTextBlockForElementAt(EObject element, ANTLR3LocationToken referenceToken) {
        TextBlock rootBlock = TbUtil.getNewestVersion(existingRoot);
        
        for (TextBlock textBlock : TbUtil.findTextBlockOf(rootBlock, element, parserScope.getResourceSet())) {
            
            int candidateOffset = TbUtil.getAbsoluteOffset(textBlock);
            if (referenceToken != null && ((candidateOffset > referenceToken.getStartIndex()) || 
                    (candidateOffset + textBlock.getLength() < referenceToken.getStopIndex()))) {
                continue;
            }
            return textBlock;
        }
        return null;
    }

    /**
     * This setter can be used to define the parent context on which the class
     * is going to work
     * 
     * @param root
     */
    public void setRootBlock(TextBlock root) {
        this.existingRoot = root;
        this.traverser = new TextBlockTraverser();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyModelElementResolutionFailed()
     */
    @Override
    public void notifyCommitModelElementFailed() {

    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterOperatoredBrackettedSequence()
     */
    @Override
    public void notifyEnterOperatoredBrackettedSequence() {
        // ignore

    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterSeparatorSequence()
     */
    @Override
    public void notifyEnterSeparatorSequence() {
        //store sequence before separator as it will be restored after separator consumption
        SequenceElement currentSequenceElement = traverser.getCurrentSequenceElement();
        traverser.setSequenceElementOfSeparator(currentSequenceElement);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatoredBrackettedSequence()
     */
    @Override
    public void notifyExitOperatoredBrackettedSequence() {
        //ignore

    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitSeparatorSequence()
     */
    @Override
    public void notifyExitSeparatorSequence() {
    	//restore sequence from before separator
        SequenceElement currentSequenceElement = traverser.getSequenceElementOfSeparator();
        traverser.setCurrentSequenceElement(currentSequenceElement);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyEnterOperatorSequence(java.lang.String, int, boolean)
     */
    @Override
    public void notifyEnterOperatorSequence(String operator, int arity, boolean isUnaryPostfix) {
        traverser.setOperatorToken(true);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IParsingObserver#notifyExitOperatorSequence()
     */
    @Override
    public void notifyExitOperatorSequence() {
        //if there was a right hand side assign the textblock created for it to the textblock responsible for
        //the operator templated element.
        TextBlockProxy currentTextBlockProxy = traverser.getCurrent();
        //first get the second to the last TextBlockProxy within the parent
        int index = currentTextBlockProxy.getSubNodes().size() - 1;
        boolean countedFirstTbFromReverse = false;
        TextBlockProxy last = null;
        TextBlockProxy secondToLast = null;
        while (index > 0) {
            Object o = currentTextBlockProxy.getSubNodes().get(index--);
            if (o instanceof TextBlockProxy) {
                if (countedFirstTbFromReverse) {
                    secondToLast = (TextBlockProxy) o;
                    break;
                } else {
                    last = (TextBlockProxy) o;
                    countedFirstTbFromReverse = true;
                }
            }
        }
        if (secondToLast != null && secondToLast.getTemplate() instanceof OperatorTemplate) {
            OperatorTemplate optemplate = (OperatorTemplate) secondToLast.getTemplate();
            if (optemplate.getStoreRightSideTo() != null) {
                //this means that the right hand side proxy was added to the parent textblock instead of
                //the one for the operatortemplate, so move it to there
                last.setParent(secondToLast);
                currentTextBlockProxy.removeSubNode(last);
                secondToLast.addSubNodeAt(last, secondToLast.getSubNodes().size());
            }
        }
    }

    @Override
    public void reset() {
        this.traverser = new TextBlockTraverser();
        //ruleDepth = 0;
    }

    /**
     * This class should not fail silently, as this means that we might continue incremental parsing based
     * on false information. This might lead to information loss when we try to "re-use" information. 
     */
    private void failWithError(Throwable cause, String message) {
        cause.printStackTrace();
        throw new RuntimeException(message, cause);
    }

    private void failWithError(String message) {
        failWithError(new RuntimeException(message), message);
    }

}
