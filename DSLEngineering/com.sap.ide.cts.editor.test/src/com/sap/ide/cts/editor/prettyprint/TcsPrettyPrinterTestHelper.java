package com.sap.ide.cts.editor.prettyprint;

import java.io.ByteArrayOutputStream;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

<<<<<<< HEAD
import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.TextblocksPackage;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorPrintStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.mi.textual.tcs.util.TcsUtil;

=======
import tcs.ConcreteSyntax;
import textblocks.TextBlock;
import textblocks.TextblocksPackage;

import com.sap.furcas.textual.tcs.TcsUtil;
import com.sap.ide.cts.editor.prettyprint.imported.TCSExtractorPrintStream;
import com.sap.ide.cts.parser.incremental.ParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
>>>>>>> 339c4f6827f2205a0254bfb911d75ecfc4a51698

public class TcsPrettyPrinterTestHelper {

    public static String prettyPrintString(EObject source, ConcreteSyntax syntax)
	    throws SyntaxAndModelMismatchException {
	ByteArrayOutputStream output = new ByteArrayOutputStream();

	CtsPrettyPrinter.prettyPrint(source, syntax, new TCSExtractorPrintStream(output), null, null);

	return output.toString();
    }

    public static TextBlock prettyPrintTextBlock(EObject source, ConcreteSyntax syntax,
	    ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory)
	    throws SyntaxAndModelMismatchException {

	ResourceSet con = TcsUtil.getConnectionFromRefObject(source);
	TextblocksPackage tbPackage = con.getPackage(TextblocksPackage.PACKAGE_DESCRIPTOR);
	CtsTextBlockTCSExtractorStream target = new CtsTextBlockTCSExtractorStream(tbPackage, null, parserFactory);
	CtsPrettyPrinter.prettyPrint(source, syntax, target, null, null);
	return target.getRootBlock();
    }

    public static void prettyPrintConsole(EObject source, ConcreteSyntax syntax)
	    throws SyntaxAndModelMismatchException {
	CtsPrettyPrinter.prettyPrint(source, syntax, new TCSExtractorPrintStream(System.out), null, null);
    }

}