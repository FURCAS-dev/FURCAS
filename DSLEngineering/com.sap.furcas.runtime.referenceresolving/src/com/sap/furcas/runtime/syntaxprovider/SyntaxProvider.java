package com.sap.furcas.runtime.syntaxprovider;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;

import com.sap.emf.ocl.trigger.TriggerManager;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.referenceresolving.SyntaxRegistry;

/**
 * Can provide a {@link ConcreteSyntax concrete syntax} and a {@link TriggerManager} for a syntax-providing bundle. The
 * {@link TriggerManager} can be used to propagate changes in {@link ResourceSet}s according to the OCL rules defined in
 * the {@link ConcreteSyntax syntax}. Particularly all tools manipulating models according to this syntax should obtain
 * the trigger manager for this purpose from this provider and {@link TriggerManager#addToObservedResourceSets register}
 * it for the editors {@link ResourceSet}.<p>
 * 
 * In turn, implementations of this interface have to guarantee that the syntax
 * is registered with the <code>SyntaxRegistry</code> for incremental model updates according to the syntax / mapping
 * definition and that the corresponding <code>TriggerManager</code> has its event manager registered on the
 * {@link ResourceSet} returned by {@link #getResourceSet()}.
 * 
 * @author Axel Uhl (d043530)
 * 
 */
public interface SyntaxProvider {
    /**
     * Returns a trigger manager for the syntax provided by this syntax provider. The trigger
     * manager can be used to automatically propagate model updates on a {@link ResourceSet}
     * according to the OCL rules specified by the syntax. The trigger manager does not have
     * any effects unless {@link TriggerManager#addToObservedResourceSets(ResourceSet) registered}
     * for a resource set.
     */
    TriggerManager getTriggerManager(SyntaxRegistry syntaxRegistry) throws ParserException, IOException;
    
    /**
     * Loads this provider's syntax if it hasn't been loaded already and returns it. If loading
     * is necessary, it is loaded into <code>loadSyntaxIn</code> except if <code>null</code>
     * is passed for <code>loadSyntaxIn</code> in which case a new {@link ResourceSetImpl} will
     * be used instead. Since an already loaded syntax will simply be returned, it cannot be
     * guaranteed that the syntax returned is contained in the <code>loadSyntaxIn</code>
     * resource set.
     */
    ConcreteSyntax getSyntax(ResourceSet loadSyntaxIn) throws IOException, ParserException;
}
