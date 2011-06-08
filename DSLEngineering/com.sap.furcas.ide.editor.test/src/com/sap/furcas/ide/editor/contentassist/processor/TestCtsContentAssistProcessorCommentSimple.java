package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorCommentSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("Comment");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beforeFirstTokenInComment() {
        List<String> expected = new ArrayList<String>();
        // no proposals in comment

        assertDisplayStrings(expected, 0, 3);
    }

    @Test
    public void beforeFirstTokenInWhitespace() {
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student name");

        assertDisplayStrings(expected, 1, 1);
    }

    @Test
    public void beforeFirstTokenAfterWhitespace() {
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student name");

        assertDisplayStrings(expected, 1, 3);
    }

    @Test
    public void beforeSecondComment() {
        List<String> expected = new ArrayList<String>();
        expected.add("name");

        assertDisplayStrings(expected, 1, 12);
    }

    @Test
    public void inSecondComment() {
        List<String> expected = new ArrayList<String>();
        // no proposal in comment line

        assertDisplayStrings(expected, 1, 15);
    }

    @Test
    public void beforeSecondKeyword() {
        List<String> expected = new ArrayList<String>();
        expected.add("name");

        assertDisplayStrings(expected, 2, 3);
    }
}
