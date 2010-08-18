package com.sap.ide.refactoring.core.textual;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.Block;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.refactoring.core.textual.TextBlockInChangeCalculator.ModelElementTextBlockTuple;
import com.sap.ide.refactoring.test.RefactoringBaseTest;

public class TestTextBlockInChangeCalculator extends RefactoringBaseTest {

    /**
     * System under test
     */
    private TextBlockInChangeCalculator sut;

    private RefactoringEditorFacade facade;

    @Test
    public void testRootObjectChanged() {
	sut = new TextBlockInChangeCalculator();
	facade = createEditorFacadeForRunletClass("Class1");
	EObject rootObject = facade.getDecoratedDomainRootObject();
	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();

	sut.add(rootObject);
	assertTextBlockInTupleList("If the root block has changed, the corresponding root textblock needs pretty printing", sut
		.getTextBlocksNeedingPrettyPrinting().get(rootObject), rootBlock);
	assertEquals("Class1 has no overlapping views on it.", 1, sut.getTextBlocksNeedingPrettyPrinting().size());
	assertEquals("Class1 is only references by the token that holds its name in the TB model", 1, sut
		.getTextBlocksNeedingShortPrettyPrinting().size());
    }

    @Test
    public void testNothingChanged() {
	sut = new TextBlockInChangeCalculator();

	// create a new class (a class which does not have any associated
	// textblocks!)
	NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	final SapClass newclazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(
		ModelManager.getPartitionService().getPartition(connection, getProject(),
			new Path("src/Package1235568260162.types")));
	newclazz.setName("NewClass");

	sut.add(newclazz);
	assertTrue("There cannot be anything to prettyprint if there are no TextBlocks",
		sut.getTextBlocksNeedingPrettyPrinting().isEmpty());
	assertTrue("There cannot be anything to short-prettyprint if there are no TextBlocks", sut
		.getTextBlocksNeedingShortPrettyPrinting().isEmpty());
    }

    @Test
    public void testRootObjectAndCompositeChanged1() {
	sut = new TextBlockInChangeCalculator();
	facade = createEditorFacadeForRunletClass("Class1");
	EObject rootObject = facade.getDecoratedDomainRootObject();
	EObject compositeChild = ((SapClass) rootObject).getOwnedSignatures().iterator().next();

	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();

	// Variant 1: First add the root
	sut.add(rootObject);
	sut.add(compositeChild);

	assertTextBlockInTupleList(sut.getTextBlocksNeedingPrettyPrinting().get(rootObject), rootBlock);
	assertEquals("If the parent block is in, the composite child must have been filtered.",
		1, sut.getTextBlocksNeedingPrettyPrinting().size());
    }

    @Test
    public void testRootObjectAndCompositeChanged2() {
	sut = new TextBlockInChangeCalculator();
	facade = createEditorFacadeForRunletClass("Class1");
	EObject rootObject = facade.getDecoratedDomainRootObject();
	EObject compositeChild = ((SapClass) rootObject).getOwnedSignatures().iterator().next();

	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();

	// Variant 2: First add the child, then the root
	sut.add(compositeChild);
	sut.add(rootObject);

	assertTextBlockInTupleList(sut.getTextBlocksNeedingPrettyPrinting().get(rootObject), rootBlock);
	assertEquals("If the parent block is in, the composite child must have been filtered.",
		1, sut.getTextBlocksNeedingPrettyPrinting().size());
    }

    @Test
    public void testComplexMergeExample() {
	sut = new TextBlockInChangeCalculator();
	facade = createEditorFacadeForRunletClass("AddTwoParametersTest");

	SapClass rootObject = (SapClass) facade.getDecoratedDomainRootObject();
	MethodSignature firstMethod = rootObject.getOwnedSignatures().iterator().next();
	MethodSignature secondMethod = rootObject.getOwnedSignatures().iterator().next();

	Block firstMethodImpl = (Block) firstMethod.getImplementation();
	Statement firstStatementInFirstMethod = firstMethodImpl.getStatements().iterator().next();

	sut.add(firstStatementInFirstMethod);
	sut.add(secondMethod);
	assertEquals("Expect to find the statement and the second method.", 2,
		sut.getTextBlocksNeedingPrettyPrinting().get(rootObject).size());

	sut.add(firstMethodImpl);
	assertEquals("Expect to find one method and one method body.", 2,
		sut.getTextBlocksNeedingPrettyPrinting().get(rootObject).size());

	// double inserts should do no harm
	sut.add(firstMethodImpl);
	sut.add(firstStatementInFirstMethod);
	sut.add(secondMethod);
	sut.add(firstMethod); // should lead to removeal of the body and the
			      // statement
	assertEquals("Expect to find both methods.", 2,
		sut.getTextBlocksNeedingPrettyPrinting().get(rootObject).size());

	sut.add(rootObject);
	assertEquals("Expect to find just the root tb.", 1,
		sut.getTextBlocksNeedingPrettyPrinting().get(rootObject).size());
	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();
	assertTextBlockInTupleList(sut.getTextBlocksNeedingPrettyPrinting().get(rootObject), rootBlock);
    }

    private void assertTextBlockInTupleList(List<ModelElementTextBlockTuple> tuples, TextBlock tb) {
	boolean found = tuples != null && findTextBlockInTupleList(tuples, tb);
	assertTrue(found);
    }

    private void assertTextBlockInTupleList(String message, List<ModelElementTextBlockTuple> tuples, TextBlock tb) {
	boolean found = tuples != null && findTextBlockInTupleList(tuples, tb);
	assertTrue(message, found);
    }

    private boolean findTextBlockInTupleList(List<ModelElementTextBlockTuple> tuples, TextBlock tb) {
	boolean found = false;
	for (ModelElementTextBlockTuple tuple : tuples) {
	    if (tuple.textBlock.equals(tb)) {
		found = true;
	    }
	}
	return found;
    }

}
