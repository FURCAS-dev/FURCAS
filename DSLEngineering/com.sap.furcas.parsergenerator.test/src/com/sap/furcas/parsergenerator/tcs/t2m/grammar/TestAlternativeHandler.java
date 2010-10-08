/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.TCS.stubs.AlternativeStub;
import com.sap.furcas.metamodel.TCS.stubs.SequenceInAlternativeStub;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub.RuleBodyStringBufferStub;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;

/**
 *
 */
public class TestAlternativeHandler {

    @BeforeClass
    public static void setup() {
        ObservationDirectivesHelper.doAddObserverParts = ObservationDirectivesHelper.NONE;
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.AlternativeHandler#addElement(TCS.Alternative, com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddElement() throws Exception {
        // Class under test
        AlternativeHandler althandler = new AlternativeHandler();

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        AlternativeStub element = new AlternativeStub();
        
        althandler.addElement(element, buf);
        assertEquals("", buf.getResult() );
        
        EList<SequenceInAlternative> seqs = new BasicEList<SequenceInAlternative>();
        element.sequences = seqs;
        althandler.addElement(element, buf);
        assertEquals("", buf.getResult() );
        
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.AlternativeHandler#addElement(TCS.Alternative, com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddElementOne() throws Exception {
        // Class under test
        AlternativeHandler althandler = new AlternativeHandler();

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        AlternativeStub element = new AlternativeStub();
        
        althandler.addElement(element, buf);
        assertEquals("", buf.getResult() );
        
        SequenceInAlternativeStub seq = new SequenceInAlternativeStub();
        seq.representation = "Hello";
        EList<SequenceInAlternative> seqs = new BasicEList<SequenceInAlternative>();
        seqs.add(seq);
        
        element.sequences = seqs;
        althandler.addElement(element, buf);
        assertEquals("(Hello)", buf.getResult() );
        
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.AlternativeHandler#addElement(TCS.Alternative, com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddElementTwo() throws Exception {
        // Class under test
        AlternativeHandler althandler = new AlternativeHandler();

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        AlternativeStub element = new AlternativeStub();
        
        althandler.addElement(element, buf);
        assertEquals("", buf.getResult() );
        
        SequenceInAlternativeStub seq = new SequenceInAlternativeStub();
        seq.representation = "Hello";
        SequenceInAlternativeStub seq2 = new SequenceInAlternativeStub();
        seq2.representation = "World";
        EList<SequenceInAlternative> seqs = new BasicEList<SequenceInAlternative>();
        seqs.add(seq);
        seqs.add(seq2);
        
        element.sequences = seqs;
        althandler.addElement(element, buf);
        assertEquals("(Hello\n  |World)", buf.getResult() );
        
    }
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.AlternativeHandler#addElement(TCS.Alternative, com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddElementTwoWithDisambiguate() throws Exception {
        // Class under test
        AlternativeHandler althandler = new AlternativeHandler();

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        AlternativeStub element = new AlternativeStub();
        
        althandler.addElement(element, buf);
        assertEquals("", buf.getResult() );
        
        SequenceInAlternativeStub seq = new SequenceInAlternativeStub();
        seq.representation = "Hello";
        seq.setDisambiguate("TEST");
        SequenceInAlternativeStub seq2 = new SequenceInAlternativeStub();
        seq2.representation = "World";
        EList<SequenceInAlternative> seqs = new BasicEList<SequenceInAlternative>();
        seqs.add(seq);
        seqs.add(seq2);
        
        element.sequences = seqs;
        althandler.addElement(element, buf);
        assertEquals("((TEST) => Hello\n  |World)", buf.getResult() );
        
    }
    
    
    /**
     * Test method for {@link com.sap.furcas.parsergenerator.tcs.t2m.grammar.AlternativeHandler#addElement(TCS.Alternative, com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer)}.
     * @throws SyntaxParsingException 
     * @throws MetaModelLookupException 
     */
    @Test
    public void testAddElementTwoWithMulti() throws Exception {
        // Class under test
        AlternativeHandler althandler = new AlternativeHandler();

        RuleBodyStringBufferStub buf = new RuleBodyStringBufferStub();
        
        AlternativeStub element = new AlternativeStub();
        
        althandler.addElement(element, buf);
        assertEquals("", buf.getResult() );
        
        SequenceInAlternativeStub seq = new SequenceInAlternativeStub();
        seq.representation = "Hello";
        seq.setDisambiguate("TEST");
        SequenceInAlternativeStub seq2 = new SequenceInAlternativeStub();
        seq2.representation = "World";
        EList<SequenceInAlternative> seqs = new BasicEList<SequenceInAlternative>();
        seqs.add(seq);
        seqs.add(seq2);
        
        element.sequences = seqs;
        element.isMulti = true;
        althandler.addElement(element, buf);
        assertEquals("((TEST) => Hello\n  |World)*", buf.getResult() );
        
    }

}
