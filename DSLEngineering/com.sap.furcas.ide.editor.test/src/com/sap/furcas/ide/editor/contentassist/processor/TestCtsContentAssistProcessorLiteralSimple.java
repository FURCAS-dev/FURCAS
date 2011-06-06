package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorLiteralSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("Literal");

    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("library");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void middleOfLiteral() {
        List<String> expected = new ArrayList<String>();
        expected.add("library");

        assertDisplayStrings(expected, 0, 3);
    }
}
