/**
 * 
 */
package com.sap.mi.textual.parsing.textblocks;

import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getParentBlock;
import static com.sap.mi.textual.parsing.textblocks.TbNavigationUtil.getSubNodesSize;
import static com.sap.mi.textual.parsing.textblocks.TbUtil.getNewestVersion;
import static com.sap.mi.textual.parsing.textblocks.TbUtil.getRelativeOffsetFromNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.mi.textual.textblocks.model.ShortPrettyPrinter;

import textblocks.AbstractToken;
import textblocks.DocumentNode;
import textblocks.Eostoken;
import textblocks.TextBlock;
import textblocks.Version;
import textblocks.VersionEnum;

/**
 * 
 */
public class TbChangeUtil {

	/**
	 * Clean up the textblocks model, i.e., delete all other versions except the
	 * current one and store remaining elements as reference version; 
	 * 
	 * 
	 * @return Returns the (new) reference version of the rootBlock
	 */
	public static DocumentNode cleanUp(DocumentNode rootBlock) {
		DocumentNode currentVersion =  getNewestVersion(rootBlock);
		for (DocumentNode oldVersion : new ArrayList<DocumentNode>(
				currentVersion.getOtherVersions())) {
			oldVersion.refDelete();
		}
		if(currentVersion instanceof TextBlock) {
			for (DocumentNode subNode : TbNavigationUtil.getSubNodes((TextBlock) currentVersion)) {
				cleanUp(subNode);
			}
		}
		makeReferenceVersion(currentVersion);
		return currentVersion;
	}
	
	/**
	 * Revert the textblocks model by delete all newer versions. 
	 * 
	 * 
	 * @return Returns the (old) newest version of the rootBlock
	 */
	public static DocumentNode revertToVersion(DocumentNode rootBlock, Version revertToVersion) {
		DocumentNode currentVersion =  TbVersionUtil.getOtherVersion(rootBlock, revertToVersion);
		
		for (DocumentNode otherVersion : new ArrayList<DocumentNode>(
				currentVersion.getOtherVersions())) {
			if(isNewer(otherVersion.getVersion(), revertToVersion)) {
				otherVersion.refDelete();
			}
		}
		if(currentVersion instanceof TextBlock) {
			for (DocumentNode subNode : TbNavigationUtil.getSubNodes((TextBlock) currentVersion)) {
				revertToVersion(subNode, revertToVersion);
			}
		}
		return currentVersion;
	}


	/**
	 * checks whether the first given version is newer than the second one.
	 * @param first
	 * @param second
	 * @return <code>true</code> if the first version is newer, <code>false</code> else.
	 */
	public static boolean isNewer(Version first, Version second) {
		if(first.equals(second)) {
			return false;
		}
		if(VersionEnum.CURRENT.equals(first)) {
			return true;
		} else if(VersionEnum.PREVIOUS.equals(first)) {
			return VersionEnum.REFERENCE.equals(second);
		} else if(VersionEnum.REFERENCE.equals(first)) {
			return false;
		}
		//this should never happen!!
		return false;
	}

	/**
	 * Iterates over all elements within the textblocks tree and sets its
	 * version to REFERENCE and resets relexing needed to false.
	 * 
	 * @param currentVersion
	 */
	public static void makeReferenceVersion(DocumentNode currentVersion) {
		currentVersion.setVersion(VersionEnum.REFERENCE);
		currentVersion.setRelexingNeeded(false);
		if(currentVersion instanceof TextBlock) {
			for (DocumentNode subNode : TbNavigationUtil.getSubNodes((TextBlock) currentVersion)) {
				makeReferenceVersion(subNode);
			}
		}
	}

	/**
	 * Sets the version of the TextBlock and all contained elements to the given
	 * version.
	 * 
	 * @param rootBlock
	 *            TextBlock to start setting the version
	 * @param version
	 *            Version to use
	 */
	public static void makeVersion(TextBlock rootBlock, Version version) {
		rootBlock.setVersion(version);
		for (AbstractToken token : rootBlock.getTokens()) {
			token.setVersion(version);
		}
		for (TextBlock subBlock : rootBlock.getSubBlocks()) {
			makeVersion(subBlock, version);
		}
	}

	/**
	 * Updates the offsets of all nodes to the right of the passed document
	 * node. Updates are executed upwards, but the tree is never descended.
	 * 
	 * Important: Does no error checking, as it would be computationally
	 * expensive. Normally do not substract more than the tokens length.
	 * 
	 * @param workingCopy
	 * @param lengthToAdd
	 *            Length to add. Can be negative.
	 */
	public static void updateOffsets(DocumentNode workingCopy, int lengthToAdd)
			throws IllegalArgumentException {
	    	updateOffsetsWithinTextBlock(workingCopy, lengthToAdd);
		workingCopy = getParentBlock(workingCopy);
		TextBlock parentBlock = getParentBlock(workingCopy);
		while (parentBlock != null) {
			updateOffsetsWithinTextBlock(workingCopy, lengthToAdd);
			workingCopy = getParentBlock(workingCopy);
			parentBlock = getParentBlock(workingCopy);
		}
	}
	
	/**
	 * Updates the offsets of all nodes to the right of the passed document
	 * node within the given textblock.
	 * 
	 * @param workingCopy
	 * @param lengthToAdd
	 *            Length to add. Can be negative.
	 */
	public static void updateOffsetsWithinTextBlock(DocumentNode workingCopy, int lengthToAdd)
			throws IllegalArgumentException {
		TextBlock parentBlock = getParentBlock(workingCopy);
		// first update adjacent tokens
		List<AbstractToken> siblingTokens = parentBlock.getTokens();
		for (Iterator<AbstractToken> iterator = siblingTokens.iterator(); iterator
				.hasNext();) {
			AbstractToken token = iterator.next();
			if (isRightOf(token, workingCopy) && !token.equals(workingCopy)
					|| token instanceof Eostoken /*
													 * always update
													 * EOSToken if it is
													 * contained within the
													 * affected textblock
													 */) {
				token.setOffset(token.getOffset() + lengthToAdd);
			}
		}

		// update adjacent textblocks within the parent textblock
		List<TextBlock> siblingBlocks = parentBlock.getSubBlocks();
		for (Iterator<TextBlock> iterator = siblingBlocks.iterator(); iterator
				.hasNext();) {
			TextBlock tb = iterator.next();
			if (isRightOf(tb, workingCopy) && !tb.equals(workingCopy)) {
				int newOffset = tb.getOffset() + lengthToAdd;
				if (newOffset < 0) {
				    throw new IllegalStateException("BUG: Attempt to set offset to negative int.");
				}
                tb.setOffset(newOffset);
			}
		}
	}

	private static boolean isRightOf(DocumentNode d1,
			DocumentNode d2) {
		if(d1.isOffsetRelative() && d2.isOffsetRelative()) {
			return d1.getOffset() >= d2.getOffset();
		} else {
			return TbUtil.getAbsoluteOffset(d1) >= TbUtil.getAbsoluteOffset(d2);
		}
	}

	/**
	 * Updates the node including its direct and transitive parents by adding
	 * <code>lengthToAdd</code> to its {@link DocumentNode#getLength()}
	 * recursively. Starts at the given node.
	 * 
	 * @param node
	 *            Node to update
	 * @param lengthToAdd
	 *            Length to add. Can be negative.
	 * @exception IllegalArgumentException
	 *                cannot substract more than the current length
	 */
	public static void updateLengthAscending(DocumentNode node, int lengthToAdd)
			throws IllegalArgumentException {
		int newLength = node.getLength() + lengthToAdd;
//		if (newLength < 0) {
//			throw new IllegalArgumentException(
//					"cannot substract more than the current length "
//							+ node.getLength() + "<" + (-lengthToAdd));
//		}
		node.setLength(newLength);
		TextBlock parent = TbNavigationUtil.getParentBlock(node);
		if (parent != null)
			updateLengthAscending(parent, lengthToAdd);
	}
	
	/**
	 * Removes the given token from the textblock and ensures that the lengths of its transitive parents
	 * are also adjusted.
	 * @param currentTextBlock
	 * @param oldTokenInCurrentBlock
	 */
	public static void removeFromBlockConsistent(TextBlock currentTextBlock,
			AbstractToken oldTokenInCurrentBlock) {
		currentTextBlock.getTokens().remove(oldTokenInCurrentBlock);
		//reduce by length of PREVIOUS version as parernt block still compute with this length
		AbstractToken previousVersion = TbVersionUtil
				.getOtherVersion(oldTokenInCurrentBlock, VersionEnum.PREVIOUS);
		TbChangeUtil.updateLengthAscending(currentTextBlock, -previousVersion
				.getLength());
	}

	/**
	 * replaces in the tokens value the specified region by the new text.
	 * Updates all other offsets and length in the tree consistently. Marks all
	 * parents with the childrenChanged flag.
	 * 
	 * @param firstToken
	 * @param newText
	 * @param offsetInNode
	 * @param replacedRegionLength
	 * @exception IllegalArgumentException
	 *                replace region invalid
	 */
	public static void replaceTokenContents(AbstractToken firstToken,
			String newText, int offsetInNode, final int replacedRegionLength, ShortPrettyPrinter shortPrettyPrinter)
			throws IllegalArgumentException {
		if (replacedRegionLength < 0) {
			throw new IllegalArgumentException("replace region length invalid : " + replacedRegionLength);
		}
		if (offsetInNode < 0) {
//            throw new IllegalArgumentException("replace region invalid");
		    // this means the node has to be moved to its left, because there is a 
		    // gap between the new content and the start of the node
		    // we have to analyse the gap to see whether there even is one and whether it is big enough
		    AbstractToken previous = TbNavigationUtil.previousToken(firstToken);
		    int absoluteOffset = TbUtil.getAbsoluteOffset(firstToken);
		    if (previous != null) {
		        if (absoluteOffset + offsetInNode < TbUtil.getAbsoluteOffset(previous)+ previous.getLength()) {
		            throw new IllegalArgumentException("BUG: Attempt to move token to overlap with previous token.");
		        }
		        // now recursively shift nodes left if possible
		        throw new RuntimeException("BUG: TODO Gaps in TextBlocksmodel replace not implemented yet.");
		    } else { // previous is null, we hold the first node of the whole tree
		        if (absoluteOffset + offsetInNode < 0) { // should never happen
		            throw new RuntimeException("BUG: Attempt to move token before position 0 of text.");
		        }
		        // now recursively shift nodes left if possible
		        throw new RuntimeException("BUG: TODO Gaps in TextBlocksmodel replace not implemented yet.");
		    }
        }

		// update token value
		String originalText = firstToken.getValue();
		if(originalText == null) {
		    originalText = shortPrettyPrinter.resynchronizeToEditableState(firstToken);
		}
		if (originalText == null) {
			if (offsetInNode != 0 || replacedRegionLength != 0) {
				throw new IllegalArgumentException("replace region invalid:" + offsetInNode + "," + replacedRegionLength);
			}
			firstToken.setValue(newText);
		} else {
			if (offsetInNode + replacedRegionLength > originalText.length()) {
				throw new IllegalArgumentException("replace region invalid " +(offsetInNode +"+" + replacedRegionLength) + ">" + originalText.length());
			}
			firstToken.setValue(originalText.substring(0, offsetInNode)
					+ newText
					+ originalText.substring(offsetInNode
							+ replacedRegionLength, originalText.length()));
		}
		 // a deletion is the replacement where length > text.length
        int lengthToUpdate = newText.length() - replacedRegionLength;
        int newLength = firstToken.getLength() + lengthToUpdate;
        if (newLength < 0) {
            throw new IllegalArgumentException(
                    "cannot substract more than the current length "
                            + firstToken.getLength() + "<" + (-lengthToUpdate));
        }
        firstToken.setLength(newLength);
	}
	
	public static void replaceTokenContentsAndUpdateParents(AbstractToken firstToken,
            String newText, int offsetInNode, int replacedRegionLength, ShortPrettyPrinter shortPrettyPrinter)
            throws IllegalArgumentException {

	    replaceTokenContents(firstToken, newText, offsetInNode, replacedRegionLength, shortPrettyPrinter);
	    // a deletion is the replacement where length > text.length
        int lengthToUpdate = newText.length() - replacedRegionLength;
		// update length and offsets
		updateLengthAscending(firstToken.getParentBlock(), lengthToUpdate);
		updateOffsets(firstToken, lengthToUpdate);

		// mark as changed
		TbMarkingUtil.mark(firstToken);
		TbChangeUtil.markAscending(firstToken
				.getParentBlock());

	}

	/**
	 * Removes the node from the parent TextBlock, and any other jmi reference.
	 * 
	 * Recursively removes now empty parent TextBlocks in the same manner.
	 * 
	 * @param token
	 *            token to be removed
	 */
	public static void removeNode(DocumentNode node) {
		if (node != null) {
			TextBlock parent = getParentBlock(node);
			node.refDelete();
			removeTextBlockIfEmpty(parent);
		}
	}

	/**
	 * If the TextBlock has no children (tokens or subblocks), removes it from
	 * the locationMap, from the parent TextBlock, and any other jmi reference.
	 * 
	 * Recursively removes now empty parent TextBlocks in the same manner.
	 * 
	 * @param textblock
	 *            the TextBlock to be removed
	 */
	public static void removeTextBlockIfEmpty(TextBlock textblock) {
		if (textblock != null) {
			if (getSubNodesSize(textblock) == 0) {
				TextBlock parent = textblock.getParentBlock();
				textblock.refDelete();
				removeTextBlockIfEmpty(parent);
			}
		}
	}

	public static void replaceLeftIntersectionWithText(
			AbstractToken workingCopy, int replacedRegionOffsetTo,
			String newText, ShortPrettyPrinter shortPrettyPrinter) {
		int offsetInTokenTo = getRelativeOffsetFromNode(
				replacedRegionOffsetTo, workingCopy);

		// replace intersecting region with an empty string // since we replace from start, offsetInTokenTo == length
		replaceTokenContents(workingCopy, newText, 0, /*length*/ offsetInTokenTo, shortPrettyPrinter);
	}

	/**
	 * Marks all transitive parents of the starting {@link TextBlock} <code>start</code> as
	 * modified by setting {@link DocumentNode#setChildrenChanged(boolean)} to <code>true</code>;
	 * @param start The {@link TextBlock} to begin the marking with.
	 */
	public static void markAscending(TextBlock start) {
		start.setChildrenChanged(true);
		TextBlock parent;
		if((parent = start.getParentBlock()) != null) {
			markAscending(parent);
		}
	}

	/**
	 * Updates the length of the given textblock by computing it from its subnodes.
	 * If the length really changed it is also propagated to its parent blocks.
	 * 
	 * @param tb
	 */
	public static void updateBlockLength(TextBlock tb) {
		int oldLength = tb.getLength();
		List<? extends DocumentNode> nodes = TbNavigationUtil.getSubNodes(tb); 
		DocumentNode firstNode = nodes.get(0);
		DocumentNode lastNode = nodes.get(nodes.size()-1);
		int newLength = 0;
		if(!firstNode.isOffsetRelative() || !lastNode.isOffsetRelative()){
			newLength = TbUtil.getAbsoluteOffset(lastNode) +
				lastNode.getLength() -
				TbUtil.getAbsoluteOffset(firstNode); 
		} else {
			newLength = lastNode.getOffset() + lastNode.getLength() - firstNode.getOffset();
		}
		if(oldLength != newLength) {
			tb.setLength(newLength);
			if(tb.getParentBlock()!= null) {
				updateLengthAscending(tb.getParentBlock(), newLength-oldLength);
			}
		}
	}

	/**
	 * Adds the newModel to the given position within the subNodes of the parentBlock.
	 * @param parentBlock
	 * @param index
	 * @param element
	 */
	public static void addToBlockAt(TextBlock parentBlock, int index,
			DocumentNode element) {
		// TODO change this upon metamodel change .. then there is only one refernce for 
		//tokens and blocks together
		List<TextBlock> subBlocks = parentBlock.getSubBlocks();
		List<AbstractToken> tokens = parentBlock.getTokens();
		if(index <= 0) {
			if(element instanceof TextBlock) {
				subBlocks.add(0, (TextBlock) element);
			} else if(element instanceof AbstractToken){
				tokens.add(0, (AbstractToken) element);
			}
		} else{
			List<? extends DocumentNode> subNodes = TbNavigationUtil.getSubNodes(parentBlock);
			DocumentNode elementBefore = subNodes.get(--index);
			if(element instanceof TextBlock) {
				while(index > 0 && !(elementBefore instanceof TextBlock)) {
					elementBefore = subNodes.get(--index);
				}
				if(((TextBlock) element).getParentBlock() != null) {
				    ((TextBlock) element).setParentBlock(null);
				}
				subBlocks.add(subBlocks.indexOf(elementBefore)+1, (TextBlock) element);
			} else if(element instanceof AbstractToken){
				while(index > 0 && !(elementBefore instanceof AbstractToken)) {
					elementBefore = subNodes.get(--index);
				}
				tokens.add(tokens.indexOf(elementBefore)+1, (AbstractToken) element);
			}
		}
	}

}
