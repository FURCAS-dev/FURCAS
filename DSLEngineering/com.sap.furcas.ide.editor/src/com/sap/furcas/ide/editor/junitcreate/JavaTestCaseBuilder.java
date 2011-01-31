package com.sap.furcas.ide.editor.junitcreate;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.DocumentEvent;

import com.sap.furcas.ide.editor.document.CtsHistoryDocument;

/**
 * Helper class to create JUnit Test methods based on the information provided
 * by {@link CtsHistoryDocument} in form of a {@link DocumentHistory}.
 * 
 * @author D049157
 */
public class JavaTestCaseBuilder {

    public static String buildTestCase(URI sourceLRI, URI copyLri, Collection<DocumentEvent> history, String testCaseName,
	    String description) {
	StringBuilder sb = new StringBuilder(1024);
	sb.append("    /**\n    " + description + "\n\n    */\n");
	sb.append("    @Test\n");
	sb.append("    public void test" + testCaseName + "() throws PartInitException, BadLocationException, CoreException {\n");
	sb.append("        // Source / Copy of: " + sourceLRI.toString() + "\n");
	sb.append("        String lriString = \"" + copyLri.toString() + "\";\n");
	sb.append("        URI lri = connection.getSession().getMoin().createLri(lriString);\n");
	sb.append("        final RefObject refObject = (RefObject) connection.getElement(lri);\n");
	sb.append("        assertNotNull(refObject); \n");
	sb.append("        assertTrue(refObject.is___Alive()); \n");
	sb.append("        AbstractGrammarBasedEditor editor = openEditor(refObject);\n");
	sb.append("        CtsDocument document = getDocument(editor);\n");

	for (DocumentEvent stmnt : history) {
	    sb.append("        document.replace(");
	    sb.append(stmnt.getOffset()).append(", ");
	    sb.append(stmnt.getLength()).append(", \"");
	    sb.append(escape(stmnt.getText())).append("\");\n");
	}
	sb.append("        saveAll(editor);\n");
	sb.append("        //failOnError(editor);\n");
	sb.append("        assertTrue(refObject.is___Alive());\n");
	sb.append("        // Your assertions on refObject here \n\n");
	sb.append("        close(editor);\n");
	sb.append("    };\n");
	return sb.toString();
    }

    private static String escape(String text) {
	text = text.replace("\"", "\\\"");
	text = text.replace("\n", "\\n");
	text = text.replace("\r", "\\r");
	text = text.replace("\t", "\\t");
	return text;
    }

}
