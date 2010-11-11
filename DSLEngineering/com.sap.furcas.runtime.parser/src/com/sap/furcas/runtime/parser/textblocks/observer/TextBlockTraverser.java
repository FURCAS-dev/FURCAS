/**
 * 
 */
package com.sap.furcas.runtime.parser.textblocks.observer;

import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;

/**
 * traverses a virtual tree based on events, traces an existing tree where there is an overlap.
 */
public class TextBlockTraverser {

    private final Stack<TextBlockProxyTraversationContext> stack = new Stack<TextBlockProxyTraversationContext>();

    public TextBlockTraverser() {
        TextBlockProxyTraversationContext rootContext = new TextBlockProxyTraversationContext(new TextBlockProxy());
        stack.push(rootContext);
    }
    
    /**
     * returns existing or newly created textblockproxy
     * @return
     */
    public TextBlockProxy enterNextChild() {
        TextBlockProxyTraversationContext currentContext = stack.peek();
        int lastIndex = currentContext.getLastVisitedChildIndex();
        currentContext.setLastVisitedChildIndex(lastIndex + 1);

        TextBlockProxy newTextBlockProxy = new TextBlockProxy();
		TextBlockProxyTraversationContext newContext = new TextBlockProxyTraversationContext(newTextBlockProxy);
        currentContext.addSubNode(newTextBlockProxy);
        stack.push(newContext);
        
        return newContext.getContextBlock();
    }
    
    /**
     * Returns the index of the last visited child.
     * @return
     */
    public int getLastVisitedChildIndex() {
    	TextBlockProxyTraversationContext currentContext = stack.peek();
        return currentContext.getLastVisitedChildIndex();
    }
    

    public void leaveChild() {
        stack.pop();
        if (stack.isEmpty()) {
            throw new IllegalStateException("Cannot leave root context");
        }
    }
    
    public TextBlockProxy getCurrent() {
        return stack.peek().getContextBlock();
    }
    
    public SequenceElement getCurrentSequenceElement() {
        return stack.peek().getCurrentSequenceElement();
    }
    
    public void addSubNode(AbstractToken token) {
        stack.peek().addSubNode(token);
    }
    
    public void addSubNode(TextBlockProxy token) {
        stack.peek().addSubNode(token);
    }
    
    public List<?> getSubNodes() {
        return stack.peek().getSubNodes();        
    }
    
    /**
     * @param offChannelTokens
     */
    public void addSubNodes(
            List<? extends AbstractToken> tokens) {
        stack.peek().addSubNodes(tokens);
    }
    
    /**
     * this can be used to reset the counter one child back in order to
     * re-enter the last child upon the next call to {@link #enterNextChild()}.
     */
	public void resetOneChildBack() {
//		//only reset if we are at least at the first child
//		if(stack.peek().getLastVisitedChildIndex() > -1) {
			stack.peek().setLastVisitedChildIndex(stack.peek().getLastVisitedChildIndex()-1);
//		}
	}

	public void setCurrentSequenceElement(SequenceElement sequenceElement) {
		// TODO Auto-generated method stub
		stack.peek().setCurrentSequenceElement(sequenceElement);
	}

	/**
	 * Adds the given <code>element</code> to the context of the element
	 * on top of the stack.
	 * @param element
	 */
	public void addToContext(Object element) {
	    stack.peek().addElementToContext(element);
	}

    public void enterAlternative(int choice) {
    	TextBlockProxyTraversationContext context = stack.peek();
    	if (context.getCurrentSequenceElement() instanceof Alternative) {
    	    context.setCurrentAlternative(choice);
    	}
        }

    public void exitAlternative() {
		TextBlockProxyTraversationContext context = stack.peek();
		if (context.getCurrentSequenceElement() instanceof Alternative) {
		    context.exitAlternative();
		}
    }

    public void setOperatorToken(boolean b) {
        stack.peek().setOperatorToken(b);
    }

    public boolean isOperatorToken() {
        return stack.peek().isOperatorToken();
    }


  
    
}
