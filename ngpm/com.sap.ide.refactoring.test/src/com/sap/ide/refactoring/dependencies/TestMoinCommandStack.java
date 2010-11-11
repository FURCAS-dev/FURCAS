package com.sap.ide.refactoring.dependencies;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.antlr.runtime.Lexer;
import org.junit.Test;

import tcs.ClassTemplate;
import tcs.ConcreteSyntax;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.EditorUtil;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;
import com.sap.ide.cts.editor.prettyprint.textblocks.IncrementalTextBlockPrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockTCSExtractorStream;
import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.ide.refactoring.core.textual.RefactoringEditorFacade;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.SapClass;


/**
 * We had difficulties undoing incremental pretty printer runs.
 * 
 * There must be a combination of actions that MOIN has difficulties with. The following tests
 * were used to track the issue down.
 * 
 * It works now after making a few changes to {@link CtsTextBlockIncrementalTCSExtractorStream}.
 * Unfortunately I don't know why... :-/
 * 
 */
public class TestMoinCommandStack extends RefactoringBaseTest {

    @Test
    public void testUndoOfOrderdCompositeAssociationInCommand() {
	TextblocksPackage tbPackage = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);

	TextBlock parentBlock = (TextBlock) tbPackage.getTextBlock().refCreateInstance();
	createTextBlocksInCommand(parentBlock);
	
	// Pre undo order check
	for (int i=0; i<parentBlock.getSubBlocks().size(); i++) {
	    assertEquals(i, parentBlock.getSubBlocks().get(i).getOffset());
	}
	
	connection.getCommandStack().undo();
	assertTrue("SubBlocks should all be gone by the undo", parentBlock.getSubBlocks().isEmpty());
	connection.getCommandStack().redo();

	// Post undo order check
	for (int i=0; i<parentBlock.getSubBlocks().size(); i++) {
	    assertEquals(i, parentBlock.getSubBlocks().get(i).getOffset());
	}
    }

    private void createTextBlocksInCommand(TextBlock parentBlock) {
	TextblocksPackage tbPackage = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	connection.getCommandStack().openGroup("Create Sub TextBlocks");

	TextBlock leftSubBlock = (TextBlock) tbPackage.getTextBlock().refCreateInstance();
	leftSubBlock.setOffset(0);
	leftSubBlock.setParentBlock(parentBlock);
	
	TextBlock middleSubBlock = (TextBlock) tbPackage.getTextBlock().refCreateInstance();
	middleSubBlock.setOffset(1);
	middleSubBlock.setParentBlock(parentBlock);
	
	TextBlock rightSubBlock = (TextBlock) tbPackage.getTextBlock().refCreateInstance();
	rightSubBlock.setOffset(2);
	rightSubBlock.setParentBlock(parentBlock);
	
	connection.getCommandStack().closeGroup();
    }
    
    @Test
    public void testUndoPrettyPrinting() {
	RefactoringEditorFacade facade =  createEditorFacadeForRunletClass("Class2");
	TextBlock textBlockToPrint = facade.getTextBlocksModel().getRoot();
	SapClass correspondingModelElement = (SapClass) facade.getDecoratedDomainRootObject();
	
	// TB needs to be valid before we start the refactoring.
	TbValidationUtil.assertTextBlockConsistencyRecursive(textBlockToPrint);

	
	connection.getCommandStack().openGroup("Pretty Print");
	TextBlock newRootTextBlock = prettyPrint(textBlockToPrint, correspondingModelElement);
	connection.getCommandStack().closeGroup();
	
	
	TbValidationUtil.assertTextBlockConsistencyRecursive(newRootTextBlock);
	TbValidationUtil.assertTextBlockConsistencyRecursive(textBlockToPrint);
	
	connection.getCommandStack().undo();
	
	// We have just undone the refactoring. It is essential that we still have a valid TB.
	TbValidationUtil.assertTextBlockConsistencyRecursive(textBlockToPrint);
    }
    
    private TextBlock prettyPrint(TextBlock textBlockToPrint, RefObject correspondingModelElement) {
	ClassTemplate template = (ClassTemplate) textBlockToPrint.getType().getParseRule();
	ConcreteSyntax syntax = template.getConcretesyntax();

	AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil
		.constructParserFactoryForSyntax(syntax);
	TextblocksPackage tbPackage = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	TextBlockTCSExtractorStream stream = new TextBlockTCSExtractorStream(tbPackage,
		textBlockToPrint.get___Partition(), parserFactory);
	try {
	    PrettyPrinter prettyPrinter = new PrettyPrinter();
	    prettyPrinter.prettyPrint(correspondingModelElement, syntax, stream, template);
	} catch (SyntaxAndModelMismatchException e) {
	    fail(e.getMessage());
	}
	return stream.getPrintedResultRootBlock();
    }
    
    @Test
    public void testUndoIncrementalPrettyPrintingWithReuse() {
	RefactoringEditorFacade facade =  createEditorFacadeForRunletClass("Class2");
	TextBlock textBlockToPrint = facade.getTextBlocksModel().getRoot();
	SapClass correspondingModelElement = (SapClass) facade.getDecoratedDomainRootObject();
	
	// TB needs to be valid before we start the refactoring.
	TbValidationUtil.assertTextBlockConsistencyRecursive(textBlockToPrint);

	
	connection.getCommandStack().openGroup("Pretty Print");
	TextBlock newRootTextBlock = incrementalPrettyPrint(textBlockToPrint, correspondingModelElement);
	connection.getCommandStack().closeGroup();
	
	TbValidationUtil.assertTextBlockConsistencyRecursive(newRootTextBlock);
	
	connection.getCommandStack().undo();
	
	// We have just undone the refactoring. It is essential that we still have a valid, original TB
	TbValidationUtil.assertTextBlockConsistencyRecursive(textBlockToPrint);
    }
    
    private TextBlock incrementalPrettyPrint(TextBlock textBlockToPrint, RefObject correspondingModelElement) {
	IncrementalTextBlockPrettyPrinter incrementalPrettyPrinter = new IncrementalTextBlockPrettyPrinter();
	ClassTemplate template = (ClassTemplate) textBlockToPrint.getType().getParseRule();
	ConcreteSyntax syntax = template.getConcretesyntax();

	AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory = EditorUtil.constructParserFactoryForSyntax(syntax);
	TextblocksPackage tbPackage = connection.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	TextBlockTCSExtractorStream stream = new TextBlockTCSExtractorStream(tbPackage, textBlockToPrint.get___Partition(), parserFactory);
	try {
	    incrementalPrettyPrinter.prettyPrint(correspondingModelElement, textBlockToPrint, syntax, template, stream);
	} catch (SyntaxAndModelMismatchException e) {
	    fail(e.getMessage());
	}
	return stream.getPrintedResultRootBlock();
    }
    
    
}
