package com.sap.furcas.test.fixture;

import java.io.File;

public class FeatureFixtureData {
    
    public static final String EXAMPLE_FOLDER = "../com.sap.furcas.test/featureFixtures/";

    
    // EnumerationTemplates Tests
    public static final File ENUM_FEATURE_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/Enumeration.ecore");
    public static final File ENUM_FEATURE_TCS = new File("../com.sap.furcas.test/featureFixtures/EnumerationFeatureMapped.tcs");
    public static final File ENUM_FEATURE_AUTO_TCS = new File("../com.sap.furcas.test/featureFixtures/EnumerationFeatureAuto.tcs");
    
    // QueryByIdentifierPArg Tests
    public static final File PARG_QUERY_BY_IDENTIFIER_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/PropertyArgument_QueryByIdentifier.ecore");
    public static final File PARG_QUERY_BY_IDENTIFIER_TCS = new File("../com.sap.furcas.test/featureFixtures/PropertyArgument_QueryByIdentifier.tcs");
    
    //ForeachInOCLExpr Tests
    public static final File FOREACH_PREDICATE_PROPERTY_INIT_METAMODEL = new File("../com.sap.furcas.test/featureFixtures/ForeachPredicatePropertyInit.ecore");
    public static final File FOREACH_PREDICATE_PROPERTY_INIT_TCS = new File("../com.sap.furcas.test/featureFixtures/ForeachPredicatePropertyInit.tcs");

}
