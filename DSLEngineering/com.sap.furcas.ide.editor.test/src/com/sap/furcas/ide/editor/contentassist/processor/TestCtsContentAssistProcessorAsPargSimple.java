package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.ide.editor.test.utils.StringReplacement;

public class TestCtsContentAssistProcessorAsPargSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("AsParg");
    }

    @Before
    public void initProcessor()throws Exception {
        initProcessorForPrefix("Simple", new StringReplacement(0, 0, "{ }"));
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("{");
        // expression is not a valid token, just make sure "value" is not
        // offered
        // from the actual template
        expected.add("{ expression }");

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void afterBracket() {
        List<String> expected = new ArrayList<String>();
        // expression is not a valid token, just make sure "value" is not
        // offered
        // from the actual template
        expected.add("expression");

        assertDisplayStrings(expected, 0, 2);
    }
}
