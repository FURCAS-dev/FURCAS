package com.sap.furcas.unparser.testutils;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.unparser.PrettyPrinter;
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.TCSExtractorPrintStream;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;



public class PrettyPrintTestHelper {
    
    public static String prettyPrintString(EObject source, ConcreteSyntax syntax) throws SyntaxAndModelMismatchException {
	ByteArrayOutputStream output = new ByteArrayOutputStream();

    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  new TCSExtractorPrintStream(output));

	return output.toString();
    }

    public static TextBlock prettyPrintTextBlock(EObject source, ConcreteSyntax syntax,
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory)
	    throws SyntaxAndModelMismatchException {

	TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(TextblocksPackage.eINSTANCE, parserFactory);
	
    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  target);
	
	return target.getPrintedResultRootBlock();
    }

    public static void prettyPrintConsole(EObject source, ConcreteSyntax syntax) throws SyntaxAndModelMismatchException {
    	PrettyPrinter prettyPrinter = new PrettyPrinter();
    	prettyPrinter.prettyPrint(source, syntax,  new TCSExtractorPrintStream(System.out));
    }
    
    public static String readFile(String fileName) throws IOException {
        char[] chr = new char[2048];
        FileReader reader = new FileReader(fileName);
        StringBuffer buf = new StringBuffer();
        try {
            int len = 0;
            while ((len=reader.read(chr))>0) {
                buf.append(chr, 0, len);
            }
        } finally {
            reader.close();
        }
        return buf.toString();
    }

}
