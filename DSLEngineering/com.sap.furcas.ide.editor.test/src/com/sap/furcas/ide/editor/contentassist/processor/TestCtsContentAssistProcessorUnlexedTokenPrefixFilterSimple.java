package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.ide.editor.test.utils.StringReplacement;

@Ignore("Fails after the EMF migration. Failing for unknown reasons.")
public class TestCtsContentAssistProcessorUnlexedTokenPrefixFilterSimple extends
        CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser()throws Exception {
        initMetamodelTestbase("UnlexedTokenPrefixFilter");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple", new StringReplacement(0, 0, "*(?=| peter $$"));
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("*(?=|");
        expected.add("*(?=| name $$$");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void beforeNonIdentifierToken() {
        List<String> expected = new ArrayList<String>();
        expected.add("$$$");

        assertDisplayStrings(expected, 0, 12);
    }

    @Test
    public void middleOfNonIdentifierToken() {
        List<String> expected = new ArrayList<String>();
        expected.add("$$$");

        assertDisplayStrings(expected, 0, 13);
    }
}
