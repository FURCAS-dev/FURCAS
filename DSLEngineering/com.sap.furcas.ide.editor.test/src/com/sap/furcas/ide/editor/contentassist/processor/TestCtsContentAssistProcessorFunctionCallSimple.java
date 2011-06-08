package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorFunctionCallSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("FunctionCall");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("moody_student");
        expected.add("moody_student name");
        expected.add("normal_student");
        expected.add("normal_student name");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void beginningOfFunctionCall() {
        List<String> expected = new ArrayList<String>();
        expected.add("name");

        assertDisplayStrings(expected, 0, 15);
    }

    @Test
    public void insideFunctionCall() {
        List<String> expected = new ArrayList<String>();

        assertDisplayStrings(expected, 0, 17);
    }
}
