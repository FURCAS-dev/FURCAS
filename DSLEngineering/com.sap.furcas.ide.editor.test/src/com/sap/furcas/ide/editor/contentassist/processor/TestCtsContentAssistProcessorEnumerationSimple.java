package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorEnumerationSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("Enumeration");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void allEnumerationOptions() {
        List<String> expected = new ArrayList<String>();
        expected.add("a_workaholic");
        expected.add("type");
        expected.add("very_lazy");
        expected.add("very_studious");

        assertDisplayStrings(expected, 0, 17);
    }

    @Test
    public void middleOfEnumerationOption() {
        List<String> expected = new ArrayList<String>();
        expected.add("very_lazy");
        expected.add("very_studious");

        assertDisplayStrings(expected, 0, 19);
    }
}
