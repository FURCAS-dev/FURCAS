package com.sap.furcas.tcs.editor.parser;

import generated.TCSLexer;
import generated.TCSParser;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;

public class TCSParserFactory extends
        AbstractParserFactory<TCSParser, TCSLexer> {

    private static final String LANGUAGE_ID = "TCS";

    @Override
    public Class<TCSLexer> getLexerClass() {
        return TCSLexer.class;
    }

    @Override
    public Class<TCSParser> getParserClass() {
        return TCSParser.class;
    }

    @Override
    public String getLanguageId() {
        return LANGUAGE_ID;
    }

    @Override
    public EPackage getMetamodelPackage(ResourceSet connection) {
        return EPackage.Registry.INSTANCE.getEPackage("http://www.furcas.org");
    }

    @Override
    public String[] getHiddenChannelTokenNames() {
        return new String[] { "WS", "NL", "COMMENT" };
    }

    @Override
    public URI getSyntaxUri() {
        return URI.createPlatformPluginURI("/com.sap.furcas.tcs.editor/mappings/TCS.tcs",
                true);
    }
}
