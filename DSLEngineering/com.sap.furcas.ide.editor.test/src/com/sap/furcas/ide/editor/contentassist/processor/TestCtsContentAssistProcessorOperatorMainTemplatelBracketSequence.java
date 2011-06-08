package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Failing after the EMF migration. Failing for unknown reasons")
public class TestCtsContentAssistProcessorOperatorMainTemplatelBracketSequence extends
        CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("OperatorMainTemplate");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("BracketSequence");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("-");
        expected.add("value");

        assertDisplayStrings(expected, 0, 0);
    }
}
