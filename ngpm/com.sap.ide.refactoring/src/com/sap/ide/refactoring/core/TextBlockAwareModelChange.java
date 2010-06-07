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

public class TextBlockAwareModelChange extends TextEditBasedChange {

    private final TextBlockAwareRefactoringCommand command;
    private final RefactoringEditorFacade facade;

    public TextBlockAwareModelChange(RefactoringEditorFacade facade, TextBlockAwareRefactoringCommand command) {
	super(command.getDescription());

	this.command = command;
	this.facade = facade;
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
	if (command.canExecute()) {
	    return new RefactoringStatus();
	} else {
	    return RefactoringStatus.createFatalErrorStatus("Workspace has changed. Refactoring is no longer valid");
	}
    }

    /**
     * User has accepted the change and desires that the refactoring is applied to his workspace.
     */
    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
	pm.beginTask("Applying Refactoring: " + command.getDescription(), 2);

	// Finally, re-apply the desired changes.
	command.runRefactoring();
	pm.worked(1);

	facade.refreshUI();
	pm.done();
	return new NullChange();
    }


// ######## Provider change as a textual representation for the compare viewer  ########

    @Override
    public String getCurrentContent(IProgressMonitor pm) throws CoreException {
	return command.getTextualPreExecutionRepresentation();
    }

    @Override
    public String getPreviewContent(IProgressMonitor pm) throws CoreException {
	if (isEnabled()) {
	    return command.getTextualPostExecutionRepresentation();
	} else {
	    return command.getTextualPreExecutionRepresentation();
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
	    throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
 IRefactoringCoreStatusCodes.BAD_LOCATION,
		    message, e));
	}
    }

}
