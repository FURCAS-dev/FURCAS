package com.sap.mi.textual.parsing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.parsergenerator.testutils.ResolutionBeanHelper;
import com.sap.furcas.parsergenerator.testutils.StringListHelper;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.test.util.EcoreMetaLookUp;


public class BibTextMetaLookUpTest {

    static EcoreMetaLookUp lookup;

    @BeforeClass
    public static void init() throws Exception {
        
            lookup = new EcoreMetaLookUp("BibText.ecore", "BibText1.ecore");
            
        
        assert lookup != null;
        
    }
    
    private IMetaModelLookup<Object> getLookup() {
      
        return lookup;

    }
	
	@Test
	public void testGetClasses() throws Exception {
		IMetaModelLookup<Object> lookup = getLookup();
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
		assertNull(lookup.resolveReference(null));			
	}
	

	@Test
	public void testGetMultiplicity() throws Exception {
		IMetaModelLookup lookup = getLookup();
		assertNotNull(lookup);
		
		assertEquals(true, lookup.getMultiplicity(ResolutionBeanHelper.refE("BibText", "BibTextFile"), "entries").isOptional());
		assertEquals(true, lookup.getMultiplicity(ResolutionBeanHelper.refE("BibText", "BibTextFile"), "entries").isMultiple());
		assertEquals(false, lookup.getMultiplicity(ResolutionBeanHelper.refE("BibText", "Article"), "author").isOptional());
		assertEquals(false, lookup.getMultiplicity(ResolutionBeanHelper.refE("BibText", "Article"), "author").isMultiple());
		assertNull(lookup.getMultiplicity(ResolutionBeanHelper.refE("blabla"), "xyz"));
	}
	
	@Test
	public void testGetTypeClass() throws Exception {
		IMetaModelLookup lookup = getLookup();
		assertNotNull(lookup);
		
		assertEquals(ResolutionBeanHelper.refE("BibText", "BibTextEntry"), lookup.getFeatureClassReference(ResolutionBeanHelper.refE("BibText", "BibTextFile"), "entries"));
		assertEquals(ResolutionBeanHelper.refE("BibText", "Author"), lookup.getFeatureClassReference(ResolutionBeanHelper.refE("BibText", "Article"), "author"));
	}
	
}
