package com.sap.mi.textual.textblocks.model;

import static com.sap.mi.textual.parsing.textblocks.TbVersionUtil.getOtherVersion;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EEnum;
import org.junit.Test;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.mi.textual.parsing.textblocks.TbUtil;
import com.sap.mi.textual.parsing.textblocks.TextBlockTest;

public class TestReplacingInTBModel extends TextBlockTest {
    
    private LexedToken createTokenWithWorkingCopy(String value) {
        TextBlock parentBlock = modelFactory.createTextBlock();
        parentBlock.setVersion(EEnum.REFERENCE);
        LexedToken testToken = createToken(value);
        testToken.setParent(parentBlock);
        TbUtil.createNewCopy(
                getOtherVersion(parentBlock, EEnum.REFERENCE),
                EEnum.PREVIOUS, false, null);
        return testToken;
    }
    
    private TextBlock createEmptyTree(boolean withEmptyToken) {
        TextBlock parentBlock = modelFactory.createTextBlock();
        parentBlock.setVersion(EEnum.REFERENCE);
        Bostoken bos = modelFactory.createBostoken();
        bos.setVersion(EEnum.REFERENCE);
        bos.setParent(parentBlock);

        if (withEmptyToken) {
            LexedToken testToken = createToken("");
            testToken.setVersion(EEnum.REFERENCE);
            testToken.setParent(parentBlock);
            testToken.setOffset(0);
        }
        Eostoken eos = modelFactory.createEostoken();
        eos.setVersion(EEnum.REFERENCE);
        eos.setParent(parentBlock);
        eos.setOffset(0);
        parentBlock.setLength(0);
        parentBlock.setCachedString("");
        
        
        TbUtil.createNewCopy(
                getOtherVersion(parentBlock, EEnum.REFERENCE),
                EEnum.PREVIOUS, false, null);
        return parentBlock;
    }
    
    private TextBlock createSimpleTree(String... values) {
        TextBlock parentBlock = modelFactory.createTextBlock();
        parentBlock.setVersion(EEnum.REFERENCE);
        Bostoken bos = modelFactory.createBostoken();
        bos.setVersion(EEnum.REFERENCE);
        bos.setParent(parentBlock);
        
        String fullString = "";
        int totalLength = 0;
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            LexedToken testToken = createToken(value);
            testToken.setVersion(EEnum.REFERENCE);
            testToken.setParent(parentBlock);
            testToken.setOffset(totalLength);
            
            totalLength += value.length();
            fullString += value;
        }
        
        
        Eostoken eos = modelFactory.createEostoken();
        eos.setVersion(EEnum.REFERENCE);
        eos.setParent(parentBlock);
        eos.setOffset(totalLength);
        parentBlock.setLength(totalLength);
        parentBlock.setCachedString(fullString);        
        
        TbUtil.createNewCopy(
                getOtherVersion(parentBlock, EEnum.REFERENCE),
                EEnum.PREVIOUS, false, null);
        return parentBlock;
    }
    
    private TextBlock createSimpleTreeWithGaps(String value) {
        TextBlock parentBlock = modelFactory.createTextBlock();
        parentBlock.setVersion(EEnum.REFERENCE);
        Bostoken bos = modelFactory.createBostoken();
        bos.setVersion(EEnum.REFERENCE);
        bos.setParent(parentBlock);
        
        LexedToken testToken = createToken(value);
        testToken.setVersion(EEnum.REFERENCE);
        testToken.setParent(parentBlock);
        
        Eostoken eos = modelFactory.createEostoken();
        eos.setVersion(EEnum.REFERENCE);
        eos.setParent(parentBlock);
        
        // create gaps of 5 at start and end
        testToken.setOffset(5);
        parentBlock.setLength(value.length() + 10);
        parentBlock.setCachedString("     " + value + "     " );
        eos.setOffset(value.length() + 10);
        
        TbUtil.createNewCopy(
                getOtherVersion(parentBlock, EEnum.REFERENCE),
                EEnum.PREVIOUS, false, null);
        return parentBlock;
    }
    
    /**
     * @param string
     * @return
     */
    private TextBlock createDeepTreeWithGaps(String... values) {
        TextBlock rootBlock = modelFactory.createTextBlock();
        rootBlock.setVersion(EEnum.REFERENCE);
        
        Bostoken bos = modelFactory.createBostoken();
        bos.setVersion(EEnum.REFERENCE);
        bos.setParent(rootBlock);
        
        Eostoken eos = modelFactory.createEostoken();
        eos.setVersion(EEnum.REFERENCE);
        eos.setParent(rootBlock);
        
        String fullString = "";
        // create gaps of 5 at start and end
        int lastIndex = 0;
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            TextBlock parentBlock = modelFactory.createTextBlock();
            parentBlock.setVersion(EEnum.REFERENCE);
            parentBlock.setParent(rootBlock);
            
            parentBlock.setLength(value.length() + 6); // gap of 3 before and after contents
            parentBlock.setOffset(lastIndex + 2); // gap of 2 before start 
            
            LexedToken testToken = createToken(value);
            testToken.setVersion(EEnum.REFERENCE);
            testToken.setParent(parentBlock);
            testToken.setOffset(3); // absolute offset differs
            testToken.setOffsetRelative(true);
            fullString+="     " + value + "     ";
            lastIndex += value.length() + 10;
        }

        rootBlock.setLength(lastIndex);
        rootBlock.setCachedString(fullString);
        eos.setOffset(lastIndex);
        
        TbUtil.createNewCopy(
                getOtherVersion(rootBlock, EEnum.REFERENCE),
                EEnum.PREVIOUS, false, null);

        return rootBlock;
    }
    
    /**
     * creates a tree root(parentBlock(subBlock(value1)), parentBlock(subBlock(value2))...) with plenty of gaps of 2
     * @param string
     * @return
     */
    private TextBlock createVeryDeepTreeWithGaps(String... values) {
        TextBlock rootBlock = modelFactory.createTextBlock();
        rootBlock.setVersion(EEnum.REFERENCE);
        
        Bostoken bos = modelFactory.createBostoken();
        bos.setVersion(EEnum.REFERENCE);
        bos.setParent(rootBlock);
        
        Eostoken eos = modelFactory.createEostoken();
        eos.setVersion(EEnum.REFERENCE);
        eos.setParent(rootBlock);
        
        // create gaps of 6 at start and end
        int lastIndex = 0;
        String fullString = "";
        for (int i = 0; i < values.length; i++) {
            String value = values[i];
            TextBlock parentBlock = modelFactory.createTextBlock();
            parentBlock.setVersion(EEnum.REFERENCE);
            parentBlock.setParent(rootBlock);
            parentBlock.setLength(value.length() + 8); // gap of 4 before and after contents
            parentBlock.setOffset(lastIndex + 2); // gap of 2 before start and after end
            parentBlock.setOffsetRelative(true);
            
            TextBlock subParentBlock = modelFactory.createTextBlock();
            subParentBlock.setVersion(EEnum.REFERENCE);
            subParentBlock.setParent(parentBlock);
            subParentBlock.setLength(value.length() + 4); // gap of 2 before and after contents
            subParentBlock.setOffset( 2); // gap of 2 before start and after end
            subParentBlock.setOffsetRelative(true);
            
            LexedToken testToken = createToken(value);
            testToken.setVersion(EEnum.REFERENCE);
            testToken.setParent(subParentBlock);
            testToken.setOffset(2); // absolute offset differs
            testToken.setOffsetRelative(true);
            
            fullString+="      " + value + "      ";
            lastIndex += value.length() + 12;
        }
        rootBlock.setCachedString(fullString);
        rootBlock.setLength(lastIndex);
        eos.setOffset(lastIndex);
        
        TbUtil.createNewCopy(
                getOtherVersion(rootBlock, EEnum.REFERENCE),
                EEnum.PREVIOUS, false, null);

        return rootBlock;
    }
    
    private static <Type extends DocumentNode> Type getWorkingCopy(Type node) {
        
        return getOtherVersion(node,
                EEnum.PREVIOUS);
    }
    
    @Test
    public void testModifyTokenOnOverlap() throws Exception {
        LexedToken testToken = createTokenWithWorkingCopy("012345");
        TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 0, 0, "test", new ShortPrettyPrinter(null));
        assertEquals("test012345", getWorkingCopy(testToken).getValue());
        
        testToken = createTokenWithWorkingCopy("012345");
        TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 5, 0, "test", new ShortPrettyPrinter(null));
        assertEquals("01234test5", getWorkingCopy(testToken).getValue());
        
        testToken = createTokenWithWorkingCopy("012345");
        TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 6, 0, "test", new ShortPrettyPrinter(null));
        assertEquals("012345", getWorkingCopy(testToken).getValue());
        
        testToken = createTokenWithWorkingCopy("012345");
        TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 2, 3, "test", new ShortPrettyPrinter(null));
        assertEquals("01test5", getWorkingCopy(testToken).getValue());
        
        testToken = createTokenWithWorkingCopy("012345");
        TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 0, 6, "test", new ShortPrettyPrinter(null));
        assertEquals("test", getWorkingCopy(testToken).getValue());
        
        // larger region
        testToken = createTokenWithWorkingCopy("012345");
        TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 0, 8, "test", new ShortPrettyPrinter(null));
        assertEquals("test", getWorkingCopy(testToken).getValue());
        
        testToken = createTokenWithWorkingCopy("012345");
        TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 4, 6, "test", new ShortPrettyPrinter(null));
        assertEquals("0123test", getWorkingCopy(testToken).getValue());
    }
    

    
    @Test
    public void testModifyTokenToDelete() throws Exception {
        LexedToken testToken = createTokenWithWorkingCopy("012345");
        testToken.setOffset(10);
        boolean toDeleteFlag = TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 9, 7, "test", new ShortPrettyPrinter(null));
        assertTrue(toDeleteFlag);
        
        toDeleteFlag = TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 0, 9, "test", new ShortPrettyPrinter(null));
        assertFalse(toDeleteFlag);
        
        toDeleteFlag = TbReplacingHelper.modifyTokenOnOverlap(testToken, 0, 16, 10, "test", new ShortPrettyPrinter(null));
        assertFalse(toDeleteFlag);
        
    }
    
    @Test
    public void testModifyInSimpleTree() throws Exception {
        TextBlock root = createSimpleTree("012345");
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 0, "test");
        assertEquals(10, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("test012345", getWorkingCopy(root).getTokens().get(1).getValue());
        
        root = createSimpleTree("012345");
        model.replace(root, 6, 0, "test");
        assertEquals(10, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("012345test", getWorkingCopy(root).getTokens().get(1).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokens() throws Exception {
        TextBlock root = createSimpleTree("012", "345");
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 0, "test");
        assertEquals(10, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(3) instanceof Eostoken);
        assertEquals("test012", getWorkingCopy(root).getTokens().get(1).getValue());
        assertEquals("345", getWorkingCopy(root).getTokens().get(2).getValue());
        assertEquals(7, getWorkingCopy(root).getTokens().get(2).getOffset());
        assertEquals(10, getWorkingCopy(root).getTokens().get(3).getOffset());
        
        root = createSimpleTree("012", "345");
        model.replace(root, 3, 0, "test");
        assertEquals(10, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(3) instanceof Eostoken);
        assertEquals("012", getWorkingCopy(root).getTokens().get(1).getValue());
        assertEquals("test345", getWorkingCopy(root).getTokens().get(2).getValue());
        assertEquals(3, getWorkingCopy(root).getTokens().get(2).getOffset());
        assertEquals(10, getWorkingCopy(root).getTokens().get(3).getOffset());
        
        root = createSimpleTree("012", "345");
        model.replace(root, 6, 0, "test");
        assertEquals(10, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(3) instanceof Eostoken);
        assertEquals("012", getWorkingCopy(root).getTokens().get(1).getValue());
        assertEquals("345test", getWorkingCopy(root).getTokens().get(2).getValue());

        
        root = createSimpleTree("012", "345");
        model.replace(root, 0, 3, "test");
        assertEquals(7, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(3) instanceof Eostoken);
        assertEquals("test", getWorkingCopy(root).getTokens().get(1).getValue());
        assertEquals("345", getWorkingCopy(root).getTokens().get(2).getValue());
        assertEquals(4, getWorkingCopy(root).getTokens().get(2).getOffset());
        assertEquals(7, getWorkingCopy(root).getTokens().get(3).getOffset());
        
        root = createSimpleTree("012", "345");
        model.replace(root, 0, 4, "test");
        assertEquals(6, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(3) instanceof Eostoken);
        assertEquals("test", getWorkingCopy(root).getTokens().get(1).getValue());
        assertEquals("45", getWorkingCopy(root).getTokens().get(2).getValue());
        assertEquals(4, getWorkingCopy(root).getTokens().get(2).getOffset());
        assertEquals(6, getWorkingCopy(root).getTokens().get(3).getOffset());
        
        root = createSimpleTree("012", "345");
        model.replace(root, 0, 6, "test");
        assertEquals(4, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("test", getWorkingCopy(root).getTokens().get(1).getValue());
        assertEquals(4, getWorkingCopy(root).getTokens().get(2).getOffset());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepInsert1() throws Exception {
        // inserts before subblocks
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 0, "test"); // should create a new token at beginning of text
        assertEquals(30, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS,  tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
       

        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(0, parent1.getOffset()); // was 2
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("test     012", parent1.getTokens().get(0).getValue());
        assertEquals(0, parent1.getTokens().get(0).getOffset());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(19, parent2.getOffset());
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepInsert2() throws Exception {
        // inserts between subblocks
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 13, 0, "test"); // should create a new token in middle of text
        assertEquals(30, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1,  tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        

        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012     test", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(19, parent2.getOffset());
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepInsert3() throws Exception {
        // inserts after blocks
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 26, 0, "test"); // should create a new token in middle of text
        assertEquals(30, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        

        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(15, parent2.getOffset());
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345     test", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepInsert4() throws Exception {
        // inserts within subBlock
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 4, 0, "test"); // should create a new token within first subblock
        assertEquals(30, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size()); //oldtoken
        
        assertEquals(2, parent1.getTokens().get(0).getOffset());
        assertEquals(true, parent1.getTokens().get(0).isOffsetRelative());
        assertEquals("test 012", parent1.getTokens().get(0).getValue());

        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(19, parent2.getOffset());
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepInsert5a() throws Exception {
        // inserts within token
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 5, 0, "test"); // should extend existing token at start
        assertEquals(30, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size()); //newtoken, oldtoken
        assertEquals("test012", parent1.getTokens().get(0).getValue());
        assertEquals(3, parent1.getTokens().get(0).getOffset());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(19, parent2.getOffset());
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepInsert5b() throws Exception {
        // inserts within token at end
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 8, 0, "test"); // should extend existing token at start
        assertEquals(30, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals("012test", parent1.getTokens().get(0).getValue());

        assertEquals(3, parent1.getTokens().get(0).getOffset());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(19, parent2.getOffset());
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepInsert6() throws Exception {
        // inserts at End
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 26, 0, "test"); // should create a new token at beginning of text
        assertEquals(30, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS,  tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        

        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset()); 
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(15, parent2.getOffset());
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345     test", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepInsert7() throws Exception {
        // inserts at End of second block
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 24, 0, "test"); // should create a new token at beginning of text
        assertEquals(30, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset()); 
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(15, parent2.getOffset());
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345   test", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace1() throws Exception {
        // replaces first token
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 5, 3, "test"); // should replace complete first token
        assertEquals(27, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("test", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(16, parent2.getOffset()); // was 15
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace2() throws Exception {
        // replaces second token
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 18, 3, "test");// should replace complete second token
        assertEquals(27, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(15, parent2.getOffset()); 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("test", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace3() throws Exception {
        // replaces gap to first token, reducing text length
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 5, "test");// should replace complete second token
        assertEquals(25, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(0, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("test012", parent1.getTokens().get(0).getValue());
        assertEquals(0, parent1.getTokens().get(0).getOffset());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(14, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace4() throws Exception {
        // replaces gap after second token, reducing text length
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 21, 5, "test");// should add to second token
        assertEquals(25, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(15, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345test", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace5() throws Exception {
        // replaces whole first textblock
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 13, "test");// should replace first textBlock
        assertEquals(17, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
     
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(0, parent1.getOffset()); // was 15 
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("test", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(6, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace6() throws Exception {
        // replaces whole second textblock
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 13, 13, "test");// should replace first textBlock
        assertEquals(17, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent2.getOffset()); // was 2
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("012     test", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace7() throws Exception {
        // replaces within gap between tokens
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "  ___012___    ___345___  "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 9, 8, "test");// should create new token in first subBlock
        assertEquals(22, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012 test", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(13, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
        assertEquals(1, parent2.getTokens().get(0).getOffset()); // was 3 
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace8() throws Exception {
        // replaces from one token to the next
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "  ___012___    ___345___  "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 6, 14, "test");// should create new token in first subBlock
        assertEquals(16, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("0test", parent1.getTokens().get(0).getValue());
        
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(10, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("5", parent2.getTokens().get(0).getValue());
        assertEquals(0, parent2.getTokens().get(0).getOffset()); 
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace9() throws Exception {
        // replaces all gap between tokens
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "  ___012___    ___345___  "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 8, 10, "test");// should create new token in first subBlock
        assertEquals(20, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012test", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(12, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
        assertEquals(0, parent2.getTokens().get(0).getOffset());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace10() throws Exception {
        // replaces all 
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "  ___012___    ___345___  "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 26, "test");// should create new token in first subBlock
        assertEquals(4, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS, newtoken, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(0, parent1.getOffset());
        assertEquals(4, parent1.getLength());
        assertEquals("test", parent1.getTokens().get(0).getValue());
        assertEquals(0, parent1.getTokens().get(0).getOffset());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace11() throws Exception {
        // replaces all with empty String
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "  ___012___    ___345___  "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 26, "");// should create new token in first subBlock
        assertEquals(0, getWorkingCopy(root).getLength());
        assertEquals(2, getWorkingCopy(root).getSubNodes().size()); // BOS, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace12() throws Exception {
        // replaces whole second half with empty
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 13, 13, "");// should replace first textBlock
        assertEquals(13, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS,  tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent2.getOffset()); // was 2
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("012", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace13() throws Exception {
        // replaces whole second TB with empty
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 15, 9, "");// should replace first textBlock
        assertEquals(17, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS,  tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent2.getOffset()); // was 2
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("012", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepReplace14() throws Exception {
        // replaces whole token with empty
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 18, 3, "");// should replace first textBlock
        assertEquals(23, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS,  tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent2.getOffset()); // was 2
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("012", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeWithGaps() throws Exception {
        TextBlock root = createSimpleTreeWithGaps("012345"); // creates tree with length 16: "     012345     "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 5, 0, "test");
        assertEquals(20, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("test012345", getWorkingCopy(root).getTokens().get(1).getValue());
        
        root = createSimpleTreeWithGaps("012345");
        model.replace(root, 11, 0, "test");
        assertEquals(20, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("012345test", getWorkingCopy(root).getTokens().get(1).getValue());
        
        
        root = createSimpleTreeWithGaps("012345");
        model.replace(root, 0, 16, "test");
        assertEquals(4, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("test", getWorkingCopy(root).getTokens().get(1).getValue());
        
        root = createSimpleTreeWithGaps("012345");
        model.replace(root, 4, 7, "test");
        assertEquals(13, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("test", getWorkingCopy(root).getTokens().get(1).getValue());
        
        root = createSimpleTreeWithGaps("012345");
        model.replace(root, 0, 0, "test");
        assertEquals(20, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("test     012345", getWorkingCopy(root).getTokens().get(1).getValue());
        
    }
    
    @Test
    public void testModifyInDeepTreeWithGaps() throws Exception {
        TextBlock root = createDeepTreeWithGaps("012345");// creates tree with inner textBlock with length 16: "     012345     "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 5, 0, "test");
        assertEquals(20, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        TextBlock parent = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(1, parent.getSubNodes().size());
        assertEquals("test012345", parent.getTokens().get(0).getValue());
        
        root = createDeepTreeWithGaps("012345");
        model.replace(root, 11, 0, "test");
        assertEquals(20, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        parent = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(1, parent.getTokens().size());
        assertEquals("012345test", parent.getTokens().get(0).getValue());
        
        root = createDeepTreeWithGaps("012345");
        model.replace(root, 0, 16, "test");
        assertEquals(4, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        assertEquals("test", getWorkingCopy(root).getSubBlocks().get(0).getTokens().get(0).getValue());
        
        root = createDeepTreeWithGaps("012345");
        model.replace(root, 4, 7, "test");
        assertEquals(13, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        parent = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals("test", parent.getTokens().get(0).getValue());
        
        root = createDeepTreeWithGaps("012345");
        model.replace(root, 0, 0, "test");
        assertEquals(20, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertEquals(2, getWorkingCopy(root).getTokens().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        parent = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals("test     012345", parent.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInVeryDeepTreeWithGaps() throws Exception {
        // special cases tree with textblocks with relative offsets as childs of childs of root (only there do relative offsets start to be special)
        TextBlock root = createVeryDeepTreeWithGaps("012345"); // creates tree of length 18 "      012345      "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 0, "test");
        assertEquals(22, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertEquals(2, getWorkingCopy(root).getTokens().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        TextBlock parent = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(1, parent.getSubNodes().size());
        assertEquals(0, parent.getOffset());
        
        TextBlock subparent = parent.getSubBlocks().get(0);
        assertEquals(1, subparent.getSubNodes().size());
        assertEquals("test      012345", subparent.getTokens().get(0).getValue());
        assertEquals(0, subparent.getOffset());
        
        
        // next testcase
        
        root = createVeryDeepTreeWithGaps("012345"); // creates tree of length 18 "      012345      "
        model.replace(root, 0, 2, "test");
        assertEquals(20, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        parent = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(1, parent.getSubNodes().size());
        assertEquals(0, parent.getOffset());
        
        subparent = parent.getSubBlocks().get(0);
        assertEquals(1, subparent.getSubNodes().size());
        assertEquals("test    012345", subparent.getTokens().get(0).getValue());
        assertEquals(0, subparent.getOffset());
        
        // next testcase
        
        root = createVeryDeepTreeWithGaps("012345"); // creates tree of length 18 "      012345      "
        model.replace(root, 0, 4, "test");
        assertEquals(18, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        parent = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(1, parent.getSubNodes().size());
        assertEquals(0, parent.getOffset());
        
        subparent = parent.getSubBlocks().get(0);
        assertEquals(1, subparent.getSubNodes().size());
        assertEquals("test  012345", subparent.getTokens().get(0).getValue());
        assertEquals(0, subparent.getOffset());
        
// next testcase
        
        root = createVeryDeepTreeWithGaps("012345"); // creates tree of length 18 "      012345      "
        model.replace(root, 0, 6, "test");
        assertEquals(16, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size());
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        parent = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(1, parent.getSubNodes().size());
        assertEquals(0, parent.getOffset());
        
        subparent = parent.getSubBlocks().get(0);
        assertEquals(1, subparent.getSubNodes().size());
        assertEquals("test012345", subparent.getTokens().get(0).getValue());
        assertEquals(0, subparent.getOffset());
        
    }

    @Test
    public void testAddInEmptyTree1() throws Exception {
        TextBlock root = createEmptyTree(false);
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 0, "test");
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        
        assertEquals("test", getWorkingCopy(root).getTokens().get(1).getValue());
        assertEquals(0, getWorkingCopy(root).getTokens().get(1).getOffset());
        assertEquals(4, getWorkingCopy(root).getTokens().get(2).getOffset());
        
        assertEquals(4, getWorkingCopy(root).getLength());
    }
    
    @Test
    public void testAddInEmptyTree2() throws Exception {
        TextBlock root = createEmptyTree(true); // creates an empty tree with an existing empty token inside
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 0, "test");
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(2) instanceof Eostoken);
        assertEquals("test", getWorkingCopy(root).getTokens().get(1).getValue());
        
        assertEquals(0, getWorkingCopy(root).getTokens().get(1).getOffset());
        assertEquals(4, getWorkingCopy(root).getTokens().get(2).getOffset());
        
        assertEquals(4, getWorkingCopy(root).getLength());
    }
    

    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove1() throws Exception {
        // replaces first token
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 5, 3, ""); // should replace complete first token
        assertEquals(23, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
     
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(12, parent2.getOffset()); // was 15
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove2() throws Exception {
        // replaces second token
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 18, 3, "");// should replace complete second token
        assertEquals(23, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
       
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove3() throws Exception {
        // replaces gap to first token, reducing text length
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 5, "");// should replace complete second token
        assertEquals(21, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(0, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        assertEquals(0, parent1.getTokens().get(0).getOffset());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(10, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove4() throws Exception {
        // replaces gap after second token, reducing text length
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 21, 5, "");// should add to second token
        assertEquals(21, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(15, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove5() throws Exception {
        // replaces whole first textblock
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 0, 13, "");// should replace first textBlock
        assertEquals(13, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);

        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove6() throws Exception {
        // replaces whole second textblock
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "     012          345   "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 13, 13, "");// should replace first textBlock
        assertEquals(13, getWorkingCopy(root).getLength());
        assertEquals(3, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent2.getOffset()); // was 2
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("012", parent2.getTokens().get(0).getValue());
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove7() throws Exception {
        // replaces within gap between tokens
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "  ___012___    ___345___  "
        // expect "  ___012_|_345___  "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 9, 8, "");// should create new token in first subBlock
        assertEquals(18, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(9, parent2.getOffset()); // was 15 (-8, +2 for cut off gap in tb2)
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
        assertEquals(1, parent2.getTokens().get(0).getOffset()); // was 3 
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove8() throws Exception {
        // replaces from one token to the next
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "  ___012___    ___345___  "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 6, 14, "");// should create new token in first subBlock
        assertEquals(12, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("0", parent1.getTokens().get(0).getValue());
        
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(6, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("5", parent2.getTokens().get(0).getValue());
        assertEquals(0, parent2.getTokens().get(0).getOffset()); 
    }
    
    @Test
    public void testModifyInSimpleTreeMultiTokensDeepRemove9() throws Exception {
        // replaces all gap between tokens
        TextBlock root = createDeepTreeWithGaps("012", "345"); // creates tree of length 26: "  ___012___    ___345___  "
        TextBlocksModel model = new TextBlocksModel(root,  null);
        model.replace(root, 8, 10, "");// should create new token in first subBlock
        assertEquals(16, getWorkingCopy(root).getLength());
        assertEquals(4, getWorkingCopy(root).getSubNodes().size()); // BOS, tb1, tb2, eos
        assertTrue(getWorkingCopy(root).getTokens().get(0) instanceof Bostoken);
        assertTrue(getWorkingCopy(root).getTokens().get(1) instanceof Eostoken);
        
        TextBlock parent1 = getWorkingCopy(root).getSubBlocks().get(0);
        assertEquals(2, parent1.getOffset());
        assertEquals(1, parent1.getSubNodes().size());
        assertEquals("012", parent1.getTokens().get(0).getValue());
        
        TextBlock parent2 = getWorkingCopy(root).getSubBlocks().get(1);
        assertEquals(8, parent2.getOffset()); // was 15 
        assertEquals(1, parent2.getSubNodes().size());
        assertEquals("345", parent2.getTokens().get(0).getValue());
        assertEquals(0, parent2.getTokens().get(0).getOffset());
    }
    
    
}
