package com.sap.mi.textual.parsing.textblocks.observer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

<<<<<<< HEAD
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.mi.textual.parsing.textblocks.TextBlockTest;
=======
import textblocks.Eostoken;
import textblocks.TextBlock;

import com.sap.furcas.textual.textblocks.testutils.TextBlockTest;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

public class TestTokenRelocationUtilRelocateUsingSubNodes extends TextBlockTest {
    
    
    @Test
    public void testUpdateLocationNoSubNodes() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(32);
        root.setOffsetRelative(false);
        root.setLength(23);
        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);
        assertEquals(32, root.getOffset());
        assertEquals(23, root.getLength());
        assertEquals(false, root.isOffsetRelative());
     }
    
    @Test (expected = NullPointerException.class)
    public void testUpdateLocationNull() throws Exception {
        // just testing the method does nothing weird
        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(null);
     }
    
    @Test
    public void testUpdateLocationTwoAbsoluteSubNodes() throws Exception {
        // the default case
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(44); // random value to be overwritten
        root.setLength(55); // random value to be overwritten
        root.setOffsetRelative(true);
        TextBlock first = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        first.setParent(root);
        first.setOffset(42);
        first.setLength(13);
        first.setStartRow(3);
        first.setStartColumn(7);
        first.setEndRow(4);
        first.setEndColumn(17);
        first.setOffsetRelative(false);
        
        last.setParent(root);
        last.setOffset(100);
        last.setStartRow(8);
        last.setStartColumn(11);
        last.setEndRow(9);
        last.setEndColumn(13);
        last.setLength(23);
        last.setOffsetRelative(false);
        
        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);
        
        assertEquals(42, root.getOffset());
        assertEquals(123-42, root.getLength());
        assertEquals(3, root.getStartRow());
        assertEquals(7, root.getStartColumn()); 
        assertEquals(9, root.getEndRow());
        assertEquals(13, root.getEndColumn()); 
        assertEquals(false, root.isOffsetRelative());        
        
     // should not change
        assertEquals(42, first.getOffset());
        assertEquals(13, first.getLength()); 
        assertEquals(3, first.getStartRow());
        assertEquals(7, first.getStartColumn()); 
        assertEquals(4, first.getEndRow());
        assertEquals(17, first.getEndColumn()); 
        assertEquals(false, first.isOffsetRelative());
        
        assertEquals(100, last.getOffset());
        assertEquals(23, last.getLength()); 
        assertEquals(8, last.getStartRow());
        assertEquals(11, last.getStartColumn()); 
        assertEquals(9, last.getEndRow());
        assertEquals(13, last.getEndColumn()); 
        assertEquals(false, last.isOffsetRelative());
     }
    
    @Test
    public void testUpdateLocationOneAbsoluteSubNode() throws Exception {
        // the case with just one subnode
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(44); // random value to be overwritten
        root.setLength(55); // random value to be overwritten
        root.setOffsetRelative(true);
        TextBlock first = modelFactory.createTextBlock();
        first.setParent(root);
        first.setOffset(42);
        first.setLength(13);
        first.setStartRow(3);
        first.setStartColumn(7);
        first.setEndRow(4);
        first.setEndColumn(17);
        first.setOffsetRelative(false);

        
        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);
        
        assertEquals(42, root.getOffset());
        assertEquals(13, root.getLength());
        assertEquals(3, root.getStartRow());
        assertEquals(7, root.getStartColumn()); 
        assertEquals(4, root.getEndRow());
        assertEquals(17, root.getEndColumn()); 
        assertEquals(false, root.isOffsetRelative());        
        
     // should not change
        assertEquals(42, first.getOffset());
        assertEquals(13, first.getLength()); 
        assertEquals(3, first.getStartRow());
        assertEquals(7, first.getStartColumn()); 
        assertEquals(4, first.getEndRow());
        assertEquals(17, first.getEndColumn()); 
        assertEquals(false, first.isOffsetRelative());
        

     }
    
    @Test
    public void testUpdateLocationThreeAbsoluteSubNodes() throws Exception {
     // the default case
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(44); // random value to be overwritten
        root.setLength(55); // random value to be overwritten
        root.setOffsetRelative(true);
        TextBlock first = modelFactory.createTextBlock();
        TextBlock middle = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        
        first.setParent(root);
        first.setOffset(42);
        first.setLength(13);
        first.setOffsetRelative(false);
        
        middle.setParent(root);
        middle.setOffset(42);
        middle.setLength(13);
        middle.setOffsetRelative(false);
        
        last.setParent(root);
        last.setOffset(100);
        last.setOffsetRelative(false);
        last.setLength(23);
        
        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);
        
        assertEquals(42, root.getOffset());
        assertEquals(123-42, root.getLength());
        assertEquals(false, root.isOffsetRelative());        
        
     // should not change
        assertEquals(42, first.getOffset());
        assertEquals(13, first.getLength()); 
        assertEquals(false, first.isOffsetRelative());
        
        assertEquals(100, last.getOffset());
        assertEquals(23, last.getLength()); 
        assertEquals(false, last.isOffsetRelative());
     }
    
    @Test
    public void testUpdateLocationTwoAbsoluteSubNodesWithEOS() throws Exception {
        // the case with EOS, which should be ignored
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(44); // random value to be overwritten
        root.setLength(55); // random value to be overwritten
        root.setOffsetRelative(true);
        TextBlock first = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
        Eostoken eos = modelFactory.createEostoken();
        
        first.setParent(root);
        first.setOffset(42);
        first.setLength(13);
        first.setOffsetRelative(false);
        
        last.setParent(root);
        last.setOffset(100);
        last.setOffsetRelative(false);
        last.setLength(23);
        
        eos.setParent(root);
        eos.setOffset(66); // random values to be ignored
        eos.setOffsetRelative(false);
        eos.setLength(33);// random values to be ignored
        
        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);
        
        assertEquals(42, root.getOffset());
        assertEquals(123-42, root.getLength());
        assertEquals(false, root.isOffsetRelative());        
        
     // should not change
        assertEquals(42, first.getOffset());
        assertEquals(13, first.getLength()); 
        assertEquals(false, first.isOffsetRelative());
        
        assertEquals(100, last.getOffset());
        assertEquals(23, last.getLength()); 
        assertEquals(false, last.isOffsetRelative());
     }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUpdateLocationTwoAbsoluteEOSOnly() throws Exception {
        // the case with EOS, which should be ignored
        TextBlock root = modelFactory.createTextBlock();
      
        Eostoken eos = modelFactory.createEostoken();
        
        eos.setParent(root);
        eos.setOffsetRelative(false);

        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);
     }
    
    @Test 
    public void testUpdateLocationRelativeFirstSubnode() throws Exception {
        // the case with EOS, which should be ignored
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(65); // random number, should remain same under these special circumstances, see method docu
        root.setLength(77);
        root.setOffsetRelative(true); // should remain true in this special case wher first subnode is relative
        
        TextBlock first = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
       
        first.setParent(root);
        first.setOffset(42);
        first.setLength(13);
        first.setOffsetRelative(true);
        
        last.setParent(root);
        last.setOffset(100);
        last.setOffsetRelative(false);
        last.setLength(23);
                
        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);

        assertEquals(65, root.getOffset());
        assertEquals(123-65, root.getLength());
        assertEquals(true, root.isOffsetRelative());        
     }
    
    
    @Test (expected = IllegalArgumentException.class)
    public void testUpdateLocationNegativeFirstSubnode() throws Exception {
        // the case with EOS, which should be ignored
        TextBlock root = modelFactory.createTextBlock();
      
        TextBlock first = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
       
        first.setParent(root);
        first.setOffsetRelative(false);
        first.setOffset(-22);
        
        last.setParent(root);
        last.setOffsetRelative(false);
        

        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);

     }
    
    @Test (expected = IllegalArgumentException.class)
    public void testUpdateLocationNegativeLastSubnode() throws Exception {
        // the case with EOS, which should be ignored
        TextBlock root = modelFactory.createTextBlock();
      
        TextBlock first = modelFactory.createTextBlock();
        TextBlock last = modelFactory.createTextBlock();
       
        first.setParent(root);
        first.setOffsetRelative(false);
        
        
        last.setParent(root);
        last.setOffsetRelative(false);
        last.setOffset(-22);

        TokenRelocationUtil.updateTextBlockLocationUsingSubNodesAfterAdding(root);

     }
    
    
}
