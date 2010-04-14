package com.sap.coghead.syntax;

import generated.CollectionLevelPermissionLexer;
import generated.CollectionLevelPermissionParser;

public class CollectionLevelPermissionParserFactory extends AbstractCogheadParserFactory<CollectionLevelPermissionParser, CollectionLevelPermissionLexer> {
    private static final String COLLECTION_LANGUAGE_ID = "CollectionLevelPermission";

    @Override
    public Class<CollectionLevelPermissionLexer> getLexerClass() {
	return CollectionLevelPermissionLexer.class;
    }

    @Override
    public Class<CollectionLevelPermissionParser> getParserClass() {
	return CollectionLevelPermissionParser.class;
    }

    @Override
    public String getLanguageId() {
	return COLLECTION_LANGUAGE_ID;
    }

	@Override
	public Integer[] getOmittedTokensForFormatting() {
		// TODO Auto-generated method stub
		return null;
	}
}
