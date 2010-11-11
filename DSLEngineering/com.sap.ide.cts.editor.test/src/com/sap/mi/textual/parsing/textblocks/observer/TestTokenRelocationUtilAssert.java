package com.sap.mi.textual.parsing.textblocks.observer;

import org.junit.Test;

<<<<<<< HEAD
import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.mi.textual.parsing.textblocks.TbValidationUtil;
import com.sap.mi.textual.parsing.textblocks.TextBlockTest;
=======
import textblocks.Bostoken;
import textblocks.Eostoken;
import textblocks.TextBlock;

import com.sap.furcas.textual.textblocks.TbValidationUtil;
import com.sap.furcas.textual.textblocks.testutils.TextBlockTest;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

public class TestTokenRelocationUtilAssert extends TextBlockTest {
    
    
    @Test
    public void testAssertRootAbsolute() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        TbValidationUtil.assertTextBlockConsistency(root);
        
        first.setOffset(0);
        first.setOffsetRelative(true);
        
        TbValidationUtil.assertTextBlockConsistency(root);
        
        middle.setOffset(20);
        middle.setOffsetRelative(true);
        
        TbValidationUtil.assertTextBlockConsistency(root);
        
        last.setOffset(40);
        last.setOffsetRelative(true);
        
        TbValidationUtil.assertTextBlockConsistency(root);
     }
    
    @Test
    public void testAssertRootRelative() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        TextBlock rootroot = modelFactory.createTextBlock();
        rootroot.setOffsetRelative(false);
        rootroot.setOffset(5);
        root.setOffset(5);
        root.setOffsetRelative(true);
        root.setParent(rootroot);
        
        TbValidationUtil.assertTextBlockConsistency(root);
        
        first.setOffset(0);
        first.setOffsetRelative(true);
        
        TbValidationUtil.assertTextBlockConsistency(root);
        
        middle.setOffset(20);
        middle.setOffsetRelative(true);
        
        TbValidationUtil.assertTextBlockConsistency(root);
        
        last.setOffset(40);
        last.setOffsetRelative(true);
        
        TbValidationUtil.assertTextBlockConsistency(root);
     }

  
    @Test (expected = IllegalStateException.class)
    public void testAssertGapFront() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        first.setOffset(11); // was 10, now is 11
        TbValidationUtil.assertTextBlockConsistency(root);
    }
    
    @Test (expected = IllegalStateException.class)
    public void testAssertGapMiddle() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        middle.setOffset(31); // was 30, now is 31
        TbValidationUtil.assertTextBlockConsistency(root);
    }
    
    @Test (expected = IllegalStateException.class)
    public void testAssertNegativeOffSet() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(-2);
        TbValidationUtil.assertTextBlockConsistency(root);
    }
    
    @Test (expected = IllegalStateException.class)
    public void testAssertNegativeLength() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        root.setLength(-4);
        TbValidationUtil.assertTextBlockConsistency(root);
    }
    
    @Test (expected = IllegalStateException.class)
    public void testAssertOverlap() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        middle.setOffset(29); // was 30, now is 29
        TbValidationUtil.assertTextBlockConsistency(root);
    }
    
    @Test (expected = IllegalStateException.class)
    public void testAssertTooLong() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        last.setLength(21); // was 20, now is 22
        TbValidationUtil.assertTextBlockConsistency(root);
    }
    
    @Test (expected = IllegalStateException.class)
    public void testAssertTooShort() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        last.setLength(19); // was 20, now is 19
        TbValidationUtil.assertTextBlockConsistency(root);
    }
    
    @Test
    public void testAssertNullLengthBOSEOS() throws Exception {
        
        TextBlock root = modelFactory.createTextBlock();
        Bostoken bos = modelFactory.createBostoken();
        bos.setParent(root);
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        Eostoken eos = modelFactory.createEostoken();
        eos.setParent(root);
        eos.setOffset(70); // not sure whether we should assume this in the test
     // since we include BOS, need to start at offset 0
        root.setOffset(0);
        root.setLength(70); 
        first.setOffset(0);
        first.setLength(30);
        
        TbValidationUtil.assertTextBlockConsistency(root);
    }
    
    
    /**
     * util fixture
     * @param root
     * @param first
     * @param middle
     * @param last
     */
    private void setupFourNodeFixtureAbsolute(TextBlock root, TextBlock first,
            TextBlock middle, TextBlock last) {
        
        root.setOffset(10); // random value to be overwritten
        root.setLength(60); // random value to be overwritten
        root.setOffsetRelative(false);
        
        first.setParent(root);
        first.setOffset(10);
        first.setLength(20);
        first.setOffsetRelative(false);
        
        middle.setParent(root);
        middle.setOffset(30);
        middle.setLength(20);
        middle.setOffsetRelative(false);
        
        last.setParent(root);
        last.setOffset(50);
        last.setLength(20);
        last.setOffsetRelative(false);
    }
    
}
