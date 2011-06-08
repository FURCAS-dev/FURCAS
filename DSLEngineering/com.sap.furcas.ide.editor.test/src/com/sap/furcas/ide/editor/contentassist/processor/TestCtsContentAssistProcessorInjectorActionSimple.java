package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorInjectorActionSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("InjectorAction");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student name");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void afterStudentKeyword() {
        List<String> expected = new ArrayList<String>();
        expected.add("name");

        assertDisplayStrings(expected, 0, 8);
    }
}
