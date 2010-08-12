package com.sap.ide.cts.editor.prettyprint.textblocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;

import tcs.Alternative;
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
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockCommands.AddNextTextBlockCommand;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockCommands.AddNextTokenCommand;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockCommands.BeginAlternativeChoiceCommand;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockCommands.EnterAlternativeMarkerCommand;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockCommands.ExitAlternativeMarkerCommand;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockCommands.FinishTextBlockCommand;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockCommands.TextBlockCommand;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbMarkingUtil;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;


/**
 * {@link TCSExtractorStream} used to create TextBlocks Model.
 * 
 * @author Philipp Meier, Andreas Landerer, Stephan Erb (d049157)
 * 
 */
public class TextBlockTCSExtractorStream implements TCSExtractorStream {

    protected static boolean DEBUG = false;
    
    protected int textBlocksHandleCounter = 0;
    protected final LinkedList<Integer> openTextBlocksHandles = new LinkedList<Integer>();
    protected final LinkedList<Integer> alternativeNestingLevel = new LinkedList<Integer>();
    
    protected List<TextBlockCommand> commandQueue = new ArrayList<TextBlockCommand>();
    protected final Map<Integer, List<TextBlockCommand>> backup = new HashMap<Integer, List<TextBlockCommand>>();
    protected int currentBackupHandle = 0;
    
    protected final LinkedList<SequenceElement> currentSE = new LinkedList<SequenceElement>();
    protected final Map<TextBlock, Template> blockToTemplate = new HashMap<TextBlock, Template>();

    protected final TextblocksPackage textblocksPacakge;
    protected final ModelPartition partitionForTextBlocks;
    
    protected TextBlock rootBlock;
    protected TextBlock currentBlock;
    protected int currentOffset;
    protected int currentBlockLength;
    
    protected final StringBuffer rootBlockCachedString = new StringBuffer();
    protected final Lexer lexer;
    
    
    public TextBlockTCSExtractorStream(TextblocksPackage pack, ModelPartition partitionForTextBlocks,
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
	this.textblocksPacakge = pack;
	this.partitionForTextBlocks = partitionForTextBlocks;
	this.lexer = parserFactory.createLexer(null);
    }
    
    public TextBlock getPrintedResultRootBlock() {
	return rootBlock;
    }

    private TextBlock createTextBlock() {
	TextBlock b = (TextBlock) textblocksPacakge.getTextBlock().refCreateInstanceInPartition(partitionForTextBlocks);
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

    private LexedToken createLexedToken(SequenceElement se) {
	// TODO compute lookahead and lookback using lexer!
	LexedToken t = (LexedToken) textblocksPacakge.getLexedToken().refCreateInstanceInPartition(partitionForTextBlocks);
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
    
    private OmittedToken createOmittedToken() {
	// TODO compute lookahead and lookback using lexer!
	OmittedToken t = (OmittedToken) textblocksPacakge.getOmittedToken().refCreateInstanceInPartition(partitionForTextBlocks);
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
    
    private void addBosToken() {
	if (this.rootBlock != null) {
	    for (AbstractToken token : this.rootBlock.getTokens()) {
		if (token instanceof Bostoken) {
		    return;
		}
	    }
	}
	Bostoken bos = ANTLRIncrementalLexerAdapter.createBOSToken(textblocksPacakge, VersionEnum.REFERENCE,
		ANTLRIncrementalLexerAdapter.bosTokenType);
	addToken(bos);
    }

    private void addEosToken() {
	if (this.rootBlock != null) {
	    for (AbstractToken token : this.rootBlock.getTokens()) {
		if (token instanceof Eostoken) {
		    return;
		}
	    }
	}
	Eostoken eos = ANTLRIncrementalLexerAdapter.createEOSToken(textblocksPacakge, VersionEnum.REFERENCE,
		ANTLRIncrementalLexerAdapter.eosTokenType);
	eos.setOffset(currentOffset);
	addToken(eos);
    }

    private void addToken(AbstractToken t) {
	assert t.getParentBlock() == null: "New token must not already have a parent";
	assert !currentBlock.getTokens().contains(t) : "Must not add the same token twice";
	currentBlock.getTokens().add(t);
	currentOffset += t.getLength();
	currentBlockLength += t.getLength();
    }
    
    private void addTextBlock(TextBlock b) {
	assert b.getSubBlocks().isEmpty() : "New blocks must not already have subblocks";
	assert b.getTokens().isEmpty() : "New blocks must not already have tokens";
	assert !currentBlock.getSubBlocks().contains(b) : "Must not add a Tb twice";
	assert b.getParentBlock() == null : "Must not already have a parent";
	currentBlock.getSubBlocks().add(b);
	currentOffset = 0;
	currentBlockLength = 0;
	currentBlock = b;
    }
    
    protected void setType(TextBlock block, Template template) {
	if (template != null) {
	    TextBlockDefinition tbDef = textblocksPacakge.getTextblockdefinition().getTextblockDefinitionReferencesProduction()
		    .getTextBlockDefinition(template).iterator().next();
	    block.setType(tbDef);
	}
    }
    
    protected Template getType(TextBlock block) {
	return blockToTemplate.get(block);
    }
    
    protected void addToParentContext(TextBlock startBlock) {

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
    
    @Override
    public void printDefault(String value) {
	commandQueue.add(new AddNextTokenCommand(this, value, getCurrentSE()));
    }

    @Override
    public void enterAlternative(Alternative alternative) {
	commandQueue.add(new EnterAlternativeMarkerCommand(this, alternative));
    }

    @Override
    public void exitAlternative() {
	commandQueue.add(new ExitAlternativeMarkerCommand(this));
    }

    @Override
    public void beginAlternativeChoice(int choiceIndexInAlternative) {
	commandQueue.add(new BeginAlternativeChoiceCommand(this, choiceIndexInAlternative));
    }
    
    @Override
    public void enterSequenceElement(SequenceElement e) {
	currentSE.push(e);
    }

    @Override
    public void exitSequenceElement() {
	currentSE.pop();
    }
    
    @Override
    public void printInteger(int v) {
	commandQueue.add(new AddNextTokenCommand(this, "" + v, getCurrentSE()));
    }

    @Override
    public void printKeyword(String keyword) {
	commandQueue.add(new AddNextTokenCommand(this, keyword, getCurrentSE()));
    }

    @Override
    public void printReal(String string) {
	commandQueue.add(new AddNextTokenCommand(this, string, getCurrentSE()));
    }

    @Override
    public void printString(String stringDelim, String v) {
	commandQueue.add(new AddNextTokenCommand(this, stringDelim + v + stringDelim, getCurrentSE()));
    }

    @Override
    public void printSymbol(String symbol) {
	commandQueue.add(new AddNextTokenCommand(this, symbol, getCurrentSE()));
    }

    @Override
    public void printWhiteSpace(String ws) {
	commandQueue.add(new AddNextTokenCommand(this, ws, getCurrentSE()));
    }

    @Override
    public int createSafePoint() {
	List<TextBlockCommand> store = new ArrayList<TextBlockCommand>(commandQueue);
	currentBackupHandle++;
	if (DEBUG) {
	    System.out.println("creating savepoint " + currentBackupHandle + " with " + store.size() + " commands saved");
	}
	backup.put(currentBackupHandle, store);
	return currentBackupHandle;
    }

    @Override
    public void resetToSafePoint(int handle) {
	commandQueue = backup.get(handle);

	if (DEBUG) {
	    System.out.println("resetting to savepoint " + handle + " with " + commandQueue.size() + " commands restored");
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
	commandQueue.add(new AddNextTextBlockCommand(this, object, t, getCurrentSE(), handle));
	return handle;
    }

    @Override
    public void endClassTemplate(int handle) {
	commandQueue.add(new FinishTextBlockCommand(this, handle));
    }

    @Override
    public void debug(String string) {
	commandQueue.add(new AddNextTokenCommand(this, string, getCurrentSE()));
    }

    @Override
    public void printBoolean(boolean v) {
	commandQueue.add(new AddNextTokenCommand(this, "" + v, getCurrentSE()));
    }

    @Override
    public void printComment(String c) {
	commandQueue.add(new AddNextTokenCommand(this, c, getCurrentSE()));
    }

    @Override
    public void printEscapedIdentifier(String identEscStart, String ident, String identEscEnd) {
	commandQueue.add(new AddNextTokenCommand(this, identEscStart + ident + identEscEnd, getCurrentSE()));
    }

    @Override
    public void printIdentifier(String ident) {
	commandQueue.add(new AddNextTokenCommand(this, ident, getCurrentSE()));
    }
    
    /*package*/ void finishTextBlock(int handle) {
	if (DEBUG) {
	    System.out.println("finishing TextBlock with handle: " + handle);
	}

	assert openTextBlocksHandles.peek() == handle;
	openTextBlocksHandles.pop();
	alternativeNestingLevel.pop();

	currentBlock.setLength(currentBlockLength);

	TextBlock parent = currentBlock.getParentBlock();
	if (parent != null) {

	    if (currentBlockLength == 0) {
		// this textblock is empty, remove it
		if (DEBUG) {
		    System.out.println("removing empty TextBlock");
		}

		// handle this textblock's addToContext flag
		// addToContext only present on ClassTemplate
		// context can be present on ClassTemplate and OperatorTemplate
		Template t = getType(currentBlock);
		if (t instanceof ClassTemplate) {
		    ClassTemplate ct = (ClassTemplate) t;
		    if (ct.isAddToContext()) {
			addToParentContext(currentBlock);
		    }
		}

		currentBlock.setParentBlock(null);
		parent.getCorrespondingModelElements().addAll(currentBlock.getCorrespondingModelElements());
		parent.getReferencedElements().addAll(currentBlock.getReferencedElements());
		currentBlock.refDelete();
	    }

	    // restore curBlockLength from parent and curBlockLength
	    currentBlockLength += parent.getLength();
	    // restore curOffset from curBlockLength
	    currentOffset = currentBlockLength;
	    currentBlock = parent;
	} else {
	    // this is for the rootblock only
	    if (currentBlock.getTokens().size() > 0 && currentBlock.getTokens().get(0) instanceof Bostoken) {
		// Ensure that no lookback is set for the first token.
		// TODO: Currently
		// the lookback for tokens created by the Extractor is hard
		// coded to
		// 2 meaning that the first token wil lookback past the BOS
		// token resulting
		// in an error.
		AbstractToken firstTok = TbNavigationUtil.firstTokenWithoutBOS(currentBlock);
		if (firstTok != null) {
		    firstTok.setLookback(0);
		}
	    }
	}
    }

    /*package*/ void addNextTextBlock(RefObject correspondingModelElement, Template template, SequenceElement se, int handle) {
	if (DEBUG) {
	    System.out.println("adding TextBlock for template " + TcsDebugUtil.prettyPrint(template) + " with handle: " + handle);
	}
	
	openTextBlocksHandles.push(handle);
	alternativeNestingLevel.push(0);

	if (rootBlock == null) {
	    // first textBlock, special rootBlock handling
	    rootBlock = createTextBlock();
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
	    currentBlock = rootBlock;

	    if (DEBUG) {
		System.out.println("adding BosToken");
	    }
	    if (template instanceof ClassTemplate) {
		if (((ClassTemplate) template).isMain()) {
		    addBosToken();
		}
	    } else if (template == null) {
		if (currentBlock.getParentBlock() == null) {
		    addBosToken();
		}
	    }
	} else {
	    // not the rootBlock

	    // backup curBlockLenght in curBlock.length
	    currentBlock.setLength(currentBlockLength);

	    TextBlock b = createTextBlock();
	    b.setOffset(currentOffset);

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
	blockToTemplate.put(currentBlock, template);
    }

    /*package*/ void addNextToken(String value, SequenceElement se) {
	if (value != null && !value.equals("")) {
	    AbstractToken t = null;
	    // TODO this is currentl needed as token types are stored in
	    // textblocks model
	    lexer.setCharStream(new ANTLRStringStream(value));
	    Token lexerToken = lexer.nextToken();

	    if (lexerToken.getChannel() == Token.HIDDEN_CHANNEL) {
		if (DEBUG) {
		    System.out.println("adding OmittedToken: '" + value + "'");
		}
		t = createOmittedToken();
	    } else {
		if (DEBUG) {
		    System.out.println("adding LexedToken: '" + value + "'");
		}
		t = createLexedToken(se);
	    }
	    t.setType(lexerToken.getType());
	    // end TODO

	    t.setValue(value);
	    t.setOffset(currentOffset);
	    t.setLength(value.length());

	    addToken(t);

	    TbMarkingUtil.markTokenRelexed(t);

	    rootBlockCachedString.append(value);
	}
    }

    @Override
    public void close() {
	createTextBlocksModel();
    }
    
    protected void createTextBlocksModel() {
	// no more backtracking after this point
	// execute all textblock commands
	for (TextBlockCommand command : commandQueue) {
	    command.execute();
	}

	// finish rootBlock

	// check first if any output was printed
	if (rootBlock != null) {
	    if (DEBUG) {
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
	    rootBlock.setCachedString(rootBlockCachedString.toString());
	    TbValidationUtil.assertTextBlockConsistencyRecursive(rootBlock);
	}
    }

    /*package*/ void enterAlternativeAndAddMarker() {
	int i = alternativeNestingLevel.pop();
	alternativeNestingLevel.push(++i);
	currentBlock.getParentAltChoices().add(getCurrentNestingLevelMarker());
    }

    /*package*/ void exitAlternativeAndAddMarker() {
	currentBlock.getParentAltChoices().add(getCurrentNestingLevelMarker());
	int i = alternativeNestingLevel.pop();
	alternativeNestingLevel.push(--i);
    }

    /*package*/ void addAlternativeChoice(int choiceIndexInAlternative) {
	currentBlock.getParentAltChoices().add(choiceIndexInAlternative);
    }
    
    private Integer getCurrentNestingLevelMarker() {
	return -alternativeNestingLevel.peek();
    }
}
