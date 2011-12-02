package com.sap.furcas.ide.editor.document;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.text.AbstractDocument;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultLineTracker;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.GapTextStore;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ISynchronizable;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.imp.FurcasParseController;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel.TokenChange;
import com.sap.furcas.runtime.textblocks.modifcation.TbVersionUtil;
import com.sap.furcas.runtime.textblocks.shortprettyprint.ShortPrettyPrinter;

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
    
    private final TextBlocksModel model;
    
    /**
     * True when changes are self-triggered and do not correspond to user actions
     * which have to be forwarded to the TextBlocks model.
     */
    private boolean inDocumentRefreshMode = false; 
    private final Collection<DocumentEvent> bufferedChanges = new ArrayList<DocumentEvent>();

    
    public CtsDocument(ModelEditorInput editorInput) {
	super();
        
        setTextStore(new GapTextStore());
        setLineTracker(new DefaultLineTracker());
        
        model = new TextBlocksModel(getReferenceOrWorkingCopy(editorInput));
        model.setUsecache(true); 
        
	completeInitialization();
	// set textual content
	set(model.get(0, model.getLength()));
	
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
    }

    private TextBlock getReferenceOrWorkingCopy(ModelEditorInput editorInput) {
        TextBlock tb = TbVersionUtil.getOtherVersion(editorInput.getRootBlock(), Version.PREVIOUS);
        return tb != null ? tb : editorInput.getRootBlock(); 
    }

    public TextBlock getRootBlock() {
        return model.getRoot();
    }

    /**
     * Sets the content of this document.
     */
    public void setRootBlock(TextBlock newRootBlock) {
        assert model.getActiveVersion() == newRootBlock.getVersion();
	model.setRootTextBlock(newRootBlock);
    }

    /**
     * Has to be called before starting to work on the
     * block returned by {@link #getRootBlock()}
     */
    public boolean flushUserEditsToTextBlocskModel() {
        Collection<DocumentEvent> events = new ArrayList<DocumentEvent>();
        synchronized (getLockObject()) {
            events.addAll(bufferedChanges);
            bufferedChanges.clear();
        }
        for (DocumentEvent event : events) {
            model.replace(event.getOffset(), event.getLength(), event.getText());
        }
        return events.size() > 0;
    }

    public void refreshContentFromTextBlocksModelChanges(final ShortPrettyPrinter shortPrettyPrinter) {
        synchronized (getLockObject()) {
            flushUserEditsToTextBlocskModel();
            final ArrayList<TokenChange> tokenChanges = model.doShortPrettyPrintToEditableVersion(shortPrettyPrinter);
            try {
                inDocumentRefreshMode = true;
                for (TokenChange change : tokenChanges) {
                    replace(change.oldOffset, change.oldLength, change.token.getValue());
                }
            } catch (BadLocationException e) {
                CtsActivator.logger.logError("Failed to refresh document", e);
            } finally {
                inDocumentRefreshMode = false;
            }
        }
    }
    
    public void resetAfterError() {
        synchronized (getLockObject()) {
            inDocumentRefreshMode = true;
            set(model.get(0, model.getLength()));
            bufferedChanges.clear();
            inDocumentRefreshMode = false;
        }        
    }
    
    /**
     * Returns a lock object for synchronization<p>
     * 
     * It is required that each information exchange from the
     * document content to the TextBlocksModel is synchronized, as the
     * first is modified from within the UI thread and the latter by the
     * {@link FurcasParseController} from within a background thread. 
     */
    @Override
    public Object getLockObject() {
        return lockObject == null ? internalLockObject : lockObject;
    }
    
    @Override
    public void setLockObject(Object lockObject) {
        this.lockObject = lockObject;
    }

}
