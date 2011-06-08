package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorSeparatorSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("Separator");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void afterSeparator() {
        List<String> expected = new ArrayList<String>();
        expected.add("title");

        assertDisplayStrings(expected, 0, 15);
    }

    @Test
    public void beforeSeparator() {
        List<String> expected = new ArrayList<String>();
        expected.add(";");
        expected.add("}");

        assertDisplayStrings(expected, 0, 18);
    }
}
