package com.sap.furcas.ide.editor.contentassist;


import static com.sap.furcas.ide.editor.contentassist.CompletionListHelper.prefixFilter;
import static com.sap.furcas.ide.editor.contentassist.CompletionListHelper.proposalListAsArray;
import static com.sap.furcas.ide.editor.contentassist.CompletionListHelper.removeDuplicates;
import static com.sap.furcas.ide.editor.contentassist.CompletionListHelper.removeNullValues;
import static com.sap.furcas.ide.editor.contentassist.CompletionListHelper.sortProposals;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.computeNonWhitespacePrefix;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.fixTokenText;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.getAbsoluteOffset;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.getDocumentContents;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.getLine;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.isAtEndOfToken;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.isContextAtWhitespace;
import static com.sap.furcas.ide.editor.contentassist.CtsContentAssistUtil.isInToken;

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
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.ide.editor.contentassist.modeladapter.StubModelAdapter;
import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
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


/**
 * Implements a content assists which is used by the editor framework. This
 * class basically serves as facade. The actual completion is calculated
 * by {@link CtsCompletionCalculator}.
 * 
 * It can derive completion proposals based on a given {@link ConcreteSyntax}
 * and a position within a text document. 
 * 
 * @author Philipp Meier
 * 
 */
public class CtsContentAssistProcessor {

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
    private final OppositeEndFinder oppositeEndFinder;
    private final TCSSpecificOCLEvaluator oclEvaluator;
    
    private final ParserFacade facade;
    private CtsContentAssistParsingHandler parsingHandler = null;

    public CtsContentAssistProcessor(IncrementalParserFacade parserFacade) {

        this.syntax = parserFacade.getParserScope().getSyntax();
        this.resourceSet = parserFacade.getParserScope().getResourceSet();
        Assert.isNotNull(resourceSet, "moin connection is null");

        this.oppositeEndFinder = parserFacade.getOppositeEndFinder();
        this.oclEvaluator = parserFacade.getOclEvaluator();

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

    private ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int line, int charPositionInLine) {
        TextBlocksModel tbModel = null;
        IDocument doc = viewer.getDocument();
        if (doc instanceof CtsDocument) {
            tbModel = new TextBlocksModel(((CtsDocument) doc).getRootBlock());
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
            if (inComment(viewer, line, charPositionInLine)) {
                return null;
            }
            
            List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
            parsingHandler = initParsingHandler(viewer);
            
            CtsContentAssistContext context = getContext(line, charPositionInLine);
            // workaround for ANTLR unlexed tokens that get parsed but start with whitespace
            if (context != null) {
                if (isContextAtWhitespace(viewer, context)) {
                    context = getPreviousContext(context);
                }
            }

            String prefix = "";
            
            if (!isValid(context)) {
                // no floor context, get first possible proposals

                results = CtsCompletionCalculator.createFirstPossibleProposals(syntax, classTemplateMap, viewer, line,
                        charPositionInLine, null, tbModel, oclEvaluator);

                // TODO workaround because ANTRL will not create error token
                // for unlexed characters
                // TODO this assumes languages with standard whitespaces
                // filter by currently un-tokenized non-whitespace prefix

                int curOffset = getAbsoluteOffset(viewer, line, charPositionInLine);

                // stop just before start of current line
                int stopOffset = getAbsoluteOffset(viewer, line, 0) - 1;
                prefix = computeNonWhitespacePrefix(CtsContentAssistUtil.getDocumentContents(viewer), curOffset, stopOffset);
                results = prefixFilter(removeNullValues(results), prefix);

                // end workaround

            } else {

                if (context.getToken().getText() == null) {
                    // TODO workaround as ANTLR does not create a correct
                    // token for unlexed content
                    fixTokenText(viewer, context.getToken());
                }

                if (isInToken(line, charPositionInLine, context.getToken())) {

                    CtsContentAssistContext previousContext = getPreviousContext(context);

                    // get proposals that follow previous token, and apply
                    // prefix filter

                    if (!isValid(previousContext)) {

                        results = CtsCompletionCalculator.createFirstPossibleProposals(syntax, classTemplateMap, viewer, line,
                                charPositionInLine, context.getToken(), tbModel, oclEvaluator);
                    } else {
                        results = CtsCompletionCalculator.createFollowProposalsFromContext(syntax, previousContext,
                                classTemplateMap, viewer, line, charPositionInLine, context.getToken(), tbModel, oclEvaluator);
                    }

                    // compute prefix from token text
                    prefix = computePrefixFromContext(charPositionInLine, context);
                    results = prefixFilter(removeNullValues(results), prefix);

                    // also get following proposals when after the last char
                    // of a token

                    // TODO maybe make this dependent on token type and
                    // symbol
                    // space variables
                    if (previousContext != null && isAtEndOfToken(line, charPositionInLine, context.getToken())) {
                        results.addAll(CtsCompletionCalculator.createFollowProposalsFromContext(syntax, context,
                                classTemplateMap, viewer, line, charPositionInLine, null, tbModel, oclEvaluator));

                        // not prefix-filtered
                    }

                } else {
                    if (!context.isErrorContext()) {
                        // get proposals that follow token
                        results = CtsCompletionCalculator.createFollowProposalsFromContext(syntax, context, classTemplateMap,
                                viewer, line, charPositionInLine, context.getToken(), tbModel, oclEvaluator);
                    }
                }
            }
            return proposalListAsArray(sortProposals(removeDuplicates(removeNullValues(results)), prefix));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // FIXME: This is bad: There is a cache in a static class
            CtsCompletionCalculator.clearTransientPartition(resourceSet);
        }
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
        String documentContents = getDocumentContents(viewer);
        InputStream in = new ByteArrayInputStream(documentContents.getBytes());
        IModelAdapter modelHandler = new DefaultTextAwareModelAdapter(new StubModelAdapter());

        // use delegator to monitor exceptions
        DelegationParsingObserver delegator = new DelegationParsingObserver();
        CtsContentAssistParsingHandler handler = new CtsContentAssistParsingHandler(resourceSet, classTemplateMap, operatorTemplateMap);
        delegator.addParsingObserver(handler);

        facade.parseProductionRule(in, modelHandler, null, null, delegator);
        return handler;
    }

    private CtsContentAssistContext getPreviousContext(CtsContentAssistContext context) {
        // get the context one offset before this context
        return getContext(getLine(context.getToken()), CtsContentAssistUtil.getCharPositionInLine(context.getToken()) - 1);
    }

    private CtsContentAssistContext getContext(int line, int charPositionInLine) {
        return parsingHandler.getFloorContext(line, charPositionInLine);
    }
    
}
