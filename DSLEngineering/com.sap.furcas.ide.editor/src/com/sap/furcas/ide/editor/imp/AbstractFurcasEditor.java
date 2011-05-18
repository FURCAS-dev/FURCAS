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

import java.util.EventObject;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.expressions.provider.ExpressionsItemProviderAdapterFactory;
import org.eclipse.ocl.types.provider.TypesItemProviderAdapterFactory;
import org.eclipse.ocl.utilities.provider.UtilitiesItemProviderAdapterFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

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
import com.sap.furcas.metamodel.FURCAS.textblocks.provider.TextblocksItemProviderAdapterFactory;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.ide.cts.parser.incremental.DefaultPartitionAssignmentHandlerImpl;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

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
     * Make it easy to extract the editor content without directly depending on the editor. 
     */
    public class ContentProvider {
        public CtsDocument getDocument() {
            return getDocumentProvider().getDocument(getEditorInput());
        }
    }
    
    private final EditingDomain editingDomain;
    private ConcreteSyntax syntax;
    private CtsDocumentProvider documentProvoider;

    private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    private IncrementalParserFacade parserFacade;

    
    public AbstractFurcasEditor(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory) {
        this.editingDomain = createEditingDomain();
        this.parserFactory = parserFactory;
    }
    
    /**
     * Initialize the editor by transform the editor input into a {@link ModelEditorInput}.
     * The IMP editor will never see the original one, but only the one built here.
     * 
     * This method is called <b>before</b> {@link #createPartControl(Composite)}.
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        editingDomain.getResourceSet().getResource(parserFactory.getSyntaxResourceURI(), /*load*/ true);
        syntax = TcsUtil.getSyntaxByName(editingDomain.getResourceSet(), parserFactory.getLanguageId());
        validateEditorState(syntax, parserFactory);
        
        // create a temporary opposite end finder that knows about the static resources in the workspace
        // It is required to find potential textblocks
        OppositeEndFinder entireWorkspaceOppositeEndFinder = Query2OppositeEndFinder.getInstance();
        ModelEditorInputLoader loader = new ModelEditorInputLoader(syntax, editingDomain.getResourceSet(),
                entireWorkspaceOppositeEndFinder, parserFactory);
        ModelEditorInput modelEditorInput = loader.loadEditorInput(input);
        
        PartitionAssignmentHandler partitionHandler = setupPartitioning(modelEditorInput);

        try {
            // create a parser/lexer combo suitable for the current editor input
            parserFacade = new IncrementalParserFacade(parserFactory, editingDomain.getResourceSet(), partitionHandler);
            assert syntax == parserFacade.getParserScope().getSyntax();
        } catch (ParserInstantiationException e) {
            throw new PartInitException("Unable to instantiate parser for language " + parserFactory.getLanguageId(), e);
        }

        documentProvoider = new CtsDocumentProvider(syntax, editingDomain, partitionHandler);
        super.init(site, modelEditorInput);
        
        CtsDocument document = getDocumentProvider().getDocument(modelEditorInput);
        document.completeInit(parserFacade);
    }

    private static PartitionAssignmentHandler setupPartitioning(ModelEditorInput modelEditorInput) {
        PartitionAssignmentHandler partitionHandler = new DefaultPartitionAssignmentHandlerImpl();
        partitionHandler.setDefaultPartition(modelEditorInput.getRootObject().eResource());
        
        if (modelEditorInput.getRootBlock().eResource() == null) {
            // might be a completely new textblock
            partitionHandler.assignToDefaultTextBlocksPartition(modelEditorInput.getRootBlock());
        }        
        return partitionHandler;
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
        getParseController().completeInit(editingDomain, new ContentProvider(), parserFacade);
        
        // re-run IMP setup procedure with our fully configured services
        fParserScheduler.cancel();
        fParserScheduler.schedule();
    }
    
    @Override
    public CtsDocumentProvider getDocumentProvider() {
        return documentProvoider;
    }
    
    @Override
    public FurcasParseController getParseController() {
        return (FurcasParseController) super.getParseController();
    }
    
    private AdapterFactoryEditingDomain createEditingDomain() {
        // Create an adapter factory that yields item providers.
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new FURCASItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TCSItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TextblocksItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TypesItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new UtilitiesItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ExpressionsItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new org.eclipse.ocl.ecore.provider.EcoreItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

        // Create the command stack that will notify this editor as commands are executed.
        BasicCommandStack commandStack = new BasicCommandStack();
        commandStack.addCommandStackListener(new CommandStackListener() {
            @Override
            public void commandStackChanged(EventObject event) {
                Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        firePropertyChange(IEditorPart.PROP_DIRTY);
                    }
                });
            }
        });

        // Create the editing domain with a special command stack.
        AdapterFactoryEditingDomain domain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
        return domain;
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
   
}
