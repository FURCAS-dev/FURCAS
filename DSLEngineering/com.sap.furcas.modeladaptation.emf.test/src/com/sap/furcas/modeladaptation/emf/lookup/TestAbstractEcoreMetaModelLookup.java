/**
 * 
 */
package com.sap.furcas.modeladaptation.emf.lookup;


/**
 * Tests the abstract AbstractMoinLookup class by creating a stub subclass and testing that.
 * Special care need to me taken to test for features that are structural features, Associations, or StructureTypes.
 */
public class TestAbstractEcoreMetaModelLookup {

//    @Test
//    public void testGetFeatureClassnameNull() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        Object featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
//        assertNull(featureClassname);
//    }
//    
//    @Test
//    public void testGetFeatureClassnameFeature() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        Object featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
//        assertNull(featureClassname);
//        
//        // create classifier stub
//        EcoreAnyStub classi = new EcoreAnyStub();
//        classi.lookupElementExtendedKey = "feature";
//        lookup.classifier = classi;
//        
//        // create feature stub
//        EcoreAnyStub feature = new EcoreAnyStub();
//        classi.lookupElementExtended = feature;
//        
//        EcoreAnyStub featureType = new EcoreAnyStub();     
//        featureType.name = "featureType";
//        feature.type = featureType;
//        
//        featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
//        assertNotNull(featureClassname);
//        assertEquals(ResolutionBeanHelper.refM("package", "featureType"), featureClassname);
//    }
//    
//    @Test
//    public void testGetFeatureClassnameAssociation() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        Object featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
//        assertNull(featureClassname);
//        
//        // create classifier stub
//        EcoreAnyStub classi = new EcoreAnyStub();
//        classi.lookupElementExtendedKey = "feature";
//        lookup.classifier = classi;
//        
//        // create asso stub
//        EcoreAnyStub assoEnd = new EcoreAnyStub();
//        lookup.assoEnd = assoEnd;
//        
//        EcoreAnyStub featureType = new EcoreAnyStub();     
//        featureType.name = "featureType";
//        assoEnd.type = featureType;
//        
//        featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
//        assertNotNull(featureClassname);
//        assertEquals(ResolutionBeanHelper.refM("package", "featureType"), featureClassname);
//    }
//    
//    @Test
//    public void testGetFeatureClassnameStructure() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        Object featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
//        assertNull(featureClassname);
//        
//        // create classifier stub
//        MofStructureTypeStub strucType = new MofStructureTypeStub();
//        strucType.lookupElementExtendedKey = "feature";
//        lookup.classifier = strucType;
//        
//        // create feature stub
//        MofStructureFieldStub field = new MofStructureFieldStub();
//        strucType.lookupElementExtended = field;
//        
//        EcoreAnyStub featureType = new EcoreAnyStub();     
//        featureType.name = "featureType";
//        field.type = featureType;
//       
//        featureClassname = lookup.getFeatureClassReference(ResolutionBeanHelper.refM("package", "testType"), "feature");
//        assertNotNull(featureClassname);
//        assertEquals(ResolutionBeanHelper.refM("package", "featureType"), featureClassname);
//    }
//    
//    
//    @Test
//    public void testGetMultiplicityFeature() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        assertNull(lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//        
//        EcoreAnyStub classi = new EcoreAnyStub();
//        classi.lookupElementExtendedKey = "feature";
//        EcoreAnyStub multiplicityType = new EcoreAnyStub();
//        
//        
//        lookup.classifier = classi;
//        EcoreAnyStub feature = new EcoreAnyStub();
//        classi.lookupElementExtended = feature;
//        feature.multiplicityType = multiplicityType;
//        
//        MultiplicityBean bean = new MultiplicityBean();
//        bean.setUpperBound(-1);
//        assertEquals(bean, lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//    }
//    
//
//    @Test
//    public void testGetMultiplicityAssociation() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        EcoreAnyStub classi = new EcoreAnyStub();
//        classi.lookupElementExtendedKey = "feature";
//        EcoreAnyStub multiplicityType = new EcoreAnyStub();
//        
//        // create asso stub
//        EcoreAnyStub assoEnd = new EcoreAnyStub();
//        lookup.assoEnd = assoEnd;
//        
////        assoEnd.type = featureType;
//        assoEnd.multiplicityType = multiplicityType;
//        
//        MultiplicityBean bean = new MultiplicityBean();
//        bean.setUpperBound(-1);
//        assertEquals(bean, lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//    }
//    
//    @Test
//    public void testGetMultiplicityStructureField() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        MofStructureTypeStub strucType = new MofStructureTypeStub();
//        strucType.lookupElementExtendedKey = "feature";
//
//        // create feature stub
//        MofStructureFieldStub field = new MofStructureFieldStub();
//        strucType.lookupElementExtended = field;
//        
//
//        lookup.classifier = strucType;
//
//        MultiplicityBean bean = new MultiplicityBean();
//        bean.setUpperBound(1);
//        bean.setLowerBound(1);
//        assertEquals(bean, lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//    }
//    
//    @Test
//    public void testHasFeatureFeature() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        assertNull(lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//        
//        EcoreAnyStub classi = new EcoreAnyStub();
//        classi.lookupElementExtendedKey = "feature";
//        lookup.classifier = classi;
//        
//        EcoreAnyStub feature = new EcoreAnyStub();
//        feature.multiplicityType = new EcoreAnyStub();
//        classi.lookupElementExtended = feature;
//        
//        assertNotNull(lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//
//    }
//    
//    @Test
//    public void testHasFeatureAssociation() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        assertNull(lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//        
//        EcoreAnyStub assoEnd = new EcoreAnyStub();
//        assoEnd.multiplicityType = new EcoreAnyStub();
//        lookup.assoEnd = assoEnd;
//
//        assertNotNull(lookup.getMultiplicity(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//
//    }
//    
//    @Test
//    public void testGetFeature() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//
//        assertNull(lookup.publicGetTypedElement(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//        
//        EcoreAnyStub classi = new EcoreAnyStub();
//        classi.lookupElementExtendedKey = "feature";
//        
//        lookup.classifier = classi;
//        // still expect null, as we did not set feature in the stub
//        assertNull(lookup.publicGetTypedElement(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//        
//        EcoreAnyStub feature = new EcoreAnyStub();
//        classi.lookupElementExtended = feature;
//        assertNotNull(lookup.publicGetTypedElement(ResolutionBeanHelper.refM("package", "testType"), "feature"));
//    }
//
//    @Test
//    public void testStringRepresentation() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        assertEquals(null, lookup.publicGetStringRep(null));
//        assertEquals("", lookup.publicGetStringRep(list()));
//        assertEquals("Test", lookup.publicGetStringRep(list("Test")));
//        assertEquals("Test::Test2", lookup.publicGetStringRep(list("Test", "Test2")));
//        assertEquals("Test::Test2::Test3", lookup.publicGetStringRep(list("Test", "Test2", "Test3")));
//    }
//    
//    @Test
//    public void testIsClassName() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        assertNull(lookup.resolveReference(list("package", "testType")));
//        
//        EcoreAnyStub classi = new EcoreAnyStub();
//        classi.name = "testType";
//        lookup.classifier = classi;
//        
//        assertNotNull(lookup.resolveReference(list("package", "testType")));
//    }
//    
//    
//    @Test
//    public void testQualifyName() throws Exception {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        /*** Test with no results **/
//        List<ResolvedNameAndReferenceBean<EObject>> result = lookup.qualifyName("typeName");
//        assertEquals(0, result.size());
//        
//        
//        /*** Test with one results **/
//        EcoreAnyStub classi = new EcoreAnyStub();
//        // EcoreAnyStub will add package to qualified Name
//        classi.name = "Test";
//        lookup.qualifiedClassifiers.add(classi ); 
//            
//        result = lookup.qualifyName("typeName");
//        assertEquals(1, result.size());
//        assertEquals(ResolutionBeanHelper.refM("package", "Test"), result.get(0));
//        
//        /*** Test with many results **/
//        classi = new EcoreAnyStub();
//        // EcoreAnyStub will add package to qualified Name
//        classi.name = "Test2";
//        lookup.qualifiedClassifiers.add(classi ); 
//            
//        result = lookup.qualifyName("typeName");
//        assertEquals(2, result.size());
//        assertTrue(result.contains(ResolutionBeanHelper.refM("package", "Test")));
//        assertTrue(result.contains(ResolutionBeanHelper.refM("package", "Test2")));
//    }
//    
//    @Test
//    public void testGetEnumLiterals() throws MetaModelLookupException {
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//        List<String> labels = new ArrayList<String>();
//        labels.add("test1");
//        labels.add("test2");
//        EnumerationTypeStub enumStub = new EnumerationTypeStub();
//        enumStub.labels = labels;
//        lookup.classifier = enumStub;
//        
//        List<String> result = lookup.getEnumLiterals(ResolutionBeanHelper.refM("package", "EnumName") );
//        assertEquals(labels, result);
//    }
//    
//    @Test
//    public void testInstanceOfSame() throws MetaModelLookupException {
//
//        // override getClassifier to return different stuff for sub and supertype
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub();
//        
//
//        final EcoreAnyStub subTypeClass = new EcoreAnyStub();
//        lookup.classifier = subTypeClass;
//        // test is independent of passed Strings
//        assertTrue(lookup.isSubTypeOf(ResolutionBeanHelper.refM("foo"), ResolutionBeanHelper.refM("bar")));
//    }
//    
//    @Test
//    public void testInstanceOf() throws MetaModelLookupException {
//
//        final List<String> subTypeName = list("package", "subtype");
//        final List<String> superTypeName = list("package", "supertype");
//        ResolvedNameAndReferenceBean<EObject> superRefBean = new ResolvedNameAndReferenceBean<EObject>(superTypeName, null);
//        ResolvedNameAndReferenceBean<EObject> subRefBean = new ResolvedNameAndReferenceBean<EObject>(subTypeName, null);
//        
//        final EcoreAnyStub subTypeClass = new EcoreAnyStub();
//        final EcoreAnyStub superTypeClass = new EcoreAnyStub();
//        
//        List<GeneralizableElement> supers = new ArrayList<GeneralizableElement>();
//        supers.add(new EcoreAnyStub());
//        supers.add(superTypeClass);
//        subTypeClass.supertypes = supers ;
//        
//        // override getClassifier to return different stuff for sub and supertype
//        MoinLookUpSubTypeStub lookup = new MoinLookUpSubTypeStub() {
//
//            /* (non-Javadoc)
//             * @see com.sap.tc.moin.textual.moinlookup.AbstractMoinLookupTest.MoinLookUpSubTypeStub#getClassifier(java.util.List)
//             */
//            @Override
//            protected Classifier getClassifierByName(List<String> typeNameQ)
//                    throws MetaModelLookupException {
//                if (typeNameQ.equals(subTypeName)) {
//                    return subTypeClass;
//                } else if (typeNameQ.equals(superTypeName)) {
//                    return superTypeClass;
//                } else {
//                    return null;
//                }
//            }
//        };
//        
//        
//        assertTrue(lookup.isSubTypeOf(subRefBean, superRefBean ));
//    }
//    
//    private class MoinLookUpSubTypeStub extends AbstractEcoreMetaModelLookup {
//
//        public List<Classifier> qualifiedClassifiers = new ArrayList<Classifier>();
//        public Classifier classifier;
//        public AssociationEnd assoEnd;
//
//        /* (non-Javadoc)
//         * @see com.sap.mi.textual.moinlookup.AbstractMoinLookup#getAssociationEnd(java.util.List, java.lang.String)
//         */
//        @Override
//        protected AssociationEnd getAssociationEnd(ResolvedNameAndReferenceBean<EObject> reference,
//                String featureName) throws MetaModelLookupException {
//            return assoEnd;
//        }
//
//        /* (non-Javadoc)
//         * @see com.sap.mi.textual.moinlookup.AbstractMoinLookup#getClassifier(java.util.List)
//         */
//        @Override
//        protected Classifier getClassifierByName(List<String> typeNameQ)
//                throws MetaModelLookupException {
//            return classifier;
//        }
//
//        /* (non-Javadoc)
//         * @see com.sap.mi.textual.interfaces.IMetaModelLookup#close()
//         */
//        public void close() {  }
//
//        /* (non-Javadoc)
//         * @see com.sap.mi.textual.interfaces.IMetaModelLookup#getDirectSubTypes(java.util.List)
//         */
//        public List<ResolvedNameAndReferenceBean<EObject>> getDirectSubTypes(ResolvedNameAndReferenceBean<EObject> typeName)
//                throws MetaModelLookupException {
//            fail("Not implemented");
//            return null;
//        }
//
//        /* (non-Javadoc)
//         * @see com.sap.mi.textual.moinlookup.AbstractMoinLookup#getClassifiers(java.lang.String)
//         */
//        @Override
//        protected List<Classifier> getClassifiers(String typeName)
//                throws MetaModelLookupException {
//            return qualifiedClassifiers;
//        }
//
//        // piping the protected superclass method for testing
//        public TypedElement publicGetTypedElement(ResolvedNameAndReferenceBean reference, String featureName) throws MetaModelLookupException {
//            return this.getTypedElement(reference, featureName);
//        }
//        
//        // piping the protected superclass method for testing
//        public String publicGetStringRep(List<String> typeName) throws MetaModelLookupException {
//            return getStringRepresentationOfName(typeName);
//        }
//
//	@Override
//	public List<String> validateOclQuery(Object template, String query,
//		Object context) {
//	    return Collections.emptyList();
//	}
//
//
//    }
//    
}
