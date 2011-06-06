package com.sap.furcas.ide.editor.contentassist.processor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Fails after the EMF migration. Failing for unknown reasons.")
public class TestCtsContentAssistProcessorRefersToSimple extends CtsContentAssistProcessorEditorTestMetamodelTestBase {

    @BeforeClass
    public static void generateParser() throws Exception {
        initMetamodelTestbase("RefersTo");
    }

    @Before
    public void initProcessor() throws Exception {
        initProcessorForPrefix("Simple");
    }

    @Before
    public void populateModel() {
        // populate model as if the fixture had been parsed
        /*	ReferencePackage refPack = connection
        			.getPackage(ReferencePackage.PACKAGE_DESCRIPTOR);

        	Library lib = (Library) refPack.getLibrary().refCreateInstance();

        	Author henderson = (Author) refPack.getAuthor().refCreateInstance();
        	henderson.setName("henderson");

        	Author obrian = (Author) refPack.getAuthor().refCreateInstance();
        	obrian.setName("obrian");

        	Author rivers = (Author) refPack.getAuthor().refCreateInstance();
        	rivers.setName("rivers");

        	lib.getAuthors().add(henderson);
        	lib.getAuthors().add(obrian);
        	lib.getAuthors().add(rivers);*/

        // no need to supply books as we only test referring to an author
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
        expected.add("henderson");
        expected.add("obrian");
        expected.add("rivers");

        assertDisplayStrings(expected, 3, 11);
    }

    @Test
    public void insideBookInsideAuthor() {
        List<String> expected = new ArrayList<String>();
        expected.add("obrian");

        assertDisplayStrings(expected, 3, 14);
    }
}
