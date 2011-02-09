package com.sap.furcas.ide.editor.document;

import java.io.ByteArrayOutputStream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultLineTracker;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.ISynchronizable;
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
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.TCSExtractorPrintStream;
import com.sap.furcas.unparser.textblocks.IncrementalTextBlockPrettyPrinter;

/**
 * A document implementation that is responsible for presenting a text blocks
 * model as an eclipse document to work on.
 * 
 * This document is synchronized. Background reconcilers can use {@link #getLockObject()} in order
 * to synchronize them on the content of this document.
 *
 * @author C5106462
 *
 */
public class CtsDocument extends AbstractDocument implements ISynchronizable {

    private final Object internalLockObject = new Object();
    private Object lockObject;
    
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
                try {
                    rootBlock = TbModelInitializationUtil.initilizeTextBlocksFromModel(rootObject, syntax, editingDomain, parserCollection.parserFactory);
                } catch (SyntaxAndModelMismatchException e) {
                    throw new PartInitException("Failed to pretty print " + rootObject, e);
                }
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
        
    @Override
    public void setLockObject(Object lockObject) {
        this.lockObject = lockObject;
    }

    @Override
    public Object getLockObject() {
        return lockObject == null ? internalLockObject : lockObject;
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public void startSequentialRewrite(boolean normalized) {
        synchronized (getLockObject()) {
            super.startSequentialRewrite(normalized);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void stopSequentialRewrite() {
        synchronized (getLockObject()) {
            super.stopSequentialRewrite();
        }
    }
    
    @Override
    public DocumentRewriteSession startRewriteSession(DocumentRewriteSessionType sessionType) {
        synchronized (getLockObject()) {
            return super.startRewriteSession(sessionType);
        }
    }
    
    @Override
    public void stopRewriteSession(DocumentRewriteSession session) {
        synchronized (getLockObject()) {
            super.stopRewriteSession(session);
        }
    }

    @Override
    public String get() {
        synchronized (getLockObject()) {
            return super.get();
        }
    }

    @Override
    public String get(int offset, int length) throws BadLocationException {
        if (!completelyItitialized) {
            throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
        }
        synchronized (getLockObject()) {
            return super.get(offset, length);
        }
    }

    @Override
    public char getChar(int offset) throws BadLocationException {
        synchronized (getLockObject()) {
            return super.getChar(offset);
        }
    }

    @Override
    public long getModificationStamp() {
        synchronized (getLockObject()) {
            return super.getModificationStamp();
        }
    }

    @Override
    public void replace(int offset, int length, String text) throws BadLocationException {
        if (!completelyItitialized) {
            throw new RuntimeException(DOCUMENT_WAS_NOT_COMPLETELY_INITIALIZED);
        }
        synchronized (getLockObject()) {
            super.replace(offset, length, text);
        }
    }

    @Override
    public void replace(int offset, int length, String text, long modificationStamp) throws BadLocationException {
        synchronized (getLockObject()) {
            super.replace(offset, length, text, modificationStamp);
        }
    }

    @Override
    public void set(String text) {
        synchronized (getLockObject()) {
            super.set(text);
        }
    }

    @Override
    public void set(String text, long modificationStamp) {
        synchronized (getLockObject()) {
            super.set(text, modificationStamp);
        }
    }

}
