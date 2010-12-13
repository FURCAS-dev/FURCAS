/**
 * 
 */
package com.sap.furcas.runtime.textblocks.model;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getLevel;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getParentBlock;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodeAt;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodes;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.isFirstInSubTree;
import static com.sap.furcas.runtime.textblocks.TbUtil.getAbsoluteOffset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.textblocks.CoverageBean;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbReplacingHelper;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;

/**
 * A model of a textBlocks tree.
 */
public class TextBlocksModel {

    private TextBlock rootBlock;

    private final VersionedTextBlockNavigator navigator;

    private Version activeVersion = Version.REFERENCE;

    private final ShortPrettyPrinter shortPrettyPrinter;

    private boolean usecache = false;

    private final EditingDomain editingDomain;

    public boolean isUsecache() {
	return usecache;
    }

    public void setUsecache(boolean usecache) {
	this.usecache = usecache;
    }

    /**
     * @param rootBlock2
     * @param modelAdapter
     */
    public TextBlocksModel(TextBlock rootBlock2, IModelElementInvestigator modelAdapter) {
	this(rootBlock2, Version.REFERENCE, modelAdapter, null);
    }

    /**
     * @param rootBlock2
     * @param modelAdapter
     */
    public TextBlocksModel(TextBlock rootBlock2, IModelElementInvestigator modelAdapter, EditingDomain editingDomain) {
	this(rootBlock2, Version.REFERENCE, modelAdapter, editingDomain);
    }

    /**
     * @param rootBlock2
     * @param modelAdapter
     * @param editingDomain
     */
    public TextBlocksModel(TextBlock rootBlock2, Version activeVersion, IModelElementInvestigator modelAdapter,
	    EditingDomain editingDomain) {
	this.activeVersion = activeVersion;
	this.editingDomain = editingDomain;
	navigator = new VersionedTextBlockNavigator(activeVersion);
	setRootTextBlock(rootBlock2);
	shortPrettyPrinter = new ShortPrettyPrinter(modelAdapter);
    }

    /**
     * @return the activeVersion
     */
    public Version getActiveVersion() {
	return activeVersion;
    }

    /**
     * @param activeVersion
     *            the activeVersion to set
     */
    public void setActiveVersion(Version activeVersion) {
	this.activeVersion = activeVersion;
    }

    public <T extends DocumentNode> T activeVersion(T node) {
	return TbVersionUtil.getOtherVersion(node, activeVersion);
    }

    /**
     * @return
     * 
     */
    public TextBlock getRoot() {
	return rootBlock;
    }

    /**
     * Sets the root {@link TextBlock} to work on.
     * 
     * @param rootBlock
     */
    public void setRootTextBlock(TextBlock rootBlock) {
	if (rootBlock == null) {
	    throw new IllegalArgumentException("null block passed as root");
	}
	if (rootBlock.getParent() != null) {
	    throw new IllegalArgumentException("block passed is not root");
	}
	this.rootBlock = rootBlock;
    }

    /**
     * Returns the token at the offset, or the last token before the offset.
     * 
     * @param offset
     *            absolute offset in text
     * @return token at the offset, last toekn before the offset, or null, if no
     *         lexed tokens in textblocks model
     * @throws TextBlocksModelException
     */
    public AbstractToken getFloorTokenInRoot(int offset) {
	return navigator.getFloorToken(rootBlock, offset);
    }

    /**
     * @return length of the whole text
     */
    public int getLength() {
	return rootBlock.getLength();
    }

    /*
     * Important: not based on rootBlock cachedString to allow the underlying
     * textblocks model to be changed through other means than
     * TextBlocksModel.replace().
     */
    public char get(final int offset) {
	if (offset < 0) { // should never happen
	    throw new IllegalArgumentException("Offset negative: " + offset);
	}
	if (offset >= getLength()) { // should never happen
	    throw new IllegalArgumentException("Offset outside text length " + offset + ">" + getLength());
	}
	if (usecache) {
	    return rootBlock.getCachedString().charAt(offset);
	}
	AbstractToken token = getFloorTokenInRoot(offset);
	if (token == null) {

	    return ' ';
	}

	int tokenStartOffset = TbUtil.getAbsoluteOffset(token);
	int tokenRelativeOffset = offset - tokenStartOffset;

	String value = token.getValue();
	if (tokenRelativeOffset < value.length()) {
	    return value.charAt(tokenRelativeOffset);
	} else {
	    return ' ';
	}
    }

    /*
     * Important: not based on rootBlock cachedString to allow the underlying
     * textblocks model to be changed through other means than
     * TextBlocksModel.replace().
     */
    public String get(final int regionOffset, final int regionLength) {

	if (regionLength == 0) {
	    return "";
	}

	if (regionLength < 0) {
	    throw new IllegalArgumentException("regionLength negative");
	}

	if (regionOffset < 0) {
	    throw new IllegalArgumentException("regionOffset negative");
	}

	if (regionOffset > rootBlock.getLength()) {
	    throw new IllegalArgumentException("regionOffset larger than document length");
	}

	if (regionOffset + regionLength > rootBlock.getLength()) {
	    throw new IllegalArgumentException("regionLength too large");
	}

	// TODO: maybe check input and throw IllegalArgumentException

	if (usecache) {
	    return rootBlock.getCachedString().substring(regionOffset, regionOffset + regionLength);
	}

	int remainingLength = regionLength;
	StringBuilder result = new StringBuilder(regionLength);

	// the position in the TextBlocksModel we currently look at for more
	// chars
	int currentAbsoluteCursorPosition = regionOffset;

	// find entry covering the offset position
	AbstractToken token = getFloorTokenInRoot(currentAbsoluteCursorPosition);
	if (token == null) {
	    // start of region is before first token, need to fill blanks up to
	    // first token of until remaining length is full
	    while (remainingLength > 0 && token == null) {
		result.append(' ');
		currentAbsoluteCursorPosition++;
		remainingLength--;
		token = getFloorTokenInRoot(currentAbsoluteCursorPosition);
	    }
	    if (remainingLength == 0) {
		return result.toString();
	    }
	}

	int entryOffset = getAbsoluteOffset(token); // entryOffset <=
	// regionOffset

	// the token-relative position we currently look at
	int startOffsetInToken = currentAbsoluteCursorPosition - entryOffset;

	while (remainingLength > 0) {
	    // in each step of the loop, we need to fill up the StringBuilder
	    // with
	    // token contents and blanks until remainingLength is zero.

	    String value = token.getValue();
	    // String resynchronizedValue =
	    // shortPrettyPrinter.resynchronizeToEditableState(token);
	    // if(value == null || "".equals(value)){
	    // //value is out of sync with model
	    // //update value from model if possible.
	    // value = resynchronizedValue;
	    // }
	    // if(token.getLength() != value.length()
	    // || (token.getValue() != null && !"".equals(value) &&
	    // !resynchronizedValue.equals(token.getValue()))) {
	    // // if(token.getVersion().equals(VersionEnum.PREVIOUS)) {
	    // //
	    // if(token.getValue().equals(TbVersionUtil.getOtherVersion(token,
	    // VersionEnum.REFERENCE).getValue())) {
	    // // replace(getAbsoluteOffset(token), token.getLength(),
	    // resynchronizedValue);
	    // // return get(regionOffset, regionLength);
	    // // } else {
	    // // //Value was manually changed so do not resynch!
	    // // }
	    // // } else {
	    // // replace(getAbsoluteOffset(token), token.getLength(),
	    // resynchronizedValue);
	    // // return get(regionOffset, regionLength);
	    // // }
	    // }

	    // if (token.getLength() != value.length()) { // Sanity check helps
	    // to detect bugs
	    // TextBlock workingCopy = (TextBlock)
	    // TbReplacingHelper.getOrCreateWorkingCopy(getRoot());
	    // replaceInNonEmptyTree(getAbsoluteOffset(token), value.length(),
	    // value, workingCopy);
	    // }

	    // how many chars of token can we use for the result
	    int resultPartLength = value.length() - startOffsetInToken;
	    if (resultPartLength <= 0) {
		// This mean the current floor token ends before the startoffset
		// we are interested in. We now need to
		// add blanks until the next token, or remaining length is
		// filled with blanks.
		while (remainingLength > 0) {
		    result.append(' ');
		    currentAbsoluteCursorPosition++;
		    remainingLength--;
		    resultPartLength = 1;
		    AbstractToken newToken = getFloorTokenInRoot(currentAbsoluteCursorPosition);
		    if (newToken == null) {
			throw new RuntimeException("No Floor token for position " + currentAbsoluteCursorPosition);
		    }
		    if (newToken != token) {
			token = newToken;
			entryOffset = getAbsoluteOffset(token);
			startOffsetInToken = 0;
			break;
		    }
		}
		continue;
		// either remainingLength is zero, then the outer while will
		// also stop
		// or we have a new token
	    }

	    // check whether this is the last token we need to use, or whether
	    // we will need to look at more
	    if (remainingLength > resultPartLength) {
		result.append(value.substring(startOffsetInToken, value.length()));

		remainingLength = remainingLength - (resultPartLength);

		currentAbsoluteCursorPosition = startOffsetInToken + entryOffset + resultPartLength;
		// get next entry for next iteration
		AbstractToken newToken = getFloorTokenInRoot(currentAbsoluteCursorPosition);

		if (!newToken.equals(token)) {
		    token = newToken;
		    entryOffset = getAbsoluteOffset(token);
		    startOffsetInToken = 0; // from now on startOffset is always
					    // zero, always consider full token
					    // value
		} else {
		    // will be dealt with in next iteration
		    startOffsetInToken += resultPartLength;
		}

	    } else { // this is the last token to consider
		result.append(value.substring(startOffsetInToken, startOffsetInToken + remainingLength));
		break;
	    }
	} // end while appending values

	String resultString = result.toString();

	// the following is just a workaround for inconsistent TextBlock Models
	// after e.g. JmiExceptions.
	if (resultString.length() != regionLength) {
	    throw new IllegalStateException("Bug: Resulting String '" + resultString + "' has inconsistent length "
		    + regionLength + "!=" + resultString.length());
	    // int difference = originallength - resultString.length();
	    // if (difference > 0) {
	    // for (int i = 0; i < difference; i++) {
	    // resultString += '#';
	    // }
	    // } else {
	    // resultString = resultString.substring(0, originallength);
	    // }
	}

	return resultString;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.ITextStore#replace(int, int,
     * java.lang.String)
     * 
     * As more than one token can be located within the replaced region, the
     * situation is handled as follows: The first affected token has it's
     * intersection with the replaced region replaced by the newText. The last
     * affected token has it's intersection with the replaced region removed.
     * All other affected nodes are removed from the textblocks model.
     * 
     * Any of the updated tokens left with a length of 0 are removed from their
     * parent textblock. Now empty textblocks are removed recursively as well.
     */
    public void replace(final int replacedRegionOffset, final int replacedRegionLength, final String newText) {
        editingDomain.getCommandStack().execute(new AbstractCommand("Replace") {

            @Override
            public boolean canExecute() {
                return true;
            }

            @Override
            public void execute() {
                TextBlock workingcopy = (TextBlock) TbReplacingHelper.getOrCreateWorkingCopy(rootBlock);
                setRootTextBlock(workingcopy);
                // if (ParsingTextblocksActivator.getDefault() != null) {
                // ParsingTextblocksActivator.getDefault().enableMoinLogging(
                // workingcopy.get___Connection());
                // }
                replace(workingcopy, replacedRegionOffset, replacedRegionLength, newText);
                // if (ParsingTextblocksActivator.getDefault() != null) {
                // ParsingTextblocksActivator.getDefault().disableMoinLogging(
                // workingcopy.get___Connection());
                // }
            }

            @Override
            public void redo() {
                // TODO Auto-generated method stub

            }

        });
	

    }

    public void doShortPrettyPrintToEditableVersion() {
	editingDomain.getCommandStack().execute(new AbstractCommand("Pretty Print Short") {

	    @Override
	    public boolean canExecute() {
		return true;
	    }

	    @Override
	    public void execute() {
		AbstractToken tok = getStartToken();
		while (tok != null && !(tok instanceof Eostoken)
		/*
		 * * && tok. is___Alive ()
		 */) {
		    if (tok instanceof LexedToken) {
			String newValue = shortPrettyPrinter.resynchronizeToEditableState(tok);
			// TODO check what to do with the empty string case!
			if (!newValue.equals(tok.getValue()) && !newValue.equals("")) {
			    int length = tok.getLength();
			    int offset = TbUtil.getAbsoluteOffset(tok);
			    if (newValue.length() != length) {
				replaceInNonEmptyTree(offset, length, newValue, rootBlock);
			    } else {
				tok.setValue(newValue);
			    }
			    rootBlock.setCachedString(rootBlock.getCachedString().substring(0, offset)
				    + newValue
				    + rootBlock.getCachedString()
					    .substring(offset + length, rootBlock.getCachedString().length()));
			}
		    }
		    tok = TbNavigationUtil.nextToken(tok);
		}
	    }

	    @Override
	    public void redo() {
		// TODO Auto-generated method stub

	    }

	});

    }

    public void reduceToMinimalVersion() {
	shortPrettyPrinter.makeFlyweight(rootBlock);
    }

    /**
     * @param replacedRegionAbsoluteOffset
     * @param replacedRegionLength
     * @param newText
     * @param workingCopy
     */
    private void replaceInNonEmptyTree(int replacedRegionAbsoluteOffset, int replacedRegionLength, String newText,
	    TextBlock workingCopy) {

	// find out whether the region starts on a token gap
	DocumentNode bottomNode = navigator.getLeafNode(workingCopy, replacedRegionAbsoluteOffset);
	if (bottomNode instanceof TextBlock) {
	    // extend a token in the block with blanks to cover the beginning of
	    // the gap.
	    TextBlock bottomBlock = (TextBlock) bottomNode;
	    if (newText.length() > 0) {
		// prepare replacement by modifying the situation, prefer to
		// extend the region over the previous token, if one exists
		AbstractToken floorToken = navigator.getFloorToken(workingCopy, replacedRegionAbsoluteOffset);
		if (floorToken != null) {
		    int floorTokenAbsoluteOffset = TbUtil.getAbsoluteOffset(floorToken);
		    // change replaced region text and offset / length to cover
		    // floor token
		    int distance = replacedRegionAbsoluteOffset - (floorTokenAbsoluteOffset + floorToken.getLength());
		    String gapBlanks = TbReplacingHelper.getGapBlanks(distance);
		    // now, replace whole floortoken up to end of replaced
		    // region
		    replacedRegionLength = floorToken.getLength() + distance + replacedRegionLength;
		    // replace with floortoken text, n blanks, and newText
		    newText = floorToken.getValue() + gapBlanks + newText;
		    // start replacing at floortoken
		    replacedRegionAbsoluteOffset = TbUtil.getAbsoluteOffset(floorToken);
		} else {
		    /*
		     * get ceiling token from offset, which must be somewhere
		     * below the bottom block (else there'd be a floor token)
		     * actually the first non BOS token in root must be the next
		     * token, since there was no floor token. extend ceiling
		     * token and all its parents up to bottom block to cover
		     * replaced region
		     */
		    AbstractToken ceilingToken = TbNavigationUtil.firstTokenWithoutBOS(bottomBlock);
		    TbReplacingHelper.extendLeftToOffsetAscending(ceilingToken, replacedRegionAbsoluteOffset);
		}
	    }
	}
	// at this point it should hold that the tree is still consistent, and
	// there exists a token at replacedRegionOffset.

	CoverageBean rootCoverageType = new CoverageBean();
	rootCoverageType.setCovered(true);
	rootCoverageType.setNodeStartsLater(false);
	rootCoverageType.setNodeEndsLater(true); // doesn't really matter
	modifyBlockRecursive(workingCopy, replacedRegionAbsoluteOffset, replacedRegionLength, newText, rootCoverageType);
    }

    /**
     * modifies this block and its subblocks recursively, assumes that the
     * replacedRegionOffset is over a token, not at a token gap.
     * 
     * @param currentBlock
     * @param replacedRegionRelativeOffset
     *            relative to root offset
     * @param replacedRegionLength
     * @param newText
     * @param coverageType
     * @param bottomBlock
     *            null or the block in which the gap exists
     * @return whether the traverse Block should be deleted
     */
    private boolean modifyBlockRecursive(TextBlock currentBlock, int replacedRegionRelativeOffset, int replacedRegionLength,
	    String newText, CoverageBean coverageType) {
	boolean shouldBeDeleted = false;
	int currentBlockAbsoluteOffset = TbUtil.getAbsoluteOffset(currentBlock);

	traverseSubTokens(currentBlock, replacedRegionRelativeOffset, replacedRegionLength, newText, currentBlockAbsoluteOffset);

	traverseSubBlocks(currentBlock, replacedRegionRelativeOffset, replacedRegionLength, newText, currentBlockAbsoluteOffset);

	if (TbNavigationUtil.getSubNodesSize(currentBlock) == 0) {
	    shouldBeDeleted = true;
	    // deal with root node special? (should never happen)
	} else {
	    // modify offset and length of this textBlock
	    if (coverageType.isCovered()) { // should always be the case, else
					    // this method would not be entered
		if (!coverageType.isNodeStartsLater() && !coverageType.isNodeEndsLater()) {
		    // textBlock starts earlier or at the same time, but ends
		    // before replacedregion end

		    // offset remains the same
		    // length may change to offsetInNode plus newText.length
		    int newBlocklength = replacedRegionRelativeOffset + newText.length(); // length
											  // change
											  // may
											  // be
											  // positive,
											  // negative
											  // or
											  // zero
		    if (newBlocklength != currentBlock.getLength()) {
			currentBlock.setLength(newBlocklength);
		    }
		} else if (coverageType.isNodeStartsLater() && coverageType.isNodeEndsLater()) { // textblock
												 // starts
												 // within
												 // region
												 // and
												 // ends
												 // outside
		    // length is reduced by overlap of region and block, since
		    // we cut off start of block
		    int overLapSize = (replacedRegionRelativeOffset + replacedRegionLength); // always
											     // positive
											     // in
											     // this
											     // case
		    if (overLapSize != 0) {
			currentBlock.setLength(currentBlock.getLength() - overLapSize);
		    }

		    if (currentBlock.isOffsetRelative() && (replacedRegionRelativeOffset + currentBlock.getOffset()) < 0) {
			// block relative offset moves by the region that will
			// be cut off from its parent
			// if replacement happens within parent, reduce the
			// offset by some amount
			// if replacement starts outside of parent, set offset
			// to zero, as all siblings left of this token will be
			// deleted else
			currentBlock.setOffset(0);
		    } else {
			// token absolute offset moves right by the amount cut
			// off, but then also moves by the difference between
			// original region and new region
			int blockOffsetChange = overLapSize;
			blockOffsetChange += (newText.length() - replacedRegionLength);
			if (blockOffsetChange != 0) {
			    currentBlock.setOffset(currentBlock.getOffset() + blockOffsetChange);
			}
		    }

		} else { // textblock is within replaced region, but has a
			 // subBlock or token left at replacedRegionStart
			 // offset remains the same
			 // length may change by the difference of replaced
			 // region and new text
		    int regionLengthDifference = newText.length() - replacedRegionLength; // length
											  // change
											  // may
											  // be
											  // positive,
											  // negative
											  // or
											  // zero
		    if (regionLengthDifference != 0) {
			currentBlock.setLength(currentBlock.getLength() + regionLengthDifference);
		    }

		}
	    }
	}
	return shouldBeDeleted;
    }

    /**
     * @param currentBlock
     * @param replacedRegionRelativeOffset
     * @param replacedRegionLength
     * @param newText
     * @param shouldBeDeleted
     * @param currentBlockAbsoluteOffset
     * @param bottomBlock
     * @return
     */
    private void traverseSubBlocks(TextBlock currentBlock, int replacedRegionRelativeOffset, int replacedRegionLength,
	    String newText, int currentBlockAbsoluteOffset) {
	List<TextBlock> toBeDeleted = new ArrayList<TextBlock>();
	List<TextBlock> subBlocks = currentBlock.getSubBlocks();
	for (Iterator<TextBlock> iterator = subBlocks.iterator(); iterator.hasNext();) {
	    // TODO: to optimize performance, find (binary search) and start
	    // with first child covering region
	    TextBlock textBlock = iterator.next();

	    int blockRelativeOffset = textBlock.getOffset();
	    if (textBlock.isOffsetRelative() == false) {
		blockRelativeOffset -= currentBlockAbsoluteOffset;
	    }
	    CoverageBean coverageType = CoverageBean.getCoverageBean(blockRelativeOffset,
		    blockRelativeOffset + textBlock.getLength(), replacedRegionRelativeOffset, replacedRegionRelativeOffset
			    + replacedRegionLength);

	    if (coverageType.isCovered() == false) {
		if (coverageType.isNodeStartsLater() == false) { // node is
								 // before
								 // replaced
								 // region

		} else { // node is after replacement region, offset may change
		    if (textBlock.isOffsetRelative() && replacedRegionRelativeOffset < 0) {
			// draw it to understand
			int offsetDifference = replacedRegionRelativeOffset + replacedRegionLength;
			if (offsetDifference != 0) {
			    textBlock.setOffset(textBlock.getOffset() - offsetDifference);
			}
		    } else {
			int offsetDifference = newText.length() - replacedRegionLength; // can
											// be
											// negative
											// if
											// newtext
											// is
											// shorter
			if (offsetDifference != 0) {
			    textBlock.setOffset(textBlock.getOffset() + offsetDifference);
			}
		    }
		}
	    } else { // node covers replaced region
		if (coverageType.isNodeRealInside()) {
		    toBeDeleted.add(textBlock);
		} else {
		    textBlock.setChildrenChanged(true);
		    // change contents starting at offset
		    boolean needsDeleting = modifyBlockRecursive(textBlock, replacedRegionRelativeOffset - blockRelativeOffset,
			    replacedRegionLength, newText, coverageType);
		    if (needsDeleting) {
			toBeDeleted.add(textBlock);
		    }
		}
	    }
	}
	for (Iterator<TextBlock> iterator = toBeDeleted.iterator(); iterator.hasNext();) {
	    TextBlock block = iterator.next();
	    EcoreUtil.delete(block, /*recursive*/ true);
	}

    }

    /**
     * @param current
     * @param replacedRegionRelativeOffset
     * @param replacedRegionLength
     * @param newText
     * @param currentBlockAbsoluteOffset
     */
    private void traverseSubTokens(TextBlock current, int replacedRegionRelativeOffset, int replacedRegionLength, String newText,
	    int currentBlockAbsoluteOffset) {

	List<AbstractToken> subtokens = current.getTokens();
	List<AbstractToken> toBeDeleted = new ArrayList<AbstractToken>();
	boolean isFirst = true;
	for (Iterator<AbstractToken> iterator = subtokens.iterator(); iterator.hasNext();) {
	    // to optimize performance, find (binary search) and start with
	    // first child covering region
	    AbstractToken abstractToken = iterator.next();
	    if (!iterator.hasNext() && abstractToken instanceof Eostoken) {
		int difference = newText.length() - replacedRegionLength;
		abstractToken.setOffset(abstractToken.getOffset() + difference);
	    } else if (isFirst && abstractToken instanceof Bostoken) {
		// do nothing ever
	    } else {
		boolean needsDeleting = TbReplacingHelper.modifyTokenOnOverlap(abstractToken, currentBlockAbsoluteOffset,
			replacedRegionRelativeOffset, replacedRegionLength, newText, shortPrettyPrinter);
		if (needsDeleting) {
		    toBeDeleted.add(abstractToken);
		}
	    }
	    isFirst = false;
	}
	for (Iterator<AbstractToken> iterator = toBeDeleted.iterator(); iterator.hasNext();) {
	    AbstractToken abstractToken = iterator.next();
	    EcoreUtil.delete(abstractToken);
	}

    }

    /**
     * @param newText
     * @param workingCopy
     */
    static void replaceInEmptyTree(String newText, TextBlock workingCopy) {
	workingCopy.setLength(newText.length());

	if (workingCopy.getTokens().size() == 2) {
	    TbReplacingHelper.createInitialToken(workingCopy, newText);
	} else { // subnodes size != 2
	    if (workingCopy.getTokens().size() != 3) {
		throw new IllegalArgumentException(
			"Method only works for textBlocks of length 0 if only BOS and EOS, or BOS, an empty token, and EOS are present.");
	    }
	}
	// change the middle token between BOS and EOS
	workingCopy.getTokens().get(1).setLength(newText.length());
	workingCopy.getTokens().get(1).setValue(newText);
	workingCopy.setLength(newText.length());
	// set BOS offset
	workingCopy.getTokens().get(workingCopy.getTokens().size() - 1).setOffset(newText.length());
    }

    /**
     * replaces the content of a textBlock tree by modifying and deleting
     * tokens. assumes that root is passed in, and that there is a PREVIOUS
     * version of root which contains PREVIOUS versions of all nodes. This
     * method currently does not create any PREVIOUS versions of anything.
     * Assumes all nodes (except root, BOS, EOS) have relative offsets !
     * 
     * @param root
     * @param replacedRegionAbsoluteOffset
     * @param replacedRegionLength
     * @param newText
     */
    public void replace(final TextBlock root, final int replacedRegionAbsoluteOffset, final int replacedRegionLength, final String newText) {
        editingDomain.getCommandStack().execute(new AbstractCommand("Replace") {

            @Override
            public boolean canExecute() {
                return true;
            }

            @Override
            public void execute() {

                TextBlock workingCopy = (TextBlock) TbReplacingHelper.getOrCreateWorkingCopy(root);
                if (replacedRegionAbsoluteOffset < 0 || replacedRegionAbsoluteOffset > root.getLength()) {
                    throw new IllegalArgumentException(Integer.toString(replacedRegionLength));
                }
                if (replacedRegionAbsoluteOffset + replacedRegionLength > root.getLength()) {
                    throw new IllegalArgumentException((replacedRegionAbsoluteOffset + replacedRegionLength) + " > " + root.getLength());
                }
                if (root.getParent() != null) {
                    throw new IllegalArgumentException("TextBlock is not root.");
                }

                if (root.getLength() == 0) {

                    replaceInEmptyTree(newText, workingCopy);
                } else {
                    replaceInNonEmptyTree(replacedRegionAbsoluteOffset, replacedRegionLength, newText, workingCopy);

                }
                workingCopy.setChildrenChanged(true);
                TbReplacingHelper.updateBlockCachedString(workingCopy, replacedRegionAbsoluteOffset, replacedRegionLength, newText);
            }

            @Override
            public void redo() {
                // TODO Auto-generated method stub

            }

        });
    }

    /**
     * Computes a list of nodes containing the two leaf nodes corresponding to
     * offsetFrom and offsetTo, and nodes between them. The nodes between the
     * tokens are returned as a root set, meaning that the highest level nodes
     * are returned, such that all model elements between the floor tokens are
     * directly or indirectly (as children, children's children etc.) contained
     * in the list, but the list has a minimum number of entries, given the
     * above restrictions. This implies that it is not the absolute minimal root
     * set, because the first and last leaf nodes are always included, even if
     * the list could become smaller if some ancestor of them were instead
     * included.
     * 
     * Nodes in between the floor tokens are all right siblings of the left
     * floor token, right siblings of the left floor token's parent etc and all
     * left siblings of the right floor token and left siblings of the the right
     * floor token's parent etc. If both tokens or the corresponding parents are
     * in the same TextBlock, all siblings between the two nodes are added to
     * the list.
     * 
     * See test cases for examples.
     * 
     * @param rootBlock
     *            the top-most TextBlock
     * @param offsetFrom
     *            absolute start offset
     * @param offsetTo
     *            absolute end offset
     * @return minimal list of nodes that directly, or indirectly include all
     *         tokens between the floor tokens identified by offsetFrom and
     *         offsetTo
     */
    public List<DocumentNode> getNodesBetweenAsRootSet(TextBlock rootBlock, int offsetFrom, int offsetTo) {
	List<DocumentNode> results = new ArrayList<DocumentNode>();

	if (offsetFrom < 0) {
	    throw new IllegalArgumentException("invalid region: offsetFrom is negative");
	}

	if (offsetTo < offsetFrom) {
	    throw new IllegalArgumentException("invalid region: offsetTo is smaller than offsetFrom");
	}
	if (offsetTo > TbUtil.getAbsoluteOffset(rootBlock) + rootBlock.getLength()) {
	    throw new IllegalArgumentException("Region outside textBlock : " + offsetTo + ">"
		    + (TbUtil.getAbsoluteOffset(rootBlock) + rootBlock.getLength()));
	}
	// find leftmost leaf node of the region
	DocumentNode leftLeafNode = navigator.getLeafNode(rootBlock, offsetFrom);

	// find rightmost leaf node of the region
	DocumentNode rightLeafNode = navigator.getLeafNode(rootBlock, offsetTo);

	results.addAll(getNodesBetweenAsRootSet(leftLeafNode, rightLeafNode));

	return results;
    }

    /**
     * Computes a list of nodes containing the two floorTokens corresponding to
     * offsetFrom and offsetTo, and nodes between them. The nodes between the
     * tokens are returned as a root set, meaning that the highest level nodes
     * are returned, such that all and only model elements between the tokens
     * are directly or indirectly (as children, children's children etc.)
     * contained in the list, but the list has a minimum number of entries. The
     * list thus will never contain any 2 document nodes where one is an
     * ancestor of the other.
     * 
     * Nodes in between the floor tokens are all right siblings of the left
     * floor token, right siblings of the left floor token's parent etc and all
     * left siblings of the right floor token and left siblings of the the right
     * floor token's parent etc. If both tokens or the corresponding parents are
     * in the same TextBlock, all siblings between the two nodes are added to
     * the list.
     * 
     * See test cases for examples.
     * 
     * @param rootBlock
     *            the top-most TextBlock
     * @param offsetFrom
     *            absolute start offset
     * @param offsetTo
     *            absolute end offset
     * @return minimal list of nodes that directly, or indirectly include all
     *         tokens between the floor tokens identified by offsetFrom and
     *         offsetTo
     */
    private List<DocumentNode> getNodesBetweenAsRootSet(DocumentNode leftFloorToken, DocumentNode rightFloorToken) {
	List<DocumentNode> results = new ArrayList<DocumentNode>();

	if (rightFloorToken == null || leftFloorToken == null) {
	    throw new IllegalArgumentException("Tokens must not be null");
	}
	if (leftFloorToken == rightFloorToken) {
	    // only one floor token
	    results.add(leftFloorToken);
	    return results;
	}

	results.add(leftFloorToken);

	int leftNodeLevel = getLevel(leftFloorToken);
	int rightNodeLevel = getLevel(rightFloorToken);

	Map<Integer, DocumentNode> rightNodeLevelMap = TbUtil.createNodeLevelMap(rightFloorToken, rightNodeLevel);

	DocumentNode curLeftNode = leftFloorToken;
	int curLeftLevel = leftNodeLevel;
	// get the node in the right node path which is on the same level as
	// leftFloorNode (if any)
	DocumentNode possibleSameLevelRightNode = rightNodeLevelMap.get(curLeftLevel);

	// ascend
	DocumentNode parentBlock = getParentBlock(curLeftNode);
	while (parentBlock != null) {
	    addRightSiblingsBeforeEndNode(results, curLeftNode, possibleSameLevelRightNode);
	    if (getParentBlock(curLeftNode) == getParentBlock(possibleSameLevelRightNode)) {
		// found same level right node
		if (possibleSameLevelRightNode == rightFloorToken) {
		    // we are done
		    results.add(rightFloorToken);
		    return results;
		}
		break;
	    }

	    curLeftNode = parentBlock;
	    parentBlock = getParentBlock(parentBlock);
	    curLeftLevel--;
	    possibleSameLevelRightNode = rightNodeLevelMap.get(curLeftLevel);
	}
	// now either we have reached a level where both subtrees have a common
	// parent, or we have reached root

	DocumentNode curRightNode = possibleSameLevelRightNode;
	int curRightLevel = curLeftLevel + 1;
	DocumentNode nextRightNode = rightNodeLevelMap.get(curRightLevel);

	// descend
	while (nextRightNode != rightFloorToken) {
	    // if there are nodes left of current path node, include them
	    if (!isFirstInSubTree(nextRightNode)) {
		DocumentNode firstSubNode = getSubNodeAt((TextBlock) curRightNode, 0);
		results.add(firstSubNode);
		addRightSiblingsBeforeEndNode(results, firstSubNode, nextRightNode);
	    }
	    curRightNode = nextRightNode;
	    curRightLevel++;
	    nextRightNode = rightNodeLevelMap.get(curRightLevel);
	}

	// no deeper parent, last block
	if (!isFirstInSubTree(rightFloorToken)) {
	    DocumentNode firstSubNode = getSubNodeAt(TbNavigationUtil.getParentBlock(rightFloorToken), 0);
	    if (firstSubNode instanceof Bostoken) {
		firstSubNode = getSubNodeAt(TbNavigationUtil.getParentBlock(rightFloorToken), 1);
	    }
	    results.add(firstSubNode);
	    addRightSiblingsBeforeEndNode(results, firstSubNode, rightFloorToken);
	}

	results.add(rightFloorToken);

	return results;
    }

    /**
     * Helper function that adds all nodes between start and end in the parent
     * block's subNodes. If end is null, or not in the list of subNodes, add all
     * remaining nodes.
     * 
     * @param nodes
     *            nodes list to add to
     * @param start
     *            node after which to start
     * @param end
     *            node before which to end. can be null or not part of the
     *            subNodes
     */
    public void addRightSiblingsBeforeEndNode(List<DocumentNode> nodes, DocumentNode start, DocumentNode end) {
	if (start == end) {
	    return;
	}

	List<? extends DocumentNode> subNodes = getSubNodes(getParentBlock(start));
	int index = subNodes.indexOf(start) + 1;
	while (index < subNodes.size()) {
	    DocumentNode nextNode = subNodes.get(index);
	    if (nextNode == end) {
		return;
	    }
	    nodes.add(nextNode);
	    index++;
	}
    }

    /**
	 * 
	 */
    public Bostoken getStartToken() {
	if (rootBlock.getTokens().size() <= 0) {
	    throw new IllegalStateException("TextBlocksModel is in illegal state, root block contains no tokens!");
	}
	if (!(rootBlock.getTokens().get(0) instanceof Bostoken)) {
	    throw new IllegalStateException("TextBlocksModel is in illegal state, first token not BOS!");
	}

	return (Bostoken) activeVersion(rootBlock.getTokens().get(0));
    }

}
