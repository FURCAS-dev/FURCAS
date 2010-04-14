package com.sap.ap.cts.monet.parser;

import generated.ActionsLexer;
import generated.ActionsParser;

public class ActionsParserFactory extends AbstractRunletParserFactory<ActionsParser, ActionsLexer> {

    private static final String ACTIONS_LANGUAGE_ID = "Actions";

    @Override
    public Class<ActionsLexer> getLexerClass() {
	return ActionsLexer.class;
    }

    @Override
    public Class<ActionsParser> getParserClass() {
	return ActionsParser.class;
    }

    @Override
    public String getLanguageId() {
	return ACTIONS_LANGUAGE_ID;
    }

	@Override
	public Integer[] getOmittedTokensForFormatting() {
		// TODO Auto-generated method stub
		return null;
	}
}
