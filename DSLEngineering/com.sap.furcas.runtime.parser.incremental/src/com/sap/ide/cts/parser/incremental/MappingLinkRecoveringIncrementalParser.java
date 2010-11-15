package com.sap.ide.cts.parser.incremental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.ForEachContext;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.impl.DelayedReference;
import com.sap.furcas.runtime.parser.impl.DelayedReferencesHelper;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;


public class MappingLinkRecoveringIncrementalParser extends IncrementalParser {

    public MappingLinkRecoveringIncrementalParser(EditingDomain editingDomain,
            ParserFactory<?, ?> parserFactory,
            IncrementalLexer incrementalLexer,
            ObservableInjectingParser batchParser,
            TextBlockReuseStrategy reuseStrategy,
            Set<URI> additionalCRIScope,
            OppositeEndFinder oppositeEndFinder) {
        super(editingDomain, parserFactory, incrementalLexer, batchParser,
                reuseStrategy, additionalCRIScope, oppositeEndFinder);
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
                tbtokenStream, getEditingDomain().getResourceSet(), parserFactory
                        .getMetamodelUri(getEditingDomain().getResourceSet()), TcsUtil
                        .getSyntaxePartitions(getEditingDomain().getResourceSet(), parserFactory
                                .getLanguageId()), parserFactory
                        .getParserLookupScope(getEditingDomain().getResourceSet()), additionalCRIScope);
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
                    existingRoot, parserTextBlocksHandler, getOppositeEndFinder());
            getEditingDomain().getCommandStack().execute(rmlc);
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

    public class RecoverMappingLinkComand extends AbstractCommand {

        private final TextBlock existingRoot;
        private boolean failed = false;
        private Exception exception;
        private final ParserTextBlocksHandler parserTextBlocksHandler;
        private Map<TextBlockProxy, List<DelayedReference>> tBProxy2Reference;
		private final OppositeEndFinder oppositeEndFinder;
		private final EStructuralFeature templateTypeRef;

        public RecoverMappingLinkComand(TextBlock existingRoot,
                ParserTextBlocksHandler parserTextBlocksHandler, OppositeEndFinder oppositeEndFinder) {
            super("Recover Link to Mapping Model");
            this.existingRoot = existingRoot;
            this.parserTextBlocksHandler = parserTextBlocksHandler;
			this.oppositeEndFinder = oppositeEndFinder;
            templateTypeRef = TextblockdefinitionPackage.eINSTANCE.getTextBlockDefinition_ParseRule();
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
            for (ForEachContext fec : textBlock.getForEachContext()) {
                for (EObject ro : textBlock.getCorrespondingModelElements()) {
                    if(fec.getSourceModelElement().equals(ro)) {
                        for (DelayedReference ref : tBProxy2Reference.get(proxy)) {
                            try {
                                Collection<?> result = helper.evaluateForeachOcl(ro, ref, 
                                        batchParser.getInjector().getModelAdapter(), 
                                        ro);
                                if(elementsEqual(result, fec.getContextElement())) {
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
            Collection<EObject> tbDefs = oppositeEndFinder.
            	navigateOppositePropertyWithBackwardScope((EReference) templateTypeRef, t);
            if (!tbDefs.isEmpty()) {
                if (tbDefs.size() == 1) {
                    return (TextBlockDefinition) tbDefs.iterator().next();
                } else {
                    // TODO What to do if there is more than one?
                    // for now this case seems strange, so throw an exception
                	throw new RuntimeException("Found more than one TextBlockDefinition for template: " + t);
                }
            }
            return null;
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
