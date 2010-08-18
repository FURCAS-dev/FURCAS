package com.sap.ide.cts.editor.prettyprint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ContextTemplate;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.OmittedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.ide.cts.editor.contentassist.TcsDebugUtil;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbMarkingUtil;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.mi.textual.tcs.util.TcsUtil;

/**
 * 
 * @author Andreas Landerer
 * 
 */
public class CtsTextBlockIncrementalTCSExtractorStream implements
		TCSExtractorStream
{

	private static boolean																		debug					= false;
	private int																					textBlocksHandleCounter	= 0;
	private Stack<Integer>																		openTextBlocksHandles	= new Stack<Integer>();
	private TextBlock																			oldTextBlock			= null;
	private ClassTemplate																		templateForOldTextBlock	= null;
	private List<TextBlockCommand>																current					= new ArrayList<TextBlockCommand>();
	private Map<Integer, List<TextBlockCommand>>												backup					= new HashMap<Integer, List<TextBlockCommand>>();
	private int																					curBackupHandle			= 0;
	private Stack<SequenceElement>																currentSE				= new Stack<SequenceElement>();
	private Map<TextBlock, Template>															blockToTemplate			= new HashMap<TextBlock, Template>();
	private PrettyPrinter																		prettyPrinter			= null;
	private boolean																				formatMode				= true;
	private TextblocksPackage																	pack					= null;
	private Resource																		part					= null;
	private TextBlock																			rootBlock				= null;
	private TextBlock																			curBlock				= null;
	private int																					curOffset				= 0;
	private int																					curBlockLength			= 0;
	private Stack<Integer>																		indexesTB				= new Stack<Integer>();
	private Stack<Integer>																		indexesTokens			= new Stack<Integer>();
	private List<TextBlock>																		tbsToDelete				= new ArrayList<TextBlock>();
	StringBuffer																				rootBlockCachedString	= new StringBuffer();
	private final Lexer																			lexer;
	private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>	pFactory;

	interface TextBlockCommand
	{
		void execute();
	}

	class AddNextTextBlockCommand implements TextBlockCommand
	{
		private TextBlock		textblock;
		private EObject		object;
		private Template		t;
		private SequenceElement	se;
		private int				handle;

		public AddNextTextBlockCommand(EObject object, Template t,
				SequenceElement se, int handle)
		{
			this.object = object;
			this.t = t;
			this.se = se;
			this.handle = handle;
		}

		public AddNextTextBlockCommand(TextBlock textblock, EObject object,
				Template t, SequenceElement se, int handle)
		{
			this(object, t, se, handle);
			this.textblock = textblock;
		}

		public void execute()
		{
			if (this.textblock != null)
			{
				addNextTextBlock(this.textblock, object, t, se, handle);
			}
			else
			{
				addNextTextBlock(null, object, t, se, handle);
			}
		}
	}

	class FinishTextBlockCommand implements TextBlockCommand
	{
		private int	handle;

		public FinishTextBlockCommand(int handle)
		{
			this.handle = handle;
		}

		public void execute()
		{
			finishTextBlock(handle);
		}
	}

	class AddNextTokenCommand implements TextBlockCommand
	{
		private String			s;
		private SequenceElement	se;
		private AbstractToken	token;

		public AddNextTokenCommand(String s, SequenceElement se)
		{
			this.s = s;
			this.se = se;
		}

		public AddNextTokenCommand(AbstractToken token)
		{
			this(token.getValue(), null);
			this.token = token;
		}

		public void execute()
		{
			if (this.token == null)
			{
				addNextToken(s, se);
			}
			else
			{
				addNextToken(this.token);
			}
		}
	}

	public CtsTextBlockIncrementalTCSExtractorStream(
			TextblocksPackage pack,
			Resource partitionForTextBlocks,
			AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
			boolean formatMode)
	{
		this.pack = pack;
		part = partitionForTextBlocks;
		this.lexer = parserFactory.createLexer(null);
		this.pFactory = parserFactory;
		this.formatMode = formatMode;
	}

	public TextBlock getRootBlock()
	{
		return rootBlock;
	}

	TextBlock createTextBlock()
	{
		TextBlock b = (TextBlock) pack.getTextBlock()
				.refCreateInstanceInPartition(part);
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

	LexedToken createLexedToken(SequenceElement se)
	{
		// TODO compute lookahead and lookback using lexer!
		LexedToken t = (LexedToken) pack.getLexedToken()
				.refCreateInstanceInPartition(part);
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

	OmittedToken createOmittedToken()
	{
		// TODO compute lookahead and lookback using lexer!
		OmittedToken t = (OmittedToken) pack.getOmittedToken()
				.refCreateInstanceInPartition(part);
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

	void addNextTextBlock(TextBlock oldTb, EObject correspondingModelElement,
			Template template, SequenceElement se, int handle)
	{
		if (debug)
		{
			System.out.println("adding TextBlock for template "
					+ TcsDebugUtil.prettyPrint(template) + " with handle: "
					+ handle);
		}

		openTextBlocksHandles.add(handle);

		if (rootBlock == null)
		{
			// first textBlock, special rootBlock handling
			if (oldTb == null)
			{
				rootBlock = createTextBlock();
			}
			else
			{
				rootBlock = oldTb;
			}
			setType(rootBlock, template);
			rootBlock.setOffsetRelative(false);
			if (correspondingModelElement != null)
			{
				if (TcsUtil.isPropertyInit(se))
				{
					// Add to referenced element if its a Property Init
					rootBlock.getReferencedElements().add(
							correspondingModelElement);
				}
				else
				{
					rootBlock.getCorrespondingModelElements().add(
							correspondingModelElement);
				}
			}
			rootBlock.setSequenceElement(se);
			curBlock = rootBlock;

			if (debug)
			{
				System.out.println("adding BosToken");
			}
			if (template instanceof ClassTemplate)
			{
				if (((ClassTemplate) template).isIsMain())
				{
					addBosToken();
				}
			}
			else if (template == null && oldTb == null)
			{
				if (curBlock.getParent() == null)
				{
					addBosToken();
				}
			}
		}
		else
		{
			// not the rootBlock

			// backup curBlockLenght in curBlock.length
			curBlock.setLength(curBlockLength);
			TextBlock b;
			if (oldTb == null)
			{
				b = createTextBlock();
			}
			else
			{
				b = oldTb;
			}
			b.setOffset(curOffset);

			if (correspondingModelElement != null)
			{
				if (TcsUtil.isPropertyInit(se))
				{
					// Add to referenced element if its a Property Init
					b.getReferencedElements().add(correspondingModelElement);
				}
				else
				{
					b.getCorrespondingModelElements().add(
							correspondingModelElement);
				}
			}
			b.setSequenceElement(se);
			setType(b, template);
			addTextBlock(b);
		}

		// save Template for later use
		blockToTemplate.put(curBlock, template);
	}

	public void setPrettyPrinter(PrettyPrinter prettyPrinter)
	{
		this.prettyPrinter = prettyPrinter;
	}

	private void setType(TextBlock block, Template template)
	{
		if (template != null)
		{
			TextBlockDefinition tbDef = pack.getTextblockdefinition()
					.getTextblockDefinitionReferencesProduction()
					.getTextBlockDefinition(template).iterator().next();
			block.setType(tbDef);
		}
	}

	void addTextBlock(TextBlock b)
	{
		if (b.getParent() != null)
		{
			b.setParent(null);
		}
		curBlock.getSubBlocks().add(b);
		curOffset = 0;
		curBlockLength = 0;
		curBlock = b;
	}

	void finishTextBlock(int handle)
	{
		if (debug)
		{
			System.out.println("finishing TextBlock with handle: " + handle);
		}

		while (openTextBlocksHandles.size() > 0
				&& openTextBlocksHandles.peek() != handle)
		{
			// calls to addTextBlock and finishTextBlock do not match
			// last textblock was falsely left open

			// gracefully close it
			if (debug)
			{
				System.out.println("closing left-open TextBlock with handle: "
						+ openTextBlocksHandles.peek());
			}
			finishTextBlock(openTextBlocksHandles.peek());
		}
		if (openTextBlocksHandles.size() > 0)
		{
			openTextBlocksHandles.pop();
		}

		curBlock.setLength(curBlockLength);

		TextBlock parent = curBlock.getParent();
		if (parent != null)
		{

			if (curBlockLength == 0)
			{
				// this textblock is empty, remove it
				if (debug)
				{
					System.out.println("removing empty TextBlock");
				}

				// handle this textblock's addToContext flag
				// addToContext only present on ClassTemplate
				// context can be present on ClassTemplate and OperatorTemplate
				Template t = getType(curBlock);
				if (t instanceof ClassTemplate)
				{
					ClassTemplate ct = (ClassTemplate) t;
					if (ct.isIsAddToContext())
					{
						addToParentContext(curBlock);
					}
				}

				parent.getSubBlocks().remove(curBlock);
				List<EObject> parentModelElements = parent
						.getCorrespondingModelElements();
				for (EObject o : curBlock.getCorrespondingModelElements())
				{
					if (!parentModelElements.contains(o))
					{
						parentModelElements.add(o);
					}
				}

				Collection<EObject> parentReferencedElements = parent
						.getReferencedElements();
				for (EObject o : curBlock.getReferencedElements())
				{
					if (!parentReferencedElements.contains(o))
					{
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
		}
		else
		{
			// this is for the rootblock only
			if (curBlock.getTokens().size() > 0
					&& curBlock.getTokens().get(0) instanceof Bostoken)
			{
				// Ensure that no lookback is set for the first token.
				// TODO: Currently
				// the lookback for tokens created by the Extractor is hard
				// coded to
				// 2 meaning that the first token wil lookback past the BOS
				// token resulting
				// in an error.
				AbstractToken firstTok = TbNavigationUtil
						.firstTokenWithoutBOS(curBlock);
				if (firstTok != null)
				{
					firstTok.setLookback(0);
				}
			}
		}
	}

	private Template getType(TextBlock block)
	{
		return blockToTemplate.get(block);
	}

	private void addToParentContext(TextBlock startBlock)
	{

		List<EObject> modelElements = startBlock
				.getCorrespondingModelElements();

		TextBlock parentBlock = startBlock.getParent();
		while (parentBlock != null)
		{
			Template t = getType(parentBlock);

			if (t instanceof ContextTemplate)
			{
				ContextTemplate ct = (ContextTemplate) t;
				if (ct.isContext())
				{
					parentBlock.getElementsInContext().addAll(modelElements);
					return;
				}
			}

			parentBlock = parentBlock.getParent();
		}

	}

	void addNextToken(AbstractToken token)
	{
		token.setOffset(curOffset);
		token.setLength(token.getValue().length());
		this.addToken(token);
		TbMarkingUtil.markTokenRelexed(token);
		rootBlockCachedString.append(token.getValue());
	}

	void addNextToken(String value, SequenceElement se)
	{
		if (value != null && !value.equals(""))
		{
			AbstractToken t = null;
			// TODO this is currentl needed as token types are stored in
			// textblocks model
			lexer.setCharStream(new ANTLRStringStream(value));
			Token lexerToken = lexer.nextToken();

			if (lexerToken.getChannel() == Token.HIDDEN_CHANNEL)
			{
				if (debug)
				{
					System.out.println("adding OmittedToken: '" + value + "'");
				}
				t = createOmittedToken();
			}
			else
			{
				if (debug)
				{
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

	void addBosToken()
	{
		Bostoken bos = ANTLRIncrementalLexerAdapter.createBOSToken(pack,
				VersionEnum.REFERENCE,
				ANTLRIncrementalLexerAdapter.bosTokenType);
		addToken(bos);
	}

	void addEosToken()
	{
		if (this.rootBlock != null)
		{
			for (AbstractToken token : this.rootBlock.getTokens())
			{
				if (token instanceof Eostoken)
				{
					return;
				}
			}
		}
		Eostoken eos = ANTLRIncrementalLexerAdapter.createEOSToken(pack,
				VersionEnum.REFERENCE,
				ANTLRIncrementalLexerAdapter.eosTokenType);
		eos.setOffset(curOffset);
		addToken(eos);
	}

	void addToken(AbstractToken t)
	{
		if (t.getParent() != null)
		{
			t.setParent(null);
		}
		if (!this.indexesTokens.isEmpty())
		{
			int index = this.indexesTokens.peek();
			if (curBlock.getTokens().contains(t)
					&& curBlock.getTokens().indexOf(t) != index)
			{
				this.curBlock.getTokens().remove(t);
			}
			curBlock.getTokens().add(this.indexesTokens.peek(), t);
			this.indexesTokens.push(this.indexesTokens.pop() + 1);
		}
		else
		{
			curBlock.getTokens().add(t);
		}
		curOffset += t.getLength();
		curBlockLength += t.getLength();
	}

	@Override
	public void close()
	{
		this.indexesTB.clear();
		this.indexesTokens.clear();
		if (this.oldTextBlock != null)
		{
			this.mergeTbs(this.oldTextBlock, 0);
		}

		// no more backtracking after this point
		// execute all textblock commands
		for (TextBlockCommand command : current)
		{
			if (command instanceof AddNextTextBlockCommand)
			{
				this.indexesTokens.push(0);
			}
			else if (command instanceof FinishTextBlockCommand)
			{
				this.indexesTokens.pop();
			}
			command.execute();
		}

		// finish rootBlock

		// check first if any output was printed
		if (rootBlock != null)
		{
			if (debug)
			{
				System.out.println("adding EosToken");
			}
			Template template = this.blockToTemplate.get(rootBlock);
			if (template instanceof ClassTemplate)
			{
				if (((ClassTemplate) template).isIsMain())
				{
					addEosToken();
				}
			}
			else if (template == null)
			{
				if (rootBlock.getParent() == null)
				{
					addEosToken();
				}
			}
			TbValidationUtil.assertTextBlockConsistencyRecursive(rootBlock);
			rootBlock.setCachedString(rootBlockCachedString.toString());
		}
	}

	private boolean isOmittedTokenForFormatingPurpose(OmittedToken token)
	{
		for (Integer i : this.pFactory.getOmittedTokensForFormatting())
		{
			if (i.intValue() == token.getType())
			{
				return true;
			}
		}

		return false;
	}

	private void mergeTbsConservatively(TextBlock tb, int depth)
	{
		assert tb != null;

		List<AbstractToken> tokensToDelete = new ArrayList<AbstractToken>();
		AddNextTextBlockCommand newTbCmd = null;
		TextBlockCommand lastCmdPreserved = null;
		int indexOfCorrTbCmd = -1;

		// call method recursively for SubBlocks
		for (TextBlock subBlock : tb.getSubBlocks())
		{
			this.mergeTbs(subBlock, depth + 1);
		}
		if (this.tbsToDelete.size() > 0 && depth == 0)
		{
			for (TextBlock tbToDelete : this.tbsToDelete)
			{
				tbToDelete.refDelete();
			}
		}
		
		// check if corresponding ModelElement still exists
		for (TextBlockCommand command : this.current)
		{
			if (command instanceof AddNextTextBlockCommand)
			{
				AddNextTextBlockCommand tbCommand = (AddNextTextBlockCommand) command;
				List<EObject> me = tb.getCorrespondingModelElements();
				if (me.size() > 0)
				{
					if (tbCommand.object.equals(me.get(0)))
					{
						// replace new command by existing TextBlock
						indexOfCorrTbCmd = this.current.indexOf(tbCommand);
						newTbCmd = new AddNextTextBlockCommand(tb,
								tbCommand.object, tbCommand.t, tbCommand.se,
								tbCommand.handle);
						break;
					}
				}
				else
				{
					return;
				}
			}
		}
		if (newTbCmd != null)
		{
			this.current.remove(indexOfCorrTbCmd);
			this.current.add(indexOfCorrTbCmd, newTbCmd);

			// check if there are any tokens that can be preserved
			for (AbstractToken token : tb.getTokens())
			{
				// preserved all OmittedTokens
				if (token instanceof OmittedToken)
				{
					

				}

				// if token is a LexedToken it will be preserved if it exists in
				// both the old TextBlock and the
				// new CommandList
				else if (token instanceof LexedToken)
				{
					AddNextTokenCommand tokenCmd = null;
					LexedToken lexedToken = (LexedToken) token;
					Stack<Integer> subBlocks = new Stack<Integer>();
					for (int i = indexOfCorrTbCmd + 1; i < this.current.size(); i++)
					{
						TextBlockCommand tbCmd = this.current.get(i);
						if (tbCmd instanceof AddNextTextBlockCommand)
						{
							subBlocks
									.push(((AddNextTextBlockCommand) tbCmd).handle);
						}
						if (tbCmd instanceof FinishTextBlockCommand)
						{
							AddNextTextBlockCommand tbStartCommand = (AddNextTextBlockCommand) this.current
									.get(indexOfCorrTbCmd);
							subBlocks.pop();
							if (((FinishTextBlockCommand) tbCmd).handle == tbStartCommand.handle)
							{
								break;
							}
						}
						if (tbCmd instanceof AddNextTokenCommand)
						{
							if (subBlocks.isEmpty())
							{
								AddNextTokenCommand currentTokenCmd = (AddNextTokenCommand) tbCmd;
								if (lexedToken.getSequenceElement().equals(
										currentTokenCmd.se)
										&& lexedToken.getValue().equals(
												currentTokenCmd.s))
								{
									tokenCmd = currentTokenCmd;
									break;
								}
							}
						}
					}
					if (tokenCmd == null)
					{
						tokensToDelete.add(lexedToken);
					}
					else
					{
						int indexOfCorrTokenCmd = this.current
								.indexOf(tokenCmd);
						this.current.remove(indexOfCorrTokenCmd);
						tokenCmd = new AddNextTokenCommand(lexedToken);
						this.current.add(indexOfCorrTokenCmd, tokenCmd);
						lastCmdPreserved = tokenCmd;
					}
				}
			}

			tb.getTokens().removeAll(tokensToDelete);
			for (AbstractToken t : tokensToDelete)
			{
				t.refDelete();
			}
		}
		else
		{
			this.tbsToDelete.add(tb);
		}
	}

	private void mergeTbs(TextBlock tb, int depth)
	{
		assert tb != null;

		List<AbstractToken> tokensToDelete = new ArrayList<AbstractToken>();
		AddNextTextBlockCommand newTbCmd = null;
		TextBlockCommand lastCmdPreserved = null;
		int indexOfCorrTbCmd = -1;

		// call method recursively for SubBlocks
		for (TextBlock subBlock : tb.getSubBlocks())
		{
			this.mergeTbs(subBlock, depth + 1);
		}
		if (this.tbsToDelete.size() > 0 && depth == 0)
		{
			for (TextBlock tbToDelete : this.tbsToDelete)
			{
				tbToDelete.refDelete();
			}
		}

		// check if corresponding ModelElement still exists
		for (TextBlockCommand command : this.current)
		{
			if (command instanceof AddNextTextBlockCommand)
			{
				AddNextTextBlockCommand tbCommand = (AddNextTextBlockCommand) command;
				List<EObject> me = tb.getCorrespondingModelElements();
				if (me.size() > 0)
				{
					if (tbCommand.object.equals(me.get(0)))
					{
						// replace new command by existing TextBlock
						indexOfCorrTbCmd = this.current.indexOf(tbCommand);
						newTbCmd = new AddNextTextBlockCommand(tb,
								tbCommand.object, tbCommand.t, tbCommand.se,
								tbCommand.handle);
						break;
					}
				}
				else
				{
					return;
				}
			}
		}
		if (newTbCmd != null)
		{
			this.current.remove(indexOfCorrTbCmd);
			this.current.add(indexOfCorrTbCmd, newTbCmd);

			// check if there are any tokens that can be preserved
			for (AbstractToken token : tb.getTokens())
			{
				if(token instanceof OmittedToken)
				{
					if(!this.formatMode)
					{
						this.handleOmittedToken((OmittedToken) token, tokensToDelete, lastCmdPreserved, indexOfCorrTbCmd);
					}
					else
					{
						this.handleOmittedTokenConservatively((OmittedToken) token, tokensToDelete, lastCmdPreserved, indexOfCorrTbCmd);
					}
				}
				
				else if (token instanceof LexedToken)
				{
					this.handleLexedToken((LexedToken) token, tokensToDelete, lastCmdPreserved, indexOfCorrTbCmd);
				}
			}

			tb.getTokens().removeAll(tokensToDelete);
			for (AbstractToken t : tokensToDelete)
			{
				t.setParent(null);
				t.refDelete();
			}
		}
		else
		{
			this.tbsToDelete.add(tb);
		}
	}
	
	private void handleOmittedToken(OmittedToken token, List<AbstractToken> tokensToDelete, 
			TextBlockCommand lastCmdPreserved, int indexOfCorrTbCmd)
	{
		// if token is an OmittedToken it will be preserved only if it
		// has no formatting purpose and
		// if it is not a BosToken or an EosToken
		// preserved OmittedTokens are COMMENTS and MULTI_LINE_COMMENTS
		OmittedToken omittedToken = (OmittedToken) token;
		AddNextTokenCommand tokenCmd = null;
		if (!this.isOmittedTokenForFormatingPurpose(omittedToken))
		{
			if (!(token instanceof Bostoken) && !(token instanceof Eostoken))
			{
				int index = 0;
				if (lastCmdPreserved != null)
				{
					index = this.current.indexOf(lastCmdPreserved);
				}
				else
				{
					index = indexOfCorrTbCmd;
				}
				tokenCmd = new AddNextTokenCommand(omittedToken.getValue(), null);
				this.current.add(index + 1, tokenCmd);
				AddNextTokenCommand tokenEOL = new AddNextTokenCommand("\n", null);
				this.current.add(index + 2, tokenEOL);
				tokensToDelete.add(omittedToken);
			}
			else
			{
				tokensToDelete.add(omittedToken);
			}
		}
		else
		{
			tokensToDelete.add(omittedToken);
		}
	}
	
	private void handleOmittedTokenConservatively(OmittedToken token, List<AbstractToken> tokensToDelete, 
			TextBlockCommand lastCmdPreserved, int indexOfCorrTbCmd)
	{
		OmittedToken omittedToken = (OmittedToken) token;
		AddNextTokenCommand tokenCmd = null;
		boolean otFound = false;
		for (TextBlockCommand command : this.current)
		{
			if (command instanceof AddNextTokenCommand)
			{
				if (((AddNextTokenCommand) command).s.equals(token.getValue()))
				{
					if (lastCmdPreserved != null
							&& this.current.indexOf(command) > this.current.indexOf(lastCmdPreserved))
					{
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
		if (!otFound)
		{
			if (!this.isOmittedTokenForFormatingPurpose(omittedToken)
					&& !(token instanceof Bostoken)
					&& !(token instanceof Eostoken))
			{
				if (!this.isOmittedTokenForFormatingPurpose(omittedToken))
				{
					if (!(token instanceof Bostoken)
							&& !(token instanceof Eostoken))
					{
						int index = 0;
						if (lastCmdPreserved != null)
						{
							index = this.current.indexOf(lastCmdPreserved);
						}
						else
						{
							index = indexOfCorrTbCmd;
						}
						tokenCmd = new AddNextTokenCommand(omittedToken.getValue(), null);
						this.current.add(index + 1, tokenCmd);
						AddNextTokenCommand tokenEOL = new AddNextTokenCommand("\n", null);
						this.current.add(index + 2, tokenEOL);
						tokensToDelete.add(omittedToken);
					}
				}
			}
			else
			{
				if (!(token instanceof Bostoken)
						&& !(token instanceof Eostoken))
				{
					int index = 0;
					if (lastCmdPreserved != null)
					{
						index = this.current.indexOf(lastCmdPreserved);
					}
					else
					{
						index = indexOfCorrTbCmd;
					}
					tokenCmd = new AddNextTokenCommand(token);
					this.current.add(index + 1, tokenCmd);
				}
				else
				{
					tokensToDelete.add(token);
				}
			}
		}
	}
	
	private void handleLexedToken(LexedToken token, List<AbstractToken> tokensToDelete, 
			TextBlockCommand lastCmdPreserved, int indexOfCorrTbCmd)
	{
		// if token is a LexedToken it will be preserved if it exists in
		// both the old TextBlock and the
		// new CommandList
		AddNextTokenCommand tokenCmd = null;
		LexedToken lexedToken = (LexedToken) token;
		Stack<Integer> subBlocks = new Stack<Integer>();
		for (int i = indexOfCorrTbCmd + 1; i < this.current.size(); i++)
		{
			TextBlockCommand tbCmd = this.current.get(i);
			if (tbCmd instanceof AddNextTextBlockCommand)
			{
				subBlocks.push(((AddNextTextBlockCommand) tbCmd).handle);
			}
			if (tbCmd instanceof FinishTextBlockCommand)
			{
				AddNextTextBlockCommand tbStartCommand = (AddNextTextBlockCommand) this.current.get(indexOfCorrTbCmd);
				if (!subBlocks.isEmpty())
				{
					subBlocks.pop();
				}
				if (((FinishTextBlockCommand) tbCmd).handle == tbStartCommand.handle)
				{
					break;
				}
			}
			if (tbCmd instanceof AddNextTokenCommand)
			{
				if (subBlocks.isEmpty())
				{
					AddNextTokenCommand currentTokenCmd = (AddNextTokenCommand) tbCmd;
					if (lexedToken.getSequenceElement().equals(currentTokenCmd.se)
							&& lexedToken.getValue().equals(currentTokenCmd.s))
					{
						tokenCmd = currentTokenCmd;
						break;
					}
				}
			}
		}
		if (tokenCmd == null)
		{
			tokensToDelete.add(lexedToken);
		}
		else
		{
			int indexOfCorrTokenCmd = this.current.indexOf(tokenCmd);
			this.current.remove(indexOfCorrTokenCmd);
			tokenCmd = new AddNextTokenCommand(lexedToken);
			this.current.add(indexOfCorrTokenCmd, tokenCmd);
			lastCmdPreserved = tokenCmd;
		}
	}

	private SequenceElement getCurrentSE()
	{
		if (!currentSE.isEmpty())
		{
			return currentSE.peek();
		}

		return null;
	}

	@Override
	public int startClassTemplateForObject(EObject object, Template t)
	{
		int handle = textBlocksHandleCounter++;
		current.add(new AddNextTextBlockCommand(object, t, getCurrentSE(),
				handle));
		return handle;
	}

	@Override
	public void endClassTemplate(int handle)
	{
		current.add(new FinishTextBlockCommand(handle));
	}

	@Override
	public void debug(String string)
	{
		current.add(new AddNextTokenCommand(string, getCurrentSE()));
	}

	@Override
	public void printBoolean(boolean v)
	{
		current.add(new AddNextTokenCommand("" + v, getCurrentSE()));
	}

	@Override
	public void printComment(String c)
	{
		current.add(new AddNextTokenCommand(c, getCurrentSE()));
	}

	@Override
	public void printEscapedIdentifier(String identEscStart, String ident,
			String identEscEnd)
	{
		current.add(new AddNextTokenCommand(
				identEscStart + ident + identEscEnd, getCurrentSE()));
	}

	@Override
	public void printIdentifier(String ident)
	{
		current.add(new AddNextTokenCommand(ident, getCurrentSE()));
	}

	@Override
	public void printInteger(int v)
	{
		current.add(new AddNextTokenCommand("" + v, getCurrentSE()));
	}

	@Override
	public void printKeyword(String keyword)
	{
		current.add(new AddNextTokenCommand(keyword, getCurrentSE()));
	}

	@Override
	public void printReal(String string)
	{
		current.add(new AddNextTokenCommand(string, getCurrentSE()));
	}

	@Override
	public void printString(String stringDelim, String v)
	{
		current.add(new AddNextTokenCommand(stringDelim + v + stringDelim,
				getCurrentSE()));
	}

	@Override
	public void printSymbol(String symbol)
	{
		current.add(new AddNextTokenCommand(symbol, getCurrentSE()));
	}

	@Override
	public void printWhiteSpace(String ws)
	{
		current.add(new AddNextTokenCommand(ws, getCurrentSE()));
	}

	@Override
	public int createSafePoint()
	{
		List<TextBlockCommand> store = new ArrayList<TextBlockCommand>(current);
		curBackupHandle++;

		if (debug)
		{
			System.out.println("creating savepoint " + curBackupHandle
					+ " with " + store.size() + " commands saved");
		}

		backup.put(curBackupHandle, store);
		return curBackupHandle;
	}

	@Override
	public void resetToSafePoint(int handle)
	{
		current = backup.get(handle);

		if (debug)
		{
			System.out.println("resetting to savepoint " + handle + " with "
					+ current.size() + " commands restored");
		}

	}

	@Override
	public void enterSequenceElement(SequenceElement e)
	{
		currentSE.push(e);

	}

	@Override
	public void exitSequenceElement()
	{
		currentSE.pop();

	}

	public TextBlock getOldTextBlock()
	{
		return oldTextBlock;
	}

	public void setOldTextBlock(TextBlock oldTextBlock)
	{
		this.oldTextBlock = oldTextBlock;
	}

	public ClassTemplate getTemplateForOldTextBlock()
	{
		return templateForOldTextBlock;
	}

	public void setTemplateForOldTextBlock(ClassTemplate templateForOldTextBlock)
	{
		this.templateForOldTextBlock = templateForOldTextBlock;
	}

	@Override
	public void printDefault(String value)
	{
		current.add(new AddNextTokenCommand(value, getCurrentSE()));
	}
}
