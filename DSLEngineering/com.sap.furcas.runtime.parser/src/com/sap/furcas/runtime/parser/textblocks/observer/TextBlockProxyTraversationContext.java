/**
 * 
 */
package com.sap.furcas.runtime.parser.textblocks.observer;

import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;

/**
 *
 */
public class TextBlockProxyTraversationContext {

    private final TextBlockProxy contextBlock;

    private int lastVisitedChildIndex = -1;

    private SequenceElement sequenceElement;

    private boolean operatorToken;

    private int alternativeNestingLevel;

    /**
     * The sequence element that was used before a separator sequence. It is stored so
     * that it can be restored to the current sequence element once the separator sequence
     * was left.
     */
	private SequenceElement sequenceElementOfSeparator;

    /**
     * @param contextBlock
     */
    public TextBlockProxyTraversationContext(TextBlockProxy contextBlock) {
	super();
	if (contextBlock == null) {
	    throw new IllegalArgumentException("Block is null");
	}
	this.contextBlock = contextBlock;
    }

    /**
     * @return the lastVisitedChildIndex
     */
    public int getLastVisitedChildIndex() {
	return lastVisitedChildIndex;
    }

    /**
     * @param lastVisitedChildIndex
     *            the lastVisitedChildIndex to set
     */
    public void setLastVisitedChildIndex(int lastVisitedChildIndex) {
	this.lastVisitedChildIndex = lastVisitedChildIndex;
    }

    /**
     * @return the contextBlock
     */
    public TextBlockProxy getContextBlock() {
	return contextBlock;
    }

    public void addSubNode(Object node) {
	if (node == null) {
	    throw new IllegalArgumentException("node is null");
	}
	contextBlock.addSubNode(node);
	if (node instanceof TextBlockProxy) {
	    ((TextBlockProxy) node).setParent(contextBlock);
	    ((TextBlockProxy) node).setSequenceElement(sequenceElement);
	}
	if (node instanceof LexedToken) {
	    LexedToken tok = (LexedToken) node;
	    tok.setSequenceElement(sequenceElement);
	    tok.setOperator(operatorToken);
	}
    }

    /**
     * @param nodes
     */
    public void addSubNodes(List<? extends Object> nodes) {
	contextBlock.addSubNodes(nodes);
	for (Iterator<?> iterator = nodes.iterator(); iterator.hasNext();) {
	    Object node = iterator.next();
	    if (node instanceof TextBlockProxy) {
		((TextBlockProxy) node).setParent(contextBlock);
		((TextBlockProxy) node).setSequenceElement(sequenceElement);
	    }
	    if (node instanceof LexedToken) {
		LexedToken tok = (LexedToken) node;
		tok.setSequenceElement(sequenceElement);
		tok.setOperator(operatorToken);
	    }
	}
    }

    public List<Object> getSubNodes() {
	return contextBlock.getSubNodes();
    }

    /**
     * Sets the current {@link SequenceElement} that is then used to be attached
     * to all tokens that are consumed within this sequence element.
     */
    public void setCurrentSequenceElement(SequenceElement sequenceElement) {
	this.sequenceElement = sequenceElement;
    }
    
    /**
     * Gets the current {@link SequenceElement} that is then used to be attached
     * to all tokens that are consumed within this sequence element.
     */
    public SequenceElement getCurrentSequenceElement() {
	return sequenceElement;
    }

    /**
     * Used to store the element in the "context" of the current textnlock
     * @param element
     */
    public void addElementToContext(Object element) {
	contextBlock.addToContext(element);
    }

    /**
     * Sets the currently chosen alternative
     * @param choice
     * @param alternativeNestingLevel 
     */
    public void setCurrentAlternative(int choice) {
	alternativeNestingLevel++;
	// Crude hack: we use the negative value of the current
	// nesting level to mark to which level a certain alternative
	// choice belongs.
	// This is required by the pretty printer to decide
	// which chosen alternative belongs to which nested alternative.
	contextBlock.addAlternativeChoice(-alternativeNestingLevel); // marker
	contextBlock.addAlternativeChoice(choice);
    }

    public void exitAlternative() {
	// Crude hack: add marker to proper model the nesting level
	contextBlock.addAlternativeChoice(-alternativeNestingLevel); // marker
	alternativeNestingLevel--;
    }	

    public void setOperatorToken(boolean operatorToken) {
        this.operatorToken = operatorToken;
    }

    public boolean isOperatorToken() {
        return operatorToken;
    }

    
	public void setSequenceElementOfSeparator(
			SequenceElement currentSequenceElement) {
		this.sequenceElementOfSeparator = currentSequenceElement;
	}
	
	public SequenceElement getSequenceElementOfSeparator() {
		return this.sequenceElementOfSeparator;
	}

}
