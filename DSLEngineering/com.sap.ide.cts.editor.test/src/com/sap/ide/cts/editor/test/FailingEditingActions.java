package com.sap.ide.cts.editor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import modelmanagement.Package;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.PartInitException;
import org.junit.Test;

import behavioral.actions.Block;
import behavioral.actions.NamedValueDeclaration;
import behavioral.actions.Return;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.document.CtsHistoryDocument;
import com.sap.ide.cts.editor.junitcreate.DocumentHistory;
import com.sap.ide.cts.editor.junitcreate.SnapshotVersion;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import data.classes.MethodSignature;
import data.classes.NamedValue;
import data.classes.SapClass;
import dataaccess.expressions.MethodCallExpression;

public class FailingEditingActions extends RunletEditorTest {
    

    /**
     * When a parameter that is used as object for a method call changes its multiplicity from 0..1 to 1..1, the output
     * multiplicity of calling a method with 1..1 output multiplicity should change to 1..1.
     */
    @Test
    public void testChangeObjectMultiplicityForMethodCall() throws PartInitException, BadLocationException, CoreException {
        final RefObject refObject = findClass("MethodCallOutputMultiplicityTest");
        assertNotNull(refObject); 
        assertTrue(refObject.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(refObject);
        CtsDocument document = getDocument(editor);
        document.replace(52, 0, "1");
        document.replace(53, 0, ".");
        document.replace(54, 0, ".");
        document.replace(55, 0, "1");
        document.replace(56, 0, " ");
        document.replace(70, 0, " ");
        document.replace(71, 0, "1");
        document.replace(72, 0, ".");
        document.replace(73, 0, ".");
        document.replace(74, 0, "1");
        saveAll(editor);
        assertTrue(refObject.is___Alive());
	MethodCallExpression mce = (MethodCallExpression) ((Return) ((Block) ((SapClass) refObject).getOwnedSignatures()
		.iterator().next().getImplementation()).getStatements().iterator().next()).getArgument();
	assertEquals(1, mce.getType().getLowerMultiplicity());
        close(editor);
    };

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
        pos = document.get().indexOf(";");
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

    

}
