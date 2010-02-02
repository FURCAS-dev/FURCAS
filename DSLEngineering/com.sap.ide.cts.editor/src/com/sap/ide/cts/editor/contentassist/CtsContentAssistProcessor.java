package com.sap.ide.cts.editor.contentassist;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.Lexer;
import org.antlr.runtime.Parser;
import org.antlr.runtime.Token;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;

import com.sap.ide.cts.editor.contentassist.modeladapter.StubModelAdapter;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.document.TextBlocksModelStore;
import com.sap.mi.textual.grammar.IModelAdapter;
import com.sap.mi.textual.grammar.ParserFacade;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.DelegationParsingObserver;
import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.Connection;

public class CtsContentAssistProcessor implements IContentAssistProcessor {

	private Class<? extends Lexer> lexerClass;
	private Class<? extends Parser> parserClass;
	private final String language;
	private ConcreteSyntax syntax;
	private Map<List<String>, Map<String, ClassTemplate>> classTemplateMap = null;
	private CtsContentAssistParsingHandler parsingHandler = null;
	private Connection connection;

	public CtsContentAssistProcessor(Connection connection,
			Class<? extends Lexer> lexerClass,
			Class<? extends Parser> parserClass, String language) {
		this.language = language;
		Assert.isNotNull(connection, "moin connection is null");
		this.lexerClass = lexerClass;
		this.parserClass = parserClass;
		this.syntax = getSyntax(connection, language);
		this.connection = connection;

		if (syntax == null) {
			throw new IllegalStateException(
					"Syntax definition model for language '" + language
							+ "' does not exist in connection.");
		}

		initClassTemplateMap();
	}

	public CtsContentAssistProcessor(ConcreteSyntax syntax,
			Class<? extends Lexer> lexerClass,
			Class<? extends Parser> parserClass, String language) {
		this.language = language;
		this.lexerClass = lexerClass;
		this.parserClass = parserClass;
		this.syntax = syntax;
		Assert.isNotNull(syntax, "ConcreteSyntax is null");

		this.connection = TcsUtil.getConnectionFromRefObject(syntax);
		Assert.isNotNull(connection, "moin connection is null");

		initClassTemplateMap();
	}

	/**
	 * offset = 0..n-1
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {

		try {
			int line = getLine(viewer, offset);
			int charPositionInLine = getCharPositionInLine(viewer, offset, line);

			return computeCompletionProposals(viewer, line, charPositionInLine);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param viewer
	 * @param offset
	 *            0..n-1
	 * @param line
	 *            0..n-1
	 * @return
	 * @throws BadLocationException
	 */
	private int getCharPositionInLine(ITextViewer viewer, int offset, int line)
			throws BadLocationException {
		IRegion lineRegion = viewer.getDocument().getLineInformation(line);
		return offset - lineRegion.getOffset();
	}

	/**
	 * 
	 * @param viewer
	 * @param offset
	 *            0..n-1
	 * @return
	 * @throws BadLocationException
	 */
	private int getLine(ITextViewer viewer, int offset)
			throws BadLocationException {
		return viewer.getDocument().getLineOfOffset(offset);
	}

	private int getLine(Token token) {
		// ANTRL lines start at 1
		return token.getLine() - 1;
	}

	private int getCharPositionInLine(Token token) {
		// ANTRL line positions start at 0
		return token.getCharPositionInLine();
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int line, int charPositionInLine) {
		TextBlocksModel tbModel = null;
		IDocument doc = viewer.getDocument();
		if (doc instanceof CtsDocument) {
			TextBlocksModelStore store = ((CtsDocument) doc)
					.getTextBlocksModelStore();
			if (store != null) {
				tbModel = store.getModel();
			}
		}

		return computeCompletionProposals(viewer, line, charPositionInLine,
				tbModel);
	}

	/**
	 * 
	 * @param viewer
	 * @param line
	 *            0...n
	 * @param charPositionInLine
	 *            0..n
	 * @return
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int line, int charPositionInLine, TextBlocksModel tbModel) {

		try {
			List<ICompletionProposal> results = null;

			initParsingHandler(viewer);

			String prefix = "";

			if (!inComment(viewer, line, charPositionInLine)) {

				CtsContentAssistContext context = getContext(line,
						charPositionInLine);

				if (!isValid(context)) {
					// no floor context, get first possible proposals

					results = CtsContentAssistUtil
							.createFirstPossibleProposals(syntax,
									classTemplateMap, viewer, line,
									charPositionInLine, null, tbModel);

					// TODO workaround because ANTRL will not create error token
					// for unlexed characters
					// TODO this assumes languages with standard whitespaces
					// filter by currently un-tokenized non-whitespace prefix

					int curOffset = getAbsoluteOffset(viewer, line,
							charPositionInLine);

					// stop just before start of current line
					int stopOffset = getAbsoluteOffset(viewer, line, 0) - 1;

					prefix = CtsContentAssistUtil.computeNonWhitespacePrefix(
							getDocumentContents(viewer), curOffset, stopOffset);

					results = prefixFilter(removeNullValues(results), prefix);

					// end workaround

				} else {
					// we are at or past a token
					if (CtsContentAssistUtil.isInToken(line,
							charPositionInLine, context.getToken())) {

						CtsContentAssistContext previousContext = getPreviousContext(
								context, viewer);

						// get proposals that follow previous token, and apply
						// prefix filter

						if (!isValid(previousContext)
								|| previousContext.isErrorContext()) {
							results = CtsContentAssistUtil
									.createFirstPossibleProposals(syntax,
											classTemplateMap, viewer, line,
											charPositionInLine, context
													.getToken(), tbModel);
						} else {
							// get proposals that follow token
							results = CtsContentAssistUtil
									.createFollowProposalsFromContext(syntax,
											previousContext, classTemplateMap,
											viewer, line, charPositionInLine,
											context.getToken(), tbModel);
						}

						// compute prefix from token text
						prefix = context.getToken().getText().substring(
								0,
								charPositionInLine
										- context.getToken()
												.getCharPositionInLine());

						results = prefixFilter(removeNullValues(results),
								prefix);

						// also get following proposals when after the last char
						// of
						// a token

						// TODO maybe make this dependent on token type and
						// symbol
						// space variables
						if (previousContext != null
								&& isAtEndOfToken(line, charPositionInLine,
										context.getToken())) {
							results.addAll(CtsContentAssistUtil
									.createFollowProposalsFromContext(syntax,
											context, classTemplateMap, viewer,
											line, charPositionInLine, null,
											tbModel));

							// not prefix-filtered
						}

					} else {
						// get proposals that follow token
						results = CtsContentAssistUtil
								.createFollowProposalsFromContext(syntax,
										context, classTemplateMap, viewer,
										line, charPositionInLine, context
												.getToken(), tbModel);

						// TODO workaround because ANTRL will not create error
						// token
						// for unlexed characters
						// TODO this assumes languages with standard whitespaces
						// filter by currently un-tokenized non-whitespace
						// prefix

						int curOffset = getAbsoluteOffset(viewer, line,
								charPositionInLine);

						// stop at beginning of last valid token
						int stopOffset = viewer.getDocument()
								.getLineInformation(
										context.getToken().getLine() - 1)
								.getOffset()
								+ context.getToken().getCharPositionInLine();

						prefix = CtsContentAssistUtil
								.computeNonWhitespacePrefix(
										getDocumentContents(viewer), curOffset,
										stopOffset);

						results = prefixFilter(removeNullValues(results),
								prefix);
					}

					// end workaround
				}

				return proposalListAsArray(sortProposals(
						removeDuplicates(removeNullValues(results)), prefix));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// clear transient partitions used by content assist
			TcsUtil.clearTransientPartition(connection);
			CtsContentAssistParsingHandler.clearTransientPartition(connection);
		}

		return null;

	}

	private boolean inComment(ITextViewer viewer, int line,
			int charPositionInLine) throws BadLocationException {
		IRegion lineInfo = viewer.getDocument().getLineInformation(line);
		String curLine = getDocumentContents(viewer).substring(
				lineInfo.getOffset(),
				lineInfo.getOffset() + lineInfo.getLength());

		// TODO update this when other forms than end of line comments
		// become possible
		int commentStart = curLine.indexOf(TcsUtil
				.getEndOfLineCommentPrefix(TcsUtil.getCommentToken(syntax)));
		if (commentStart != -1) {
			if (charPositionInLine > commentStart) {
				return true;
			}
		}

		return false;
	}

	private int getAbsoluteOffset(ITextViewer viewer, int line,
			int charPositionInLine) throws BadLocationException {
		return viewer.getDocument().getLineInformation(line).getOffset()
				+ charPositionInLine;
	}

	/**
	 * determines wheater a context is valid and corresponds to parsed token
	 * 
	 * @param context
	 * @return
	 */
	private boolean isValid(CtsContentAssistContext context) {
		if (context == null) {
			return false;
		}

		if (context.getToken() == null) {
			return false;
		}

		if (getCharPositionInLine(context.getToken()) == -1) {
			return false;
		}

		return true;
	}

	private void initParsingHandler(ITextViewer viewer) throws IOException,
			UnknownProductionRuleException,
			InvalidParserImplementationException {
		ParserFacade facade;
		facade = new ParserFacade(getParserClass(), getLexerClass());

		String documentContents = getDocumentContents(viewer);
		InputStream in = new ByteArrayInputStream(documentContents.getBytes());
		IModelAdapter modelHandler = new TextBlocksAwareModelAdapter(
				new StubModelAdapter());

		if (syntax == null) {
			throw new IllegalStateException(
					"Syntax definition model for language '" + language
							+ "' does not exist in connection.");
		}

		// use delegator to monitor exceptions
		DelegationParsingObserver delegator = new DelegationParsingObserver();
		parsingHandler = new CtsContentAssistParsingHandler(syntax);
		delegator.addParsingObserver(parsingHandler);

		facade.parseProductionRule(in, modelHandler, null, null, delegator);

	}

	private String getDocumentContents(ITextViewer viewer) {
		return viewer.getDocument().get();
	}

	private void initClassTemplateMap() {
		classTemplateMap = TcsUtil.createClassTemplateMap(syntax);
	}

	private CtsContentAssistContext getPreviousContext(
			CtsContentAssistContext context, ITextViewer viewer)
			throws BadLocationException {
		// get the context one offset before this context
		return getContext(getLine(context.getToken()),
				getCharPositionInLine(context.getToken()) - 1);
	}

	private CtsContentAssistContext getContext(int line, int charPositionInLine)
			throws BadLocationException {

		return parsingHandler.getFloorContext(line, charPositionInLine);
	}

	private static ConcreteSyntax getSyntax(Connection connection,
			String language) {
		List<ConcreteSyntax> syntaxList = TcsUtil
				.getSyntaxesInConnection(connection);

		for (ConcreteSyntax syntax : syntaxList) {
			if (syntax != null && syntax.getName() != null
					&& syntax.getName().equals(language)) {
				return syntax;
			}
		}
		return null;
	}

	static boolean isAtEndOfToken(int line, int charPositionInLine, Token t) {
		// ANTLR lines start at 1 and char positions at 0
		if (line + 1 != t.getLine()) {
			return false;
		}

		if (charPositionInLine == t.getCharPositionInLine()
				+ t.getText().length()) {
			return true;
		}

		return false;
	}

	static boolean containsDisplayString(List<ICompletionProposal> proposals,
			String displayString) {
		for (ICompletionProposal p : proposals) {
			if (p.getDisplayString().equals(displayString)) {
				return true;
			}
		}

		return false;
	}

	static List<ICompletionProposal> removeDuplicates(
			List<ICompletionProposal> input) {

		if (input == null) {
			return null;
		}

		List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

		for (ICompletionProposal proposal : input) {
			if (!containsDisplayString(results, proposal.getDisplayString())) {
				results.add(proposal);
			}
		}

		return results;
	}

	public static List<ICompletionProposal> removeNullValues(
			List<ICompletionProposal> input) {
		if (input == null) {
			return null;
		}

		List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

		for (ICompletionProposal proposal : input) {
			if (proposal != null) {
				results.add(proposal);
			}
		}

		return results;
	}

	static List<ICompletionProposal> sortProposals(
			List<ICompletionProposal> input, String prefix) {
		if (input == null) {
			return null;
		}

		List<ICompletionProposal> results = new ArrayList<ICompletionProposal>(
				input);

		Collections.sort(results, new CompletionProposalsComparator(prefix));

		return results;

	}

	static class CompletionProposalsComparator implements
			Comparator<ICompletionProposal> {

		/**
		 * proposals that start with the prefix come first
		 */
		private String prefix;

		public CompletionProposalsComparator(String prefix) {
			this.prefix = prefix;
		}

		@Override
		public int compare(ICompletionProposal a, ICompletionProposal b) {
			boolean aTop = a.getDisplayString().startsWith(prefix);
			boolean bTop = b.getDisplayString().startsWith(prefix);

			if (aTop && bTop) {
				return a.getDisplayString().compareTo(b.getDisplayString());
			}

			if (aTop) {
				return -1;
			}

			if (bTop) {
				return 1;
			}

			// !aTop and !bTop
			return a.getDisplayString().compareTo(b.getDisplayString());

		}

	};

	static List<ICompletionProposal> prefixFilter(
			List<ICompletionProposal> input, String prefix) {

		List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
		for (ICompletionProposal proposal : input) {
			if (proposal.getDisplayString().startsWith(prefix)) {
				results.add(proposal);
			}
		}

		return results;
	}

	static ICompletionProposal[] proposalListAsArray(
			List<ICompletionProposal> proposalList) {
		if (proposalList == null) {
			return null;
		}
		return proposalList.toArray(new ICompletionProposal[0]);
	}

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	protected Class<? extends Lexer> getLexerClass() {
		return lexerClass;
	}

	protected Class<? extends Parser> getParserClass() {
		return parserClass;
	}

}
