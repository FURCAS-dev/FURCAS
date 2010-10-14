package de.hpi.sam.bp2009.solution.oclToAst;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.ocl.ecore.delegate.DelegateDomain;
import org.eclipse.ocl.ecore.delegate.DelegateDomain.Factory.Registry;
import org.osgi.framework.BundleContext;

import de.hpi.sam.bp2009.solution.oclToAst.delegate.OclAstDelegateDomain;
import de.hpi.sam.bp2009.solution.oclToAst.delegate.OclAstDelegateDomainFactory;

/**
 * When started, registers the {@link OclAstDelegateDomain} with the {@link DelegateDomain.Factory.Registry}
 * for the URI 
 * 
 * @author Axel Uhl
 *
 */
public class Activator extends Plugin {

    @Override
    public void start(BundleContext context) throws Exception {
        Registry delegateDomainFactoryRegistry = DelegateDomain.Factory.Registry.INSTANCE;
        delegateDomainFactoryRegistry.put(EAnnotationOCLParser.ANNOTATION_SOURCE,
                new OclAstDelegateDomainFactory());
    }

}
