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

		assertEquals(refString, result.toString());
	}

	@Test
	public void testBacktrackingResetAll() {
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

		String refString = "";

		assertEquals(refString, result.toString());
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

		assertEquals(refString, result.toString());
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

		assertEquals(refString, result.toString());
	}

}
