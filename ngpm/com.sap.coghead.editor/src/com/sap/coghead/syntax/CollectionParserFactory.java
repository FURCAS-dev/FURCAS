package com.sap.coghead.syntax;

import generated.CollectionLexer;
import generated.CollectionParser;

public class CollectionParserFactory extends AbstractCogheadParserFactory<CollectionParser, CollectionLexer> {
    private static final String COLLECTION_LANGUAGE_ID = "Collection";

    @Override
    public Class<CollectionLexer> getLexerClass() {
	return CollectionLexer.class;
    }

    @Override
    public Class<CollectionParser> getParserClass() {
	return CollectionParser.class;
    }

    @Override
    public String getLanguageId() {
	return COLLECTION_LANGUAGE_ID;
    }
}
