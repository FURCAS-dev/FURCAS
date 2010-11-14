package com.sap.furcas.modeladaptation.emf.lookup;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.test.fixture.FixtureData;
import com.sap.furcas.test.testutils.StringListHelper;

public class XPathTextMetaLookUpTest {

    static FileBasedEcoreMetaModelLookUp lookup;

    @BeforeClass
    public static void init() throws Exception {
        lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.XPATH_METAMODEL, FixtureData.XPATH1_METAMODEL);
        assert lookup != null;
    }

    @Test
    public void testGetClasses() throws Exception {
        assertNotNull(lookup);

        assertNull(lookup.resolveReference(StringListHelper.list("Classifier")));
        assertNull(lookup.resolveReference(StringListHelper.list("XYZ")));
        assertNull(lookup.resolveReference(StringListHelper.list("Year123")));
        assertNull(lookup.resolveReference(StringListHelper.list("")));
    }

    @Ignore("Commented in moin")
    @Test
    public void testHasFeature() throws Exception {
        // IMetaModelLookup<EObject> lookup = getLookup();
        // assertNotNull(lookup);

        // assertTrue(lookup.hasFeature("BibTextFile", "entries"));
        // assertFalse(lookup.hasFeature("BibTextFile", "entriesXYZ"));
    }

    @Ignore("Commented in moin")
    @Test
    public void testGetMultiplicity() throws Exception {
        // IMetaModelLookup<EObject> lookup = getLookup();
        // assertNotNull(lookup);

        // assertEquals(true, lookup.getMultiplicity("BibTextFile", "entries").isOptional());
        // assertEquals(true, lookup.getMultiplicity("BibTextFile", "entries").isUnbounded());
        // assertEquals(false, lookup.getMultiplicity("Article", "author").isOptional());
        // assertEquals(false, lookup.getMultiplicity("Article", "author").isUnbounded());
        // assertNull(lookup.getMultiplicity("blabla", "xyz"));
    }

    @Ignore("Commented in moin")
    @Test
    public void testGetTypeClass() throws Exception {
        // IMetaModelLookup<EObject> lookup = getLookup();
        // assertNotNull(lookup);

        // assertEquals("BibTextEntry", lookup.getFeatureClassName("BibTextFile", "entries"));
        // assertEquals("Author", lookup.getFeatureClassName("Article", "author"));
    }
}
