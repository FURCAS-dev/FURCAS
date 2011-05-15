package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachExecution;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.DelayedReferencesHelper;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.impl.ParserScope;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;


public class MappingLinkRecoveringIncrementalParser extends IncrementalParser {

    public MappingLinkRecoveringIncrementalParser(ObservableInjectingParser batchParser, ParserScope parserScope, TextBlockReuseStrategy reuseStrategy,
            PartitionAssignmentHandler partitionAssignmentHandler) {
        super(batchParser, parserScope, reuseStrategy, partitionAssignmentHandler);
    }

    /**
     * FIXME: Recover
     * {@link ForeachPredicatePropertyInit#getInjectorActionsBlockReference()}
     * from broken mapping!
     * 
     * @param existingRoot
     * @param rootTemplate
     * @throws TextBlockMappingRecoveringFailedException
     */
    public void recoverMappingLink(TextBlock existingRoot,
            ClassTemplate rootTemplate)
            throws TextBlockMappingRecoveringFailedException {
        
        ParserTextBlocksHandler parserTextBlocksHandler = new ParserTextBlocksHandler(tbtokenStream, parserScope,
                partitionHandler);
        
        // IParsingObserver originalObserver = batchParser.getObserver();
        batchParser.setObserver(parserTextBlocksHandler);
        ((ANTLRIncrementalLexerAdapter) batchParser.input.getTokenSource())
                .setCurrentTokenForParser(existingRoot.getTokens().get(0));
        // Ensure no model elements get created
        // only proxies should be created
        boolean originalResolveProxiesValue = batchParser.isResolveProxies();
        prepareForParsing(existingRoot, parserTextBlocksHandler);
        batchParser.setResolveProxies(false);
        try {
            existingRoot.setType(rootTemplate);
            RecoverMappingLinkComand rmlc = new RecoverMappingLinkComand(
                    existingRoot, parserTextBlocksHandler);
            rmlc.execute();
            if (rmlc.hasFailed()) {
                // connection.getCommandStack().undo();
                throw new TextBlockMappingRecoveringFailedException(rmlc.getException(), 
                        "Cannot recover textblock to mapping link due to the following errors:"
                                + rmlc.getException());
            }
            if (batchParser.getInjector().getErrorList().size() > 1) {
                throw new TextBlockMappingRecoveringFailedException(
                        "Cannot recover textblock to mapping link due to the following parse errors:"
                                + batchParser.getInjector().getErrorList());
            }
        } catch (Exception e) {
            throw new TextBlockMappingRecoveringFailedException(e);
        } finally {
            batchParser.setResolveProxies(originalResolveProxiesValue);
        }
    }

    // FIXME: Should not run in command mode. Editor is repsonsible for 
    // synchronization with the domain.
    public class RecoverMappingLinkComand extends AbstractCommand {

        private final TextBlock existingRoot;
        private boolean failed = false;
        private Exception exception;
        private final ParserTextBlocksHandler parserTextBlocksHandler;
        private Map<TextBlockProxy, List<DelayedReference>> tBProxy2Reference;

        public RecoverMappingLinkComand(TextBlock existingRoot,
                ParserTextBlocksHandler parserTextBlocksHandler) {
            super("Recover Link to Mapping Model");
            this.existingRoot = existingRoot;
            this.parserTextBlocksHandler = parserTextBlocksHandler;
        }

        @Override
        public boolean canExecute() {
            return true;
        }

        @Override
        public void execute() {
            try {
                callBatchParser(existingRoot);
                // FIXME: evaluate foreach references to reestablish links where
                // templates used in foreachs
                // are referenced as additionalTemplates
                TextBlockProxy proxy = parserTextBlocksHandler
                        .getCurrentTbProxy();
                createTBProxy2ReferenceMap();
                recoverMappingLink(existingRoot, proxy);
            } catch (Exception ex) {
                exception = ex;
                failed = true;
            }
        }

        private void createTBProxy2ReferenceMap() {
            tBProxy2Reference = new HashMap<TextBlockProxy, List<DelayedReference>>();
            for (DelayedReference ref : batchParser.getDelayedReferences()) {
                if(ref.getType() == DelayedReference.ReferenceType.TYPE_FOREACH_PREDICATE) {
                    List<DelayedReference> refs = tBProxy2Reference.get(ref.getTextBlock());
                    if(refs == null) {
                        refs = new ArrayList<DelayedReference>(3);
                        tBProxy2Reference.put((TextBlockProxy) ref.getTextBlock(), refs);
                    }
                    refs.add(ref);
                }
            }
        }

        private void recoverMappingLink(TextBlock textBlock,
                TextBlockProxy proxy) {
            if (proxy.getSubNodes().size() != TbNavigationUtil
                    .getSubNodesSize(textBlock)) {
                if (TbNavigationUtil.getSubNodeAt(textBlock, 0) instanceof Bostoken) {
                    if (proxy.getSubNodes().size() + 2 != TbNavigationUtil
                            .getSubNodesSize(textBlock)) {
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
            textBlock.getAdditionalTemplates().addAll(
                    proxy.getAdditionalTemplates());
            if (textBlock.getForEachExecutions().size() > 0) {
                recoverForEachContext(textBlock, proxy);
            }
            int i = 0;
            for (DocumentNode n : TbNavigationUtil.getSubNodes(textBlock)) {
                if (n instanceof TextBlock) {
                    TextBlockProxy subNodeProxy = (TextBlockProxy) proxy
                            .getSubNodes().get(i);
                    recoverMappingLink((TextBlock) n, subNodeProxy);
                }
                if (n instanceof LexedToken
                        && ((LexedToken) n).getSequenceElement() == null) {
                    ((LexedToken) n).setSequenceElement(proxy
                            .getSequenceElement());
                }
                if (!(n instanceof Bostoken)) {
                    i++;
                }
            }
        }

        private void recoverForEachContext(TextBlock textBlock,
                TextBlockProxy proxy) {
            for (ForEachExecution fec : textBlock.getForEachExecutions()) {
                for (EObject ro : textBlock.getCorrespondingModelElements()) {
                    if(fec.getSourceModelElement().equals(ro)) {
                        for (DelayedReference ref : tBProxy2Reference.get(proxy)) {
                            try {
                                Collection<?> result = DelayedReferencesHelper.evaluateForeachOcl(ro, ref, 
                                        batchParser.getInjector().getModelAdapter(), 
                                        ro);
                                if(result.contains(fec.getContextElement())) {
                                    fec.setForeachPedicatePropertyInit((ForeachPredicatePropertyInit) ref.getQueryElement());
                                    textBlock.getAdditionalTemplates().add(
                                            fec.getForeachPedicatePropertyInit().getInjectorActionsBlock().getParentTemplate());
                                }
                            } catch (ModelAdapterException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }

       

        @Override
		public void redo() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Collection<?> getAffectedObjects() {
			// TODO Auto-generated method stub
			return super.getAffectedObjects();
		}

		public boolean hasFailed() {
            return failed;
        }

        public void setException(Exception exception) {
            this.exception = exception;
        }

        public Exception getException() {
            return exception;
        }

    }

}
