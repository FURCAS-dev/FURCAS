package com.sap.furcas.test.fixture;

import java.io.File;

public class FeatureFixtureData {
    
    public static final String EXAMPLE_FOLDER = "../com.sap.furcas.test/featureFixtures/";

    
    // EnumerationTemplates Tests
    public static final File ENUM_FEATURE_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/Enumeration.ecore");
    public static final File ENUM_FEATURE_TCS = new File("../com.sap.furcas.test/featureFixtures/EnumerationFeatureMapped.tcs");
    public static final File ENUM_FEATURE_AUTO_TCS = new File("../com.sap.furcas.test/featureFixtures/EnumerationFeatureAuto.tcs");
    public static final String ENUM_FEATURE_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/template/EnumerationTemplate";
    
    // QueryByIdentifierPArg Tests
    public static final File PARG_REFERENCE_BY_IDENTIFIER_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/PropertyArgument_ReferenceByIdentifier.ecore");
    public static final File PARG_QUERY_BY_IDENTIFIER_TCS = new File("../com.sap.furcas.test/featureFixtures/PropertyArgument_ReferenceByIdentifier.tcs");
    public static final String PARG_REFERENCE_BY_IDENTIFIER_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/property/referenceByIdentifier";
    
    //ForeachInOCLExpr Tests
    public static final File FOREACH_PREDICATE_PROPERTY_INIT_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/ForeachPredicatePropertyInit.ecore");
    public static final File FOREACH_PREDICATE_PROPERTY_INIT_TCS = new File("../com.sap.furcas.test/featureFixtures/ForeachPredicatePropertyInit.tcs");
    public static final String FOREACH_PREDICATE_PROPERTY_INIT_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/property/ForeachPredicatePropertyInit";

    // PrimitiveTemplate Tests
    public static final File PRIMITIVE_TEMPLATE_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/PrimitiveTemplate.ecore");
    public static final File PRIMITIVE_TEMPLATE_TCS = new File("../com.sap.furcas.test/featureFixtures/PrimitiveTemplate.tcs");
    public static final String PRIMITIVE_PACKAGE_URI = "http://www.furcas.org/TCS/featuretests/template/primitiveTemplate";


    
}
