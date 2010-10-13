package com.sap.ide.cts.editor.action;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;

import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.DialogsImages;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.document.CtsHistoryDocument;
import com.sap.ide.cts.editor.junitcreate.CreateTestCaseDialog;
import com.sap.ide.cts.editor.junitcreate.DocumentHistory;
import com.sap.ide.cts.editor.junitcreate.JavaTestCaseBuilder;
import com.sap.ide.cts.editor.junitcreate.NoSuchSnapshotException;
import com.sap.ide.cts.editor.junitcreate.SnapshotVersion;

public class CreateTestCaseAction extends Action {

    private CtsDocument document;
    private final Clipboard clipboard;

    public CreateTestCaseAction() {
	super();
	setText("Create TestCase");
	setToolTipText("Create TestCase based on the current editor input and editing history.");
	setImageDescriptor(DialogsImages.imageRegistry.getDescriptor(DialogsImages.CREATE_TEST));

	clipboard = new Clipboard(CtsActivator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay());
    }

    @Override
    public void run() {
	assert document instanceof CtsHistoryDocument : "Document not a CtsHistoryDocument";

	CreateTestCaseDialog diag = CreateTestCaseDialog.createDialog();
	int result = diag.open();
	if (result == Window.OK) {
	    String description = diag.getDescription();
	    String testCaseName = diag.getName();
	    SnapshotVersion version = diag.getVersion();

	    CtsHistoryDocument histDocument = (CtsHistoryDocument) document;
	    DocumentHistory history = histDocument.getDocumentHistory();
	    
	    URI srcLri = document.getRootObject().get___Mri().getLri();

	    Collection<DocumentEvent> events = history.getHistory(version);
	    String testCase = null; 
	    
	    try {
		URI documentRootMRI = history.persistSnapshot(testCaseName, version);
		if (documentRootMRI != null) {
		    URI copyLRI = documentRootMRI.getLri();
		    testCase = JavaTestCaseBuilder.buildTestCase(srcLri, copyLRI, events, testCaseName, description);
		} else {
		    MessageDialog.openWarning(CtsActivator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),
			    "Cannot create testcase", "Could not persist snapshot. Please consult the error log.");
		}

	    } catch (PartitionCreatingNotPossibleException e) {
		String msg = e.getMessage();
		IStatus status = new Status(IStatus.ERROR, CtsActivator.PLUGIN_ID, IStatus.OK, msg, e);
		ErrorDialog.openError(CtsActivator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),
			"Cannot create partition", "Could not create partition with your desired name.", status);
	    } catch (NoSuchSnapshotException e) {
		String msg = e.getMessage();
		msg += " You must save your editor in order to complete the current"
			+ " editing session and make it persistable." + " (A snapshot can only be peristed once.)";
		MessageDialog.openWarning(CtsActivator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),
			"Cannot create testcase", msg);
	    }
	    if (testCase == null) {
		// Always build a testcase operating on the original source (Not on the copy).
		// Works as a fallback if the copy cannot be persisted.
		testCase = "// Fallback: Test oparates on the ORIGINAL source \n" +
			JavaTestCaseBuilder.buildTestCase(srcLri, srcLri, events, testCaseName, description);
	    }
	    copyToClipboard(clipboard, testCase);
	    System.out.println(testCase);
	}
    }

    private void copyToClipboard(Clipboard clip, String text) {
	TextTransfer textTransfer = TextTransfer.getInstance();
	Transfer[] transfers = new Transfer[] { textTransfer };
	Object[] data = new Object[] { text };
	clip.setContents(data, transfers);
    }

    public void initializeWithDocument(CtsDocument document) {
	this.document = document;
    }

    @Override
    protected void finalize() throws Throwable {
	clipboard.dispose();
	super.finalize();
    }

}
