package com.sap.ap.cts.monet.parser;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;
import com.sap.mi.textual.grammar.impl.ObservableInjectingParser;

public abstract class AbstractRunletParserFactory<P extends ObservableInjectingParser, L extends Lexer>
extends AbstractParserFactory<P, L> {

    public String[] getHiddenChannelTokenNames() {
	return new String[] { "WS", "NL", "COMMENT", "MULTI_LINE_COMMENT" };
    }

    @Override
    public EPackage getMetamodelPackage(ResourceSet connection) {
        return connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
    }

}
