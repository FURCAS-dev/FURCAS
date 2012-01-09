package com.sap.furcas.runtime.parser.incremental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.incremental.testbase.IncrementalParserBasedTest;
import com.sap.furcas.test.fixture.ScenarioFixtureData;
import com.sap.ide.cts.parser.incremental.IncrementalParserFacade;

/**
 * Test actions that the incremental parser might encounter within an editor environment.
 * 
 * In the focus of these tests are optional syntax elements implemented via {@link Alternative}s
 * or {@link ConditionalElement}s.
 * 
 * @author Stephan Erb
 */
public class TestAlternativeParsingScenarios extends IncrementalParserBasedTest {

    private static final String LANGUAGE = "BibtexWithAlternatives";
    private static final File TCS = new File("fixtures/BibtexWithAlternatives.tcs");
    private static final File[] METAMODELS = { ScenarioFixtureData.BIBTEXT_METAMODEL, ScenarioFixtureData.BIBTEXT1_METAMODEL };


    @BeforeClass
    public static void setupParser() throws Exception {
        setupParser(LANGUAGE, TCS, METAMODELS);
    }

    protected ParsingResult triggerParserAndExpectReuse() {
        ParsingResult result = super.triggerParser();
        // Within this testclass we expect full re-use of all root elements
        if (result.oldRoot != null) {
            assertEquals(result.oldRoot, result.newRoot);
        }
        return result;
    }
    
    @Test
    public void testInitialParse() throws Exception {
        model.replace(0, 0, "Library: Foo Entries:{}");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * Change name from Foo to Bar
     */
    @Test
    public void testChangeOptionalProperty() throws Exception {
        model.replace(0, 0, "Library: Foo Entries:{}");
        triggerParserAndExpectReuse();
        assertEquals("Foo", get(getLibrary(), "name"));
        
        model.replace("Library: ".length(), "Foo".length(), "Bar");
        triggerParserAndExpectReuse();
        assertEquals("Bar", get(getLibrary(), "name"));
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * Change name from nothing to Foo.
     * Expect that the propertyInit on hasName is executed.
     */
    @Test
    public void testSetOptionalProperty() throws Exception {
        model.replace(0, 0, "Library: Entries:{}");
        triggerParserAndExpectReuse();
        assertFalse("Should not be considered set", isSet(getLibrary(), "name"));
        assertEquals(false, get(getLibrary(), "hasName"));
        
        model.replace("Library:".length(), "".length(), "NewName");
        triggerParserAndExpectReuse();
        assertEquals("NewName", get(getLibrary(), "name"));
        assertTrue("Should be considered set", isSet(getLibrary(), "name"));
        assertEquals(true, get(getLibrary(), "hasName"));

        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * Change name from Foo to nothing.
     * Expect that the propertyInit on hasName is executed.
     */
    @Test
    public void testUnsetOptionalProperty() throws Exception {
        model.replace(0, 0, "Library: Foo Entries:{}");
        triggerParserAndExpectReuse();
        assertEquals("Foo", get(getLibrary(), "name"));
        assertTrue("Should be considered set", isSet(getLibrary(), "name"));
        assertEquals(true, get(getLibrary(), "hasName"));
        
        model.replace("Library: ".length(), "Foo".length(), "");
        triggerParserAndExpectReuse();
        assertEquals(false, get(getLibrary(), "hasName"));
        assertFalse("Should no longer be considered set", isSet(getLibrary(), "name"));
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * Remove several authors. Author are represented using TextBlocks.
     */
    @Test
    public void testUnsetMultiValuelProperty() throws Exception {
        model.replace(0, 0, "Library: Entries:{ Karl Gustav Peter }");
        triggerParserAndExpectReuse();
        assertEquals("Expect the authors", 3, getCollection(getLibrary(), "entries").size());
        
        model.replace("Library: Entries:{".length(), " Karl Gustav Peter ".length(), "");
        triggerParserAndExpectReuse();
        assertEquals("Authors should be gone", 0, getCollection(getLibrary(), "entries").size());
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * Remove several authors. Author are represented using TextBlocks.
     * 
     * Same as above but this time force the deletion by switching to an
     * alternative which can only be used if there are no authors at all. 
     */
    @Test
    public void testUnsetOptionalMultiValuelProperty() throws Exception {
        model.replace(0, 0, "Library: Entries:{ Karl Gustav Peter }");
        triggerParserAndExpectReuse();
        assertEquals("Expect the authors", 3, getCollection(getLibrary(), "entries").size());
        
        model.replace("Library: ".length(), "Entries:{ Karl Gustav Peter }".length(), "");
        triggerParserAndExpectReuse();
        assertEquals("Authors should be gone", 0, getCollection(getLibrary(), "entries").size());
        
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
    }
    
    /**
     * There are alternative ways to represent an author.
     * Switch between these and always expect that the author object is reused.
     */
    @Test
    public void testSwitchAlternative() throws Exception {
        model.replace(0, 0, "Library: Entries:{ MyAuthor }");
        triggerParserAndExpectReuse();
        
        EObject author = getFirstEntry();
        assertEquals("MyAuthor", get(author, "name"));
        
        model.replace("Library: Entries:{ ".length(), "MyAuthor".length(), "alternative");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertFalse("Name not set in chosen alternative", isSet(author, "name"));
        
        // No switch back to the alternative with a name
        model.replace("Library: Entries:{ ".length(), "alternative".length(), "SameAuthorNewName");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertEquals("SameAuthorNewName", get(author, "name"));
    }
    
    /**
     * There are alternative ways to represent an author.
     * Switch between these and always expect that the author object is reused.
     * 
     * Same as above but we do now switch between alternatives on different
     * nesting levels.
     */
    @Test
    public void testSwitchNestedAlternative() throws Exception {
        model.replace(0, 0, "Library: Entries:{ MyAuthor }");
        triggerParserAndExpectReuse();
        
        EObject author = getFirstEntry();
        assertEquals("MyAuthor", get(author, "name"));
        
        // Switch to a nested alternative
        model.replace("Library: Entries:{ ".length(), "MyAuthor".length(), "nestedAlternativeA");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertFalse("Name not set in chosen alternative", isSet(author, "name"));
        
        // Switch to another nested alternative
        model.replace("Library: Entries:{ ".length(), "nestedAlternativeA".length(), "nestedAlternativeB");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertFalse("Name not set in chosen alternative", isSet(author, "name"));
        
        // No switch back to the outer alternative with a name
        model.replace("Library: Entries:{ ".length(), "nestedAlternativeB".length(), "SameAuthorNewName");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertEquals("SameAuthorNewName", get(author, "name"));
    }
    
    /**
     * There are alternative ways to represent an author.
     * Switch between these and always expect that the author object is reused.
     * 
     * Same as above but we do now switch between alternatives on different
     * nesting levels and of different types (alternatives and isDefined clauses).
     */
    @Test
    public void testSwitchNestedIsDefined() throws Exception {
        model.replace(0, 0, "Library: Entries:{ MyAuthor }");
        triggerParserAndExpectReuse();
        
        EObject author = getFirstEntry();
        assertEquals("MyAuthor", get(author, "name"));
        
        // Switch to a nested alternative in an isDefined
        model.replace("Library: Entries:{ ".length(), "".length(), "nested name ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertEquals("Name should be the same", "MyAuthor", get(author, "name"));
        
        // Switch to another nested alternative within the other isDefined clause
        model.replace("Library: Entries:{ nested ".length(), "name MyAuthor".length(), "keywordA");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertFalse("Name not set in chosen alternative", isSet(author, "name"));
        
        // Switch to back to the previous isDefined clause
        model.replace("Library: Entries:{ nested ".length(), "keywordA".length(), "name MyAuthor");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertEquals("Name should be the same", "MyAuthor", get(author, "name"));
        
        // Switch to yet another nested alternative which lies outside of the isDefined.
        model.replace("Library: Entries:{ ".length(), "nested name MyAuthor".length(), "nestedAlternativeB");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertFalse("Name not set in chosen alternative", isSet(author, "name"));
        
        // No switch back to the outer alternative with a name
        model.replace("Library: Entries:{ ".length(), "nestedAlternativeB".length(), "SameAuthorNewName");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertEquals("SameAuthorNewName", get(author, "name"));
    }
    
    /**
     * There are alternative ways to represent an author.
     * Switch between these and always expect that the author object is reused.
     * 
     * Same as above but we do now switch between alternatives on different
     * nesting levels and of different types (alternatives and isDefined clauses).
     */
    @Test
    public void testSwitchNestedIsDefinedNoElse() throws Exception {
        model.replace(0, 0, "Library: Entries:{ MyAuthor }");
        triggerParserAndExpectReuse();
        
        EObject author = getFirstEntry();
        assertEquals("MyAuthor", get(author, "name"));
        
        // Don't enable the isDefined
        model.replace("Library: Entries:{ ".length(), "MyAuthor".length(), "noElse");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertFalse("Name not set in chosen alternative", isSet(author, "name"));
        
        // Switch to the then clause of the isDefined
        model.replace("Library: Entries:{ ".length(), "".length(), "name MyAuthor ");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertEquals("Name should be the same", "MyAuthor", get(author, "name"));
        
        // Switch to back out of the then block (there is no else block)
        model.replace("Library: Entries:{ ".length(), "name MyAuthor".length(), "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertSame("Author object should have been re-used", author, getFirstEntry());
        assertFalse("Name not set in chosen alternative", isSet(author, "name"));
    }
    
    /**
     * Switch between alternatives but with an intermediate delete.
     * No reuse expected (this is just to assure that our reuse check works...)
     */
    @Test
    public void testSwitchAlternativeWithoutReuse() throws Exception {
        model.replace(0, 0, "Library: Entries:{ MyAuthor }");
        triggerParserAndExpectReuse();
        
        EObject author = getFirstEntry();
        assertEquals("MyAuthor", get(author, "name"));
        
        model.replace("Library: Entries:{ ".length(), "MyAuthor".length(), "");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertNull("Author object should be gone", getFirstEntry());
        
        model.replace("Library: Entries:{ ".length(), "".length(), "alternative");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertFalse("Author should have been recreated", author.equals(getFirstEntry()));
        assertFalse("Name not set in chosen alternative", isSet(author, "name"));
    }
    
    /**
     * Replace an author with an entry.
     */
    @Test
    public void testReplaceWithModelElementOfDifferentType() throws Exception {
        model.replace(0, 0, "Library: Entries:{ Author }");
        triggerParserAndExpectReuse();
        
        EObject author = getFirstEntry();
        EClass authorEntryType = author.eClass();
         
        model.replace("Library: Entries:{ ".length(), "Author".length(), "article");
        triggerParserAndExpectReuse();
        assertTrue(model.getRoot().getVersion() == Version.REFERENCE);
        
        assertFalse("Types should be different", authorEntryType.equals(getFirstEntry().eClass()));
        assertFalse("No reuse for different types expected", author.equals(getFirstEntry()));
    }
    
    private Object get(EObject obj, String name) {
        return obj.eGet(obj.eClass().getEStructuralFeature(name));
    }
    
    private Collection<?> getCollection(EObject obj, String name) {
        return (Collection<?>) obj.eGet(obj.eClass().getEStructuralFeature(name));
    }
    
    private boolean isSet(EObject obj, String name) {
        return obj.eIsSet(obj.eClass().getEStructuralFeature(name));
    }
    
    private EObject getLibrary() {
        return IncrementalParserFacade.getParsingResult(model.getRoot());
    }
    
    private EObject getFirstEntry() {
        Collection<?> col = getCollection(getLibrary(), "entries");
        if (col.isEmpty()) {
            return null;
        }
        return (EObject) getCollection(getLibrary(), "entries").iterator().next();
    }
    
}
