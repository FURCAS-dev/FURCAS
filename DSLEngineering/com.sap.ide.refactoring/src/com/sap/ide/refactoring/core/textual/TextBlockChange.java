package com.sap.ide.refactoring.core.textual;

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

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.model.RefactoringModelUtil;

/**
 * Glue coding to the Eclipe refactoring framework. It is used to present
 * pretty printing results in the Eclipse preview.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class TextBlockChange extends TextEditBasedChange {

    private String preChangeState = "";
    private String postChangeState = "";
    
    private final RootElementTextBlockTuple rootTuple;
    
    /** 
     * Cache name. We might not be able to construct if afterwards, if the
     * block is deleted by the pretty printer 
     */
    private final String name;
    private final RefactoringEditorFacade facade;
    private TextBlock postChangeRootBlock;


    public TextBlockChange(RefactoringEditorFacade facade, RootElementTextBlockTuple rootTuple) {
    	
	super("Pretty Print");
	this.facade = facade;
	this.rootTuple = rootTuple;
	this.name = getName();
	
	fetchPreChangeState();
    }

    @Override
    public Object getModifiedElement() {
	return rootTuple.modelElement;
    }

    @Override
    public String getName() {
	if (name == null) {
	    String syntaxString = "";
	    try {
		syntaxString =  " in Syntax \"" + rootTuple.textBlock.getType().getParseRule().getConcretesyntax().getName() + "\"";
	    } catch (NullPointerException e) {
		// do nothing
	    }
	    return "Pretty Print: " + RefactoringModelUtil.getModelElementName(rootTuple.modelElement) +
	    " (" + RefactoringModelUtil.getModelElementType(rootTuple.modelElement) + ")" + syntaxString; 
	} else {
	    return name;
	}
    }

    @Override
    public void initializeValidationData(IProgressMonitor pm) {

    }

    @Override
    public RefactoringStatus isValid(IProgressMonitor pm) throws OperationCanceledException {
	return new RefactoringStatus();
    }

    @Override
    public Change perform(IProgressMonitor pm) {
	if (changeBelongsToEditorFacade() && postChangeRootBlock != null) {
	    facade.updateRootBlock(postChangeRootBlock);
	    facade.refreshUI();
	}
	return new NullChange();
    }

    private boolean changeBelongsToEditorFacade() {
	return facade.getDecoratedDomainRootObject().equals(rootTuple.modelElement) &&
		facade.getTextBlocksModel().getRoot().equals(rootTuple.textBlock);
    }
    
    @Override
    public String getCurrentContent(IProgressMonitor pm) {
	return preChangeState;
    }

    @Override
    public String getPreviewContent(IProgressMonitor pm) {
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

    private String clipToRegion(IDocument document, IRegion region, boolean expandRegionToFullLine, int surroundingLines)
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

    private void fetchPreChangeState() {
	System.out.println(">>>PRE");
	preChangeState = getTextFromTextBlock(rootTuple.textBlock);
    }

    public void fetchPostChangeState(TextBlock modifiedBlock) {
	if (modifiedBlock == null) {
	    postChangeState = ""; 
	} else {
	    System.out.println(">>>POST");
	    postChangeState = getTextFromTextBlock(modifiedBlock);
	    postChangeRootBlock = modifiedBlock;
	}
    }

    private String getTextFromTextBlock(TextBlock textBlock) {
	try { // May fail if the model is invalid
	    TextBlock rootBlock = TbNavigationUtil.getUltraRoot(textBlock);
	    TextBlocksModel model = new TextBlocksModel(rootBlock, /*modelAdapter*/ null);
	    System.out.println(model.get(0, model.getLength()));
	    return model.get(0, model.getLength());
	} catch (Exception e) {
	    Activator.logError(e, "Failed to get text from text block model");
	    return "Failed to retrieve content. See Error log.";
	}
    }

}
