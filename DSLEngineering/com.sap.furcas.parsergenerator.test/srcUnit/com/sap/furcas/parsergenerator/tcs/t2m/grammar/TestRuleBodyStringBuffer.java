/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.AlternativeStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.BlockStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.ConditionalElementStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.FunctionCallStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.FunctionTemplateStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.LiteralRefStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.LiteralStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.PropertyStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.SequenceElementStub;
import com.sap.furcas.metamodel.FURCAS.TCS.stubs.SequenceStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.PropertyQuantityConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.AlternativeHandlerStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.BlockTypeHandlerStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.ConditionalElementHandlerStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.PropertyHandlerStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.SyntaxLookupStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.TemplateNamingHelperStub;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.test.parsing.testutils.StringListHelper;

/**
 *
 */
public class TestRuleBodyStringBuffer {

    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#append(java.lang.Object)}.
     */
    @Test
    public void testAppendObject() {
        SyntaxLookup syntaxLook = new SyntaxLookupStub();
        PropertyTypeHandler prop = new PropertyHandlerStub();
        ConditionalElementHandler conEl = new ConditionalElementHandlerStub();
        BlockTypeHandler block = new BlockTypeHandlerStub();
        AlternativeHandler alt = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(alt, block, conEl, prop, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        buf.append("test");
        assertEquals("test", buf.getResult());
        assertEquals("test", buf.toString());
        
        buf.append('c');
        assertEquals("testc", buf.getResult());
        assertEquals("testc", buf.toString());
        
        buf.append("1", "2", 3 ,"4");
        assertEquals("testc1234", buf.getResult());
        assertEquals("testc1234", buf.toString());
        
    }

    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentAlternative() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        Alternative alternative = new AlternativeStub();
        buf.addToRuleFragment(alternative);
        
        // check the Handler has been called
        assertEquals(1, altHandler.elements.size());
        assertEquals(1, altHandler.buffers.size());
        assertTrue(altHandler.elements.contains(alternative));
        assertTrue(altHandler.buffers.contains(buf));
        
        Alternative alternative2 = new AlternativeStub();
        buf.addToRuleFragment(alternative2);
        
        assertEquals(2, altHandler.elements.size());
        assertEquals(2, altHandler.buffers.size());
        assertTrue(altHandler.elements.contains(alternative));
        assertTrue(altHandler.elements.contains(alternative2));
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentBlock() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        BlockStub block = new BlockStub();
        buf.addToRuleFragment(block);
        
        // check the Handler has been called
        assertEquals(1, blockHandler.elements.size());
        assertEquals(1, blockHandler.buffers.size());
        assertTrue(blockHandler.elements.contains(block));
        assertTrue(blockHandler.buffers.contains(buf));
        
        BlockStub block2 = new BlockStub();
        buf.addToRuleFragment(block2);
        
        assertEquals(2, blockHandler.elements.size());
        assertEquals(2, blockHandler.buffers.size());
        assertTrue(blockHandler.elements.contains(block));
        assertTrue(blockHandler.elements.contains(block2));
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentSequence() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        SequenceStub block = new SequenceStub();
        buf.addToRuleFragment(block);
        
        // check the Handler has been called (blockhandler also deals with sequences)
        assertEquals(1, blockHandler.elements.size());
        assertEquals(1, blockHandler.buffers.size());
        assertTrue(blockHandler.elements.contains(block));
        assertTrue(blockHandler.buffers.contains(buf));
        
        SequenceStub block2 = new SequenceStub();
        buf.addToRuleFragment(block2);
        
        assertEquals(2, blockHandler.elements.size());
        assertEquals(2, blockHandler.buffers.size());
        assertTrue(blockHandler.elements.contains(block));
        assertTrue(blockHandler.elements.contains(block2));
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentProperty() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        PropertyStub prop = new PropertyStub();
        buf.addToRuleFragment(prop);
        
        // check the Handler has been called
        assertEquals(1, propHandler.elements.size());
        assertEquals(1, propHandler.buffers.size());
        assertTrue(propHandler.elements.contains(prop));
        assertTrue(propHandler.buffers.contains(buf));
        
        PropertyStub prop2 = new PropertyStub();
        buf.addToRuleFragment(prop2);
        
        assertEquals(2, propHandler.elements.size());
        assertEquals(2, propHandler.buffers.size());
        assertTrue(propHandler.elements.contains(prop));
        assertTrue(propHandler.elements.contains(prop2));
    }

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentLiteral() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        LiteralStub lit = new LiteralStub();
        lit.setValue("Hello");
        buf.addToRuleFragment(lit);
        assertEquals("Hello", buf.getResult());
        
        lit = new LiteralStub();
        lit.setValue("World");
        buf.addToRuleFragment(lit);
        assertEquals("HelloWorld", buf.getResult());

        lit.setValue("Again");
        buf.addToRuleFragment(lit);
        assertEquals("HelloWorldAgain", buf.getResult());
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentFunctionCall() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        
        TemplateNamingHelperStub namingHelper = new TemplateNamingHelperStub()
        ;
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, namingHelper, null, null );

        
        FunctionCallStub fc = new FunctionCallStub();
        FunctionTemplateStub funcTemplate = new FunctionTemplateStub();
        // Naming helper stub uses names instead of functionName, as the real helper would do
        funcTemplate.names = StringListHelper.list( "funcName");
        funcTemplate.functionName = "error";
        fc.template = funcTemplate;
        buf.addToRuleFragment(fc);
        assertEquals("funcName[ret]", buf.getResult());
        
        funcTemplate.names = StringListHelper.list( "otherName");
        
        buf.addToRuleFragment(fc);
        assertEquals("funcName[ret]otherName[ret]", buf.getResult());
    }

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentLiteralRef() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        LiteralRefStub litRef = new LiteralRefStub();
        
        LiteralStub lit = new LiteralStub();
        litRef.setReferredLiteral(lit);
        lit.setValue("Hello");
        buf.addToRuleFragment(litRef);
        // syntaxLookupStub adds "Rule-"
        assertEquals("Rule-Hello", buf.getResult());
        
        litRef = new LiteralRefStub();
        lit.setValue("Again");
        litRef.setReferredLiteral(lit);
        buf.addToRuleFragment(litRef);
        assertEquals("Rule-HelloRule-Again", buf.getResult());
    }

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentConditionalElement() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        ConditionalElementStub prop = new ConditionalElementStub();
        buf.addToRuleFragment(prop);
        
        // check the Handler has been called
        assertEquals(1, conElHandler.elements.size());
        assertEquals(1, conElHandler.buffers.size());
        assertTrue(conElHandler.elements.contains(prop));
        assertTrue(conElHandler.buffers.contains(buf));
        
        ConditionalElementStub prop2 = new ConditionalElementStub();
        buf.addToRuleFragment(prop2);
        
        assertEquals(2, conElHandler.elements.size());
        assertEquals(2, conElHandler.buffers.size());
        assertTrue(conElHandler.elements.contains(prop));
        assertTrue(conElHandler.elements.contains(prop2));
    }

    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragment() throws Exception {
        SyntaxLookup syntaxLook = new SyntaxLookupStub();
        PropertyTypeHandler prop = new PropertyHandlerStub();
        ConditionalElementHandler conEl = new ConditionalElementHandlerStub();
        BlockTypeHandler block = new BlockTypeHandlerStub();
        AlternativeHandler alt = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(alt, block, conEl, prop, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        boolean excCaught = false;
        try {
            SequenceElementStub element = new SequenceElementStub();
            buf.addToRuleFragment(element);
        } catch (RuntimeException rte) {
            excCaught = true;
        }
        assertTrue("Should throw exception since SequenceElementStub should not be writable element.", excCaught);
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentNull() throws Exception {
        SyntaxLookup syntaxLook = new SyntaxLookupStub();
        PropertyTypeHandler prop = new PropertyHandlerStub();
        ConditionalElementHandler conEl = new ConditionalElementHandlerStub();
        BlockTypeHandler block = new BlockTypeHandlerStub();
        AlternativeHandler alt = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(alt, block, conEl, prop, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
   
        buf.addToRuleFragment((Sequence)null);
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        buf.addToRuleFragment((SequenceElement)null);
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
    }

    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentMissingLiteral() throws Exception {
        SyntaxLookup syntaxLook = new SyntaxLookupStub();
        PropertyTypeHandler prop = new PropertyHandlerStub();
        ConditionalElementHandler conEl = new ConditionalElementHandlerStub();
        BlockTypeHandler block = new BlockTypeHandlerStub();
        AlternativeHandler alt = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(alt, block, conEl, prop, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        boolean excCaught = false;
        try {
            LiteralRefStub element = new LiteralRefStub();
            buf.addToRuleFragment(element);
        } catch (RuntimeException rte) {
            excCaught = true;
        }
        assertTrue("Should throw exception since LiteralRef has no refertred literal.", excCaught);
    }

    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddToRuleFragmentAll() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        Alternative alternative = new AlternativeStub();
        buf.addToRuleFragment(alternative);
        Alternative alternative2 = new AlternativeStub();
        buf.addToRuleFragment(alternative2);
        
        BlockStub block = new BlockStub();
        buf.addToRuleFragment(block);
        BlockStub block2 = new BlockStub();
        buf.addToRuleFragment(block2);
        
        PropertyStub prop = new PropertyStub();
        buf.addToRuleFragment(prop);
        PropertyStub prop2 = new PropertyStub();
        buf.addToRuleFragment(prop2);
        
        SequenceStub seq = new SequenceStub();
        buf.addToRuleFragment(seq);   
        SequenceStub seq2 = new SequenceStub();
        buf.addToRuleFragment(seq2);
        
   
        
        assertEquals(2, propHandler.elements.size());
        assertEquals(2, propHandler.buffers.size());
        assertTrue(propHandler.elements.contains(prop));
        assertTrue(propHandler.elements.contains(prop2));
        
        assertEquals(4, blockHandler.elements.size());
        assertEquals(4, blockHandler.buffers.size());
        assertTrue(blockHandler.elements.contains(seq));
        assertTrue(blockHandler.elements.contains(seq2));
        assertTrue(blockHandler.elements.contains(block));
        assertTrue(blockHandler.elements.contains(block2));
        
        assertEquals(2, altHandler.elements.size());
        assertEquals(2, altHandler.buffers.size());
        assertTrue(altHandler.elements.contains(alternative));
        assertTrue(altHandler.elements.contains(alternative2));
    }
    
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer#addToRuleFragment(TCS.LocatedElement)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAppends() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        
        assertNotNull(buf.getResult());
        assertEquals("", buf.getResult());
        
        buf.append("Test");
        assertEquals("Test", buf.getResult());
        
        buf.append((Object)null);
        assertEquals("Test", buf.getResult());
        
        buf.append((Object[])null);
        assertEquals("Test", buf.getResult());
        
        
        // generic object with toString Method to be called, this is a white box test
        buf.append(new Object() {
          @Override
	public String toString() { return "HelloWorld";}  
        }
        );
        
        assertEquals("TestHelloWorld", buf.getResult());
        
        String[] array = new String[] {"1", null, "3"};
        buf.append(array);
        assertEquals("TestHelloWorld1null3", buf.getResult());
    }
    
    @Test
    public void testConstraints() throws Exception {
        SyntaxLookupStub syntaxLook = new SyntaxLookupStub();
        PropertyHandlerStub propHandler = new PropertyHandlerStub();
        ConditionalElementHandlerStub conElHandler = new ConditionalElementHandlerStub();
        BlockTypeHandlerStub blockHandler = new BlockTypeHandlerStub();
        AlternativeHandlerStub altHandler = new AlternativeHandlerStub();
        RuleBodyStringBuffer buf = new RuleBodyStringBuffer(altHandler, blockHandler, conElHandler, propHandler, syntaxLook, null, null, null);
        assertNotNull(buf);
        assertNotNull(buf.getCurrentConstraints());
        assertEquals(0, buf.getCurrentConstraints().size());
        
        // test add / remove
        String property = "propName";
        RuleBodyPropertyConstraint con = buf.setPropertyConstraint(new PropertyQuantityConstraint(property , 1, false));
        assertEquals(1, buf.getCurrentConstraints().size());
        assertEquals(con, buf.getCurrentConstraints().get(0));
        buf.removeConstraint(con);
        assertEquals(0, buf.getCurrentConstraints().size());
       
        
        // Test multiple add / remove
        String property2 = "propName2";
        RuleBodyPropertyConstraint con1 = buf.setPropertyConstraint(new PropertyQuantityConstraint(property, 1, false));
        RuleBodyPropertyConstraint con2 = buf.setPropertyConstraint(new PropertyQuantityConstraint(property2, 2, true));
        assertEquals(2, buf.getCurrentConstraints().size());
        buf.removeConstraint(con2);
        buf.removeConstraint(con1);
        assertEquals(0, buf.getCurrentConstraints().size());
        
     // Test multiple badly ordered add / remove
        property2 = "propName2";
        con1 = buf.setPropertyConstraint(new PropertyQuantityConstraint(property, 1, false));
        con2 = buf.setPropertyConstraint(new PropertyQuantityConstraint(property2, 2, true));
        assertEquals(2, buf.getCurrentConstraints().size());
        boolean caught = false;
        try {
            buf.removeConstraint(con1);
        } catch (RuntimeException e) {
             caught = true;
        }
        assertTrue("Expected Exception because order of remove did is inconsitent with order of add", caught);
        
    }
}
