package com.sap.mi.textual.moinlookup;

import static com.sap.mi.textual.test.util.ResolutionBeanHelper.refM;
import static com.sap.mi.textual.test.util.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import tcs.TcsPackage;

import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.furcas.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.ide.cts.editor.test.util.ProjectConnectionBasedTest;
import com.sap.mi.textual.test.util.MOINContainerNameLookUpFactory;
import com.sap.mi.textual.test.util.StringListHelper;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TestMoinLookUp extends ProjectConnectionBasedTest{

	private static Connection connection;

	private static IMetaModelLookup<RefObject> lookup = null;

	@BeforeClass
	public static void setup() throws Exception {	
        
        lookup = MOINContainerNameLookUpFactory.getMOINContainerNameLookUpFactory(TcsPackage.PACKAGE_DESCRIPTOR.getModelContainerName() );
//		Field partitionScopeProviderField = AbstractQueryBasedMoinMetaLookUp.class
//				.getDeclaredField("partitionScopeProvider");
//		partitionScopeProviderField.setAccessible(true);
//		PartitionScopeProviderStub partitionScopeProviderStub = new PartitionScopeProviderStub();
//		partitionScopeProviderStub.addPri(PartitionService.getInstance()
//				.getPri(	"MetaModelDataArea",
//						TcsPackage.PACKAGE_DESCRIPTOR
//								.getModelContainerName(),
//						"moin/meta/Metamodel.moinmm"));
//		partitionScopeProviderField.set(lookup, partitionScopeProviderStub);
	}

	@AfterClass
	public static void tearDown2() {
	    if (lookup != null ) {
	        lookup.close();
	    }
	    if (connection != null && connection.isAlive()) {
			connection.close();
		}
	}

	private IMetaModelLookup<RefObject> getLookup() {

		return lookup;

	}
	
	@Test
    public void testGetPrimitiveClasses() throws Exception {
        IMetaModelLookup<?> lookup = getLookup();
        assertNotNull(lookup);
        // failure here indicates that the PRI for PrimitiveTypes has not been included in query
        assertNotNull(lookup.resolveReference(list("PrimitiveTypes", "String")));
        assertNotNull(lookup.resolveReference(list("PrimitiveTypes", "Integer")));
        assertNotNull(lookup.resolveReference(list("PrimitiveTypes", "Boolean")));
	}

	@Test
	public void testGetClasses() throws Exception {
		IMetaModelLookup<?> lookup = getLookup();
		assertNotNull(lookup);
		assertNotNull(lookup.resolveReference(list("TCS",
				"ConcreteSyntax")));
		assertNotNull(lookup.resolveReference(list("TCS",
				"Template")));
		assertNotNull(lookup.resolveReference(list("TCS",
				"Keyword")));
		assertNotNull(lookup.resolveReference(StringListHelper
				.list("TCS", "ClassTemplate")));
		assertNotNull(lookup.resolveReference(list("TCS",
				"Token")));
		assertNotNull(lookup.resolveReference(list("TCS", "PrimitiveTemplate")));
		assertNotNull(lookup.resolveReference(list("TCS",
				"LocatedElement")));

		assertNull(lookup.resolveReference(list("TCS",
				"Classifier")));
		assertNull(lookup.resolveReference(list("TCS", "XYZ")));
		assertNull(lookup.resolveReference(list("TCS",
				"Year123")));
		assertNull(lookup.resolveReference(list("")));
		//assertFalse(lookup.resolveReference(null));
	}

	@Test
	public void testHasFeature() throws Exception {
		IMetaModelLookup<RefObject> lookup = getLookup();
		assertNotNull(lookup);

		assertNotNull(lookup.getMultiplicity(refM("TCS",
				"ConcreteSyntax"), "k"));
		assertNull(lookup.getMultiplicity(refM("TCS",
				"Template"), "something"));
	}

	
	@Test
    public void testGetDirectSubTypes() throws Exception {
        IMetaModelLookup<RefObject> lookup = getLookup();
        assertNotNull(lookup);

        List<ResolvedNameAndReferenceBean<RefObject>> subTypes = new ArrayList<ResolvedNameAndReferenceBean<RefObject>>();
        subTypes.add(refM("TCS", "FunctionTemplate"));
        subTypes.add(refM("TCS", "ClassTemplate"));
        subTypes.add(refM("TCS", "PrimitiveTemplate"));
        subTypes.add(refM("TCS", "OperatorTemplate"));
        subTypes.add(refM("TCS", "EnumerationTemplate"));
        assertEquals(subTypes, lookup.getDirectSubTypes(refM("TCS",
                "Template")));
        
    }

	@Test
	public void testHasFeatureForAssociationEnds() throws Exception {
		IMetaModelLookup<RefObject> lookup = getLookup();
		assertNotNull(lookup);
		
		assertNotNull(lookup.getMultiplicity(refM("TCS",
				"Template"), "concreteSyntax"));
		assertNull(lookup.getMultiplicity(refM("TCS",
				"Template"), "entriesXYZ"));
	}

	@Test
	public void testGetMultiplicity() throws Exception {
		IMetaModelLookup<RefObject> lookup = getLookup();
		assertNotNull(lookup);

		assertNotNull(lookup.getMultiplicity(
		        refM("TCS", "ConcreteSyntax"), "templates"));
		assertEquals(true, lookup.getMultiplicity(
		        refM("TCS", "ConcreteSyntax"), "templates")
				.isOptional());
		assertEquals(true, lookup.getMultiplicity(
		        refM("TCS", "ConcreteSyntax"), "templates")
				.isMultiple());
		assertEquals(false, lookup.getMultiplicity(
		        refM("TCS", "ClassTemplate"), "isMain")
				.isOptional());
		assertEquals(false, lookup.getMultiplicity(
		        refM("TCS", "ClassTemplate"), "isMain")
				.isMultiple());
		assertNull(lookup.getMultiplicity(refM("blabla"),
				"xyz"));
	}

	@Test
	public void testGetTypeClass() throws Exception {
		IMetaModelLookup<RefObject> lookup = getLookup();
		assertNotNull(lookup);

		assertEquals(refM("TCS", "Template"), lookup
				.getFeatureClassReference(refM("TCS",
						"ConcreteSyntax"), "templates"));
		assertEquals(refM("TCS", "Sequence"), lookup
				.getFeatureClassReference(refM("TCS", "ClassTemplate"), "templateSequence"));
	      assertEquals(refM("PrimitiveTypes", "String"), lookup
	                .getFeatureClassReference(refM("TCS", "ConcreteSyntax"), "lexer"));
	}
	
	@Test
	public void testGetEnumLiterals() throws Exception {
		IMetaModelLookup<RefObject> lookup = getLookup();
		assertNotNull(lookup);

		List<String> literals = lookup.getEnumLiterals(
		        refM("TCS", "Associativity"));
		assertNotNull(literals);
		assertEquals(2, literals.size());
		assertEquals("right", literals.get(0));
		assertEquals("left", literals.get(1));
		
	}

    @Override
    public InputStream getProjectContentAsStream() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getProjectName() {
        // TODO Auto-generated method stub
        return "MoinLookUpTest";
    }

}
