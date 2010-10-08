package com.sap.mi.textual.parsing.textblocks.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

<<<<<<< HEAD
import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.parsing.textblocks.observer.TokenRelocationUtil;
import com.sap.mi.textual.parsing.textblocks.TextBlockTest;
=======
import textblocks.AbstractToken;
import textblocks.Eostoken;
import textblocks.LexedToken;
import textblocks.TextBlock;

import com.sap.furcas.textual.textblocks.testutils.TextBlockTest;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

/**
 * tests several methods of that util class
 */
public class TestTokenRelocationUtil extends TextBlockTest {


    
    
    // should never happen, therefore nullPointer is acceptable
    @Test (expected = NullPointerException.class)
    public void testMoveTokensNull() throws Exception {
        TokenRelocationUtil.moveTokens(null, null);
    }

    // should never happen, therefore nullPointer is acceptable
    @Test(expected = NullPointerException.class)
    public void testMoveTokensNullTokens() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TokenRelocationUtil.moveTokens(null, root);
    }
    

    @Test
    public void testMoveTokensNullBlock() throws Exception {
        // moves tokens to null parent
        TextBlock root = modelFactory.createTextBlock();
        List<AbstractToken> tokens = new ArrayList<AbstractToken>();
        LexedToken token = modelFactory.createLexedToken();
        token.setParent(root);
        tokens.add(token);
        boolean moved = TokenRelocationUtil.moveTokens(tokens, null);
        assertTrue(moved);
        assertNull(token.getParent());
    }

    @Test
    public void testMoveTokensNoTokens() throws Exception {
        List<AbstractToken> tokens = new ArrayList<AbstractToken>();

        boolean moved = TokenRelocationUtil.moveTokens(tokens, null);
        assertFalse(moved);
    }
    
    @Test
    public void testMoveTokensNoMove() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        List<AbstractToken> tokens = new ArrayList<AbstractToken>();
        LexedToken token = modelFactory.createLexedToken();
        token.setParent(root);
        tokens.add(token);
        // should not move anything, since token is already in Block
        boolean moved = TokenRelocationUtil.moveTokens(tokens, root);
        assertFalse(moved);
    }
    
    @Test
    public void testInsertTokens() throws Exception {
        TextBlock target = modelFactory.createTextBlock();
        assertEquals(0, target.getTokens().size());
        LexedToken token = modelFactory.createLexedToken();
        
        TokenRelocationUtil.insertToken(target, token);
        
        assertEquals(1, target.getTokens().size());
        assertEquals(token, target.getTokens().get(0));
    }

    @Test
    public void testInsertTokensFromTo() throws Exception {
        TextBlock target = modelFactory.createTextBlock();
        TextBlock source = modelFactory.createTextBlock();
        LexedToken token = modelFactory.createLexedToken();
        token.setParent(source);
        assertEquals(0, target.getTokens().size());
        assertEquals(1, source.getTokens().size());
        
        TokenRelocationUtil.insertToken(target, token);
        
        assertEquals(1, target.getTokens().size());
        assertEquals(0, source.getTokens().size());
        assertEquals(token, target.getTokens().get(0));
    }
    
    @Test
    public void testInsertEnd() throws Exception {
        TextBlock target = modelFactory.createTextBlock();
        LexedToken existing1 = modelFactory.createLexedToken();
        existing1.setOffset(10);
        existing1.setParent(target);
        LexedToken existing2 = modelFactory.createLexedToken();
        existing2.setOffset(20);
        existing2.setParent(target);
        TextBlock source = modelFactory.createTextBlock();
        LexedToken token = modelFactory.createLexedToken();
        token.setOffset(25);
        token.setParent(source);
        assertEquals(2, target.getTokens().size());
        assertEquals(1, source.getTokens().size());
        
        TokenRelocationUtil.insertToken(target, token);
        
        assertEquals(3, target.getTokens().size());
        assertEquals(0, source.getTokens().size());
        assertEquals(token, target.getTokens().get(2));
    }
    
    @Test
    public void testInsertStart() throws Exception {
        TextBlock target = modelFactory.createTextBlock();
        LexedToken existing1 = modelFactory.createLexedToken();
        existing1.setOffset(10);
        existing1.setParent(target);
        LexedToken existing2 = modelFactory.createLexedToken();
        existing2.setOffset(20);
        existing2.setParent(target);
        TextBlock source = modelFactory.createTextBlock();
        LexedToken token = modelFactory.createLexedToken();
        token.setOffset(5);
        token.setParent(source);
        assertEquals(2, target.getTokens().size());
        assertEquals(1, source.getTokens().size());
        
        TokenRelocationUtil.insertToken(target, token);
        
        assertEquals(3, target.getTokens().size());
        assertEquals(0, source.getTokens().size());
        assertEquals(token, target.getTokens().get(0));
    }
    
    @Test
    public void testInsertMiddle() throws Exception {
        TextBlock target = modelFactory.createTextBlock();
        LexedToken existing1 = modelFactory.createLexedToken();
        existing1.setOffset(10);
        existing1.setParent(target);
        LexedToken existing2 = modelFactory.createLexedToken();
        existing2.setOffset(20);
        existing2.setParent(target);
        TextBlock source = modelFactory.createTextBlock();
        LexedToken token = modelFactory.createLexedToken();
        token.setOffset(15);
        token.setParent(source);
        assertEquals(2, target.getTokens().size());
        assertEquals(1, source.getTokens().size());
        
        TokenRelocationUtil.insertToken(target, token);
        
        assertEquals(3, target.getTokens().size());
        assertEquals(0, source.getTokens().size());
        assertEquals(token, target.getTokens().get(1));
    }
    
    @Test
    public void testInsertEndRelative() throws Exception {
        TextBlock target = modelFactory.createTextBlock();
        target.setOffset(6);
        target.setOffsetRelative(false);
        LexedToken existing1 = modelFactory.createLexedToken();
        existing1.setOffset(4);
        existing1.setOffsetRelative(true);
        existing1.setParent(target);
        LexedToken existing2 = modelFactory.createLexedToken();
        existing2.setOffset(14);
        existing2.setOffsetRelative(true);
        existing2.setParent(target);
        TextBlock source = modelFactory.createTextBlock();
        LexedToken token = modelFactory.createLexedToken();
        source.setOffset(25);
        source.setOffsetRelative(false);
        token.setOffset(0);
        token.setOffsetRelative(true);
        token.setParent(source);
        assertEquals(2, target.getTokens().size());
        assertEquals(1, source.getTokens().size());
        
        TokenRelocationUtil.insertToken(target, token);
        
        assertEquals(3, target.getTokens().size());
        assertEquals(0, source.getTokens().size());
        assertEquals(token, target.getTokens().get(2));
    }
    
    @Test
    public void testInsertStartRelative() throws Exception {
        TextBlock target = modelFactory.createTextBlock();
        target.setOffset(6);
        LexedToken existing1 = modelFactory.createLexedToken();
        existing1.setOffset(4);
        existing1.setOffsetRelative(true);
        existing1.setParent(target);
        LexedToken existing2 = modelFactory.createLexedToken();
        existing2.setOffset(14);
        existing2.setOffsetRelative(true);
        existing2.setParent(target);
        TextBlock source = modelFactory.createTextBlock();
        LexedToken token = modelFactory.createLexedToken();
        source.setOffset(5);
        token.setOffset(0);
        token.setOffsetRelative(true);
        token.setParent(source);
        assertEquals(2, target.getTokens().size());
        assertEquals(1, source.getTokens().size());
        
        TokenRelocationUtil.insertToken(target, token);
        
        assertEquals(3, target.getTokens().size());
        assertEquals(0, source.getTokens().size());
        assertEquals(token, target.getTokens().get(0));
    }
    
    @Test
    public void testInsertMiddleRelative() throws Exception {
        TextBlock target = modelFactory.createTextBlock();
        target.setOffset(6);
        LexedToken existing1 = modelFactory.createLexedToken();
        existing1.setOffset(4);
        existing1.setOffsetRelative(true);
        existing1.setParent(target);
        LexedToken existing2 = modelFactory.createLexedToken();
        existing2.setOffset(14);
        existing2.setOffsetRelative(true);
        existing2.setParent(target);
        TextBlock source = modelFactory.createTextBlock();
        LexedToken token = modelFactory.createLexedToken();
        source.setOffset(15);
        token.setOffset(0);
        token.setOffsetRelative(true);
        token.setParent(source);
        assertEquals(2, target.getTokens().size());
        assertEquals(1, source.getTokens().size());
        
        TokenRelocationUtil.insertToken(target, token);
        
        assertEquals(3, target.getTokens().size());
        assertEquals(0, source.getTokens().size());
        assertEquals(token, target.getTokens().get(1));
    }
    
    @Test
    public void testMoveTokensMoveAll() throws Exception {
        // default case
        TextBlock root = modelFactory.createTextBlock();
        TextBlock source = modelFactory.createTextBlock();
        TextBlock target = modelFactory.createTextBlock();
        source.setParent(root);
        target.setParent(root);
        
        
        LexedToken token = modelFactory.createLexedToken();
        token.setParent(source);
        LexedToken token2 = modelFactory.createLexedToken();
        token2.setParent(source);
        
        List<AbstractToken> tokens = new ArrayList<AbstractToken>();
        tokens.add(token);
        tokens.add(token2);

        boolean moved = TokenRelocationUtil.moveTokens(tokens, target);
        assertTrue(moved);
        
        assertEquals(1, root.getSubBlocks().size()); // assert source has been deleted
        assertEquals(target, root.getSubBlocks().get(0));
        assertEquals(2, target.getTokens().size());
        assertEquals(token, target.getTokens().get(0));
        assertEquals(token2, target.getTokens().get(1));
        
    }
    
    @Test
    public void testMoveTokensUpdateTargetLocationAndTargetParentLocation() throws Exception {

        TextBlock root = modelFactory.createTextBlock();   // empty target model for testing of update of parent location    
        TextBlock target = modelFactory.createTextBlock();
        target.setParent(root);
        
        LexedToken token = modelFactory.createLexedToken();
        token.setOffset(12);
        token.setLength(13);
        token.setOffsetRelative(false);
        LexedToken token2 = modelFactory.createLexedToken();
        token2.setOffset(25);
        token2.setLength(15);
        token2.setOffsetRelative(false);
        
        List<AbstractToken> tokens = new ArrayList<AbstractToken>();
        tokens.add(token);
        tokens.add(token2);

        boolean moved = TokenRelocationUtil.moveTokens(tokens, target);
        assertTrue(moved);
        
        assertEquals(1, root.getSubBlocks().size()); // assert target still exists
        assertEquals(target, root.getSubBlocks().get(0));
        
        assertEquals(2, target.getTokens().size());
        assertEquals(token, target.getTokens().get(0));
        assertEquals(token2, target.getTokens().get(1));
        
        // now assert locations have been updated correctly
        assertEquals(12, target.getOffset());
        assertEquals(28, target.getLength());
        assertEquals(12, root.getOffset()); // assumes parents have to be updated by moveTokens
        assertEquals(28, root.getLength());
    }
    
    @Test
    public void testMoveTokenWithoutParent() throws Exception {
        // checks no nullpointer occurs if a token without parent block is passed in

        TextBlock target = modelFactory.createTextBlock();

        
        LexedToken token = modelFactory.createLexedToken();
        
        List<AbstractToken> tokens = new ArrayList<AbstractToken>();
        tokens.add(token);

        boolean moved = TokenRelocationUtil.moveTokens(tokens, target);
        assertTrue(moved);

        assertEquals(1, target.getTokens().size());
        assertEquals(token, target.getTokens().get(0));
        
    }
    
  
    
    @Test
    public void testMoveTokensMoveSome() throws Exception {
        // default case
        TextBlock source = modelFactory.createTextBlock();
        TextBlock target = modelFactory.createTextBlock();
        
        
        LexedToken token = modelFactory.createLexedToken();
        token.setParent(source);
        LexedToken token2 = modelFactory.createLexedToken();
        token2.setParent(source);
        token2.setOffsetRelative(false);
        token2.setOffset(10);
        token2.setLength(17);
        
        List<AbstractToken> tokens = new ArrayList<AbstractToken>();
        tokens.add(token);
        // token2 stay in source
        
        boolean moved = TokenRelocationUtil.moveTokens(tokens, target);
        assertTrue(moved);
        
        assertEquals(1, source.getTokens().size());
        assertEquals(1, target.getTokens().size());
        assertEquals(token, target.getTokens().get(0));
        assertEquals(token2, source.getTokens().get(0));
        
        assertEquals(10, source.getOffset());
        assertEquals(17, source.getLength());
    }
    
    
    
   
    
    @Test
    public void testMoveTokensSetAbsolute() throws Exception {
        // default case
        TextBlock source = modelFactory.createTextBlock();
        TextBlock target = modelFactory.createTextBlock();
        
        LexedToken token = modelFactory.createLexedToken();
        token.setParent(source);
        token.setOffsetRelative(true);
        token.setOffset(5);
        source.setOffsetRelative(false);
        source.setOffset(20);
        
        List<AbstractToken> tokens = new ArrayList<AbstractToken>();
        tokens.add(token);
        // token2 stay in source
        
        boolean moved = TokenRelocationUtil.moveTokens(tokens, target);
        assertTrue(moved);
       
        assertEquals(1, target.getTokens().size());
        assertEquals(token, target.getTokens().get(0));

        assertEquals(25, token.getOffset());
        assertFalse(token.isOffsetRelative());
    }
    
    
    
    
    @Test (expected = NullPointerException.class) // fine since this should never happen
    public void testMakeRelativeNull() throws Exception {
        TokenRelocationUtil.makeSubNodesRelative(null);
    }
    
    @Test
    public void testMakeRelativeEmpty() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        TokenRelocationUtil.makeSubNodesRelative(root);
        // assert no exception thrown
    }
    
    @Test
    public void testMakeRelative() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(10);
        root.setOffsetRelative(false);
        
        LexedToken token = modelFactory.createLexedToken();
        token.setParent(root);
        token.setOffset(10);
        token.setOffsetRelative(false);
        
        TextBlock block = modelFactory.createTextBlock();
        block.setParent(root);
        block.setOffset(20);
        block.setOffsetRelative(false);
        
        LexedToken token3 = modelFactory.createLexedToken();
        token3.setParent(root);
        token3.setOffset(30);
        token3.setOffsetRelative(false);
        
        Eostoken eos = modelFactory.createEostoken();
        eos.setParent(root);
        eos.setOffset(40);
        token3.setOffsetRelative(false);
        
        TokenRelocationUtil.makeSubNodesRelative(root);
        
        assertTrue(token.isOffsetRelative());
        assertTrue(block.isOffsetRelative());
        assertTrue(token3.isOffsetRelative());
        assertTrue(eos.isOffsetRelative());
        
        assertEquals(10, root.getOffset());
     // all offsets shifted by 10 by making relative
        assertEquals(0, token.getOffset()); 
        assertEquals(10, block.getOffset());
        assertEquals(20, token3.getOffset());
        assertEquals(30, eos.getOffset());
    }
    
    
    @Test (expected = IllegalArgumentException.class)
    public void testMakeRelativeIllegal() throws Exception {
        TextBlock root = modelFactory.createTextBlock();
        root.setOffset(10);
        root.setOffsetRelative(false);
        
        LexedToken token = modelFactory.createLexedToken();
        token.setParent(root);
        token.setOffset(5); // smaller absolute offset than root should cause exception
        token.setOffsetRelative(false);
        TokenRelocationUtil.makeSubNodesRelative(root);
    }
}
