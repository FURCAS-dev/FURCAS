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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.expressions.provider.ExpressionsItemProviderAdapterFactory;
import org.eclipse.ocl.types.provider.TypesItemProviderAdapterFactory;
import org.eclipse.ocl.utilities.provider.UtilitiesItemProviderAdapterFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.EditorUtil;
import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.ide.editor.document.CtsDocumentProvider;
import com.sap.furcas.ide.editor.document.ModelEditorInput;
import com.sap.furcas.ide.editor.imp.services.FurcasParseController;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.provider.TCSItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.provider.FURCASItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.provider.TextblockdefinitionItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.provider.TextblocksItemProviderAdapterFactory;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
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
 * The editor is backed by the TextBlocks model and supports incremental parsing.
 * It is based on IMP and extends it by injecting a {@link CtsDocument}
 * via a custom {@link CtsDocumentProvider}. <p>
 * 
 * Clients that want to use this editor <b>must</b> register:
 * <ul>
 *      <li>an IMP {@link Language} descriptor
 *      <li>the {@link FurcasParseController}</li>
 *      <li>the editor itself</li>
 * </ul>
 * In addition, clients <b>can</b> implement and register other IMP services
 * such as the {@link ITokenColorer}.
 * 
 * @author Stephan Erb
 * 
 */
public class AbstractFurcasEditor extends UniversalEditor {

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
        public TextBlock getCurrentRootBlock() {
            TextBlock rootBlock = getDocumentProvider().getDocument(getEditorInput()).getRootBlock();
            return (TextBlock) TbUtil.getNewestVersion(rootBlock);
        }
        public EObject getCurrentRootObject() {
            return getDocumentProvider().getDocument(getEditorInput()).getRootObject();
        }
        public String get(int pos, int length) {
            try {
                return getDocumentProvider().getDocument(getEditorInput()).get(pos, length);
            } catch (BadLocationException e) {
                throw new RuntimeException(e);
            }
        }
        
    }

    private final CtsDocumentProvider documentProvoider;
    private final EditingDomain editingDomain;

    private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    private ParserCollection parserCollection;

    public AbstractFurcasEditor(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory) {
        this.parserFactory = parserFactory;
        this.editingDomain = createEditingDomain();
        this.documentProvoider = new CtsDocumentProvider(editingDomain);
    }
    
    private static AdapterFactoryEditingDomain createEditingDomain() {
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
        return new AdapterFactoryEditingDomain(adapterFactory, commandStack);
    }
    
    /**
     * Transform the editor input into a {@link ModelEditorInput}.
     * The IMP editor will never see the original one, but only the one built here.
     * 
     * This method is called <b>before</b> {@link #createPartControl(Composite)}.
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        IEditorInput wrappedInput = createModelEditorInput(input);
        if (wrappedInput == null) {
            return; // errors already handled
        }
        // pass input to the IMP editor
        super.init(site, wrappedInput);

        // create a parser/lexer combo suitable for the current editor input
        parserCollection = initializeParser();
        
        ConcreteSyntax syntax = EditorUtil.getActiveSyntaxByName(editingDomain, wrappedInput, parserCollection.parserFactory.getLanguageId());
        if (syntax == null) {
            IStatus status = new Status(IStatus.ERROR, CtsActivator.PLUGIN_ID, "");
            ErrorDialog.openError(getSite().getShell(), "Error loading syntax definition", "No syntax definition for language \""
                    + parserCollection.parserFactory.getLanguageId() + "\" found. Make sure the editor project"
                    + "is correctly referenced and the mapping model is available.", status);
            return;
        }
        if (!isParserConsistentToMapping(syntax, parserCollection.parserFactory)) {
            IStatus status = new Status(IStatus.ERROR, CtsActivator.PLUGIN_ID, "");
            ErrorDialog.openError(getSite().getShell(), "Inconsistency between mapping and parser",
                    "Loaded parser class: " + parserCollection.parserFactory.getParserClass().getCanonicalName() +
                    " is not consistent with mapping: " + EcoreUtil.getURI(syntax), status);
            return;
        }

        CtsDocument document = getDocumentProvider().getDocument(wrappedInput);
        document.completeInit(syntax, parserCollection);
    }

    private IEditorInput createModelEditorInput(IEditorInput input) {
        IEditorInput wrappedInput = input;
        try {
            if(input instanceof FileEditorInput) {
                Resource r = editingDomain.loadResource(URI.createFileURI(((FileEditorInput)input).getPath().toOSString()).toString());
                if(r.getErrors().size() > 0) {
                    CtsActivator.getDefault().getLog().log(new Status(Status.ERROR, CtsActivator.PLUGIN_ID, "Could not load resource: " + ((FileEditorInput)input).getPath() + r.getErrors()));
                    return null;
                }
                wrappedInput = new ModelEditorInput(((FileEditorInput) input).getFile(), r.getContents().iterator().next());
            } else {
                CtsActivator.getDefault().getLog().log(new Status(Status.ERROR, CtsActivator.PLUGIN_ID, "Unknown editor input type: " + input));
            }
        } catch (Exception e) {
            CtsActivator.getDefault().getLog().log(new Status(Status.ERROR, CtsActivator.PLUGIN_ID, "Could not load resource: " + ((FileEditorInput)input).getPath(), e));
        }
        return wrappedInput;
    }
    
    private static boolean isParserConsistentToMapping(ConcreteSyntax syntax, ParserFactory<?, ?> parserFactory) {
        String id = parserFactory.getSyntaxUUID();
        return id == null || EcoreUtil.getURI(syntax).equals(id);
    }
    
    private ParserCollection initializeParser() {
        //add mapping resource to resource set
        editingDomain.loadResource(parserFactory.getSyntaxUri().toString());
        
        ResourceSet resourceSet = editingDomain.getResourceSet();
        Set<URI> referenceScope = getAdditionalLookupURIs();
        
        EMFModelAdapter modelAdapter = new EMFModelAdapter(parserFactory.getMetamodelPackage(resourceSet), resourceSet, referenceScope);

        TextBlockReuseStrategyImpl reuseStrategy = new TextBlockReuseStrategyImpl(parserFactory.createLexer(/*input*/null), modelAdapter);
        ANTLRIncrementalLexerAdapter lexer = new ANTLRIncrementalLexerAdapter(new ANTLRLexerAdapter(parserFactory.createLexer(/*input*/null), reuseStrategy),
                modelAdapter, editingDomain);

        // FIXME: inject model adapter instead of hiding the initialization internally and then extracting it!
        ObservableInjectingParser parser = parserFactory.createParser(parserFactory.createIncrementalTokenStream(lexer), resourceSet, referenceScope, referenceScope);

        ITextBlocksTokenStream tokenStream = (ITextBlocksTokenStream) parser.getTokenStream();
        ParserTextBlocksHandler textBlocksHandler = new ParserTextBlocksHandler(tokenStream, resourceSet, parserFactory.getMetamodelUri(resourceSet), TcsUtil.getSyntaxPartitions(resourceSet, parserFactory.getLanguageId()),
                referenceScope, referenceScope);
        parser.setObserver(textBlocksHandler);

        lexer.setModelInjector(parser.getInjector());
        reuseStrategy.setModelElementInvestigator(parser.getInjector().getModelAdapter());
        
        QueryContextProvider queryContext = EcoreHelper.createProjectDependencyQueryContextProvider(resourceSet, referenceScope);
        OppositeEndFinder oppositeEndFinder = new Query2OppositeEndFinder(queryContext);
        
        PartitionAssignmentHandler partitionHandler = getDocumentProvider().getDocument(getEditorInput()).getPartitionHandler();
        MappingLinkRecoveringIncrementalParser incrementalParser = new MappingLinkRecoveringIncrementalParser(editingDomain, parserFactory, lexer, parser,
                reuseStrategy, referenceScope, oppositeEndFinder, partitionHandler);

        ShortPrettyPrinter shortPrettyPrinter = new ShortPrettyPrinter(((ModelInjector) parser.getInjector()).getModelAdapter());
        
        return new ParserCollection(parserFactory, lexer, parser, incrementalParser, textBlocksHandler, shortPrettyPrinter, oppositeEndFinder);
    }
        
    /**
     * IMP uses this to initialize all services. We proceed with a deferred initialization to
     * inject FURCAS specific information into our service implementations.
     * 
     * This method is called <b>after</b> {@link #init(IEditorSite, IEditorInput)}.
     */
    @Override
    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        
        ((FurcasParseController) fLanguageServiceManager.getParseController()).completeInit(editingDomain, new ContentProvider(), parserCollection);
        
        // re-run IMP setup procedure with our fully configured services
        fParserScheduler.cancel();
        fParserScheduler.schedule(/*schedule_delay*/ 100);
    }
    
    @Override
    public CtsDocumentProvider getDocumentProvider() {
        return documentProvoider;
    }

    /**
     * This method should be overridden if additional URIs should be added to
     * the lookup scope of the parser.
     */
    protected Set<URI> getAdditionalLookupURIs() {
        return Collections.emptySet();
    }
            
    @Override
    public boolean isDirty() {
        return ((BasicCommandStack) editingDomain.getCommandStack()).isSaveNeeded();
    }
    
}
