package com.sap.furcas.runtime.syntaxprovider;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.parser.ParserFactory;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;

public class SyntaxProviderImpl implements SyntaxProvider {
    private ConcreteSyntax syntax;
    private final OppositeEndFinder oppositeEndFinder;
    private final ParserFactory<?, ?> parserFactory;
    
    public SyntaxProviderImpl(ParserFactory<?, ?> parserFactory) {
        super();
        this.parserFactory = parserFactory;
        this.oppositeEndFinder = DefaultOppositeEndFinder.getInstance();
    }

    @Override
    public ConcreteSyntax getSyntax() {
        if (syntax == null) {
            ResourceSet resourceSet = new ResourceSetImpl();
            syntax = (ConcreteSyntax) resourceSet.getEObject(URI.createURI(parserFactory.getSyntaxUUID()), true);
        }
        return syntax;
    }

    @Override
    public void registerForIncrementalEvaluation(SyntaxRegistry registry) {
        registry.registerSyntaxForIncrementalEvaluation(getSyntax(), oppositeEndFinder, /*progressmonitor*/null, parserFactory);
    }

}
