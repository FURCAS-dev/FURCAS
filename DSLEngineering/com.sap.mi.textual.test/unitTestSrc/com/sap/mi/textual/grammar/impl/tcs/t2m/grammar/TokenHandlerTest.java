/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import static com.sap.mi.textual.test.util.RuleComparisonHelper.tokens;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.sap.furcas.metamodel.TCS.EndOfLineRule;
import com.sap.furcas.metamodel.TCS.Mapping;
import com.sap.furcas.metamodel.TCS.MultiLineRule;
import com.sap.furcas.metamodel.TCS.SimplePattern;
import com.sap.furcas.metamodel.TCS.StringPattern;
import com.sap.furcas.metamodel.TCS.WordRule;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.TokenHandler;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.ANTLR3WriterStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.ClassPatternStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.LocatedElementStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.OrPatternStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.RulePatternStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.StringPatternStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.TokenStub;

/**
 *
 */
public class TokenHandlerTest {

    @Test
    public void testAddElementClassAlpha() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        ClassPatternStub cps = new ClassPatternStub();
        cps.name = "alpha";
        patterns.add(cps);
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : ((\'A\' .. \'Z\'| \'a\' .. \'z\')) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementClassAlphaNum() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        ClassPatternStub cps = new ClassPatternStub();
        cps.name = "alnum";
        patterns.add(cps);
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : ((\'A\' .. \'Z\'| \'a\' .. \'z\'| \'0\' .. \'9\')) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementClassStringPat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        StringPatternStub cps = new StringPatternStub();
        cps.name = "someString";
        patterns.add(cps);
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : ('someString') ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementClassMultiStringPat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        StringPatternStub cps = new StringPatternStub();
        cps.name = "someString";
        patterns.add(cps);
        cps = new StringPatternStub();
        cps.name = "someString2";
        patterns.add(cps);
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : ('someString' | 'someString2') ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementEOLRulePat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        EndOfLineRuleStub rulestub= new EndOfLineRuleStub();
        rulestub.stringPat.name="//";
        rps.rule = rulestub;
        patterns.add(rps);
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : (((\'//\' (~(\'\\r\'| \'\\n\'))*))) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementEOLRuleEscapedPat() throws Exception {
        // hyphen needs to be escaped
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        EndOfLineRuleStub rulestub= new EndOfLineRuleStub();
        rulestub.stringPat.name="'";
        rps.rule = rulestub;
        patterns.add(rps);
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : (((\'\\'\' (~(\'\\r\'| \'\\n\'))*))) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }

    @Test
    public void testAddElementMultiLineRulePat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        MultiLineRuleStub rulestub= new MultiLineRuleStub();
        rulestub.startPat.name="/*";
        rulestub.endPat.name="*/";
        rps.rule = rulestub;
        patterns.add(rps);
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : ((('/*' (options {greedy = false;} : ('\\n'| ~ '\\n'))* '*/'))) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementWordstartEndPat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        patterns.add(rps);
        
        Collection<SimplePattern> startPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "startString";
        startPatterns.add(sps1);
        
        Collection<SimplePattern> endPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps2 = new StringPatternStub();
        sps2.name = "endString";
        endPatterns.add(sps2);
        
        WordRuleStub rulestub= new WordRuleStub();
        rulestub.startPat = getOrPatternStub(startPatterns);
        rulestub.endPat= getOrPatternStub(endPatterns);
        rps.rule = rulestub;
        
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : (('startString') ('endString')) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementWordPartEndPat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        patterns.add(rps);
        
        Collection<SimplePattern> partPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "partString";
        partPatterns.add(sps1);
        
        Collection<SimplePattern> endPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps2 = new StringPatternStub();
        sps2.name = "endString";
        endPatterns.add(sps2);
        
        WordRuleStub rulestub= new WordRuleStub();
        rulestub.partPat = getOrPatternStub(partPatterns);
        rulestub.endPat= getOrPatternStub(endPatterns);
        rps.rule = rulestub;
        
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : ((('partString'))* ('endString')) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementWordStartPartEndPat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        patterns.add(rps);
        
        Collection<SimplePattern> startPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps0 = new StringPatternStub();
        sps0.name = "startString";
        startPatterns.add(sps0);
        
        Collection<SimplePattern> partPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "partString";
        partPatterns.add(sps1);
        
        Collection<SimplePattern> endPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps2 = new StringPatternStub();
        sps2.name = "endString";
        endPatterns.add(sps2);
        
        WordRuleStub rulestub= new WordRuleStub();
        rulestub.startPat = getOrPatternStub(startPatterns);
        rulestub.partPat = getOrPatternStub(partPatterns);
        rulestub.endPat= getOrPatternStub(endPatterns);
        rps.rule = rulestub;
        
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : (('startString') (('partString'))* ('endString')) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementWordMultiStartPartEndPat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        patterns.add(rps);
        
        Collection<SimplePattern> startPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps0 = new StringPatternStub();
        sps0.name = "startString";
        startPatterns.add(sps0);
        sps0 = new StringPatternStub();
        sps0.name = "startString2";
        startPatterns.add(sps0);
        
        Collection<SimplePattern> partPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "partString";
        partPatterns.add(sps1);
        sps1 = new StringPatternStub();
        sps1.name = "partString2";
        partPatterns.add(sps1);
        
        Collection<SimplePattern> endPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps2 = new StringPatternStub();
        sps2.name = "endString";
        endPatterns.add(sps2);
        sps2 = new StringPatternStub();
        sps2.name = "endString2";
        endPatterns.add(sps2);
        
        WordRuleStub rulestub= new WordRuleStub();
        rulestub.startPat = getOrPatternStub(startPatterns);
        rulestub.partPat = getOrPatternStub(partPatterns);
        rulestub.endPat= getOrPatternStub(endPatterns);
        rps.rule = rulestub;
        
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : (('startString' | 'startString2') (('partString' | 'partString2'))* ('endString' | 'endString2')) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementWordStartPartPat() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        rps.name = "someString";
        patterns.add(rps);
        
        Collection<SimplePattern> startPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps0 = new StringPatternStub();
        sps0.name = "startString";
        startPatterns.add(sps0);
        
        Collection<SimplePattern> partPatterns = new ArrayList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "partString";
        partPatterns.add(sps1);

        
        WordRuleStub rulestub= new WordRuleStub();
        rulestub.startPat = getOrPatternStub(startPatterns);
        rulestub.partPat = getOrPatternStub(partPatterns);
        rps.rule = rulestub;
        
        TokenStub token = createTokenDefinition("testToken", patterns);
        
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : (('startString') (('partString'))* ) ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    @Test
    public void testAddElementOmittedToken() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        Collection<SimplePattern> patterns = new ArrayList<SimplePattern>();
        ClassPatternStub cps = new ClassPatternStub();
        cps.name = "alpha";
        patterns.add(cps);
        TokenStub token = createTokenDefinition("testToken", patterns);
        token.isOmitted = true;
        althandler.addToken(token);
        
        assertEquals(1, writerStub.rules.size() );
        AbstractAntlr3Rule result = writerStub.rules.get(0);

        String expected = "testToken : ((\'A\' .. \'Z\'| \'a\' .. \'z\')){$channel=HIDDEN;} ;";
        
        List tokens = tokens( expected); 
        List tokens2 = tokens( result.toString()); 

        assertEquals(tokens, tokens2);
    }
    
    /**
     * util method for getting a token stub
     * @param string 
     * @param patterns
     * @return
     */
    private TokenStub createTokenDefinition(String name, Collection<SimplePattern> patterns) {
        TokenStub token = new TokenStub();
        token.orPattern = getOrPatternStub(patterns) ;
        token.name = name;
        return token;
    }
    
    private OrPatternStub getOrPatternStub(Collection<SimplePattern> patterns) {
        OrPatternStub orPattern = new OrPatternStub();
        
        orPattern.simplePatterns = patterns;
        return orPattern;
    }
  
    class  MultiLineRuleStub extends LocatedElementStub implements MultiLineRule {

        public StringPatternStub startPat = new StringPatternStub();
        public StringPatternStub endPat = new StringPatternStub();
        
        /* (non-Javadoc)
         * @see tcs.MultiLineRule#getEnd()
         */
        @Override
        public StringPattern getEnd() throws JmiException {
            return endPat;
        }
        
        /* (non-Javadoc)
         * @see tcs.MultiLineRule#getStart()
         */
        @Override
        public StringPattern getStart() throws JmiException {
            return startPat;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#getEsc()
         */
        @Override
        public StringPattern getEsc() throws JmiException {
            return null;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#getEscMappings()
         */
        @Override
        public Collection<Mapping> getEscMappings() throws JmiException {
            return null;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#isDropEnd()
         */
        @Override
        public boolean isDropEnd() throws JmiException {
            return false;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#isDropStart()
         */
        @Override
        public boolean isDropStart() throws JmiException {
            return false;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#setDropEnd(boolean)
         */
        @Override
        public void setDropEnd(boolean newValue) throws JmiException {}

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#setDropStart(boolean)
         */
        @Override
        public void setDropStart(boolean newValue) throws JmiException { }

        @Override
        public void setEnd(StringPattern newValue) throws JmiException { }


        @Override
        public void setEsc(StringPattern newValue) throws JmiException {  }

        @Override
        public void setStart(StringPattern newValue) throws JmiException { }

        
    }
    
    class  WordRuleStub extends LocatedElementStub implements WordRule {

        private OrPatternStub startPat = new OrPatternStub();
        private OrPatternStub partPat = new OrPatternStub();
        private OrPatternStub endPat = new OrPatternStub();

        /* (non-Javadoc)
         * @see tcs.WordRule#getEnd()
         */
        @Override
        public OrPattern getEnd() throws JmiException {
            return endPat;
        }

        /* (non-Javadoc)
         * @see tcs.WordRule#getPart()
         */
        @Override
        public OrPattern getPart() throws JmiException {
            return partPat;
        }

        /* (non-Javadoc)
         * @see tcs.WordRule#getStart()
         */
        @Override
        public OrPattern getStart() throws JmiException {
            return startPat;
        }

  
        @Override
        public void setEnd(OrPattern newValue) throws JmiException {}

        @Override
        public void setPart(OrPattern newValue) throws JmiException {}

        @Override
        public void setStart(OrPattern newValue) throws JmiException { }

    }
    
    class  EndOfLineRuleStub extends LocatedElementStub implements EndOfLineRule {

        public StringPatternStub stringPat = new StringPatternStub();

        /* (non-Javadoc)
         * @see tcs.EndOfLineRule#getStart()
         */
        @Override
        public StringPattern getStart() throws JmiException {
            return stringPat;
        }

        /* (non-Javadoc)
         * @see tcs.EndOfLineRule#isDropStart()
         */
        @Override
        public boolean isDropStart() throws JmiException {
            return false;
        }

        /* (non-Javadoc)
         * @see tcs.EndOfLineRule#setDropStart(boolean)
         */
        @Override
        public void setDropStart(boolean newValue) throws JmiException {
        }

        /* (non-Javadoc)
         * @see tcs.EndOfLineRule#setStart(tcs.StringPattern)
         */
        @Override
        public void setStart(StringPattern newValue) throws JmiException { }

     
    }

}
