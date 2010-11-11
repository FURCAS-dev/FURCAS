package com.sap.ide.cts.editor.contentassist.parsinghandler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.TCS.LiteralRef;
import com.sap.furcas.metamodel.TCS.Property;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.ide.cts.editor.contentassist.CtsContentAssistContext;

public class TestCtsContentAssistParsingHandlerSequence extends
		CtsContentAssistParsingHandlerTestBase {

	@Before
	public void initObserver() throws InvalidParserImplementationException,
			IOException, UnknownProductionRuleException {
		observeFixture("fixtures/Sequence.tcs");
	}

	@Test
	public void testValidFinishState() {
		observer.assertValidFinishState();
	};

	@Test
	public void testParentPropertyStackSize() {
		CtsContentAssistContext context;

		context = observer.getFloorContext(1, 0);
		assertEquals(0, context.getParentPropertyStack().size());

		context = observer.getFloorContext(2, 0);
		assertEquals(0, context.getParentPropertyStack().size());

		// templates
		context = observer.getFloorContext(2, 1);
		assertEquals(1, context.getParentPropertyStack().size());

		// templates and names
		context = observer.getFloorContext(2, 14);
		assertEquals(2, context.getParentPropertyStack().size());

		// templates and names
		context = observer.getFloorContext(2, 18);
		assertEquals(2, context.getParentPropertyStack().size());

		// templates and names
		context = observer.getFloorContext(2, 24);
		assertEquals(2, context.getParentPropertyStack().size());

		// templates and elements
		context = observer.getFloorContext(3, 24);
		assertEquals(3, context.getParentPropertyStack().size());

		// templates
		context = observer.getFloorContext(5, 0);
		assertEquals(1, context.getParentPropertyStack().size());

		context = observer.getFloorContext(6, 0);
		assertEquals(0, context.getParentPropertyStack().size());

	}

	@Test
	public void testSequenceElements() {
		CtsContentAssistContext context;

		// property names
		context = observer.getFloorContext(2, 14);
		assertTrue(context.getSequenceElement() instanceof Property);

		// literal ref ::
		context = observer.getFloorContext(2, 18);
		assertTrue(context.getSequenceElement() instanceof LiteralRef);

		// property names
		context = observer.getFloorContext(2, 24);
		assertTrue(context.getSequenceElement() instanceof Property);

	}
}
