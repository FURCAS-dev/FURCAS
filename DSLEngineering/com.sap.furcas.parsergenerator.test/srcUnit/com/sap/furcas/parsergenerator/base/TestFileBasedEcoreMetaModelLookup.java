/**
 * 
 */
package com.sap.furcas.parsergenerator.base;

import static com.sap.furcas.test.parsing.testutils.ResolutionBeanHelper.refE;
import static com.sap.furcas.test.parsing.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;

import com.sap.furcas.parsergenerator.emf.lookup.FileBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.test.scenario.FixtureData;

/**
 * Tests the Ecore based lookup class that is used for testing, prerequisite for scenario tests (!).
 */
public class TestFileBasedEcoreMetaModelLookup {

    @Test
    public void testIsClassNameWithBibText() throws Exception {
        FileBasedEcoreMetaModelLookUp lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL);
        assertNotNull(lookup.resolveReference(list("BibText", "Article")));
        assertNotNull(lookup.resolveReference(list("BibText", "Author")));
        assertNotNull(lookup.resolveReference(list("BibText", "BibTextFile")));
        assertNotNull(lookup.resolveReference(list("BibText", "BibTextEntry")));
        assertNotNull(lookup.resolveReference(list("PrimitiveTypes", "String"))); // important

        assertNull(lookup.resolveReference(list("Article2")));
        assertNull(lookup.resolveReference(list("BibText2", "Article")));
        assertNull(lookup.resolveReference(list("BibTex", "Article")));
        assertNull(lookup.resolveReference(list("Artice")));
        assertNull(lookup.resolveReference(list("Autho")));
    }

    @Test
    public void testIsSubtypeWithBibText() throws Exception {
        FileBasedEcoreMetaModelLookUp lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL);
        assertTrue(lookup.isSubTypeOf(refE("BibText", "Article"), refE("BibText", "Article")));
        assertTrue(lookup.isSubTypeOf(refE("BibText", "Article"), refE("BibText", "BibTextEntry")));
        assertTrue(lookup.isSubTypeOf(refE("BibText", "Author"), refE("BibText", "BibTextEntry")));
        assertTrue(lookup.isSubTypeOf(refE("BibText", "BibTextEntry"), refE("BibText", "BibTextEntry")));
        assertTrue(lookup.isSubTypeOf(refE("BibText", "Year"), refE("BibText", "Attribute")));

        assertFalse(lookup.isSubTypeOf(refE("BibText", "Article"), refE("BibText", "Author")));
        assertFalse(lookup.isSubTypeOf(refE("BibText", "Author"), refE("BibText", "Article")));
        assertFalse(lookup.isSubTypeOf(refE("BibText", "BibTextEntry"), refE("BibText", "Article")));
        assertFalse(lookup.isSubTypeOf(refE("BibText", "Attribute"), refE("BibText", "Year")));
        assertFalse(lookup.isSubTypeOf(refE("BibText", "Year"), refE("BibText", "Article")));
        assertFalse(lookup.isSubTypeOf(refE("BibText", "Article"), refE("BibText", "Attribute")));

    }

    @Test
    public void testMultiWithBibText() throws Exception {
        FileBasedEcoreMetaModelLookUp lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL);
        assertFalse(lookup.getMultiplicity(refE("BibText", "Article"), "author").isOptional());
        assertFalse(lookup.getMultiplicity(refE("BibText", "Article"), "author").isMultiple());
        assertFalse(lookup.getMultiplicity(refE("BibText", "Article"), "key").isMultiple());
        assertFalse(lookup.getMultiplicity(refE("BibText", "Author"), "key").isMultiple());
        assertTrue(lookup.getMultiplicity(refE("BibText", "Author"), "articles").isOptional());
        assertTrue(lookup.getMultiplicity(refE("BibText", "Author"), "articles").isMultiple());
        assertTrue(lookup.getMultiplicity(refE("BibText", "BibTextFile"), "entries").isMultiple());
        assertTrue(lookup.getMultiplicity(refE("BibText", "BibTextEntry"), "attributes").isMultiple());
        assertEquals(5, lookup.getMultiplicity(refE("BibText", "BibTextEntry"), "attributes").getUpperBound());

    }

    @Test
    public void testFeatureClassNameWithBibText() throws Exception {
        FileBasedEcoreMetaModelLookUp lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL);
        assertEquals(refE("BibText", "Author"), lookup.getFeatureClassReference(refE("BibText", "Article"), "author"));
        assertEquals(refE("PrimitiveTypes", "String"), lookup.getFeatureClassReference(refE("BibText", "Article"), "key"));
        assertEquals(refE("PrimitiveTypes", "String"), lookup.getFeatureClassReference(refE("BibText", "Author"), "key"));
        assertEquals(refE("BibText", "Article"), lookup.getFeatureClassReference(refE("BibText", "Author"), "articles"));
        assertEquals(refE("BibText", "BibTextEntry"), lookup.getFeatureClassReference(refE("BibText", "BibTextFile"), "entries"));
        assertEquals(refE("PrimitiveTypes", "String"), lookup.getFeatureClassReference(refE("BibText", "BibTextEntry"), "key"));

        assertNull(lookup.getFeatureClassReference(refE("BibTextEntry"), ""));
        assertNull(lookup.getFeatureClassReference(refE("BibTextEntry"), "key2"));
        assertNull(lookup.getFeatureClassReference(refE("BibTextEntry"), "ke"));
        assertNull(lookup.getFeatureClassReference(refE("BibTextEntry"), null));
    }

    @Test
    public void testSubTypesWithBibText() throws Exception {
        FileBasedEcoreMetaModelLookUp lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.BIBTEXT_METAMODEL, FixtureData.BIBTEXT1_METAMODEL);
        List<ResolvedNameAndReferenceBean<EObject>> result = lookup.getDirectSubTypes(refE("BibText", "BibTextEntry"));
        assertEquals(2, result.size());
        assertTrue(result.contains(refE("BibText", "Article")));
        assertTrue(result.contains(refE("BibText", "Author")));

        assertEquals(list(), lookup.getDirectSubTypes(refE("BibText", "Article")));

        result = lookup.getDirectSubTypes(refE("BibText", "Attribute"));
        assertEquals(1, result.size());
        assertTrue(result.contains(refE("BibText", "Year")));

        assertEquals(list(), lookup.getDirectSubTypes(refE("BibText", "Author")));
    }

    // TODO test with more packages, change above when BibText has packages
    @Test
    public void testSubTypesWithXPath() throws Exception {
        FileBasedEcoreMetaModelLookUp lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.XPATH1_METAMODEL, FixtureData.XPATH_METAMODEL);
        List<ResolvedNameAndReferenceBean<EObject>> result = lookup.getDirectSubTypes(refE("XPath", "LocatedElement"));
        assertEquals(6, result.size());
        assertTrue(result.contains(refE("XPath", "Axis")));
        assertTrue(result.contains(refE("XPath", "Expression")));
        assertTrue(result.contains(refE("XPath", "NamedElement")));

        result = lookup.getDirectSubTypes(refE("XPath", "NodeTest"));
        assertEquals(4, result.size());
        assertTrue(result.contains(refE("XPath", "WildCardTest")));
        assertTrue(result.contains(refE("XPath", "IsTextTest")));

        result = lookup.getDirectSubTypes(refE("XPath", "Axis"));
        assertEquals(13, result.size());
        assertTrue(result.contains(refE("XPath", "ParentAxis")));
        assertTrue(result.contains(refE("XPath", "SelfAxis")));

        result = lookup.getDirectSubTypes(refE("XPath", "Expression"));
        assertEquals(5, result.size());
        assertTrue(result.contains(refE("XPath", "PathExpression")));
        assertTrue(result.contains(refE("XPath", "FunctionCallExp")));
    }

    @Test
    public void testSubTypesWithMultiPackages() throws Exception {
        FileBasedEcoreMetaModelLookUp lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.MULTIPACKAGE_METAMODEL);
        List<ResolvedNameAndReferenceBean<EObject>> result = lookup.getDirectSubTypes(refE("expression", "Expression"));
        assertEquals(3, result.size());
        assertTrue(result.contains(refE("expression", "rightPackage", "BinaryExpression")));
        assertTrue(result.contains(refE("expression", "rightPackage", "ValueExpression")));
        assertTrue(result.contains(refE("expression", "rightPackage", "StringExpression")));
    }

    @Test
    public void testQualifyNamesWithMultiPackages() throws Exception {
        FileBasedEcoreMetaModelLookUp lookup = new FileBasedEcoreMetaModelLookUp(FixtureData.MULTIPACKAGE_METAMODEL);
        List<ResolvedNameAndReferenceBean<EObject>> result = lookup.qualifyName("Expression");
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(refE("expression", "Expression")));

        result = lookup.qualifyName("BinaryExpression");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(refE("expression", "rightPackage", "BinaryExpression")));
        assertTrue(result.contains(refE("expression", "wrongPackage", "BinaryExpression")));

        result = lookup.qualifyName("ValueExpression");
        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(refE("expression", "rightPackage", "ValueExpression")));

        result = lookup.qualifyName("StringExpression");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(refE("expression", "rightPackage", "StringExpression")));
        assertTrue(result.contains(refE("expression", "wrongPackage", "StringExpression")));

        result = lookup.qualifyName("ExpressionList");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(refE("expression", "rightPackage", "ExpressionList")));
        assertTrue(result.contains(refE("expression", "wrongPackage", "ExpressionList")));
    }
}
