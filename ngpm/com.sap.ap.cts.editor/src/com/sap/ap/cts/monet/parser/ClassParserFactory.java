package com.sap.ap.cts.monet.parser;

import generated.ClassLexer;
import generated.ClassParser;


public class ClassParserFactory extends AbstractRunletParserFactory<ClassParser, ClassLexer> {
    private static final String CLASS_LANGUAGE_ID = "Class";

    @Override
    public Class<ClassLexer> getLexerClass() {
	return ClassLexer.class;
    }

    @Override
    public Class<ClassParser> getParserClass() {
	return ClassParser.class;
    }

    @Override
    public String getLanguageId() {
	return CLASS_LANGUAGE_ID;
    }

	@Override
	public Integer[] getOmittedTokensForFormatting() {
		return new Integer[]{ClassParser.WS, ClassParser.NL};
	}
}
