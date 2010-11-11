package com.sap.ide.cts.editor.prettyprint;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrintContext;

public class PrettyPrintContextTest {

	@Test
	public void testDuplicate() {

		PrettyPrintContext context = new PrettyPrintContext();
		context.setCurIndent("a");
		context.setIndentLevel(3);
		context.setTypeLast(1);

		context.getPriorities().push(4);
		context.getPriorities().push(8);

		context.getCurrentSeparator().push("dd");
		context.getCurrentSeparator().push("ee");

		context.getClassTemplates().push(null);

		PrettyPrintContext dup = context.clone();

		assertEquals("a", dup.getCurIndent());
		assertEquals(3, dup.getIndentLevel());
		assertEquals(1, dup.getTypeLast());

		assertEquals(2, dup.getPriorities().size());
		assertEquals(8, (int)dup.getPriorities().pop());
		assertEquals(4, (int)dup.getPriorities().pop());

		assertEquals(2, dup.getCurrentSeparator().size());
		assertEquals("ee", dup.getCurrentSeparator().pop());
		assertEquals("dd", dup.getCurrentSeparator().pop());

		assertEquals(1, dup.getClassTemplates().size());
		assertEquals(null, dup.getClassTemplates().pop());
	}

}
