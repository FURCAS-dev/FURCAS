/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.unparser.textblocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.unparser.PrettyPrintingPolicy;
import com.sap.furcas.unparser.PrettyPrintingTracer;

/**
 * This is a tracer which gathers information during pretty printing
 * to be able to serve as a {@link PrettyPrintPolicyProvider}.
 * 
 * The tracing is performed in order to know which old TextBlocks correspond to 
 * newly pretty printed information. The policies are then configured accordingly,
 * in order to transfer as much information (e.g. whitespaces) from the old TextBlocksModel
 * over to the new one.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class TextBlockPrettyPrintingTraverser implements PrettyPrintingPolicy, PrettyPrintingTracer {
    
    /**
     * Each context corresponds to one TextBlock 
     */
    private static class TraversationContext implements Cloneable {
	
	/**
	 * Must always be checked. If this is false all other values of this class may
	 * contain stupid/wrong/misleading values
	 */
	public boolean isValid;

	public TextBlock textBlock;
	public final LinkedList<SequenceElement> visitedSequenceElementOfBlock = new LinkedList<SequenceElement>();
	
	public boolean onTrackInSubNodeStream = true;
	// TODO: Improve performance by not consuming this list, but instead by 
	// maintaining an index counter which is incremented to simulate the current behavior
	public final LinkedList<DocumentNode> remainingDocumentNodesOfBlock = new LinkedList<DocumentNode>();
	public final HashMap<SequenceElement, AbstractToken> firstPreceedingWhiteSpacePerTokenSequenceElement = new HashMap<SequenceElement, AbstractToken>();

	public int alternativeNestingLevel;
	public final LinkedList<Integer> remainingAlternativeChoicesOfBlock = new LinkedList<Integer>();
	public final LinkedList<Boolean> haveConsumedAlternativeChoice = new LinkedList<Boolean>();
	
	/**
	 * Get valid context;
	 */
	public TraversationContext(TextBlock textBlock) {
	    this.textBlock = textBlock;
	    this.remainingAlternativeChoicesOfBlock.addAll(textBlock.getParentAltChoices());
	    this.remainingDocumentNodesOfBlock.addAll(TbNavigationUtil.getSubNodes(textBlock));
	    this.isValid = true;
	    
	    initializeSequenceElementStore(textBlock.getTokens());
	}
	
	private void initializeSequenceElementStore(List<AbstractToken> tokensOfBlock) {
	    AbstractToken currentleftMostWhiteSpace = null;
	    
	    for (AbstractToken token : tokensOfBlock) {
		if (token instanceof LexedToken) {
		    SequenceElement se = ((LexedToken) token).getSequenceElement();
		    if (currentleftMostWhiteSpace == null) {
			firstPreceedingWhiteSpacePerTokenSequenceElement.put(se, token);
		    } else {
			firstPreceedingWhiteSpacePerTokenSequenceElement.put(se, currentleftMostWhiteSpace);
			currentleftMostWhiteSpace = null;
		    }
		} else if (isWhiteSpace(token) && !isPseudoToken(token)) {
		    if (currentleftMostWhiteSpace == null) {
			currentleftMostWhiteSpace = token;
		    }
		} else {
		    currentleftMostWhiteSpace = null;
		}
	    }
	}
    	
	/**
	 * Get a NULL-context. Used if we did not found a correct textblock
	 */
	public TraversationContext() {
	    this.isValid = false;
	}
	
	@Override
	public TraversationContext clone() {
	    TraversationContext clone = new TraversationContext();
	    clone.textBlock = this.textBlock;
	    clone.isValid = this.isValid;
	    clone.onTrackInSubNodeStream = this.onTrackInSubNodeStream;
	    clone.alternativeNestingLevel = this.alternativeNestingLevel;
	    clone.haveConsumedAlternativeChoice.addAll(this.haveConsumedAlternativeChoice);
	    clone.visitedSequenceElementOfBlock.addAll(this.visitedSequenceElementOfBlock);
	    clone.firstPreceedingWhiteSpacePerTokenSequenceElement.putAll(this.firstPreceedingWhiteSpacePerTokenSequenceElement);
	    clone.remainingDocumentNodesOfBlock.addAll(this.remainingDocumentNodesOfBlock);
	    clone.remainingAlternativeChoicesOfBlock.addAll(this.remainingAlternativeChoicesOfBlock);
	    return clone;
	}
    }
   
    private final LinkedList<TraversationContext> traversationContextStack = new LinkedList<TraversationContext>();  
    private final TextBlockIndex textBlocksIndex;
        
    public TextBlockPrettyPrintingTraverser(TextBlockIndex index) {
	this.textBlocksIndex = index;
    }
    
    @Override
    public void notifyStartedClassTemplateForObject(int handle, EObject printedModelElement, Template template) {
	Collection<TextBlock> potentiallyReusableBlocks = textBlocksIndex.findTextBlock(template.getConcreteSyntax(), template, printedModelElement);
	if (potentiallyReusableBlocks.isEmpty()) {
	    this.traversationContextStack.push(/*null context*/ new TraversationContext());
	} else {
	    // it is unknown which textblocks to prefer if there are several potential
	    // this may happen if a model element is visible in several views
	    TextBlock block = potentiallyReusableBlocks.iterator().next();
	    this.traversationContextStack.push(/*valid context*/ new TraversationContext(block));
	}
    }
    
    private TraversationContext getCurrentContext() {
	return traversationContextStack.peek();
    }
    
    @Override
    public void notifyEndedClassTemplate(int handle) {
	traversationContextStack.pop();
	if (traversationContextStack.isEmpty() || !getCurrentContext().isValid) {
	    return;
	}
    }

    @Override
    public void notifyEnteredSequenceElement(SequenceElement seqElem) {
	getCurrentContext().visitedSequenceElementOfBlock.push(seqElem);
    }
    
    private SequenceElement getCurrentSequenceElement() {
	if (getCurrentContext().visitedSequenceElementOfBlock.isEmpty()) {
	    return null;
	} else {
	    return getCurrentContext().visitedSequenceElementOfBlock.peek();
	}
    }
        
    @Override
    public void notifyExitedSequenceElement() {
	getCurrentContext().visitedSequenceElementOfBlock.pop();
    }
    
    @Override
    public void notifyAboutToPrintWhiteSpace() {
	// do nothing
    }
    
    @Override
    public void notifyPrintedWhiteSpace(String ws) {
	// do nothing
    }
    
    @Override
    public void notifyAboutToPrintToken() {
	if (!getCurrentContext().isValid) {
	    return;
	}
	LinkedList<DocumentNode> subNodes = getCurrentContext().remainingDocumentNodesOfBlock;

	boolean success = consumeUntilNexedLexedToken(subNodes);
	getCurrentContext().onTrackInSubNodeStream = success;
    }
    
    /**
     * Fast forward to the leftmost whitespace in [..., TB, WS, WS, MyLexedToken, TB]
     * 
     * Caution: If we are not totally on track in the current stream, the whitespaces
     * might have been consumed early. We then forward to the lexed token instead.
     */
    private boolean consumeUntilNexedLexedToken(LinkedList<DocumentNode> subNodes) {
	ListIterator<DocumentNode> iter = subNodes.listIterator();
	
	AbstractToken targetToken = getCurrentContext().firstPreceedingWhiteSpacePerTokenSequenceElement.get(getCurrentSequenceElement());
	if (targetToken == null) {
	    return false;
	}
	
	if (getCurrentContext().remainingDocumentNodesOfBlock.contains(targetToken)) {
	    while (iter.hasNext()) {
		DocumentNode node = iter.next();
		if (node == targetToken) {
		    iter.previous(); // gone one to far
		    return true;
		} else {
		    iter.remove();
		}
	    }
	} else {
	    while (iter.hasNext()) {
		DocumentNode node = iter.next();
		if (node instanceof LexedToken && getSequenceElement(node) == getCurrentSequenceElement()) {
		    iter.previous(); // gone one to far
		    return true;
		} else {
		    iter.remove();
		}
	    }
	}
	return false; // happens at end of list
    }
    
    private static SequenceElement getSequenceElement(DocumentNode node) {
	return ((LexedToken) node).getSequenceElement();
    }
        
    @Override
    public void notifyPrintedToken() {
	if (!getCurrentContext().isValid || !getCurrentContext().onTrackInSubNodeStream) {
	    return;
	}
	LinkedList<DocumentNode> subNodes = getCurrentContext().remainingDocumentNodesOfBlock;
	SequenceElement seqElemOfNextNode = getSequenceElement(subNodes.peek()); 
	if (seqElemOfNextNode == getCurrentSequenceElement()) {
	    getCurrentContext().onTrackInSubNodeStream = true;
	    subNodes.pop(); // consume the sequence element; it was expected
	} else {
	    getCurrentContext().onTrackInSubNodeStream = false;
	}
    }
            
    @Override
    public String adaptWhiteSpace(String tcsImpliedWhiteSpace) {
	if (!getCurrentContext().isValid) {
	    return tcsImpliedWhiteSpace;
	}
	if (!getCurrentContext().onTrackInSubNodeStream) {
	    return tcsImpliedWhiteSpace;
	}
	String adaptedWS = consumeAndGetNextWhiteSpaceInCurrentBlock(/*deleteConsumedTokens*/ true);
	return adaptedWS;
    }

    @Override
    public Boolean desiresAdditionalWhiteSpace() {
	if (!getCurrentContext().isValid) {
	    return false;
	}
	if (!getCurrentContext().onTrackInSubNodeStream) {
	    return false;
	}
	return !getNextWhiteSpaceInCurrentBlock().isEmpty();
    }

    private String getNextWhiteSpaceInCurrentBlock() {
	return consumeAndGetNextWhiteSpaceInCurrentBlock(/*deleteConsumedTokens*/ false);
    }
    
    private String consumeAndGetNextWhiteSpaceInCurrentBlock(boolean deleteConsumedTokens) {
	Iterator<DocumentNode> iter = getCurrentContext().remainingDocumentNodesOfBlock.iterator();
	StringBuilder builder = new StringBuilder();
	
	while (iter.hasNext()) {
	    DocumentNode node = iter.next();
	    if (isPseudoToken(node)) {
		if (deleteConsumedTokens) {
		    iter.remove();
		}
		continue;
	    }
	    if (isWhiteSpace(node)) {
		builder.append(((AbstractToken) node).getValue());
		if (deleteConsumedTokens) {
		    iter.remove();
		}
	    } else {
		break;
	    }
	}
	return builder.toString();
    }
    
    private static boolean isPseudoToken(DocumentNode node) {
	return node instanceof Bostoken || node instanceof Eostoken;
    }
    
    private static boolean isWhiteSpace(DocumentNode node) {
	// TODO: check for parser token types instead?
	return node instanceof OmittedToken;
    }

    @Override
    public void notifyEnteredAlternative(Alternative alternative) {
	if (!getCurrentContext().isValid) {
	    return;
	}
	getCurrentContext().alternativeNestingLevel++;
	LinkedList<Integer> remainingChoices = getCurrentContext().remainingAlternativeChoicesOfBlock;

	if (!remainingChoices.isEmpty() && remainingChoices.peek().equals(markerOfCurrentLevel())) {
	    // there is potential that we can re-use our stored alternative choices;
	    remainingChoices.pop(); // consume the marker
	    getCurrentContext().haveConsumedAlternativeChoice.push(true);
	} else {
	    // may happen if it was not possible to use one of the alternatives
	    // we preferred earlier, but instead an alternative with additional
	    // nested alternatives was chosen.
	    // Therefore: do nothing and wait until we get (hopefully) back on
	    // track...
	    getCurrentContext().haveConsumedAlternativeChoice.push(false);
	}
    }
    
    @Override
    public void notifyBeganAlternativeChoice(int choiceIndexInAlternative) {
	// do nothing
    }

    @Override
    public void notifyExitedAlternative() {
	if (!getCurrentContext().isValid) {
	    return;
	}
	LinkedList<Integer> remainingChoices = getCurrentContext().remainingAlternativeChoicesOfBlock;
	if (getCurrentContext().haveConsumedAlternativeChoice.peek() && remainingChoices != null) {
	    // when we entered the alternative that is now closed, we consumed an opening marker
	    // from the list of remainingChoices. We must now also consume the corresponding closing marker
	    while (remainingChoices.peek() != markerOfCurrentLevel()) {
		remainingChoices.pop();
	    }
	    remainingChoices.pop(); // consume the marker;
	} 
	getCurrentContext().alternativeNestingLevel--;
	getCurrentContext().haveConsumedAlternativeChoice.pop();

    }
        
    @Override
    public List<SequenceInAlternative> getSequenceElementsOfCurrentAlternativeInPreferredOrder(Alternative alternative) {
	if (!getCurrentContext().isValid) {
	    return sortWithDefaultOrder(alternative.getSequences());
	}
	
	if (hasPreferredChoiceForCurrentAlternative()) {
	    int preferredSequenceNr = getAndConsumePreferredAlternative();
	    List<SequenceInAlternative> sequences = new ArrayList<SequenceInAlternative>(alternative.getSequences());
	    SequenceInAlternative preferredSequence = sequences.remove(preferredSequenceNr);
	    // make sure preferred sequence is at the beginning and the rest is in default order
	    sequences = sortWithDefaultOrder(sequences);
	    sequences.add(0, preferredSequence);
	    return sequences;
	} else {
	    return sortWithDefaultOrder(alternative.getSequences());
	}
    }
    
    private int markerOfCurrentLevel() {
	return -getCurrentContext().alternativeNestingLevel;
    }
    
    private boolean hasPreferredChoiceForCurrentAlternative() {
	return !getCurrentContext().remainingAlternativeChoicesOfBlock.isEmpty() && 
		getCurrentContext().remainingAlternativeChoicesOfBlock.peek() >= 0; // must not be a marker
    }
    
    private int getAndConsumePreferredAlternative() {
	assert getCurrentContext().remainingAlternativeChoicesOfBlock.peek() >= 0 : "Must not be a marker";
	return getCurrentContext().remainingAlternativeChoicesOfBlock.pop();
    }
        
    /**
     * Default sort order is by number of sequence elements.
     * Largest are first, because those have the most information.
     */
    private List<SequenceInAlternative> sortWithDefaultOrder(Collection<SequenceInAlternative> collection) {
	List<SequenceInAlternative> result = new ArrayList<SequenceInAlternative>(collection);
	Collections.sort(result, new Comparator<Sequence>() {
	    @Override
	    public int compare(Sequence a, Sequence b) {
		// swap a and b to have largest sequence first
		return new Integer(b.getElements().size()).compareTo(a.getElements().size());
	    }
	});
	return result;
    }
    
    @Override
    public TextBlockPrettyPrintingTraverser clone() {
	TextBlockPrettyPrintingTraverser clone = new TextBlockPrettyPrintingTraverser(textBlocksIndex);
	for (TraversationContext context : this.traversationContextStack) {
	    clone.traversationContextStack.add(context.clone());
	}
	return clone;
    }

    @Override
    public void notifySafePointCreated(int handle) {
	throw new AssertionError("Not yet implemented");
    }

    @Override
    public void notifyResettedToSafePoint(int handle) {
        throw new AssertionError("Not yet implemented");
    }

}
