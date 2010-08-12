package com.sap.ide.cts.editor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

import data.classes.MethodSignature;
import data.classes.SapClass;
import dataaccess.expressions.Expression;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.VariableExpression;
import dataaccess.expressions.literals.NumberLiteral;

public class FailingEditingActions extends RunletEditorTest {
    /**
    I tried to add a 2.times(...) around an existing Number expression

    */
    @Test
    public void testFailingExpressionTransformation() throws PartInitException, BadLocationException, CoreException {
        // Source / Copy of: PF.IDE:E012BF1E67C2AFF0A53B11DFBFC6C9820A128A57
        final SapClass refObject = findClass("SebastiansCCpy0");
        assertNotNull(refObject); 
        assertTrue(refObject.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(refObject);
        CtsDocument document = getDocument(editor);
        document.replace(56, 0, "2");
        document.replace(57, 0, ".");
        document.replace(58, 0, "t");
        document.replace(59, 0, "i");
        document.replace(60, 0, "m");
        document.replace(61, 0, "e");
        document.replace(62, 0, "s");
        document.replace(63, 0, "()");
        document.replace(80, 1, ")");
        document.replace(64, 1, "");
        document.replace(80, 0, "l");
        document.replace(80, 1, "");
        document.replace(80, 0, ";");
        saveAll(editor);
        failOnError(editor);
        assertTrue(refObject.is___Alive());
        MethodSignature sLength = null;
        for (MethodSignature ms : refObject.getOwnedSignatures()) {
            if (ms.getName().equals("sLength")) {
        	sLength = ms;
        	break;
            }
        }
        Expression sourceForMethodCall = ((MethodCallExpression) ((Return) ((Block) sLength.getImplementation()).getStatements().iterator().next()).
        	getArgument()).getObject();
        assertTrue(sourceForMethodCall instanceof NumberLiteral);
        assertEquals("2", ((NumberLiteral) sourceForMethodCall).getLiteral());
        close(editor);
    };

    /**
     * Added a parameter to two operations and used the new parameter in both operations' implementation
     */
     @Test
     public void testAddTwoParametersTest() throws PartInitException, BadLocationException, CoreException {
	 final SapClass refObject = findClass("AddTwoParametersTest");
         assertNotNull(refObject); 
         assertTrue(refObject.is___Alive()); 
         AbstractGrammarBasedEditor editor = openEditor(refObject);
         CtsDocument document = getDocument(editor);
         document.replace(45, 0, "H");
         document.replace(46, 0, "u");
         document.replace(47, 0, "m");
         document.replace(48, 0, "b");
         document.replace(49, 0, "a");
         document.replace(50, 0, " ");
         document.replace(51, 0, "a");
         document.replace(75, 1, "");
         document.replace(74, 1, "");
         document.replace(74, 0, "a");
         document.replace(96, 0, "H");
         document.replace(97, 0, "u");
         document.replace(98, 0, "m");
         document.replace(99, 0, "b");
         document.replace(100, 0, "a");
         document.replace(101, 0, " ");
         document.replace(102, 0, "a");
         document.replace(126, 1, "");
         document.replace(125, 1, "");
         document.replace(125, 0, "a");
         saveAll(editor);
         failOnError(editor);
         assertTrue(refObject.is___Alive());
         MethodSignature a = refObject.getOwnedSignatures().iterator().next();
         NamedValueDeclaration v = (NamedValueDeclaration) ((Block) a.getImplementation()).getStatements().iterator().next();
         VariableExpression e = (VariableExpression) v.getNamedValue().getInitExpression();
         assertEquals(a.getInput().iterator().next(), e.getVariable());
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
