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
package com.sap.furcas.runtime.parser.testbase;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;

/**
 * Parsing helper for parsing text fragments / files that uses a {@link EMFModelAdapter}
 */
public class EMFParsingHelper extends AbstractParsingHelper<ModelParsingResult> {
    
    private final Set<URI> referenceScope;
    private final ResourceSet resourceSet;
    private final String packageURI;
    
    public EMFParsingHelper(ParserFacade parserFacade, GeneratedParserTestConfiguration testConfig, String packageURI) {
        super(parserFacade);
        this.packageURI = packageURI;
        this.resourceSet = testConfig.getSourceConfiguration().getResourceSet();
        this.referenceScope = testConfig.getSourceConfiguration().getReferenceScope();
    }

    @Override
    protected IModelAdapter createModelAdapter() {
        IMetaModelLookup<EObject> metamodelLookup = new QueryBasedEcoreMetaModelLookUp(resourceSet, referenceScope);
        return new DefaultTextAwareModelAdapter(new EMFModelAdapter(resourceSet,
                EcoreHelper.createTransientParsingResource(resourceSet, packageURI), metamodelLookup, new HashSet<URI>()));
    }

    @Override
    protected ModelParsingResult createParsingResult(IModelAdapter modelAdapter, ModelParsingResult result) {
        return result;
    }
    
}
