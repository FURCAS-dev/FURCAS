/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package bibtex.dsl.parser;

import generated.BibtexLexer;
import generated.BibtexParser;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;

public class BibtexParserFactory extends AbstractParserFactory<BibtexParser, BibtexLexer> {

    public static final String LANGUAGE_ID = "Bibtex";

    @Override
    public Class<BibtexLexer> getLexerClass() {
        return BibtexLexer.class;
    }

    @Override
    public Class<BibtexParser> getParserClass() {
        return BibtexParser.class;
    }

    @Override
    public String getLanguageId() {
        return LANGUAGE_ID;
    }

    @Override
    public EPackage getMetamodelPackage(ResourceSet connection) {
        return EPackage.Registry.INSTANCE.getEPackage("http://www.sap.com/furcas/examples/bibtex");
    }

    @Override
    public String[] getHiddenChannelTokenNames() {
        return new String[] { "WS", "NL", "COMMENT" };
    }

    @Override
    public URI getSyntaxUri() {
        return URI.createPlatformPluginURI("/bibtex.dsl/mappings/Bibtex.tcs", true);
    }
}
