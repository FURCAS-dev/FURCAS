/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.ClassProductionRule;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.OperatorTemplateProductionRule;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.SimpleProductionRule;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.SymbolProductionRule;
import com.sap.furcas.parsergenerator.util.VarStringBuffer;

/**
 *
 */
public class TestRules {

    protected static final String COLONSTRING = "\n  :\n  ";
    protected static final String SEMICOLONSTRING = "\n  ;\n";
    
    private static final String RETURNSTRING = " returns[";
    private static final String INITSTRING = " @init{";
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule#AbstractAntlr3Rule(java.lang.String)}.
     */
    @Test
    public void testAbstractAntlr3Rule() {
        VarStringBuffer result = new VarStringBuffer();
        AbstractAntlr3Rule rule = new AbstractAntlr3Rule("head") {

            @Override
            protected void addRuleBody(VarStringBuffer buf) {
                buf.append("body");
            }

            @Override
            public int getLength() {
                return 42;
            }};
            
            rule.addToSerializationBuffer(result);
        assertEquals("head" + COLONSTRING + "body" + SEMICOLONSTRING, result.toString());
        // test toString as well
        assertEquals("head" + COLONSTRING + "body" + SEMICOLONSTRING, rule.toString());
    }

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule#addToSerializationBuffer(com.sap.furcas.parsergenerator.util.VarStringBuffer)}.
     */
    @Test
    public void testClassRule() {
        VarStringBuffer result ;
        ClassProductionRule rule = new ClassProductionRule("head", "returnDec", "initDec", "body", null);
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" + RETURNSTRING + "returnDec" + "]" + INITSTRING + "initDec" +"}" + COLONSTRING + "body" + SEMICOLONSTRING, result.toString());
        
        
        rule = new ClassProductionRule("head", null, "initDec", "body", null);
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" + INITSTRING + "initDec" +"}" +  COLONSTRING + "body" + SEMICOLONSTRING, result.toString());
        
        rule = new ClassProductionRule("head", null, null, "body", null);
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" + COLONSTRING + "body" + SEMICOLONSTRING, result.toString());
        
    }

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule#getLength()}.
     */
    @Test
    public void testOperatorTemplateProductionRule() {
        
        VarStringBuffer result ;
        OperatorTemplateProductionRule rule = new OperatorTemplateProductionRule("head", "paramDec", "returnDec", "initDec", "body");
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" +"[" +"paramDec"+"]"+ RETURNSTRING + "returnDec" + "]" + INITSTRING + "initDec" +"}" + COLONSTRING + "body" + SEMICOLONSTRING + " finally {onExitTemplateRule(metaType);}", result.toString());
        
        rule = new OperatorTemplateProductionRule("head", null, "returnDec", "initDec", "body");
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" + RETURNSTRING + "returnDec" + "]" + INITSTRING + "initDec" +"}" + COLONSTRING + "body" + SEMICOLONSTRING + " finally {onExitTemplateRule(metaType);}", result.toString());
        
        rule = new OperatorTemplateProductionRule("head", null, null, "initDec", "body");
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" + INITSTRING + "initDec" +"}" + COLONSTRING + "body" + SEMICOLONSTRING + " finally {onExitTemplateRule(metaType);}", result.toString());
        
        rule = new OperatorTemplateProductionRule("head", null, null, null, "body");
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" + COLONSTRING + "body" + SEMICOLONSTRING + " finally {onExitTemplateRule(metaType);}", result.toString());
        
    }

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.AbstractAntlr3Rule#addRuleHead(com.sap.furcas.parsergenerator.util.VarStringBuffer)}.
     */
    @Test
    public void testSimpleRule() {
        VarStringBuffer result ;
        SimpleProductionRule rule = new SimpleProductionRule("head", "body");
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" + COLONSTRING + "body" + SEMICOLONSTRING, result.toString());
        
    }
    
    @Test
    public void testSymbolRule() {
        VarStringBuffer result ;
        SymbolProductionRule rule = new SymbolProductionRule("head", "body");
        result = new VarStringBuffer();
        rule.addToSerializationBuffer(result);
        assertEquals("head" + COLONSTRING + "'body'" + SEMICOLONSTRING, result.toString());
        
    }

}
