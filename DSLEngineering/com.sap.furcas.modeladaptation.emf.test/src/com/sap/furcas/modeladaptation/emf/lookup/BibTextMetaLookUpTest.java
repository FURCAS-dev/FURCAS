package com.sap.furcas.modeladaptation.emf.lookup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.test.fixture.FixtureData;
import com.sap.furcas.test.testutils.ResolutionBeanHelper;
import com.sap.furcas.test.testutils.StringListHelper;

public class BibTextMetaLookUpTest {

    static FileBasedEcoreMetaModelLookUp lookup;

    @BeforeClass
    public static void init() throws Exception {
        lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL);
        assert lookup != null;

    }

    @Test
    public void testGetClasses() throws Exception {
        assertNotNull(lookup);
        assertNotNull(lookup.resolveReference(StringListHelper.list("BibText", "BibTextFile")));
        assertNotNull(lookup.resolveReference(StringListHelper.list("BibText", "BibTextEntry")));
        assertNotNull(lookup.resolveReference(StringListHelper.list("BibText", "Article")));
        assertNotNull(lookup.resolveReference(StringListHelper.list("BibText", "Author")));
        assertNotNull(lookup.resolveReference(StringListHelper.list("BibText", "Attribute")));
        assertNotNull(lookup.resolveReference(StringListHelper.list("BibText", "Year")));
        assertNotNull(lookup.resolveReference(StringListHelper.list("BibText", "LocatedElement")));

        assertNull(lookup.resolveReference(StringListHelper.list("BibText", "Classifier")));
        assertNull(lookup.resolveReference(StringListHelper.list("BibText", "XYZ")));
        assertNull(lookup.resolveReference(StringListHelper.list("BibText", "Year123")));
        assertNull(lookup.resolveReference(StringListHelper.list("")));
    }

    @Test
    public void testGetMultiplicity() throws Exception {
        assertNotNull(lookup);

        assertEquals(true, lookup.getMultiplicity(ResolutionBeanHelper.refE("BibText", "BibTextFile"), "entries").isOptional());
        assertEquals(true, lookup.getMultiplicity(ResolutionBeanHelper.refE("BibText", "BibTextFile"), "entries").isMultiple());
        assertEquals(false, lookup.getMultiplicity(ResolutionBeanHelper.refE("BibText", "Article"), "author").isOptional());
        assertEquals(false, lookup.getMultiplicity(ResolutionBeanHelper.refE("BibText", "Article"), "author").isMultiple());
        assertNull(lookup.getMultiplicity(ResolutionBeanHelper.refE("blabla"), "xyz"));
    }

    @Test
    public void testGetTypeClass() throws Exception {
        assertNotNull(lookup);

        assertEquals(ResolutionBeanHelper.refE("BibText", "BibTextEntry"),
                lookup.getFeatureClassReference(ResolutionBeanHelper.refE("BibText", "BibTextFile"), "entries"));
        assertEquals(ResolutionBeanHelper.refE("BibText", "Author"),
                lookup.getFeatureClassReference(ResolutionBeanHelper.refE("BibText", "Article"), "author"));
    }

}
