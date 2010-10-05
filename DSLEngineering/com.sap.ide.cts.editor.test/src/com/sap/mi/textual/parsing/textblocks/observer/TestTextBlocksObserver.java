package com.sap.mi.textual.parsing.textblocks.observer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.TCSPackage;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.ide.cts.editor.test.util.TcsTestHelper;
import com.sap.ide.cts.editor.test.util.TestSourceTextBlockCreator;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationTokenImpl;
import com.sap.mi.textual.parsing.textblocks.UtilFixtureBase;
import com.sap.mi.textual.tcs.util.TcsUtil;

public class TestTextBlocksObserver extends UtilFixtureBase {
    
    private static final List<String> emptyList = Collections.singletonList("");

	@Test
    public void testEnterExitRuleNullTokens() {
        // should leave the textblock as it is.
		
		//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
     
        TokenStreamMock stream = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(stream, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);


        TextBlock root = modelFactory.createTextBlock();
        observer.setRootBlock(root);
        
        observer.notifyEnterRule(emptyList, null);
        observer.notifyExitRule(null);
        
        // assert no exception occured
    }
    
    @Test
    public void testEnterExitRuleNoTokenMove() {
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        // should leave the textblock as it is.
     
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);

        LexedToken contentToken = createToken("test");
        
        tokenStreamMock.nextToken = contentToken; // token is already in root block, so it should not get moved
        
        TextBlock root = TestSourceTextBlockCreator.initialiseTextBlocksWithContentToken(modelFactory, contentToken);
        
        observer.setRootBlock(root);
        
        observer.notifyEnterRule(emptyList, null);
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root blcok
        
        observer.notifyExitRule(null);
        
        assertEquals(1,observer.getCurrentTbProxy().getSubNodes().size());
        assertEquals(contentToken, observer.getCurrentTbProxy().getSubNodes().get(0)); 
    }
    
    @Test
    public void testEnterExitRuleTokenMove() {
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);

        LexedToken contentToken = createToken("test");

        
        tokenStreamMock.nextToken = contentToken; 
        
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        
        observer.setRootBlock(root);
        
        observer.notifyEnterRule(emptyList, null);
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root blcok
        
        observer.notifyExitRule(null);
        
        // assert token was added to root
        assertEquals(1, observer.getCurrentTbProxy().getSubNodes().size());
        assertEquals(contentToken, observer.getCurrentTbProxy().getSubNodes().get(0)); 
    }
    
    @Test
    public void testNewSubBlocks() throws Exception {
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);
       
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        tokenStreamMock.nextToken = token1; 
        
        observer.notifyEnterRule(emptyList, null);
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        
        LexedToken token2 = createToken("test2");
        token2.setOffset(4);
        tokenStreamMock.nextToken = token2;
        observer.notifyEnterRule(emptyList, null);
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to sub block
        
        observer.notifyExitRule(null);
        
        LexedToken token3 = createToken("test3");
        token3.setOffset(9);
        tokenStreamMock.nextToken = token3;

        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to root block
        
        observer.notifyExitRule(null);
        
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
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);
       
        TextBlock root = modelFactory.createTextBlock(); // using emtpy block here, not block with BOS, EOS 
        TextBlock subBlock = modelFactory.createTextBlock();
        subBlock.setParent(root); // first subnode
        observer.setRootBlock(root);

        LexedToken token1 = createToken("test");
        tokenStreamMock.nextToken = token1; 
        
        observer.notifyEnterRule(emptyList, null);
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        
        LexedToken token2 = createToken("test2");
        token2.setOffset(4);
        tokenStreamMock.nextToken = token2;
        observer.notifyEnterRule(emptyList, null);
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test2")); // should add token2 to sub block
        
        observer.notifyExitRule(null);
        
        LexedToken token3 = createToken("test3");
        token3.setOffset(9);
        tokenStreamMock.nextToken = token3;

        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test3")); // should add token3 to root block
        
        observer.notifyExitRule(null);
        
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
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);

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
        
        observer.notifyEnterRule(emptyList, null);
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root blcok
        observer.notifyExitRule(null);
        
        // assert token was added to root
        assertEquals(3, observer.getCurrentTbProxy().getSubNodes().size());
        // (oc1, oc2, contentToken) expected
        assertEquals(ocToken1, observer.getCurrentTbProxy().getSubNodes().get(0)); 
        assertEquals(ocToken2, observer.getCurrentTbProxy().getSubNodes().get(1)); 
        assertEquals(contentToken, observer.getCurrentTbProxy().getSubNodes().get(2));
    }
    
    @Test
    public void testMoveTokensToSubBlock() throws Exception {
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);
       
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
        
        observer.notifyEnterRule(emptyList, null); // enter root
        observer.notifyEnterRule(emptyList, null); // enter sub
        
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to sub block       
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to sub block
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to sub block
        
        observer.notifyExitRule(null);
        observer.notifyExitRule(null);
        
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
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);
       
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
        
        observer.notifyEnterRule(emptyList, null); // enter root
        
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block       
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to root block
        
        observer.notifyExitRule(null);

        
        // assert tokens were moved from root to sub
        assertEquals(3, observer.getCurrentTbProxy().getSubNodes().size());
        
        assertEquals(token1, observer.getCurrentTbProxy().getSubNodes().get(0));
        assertEquals(token2, observer.getCurrentTbProxy().getSubNodes().get(1));
        assertEquals(token3, observer.getCurrentTbProxy().getSubNodes().get(2));

    }
    
    @Test
    public void testMoveTokensToRootWithExisting() throws Exception {
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);
       
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
        
        observer.notifyEnterRule(emptyList, null); // enter root
        
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block       
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to root block
        
        observer.notifyExitRule(null);

        
        // assert tokens were moved from root to sub
        assertEquals(3,observer.getCurrentTbProxy().getSubNodes().size());

        assertEquals(token1, observer.getCurrentTbProxy().getSubNodes().get(0));
        assertEquals(token2, observer.getCurrentTbProxy().getSubNodes().get(1));
        assertEquals(token3, observer.getCurrentTbProxy().getSubNodes().get(2));

    }
    
    
    
    @Test
    public void testMoveBetweenSubBlocks() throws Exception {
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);
       
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
        
        observer.notifyEnterRule(emptyList, null); // enter root
        observer.notifyEnterRule(emptyList, null); // enter subBlock1
        observer.notifyExitRule(null);
        observer.notifyEnterRule(emptyList, null); // enter subBlock2
        
        
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block       
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token3 to root block
        
        observer.notifyExitRule(null); // exit subBlock2 
        
        observer.notifyExitRule(null); // exit root

        
        // assert tokens were moved from root to sub and no empty textblock was created
        assertEquals(1,observer.getCurrentTbProxy().getSubNodes().size());
        
        TextBlockProxy subBlock2Proxy = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(0);
        
        assertEquals(token1, subBlock2Proxy.getSubNodes().get(0));
        assertEquals(token2, subBlock2Proxy.getSubNodes().get(1));
        assertEquals(token3, subBlock2Proxy.getSubNodes().get(2));

    }
    
    @Test
    public void testMoveBetweenSubBlocksDeep() throws Exception {
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
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
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);
       
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
        
        observer.notifyEnterRule(emptyList, null); // enter root
        observer.notifyEnterRule(emptyList, null); // enter subBlock1
        observer.notifyEnterRule(emptyList, null); // enter subSubBlock1
        observer.notifyEnterRule(emptyList, null); // enter subSubSubBlock1
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        observer.notifyExitRule(null); // leave subSubSubBlock1
        observer.notifyExitRule(null); // leave subSubBlock1 
        observer.notifyExitRule(null); // leave subBlock1 
        observer.notifyEnterRule(emptyList, null); // enter subBlock2
        observer.notifyEnterRule(emptyList, null); // enter subSubBlock2              
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        tokenStreamMock.nextToken = token3;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token2 to root block
        observer.notifyExitRule(null); // exit subSubBlock2 
        observer.notifyExitRule(null); // exit subBlock2 
        
        observer.notifyExitRule(null); // exit root

        
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
    	//create TCS mapping on connection
		TcsTestHelper.createTcsSyntaxMappingOnConnection(connection);
		
        TokenStreamMock tokenStreamMock = new TokenStreamMock();
        URI tcsCRI = ((EObject)connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR)).get___Mri().getCri();
        ParserTextBlocksHandler observer = new ParserTextBlocksHandler(tokenStreamMock, connection, tcsCRI,
        		TcsUtil.getSyntaxePartitions(connection, "TCS"), null, null);
       
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
        
        observer.notifyEnterRule(emptyList, null); // enter root
        tokenStreamMock.nextToken = token1;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        observer.notifyEnterRule(emptyList, null); // enter subBlock1
        tokenStreamMock.offChannelTokens.add(space);
        tokenStreamMock.nextToken = token2;
        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test2")); // should add space and token2 to subblock
        observer.notifyExitRule(null);
        
        observer.notifyExitRule(null); // exit root

       
        assertEquals(2, observer.getCurrentTbProxy().getSubNodes().size());
        TextBlockProxy subBlockProxy1 = (TextBlockProxy) observer.getCurrentTbProxy().getSubNodes().get(1);
        
        assertEquals(2, subBlockProxy1.getSubNodes().size()); //space should be moved to subblock

    }
    
    @Test
    @Ignore
    public void testSkippedTextBlock() {
        /*
         * Test the case when target textBlock tree has TextBlock Nodes which are not traversed
         * - root
         * -- subNode
         * --- subSubNode
         * - subNode2
         * ...
         * 
         * enterRule // into root
         * enterRule // into subNode
         * exitRule // out of subNode, skipped subSubNode!!!
         * enterRule // intosubnode2
         * ...
         */
        fail("TODO");

//        tokenStreamMock.nextToken = token1;
//        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        //observer.notifyEnterRule(emptyList, null); // enter root
//        observer.notifyExitRule(null); // leave root
    }
    
    @Test
    @Ignore
    public void testConsumedTokenBeforeRoot() {
        /*
         * Test the case when tokens get consumed before we entered a rule (exception)
         */
        fail("TODO");

//        tokenStreamMock.nextToken = token1;
//        observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
        //observer.notifyEnterRule(emptyList, null); // enter root
//        observer.notifyExitRule(null); // leave root
    }

    @Test
    @Ignore
    public void testConsumedTokenAfterRoot() {
        /*
         * Test the case when tokens get consumed after we entered a rule (exception)
         */
        fail("TODO");

//         observer.notifyEnterRule(emptyList, null); // enter root
//        observer.notifyExitRule(null); // leave root
//      tokenStreamMock.nextToken = token1;
//      observer.notifyTokenConsume(new ANTLR3LocationTokenImpl(0, "test")); // should add token1 to root block
    }
    
    @Test
    @Ignore
    public void testIrregularRuleCalls() {
        /*
         * Test the cases when parser does not adhere to contract, e.g. enterRule(x) enterRule(y), exitRule(x), exitRule(y)
         */
        fail("TODO");
    }
    
    @Test
    @Ignore
    public void testOffChannelTokensAfterRoot() {
        /*
         * Test the cases when there are offChannelTokens after the root rule (needs API change?)
         */
        fail("TODO");
        
//        TokenStreamMock tokenStreamMock = new TokenStreamMock();
//         observer.notifyEnterRule(emptyList, null); // enter root
//        observer.notifyExitRule(null); // leave root
//      tokenStreamMock.offChannelTokens.add(token);

    }
    
    @Test
    @Ignore
    public void testModelElementResolved() {
        fail("TODO");
        /*
         * test the default case
         */
//        root.addCorresponidngModelElement(refObject1)
//        observer.notifyEnterRule(emptyList, null); // enter root
//        observer.notifyModelElementResolved(refObject2)
//      observer.notifyExitRule(null); // leave root
    }
    
    @Test
    @Ignore
    public void testModelElementResolvedMany() {
        fail("TODO");
        /*
         * test the error case of more than one modelElement in textBlock
         */
//        root.addCorresponidngModelElement(refObject1)
//        observer.notifyEnterRule(emptyList, null); // enter root
//        observer.notifyModelElementResolved(refObject2)
//      observer.notifyModelElementResolved(refObject3)
//      observer.notifyExitRule(null); // leave root
    }
    
    @Test
    @Ignore
    public void testResolutionFailed() {
        fail("TODO");
        // observer.modelElementResolutionFailed
    }
    
    @Test
    @Ignore
    public void testOutOfContext() {
        fail("TODO");
        // observer.modelElementResolvedOutOfContext
    }
        
    @Test
    @Ignore
    public void testErrorInRule() {
        fail("TODO");
        // observer.notifyErrorInRule
    }
    
    @Test
    @Ignore
    public void testMoveTokensToRootWithEOSBOS() {
        fail("TODO");
        // similar to testMoveTokensToRootWithExisting
        /*
         * test the case tokens are moved from subBlock to root block, 
         * where rootBlock also has BOS and EOS (simply adding tokens 
         * to root would add tokens after EOS).
         */
    }  
}
