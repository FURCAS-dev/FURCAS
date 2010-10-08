/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.furcas.parsergenerator.utils.StringConcatTest;
import com.sap.furcas.parsergenerator.utils.VarStringBufferTest;
import com.sap.mi.textual.common.exceptions.TestExceptions;
import com.sap.mi.textual.common.exceptions.TestKeyToListMap;
import com.sap.mi.textual.grammar.impl.tcs.t2m.validation.MainTemplateValidationTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.validation.OperatorListValidationTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.validation.TemplateNameValidationTest;

@RunWith (Suite.class)
@SuiteClasses ( { 
    TestExceptions.class,
    TestKeyToListMap.class,
    StringConcatTest.class,
    VarStringBufferTest.class,
    OperatorListValidationTest.class,
    TemplateNameValidationTest.class,
    MainTemplateValidationTest.class} )

public class OtherUnitTestSuite {

// empty class, no properties, no methods, nothing!!

}