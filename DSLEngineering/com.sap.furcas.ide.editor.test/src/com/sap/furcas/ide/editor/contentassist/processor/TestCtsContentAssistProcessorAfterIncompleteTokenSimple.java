package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.ide.editor.test.utils.StringReplacement;

public class TestCtsContentAssistProcessorAfterIncompleteTokenSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("AfterIncompleteToken");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple", new StringReplacement(0, 0, "stu"));
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student name");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void afterIncompleteToken() {
        List<String> expected = new ArrayList<String>();
        expected.add("student");
        expected.add("student name");

        assertDisplayStrings(expected, 0, 3);
    }
}
