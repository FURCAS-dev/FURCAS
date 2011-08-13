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
package com.sap.furcas.runtime.parser.impl;

import java.util.Set;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.SyntaxLookup;

import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;

/**
 * A data object capturing details about the scope of FURCAS parsers. </p>
 * 
 * The parser infrastructure makes use of scoping information to correctly
 * parameterize MQL (query2) and OCL queries. </p>
 * 
 * Accurate scoping information is required for performance reasons and to prevent
 * ambigous query results. The latter happens when the scope is to broad and more
 * elements than expected are found.</p>
 * 
 * 
 * @author Stephan Erb
 *
 */
public class ParserScope {
    
    private final ConcreteSyntax syntax;
    private final SyntaxLookup syntaxLookup;
    private final ResourceSet resourceSet;
    private final Set<URI> metamodels;
    private final IMetaModelLookup<EObject> metamodelLookup;;
    private final Set<URI> explicitQueryScope;

    
    public ParserScope(ResourceSet resourceSet, ParserFactory<? extends ObservableInjectingParser, ? extends Lexer> parserFactory) {
        
        this.metamodels = parserFactory.getMetamodelURIs();
        this.metamodelLookup = new QueryBasedEcoreMetaModelLookUp(resourceSet, metamodels);
        
        this.syntax = (ConcreteSyntax) resourceSet.getEObject(URI.createURI(parserFactory.getSyntaxUUID()), true);
        this.resourceSet = resourceSet;
        
        MetaModelElementResolutionHelper<EObject> resolutionHelper = new MetaModelElementResolutionHelper<EObject>(metamodelLookup);
        this.syntaxLookup = new SyntaxLookup(syntax, resolutionHelper);
        
        this.explicitQueryScope = parserFactory.getAdditionalQueryScope();
    }
    
    
    /**
     * The mapping definition.
     */
    public ConcreteSyntax getSyntax() {
        return syntax;
    }
    
    /**
     * A pre-configured {@link SyntaxLookup} operating on the mapping returned
     * by {@link #getSyntax()}
     */
    public SyntaxLookup getSyntaxLookup() {
        return syntaxLookup;
    }

    /**
     * The set of all loaded resources that are used by parsing and editing session.
     * The following URIs can be used to express a scope on top of this resourceSet. 
     */
    public ResourceSet getResourceSet() {
        return resourceSet;
    }

    /**
     * URIs of all metamodels that are decorated by the {@link #syntax}.
     * Each {@link Template} corresponds to a class of one of these metamodels  
     */
    public Set<URI> getMetamodels() {
        return metamodels;
    }
    
    /**
     * A pre-configured {@link IMetaModelLookup} working on the metamodels returned
     * by {@link #getMetamodels()}
     */
    public IMetaModelLookup<EObject> getMetamodelLookup() {
        return metamodelLookup;
    }

    /**
     * Additional URIs that shall be included in the OCL and Query2 lookup scope.
     * This explicit scope is required as {@link ProjectDependencyQueryContextProvider}
     * can only find resources which are stored in the workspace and visible through
     * project dependencies. Some resources might be shipped in plugins and
     * would not be visible. <p>
     * 
     * Such resources are loaded on-demand and endup in the {@link ResourceSet}<p>
     * 
     * This scope does not include any TextBlocks resources.
     */
    public Set<URI> getExplicitQueryScope() {
        return explicitQueryScope;
    }
        
}
