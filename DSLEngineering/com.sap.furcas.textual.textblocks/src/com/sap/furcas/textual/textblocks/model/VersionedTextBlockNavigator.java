package com.sap.furcas.textual.textblocks.model;

import java.util.List;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.furcas.textual.textblocks.TbUtil;

public class VersionedTextBlockNavigator {
	
	private Version activeVersion = Version.REFERENCE;
	
	public VersionedTextBlockNavigator(Version activeVersion) {
		super();
		this.activeVersion = activeVersion;
	}

	
	/**
	 * @return the activeVersion
	 */
	public Version getActiveVersion() {
		return activeVersion;
	}


	/**
	 * @param activeVersion the activeVersion to set
	 */
	public void setActiveVersion(Version activeVersion) {
		this.activeVersion = activeVersion;
	}


	/**
	 * Searches the floor DocumentNode compared by it's offset.
	 * 
	 * Assumes, that the list is already sorted, or the results are undefined.
	 * Assumes, that the list implements RandomAccess to run in lg(n).
	 * 
	 * @param nodes
	 *            list of nodes to search
	 * @param offset
	 *            offset, to get floor entry of
	 * @return nearest DocumentNode in the list, that has an offset smaller or
	 *         equal than offset. if all elements in the list are larger,
	 *         returns null
	 */
	public <Type extends DocumentNode> Type floorSearchByOffset(
			List<Type> nodes, int offset) {

		int low = 0;
		int high = nodes.size() - 1;
		int mid;
		Type floorEntry = null;
		while (low <= high) {
			mid = (low + high) / 2;
			Type midNode = nodes.get(mid); 
			if (midNode.getOffset() > offset) {
				high = mid - 1;
			} else if (midNode.getOffset() < offset) {
				low = mid + 1;
				floorEntry = midNode;
			} else {
				return midNode;
			}
		}

		return floorEntry;
	}

	/**
	 * Returns the token at the offset, or the last token before the offset.
	 * Uses a binary search algorithm, as the subnodes are always sorted.
	 * 
	 * Important: ignores the bos and eos tokens of the root-block.
	 * 
	 * @param block
	 *            TextBlock to start looking
	 * @param offset
	 *            offset relative to the textblock. equals to absolute offset if
	 *            passed the rootblock.
	 * @return token at the offset, or last token before offset, or null, if no
	 *         tokens were found before the offset
	 */
	public AbstractToken getFloorToken(TextBlock block, int offset) {
		DocumentNode floorToken = null;
		if (block.getParent() == null) {
			// root block, don't search bos and eos
			floorToken = floorSearchByOffset(TbUtil.withoutBosEos(block.getTokens()),
					offset);
		} else {
			floorToken = floorSearchByOffset(block.getTokens(), offset);
		}

		DocumentNode floorBlock = floorSearchByOffset(block.getSubBlocks(),
				offset);

		if (floorToken != null) {
			if (floorBlock != null) {
				// both floor token and block found
				if (floorToken.getOffset() < floorBlock.getOffset()) {
					AbstractToken subFloorToken = getFloorToken((TextBlock) floorBlock, offset
							- floorBlock.getOffset());
					// with gaps, it may happen the subBlock has no tokens at that position
					if (subFloorToken == null) {
					    return  (AbstractToken) floorToken;
					}
					return subFloorToken;
				}
			}
			return (AbstractToken) floorToken;

		} else {
			if (floorBlock != null) {
				// only floor block exists
				return getFloorToken((TextBlock) floorBlock, offset
						- floorBlock.getOffset());
			}
		}

		// no floor token exists
		return null;
	}
	
	 /**
     * Returns the token at the offset.
     * Uses a binary search algorithm, as the subnodes are always sorted.
     * 
     * Important: ignores the bos and eos tokens of the root-block.
     * 
     * @param currentBlock
     *            TextBlock to start looking
     * @param offset
     *            offset relative to the textblock. equals to absolute offset if
     *            passed the rootblock.
     * @return token at the offset, or last token before offset, or null, if no
     *         tokens were found before the offset
     */
	public DocumentNode getLeafNode(TextBlock currentBlock, int offset) {
	    if (currentBlock == null) return null;
//	    int blockOffset = getAbsoluteOffset(block);
//	    if (blockOffset>offset || blockOffset + block.getLength() < offset) return null; // or rather illegalArgument?

	    DocumentNode floorToken = null;
	    if (currentBlock.getParent() == null) {
	        // root block, don't search bos and eos
	        floorToken = floorSearchByOffset(TbUtil.withoutBosEos(currentBlock.getTokens()),
	                offset);
	    } else {
	        floorToken = floorSearchByOffset(currentBlock.getTokens(), offset);
	    }

	    DocumentNode floorBlock = floorSearchByOffset(currentBlock.getSubBlocks(),
	            offset);

	    if (floorToken != null) {
	        if (floorBlock != null) {
	            // both floor token and block found
	            if (floorToken.getOffset() < floorBlock.getOffset()) {
	                // floorblock after floortoken, ignore token

	                DocumentNode subLeafNode = getLeafNode((TextBlock) floorBlock, offset
	                        - floorBlock.getOffset());
	                // with gaps, it may happen the subBlock has no tokens at that position
	                if (subLeafNode == null || subLeafNode == floorBlock) {
	                    if (floorBlock.getOffset() + floorBlock.getLength() > offset) {
	                        return floorBlock; // this is the difference to getFloorToken
	                    } else {
	                        return currentBlock;
	                    }
	                }
	                return subLeafNode;
	            }
	        }
	        if (floorToken.getOffset() <= offset && floorToken.getOffset() + floorToken.getLength() > offset) {
	            return floorToken;
	        }
	        return currentBlock;

	    } else { // no floor token found in this block
	        if (floorBlock != null) {
	            // only floor block exists
	            if (floorBlock.getOffset() <= offset && floorBlock.getOffset() + floorBlock.getLength() > offset) {
	                DocumentNode subLeafNode = getLeafNode((TextBlock) floorBlock, offset
	                        - floorBlock.getOffset());
	                if (subLeafNode != null) {
	                    return subLeafNode;
	                } else {
	                    return floorBlock;
	                }
	            } else { // floor block is not leaf at offset position
	                return currentBlock;
	            }
	        } else { // neither subtoken nor subBlock found within this block
	            return currentBlock;
	        }
	    }
	}
}
