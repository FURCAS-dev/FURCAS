package com.sap.mi.textual.parsing.textblocks;

import com.sap.mi.textual.common.interfaces.IModelElementProxy;
import com.sap.mi.textual.grammar.impl.ContextBuilder;
import com.sap.mi.textual.grammar.impl.context.ContextManager;
import com.sap.mi.textual.parsing.textblocks.observer.Stack;

public class LocalContextBuilder implements ContextBuilder {

	private ContextManager contextManager = new ContextManager();
	private Stack<IModelElementProxy> contextStack = new Stack<IModelElementProxy>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.impl.ContextBuilder#addToContext(com.sap.mi.textual.grammar.IModelElementProxy,
	 *      java.lang.String)
	 */
	public void addContext(IModelElementProxy element, String... tags) {
	    IModelElementProxy currentContextElement = null;
	    if (!contextStack.isEmpty()) {
		currentContextElement = contextStack.peek();
	    }
	    if (currentContextElement != null) {
		// create context using proxy for now, need to replace the proxy
		// by real
		// object
		// after
		// resolution / creation
		contextManager.addContextChildFor(currentContextElement, element, tags);
	    } else {
		contextManager.addRootContext(element, tags);
	    }
	    contextStack.push(element);
	}

	public ContextManager getContextManager() {
	    return contextManager;
	}

	public Stack<IModelElementProxy> getContextStack() {
	    return contextStack;
	}

	@Override
	public void addToCurrentContext(Object elementInContext) {
	    IModelElementProxy currentContextElement = null;
	    if (!contextStack.isEmpty()) {
		currentContextElement = contextStack.peek();
	    }
	    if (currentContextElement != null) {
		contextManager.addToContext(currentContextElement, elementInContext);
	    }
	}

    @Override
    public void reset() {
          contextStack.clear();
          contextManager = new ContextManager();
    }
}
