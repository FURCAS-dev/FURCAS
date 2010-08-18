package com.sap.ide.refactoring.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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

import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.refactoring.Activator;

public class TextBlockChange extends TextEditBasedChange {

    private final EObject correspondingRootObject;
    private String preChangeState;
    private String postChangeState;
    private String changeDescription = "Pretty Print";

    public TextBlockChange(EObject correspondingRootObject) {
	super("Pretty Print");
	this.correspondingRootObject = correspondingRootObject;
    }

    @Override
    public Object getModifiedElement() {
	return correspondingRootObject;
    }

    @Override
    public String getName() {
	return changeDescription + " " + ((EClass) correspondingRootObject.refMetaObject()).getName();
    }

    @Override
    public void initializeValidationData(IProgressMonitor pm) {

    }

    @Override
    public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
	return new RefactoringStatus();
    }

    @Override
    public Change perform(IProgressMonitor pm) throws CoreException {
	return new NullChange();
    }

    @Override
    public String getCurrentContent(IProgressMonitor pm) throws CoreException {
	return preChangeState;
    }

    @Override
    public String getPreviewContent(IProgressMonitor pm) throws CoreException {
	if (isEnabled()) {
	    return postChangeState;
	} else {
	    return preChangeState;
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
		    // no lines are in the region, so remove one from the
		    // context,
		    // or else spurious changes show up that look like deletes
		    // from the source
		    if (surroundingLines == 0) {
			// empty: show nothing
			return "";
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
		message = "BadLocationException";
	    }
	    throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IRefactoringCoreStatusCodes.BAD_LOCATION,
		    message, e));
	}
    }

    public void fetchPreChangeState(TextBlock textBlock) {
	preChangeState = getTextFromTextBlock(textBlock);
    }

    public void fetchPostChangeState(String description, TextBlock textBlock) {
	changeDescription = description;
	postChangeState = getTextFromTextBlock(textBlock);
    }

    private String getTextFromTextBlock(TextBlock textBlock) {
	// TODO: find a way how to do this properly...
	// We cannot just rely on the cache.
	String text = textBlock.getCachedString();
	return text == null ? "" : text;
    }

}
