package com.sap.mi.textual.parsing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.test.util.EcoreMetaLookUp;
import com.sap.mi.textual.test.util.StringListHelper;


public class XPathTextMetaLookUpTest {

	private IMetaModelLookup getLookup() throws Exception {
	    EcoreMetaLookUp lookup = new EcoreMetaLookUp( "XPath.ecore", "XPath1.ecore");
		return lookup;
	}
	
	@Test
	public void testGetClasses() throws Exception {
		IMetaModelLookup lookup = getLookup();
		assertNotNull(lookup);
	
		assertNull(lookup.resolveReference(StringListHelper.list("Classifier")));
		assertNull(lookup.resolveReference(StringListHelper.list("XYZ")));
		assertNull(lookup.resolveReference(StringListHelper.list("Year123")));
		assertNull(lookup.resolveReference(StringListHelper.list("")));
		assertNull(lookup.resolveReference(null));			
	}
	
	@Test
	public void testHasFeature() throws Exception {
		IMetaModelLookup lookup = getLookup();
		assertNotNull(lookup);
		
//		assertTrue(lookup.hasFeature("BibTextFile", "entries"));
//		assertFalse(lookup.hasFeature("BibTextFile", "entriesXYZ"));
	}
	
	@Test
	public void testGetMultiplicity() throws Exception {
		IMetaModelLookup lookup = getLookup();
		assertNotNull(lookup);
		
//		assertEquals(true, lookup.getMultiplicity("BibTextFile", "entries").isOptional());
//		assertEquals(true, lookup.getMultiplicity("BibTextFile", "entries").isUnbounded());
//		assertEquals(false, lookup.getMultiplicity("Article", "author").isOptional());
//		assertEquals(false, lookup.getMultiplicity("Article", "author").isUnbounded());
//		assertNull(lookup.getMultiplicity("blabla", "xyz"));
	}
	
	@Test
	public void testGetTypeClass() throws Exception {
		IMetaModelLookup lookup = getLookup();
		assertNotNull(lookup);
		
//		assertEquals("BibTextEntry", lookup.getFeatureClassName("BibTextFile", "entries"));
//		assertEquals("Author", lookup.getFeatureClassName("Article", "author"));
	}
}
