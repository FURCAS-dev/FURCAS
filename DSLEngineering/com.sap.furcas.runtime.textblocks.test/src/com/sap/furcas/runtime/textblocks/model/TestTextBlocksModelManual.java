package com.sap.furcas.runtime.textblocks.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.OmittedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksFactory;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;

public class TestTextBlocksModelManual {

    private TextBlock rootBlock;

    @Before
    public void setUpTree() throws Exception {
	initTree();
    }

    private void initTree() {
	rootBlock = TextblocksFactory.eINSTANCE.createTextBlock();
	rootBlock.setChildrenChanged(false);
	rootBlock.setVersion(Version.REFERENCE);
	rootBlock.setRelexingNeeded(false);
	rootBlock.setStartRow(0);
	rootBlock.setStartColumn(0);
	rootBlock.setEndRow(0);
	rootBlock.setEndColumn(11);
	rootBlock.setOffset(0);
	rootBlock.setLength(11);
	rootBlock.setOffsetRelative(true);
	//rootBlock.setComplete(false);
	rootBlock.setCachedString("abc - d*ee;\n");
	Bostoken bosToken = TextblocksFactory.eINSTANCE.createBostoken();
	bosToken.setChildrenChanged(false);
	bosToken.setVersion(Version.REFERENCE);
	bosToken.setRelexingNeeded(false);
	bosToken.setStartRow(0);
	bosToken.setStartColumn(0);
	bosToken.setEndRow(0);
	bosToken.setEndColumn(0);
	bosToken.setOffset(0);
	bosToken.setLength(0);
	bosToken.setOffsetRelative(true);
	bosToken.setValue("");
	bosToken.setLookahead(0);
	bosToken.setLookback(0);
	bosToken.setState(0);
	//bosToken.setType(0);
	rootBlock.getSubNodes().add(bosToken);
	LexedToken lexedToken =  TextblocksFactory.eINSTANCE.createLexedToken();
	lexedToken.setChildrenChanged(false);
	lexedToken.setVersion(Version.REFERENCE);
	lexedToken.setRelexingNeeded(false);
	lexedToken.setStartRow(0);
	lexedToken.setStartColumn(0);
	lexedToken.setEndRow(0);
	lexedToken.setEndColumn(2);
	lexedToken.setOffset(0);
	lexedToken.setLength(3);
	lexedToken.setOffsetRelative(true);
	lexedToken.setValue("abc");
	lexedToken.setLookahead(0);
	lexedToken.setLookback(0);
	lexedToken.setState(0);
	lexedToken.setType(0);
	rootBlock.getSubNodes().add(lexedToken);
	OmittedToken omittedToken = TextblocksFactory.eINSTANCE.createOmittedToken();
	omittedToken.setChildrenChanged(false);
	omittedToken.setVersion(Version.REFERENCE);
	omittedToken.setRelexingNeeded(false);
	omittedToken.setStartRow(0);
	omittedToken.setStartColumn(3);
	omittedToken.setEndRow(0);
	omittedToken.setEndColumn(3);
	omittedToken.setOffset(3);
	omittedToken.setLength(1);
	omittedToken.setOffsetRelative(true);
	omittedToken.setValue(" ");
	omittedToken.setLookahead(0);
	omittedToken.setLookback(0);
	omittedToken.setState(0);
	//omittedToken.setType(0);
	rootBlock.getSubNodes().add(omittedToken);
	lexedToken = TextblocksFactory.eINSTANCE.createLexedToken();
	lexedToken.setChildrenChanged(false);
	lexedToken.setVersion(Version.REFERENCE);
	lexedToken.setRelexingNeeded(false);
	lexedToken.setStartRow(0);
	lexedToken.setStartColumn(4);
	lexedToken.setEndRow(0);
	lexedToken.setEndColumn(4);
	lexedToken.setOffset(4);
	lexedToken.setLength(1);
	lexedToken.setOffsetRelative(true);
	lexedToken.setValue("-");
	lexedToken.setLookahead(0);
	lexedToken.setLookback(0);
	lexedToken.setState(0);
	lexedToken.setType(0);
	rootBlock.getSubNodes().add(lexedToken);
	omittedToken = TextblocksFactory.eINSTANCE.createOmittedToken();
	omittedToken.setChildrenChanged(false);
	omittedToken.setVersion(Version.REFERENCE);
	omittedToken.setRelexingNeeded(false);
	omittedToken.setStartRow(0);
	omittedToken.setStartColumn(5);
	omittedToken.setEndRow(0);
	omittedToken.setEndColumn(5);
	omittedToken.setOffset(5);
	omittedToken.setLength(1);
	omittedToken.setOffsetRelative(true);
	omittedToken.setValue(" ");
	omittedToken.setLookahead(0);
	omittedToken.setLookback(0);
	omittedToken.setState(0);
	//omittedToken.setType(0);
	rootBlock.getSubNodes().add(omittedToken);
	Eostoken eosToken = TextblocksFactory.eINSTANCE.createEostoken();
	eosToken.setChildrenChanged(false);
	eosToken.setVersion(Version.REFERENCE);
	eosToken.setRelexingNeeded(false);
	eosToken.setStartRow(0);
	eosToken.setStartColumn(5);
	eosToken.setEndRow(0);
	eosToken.setEndColumn(5);
	eosToken.setOffset(5);
	eosToken.setLength(0);
	eosToken.setOffsetRelative(true);
	eosToken.setValue("");
	eosToken.setLookahead(0);
	eosToken.setLookback(0);
	eosToken.setState(0);
	//eosToken.setType(0);
	rootBlock.getSubNodes().add(eosToken);
	TextBlock block2 = TextblocksFactory.eINSTANCE.createTextBlock();
	block2.setChildrenChanged(false);
	block2.setVersion(Version.REFERENCE);
	block2.setRelexingNeeded(false);
	block2.setStartRow(0);
	block2.setStartColumn(6);
	block2.setEndRow(0);
	block2.setEndColumn(11);
	block2.setOffset(6);
	block2.setLength(6);
	block2.setOffsetRelative(true);
	//block2.setComplete(false);
	block2.setCachedString("d*ee;\n");
	rootBlock.getSubNodes().add(block2);
	lexedToken = TextblocksFactory.eINSTANCE.createLexedToken();
	lexedToken.setChildrenChanged(false);
	lexedToken.setVersion(Version.REFERENCE);
	lexedToken.setRelexingNeeded(false);
	lexedToken.setStartRow(0);
	lexedToken.setStartColumn(6);
	lexedToken.setEndRow(0);
	lexedToken.setEndColumn(6);
	lexedToken.setOffset(0);
	lexedToken.setLength(1);
	lexedToken.setOffsetRelative(true);
	lexedToken.setValue("d");
	lexedToken.setLookahead(0);
	lexedToken.setLookback(0);
	lexedToken.setState(0);
	lexedToken.setType(0);
	block2.getSubNodes().add(lexedToken);
	lexedToken = TextblocksFactory.eINSTANCE.createLexedToken();
	lexedToken.setChildrenChanged(false);
	lexedToken.setVersion(Version.REFERENCE);
	lexedToken.setRelexingNeeded(false);
	lexedToken.setStartRow(0);
	lexedToken.setStartColumn(7);
	lexedToken.setEndRow(0);
	lexedToken.setEndColumn(7);
	lexedToken.setOffset(1);
	lexedToken.setLength(1);
	lexedToken.setOffsetRelative(true);
	lexedToken.setValue("*");
	lexedToken.setLookahead(0);
	lexedToken.setLookback(0);
	lexedToken.setState(0);
	lexedToken.setType(0);
	block2.getSubNodes().add(lexedToken);
	lexedToken = TextblocksFactory.eINSTANCE.createLexedToken();
	lexedToken.setChildrenChanged(false);
	lexedToken.setVersion(Version.REFERENCE);
	lexedToken.setRelexingNeeded(false);
	lexedToken.setStartRow(0);
	lexedToken.setStartColumn(8);
	lexedToken.setEndRow(0);
	lexedToken.setEndColumn(9);
	lexedToken.setOffset(2);
	lexedToken.setLength(2);
	lexedToken.setOffsetRelative(true);
	lexedToken.setValue("ee");
	lexedToken.setLookahead(0);
	lexedToken.setLookback(0);
	lexedToken.setState(0);
	lexedToken.setType(0);
	block2.getSubNodes().add(lexedToken);
	lexedToken = TextblocksFactory.eINSTANCE.createLexedToken();
	lexedToken.setChildrenChanged(false);
	lexedToken.setVersion(Version.REFERENCE);
	lexedToken.setRelexingNeeded(false);
	lexedToken.setStartRow(0);
	lexedToken.setStartColumn(10);
	lexedToken.setEndRow(0);
	lexedToken.setEndColumn(10);
	lexedToken.setOffset(4);
	lexedToken.setLength(1);
	lexedToken.setOffsetRelative(true);
	lexedToken.setValue(";");
	lexedToken.setLookahead(0);
	lexedToken.setLookback(0);
	lexedToken.setState(0);
	lexedToken.setType(0);
	block2.getSubNodes().add(lexedToken);
	lexedToken = TextblocksFactory.eINSTANCE.createLexedToken();
	lexedToken.setChildrenChanged(false);
	lexedToken.setVersion(Version.REFERENCE);
	lexedToken.setRelexingNeeded(false);
	lexedToken.setStartRow(0);
	lexedToken.setStartColumn(11);
	lexedToken.setEndRow(0);
	lexedToken.setEndColumn(11);
	lexedToken.setOffset(5);
	lexedToken.setLength(1);
	lexedToken.setOffsetRelative(true);
	lexedToken.setValue("\n");
	lexedToken.setLookahead(0);
	lexedToken.setLookback(0);
	lexedToken.setState(0);
	lexedToken.setType(0);
	block2.getSubNodes().add(lexedToken);
    }

    @Test
    public void testGetChar() throws Exception {
	TextBlocksModel tbModel = new TextBlocksModel(rootBlock, null);
	char c = tbModel.get(8);
	assertEquals('e', c);
    }

    @Test
    public void testGetString() throws Exception {
	TextBlocksModel tbModel = new TextBlocksModel(rootBlock, null);
	String c = tbModel.get(2, 5);
	assertEquals("c - d", c);
    }

    @Test
    public void testReplaceString() throws Exception {
	TextBlocksModel tbModel = new TextBlocksModel(rootBlock, null);
	tbModel.replace(2, 0, "c");
	String c = tbModel.get(2, 5);
	assertEquals("cc - ", c);
    }

}
