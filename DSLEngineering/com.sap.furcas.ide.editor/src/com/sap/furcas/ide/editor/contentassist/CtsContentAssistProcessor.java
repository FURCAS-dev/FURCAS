package com.sap.furcas.ide.editor.contentassist;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import com.sap.furcas.ide.editor.contentassist.modeladapter.StubModelAdapter;
import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DelegationParsingObserver;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.TextBlocksAwareModelAdapter;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;


public class CtsContentAssistProcessor implements IContentAssistProcessor {

	private final Class<? extends Lexer> lexerClass;
	private final Class<? extends ObservableInjectingParser> parserClass;
	private final String language;
	private final ConcreteSyntax syntax;
	private Map<List<String>, Map<String, ClassTemplate>> classTemplateMap = null;
	private CtsContentAssistParsingHandler parsingHandler = null;
	private final ResourceSet connection;
        private final Query2OppositeEndFinder oppositeEndFinder;
        private final TCSSpecificOCLEvaluator oclEvaluator;

        /** FIXME: This content assist interface can have crude side affects.
         * It will lead to dataloss due to reverting of the connection!
         */
	public CtsContentAssistProcessor(ResourceSet connection,
			AbstractParserFactory<ObservableInjectingParser, Lexer> parserFactory, String language) {
		this.language = language;
		Assert.isNotNull(connection, "moin connection is null");
		this.lexerClass = parserFactory.getLexerClass();
		this.parserClass = parserFactory.getParserClass();
		this.syntax = getSyntax(connection, language);
		this.connection = connection;
		
		Set<URI> parserLookupScope = parserFactory.getParserLookupScope(connection);
		if(parserLookupScope == null) {
		    parserLookupScope = Collections.emptySet();
		}
                QueryContextProvider queryContext = EcoreHelper.createProjectDependencyQueryContextProvider(connection,
		        parserLookupScope);
	        this.oppositeEndFinder = new Query2OppositeEndFinder(queryContext);
	        this.oclEvaluator = new TCSSpecificOCLEvaluator(oppositeEndFinder);

		if (syntax == null) {
			throw new IllegalStateException(
					"Syntax definition model for language '" + language
							+ "' does not exist in connection.");
		}

		initClassTemplateMap();
	}
	
        /** FIXME: This content assist interface can have crude side affects.
         * It will lead to dataloss due to reverting of the connection!
         */
	public CtsContentAssistProcessor(ConcreteSyntax syntax,
	        AbstractParserFactory<ObservableInjectingParser, Lexer> parserFactory, String language) {
		this.language = language;
		this.lexerClass = parserFactory.getLexerClass();
                this.parserClass = parserFactory.getParserClass();
		this.syntax = syntax;
		Assert.isNotNull(syntax, "ConcreteSyntax is null");
		
		this.connection = syntax.eResource().getResourceSet();
                Assert.isNotNull(connection, "moin connection is null");
		
		QueryContextProvider queryContext = EcoreHelper.createProjectDependencyQueryContextProvider(connection, 
		        parserFactory.getParserLookupScope(connection));
                this.oppositeEndFinder = new Query2OppositeEndFinder(queryContext);
                this.oclEvaluator = new TCSSpecificOCLEvaluator(oppositeEndFinder);

		initClassTemplateMap();
	}

    /**
	 * offset = 0..n-1
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {

		try {
			int line = CtsContentAssistUtil.getLine(viewer, offset);
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
	private static int getCharPositionInLine(ITextViewer viewer, int offset,
			int line) throws BadLocationException {
		IRegion lineRegion = viewer.getDocument().getLineInformation(line);
		return offset - lineRegion.getOffset();
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int line, int charPositionInLine) {
		TextBlocksModel tbModel = null;
		IDocument doc = viewer.getDocument();
		if (doc instanceof CtsDocument) {
		    tbModel = new TextBlocksModel(((CtsDocument) doc).getRootBlock(), null);
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
			List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();

			initParsingHandler(viewer);

			String prefix = "";

			if (!inComment(viewer, line, charPositionInLine)) {

				CtsContentAssistContext context = getContext(line,
						charPositionInLine);

				// workaround for ANTLR unlexed tokens that get parsed but start
				// with whitespace
				if (context != null) {

					if (CtsContentAssistUtil.isContextAtWhitespace(viewer,
							context)) {
						context = getPreviousContext(context, viewer);
					}
				}

				if (!isValid(context)) {
					// no floor context, get first possible proposals

					results = CtsContentAssistUtil
							.createFirstPossibleProposals(syntax,
									classTemplateMap, viewer, line,
									charPositionInLine, null, tbModel, oclEvaluator);

					// TODO workaround because ANTRL will not create error token
					// for unlexed characters
					// TODO this assumes languages with standard whitespaces
					// filter by currently un-tokenized non-whitespace prefix

					int curOffset = CtsContentAssistUtil.getAbsoluteOffset(
							viewer, line, charPositionInLine);

					// stop just before start of current line
					int stopOffset = CtsContentAssistUtil.getAbsoluteOffset(
							viewer, line, 0) - 1;

					prefix = CtsContentAssistUtil.computeNonWhitespacePrefix(
							CtsContentAssistUtil.getDocumentContents(viewer),
							curOffset, stopOffset);

					results = prefixFilter(removeNullValues(results), prefix);

					// end workaround

				} else {

					if (context.getToken().getText() == null) {
						// TODO workaround as ANTLR does not create a correct
						// token for unlexed content
						CtsContentAssistUtil.fixTokenText(viewer, context
								.getToken());
					}

					if (CtsContentAssistUtil.isInToken(line,
							charPositionInLine, context.getToken())) {

						CtsContentAssistContext previousContext = getPreviousContext(
								context, viewer);

						// get proposals that follow previous token, and apply
						// prefix filter

						if (!isValid(previousContext)) {

							results = CtsContentAssistUtil
									.createFirstPossibleProposals(syntax,
											classTemplateMap, viewer, line,
											charPositionInLine, context
													.getToken(), tbModel, oclEvaluator);
						} else {
							results = CtsContentAssistUtil
									.createFollowProposalsFromContext(syntax,
											previousContext, classTemplateMap,
											viewer, line, charPositionInLine,
											context.getToken(), tbModel, oclEvaluator);
						}

						// compute prefix from token text
						prefix = computePrefixFromContext(charPositionInLine,
								context);

						results = prefixFilter(removeNullValues(results),
								prefix);

						// also get following proposals when after the last char
						// of
						// a token

						// TODO maybe make this dependent on token type and
						// symbol
						// space variables
						if (previousContext != null
								&& CtsContentAssistUtil.isAtEndOfToken(line,
										charPositionInLine, context.getToken())) {
							results.addAll(CtsContentAssistUtil
									.createFollowProposalsFromContext(syntax,
											context, classTemplateMap, viewer,
											line, charPositionInLine, null,
											tbModel, oclEvaluator));

							// not prefix-filtered
						}

					} else {
						if (!context.isErrorContext()) {
							// get proposals that follow token
							results = CtsContentAssistUtil
									.createFollowProposalsFromContext(syntax,
											context, classTemplateMap, viewer,
											line, charPositionInLine, context
													.getToken(), tbModel,
													oclEvaluator);
						}

					}
				}

				return proposalListAsArray(sortProposals(
						removeDuplicates(removeNullValues(results)), prefix));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			// clear transient partitions used by content assist
			//TcsUtil.clearTransientPartition(connection);
			CtsContentAssistParsingHandler.clearTransientPartition(connection);
		}

		return null;

	}

	private String computePrefixFromContext(int charPositionInLine,
			CtsContentAssistContext context) {
		String prefix;
		prefix = context.getToken().getText()
				.substring(
						0,
						charPositionInLine
								- context.getToken().getCharPositionInLine());
		return prefix;
	}

	private boolean inComment(ITextViewer viewer, int line,
			int charPositionInLine) throws BadLocationException {
		IRegion lineInfo = viewer.getDocument().getLineInformation(line);
		String curLine = CtsContentAssistUtil.getDocumentContents(viewer)
				.substring(lineInfo.getOffset(),
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

		if (CtsContentAssistUtil.getCharPositionInLine(context.getToken()) == -1) {
			return false;
		}

		return true;
	}

	private void initParsingHandler(ITextViewer viewer) throws IOException,
			UnknownProductionRuleException,
			InvalidParserImplementationException {
		ParserFacade facade;
		facade = new ParserFacade(getParserClass(), getLexerClass(), language);

		String documentContents = CtsContentAssistUtil
				.getDocumentContents(viewer);
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

	private void initClassTemplateMap() {
		classTemplateMap = TcsUtil.createClassTemplateMap(syntax);
	}

	private CtsContentAssistContext getPreviousContext(
			CtsContentAssistContext context, ITextViewer viewer) {
		// get the context one offset before this context
		return getContext(
				CtsContentAssistUtil.getLine(context.getToken()),
				CtsContentAssistUtil.getCharPositionInLine(context.getToken()) - 1);
	}

	private CtsContentAssistContext getContext(int line, int charPositionInLine) {

		return parsingHandler.getFloorContext(line, charPositionInLine);
	}

	private static ConcreteSyntax getSyntax(ResourceSet connection,
			String language) {
		List<ConcreteSyntax> syntaxList = TcsUtil
				.getSyntaxesInResourceSet(connection);

		for (ConcreteSyntax syntax : syntaxList) {
			if (syntax != null && syntax.getName() != null
					&& syntax.getName().equals(language)) {
				return syntax;
			}
		}
		return null;
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
		private final String prefix;

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

	protected Class<? extends ObservableInjectingParser> getParserClass() {
		return parserClass;
	}

}
