/**
 * 
 */
package com.sap.mi.textual.parsing.textblocks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.TextBlock;

/**
 * util class performing navigation operations in TextBlocks tree, which can be
 * complex because of the nature of the tree. Special care has to be taken to
 * avoid performance issues, since most operations perform badly when invoked on
 * TextBlocks with hundreds of subnodes.
 * 
 * This class assumes that there are no empty blocks (with no sub-blocks and
 * sub-tokens).
 */
public class TbNavigationUtil {

	public static AbstractToken firstToken(DocumentNode node) {
		while (!isToken(node) && node != null) {
			node = getSubNodeAt(((TextBlock) node), 0);
		}
		return (AbstractToken) node;
	}
	
	public static AbstractToken firstTokenWithoutBOS(DocumentNode node) {
        while (!isToken(node) && node != null) {
        	DocumentNode newNode = null;
        	int index = 0;
        	newNode = getSubNodeAt(((TextBlock) node), index++);
        	
        	if (newNode instanceof Bostoken) {
                newNode = getSubNodeAt(((TextBlock) node), index++);
            }
        	
        	while(newNode != null && newNode instanceof TextBlock && getSubNodesSize((TextBlock)newNode) == 0) {
        		newNode = getSubNodeAt(((TextBlock) node), index++);
        		if(newNode == null) {
            		//only one empty block contained in the block
            		newNode = ((TextBlock)node).getParent();
            		if(((TextBlock)newNode).getParent() != null) {
            			index = getSubNodesIndex(newNode) + 1;
            			DocumentNode siblingNode = getSubNodeAt(((TextBlock)newNode).getParent(), index);
            			while(siblingNode == null && ((TextBlock)newNode).getParent() != null) {
            				newNode = ((TextBlock)newNode).getParent();
            				index = getSubNodesIndex(newNode) + 1;
                			siblingNode = getSubNodeAt(((TextBlock)newNode).getParent(), index);
            			}
            			if(siblingNode != null) {
            				newNode = siblingNode;
            			}
            		}
            	}
        	}
        	
            node = newNode;
        }
        return (AbstractToken) node;
    }

	/**
	 * Returns the last token of the subtree.
	 * 
	 * @param node
	 * @param version
	 * @return
	 */
	public static AbstractToken lastToken(DocumentNode node) {
		while (!isToken(node)) {
			// node is textBlock

			int size = getSubNodesSize(((TextBlock) node));
			// List<DocumentNode> subNodes = (List<DocumentNode>)
			// getSubNodes(((TextBlock) node));
			node = getSubNodeAt(((TextBlock) node), size - 1);
		}
		return (AbstractToken) node;
	}

	/**
	 * Fetches the next sibling element within a subtree for element
	 * <code>node</code>
	 * 
	 * @param node
	 * @return
	 */
	public static DocumentNode getNextInSubTree(DocumentNode node) {

		// root node has no siblings
		if (getParentBlock(node) == null) {
			return null;
		}

		TextBlock textBlock = getParentBlock(node);
		List<TextBlock> subBlocks = textBlock.getSubBlocks();
		List<AbstractToken> tokens = textBlock.getTokens();

		Iterator<TextBlock> itBlocks = subBlocks.iterator();
		Iterator<AbstractToken> itToks = tokens.iterator();

		TextBlock nextBlock = null;
		AbstractToken nextToken = null;

		if (itBlocks.hasNext()) {
			nextBlock = itBlocks.next();
		}
		if (itToks.hasNext()) {
			nextToken = itToks.next();
		}

		DocumentNode candidate = null;
		boolean returnNext = false;
		// while there are still more elements
		while (nextBlock != null || nextToken != null) {
			DocumentNode loopNode = null;
			if ((nextToken == null)
					|| (nextBlock != null && nextBlock.getOffset() < nextToken
							.getOffset())) {
				// subnodes.add(nextBlock);
				loopNode = nextBlock;
				if (itBlocks.hasNext()) {
					nextBlock = itBlocks.next();
				} else {
					nextBlock = null;
				}
			} else {
				loopNode = nextToken;
				// subnodes.add(nextToken);
				if (itToks.hasNext()) {
					nextToken = itToks.next();
				} else {
					nextToken = null;
				}
			}
			if (returnNext) {
				candidate = loopNode;
				break;
			}
			if (loopNode.equals(node)) {
				returnNext = true;
			}
		} // while (subnodes.size() < totalSize);

		return candidate;
	}

	/**
	 * Returns a merged list of elements from tokens and subBlocks of a given
	 * textblock sorting them using their offsets (ascending).
	 * 
	 * Sorting assumes that the blocks and the tokens are already sorted
	 * according to their offset (ascending).
	 * 
	 * @param textBlock
	 * @return
	 */
	public static List<? extends DocumentNode> getSubNodes(TextBlock textBlock) {
		List<TextBlock> subBlocks = textBlock.getSubBlocks();
		List<AbstractToken> tokens = textBlock.getTokens();

		if (subBlocks.isEmpty()) {
			return tokens; // TODO TG: needs cloning?
		} else {
			if (tokens.isEmpty()) {
				return subBlocks; // TODO TG: needs cloning?
			}
		}
		// both lists contain values, need to add all into one new list

		int totalSize = subBlocks.size() + tokens.size();
		List<DocumentNode> subnodes = new ArrayList<DocumentNode>(totalSize);

		Iterator<TextBlock> itBlocks = subBlocks.iterator();
		Iterator<AbstractToken> itToks = tokens.iterator();
		TextBlock nextBlock = itBlocks.next();
		AbstractToken nextToken = itToks.next();

		// Bostoken is always the first token
		if (nextToken instanceof Bostoken) {
			// add bos token first
			subnodes.add(nextToken);
			if(itToks.hasNext()) {
			    nextToken = itToks.next();
			} else {
				nextToken = null;
			}
		}

		// while there are still more elements
		while (nextBlock != null || nextToken != null) {
			// do {
			if ((nextToken == null)
					|| (nextBlock != null && isOffsetLessOrEqual(nextBlock, nextToken))) {
				subnodes.add(nextBlock);
				if (itBlocks.hasNext()) {
					nextBlock = itBlocks.next();
				} else {
					nextBlock = null;
				}
			} else {
				subnodes.add(nextToken);
				if (itToks.hasNext()) {
					nextToken = itToks.next();
				} else {
					nextToken = null;
				}
			}
		}

		return subnodes;
	}

	public static int getSubNodesIndex(DocumentNode searchNode) {
		TextBlock parent = getParentBlock(searchNode);

		if (parent == null) {
			// this is the root node
			return 0;
		}

		List<TextBlock> subBlocks = parent.getSubBlocks();
		List<AbstractToken> tokens = parent.getTokens();

		if (subBlocks == null || subBlocks.size() == 0) {
			return tokens.indexOf(searchNode);
		}
		if (tokens == null || tokens.size() == 0) {
			return subBlocks.indexOf(searchNode);
		}

		Iterator<TextBlock> itBlocks = subBlocks.iterator();
		Iterator<AbstractToken> itToks = tokens.iterator();

		TextBlock nextBlock = null;
		AbstractToken nextToken = null;

		if (itBlocks.hasNext()) {
			nextBlock = itBlocks.next();
		}
		if (itToks.hasNext()) {
			nextToken = itToks.next();
		}

		int candidateIndex = -1;

		// Bostoken is always the first token
		if (nextToken instanceof Bostoken) {
			if (searchNode.equals(nextToken)) {
				return 0;
			}

			// advance index and skip bos token
			candidateIndex = 0;
			nextToken = itToks.next();
		}

		// while there are still more elements

		DocumentNode candidate = null;
		// the second part of while loop should never happen, but in case of a
		// bug somewhere else we do not want to get an infinite loop
		while (!searchNode.equals(candidate)
				&& (nextToken != null || nextBlock != null)) {
			if ((nextToken == null)
					|| (nextBlock != null && isOffsetLessOrEqual(nextBlock, nextToken))) {
				candidate = nextBlock;
				if (itBlocks.hasNext()) {
					nextBlock = itBlocks.next();
				} else {
					nextBlock = null;
				}
			} else {
				candidate = nextToken;
				if (itToks.hasNext()) {
					nextToken = itToks.next();
				} else {
					nextToken = null;
				}
			}
			candidateIndex++;
		}

		return candidateIndex;
	}

	public static DocumentNode getSubNodeAt(TextBlock textBlock, int searchIndex) {

		if (textBlock == null) {
			return null;
		}

		List<TextBlock> subBlocks = textBlock.getSubBlocks();
		List<AbstractToken> tokens = textBlock.getTokens();

		int totalSize = subBlocks.size() + tokens.size();
		if (searchIndex > totalSize - 1 || searchIndex < 0) {
			return null;
		}

		// avoid complex list search if we can have it easy
		if (subBlocks.size() == 0) {
			// only tokens
			return tokens.get(searchIndex);
		}
		if (tokens.size() == 0) {
			// only blocks
			return subBlocks.get(searchIndex);
		}

		Iterator<TextBlock> itBlocks = subBlocks.iterator();
		Iterator<AbstractToken> itToks = tokens.iterator();

		TextBlock nextBlock;
		AbstractToken nextToken = null;
		if(itBlocks.hasNext()) {
			nextBlock = itBlocks.next();
		} else {
			nextBlock = null;
		}
		if (itToks.hasNext()) {
			nextToken = itToks.next();
		}

		int loopIndex = 0;

		// Bostoken is always the first token
		if (nextToken instanceof Bostoken) {
			if (searchIndex == 0) {
				return nextToken;
			}

			// skip bos token
			loopIndex = 1;
			nextToken = itToks.next();
		}

		// while there are still more elements
		DocumentNode candidate = null;
		while (loopIndex <= searchIndex) {
			// we can assume nextBlock != null || nextToken != null because
			// totalsize >= searchIndex
			if ((nextToken == null)
					|| (nextBlock != null && isOffsetLessOrEqual(nextBlock, nextToken))) {
				// subnodes.add(nextBlock);
				candidate = nextBlock;
				if(itBlocks.hasNext()) {
					nextBlock = itBlocks.next();
				} else {
					nextBlock = null;
				}
			} else {
				candidate = nextToken;
				// subnodes.add(nextToken);
				if (itToks.hasNext()) {
					nextToken = itToks.next();
				} else {
					nextToken = null;
				}
			}
			loopIndex++;
		}

		return candidate;
	}


	private static boolean isOffsetLessOrEqual(TextBlock nextBlock,
			AbstractToken nextToken) {
		if(nextBlock.isOffsetRelative() || nextToken.isOffsetRelative()) {
			return TbUtil.getAbsoluteOffset(nextBlock) <= TbUtil.getAbsoluteOffset(nextToken);
		} else {
			return nextBlock.getOffset() <= nextToken
				.getOffset();
		}
	}

	public static int getSubNodesSize(TextBlock textBlock) {
		List<TextBlock> subBlocks = textBlock.getSubBlocks();
		List<AbstractToken> tokens = textBlock.getTokens();
		return subBlocks.size() + tokens.size();
	}

	/**
	 * 
	 * @param node
	 * @return <code>true</code> if node is the last in its parents child
	 *         elements, <code>false</code> else.
	 */
	public static boolean isLastInSubTree(DocumentNode node) {
		if (getParentBlock(node) == null) {
			return true;
		}

		TextBlock textBlock = getParentBlock(node);
		List<TextBlock> subBlocks = textBlock.getSubBlocks();
		List<AbstractToken> tokens = textBlock.getTokens();

		AbstractToken lastToken = null;
		if (!tokens.isEmpty()) {
			lastToken = tokens.get(tokens.size() - 1);
		}

		TextBlock lastTextBlock = null;
		if (!subBlocks.isEmpty()) {
			lastTextBlock = subBlocks.get(subBlocks.size() - 1);
		}

		DocumentNode lastNode = lastToken;
		if (lastNode == null) {
			lastNode = lastTextBlock;
		} else {
			if (lastTextBlock != null) { // need to check who is really last,
				// there can be only one
				if (lastToken instanceof Eostoken) {
					lastNode = lastToken;
				} else if (lastTextBlock.getOffset() > lastToken.getOffset()) {
					lastNode = lastTextBlock;
				}
			}
		}

		return node.equals(lastNode);
	}

	/**
	 * Fetches the next token within the token stream by traversing the node
	 * tree depth first.
	 * 
	 * @param tok
	 * @return
	 */
	public static AbstractToken nextToken(AbstractToken tok) {
		TextBlock parent = tok.getParent();
		if (parent == null) {
			return null;
		}

		if (isLastInSubTree(tok)) {
			while (parent != null && isLastInSubTree(parent)) {
				// its the last element, so traverse to the next subtree and
				// find the first leaf there
				parent = parent.getParent();
			}
			DocumentNode parentNextSibling = getNextInSubTree(parent);
			if (parentNextSibling == null) {
				// we're at root node, no more tokens
				return null;
			}
			return firstToken(parentNextSibling);
		} else {
			DocumentNode nextSibling = getNextInSubTree(tok);
			if (!isToken(nextSibling)) {
				return firstToken(nextSibling);
			}
			return (AbstractToken) nextSibling;
		}
	}

	/**
	 * Fetch the previous token from the token stream by traversing the node
	 * tree depths first.
	 * 
	 * @param tok
	 * @return
	 */
	public static AbstractToken previousToken(AbstractToken tok) {
		TextBlock parent = tok.getParent();
		if (isFirstInSubTree(tok)) {
			while (parent.getParent() != null && isFirstInSubTree(parent)) {
				// its the first element, so traverse to the previous subtree
				// and
				// find the last leaf there
				parent = parent.getParent();
			}
			// now parent is either root or some TextBlock which is not first in
			// subtree
			DocumentNode parentPreviousSibling = getPreviousInSubTree(parent);
			if (parentPreviousSibling == null) {
				// we're at root node, no more tokens
				return null;
			}
			return lastToken(parentPreviousSibling);
		} else {
			DocumentNode previousSibling = getPreviousInSubTree(tok);
			if (!isToken(previousSibling)) {
				return lastToken(previousSibling);
			}
			return (AbstractToken) previousSibling;
		}
	}

	/**
	 * 
	 * @param node
	 * @return <code>true</code> if node is the first in its parents child
	 *         elements, <code>false</code> else.
	 */
	public static boolean isFirstInSubTree(DocumentNode node) {
		if ( /* root is always first in subtree */getParentBlock(node) == null) {
			return true;
		} else {
			TextBlock parent = getParentBlock(node);
			DocumentNode first = getSubNodeAt(parent, 0);
			// getSubNodesIndex(node) == 0;
			return node.equals(first);
		}
	}

	/**
	 * Resolves to either {@link TextBlock#getParentBlock()}} or
	 * {@link AbstractToken#getParentBlock()} depending on the type of
	 * <tt>node</tt>.
	 * 
	 * @param node
	 * @return
	 */
	public static TextBlock getParentBlock(DocumentNode node) {
		if (node instanceof TextBlock) {
			return ((TextBlock) node).getParent();
		} else if (node instanceof AbstractToken) {
			return ((AbstractToken) node).getParent();
		} else {
			return null;
		}
	}

	/**
	 * Fetches the previous sibling element within a subtree for element
	 * <code>node</code>
	 * 
	 * @param node
	 * @return
	 */
	public static DocumentNode getPreviousInSubTree(DocumentNode node) {
		TextBlock parent = getParent(node);
		if (parent == null) {
			return null;
		}
		int nodeIndex = getSubNodesIndex(node);
		return getSubNodeAt(parent, nodeIndex - 1);
	}

	private static TextBlock getParent(DocumentNode node) {
		if (node instanceof TextBlock) {
			TextBlock tb = (TextBlock) node;
			return tb.getParent();
		} else {
			AbstractToken tok = (AbstractToken) node;
			return tok.getParent();
		}
	}

	public static boolean isToken(DocumentNode node) {
		return node instanceof AbstractToken;
	}

	/**
	 * Replaces the subtree represented by <code>previousParentBlock</code>
	 * with the subtree represented by <code>currentTextBlock</code>
	 * 
	 * Cannot replace the root node.
	 * 
	 * @param previousParentBlock
	 *            subtree to be replaced
	 * @param currentTextBlock
	 *            subtree that will be used in the new version
	 * 
	 * @exception IllegalArgumentException
	 *                cannot replace a root textblock
	 */
	public static void replaceSubTree(TextBlock previous, TextBlock current)
			throws IllegalArgumentException {
		TextBlock parent = previous.getParent();

		if (parent != null) {
			int oldIndex = parent.getSubBlocks().indexOf(previous);
			parent.getSubBlocks().remove(previous);
			parent.getSubBlocks().add(oldIndex, current);
		} else {
			throw new IllegalArgumentException(
					"cannot replace a root textblock");
		}
	}

	public static int getLevel(DocumentNode node) {
		// root Block is level 0
		int level = 0;
		TextBlock parent = getParentBlock(node);
		while (parent != null) {
			level++;
			parent = parent.getParent();
		}

		return level;
	}

	/**
	 * Retrieves the right adjecent textblock of the given textblock. If no
	 * further block exists <code>null</code> is returned;
	 * 
	 * @param currentTextBlock
	 * @return
	 */
	public static TextBlock nextBlockInSubTree(TextBlock currentTextBlock) {
		TextBlock parent = currentTextBlock.getParent();
		if (parent == null) {
			return null;
		}
		List<TextBlock> subBlocks = parent.getSubBlocks();
		int indexOf = subBlocks.indexOf(currentTextBlock);
		if (indexOf == subBlocks.size() - 1) {
			// it is the last block
			return null;
		}
		return subBlocks.get(indexOf + 1);

	}
	
	/**
	 * Retrieves the left adjecent textblock of the given textblock. If no
	 * further block exists <code>null</code> is returned;
	 * 
	 * @param currentTextBlock
	 * @return
	 */
	public static TextBlock previousBlockInSubTree(TextBlock currentTextBlock) {
		TextBlock parent = currentTextBlock.getParent();
		if (parent == null) {
			return null;
		}
		List<TextBlock> subBlocks = parent.getSubBlocks();
		int indexOf = subBlocks.indexOf(currentTextBlock);
		if (indexOf == 0) {
			// it is the last block
			return null;
		}
		return subBlocks.get(indexOf - 1);

	}

	/**
	 * Navigates to the ultra root of the given node. TODO: Once added to the MM
	 * UltraRoot has to be checked here
	 * 
	 * @param node
	 * @return
	 */
	public static TextBlock getUltraRoot(DocumentNode node) {
		if (node instanceof AbstractToken) {
			return getUltraRoot(((AbstractToken) node).getParent());
		} else if (node instanceof TextBlock) {
			if (isUltraRoot((TextBlock)node)) {
				return (TextBlock) node;
			}else {
				return getUltraRoot(((TextBlock) node).getParent());
			}
		} else {
			throw new RuntimeException(
					node
							+ "can not be asked for UltraRoot, only TextBlocks and AbstractTokens can have that.");
		}
	}

	/**
	 * Checks if the given {@link TextBlock} is the root of a textblock tree.
	 * @param node
	 * @return
	 */
	public static boolean isUltraRoot(TextBlock node) {
		// TODO If parent instance of UltraRoot if there will be an extra class for this kind of element
		return node.getParent() == null;
	}

//    /**
//     * returns the TextBlock which spans the given offset without containing a subBlock also covering that offset.
//     * @param offsetFrom
//     */
//    public static void getLeafBlockAt(int offset) {
//        // TODO Auto-generated method stub
//        //TODO
//    }

}
