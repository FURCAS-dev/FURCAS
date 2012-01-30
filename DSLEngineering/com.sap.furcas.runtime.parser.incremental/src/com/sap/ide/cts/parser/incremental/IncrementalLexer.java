package com.sap.ide.cts.parser.incremental;

import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodeAt;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.getSubNodes;
import static com.sap.furcas.runtime.textblocks.TbNavigationUtil.isToken;
import static com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil.deltaInChars;
import static com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil.isBOS;
import static com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil.isEOS;
import static com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil.mark;
import static com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil.marked;
import static com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil.getOtherVersion;
import static com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil.hasChildChanges;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.textblocks.TbDebugUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.TokenLocation;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.ide.cts.parser.Activator;

/**
 * The Incremental Lexer Servers as an intermediate class that serves the incremental parsing capabilities for an arbitrary batch
 * lexer and parser.
 * 
 * <b>Adaption to specific lexer implementations:</b> It is the responsibility of sublcasses of this class to adapt the
 * incremental lexing capabilities to a specific lexer/parser implementation. An important requirement is that these
 * implementations need to track the lookahead of the batch lexer. It is assumed that the difference between constructionLoc (the
 * place representing the end of the token being constructed ) readLoc is set according to the lookahead that was done by the
 * lexer. This information is then used to identify how much further the lexer had to look to decide the the boundaries and type
 * of the token. Lookahead is then stored in the tokens and upon incremental lexing used to identify what other tokens are
 * affected by a change within a specific tokens. In fact, these are exactly those tokens which had a lookahead reaching this
 * changed token.
 * 
 * @author C5106462
 * 
 */
public abstract class IncrementalLexer extends IncrementalRecognizer {

    private LexerAdapter batchLexer;

    private List<AbstractToken> tokenList;

    protected AbstractToken readToken;
    private TokenLocation constructionLoc;
    protected TokenLocation readLoc;
    protected int readOffset;
    protected int constructionOffset;
    protected AbstractToken constructionToken;

    private final List<TextBlock> changedBlocks = new ArrayList<TextBlock>();
    protected ShortPrettyPrinter shortPrettyPrinter;

    public IncrementalLexer(LexerAdapter lexerAdapter, IModelElementInvestigator mi) {

        this.shortPrettyPrinter = new ShortPrettyPrinter(mi);
        setBatchLexer(lexerAdapter);
        getBatchLexer().setIncrementalLexer(this);
    }

    protected void setBatchLexer(LexerAdapter batchLexer) {
        this.batchLexer = batchLexer;
    }

    public LexerAdapter getBatchLexer() {
        return batchLexer;
    }

    public Eostoken getEOS() {
        if (!EcoreHelper.isAlive(eosRef)) {
            eosRef = createEOSToken(textblocksFactory, Version.CURRENT);
        }
        return eosRef;
    }

    public Bostoken getBOS() {
        return bosRef;
    }

    public static Bostoken createBOSToken(TextblocksFactory tbFactory, Version version) {
        Bostoken bos = tbFactory.createBostoken();
        TbVersionUtil.setVersion(bos, version);
        bos.setValue(BOS);
        bos.setType(getBOSTokenType());
        return bos;
    }

    public static Eostoken createEOSToken(TextblocksFactory tbFactory, Version version) {
        Eostoken eos = tbFactory.createEostoken();
        TbVersionUtil.setVersion(eos, version);
        eos.setValue(EOS);
        eos.setType(getEOSTokenType());
        return eos;
    }

    public void setSource(AbstractToken startNode) {
        readToken = startNode;
    }

    /**
     * This is the main method of the incremental lexer. It should be called whenever changes were made to the textblocks model so
     * that tokens changed their values or were deleted. It operates on the {@link Version#PREVIOUS} version of the
     * <code>root</code> text block.
     * 
     * @param root
     *            the root Textblock of the document that should be lexed
     * @return <code>true</code> if lexing was successful, <code>false</code> else
     */
    public boolean lex(TextBlock root) {
        changedBlocks.clear();
        // get EOS and BOS from root block
        setEOSFromRoot(root);
        setBOSFromRoot(root);
        // Ensure correct version to work with;
        root = getOtherVersion(root, Version.PREVIOUS);

        if (root == null) {
            // no previous version there, this means no changes made
            // so return successfully!
            return true;
        }

        boolean success = false;
        try {
            // mark real changes
            applyMarking(root);
            // lex all changed tokens,
            success = lexPhase(root);
            // textBlock hierarchy not changed, textBlock token contents updated
            if (success) {
                updateLookbacks(root);
            }
        } catch (RuntimeException ex) {
            success = false;
            TextBlock referenceVersion = getOtherVersion(root, Version.REFERENCE);
            TextBlock previousVersion = getOtherVersion(root, Version.PREVIOUS);
            TextBlock currentVersion = getOtherVersion(root, Version.CURRENT);
            Activator
                    .logError("Unexpected Exception during incremental lexing! Check the following exception:\n"
                            + "Reference Block:\n" + referenceVersion == null ? "<none>"
                            : TbDebugUtil.getTextBlockAsAnnotatedString(referenceVersion) + "\n\nPrevious Block:\n"
                                    + previousVersion == null ? "<none>"
                                    : TbDebugUtil.getTextBlockAsAnnotatedString(previousVersion) + "\n\nCurrent Block:\n"
                                            + currentVersion == null ? "<none>" : TbDebugUtil
                                            .getTextBlockAsAnnotatedString(currentVersion));
            Activator.logError(ex);
            throw ex;

        } finally {
            if (!success) {
                // lexing didn't work so go back to previous version. It should not have been affected.
                TbChangeUtil.revertToVersion(root, Version.PREVIOUS);
            }
        }
        return success;
    }

    /**
     * Proceed to the next token of the given <code>version</code>.
     * 
     * @param token
     * @param version
     * @return
     */
    protected static AbstractToken nextToken(AbstractToken token, Version version) {
        return TbNavigationUtil.nextToken(getOtherVersion(token, version));
    }

    protected static AbstractToken previousToken(AbstractToken tok, Version version) {
        return TbNavigationUtil.previousToken(getOtherVersion(tok, version));
    }

    /**
     * Returns the first token of the subtree.
     * 
     * @param node
     * @param version
     * @return
     */
    private static AbstractToken firstToken(DocumentNode node, Version version) {
        node = getOtherVersion(node, version);
        return TbNavigationUtil.firstToken(node);
    }

    /**
     * Starts the marking phase.
     * 
     * @param node
     */
    private void applyMarking(DocumentNode node) {
        DocumentNode r = node;
        if (isToken(node)) {
            if (lexemeChanged((AbstractToken) r)) {
                markFrom((AbstractToken) node); // Handle textual changes.
            }
        } else {
            TextBlock tb = (TextBlock) node;
            // Handle structural changes.
            List<? extends DocumentNode> previousVersionSubNodes = getSubNodes(tb);
            if (hasChildChanges(tb, Version.REFERENCE)) {
                TextBlock referenceVersionTb = getOtherVersion(tb, Version.REFERENCE);
                List<? extends DocumentNode> referenceVersionSubNodes = getSubNodes(referenceVersionTb);

                for (int iPrevious = 0, iReference = 0; iPrevious < previousVersionSubNodes.size()
                        || iReference < referenceVersionSubNodes.size();) {
                    DocumentNode previousVersionNode = null;
                    DocumentNode referenceVersionNode = null;
                    if (iPrevious < previousVersionSubNodes.size()) {
                        previousVersionNode = previousVersionSubNodes.get(iPrevious);
                    }
                    if (iReference < referenceVersionSubNodes.size()) {
                        referenceVersionNode = referenceVersionSubNodes.get(iReference);
                    }

                    if (previousVersionNode != null && getOtherVersion(previousVersionNode, Version.REFERENCE) == null) {
                        // new node created

                        // Mark first token not earlier than the leading edge of
                        // the original subtree.
                        markFrom(tokenBefore(previousVersionNode, Version.PREVIOUS));
                        // Mark first token after the original subtree.
                        markFrom(firstTokenAfter(previousVersionNode, Version.PREVIOUS));
                        iPrevious++;
                    }
                    if (referenceVersionNode != null && getOtherVersion(referenceVersionNode, Version.PREVIOUS) == null) {
                        // node deleted

                        // Mark first token not earlier than the leading edge of
                        // the original subtree.
                        AbstractToken tokenBefore = tokenBefore(referenceVersionNode, Version.REFERENCE);
                        if (tokenBefore != null && existsInVersion(tokenBefore, Version.PREVIOUS)) {
                            // always mark the PREVIOUS Version
                            markFrom(getOtherVersion(tokenBefore, Version.PREVIOUS));
                        }
                        // Mark first token after the original subtree.
                        AbstractToken firstTokenAfter = firstTokenAfter(referenceVersionNode, Version.REFERENCE);
                        if (firstTokenAfter != null && existsInVersion(firstTokenAfter, Version.PREVIOUS)) {
                            // always mark the PREVIOUS Version
                            markFrom(getOtherVersion(firstTokenAfter, Version.PREVIOUS));
                        }
                        iReference++;
                    } else {
                        iReference++;
                        iPrevious++;
                    }
                }
            }
            // Recursively process any edits within this subtree.
            /*
             * TODO changed from original:REFERENCE check if this is still correct
             */
            if (hasNestedChanges(tb, Version.PREVIOUS)) {
                for (int i = 0; i < previousVersionSubNodes.size(); i++) {
                    applyMarking(previousVersionSubNodes.get(i));
                }
            }
        }
    }

    /**
     * Retrieves to token that is just in front of the given subtree/token
     * 
     * @param referenceVersionNode
     * @param reference
     * @return
     */
    private static AbstractToken tokenBefore(DocumentNode referenceVersionNode, Version version) {
        if (isToken(referenceVersionNode)) {
            return TbNavigationUtil.previousToken((AbstractToken) referenceVersionNode);
        } else {
            return TbNavigationUtil.previousToken(firstToken(referenceVersionNode, version));
        }
    }

    private boolean lexemeChanged(AbstractToken r) {
        AbstractToken previousVersion = getOtherVersion(r, Version.PREVIOUS);
        if (previousVersion == null) {
            // No previous version exists, which means token was not changed
            return false;
        }
        String r1Text = asString(previousVersion);
        AbstractToken referenceVersion = getOtherVersion(r, Version.REFERENCE);
        if (referenceVersion == null) {
            // no reference Version exists, so token was newly created for
            // PREVIOUS (only happens on token gaps)
            return true;
        }
        String r2Text = asString(referenceVersion);
        if (r1Text != null) {
            return !r1Text.equals(r2Text);
        } else {
            return r2Text != null;
        }
    }

    /**
     * Ensure that we have a valid state to re-start the lexer here. This backup occurs in the current tree.
     */
    private void ensureStartable(AbstractToken tok) {
        if (tok instanceof Bostoken || tok instanceof Eostoken) {
            // There is nothing before the BOS or EOS Token so
            // nothing needs to be marked in front of it
            return;
        }
        for (AbstractToken prev = TbNavigationUtil.previousToken(tok); !isStartable(prev) && !marked(prev); prev = TbNavigationUtil
                .previousToken(prev)) {
            mark(prev);
        }
    }

    private boolean isStartable(AbstractToken tok2) {
        // TODO check the actual criterion for this
        return true;
    }

    /**
     * Begin incrementally lexing a new region starting at tok.
     */
    private void setupForFirstToken(AbstractToken tok) {
        readToken = constructionToken = tok;
        constructionOffset = readOffset = 0;
        readLoc = new TokenLocation(readToken, readOffset);
        this.constructionLoc = new TokenLocation(constructionToken, constructionOffset);
        tokenList = new ArrayList<AbstractToken>();
    }

    /**
     * Return the next re-lexed token. TODO: check whether tokens from the previous or reference version can be re-used.
     */
    private AbstractToken nextNewToken() {
        if (tokenList.isEmpty()) {
            tokenList.addAll(getBatchLexer().moreTokens());
        }
        for (AbstractToken tok : tokenList) {
            // as index() only returned a position relative to the last
            // construction token
            // we need to fix this here before returning the token
            tok.setOffset(tok.getOffset() + TbUtil.getAbsoluteOffset(getConstructionLoc().getTok()));
            advance(asString(tok).length());
            tok.setLookahead(deltaInChars(readLoc, getConstructionLoc()));
        }
        return tokenList.remove(0);
    }

    /**
     * Sets the new start position from where to start lexing the next token by advancing in the document tree by
     * <code>length</code>.
     * 
     * @param constructionLoc
     * @param length
     */
    private void advance(int length) {
        while (getConstructionLoc().getOffset() + length > asString(getConstructionLoc().getTok()).length()) {
            length = length - asString(getConstructionLoc().getTok()).length() + getConstructionLoc().getOffset();
            getConstructionLoc().setTok(nextToken(getConstructionLoc().getTok(), Version.PREVIOUS));
            getConstructionLoc().setOffset(0);
            if (isEOS(getConstructionLoc().getTok())) {
                return;
            }
        }
        getConstructionLoc().setOffset(getConstructionLoc().getOffset() + length);
    }

    protected String getSynchronizedValue(AbstractToken candidate) {
        String candidateValue = candidate.getValue();
        if (candidateValue == null) {
            candidateValue = shortPrettyPrinter.resynchronizeToEditableState(candidate);
        }
        return candidateValue;
    }

    /**
     * Restore consistency to the entire token stream.
     * 
     * @return <code>true</code> if lexing happened without errors, <code>false</code> else.
     */
    private boolean lexPhase(TextBlock root) {
        // first create a new version of the tree
        // TODO: this should be enhanced by only creating new versions of
        // changed regions and re-using the old untouched rest.

        TextBlock currentRoot = getOtherVersion(root, Version.CURRENT);
        if (currentRoot == null) {
            currentRoot = (TextBlock) TbUtil.createNewCopy(root, Version.CURRENT, true, shortPrettyPrinter);
        } else {
            // TODO fix possibly incomplete textblocks to be able to reuse or
            // recreate them for current version
            TbChangeUtil.revertToVersion(root, Version.PREVIOUS);
            currentRoot = (TextBlock) TbUtil.createNewCopy(root, Version.CURRENT, true, shortPrettyPrinter);
        }
        for (AbstractToken tok = findNextRegion(root); !isEOS(tok);
        // as we are now at the right edge of the last section we need to go to
        // the next token
        // of the current version and then back to the previous version to find
        // the next changed region
        tok = isEOS(tok) ? tok : findNextRegion(getOtherVersion(nextToken(tok, Version.CURRENT), Version.PREVIOUS))) {
            TextBlock previousParentBlock = tok.getParent();
            TextBlock currentTextBlock = getCurrentVersion(previousParentBlock);
            changedBlocks.add(currentTextBlock);

            // remove old token from current textblock it will be replaced by
            // newly lexed tokens

            AbstractToken oldTokenInCurrentBlock = getOtherVersion(tok, Version.CURRENT);
            int index = currentTextBlock.getSubNodes().indexOf(oldTokenInCurrentBlock);

            // fetch newly lexed token
            setupForFirstToken(tok);
            tok = nextNewToken();

            while (!canStopLexing(tok)) {
                addTokenIfNecessaryAndUpdateOffetsAndLengths(tok, currentTextBlock, index++);
                makeOffsetRelativeToBlock(tok, tok.getParent());
                
                // move to next new token
                tok = nextNewToken();
      
                // if lexing proceeded to next previous-version token switch
                // to this one in current version as well and delete all CURRENT tokens that were
                // read over during lexing
                for (AbstractToken remainingToken : removeAllOutdatedTokensFromCurrentVersion(oldTokenInCurrentBlock)) {
                    oldTokenInCurrentBlock = remainingToken;
                    if (!oldTokenInCurrentBlock.getParent().equals(currentTextBlock)) {
                        currentTextBlock = oldTokenInCurrentBlock.getParent();
                        changedBlocks.add(currentTextBlock);
                        index = currentTextBlock.getSubNodes().indexOf(oldTokenInCurrentBlock);
                    }
                }
            }
            if (!tok.isOffsetRelative()) {
                makeOffsetRelativeToBlock(tok, currentTextBlock);
            }
            // delete old current version token as it won't be deleted in the
            // cleanup due to its "current" version status
            if (oldTokenInCurrentBlock instanceof Eostoken && !wasReUsed(oldTokenInCurrentBlock)) {
                TbChangeUtil.delete(oldTokenInCurrentBlock);
            }

        }
        // Adds EOS token if missing fro mnew copy: TODO When and why would we
        // ever expect this to happen?
        if (!(currentRoot.getSubNodes().get(currentRoot.getSubNodes().size() - 1) instanceof Eostoken)) {
            AbstractToken eosTok = createEOSToken(textblocksFactory, Version.CURRENT);
            eosTok.setOffset(currentRoot.getLength());
            eosTok.setOffsetRelative(true);

            currentRoot.getSubNodes().add(eosTok);
        }
        // If a token was (re-)moved because it's lexeme was joined with another
        // token of
        // another textblock the textblocks length and offset might need to be
        // udpated.
        for (TextBlock tb : changedBlocks) {
            TbChangeUtil.updateBlockLength(tb);
        }
        if (!batchLexer.hasErrors()) {
            for (TextBlock tb : changedBlocks) {
                TbValidationUtil.assertTextBlockConsistencyRecursive(tb);
            }
            return true;
        } else {
            return false;
        }
    }

    private void makeOffsetRelativeToBlock(AbstractToken tok, TextBlock currentTextBlock) {
        // make offset relative to textblock
        // currently it is relative to the offset of the previous
        // version of this token
        tok.setOffset(tok.getOffset() - TbUtil.getAbsoluteOffset(currentTextBlock));
        if (tok.getOffset() < 0 && !tok.isOffsetRelative()) {
            // this may happen if a token gets merged into a subblock
            // then it is always the first token and we need to adapt
            // the offset of the block and all other tokens of the block
            currentTextBlock.setOffset(currentTextBlock.getOffset() + tok.getOffset());
            TbChangeUtil.updateOffsetsWithinTextBlock(tok, tok.getOffset());
            tok.setOffset(0);
        }
        tok.setOffsetRelative(true);
    }

    private void addTokenIfNecessaryAndUpdateOffetsAndLengths(AbstractToken tok, TextBlock currentTextBlock, int index) {
        // add new tokens at position of oldTokens
        // if the token is re-used it has to be first
        // extracted from its original parent
        if (tok.getParent() != null) {
            // if the original parent was a direct or indirect child of the
            // current node it can be left there
            if (!(TbUtil.isAncestorOf(currentTextBlock, tok.getParent()) || currentTextBlock.equals(tok.getParent()))) {
                tok.setParent(null);
                currentTextBlock.getSubNodes().add(index, tok);
                TbChangeUtil.updateLengthAscending(currentTextBlock, tok.getLength());
                TbChangeUtil.updateOffsets(tok, tok.getLength());
                // increment so that next new tokens will be added behind
                // this new one
            } else {
                int lengthDiff = tok.getLength() - getOtherVersion(tok, Version.PREVIOUS).getLength();
                TbChangeUtil.updateLengthAscending(tok.getParent(), lengthDiff);
                TbChangeUtil.updateOffsets(tok, lengthDiff);
            }
        } else {
            currentTextBlock.getSubNodes().add(index, tok);
            TbChangeUtil.updateLengthAscending(currentTextBlock, tok.getLength());
            TbChangeUtil.updateOffsets(tok, tok.getLength());
            // increment so that next new tokens will be added behind
            // this new one
        }
    }

    /**
     * Removes all tokens from the CURRENT model which are outdated because new versions have been instantiated for them. TODO:
     * Note that this is done because the original CURRENT version was produced using a copy of the PREVIOUS version. If a more
     * selective versioning is used this needs to be changed/or removed.
     * 
     * @return remaining tokens
     */
    private Collection<AbstractToken> removeAllOutdatedTokensFromCurrentVersion(AbstractToken oldTokenInCurrentBlock) {
        AbstractToken constructionLocToken = getOtherVersion(getConstructionLoc().getTok(), Version.CURRENT);
        AbstractToken currentToken = oldTokenInCurrentBlock;
        
        while (!currentToken.equals(constructionLocToken)) {
            AbstractToken deleteToken = currentToken;
            // need to navigate using previous version because current might
            // have already been disconnected from the tree
            currentToken = navigateToNextCURRENTTokenUsingPreviousVersion(currentToken);

            // the token may have been re-used but only when the lexer didn't
            // "read over" it.
            // Read over is the case when the token is before the current
            // constructionLocation
            if (!wasReUsed(deleteToken)) {
                TextBlock deleteTokenParent = deleteToken.getParent();

                TbChangeUtil.updateLengthAscending(deleteTokenParent, -deleteToken.getLength());
                if (TbNavigationUtil.isFirstInSubTree(currentToken)) {
                    currentToken.getParent().setOffset(currentToken.getParent().getOffset() - deleteToken.getLength());
                    TbChangeUtil.updateOffsets(currentToken.getParent(), -deleteToken.getLength());
                } else {
                    TbChangeUtil.updateOffsets(currentToken, -deleteToken.getLength());
                }

                TbChangeUtil.delete(deleteToken);
                if (TbNavigationUtil.getSubNodesSize(deleteTokenParent) == 0) {
                    changedBlocks.remove(deleteTokenParent);
                    TbChangeUtil.delete(deleteTokenParent);
                }
            }
        }
        return Collections.singleton(currentToken);
    }

    protected abstract boolean wasReUsed(AbstractToken deleteToken);

    private static AbstractToken navigateToNextCURRENTTokenUsingPreviousVersion(AbstractToken oldTokenInCurrentBlock) {
        oldTokenInCurrentBlock = TbNavigationUtil.nextToken(getOtherVersion(oldTokenInCurrentBlock, Version.PREVIOUS));
        // now the current version again
        oldTokenInCurrentBlock = getOtherVersion(oldTokenInCurrentBlock, Version.CURRENT);
        return oldTokenInCurrentBlock;
    }

    /**
     * Gets or creates the {@link Version#CURRENT} version of the Textblock.
     */
    private TextBlock getCurrentVersion(TextBlock tb) {
        TextBlock currentVersion = getOtherVersion(tb, Version.CURRENT);
        if (currentVersion == null) {
            currentVersion = textblocksFactory.createTextBlock();
            tb.eResource().getContents().add(currentVersion);
            currentVersion.setVersion(Version.CURRENT);
            TbUtil.referenceVersions(currentVersion, tb);
            if (tb.getParent() == null) {
                // If its the root block then add also the BOS token
                currentVersion.getSubNodes().add(createBOSToken(textblocksFactory, Version.CURRENT));
            }
            // also copy cached string represenation
            currentVersion.setCachedString(tb.getCachedString());
        }
        return currentVersion;
    }

    /**
     * Determine when previous and current token streams merge again.
     */
    private boolean canStopLexing(AbstractToken tok) {
        if (isEOS(tok)) {
            return true;
        } 
        if (tok.getParent() == null) {
            return false; // need one more iteration to add.
        }
        boolean atEndOfConstruction = getConstructionLoc().getOffset() == getConstructionLoc().getTok().getLength();
        boolean notMarked = !marked(getConstructionLoc().getTok());
        return tokenList.isEmpty() && atEndOfConstruction && notMarked && isStartable(tok);
    }

    /**
     * Updates all token lookback counts after re-lexing.
     * 
     * @param root
     */
    private void updateLookbacks(TextBlock root) {
        // Ensure to work on current version;
        DocumentNode node = getOtherVersion(root, Version.CURRENT);
        while (node != null && !isEOS(node)) {
            if (isToken(node)) {
                AbstractToken tok = (AbstractToken) node;
                if (wasReLexed(tok)) {
                    node = fixLookbacks(tok);
                } else {
                    node = nextSubtree(tok);
                }
            } else if (hasNestedChanges((TextBlock) node, Version.PREVIOUS)) {
                // Which
                // version?
                node = getSubNodeAt(((TextBlock) node), 0);
            } else {
                node = nextSubtree(node);
            }
        }
    }

    /**
     * Process a re-lexed region starting at tok.
     */
    private AbstractToken fixLookbacks(AbstractToken tok) {
        LookAheadSet laSet = new LookAheadSet();
        if (!isBOS(tok)) {
            // Extract lookback count (if different in current version, use old
            // value).
            int lb = nextToken(TbNavigationUtil.previousToken(tok), Version.REFERENCE).getLookback();
            AbstractToken bootTok = tok;
            while (lb-- > 0
                    && tokensConverge(getOtherVersion(TbNavigationUtil.previousToken(bootTok), Version.REFERENCE),
                            getOtherVersion(TbNavigationUtil.previousToken(bootTok), Version.PREVIOUS))
                    && !wasReLexed(TbNavigationUtil.previousToken(bootTok))) {
                bootTok = TbNavigationUtil.previousToken(bootTok);
            }
            // Initialize the lookahead set from the bootstrap region.
            while (bootTok != tok) {
                laSet.advance(bootTok.getLength());
                laSet.addItem(bootTok);
                bootTok = TbNavigationUtil.nextToken(bootTok);
            }
        }
        do {
            // Set the lookback for re-lexed tokens.
            while (wasReLexed(tok)) {
                tok.setLookback(laSet.computeLookback());
                laSet.advance(asString(tok).length());
                laSet.addItem(tok);
                tok = TbNavigationUtil.nextToken(tok);
            }
            // Symmetric to bootstrap: process unmodified tokens reached by
            // lookahead from re-lexed area.
            while (!isEOS(tok) && !wasReLexed(tok) && !laSet.allItemsDiscardable()
                    && tok.getLookback() != laSet.computeLookback()) {
                tok.setLookback(laSet.computeLookback());
                laSet.advance(tok.getLength());
                laSet.addItem(tok);
                tok = TbNavigationUtil.nextToken(tok);
            }
        } while (wasReLexed(tok));
        return tok; // Return first clean token or eos to caller.
    }

    /**
     * Checks whether two tokens correspond to each other in the token stream. This is the case when they are linked as versions
     * to each other and additionally there lexeme is still the same.
     * 
     * @param t1
     * @param t2
     * @return
     */
    private boolean tokensConverge(AbstractToken t1, AbstractToken t2) {
        return t1.getOtherVersions().contains(t2) && getSynchronizedValue(t1).equals(getSynchronizedValue(t2));
    }

    /**
     * Retrieves the first token of the next subtree of the <code>oldChild</code>'s subtree.
     * 
     * @param oldChild
     * @param version
     * @return
     */
    private AbstractToken firstTokenAfter(DocumentNode oldChild, Version version) {
        oldChild = getOtherVersion(oldChild, version);
        if (isEOS(oldChild)) {
            return (AbstractToken) oldChild;
        }
        oldChild = firstToken(nextSubtree(oldChild), version);
        // while (!isToken(oldChild)) {
        // oldChild = getSubNodes(((TextBlock) oldChild))
        // .get(0);
        // }
        return (AbstractToken) oldChild;
    }

    private static boolean existsInVersion(AbstractToken tok, Version v) {
        return tok.getVersion().equals(v) || getOtherVersion(tok, v) != null;
    }

    /**
     * Explicitly mark tokens dependent upon tok for re-lexing. This backup occurs in the last-lexed tree.
     */
    private void markFrom(AbstractToken tok) {
        if (!existsInVersion(tok, Version.PREVIOUS)) {
            // || !existsInVersion(tok, Version.REFERENCE))
            return;
        }
        mark(tok);
        ensureStartable(tok);
        // Check everything in its lookback set.
        for (int ov = tok.getLookback(); ov > 0; --ov) {
            tok = previousToken(tok, Version.PREVIOUS);
            if (isBOS(tok)) {
                return;
            }
            if (!existsInVersion(tok, Version.PREVIOUS)/* see above */
                    || marked(tok)) {
                continue;
            }
            mark(tok);
            ensureStartable(tok);
        }
    }

    /**
     * Needs to be overwritten by parser specific subclass to be able to extract lexeme from parser specific token represntations.
     * 
     * @param token
     * @return
     */
    protected abstract String asString(AbstractToken token);

    public TokenLocation getConstructionLoc() {
        return constructionLoc;
    }

    public AbstractToken getReadToken() {
        return readToken;
    }

    public TokenLocation getReadLoc() {
        return readLoc;
    }

}
