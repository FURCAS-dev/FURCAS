package com.sap.mi.textual.parsing.textblocks;

import textblocks.Bostoken;
import textblocks.Eostoken;
import textblocks.LexedToken;
import textblocks.TextBlock;

public interface TestTextBlocksModelElementFactory {
	
	public TextBlock createTextBlock();
	public LexedToken createLexedToken();
	public Eostoken createEostoken();
	public Bostoken createBostoken();
	
}
