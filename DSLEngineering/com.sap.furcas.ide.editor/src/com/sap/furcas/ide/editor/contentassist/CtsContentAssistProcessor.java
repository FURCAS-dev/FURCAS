package com.sap.furcas.ide.editor.contentassist;

import static com.sap.furcas.ide.editor.contentassist.CompletionProposalHelper.prefixFilter;
import static com.sap.furcas.ide.editor.contentassist.CompletionProposalHelper.proposalListAsArray;
import static com.sap.furcas.ide.editor.contentassist.CompletionProposalHelper.removeDuplicates;
import static com.sap.furcas.ide.editor.contentassist.CompletionProposalHelper.removeNullValues;
import static com.sap.furcas.ide.editor.contentassist.CompletionProposalHelper.sortProposals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
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
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.impl.DelegationParsingObserver;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;

public class CtsContentAssistProcessor implements IContentAssistProcessor {

    /**
     * contains a mapping of qualifiedName + Mode to ClassTemplate of all
     * ClassTemplates contained in the ConcreteSyntax passed to the constructor
     */
    private final Map<List<String>, Map<String, ClassTemplate>> classTemplateMap;

    /**
     * contains a mapping of qualifiedName to OperatorTemplate of all
     * OperatorTemplates contained in the ConcreteSyntax passed to the
     * constructor
     */
    private final Map<List<String>, OperatorTemplate> operatorTemplateMap;
    
    
    private final ConcreteSyntax syntax;
    private final ResourceSet resourceSet;
    private final Query2OppositeEndFinder oppositeEndFinder;
    private final TCSSpecificOCLEvaluator oclEvaluator;
    
    private final ParserFacade facade;
    private CtsContentAssistParsingHandler parsingHandler = null;

    public CtsContentAssistProcessor(IncrementalParserFacade parserFacade) {

        this.syntax = parserFacade.getParserScope().getSyntax();
        this.resourceSet = parserFacade.getParserScope().getResourceSet();
        Assert.isNotNull(resourceSet, "moin connection is null");

        QueryContextProvider queryContext = EcoreHelper.createProjectDependencyQueryContextProvider(resourceSet,
                parserFacade.getParserFactory().getAdditionalQueryScope());
        this.oppositeEndFinder = new Query2OppositeEndFinder(queryContext);
        this.oclEvaluator = new TCSSpecificOCLEvaluator(oppositeEndFinder);

        classTemplateMap = TcsUtil.createClassTemplateMap(syntax);
        operatorTemplateMap = TcsUtil.createOperatorTemplateMap(syntax);
        
        try {
            facade = new ParserFacade(parserFacade.getParserFactory().getParserClass(), parserFacade.getParserFactory().getLexerClass(),
                    parserFacade.getParserFactory().getLanguageId());
        } catch (InvalidParserImplementationException e) {
            throw new RuntimeException("Failed to initialize the Content Assist", e);
        }
    }

    /**
     * offset = 0..n-1
     */
    @Override
    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {

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
    private static int getCharPositionInLine(ITextViewer viewer, int offset, int line) throws BadLocationException {
        IRegion lineRegion = viewer.getDocument().getLineInformation(line);
        return offset - lineRegion.getOffset();
    }

    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int line, int charPositionInLine) {
        TextBlocksModel tbModel = null;
        IDocument doc = viewer.getDocument();
        if (doc instanceof CtsDocument) {
            tbModel = new TextBlocksModel(((CtsDocument) doc).getRootBlock(), null);
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

            parsingHandler = initParsingHandler(viewer);

            String prefix = "";

            if (!inComment(viewer, line, charPositionInLine)) {

                CtsContentAssistContext context = getContext(line, charPositionInLine);

                // workaround for ANTLR unlexed tokens that get parsed but start
                // with whitespace
                if (context != null) {

                    if (CtsContentAssistUtil.isContextAtWhitespace(viewer, context)) {
                        context = getPreviousContext(context, viewer);
                    }
                }

                if (!isValid(context)) {
                    // no floor context, get first possible proposals

                    results = CtsContentAssistUtil.createFirstPossibleProposals(syntax, classTemplateMap, viewer, line,
                            charPositionInLine, null, tbModel, oclEvaluator);

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

                        CtsContentAssistContext previousContext = getPreviousContext(context, viewer);

                        // get proposals that follow previous token, and apply
                        // prefix filter

                        if (!isValid(previousContext)) {

                            results = CtsContentAssistUtil.createFirstPossibleProposals(syntax, classTemplateMap, viewer, line,
                                    charPositionInLine, context.getToken(), tbModel, oclEvaluator);
                        } else {
                            results = CtsContentAssistUtil
                                    .createFollowProposalsFromContext(syntax, previousContext, classTemplateMap, viewer, line,
                                            charPositionInLine, context.getToken(), tbModel, oclEvaluator);
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
                                    classTemplateMap, viewer, line, charPositionInLine, null, tbModel, oclEvaluator));

                            // not prefix-filtered
                        }

                    } else {
                        if (!context.isErrorContext()) {
                            // get proposals that follow token
                            results = CtsContentAssistUtil.createFollowProposalsFromContext(syntax, context, classTemplateMap,
                                    viewer, line, charPositionInLine, context.getToken(), tbModel, oclEvaluator);
                        }

                    }
                }

                return proposalListAsArray(sortProposals(removeDuplicates(removeNullValues(results)), prefix));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            // clear transient partitions used by content assist
            TcsUtil.clearTransientPartition(resourceSet);
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

    private CtsContentAssistParsingHandler initParsingHandler(ITextViewer viewer) throws IOException, UnknownProductionRuleException {
        String documentContents = CtsContentAssistUtil.getDocumentContents(viewer);
        InputStream in = new ByteArrayInputStream(documentContents.getBytes());
        IModelAdapter modelHandler = new DefaultTextAwareModelAdapter(new StubModelAdapter());

        // use delegator to monitor exceptions
        DelegationParsingObserver delegator = new DelegationParsingObserver();
        CtsContentAssistParsingHandler handler = new CtsContentAssistParsingHandler(resourceSet, classTemplateMap, operatorTemplateMap);
        delegator.addParsingObserver(handler);

        facade.parseProductionRule(in, modelHandler, null, null, delegator);
        return handler;
    }

    private CtsContentAssistContext getPreviousContext(CtsContentAssistContext context, ITextViewer viewer) {
        // get the context one offset before this context
        return getContext(CtsContentAssistUtil.getLine(context.getToken()),
                CtsContentAssistUtil.getCharPositionInLine(context.getToken()) - 1);
    }

    private CtsContentAssistContext getContext(int line, int charPositionInLine) {
        return parsingHandler.getFloorContext(line, charPositionInLine);
    }

    @Override
    public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
        return null;
    }

    @Override
    public char[] getCompletionProposalAutoActivationCharacters() {
        return null;
    }

    @Override
    public char[] getContextInformationAutoActivationCharacters() {
        return null;
    }

    @Override
    public IContextInformationValidator getContextInformationValidator() {
        return null;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

}
