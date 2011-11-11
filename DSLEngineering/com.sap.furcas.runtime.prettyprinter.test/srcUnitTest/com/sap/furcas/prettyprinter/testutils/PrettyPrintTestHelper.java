package com.sap.furcas.prettyprinter.testutils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.prettyprinter.PrettyPrinter;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;


public class PrettyPrintTestHelper {

    public static String prettyPrintString(EObject source, ConcreteSyntax syntax, Set<URI> metamodels) throws SyntaxMismatchException {
        IMetaModelLookup<EObject> lookup = new QueryBasedEcoreMetaModelLookUp(syntax.eResource().getResourceSet(), metamodels);
        // Using the TCSParserFactory here is a crude hack: We should use the ParserFactories suitable for the given
        // syntax. However, not all clients of this test method know their respective factory.
        // Using the (wrong) TCS factory here will lead to wrong token types. But as the client is only
        // interested in the string representation, this is not a problem.
        PrettyPrinter prettyPrinter = new PrettyPrinter(syntax, lookup, new TCSSpecificOCLEvaluator(), new TCSParserFactory());

        return prettyPrinter.prettyPrint(source).getCachedString();
    }

    public static TextBlock prettyPrintTextBlock(EObject source, ConcreteSyntax syntax,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) throws SyntaxMismatchException {

        PrettyPrinter prettyPrinter = createPrettyPrinter(syntax, parserFactory);

        return prettyPrinter.prettyPrint(source);
    }

    public static TextBlock prettyPrintTextBlock(EObject source, TextBlock textBlock,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) throws SyntaxMismatchException {

        PrettyPrinter prettyPrinter = createPrettyPrinter(textBlock.getType().getConcreteSyntax(), parserFactory);
        return prettyPrinter.prettyPrint(source, textBlock);
    }
    
    private static PrettyPrinter createPrettyPrinter(ConcreteSyntax syntax,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        
        IMetaModelLookup<EObject> lookup = new QueryBasedEcoreMetaModelLookUp(syntax.eResource().getResourceSet(), parserFactory.getMetamodelURIs());
        PrettyPrinter prettyPrinter = new PrettyPrinter(syntax, lookup, new TCSSpecificOCLEvaluator(), parserFactory);
        return prettyPrinter;
    }

    public static String readFile(String fileName) throws IOException {
        char[] chr = new char[2048];
        FileReader reader = new FileReader(fileName);
        StringBuffer buf = new StringBuffer();
        try {
            int len = 0;
            while ((len = reader.read(chr)) > 0) {
                buf.append(chr, 0, len);
            }
        } finally {
            reader.close();
        }
        return buf.toString();
    }

}
