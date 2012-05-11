package com.sap.furcas.runtime.syntaxprovider;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;

/**
 * Configures the given {@link SyntaxRegistry } so that it can be used to propagate changes in {@link ResourceSet}s according
 * to the OCL rules defined in the {@link ConcreteSyntax syntax}.
 */
public interface SyntaxProvider {
    
   ConcreteSyntax getSyntax();

    void registerForIncrementalEvaluation(SyntaxRegistry registry);
    
}
