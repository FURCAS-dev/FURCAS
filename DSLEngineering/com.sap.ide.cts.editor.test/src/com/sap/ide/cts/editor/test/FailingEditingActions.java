package com.sap.ide.cts.editor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import modelmanagement.Package;
import ngpm.NgpmPackage;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.PartInitException;
import org.junit.Test;

import behavioral.actions.Block;
import behavioral.actions.NamedValueDeclaration;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.document.CtsHistoryDocument;
import com.sap.ide.cts.editor.junitcreate.DocumentHistory;
import com.sap.ide.cts.editor.junitcreate.SnapshotVersion;
import com.sap.mi.fwk.ModelManager;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.MethodSignature;
import data.classes.NamedValue;
import data.classes.SapClass;

public class FailingEditingActions extends RunletEditorTest {

    /**
     * The outcommenting doesn't seem to be honored by the incremental parser.
     */
    @Test
    public void testAddIterate() throws PartInitException, BadLocationException, CoreException {
        final RefObject refObject = findClass("ClassWithEmptyMethod");
        assertNotNull(refObject); 
        assertTrue(refObject.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(refObject);
        CtsDocument document = getDocument(editor);
        int pos = document.get().indexOf("}");
        document.replace(pos, 0, "  OrderedAssocTest o = new OrderedAssocTest(orderedPersons: all Person[self.name==\"Axel\"]);\n  ");
        saveAll(editor);
        //failOnError(editor);
        assertTrue(refObject.is___Alive());
        // Your assertions on refObject here 
        SapClass c = (SapClass) refObject;
        MethodSignature ms = c.getOwnedSignatures().iterator().next();
        Block b = (Block) ms.getImplementation();
        Collection<NamedValue> variables = b.getVariables();
        assertEquals("Expect to find one declared variables in block because of new OrderedAssocTest variable o",
        	1, variables.size());
        NamedValueDeclaration variableDeclaration = (NamedValueDeclaration) b.getStatements().iterator().next();
        Collection<JmiException> verificationResults = variableDeclaration.getNamedValue().getInitExpression().
        							refVerifyConstraints(/* deepVerity */ true);
        assertEquals("Expected to find one semantic error in variable declaration before fix", 1, verificationResults.size());
        pos = document.get().indexOf(");");
        document.replace(pos, 0, "->iterate(p|p)"); // this will make it semantically correct again
        saveAll(editor);
        Collection<JmiException> verificationResults2 = variableDeclaration.getNamedValue().getInitExpression().
        							refVerifyConstraints(/* deepVerity */ true);
        assertEquals("Expected to find no semantic errors in variable declaration after fix", 0, verificationResults2.size());
        close(editor);
    };
   
    /**
     * (from TestCtsHistoryDocument)
     * 
     * This testcase fails due to a potential bug in MOIN. For a problem
     * description see {@link DocumentHistory#persistSnapshot(String)}
     * 
     * Only real difference to the existing testcase in TestCtsHistoryDocument
     * is that here we only create one snapshot per iteration
     */
    @Test
    public void testCopyPersistSeriesWithContainerCheck() throws Exception {
	int SERIES_COUNT = 3;

	final SapClass clazz = findClass("Class2");
	assertNotNull(clazz);
	AbstractGrammarBasedEditor editor = openEditor(clazz);
	CtsHistoryDocument document = (CtsHistoryDocument) getDocument(editor);
	saveAll(editor); // hack to run on migrated tokens / fixed mapping
	failOnError(editor);

	DocumentHistory history = new DocumentHistory(document, getProject());
	document.setAndActivateDocumentHistoryForTesting(history);

	Collection<SapClass> classes = new ArrayList<SapClass>(SERIES_COUNT + 1);
	classes.add(clazz);
	for (int i = 1; i <= SERIES_COUNT; i++) {
	    String s = "Iteration " + i + ": ";

	    Boolean success = history.createNewSnapshot(new NullProgressMonitor());
	    assertTrue(success);
	    // history.hack();

	    MRI mri = history.persistSnapshot("TestCopyPersistSeries" + i, SnapshotVersion.COMPLETED);
	    assertNotNull(s + "Check for internal errros", mri);

	    assertTrue(history.isActive());

	    SapClass copy = (SapClass) connection.getElement(mri);
	    assertNotNull(s + "Element lookup with loading into memory", copy);
	    assertNull(copy.refVerifyConstraints(true));

	    ModelPartition partition = copy.get___Partition();
	    assertFalse(partition.isDirty());
	    assertFalse(partition.hadUnhandledErrorsDuringLoad());

	    assertNull(copy.refVerifyConstraints(true));

	    // Assert correct composition hierarchy
	    classes.add(copy);
	    Package pkg = clazz.getPackage();
	    assertNotNull(pkg);
	    assertEquals(s + "Copy must know its package", pkg, copy.getPackage());
	    assertTrue(s + "Package must know the copy", pkg.getClasses().contains(copy));
	    assertTrue(s + "Package must know its classes", pkg.getClasses().containsAll(classes));
	}

	assertNull(clazz.refVerifyConstraints(true));
	close(editor);
    }

    
    /** Currently fails with a StackOverflowError due to nested update event handler calls
     */
	@Test
	public void testDeleteStatementFromMethod() throws NullPartitionNotEmptyException,
			ReferencedTransientElementsException, PartitionsNotSavedException,
			BadLocationException, CoreException {

		NgpmPackage rootPkg = connection
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		final SapClass clazz = (SapClass) rootPkg.getData().getClasses()
				.getSapClass().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		final Package pack = (Package) rootPkg.getModelmanagement()
				.getPackage().refCreateInstanceInPartition(
						ModelManager.getPartitionService().getPartition(
								connection, getProject(),
								new Path("src/Package1235568260162.types")));
		clazz.setPackage(pack);
		clazz.setName("Humba");
		connection.save();

		AbstractGrammarBasedEditor editor = openEditor(clazz);

		CtsDocument document = getDocument(editor);
		String contents = document.get();
		int bodyStart = contents.indexOf('{');
		String newBody = "Boolean playWithPersistence() {"
				+ "store this;"
				+ "commit;"
				+ "var repositoryContainsThis = all Organization->iterate(contains=false; i|contains.or(i==this));"
				+ "return repositoryContainsThis;" + "}"
				+ "owns Person* persons {.,+=,-=}";
		document.replace(bodyStart + 1, 0, newBody);
		assertEquals("class Humba {" + newBody + "\n  \n}", document.get());

		saveAll(editor);

		assertEquals(4, clazz.getOwnedSignatures().size());
		Block body = (Block) clazz.getOwnedSignatures().iterator().next()
				.getImplementation();
		assertEquals(4, body.getStatements().size());

		contents = document.get();
		String commitString = "commit;";
		int commitStatmentIndex = contents.indexOf(commitString);
		document.replace(commitStatmentIndex, commitString.length(), "");
		assertEquals(
				"class Humba {Boolean playWithPersistence() {"
						+ "store this;"
						+ "var repositoryContainsThis = all Organization->iterate(contains=false; i|contains.or(i==this));"
						+ "return repositoryContainsThis;" + "}"
						+ "owns Person* persons {.,+=,-=}\n  \n}", document.get());

		saveAll(editor);

		assertEquals(4, clazz.getOwnedSignatures().size());
		body = (Block) clazz.getOwnedSignatures().iterator().next()
				.getImplementation();
		assertEquals(3, body.getStatements().size());

		close(editor);
	}
	

}
