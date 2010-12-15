package com.sap.ide.refactoring.ui;


import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import textblocks.DocumentNode;

import com.sap.ide.refactoring.Activator;
import com.sap.ide.refactoring.core.reference.ReEvaluationInfo;
import com.sap.ide.refactoring.core.textual.RootElementTextBlockTuple;
import com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;

/**
 * TODO: Unfinished.
 * 
 * Meant highlight the where and how a reference was rebound. 
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class ReEvaluationStatusContextViewer extends AnnotationEnabledStatusContextViewer {

    @Override
    public void setInputAndAnnotations(RefactoringStatusContext input) {
	ReEvaluationInfo reEvaluationInfo = (ReEvaluationInfo) input.getCorrespondingElement();

	// heuristics says that the only the first corresponding model element has
	// syntax contribution
	RootElementTextBlockTuple rootTuple = TextBlockRefactoringUtil.findTextBlockRootDomainRootObjectTuplesForModelElement(reEvaluationInfo.modelElement).iterator().next();
	DocumentNode documentNode = TextBlockRefactoringUtil.findCorrespondingTextBlocks(reEvaluationInfo.modelElement).iterator().next();

	TextBlocksModel model = new TextBlocksModel(rootTuple.textBlock, /*modelAdapter*/null);
	IDocument document = new Document(model.get(0, model.getLength()));
	
	setAnnotatedDocumentRegion(document, new Region(0, model.getLength()));
	addAnnotation(reEvaluationInfo.getSeverity(), reEvaluationInfo.getMessage(), documentNode);
    }
    
    @Override
    protected void highlightTextPosition(Position position) {
	try {
	    textPresentation.addStyleRange(new StyleRange(position.offset, position.length, null, new Color(Display.getDefault(),
		    new RGB(0, 0, 255))));
	    sourceViewer.changeTextPresentation(textPresentation, true);
	} catch (Exception e) {
	    Activator.logError(e, "Failed to highlight affected text");
	}
    }
    


}
