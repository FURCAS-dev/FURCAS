package com.sap.ide.cts.editor.prettyprint;

import java.util.ArrayList;
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
import com.sap.furcas.metamodel.textblockdefinition.TextblockDefinition;
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.OmittedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.ide.cts.editor.contentassist.TcsDebugUtil;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
/**
 * 
 * @author Philipp Meier, Andreas Landerer
 *
 */
public class CtsTextBlockTCSExtractorStream implements TCSExtractorStream
{

	private static boolean	debug					= false;
	/**
	 * this is used to track unmatched opened and closed textblocks
	 */
	private int				textBlocksHandleCounter	= 0;

	private Stack<Integer>	openTextBlocksHandles	= new Stack<Integer>();

	interface TextBlockCommand
	{
		void execute();
	}

	class AddNextTextBlockCommand implements TextBlockCommand
	{

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

		public void execute()
		{
			addNextTextBlock(object, t, se, handle);
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

		public AddNextTokenCommand(String s, SequenceElement se)
		{
			this.s = s;
			this.se = se;
		}

		public void execute()
		{
			addNextToken(s, se);
		}
	}

	private List<TextBlockCommand>					current					= new ArrayList<TextBlockCommand>();
	private Map<Integer, List<TextBlockCommand>>	backup					= new HashMap<Integer, List<TextBlockCommand>>();
	private int										curBackupHandle			= 0;
	private Stack<SequenceElement>					currentSE				= new Stack<SequenceElement>();
	private Map<TextBlock, Template>				blockToTemplate			= new HashMap<TextBlock, Template>();

	TextblocksPackage								pack					= null;
	Resource									part					= null;
	TextBlock										rootBlock				= null;
	TextBlock										curBlock				= null;
	int												curOffset				= 0;
	int												curBlockLength			= 0;

	StringBuffer									rootBlockCachedString	= new StringBuffer();
	private final Lexer								lexer;

	public CtsTextBlockTCSExtractorStream(
			TextblocksPackage pack,
			Resource partitionForTextBlocks,
			ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory)
	{
		this.pack = pack;
		part = partitionForTextBlocks;
		this.lexer = parserFactory.createLexer(null);
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

	LexedToken createLexedToken(SequenceElement se)
	{
		// TODO compute lookahead and lookback using lexer!
		LexedToken t = (LexedToken) pack.getLexedToken()
				.refCreateInstanceInPartition(part);
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

	OmittedToken createOmittedToken()
	{
		// TODO compute lookahead and lookback using lexer!
		OmittedToken t = (OmittedToken) pack.getOmittedToken()
				.refCreateInstanceInPartition(part);
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

	void addNextTextBlock(EObject correspondingModelElement,
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
			rootBlock = createTextBlock();
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
			else if(template == null)
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

			TextBlock b = createTextBlock();
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

	private void setType(TextBlock block, Template template)
	{
		if (template != null)
		{
			TextblockDefinition tbDef = pack.getTextblockdefinition()
					.getTextblockDefinitionReferencesProduction()
					.getTextBlockDefinition(template).iterator().next();
			block.setType(tbDef);
		}
	}

	void addTextBlock(TextBlock b)
	{
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
				parent.getCorrespondingModelElements().addAll(
						curBlock.getCorrespondingModelElements());
				parent.getReferencedElements().addAll(
						curBlock.getReferencedElements());
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
			if (curBlock.getTokens().size() > 0 && curBlock.getTokens().get(0) instanceof Bostoken)
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
				if (ct.isIsContext())
				{
					parentBlock.getElementsInContext().addAll(modelElements);
					return;
				}
			}

			parentBlock = parentBlock.getParent();
		}

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
				Version.REFERENCE,
				ANTLRIncrementalLexerAdapter.bosTokenType);
		addToken(bos);
	}

	void addEosToken()
	{
		Eostoken eos = ANTLRIncrementalLexerAdapter.createEOSToken(pack,
				Version.REFERENCE,
				ANTLRIncrementalLexerAdapter.eosTokenType);
		eos.setOffset(curOffset);
		addToken(eos);
	}

	void addToken(AbstractToken t)
	{
		curOffset += t.getLength();
		curBlockLength += t.getLength();

		curBlock.getTokens().add(t);
	}

	@Override
	public void close()
	{
		// no more backtracking after this point
		// execute all textblock commands

		for (TextBlockCommand command : current)
		{
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
			else if(template == null)
			{
				if(rootBlock.getParent() == null)
				{
					addEosToken();
				}
			}

			TbValidationUtil.assertTextBlockConsistencyRecursive(rootBlock);
			rootBlock.setCachedString(rootBlockCachedString.toString());
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

	@Override
	public void printDefault(String value)
	{
		current.add(new AddNextTokenCommand(value, getCurrentSE()));
	}
}
