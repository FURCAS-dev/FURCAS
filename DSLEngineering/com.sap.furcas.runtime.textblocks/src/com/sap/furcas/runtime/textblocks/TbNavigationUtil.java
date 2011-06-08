/**
 * 
 */
package com.sap.furcas.runtime.textblocks;

import java.util.List;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

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
		if (node == null || node.getParent() == null) {
			return null;
		}
		int index = node.getParent().getSubNodes().indexOf(node);
		return getSubNodeAt(node.getParent(), index + 1);
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
	    return textBlock.getSubNodes();
	}

	public static int getSubNodesIndex(DocumentNode searchNode) {
		TextBlock parent = searchNode.getParent();

		if (parent == null) {
			// this is the root node
			return 0;
		}
		return parent.getSubNodes().indexOf(searchNode);
	}

	public static DocumentNode getSubNodeAt(TextBlock textBlock, int searchIndex) {
		if (textBlock == null) {
			return null;
		}
		if (searchIndex > textBlock.getSubNodes().size() - 1 || searchIndex < 0) {
			return null;
		}
		return textBlock.getSubNodes().get(searchIndex);
	}

	public static int getSubNodesSize(TextBlock textBlock) {
		return textBlock.getSubNodes().size();
	}

	/**
	 * 
	 * @param node
	 * @return <code>true</code> if node is the last in its parents child
	 *         elements, <code>false</code> else.
	 */
	public static boolean isLastInSubTree(DocumentNode node) {
		if (node.getParent() == null) {
			return true;
		}
		TextBlock textBlock = node.getParent();
		DocumentNode lastInTree = textBlock.getSubNodes().get(textBlock.getSubNodes().size()-1);
		return node.equals(lastInTree);
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
     * @return <code>true</code> if node is the first in its parents child elements, <code>false</code> else.
     */
    public static boolean isFirstInSubTree(DocumentNode node) {
        if ( /* root is always first in subtree */node.getParent() == null) {
            return true;
        } else {
            TextBlock parent = node.getParent();
            DocumentNode first = getSubNodeAt(parent, 0);
            // getSubNodesIndex(node) == 0;
            return node.equals(first);
        }
    }

    /**
     * Fetches the previous sibling element within a subtree for element <code>node</code>
     * 
     * @param node
     * @return
     */
    public static DocumentNode getPreviousInSubTree(DocumentNode node) {
        TextBlock parent = node.getParent();
        if (parent == null) {
            return null;
        }
        int nodeIndex = getSubNodesIndex(node);
        return getSubNodeAt(parent, nodeIndex - 1);
    }

    public static boolean isToken(DocumentNode node) {
        return node instanceof AbstractToken;
    }

    /**
     * Replaces the subtree represented by <code>previousParentBlock</code> with the subtree represented by
     * <code>currentTextBlock</code>
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
    public static void replaceSubTree(TextBlock previous, TextBlock current) throws IllegalArgumentException {
        TextBlock parent = previous.getParent();

        if (parent != null) {
            int oldIndex = parent.getSubNodes().indexOf(previous);
            parent.getSubNodes().remove(previous);
            parent.getSubNodes().add(oldIndex, current);
        } else {
            throw new IllegalArgumentException("cannot replace a root textblock");
        }
    }

    public static int getLevel(DocumentNode node) {
        // root Block is level 0
        int level = 0;
        TextBlock parent = node.getParent();
        while (parent != null) {
            level++;
            parent = parent.getParent();
        }

        return level;
    }

    /**
     * Retrieves the right adjecent textblock of the given textblock. If no further block exists <code>null</code> is
     * returned;
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
     * Retrieves the left adjecent textblock of the given textblock. If no further block exists <code>null</code> is
     * returned;
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
     * Navigates to the ultra root of the given node. TODO: Once added to the MM UltraRoot has to be checked here
     * 
     * @param node
     * @return
     */
    public static TextBlock getUltraRoot(DocumentNode node) {
        if (node instanceof AbstractToken) {
            return getUltraRoot(((AbstractToken) node).getParent());
        } else if (node instanceof TextBlock) {
            if (isUltraRoot(node)) {
                return (TextBlock) node;
            } else {
                return getUltraRoot(((TextBlock) node).getParent());
            }
        } else {
            throw new RuntimeException(node
                    + "can not be asked for UltraRoot, only TextBlocks and AbstractTokens can have that.");
        }
    }

    /**
     * Checks if the given {@link TextBlock} is the root of a textblock tree.
     * 
     * @param node
     * @return
     */
    public static boolean isUltraRoot(DocumentNode node) {
        // TODO If parent instance of UltraRoot if there will be an extra class for this kind of element
        return node.getParent() == null;
    }

}
