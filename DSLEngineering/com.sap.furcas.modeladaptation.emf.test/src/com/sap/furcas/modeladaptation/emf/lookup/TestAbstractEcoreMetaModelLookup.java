/**
 * 
 */
package com.sap.furcas.modeladaptation.emf.lookup;

import static com.sap.furcas.test.testutils.StringListHelper.list;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.junit.Test;

import com.sap.furcas.emf.stubs.EcoreAnyStub;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.interfaces.MultiplicityBean;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.test.testutils.ResolutionBeanHelper;

/**
 * Tests the abstract AbstractMoinLookup class by creating a stub subclass and testing that.
 * Special care need to me taken to test for features that are structural features, Associations, or StructureTypes.
 */
public class TestAbstractEcoreMetaModelLookup {

    @Test
    public void testGetFeatureClassnameNull() throws Exception {
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        Object featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
        assertNull(featureClassname);
    }

    @Test
    public void testGetFeatureClassnameFeature() throws Exception {
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        Object featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
        assertNull(featureClassname);

        // create classifier stub
        EcoreAnyStub classi = new EcoreAnyStub();
        classi.lookupElementExtendedKey = "feature";
        lookup.classifier = classi;

        // create feature stub
        EcoreAnyStub feature = new EcoreAnyStub();
        classi.lookupElementExtended = feature;

        EcoreAnyStub featureType = new EcoreAnyStub();
        featureType.name = "featureType";
        feature.type = featureType;

        featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
        assertNotNull(featureClassname);
        assertEquals(ResolutionBeanHelper.refM("package", "featureType"), featureClassname);
    }

    @Test
    public void testGetMultiplicityFeature() throws Exception {
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        EcoreAnyStub strucType = new EcoreAnyStub();
        strucType.lookupElementExtendedKey = "feature";

        // create feature stub
        EcoreAnyStub field = new EcoreAnyStub();
        field.upper = 1;
        field.lower = 1;
        strucType.lookupElementExtended = field;

        lookup.classifier = strucType;

        MultiplicityBean bean = new MultiplicityBean();
        bean.setUpperBound(1);
        bean.setLowerBound(1);
        assertEquals(bean, lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
    }

    @Test
    public void testHasFeatureFeature() throws Exception {
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        assertNull(lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));

        EcoreAnyStub classi = new EcoreAnyStub();
        classi.lookupElementExtendedKey = "feature";
        lookup.classifier = classi;

        EcoreAnyStub feature = new EcoreAnyStub();
        classi.lookupElementExtended = feature;

        assertNotNull(lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));

    }

    @Test
    public void testGetFeature() throws Exception {
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        assertNull(lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature"));

        EcoreAnyStub classi = new EcoreAnyStub();
        classi.lookupElementExtendedKey = "feature";

        lookup.classifier = classi;
        // still expect null, as we did not set feature in the stub
        assertNull(lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature"));

        EcoreAnyStub feature = new EcoreAnyStub();
        classi.lookupElementExtended = feature;
        
        EcoreAnyStub featureType = new EcoreAnyStub();
        featureType.name = "featureType";
        feature.type = featureType;
        
        assertNotNull(lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature"));
    }

    @Test
    public void testIsClassName() throws Exception {
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        assertNull(lookup.resolveReference(list("package", "testType")));

        EcoreAnyStub classi = new EcoreAnyStub();
        classi.name = "testType";
        lookup.classifier = classi;

        assertNotNull(lookup.resolveReference(list("package", "testType")));
    }

    @Test
    public void testQualifyName() throws Exception {
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        /*** Test with no results **/
        List<ResolvedNameAndReferenceBean<EObject>> result = lookup.qualifyName("typeName");
        assertEquals(0, result.size());

        /*** Test with one results **/
        EcoreAnyStub classi = new EcoreAnyStub();
        // EcoreAnyStub will add package to qualified Name
        classi.name = "Test";
        lookup.qualifiedClassifiers.add(classi);

        result = lookup.qualifyName("typeName");
        assertEquals(1, result.size());
        assertEquals(ResolutionBeanHelper.refM("package", "Test"), result.get(0));

        /*** Test with many results **/
        classi = new EcoreAnyStub();
        // EcoreAnyStub will add package to qualified Name
        classi.name = "Test2";
        lookup.qualifiedClassifiers.add(classi);

        result = lookup.qualifyName("typeName");
        assertEquals(2, result.size());
        assertTrue(result.contains(ResolutionBeanHelper.refM("package", "Test")));
        assertTrue(result.contains(ResolutionBeanHelper.refM("package", "Test2")));
    }

    @Test
    public void testGetEnumLiterals() throws MetaModelLookupException {
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        EList<EEnumLiteral> literals = new BasicEList<EEnumLiteral>();
        List<String> labels = new ArrayList<String>();
        
        EcoreAnyStub literalStub = new EcoreAnyStub();
        literalStub.enumLiteralString = "test1";
        labels.add(literalStub.enumLiteralString);
        literals.add(literalStub);
        
        literalStub = new EcoreAnyStub();
        literalStub.enumLiteralString = "test2";
        labels.add(literalStub.enumLiteralString);
        literals.add(literalStub);
        
        EcoreAnyStub enumStub = new EcoreAnyStub();
        enumStub.enumLiterals = literals;
        lookup.classifier = enumStub;

        List<String> result = lookup.getEnumLiterals(ResolutionBeanHelper.refM("package", "EnumName"));
        assertEquals(labels, result);
    }

    @Test
    public void testInstanceOfSame() throws MetaModelLookupException {

        // override getClassifier to return different stuff for sub and supertype
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();

        final EcoreAnyStub subTypeClass = new EcoreAnyStub();
        lookup.classifier = subTypeClass;
        // test is independent of passed Strings
        assertTrue(lookup.isSubTypeOf(ResolutionBeanHelper.refM("foo"), ResolutionBeanHelper.refM("bar")));
    }

    @Test
    public void testInstanceOf() throws MetaModelLookupException {

        final List<String> subTypeName = list("package", "subtype");
        final List<String> superTypeName = list("package", "supertype");
        ResolvedNameAndReferenceBean<EObject> superRefBean = new ResolvedNameAndReferenceBean<EObject>(superTypeName, null);
        ResolvedNameAndReferenceBean<EObject> subRefBean = new ResolvedNameAndReferenceBean<EObject>(subTypeName, null);

        final EcoreAnyStub subTypeClass = new EcoreAnyStub();
        final EcoreAnyStub superTypeClass = new EcoreAnyStub();

        EList<EClass> supers = new BasicEList<EClass>();
        supers.add(new EcoreAnyStub());
        supers.add(superTypeClass);
        subTypeClass.supertypes = supers;

        // override getClassifier to return different stuff for sub and supertype
        TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup() {
            @Override
            protected EClassifier findClassifiersByQualifiedName(List<String> typeNameQ) throws MetaModelLookupException {
                if (typeNameQ.equals(subTypeName)) {
                    return subTypeClass;
                } else if (typeNameQ.equals(superTypeName)) {
                    return superTypeClass;
                } else {
                    return null;
                }
            }
        };

        assertTrue(lookup.isSubTypeOf(subRefBean, superRefBean));
    }
    
    /**
     * This tests the lookup of references through generics used e.g., in the OCL and OCLEcore metamodels
     * For example, ecore::EnumLiteralExp inherits from EnumLiteralExp<C, LE> binding the generic types
     * as follows: EnumLiteralExp<EClassifier, EEnumLiteral> which leads to the reference "referredEnumLiteral"
     * being bound to type EEnumLiteral. This binding has to be resolved by the metalookup. Currently,
     * {@link AbstractEcoreMetaModelLookup#getEType(EObject, org.eclipse.emf.ecore.EStructuralFeature)} is 
     * responsible for resolving the generic type stuff.
     * 
     * @throws MetaModelLookupException
     */
    @Test
    public void testGenericReferenceTypeResolvingParameterizedReference() throws MetaModelLookupException {
    	TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();
    	ResolvedNameAndReferenceBean<EObject> reference = ResolutionBeanHelper.refM(
    			EcorePackage.eINSTANCE.getEnumLiteralExp(), "ocl", "ecore", "EnumLiteralExp");
    	
    	ResolvedNameAndReferenceBean<EObject> featureClassReference = 
    		lookup.getFeatureClassReference(reference, "referredEnumLiteral");
    	assertEquals(org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEEnumLiteral(),
    			featureClassReference.getReference());
    }
    
//    /**
//     * This tests the lookup of references through generics used e.g., in the OCL and OCLEcore metamodels
//     * this time for parameterized reference types:
//     * ecore::VariableExp has a reference referredVariable which is of Type Variable<C, PM>. As 
//     * ecore::VariableExp has a generic supertype  VariableExp<EClassifier, EParameter> these parameters
//     * should also be bound to the type of the  referredVariable reference leading to the reference type
//     * of Variable<EClassifier, EParameter>. This case should also be handled by
//     * {@link AbstractEcoreMetaModelLookup#getEType(EObject, org.eclipse.emf.ecore.EStructuralFeature)}.
//     * 
//     * @throws MetaModelLookupException
//     */
//    @Test
//    public void testGenericReferenceTypeResolvingParameterizedReferenceType() throws MetaModelLookupException {
//    	TestableAbstractEcoreMetaModelLookup lookup = new TestableAbstractEcoreMetaModelLookup();
//    	ResolvedNameAndReferenceBean<EObject> reference = ResolutionBeanHelper.refM(
//    			EcorePackage.eINSTANCE.getEnumLiteralExp(), "ocl", "ecore", "VariableExp");
//    	
//    	ResolvedNameAndReferenceBean<EObject> featureClassReference = 
//    		lookup.getFeatureClassReference(reference, "referredVariable");
//    	assertEquals(org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEEnumLiteral(),
//    			featureClassReference.getReference());
//    }

    private class TestableAbstractEcoreMetaModelLookup extends AbstractEcoreMetaModelLookup {

        public TestableAbstractEcoreMetaModelLookup() {
			super(DefaultOppositeEndFinder.getInstance());
		}

		public EList<EClassifier> qualifiedClassifiers = new BasicEList<EClassifier>();
        public EClassifier classifier;

        @Override
        protected EClassifier findClassifiersByQualifiedName(List<String> typeNameQ) throws MetaModelLookupException {
            return classifier;
        }

        @Override
        protected EList<EClassifier> findClassifiersByUnqualifiedName(String typeName) throws MetaModelLookupException {
            return qualifiedClassifiers;
        }

        @Override
        public EList<Diagnostic> validateOclQuery(Template template, String queryToValidate) {
            return new BasicEList<Diagnostic>();
        }

        @Override
        public List<ResolvedNameAndReferenceBean<EObject>> getDirectSubTypes(ResolvedNameAndReferenceBean<EObject> typeName)
                throws MetaModelLookupException, NameResolutionFailedException {
            fail("Not implemented");
            return null;
        }

        @Override
        public void close() {
            fail("Not implemented");
        }

        @Override
        public List<Diagnostic> validateOclQuery(EObject parsingContext, String oclQuery) {
            return new BasicEList<Diagnostic>();
        }

        @Override
        public EObject getOclReturnType(EObject parsingContext, String oclQuery) throws MetaModelLookupException {
            return new EcoreAnyStub();
            
        }

    }
}