/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.parsergenerator.tcs.t2m.grammar.ANTLR3GrammarWriter;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule;
import com.sap.furcas.runtime.common.exceptions.GrammarGenerationException;

/**
 * Stub needed mainly to collect rules written by syntax element handlers.
 */
public class ANTLR3WriterStub extends ANTLR3GrammarWriter {

    public List<AbstractAntlr3Rule> rules = new ArrayList<AbstractAntlr3Rule>();
    public String fixedString;
//    public List<RuleBodyStringBuffer> buffers = new ArrayList<RuleBodyStringBuffer>();
    public String grammarName;
    public String grammarOptions;
    public List<String> additionalMembers;
    
    @Override
    public void addRule(AbstractAntlr3Rule rule) {
        rules.add(rule);
    }
    
    @Override
    public String getGrammarHeader() {
        return "StubGrammarHeader";
    }
    @Override
    public String getOutput() throws GrammarGenerationException {
        return "StubOutput";
    }
    @Override
    public void setFixedString(String fixedString) {
        this.fixedString = fixedString;
    }
    
    @Override
    public void setGrammarName(String grammarName) {
        this.grammarName = grammarName;
    }
    @Override
    public void setGrammarOptions(String grammarOptions) {
        this.grammarOptions = grammarOptions;
    }
    @Override
    public void setLexerHeader(String lexerHeader) {
        fail("not implemented yet");
    }
    @Override
    public void addLexerMembers(List<String> lexerMembers) {
        additionalMembers = lexerMembers;
    }
    

}
