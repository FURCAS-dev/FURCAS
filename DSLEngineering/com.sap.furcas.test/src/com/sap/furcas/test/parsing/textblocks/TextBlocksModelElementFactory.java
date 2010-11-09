package com.sap.furcas.test.parsing.textblocks;

import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

public interface TextBlocksModelElementFactory {

    public TextBlock createTextBlock();

    public LexedToken createLexedToken();

    public Eostoken createEostoken();

    public Bostoken createBostoken();

}
