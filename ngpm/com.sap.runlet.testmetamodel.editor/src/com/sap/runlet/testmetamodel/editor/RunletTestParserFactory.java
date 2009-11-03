package com.sap.runlet.testmetamodel.editor;

import generated.RunletTestLexer;
import generated.RunletTestParser;

public class RunletTestParserFactory extends AbstractRunletParserFactory<RunletTestParser, RunletTestLexer> {

    private static final String RUNLET_TEST_LANGUAGE_ID = "RunletTest";

    @Override
    public Class<RunletTestLexer> getLexerClass() {
	return RunletTestLexer.class;
    }

    @Override
    public Class<RunletTestParser> getParserClass() {
	return RunletTestParser.class;
    }

    @Override
    public String getLanguageId() {
	return RUNLET_TEST_LANGUAGE_ID;
    }

}
