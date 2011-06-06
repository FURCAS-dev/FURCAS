package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorConditionalSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("Conditional");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("evaluated");
        expected.add("expression");
        expected.add("expression { value }");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void inConditional() {
        List<String> expected = new ArrayList<String>();
        expected.add("evaluated");

        assertDisplayStrings(expected, 0, 4);
    }

    @Test
    public void afterConditional() {
        List<String> expected = new ArrayList<String>();
        expected.add("expression");
        expected.add("expression { value }");

        assertDisplayStrings(expected, 0, 10);
    }
}
