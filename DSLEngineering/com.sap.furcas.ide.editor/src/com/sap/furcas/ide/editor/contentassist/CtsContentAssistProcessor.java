package com.sap.furcas.ide.editor.contentassist;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.Lexer;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.contentassist.modeladapter.StubModelAdapter;
import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DelegationParsingObserver;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.TextBlocksAwareModelAdapter;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;

public class CtsContentAssistProcessor {

    private final Class<? extends Lexer> lexerClass;
    private final Class<? extends ObservableInjectingParser> parserClass;
    private final String language;
    private final ConcreteSyntax syntax;
    private Map<List<String>, Map<String, ClassTemplate>> classTemplateMap = null;
    private CtsContentAssistParsingHandler parsingHandler = null;

    public CtsContentAssistProcessor(ConcreteSyntax syntax, Class<? extends Lexer> lexerClass,
            Class<? extends ObservableInjectingParser> parserClass, String language) {
        this.language = language;
        this.lexerClass = lexerClass;
        this.parserClass = parserClass;
        this.syntax = syntax;
        Assert.isNotNull(syntax, "ConcreteSyntax is null");

        initClassTemplateMap();
    }

    /**
     * offset = 0..n-1
     */
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
        try {
            int line = CtsContentAssistUtil.getLine(viewer, offset);
            int charPositionInLine = getCharPositionInLine(viewer, offset, line);

            return computeCompletionProposals(viewer, line, charPositionInLine);
        } catch (BadLocationException e) {
            CtsActivator.logError(e);
        }
        return new ICompletionProposal[0];
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
    private static int getCharPositionInLine(ITextViewer viewer, int offset, int line) throws BadLocationException {
        IRegion lineRegion = viewer.getDocument().getLineInformation(line);
        return offset - lineRegion.getOffset();
    }

    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int line, int charPositionInLine) {
        TextBlocksModel tbModel = null;
        IDocument doc = viewer.getDocument();
        if (doc instanceof CtsDocument) {
            tbModel = new TextBlocksModel(((CtsDocument) doc).getRootBlock(), /*modelAdapter*/ null);
        }
        return computeCompletionProposals(viewer, line, charPositionInLine, tbModel);
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
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int line, int charPositionInLine,
            TextBlocksModel tbModel) {

        try {
            List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
            initParsingHandler(viewer);
            String prefix = "";

            if (!inComment(viewer, line, charPositionInLine)) {

                CtsContentAssistContext context = getContext(line, charPositionInLine);

                // workaround for ANTLR unlexed tokens that get parsed but start with whitespace
                if (context != null) {
                    if (CtsContentAssistUtil.isContextAtWhitespace(viewer, context)) {
                        context = getPreviousContext(context);
                    }
                }

                if (!isValid(context)) {
                    // no floor context, get first possible proposals

                    results = CtsContentAssistUtil.createFirstPossibleProposals(syntax, classTemplateMap, viewer, line,
                            charPositionInLine, null, tbModel);

                    // TODO workaround because ANTRL will not create error token
                    // for unlexed characters
                    // TODO this assumes languages with standard whitespaces
                    // filter by currently un-tokenized non-whitespace prefix

                    int curOffset = CtsContentAssistUtil.getAbsoluteOffset(viewer, line, charPositionInLine);

                    // stop just before start of current line
                    int stopOffset = CtsContentAssistUtil.getAbsoluteOffset(viewer, line, 0) - 1;

                    prefix = CtsContentAssistUtil.computeNonWhitespacePrefix(CtsContentAssistUtil.getDocumentContents(viewer),
                            curOffset, stopOffset);

                    results = prefixFilter(removeNullValues(results), prefix);
                    // end workaround

                } else {

                    if (context.getToken().getText() == null) {
                        // TODO workaround as ANTLR does not create a correct
                        // token for unlexed content
                        CtsContentAssistUtil.fixTokenText(viewer, context.getToken());
                    }

                    if (CtsContentAssistUtil.isInToken(line, charPositionInLine, context.getToken())) {

                        CtsContentAssistContext previousContext = getPreviousContext(context);

                        // get proposals that follow previous token, and apply
                        // prefix filter

                        if (!isValid(previousContext)) {
                            results = CtsContentAssistUtil.createFirstPossibleProposals(syntax, classTemplateMap, viewer, line,
                                    charPositionInLine, context.getToken(), tbModel);
                        } else {
                            results = CtsContentAssistUtil.createFollowProposalsFromContext(syntax, previousContext,
                                    classTemplateMap, viewer, line, charPositionInLine, context.getToken(), tbModel);
                        }

                        // compute prefix from token text
                        prefix = computePrefixFromContext(charPositionInLine, context);

                        results = prefixFilter(removeNullValues(results), prefix);

                        // also get following proposals when after the last char
                        // of
                        // a token

                        // TODO maybe make this dependent on token type and
                        // symbol
                        // space variables
                        if (previousContext != null
                                && CtsContentAssistUtil.isAtEndOfToken(line, charPositionInLine, context.getToken())) {
                            results.addAll(CtsContentAssistUtil.createFollowProposalsFromContext(syntax, context,
                                    classTemplateMap, viewer, line, charPositionInLine, null, tbModel));

                            // not prefix-filtered
                        }

                    } else {
                        if (!context.isErrorContext()) {
                            // get proposals that follow token
                            results = CtsContentAssistUtil.createFollowProposalsFromContext(syntax, context, classTemplateMap,
                                    viewer, line, charPositionInLine, context.getToken(), tbModel);
                        }

                    }
                }

                return proposalListAsArray(sortProposals(removeDuplicates(removeNullValues(results)), prefix));
            }

        } catch (Exception e) {
            CtsActivator.logError(e);
        }
        return null;
    }

    private String computePrefixFromContext(int charPositionInLine, CtsContentAssistContext context) {
        String prefix;
        prefix = context.getToken().getText().substring(0, charPositionInLine - context.getToken().getCharPositionInLine());
        return prefix;
    }

    private boolean inComment(ITextViewer viewer, int line, int charPositionInLine) throws BadLocationException {
        IRegion lineInfo = viewer.getDocument().getLineInformation(line);
        String curLine = CtsContentAssistUtil.getDocumentContents(viewer).substring(lineInfo.getOffset(),
                lineInfo.getOffset() + lineInfo.getLength());

        // TODO update this when other forms than end of line comments
        // become possible
        int commentStart = curLine.indexOf(TcsUtil.getEndOfLineCommentPrefix(TcsUtil.getCommentToken(syntax)));
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

    private void initParsingHandler(ITextViewer viewer) throws IOException, UnknownProductionRuleException,
            InvalidParserImplementationException {
        ParserFacade facade;
        facade = new ParserFacade(parserClass, lexerClass, language);

        String documentContents = CtsContentAssistUtil.getDocumentContents(viewer);
        InputStream in = new ByteArrayInputStream(documentContents.getBytes());
        IModelAdapter modelHandler = new TextBlocksAwareModelAdapter(new StubModelAdapter());

        if (syntax == null) {
            throw new IllegalStateException("Syntax definition model for language '" + language
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

    private CtsContentAssistContext getPreviousContext(CtsContentAssistContext context) {
        // get the context one offset before this context
        return getContext(CtsContentAssistUtil.getLine(context.getToken()),
                CtsContentAssistUtil.getCharPositionInLine(context.getToken()) - 1);
    }

    private CtsContentAssistContext getContext(int line, int charPositionInLine) {
        return parsingHandler.getFloorContext(line, charPositionInLine);
    }

    static boolean containsDisplayString(List<ICompletionProposal> proposals, String displayString) {
        for (ICompletionProposal p : proposals) {
            if (p.getDisplayString().equals(displayString)) {
                return true;
            }
        }

        return false;
    }

    static List<ICompletionProposal> removeDuplicates(List<ICompletionProposal> input) {
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

    public static List<ICompletionProposal> removeNullValues(List<ICompletionProposal> input) {
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

    static List<ICompletionProposal> sortProposals(List<ICompletionProposal> input, String prefix) {
        if (input == null) {
            return null;
        }
        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>(input);
        Collections.sort(results, new CompletionProposalsComparator(prefix));
        return results;
    }

    static class CompletionProposalsComparator implements Comparator<ICompletionProposal> {

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

    static List<ICompletionProposal> prefixFilter(List<ICompletionProposal> input, String prefix) {
        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
        for (ICompletionProposal proposal : input) {
            if (proposal.getDisplayString().startsWith(prefix)) {
                results.add(proposal);
            }
        }
        return results;
    }

    static ICompletionProposal[] proposalListAsArray(List<ICompletionProposal> proposalList) {
        if (proposalList == null) {
            return null;
        }
        return proposalList.toArray(new ICompletionProposal[0]);
    }

}
