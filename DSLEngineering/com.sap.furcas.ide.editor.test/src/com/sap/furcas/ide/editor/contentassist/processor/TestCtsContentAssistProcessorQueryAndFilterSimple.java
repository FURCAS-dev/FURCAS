package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.ide.editor.test.utils.StringReplacement;

@Ignore("Not yet ported to referenceBy and lookupScope")
public class TestCtsContentAssistProcessorQueryAndFilterSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("QueryAndFilter");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple", new StringReplacement(4, 0, ";\n\"dubry\" by obrian"));
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
    public void insideBookBeginningOfAuthorParsed() {
        List<String> expected = new ArrayList<String>();
        expected.add("author");
        expected.add("hegel");
        expected.add("henderson");
        expected.add("obrian");

        assertDisplayStrings(expected, 3, 11);
    }

    @Test
    public void insideBookInsideAuthorParsed() {
        List<String> expected = new ArrayList<String>();
        expected.add("hegel");
        expected.add("henderson");

        assertDisplayStrings(expected, 3, 13);
    }

    @Test
    public void insideBookBeginningOfAuthorUnparsed() {
        List<String> expected = new ArrayList<String>();
        expected.add("author");

        assertDisplayStrings(expected, 5, 11);
    }

    @Test
    public void insideBookInsideAuthorUnparsed() {
        List<String> expected = new ArrayList<String>();

        assertDisplayStrings(expected, 5, 13);
    }
}
