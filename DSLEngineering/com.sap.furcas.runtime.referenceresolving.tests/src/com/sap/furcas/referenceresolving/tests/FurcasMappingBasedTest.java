package com.sap.furcas.referenceresolving.tests;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.junit.Before;

import tcs.ConcreteSyntax;

import com.sap.furcas.parser.tcs.stable.TCSLexer;
import com.sap.furcas.parser.tcs.stable.TCSParser;

/**
 * Base class for test cases that use a FURCAS mapping specification (".tcs" file) and based on this
 * produce lexer and parser, then parse a text resource and register all reference resolving callbacks.
 * Then, the tests can start to manipulate the model produced by the parser run and observe how
 * OCL-based property assignments get re-assigned.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public abstract class FurcasMappingBasedTest extends TestCase {
    @Before
    public void setUp() throws IOException, RecognitionException {
        TCSParser parser = new TCSParser(getMappingDefinition());
        ConcreteSyntax syntax = (ConcreteSyntax) parser.main();
        
    }

    /**
     * Obtains a token stream containing the mapping definition. Presumably, the token stream is
     * produced by a {@link TCSLexer}.
     */
    private TokenStream getMappingDefinition() throws IOException {
        return new CommonTokenStream(new TCSLexer(new ANTLRInputStream(getMappingDefinitionAsInputStream())));
    }
    
    protected abstract InputStream getMappingDefinitionAsInputStream();
}
