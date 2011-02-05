package com.sap.furcas.ide.editor.document;

import java.io.ByteArrayOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultLineTracker;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.action.PrettyPrintAction;
import com.sap.furcas.ide.editor.dialogs.PrettyPrintPreviewDialog;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor.ParserCollection;
import com.sap.furcas.ide.editor.recovery.TbRecoverUtil;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.unparser.extraction.TCSExtractorPrintStream;
import com.sap.furcas.unparser.textblocks.IncrementalTextBlockPrettyPrinter;
import com.sap.ide.cts.parser.incremental.DefaultPartitionAssignmentHandlerImpl;
import com.sap.ide.cts.parser.incremental.PartitionAssignmentHandler;
import com.sap.ide.cts.parser.incremental.TextBlockMappingBrokenException;

/**
 * A document implementation that is responsible for presenting a text blocks
 * model as an eclipse document to work on.
 *
 * @author C5106462
 *
 */
public class CtsDocument extends AbstractDocument {

    private static final String DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED = "Document was not completely initialized. Call completeInit() to finish the initialization";
    private boolean completelyItitialized = false;

    private EObject rootObject;
    private TextBlock rootBlock;
    
    private ConcreteSyntax syntax;
    private final EditingDomain editingDomain;
    private final PartitionAssignmentHandler partitionHandler;
    
    /**
     * Creates a new empty document.
     */
    public CtsDocument(ModelEditorInput modelEditorInput, EditingDomain editingDomain) {
	super();
        this.partitionHandler = new DefaultPartitionAssignmentHandlerImpl();
	Resource defaultResource = modelEditorInput.getEObject().eResource();
	this.partitionHandler.setDefaultPartition(defaultResource);
        this.editingDomain = editingDomain;
        
	completeInitialization();
    }

    /**
     * The document will be usable and completely initialized after this method was called.
     */
    public void completeInit(ConcreteSyntax concreteSyntax, ParserCollection parserCollection) {
	syntax = concreteSyntax;
        ClassTemplate rootTemplate = TcsUtil.getMainClassTemplate(syntax);

	//TODO this needs to be done on a specifically designated sub element
	EObject inputObject = partitionHandler.getDefaultPartition().getContents().iterator().next();
	if (inputObject instanceof TextBlock) {
	    if (TbUtil.isTextBlockOfType(rootTemplate, (TextBlock) inputObject)) {
		rootBlock = (TextBlock) inputObject;
		if (rootBlock.getCorrespondingModelElements().size() > 0) {
		    rootObject = rootBlock.getCorrespondingModelElements().iterator().next();
		}
	    }
	} else {
	    rootObject = inputObject;
	    rootBlock = determineRootBlockForRootObject(concreteSyntax, rootTemplate, inputObject, parserCollection);
	}

	if (rootBlock == null) {
	    MessageDialog.openError(CtsActivator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),
		    "Initialization Failed", "Failed to initialize document. Consult the error log for further information!");
	    return;
	}
	
        TbRecoverUtil.checkAndMigrateTokenIds(rootBlock, parserCollection.parser, parserCollection.lexer, parserCollection.shortPrettyPrinter, /*fail silently*/ false);

	TextBlocksModelStore textBlocksModelStore = new TextBlocksModelStore(editingDomain, rootBlock, parserCollection.parser.getInjector().getModelAdapter());
	setTextStore(textBlocksModelStore);
	setLineTracker(new DefaultLineTracker());

	completelyItitialized = true;

	//synchronize all tokens with values from model
	textBlocksModelStore.expandToEditableVersion();
	getTracker().set(rootBlock.getCachedString());

	//enable usage of cached string for get() operations as it is faster.
	((TextBlocksModelStore)getStore()).getModel().setUsecache(true);
    }


    /**
     * Get a corresponding root TextBlock for the given rootObject.
     * If no TextBlock does exist yet, a new one is created.
     */
    private TextBlock determineRootBlockForRootObject(ConcreteSyntax concreteSyntax, ClassTemplate rootTemplate,
	    EObject inputObject, ParserCollection parserCollection) {

	TextblocksPackage tbPackage = TextblocksPackage.eINSTANCE;
	TextBlock rootBlock = null;
	try {
	  //note: ensure that if exists the textblock partition belonging to the model partition is loaded
            //into the resource set
	    rootBlock = TbModelInitializationUtil.getRootBlockForRootObject(inputObject, parserCollection.oppositeEndFinder, rootTemplate);
	} catch (TextBlockMappingBrokenException e) {
	    TextBlock blockInError = e.getBlock();
	    rootBlock = recoverBrokenTextBlockMapping(inputObject, blockInError, rootTemplate, parserCollection);
	}

	if (rootBlock == null) {
	    // no root node found, so create a new one
	    rootBlock = TbModelInitializationUtil.initilizeTextBlocksFromModel(inputObject, tbPackage, concreteSyntax, editingDomain, parserCollection.parserFactory);
	    partitionHandler.assignToDefaultTextBlocksPartition(rootBlock);
	}
	return rootBlock;
    }
    

    private static TextBlock recoverBrokenTextBlockMapping(EObject rootObject, TextBlock blockInError, ClassTemplate rootTemplate, ParserCollection parserCollection) {
        assert blockInError.getType() == null : "Mapping which is supposed to be broken is still valid.";
        TextBlock rootBlock = null;

        // might be a valid textblock but with a broken reference to the
        // mapping
        boolean recoverLink = MessageDialog.openQuestion(CtsActivator.getDefault().getWorkbench().getActiveWorkbenchWindow()
                .getShell(), "Mapping Link Broken", "The link from the current document to the mapping definition is broken."
                + "Would you like to try to recover this connection?\n"
                + "Otherwise this will cause all elements in defined in the"
                + "document to be re-created upon changes to the document!");
        if (recoverLink) {
            if (!TbRecoverUtil.recoverTextBlockFromBrokenMapping(blockInError, rootTemplate, parserCollection.incrementalParser, parserCollection.parser, parserCollection.lexer, parserCollection.shortPrettyPrinter)) {
                String title = "Mapping Link Recovery Failed";
                String error = "The link from the current document to the mapping definition is broken." + "Recovery failed!\n"
                        + "This will cause all elements in defined in the"
                        + "document to be re-created upon changes to the document!";
                String oldClass = blockInError.getCachedString();
                String newClass = "";
                try {
                    IncrementalTextBlockPrettyPrinter pp = new IncrementalTextBlockPrettyPrinter(/*readOnly*/true);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    TCSExtractorPrintStream target = new TCSExtractorPrintStream(stream);
                    pp.prettyPrint(rootObject, blockInError, rootTemplate.getConcreteSyntax(), rootTemplate, target);
                    newClass = stream.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    newClass = "Error occurred while pretty printing: " + e.getMessage();
                }
                PrettyPrintPreviewDialog dialog = new PrettyPrintPreviewDialog(title, error, oldClass, newClass);
                boolean startPrettyPrinter = dialog.open();
                if (startPrettyPrinter) {
                    PrettyPrintAction action = new PrettyPrintAction(rootObject.eClass(), rootObject, false);
                    action.runWithEvent(null);
                    rootBlock = action.getRootBlock();
                } else {
                    rootBlock = blockInError;
                }
            } else {
                rootBlock = blockInError;
            }
        } else {
            // just do nothing then
            rootBlock = blockInError;
        }
        return rootBlock;
    }

    @Override
    public synchronized void replace(int pos, int length, String text) throws BadLocationException {
	if (!completelyItitialized) {
	    throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
	}
	// TODO remove synchronization once a better solution has been found
	super.replace(pos, length, text);
    }

    @Override
    public synchronized String get(int pos, int length) throws BadLocationException {
	if (!completelyItitialized) {
	    throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
	}
	// TODO remove synchronization once a better solution has been found
	return super.get(pos, length);
    }

    public EObject getRootObject() {
	if (!completelyItitialized) {
	    throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
	}
	return rootObject;
    }

    public void setRootObject(EObject rootObject) {
	if (!completelyItitialized) {
	    throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
	}
	this.rootObject = rootObject;
    }

    public TextBlock getRootBlock() {
	if (!completelyItitialized) {
	    throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
	}
	return rootBlock;
    }

    public void setRootBlock(TextBlock rootBlock) {
	if (!completelyItitialized) {
	    throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
	}
	this.rootBlock = rootBlock;
	((TextBlocksModelStore) getStore()).setRootTextBlock(rootBlock);
    }

    public TextBlocksModelStore getTextBlocksModelStore() {
	if (!completelyItitialized) {
	    throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
	}
	return (TextBlocksModelStore) getStore();
    }

    /**
     * If {@link #completeInitialization()} was not called after the document
     * was created the method will return <code>false</code>.
     *
     * @return <code>true</code> if the Document was already completely
     *         initialized, <code>false</code> else.
     */
    public boolean isCompletelyItitialized() {
	return completelyItitialized;
    }

    public ConcreteSyntax getSyntax() {
	return syntax;
    }

    public void reduceToMinimalState() {
	((TextBlocksModelStore) getStore()).reduceToMinimalState();
    }

    public PartitionAssignmentHandler getPartitionHandler() {
        return partitionHandler;
    }

}
