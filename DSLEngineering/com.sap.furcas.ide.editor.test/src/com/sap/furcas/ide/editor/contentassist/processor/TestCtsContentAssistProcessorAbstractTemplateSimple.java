package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorAbstractTemplateSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("AbstractTemplate");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfLine() {
        List<String> expected = new ArrayList<String>();
        expected.add("employee");
        expected.add("employee nickname");
        expected.add("manager");
        expected.add("manager num_employees");

        assertDisplayStrings(expected, 3, 0);
    }

    @Test
    public void inManagerEntryKeyword() {
        List<String> expected = new ArrayList<String>();
        expected.add("manager");
        expected.add("manager num_employees");

        assertDisplayStrings(expected, 3, 3);
    }

    @Test
    public void inManagerEntryBeforeProperty() {
        List<String> expected = new ArrayList<String>();
        expected.add("num_employees");

        assertDisplayStrings(expected, 3, 8);
    }

    @Test
    public void inEmployeeEntryKeyword() {
        List<String> expected = new ArrayList<String>();
        expected.add("employee");
        expected.add("employee nickname");

        assertDisplayStrings(expected, 4, 1);
    }

    @Test
    public void inEmployeeEntryBeforeProperty() {
        List<String> expected = new ArrayList<String>();
        expected.add("nickname");

        assertDisplayStrings(expected, 4, 9);
    }

    @Test
    public void inEmployeeEntryInProperty() {
        List<String> expected = new ArrayList<String>();

        assertDisplayStrings(expected, 4, 11);
    }
}
