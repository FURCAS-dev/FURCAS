package com.sap.finex.editor.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.PartInitException;
import org.junit.Test;

import structure.FinexClass;
import behavior.expressions.BinaryNumericOperator;

import com.sap.ide.cts.editor.AbstractGrammarBasedEditor;
import com.sap.ide.cts.editor.document.CtsDocument;

public class TestFinexEditingActions extends FinexEditorTest {
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
