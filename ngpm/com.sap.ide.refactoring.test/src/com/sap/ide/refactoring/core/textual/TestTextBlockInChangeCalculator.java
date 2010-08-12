package com.sap.ide.refactoring.core.textual;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import ngpm.NgpmPackage;

import org.eclipse.core.runtime.Path;
import org.junit.Test;

import textblocks.TextBlock;
import behavioral.actions.Block;
import behavioral.actions.Statement;

import com.sap.ide.refactoring.core.textual.ModelElementDocumentNodeChangeDescriptor.ChangeType;
import com.sap.ide.refactoring.test.RefactoringBaseTest;
import com.sap.mi.fwk.ModelManager;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.MethodSignature;
import data.classes.SapClass;

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
	RefObject rootObject = facade.getDecoratedDomainRootObject();
	RootElementTextBlockTuple rootTuple = new RootElementTextBlockTuple(rootObject, facade.getTextBlocksModel().getRoot());
	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();

	sut.add(rootObject, ChangeType.CHANGED);
	assertTextBlockInTupleList("If the root block has changed, the corresponding root textblock needs pretty printing", sut
		.getTextBlocksNeedingPrettyPrinting().get(rootTuple), rootBlock);
	assertEquals("Class1 has no overlapping views on it.", 1, sut.getTextBlocksNeedingPrettyPrinting().size());
	assertEquals("Class1 is only references by the token that holds its name in the TB model", 1, sut
		.getTextBlocksNeedingShortPrettyPrinting().get(rootTuple).size());
    }

    @Test
    public void testRootObjectAndCompositeChanged1() {
	sut = new TextBlockInChangeCalculator();
	facade = createEditorFacadeForRunletClass("Class1");
	RefObject rootObject = facade.getDecoratedDomainRootObject();
	RootElementTextBlockTuple rootTuple = new RootElementTextBlockTuple(rootObject, facade.getTextBlocksModel().getRoot());
	RefObject compositeChild = ((SapClass) rootObject).getOwnedSignatures().iterator().next();

	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();

	// Variant 1: First add the root
	sut.add(rootObject, ChangeType.CHANGED);
	sut.add(compositeChild, ChangeType.CHANGED);

	assertTextBlockInTupleList(sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple), rootBlock);
	assertEquals("If the parent block is in, the composite child must have been filtered.",
		1, sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple).size());
    }

    @Test
    public void testRootObjectAndCompositeChanged2() {
	sut = new TextBlockInChangeCalculator();
	facade = createEditorFacadeForRunletClass("Class1");
	RefObject rootObject = facade.getDecoratedDomainRootObject();
	RootElementTextBlockTuple rootTuple = new RootElementTextBlockTuple(rootObject, facade.getTextBlocksModel().getRoot());
	RefObject compositeChild = ((SapClass) rootObject).getOwnedSignatures().iterator().next();

	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();

	// Variant 2: First add the child, then the root
	sut.add(compositeChild, ChangeType.CHANGED);
	sut.add(rootObject, ChangeType.CHANGED);

	assertTextBlockInTupleList(sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple), rootBlock);
	assertEquals("If the parent block is in, the composite child must have been filtered.",
		1, sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple).size());
    }

    @Test
    public void testComplexMergeExample() {
	sut = new TextBlockInChangeCalculator();
	facade = createEditorFacadeForRunletClass("AddTwoParametersTest");

	SapClass rootObject = (SapClass) facade.getDecoratedDomainRootObject();
	RootElementTextBlockTuple rootTuple = new RootElementTextBlockTuple(rootObject, facade.getTextBlocksModel().getRoot());
	MethodSignature firstMethod = rootObject.getOwnedSignatures().iterator().next();
	MethodSignature secondMethod = rootObject.getOwnedSignatures().iterator().next();

	Block firstMethodImpl = (Block) firstMethod.getImplementation();
	Statement firstStatementInFirstMethod = firstMethodImpl.getStatements().iterator().next();

	sut.add(firstStatementInFirstMethod, ChangeType.CHANGED);
	sut.add(secondMethod, ChangeType.CHANGED);
	assertEquals("Expect to find the statement and the second method.", 2,
		sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple).size());

	sut.add(firstMethodImpl, ChangeType.CHANGED);
	assertEquals("Expect to find one method and one method body.", 2,
		sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple).size());

	// double inserts should do no harm
	sut.add(firstMethodImpl, ChangeType.CHANGED);
	sut.add(firstStatementInFirstMethod, ChangeType.CHANGED);
	sut.add(secondMethod, ChangeType.CHANGED);
	sut.add(firstMethod, ChangeType.CHANGED); // should lead to removeal of the body and the statement
	assertEquals("Expect to find both methods.", 2,
		sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple).size());

	sut.add(rootObject, ChangeType.CHANGED);
	assertEquals("Expect to find just the root tb.", 1,
		sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple).size());
	TextBlock rootBlock = facade.getTextBlocksModel().getRoot();
	assertTextBlockInTupleList(sut.getTextBlocksNeedingPrettyPrinting().get(rootTuple), rootBlock);
    }

    /**
     * For now we expect new top level elements do not get a new view automatically 
     * 
     * If  anyone has a good reasons to change it, we will.
     */
    @Test
    public void testCreateNewRootElement() {
	sut = new TextBlockInChangeCalculator();

	// create a new class (a class which does not have any associated textblocks!)
	NgpmPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
	final SapClass newclazz = (SapClass) rootPkg.getData().getClasses().getSapClass().refCreateInstanceInPartition(
		ModelManager.getPartitionService().getPartition(connection, getProject(),
			new Path("src/Package1235568260162.types")));
	newclazz.setName("NewClass");

	sut.add(newclazz, ChangeType.CREATED);
	assertTrue(sut.getTextBlocksNeedingPrettyPrinting().isEmpty());
    }

    private void assertTextBlockInTupleList(List<ModelElementDocumentNodeChangeDescriptor> tuples, TextBlock tb) {
	boolean found = tuples != null && findTextBlockInTupleList(tuples, tb);
	assertTrue(found);
    }

    private void assertTextBlockInTupleList(String message, List<ModelElementDocumentNodeChangeDescriptor> tuples, TextBlock tb) {
	boolean found = tuples != null && findTextBlockInTupleList(tuples, tb);
	assertTrue(message, found);
    }

    private boolean findTextBlockInTupleList(List<ModelElementDocumentNodeChangeDescriptor> tuples, TextBlock tb) {
	boolean found = false;
	for (ModelElementDocumentNodeChangeDescriptor tuple : tuples) {
	    if (tuple.documentNode.equals(tb)) {
		found = true;
	    }
	}
	return found;
    }

}
