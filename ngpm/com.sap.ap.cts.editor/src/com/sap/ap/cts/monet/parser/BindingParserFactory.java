package com.sap.ap.cts.monet.parser;

import generated.BindingLexer;
import generated.BindingParser;

public class BindingParserFactory extends AbstractRunletParserFactory<BindingParser, BindingLexer> {

    private static final String BINDING_LANGUAGE_ID = "Binding";

    @Override
    public Class<BindingLexer> getLexerClass() {
	return BindingLexer.class;
    }

    @Override
    public Class<BindingParser> getParserClass() {
	return BindingParser.class;
    }

    @Override
    public String getLanguageId() {
	return BINDING_LANGUAGE_ID;
    }

	@Override
	public Integer[] getOmittedTokensForFormatting() {
		// TODO Auto-generated method stub
		return null;
	}

}
