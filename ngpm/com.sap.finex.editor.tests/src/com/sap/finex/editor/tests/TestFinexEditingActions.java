package com.sap.finex.editor.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.PartInitException;
import org.junit.Test;

import structure.FinexClass;
import behavior.expressions.BinaryNumericOperator;
import behavior.expressions.Expression;
import behavior.expressions.literals.IntegerLiteral;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;

public class TestFinexEditingActions extends FinexEditorTest {
    
    /**
     * The editor gives an error dialog and the model is not updated.
     */
    @Test
    public void testAddingValidation() throws PartInitException, BadLocationException, CoreException {
        FinexClass testInfixChangeClass = findClass("TestFinexInfixOperatorChange");
        // Source / Copy of: PF.IDE:E007956A7EF09B11E0BA11DE91A5CC610A140E7A
        assertNotNull(testInfixChangeClass); 
        assertTrue(testInfixChangeClass.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(testInfixChangeClass);
        CtsDocument document = getDocument(editor);
        document.replace(49, 0, "\n    ");
        document.replace(54, 0, "[]");
        document.replace(55, 0, "2");
        document.replace(56, 0, " ");
        document.replace(57, 0, "<");
        document.replace(58, 0, " ");
        document.replace(59, 0, "3");
        document.replace(61, 0, ";");
        saveAll(editor);
        failOnError(editor);
        assertTrue(testInfixChangeClass.is___Alive());
        // Your assertions on refObject here 
        assertEquals(2, testInfixChangeClass.getInvariants().size());
        boolean found = false;
        for (Expression e : testInfixChangeClass.getInvariants()) {
            if (e instanceof BinaryNumericOperator) {
                BinaryNumericOperator bno = (BinaryNumericOperator) e;
                if (bno.getOperator().equals("<")) {
                    found = found || (bno.getLeft() instanceof IntegerLiteral &&
                             bno.getRight() instanceof IntegerLiteral &&
                             ((IntegerLiteral) bno.getLeft()).getLiteral().equals("2") &&
                             ((IntegerLiteral) bno.getRight()).getLiteral().equals("3"));
                }
            }
        }
        assertTrue("Didn't find an invariant [ 2 < 3]", found);
        close(editor);
    };

    /**
     * The test failed because the incremental editor simply did not update the operator in the model
     */
    @Test
    public void testChangeInfixOperatorFromPlusToMinus() throws PartInitException, BadLocationException, CoreException {
        FinexClass testInfixChangeClass = findClass("TestFinexInfixOperatorChange");
        assertNotNull(testInfixChangeClass); 
        assertTrue(testInfixChangeClass.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(testInfixChangeClass);
        CtsDocument document = getDocument(editor);
        document.replace(39, 1, "");
        document.replace(39, 0, "+");
        saveAll(editor);
        failOnError(editor);
        assertTrue(testInfixChangeClass.is___Alive());

        BinaryNumericOperator invariant = (BinaryNumericOperator) testInfixChangeClass.getInvariants().iterator().next();
        BinaryNumericOperator expectedPlusOperator = (BinaryNumericOperator) invariant.getLeft();
        assertEquals("+", expectedPlusOperator.getOperator());
        
        close(editor);
    };
    
    /**
     * The test failed because the incremental editor simply did not update the operator in the model
     * @throws BadLocationException 
     */
    @Test
    public void testFindClass() throws PartInitException, CoreException, BadLocationException {
        FinexClass testInfixChangeClass = findClass("TestFinexInfixOperatorChange");
        assertNotNull(testInfixChangeClass); 
        assertTrue(testInfixChangeClass.is___Alive()); 
        AbstractGrammarBasedEditor editor = openEditor(testInfixChangeClass);
        CtsDocument document = getDocument(editor);
        document.replace(38, 1, ""); // replace a + by a +
        document.replace(38, 0, "+");
        saveAll(editor);
        failOnError(editor);
        assertTrue(testInfixChangeClass.is___Alive());

        BinaryNumericOperator invariant = (BinaryNumericOperator) testInfixChangeClass.getInvariants().iterator().next();
        assertNotNull(invariant);
        
        close(editor);
    };

}
