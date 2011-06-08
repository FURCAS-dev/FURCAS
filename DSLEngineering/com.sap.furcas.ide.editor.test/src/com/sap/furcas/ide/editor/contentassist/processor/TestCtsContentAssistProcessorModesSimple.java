package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorModesSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("Modes");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfAuthor() {
        List<String> expected = new ArrayList<String>();
        expected.add("author");
        expected.add("author name");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void afterAuthorKeyword() {
        List<String> expected = new ArrayList<String>();
        expected.add("name");

        assertDisplayStrings(expected, 0, 7);
    }
}
