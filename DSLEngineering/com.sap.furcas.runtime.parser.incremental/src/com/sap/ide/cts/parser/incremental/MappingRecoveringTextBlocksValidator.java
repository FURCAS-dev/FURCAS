package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Token;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.DelayedReferencesHelper;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbMarkingUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;

public class MappingRecoveringTextBlocksValidator {

    private final IncrementalParserFacade parserFacade;
    private final ShortPrettyPrinter shortPrettyPrinter;

    public MappingRecoveringTextBlocksValidator(IncrementalParserFacade parserFacade) {
        this.parserFacade = parserFacade;
        this.shortPrettyPrinter = new ShortPrettyPrinter(parserFacade.getModelElementInvestigator());
    }

    /**
     * Ensures that the token ids stored in the TextBlocks model are still in
     * sync with those from the generated parser.<p> 
     * 
     * If only a token Id changed and lexing is still possible without errors,
     * the ids are updated correspondingly. If lexing without errors is not
     * possible, this routing will mark the effect region for later reparsing.
     */
    public void checkAndMigrateTokenIds(TextBlock rootBlock) {
        AbstractToken tok = (AbstractToken) rootBlock.getSubNodes().get(0);
        // BOS token does not have to be checked. It also is not necessary to
        // check if the tb model is in its empty initial state
        // this is indicated by the only token having an id of -1
        Lexer antlrLexer = ((ANTLRLexerAdapter) parserFacade.getLexer()).getANTLRLexer();
        CharStream originalStream = antlrLexer.getCharStream();
        try {
            while (!TbMarkingUtil.isEOS(tok = TbNavigationUtil.nextToken(tok)) && tok != null && tok.getType() != 0) {
                parserFacade.getLexer().setState(tok.getState());
                String value = shortPrettyPrinter.resynchronizeToEditableState(tok);
                if (!TbMarkingUtil.isEOS(tok)) {
                    AbstractToken nextToken = TbNavigationUtil.nextToken(tok);
                    value += shortPrettyPrinter.resynchronizeToEditableState(nextToken);
                }
                antlrLexer.setCharStream(new ANTLRStringStream(value));
                Token lexerToken = antlrLexer.nextToken();
                if (lexerToken.getType() != tok.getType()) {
                    // token id may have changed

                    // This works because lexer and parser are already connected
                    if (parserFacade.getErrors().size() > 0) {
                        // Ok this means not only have the token ids changed
                        // but also the lexer rules do not work for this token
                        // anymore. Markin the token will force re-lexing.
                        TbMarkingUtil.mark(tok);
                    } else {
                        tok.setType(lexerToken.getType());
                    }
                }
            }
        } finally {
            antlrLexer.setCharStream(originalStream);
        }
    }

    public boolean hasBrokenMapping(TextBlock rootBlock) {
        return rootBlock.getType() == null;
    }

    /**
     * FIXME: Recover {@link ForeachPredicatePropertyInit#getInjectorActionsBlockReference()}
     * from broken mapping!
     * 
     */
    public void recoverMappingLink(TextBlock existingRoot, ClassTemplate rootTemplate)
            throws TextBlockMappingRecoveringFailedException {

        ParserTextBlocksHandler parserTextBlocksHandler = parserFacade.createParserTextBlocksHandler();

        parserFacade.getParser().setObserver(parserTextBlocksHandler);
        parserFacade.getIncrementalLexer().setCurrentTokenForParser(existingRoot.getTokens().get(0));

        // Ensure no model elements get created only proxies should be created
        boolean originalResolveProxiesValue = parserFacade.getParser().isResolveProxies();
        parserFacade.getIncrementalParser().prepareForParsing(existingRoot, parserTextBlocksHandler);
        parserFacade.getParser().setResolveProxies(false);
        try {
            existingRoot.setType(rootTemplate);
            RecoverMappingLinkComand command = new RecoverMappingLinkComand(parserFacade, existingRoot, parserTextBlocksHandler);
            command.runRecovery();

            if (command.hasFailed()) {
                throw new TextBlockMappingRecoveringFailedException("Unable to recover mapping.");
            }
            if (parserFacade.getErrors().size() > 1) {
                throw new TextBlockMappingRecoveringFailedException(
                        "Cannot recover textblock to mapping link due to the following parse errors:" + parserFacade.getErrors());
            }
        } catch (Exception e) {
            throw new TextBlockMappingRecoveringFailedException(e,
                    "Cannot recover textblock to mapping link due to the following errors:" + e.getMessage());
        } finally {
            parserFacade.getParser().setResolveProxies(originalResolveProxiesValue);
        }
    }

    private static class RecoverMappingLinkComand {

        private final TextBlock existingRoot;
        private final ParserTextBlocksHandler parserTextBlocksHandler;

        private Map<TextBlockProxy, List<DelayedReference>> tBProxy2Reference;
        private final IncrementalParserFacade parserFacade;
        private boolean failed;

        public RecoverMappingLinkComand(IncrementalParserFacade parserFacade, TextBlock existingRoot,
                ParserTextBlocksHandler parserTextBlocksHandler) {
            this.parserFacade = parserFacade;
            this.existingRoot = existingRoot;
            this.parserTextBlocksHandler = parserTextBlocksHandler;
        }

        public void runRecovery() throws Exception {
            parserFacade.getIncrementalParser().callBatchParser(existingRoot);
            // FIXME: evaluate foreach references to reestablish links where
            // templates used in foreachs
            // are referenced as additionalTemplates
            TextBlockProxy proxy = parserTextBlocksHandler.getCurrentTbProxy();
            createTBProxy2ReferenceMap();
            recoverMappingLink(existingRoot, proxy);
        }

        private void createTBProxy2ReferenceMap() {
            tBProxy2Reference = new HashMap<TextBlockProxy, List<DelayedReference>>();
            for (DelayedReference ref : parserFacade.getParser().getDelayedReferences()) {
                if (ref.getType() == DelayedReference.ReferenceType.TYPE_FOREACH_PREDICATE) {
                    List<DelayedReference> refs = tBProxy2Reference.get(ref.getTextBlock());
                    if (refs == null) {
                        refs = new ArrayList<DelayedReference>(3);
                        tBProxy2Reference.put((TextBlockProxy) ref.getTextBlock(), refs);
                    }
                    refs.add(ref);
                }
            }
        }

        private void recoverMappingLink(TextBlock textBlock, TextBlockProxy proxy) throws Exception {
            if (proxy.getSubNodes().size() != TbNavigationUtil.getSubNodesSize(textBlock)) {
                if (TbNavigationUtil.getSubNodeAt(textBlock, 0) instanceof Bostoken) {
                    if (proxy.getSubNodes().size() + 2 != TbNavigationUtil.getSubNodesSize(textBlock)) {
                        failed = true;
                        return;
                    }
                } else {
                    failed = true;
                    return;
                }
            }
            textBlock.setSequenceElement(proxy.getSequenceElement());
            Template t = proxy.getTemplate();
            if (t == null) {
                failed = true;
                return;
            }
            textBlock.setType(t);
            textBlock.getAdditionalTemplates().addAll(proxy.getAdditionalTemplates());
            if (textBlock.getForEachExecutions().size() > 0) {
                recoverForEachContext(textBlock, proxy);
            }
            int i = 0;
            for (DocumentNode n : TbNavigationUtil.getSubNodes(textBlock)) {
                if (n instanceof TextBlock) {
                    TextBlockProxy subNodeProxy = (TextBlockProxy) proxy.getSubNodes().get(i);
                    recoverMappingLink((TextBlock) n, subNodeProxy);
                }
                if (n instanceof LexedToken && ((LexedToken) n).getSequenceElement() == null) {
                    ((LexedToken) n).setSequenceElement(proxy.getSequenceElement());
                }
                if (!(n instanceof Bostoken)) {
                    i++;
                }
            }
        }

        private void recoverForEachContext(TextBlock textBlock, TextBlockProxy proxy) throws ModelAdapterException {
            for (ForEachExecution fec : textBlock.getForEachExecutions()) {
                for (EObject ro : textBlock.getCorrespondingModelElements()) {
                    if (fec.getSourceModelElement().equals(ro)) {
                        for (DelayedReference ref : tBProxy2Reference.get(proxy)) {
                            Collection<?> result = DelayedReferencesHelper.evaluateForeachOcl(ro, ref,
                                    parserFacade.getModelAdapter(), ro);
                            if (result.contains(fec.getContextElement())) {
                                fec.setForeachPedicatePropertyInit((ForeachPredicatePropertyInit) ref.getQueryElement());
                                textBlock.getAdditionalTemplates().add(
                                        fec.getForeachPedicatePropertyInit().getInjectorActionsBlock().getParentTemplate());
                            }
                        }
                    }
                }
            }
        }

        public boolean hasFailed() {
            return failed;
        }

    }

}
