package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Failing after the EMF migration. Failing for unknown reasons")
public class TestCtsContentAssistProcessorOperatorMainTemplatelSimple extends
        CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("OperatorMainTemplate");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("value");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void afterFirstExpression() {
        List<String> expected = new ArrayList<String>();
        expected.add("*");
        expected.add("+");
        expected.add("-");
        expected.add("/");
        expected.add("[");
        expected.add("^^");
        expected.add("sqrt");

        assertDisplayStrings(expected, 0, 2);
    }

    @Test
    public void afterOperator() {
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("value");

        assertDisplayStrings(expected, 0, 4);
    }

    @Test
    public void inOperator() {
        List<String> expected = new ArrayList<String>();
        expected.add("^^");

        assertDisplayStrings(expected, 0, 20);
    }
}
