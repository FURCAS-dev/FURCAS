package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Not yet ported to referenceBy and lookupScope")
public class TestCtsContentAssistProcessorQueryAndRefersToSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("QueryAndRefersTo");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfBook() {
        List<String> expected = new ArrayList<String>();
        expected.add("title");
        expected.add("title by author");
        expected.add("}");

        assertDisplayStrings(expected, 3, 0);
    }

    @Test
    public void insideBookBeginningOfAuthor() {
        List<String> expected = new ArrayList<String>();
        expected.add("author");
        expected.add("hegel");

        // only hegel should return from query

        assertDisplayStrings(expected, 3, 11);
    }

    @Test
    public void insideBookInsideAuthor() {
        List<String> expected = new ArrayList<String>();
        expected.add("hegel");

        assertDisplayStrings(expected, 3, 13);
    }
}
