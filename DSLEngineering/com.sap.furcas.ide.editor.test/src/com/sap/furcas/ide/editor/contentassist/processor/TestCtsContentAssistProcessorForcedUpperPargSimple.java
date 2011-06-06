package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorForcedUpperPargSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("ForcedUpperParg");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("library");
        expected.add("library { author }");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void atForcedUpperProperty() {
        List<String> expected = new ArrayList<String>();
        expected.add("name");
        expected.add("}");

        assertDisplayStrings(expected, 0, 17);
    }

    @Test
    public void afterForcedUpperProperty() {
        List<String> expected = new ArrayList<String>();
        // should not list name again
        expected.add("}");

        assertDisplayStrings(expected, 0, 23);
    }
}
