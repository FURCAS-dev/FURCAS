/**
 * 
 */
package com.sap.furcas.runtime.parser.textblocks.observer;

import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.textblocks.LexedToken;

/**
 *
 */
public class TextBlockProxyTraversationContext {

    private TextBlockProxy contextBlock;

    private int lastVisitedChildIndex = -1;

    private SequenceElement sequenceElement;

    private int currentAlternative;

    private boolean operatorToken;

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
     * Gets the currently navigated {@link Alternative}.
     * @return
     */
    public int getCurrentAlternative() {
	return currentAlternative;
    }

    /**
     * Sets the currently chosen alternative
     * @param choice
     */
    public void setCurrentAlternative(int choice) {
	currentAlternative = choice;
	contextBlock.addAlternativeChoice(choice);
    }

    public void setOperatorToken(boolean operatorToken) {
        this.operatorToken = operatorToken;
    }

    public boolean isOperatorToken() {
        return operatorToken;
    }	

}
