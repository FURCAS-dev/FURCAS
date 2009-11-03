package com.sap.ide.cts.editor.prettyprint;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorPrintStream;

public class TCSExtractorPrintStreamTest {

	private TCSExtractorPrintStream stream;
	private ByteArrayOutputStream result;

	@Before
	public void initStream() {
		result = new ByteArrayOutputStream();
		stream = new TCSExtractorPrintStream(result);
	}

	@Test
	public void testPublicInterface() {
		stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		stream.startClassTemplateForObject(null, null);
		stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate();
		stream.endClassTemplate();

		stream.printWhiteSpace("\n\n ");

		stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate();

		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		stream.startClassTemplateForObject(null, null);
		stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate();
		stream.printSymbol("::");
		stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate();
		stream.endClassTemplate();
		stream.endClassTemplate();

		stream.printWhiteSpace(" ");
		stream.endClassTemplate();

		stream.close();

		String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

		assertEquals(refString, result.toString());
	}

	@Test
	public void testBacktrackingResetAll() {
		int handle = stream.createSafePoint();

		stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		stream.startClassTemplateForObject(null, null);
		stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate();
		stream.endClassTemplate();

		stream.printWhiteSpace("\n\n ");

		stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate();

		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		stream.startClassTemplateForObject(null, null);
		stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate();
		stream.printSymbol("::");
		stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate();
		stream.endClassTemplate();
		stream.endClassTemplate();

		stream.printWhiteSpace(" ");
		stream.endClassTemplate();

		stream.resetToSafePoint(handle);

		stream.close();

		String refString = "";

		assertEquals(refString, result.toString());
	}

	@Test
	public void testBacktrackingResetPrimitiveOutput() {
		stream.createSafePoint();

		stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		stream.startClassTemplateForObject(null, null);
		stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate();
		stream.endClassTemplate();

		// use backtracking to remove unwanted output
		int handleInner = stream.createSafePoint();
		stream.printSymbol("::");
		stream.resetToSafePoint(handleInner);

		stream.printWhiteSpace("\n\n ");

		stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate();

		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		stream.startClassTemplateForObject(null, null);
		stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate();
		stream.printSymbol("::");
		stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate();
		stream.endClassTemplate();
		stream.endClassTemplate();

		stream.printWhiteSpace(" ");
		stream.endClassTemplate();

		stream.close();

		String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

		assertEquals(refString, result.toString());
	}

	@Test
	public void testBacktrackingResetTemplateOutput() {
		stream.createSafePoint();

		stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("a");
		stream.printWhiteSpace(" ");
		stream.printBoolean(false);

		stream.startClassTemplateForObject(null, null);
		stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate();
		stream.endClassTemplate();

		// use backtracking to remove unwanted output
		int handleInner = stream.createSafePoint();
		stream.startClassTemplateForObject(null, null);
		stream.createSafePoint();
		stream.startClassTemplateForObject(null, null);
		stream.printString("\"", "a(%tok%");
		stream.endClassTemplate();
		stream.endClassTemplate();
		stream.resetToSafePoint(handleInner);

		stream.printWhiteSpace("\n\n ");

		stream.startClassTemplateForObject(null, null);
		stream.printString("\\\"", "%token%");
		stream.endClassTemplate();

		stream.printWhiteSpace("\n\n ");
		stream.printInteger(2000);

		stream.startClassTemplateForObject(null, null);
		stream.startClassTemplateForObject(null, null);
		stream.printSymbol("(");
		stream.startClassTemplateForObject(null, null);
		stream.printWhiteSpace(" ");
		stream.printIdentifier("PrimitiveTypes");
		stream.endClassTemplate();
		stream.printSymbol("::");
		stream.startClassTemplateForObject(null, null);
		stream.printIdentifier("String");
		stream.endClassTemplate();
		stream.endClassTemplate();
		stream.endClassTemplate();

		stream.printWhiteSpace(" ");
		stream.endClassTemplate();

		stream.close();

		String refString = "a false\"a(%tok%\"\n\n \\\"%token%\\\"\n\n 2000( PrimitiveTypes::String ";

		assertEquals(refString, result.toString());
	}

}
