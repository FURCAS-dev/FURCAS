package com.sap.ide.refactoring.core.textual;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.ISourceViewer;
import org.junit.After;
import org.junit.Test;

import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.mi.textual.parsing.textblocks.TbNavigationUtil;
import com.sap.mi.textual.textblocks.model.TextBlocksModel;

public class TestSourcePositionModelLocator extends RefactoringBaseTest {

    /**
     * System under test
     */
    private SourcePositionModelLocator sut;

    private ISourceViewer viewer;
    private CtsDocument document;
    private AbstractGrammarBasedEditor editor;

    public TestSourcePositionModelLocator() {
	isIntegrationTest = true;
    }

    /**
     * Initialize class members for the next testcase run
     *
     * @param className
     */
    private void initializeForClass(String className) {
	final EObject refObject = findRunletClass(className);
	assertNotNull(refObject);
	assertTrue(refObject.is___Alive());

	editor = openEditor(refObject);
	document = getDocument(editor);
	TextBlocksModel model = document.getTextBlocksModelStore().getModel();

	viewer = editor.getSourceViewerPublic();
	viewer.setEditable(false);
	sut = new SourcePositionModelLocator(model, viewer);

    }

    @Test
    public void testSourceViewerOffsetHandlingAssumption() {
	initializeForClass("OrderedAssocTestCase");

	setCursor(0);
	assertEquals(0, viewer.getSelectedRange().x);
	assertEquals(0, viewer.getSelectedRange().y);

	setCursor(10);
	assertEquals(10, viewer.getSelectedRange().x);
	assertEquals(0, viewer.getSelectedRange().y);

	selectRange(10, 20);
	assertEquals(10, viewer.getSelectedRange().x);
	assertEquals(20, viewer.getSelectedRange().y);
    }

    @Test
    public void testFindSingleSelectedCorrespondingModelElements() {
	initializeForClass("OrderedAssocTestCase");

	setCursor("class Order".length());
	Collection<EObject> selected = sut.findSelectedCorrespondingModelElements();

	assertEquals(1, selected.size());
	assertEquals(findRunletClass("OrderedAssocTestCase"), selected.iterator().next());
    }

    @Test
    public void testFindRootBlockForFullSelection() {
	initializeForClass("OrderedAssocTestCase");

	selectRange(0, document.getLength());
	Collection<DocumentNode> selected = sut.findSelecetedTextBlocks();

	assertEquals("Only root TextBlock shall be contained", 1, selected.size());
	DocumentNode rootNode = selected.iterator().next();
	assertEquals(rootNode, TbNavigationUtil.getUltraRoot(rootNode));
    }

    @Test
    public void testFindCorrespondingModelElementsForFullSelection() {
	initializeForClass("OrderedAssocTestCase");

	selectRange(0, document.getLength());
	Collection<EObject> selected = sut.findSelectedCorrespondingModelElements();

	assertEquals(1, selected.size());
	assertEquals(findRunletClass("OrderedAssocTestCase"), selected.iterator().next());
    }

    @Test
    public void testFindReferencedModelElementsForSelectedWord() {
	initializeForClass("RedefineParameterTst2");
	String text = document.get();

	selectRange(text.indexOf("Number"), "Number".length());
	Collection<EObject> selected = sut.findSelectedReferencedModelElements();

	assertEquals(1, selected.size());
	assertEquals(findRunletClass("Number"), selected.iterator().next());
    }

    /**
     * The class has a method and within this method two statements. Select
     * those two statements.
     */
    @Test
    public void testFindMultipleSelectedCorrespondingModelElements() {
	initializeForClass("RedefineParameterTst2");

	String wholeClass = document.get();
	String methodOnly = wholeClass.substring(wholeClass.indexOf("{") + 1, wholeClass.lastIndexOf("}"));
	int offsetOfMethodInClass = wholeClass.indexOf(methodOnly);
	int statementStart = methodOnly.indexOf("var m") - 1; // begin of the
	// first statement
	int statementsEnd = methodOnly.lastIndexOf(";") - 1; // end of the
	// second statement

	selectRange(offsetOfMethodInClass + statementStart, statementsEnd - statementStart);
	Collection<EObject> selected = sut.findSelectedCorrespondingModelElements();

	assertEquals(2, selected.size());
    }

    /**
     * The class contains three occurrences of the variable "m". Test that the
     * last one has a reference to second occurrence (var usage to declaration)
     */
    @Test
    public void testFindSelectedReferencedModelElements() {
	initializeForClass("RedefineParameterTst2");
	String text = document.get();

	int usageIndex = text.lastIndexOf("m");
	int varDeclIndex = text.substring(0, usageIndex).lastIndexOf("m");

	selectRange(usageIndex, 1);
	Collection<EObject> referenced = sut.findSelectedReferencedModelElements();
	assertEquals(1, referenced.size());
	EObject varDeclReferenced = referenced.iterator().next();

	selectRange(varDeclIndex, 1);
	Collection<EObject> corresponding = sut.findSelectedCorrespondingModelElements();
	assertEquals(1, corresponding.size());
	EObject varDecl = corresponding.iterator().next();

	assertEquals(varDecl, varDeclReferenced);
    }

    private void setCursor(int offset) {
	selectRange(offset, 0);
    }

    private void selectRange(int offset, int length) {
	viewer.setSelectedRange(offset, length); // set cursor within class name
    }

    @After
    public void releaseResources() {
	if (editor != null) {
	    close(editor);
	}
	editor = null;
	document = null;
	viewer = null;
	sut = null;
    }

}
