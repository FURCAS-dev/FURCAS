/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static com.sap.furcas.parsergenerator.testutils.RuleComparisonHelper.tokens;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.Mapping;
import com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.OrPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.Word;
import com.sap.furcas.metamodel.FURCAS.TCS.WordRule;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ClassPatternStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.LocatedElementStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.OrPatternStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.RulePatternStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.StringPatternStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.TokenStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.ANTLR3WriterStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule;

/**
 *
 */
public class TokenHandlerTest {

    @Test
    public void testAddElementClassAlpha() throws Exception {
        ANTLR3WriterStub writerStub = new ANTLR3WriterStub();
        // Class under test
        TokenHandler althandler = new TokenHandler(writerStub, null);

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        patterns.add(rps);
        
        EList<SimplePattern> startPatterns = new BasicEList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "startString";
        startPatterns.add(sps1);
        
        EList<SimplePattern> endPatterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        patterns.add(rps);
        
        EList<SimplePattern> partPatterns = new BasicEList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "partString";
        partPatterns.add(sps1);
        
        EList<SimplePattern> endPatterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        patterns.add(rps);
        
        EList<SimplePattern> startPatterns = new BasicEList<SimplePattern>();
        StringPatternStub sps0 = new StringPatternStub();
        sps0.name = "startString";
        startPatterns.add(sps0);
        
        EList<SimplePattern> partPatterns = new BasicEList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "partString";
        partPatterns.add(sps1);
        
        EList<SimplePattern> endPatterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        patterns.add(rps);
        
        EList<SimplePattern> startPatterns = new BasicEList<SimplePattern>();
        StringPatternStub sps0 = new StringPatternStub();
        sps0.name = "startString";
        startPatterns.add(sps0);
        sps0 = new StringPatternStub();
        sps0.name = "startString2";
        startPatterns.add(sps0);
        
        EList<SimplePattern> partPatterns = new BasicEList<SimplePattern>();
        StringPatternStub sps1 = new StringPatternStub();
        sps1.name = "partString";
        partPatterns.add(sps1);
        sps1 = new StringPatternStub();
        sps1.name = "partString2";
        partPatterns.add(sps1);
        
        EList<SimplePattern> endPatterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
        RulePatternStub rps = new RulePatternStub();
        rps.name = "someString";
        patterns.add(rps);
        
        EList<SimplePattern> startPatterns = new BasicEList<SimplePattern>();
        StringPatternStub sps0 = new StringPatternStub();
        sps0.name = "startString";
        startPatterns.add(sps0);
        
        EList<SimplePattern> partPatterns = new BasicEList<SimplePattern>();
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

        EList<SimplePattern> patterns = new BasicEList<SimplePattern>();
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
    private TokenStub createTokenDefinition(String name, EList<SimplePattern> patterns) {
        TokenStub token = new TokenStub();
        token.orPattern = getOrPatternStub(patterns) ;
        token.name = name;
        return token;
    }
    
    private OrPatternStub getOrPatternStub(EList<SimplePattern> patterns) {
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
        public StringPattern getEnd() {
            return endPat;
        }
        
        /* (non-Javadoc)
         * @see tcs.MultiLineRule#getStart()
         */
        @Override
        public StringPattern getStart() {
            return startPat;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#getEsc()
         */
        @Override
        public StringPattern getEsc() {
            return null;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#getEscMappings()
         */
        @Override
        public EList<Mapping> getEscMappings() {
            return null;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#isDropEnd()
         */
        @Override
        public boolean isDropEnd() {
            return false;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#isDropStart()
         */
        @Override
        public boolean isDropStart() {
            return false;
        }

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#setDropEnd(boolean)
         */
        @Override
        public void setDropEnd(boolean newValue) {}

        /* (non-Javadoc)
         * @see tcs.MultiLineRule#setDropStart(boolean)
         */
        @Override
        public void setDropStart(boolean newValue) { }

        @Override
        public void setEnd(StringPattern newValue) { }


        @Override
        public void setEsc(StringPattern newValue) {  }

        @Override
        public void setStart(StringPattern newValue) { }

        
    }
    
    class  WordRuleStub extends LocatedElementStub implements WordRule {

        private OrPatternStub startPat = new OrPatternStub();
        private OrPatternStub partPat = new OrPatternStub();
        private OrPatternStub endPat = new OrPatternStub();

        /* (non-Javadoc)
         * @see tcs.WordRule#getEnd()
         */
        @Override
        public OrPattern getEnd() {
            return endPat;
        }

        /* (non-Javadoc)
         * @see tcs.WordRule#getPart()
         */
        @Override
        public OrPattern getPart() {
            return partPat;
        }

        /* (non-Javadoc)
         * @see tcs.WordRule#getStart()
         */
        @Override
        public OrPattern getStart() {
            return startPat;
        }

  
        @Override
        public void setEnd(OrPattern newValue) {}

        @Override
        public void setPart(OrPattern newValue) {}

        @Override
        public void setStart(OrPattern newValue) { }

	@Override
	public EList<Word> getWords() {
	    return null;
	}

    }
    
    class  EndOfLineRuleStub extends LocatedElementStub implements EndOfLineRule {

        public StringPatternStub stringPat = new StringPatternStub();

        /* (non-Javadoc)
         * @see tcs.EndOfLineRule#getStart()
         */
        @Override
        public StringPattern getStart() {
            return stringPat;
        }

        /* (non-Javadoc)
         * @see tcs.EndOfLineRule#isDropStart()
         */
        @Override
        public boolean isDropStart() {
            return false;
        }

        /* (non-Javadoc)
         * @see tcs.EndOfLineRule#setDropStart(boolean)
         */
        @Override
        public void setDropStart(boolean newValue) {
        }

        /* (non-Javadoc)
         * @see tcs.EndOfLineRule#setStart(tcs.StringPattern)
         */
        @Override
        public void setStart(StringPattern newValue) { }

     
    }

}
