package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.ide.editor.test.utils.StringReplacement;

public class TestCtsContentAssistProcessorUnlexedTokenPrefixFilterStartOfFileSimple extends
        CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("UnlexedTokenPrefixFilterStartOfFile");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple", new StringReplacement(0, 0, "-</!"));
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("*(?=|");
        expected.add("*(?=| name");
        expected.add("-</!^>");
        expected.add("-</!^> name");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void middleOfNonIdentifierTokenAtStartOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("-</!^>");
        expected.add("-</!^> name");

        assertDisplayStrings(expected, 0, 3);
    }
}
