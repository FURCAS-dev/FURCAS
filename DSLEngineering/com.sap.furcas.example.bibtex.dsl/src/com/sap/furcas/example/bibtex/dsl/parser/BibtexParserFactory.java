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
package com.sap.furcas.example.bibtex.dsl.parser;

import generated.BibtexLexer;
import generated.BibtexParser;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;

import Bibtex.BibtexPackage;

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
    public Set<URI> getMetamodelURIs() {
        HashSet<URI> metamodels = new HashSet<URI>();
        metamodels.add(URI.createURI(BibtexPackage.eINSTANCE.getNsURI()));
        metamodels.add(URI.createURI(EcorePackage.eINSTANCE.getNsURI()));
        return metamodels;
    }

    @Override
    public URI getSyntaxResourceURI() {
        return URI.createPlatformPluginURI("/com.sap.furcas.example.bibtex.dsl/mapping/Bibtex.tcs", /*encode*/ false);
    }

    @Override
    public Set<URI> getAdditionalQueryScope() {
        return Collections.emptySet();
    }

}
