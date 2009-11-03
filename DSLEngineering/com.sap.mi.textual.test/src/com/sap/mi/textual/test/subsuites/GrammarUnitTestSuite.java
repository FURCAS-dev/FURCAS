/**
 * 
 */
package com.sap.mi.textual.test.subsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sap.mi.textual.grammar.impl.tcs.t2m.TestAbstractGrammarGenerator;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.AlternativeHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ClassTemplateHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.ConditionalElementHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.EnumerationTemplateHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.FunctionTemplateHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.GrammarGeneratorTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.InjectorActionsHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.OperatorHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.PrimitiveTemplateHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.PropertyTypeHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBufferTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.SyntaxLookupTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.TemplateNamingHelperTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.TokenHandlerTest;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.RulesTest;

@RunWith (Suite.class)
@SuiteClasses ( { 
    TestAbstractGrammarGenerator.class,
    AlternativeHandlerTest.class,
    ClassTemplateHandlerTest.class,
    ConditionalElementHandlerTest.class,
    EnumerationTemplateHandlerTest.class,
    FunctionTemplateHandlerTest.class,
    GrammarGeneratorTest.class,
    InjectorActionsHandlerTest.class,
    OperatorHandlerTest.class,
    PrimitiveTemplateHandlerTest.class,    
    PropertyTypeHandlerTest.class,
    RuleBodyStringBufferTest.class,
    SyntaxLookupTest.class,
    TemplateNamingHelperTest.class,
    TokenHandlerTest.class,
    RulesTest.class}
)

public class GrammarUnitTestSuite {

// empty class, no properties, no methods, nothing!!

}