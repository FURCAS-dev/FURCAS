package com.sap.runlet.abstractexpressionpad.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaTestCaseBuilder {

    public static String buildTestCase(List<String> history) {
	StringBuilder sb = new StringBuilder(1024);
	sb.append("    public void test() throws Exception {\n");
	sb.append("        ExecuteResult executeResult = main.execute(\n");
	List<String> statements = new ArrayList<String>(history.size());
	for (String stmnt : history) {
	    if (!stmnt.startsWith("!")) {
		statements.add(stmnt);
	    }
	}
	int countDown = statements.size();
	Collections.reverse(statements);
	for (String stmnt : statements) {
	    --countDown;
	    // skip inspection commands
	    sb.append("            \"");
	    sb.append(stmnt.replace("\"", "\\\""));
	    sb.append('"');
	    if (!(countDown == 0)) {
		sb.append(",\n");
	    }
	}
	sb.append(");\n");
	sb.append("        RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition>[] result = executeResult.getResult();\n");
	sb.append("        String[]      errors = executeResult.getErrors();\n");
	sb.append("        assertEquals(").append(statements.size()).append(", result.length);\n");
	sb.append("        assertEquals(0, errors.length);\n");
	sb.append("    }\n");
	return sb.toString();
    }

}
