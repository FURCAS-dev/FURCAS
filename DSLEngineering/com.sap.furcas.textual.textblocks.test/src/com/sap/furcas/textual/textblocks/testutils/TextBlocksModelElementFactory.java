package com.sap.furcas.textual.textblocks.testutils;

import com.sap.furcas.metamodel.textblocks.Bostoken;
import com.sap.furcas.metamodel.textblocks.Eostoken;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;

public interface TextBlocksModelElementFactory {

    public TextBlock createTextBlock();

    public LexedToken createLexedToken();

    public Eostoken createEostoken();

    public Bostoken createBostoken();

}
