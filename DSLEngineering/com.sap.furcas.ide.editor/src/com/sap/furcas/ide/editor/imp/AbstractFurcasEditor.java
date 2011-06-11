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
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.RecordingCommand;
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
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.ide.cts.parser.incremental.DefaultPartitionAssignmentHandlerImpl;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

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
    
    private final TransactionalEditingDomain editingDomain;
    private final ConcreteSyntax syntax;
    private final AdapterFactory adapterFactory;
    
    private CtsDocumentProvider documentProvoider;

    private final AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory;
    private IncrementalParserFacade parserFacade;

    
    public AbstractFurcasEditor(AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>  parserFactory) {
        this.parserFactory = parserFactory;
        this.editingDomain = createEditingDomain();
        configureEditingDomain(editingDomain);
        
        this.adapterFactory = createAdapterFactory();
        
        this.syntax = (ConcreteSyntax) editingDomain.getResourceSet().getEObject(URI.createURI(parserFactory.getSyntaxUUID()), true);
        validateEditorState(syntax, parserFactory);
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
                modelEditorInput.getRootBlock(), parserFacade);
        editingDomain.getCommandStack().execute(command);
        modelEditorInput.setRootBlock(command.getResultBlock());
        
        documentProvoider = new CtsDocumentProvider(modelEditorInput, editingDomain, partitionHandler);
        super.init(site, modelEditorInput.asLightWeightEditorInput());
    }

    private IncrementalParserFacade createParserFacade(final PartitionAssignmentHandler partitionHandler) {
        // Using the command is a workaround because the incremental parser facade
        // is already modifying a model when creating the transient parsing resource
        final IncrementalParserFacade[] facade = new IncrementalParserFacade[1];
        RecordingCommand cmd = new RecordingCommand(editingDomain) {
            @Override
            protected void doExecute() {
                try {
                    // create a parser/lexer combo suitable for the current editor input
                    facade[0] = new IncrementalParserFacade(parserFactory, editingDomain.getResourceSet(), partitionHandler);
                    assert syntax == facade[0].getParserScope().getSyntax();
                } catch (ParserInstantiationException e) {
                    throw new RuntimeException("Unable to instantiate parser for language " + parserFactory.getLanguageId(), e);
                }
            }
        };
        editingDomain.getCommandStack().execute(cmd);
        return facade[0];
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
     * Can be overwritten by subclasses if needed.
     */
    protected TransactionalEditingDomain createEditingDomain() {
        return  WorkspaceEditingDomainFactory.INSTANCE.createEditingDomain();
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
    
//    @Override
//    public void gotoMarker(IMarker marker) {
//        EditUIMarkerHelper;
//        //getTargetObjects 
//        
//            try {
//                    if (marker.getType().equals(EValidator.MARKER)) {
//                            String uriAttribute = marker.getAttribute(
//                                            EValidator.URI_ATTRIBUTE, null);
//                            if (uriAttribute != null) {
//                                    URI uri = URI.createURI(uriAttribute);
//                                    EObject eObject = editingDomain.getResourceSet()
//                                                    .getEObject(uri, true);
//                                    if (eObject != null) {
//                                            setSelectionToViewer(Collections
//                                                            .singleton(editingDomain.getWrapper(eObject)));
//                                    }
//                            }
//                    }
//            } catch (CoreException exception) {
//                    OCLInEcorePlugin.INSTANCE.log(exception);
//            }
//    }
    
}
