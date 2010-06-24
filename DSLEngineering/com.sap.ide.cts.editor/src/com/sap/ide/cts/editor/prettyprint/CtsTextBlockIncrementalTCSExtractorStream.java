package com.sap.ide.cts.editor.prettyprint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;

import tcs.ClassTemplate;
import tcs.ContextTemplate;
import tcs.SequenceElement;
import tcs.Template;
import textblockdefinition.TextBlockDefinition;
import textblocks.AbstractToken;
import textblocks.Bostoken;
import textblocks.Eostoken;
import textblocks.LexedToken;
import textblocks.OmittedToken;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;
import textblocks.VersionEnum;

import com.sap.ide.cts.editor.contentassist.TcsDebugUtil;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbMarkingUtil;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * 
 * @author Andreas Landerer
 * 
 */
public class CtsTextBlockIncrementalTCSExtractorStream implements TCSExtractorStream {

    private static boolean debug = false;
    private int textBlocksHandleCounter = 0;
    private Stack<Integer> openTextBlocksHandles = new Stack<Integer>();
    private TextBlock oldTextBlock = null;
    private ClassTemplate templateForOldTextBlock = null;
    private List<TextBlockCommand> current = new ArrayList<TextBlockCommand>();
    private Map<Integer, List<TextBlockCommand>> backup = new HashMap<Integer, List<TextBlockCommand>>();
    private int curBackupHandle = 0;
    private Stack<SequenceElement> currentSE = new Stack<SequenceElement>();
    private Map<TextBlock, Template> blockToTemplate = new HashMap<TextBlock, Template>();
    private boolean formatMode = true;
    private TextblocksPackage pack = null;
    private ModelPartition part = null;
    private TextBlock rootBlock = null;
    private TextBlock curBlock = null;
    private int curOffset = 0;
    private int curBlockLength = 0;
    StringBuffer rootBlockCachedString = new StringBuffer();
    private final Lexer lexer;
    private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> pFactory;

    interface TextBlockCommand {
	void execute();
    }

    class AddNextTextBlockCommand implements TextBlockCommand {
	private TextBlock textblock;
	private RefObject object;
	private Template t;
	private SequenceElement se;
	private int handle;

	public AddNextTextBlockCommand(RefObject object, Template t, SequenceElement se, int handle) {
	    this.object = object;
	    this.t = t;
	    this.se = se;
	    this.handle = handle;
	}

	public AddNextTextBlockCommand(TextBlock textblock, RefObject object, Template t, SequenceElement se, int handle) {
	    this(object, t, se, handle);
	    this.textblock = textblock;
	}

	public void execute() {
	    if (this.textblock != null) {
		addNextTextBlock(this.textblock, object, t, se, handle);
	    } else {
		addNextTextBlock(null, object, t, se, handle);
	    }
	}
    }

    class FinishTextBlockCommand implements TextBlockCommand {
	private int handle;

	public FinishTextBlockCommand(int handle) {
	    this.handle = handle;
	}

	public void execute() {
	    finishTextBlock(handle);
	}
    }

    class AddNextTokenCommand implements TextBlockCommand {
	private String s;
	private SequenceElement se;
	private AbstractToken token;

	public AddNextTokenCommand(String s, SequenceElement se) {
	    this.s = s;
	    this.se = se;
	}

	public AddNextTokenCommand(AbstractToken token) {
	    this(token.getValue(), null);
	    this.token = token;
	}

	public void execute() {
	    if (this.token == null) {
		addNextToken(s, se);
	    } else {
		addNextToken(this.token);
	    }
	}
    }

    public CtsTextBlockIncrementalTCSExtractorStream(TextblocksPackage pack, ModelPartition partitionForTextBlocks,
	    AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory, boolean formatMode) {
	this.pack = pack;
	part = partitionForTextBlocks;
	this.lexer = parserFactory.createLexer(null);
	this.pFactory = parserFactory;
	this.formatMode = formatMode;
    }

    public TextBlock getRootBlock() {
	return rootBlock;
    }

    TextBlock createTextBlock() {
	TextBlock b = (TextBlock) pack.getTextBlock().refCreateInstanceInPartition(part);
	b.setChildrenChanged(false);
	b.setVersion(VersionEnum.REFERENCE);
	b.setRelexingNeeded(false);
	b.setStartRow(0);
	b.setStartColumn(0);
	b.setEndRow(0);
	b.setEndColumn(0);
	b.setOffset(0);
	b.setLength(0);
	b.setOffsetRelative(true);
	b.setComplete(true);
	b.setCachedString("");
	return b;
    }

    LexedToken createLexedToken(SequenceElement se) {
	// TODO compute lookahead and lookback using lexer!
	LexedToken t = (LexedToken) pack.getLexedToken().refCreateInstanceInPartition(part);
	t.setChildrenChanged(false);
	t.setVersion(VersionEnum.REFERENCE);
	t.setRelexingNeeded(false);
	t.setStartRow(0);
	t.setStartColumn(0);
	t.setEndRow(0);
	t.setEndColumn(0);
	t.setOffset(0);
	t.setLength(0);
	t.setOffsetRelative(true);
	t.setValue("");
	t.setLookahead(2);
	t.setLookback(2);
	t.setState(0);
	t.setType(0);
	t.setSequenceElement(se);
	return t;
    }

    OmittedToken createOmittedToken() {
	// TODO compute lookahead and lookback using lexer!
	OmittedToken t = (OmittedToken) pack.getOmittedToken().refCreateInstanceInPartition(part);
	t.setChildrenChanged(false);
	t.setVersion(VersionEnum.REFERENCE);
	t.setRelexingNeeded(false);
	t.setStartRow(0);
	t.setStartColumn(0);
	t.setEndRow(0);
	t.setEndColumn(0);
	t.setOffset(0);
	t.setLength(0);
	t.setOffsetRelative(true);
	t.setValue("");
	t.setLookahead(2);
	t.setLookback(2);
	t.setState(0);
	t.setType(0);
	return t;
    }

    void addNextTextBlock(TextBlock oldTb, RefObject correspondingModelElement, Template template, SequenceElement se, int handle) {
	if (debug) {
	    System.out.println("adding TextBlock for template " + TcsDebugUtil.prettyPrint(template) + " with handle: " + handle);
	}

	openTextBlocksHandles.add(handle);

	if (rootBlock == null) {
	    // first textBlock, special rootBlock handling
	    if (oldTb == null) {
		rootBlock = createTextBlock();
	    } else {
		rootBlock = oldTb;
	    }
	    setType(rootBlock, template);
	    rootBlock.setOffsetRelative(false);
	    if (correspondingModelElement != null) {
		if (TcsUtil.isPropertyInit(se)) {
		    // Add to referenced element if its a Property Init
		    rootBlock.getReferencedElements().add(correspondingModelElement);
		} else {
		    rootBlock.getCorrespondingModelElements().add(correspondingModelElement);
		}
	    }
	    rootBlock.setSequenceElement(se);
	    curBlock = rootBlock;

	    if (debug) {
		System.out.println("adding BosToken");
	    }
	    if (template instanceof ClassTemplate) {
		if (((ClassTemplate) template).isMain()) {
		    addBosToken();
		}
	    } else if (template == null && oldTb == null) {
		if (curBlock.getParentBlock() == null) {
		    addBosToken();
		}
	    }
	} else {
	    // not the rootBlock

	    // backup curBlockLenght in curBlock.length
	    curBlock.setLength(curBlockLength);
	    TextBlock b;
	    if (oldTb == null) {
		b = createTextBlock();
	    } else {
		b = oldTb;
	    }
	    b.setOffset(curOffset);

	    if (correspondingModelElement != null) {
		if (TcsUtil.isPropertyInit(se)) {
		    // Add to referenced element if its a Property Init
		    b.getReferencedElements().add(correspondingModelElement);
		} else {
		    b.getCorrespondingModelElements().add(correspondingModelElement);
		}
	    }
	    b.setSequenceElement(se);
	    setType(b, template);
	    addTextBlock(b);
	}

	// save Template for later use
	blockToTemplate.put(curBlock, template);
    }

    private void setType(TextBlock block, Template template) {
	if (template != null) {
	    TextBlockDefinition tbDef = pack.getTextblockdefinition().getTextblockDefinitionReferencesProduction()
		    .getTextBlockDefinition(template).iterator().next();
	    block.setType(tbDef);
	}
    }

    void addTextBlock(TextBlock b) {
	assert b.getParentBlock() == null;
	curBlock.getSubBlocks().add(b);
	curOffset = 0;
	curBlockLength = 0;
	curBlock = b;
    }

    void finishTextBlock(int handle) {
	if (debug) {
	    System.out.println("finishing TextBlock with handle: " + handle);
	}

	while (openTextBlocksHandles.size() > 0 && openTextBlocksHandles.peek() != handle) {
	    // calls to addTextBlock and finishTextBlock do not match
	    // last textblock was falsely left open

	    // gracefully close it
	    if (debug) {
		System.out.println("closing left-open TextBlock with handle: " + openTextBlocksHandles.peek());
	    }
	    finishTextBlock(openTextBlocksHandles.peek());
	}
	if (openTextBlocksHandles.size() > 0) {
	    openTextBlocksHandles.pop();
	}

	curBlock.setLength(curBlockLength);

	TextBlock parent = curBlock.getParentBlock();
	if (parent != null) {

	    if (curBlockLength == 0) {
		// this textblock is empty, remove it
		if (debug) {
		    System.out.println("removing empty TextBlock");
		}

		// handle this textblock's addToContext flag
		// addToContext only present on ClassTemplate
		// context can be present on ClassTemplate and OperatorTemplate
		Template t = getType(curBlock);
		if (t instanceof ClassTemplate) {
		    ClassTemplate ct = (ClassTemplate) t;
		    if (ct.isAddToContext()) {
			addToParentContext(curBlock);
		    }
		}

		curBlock.setParentBlock(null);
		List<RefObject> parentModelElements = parent.getCorrespondingModelElements();
		for (RefObject o : curBlock.getCorrespondingModelElements()) {
		    if (!parentModelElements.contains(o)) {
			parentModelElements.add(o);
		    }
		}

		Collection<RefObject> parentReferencedElements = parent.getReferencedElements();
		for (RefObject o : curBlock.getReferencedElements()) {
		    if (!parentReferencedElements.contains(o)) {
			parentReferencedElements.add(o);
		    }
		}
		curBlock.refDelete();
	    }

	    // restore curBlockLength from parent and curBlockLength
	    curBlockLength += parent.getLength();
	    // restore curOffset from curBlockLength
	    curOffset = curBlockLength;
	    curBlock = parent;
	} else {
	    // this is for the rootblock only
	    if (curBlock.getTokens().size() > 0 && curBlock.getTokens().get(0) instanceof Bostoken) {
		// Ensure that no lookback is set for the first token.
		// TODO: Currently
		// the lookback for tokens created by the Extractor is hard
		// coded to
		// 2 meaning that the first token wil lookback past the BOS
		// token resulting
		// in an error.
		AbstractToken firstTok = TbNavigationUtil.firstTokenWithoutBOS(curBlock);
		if (firstTok != null) {
		    firstTok.setLookback(0);
		}
	    }
	}
    }

    private Template getType(TextBlock block) {
	return blockToTemplate.get(block);
    }

    private void addToParentContext(TextBlock startBlock) {

	List<RefObject> modelElements = startBlock.getCorrespondingModelElements();

	TextBlock parentBlock = startBlock.getParentBlock();
	while (parentBlock != null) {
	    Template t = getType(parentBlock);

	    if (t instanceof ContextTemplate) {
		ContextTemplate ct = (ContextTemplate) t;
		if (ct.isContext()) {
		    parentBlock.getElementsInContext().addAll(modelElements);
		    return;
		}
	    }

	    parentBlock = parentBlock.getParentBlock();
	}

    }

    void addNextToken(AbstractToken token) {
	token.setOffset(curOffset);
	token.setLength(token.getValue().length());
	this.addToken(token);
	TbMarkingUtil.markTokenRelexed(token);
	rootBlockCachedString.append(token.getValue());
    }

    void addNextToken(String value, SequenceElement se) {
	if (value != null && !value.equals("")) {
	    AbstractToken t = null;
	    // TODO this is currentl needed as token types are stored in
	    // textblocks model
	    lexer.setCharStream(new ANTLRStringStream(value));
	    Token lexerToken = lexer.nextToken();

	    if (lexerToken.getChannel() == Token.HIDDEN_CHANNEL) {
		if (debug) {
		    System.out.println("adding OmittedToken: '" + value + "'");
		}
		t = createOmittedToken();
	    } else {
		if (debug) {
		    System.out.println("adding LexedToken: '" + value + "'");
		}
		t = createLexedToken(se);
	    }
	    t.setType(lexerToken.getType());
	    // end TODO

	    t.setValue(value);
	    t.setOffset(curOffset);
	    t.setLength(value.length());
	    addToken(t);

	    TbMarkingUtil.markTokenRelexed(t);

	    rootBlockCachedString.append(value);
	}
    }

    void addBosToken() {
	Bostoken bos = ANTLRIncrementalLexerAdapter.createBOSToken(pack, VersionEnum.REFERENCE,
		ANTLRIncrementalLexerAdapter.bosTokenType);
	addToken(bos);
    }

    void addEosToken() {
	if (this.rootBlock != null) {
	    for (AbstractToken token : this.rootBlock.getTokens()) {
		if (token instanceof Eostoken) {
		    return;
		}
	    }
	}
	Eostoken eos = ANTLRIncrementalLexerAdapter.createEOSToken(pack, VersionEnum.REFERENCE,
		ANTLRIncrementalLexerAdapter.eosTokenType);
	eos.setOffset(curOffset);
	addToken(eos);
    }

    void addToken(AbstractToken t) {
	curBlock.getTokens().add(t);
	curOffset += t.getLength();
	curBlockLength += t.getLength();
    }

    @Override
    public void close() {
	Collection<TextBlock> notReusedTextBlocks = tryToReuseOldTextBlockTree();
	for (TextBlock tb : notReusedTextBlocks) {
	    if (tb.is___Alive()) {
		tb.refDelete();
	    }
	}
	createTextBlockModel();
    }

    /**
     * Returns a list of blocks which could not be reused and are candidates for
     * removal.
     * 
     * @return
     */
    protected Collection<TextBlock> tryToReuseOldTextBlockTree() {
	if (this.oldTextBlock != null) {
	    return this.mergeTbs(this.oldTextBlock, 0);
	} else {
	    return Collections.emptyList();
	}
    }

    protected void createTextBlockModel() {
	// no more backtracking after this point
	// execute all textblock commands
	for (TextBlockCommand command : current) {
	    command.execute();
	}

	// finish rootBlock

	// check first if any output was printed
	if (rootBlock != null) {
	    if (debug) {
		System.out.println("adding EosToken");
	    }
	    Template template = this.blockToTemplate.get(rootBlock);
	    if (template instanceof ClassTemplate) {
		if (((ClassTemplate) template).isMain()) {
		    addEosToken();
		}
	    } else if (template == null) {
		if (rootBlock.getParentBlock() == null) {
		    addEosToken();
		}
	    }
	    TbValidationUtil.assertTextBlockConsistencyRecursive(rootBlock);
	    rootBlock.setCachedString(rootBlockCachedString.toString());
	}
    }

    protected Collection<TextBlock> mergeTbs(TextBlock textBlockToReuse, int depth) {
	Collection<TextBlock> textBlocksThatCouldNotYetBeReuse = new ArrayList<TextBlock>();
	AddNextTextBlockCommand newTbCmd = null;
	int indexOfCorrTbCmd = -1;

	Collection<TextBlock> subBlocksToReuse = new ArrayList<TextBlock>(textBlockToReuse.getSubBlocks());
	Collection<AbstractToken> tokensToReuse = new ArrayList<AbstractToken>(textBlockToReuse.getTokens());
	// Reuse this block in isolation.
	textBlockToReuse.setParentBlock(null);
	textBlockToReuse.getSubBlocks().clear();
	textBlockToReuse.getTokens().clear();

	for (TextBlock subBlock : subBlocksToReuse) {
	    textBlocksThatCouldNotYetBeReuse.addAll(this.mergeTbs(subBlock, depth + 1));
	}
	// The following is done buttom up. Meaning that the first time we leave
	// the loop
	// above we are in a leaf block.

	// check if corresponding ModelElement still exists
	outer: for (TextBlockCommand command : new ArrayList<TextBlockCommand>(this.current)) {
	    if (command instanceof AddNextTextBlockCommand) {
		AddNextTextBlockCommand tbCommand = (AddNextTextBlockCommand) command;
		for (RefObject correspondingModelElement : textBlockToReuse.getCorrespondingModelElements()) {
		    if (tbCommand.object.equals(correspondingModelElement)) {
			// replace new command by existing TextBlock
			indexOfCorrTbCmd = this.current.indexOf(tbCommand);
			newTbCmd = new AddNextTextBlockCommand(textBlockToReuse, tbCommand.object, tbCommand.t, tbCommand.se,
				tbCommand.handle);
			this.current.remove(indexOfCorrTbCmd);
			this.current.add(indexOfCorrTbCmd, newTbCmd);

			break outer; // FIXME: why is this needed?
		    }
		}
	    }
	}
	if (newTbCmd != null) {
	    TextBlockCommand lastCmdPreserved = null;

	    // check if there are any tokens that can be preserved
	    for (AbstractToken token : tokensToReuse) {
		if (token instanceof OmittedToken) {
		    if (!this.formatMode) {
			this.handleOmittedToken((OmittedToken) token, lastCmdPreserved, indexOfCorrTbCmd);
		    } else {
			this.handleOmittedTokenConservatively((OmittedToken) token, lastCmdPreserved, indexOfCorrTbCmd);
		    }
		}

		else if (token instanceof LexedToken) {
		    this.handleLexedToken((LexedToken) token, lastCmdPreserved, indexOfCorrTbCmd);
		}

	    }
	} else {
	    // Remove potentially listed children. If we reuse the parent we
	    // will be able to reuse-them along.
	    textBlocksThatCouldNotYetBeReuse.removeAll(subBlocksToReuse);
	    textBlocksThatCouldNotYetBeReuse.add(textBlockToReuse);
	}
	return textBlocksThatCouldNotYetBeReuse;
    }

    private boolean isOmittedTokenForFormatingPurpose(OmittedToken token) {
	for (Integer i : this.pFactory.getOmittedTokensForFormatting()) {
	    if (i.intValue() == token.getType()) {
		return true;
	    }
	}

	return false;
    }

    private void handleOmittedToken(OmittedToken token, TextBlockCommand lastCmdPreserved, int indexOfCorrTbCmd) {
	// if token is an OmittedToken it will be preserved only if it
	// has no formatting purpose and
	// if it is not a BosToken or an EosToken
	// preserved OmittedTokens are COMMENTS and MULTI_LINE_COMMENTS
	OmittedToken omittedToken = token;
	AddNextTokenCommand tokenCmd = null;
	if (!this.isOmittedTokenForFormatingPurpose(omittedToken)) {
	    if (!(token instanceof Bostoken) && !(token instanceof Eostoken)) {
		int index = 0;
		if (lastCmdPreserved != null) {
		    index = this.current.indexOf(lastCmdPreserved);
		} else {
		    index = indexOfCorrTbCmd;
		}
		tokenCmd = new AddNextTokenCommand(omittedToken.getValue(), null);
		this.current.add(index + 1, tokenCmd);
		AddNextTokenCommand tokenEOL = new AddNextTokenCommand("\n", null);
		this.current.add(index + 2, tokenEOL);
	    }
	}
	omittedToken.refDelete();
    }

    private void handleOmittedTokenConservatively(OmittedToken token, TextBlockCommand lastCmdPreserved, int indexOfCorrTbCmd) {
	OmittedToken omittedToken = token;
	AddNextTokenCommand tokenCmd = null;
	boolean otFound = false;
	for (TextBlockCommand command : this.current) {
	    if (command instanceof AddNextTokenCommand) {
		if (((AddNextTokenCommand) command).s.equals(token.getValue())) {
		    if (lastCmdPreserved != null && this.current.indexOf(command) > this.current.indexOf(lastCmdPreserved)) {
			AddNextTokenCommand newCommand = new AddNextTokenCommand(token);
			int index = this.current.indexOf(command);
			this.current.remove(index);
			this.current.add(index, newCommand);
			lastCmdPreserved = newCommand;
			otFound = true;
			break;
		    }
		}
	    }
	}
	if (!otFound) {
	    if (!this.isOmittedTokenForFormatingPurpose(omittedToken) && !(token instanceof Bostoken)
		    && !(token instanceof Eostoken)) {
		if (!this.isOmittedTokenForFormatingPurpose(omittedToken)) {
		    if (!(token instanceof Bostoken) && !(token instanceof Eostoken)) {
			int index = 0;
			if (lastCmdPreserved != null) {
			    index = this.current.indexOf(lastCmdPreserved);
			} else {
			    index = indexOfCorrTbCmd;
			}
			tokenCmd = new AddNextTokenCommand(omittedToken.getValue(), null);
			this.current.add(index + 1, tokenCmd);
			AddNextTokenCommand tokenEOL = new AddNextTokenCommand("\n", null);
			this.current.add(index + 2, tokenEOL);
			omittedToken.refDelete();
		    }
		}
	    } else {
		if (!(token instanceof Bostoken) && !(token instanceof Eostoken)) {
		    int index = 0;
		    if (lastCmdPreserved != null) {
			index = this.current.indexOf(lastCmdPreserved);
		    } else {
			index = indexOfCorrTbCmd;
		    }
		    tokenCmd = new AddNextTokenCommand(token);
		    this.current.add(index + 1, tokenCmd);
		} else {
		    token.refDelete();
		}
	    }
	}
    }

    private void handleLexedToken(LexedToken lexedToken, TextBlockCommand lastCmdPreserved, int indexOfCorrTbCmd) {
	// if token is a LexedToken it will be preserved if it exists in
	// both the old TextBlock and the
	// new CommandList
	AddNextTokenCommand tokenCmd = null;
	Stack<Integer> subBlocks = new Stack<Integer>();
	for (int i = indexOfCorrTbCmd + 1; i < this.current.size(); i++) {
	    TextBlockCommand tbCmd = this.current.get(i);
	    if (tbCmd instanceof AddNextTextBlockCommand) {
		subBlocks.push(((AddNextTextBlockCommand) tbCmd).handle);
	    }
	    if (tbCmd instanceof FinishTextBlockCommand) {
		AddNextTextBlockCommand tbStartCommand = (AddNextTextBlockCommand) this.current.get(indexOfCorrTbCmd);
		if (!subBlocks.isEmpty()) {
		    subBlocks.pop();
		}
		if (((FinishTextBlockCommand) tbCmd).handle == tbStartCommand.handle) {
		    break;
		}
	    }
	    if (tbCmd instanceof AddNextTokenCommand) {
		if (subBlocks.isEmpty()) {
		    AddNextTokenCommand currentTokenCmd = (AddNextTokenCommand) tbCmd;
		    if (lexedToken.getSequenceElement().equals(currentTokenCmd.se)
			    && lexedToken.getValue().equals(currentTokenCmd.s)) {
			tokenCmd = currentTokenCmd;
			break;
		    }
		}
	    }
	}
	if (tokenCmd == null) {
	    lexedToken.refDelete();
	} else {
	    int indexOfCorrTokenCmd = this.current.indexOf(tokenCmd);
	    this.current.remove(indexOfCorrTokenCmd);
	    tokenCmd = new AddNextTokenCommand(lexedToken);
	    this.current.add(indexOfCorrTokenCmd, tokenCmd);
	    lastCmdPreserved = tokenCmd;
	}
    }

    private SequenceElement getCurrentSE() {
	if (!currentSE.isEmpty()) {
	    return currentSE.peek();
	}

	return null;
    }

    @Override
    public int startClassTemplateForObject(RefObject object, Template t) {
	int handle = textBlocksHandleCounter++;
	current.add(new AddNextTextBlockCommand(object, t, getCurrentSE(), handle));
	return handle;
    }

    @Override
    public void endClassTemplate(int handle) {
	current.add(new FinishTextBlockCommand(handle));
    }

    @Override
    public void debug(String string) {
	current.add(new AddNextTokenCommand(string, getCurrentSE()));
    }

    @Override
    public void printBoolean(boolean v) {
	current.add(new AddNextTokenCommand("" + v, getCurrentSE()));
    }

    @Override
    public void printComment(String c) {
	current.add(new AddNextTokenCommand(c, getCurrentSE()));
    }

    @Override
    public void printEscapedIdentifier(String identEscStart, String ident, String identEscEnd) {
	current.add(new AddNextTokenCommand(identEscStart + ident + identEscEnd, getCurrentSE()));
    }

    @Override
    public void printIdentifier(String ident) {
	current.add(new AddNextTokenCommand(ident, getCurrentSE()));
    }

    @Override
    public void printInteger(int v) {
	current.add(new AddNextTokenCommand("" + v, getCurrentSE()));
    }

    @Override
    public void printKeyword(String keyword) {
	current.add(new AddNextTokenCommand(keyword, getCurrentSE()));
    }

    @Override
    public void printReal(String string) {
	current.add(new AddNextTokenCommand(string, getCurrentSE()));
    }

    @Override
    public void printString(String stringDelim, String v) {
	current.add(new AddNextTokenCommand(stringDelim + v + stringDelim, getCurrentSE()));
    }

    @Override
    public void printSymbol(String symbol) {
	current.add(new AddNextTokenCommand(symbol, getCurrentSE()));
    }

    @Override
    public void printWhiteSpace(String ws) {
	current.add(new AddNextTokenCommand(ws, getCurrentSE()));
    }

    @Override
    public int createSafePoint() {
	List<TextBlockCommand> store = new ArrayList<TextBlockCommand>(current);
	curBackupHandle++;

	if (debug) {
	    System.out.println("creating savepoint " + curBackupHandle + " with " + store.size() + " commands saved");
	}

	backup.put(curBackupHandle, store);
	return curBackupHandle;
    }

    @Override
    public void resetToSafePoint(int handle) {
	current = backup.get(handle);

	if (debug) {
	    System.out.println("resetting to savepoint " + handle + " with " + current.size() + " commands restored");
	}

    }

    @Override
    public void enterSequenceElement(SequenceElement e) {
	currentSE.push(e);

    }

    @Override
    public void exitSequenceElement() {
	currentSE.pop();

    }

    public TextBlock getOldTextBlock() {
	return oldTextBlock;
    }

    public void setOldTextBlock(TextBlock oldTextBlock) {
	this.oldTextBlock = oldTextBlock;
    }

    public ClassTemplate getTemplateForOldTextBlock() {
	return templateForOldTextBlock;
    }

    public void setTemplateForOldTextBlock(ClassTemplate templateForOldTextBlock) {
	this.templateForOldTextBlock = templateForOldTextBlock;
    }

    @Override
    public void printDefault(String value) {
	current.add(new AddNextTokenCommand(value, getCurrentSE()));
    }
}
