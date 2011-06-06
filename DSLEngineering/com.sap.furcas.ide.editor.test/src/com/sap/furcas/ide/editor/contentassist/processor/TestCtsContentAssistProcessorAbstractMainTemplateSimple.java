package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorAbstractMainTemplateSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void init() throws Exception {
        initMetamodelTestbase("AbstractMainTemplate");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("value");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void inNumber() {
        List<String> expected = new ArrayList<String>();

        assertDisplayStrings(expected, 0, 2);
    }
}
