package com.sap.furcas.test.fixture;

import java.io.File;

public class FeatureFixtureData {
    
    public static final String EXAMPLE_FOLDER = "../com.sap.furcas.test/featureFixtures/";

    // NestedPackageLookup Tests
    public static final File NESTED_PACKAGE_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/NestedPackageLookUp.ecore");
    public static final File NESTED_PACKAGE_TCS = new File("../com.sap.furcas.test/featureFixtures/NestedPackageLookUp.tcs");
    public static final File NESTED_PACKAGE_BY_URI_TCS = new File("../com.sap.furcas.test/featureFixtures/NestedPackageLookUpByNsURI.tcs");
    public static final String NESTED_PACKAGE_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/template/NestedPackage";
    
    // EnumerationTemplates Tests
    public static final File ENUM_FEATURE_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/Enumeration.ecore");
    public static final File ENUM_FEATURE_TCS = new File("../com.sap.furcas.test/featureFixtures/EnumerationFeatureMapped.tcs");
    public static final File ENUM_FEATURE_AUTO_TCS = new File("../com.sap.furcas.test/featureFixtures/EnumerationFeatureAuto.tcs");
    public static final String ENUM_FEATURE_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/template/EnumerationTemplate";
    
    // QueryByIdentifierPArg Tests
    public static final File PARG_REFERENCE_BY_IDENTIFIER_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/PropertyArgument_ReferenceByIdentifier.ecore");
    public static final File PARG_QUERY_BY_IDENTIFIER_TCS = new File("../com.sap.furcas.test/featureFixtures/PropertyArgument_ReferenceByIdentifier.tcs");
    public static final String PARG_REFERENCE_BY_IDENTIFIER_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/property/referenceByIdentifier";

    // Separator Tests
    public static final File PARG_SEPARATOR_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/PropertyArgument_Separator.ecore");
    public static final File PARG_SEPARATOR_TCS = new File("../com.sap.furcas.test/featureFixtures/PropertyArgument_Separator.tcs");
    public static final String PARG_SEPARATOR_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/property/Separator";
   
    
    //ForeachInOCLExpr Tests
    public static final File FOREACH_PREDICATE_PROPERTY_INIT_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/ForeachPredicatePropertyInit.ecore");
    public static final File FOREACH_PREDICATE_PROPERTY_INIT_TCS = new File("../com.sap.furcas.test/featureFixtures/ForeachPredicatePropertyInit.tcs");
    public static final String FOREACH_PREDICATE_PROPERTY_INIT_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/property/ForeachPredicatePropertyInit";

    // PrimitiveTemplate Tests
    public static final File PRIMITIVE_TEMPLATE_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/PrimitiveTemplate.ecore");
    public static final File PRIMITIVE_TEMPLATE_TCS = new File("../com.sap.furcas.test/featureFixtures/PrimitiveTemplate.tcs");
    public static final String PRIMITIVE_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/template/primitiveTemplate";

}
