package com.sap.furcas.ide.editor.document;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.DefaultLineTracker;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.GapTextStore;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.commands.NullCommand;
import com.sap.furcas.ide.editor.dialogs.PrettyPrintPreviewDialog;
import com.sap.furcas.ide.editor.imp.parsing.FurcasParseController;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.tcs.MessageHelper;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.TbUtil;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.furcas.unparser.PrettyPrinter;
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.TCSExtractorPrintStream;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;
import com.sap.furcas.unparser.textblocks.IncrementalTextBlockPrettyPrinter;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;
import com.sap.ide.cts.parser.incremental.MappingRecoveringTextBlocksValidator;
import com.sap.ide.cts.parser.incremental.TextBlockMappingRecoveringFailedException;

/**
 * A document implementation that is responsible for presenting a text blocks
 * model as an eclipse document to work on.<p>
 * 
 * This document is synchronized. Background reconcilers can use {@link #getLockObject()} in order
 * to synchronize them on the content of this document. This is required as users typing within
 * the editor modify this document from within the UI thread.<p>
 * 
 * This documents implements a buffer for document changes, meaning that the underlying
 * TextBlocksModel is not instantly updated. Clients have to call {@link #flushUserEditsToTextBlocskModel()}
 * to apply the buffered changes to the underlying model. The reverse operation is 
 * {@link #refreshContentFromTextBlocksModel()}.
 *
 * @author C5106462
 * @author Stephan Erb
 *
 */
public class CtsDocument extends AbstractDocument implements ISynchronizable {
    
    private final Object internalLockObject = new Object();
    private Object lockObject;
    
    private boolean completelyItitialized = false;

    private EObject rootObject;
    private TextBlocksModel model;
    private TextBlock rootBlock;
    
    private final ConcreteSyntax syntax;
    private final EditingDomain editingDomain;

    /**
     * True when changes are self-triggered and do not correspond to user actions
     * which have to be forwarded to the TextBlocks model.
     */
    private boolean inDocumentRefreshMode = false; 
    private final Collection<DocumentEvent> bufferedChanges = new ArrayList<DocumentEvent>();

    
    /**
     * Creates a new empty document.
     */
    public CtsDocument(ModelEditorInput editorInput, ConcreteSyntax syntax, EditingDomain editingDomain) {
	super();
        this.editingDomain = editingDomain;
        this.syntax = syntax;
        this.rootObject = editorInput.getRootObject();
        this.rootBlock = editorInput.getRootBlock();
        
        setTextStore(new GapTextStore());
        setLineTracker(new DefaultLineTracker());
	completeInitialization();
    }

    /**
     * The document will be usable and completely initialized after this method was called.
     */
    public void completeInit(IncrementalParserFacade parserFacade) throws PartInitException {
        validateDomainModelCompliesToSyntax();
        validateAndMigrateTextBlocksModel(parserFacade);

        model = new TextBlocksModel(rootBlock, parserFacade.getModelElementInvestigator());
        expandToEditableVersion();
        refreshContentFromTextBlocksModel();
        model.setUsecache(true); 
        
        addDocumentListener(new IDocumentListener() {
            @Override
            public void documentChanged(DocumentEvent event) {
                synchronized (getLockObject()) {
                    if (!inDocumentRefreshMode) {
                        bufferedChanges.add(event);
                    }
                }
            }
            @Override
            public void documentAboutToBeChanged(DocumentEvent event) { }
        });
        completelyItitialized = true;
    }

    private void validateAndMigrateTextBlocksModel(IncrementalParserFacade parserFacade) throws PartInitException  {
        ClassTemplate rootTemplate = TcsUtil.getMainClassTemplate(syntax);
        MappingRecoveringTextBlocksValidator validator = new MappingRecoveringTextBlocksValidator(parserFacade);
        
        validator.checkAndMigrateTokenIds(rootBlock);
        
        if (validator.hasBrokenMapping(rootBlock)) {
            boolean success = recoverBrokenTextBlockMapping(validator, parserFacade);
            if (success && !TbUtil.isTextBlockOfType(rootTemplate, rootBlock)) {
                throw new PartInitException("Main template " + MessageHelper.getTemplateName(rootTemplate) +
                        " does not fit the given TextBlocks model.");
            }
        } else if (!TbUtil.isTextBlockOfType(rootTemplate, rootBlock)) {
            throw new PartInitException("Main template " + MessageHelper.getTemplateName(rootTemplate) +
                    " does not fit the given TextBlocks model which uses " + MessageHelper.getTemplateName(rootBlock.getType()));
        }
        
        TbValidationUtil.assertTextBlockConsistencyRecursive(rootBlock);
        TbValidationUtil.assertCacheIsUpToDate(rootBlock);
    }
    
    /**
     * Make sure the model element is still valid according
     * to this concrete syntax (e.g., matching property inits)
     */
    private void validateDomainModelCompliesToSyntax() throws PartInitException {
        PrettyPrinter prettyPrinter = new PrettyPrinter();
        TCSExtractorPrintStream target = new TCSExtractorPrintStream(new ByteArrayOutputStream());
        try {
            prettyPrinter.prettyPrint(rootObject, syntax, target);
            // we don't care about the result. Validation is always performed.
        } catch (SyntaxAndModelMismatchException e) {
            throw new PartInitException("Model does not (fully) conform to syntax " + syntax.getName() + ": \n\n" + e.getCause().getMessage(), e);
        }
    }
    
    /**
     * Inspect the {@link #rootBlock} and try to recover it. After the recovery it might turn out that
     * we have a block of the wrong type at hand. <p>
     * 
     * The {@link #rootBlock} is directly modified by this method.
     */
    private boolean recoverBrokenTextBlockMapping(MappingRecoveringTextBlocksValidator validator, IncrementalParserFacade parserFacade) throws PartInitException {
        try {
            validator.recoverMappingLink(rootBlock, TcsUtil.getMainClassTemplate(syntax));
            return true;
        } catch (TextBlockMappingRecoveringFailedException e) {
            
            String title = "Mapping Link Recovery Failed";
            String error = "The link from the current document to the mapping definition is broken." + "The recovery failed! \n "
            + e.getMessage() + "\n \n"
            + "You have two options: \n"
            + " a) Click OK and the model will be pretty printed. The old textual view will be replaced. \n"
            + " b) Click Cancel to keep the texutal view as it is. However, this will force the recreation of all model elements"
            + " defined in this view upon changes to this document.";
            
            String oldTextualView = rootBlock.getCachedString();
            String newTextualView = prettyPrintModelToString();
            PrettyPrintPreviewDialog previewDialog = new PrettyPrintPreviewDialog(title, error, oldTextualView, newTextualView);
            boolean prettyPrintAccepted = previewDialog.open();
            
            if (prettyPrintAccepted) {
                TextBlock newRootBlock = prettyPrintModelToTextBlock(parserFacade);
                TbChangeUtil.deleteOtherVersions(rootBlock);
                EcoreUtil.delete(rootBlock);
                rootBlock = newRootBlock;
                return true;
            } 
        }
        return false;
    }
    
    private String prettyPrintModelToString() throws PartInitException {
        IncrementalTextBlockPrettyPrinter prettyPrinter = new IncrementalTextBlockPrettyPrinter();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        TCSExtractorPrintStream target = new TCSExtractorPrintStream(stream);
        try {
            prettyPrinter.prettyPrint(rootObject, rootBlock, syntax, TcsUtil.getMainClassTemplate(syntax), target);
        } catch (SyntaxAndModelMismatchException e) {
            throw new PartInitException("Model does not (fully) conform to syntax " + syntax.getName() + ": \n\n" + e.getCause().getMessage(), e);
        }
        return stream.toString();
    }

    private TextBlock prettyPrintModelToTextBlock(IncrementalParserFacade parserFacade) throws PartInitException {
        IncrementalTextBlockPrettyPrinter prettyPrinter = new IncrementalTextBlockPrettyPrinter();
        TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(parserFacade.getParserFactory());
        try {
            prettyPrinter.prettyPrint(rootObject, rootBlock, syntax, TcsUtil.getMainClassTemplate(syntax), target);
        } catch (SyntaxAndModelMismatchException e) {
            throw new PartInitException("Model does not (fully) conform to syntax " + syntax.getName() + ": \n\n" + e.getCause().getMessage(), e);
        }        return target.getPrintedResultRootBlock();
    }

    public EObject getRootObject() {
	return rootObject;
    }

    public TextBlock getRootBlock() {
	return rootBlock;
    }

    /**
     * Updates {@link #getRootBlock()} and {@link #getRootObject()}. 
     */
    public void setModelContent(TextBlock newRootBlock) {
        assert model.getActiveVersion() == newRootBlock.getVersion();
        this.rootBlock = newRootBlock;
	for (EObject root : newRootBlock.getCorrespondingModelElements()) {
	    rootObject = root;
	    break;
	}
	model.setRootTextBlock(rootBlock);
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
        
    @Override
    public void setLockObject(Object lockObject) {
        this.lockObject = lockObject;
    }

    /**
     * Returns a lock object for synchronization<p>
     * 
     * It is required that each information exchange from the
     * document content to the TextBlocksModel is synchronized, as the
     * first is modified from within the UI thread and the later by the {@link FurcasParseController}
     * from within a background thread. 
     */
    @Override
    public Object getLockObject() {
        return lockObject == null ? internalLockObject : lockObject;
    }
    
    public void flushUserEditsToTextBlocskModel() {
        Collection<DocumentEvent> events = new ArrayList<DocumentEvent>();
        synchronized (getLockObject()) {
            events.addAll(bufferedChanges);
            bufferedChanges.clear();
        }
        for (DocumentEvent event : events) {
            model.replace(event.getOffset(), event.getLength(), event.getText());
        }
        // FIXME: Use commands everywhere so that we don't have to fake modifications.
        editingDomain.getCommandStack().execute(new NullCommand());
    }

    public void refreshContentFromTextBlocksModel() {
        final String text = model.get(0, model.getLength());
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                synchronized (getLockObject()) {
                    if (!bufferedChanges.isEmpty()) {
                        CtsActivator.logger.logWarning("Overwriting user edits when refreshing the " +
                        	"document content. User might get confused");
                        bufferedChanges.clear();
                    }
                    inDocumentRefreshMode = true;
                    set(text);
                    inDocumentRefreshMode = false;
                }
            }
        });
    }

    public void expandToEditableVersion() {
        model.doShortPrettyPrintToEditableVersion();
    }

}
