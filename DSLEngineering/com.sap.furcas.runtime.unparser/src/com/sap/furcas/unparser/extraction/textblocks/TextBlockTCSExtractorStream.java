/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.unparser.extraction.textblocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.OmittedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.TcsDebugUtil;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.furcas.unparser.extraction.TCSExtractorStream;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockCommands.AddNextTextBlockCommand;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockCommands.AddNextTokenCommand;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockCommands.BeginAlternativeChoiceCommand;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockCommands.EnterAlternativeMarkerCommand;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockCommands.ExitAlternativeMarkerCommand;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockCommands.FinishTextBlockCommand;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockCommands.TextBlockCommand;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;


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

    protected final TextblocksFactory textblocksFactory;
    
    protected TextBlock rootBlock;
    protected TextBlock currentBlock;
    protected int currentOffset;
    protected int currentBlockLength;
    
    protected final StringBuffer rootBlockCachedString = new StringBuffer();
    protected final Lexer lexer;
    
    
    public TextBlockTCSExtractorStream(TextblocksPackage pack, ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
	this.textblocksFactory = pack.getTextblocksFactory();
	this.lexer = parserFactory.createLexer(null);
    }
    
    public TextBlock getPrintedResultRootBlock() {
	return rootBlock;
    }

    private TextBlock createTextBlock() {
	TextBlock b = textblocksFactory.createTextBlock();
	b.setChildrenChanged(false);
	b.setVersion(Version.REFERENCE);
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
	LexedToken t = textblocksFactory.createLexedToken();
	t.setChildrenChanged(false);
	t.setVersion(Version.REFERENCE);
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
	OmittedToken t = textblocksFactory.createOmittedToken();
	t.setChildrenChanged(false);
	t.setVersion(Version.REFERENCE);
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
	Bostoken bos = ANTLRIncrementalLexerAdapter.createBOSToken(textblocksFactory, Version.REFERENCE,
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
	Eostoken eos = ANTLRIncrementalLexerAdapter.createEOSToken(textblocksFactory, Version.REFERENCE,
		ANTLRIncrementalLexerAdapter.eosTokenType);
	eos.setOffset(currentOffset);
	addToken(eos);
    }

    private void addToken(AbstractToken t) {
	assert t.getParent() == null: "New token must not already have a parent";
	assert !currentBlock.getTokens().contains(t) : "Must not add the same token twice";
	currentBlock.getSubNodes().add(t);
	currentOffset += t.getLength();
	currentBlockLength += t.getLength();
    }
    
    private void addTextBlock(TextBlock b) {
	assert b.getSubBlocks().isEmpty() : "New blocks must not already have subblocks";
	assert b.getTokens().isEmpty() : "New blocks must not already have tokens";
	assert !currentBlock.getSubBlocks().contains(b) : "Must not add a Tb twice";
	assert b.getParent() == null : "Must not already have a parent";
	currentBlock.getSubNodes().add(b);
	currentOffset = 0;
	currentBlockLength = 0;
	currentBlock = b;
    }
    
    protected void setType(TextBlock block, Template template) {
	if (template != null) {
	    TextBlockDefinition tbDef = template.getTextBlockDefinition();
	    block.setType(tbDef);
	}
    }
    
    protected Template getType(TextBlock block) {
	return blockToTemplate.get(block);
    }
    
    protected void addToParentContext(TextBlock startBlock) {

	List<EObject> modelElements = startBlock.getCorrespondingModelElements();

	TextBlock parentBlock = startBlock.getParent();
	while (parentBlock != null) {
	    Template t = getType(parentBlock);

	    if (t instanceof ContextTemplate) {
		ContextTemplate ct = (ContextTemplate) t;
		if (ct.isIsContext()) {
		    parentBlock.getElementsInContext().addAll(modelElements);
		    return;
		}
	    }
	    parentBlock = parentBlock.getParent();
	}
    }
    
    @Override
    public void printDefault(String value) {
	commandQueue.add(new AddNextTokenCommand(this, value, getCurrentSE()));
    }

    @Override
    public void enterAlternative(Alternative alternative) {
	commandQueue.add(new EnterAlternativeMarkerCommand(this));
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
    public int startClassTemplateForObject(EObject object, Template t) {
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

	TextBlock parent = currentBlock.getParent();
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
		    if (ct.isIsAddToContext()) {
			addToParentContext(currentBlock);
		    }
		}

		currentBlock.setParent(null);
		parent.getCorrespondingModelElements().addAll(currentBlock.getCorrespondingModelElements());
		parent.getReferencedElements().addAll(currentBlock.getReferencedElements());
                EcoreUtil.delete(currentBlock);
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

    /*package*/ void addNextTextBlock(EObject correspondingModelElement, Template template, SequenceElement se, int handle) {
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
		if (((ClassTemplate) template).isIsMain()) {
		    addBosToken();
		}
	    } else if (template == null) {
		if (currentBlock.getParent() == null) {
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
		if (((ClassTemplate) template).isIsMain()) {
		    addEosToken();
		}
	    } else if (template == null) {
		if (rootBlock.getParent() == null) {
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
