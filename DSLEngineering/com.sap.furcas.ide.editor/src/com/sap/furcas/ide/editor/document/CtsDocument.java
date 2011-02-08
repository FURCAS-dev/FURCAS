package com.sap.furcas.ide.editor.document;

import java.io.ByteArrayOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultLineTracker;
import org.eclipse.ui.PartInitException;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.dialogs.PrettyPrintPreviewDialog;
import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor.ParserCollection;
import com.sap.furcas.ide.editor.recovery.TbRecoverUtil;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.tcs.MessageHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.validation.IllegalTextBlocksStateException;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.furcas.unparser.extraction.TCSExtractorPrintStream;
import com.sap.furcas.unparser.textblocks.IncrementalTextBlockPrettyPrinter;

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

    private final EObject rootObject;
    private TextBlock rootBlock;
    
    private final ConcreteSyntax syntax;
    private final EditingDomain editingDomain;
    
    /**
     * Creates a new empty document.
     */
    public CtsDocument(ModelEditorInput editorInput, ConcreteSyntax syntax, EditingDomain editingDomain) {
	super();
        this.editingDomain = editingDomain;
        this.syntax = syntax;
        this.rootObject = editorInput.getRootObject();
        this.rootBlock = editorInput.getRootBlock();
	completeInitialization();
    }

    /**
     * The document will be usable and completely initialized after this method was called.
     */
    public void completeInit(ParserCollection parserCollection) throws PartInitException {
        
        validateAndMigrateTextBlocksModel(parserCollection);

	TextBlocksModelStore textBlocksModelStore = new TextBlocksModelStore(editingDomain, rootBlock, parserCollection.parser.getInjector().getModelAdapter());
	setTextStore(textBlocksModelStore);
	setLineTracker(new DefaultLineTracker());

	completelyItitialized = true;

	// synchronize all tokens with values from model
	textBlocksModelStore.expandToEditableVersion();
	getTracker().set(rootBlock.getCachedString());

	// enable usage of cached string for get() operations as it is faster.
	((TextBlocksModelStore)getStore()).getModel().setUsecache(true);
    }

    private void validateAndMigrateTextBlocksModel(ParserCollection parserCollection) throws PartInitException {
        ClassTemplate rootTemplate = TcsUtil.getMainClassTemplate(syntax);
        if (rootBlock.getType() == null) {
            boolean success = recoverBrokenTextBlockMapping(parserCollection, rootTemplate);
            if (success && !TbUtil.isTextBlockOfType(rootTemplate, rootBlock)) {
                throw new PartInitException("Main template " + MessageHelper.getTemplateName(rootTemplate) + " does not fit the given TextBlocks model.");
            }
        } else if (!TbUtil.isTextBlockOfType(rootTemplate, rootBlock)) {
            throw new PartInitException("Main template " + MessageHelper.getTemplateName(rootTemplate) + " does not fit the given TextBlocks model which uses " + MessageHelper.getTemplateName(rootBlock.getType().getParseRule()));
        }
        
        TbRecoverUtil.checkAndMigrateTokenIds(rootBlock, parserCollection.parser, parserCollection.lexer,
                parserCollection.shortPrettyPrinter, /*fail silently*/false);
        
        try {
            TbValidationUtil.assertTextBlockConsistencyRecursive(rootBlock);
            TbValidationUtil.assertCacheIsUpToDate(rootBlock);
        } catch (IllegalTextBlocksStateException e) {
            throw new PartInitException("TextBlock model is invalid", e);
        }
    }
    
    
    /**
     * FIXME: Is that what we want?
     */
    private boolean recoverBrokenTextBlockMapping(ParserCollection parserCollection, ClassTemplate rootTemplate) throws PartInitException {
        // might be a valid textblock but with a broken reference to the mapping
        // but might also be a TextBlock of the wrong type...
        if (TbRecoverUtil.recoverTextBlockFromBrokenMapping(rootBlock, rootTemplate, parserCollection.incrementalParser, parserCollection.parser, parserCollection.lexer, parserCollection.shortPrettyPrinter)) {
            return true; // now recovered!
        } else {    
            String title = "Mapping Link Recovery Failed";
            String error = "The link from the current document to the mapping definition is broken." + "The recovery failed!\n"
            + "You have two options: \n" +
            " a) Click OK and the model will be pretty printed. The old textual view will be replaced. \n" +
            " b) Click Cancel to keep the texutal view but to force the recreation of all model elements defined in this view  upon changes to this document.";
            String oldTextualView = rootBlock.getCachedString();
            String newTextualView = prettyPrintToString(rootTemplate);
            PrettyPrintPreviewDialog dialog = new PrettyPrintPreviewDialog(title, error, oldTextualView, newTextualView);
            boolean prettyPrintAccepted = dialog.open();

            if (prettyPrintAccepted) {
                rootBlock = TbModelInitializationUtil.initilizeTextBlocksFromModel(rootObject, syntax, editingDomain, parserCollection.parserFactory);
            } else {
                // unaltered
            }
            return false;
        } 
    }

    private String prettyPrintToString(ClassTemplate rootTemplate) {
        String newTextualView = "";
        try {
            IncrementalTextBlockPrettyPrinter pp = new IncrementalTextBlockPrettyPrinter(/*readOnly*/true);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            TCSExtractorPrintStream target = new TCSExtractorPrintStream(stream);
            pp.prettyPrint(rootObject, rootBlock, rootTemplate.getConcreteSyntax(), rootTemplate, target);
            newTextualView = stream.toString();
        } catch (Exception e) {
            CtsActivator.logError(e);
            newTextualView = "Error occurred while pretty printing: " + e.getMessage();
        }
        return newTextualView;
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

    public TextBlock getRootBlock() {
	if (!completelyItitialized) {
	    throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
	}
	return rootBlock;
    }

    /*package*/ void setRootBlock(TextBlock rootBlock) {
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

    /*package*/ void reduceToMinimalState() {
        if (!completelyItitialized) {
            throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
        }
	((TextBlocksModelStore) getStore()).reduceToMinimalState();
    }

}
