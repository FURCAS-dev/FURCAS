package com.sap.ide.cts.editor.contentassist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.antlr.runtime.ClassicToken;
import org.antlr.runtime.Token;
import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.ide.editor.contentassist.CtsContentAssistContext;
import com.sap.furcas.ide.editor.contentassist.CtsContentAssistParsingHandler;
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.test.base.StandaloneConnectionBasedTest;
import com.sap.furcas.test.util.TcsTestHelper;

public class CtsContentAssistParsingHandlerTest extends
		StandaloneConnectionBasedTest {

	CtsContentAssistParsingHandler handler;

	@Before
	public void initParsingHandler() {
		// create tcs Syntax
		ConcreteSyntax tcsSyntax = TcsTestHelper
				.createTcsSyntaxMappingOnConnection(connection);
		assertNotNull(tcsSyntax);
		handler = new CtsContentAssistParsingHandler(tcsSyntax);
	}

	@Test
	public void testGetFloorTokenNull() {
		Token token = new ClassicToken(0, "a");
		CtsContentAssistContext context = new CtsContentAssistContext();
		context.setToken(token);

		handler.getPositionMap().put(new TextPosition(1, 0), context);

		assertEquals(null, handler.getFloorContext(0, 0));
	}

	@Test
	public void testGetFloorTokenDifferentLine() {

		Token token = new ClassicToken(0, "a");
		CtsContentAssistContext contextA = new CtsContentAssistContext();
		contextA.setToken(token);

		handler.getPositionMap().put(new TextPosition(0, 0), contextA);

		token = new ClassicToken(0, "b");
		CtsContentAssistContext contextB = new CtsContentAssistContext();
		contextB.setToken(token);

		handler.getPositionMap().put(new TextPosition(1, 10), contextB);

		assertEquals(contextA, handler.getFloorContext(0, 0));
		assertEquals(contextA, handler.getFloorContext(0, 15));
		assertEquals(contextA, handler.getFloorContext(1, 0));
		assertEquals(contextB, handler.getFloorContext(1, 10));
		assertEquals(contextB, handler.getFloorContext(1, 15));

	}

	@Test
	public void testGetFloorTokenSameLine() {
		Token token = new ClassicToken(0, "a");
		CtsContentAssistContext contextA = new CtsContentAssistContext();
		contextA.setToken(token);

		handler.getPositionMap().put(new TextPosition(0, 0), contextA);

		token = new ClassicToken(0, "b");
		CtsContentAssistContext contextB = new CtsContentAssistContext();
		contextB.setToken(token);

		handler.getPositionMap().put(new TextPosition(0, 10), contextB);

		assertEquals(contextA, handler.getFloorContext(0, 0));
		assertEquals(contextA, handler.getFloorContext(0, 9));
		assertEquals(contextB, handler.getFloorContext(0, 10));
		assertEquals(contextB, handler.getFloorContext(1, 0));
		assertEquals(contextB, handler.getFloorContext(1, 15));
	}
}
