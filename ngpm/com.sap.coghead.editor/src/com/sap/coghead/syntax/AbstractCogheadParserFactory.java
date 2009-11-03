package com.sap.coghead.syntax;

import org.antlr.runtime.Lexer;

import coghead.CogheadPackage;

import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

public abstract class AbstractCogheadParserFactory<P extends ObservableInjectingParser, L extends Lexer>
extends AbstractParserFactory<P, L> {
    @Override
    protected String[] getHiddenChannelTokenNames() {
	return new String[] { "WS", "NL", "COMMENT", "MULTI_LINE_COMMENT" };
    }

    @Override
    public RefPackage getMetamodelPackage(Connection connection) {
        return connection.getPackage(CogheadPackage.PACKAGE_DESCRIPTOR);
    }

}
