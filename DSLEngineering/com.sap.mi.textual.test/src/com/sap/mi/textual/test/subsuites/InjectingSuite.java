/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.furcas.parser.impl.context.TestContext;
import com.sap.furcas.parser.impl.context.TestContextManager;
import com.sap.furcas.parser.impl.context.TestObservableInjectingParser;
import com.sap.furcas.parser.impl.context.TestObservableParser;
import com.sap.mi.textual.test.parsingObserver.ObservationTest;


@RunWith (Suite.class)
@SuiteClasses ( {
    ObservationTest.class,
    TestObservableParser.class,
    TestObservableInjectingParser.class,
    TestContextManager.class,
    TestContext.class
})

public class InjectingSuite {

// empty class, no properties, no methods, nothing!!

}