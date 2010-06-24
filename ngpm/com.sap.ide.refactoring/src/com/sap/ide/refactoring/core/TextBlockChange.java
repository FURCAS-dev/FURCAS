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

import textblocks.TextBlock;

import com.sap.ide.refactoring.Activator;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TextBlockChange extends TextEditBasedChange {

    private String preChangeState = "Unable to retrieve content"; // default/error message
    private String postChangeState = "Unable to retrieve content"; // default/error message
    private final RefObject rootObject;

    public TextBlockChange(RefObject rootObject) {
	super("Pretty Print");
	this.rootObject = rootObject;
    }

    @Override
    public Object getModifiedElement() {
	return rootObject;
    }

    @Override
    public String getName() {
	return "Pretty Print " + ((MofClass) rootObject.refMetaObject()).getName();
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
	System.out.println(">>>PRE");
	preChangeState = getTextFromTextBlock(textBlock);
    }

    public void fetchPostChangeState(TextBlock textBlock) {
	System.out.println(">>>POST");
	postChangeState = getTextFromTextBlock(textBlock);
    }

    private String getTextFromTextBlock(TextBlock textBlock) {
	String text = textBlock.getCachedString();
	// Remove the following check if the pretty printer has matured
	if (TbNavigationUtil.isUltraRoot(textBlock)) {
	    TextBlocksModel model = new TextBlocksModel(textBlock, /*modelAdapter*/ null);
	    model.setUsecache(!model.isUsecache());
	    assert text.equals(model.get(0, model.getLength())) : "Cache and Model must be in sync.";
	}
	System.out.println(text);
	return text == null ? "" : text;
    }

}
