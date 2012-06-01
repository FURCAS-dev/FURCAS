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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.imp.language.Language;
import org.eclipse.imp.services.ITokenColorer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import com.sap.furcas.ide.editor.commands.SetupTextBlocksModelCommand;
import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.ide.editor.document.CtsDocumentProvider;
import com.sap.furcas.ide.editor.document.ModelEditorInput;
import com.sap.furcas.ide.editor.document.ModelEditorInputLoader;
import com.sap.furcas.ide.editor.imp.services.FurcasContentProposer;
import com.sap.furcas.ide.editor.imp.services.FurcasLabelProvider;
import com.sap.furcas.ide.editor.imp.services.FurcasTreeModelBuilder;
import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.common.exceptions.ParserInstantiationException;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.impl.DefaultPartitionAssignmentHandlerImpl;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

/**
 * Base class for language specific FURCAS editors. <p>
 * 
 * Clients that want to use this editor <b>must</b> register:
 * <ul>
 *      <li>an IMP {@link Language} descriptor</li>
 *      <li>the {@link FurcasParseController}</li>
 *      <li>the editor itself</li>
 * </ul><br>
 * 
 * Clients that want to use this editor <b>should</b> inherit from the <tt>FURCAS_BASE</tt>
 * language. It provides the following generic implementations:
 * <ul>
 *      <li>the {@link FurcasContentProposer}</li>
 *      <li>the {@link FurcasTreeModelBuilder}</li>
 *      <li>the {@link FurcasLabelProvider}</li>
 * </ul><br>
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
        public void notifyDirtyPropertyChanged() {
            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    firePropertyChange(IEditorPart.PROP_DIRTY);
                }
            });
        }
    }
    
    private final TransactionalEditingDomain editingDomain;
    private final ConcreteSyntax syntax;
    private final AdapterFactory adapterFactory;
    
    private CtsDocumentProvider documentProvoider;

    private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    private final SyntaxRegistry syntaxRegistry;
    private IncrementalParserFacade parserFacade;

    
    public AbstractFurcasEditor(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory) {
        this.parserFactory = parserFactory;
        
        this.editingDomain = createEditingDomain();
        configureEditingDomain(editingDomain);
        
        this.syntax = (ConcreteSyntax) editingDomain.getResourceSet().getEObject(URI.createURI(parserFactory.getSyntaxUUID()), true);
        validateEditorState(syntax, parserFactory);
        
        this.adapterFactory = createAdapterFactory();
        this.syntaxRegistry = new SyntaxRegistry();
    }
    
    /**
     * Initialize the editor by transform the editor input into a {@link ModelEditorInput}.
     * The IMP editor will never see the original one, but only the one built here.
     * 
     * This method is called <b>before</b> {@link #createPartControl(Composite)}.
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        ModelEditorInputLoader loader = new ModelEditorInputLoader(syntax, editingDomain.getResourceSet(), adapterFactory);
        ModelEditorInput modelEditorInput = loader.loadEditorInput(input);
        
        PartitionAssignmentHandler partitionHandler = createPartititionAssignmentHandler(modelEditorInput);
        parserFacade = createParserFacade(partitionHandler);
        
        SetupTextBlocksModelCommand command = new SetupTextBlocksModelCommand(editingDomain, modelEditorInput.getRootObject(),
                modelEditorInput.getRootBlock(), parserFacade, partitionHandler);
        editingDomain.getCommandStack().execute(command);
        modelEditorInput.setRootBlock(command.getResultBlock());
        
        documentProvoider = new CtsDocumentProvider(modelEditorInput, editingDomain, partitionHandler);
        super.init(site, modelEditorInput.asLightWeightEditorInput());
        
        syntaxRegistry.registerSyntaxForIncrementalEvaluation(syntax, parserFacade.getOppositeEndFinder(), new NullProgressMonitor(), parserFactory);
        syntaxRegistry.registerAllLoadedSyntaxesTriggerManagers(editingDomain.getResourceSet());
        
                
        // Reset dirty state. It was changed by the initializing commands.
        ((BasicCommandStack) editingDomain.getCommandStack()).saveIsDone();        
    }

    private IncrementalParserFacade createParserFacade(PartitionAssignmentHandler partitionHandler) {
        try {
            return new IncrementalParserFacade(parserFactory, editingDomain.getResourceSet(), partitionHandler);
        } catch (ParserInstantiationException e) {
            throw new RuntimeException("Failed to create the parser facade", e);
        }
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
        ((FurcasLabelProvider) fLanguageServiceManager.getLabelProvider()).plugProvider(
                new AdapterFactoryLabelProvider(adapterFactory));
        
        // re-run IMP setup procedure with our fully configured services
        fParserScheduler.cancel();
        fParserScheduler.schedule();
        
        getDocumentProvider().consumeModelEditorInput();
        
        updateVisuals();
    }
    
    private void updateVisuals() {
        EObject rootObject = getParseController().getCurrentRootObject();
        if (rootObject != null) { // better safe than sorry
            AdapterFactoryLabelProvider provider = new AdapterFactoryLabelProvider(adapterFactory);
            setPartName(provider.getText(rootObject));
            setTitleImage(provider.getImage(rootObject));
        }
    }
    
    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
        updateVisuals();
    }

    /**
     * Can be overwritten by subclasses if needed.
     */
    protected AdapterFactory createAdapterFactory() {
        @SuppressWarnings("hiding")
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
        adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
        return adapterFactory;
    }
    
    /**
     * Can be overwritten by subclasses if needed.
     * @param modelEditorInput 
     */
    protected PartitionAssignmentHandler createPartititionAssignmentHandler(ModelEditorInput modelEditorInput) {
        return new DefaultPartitionAssignmentHandlerImpl();
    }
    
    /**
     * Can be overwritten by subclasses if needed (e.g., to use a shared editing domain);
     * If overwritten, consider to also overwrite {@link #disposeEditingDomain()}. 
     * 
     */
    protected TransactionalEditingDomain createEditingDomain() {
        ResourceSet resourceSet = new ResourceSetImpl();
        return  WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain(resourceSet);
    }
    
    protected void disposeEditingDomain() {
        editingDomain.dispose();
    } 
    
    @Override
    public void dispose() {
        super.dispose();
        if (editingDomain != null) {
            syntaxRegistry.unregisterAllLoadedSyntaxesTriggerManagers(editingDomain.getResourceSet());
            syntaxRegistry.unregisterSyntax(syntax);
            disposeEditingDomain();
        }
    }
    
    private void configureEditingDomain(TransactionalEditingDomain domain) {
        TransactionalCommandStack commandStack = (TransactionalCommandStack) domain.getCommandStack();
        commandStack.setExceptionHandler(new CommandStackExceptionHandler());
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
        
        ECrossReferenceAdapter crossRefAdapter = new ECrossReferenceAdapter();
        editingDomain.getResourceSet().eAdapters().add(crossRefAdapter);
        crossRefAdapter.setTarget(editingDomain.getResourceSet()); 
    }
    
    private static void validateEditorState(ConcreteSyntax syntax, AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory) {
        if (syntax == null) {
            String message = "Error loading syntax definition: No syntax definition for language \""
                    + parserFactory.getLanguageId() + "\" found. Make sure the editor project"
                    + "is correctly referenced and the mapping model is available.";
            throw new RuntimeException(message);
        }
    }
    
    @Override
    public CtsDocumentProvider getDocumentProvider() {
        return documentProvoider;
    }
    
    @Override
    public FurcasParseController getParseController() {
        return (FurcasParseController) super.getParseController();
    }
    
}
