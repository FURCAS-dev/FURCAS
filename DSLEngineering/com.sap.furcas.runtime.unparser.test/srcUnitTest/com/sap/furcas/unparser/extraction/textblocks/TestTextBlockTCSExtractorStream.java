/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.unparser.extraction.textblocks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.AbstractToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.parser.tcs.stable.TCSParserFactory;
import com.sap.furcas.runtime.textblocks.model.TextBlocksModel;
import com.sap.furcas.runtime.textblocks.testbase.TextblocksTestHelper;

public class TestTextBlockTCSExtractorStream {

	protected TextBlockTCSExtractorStream stream = null;

	@Before
	public void initStream() {
		stream = new TextBlockTCSExtractorStream(TextblocksPackage.eINSTANCE, new TCSParserFactory());
	}

	@Test
	public void testPublicInterface() {
		int handleMain = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		int handleOuter = stream.startClassTemplateForObject(null, null);
		int handleInner = stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate(handleInner);
		stream.endClassTemplate(handleOuter);

		stream.printWhiteSpace("\n\n ");

		handleOuter = stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate(handleOuter);

		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		int handleA = stream.startClassTemplateForObject(null, null);
		int handleB = stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		int handleC = stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate(handleC);
		stream.printSymbol("::");
		handleC = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate(handleC);
		stream.endClassTemplate(handleB);
		stream.endClassTemplate(handleA);

		stream.printWhiteSpace(" ");
		stream.endClassTemplate(handleMain);

		stream.close();

		String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

		TextBlock rootBlock = stream.getPrintedResultRootBlock();

		assertEquals(refString, rootBlock.getCachedString());
		assertEquals(62, rootBlock.getLength());
		assertEquals(0, rootBlock.getOffset());
		assertEquals(false, rootBlock.isOffsetRelative());

		List<AbstractToken> tokens = rootBlock.getTokens();
		List<TextBlock> subBlocks = rootBlock.getSubBlocks();

		assertEquals(9, tokens.size());

		AbstractToken tok = tokens.get(0);
		assertTrue(tok instanceof Bostoken);

		tok = tokens.get(1);
		assertEquals("a", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(2);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(1, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(3);
		assertEquals("false", tok.getValue());
		assertEquals(5, tok.getLength());
		assertEquals(2, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 9

		tok = tokens.get(4);
		assertEquals("\n\n ", tok.getValue());
		assertEquals(3, tok.getLength());
		assertEquals(16, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 11

		tok = tokens.get(5);
		assertEquals("\n\n ", tok.getValue());
		assertEquals(3, tok.getLength());
		assertEquals(30, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(6);
		assertEquals("2000", tok.getValue());
		assertEquals(4, tok.getLength());
		assertEquals(33, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 24

		tok = tokens.get(7);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(61, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(8);
		assertTrue(tok instanceof Eostoken);

		assertEquals(3, subBlocks.size());

		TextBlock block = subBlocks.get(0);
		assertEquals(1, block.getSubBlocks().size());
		assertEquals(9, block.getLength());
		assertEquals(7, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		block = block.getSubBlocks().get(0);

		tokens = block.getTokens();
		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("\"a(%tok%\"", tok.getValue());
		assertEquals(9, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(9, block.getLength());
		assertEquals(0, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		assertEquals(true, tok.isOffsetRelative());

		block = subBlocks.get(1);
		tokens = block.getTokens();
		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("\\\"%token%\\\"", tok.getValue());
		assertEquals(11, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(11, block.getLength());
		assertEquals(19, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		assertEquals(true, tok.isOffsetRelative());

		block = subBlocks.get(2);
		assertEquals(1, block.getSubBlocks().size());
		assertEquals(24, block.getLength());
		assertEquals(37, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		block = block.getSubBlocks().get(0);
		assertEquals(24, block.getLength());
		assertEquals(0, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		tokens = block.getTokens();

		assertEquals(2, tokens.size());

		tok = tokens.get(0);
		assertEquals("(", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 15

		tok = tokens.get(1);
		assertEquals("::", tok.getValue());
		assertEquals(2, tok.getLength());
		assertEquals(16, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		TextBlock subSlock = block.getSubBlocks().get(1);
		assertEquals(6, subSlock.getLength());
		assertEquals(18, subSlock.getOffset());
		assertEquals(true, block.isOffsetRelative());
		tokens = subSlock.getTokens();

		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("String", tok.getValue());
		assertEquals(6, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		block = block.getSubBlocks().get(0);
		assertEquals(15, block.getLength());
		assertEquals(1, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		tokens = block.getTokens();

		assertEquals(2, tokens.size());

		tok = tokens.get(0);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(1);
		assertEquals("PrimitiveTypes", tok.getValue());
		assertEquals(14, tok.getLength());
		assertEquals(1, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		TextblocksTestHelper.assertTextBlockAndChildren(rootBlock);

		TextBlocksModel model = new TextBlocksModel(rootBlock, null);
		assertEquals(refString, model.get(0, model.getLength()));
	}

	@Test
	public void testBacktrackingResetAllBeforeRootBlock() {

		int handle = stream.createSafePoint();

		int handleMain = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		int handleOuter = stream.startClassTemplateForObject(null, null);
		int handleInner = stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate(handleInner);
		stream.endClassTemplate(handleOuter);

		stream.printWhiteSpace("\n\n ");

		handleOuter = stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate(handleOuter);

		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		int handleA = stream.startClassTemplateForObject(null, null);
		int handleB = stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		int handleC = stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate(handleC);
		stream.printSymbol("::");
		handleC = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate(handleC);
		stream.endClassTemplate(handleB);
		stream.endClassTemplate(handleA);

		stream.printWhiteSpace(" ");
		stream.endClassTemplate(handleMain);

		stream.resetToSafePoint(handle);

		stream.close();

		assertEquals(null, stream.getPrintedResultRootBlock());
	}

	@Test
	public void testBacktrackingResetAllAfterRootBlock() {

		int handleMain = stream.startClassTemplateForObject(null, null);

		int handle = stream.createSafePoint();

		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		int handleOuter = stream.startClassTemplateForObject(null, null);
		int handleInner = stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate(handleInner);
		stream.endClassTemplate(handleOuter);

		stream.printWhiteSpace("\n\n ");

		handleOuter = stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate(handleOuter);

		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		int handleA = stream.startClassTemplateForObject(null, null);
		int handleB = stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		int handleC = stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate(handleC);
		stream.printSymbol("::");
		handleC = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate(handleC);
		stream.endClassTemplate(handleB);
		stream.endClassTemplate(handleA);

		stream.printWhiteSpace(" ");
		stream.endClassTemplate(handleMain);

		stream.resetToSafePoint(handle);

		stream.close();

		TextBlock rootBlock = stream.getPrintedResultRootBlock();

		assertEquals("", rootBlock.getCachedString());
		assertEquals(0, rootBlock.getLength());
		assertEquals(2, rootBlock.getTokens().size()); // bos and eos tokens
		// only
		assertEquals(0, rootBlock.getSubBlocks().size());
	}

	@Test
	public void testBacktrackingResetPrimitiveOutput() {
		stream.createSafePoint();

		int handleMain = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		int handleOuter = stream.startClassTemplateForObject(null, null);
		int handleInner = stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate(handleInner);
		stream.endClassTemplate(handleOuter);

		// use backtracking to remove unwanted output
		int handleSavePointInner = stream.createSafePoint();
		stream.printSymbol("::");
		stream.resetToSafePoint(handleSavePointInner);

		stream.printWhiteSpace("\n\n ");

		handleOuter = stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate(handleOuter);

		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		int handleA = stream.startClassTemplateForObject(null, null);
		int handleB = stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		int handleC = stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate(handleC);
		stream.printSymbol("::");
		handleC = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate(handleC);
		stream.endClassTemplate(handleB);
		stream.endClassTemplate(handleA);

		stream.printWhiteSpace(" ");
		stream.endClassTemplate(handleMain);

		stream.close();

		String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

		TextBlock rootBlock = stream.getPrintedResultRootBlock();

		assertEquals(refString, rootBlock.getCachedString());
		assertEquals(62, rootBlock.getLength());
		assertEquals(0, rootBlock.getOffset());
		assertEquals(false, rootBlock.isOffsetRelative());

		List<AbstractToken> tokens = rootBlock.getTokens();
		List<TextBlock> subBlocks = rootBlock.getSubBlocks();

		assertEquals(9, tokens.size());

		AbstractToken tok = tokens.get(0);
		assertTrue(tok instanceof Bostoken);

		tok = tokens.get(1);
		assertEquals("a", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(2);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(1, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(3);
		assertEquals("false", tok.getValue());
		assertEquals(5, tok.getLength());
		assertEquals(2, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 9

		tok = tokens.get(4);
		assertEquals("\n\n ", tok.getValue());
		assertEquals(3, tok.getLength());
		assertEquals(16, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 11

		tok = tokens.get(5);
		assertEquals("\n\n ", tok.getValue());
		assertEquals(3, tok.getLength());
		assertEquals(30, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(6);
		assertEquals("2000", tok.getValue());
		assertEquals(4, tok.getLength());
		assertEquals(33, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 24

		tok = tokens.get(7);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(61, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(8);
		assertTrue(tok instanceof Eostoken);

		assertEquals(3, subBlocks.size());

		TextBlock block = subBlocks.get(0);
		assertEquals(1, block.getSubBlocks().size());
		assertEquals(9, block.getLength());
		assertEquals(7, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		block = block.getSubBlocks().get(0);

		tokens = block.getTokens();
		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("\"a(%tok%\"", tok.getValue());
		assertEquals(9, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(9, block.getLength());
		assertEquals(0, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		assertEquals(true, tok.isOffsetRelative());

		block = subBlocks.get(1);
		tokens = block.getTokens();
		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("\\\"%token%\\\"", tok.getValue());
		assertEquals(11, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(11, block.getLength());
		assertEquals(19, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		assertEquals(true, tok.isOffsetRelative());

		block = subBlocks.get(2);
		assertEquals(1, block.getSubBlocks().size());
		assertEquals(24, block.getLength());
		assertEquals(37, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		block = block.getSubBlocks().get(0);
		assertEquals(24, block.getLength());
		assertEquals(0, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		tokens = block.getTokens();

		assertEquals(2, tokens.size());

		tok = tokens.get(0);
		assertEquals("(", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 15

		tok = tokens.get(1);
		assertEquals("::", tok.getValue());
		assertEquals(2, tok.getLength());
		assertEquals(16, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		TextBlock subSlock = block.getSubBlocks().get(1);
		assertEquals(6, subSlock.getLength());
		assertEquals(18, subSlock.getOffset());
		assertEquals(true, block.isOffsetRelative());
		tokens = subSlock.getTokens();

		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("String", tok.getValue());
		assertEquals(6, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		block = block.getSubBlocks().get(0);
		assertEquals(15, block.getLength());
		assertEquals(1, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		tokens = block.getTokens();

		assertEquals(2, tokens.size());

		tok = tokens.get(0);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(1);
		assertEquals("PrimitiveTypes", tok.getValue());
		assertEquals(14, tok.getLength());
		assertEquals(1, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		TextblocksTestHelper.assertTextBlockAndChildren(rootBlock);

		TextBlocksModel model = new TextBlocksModel(rootBlock, null);
		assertEquals(refString, model.get(0, model.getLength()));
	}

	@Test
	public void testBacktrackingResetTemplateOutput() {
		stream.createSafePoint();

		int handleMain = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		int handleOuter = stream.startClassTemplateForObject(null, null);
		int handleInner = stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate(handleInner);
		stream.endClassTemplate(handleOuter);

		// use backtracking to remove unwanted output
		int handleSafePointInner = stream.createSafePoint();
		handleOuter = stream.startClassTemplateForObject(null, null);
		
		//also assume more safepoints created within template
		stream.createSafePoint();
		stream.createSafePoint();
		handleInner = stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate(handleInner);
		stream.endClassTemplate(handleOuter);
		stream.resetToSafePoint(handleSafePointInner);

		stream.printWhiteSpace("\n\n ");

		handleOuter = stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate(handleOuter);
		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		int handleA = stream.startClassTemplateForObject(null, null);
		int handleB = stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		int handleC = stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate(handleC);
		stream.printSymbol("::");
		handleC = stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate(handleC);
		stream.endClassTemplate(handleB);
		stream.endClassTemplate(handleA);

		stream.printWhiteSpace(" ");
		stream.endClassTemplate(handleMain);

		stream.close();

		String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

		TextBlock rootBlock = stream.getPrintedResultRootBlock();

		assertEquals(refString, rootBlock.getCachedString());
		assertEquals(62, rootBlock.getLength());
		assertEquals(0, rootBlock.getOffset());
		assertEquals(false, rootBlock.isOffsetRelative());

		List<AbstractToken> tokens = rootBlock.getTokens();
		List<TextBlock> subBlocks = rootBlock.getSubBlocks();

		assertEquals(9, tokens.size());

		AbstractToken tok = tokens.get(0);
		assertTrue(tok instanceof Bostoken);

		tok = tokens.get(1);
		assertEquals("a", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(2);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(1, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(3);
		assertEquals("false", tok.getValue());
		assertEquals(5, tok.getLength());
		assertEquals(2, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 9

		tok = tokens.get(4);
		assertEquals("\n\n ", tok.getValue());
		assertEquals(3, tok.getLength());
		assertEquals(16, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 11

		tok = tokens.get(5);
		assertEquals("\n\n ", tok.getValue());
		assertEquals(3, tok.getLength());
		assertEquals(30, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(6);
		assertEquals("2000", tok.getValue());
		assertEquals(4, tok.getLength());
		assertEquals(33, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 24

		tok = tokens.get(7);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(61, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(8);
		assertTrue(tok instanceof Eostoken);

		assertEquals(3, subBlocks.size());

		TextBlock block = subBlocks.get(0);
		assertEquals(1, block.getSubBlocks().size());
		assertEquals(9, block.getLength());
		assertEquals(7, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		block = block.getSubBlocks().get(0);

		tokens = block.getTokens();
		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("\"a(%tok%\"", tok.getValue());
		assertEquals(9, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(9, block.getLength());
		assertEquals(0, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		assertEquals(true, tok.isOffsetRelative());

		block = subBlocks.get(1);
		tokens = block.getTokens();
		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("\\\"%token%\\\"", tok.getValue());
		assertEquals(11, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(11, block.getLength());
		assertEquals(19, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		assertEquals(true, tok.isOffsetRelative());

		block = subBlocks.get(2);
		assertEquals(1, block.getSubBlocks().size());
		assertEquals(24, block.getLength());
		assertEquals(37, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		block = block.getSubBlocks().get(0);
		assertEquals(24, block.getLength());
		assertEquals(0, block.getOffset());
		assertEquals(true, block.isOffsetRelative());

		tokens = block.getTokens();

		assertEquals(2, tokens.size());

		tok = tokens.get(0);
		assertEquals("(", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		// block length 15

		tok = tokens.get(1);
		assertEquals("::", tok.getValue());
		assertEquals(2, tok.getLength());
		assertEquals(16, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		TextBlock subSlock = block.getSubBlocks().get(1);
		assertEquals(6, subSlock.getLength());
		assertEquals(18, subSlock.getOffset());
		assertEquals(true, block.isOffsetRelative());
		tokens = subSlock.getTokens();

		assertEquals(1, tokens.size());

		tok = tokens.get(0);
		assertEquals("String", tok.getValue());
		assertEquals(6, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		block = block.getSubBlocks().get(0);
		assertEquals(15, block.getLength());
		assertEquals(1, block.getOffset());
		assertEquals(true, block.isOffsetRelative());
		tokens = block.getTokens();

		assertEquals(2, tokens.size());

		tok = tokens.get(0);
		assertEquals(" ", tok.getValue());
		assertEquals(1, tok.getLength());
		assertEquals(0, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		tok = tokens.get(1);
		assertEquals("PrimitiveTypes", tok.getValue());
		assertEquals(14, tok.getLength());
		assertEquals(1, tok.getOffset());
		assertEquals(true, tok.isOffsetRelative());

		TextblocksTestHelper.assertTextBlockAndChildren(rootBlock);

		TextBlocksModel model = new TextBlocksModel(rootBlock, null);
		assertEquals(refString, model.get(0, model.getLength()));
	}
}
