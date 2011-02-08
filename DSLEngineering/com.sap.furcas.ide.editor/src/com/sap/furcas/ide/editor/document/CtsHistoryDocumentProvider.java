package com.sap.furcas.ide.editor.document;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.text.IDocument;

import com.sap.furcas.ide.editor.FurcasDocumentSetupParticpant;
import com.sap.furcas.runtime.common.util.EcoreHelper;

/**
 * <p>DocumentProvider for {@link CtsHistoryDocument}.</p>
 * 
 * If the JUnitTestCaseCreate feature and therefore logging is disabled this
 * provider will behave exactly the same as {@link CtsDocumentProvider}.
 * 
 * @author D049157
 */
public class CtsHistoryDocumentProvider extends CtsDocumentProvider {

    public CtsHistoryDocumentProvider(FurcasDocumentSetupParticpant documentSetupParticipant, EditingDomain editingDomain) {
	super(documentSetupParticipant, editingDomain);
    }

    @Override
    protected CtsDocument createDocumentFactoryMethod(Object element) {
	CtsDocument document = new CtsHistoryDocument(((ModelEditorInput) element), editingDomain);
	return document;
    }

    @Override
    public void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite)
	    throws CoreException {

	super.doSaveDocument(monitor, element, document, overwrite);

	if (document instanceof CtsHistoryDocument) {
	    CtsHistoryDocument ctsDocument = (CtsHistoryDocument) document;

	    if (!EcoreHelper.isAlive(ctsDocument.getRootObject())) {
		// the ModelEditor ElementDeleteListener might have detected
		// that the editor input was deleted because of a text cut/paste action.
		// It will therefore close the editor including its connection,
		// but a working connection is required in createSnapshot.
		// As the editor is going down anyway... no new snapshot is
		// required.
		return;
	    }

	    // Snapshot the just saved document version
	    try {
                monitor.beginTask("Creating Document Snapshot", 1000);
//                ctsDocument.getDocumentHistory().createNewSnapshot(monitor);
            }
            finally {
                monitor.done();
            }
	    
	}
    }
}
