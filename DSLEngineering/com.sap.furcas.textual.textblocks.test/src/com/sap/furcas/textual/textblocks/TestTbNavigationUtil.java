/**
 * 
 */
package com.sap.furcas.textual.textblocks;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.textual.textblocks.testutils.FixtureProvidingTextBlockTest;

/**
 * 
 */
public class TestTbNavigationUtil extends FixtureProvidingTextBlockTest {

    @Test
    public void testFirstToken() {
	assertEquals(bos, TbNavigationUtil.firstToken(main));
	assertEquals(lexed3, TbNavigationUtil.firstToken(middle));
	assertEquals(subToken, TbNavigationUtil.firstToken(subBlock1));
    }

    @Test
    public void testLastToken() {
	assertEquals(eos, TbNavigationUtil.lastToken(main));
	assertEquals(subToken, TbNavigationUtil.lastToken(middle));
	assertEquals(subToken, TbNavigationUtil.lastToken(subBlock1));
    }

    @Test
    public void testGetNextInSubTree() {

	assertEquals(null, TbNavigationUtil.getNextInSubTree(subBlock1));
	assertEquals(null, TbNavigationUtil.getNextInSubTree(eos));
	assertEquals(subBlock1, TbNavigationUtil.getNextInSubTree(lexed3));
	assertEquals(lexed2, TbNavigationUtil.getNextInSubTree(left));
	assertEquals(eos, TbNavigationUtil.getNextInSubTree(right));
	assertEquals(null, TbNavigationUtil.getNextInSubTree(main));
    }

    @Test
    public void testPreviousInSubTree() {
	assertEquals(null, TbNavigationUtil.getPreviousInSubTree(bos));
	assertEquals(left, TbNavigationUtil.getPreviousInSubTree(lexed2));
	assertEquals(middle, TbNavigationUtil.getPreviousInSubTree(right));
	assertEquals(bos, TbNavigationUtil.getPreviousInSubTree(left));
	assertEquals(null, TbNavigationUtil.getPreviousInSubTree(main));
    }

    @Test
    public void testGetSubNodes() {
	// mixed subnodes
	List<DocumentNode> expectedNodesFromMain = new ArrayList<DocumentNode>();
	expectedNodesFromMain.add(bos);
	expectedNodesFromMain.add(left);
	expectedNodesFromMain.add(lexed2);
	expectedNodesFromMain.add(middle);
	expectedNodesFromMain.add(right);
	expectedNodesFromMain.add(eos);

	assertEquals(expectedNodesFromMain, TbNavigationUtil.getSubNodes(main));

	// only textblocks
	List<DocumentNode> expectedNodesFromLeft = new ArrayList<DocumentNode>();
	expectedNodesFromLeft.add(leftLeft);

	assertEquals(expectedNodesFromLeft, TbNavigationUtil.getSubNodes(left));

	// only tokens
	List<DocumentNode> expectedNodesFromRight = new ArrayList<DocumentNode>();
	expectedNodesFromRight.add(lexed4);

	assertEquals(expectedNodesFromRight, TbNavigationUtil.getSubNodes(right));
    }

    @Test
    public void testGetSubNodesBug() {
	List<DocumentNode> expectedNodes = new ArrayList<DocumentNode>();

	Bostoken t = modelFactory.createBostoken();
	t.setOffset(0);
	t.setOffsetRelative(true);

	TextBlock tb = modelFactory.createTextBlock();
	tb.setOffset(0);
	tb.setOffsetRelative(true);

	TextBlock parent = modelFactory.createTextBlock();
	parent.getSubNodes().add(t);
	parent.getSubNodes().add(tb);

	expectedNodes.add(t);
	expectedNodes.add(tb);

	assertEquals(tb, parent.getSubBlocks().iterator().next());
	assertEquals(t, parent.getTokens().iterator().next());
    }

    @Test
    public void testGetSubNodesIndex() {
	assertEquals(0, TbNavigationUtil.getSubNodesIndex(bos));
	assertEquals(1, TbNavigationUtil.getSubNodesIndex(left));
	assertEquals(0, TbNavigationUtil.getSubNodesIndex(leftLeft));
	assertEquals(3, TbNavigationUtil.getSubNodesIndex(middle));
	assertEquals(0, TbNavigationUtil.getSubNodesIndex(lexed4));
	assertEquals(0, TbNavigationUtil.getSubNodesIndex(main));
	assertEquals(5, TbNavigationUtil.getSubNodesIndex(eos));
    }

    @Test
    public void testGetSubNodeAt() {
	assertEquals(bos, TbNavigationUtil.getSubNodeAt(main, 0));
	assertEquals(left, TbNavigationUtil.getSubNodeAt(main, 1));
	assertEquals(lexed2, TbNavigationUtil.getSubNodeAt(main, 2));
	assertEquals(middle, TbNavigationUtil.getSubNodeAt(main, 3));
	assertEquals(right, TbNavigationUtil.getSubNodeAt(main, 4));
	assertEquals(eos, TbNavigationUtil.getSubNodeAt(main, 5));
	assertEquals(lexed3, TbNavigationUtil.getSubNodeAt(middle, 0));
	assertEquals(lexed4, TbNavigationUtil.getSubNodeAt(right, 0));
    }

    @Test
    public void testGetSubNodesSize() {
	assertEquals(6, TbNavigationUtil.getSubNodesSize(main));
	assertEquals(2, TbNavigationUtil.getSubNodesSize(middle));
	assertEquals(1, TbNavigationUtil.getSubNodesSize(right));

    }

    @Test
    public void testIsFirstInSubTree() {
	assertEquals(true, TbNavigationUtil.isFirstInSubTree(bos));
	assertEquals(false, TbNavigationUtil.isFirstInSubTree(lexed2));
	assertEquals(true, TbNavigationUtil.isFirstInSubTree(lexed1));
	assertEquals(false, TbNavigationUtil.isFirstInSubTree(middle));
	assertEquals(true, TbNavigationUtil.isFirstInSubTree(main));
    }

    @Test
    public void testIsLastInSubTree() {
	assertEquals(true, TbNavigationUtil.isLastInSubTree(lexed1));
	assertEquals(false, TbNavigationUtil.isLastInSubTree(bos));
	assertEquals(true, TbNavigationUtil.isLastInSubTree(eos));
	assertEquals(false, TbNavigationUtil.isLastInSubTree(middle));
	assertEquals(true, TbNavigationUtil.isLastInSubTree(main));
    }

    @Test
    public void testNextToken() {
	assertEquals(lexed1, TbNavigationUtil.nextToken(bos));
	assertEquals(lexed2, TbNavigationUtil.nextToken(lexed1));
	assertEquals(lexed3, TbNavigationUtil.nextToken(lexed2));
	assertEquals(subToken, TbNavigationUtil.nextToken(lexed3));
	assertEquals(lexed4, TbNavigationUtil.nextToken(subToken));
	assertEquals(eos, TbNavigationUtil.nextToken(lexed4));
	assertEquals(null, TbNavigationUtil.nextToken(eos));
    }

    @Test
    public void testPreviousToken() {
	assertEquals(lexed4, TbNavigationUtil.previousToken(eos));
	assertEquals(subToken, TbNavigationUtil.previousToken(lexed4));
	assertEquals(lexed3, TbNavigationUtil.previousToken(subToken));
	assertEquals(lexed2, TbNavigationUtil.previousToken(lexed3));
	assertEquals(lexed1, TbNavigationUtil.previousToken(lexed2));
	assertEquals(bos, TbNavigationUtil.previousToken(lexed1));
	assertEquals(null, TbNavigationUtil.previousToken(bos));
    }

    @Test
    public void testGetParentBlock() {
	assertEquals(main, TbNavigationUtil.getParentBlock(left));
	assertEquals(left, TbNavigationUtil.getParentBlock(leftLeft));
	assertEquals(null, TbNavigationUtil.getParentBlock(main));
	assertEquals(middle, TbNavigationUtil.getParentBlock(lexed3));
	assertEquals(null, TbNavigationUtil.getParentBlock(null));
    }

    @Test
    public void testIsToken() {
	assertEquals(false, TbNavigationUtil.isToken(main));
	assertEquals(true, TbNavigationUtil.isToken(bos));
    }

    @Test
    public void testReplaceSubTree() {
	TextBlock middleNew = modelFactory.createTextBlock();
	LexedToken lexed3New = modelFactory.createLexedToken();
	middleNew.getSubNodes().add(lexed3New);

	middleNew.setOffset(6);

	assertEquals(middle, TbNavigationUtil.getSubNodeAt(main, 3));
	TbNavigationUtil.replaceSubTree(middle, middleNew);
	assertEquals(middleNew, TbNavigationUtil.getSubNodeAt(main, 3));

	assertEquals(null, middle.getParent());
	assertEquals(main, middleNew.getParent());
	assertEquals(middleNew, lexed3New.getParent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReplaceSubTreeRoot() {
	TbNavigationUtil.replaceSubTree(main, middle);
    }

    @Test
    public void testGetLevel() {
	assertEquals(0, TbNavigationUtil.getLevel(main));
	assertEquals(1, TbNavigationUtil.getLevel(left));
	assertEquals(1, TbNavigationUtil.getLevel(middle));
	assertEquals(1, TbNavigationUtil.getLevel(right));
	assertEquals(2, TbNavigationUtil.getLevel(leftLeft));
	assertEquals(2, TbNavigationUtil.getLevel(subBlock1));
	assertEquals(3, TbNavigationUtil.getLevel(subBlock2));
	assertEquals(4, TbNavigationUtil.getLevel(subBlock3));
	assertEquals(5, TbNavigationUtil.getLevel(subBlock4));
	assertEquals(6, TbNavigationUtil.getLevel(subToken));

    }

}
