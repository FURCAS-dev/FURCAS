package com.sap.furcas.unparser.testutils;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.unparser.PrettyPrinter;
import com.sap.furcas.unparser.SyntaxAndModelMismatchException;
import com.sap.furcas.unparser.extraction.TCSExtractorPrintStream;
import com.sap.furcas.unparser.extraction.textblocks.TextBlockTCSExtractorStream;

public class PrettyPrintTestHelper {

    public static String prettyPrintString(EObject source, ConcreteSyntax syntax, Set<URI> metamodels) throws SyntaxAndModelMismatchException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        IMetaModelLookup<EObject> lookup = new QueryBasedEcoreMetaModelLookUp(syntax.eResource().getResourceSet(), metamodels);
        PrettyPrinter prettyPrinter = new PrettyPrinter(syntax, lookup);
        prettyPrinter.prettyPrint(source, new TCSExtractorPrintStream(output));

        return output.toString();
    }

    public static TextBlock prettyPrintTextBlock(EObject source, ConcreteSyntax syntax,
            ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) throws SyntaxAndModelMismatchException {

        TextBlockTCSExtractorStream target = new TextBlockTCSExtractorStream(parserFactory);

        IMetaModelLookup<EObject> lookup = new QueryBasedEcoreMetaModelLookUp(syntax.eResource().getResourceSet(),
                parserFactory.getMetamodelURIs());
        PrettyPrinter prettyPrinter = new PrettyPrinter(syntax, lookup);
        prettyPrinter.prettyPrint(source, target);

        return target.getPrintedResultRootBlock();
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
