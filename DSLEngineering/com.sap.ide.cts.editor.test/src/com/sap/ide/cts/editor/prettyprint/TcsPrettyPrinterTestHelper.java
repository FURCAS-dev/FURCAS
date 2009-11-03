package com.sap.ide.cts.editor.prettyprint;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;

import tcs.ConcreteSyntax;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorPrintStream;
import com.sap.mi.tcs.parser.TcsParserFactory;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TcsPrettyPrinterTestHelper {

	public static String prettyPrintString(RefObject source,
			ConcreteSyntax syntax) throws SyntaxAndModelMismatchException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		CtsPrettyPrinter.prettyPrint(source, syntax,
				new TCSExtractorPrintStream(output));

		return output.toString();
	}

	public static TextBlock prettyPrintTextBlock(RefObject source,
			ConcreteSyntax syntax) throws SyntaxAndModelMismatchException {

		assertNotNull(syntax);

		Connection con = TcsUtil.getConnectionFromRefObject(source);
		TextblocksPackage tbPackage = con
				.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);

		CtsTextBlockTCSExtractorStream target = new CtsTextBlockTCSExtractorStream(
				tbPackage, null, new TcsParserFactory());

		CtsPrettyPrinter.prettyPrint(source, syntax, target);

		return target.getRootBlock();
	}

	public static void prettyPrintConsole(RefObject source,
			ConcreteSyntax syntax) throws SyntaxAndModelMismatchException {
		CtsPrettyPrinter.prettyPrint(source, syntax,
				new TCSExtractorPrintStream(System.out));
	}

}
