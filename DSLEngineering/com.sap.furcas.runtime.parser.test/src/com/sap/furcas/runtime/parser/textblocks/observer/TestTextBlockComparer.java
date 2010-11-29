package com.sap.furcas.runtime.parser.textblocks.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextBlockDefinition;
import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.parser.textblocks.TextBlockFactory;
import com.sap.furcas.runtime.textblocks.testbase.TextBlockTest;


public class TestTextBlockComparer extends TextBlockTest {
    
    @Test (expected = IllegalArgumentException.class)
    public void testNewNullTraverser() throws Exception {
        new TextBlockComparer(null, null);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNewTraverserNullRoot() throws Exception {
        TextBlockFactory factory = getFactory();
        new TextBlockComparer(null, factory);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNewTraverserNullFact() throws Exception {
       
        new TextBlockComparer(modelFactory.createTextBlock(), null);
    }
    
    @Test 
    public void testNewTraverser() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        assertEquals(block, traverser.getCurrent());
        assertEquals(0, traverser.getTokensToBeRelocated().size());
    }
    
    @Test (expected = IllegalStateException.class)
    public void testLeaveNewTraverser() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        
        traverser.leaveChild(); // throws exception, we cannot leave root
    }
    
    @Test 
    public void testEnterTraverser() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        
        traverser.enterNextChild(); 
        assertNotNull(traverser.getCurrent());
        assertNotSame(block, traverser.getCurrent());
        assertEquals(0, traverser.getTokensToBeRelocated().size());
    }
    
    @Test
    public void testEnterLeaveTraverser() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        
        traverser.enterNextChild();
        traverser.leaveChild();
        assertNotNull(traverser.getCurrent());
        assertEquals(block, traverser.getCurrent());
        assertEquals(0, traverser.getTokensToBeRelocated().size());
    }
    
    
    @Test (expected = IllegalStateException.class)
    public void testEnterLeaveLeaveNewTraverser() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        
        traverser.enterNextChild(); 
        traverser.leaveChild(); 
        traverser.leaveChild(); // throws exception, we cannot leave root
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testTraverserSetterNull() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
       
        traverser.addTokenToBeRelocated(null);
    }
    
    @Test 
    public void testTraverserSetter() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        
        AbstractToken tok = modelFactory.createLexedToken();
        traverser.addTokenToBeRelocated(tok);
        traverser.enterNextChild(); 
        assertEquals(0, traverser.getTokensToBeRelocated().size());
        traverser.leaveChild(); 
        assertEquals(1, traverser.getTokensToBeRelocated().size());
        assertEquals(tok, traverser.getTokensToBeRelocated().get(0));
    }
    
    @Test 
    public void testTraverserSetter2() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        
        AbstractToken tok = modelFactory.createLexedToken();
        traverser.addTokenToBeRelocated(tok);
        traverser.enterNextChild(); 
        assertEquals(0, traverser.getTokensToBeRelocated().size());
        
        AbstractToken tok2 = modelFactory.createLexedToken();
        traverser.addTokenToBeRelocated(tok2);
        AbstractToken tok3 = modelFactory.createLexedToken();
        traverser.addTokenToBeRelocated(tok3);
        assertEquals(2, traverser.getTokensToBeRelocated().size());
        assertEquals(tok2, traverser.getTokensToBeRelocated().get(0));
        assertEquals(tok3, traverser.getTokensToBeRelocated().get(1));
        
        traverser.leaveChild(); 
        assertEquals(1, traverser.getTokensToBeRelocated().size());
        assertEquals(tok, traverser.getTokensToBeRelocated().get(0));
    }
    
    @Test 
    public void testTraverserSetterMany() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        
        AbstractToken tok = modelFactory.createLexedToken();
        AbstractToken tok2 = modelFactory.createLexedToken();
        Collection<AbstractToken> tokList = new ArrayList<AbstractToken>();
        tokList.add(tok);
        tokList.add(tok2);
        traverser.addTokensToBeRelocated(tokList);
        assertEquals(2, traverser.getTokensToBeRelocated().size());
        assertEquals(tok, traverser.getTokensToBeRelocated().get(0));
        assertEquals(tok2, traverser.getTokensToBeRelocated().get(1));
    }
    
    @Test 
    public void testEnterTraverserWithSubtokens() throws Exception {
        TextBlockFactory factory = getFactory();
        TextBlock block = modelFactory.createTextBlock();
        TextBlock subblock = modelFactory.createTextBlock();
        TextBlock subblock2 = modelFactory.createTextBlock();
        TextBlock subsubblock = modelFactory.createTextBlock();
        subblock.setParent(block);
        subblock2.setParent(block);
        subsubblock.setParent(subblock);
        TextBlockComparer traverser = new TextBlockComparer(block, factory);
        
        traverser.enterNextChild(); // in subblock
        assertEquals(subblock, traverser.getCurrent());
        
        traverser.enterNextChild(); // in subsubblock
        assertEquals(subsubblock, traverser.getCurrent());
        
        traverser.enterNextChild(); // below  subsubblock
        assertNotSame(subsubblock, traverser.getCurrent());
        
        traverser.leaveChild(); // in subsubblock
        assertEquals(subsubblock, traverser.getCurrent());
        
        traverser.leaveChild();  // in subblock
        assertEquals(subblock, traverser.getCurrent());
        
        traverser.enterNextChild(); // below subblock, not in subsubblock
        assertNotSame(subblock, traverser.getCurrent());
        assertNotSame(subsubblock, traverser.getCurrent());
        
        traverser.leaveChild(); // in subblock
        assertEquals(subblock, traverser.getCurrent());
        
        traverser.leaveChild(); // in block 
        assertEquals(block, traverser.getCurrent());
        
        traverser.enterNextChild(); // in subblock2 
        assertEquals(subblock2, traverser.getCurrent());
        
        traverser.leaveChild(); // in block
        assertEquals(block, traverser.getCurrent());
        
    }
    	/**
	 * util method to create a factory
	 * 
	 * @return
	 */
	private TextBlockFactory getFactory() {
		return new TextBlockFactory() {

			@Override
			public TextBlock createBlock() {
				return modelFactory.createTextBlock();
			}

			@Override
			public TextBlock createNewTextBlock(TextBlockProxy proxy, TextBlock parent) {
				return modelFactory.createTextBlock();
			}

			@Override
			public TextBlockDefinition getTbDef(Template template) {
				return null;
			}
		};
	}
    
    
    
    /* ************* tests for context bean *****/
    

    @Test (expected = IllegalArgumentException.class)
    public void testNewNullContext() throws Exception {
        new TextBlockTraversationContext(null, true);
    }
    
    @Test
    public void testNewContext() throws Exception {
        TextBlock block = modelFactory.createTextBlock();
        TextBlockTraversationContext context = new TextBlockTraversationContext(block, true);
        assertEquals(block, context.getContextBlock());
        assertEquals(-1, context.getLastVisitedChildIndex());
        assertEquals(0, context.getTokensToBeRelocated().size());
        assertEquals(true, context.isNewBlock());
        
        // test boolean parameter false
        context = new TextBlockTraversationContext(block, false);
        assertEquals(block, context.getContextBlock());
        assertEquals(-1, context.getLastVisitedChildIndex());
        assertEquals(0, context.getTokensToBeRelocated().size());
        assertEquals(false, context.isNewBlock());
    }
    
    @Test
    public void testSetters() throws Exception {
        TextBlock block = modelFactory.createTextBlock();
        TextBlockTraversationContext context = new TextBlockTraversationContext(block, true);
        
        context.setLastVisitedChildIndex(42);
        assertEquals(42, context.getLastVisitedChildIndex());
        
        AbstractToken tok = modelFactory.createLexedToken();
        context.addTokenToBeRelocated(tok);
        assertEquals(1, context.getTokensToBeRelocated().size());
        assertEquals(tok, context.getTokensToBeRelocated().get(0));
        
        AbstractToken tok2 = modelFactory.createLexedToken();
        AbstractToken tok3 = modelFactory.createLexedToken();
        
        Collection<AbstractToken> tokList = new ArrayList<AbstractToken>();
        tokList.add(tok2);
        tokList.add(tok3);
        context.addTokensToBeRelocated(tokList);
        assertEquals(3, context.getTokensToBeRelocated().size());
        assertEquals(tok, context.getTokensToBeRelocated().get(0));
        assertEquals(tok2, context.getTokensToBeRelocated().get(1));
        assertEquals(tok3, context.getTokensToBeRelocated().get(2));
    }
}
