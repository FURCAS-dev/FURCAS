package com.sap.furcas.parsergenerator.tcs.generator;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.sap.furcas.parsergenerator.TCSParserGenerator;
import com.sap.furcas.parsergenerator.TCSParserGeneratorFactory;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;


/**
 * Tests that the parsergenerator extensoin point works as expected.
 * 
 * @author Stephan Erb (d049157)
 */
public class TestTCSGrammarGenerator {

    
    @Test
    public void testLookup() throws ParserGeneratorInvocationException {
         TCSParserGenerator generator = TCSParserGeneratorFactory.INSTANCE.createTCSParserGenerator();
         assertNotNull("Parsergenerator project should provide an implementation", generator);
    }
    
    
}
