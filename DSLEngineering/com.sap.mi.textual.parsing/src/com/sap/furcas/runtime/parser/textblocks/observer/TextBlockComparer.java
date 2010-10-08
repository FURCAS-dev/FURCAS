package com.sap.furcas.runtime.parser.textblocks.observer;

import java.util.Collection;
import java.util.List;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.runtime.parser.textblocks.TextBlockFactory;

public class TextBlockComparer {

	private Stack<TextBlockTraversationContext> stack = new Stack<TextBlockTraversationContext>();
	private TextBlockFactory myFactory;
	private static final boolean reUseTextblocks = true;

	public TextBlockComparer(TextBlock root, TextBlockFactory factory) {
		if (root == null || factory == null) {
			throw new IllegalArgumentException(root + ", " + factory);
		}
		myFactory = factory;
		TextBlockTraversationContext rootContext = new TextBlockTraversationContext(
				root, false);
		stack.push(rootContext);
	}

	/**
	 * returns existing or newly created textblock
	 * 
	 * @return
	 */
	public TextBlock enterNextChild() {
		TextBlockTraversationContext currentContext = stack.peek();
		TextBlock currentBlock = currentContext.getContextBlock();
		int lastIndex = currentContext.getLastVisitedChildIndex();
		currentContext.setLastVisitedChildIndex(lastIndex + 1);

		// TODO This is actually to optimistic, instead it should be checked if
		// the tokens within
		// the current current rule can reach the next block , if so it can be
		// re-used
		// otherwise a new textblock needs to be created
		TextBlockTraversationContext newContext = getNextBlockAtIndex(
				currentBlock, lastIndex + 1);
		stack.push(newContext);

		return newContext.getContextBlock();
	}

	/**
	 * Returns the index of the last visited child.
	 * 
	 * @return
	 */
	public int getLastVisitedChildIndex() {
		TextBlockTraversationContext currentContext = stack.peek();
		return currentContext.getLastVisitedChildIndex();
	}

	/**
	 * get child at position or create new TextBlock
	 * 
	 * @param currentBlock
	 * @param i
	 * @return
	 */
	private TextBlockTraversationContext getNextBlockAtIndex(
			TextBlock currentBlock, int i) {
		TextBlock result;

		// TODO this is a workaround until incremental
		if (!reUseTextblocks) {
			result = myFactory.createBlock();
			return new TextBlockTraversationContext(result, true);
		}

		List<TextBlock> subBlocks = currentBlock.getSubBlocks();
		boolean created = false;
		if (subBlocks != null && subBlocks.size() > i && i >= 0
		// TODO this is a heuristic?!?!, only if the subblock was changed it is
		// resonable to return it
		// && subBlocks.get(i).isChildrenChanged()
		//	
		) {
			result = subBlocks.get(i);
		} else {
			result = myFactory.createBlock();
			created = true;
		}
		return new TextBlockTraversationContext(result, created);
	}

	public void leaveChild() {
		stack.pop();
		if (stack.isEmpty()) {
			throw new IllegalStateException("Cannot leave root context");
		}
	}

	public TextBlock getCurrent() {
		return stack.peek().getContextBlock();
	}

	public void addTokenToBeRelocated(AbstractToken token) {
		stack.peek().addTokenToBeRelocated(token);
	}

	public List<AbstractToken> getTokensToBeRelocated() {
		return stack.peek().getTokensToBeRelocated();
	}

	/**
	 * @param offChannelTokens
	 */
	public void addTokensToBeRelocated(
			Collection<? extends AbstractToken> tokens) {
		stack.peek().addTokensToBeRelocated(tokens);
	}



	/**
	 * @return
	 */
	public boolean isNewlyCreatedBlock() {
		return stack.peek().isNewBlock();
	}

	/**
	 * this can be used to reset the counter one child back in order to re-enter
	 * the last child upon the next call to {@link #enterNextChild()}.
	 */
	public void resetOneChildBack() {
		// //only reset if we are at least at the first child
		// if(stack.peek().getLastVisitedChildIndex() > -1) {
		stack.peek().setLastVisitedChildIndex(
				stack.peek().getLastVisitedChildIndex() - 1);
		// }
	}

}
