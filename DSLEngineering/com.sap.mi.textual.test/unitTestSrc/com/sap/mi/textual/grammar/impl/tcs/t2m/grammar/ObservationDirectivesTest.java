/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.textual.tcs.SyntaxLookup;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.AlternativeHandlerStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.BlockTypeHandlerStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.ConditionalElementHandlerStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.PropertyHandlerStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub.SyntaxLookupStub;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.LiteralStub;

/**
 * Tests correct adding of observationDirectives.
 */
public class ObservationDirectivesTest {

    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.ALL;
    }
    
    /**
     * Test method for {@link com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBuffer#append(java.lang.Object)}.
     */
    @Test
    public void testAppendObject() throws Exception {
        SyntaxLookup syntaxLook = new SyntaxLookupStub();
        PropertyTypeHandler prop = new PropertyHandlerStub();
        ConditionalElementHandler conEl = new ConditionalElementHandlerStub();
        BlockTypeHandler block = new BlockTypeHandlerStub();
        AlternativeHandler alt = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(alt, block, conEl, prop, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        LiteralStub seqElement = new LiteralStub();
        seqElement.value = "test";
        buf.addToRuleFragment(seqElement);
        
        assertEquals("{_beforeSeqEl();}test{_afterSeqEl();}", buf.toString());
        
    }
    
}
