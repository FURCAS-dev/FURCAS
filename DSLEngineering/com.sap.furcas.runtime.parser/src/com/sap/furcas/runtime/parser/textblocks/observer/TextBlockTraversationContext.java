package com.sap.furcas.runtime.parser.textblocks.observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

public class TextBlockTraversationContext {

	private final TextBlock contextBlock;

	private int lastVisitedChildIndex = -1;

	private final List<AbstractToken> relocationTokens = new ArrayList<AbstractToken>();

	private final boolean isNewBlock;

	/**
	 * @param contextBlock
	 */
	public TextBlockTraversationContext(TextBlock contextBlock,
			boolean isNewBlock) {
		super();
		if (contextBlock == null) {
			throw new IllegalArgumentException("Block is null");
		}
		this.contextBlock = contextBlock;
		this.isNewBlock = isNewBlock;
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
	public TextBlock getContextBlock() {
		return contextBlock;
	}

	public void addTokenToBeRelocated(AbstractToken token) {
		if (token == null) {
			throw new IllegalArgumentException("token is null");
		}
		this.relocationTokens.add(token);
	}

	public List<AbstractToken> getTokensToBeRelocated() {
		return relocationTokens;
	}

	/**
	 * @param tokens
	 */
	public void addTokensToBeRelocated(
			Collection<? extends AbstractToken> tokens) {
		relocationTokens.addAll(tokens);
	}

	/**
	 * @return
	 */
	public boolean isNewBlock() {
		return isNewBlock;
	}

}
