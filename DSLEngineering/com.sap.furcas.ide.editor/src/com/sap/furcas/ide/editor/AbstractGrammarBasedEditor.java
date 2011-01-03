package com.sap.furcas.ide.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.AnnotationPainter;
import org.eclipse.jface.text.source.AnnotationPainter.IDrawingStrategy;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.expressions.provider.ExpressionsItemProviderAdapterFactory;
import org.eclipse.ocl.types.provider.TypesItemProviderAdapterFactory;
import org.eclipse.ocl.utilities.provider.UtilitiesItemProviderAdapterFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import com.sap.furcas.ide.editor.commands.CleanUpTextBlocksCommand;
import com.sap.furcas.ide.editor.commands.ParseCommand;
import com.sap.furcas.ide.editor.document.CtsDocument;
import com.sap.furcas.ide.editor.document.ModelEditorInput;
import com.sap.furcas.ide.editor.matching.CtsStaticMatcher;
import com.sap.furcas.ide.editor.preferences.PreferenceInitializer;
import com.sap.furcas.ide.editor.recovery.ModelEditorInputRecoveryStrategy;
import com.sap.furcas.ide.editor.recovery.TbRecoverUtil;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.provider.TCSItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.provider.FURCASItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.provider.TextblockdefinitionItemProviderAdapterFactory;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.metamodel.FURCAS.textblocks.provider.TextblocksItemProviderAdapterFactory;
import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.ParsingError;
import com.sap.furcas.runtime.parser.impl.ModelInjector;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.parser.textblocks.ITextBlocksTokenStream;
import com.sap.furcas.runtime.parser.textblocks.observer.ParserTextBlocksHandler;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;
import com.sap.ide.cts.parser.errorhandling.ErrorEntry;
import com.sap.ide.cts.parser.errorhandling.SemanticParserException;
import com.sap.ide.cts.parser.incremental.MappingLinkRecoveringIncrementalParser;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.ide.cts.parser.incremental.PartitionAssignmentHandler;
import com.sap.ide.cts.parser.incremental.TextBlockReuseStrategyImpl;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRIncrementalLexerAdapter;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRLexerAdapter;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

public abstract class AbstractGrammarBasedEditor extends ModelBasedTextEditor
        implements MarkerRefreshListener {

    private ICharacterPairMatcher fBracketMatcher;
    private ProjectionAnnotationModel annotationModel;
    private Annotation[] oldAnnotations;
    private ProjectionSupport projectionSupport;

    public void updateFoldingStructure(ArrayList<Position> positions) {
        Annotation[] annotations = new Annotation[positions.size()];
        HashMap<ProjectionAnnotation, Position> newAnnotations = new HashMap<ProjectionAnnotation, Position>();
        for (int i = 0; i < positions.size(); i++) {
            ProjectionAnnotation annotation = new ProjectionAnnotation();
            newAnnotations.put(annotation, positions.get(i));
            annotations[i] = annotation;
        }
        annotationModel.modifyAnnotations(oldAnnotations, newAnnotations, null);
        oldAnnotations = annotations;
    }

    @Override
    protected void configureSourceViewerDecorationSupport(
            SourceViewerDecorationSupport support) {

        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        "com.sap.ide.cts.editor.bracketMatching");
        if (config.length != 0) {
            IConfigurationElement e = config[0];
            String matchingType = e.getAttribute("matchingType");
            if (matchingType.equals("default")) {
                fBracketMatcher = new DefaultCharacterPairMatcher(
                        CtsStaticMatcher.MATCHING_BRACKETS);
            }
            if (matchingType.equals("configurable")) {
                char matchingBraces[] = e.getAttribute("matchingBrackets")
                        .toCharArray();
                if (matchingBraces != null) {
                    fBracketMatcher = new DefaultCharacterPairMatcher(
                            matchingBraces);
                }
            }

            support.setCharacterPairMatcher(fBracketMatcher);
            support.setMatchingCharacterPainterPreferenceKeys(
                    PreferenceInitializer.EDITOR_MATCHING_BRACKETS,
                    PreferenceInitializer.EDITOR_MATCHING_BRACKETS_COLOR);
        }

        IPreferenceStore pref = CtsActivator.getDefault().getPreferenceStore();
        pref.setValue(PreferenceInitializer.EDITOR_MATCHING_BRACKETS, true);
        IPreferenceStore[] stores = { getPreferenceStore(), pref };
        super.setPreferenceStore(new ChainedPreferenceStore(stores));

        super.configureSourceViewerDecorationSupport(support);
    }

    public static class BoxDrawingStrategy implements IDrawingStrategy {
        /*
         * @see
         * org.eclipse.jface.text.source.AnnotationPainter.IDrawingStrategy#
         * draw(org.eclipse.jface.text.source.Annotation,
         * org.eclipse.swt.graphics.GC, org.eclipse.swt.custom.StyledText, int,
         * int, org.eclipse.swt.graphics.Color)
         */
        @Override
        public void draw(Annotation annotation, GC gc, StyledText textWidget,
                int offset, int length, Color color) {

            if (length == 0) {
                // fgIBeamStrategy.draw(annotation, gc, textWidget, offset,
                // length, color);
                return;
            }

            if (gc != null) {

                Rectangle bounds;
                if (length > 0) {
                    bounds = textWidget.getTextBounds(offset, offset + length
                            - 1);
                } else {
                    Point loc = textWidget.getLocationAtOffset(offset);
                    bounds = new Rectangle(loc.x, loc.y, 1,
                            textWidget.getLineHeight(offset));
                }

                drawBox(gc, textWidget, color, bounds);

            } else {
                textWidget.redrawRange(offset, length, true);
            }
        }

        protected void drawBox(GC gc, StyledText textWidget, Color color,
                Rectangle bounds) {
            gc.setForeground(color);
            // gc.setBackground(color);
            gc.drawRectangle(bounds.x, bounds.y, bounds.width - 1,
                    bounds.height - 1);
            // textWidget.drawBackground(gc,bounds.x, bounds.y, bounds.width -
            // 1,
            // bounds.height - 1);
        }
    }

    public static final String ERROR_TYPE = "org.eclipse.ui.workbench.texteditor.error";
    public static final String WARNING_TYPE = "org.eclipse.ui.workbench.texteditor.warning";
    private static final String BOX_DRAWING_STRATEGY = "BOX_DRAWING_STRATEGY";

    public static boolean highlightTBCanges = false;

    private AbstractGrammarBasedContentOutlinePage outlinePage;
    private Object model;

    private ANTLRIncrementalLexerAdapter lexer;
    private ObservableInjectingParser parser;

    private ParserTextBlocksHandler textBlocksHandler;
    private final ITokenMapper tokenMapper;
    private ParserFactory<?, ?> parserFactory;
    private Resource tbPartition;
    private final List<Annotation> tbHighlightAnnotations = new ArrayList<Annotation>();
    private MappingLinkRecoveringIncrementalParser incrementalParser;
    private PartitionHighlighter partitionHighlighter;
    private final Set<Annotation> markerAnnotations = new HashSet<Annotation>();
    private final Set<IMarker> parseErrorMarkers = new HashSet<IMarker>();
    private ShortPrettyPrinter shortPrettyPrinter;
    private Job parseRunnable;

    /**
     * A thread-safe queue with the data which {@link OnMarkerChangeJob} needs
     * to process it's work.
     */
    private final ConcurrentLinkedQueue<IDocumentProvider> providerTaskQueue = new ConcurrentLinkedQueue<IDocumentProvider>();

    private OnMarkerChangeJob onMarkerChangeJob = null;
    private ComposedAdapterFactory adapterFactory;
    public AbstractGrammarBasedEditor(ParserFactory<?, ?> parserFactory,
            ITokenMapper tokenMapper) {
        super();

        this.setParserFactory(parserFactory);
        this.tokenMapper = tokenMapper;
        this.oppositeEndFinder = Query2OppositeEndFinder.getInstance();
        initializeEditingDomain();
        // do this via plugin.xml?
        // setDocumentProvider(new CtsDocumentProvider());
        // TODO
        // ModelManager.getMarkerManager().addRefreshListener(this);
    }

    public String getLanguageId() {
        return parserFactory.getLanguageId();
    }

    protected void setParser(ObservableInjectingParser parser) {
        this.parser = parser;
        if (parser.getTokenStream() instanceof ITextBlocksTokenStream) {
            ITextBlocksTokenStream tokenStream = (ITextBlocksTokenStream) parser
                    .getTokenStream();
            textBlocksHandler = new ParserTextBlocksHandler(tokenStream,
                    getEditingDomain().getResourceSet(), getParserFactory().getMetamodelUri(
                            getEditingDomain().getResourceSet()), TcsUtil.getSyntaxPartitions(
                                    getEditingDomain().getResourceSet(), getLanguageId()),
                    getAdditionalLookupURIS(), getAdditionalLookupURIS());
            this.parser.setObserver(textBlocksHandler);
        } else {
            throw new IllegalArgumentException(
                    "Only TextBlocks Aware Parsers are supported as parsers if this Editor. Given was a:"
                            + parser.getClass());
        }
    }

    protected void setLexer(ANTLRIncrementalLexerAdapter lexer) {
        this.lexer = lexer;
    }

    protected ANTLRIncrementalLexerAdapter getLexer() {
        return lexer;
    }

    protected Class<? extends Lexer> getLexerClass() {
        return getParserFactory().getLexerClass();
    }

    public ObservableInjectingParser getParser() {
        return parser;
    }

    @Override
    public void createPartControl(Composite parent) {
        final AbstractGrammarBasedViewerConfiguration config = createSourceViewerConfig(getDocumentProvider()
                .getAnnotationModel(getEditorInput()));
        setSourceViewerConfiguration(config);
        
        super.createPartControl(parent);

        ProjectionViewer viewer = (ProjectionViewer) getSourceViewer();
        projectionSupport = new ProjectionSupport(viewer,
                getAnnotationAccess(), getSharedColors());
        projectionSupport.install();
        viewer.doOperation(ProjectionViewer.TOGGLE);
        annotationModel = viewer.getProjectionAnnotationModel();

        final SourceViewer textViewer = (SourceViewer) getSourceViewerPublic();
        textViewer.getTextWidget().addListener(SWT.KeyDown, new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (event.character == ' '
                        && (event.stateMask & SWT.CTRL) == SWT.CTRL) {
                    config.getContentAssistant(textViewer)
                            .showPossibleCompletions();
                }

            }

        });

//        textViewer.getTextWidget().addListener(SWT.KeyDown,
//                new HighlightTextBlockAction(textViewer));
//
//        textViewer.getTextWidget().addListener(SWT.KeyDown,
//                new GotoDeclarationAction(textViewer));

        // to paint the annotations
        AnnotationPainter ap = new AnnotationPainter(textViewer,
                getAnnotationAccess());
        ap.addDrawingStrategy(BOX_DRAWING_STRATEGY, new BoxDrawingStrategy());

        ap.addAnnotationType(ERROR_TYPE);
        ap.setAnnotationTypeColor(ERROR_TYPE, new Color(Display.getDefault(),
                new RGB(255, 0, 0)));
        ap.addHighlightAnnotationType(ERROR_TYPE);

        ap.addAnnotationType(WARNING_TYPE);
        ap.setAnnotationTypeColor(WARNING_TYPE, new Color(Display.getDefault(),
                new RGB(255, 255, 0)));

//        ap.addAnnotationType(HighlightTextBlockAction.TB_HIGHLIGHT_ANNOTATION,
//                BOX_DRAWING_STRATEGY);
//        ap.setAnnotationTypeColor(
//                HighlightTextBlockAction.TB_HIGHLIGHT_ANNOTATION, new Color(
//                        Display.getDefault(), new RGB(122, 122, 122)));

        // this will draw the squigglies under the text
        textViewer.addPainter(ap);
        parseRunnable = new Job("Background Parsing") {
            @Override
            public IStatus run(final IProgressMonitor monitor) {

                final String msg = "Parsing...";
                monitor.beginTask(msg, 100);
                // TODO here the event classification has to be done
                parseInputAndRefreshAnnotations(true);
                monitor.done();
                return Status.OK_STATUS;
            }
        };
        textViewer.addTextListener(new ITextListener() {

            @Override
            public void textChanged(TextEvent event) {
                if (event.getDocumentEvent() != null) {
                    if (parseRunnable.getState() == Job.WAITING) {
                        parseRunnable.cancel();
                    }
                    parseRunnable.schedule(650);
                }
            }

        });
        parseInputAndRefreshAnnotations(true);
    }

    @Override
    public void onMarkerChange(IProject affectedProject) {

        if (onMarkerChangeJob == null) {

            onMarkerChangeJob = new OnMarkerChangeJob("MarkerChangedJob", this,
                    providerTaskQueue);
        }

        // Refresh necessary ?
        if (getEditorInput().getAdapter(IProject.class).equals(affectedProject)
                && getDocumentProvider() != null) {

            providerTaskQueue.add(getDocumentProvider());
        }

        if (onMarkerChangeJob.getState() == Job.SLEEPING) {
            onMarkerChangeJob.wakeUp();
        }

        else if (onMarkerChangeJob.getState() == Job.NONE) {
            onMarkerChangeJob.schedule();
        }

        // In all other cases the onMarkerChangeJob is WAITING or RUNNING.
    }

    //
    // public void onMarkerChange(IProject affectedProject){
    // if(getEditorInput().getAdapter(IProject.class).equals(affectedProject)){
    // IDocumentProvider provider = getDocumentProvider();
    // if(provider != null) {
    // CtsDocument document =
    // (CtsDocument)provider.getDocument(getEditorInput());
    // if(document != null) {
    // if(document.isCompletelyItitialized() &&
    // ((Partitionable)document.getRootObject()).is___Alive()){
    // Resource rootPartition =
    // ((Partitionable)document.getRootObject()).get___Partition();
    // refreshModelAnnotations(rootPartition);
    // }
    // }
    // }
    // }
    // }

    private Collection<DocumentNode> checkPartitioning(DocumentNode start,
            Resource rootPartition) {
        ArrayList<DocumentNode> subNodesInOtherPartitions = new ArrayList<DocumentNode>();
        if (start instanceof TextBlock) {
            TextBlock tb = (TextBlock) start;
            for (DocumentNode documentNode : tb.getSubBlocks()) {
                subNodesInOtherPartitions.addAll(checkPartitioning(
                        documentNode, rootPartition));
            }
            if (tb.getCorrespondingModelElements().size() > 0) {
                for (EObject element : tb.getCorrespondingModelElements()) {
                    if (!element.eResource().equals(rootPartition)) {
                        subNodesInOtherPartitions.add(tb);
                    }
                }
            }
        }
        return subNodesInOtherPartitions;
    }

    private PartitionHighlighter createHighlighter() {
        IAnnotationModel model = getDocumentProvider().getAnnotationModel(
                getEditorInput());
        return new PartitionHighlighter(model);
    }

    @Override
    public void doSaveAboutToPerform(IProgressMonitor monitor) {
        parseInputAndRefreshAnnotations(false);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object getAdapter(Class required) {
        if (IContentOutlinePage.class.equals(required)) {
            if (outlinePage == null) {
                outlinePage = new AbstractGrammarBasedContentOutlinePage(
                        getDocumentProvider(), this);
                outlinePage.setInput(getModel());
            }
            return outlinePage;
        }
        return super.getAdapter(required);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
    
    /**
     * This is for implementing {@link IEditorPart} and simply tests the command
     * stack.
     */
    @Override
    public boolean isDirty() {
        return ((BasicCommandStack) getEditingDomain().getCommandStack())
                .isSaveNeeded();
    }

    /**
     * This sets up the editing domain for the model editor. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void initializeEditingDomain() {
        // Create an adapter factory that yields item providers.
        //
        adapterFactory = new ComposedAdapterFactory(
                ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

        adapterFactory
                .addAdapterFactory(new ResourceItemProviderAdapterFactory());
        adapterFactory
                .addAdapterFactory(new FURCASItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TCSItemProviderAdapterFactory());
        adapterFactory
                .addAdapterFactory(new TextblocksItemProviderAdapterFactory());
        adapterFactory
                .addAdapterFactory(new TextblockdefinitionItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
        adapterFactory.addAdapterFactory(new TypesItemProviderAdapterFactory());
        adapterFactory
                .addAdapterFactory(new UtilitiesItemProviderAdapterFactory());
        adapterFactory
                .addAdapterFactory(new ExpressionsItemProviderAdapterFactory());
        adapterFactory
                .addAdapterFactory(new org.eclipse.ocl.ecore.provider.EcoreItemProviderAdapterFactory());
        adapterFactory
                .addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

        // Create the command stack that will notify this editor as commands are
        // executed.
        //
        BasicCommandStack commandStack = new BasicCommandStack();

        // Add a listener to set the most recent command's affected objects to
        // be the selection of the viewer with focus.
        //
        commandStack.addCommandStackListener(new CommandStackListener() {
            @Override
            public void commandStackChanged(final EventObject event) {
                // getContainer().getDisplay().asyncExec(new Runnable() {
                // public void run() {
                // firePropertyChange(IEditorPart.PROP_DIRTY);
                //
                // // Try to select the affected objects.
                // //
                // Command mostRecentCommand = ((CommandStack) event
                // .getSource()).getMostRecentCommand();
                // if (mostRecentCommand != null) {
                // setSelectionToViewer(mostRecentCommand
                // .getAffectedObjects());
                // }
                // if (propertySheetPage != null
                // && !propertySheetPage.getControl().isDisposed()) {
                // propertySheetPage.refresh();
                // }
                // }
                // });
            }
        });

        // Create the editing domain with a special command stack.
        //
        setEditingDomain(new AdapterFactoryEditingDomain(adapterFactory,
                commandStack, new HashMap<Resource, Boolean>()));
    }

    /**
     * Additionally initializes the connection for the given editor input.
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        IEditorInput wrappedInput = input;
        try {
            if(input instanceof FileEditorInput) {
                Resource r = getEditingDomain().loadResource(URI.createFileURI(((FileEditorInput)input).getPath().toOSString()).toString());
                if(r.getErrors().size() > 0) {
                    CtsActivator.getDefault().getLog().log(new Status(Status.ERROR, CtsActivator.PLUGIN_ID, "Could not load resource: " + ((FileEditorInput)input).getPath() + r.getErrors()));
                    return;
                }
                wrappedInput = new ModelEditorInput(r.getContents().iterator().next());
                IContainer[] containers = EcorePlugin.getWorkspaceRoot().findContainersForLocationURI(((FileEditorInput) input).getURI());
                if(containers.length > 0) {
                    IProject proj = containers[0].getProject();
                    ((ModelEditorInput) wrappedInput).setProject(proj);
                }
            }
        } catch (Exception e) {
            CtsActivator.getDefault().getLog().log(new Status(Status.ERROR, CtsActivator.PLUGIN_ID, "Could not load resource: " + ((FileEditorInput)input).getPath(), e));
        }
        super.init(site, wrappedInput);
        // editingDomain.getCommandStack().openGroup("Deferred Editor Initialization");
        try {
            initializeNewParser();
            // Initialize the document
            ConcreteSyntax syntax = EditorUtil.getActiveSyntax(this);
            if (syntax == null) {
                IStatus status = new Status(IStatus.ERROR,
                        CtsActivator.PLUGIN_ID, "");
                ErrorDialog
                        .openError(
                                getSite().getShell(),
                                "Error loading syntax definition",
                                "No syntax definition for language \""
                                        + getLanguageId()
                                        + "\" found. Make sure the editor project is correctly referenced and the mapping model is available.",
                                status);
                return;
            }
            if (!isParserConsistentToMapping(syntax, parserFactory)) {
                MessageDialog.openError(CtsActivator.getDefault()
                        .getWorkbench().getActiveWorkbenchWindow().getShell(),
                        "Inconsistency between mapping and parser",
                        "Loaded parser class: "
                                + parserFactory.getParserClass()
                                        .getCanonicalName()
                                + " is not consistent with mapping: "
                                + EcoreUtil.getURI(syntax));
            }

//            initConnection(input);

            ClassTemplate rootTemplate = TcsUtil.getMainClassTemplate(syntax);
            CtsDocument document = (CtsDocument) getDocumentProvider()
                    .getDocument(wrappedInput);
            document.completeInit(syntax, rootTemplate, getParserFactory(),
                    getRecoveryStrategy(), getParser(), null);

            registerNameChangeListenerForInput(document.getRootObject());

            TextBlock rootBlock = document.getRootBlock();
            setModel(rootBlock);
            TbRecoverUtil.checkAndMigrateTokenIds(rootBlock, getParser(),
                    getLexer(), shortPrettyPrinter, false);
            tbPartition = rootBlock.eResource();
        } finally {
//            editingDomain.getCommandStack().closeGroup();
        }
    }

    private boolean isParserConsistentToMapping(ConcreteSyntax syntax,
            ParserFactory<?, ?> parserFactory2) {
        String id = parserFactory.getSyntaxUUID();
        return id == null || EcoreUtil.getURI(syntax).equals(id);
    }

    /**
     * This needs much more work. But so far:
     * 
     * Dependencies from CtsDocument, which required to know its editor, pulled
     * up and encapsulated into this strategy.
     * 
     * @return a strategy to help CtsDocuments get a valid rootBlock
     */
    public ModelEditorInputRecoveryStrategy getRecoveryStrategy() {
        return new ModelEditorInputRecoveryStrategy() {

            @Override
            public TextBlock recoverBrokenTextBlockMapping(EObject rootObject,
                    TextBlock blockInError, ClassTemplate rootTemplate) {
                assert blockInError.getType() == null : "Mapping which is supposed to be broken is still valid.";
                TextBlock rootBlock = null;

                // might be a valid textblock but with a broken reference to the
                // mapping
                boolean recoverLink = MessageDialog
                        .openQuestion(
                                CtsActivator.getDefault().getWorkbench()
                                        .getActiveWorkbenchWindow().getShell(),
                                "Mapping Link Broken",
                                "The link from the current document to the mapping definition is broken."
                                        + "Would you like to try to recover this connection?\n"
                                        + "Otherwise this will cause all elements in defined in the"
                                        + "document to be re-created upon changes to the document!");
                if (recoverLink) {
                    if (!TbRecoverUtil.recoverTextBlockFromBrokenMapping(
                            blockInError, rootTemplate, getIncrementalParser(),
                            getParser(), getLexer(), shortPrettyPrinter)) {
                        String title = "Mapping Link Recovery Failed";
                        String error = "The link from the current document to the mapping definition is broken."
                                + "Recovery failed!\n"
                                + "This will cause all elements in defined in the"
                                + "document to be re-created upon changes to the document!";
                        String oldClass = blockInError.getCachedString();
                        String newClass = "";
                        try {
                            //FIXME once PrettyPrinter is migrated
//                            IncrementalTextBlockPrettyPrinter pp = new IncrementalTextBlockPrettyPrinter(
//                                    /* readOnly */true);
//                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                            TCSExtractorPrintStream target = new TCSExtractorPrintStream(
//                                    stream);
//                            pp.prettyPrint(rootObject, blockInError,
//                                    rootTemplate.getConcretesyntax(),
//                                    rootTemplate, target);
//                            newClass = stream.toString();
                        } catch (Exception e) {
                            e.printStackTrace();
                            newClass = "Error occurred while pretty printing: "
                                    + e.getMessage();
                        }
//                        PrettyPrintPreviewDialog dialog = new PrettyPrintPreviewDialog(
//                                title, error, oldClass, newClass);
//                        boolean startPrettyPrinter = dialog.open();
//                        if (startPrettyPrinter) {
//                            PrettyPrintAction action = new PrettyPrintAction(
//                                    (MofClass) rootObject.refMetaObject(),
//                                    rootObject, false);
//                            action.runWithEvent(null);
//                            rootBlock = action.getRootBlock();
//                        } else {
//                            rootBlock = blockInError;
//                        }
                    } else {
                        rootBlock = blockInError;
                    }
                } else {
                    // just do nothing then
                    rootBlock = blockInError;
                }
                return rootBlock;
            }
        };
    }

    private void registerNameChangeListenerForInput(EObject inputObject) {
//        Entry<Attribute, String> nameAttribute = ModelManager.getInstance()
//                .getObjectNameAttribute(inputObject);
//
//        if (nameAttribute != null) {
//            ChangeListener changeListener = new ChangeListener() {
//
//                @Override
//                public void notify(ChangeEvent event) {
//
//                    final AttributeValueChangeEvent changeEvent = (AttributeValueChangeEvent) event;
//                    Runnable uiUpdater = new Runnable() {
//                        @Override
//                        public void run() {
//                            setPartName((String) changeEvent.getNewValue());
//                            // this will make the tab re-render itself
//                            firePropertyChange(PROP_DIRTY);
//                        }
//                    };
//                    Display.getDefault().asyncExec(uiUpdater);
//                }
//            };
//            AttributeFilter attributeFilter = new AttributeFilter(
//                    nameAttribute.getKey());
//            InstanceFilter instanceFilter = new InstanceFilter(inputObject);
//            AndFilter compositeFilter = new AndFilter(instanceFilter,
//                    attributeFilter);
//            getResourceSet().getSession().getEventRegistry()
//                    .registerListener(changeListener, compositeFilter);
//        }

    }

    // @Override
    // public void setFocus() {
    // super.setFocus();
    // //remove history listeners that are automatically registered by model
    // editor as they slow down the save process.
    // removeHistoryListener();
    // }
    //
    // private void removeHistoryListener() {
    // IOperationHistoryListener mHistoryListener;
    // try {
    // String[] listenerFieldsToRemove = new String[]{"mUndoAction",
    // "mRedoAction", "mHistoryListener"};
    // for (int i = 0; i < listenerFieldsToRemove.length; i++) {
    // String listenerFieldName = listenerFieldsToRemove[i];
    // Field listenerField =
    // ModelEditor.class.getDeclaredField(listenerFieldName);
    // listenerField.setAccessible(true);
    // mHistoryListener = (IOperationHistoryListener)
    // listenerField.get(this.getModelEditor());
    // if(mHistoryListener != null) {
    // OperationHistoryFactory.getOperationHistory().removeOperationHistoryListener(mHistoryListener);
    // }
    // }
    //
    // } catch (IllegalArgumentException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (SecurityException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (IllegalAccessException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (NoSuchFieldException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    protected ITokenMapper getTokenMapper() {
        return this.tokenMapper;
    }

    /**
     * First calls the subclassed Lexer to lex the input file, then calls the
     * parser to turn the input file into a model. Afterwards the outlinepage is
     * updated using the new model. If there are errors during lexing or
     * parsing, they are passed to the {@link #showInputInvalidInfo(ErrorEntry)}
     * method. The outline is also updated using the partially parsed model.
     * 
     * @param dry
     *            If <code>true</code> a dry parse is done without creating any
     *            mode elements.
     */
    protected void parseInputAndRefreshAnnotations(boolean dry) {
        // TODO check how this is actually done correctly
        ((AnnotationModel) getDocumentProvider().getAnnotationModel(
                getEditorInput())).removeAllAnnotations();
        getPartitionHighlighter().removeAll();
        boolean hasErrors = false, hasWarnings = false;
        try {
            CtsDocument ctsDocument = (CtsDocument) getSourceViewerPublic()
                    .getDocument();
            TextBlock rootBlock = ctsDocument.getRootBlock();
            TextBlock previousBlock = (TextBlock) TbUtil
                    .getNewestVersion(rootBlock);
            ParseCommand parseCommand = null;
            if (dry) {
                dryParse(previousBlock);
                // parseCommand = new ParseCommand(previousBlock,
                // getWorkingConnection(), this, /*errorMode*/ true);

            } else {
                parseCommand = new ParseCommand(previousBlock,
                        getEditingDomain().getResourceSet(), this, /* errorMode */false);

//                ParsingTextblocksActivator.getDefault().enableMoinLogging(
//                        getEditingDomain().getResourceSet());
                getEditingDomain().getCommandStack().execute(parseCommand);
//                ParsingTextblocksActivator.getDefault().disableMoinLogging(
//                        getEditingDomain().getResourceSet());
                if (parseCommand.getParseException() != null) {
                    throw parseCommand.getParseException();
                }
                TextBlock newBlock = parseCommand.getNewBlock();
                // move to new current version
                if (newBlock == null || !EcoreHelper.isAlive(newBlock)) {
                    throw new RuntimeException(
                            "Textblock returned by parsing has been deleted!");
                }

                if (dry) {
                    if (TbVersionUtil.getOtherVersion(newBlock,
                            Version.CURRENT) != null) {
                        // only clean up if a current version exists, as this is
                        // only the case if
                        // the rootBlock was at least lexable
                        // monitor.beginTask("Cleaning up textblocks.", 100);
                        CleanUpTextBlocksCommand cleanUpCommand = new CleanUpTextBlocksCommand(
                                ctsDocument.getRootBlock());
                        getEditingDomain().getCommandStack().execute(cleanUpCommand);
                        newBlock = cleanUpCommand.getNewRootBlock();
                        ctsDocument.setRootBlock(newBlock);
                        ctsDocument.reduceToMinimalState();
                    }
                }
                setModel(newBlock);
            }
        } catch (SemanticParserException e) {
            for (ParsingError ex : e.getIssuesList()) {
                showInputInvalidInfo(ex);
                hasErrors = true;
            }
            // TODO annotate Elements in Outline View with error marker
            setModel(e.getTextBlock());
            updateOutlineSave();
            if (hasErrors) {
                return;
            } else if (hasWarnings) {
                setStatusLineErrorMessageInUIThread(e.getIssuesList().get(0)
                        .getMessage());
            }
        } catch (RuntimeException e) {
            CtsActivator.logError(e);
            return;

        } catch (Exception e) {
            showInputInvalidInfo(e);
            return;
        }
        if (!hasErrors) {
            setStatusLineErrorMessageInUIThread(null);
        }
        if (!hasWarnings) {
            setStatusLineMessageInUIThread(null);
        }
        CtsDocument document = (CtsDocument) getDocumentProvider().getDocument(
                getEditorInput());
        if (EcoreHelper.isAlive(document.getRootObject())) {
            Resource rootPartition = document.getRootObject().eResource();
            TextBlock rootBlock = document.getRootBlock();
            // check partitioning for elements in other partitions
            getPartitionHighlighter().addHighlights(
                    checkPartitioning(TbUtil.getNewestVersion(rootBlock),
                            rootPartition));
            refreshModelAnnotations(rootPartition);
        }
        // TODO do this for all other partitions as well
        updateOutlineSave();
    }

    private void setStatusLineErrorMessageInUIThread(final String message) {
        if (Display.getCurrent() == null) {
            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    setStatusLineErrorMessage(message);
                }
            });

        } else {
            setStatusLineErrorMessage(message);
        }
    }

    private void setStatusLineMessageInUIThread(final String message) {
        if (Display.getCurrent() == null) {
            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    setStatusLineMessage(message);
                }
            });

        } else {
            setStatusLineMessage(message);
        }
    }

    private final Set<Resource> annotatedPartitionsToUpdate = Collections
            .synchronizedSet(new HashSet<Resource>());

//    private class AnnotationUpdater implements Runnable {
//
//        private final Resource rootPartition;
//
//        public AnnotationUpdater(Resource partition) {
//            this.rootPartition = partition;
//            annotatedPartitionsToUpdate.add(partition);
//        }
//
//        @Override
//        public void run() {
//            annotatedPartitionsToUpdate.remove(rootPartition);
//            for (Annotation markerAnnotation : new HashSet<Annotation>(
//                    markerAnnotations)) {
//                IAnnotationModel model = getDocumentProvider()
//                        .getAnnotationModel(getEditorInput());
//                markerAnnotations.remove(markerAnnotation);
//                if (model != null) {
//                    model.removeAnnotation(markerAnnotation);
//                }
//            }
//            IMarker[] markers = ModelManager.getMarkerManager().findMarkers(
//                    rootPartition, IMarker.PROBLEM, true, 0);
//            for (IMarker marker : markers) {
//                EObject element;
//                try {
//                    element = (EObject) getResourceSet()
//                            .getElement(
//                                    getResourceSet()
//                                            .getSession()
//                                            .getMoin()
//                                            .createMri(
//                                                    (String) marker
//                                                            .getAttribute(MarkerManager.ATTRIBUTE_OBJ_MRI)));
//                    Annotation annotation = new Annotation(ERROR_TYPE, false,
//                            marker.getAttribute(IMarker.MESSAGE, ""));
//                    if (element instanceof DocumentNode) {
//                        DocumentNode source = (DocumentNode) element;
//                        if (TbUtil.isAncestorOf(
//                                ((CtsDocument) getDocumentProvider()
//                                        .getDocument(getEditorInput()))
//                                        .getRootBlock(), source)) {
//                            Position position = null;
//                            if (source instanceof TextBlock) {
//                                position = new Position(
//                                        TbUtil.getAbsoluteOffsetWithoutBlanks((TextBlock) source),
//                                        source.getLength());
//                            } else {
//                                position = new Position(
//                                        TbUtil.getAbsoluteOffset(source),
//                                        source.getLength());
//                            }
//                            getDocumentProvider().getAnnotationModel(
//                                    getEditorInput()).addAnnotation(annotation,
//                                    position);
//                            markerAnnotations.add(annotation);
//                        }
//                    } else if (element != null) {
//                        DocumentNodeReferencesCorrespondingModelElement assoc = getResourceSet()
//                                .getPackage(
//                                        TextblocksPackage.PACKAGE_DESCRIPTOR)
//                                .getDocumentNodeReferencesCorrespondingModelElement();
//                        Collection<DocumentNode> nodes = assoc
//                                .getDocumentNode(element);
//                        for (DocumentNode documentNode : nodes) {
//                            if (documentNode instanceof TextBlock) {
//                                if (TbUtil.isAncestorOf(
//                                        ((CtsDocument) getDocumentProvider()
//                                                .getDocument(getEditorInput()))
//                                                .getRootBlock(), documentNode)) {
//                                    getDocumentProvider()
//                                            .getAnnotationModel(
//                                                    getEditorInput())
//                                            .addAnnotation(
//                                                    annotation,
//                                                    new Position(
//                                                            TbUtil.getAbsoluteOffsetWithoutBlanks((TextBlock) documentNode),
//                                                            documentNode
//                                                                    .getLength()));
//                                    markerAnnotations.add(annotation);
//                                }
//                            }
//                        }
//                    }
//                } catch (InvalidResourceIdentifierException e) {
//                    // Ignore, marker seems to be out of date
//                } catch (CoreException e) {
//                    // Ignore, marker seems to be out of date
//                }
//            }
//
//        }
//    }

    void refreshModelAnnotations(Resource rootPartition) {
        if (!annotatedPartitionsToUpdate.contains(rootPartition)) {
//            AnnotationUpdater updater = new AnnotationUpdater(rootPartition);
//            Display.getDefault().asyncExec(updater);
        }
    }

    private PartitionHighlighter getPartitionHighlighter() {
        if (partitionHighlighter == null) {
            partitionHighlighter = createHighlighter();
        }
        return partitionHighlighter;
    }

    private boolean runningOutlineUpdate = false;
    private ResourceSet resourceSet;
    private final OppositeEndFinder oppositeEndFinder;
    private ObservableInjectingParser dryParser;

    private void updateOutlineSave() {
        try {
            if (outlinePage != null && !runningOutlineUpdate) {
                runningOutlineUpdate = true;
                Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        runningOutlineUpdate = false;
                        outlinePage.setInput(getModel());
                    }
                });
            }
        } catch (Exception ex) {
            // log the error but we do not want the saving process or whatever
            // caused the
            // updatge to be disturbed by an error here.
            CtsActivator.logError(ex);
        }
    }

    // private void showInputWarning(ParsingError ex) {
    // fAnnotationModel.addAnnotation(new Annotation(WARNING_TYPE, false, ex
    // .getMessage()), new Position(0, textViewer.getDocument()
    // .getLength()));
    // }

    public TextBlock parse(TextBlock previousBlock)
            throws SemanticParserException {
        return parse(previousBlock, false);
    }

    public TextBlock parse(TextBlock root, boolean errorMode)
            throws SemanticParserException {
        boolean syntacticallyCorrect = true;
        // ensure to work on previous version
        TextBlock previousBlock = TbVersionUtil.getOtherVersion(root,
                Version.PREVIOUS);
        if (previousBlock == null) {
            previousBlock = root;
        }
        TextBlock newBlock = previousBlock;

        try {
            dryParse(previousBlock);
        } catch (SemanticParserException e) {
            syntacticallyCorrect = false;
            throw e;
        }

        if (syntacticallyCorrect) {
            // reset errors in modelinjector
            parser.getInjector().getErrorList().clear();
            getLexer().setSource(previousBlock.getTokens().get(0));
            syntacticallyCorrect = getLexer().lex(previousBlock);

            // set the start token to the lexer
            TextBlock newlyLexedTextBlock = TbVersionUtil.getOtherVersion(
                    previousBlock, Version.CURRENT);
            if (newlyLexedTextBlock != null) {
                getLexer().setCurrentTokenForParser(
                        newlyLexedTextBlock.getTokens().get(0));
                textBlocksHandler.setRootBlock(newlyLexedTextBlock);

                if (syntacticallyCorrect) {

                    newBlock = incrementalParser.incrementalParse(
                            newlyLexedTextBlock, errorMode);
                    removeOutdatedParseErrorMarkers(incrementalParser
                            .getChangedBlocks());

                    // TODO this is only for debugging
                    if (highlightTBCanges) {
                        highlightChangedBlocks(incrementalParser
                                .getChangedBlocks());
                    }

//                    // assign newly created block to partition
//                    if(!tbPartition.equals(newBlock.eResource())){
//                        tbPartition.getContents().add(newBlock);
//                    }

                    EObject result = null;
                    if (newBlock.getCorrespondingModelElements().size() > 0) {
                        result = newBlock.getCorrespondingModelElements()
                                .iterator().next();
                    }

                    if (result == null) {
                        throw new SemanticParserException(
                                incrementalParser.getErrorList(),
                                previousBlock, result);
                    }

                    ArrayList<ParsingError> errorList = new ArrayList<ParsingError>();
                    errorList.addAll(incrementalParser.getErrorList());

                    if (errorList.size() == 0) {
//                        if (getEditorInput() instanceof ModelEditorInput) {
//                            ((ModelEditorInput) getEditorInput())
//                                    .getRefObject();
//                        }
                    }
                    if (errorList.size() > 0) {
                        throw new SemanticParserException(errorList, newBlock,
                                result);
                    }

                } else {
                    throw new SemanticParserException(
                            incrementalParser.getErrorList(), previousBlock,
                            null);
                }
            }
        } else {
            throw new SemanticParserException(incrementalParser.getErrorList(),
                    previousBlock, null);
        }
        return newBlock;

    }

    private void removeOutdatedParseErrorMarkers(
            Collection<TextBlock> changedBlocks) {
        //FIXME
//        for (IMarker marker : new ArrayList<IMarker>(parseErrorMarkers)) {
//            DocumentNode element;
//            try {
//                element = (DocumentNode) getResourceSet()
//                        .getElement(
//                                getResourceSet()
//                                        .getSession()
//                                        .getMoin()
//                                        .createMri(
//                                                (String) marker
//                                                        .getAttribute(MarkerManager.ATTRIBUTE_OBJ_MRI)));
//                for (TextBlock textBlock : changedBlocks) {
//                    if (TbUtil.isAncestorOf(textBlock, element)) {
//                        // element was newly parsed so delete old marker
//                        ModelManager.getMarkerManager().deleteMarker(marker);
//                        parseErrorMarkers.remove(marker);
//                    }
//                }
//            } catch (InvalidResourceIdentifierException ex) {
//                // element invalid so remove marker
//                ModelManager.getMarkerManager().deleteMarker(marker);
//                parseErrorMarkers.remove(marker);
//            } catch (CoreException e) {
//                // marker not found, so remove
//                parseErrorMarkers.remove(marker);
//            }
//        }
    }

    private void highlightChangedBlocks(Collection<TextBlock> changedBlocks) {
        removeAllAnnotations(getSourceViewerPublic().getAnnotationModel(),
                tbHighlightAnnotations);
        for (TextBlock textBlock : changedBlocks) {
            //FIXME
//            Annotation highlightAnnotation = new Annotation(
//                    HighlightTextBlockAction.TB_HIGHLIGHT_ANNOTATION, false,
//                    null);
//            tbHighlightAnnotations.add(highlightAnnotation);
//
//            getSourceViewerPublic().getAnnotationModel().addAnnotation(
//                    highlightAnnotation,
//                    new Position(TbUtil.getAbsoluteOffset(textBlock), textBlock
//                            .getLength()));

        }
    }

    private void removeAllAnnotations(IAnnotationModel annotationModel,
            List<Annotation> tbHighlightAnnotations2) {
        for (Annotation annotation : tbHighlightAnnotations2) {
            annotationModel.removeAnnotation(annotation);
        }
    }

    // /**
    // * Execute a parse run with a dummy ModelInjector that actually does
    // * not create any model element. This may be useful if you only want to
    // * do a syntax check without creating model elements at all.
    // *
    // * @throws RecognitionException, {@link SemanticParserException}
    // */
    // protected abstract TextBlock dryParse(String text) throws
    // RecognitionException,
    // SemanticParserException;

    private ObservableInjectingParser createDryParser(TextBlock rootBlock,
            ResourceSet connection) {
//        if(dryParser == null) {
            Lexer lexer = getParserFactory().createLexer(
                    new ANTLRStringStream(rootBlock.getCachedString()));
            dryParser = getParserFactory().createParser(new CommonTokenStream(lexer),
                connection);
//        }
//        dryParser.reset();
        return dryParser;
    }

    /**
     * Execute a parse run with a dummy ModelInjector that actually does not
     * create any model element. This may be useful if you only want to do a
     * syntax check without creating model elements at all.
     * 
     * @throws RecognitionException
     *             , {@link SemanticParserException}
     */
    public void dryParse(TextBlock rootBlock) throws SemanticParserException {
        ResourceSet connection = getEditingDomain().getResourceSet();
        ObservableInjectingParser p = createDryParser(rootBlock, connection);
        removeOutdatedParseErrorMarkers(Collections.singleton(rootBlock));

        List<ParsingError> errorList = p.checkSyntaxWithoutInjecting();

        if (errorList != null && errorList.size() > 0) {
            throw new SemanticParserException(errorList, rootBlock, null);
        }

    }

    private void showInputInvalidInfo(Exception e) {
        Annotation annotation = new Annotation(ERROR_TYPE, false,
                e.getMessage() == null ? e.getClass().getName()
                        : e.getMessage());
        getDocumentProvider().getAnnotationModel(getEditorInput())
                .addAnnotation(annotation, guessPosition(e));
        /*
         * this .setStatusLineErrorMessageInUIThread(
         * "Entered expression is invalid. Cause given: " + e.getClass() + " : "
         * + e.getMessage());
         */
    }

    /**
     * @param e
     */
    private void showInputInvalidInfo(ParsingError e) {
        getDocumentProvider().getAnnotationModel(getEditorInput())
                .addAnnotation(
                        new Annotation(ERROR_TYPE, false,
                                e.getMessage() == null ? e.getClass().getName()
                                        : e.getMessage()), guessPosition(e));
        setStatusLineErrorMessageInUIThread("Entered expression is invalid. Cause given: "
                + e.getMessage());
        AbstractToken tok = ((CtsDocument) getDocumentProvider().getDocument(
                getEditorInput())).getTextBlocksModelStore().getFloorToken(
                e.getIndex());
        int length = e.getStopIndex() - e.getIndex();
        length = length < 0 ? 1 : length;
        if (tok != null) {
            if (length > tok.getLength()) {
                // TODO add adjecent tokens and find common ancestor for marker
                // creation
            }
            //FIXME 
//            IMarker marker = ModelManager.getMarkerManager().createMarker(tok,
//                    IMarker.PROBLEM, IMarker.SEVERITY_ERROR, e.getMessage());
//            parseErrorMarkers.add(marker);
        }
    }

    /**
     * @param e
     * @return
     */
    private Position guessPosition(Object e) {
        if (e instanceof ParsingError) {
            ParsingError recException = (ParsingError) e;
            int offset = recException.getIndex();
            int length = recException.getStopIndex() - recException.getIndex();
            length = length < 0 ? 1 : length;
            return new Position(offset, length);
        }
        return new Position(0, getSourceViewerPublic().getDocument()
                .getLength());
    }

    public void setModel(Object model) {
        this.model = model;
    }

    /**
     * Currently contains the root textblock of the current document. For a
     * document that is parsed for the first time a new Textblock is created.
     * 
     * @return the current root textblock.
     */
    protected Object getModel() {
        if (model == null) {
            initializeModel();
        }
        return model;
    }

    /**
     * the root element of a new text document(i.e. the root textblock node) is
     * initialized here. Additionally attributes such as the definition of the
     * textblock need to be set here.
     */
    private void initializeModel() {
        // TextBlock tb = textblocksPackage.getTextBlock().createTextBlock();
        // TODO get definition depending on the actual grammar/metamodel
        // TextBlockDefinition definition = textblocksDefinitionPackage
        // .getTextBlockDefinition().createTextBlockDefinition();
        // Production production = grammarPackage.getProduction()
        // .createProduction();
        // // set the name of the root parse rule from the grammar.
        // production.setName("prog");
        // definition.setParseRule(production);
        // tb.setType(definition);
    }

    protected Class<? extends ObservableInjectingParser> getParserClass() {
        return getParserFactory().getParserClass();
    }

    protected void initializeNewParser() {
        //add mapping resource to resource set
        getEditingDomain().loadResource(getParserFactory().getSyntaxUri().toString());
        
        TextBlockReuseStrategyImpl reuseStrategy = new TextBlockReuseStrategyImpl(
                createLexer(), null);
        setLexer(new ANTLRIncrementalLexerAdapter(new ANTLRLexerAdapter(
                createLexer(), reuseStrategy), null, getEditingDomain()));
        ObservableInjectingParser parser;

        parser = getParserFactory().createParser(
                getParserFactory().createIncrementalTokenStream(getLexer()),
                getEditingDomain().getResourceSet(), getAdditionalLookupURIS(),
                getAdditionalLookupURIS());
        getLexer().setModelInjector(parser.getInjector());
        reuseStrategy.setModelElementInvestigator(((ModelInjector) parser
                .getInjector()).getModelAdapter());
        setParser(parser);
        PartitionAssignmentHandler partitionHandler = ((CtsDocument) getDocumentProvider().getDocument(getEditorInput())).getPartitionHandler();
        incrementalParser = new MappingLinkRecoveringIncrementalParser(
                getEditingDomain(), getParserFactory(), getLexer(), getParser(),
                reuseStrategy, getAdditionalLookupURIS(), oppositeEndFinder,
                partitionHandler);
        shortPrettyPrinter = new ShortPrettyPrinter(new EMFModelAdapter(
                parserFactory.getMetamodelPackage(getEditingDomain().getResourceSet()),
                getEditingDomain().getResourceSet(), getAdditionalLookupURIS()));
    }

    /**
     * This method should be overridden if additional URIs should be added to
     * the lookup scope of the parser.
     * 
     * @return
     */
    protected Set<URI> getAdditionalLookupURIS() {
        return Collections.EMPTY_SET;
    }

    private Lexer createLexer() {
        return getParserFactory().createLexer(null);
    }

    /**
     * Should be overridden by subclass to return an instance or subclass of
     * {@link AbstractGrammarBasedViewerConfiguration}.
     * 
     * @param annotationModel
     * @return
     */
    protected AbstractGrammarBasedViewerConfiguration createSourceViewerConfig(
            IAnnotationModel annotationModel) {
        AbstractGrammarBasedViewerConfiguration svc = new AbstractGrammarBasedViewerConfiguration(
                getEditingDomain().getResourceSet(), annotationModel, getLexerClass(),
                getParserClass(), getTokenMapper(), getLanguageId(), this);
        return svc;
    }

    private void setParserFactory(
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        this.parserFactory = parserFactory;
    }

    public ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> getParserFactory() {
        return parserFactory;
    }

    public MappingLinkRecoveringIncrementalParser getIncrementalParser() {
        return incrementalParser;
    }
}
