package com.sap.ap.cts.monet.parser;

import generated.PackageLexer;
import generated.PackageParser;


public class PackageParserFactory extends AbstractRunletParserFactory<PackageParser, PackageLexer> {
    private static final String PACKAGE_LANGUAGE_ID = "Package";

    @Override
    public Class<PackageLexer> getLexerClass() {
	return PackageLexer.class;
    }

    @Override
    public Class<PackageParser> getParserClass() {
	return PackageParser.class;
    }

    @Override
    public String getLanguageId() {
	return PACKAGE_LANGUAGE_ID;
    }

	@Override
	public Integer[] getOmittedTokensForFormatting() {
		return new Integer[]{PackageParser.WS, PackageParser.NL};
	}
}
