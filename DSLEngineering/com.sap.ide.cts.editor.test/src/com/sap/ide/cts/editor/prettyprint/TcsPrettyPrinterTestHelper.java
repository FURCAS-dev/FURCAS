package com.sap.ide.cts.editor.prettyprint;

import java.io.ByteArrayOutputStream;

import org.antlr.runtime.Lexer;

import tcs.ConcreteSyntax;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorPrintStream;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockTCSExtractorStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.tcs.util.TcsUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TcsPrettyPrinterTestHelper {

    public static String prettyPrintString(RefObject source, ConcreteSyntax syntax)
	    throws SyntaxAndModelMismatchException {
	ByteArrayOutputStream output = new ByteArrayOutputStream();

    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  new TCSExtractorPrintStream(output));

	return output.toString();
    }

    public static TextBlock prettyPrintTextBlock(RefObject source, ConcreteSyntax syntax,
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory)
	    throws SyntaxAndModelMismatchException {

	Connection con = TcsUtil.getConnectionFromRefObject(source);
	TextblocksPackage tbPackage = con.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(tbPackage, null, parserFactory);
	
    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  target);
	
	return target.getPrintedResultRootBlock();
    }

    public static void prettyPrintConsole(RefObject source, ConcreteSyntax syntax)
	    throws SyntaxAndModelMismatchException {
	
    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  new TCSExtractorPrintStream(System.out));
    }

}
