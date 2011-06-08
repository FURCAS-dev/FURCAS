package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCtsContentAssistProcessorAlternativeIsMultiSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("AlternativeIsMulti");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Test
    public void beginningOfFile() {
        List<String> expected = new ArrayList<String>();
        expected.add("library");
        expected.add("library { }");

        // isMulti Alternatives are optional, should not come up
        // with template proposals

        assertDisplayStrings(expected, 0, 0);
    }

    @Test
    public void afterOpeningBracket() {
        List<String> expected = new ArrayList<String>();
        expected.add("author");
        expected.add("author name ;");
        expected.add("book");
        expected.add("book title ;");
        expected.add("}");

        assertDisplayStrings(expected, 1, 0);
    }

    @Test
    public void inBookAlternativeAfterFirstKeyword() {
        List<String> expected = new ArrayList<String>();
        expected.add("title");

        assertDisplayStrings(expected, 4, 6);
    }

    @Test
    public void inAuthorAlternativeAfterFirstKeyword() {
        List<String> expected = new ArrayList<String>();
        expected.add("name");

        assertDisplayStrings(expected, 5, 8);
    }

    @Test
    public void inAlternativeAfterFirstEntry() {
        List<String> expected = new ArrayList<String>();

        // isMulti allows the same content after one alternative

        expected.add("author");
        expected.add("author name ;");
        expected.add("book");
        expected.add("book title ;");
        expected.add("}");

        assertDisplayStrings(expected, 6, 0);
    }
}
