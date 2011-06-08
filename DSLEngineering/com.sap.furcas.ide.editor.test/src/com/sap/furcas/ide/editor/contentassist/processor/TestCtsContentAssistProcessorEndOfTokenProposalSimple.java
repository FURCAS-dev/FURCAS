package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorEndOfTokenProposalSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("EndOfTokenProposal");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beforeStudentToken() {
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student { name }");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void inStudentToken() {
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student { name }");

        assertDisplayStrings(expected, 0, 4);
    }

    @Test
    public void atEndOfStudentToken() {
        List<String> expected = new ArrayList<String>();
        expected.add("{");

        assertDisplayStrings(expected, 0, 7);
    }

    @Test
    public void atEndOfBracketToken() {
        List<String> expected = new ArrayList<String>();
        // prefix-filtered tokens should always be at the top
        expected.add("{");
        expected.add("name");

        assertDisplayStrings(expected, 0, 8);
    }

    @Test
    public void atEndOfJonesToken() {
        List<String> expected = new ArrayList<String>();
        expected.add("}");

        assertDisplayStrings(expected, 0, 14);
    }
}
