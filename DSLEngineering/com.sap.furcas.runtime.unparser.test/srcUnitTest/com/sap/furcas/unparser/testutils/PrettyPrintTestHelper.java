package com.sap.furcas.unparser.testutils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.prettyprinter.PrettyPrinter;
import com.sap.furcas.prettyprinter.exceptions.SyntaxMismatchException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;


public class PrettyPrintTestHelper {

    public static String prettyPrintString(EObject source, ConcreteSyntax syntax, Set<URI> metamodels) throws SyntaxMismatchException {
        IMetaModelLookup<EObject> lookup = new QueryBasedEcoreMetaModelLookUp(syntax.eResource().getResourceSet(), metamodels);
        PrettyPrinter prettyPrinter = new PrettyPrinter(syntax, lookup, new TCSSpecificOCLEvaluator());

        return prettyPrinter.prettyPrint(source).getCachedString();
    }

    public static TextBlock prettyPrintTextBlock(EObject source, ConcreteSyntax syntax,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) throws SyntaxMismatchException {

        IMetaModelLookup<EObject> lookup = new QueryBasedEcoreMetaModelLookUp(syntax.eResource().getResourceSet(), parserFactory.getMetamodelURIs());
        PrettyPrinter prettyPrinter = new PrettyPrinter(syntax, lookup, new TCSSpecificOCLEvaluator(), parserFactory);

        return prettyPrinter.prettyPrint(source);
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
