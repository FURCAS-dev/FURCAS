package com.sap.furcas.test.fixture;

import java.io.File;

public class ReferenceResolvingFixtureData {
    
    public static final String EXAMPLE_FOLDER = "../com.sap.furcas.test/referenceresolvingFixtures/";
    
    // NestedScopes Tests
    public static final File NESTED_SCOPES_METAMODEL = new File("../com.sap.furcas.test/referenceresolvingFixtures/NestedScopes.ecore");
    public static final File NESTED_SCOPES_TCS = new File("../com.sap.furcas.test/referenceresolvingFixtures/NestedScopes.tcs");
    public static final String NESTED_SCOPES_PACKAGE_URI = "http://www.furcas.org/TCS/referenceresolving/tests/nestedScopes";
    
    //PropertyInitReEvaluationWithContextInForeachTriggeredTemplate Tests
    public static final File PROPINIT_REEVAL_WITH_CONTEXT_IN_FOREACH_TCS = new File("../com.sap.furcas.test/referenceresolvingFixtures/BibtexWithContextUsedInForeachTriggeredTemplate.tcs");
    
    //BibtexWithPropertyInits Tests
    public static final File BIBTEX_WITH_PROPERTY_INITS_TCS = new File("../com.sap.furcas.test/referenceresolvingFixtures/BibtexWithPropertyInits.tcs");
    
    //BibtexWithPropertyInitsWithContext Tests
    public static final File BIBTEX_WITH_PROPERTY_INITS_WITH_CONTEX_TCS = new File("../com.sap.furcas.test/referenceresolvingFixtures/BibtexWithPropertyInitsWithContext.tcs");
}
