package com.sap.furcas.runtime.textblocks.testutils;

import com.sap.furcas.metamodel.FURCAS.textblocks.Bostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.Eostoken;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

public interface TextBlocksModelElementFactory {

    public TextBlock createTextBlock();

    public LexedToken createLexedToken();

    public Eostoken createEostoken();

    public Bostoken createBostoken();

    public LexedToken createToken(String content);

}
