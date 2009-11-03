package com.sap.ap.cts.monet.parser;

import generated.AdapterLexer;
import generated.AdapterParser;

public class AdapterParserFactory extends AbstractRunletParserFactory<AdapterParser, AdapterLexer> {

    private static final String ADAPTER_LANGUAGE_ID = "Adapter";

    @Override
    public Class<AdapterLexer> getLexerClass() {
	return AdapterLexer.class;
    }

    @Override
    public Class<AdapterParser> getParserClass() {
	return AdapterParser.class;
    }

    @Override
    public String getLanguageId() {
	return ADAPTER_LANGUAGE_ID;
    }

}
