package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Failing after the EMF migration. Failing for unknown reasons")
public class TestCtsContentAssistProcessorOperatorTemplatelBracketSequence extends
        CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("OperatorTemplate");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("BracketSequence");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("value");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void afterBracket() {
        List<String> expected = new ArrayList<String>();
        expected.add("bracket");
        expected.add("bracket value ]");

        assertDisplayStrings(expected, 0, 4);
    }

    @Test
    public void inBracketAfterExpression() {
        List<String> expected = new ArrayList<String>();
        expected.add("*");
        expected.add("+");
        expected.add("-");
        expected.add("/");
        expected.add("[");
        expected.add("]");
        expected.add("^^");
        expected.add("sqrt");

        assertDisplayStrings(expected, 0, 13);
    }
}
