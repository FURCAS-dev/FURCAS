package com.sap.ide.cts.parser.incremental;

import static com.sap.mi.textual.parsing.textblocks.TbMarkingUtil.isEOS;
import static com.sap.mi.textual.parsing.textblocks.TbMarkingUtil.marked;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getNextInSubTree;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getParentBlock;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getSubNodeAt;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getSubNodes;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.isLastInSubTree;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.isToken;
import static com.sap.mi.textual.parsing.textblocks.TbVersionUtil.getOtherVersion;

import java.util.List;

import com.sap.tc.moin.repository.Connection;

import textblocks.AbstractToken;
import textblocks.Bostoken;
import textblocks.DocumentNode;
import textblocks.Eostoken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;
import textblocks.Version;
import textblocks.VersionEnum;

public abstract class IncrementalRecognizer {

	public static final String EOS = "EOS";
	public static final String BOS = "BOS";
	protected Bostoken bosRef;
	protected Eostoken eosRef;
	protected TextblocksPackage textblocksPackage;
	protected  Connection connection;
	
	public IncrementalRecognizer(Connection connection) {
		this.connection = connection;
		textblocksPackage = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	}

	
	/**
	 * Find the next marked token within or after node.
	 */
	protected AbstractToken findNextRegion(DocumentNode node) {
		if (isEOS(node) || (isToken(node) && marked((AbstractToken) node)))
			return (AbstractToken) node;
		if (node instanceof TextBlock
				&& hasNestedChanges((TextBlock) node, VersionEnum.PREVIOUS))
			return findNextRegion(getSubNodeAt(((TextBlock) node), 0));
		if (node instanceof TextBlock
				&& ((TextBlock) node).getParentBlock() == null) {
			// node is the parent block and there were no changes detected so
			// return EOS which
			// is always the last token within the Root Textblock
			return eosRef;
		}

		return findNextRegion(nextSubtree(node));
	}
	
	
	
	protected DocumentNode nextSubtree(DocumentNode node) {
		TextBlock parent = getParentBlock(node);
		if (parent == null) {
			// node is the root node so there is no further subtree
			return eosRef;
		}
		if (isLastInSubTree(node)) {
			while (getParentBlock(parent) != null && isLastInSubTree(parent)) {
				// its the last element, so traverse to the next subtree and
				// find the first leaf there
				parent = parent.getParentBlock();
			}
			DocumentNode child = getNextInSubTree(parent);
			return child;
		} else {
			List<? extends DocumentNode> parentSubNodes = getSubNodes(parent);
			return parentSubNodes.get(parentSubNodes.indexOf(node) + 1);
		}
	}
	
	/**
	 * This method should be overridden if a parser uses another token type for
	 * eof/oes than -1
	 * 
	 * @return the token type representing end of stream
	 */
	protected int getEOSTokenType() {
		return -1;
	}


	/**
	 * This method should be overridden if a parser uses another token type for
	 * bof/bes than -1
	 * 
	 * @return the token type representing beginning of stream
	 */
	protected int getBOSTokenType() {
		return -2;
	}


	protected static boolean hasNestedChanges(TextBlock node, Version reference) {
		TextBlock otherVersion = getOtherVersion(node, reference);
		if(otherVersion == null) {
			//this means it is a new block which also means that the block is changed
			return true;
		} else {
			return otherVersion.isChildrenChanged();
		}
	}
	
	protected static boolean wasReLexed(AbstractToken token) {
		// TODO check if this is correct here
		return token.isRelexingNeeded();
	}
}
