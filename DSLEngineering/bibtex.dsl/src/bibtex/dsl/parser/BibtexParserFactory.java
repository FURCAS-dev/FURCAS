package bibtex.dsl.parser;

import generated.BibtexLexer;
import generated.BibtexParser;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;

import Bibtex.BibtexPackage;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;

public class BibtexParserFactory extends
        AbstractParserFactory<BibtexParser, BibtexLexer> {

    private static final String LANGUAGE_ID = "Bibtex";

    @Override
    public Class<BibtexLexer> getLexerClass() {
        return BibtexLexer.class;
    }

    @Override
    public Class<BibtexParser> getParserClass() {
        return BibtexParser.class;
    }

    @Override
    public String getLanguageId() {
        return LANGUAGE_ID;
    }

    @Override
    public Set<URI> getMetamodelURIs() {
        HashSet<URI> metamodels = new HashSet<URI>();
        metamodels.add(URI.createURI(BibtexPackage.eINSTANCE.getNsURI()));
        metamodels.add(URI.createURI(EcorePackage.eINSTANCE.getNsURI()));
        return metamodels;
    }

    @Override
    public URI getSyntaxResourceURI() {
        return URI.createPlatformPluginURI("/bibtex.dsl/mappings/Bibtex.tcs", true);
    }

    @Override
    public Set<URI> getAdditionalQueryScope() {
        return Collections.emptySet();
    }
}
