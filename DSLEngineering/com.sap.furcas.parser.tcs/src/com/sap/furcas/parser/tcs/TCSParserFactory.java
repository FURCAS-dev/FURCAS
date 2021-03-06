/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.parser.tcs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.parser.tcs.stable.TCSLexer;
import com.sap.furcas.parser.tcs.stable.TCSParser;

public class TCSParserFactory extends AbstractParserFactory<TCSParser, TCSLexer> {

    private static final String LANGUAGE_ID = "TCS";

    @Override
    public Class<TCSLexer> getLexerClass() {
        return TCSLexer.class;
    }

    @Override
    public Class<TCSParser> getParserClass() {
        return TCSParser.class;
    }

    @Override
    public String getLanguageId() {
        return LANGUAGE_ID;
    }

    @Override
    public Set<URI> getMetamodelURIs() {
        HashSet<URI> metamodels = new HashSet<URI>();
        metamodels.add(URI.createURI(FURCASPackage.eINSTANCE.getNsURI()));
        metamodels.add(URI.createURI(EcorePackage.eINSTANCE.getNsURI()));
        return metamodels;
    }

    @Override
    public URI getSyntaxResourceURI() {
        return URI.createPlatformPluginURI("/com.sap.furcas.parser.tcs/mapping/TCS.furcas", /*encode*/ false);
    }

    @Override
    public Set<URI> getAdditionalQueryScope() {
        return Collections.emptySet();
    }

}
