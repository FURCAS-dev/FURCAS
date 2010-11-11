package com.sap.ide.cts.editor.document;

import org.antlr.runtime.Lexer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.ide.cts.editor.junitcreate.DocumentHistory;
import com.sap.ide.cts.editor.recovery.ModelEditorInputRecoveryStrategy;
import com.sap.ide.cts.parser.incremental.ParserFactory;

/**
 * CtsDocument enabled to snapshot model versions on save and to log any changes
 * to the document.
 * 
 * @see com.sap.ide.cts.editor.document.CtsHistoryDocumentProvider
 * @see com.sap.ide.cts.editor.junitcreate
 * 
 * @author D049157
 */
public class CtsHistoryDocument extends CtsDocument {

    private DocumentHistory history;

    public CtsHistoryDocument(ModelEditorInput modelEditorInput) {
	super(modelEditorInput);
    }

    @Override
    public void completeInit(ConcreteSyntax concreteSyntax, ClassTemplate rootTemplate,
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory,
	    ModelEditorInputRecoveryStrategy recoveryStrategy, ObservableInjectingParser parser, IProgressMonitor monitor) {
	super.completeInit(concreteSyntax, rootTemplate, parserFactory, recoveryStrategy, parser, monitor);

	IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(this.modelEditorInput.getProjectName());
	DocumentHistory history = new DocumentHistory(this, project);
	setAndActivateDocumentHistory(history, monitor);
    }

    public DocumentHistory getDocumentHistory() {
	return history;
    }

    public boolean hasActiveDocumentHistory() {
	return history != null && history.isActive();
    }

    private void setAndActivateDocumentHistory(DocumentHistory history, IProgressMonitor monitor) {
	if (this.history != null) {
	    removeDocumentListener(this.history);
	}
	if (history != null) {
	    history.createNewSnapshot(monitor);
	    addDocumentListener(history);
	    this.history = history;
	}
    }

    /**
     * This is <b>ONLY</b> for <b>TESTING</b> and not supposed to be used in productive code
     * 
     * @param history
     */
    public void setAndActivateDocumentHistoryForTesting(DocumentHistory history) {
	setAndActivateDocumentHistory(history, new NullProgressMonitor());
    }

}