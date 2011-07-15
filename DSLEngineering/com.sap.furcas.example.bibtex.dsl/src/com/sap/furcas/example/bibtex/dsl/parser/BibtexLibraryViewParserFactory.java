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

import generated.BibtexLibraryViewLexer;
import generated.BibtexLibraryViewParser;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;

import Bibtex.BibtexPackage;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;

public class BibtexLibraryViewParserFactory extends AbstractParserFactory<BibtexLibraryViewParser, BibtexLibraryViewLexer> {

    public static final String LANGUAGE_ID = "BibtexLibraryView";

    @Override
    public Class<BibtexLibraryViewLexer> getLexerClass() {
        return BibtexLibraryViewLexer.class;
    }

    @Override
    public Class<BibtexLibraryViewParser> getParserClass() {
        return BibtexLibraryViewParser.class;
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
        return URI.createPlatformPluginURI("/com.sap.furcas.example.bibtex.dsl/mapping/BibtexLibraryView.furcas", /*encode*/ false);
    }

    @Override
    public Set<URI> getAdditionalQueryScope() {
        return Collections.emptySet();
    }

}
