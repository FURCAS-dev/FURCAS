/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.ide.editor.imp;

import java.util.Collections;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.expressions.provider.ExpressionsItemProviderAdapterFactory;
import org.eclipse.ocl.types.provider.TypesItemProviderAdapterFactory;
import org.eclipse.ocl.utilities.provider.UtilitiesItemProviderAdapterFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;

import com.sap.furcas.ide.editor.EditorUtil;
import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.ide.editor.document.CtsDocumentProvider;
import com.sap.furcas.ide.editor.document.ModelEditorInput;
import com.sap.furcas.ide.editor.document.ModelEditorInputLoader;
import com.sap.furcas.ide.editor.imp.parsing.FurcasParseController;
import com.sap.furcas.ide.editor.imp.services.FurcasContentProposer;
import com.sap.furcas.ide.editor.imp.services.FurcasLabelProvider;
import com.sap.furcas.ide.editor.imp.services.FurcasTreeModelBuilder;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.provider.TCSItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.provider.FURCASItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.provider.TextblockdefinitionItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.provider.TextblocksItemProviderAdapterFactory;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.ide.cts.parser.incremental.DefaultPartitionAssignmentHandlerImpl;
import com.sap.ide.cts.parser.incremental.MappingLinkRecoveringIncrementalParser;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.PartitionAssignmentHandler;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategyImpl;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.QueryContextProvider;

/**
 * Base class for language specific FURCAS editors. <p>
 * 
 * Clients that want to use this editor <b>must</b> register:
 * <ul>
 *      <li>an IMP {@link Language} descriptor</li>
 *      <li>the {@link FurcasParseController}</li>
 *      <li>the editor itself</li>
 * </ul>
 * 
 * Clients that want to use this editor <b>should</b> register:
 * <ul>
 *      <li>the {@link FurcasContentProposer}</li>
 *      <li>the {@link FurcasTreeModelBuilder}</li>
 *      <li>the {@link FurcasLabelProvider}</li>
 * </ul>
 * 
 * In addition, clients <b>can</b> implement and register other IMP services
 * such as the {@link ITokenColorer}.
 * 
 * @author Stephan Erb
 * 
 */
public class AbstractFurcasEditor extends UniversalEditor {
    
    /* Implementation notes:
     * 
     * The editor is backed by the TextBlocks model and supports incremental parsing.
     * It is based on IMP and extends it by injecting a {@link CtsDocument}
     * via a custom {@link CtsDocumentProvider}.
     *  
     * The {@link CtsDocument} contains the text presented to the user.
     * It is edited directly within the UI thread. The {@link FurcasParserController}
     * serves as a reconciler for this document. It is started automatically when document
     * has been altered. It reparses the document and creates/modifies the domain model
     * and the TextBlocks model accordingly. Reconciling happens in a background thread.
     * 
     * All support classes, such as the Outline View ({@link FurcasTreeModelBuilder} and
     * {@link FurcasLabelProvider}) or the {@link FurcasSourcePositionLocator} operate on
     * the TextBlocks model. When required those navigate into the domain model. 
     * 
     */

    /**
     * Make it easier to pass these parser related objects around
     */
    public static class ParserCollection {
        public final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
        public final ANTLRIncrementalLexerAdapter lexer;
        public final ObservableInjectingParser parser;
        public final MappingLinkRecoveringIncrementalParser incrementalParser;
        public final ShortPrettyPrinter shortPrettyPrinter;
        public final OppositeEndFinder oppositeEndFinder;
        public final ParserTextBlocksHandler textBlocksHandler;
        
        public ParserCollection(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory, ANTLRIncrementalLexerAdapter lexer, ObservableInjectingParser parser, MappingLinkRecoveringIncrementalParser incrementalParser, ParserTextBlocksHandler textBlocksHandler, ShortPrettyPrinter shortPrettyPrinter, OppositeEndFinder oppositeEndFinder) {
            this.parserFactory = parserFactory;
            this.lexer = lexer;
            this.parser = parser;
            this.incrementalParser = incrementalParser;
            this.shortPrettyPrinter = shortPrettyPrinter;
            this.oppositeEndFinder = oppositeEndFinder;
            this.textBlocksHandler = textBlocksHandler;
        }
    }
    
    /**
     * Make it easy to extract the editor content without directly depending on the editor. 
     */
    public class ContentProvider {
        public CtsDocument getDocument() {
            return getDocumentProvider().getDocument(getEditorInput());
        }
    }

    
    private final EditingDomain editingDomain;
    private final ConcreteSyntax syntax;
    private CtsDocumentProvider documentProvoider;

    private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    private ParserCollection parserCollection;

    
    public AbstractFurcasEditor(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory) {
        this.syntax = EditorUtil.loadConcreteSyntax(parserFactory);
        validateEditorState(syntax, parserFactory);
        
        this.editingDomain = createEditingDomain(syntax);
        this.parserFactory = parserFactory;
    }
    
    private static void validateEditorState(ConcreteSyntax syntax, AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory) {
        if (syntax == null) {
            String message = "Error loading syntax definition: No syntax definition for language \""
                    + parserFactory.getLanguageId() + "\" found. Make sure the editor project"
                    + "is correctly referenced and the mapping model is available.";
            throw new RuntimeException(message);
        }
        if (!isParserConsistentToMapping(syntax, parserFactory)) {
            String message = "Inconsistency between mapping and parser: " +
                    "Loaded parser class: " + parserFactory.getParserClass().getCanonicalName() +
                    " is not consistent with mapping: " + EcoreUtil.getURI(syntax);
            throw new RuntimeException(message);
        }
    }

    private static boolean isParserConsistentToMapping(ConcreteSyntax syntax, ParserFactory<?, ?> parserFactory) {
        String id = parserFactory.getSyntaxUUID();
        return id == null || EcoreUtil.getURI(syntax).equals(id);
    }
    
    private static AdapterFactoryEditingDomain createEditingDomain(ConcreteSyntax syntax) {
        // Create an adapter factory that yields item providers.
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new FURCASItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TCSItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TextblocksItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TextblockdefinitionItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TypesItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new UtilitiesItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ExpressionsItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new org.eclipse.ocl.ecore.provider.EcoreItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

        // Create the command stack that will notify this editor as commands are executed.
        BasicCommandStack commandStack = new BasicCommandStack();

        // Create the editing domain with a special command stack.
        AdapterFactoryEditingDomain domain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
        
        domain.getResourceSet().getResources().add(syntax.eResource());
        return domain;
    }
    
    /**
     * Initialize the editor by transform the editor input into a {@link ModelEditorInput}.
     * The IMP editor will never see the original one, but only the one built here.
     * 
     * This method is called <b>before</b> {@link #createPartControl(Composite)}.
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        // FIXME part of the crude  hack.
        IFile file = ((FileEditorInput) input).getFile();
        Resource resource = new ResourceSetImpl().getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true),true);

        // create a temporary opposite end finder that knows about the static resources in the workspace
        QueryContextProvider queryContext = EcoreHelper.createProjectDependencyQueryContextProvider(editingDomain.getResourceSet(), getAdditionalLookupURIs());
        QueryContext context = queryContext.getBackwardScopeQueryContext(resource);
        
        // FIXME: Crude hack: Unable to find textblocks if we do not load all resources manually!
        for (URI uri : context.getResourceScope()) {
            if (uri.fileExtension().equals(DefaultPartitionAssignmentHandlerImpl.TEXTBLOCKS_PARTITION_EXTENSION)) {
                editingDomain.getResourceSet().getResource(uri, true);
            }
        }
        
        OppositeEndFinder temporaryOppositeEndFinder = new Query2OppositeEndFinder(queryContext);
        ModelEditorInputLoader loader = new ModelEditorInputLoader(syntax, editingDomain, temporaryOppositeEndFinder, parserFactory);
        ModelEditorInput modelEditorInput = loader.loadEditorInput(input);
        
        PartitionAssignmentHandler partitionHandler = setupPartitioning(modelEditorInput, editingDomain);

        // create a parser/lexer combo suitable for the current editor input
        parserCollection = createParserCollection(editingDomain, getAdditionalLookupURIs(), parserFactory, partitionHandler);

        documentProvoider = new CtsDocumentProvider(syntax, editingDomain, partitionHandler);
        super.init(site, modelEditorInput);
        
        CtsDocument document = getDocumentProvider().getDocument(modelEditorInput);
        document.completeInit(parserCollection);
    }

    private static PartitionAssignmentHandler setupPartitioning(ModelEditorInput modelEditorInput, EditingDomain editingDomain) {
        PartitionAssignmentHandler partitionHandler = new DefaultPartitionAssignmentHandlerImpl();
        partitionHandler.setDefaultPartition(modelEditorInput.getRootObject().eResource());
        
        if (modelEditorInput.getRootBlock().eResource() == null) {
            // might be a completely new textblock
            partitionHandler.assignToDefaultTextBlocksPartition(modelEditorInput.getRootBlock());
        }

        // make sure that the editing domain knows both of them
        editingDomain.getResourceSet().getResources().add(modelEditorInput.getRootObject().eResource());
        editingDomain.getResourceSet().getResources().add(modelEditorInput.getRootBlock().eResource());
        
        return partitionHandler;
    }
    
    private static ParserCollection createParserCollection(EditingDomain editingDomain, Set<URI> referenceScope, AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory, PartitionAssignmentHandler partitionHandler) {
        ResourceSet resourceSet = editingDomain.getResourceSet();
        
        EMFModelAdapter modelAdapter = new EMFModelAdapter(parserFactory.getMetamodelPackage(resourceSet), resourceSet, referenceScope);

        TextBlockReuseStrategyImpl reuseStrategy = new TextBlockReuseStrategyImpl(parserFactory.createLexer(/*input*/null), modelAdapter);
        ANTLRIncrementalLexerAdapter lexer = new ANTLRIncrementalLexerAdapter(new ANTLRLexerAdapter(parserFactory.createLexer(/*input*/null), reuseStrategy),
                modelAdapter, editingDomain);

        // TODO: inject model adapter instead of hiding the initialization internally and then extracting it!
        ObservableInjectingParser parser = parserFactory.createParser(parserFactory.createIncrementalTokenStream(lexer), resourceSet, referenceScope, referenceScope);

        ITextBlocksTokenStream tokenStream = (ITextBlocksTokenStream) parser.getTokenStream();
        ParserTextBlocksHandler textBlocksHandler = new ParserTextBlocksHandler(tokenStream, resourceSet, parserFactory.getMetamodelUri(resourceSet),
                TcsUtil.getSyntaxPartitions(resourceSet, parserFactory.getLanguageId()), referenceScope, referenceScope);
        parser.setObserver(textBlocksHandler);

        lexer.setModelInjector(parser.getInjector());
        reuseStrategy.setModelElementInvestigator(parser.getInjector().getModelAdapter());
        
        QueryContextProvider queryContext = EcoreHelper.createProjectDependencyQueryContextProvider(resourceSet, referenceScope);
        OppositeEndFinder oppositeEndFinder = new Query2OppositeEndFinder(queryContext);
        
        MappingLinkRecoveringIncrementalParser incrementalParser = new MappingLinkRecoveringIncrementalParser(editingDomain, parserFactory, lexer, parser,
                reuseStrategy, referenceScope, oppositeEndFinder, partitionHandler);

        ShortPrettyPrinter shortPrettyPrinter = new ShortPrettyPrinter(((ModelInjector) parser.getInjector()).getModelAdapter());
        
        return new ParserCollection(parserFactory, lexer, parser, incrementalParser, textBlocksHandler, shortPrettyPrinter, oppositeEndFinder);
    }
        
    /**
     * IMP uses this to initialize all services. We proceed with a deferred initialization to
     * inject FURCAS specific information into our parser service.
     * 
     * This method is called <b>after</b> {@link #init(IEditorSite, IEditorInput)}.
     */
    @Override
    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        
        // We can retrigger the parse controller via the parser scheduler.
        // The initialization of most other serivices cannot be delayed because
        // those are already required during super.createPartControl.
        ((FurcasParseController) fLanguageServiceManager.getParseController()).completeInit(editingDomain, new ContentProvider(), parserCollection);
        
        // re-run IMP setup procedure with our fully configured services
        fParserScheduler.cancel();
        fParserScheduler.schedule();
    }
    
    @Override
    public CtsDocumentProvider getDocumentProvider() {
        return documentProvoider;
    }

    /**
     * This method should be overridden if additional URIs should be added to
     * the lookup scope of the parser.
     * 
     * By default, all resources in all dependent projects are sources.
     * If new resources are saved in a projects, those are included automatically
     * in the next parse run.
     */
    protected Set<URI> getAdditionalLookupURIs() {
        return Collections.emptySet();
    }
            
    @Override
    public boolean isDirty() {
        return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
    }

}
