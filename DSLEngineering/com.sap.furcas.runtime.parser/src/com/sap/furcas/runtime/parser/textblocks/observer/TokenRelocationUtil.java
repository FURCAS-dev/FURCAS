/**
 * 
 */
package com.sap.furcas.runtime.parser.textblocks.observer;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getParentBlock;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodeAt;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodes;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodesSize;
import static com.sap.furcas.runtime.textblocks.TbUtil.getAbsoluteOffset;
import static com.sap.furcas.runtime.textblocks.TbUtil.isAncestorOf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;

/**
 * utils class performing the relatively complex relocation task for the ParsingObserver
 */
public class TokenRelocationUtil {

//	/**
//	 * Comparator for {@link DocumentNode}s using their offsets.
//	 * @author C5106462
//	 *
//	 */
//    private static class DocumentNodeOffsetComparator implements Comparator<DocumentNode> {
//
//		@Override
//		public int compare(DocumentNode node1, DocumentNode node2) {
//			if(node1.isOffsetRelative() != node2.isOffsetRelative()) {
//				if(!(node1 instanceof Eostoken || node1 instanceof Bostoken)
//						&& !(node2 instanceof Eostoken || node2 instanceof Bostoken) ) {
//					//if one of them is EOS  or BOS it doesn't matter as they are are always relative to 0
//					throw new IllegalArgumentException(
//						"Cannot compare DocumentNodes where one has a relative and the other an absolute offset");
//				}
//			}
//			if (node1.getOffset() == node2.getOffset()) {
//				return 0;
//			} else if(node1.getOffset() < node2.getOffset()){
//				return -1;
//			} else {
//				return 1;
//			}
//		}
//
//	}
//
//	private static final DocumentNodeOffsetComparator documentNodeOffsetComparator = new DocumentNodeOffsetComparator();

	/**
     * the actual relocate method, it moves the given tokens to the given textblock, 
     * updates the offset and length attributes of origin and target textblock, makes 
     * any subnodes of the given textblock relative to it (also subblocks).
     * Will throw IllegalArgumentExceptions if the subnodes are relative or otherwise 
     * inconsistent (negative offsets, overlaps, gaps).
     * @param currentTextBlock
     * @param relocationTokens
     * @param isNewBlock if true, grants that node only has absolute subnodes (else Exception will be thrown)
     * @return
     */
    //all other methods should not be visible outside this class, but are made visible for testing.
    public static void relocateTokensAndSetLocationAndMakeSubsRelative(TextBlock currentTextBlock,
            List<AbstractToken> relocationTokens,  boolean isNewBlock) {
        if (currentTextBlock == null) {
            throw new IllegalArgumentException("null passed as block");
        }
        boolean tokensMoved = false;
        if (relocationTokens != null && relocationTokens.size() != 0) {
            // do relocate tokens, this adds tokens with absolute offsets somewhere into the block
            tokensMoved = moveTokens(relocationTokens, currentTextBlock);    
        }
        
        // this may happen even if we do not relocate any tokens, since the block might only have subblocks!
        if (getSubNodesSize(currentTextBlock) != 0) {
            /* needs to set location before we make the 
             *  subnodes relative, as we cannot set location based on subnodes afterwards,
             *  however this only works if we can be sure the subnodes have been changed and are not relative.
             *  We could make the relocate method more flexible to ignore cases when subnodes are relative, but
             *  then we will be blind for other bugs.
             */
            if (isNewBlock ) { 
                /* if tokens were moved, location is already up to date, and if not, calling this
                 * might not work because last node might be relative if no node was added
                 */
                if (! tokensMoved) {
                    updateTextBlockLocationUsingSubNodesAfterAdding(currentTextBlock);
                }
            }
            
            makeSubNodesRelative(currentTextBlock);
            
            // for finding bugs, assert is useful
            TbValidationUtil.assertTextBlockConsistency(currentTextBlock);
        }        
 
    }
    
//    /**
//     * Sorts the tokens of the given <code>textBlock</code> according to their offsets.
//     * @param textBlock
//     */
//    static void updateTokenOrdering(TextBlock textBlock) {
//    	if(textBlock != null) {
//    		sort(textBlock.getTokens(), documentNodeOffsetComparator);
//    	}
//	}
//    
//    /**
//     * Sorts the subBlocks of the given <code>textBlock</code> according to their offsets.
//     * @param textBlock
//     */
//    static void updateSubBlockOrdering(TextBlock textBlock) {
//    	sort(textBlock.getSubNodes(), documentNodeOffsetComparator);
//	}
    
//    /**
//     * Cannot use {@link Collections#sort(List, Comparator)} because this directly replaces 
//     * elements within the target collections which causes a {@link DuplicateException} in
//     * MOIN associations. Therefore  the algorithm is modified in order to first remove the element
//     * and then add the newly sorted one.
//     * 
//     * TODO: Wait for MOIN guys to come up with a better solution, as this implementation
//     * may be slow 
//     * 
//     * @param list
//     * @param c
//     */
//    private static void sort(List list, DocumentNodeOffsetComparator c) {
//    	Object[] a =  list.toArray();
//    	Arrays.sort(a, (Comparator)c);
//    	list.clear();
//    	for (Object object : a) {
//			list.add((DocumentNode)object);
//		}
//       }

//	/**
//     * checks for
//     * @param currentTextBlock
//     */
//    static void assertTextBlockConsistency(TextBlock currentTextBlock) {
//        if (currentTextBlock.getOffset() < 0) {
//            throw new IllegalStateException("TextBlock offset is negative: " +  currentTextBlock.getOffset());
//        }
//        if (currentTextBlock.getLength() < 0) {
//            throw new IllegalStateException("TextBlock length is negative: " +  currentTextBlock.getOffset());
//        }
//        List<? extends DocumentNode> subnodes = getSubNodes(currentTextBlock);
//        int lastEnd = getAbsoluteOffset(currentTextBlock); // implicitly checks for offset < 0
//        int tokenLengthSum = 0;
//        for (Iterator<? extends DocumentNode> iterator = subnodes.iterator(); iterator.hasNext();) {
//            DocumentNode documentNode = (DocumentNode) iterator.next();
//            int nodeOffSet = getAbsoluteOffset(documentNode);
//            tokenLengthSum += documentNode.getLength();
//            if (documentNode.getLength() <= 0 ) {
//                if (! (documentNode instanceof Bostoken) && ! (documentNode instanceof Eostoken) ) {
//                    throw new IllegalStateException("Subnode of length <= 0 in block: " + documentNode);
//                }
//            }
//            if ( nodeOffSet > lastEnd ) {
//                throw new IllegalStateException("TextBlock with gap between subnodes created : " + nodeOffSet +" after " + lastEnd);
//            }
//            if (nodeOffSet < lastEnd ) {
//                if (! (documentNode instanceof Eostoken) ) {
//                    throw new IllegalStateException("TextBlock with overlapping subnodes created :  " + nodeOffSet +" before " + lastEnd);
//                }
//            }
//            lastEnd = nodeOffSet + documentNode.getLength();
//        }
//        if (tokenLengthSum != currentTextBlock.getLength()) {
//            throw new IllegalStateException("TextBlock length " + currentTextBlock.getLength() + " != "+ tokenLengthSum);
//        }
//        
//    }
    
    /**
     * Relocated all elements stored in {@link #relocationCandidates} to the
     * given {@link TextBlock targetBlock} after relocating the tokens, the
     * location information of the affected blocks is updated.
     * 
     * Assumes the List of tokens is sorted by offset and does not have gaps or 
     * overlaps (else target will become inconsistent).
     * target block offset and length attributes will not be changed here 
     * (because it is done in relocateTokensAndSetLocation...()). 
     * 
     * @param tokensToRelocate the tokens to move to the given block 
     * @param targetBlock may be null, then tokens will get detached from their current parent
     * @param isNewBlock 
     */
    public static boolean moveTokens(List<AbstractToken> tokensToRelocate,
            TextBlock targetBlock) {
        boolean tokensMoved = false;
        if (tokensToRelocate.size() > 0) {
//          relocate all tokens from their current to their new parent, then empty tokensToRelocate
            Set<TextBlock> parentsToBeUpdated = new HashSet<TextBlock>();
                        
            for (AbstractToken relocationCandidate : tokensToRelocate) {
                TextBlock parentBlock = relocationCandidate.getParent();
                if (parentBlock == null || ! parentBlock.equals(targetBlock)) {
                    // token should actually be moved
                    tokensMoved = true;
                    if (parentBlock != null) {
                        // if parent is ancestor of target, then parent needs no location update from moving the token 
                        if (! isAncestorOf(parentBlock, targetBlock)) {
                            parentsToBeUpdated.add(parentBlock);
                        }
                    }
                    // make offset absolute to be sure it is correctly updated
                    // when added to its new block
                    if (relocationCandidate.isOffsetRelative()) {
                        // getAbsoluteOffset should be possible if the original tree was consistent
                        relocationCandidate.setOffset(getAbsoluteOffset(relocationCandidate)); 
                        relocationCandidate.setOffsetRelative(false);
                    }
                    
                    // TODO: we can save performance in insert by making some general assumptions, 
                    // such that the candidates are ordered, such as if insertposition = last, then 
                    // from now on merely add
                    //int insertPosition = insertToken(targetBlock, relocationCandidate);
                    insertToken(targetBlock, relocationCandidate);
                }
            }
            
            
            if (tokensMoved && targetBlock != null) {
                updateTextBlockLocationUsingSubNodesAfterAdding(targetBlock);
                
                /*
                 * TODO: this really should rather be 
                 * new TextBlocksModel(root).relocateTokens(tokens, source, target)
                 * or
                 * new TextBlocksModel(root1).removeTokens(tokens, source, target)
                 * new TextBlocksModel(root2).addTokens(tokens, source, target)
                 * where all offsets and length of all nodes in the whole tree are consistent after the operation
                 */
            }

            for (TextBlock textBlock : parentsToBeUpdated) {
                // TODO: in for loop it can happen that parents get traversed before 
                // their children, meaning parents location could be inconsistent, and 
                // sometimes parents should be deleted after all their children have been deleted
                
                
                //TODO check if textblock is allowed to be deleted, since maybe tokens may need to be added to it later?
                if (getSubNodesSize(textBlock) == 0) {
                    EcoreUtil.delete(textBlock); // do not delete parents, as they might get children added to later on during process
                } else {
                    /* basically we removed some subset of tokens from this textblock, 
                     * what is left is another arbitrary subset of absolute or relative tokens or subblocks.
                     */

                    updateTextBlockLocationAfterRemoval(textBlock);
                    updateParentsAscendingAfterRemoval(textBlock);
                    // TODO if old parent really needs to be consistent now (no token gaps?), assert consistency to detect bugs early
                }
            }
            
            if (tokensMoved && targetBlock != null) {
                // -> if length or offset changed, parent and all following siblings need changing of location, unless offsetChange == length change
                updateParentsAscendingAfterAdding(targetBlock);
            }
        }
        return tokensMoved;
    }


	/**
     * inserts token into target block at the correct position, does not update parents location info (and is therefor not generic enough to reuse.
     * Also does not check that no overlap with existing tokens or block happens. all tokens involved are assumed not to overlap, 
     * and existing tokens are assumed to be sorted (smallest offset to highest).
     * @param targetBlock
     * @param relocationCandidate
     * @return the index the token was inserted at
     */
    public static int insertToken(TextBlock targetBlock, AbstractToken relocationCandidate) {
        // get the absoluteOffset before setting parent to null
        int targetAbsoluteLocation = getAbsoluteOffset(relocationCandidate);
        int insertIndex = 0;
        // first set parent to null in any case because else MOIN will try to add second parent
        relocationCandidate.setParent(null);
        
        if (targetBlock != null) {
         
            List<AbstractToken> subTokens = targetBlock.getTokens();
            Iterator<AbstractToken> iterator = subTokens.iterator();
            
            while (iterator.hasNext()) {
                AbstractToken abstractToken = iterator.next();
                int existingOffset = getAbsoluteOffset(abstractToken);
                if (existingOffset > targetAbsoluteLocation) {
                    break;
                }
                insertIndex++;
            }
            subTokens.add(insertIndex, relocationCandidate);
        }
        return insertIndex;
    }

   

    /**
     * Updates the offset and length of the parent textblocks recursively. 
     * As the ordering of the tokens is fixed it can not be the case that
     * the ordering of the subblocks  has to be changed within tthe way to
     * the root block, so no reordering needs to be performed.
     * 
     * @param targetBlock
     */
    static void updateParentsAscendingAfterAdding(TextBlock targetBlock) {
    	TextBlock parent = targetBlock.getParent();
    	if(parent != null) {
    		updateTextBlockLocationUsingSubNodesAfterAdding(parent);
    		updateParentsAscendingAfterAdding(parent);
    	}
	}
    
    /**
     * Updates the offset and length of the parent textblocks recursively. 
     * As the ordering of the tokens is fixed it can not be the case that
     * the ordering of the subblocks  has to be changed within tthe way to
     * the root block, so no reordering needs to be performed.
     * 
     * @param targetBlock
     */
    static void updateParentsAscendingAfterRemoval(TextBlock targetBlock) {
    	TextBlock parent = targetBlock.getParent();
    	if(parent != null) {
    		updateTextBlockLocationAfterRemoval(parent);
    		updateParentsAscendingAfterRemoval(parent);
    	}
	}

	/**
     * changes location information of a textblock after subnodes have been removed.
     * Assumes that the textblock location information was valid before removal, so 
     * we can build on that, also assumes location information of subblocks is consistent
     * @param textBlock
     */
    public static void updateTextBlockLocationAfterRemoval(
            TextBlock textBlock) {
        int subNodesSize = getSubNodesSize(textBlock);
        if (subNodesSize == 0) {
            // this may happen if this method is called without current subnodes, which may not be a bug.
            return;
        }
        DocumentNode firstSubNode = getSubNodeAt(textBlock, 0);
        DocumentNode lastSubNode = getSubNodeAt(textBlock, subNodesSize - 1); // may be equal to firstNode
        if (lastSubNode instanceof Eostoken) { // EOS has offset == 0 always
            if (subNodesSize > 1 ) {
                lastSubNode = getSubNodeAt(textBlock, subNodesSize - 2);
            } else {
                throw new IllegalArgumentException("Subnodes only consisted of EOSToken");
            }
        }
        
        // Now either the original first subnode was removed or not, if not no need to update offset 
        
        /*
         * REGARDLESS of whether TB has absolute or relative offset:
         * either shift the textBlock offset by an amount if the new first subnode is relative (default case)
         * or make the textBlock offset absolute is firstnode is absolute
         */
        if (firstSubNode.isOffsetRelative()) {
            int newFirstNodeoffset = firstSubNode.getOffset();
            if (newFirstNodeoffset == 0) {
                // original first subnode has not been removed, so we do not need to update offset
            } else {
                int originalOffset = textBlock.getOffset();
                textBlock.setOffset(originalOffset+newFirstNodeoffset);
                List<? extends DocumentNode> subnodes = getSubNodes(textBlock);
                for (Iterator<? extends DocumentNode> iterator = subnodes.iterator(); iterator
                .hasNext();) {
                    DocumentNode documentNode = iterator.next();
                    if (documentNode.isOffsetRelative()) {
                        int nodeOriginalOffset = documentNode.getOffset();
                        documentNode.setOffset(nodeOriginalOffset - newFirstNodeoffset);
                    }
                }
            }

        } else { // firstSubnodeOffset is absolute we set the textblock to absolute offsets as well, as its easier
            int originalOffset = getAbsoluteOffset(textBlock);
            textBlock.setOffsetRelative(false);
            int newFirstNodeoffset = firstSubNode.getOffset();
            int difference = newFirstNodeoffset- originalOffset;
            if (difference > 0) {
                textBlock.setOffset(newFirstNodeoffset);
                List<? extends DocumentNode> subnodes = getSubNodes(textBlock);
                for (Iterator<? extends DocumentNode> iterator = subnodes.iterator(); iterator
                .hasNext();) {
                    DocumentNode documentNode = iterator.next();
                    if (documentNode.isOffsetRelative()) {
                        int nodeOriginalOffset = documentNode.getOffset();
                        documentNode.setOffset(nodeOriginalOffset - difference);
                    }
                }
            } else if (difference < 0) { // assumption is violated
                throw new IllegalStateException("new firstnode absolute offset is smaller than textBlock offset " + newFirstNodeoffset + " < " + originalOffset);
            }

        }

        // override length and column properties even if they are still correct

        int firstSubNodeAbsoluteOffset = getAbsoluteOffset(firstSubNode);
        int lastSubNodeAbsoluteOffset = getAbsoluteOffset(lastSubNode);
        int newlength = lastSubNodeAbsoluteOffset + lastSubNode.getLength() - firstSubNodeAbsoluteOffset;
        textBlock.setLength(newlength);


        
        textBlock.setStartRow(firstSubNode.getStartRow());
        textBlock.setStartColumn(firstSubNode.getStartColumn());
        textBlock.setEndRow(lastSubNode.getEndRow());
        textBlock.setEndColumn(lastSubNode.getEndColumn());        
    }

    /**
     * Updates the position information of the textblock by analyzing the
     * contained tokens and computing the range of the textblock accordingly.
     * Assumes that either all subnodes are new and with absolutes offsets, or absolute Nodes 
     * have been added (hence an update is required)
     * This also works with TextBlocks which had inconsistent location information before 
     * (such as newly created ones), since previous information is ignored.
     */
    public static void updateTextBlockLocationUsingSubNodesAfterAdding(TextBlock textBlock) {
        // update location information
        int subNodesSize = getSubNodesSize(textBlock);
        if (subNodesSize == 0) {
            // this may happen if this method is called without current subnodes, which may not be a bug.
            return;
        }
        
        // fetch first and last subnode
        DocumentNode firstSubNode = getSubNodeAt(textBlock, 0);
        DocumentNode lastSubNode = getSubNodeAt(textBlock, subNodesSize - 1); // may be equal to firstNode
        if (lastSubNode instanceof Eostoken) { // EOS offset is 0, cannot use it
            if (subNodesSize > 1 ) {
                lastSubNode = getSubNodeAt(textBlock, subNodesSize - 2);
            } else {
                throw new IllegalArgumentException("Subnodes only consisted of EOSToken");
            }
        }
        // assertions useful for detecting bugs
        if (firstSubNode.getOffset() < 0 || lastSubNode.getOffset() < 0 ) {
            throw new IllegalArgumentException("BUG: Negative relative offset in subnodes: " +firstSubNode.getOffset() + ", " + lastSubNode.getOffset());
        }       
       
        
        
        if (firstSubNode.isOffsetRelative() ) {
            /* this means that even though we added nodes, the original first node of the 
             * block still exists, meaning also that the offset of the textBlock needs no change.
             */
        } else {
        	if (lastSubNode.isOffsetRelative() ) {
                // In this case we assume that nodes were merely inserted before the last node.
            	//this means that all tokens after this inserted token that have a relative offset need to be made
        		//all tokens that were relative to absolute so that their offset can be reconputed lateron
        		List<? extends DocumentNode> subNodes = getSubNodes(textBlock) ;
        		for (DocumentNode node : subNodes) {
					makeOffsetAbsolute(node);
				}
            }  
            // the absolute offset of the textblock is the offset of its first subnode
            textBlock.setOffset(firstSubNode.getOffset());
            textBlock.setOffsetRelative(false);
        }
       
       
        
       // TB length is the difference between the end of its last node
        // and the offset of either its first subnode or itself (depending on whether first subnode had changed)   
        int newlength = getNewLength(textBlock, lastSubNode);
        if(newlength < 0) {
        	throw new IllegalArgumentException("Tried to set negative length "+ newlength +" for TextBlock.");
        }
        textBlock.setLength(newlength);

        
//        textBlock.setStartRow(firstSubNode.getStartRow());
//        textBlock.setStartColumn(firstSubNode.getStartColumn());
//        textBlock.setEndRow(lastSubNode.getEndRow());
//        textBlock.setEndColumn(lastSubNode.getEndColumn());        
    }

	public static void makeOffsetAbsolute(DocumentNode node) {
		if(node.isOffsetRelative() && getParentBlock(node) != null) {
			node.setOffset(getAbsoluteOffset(node));
			node.setOffsetRelative(false);
		}
	}

	private static int getNewLength(TextBlock textBlock,
			DocumentNode lastSubNode) {
		int lastEnd;
		int tbOffset;
		if(lastSubNode.isOffsetRelative() && textBlock.isOffsetRelative()) {
        	lastEnd = lastSubNode.getOffset() + lastSubNode.getLength();
        	tbOffset = 0; // as everything is relative the offset of the block that is subtracted at the end is 0
        } else {
	        if(lastSubNode.isOffsetRelative()) {
	        	lastEnd = getAbsoluteOffset(lastSubNode) + lastSubNode.getLength();
	        } else {
	        	lastEnd = lastSubNode.getOffset() + lastSubNode.getLength();
	        }
	        
	        if(textBlock.isOffsetRelative()) {
	        	tbOffset = getAbsoluteOffset(textBlock);
	        } else {
	        	tbOffset = textBlock.getOffset();
	        }
        }
		int newlength =  lastEnd - tbOffset;
		return newlength;
	}
    
	
	/**
	 * makes the subnodes relative to the offset of the given {@link TextBlock}
	 * this is done recursively for all subBlocks of the given block.
	 * @param tb
	 * @return
	 */
	public static void makeRelativeOffsetRecursively(TextBlock tb) {
		
		for (Object subNode : getSubNodes(tb)) {
			if(subNode instanceof TextBlock) {
				makeRelativeOffsetRecursively((TextBlock) subNode);
			}
		}
		updateTextBlockLocationUsingSubNodesAfterAdding(tb);
		makeSubNodesRelative(tb);
		TbValidationUtil.assertTextBlockConsistencyRecursive(tb);
	}
    /**
     * @param textBlock
     * @param subNodes
     */
    public static void makeSubNodesRelative(TextBlock textBlock) {
        List<? extends DocumentNode> subNodes = getSubNodes(textBlock);
        // finally update all offsets by making them relative to the new block
        int lastOffset = 0;
        int lastLength = 0;
        for (Iterator<? extends DocumentNode> iterator = subNodes.iterator(); iterator.hasNext();) {
            DocumentNode documentNode  = iterator.next(); 
            if (! documentNode.isOffsetRelative() ) {
                //int newOffSet = documentNode.getOffset() - getAbsoluteOffset(textBlock);
                int newOffSet = lastOffset + lastLength;
                if (newOffSet < 0) {
                    if (! ( documentNode instanceof Eostoken) ) {
                        throw new IllegalArgumentException("BUG: Attempt to set negative Offset: " + newOffSet);
                    } else {
                        continue;
                    }
                }
                documentNode.setOffset(newOffSet);
                documentNode.setOffsetRelative(true);
            }
            lastOffset = documentNode.getOffset();
            lastLength = documentNode.getLength();
        }
    }

	public static void relocateToken(AbstractToken subNode, int i, TextBlock tb) {
		//make offset absolute before moving it to the new block
		//TODO if offset handling externalized this has to be changed		
		int originalAbsoluteOffset = getAbsoluteOffset(subNode);
		TextBlock oldParent = subNode.getParent();
		if(oldParent.isOffsetRelative()) {
			oldParent.setOffset(getAbsoluteOffset(oldParent));
			oldParent.setOffsetRelative(false);
			for (DocumentNode child : getSubNodes(oldParent)) {
				if(child.isOffsetRelative()){
					child.setOffset(getAbsoluteOffset(child));
					child.setOffsetRelative(false);
				}
			}
		}
//		//if element is at the edge of the subblock change its boundaries
//		if(firstTokenWithoutBOS(oldParent).equals(subNode)) {
//			//updateOffsetAscending(oldParent, oldParent.getOffset() - subNode.getLength());
//			TbChangeUtil.updateLengthAscending(oldParent, - subNode.getLength());
//			TbChangeUtil.updateOffsets(oldParent, -subNode.getLength());
//		} else if (getSubNodeAt(oldParent, getSubNodesSize(oldParent)-1).equals(subNode)){
//			TbChangeUtil.updateLengthAscending(oldParent, - subNode.getLength());
//			//TbChangeUtil.updateOffsets(oldParent, -subNode.getLength());
//		}
		subNode.setOffset(originalAbsoluteOffset);
		subNode.setOffsetRelative(false);
		subNode.setParent(null);
		
		DocumentNode subNodeAtI = getSubNodeAt(tb, i);
		if(subNodeAtI != null && getAbsoluteOffset(subNodeAtI) == originalAbsoluteOffset) {
			TextBlock parentToCheck = oldParent;
			parentToCheck.setOffset(originalAbsoluteOffset + subNode.getLength());
			parentToCheck.setOffsetRelative(false);
			updateParentsAscendingAfterRemoval(parentToCheck);
		}
		//end TODO
		TbChangeUtil.addToBlockAt(tb, i, subNode);
		updateTextBlockLocationUsingSubNodesAfterAdding(tb);
		updateParentsAscendingAfterAdding(tb);
		//if the token is added to the parent block of the original block
		//we need to make sure that the original block and the relocated token do not have the same
		//offsets.
		
	}    
}
