package com.sap.ide.refactoring.ui;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;

import textblocks.DocumentNode;

import com.sap.ide.refactoring.core.constraints.ConstraintViolation;
import com.sap.ide.refactoring.core.textual.RootElementTextBlockTuple;
import com.sap.ide.refactoring.core.textual.TextBlockRefactoringUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;

/**
 * Shows source code annotated with violated constraints.
 * 
 * @author Stephan Erb (d049157)
 *
 */
public class ConstraintViolationStatusContextViewer extends AnnotationEnabledStatusContextViewer {

    @Override
    public void setInputAndAnnotations(RefactoringStatusContext input) {
	ConstraintViolation violation = (ConstraintViolation) input.getCorrespondingElement();
	
	// heuristics says that the only the first corresponding model element has
	// syntax contribution
	RootElementTextBlockTuple rootTuple = TextBlockRefactoringUtil.findTextBlockRootDomainRootObjectTuplesForModelElement(violation.elementInError).iterator().next();
	DocumentNode documentNode = TextBlockRefactoringUtil.findCorrespondingTextBlocks(violation.elementInError).iterator().next();

	TextBlocksModel model = new TextBlocksModel(rootTuple.textBlock, /*modelAdapter*/null);
	IDocument document = new Document(model.get(0, model.getLength()));
	
	addAnnotation(violation.getSeverity(), violation.getDescription(), documentNode);
	setAnnotatedDocumentRegion(document, new Region(0, model.getLength()));
    }
}
