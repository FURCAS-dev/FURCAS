package com.sap.mi.textual.parsing.textblocks.observer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

<<<<<<< HEAD
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.mi.textual.parsing.textblocks.TextBlockTest;
=======
import textblocks.TextBlock;

import com.sap.furcas.textual.textblocks.testutils.TextBlockTest;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

public class TestTokenRelocationUtilRelocateAfterRemoval extends TextBlockTest {
    
    
    @Test
    public void testUpdateLocationNoSubNodes() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(32);
        root.setOffsetRelative(false);
        root.setLength(23);
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        // no change nor exception expected
        assertEquals(32, root.getOffset());
        assertEquals(23, root.getLength());
        assertEquals(false, root.isOffsetRelative());
     }
    
    @Test (expected = NullPointerException.class)
    public void testUpdateLocationNull() throws Exception {
        // just testing the method does nothing weird
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(null);
     }
    
    @Test
    public void testUpdateLocationRemoveFirstAbsolute() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        root.getSubBlocks().remove(first);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(30, root.getOffset());
        assertEquals(40, root.getLength());
    }
    
    @Test
    public void testUpdateLocationRemoveFirstLastAbsolute() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        root.getSubBlocks().remove(first);
        root.getSubBlocks().remove(last);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(30, root.getOffset());
        assertEquals(20, root.getLength());
    }
    
    @Test
    public void testUpdateLocationRemoveMiddleAbsolute() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        root.getSubBlocks().remove(middle); // inconsistent case, but not relevant to method
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(10, root.getOffset());
        assertEquals(60, root.getLength());
    }
    
    @Test
    public void testUpdateLocationRemoveFirstTwoAbsolute() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        root.getSubBlocks().remove(first);
        root.getSubBlocks().remove(middle);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(50, root.getOffset());
        assertEquals(20, root.getLength());
    }
    
    @Test
    public void testUpdateLocationRemoveLastTwoAbsolute() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        root.getSubBlocks().remove(middle);
        root.getSubBlocks().remove(last);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(10, root.getOffset());
        assertEquals(20, root.getLength());
    }
    
    @Test
    public void testUpdateLocationRemoveLastAbsolute() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        root.getSubBlocks().remove(last);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(10, root.getOffset());
        assertEquals(40, root.getLength());
    }

    
    /* relative offset tests */
    
    @Test
    public void testUpdateLocationRemoveLastRootRelative() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        TextBlock rootroot = modelFactory.createTextBlock();
        root.setParent(rootroot);
        rootroot.setOffsetRelative(false);
        rootroot.setOffset(5);
        root.setOffsetRelative(true);
        root.setOffset(5); // root offset must be same as first subnode absolute offset
        
        root.getSubBlocks().remove(last);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(5, root.getOffset());
        assertEquals(40, root.getLength());
        assertEquals(false, root.isOffsetRelative());
    }
    
    @Test
    public void testUpdateLocationRemoveFirstRootRelative() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        TextBlock rootroot = modelFactory.createTextBlock();
        root.setParent(rootroot);
        rootroot.setOffsetRelative(false);
        rootroot.setOffset(5);
        root.setOffsetRelative(true);
        root.setOffset(5); // root offset must be same as first subnode absolute offset
        
        root.getSubBlocks().remove(first);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(30, root.getOffset()); // new absolute offset == middle.absoluteOffSet
        assertEquals(40, root.getLength());
        assertEquals(false, root.isOffsetRelative());
    }
    
    
    @Test (expected = IllegalStateException.class)
    public void testUpdateLocationRemoveLastRootRelativeInconsistent() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        TextBlock rootroot = modelFactory.createTextBlock();
        root.setParent(rootroot);
        rootroot.setOffsetRelative(false);
        rootroot.setOffset(5);
        root.setOffsetRelative(true);
        
        root.getSubBlocks().remove(last);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
    }
    
    @Test
    public void testUpdateLocationRemoveLastSubRelative() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        first.setOffsetRelative(true);
        first.setOffset(0);
        root.getSubBlocks().remove(last);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(10, root.getOffset());
        assertEquals(40, root.getLength());
    }
    
    @Test
    public void testUpdateLocationAllSubRelative() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        
        first.setOffsetRelative(true); // absoluteOffset of first = 20
        middle.setOffsetRelative(true); // absoluteOffset of middle = 40
        last.setOffset(60); // keep last one absolute for fun 
        // this is as if a virtual first node of length 10 had been removed previously
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        // root offset was 10 absolute, first relativeOffset is 10, so root offset should increase by 10 absolute
        
        assertEquals(20, root.getOffset());
        assertEquals(60, root.getLength());
        
        // all relative offsets shift by -20
        assertEquals(0, first.getOffset());
        assertEquals(20, middle.getOffset());
        assertEquals(60, last.getOffset()); // absolute offset immune
    }
    
    @Test
    public void testUpdateLocationRemoveFirstLastRelative() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        setupFourNodeFixtureAbsolute(root, first, middle, last);
        last.setOffsetRelative(true);
        last.setOffset(40);
        
        root.getSubBlocks().remove(first);
        
        TokenRelocationUtil.updateTextBlockLocationAfterRemoval(root);
        
        assertEquals(30, root.getOffset());
        assertEquals(40, root.getLength());
        
        assertEquals(20, last.getOffset()); // relative offset must have changed since textblock offset changed
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
