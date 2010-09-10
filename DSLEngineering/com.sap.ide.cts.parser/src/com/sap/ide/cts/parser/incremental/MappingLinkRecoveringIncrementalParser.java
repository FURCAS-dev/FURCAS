package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.TCS.Template;
import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.grammar.impl.DelayedReference;
import com.sap.mi.textual.grammar.impl.DelayedReferencesHelper;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.parsing.textblocks.observer.ParserTextBlocksHandler;
import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sun.corba.se.pept.transport.Connection;

public class MappingLinkRecoveringIncrementalParser extends IncrementalParser {

    public MappingLinkRecoveringIncrementalParser(Connection connection,
            ParserFactory<?, ?> parserFactory,
            IncrementalLexer incrementalLexer,
            ObservableInjectingParser batchParser,
            TextBlockReuseStrategy reuseStrategy,
            Collection<URI> additionalCRIScope) {
        super(connection, parserFactory, incrementalLexer, batchParser,
                reuseStrategy, additionalCRIScope);
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
        ParserTextBlocksHandler parserTextBlocksHandler = new ParserTextBlocksHandler(
                tbtokenStream, connection, parserFactory
                        .getMetamodelUri(connection), TcsUtil
                        .getSyntaxePartitions(connection, parserFactory
                                .getLanguageId()), parserFactory
                        .getParserLookupScope(connection), additionalCRIScope);
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
            existingRoot.setType(tbFactory.getTbDef(rootTemplate));
            RecoverMappingLinkComand rmlc = new RecoverMappingLinkComand(
                    connection, existingRoot, parserTextBlocksHandler);
            connection.getCommandStack().execute(rmlc);
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

    public class RecoverMappingLinkComand extends Command {

        private final TextBlock existingRoot;
        private boolean failed = false;
        private Exception exception;
        private final ParserTextBlocksHandler parserTextBlocksHandler;
        private Map<TextBlockProxy, List<DelayedReference>> tBProxy2Reference;

        public RecoverMappingLinkComand(Connection con, TextBlock existingRoot,
                ParserTextBlocksHandler parserTextBlocksHandler) {
            super(con);
            this.existingRoot = existingRoot;
            this.parserTextBlocksHandler = parserTextBlocksHandler;

        }

        @Override
        public boolean canExecute() {
            return true;
        }

        @Override
        public void doExecute() {
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
                if(ref.getType() == DelayedReference.TYPE_SEMANTIC_PREDICATE) {
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
            TextBlockDefinition tbDef = getTbDef(proxy.getTemplate());
            if (tbDef == null) {
                failed = true;
                return;
            }
            textBlock.setType(tbDef);
            textBlock.getAdditionalTemplates().addAll(
                    proxy.getAdditionalTemplates());
            if (textBlock.getForEachContext().size() > 0) {
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
            DelayedReferencesHelper helper = new DelayedReferencesHelper(batchParser.getInjector());
            for (ForeachContext fec : textBlock.getForEachContext()) {
                for (RefObject ro : textBlock.getCorrespondingModelElements()) {
                    if(fec.getSourceModelelement().equals(ro)) {
                        for (DelayedReference ref : tBProxy2Reference.get(proxy)) {
                            try {
                                Collection<?> result = helper.evaluateForeachOcl(ro, ref, 
                                        batchParser.getInjector().getModelAdapter(), 
                                        ro);
                                if(elementsEqual(result, fec.getContextElement())) {
                                    fec.setForeachPredicatePropertyInit((ForeachPredicatePropertyInit) ref.getQueryElement());
                                    textBlock.getAdditionalTemplates().add(
                                            fec.getForeachPredicatePropertyInit().getInjectorActionsBlockReference().getParentTemplate());
                                }
                            } catch (JmiException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (ModelAdapterException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

        private boolean elementsEqual(Collection<?> one,
                Collection<?> two) {
            for (Object refObject : two) {
                if(!one.contains(refObject)) {
                    return false;
                }
            }
            return true;
        }

        private TextBlockDefinition getTbDef(Template t) {
            Collection<TextBlockDefinition> tbDefs = getConnection()
                    .getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR)
                    .getTextblockdefinition()
                    .getTextblockDefinitionReferencesProduction()
                    .getTextBlockDefinition(t);
            if (!tbDefs.isEmpty()) {
                if (tbDefs.size() == 1) {
                    return tbDefs.iterator().next();
                } else {
                    // TODO What to do if there is more than one?
                    // for now this case seems strange, so throw an exception

                }
            }
            return null;
        }

        @Override
        public Collection<EOperation> getAffectedPartitions() {
            EObject partitionable = existingRoot;
            URI pri = partitionable.get___Partition().getPri();
            EOperation editOperation = new EOperation(
                    EOperation.Operation.EDIT, pri);
            return Collections.singleton(editOperation);
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
