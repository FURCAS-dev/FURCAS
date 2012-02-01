package com.sap.furcas.runtime.parser.textblocks.observer;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandler;
import com.sap.furcas.runtime.parser.antlr3.ANTLR3LocationTokenImpl;
import com.sap.furcas.runtime.parser.impl.ParserScope;
import com.sap.furcas.runtime.parser.testbase.MockPartitionAssignmentHandler;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.furcas.runtime.textblocks.testbase.TextBlockTest;
import com.sap.furcas.runtime.textblocks.testbase.TextblocksTestHelper;
import com.sap.furcas.runtime.textblocks.testutils.TestSourceTextBlockCreator;

public class TestTextBlocksObserver extends TextBlockTest {
    
    private URI templateURI;
    private Resource resource;
    private TokenStreamMock tokenStreamMock;
    private ParserTextBlocksHandler observer;
    
    @Before 
    public void init() {
        resource = TextblocksTestHelper.createTransientResource();
        ResourceSet resourceSet = resource.getResourceSet();
       
        tokenStreamMock = new TokenStreamMock();
        TCSParserFactory factory = new TCSParserFactory();
        
        ParserScope parserScope = new ParserScope(resourceSet, factory);
        PartitionAssignmentHandler partitioningHandler = new MockPartitionAssignmentHandler(resource);
        observer = new ParserTextBlocksHandler(tokenStreamMock, parserScope, partitioningHandler);
        
        ConcreteSyntax tcsSyntax = (ConcreteSyntax) resourceSet.getEObject(URI.createURI(factory.getSyntaxUUID()), /*load*/true);
        
        templateURI = EcoreUtil.getURI(TcsUtil.getMainClassTemplate(tcsSyntax));
    }

    @Test
    public void testEnterExitRuleNullTokens() {
        // should leave the textblock as it is.

        TextBlock root = modelFactory.createTextBlock();
        observer.setRootBlock(root);
        
        observer.notifyEnterRule(templateURI.toString());
        observer.notifyExitRule();
        
        // assert no exception occured
    }
    
    @Test
    public void testEnterExitRuleNoTokenMove() {
        // should leave the textblock as it is.
     
        LexedToken contentToken = createToken("test");
        
        tokenStreamMock.nextToken = contentToken; // token is already in root block, so it should not get moved
        
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, contentToken);
        
        observer.setRootBlock(root);
        
        observer.notifyEnterRule(templateURI.toString());
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root blcok
        
        observer.notifyExitRule();
        
        assertEquals(1,observer.getCurrentTbProxy().getSubNodes().size());
        assertEquals(contentToken, observer.getCurrentTbProxy().getSubNodes().get(0)); 
    }
    

    @Test
    public void testEnterExitRuleTokenMove() {
        LexedToken contentToken = createToken("test");

        tokenStreamMock.nextToken = contentToken; 
        
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        
        observer.setRootBlock(root);
        
        observer.notifyEnterRule(templateURI.toString());
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root blcok
        
        observer.notifyExitRule();
        
        // assert token was added to root
        assertEquals(1, observer.getCurrentTbProxy().getSubNodes().size());
        assertEquals(contentToken, observer.getCurrentTbProxy().getSubNodes().get(0)); 
    }
    
    @Test
    public void testNewSubBlocks() throws Exception {
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        tokenStreamMock.nextToken = token1; 
        
        observer.notifyEnterRule(templateURI.toString());
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        
        LexedToken token2 = createToken("test2");
        token2.setOffset(4);
        tokenStreamMock.nextToken = token2;
        observer.notifyEnterRule(templateURI.toString());
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to sub block
        
        observer.notifyExitRule();
        
        LexedToken token3 = createToken("test3");
        token3.setOffset(9);
        tokenStreamMock.nextToken = token3;

        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to root block
        
        observer.notifyExitRule();
        
        // assert token was added to root
        assertEquals(3, observer.getCurrentTbProxy().getSubNodes().size());
        assertEquals(token1, observer.getCurrentTbProxy().getSubNodes().get(0));
        assertEquals(token3, observer.getCurrentTbProxy().getSubNodes().get(2));
        
        TextBlockProxy newBlock = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(1);
        assertEquals(1, newBlock.getSubNodes().size());
        assertEquals(token2, newBlock.getSubNodes().get(0));
        
    }
    
    @Test
    public void testExistingSubBlocks() throws Exception {
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        TextBlock subBlock = modelFactory.createTextBlock();
        subBlock.setParent(root); // first subnode
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        tokenStreamMock.nextToken = token1; 
        
        observer.notifyEnterRule(templateURI.toString());
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        
        LexedToken token2 = createToken("test2");
        token2.setOffset(4);
        tokenStreamMock.nextToken = token2;
        observer.notifyEnterRule(templateURI.toString());
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test2")); // should add token2 to sub block
        
        observer.notifyExitRule();
        
        LexedToken token3 = createToken("test3");
        token3.setOffset(9);
        tokenStreamMock.nextToken = token3;

        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test3")); // should add token3 to root block
        
        observer.notifyExitRule();
        
        // assert token was added to root
        assertEquals(3, observer.getCurrentTbProxy().getSubNodes().size());
        assertEquals(token1, observer.getCurrentTbProxy().getSubNodes().get(0));
        assertEquals(token3, observer.getCurrentTbProxy().getSubNodes().get(2));
        
        TextBlockProxy subBlockProxy = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(1);
      //  assertEquals(subBlock, observer.getCurrentTbProxy().getSubNodes().get(0));
        assertEquals(1, subBlockProxy.getSubNodes().size());
        assertEquals(token2, subBlockProxy.getSubNodes().get(0));
        
    }
    
    @Test
    public void testEnterExitRuleTokenMoveWithOffChannelsTokens() throws Exception {
        LexedToken ocToken1 = createToken("tab");
        LexedToken ocToken2 = createToken("blank");
        ocToken2.setOffset(3);
        tokenStreamMock.offChannelTokens.add(ocToken1);
        tokenStreamMock.offChannelTokens.add(ocToken2);

        LexedToken contentToken = createToken("test");
        contentToken.setOffset(8);
        
        tokenStreamMock.nextToken = contentToken; 
        
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        
        observer.setRootBlock(root);
        
        observer.notifyEnterRule(templateURI.toString());
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root blcok
        observer.notifyExitRule();
        
        // assert token was added to root
        assertEquals(3, observer.getCurrentTbProxy().getSubNodes().size());
        // (oc1, oc2, contentToken) expected
        assertEquals(ocToken1, observer.getCurrentTbProxy().getSubNodes().get(0)); 
        assertEquals(ocToken2, observer.getCurrentTbProxy().getSubNodes().get(1)); 
        assertEquals(contentToken, observer.getCurrentTbProxy().getSubNodes().get(2));
    }
    
    @Test
    public void testMoveTokensToSubBlock() throws Exception {
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        root.setLength(14);
        TextBlock subBlock = modelFactory.createTextBlock();
        subBlock.setParent(root); // first subnode
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        token1.setParent(root);
        LexedToken token2 = createToken("test2");
        token2.setOffset(4);
        token2.setParent(root);
        LexedToken token3 = createToken("test3");
        token3.setOffset(9);
        token3.setParent(root);
        
        observer.notifyEnterRule(templateURI.toString()); // enter root
        observer.notifyEnterRule(templateURI.toString()); // enter sub
        
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to sub block       
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to sub block
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to sub block
        
        observer.notifyExitRule();
        observer.notifyExitRule();
        
        // assert tokens were moved from root to sub
        assertEquals(1, observer.getCurrentTbProxy().getSubNodes().size());
        
        TextBlockProxy subBlockProxy = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(0);
        assertEquals(3, subBlockProxy.getSubNodes().size());
        assertEquals(token1, subBlockProxy.getSubNodes().get(0));
        assertEquals(token2, subBlockProxy.getSubNodes().get(1));
        assertEquals(token3, subBlockProxy.getSubNodes().get(2));

    }
    
   
    
    @Test
    public void testMoveTokensToRoot() throws Exception {
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        TextBlock subBlock = modelFactory.createTextBlock();
        subBlock.setParent(root); // first subnode
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        token1.setParent(subBlock);
        LexedToken token2 = createToken("test2");
        token2.setOffset(4);
        token2.setParent(subBlock);
        LexedToken token3 = createToken("test3");
        token3.setOffset(9);
        token3.setParent(subBlock);
        
        observer.notifyEnterRule(templateURI.toString()); // enter root
        
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block       
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to root block
        
        observer.notifyExitRule();

        
        // assert tokens were moved from root to sub
        assertEquals(3, observer.getCurrentTbProxy().getSubNodes().size());
        
        assertEquals(token1, observer.getCurrentTbProxy().getSubNodes().get(0));
        assertEquals(token2, observer.getCurrentTbProxy().getSubNodes().get(1));
        assertEquals(token3, observer.getCurrentTbProxy().getSubNodes().get(2));

    }
    
    @Test
    public void testMoveTokensToRootWithExisting() throws Exception {
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        TextBlock subBlock = modelFactory.createTextBlock();
        subBlock.setLength(9);
        subBlock.setParent(root); // first subnode
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        token1.setOffsetRelative(true);
        token1.setParent(subBlock);
        LexedToken token2 = createToken("test2");
        token2.setOffsetRelative(true);
        token2.setOffset(4);
        token2.setParent(subBlock);
        LexedToken token3 = createToken("test3");
        token3.setOffsetRelative(true);
        token3.setOffset(9);
        token3.setParent(root); // token already in root!!
        
        observer.notifyEnterRule(templateURI.toString()); // enter root
        
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block       
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to root block
        
        observer.notifyExitRule();

        
        // assert tokens were moved from root to sub
        assertEquals(3,observer.getCurrentTbProxy().getSubNodes().size());

        assertEquals(token1, observer.getCurrentTbProxy().getSubNodes().get(0));
        assertEquals(token2, observer.getCurrentTbProxy().getSubNodes().get(1));
        assertEquals(token3, observer.getCurrentTbProxy().getSubNodes().get(2));

    }
    
    
    
    @Test
    public void testMoveBetweenSubBlocks() throws Exception {
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        root.setLength(14);
        TextBlock subBlock1 = modelFactory.createTextBlock();
        subBlock1.setParent(root); // first subnode
        subBlock1.setLength(14);
        TextBlock subBlock2 = modelFactory.createTextBlock();
        subBlock2.setParent(root); // first subnode
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        token1.setParent(subBlock1);
        LexedToken token2 = createToken("test2");
        token2.setOffset(4);
        token2.setParent(subBlock1);
        LexedToken token3 = createToken("test3");
        token3.setOffset(9);
        token3.setParent(subBlock1);
        
        observer.notifyEnterRule(templateURI.toString()); // enter root
        observer.notifyEnterRule(templateURI.toString()); // enter subBlock1
        observer.notifyExitRule();
        observer.notifyEnterRule(templateURI.toString()); // enter subBlock2
        
        
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block       
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to root block
        
        observer.notifyExitRule(); // exit subBlock2 
        
        observer.notifyExitRule(); // exit root

        
        // assert tokens were moved from root to sub and no empty textblock was created
        assertEquals(1,observer.getCurrentTbProxy().getSubNodes().size());
        
        TextBlockProxy subBlock2Proxy = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(0);
        
        assertEquals(token1, subBlock2Proxy.getSubNodes().get(0));
        assertEquals(token2, subBlock2Proxy.getSubNodes().get(1));
        assertEquals(token3, subBlock2Proxy.getSubNodes().get(2));

    }
    
    @Test
    public void testMoveBetweenSubBlocksDeep() throws Exception {
		
        // special case to check parents get updated
        /*
         * start:
         * - root
         * -- subBlock1
         * --- subSubBlock1
         * ---- subSubSubBlock1
         * ----- token1
         * ----- token2
         * ----- token3
         * -- subBlock2
         * --- subSubBlock2
         * 
         * End:
         * - root
         * -- subBlock1
         * --- subSubBlock1
         * ---- subSubSubBlock1
         * ----- token1
         * -- subBlock2
         * --- subSubBlock2
         * ---- token2
         * ---- token3
         */
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        root.setLength(14);
        TextBlock subBlock1 = modelFactory.createTextBlock();
        subBlock1.setParent(root); // first subnode
        subBlock1.setLength(14);
        TextBlock subSubBlock1 = modelFactory.createTextBlock();
        subSubBlock1.setParent(subBlock1);
        subSubBlock1.setLength(14);
        TextBlock subSubSubBlock1 = modelFactory.createTextBlock();
        subSubSubBlock1.setParent(subSubBlock1); 
        subSubSubBlock1.setLength(14);
        
        TextBlock subBlock2 = modelFactory.createTextBlock();
        subBlock2.setParent(root); // first subnode
        subBlock2.setOffset(14);
        TextBlock subSubBlock2 = modelFactory.createTextBlock();
        subSubBlock2.setParent(subBlock2); // first subnode
        subSubBlock2.setOffset(14);
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        token1.setParent(subSubSubBlock1);
        LexedToken token2 = createToken("test2");
        token2.setOffset(4);
        token2.setParent(subSubSubBlock1);
        LexedToken token3 = createToken("test3");
        token3.setOffset(9);
        token3.setParent(subSubSubBlock1);
        
        observer.notifyEnterRule(templateURI.toString()); // enter root
        observer.notifyEnterRule(templateURI.toString()); // enter subBlock1
        observer.notifyEnterRule(templateURI.toString()); // enter subSubBlock1
        observer.notifyEnterRule(templateURI.toString()); // enter subSubSubBlock1
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        observer.notifyExitRule(); // leave subSubSubBlock1
        observer.notifyExitRule(); // leave subSubBlock1 
        observer.notifyExitRule(); // leave subBlock1 
        observer.notifyEnterRule(templateURI.toString()); // enter subBlock2
        observer.notifyEnterRule(templateURI.toString()); // enter subSubBlock2              
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        observer.notifyExitRule(); // exit subSubBlock2 
        observer.notifyExitRule(); // exit subBlock2 
        
        observer.notifyExitRule(); // exit root

        
       /* End:
            * - root
            * -- subBlock1
            * --- subSubBlock1
            * ---- subSubSubBlock1
            * ----- token1
            * -- subBlock2
            * --- subSubBlock2
            * ---- token2
            * ---- token3
            */
        
        // assert tokens were moved from root to sub
        
        assertEquals(2, observer.getCurrentTbProxy().getSubNodes().size()); 
        
        TextBlockProxy subBlockProxy1 = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(0);
		TextBlockProxy subsubBloclProxy1 = (TextBlockProxy) subBlockProxy1.getSubNodes().get(0);
		TextBlockProxy subsubsubBlockProxy = (TextBlockProxy) subsubBloclProxy1.getSubNodes().get(0);
		
		TextBlockProxy subBlockProxy2 = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(1);
		TextBlockProxy subsubBloclProxy2 = (TextBlockProxy) subBlockProxy2.getSubNodes().get(0);
        
        assertEquals(1, subsubsubBlockProxy.getSubNodes().size());
        assertEquals(token1, subsubsubBlockProxy.getSubNodes().get(0));
        
        assertEquals(2, subsubBloclProxy2.getSubNodes().size());
        assertEquals(token2, subsubBloclProxy2.getSubNodes().get(0));
        assertEquals(token3, subsubBloclProxy2.getSubNodes().get(1));
    }
    
    @Test
    public void testOffChannelTokenAtBeginningOfSubblock() throws Exception {
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        root.setLength(9);
        TextBlock subBlock1 = modelFactory.createTextBlock();
        subBlock1.setParent(root); // first subnode
        subBlock1.setLength(5);
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        token1.setParent(root);
        LexedToken space = createToken(" ");
        space.setOffset(4);
        space.setParent(root);
        LexedToken token2 = createToken("test2");
        token2.setOffset(5);
        token2.setParent(subBlock1);
        
        observer.notifyEnterRule(templateURI.toString()); // enter root
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        observer.notifyEnterRule(templateURI.toString()); // enter subBlock1
        tokenStreamMock.offChannelTokens.add(space);
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test2")); // should add space and token2 to subblock
        observer.notifyExitRule();
        
        observer.notifyExitRule(); // exit root

       
        assertEquals(2, observer.getCurrentTbProxy().getSubNodes().size());
        TextBlockProxy subBlockProxy1 = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(1);
        
        assertEquals(2, subBlockProxy1.getSubNodes().size()); //space should be moved to subblock

    }
        
    private LexedToken createToken(String string) {
        return modelFactory.createToken(string);
    }
}
