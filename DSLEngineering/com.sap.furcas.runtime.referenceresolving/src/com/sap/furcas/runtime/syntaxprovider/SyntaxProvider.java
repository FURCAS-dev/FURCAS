package com.sap.furcas.runtime.syntaxprovider;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;

/**
 * Can provide a {@link ConcreteSyntax} concrete syntax and a {@link ResourceSet} for a syntax-providing bundle. All
 * tools manipulating models according to this syntax should obtain the resource set for this purpose from this
 * provider. In turn, implementations of this interface have to guarantee that the syntax is registered with the
 * <code>SyntaxRegistry</code> for incremental model updates according to the syntax / mapping definition and
 * that the corresponding <code>TriggerManager</code> has its event manager registered on the {@link ResourceSet}
 * returned by {@link #getResourceSet()}.
 * 
 * @author Axel Uhl (d043530)
 * 
 */
public interface SyntaxProvider {
    ResourceSet getResourceSet() throws ParserException, IOException;
    ConcreteSyntax getSyntax() throws IOException, ParserException;
}
