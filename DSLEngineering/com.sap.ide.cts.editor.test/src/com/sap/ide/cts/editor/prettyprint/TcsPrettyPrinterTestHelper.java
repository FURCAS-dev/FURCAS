package com.sap.ide.cts.editor.prettyprint;

import java.io.ByteArrayOutputStream;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.TcsUtil;
import com.sap.ide.cts.editor.prettyprint.imported.PrettyPrinter;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorPrintStream;
import com.sap.ide.cts.editor.prettyprint.textblocks.TextBlockTCSExtractorStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;



public class TcsPrettyPrinterTestHelper {

    public static String prettyPrintString(EObject source, ConcreteSyntax syntax)
	    throws SyntaxAndModelMismatchException {
	ByteArrayOutputStream output = new ByteArrayOutputStream();

    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  new TCSExtractorPrintStream(output));

	return output.toString();
    }

    public static TextBlock prettyPrintTextBlock(EObject source, ConcreteSyntax syntax,
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory)
	    throws SyntaxAndModelMismatchException {

	ResourceSet con = TcsUtil.getConnectionFromRefObject(source);
	TextblocksPackage tbPackage = con.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(tbPackage, null, parserFactory);
	
    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  target);
	
	return target.getPrintedResultRootBlock();
    }

    public static void prettyPrintConsole(EObject source, ConcreteSyntax syntax)
	    throws SyntaxAndModelMismatchException {
	
    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  new TCSExtractorPrintStream(System.out));
    }

}
