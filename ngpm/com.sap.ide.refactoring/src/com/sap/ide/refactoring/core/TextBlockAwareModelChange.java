package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.IRefactoringCoreStatusCodes;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextEditBasedChange;
import org.eclipse.ltk.core.refactoring.TextEditBasedChangeGroup;

import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.tc.moin.repository.commands.CommandHandle;

public class TextBlockAwareModelChange extends TextEditBasedChange {

    private final RefactoringEditorFacade facade;
    private final RefactoringStatus status;

    /**
     * The executed refactoring.
     */
    private final CommandHandle refactoringCommandHandle;

    /**
     * The newest command directly or inderictly triggered by the command
     * (e.g. reference re-evaluations)
     */
    private final CommandHandle dependentCommandHandle;



    public TextBlockAwareModelChange(RefactoringEditorFacade facade, RefactoringStatus status, CommandHandle refactoringCommandHandle, CommandHandle dependentCommandHandle) {
	super(refactoringCommandHandle.getDescription());

	this.facade = facade;
	this.status = status;
	this.refactoringCommandHandle = refactoringCommandHandle;
	this.dependentCommandHandle = dependentCommandHandle;
	refactoringCommandHandle = dependentCommandHandle;
    }


    @Override
    public Object getModifiedElement() {
	return facade.getDecoratedDomainRootObject();
    }


    @Override
    public void initializeValidationData(IProgressMonitor pm) {

    }

    @Override
    public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getConnection());
	if (helper.peekRedoStack().equals(refactoringCommandHandle)) {
	    return status;
	} else {
	    return RefactoringStatus.createFatalErrorStatus("Subsequent commands have been executed.  The Refactoring is no longer valid." +
	    	" It can no longer be applied.");
	}
    }

    /**
     * User has accepted the change and desires that the refactoring is applied to his workspace.
     */
    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
	pm.beginTask("Applying Refactoring: " + refactoringCommandHandle.getDescription(), 2);

	// Finally, re-apply the desired changes.
	CommandUndoRedoHelper helper = new CommandUndoRedoHelper(facade.getConnection());
	helper.redoRefactoring(dependentCommandHandle);
	pm.worked(1);

	facade.refreshUI();
	pm.done();
	return new NullChange();
    }


// ######## Provider change as a textual representation for the compare viewer  ########

    @Override
    public String getCurrentContent(IProgressMonitor pm) throws CoreException {
	return "getCurrentConten"; //command.getTextualPreExecutionRepresentation();
    }

    @Override
    public String getPreviewContent(IProgressMonitor pm) throws CoreException {
	if (isEnabled()) {
	    return "getPreviewContent"; //command.getTextualPostExecutionRepresentation();
	} else {
	    return "getPreviewContent"; //command.getTextualPreExecutionRepresentation();
	}
    }

    @Override
    public String getCurrentContent(IRegion region, boolean expandRegionToFullLine, int surroundingLines, IProgressMonitor pm)
	    throws CoreException {
	return clipToRegion(new Document(getCurrentContent(pm)), region, expandRegionToFullLine, surroundingLines);
    }

    @Override
    public String getPreviewContent(TextEditBasedChangeGroup[] changeGroups, IRegion region, boolean expandRegionToFullLine,
	    int surroundingLines, IProgressMonitor pm) throws CoreException {
	return clipToRegion(new Document(getPreviewContent(pm)), region, expandRegionToFullLine, surroundingLines);
    }

    protected String clipToRegion(IDocument document, IRegion region, boolean expandRegionToFullLine, int surroundingLines)
	    throws CoreException {
	try {
	    if (expandRegionToFullLine) {
		int startLine = Math.max(document.getLineOfOffset(region.getOffset()) - surroundingLines, 0);
		int endLine;
		if (region.getLength() == 0) {
		    // no lines are in the region, so remove one from the context,
		    // or else spurious changes show up that look like deletes from the source
		    if (surroundingLines == 0) {
			// empty: show nothing
			return ""; //$NON-NLS-1$
		    }

		    endLine = Math.min(document.getLineOfOffset(region.getOffset()) + surroundingLines - 1, document
			    .getNumberOfLines() - 1);
		} else {
		    endLine = Math.min(document.getLineOfOffset(region.getOffset() + region.getLength() - 1) + surroundingLines,
			    document.getNumberOfLines() - 1);
		}

		int offset = document.getLineInformation(startLine).getOffset();
		IRegion endLineRegion = document.getLineInformation(endLine);
		int length = endLineRegion.getOffset() + endLineRegion.getLength() - offset;
		return document.get(offset, length);

	    } else {
		return document.get(region.getOffset(), region.getLength());
	    }
	} catch (BadLocationException e) {
	    String message = e.getMessage();
	    if (message == null) {
		message = "BadLocationException"; //$NON-NLS-1$
	    }
	    throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IRefactoringCoreStatusCodes.BAD_LOCATION,
		    message, e));
	}
    }



}
