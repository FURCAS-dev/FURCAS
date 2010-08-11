/**
 * 
 */
package com.sap.mi.textual.textblocks.model;

import static com.sap.mi.textual.parsing.textblocks.TbChangeUtil.replaceTokenContents;
import static com.sap.mi.textual.parsing.textblocks.TbVersionUtil.getOtherVersion;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.mi.textual.parsing.textblocks.CoverageBean;
import com.sap.mi.textual.parsing.textblocks.TbChangeUtil;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbUtil;

/**
 * util for replacing regions within a textBlock Tree.
 * The class assumes a general textBlock tree with 
 * potential gaps between textBlocks and tokens.
 * Any textblocktree has as a property that only token nodes are leaves.
 * Also, the root is always a TextBlock, always has BOS and EOS as first and lat token,
 * and always additionally has a token or textBlock between BOS and EOS, which 
 * might be an empty token. But only root may have a token of length 0, and only if root.length == 0;
 * 
 * In a Tree without gaps it would hold that the absolute 
 * offset of each first child is the same as its parent, the 
 * root offset is zero, for each subnode. offset+length == nextSibling.offset
 * and that last subnodes offset+length is equal to its parent offset + length.
 * In a textBlock with gaps all the equals relations are replaced by <= relations.
 * 
 * As a result, in a tree without gaps, there is a token for any position 
 * between 0 and the length of root, while with gaps there may be positions 
 * not covered by tokens.
 * 
 * However, we still assume the root block to start at the absolute index 0.
 */
public class TbReplacingHelper {
    /*
     * Implementation details:
     * The implementation runs by traversing the textblock tree and checking for 
     * each node whether it lies ahead, after, or overlapping with the replaced region.
     * Depending on whether the node is a token or a textBlock, different actions are taken.
     * Any node which is completely left of the replaced region is left untouched, and 
     * children of such nodes are not traversed (which would cause problems for absolute offsets).
     * 
     * Any other node will have its offset, length, and content replaced, or it will 
     * be deleted if it would be reduced to length 0. Again, for nodes after the replaced 
     * region, subnodes are not traversed since their relative offsets must remain the same. 
     * 
     * Since this class does not create any new Token unless for an empty TextBlock Tree,
     * it will always attempt to reuse an existing token to fill the new content in.
     * 
     */
    
    

    /**
	 * Retrieves a {@link VersionEnum#PREVIOUS} version of the given node by
	 * either returning an exisiting one or if none exist by firstly
	 * initializing a working copy and returning it then.
	 * 
	 * @param node
	 * @return the {@link VersionEnum#PREVIOUS} version of the node
	 */
	public static DocumentNode getOrCreateWorkingCopy(DocumentNode node) {
		if( getOtherVersion(node,Version.PREVIOUS) == null) {
			TbUtil.createNewCopy(node, Version.PREVIOUS, false, null);
		}
	    DocumentNode previousVersion = getOtherVersion(node,
	            Version.PREVIOUS);
	    // TODO this might have to be changed if the textblock elements
	    // should be assignable
	    // to a custom partition
	    ((EObject) node).get___Partition()
	    	.assignElementIncludingChildren(previousVersion);
	    
	    return previousVersion;
	}
    
   
    
    /**
     * changes the absolute offset of token to new absoluteOffset by adding blanks on the left.
     * Assumes there are no tokens between given offset and node offset.
     * assumes offsets of non root nodes are relative.
     * assumes replacedRegionOffset >= 0
     * @param node
     * @param replacedRegionRelativeOffset
     */
    static void extendLeftToOffsetAscending(DocumentNode node,
            int replacedRegionAbsoluteOffset) {
        int absoluteOffset = TbUtil.getAbsoluteOffset(node);
        if (absoluteOffset > replacedRegionAbsoluteOffset) {
            int difference =  absoluteOffset - replacedRegionAbsoluteOffset; // always positive
            node.setLength(node.getLength() + difference);
            int relativeOffset = node.getOffset();
            if (node instanceof AbstractToken) {
                AbstractToken token = (AbstractToken) node;
                token.setValue(getGapBlanks(difference) + token.getValue());
            }
            if (relativeOffset <= difference) {
                node.setOffset(0);                
                extendLeftToOffsetAscending(TbNavigationUtil.getParentBlock(node), replacedRegionAbsoluteOffset);
            } else {
                node.setOffset(node.getOffset() - difference);
            }
        }
    }

    /**
     * @param i
     * @return
     */
    static String getGapBlanks(int length) {
        StringBuilder buffer = new StringBuilder(length);
        for (int j = 0; j < length; j++) {
            buffer.append(' ');
        }
        return buffer.toString();
    }

    /**
     * creates a new token, assumes there is only root, EOS, BOS in the tree.
     * @param firstAffected
     * @param newText
     * @param replacedRegionOffset
     */
    public static void createInitialToken(TextBlock target, String newText) {
        TextblocksPackage pkg = (TextblocksPackage) target.refImmediatePackage();
        LexedToken newToken = (LexedToken) pkg.getLexedToken().refCreateInstance();
//      make the same version as the rootBlock
        newToken.setVersion(target.getVersion());

        newToken.setValue(newText);
        newToken.setLength(newText.length());
        
        newToken.setOffset(0);
        newToken.setOffsetRelative(true);

        List<AbstractToken> tokens = target.getTokens();
        int index = 1; // insert after BOS, before EOS
//        for (Iterator<AbstractToken> iterator = tokens.iterator(); iterator.hasNext();) {
//            AbstractToken abstractToken = (AbstractToken) iterator.next();
//            if (abstractToken.getOffset() > 0 || abstractToken instanceof Eostoken) {
//                break;
//            }
//            index++;
//        }
        tokens.add(index, newToken);
        
        /*AbstractToken workingCopy = (AbstractToken) */ 
        getWorkingCopy(newToken);

    }
    
    


    /**
     * @param abstractToken
     * @param newText 
     * @return whether the token should be deleted
     */
    public static boolean modifyTokenOnOverlap(AbstractToken abstractToken, int parentBlockAbsoluteOffset, int replacedRegionRelativeOffset, int replacedRegionLength, String newText, ShortPrettyPrinter shortPrettyPrinter) {
        boolean shouldBeDeleted = false;

        int tokenRelativeOffset = abstractToken.getOffset();
        if (abstractToken.isOffsetRelative() == false) {
            tokenRelativeOffset -= parentBlockAbsoluteOffset;
        }
        CoverageBean coverageType = CoverageBean.getCoverageBean(tokenRelativeOffset, tokenRelativeOffset+abstractToken.getLength(), replacedRegionRelativeOffset, replacedRegionRelativeOffset + replacedRegionLength );

        if (coverageType.isCovered() == false) {
            if (coverageType.isNodeStartsLater() == false) {
                // do nothing
            } else { 
                // node is after replacement region, offset may change
                // change depends on overlap of region with parent
                if (abstractToken.isOffsetRelative() && replacedRegionRelativeOffset < 0) {
                    // draw it to understand
                    int offsetDifference = replacedRegionRelativeOffset + replacedRegionLength;
                    if (offsetDifference != 0) {
                        abstractToken.setOffset(abstractToken.getOffset() - offsetDifference);
                    }
                } else {
                    int offsetDifference = newText.length() - replacedRegionLength; // can be negative if newtext is shorter
                    if (offsetDifference != 0) {
                        abstractToken.setOffset(abstractToken.getOffset() + offsetDifference);
                    }
                }
            }
        } else { // token is covered
            if (coverageType.isNodeRealInside() ) { // token must be deleted
                shouldBeDeleted = true;
            } else if (coverageType.isNodeStartsLater() ) { // need to cut off from the start of this token

                AbstractToken workingCopy = getWorkingCopy(abstractToken);
                /**TODO begin view hack**/
                if(workingCopy == null) {
                    workingCopy = abstractToken;
                }
                /**TODO end start view hack**/
                // if token does not fully cover region, remove the left characters covered by the region
                int overlapLength = replacedRegionRelativeOffset + replacedRegionLength - abstractToken.getOffset();
                TbChangeUtil.replaceTokenContents(workingCopy, "", 0,  overlapLength, shortPrettyPrinter);

                if (workingCopy.getLength() == 0) { // did cut off delete whole token? (should never happen, as this is really inside coverage)
                    shouldBeDeleted = true;
                } else {

                    if (abstractToken.isOffsetRelative() && replacedRegionRelativeOffset < 0) {
                        // token relative offset moves by the region that will be cut off from its parent
                        // if replacement happens within parent, reduce the offset by some amount
                        // if replacement starts outside of parent, set offset to zero, as all siblings left of this token will be deleted else
                        abstractToken.setOffset(0);
                    } else {
                        // token absolute offset moves right by the amount cut off, but then also moves by the difference between original region and new region
                        int tokenOffsetChange = overlapLength;
                        tokenOffsetChange += (newText.length() - replacedRegionLength);
                        if (tokenOffsetChange != 0) {
                            abstractToken.setOffset(abstractToken.getOffset() + tokenOffsetChange);
                        }
                    }
                }
                
            } else { // need to replace parts of this token
                AbstractToken workingCopy = getWorkingCopy(abstractToken );
                /**TODO begin view hack**/
                if(workingCopy == null) {
                    workingCopy = abstractToken;
                }
                /**TODO end start view hack**/

                int replacedRegionOffsetTo = replacedRegionRelativeOffset
                + replacedRegionLength;
                int tokenEndOffset = tokenRelativeOffset
                + workingCopy.getLength();
                int replaceInTokenLength1 = Math.min(replacedRegionOffsetTo,
                        tokenEndOffset) - replacedRegionRelativeOffset; // either replace all or replace a part of the middle
                int offsetInTokenFrom = replacedRegionRelativeOffset - tokenRelativeOffset; // always positive

                // replace intersecting region in token with complete new text
                replaceTokenContents(workingCopy, newText, offsetInTokenFrom,
                        replaceInTokenLength1, shortPrettyPrinter);

                if (workingCopy.getLength() == 0) {
                    shouldBeDeleted = true;
                }
            } // end if token overlaps need to cut off left or right
        } // endif token is covered
        return shouldBeDeleted;
    }



    
    /**
     * Retrieves a {@link VersionEnum#PREVIOUS} version of the given node by
     * either returning an exisiting one or if none exist by firstly
     * initializing a working copy and returning it then.
     * 
     * @param node
     * @return the {@link VersionEnum#PREVIOUS} version of the node
     */
    static <Type extends DocumentNode> Type getWorkingCopy(Type node) {
        
        return getOtherVersion(node,
                Version.PREVIOUS);
    }
    
    static void updateBlockCachedString(TextBlock rootBlock, int replacedRegionOffset,
            int replacedRegionLength, String newText) {
        // TODO: currently needed because linetracker relies on it
        // check how and when to remove this
        rootBlock.setCachedString(rootBlock.getCachedString().substring(0,
                replacedRegionOffset)
                + newText
                + rootBlock.getCachedString().substring(
                        replacedRegionOffset + replacedRegionLength,
                        rootBlock.getCachedString().length()));
    }
    
}
