package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.delegate.DelegateDomain;
import org.eclipse.ocl.ecore.delegate.DelegateDomain.Factory;

public class OclAstDelegateDomainFactory implements Factory {
    public OclAstDelegateDomainFactory() {}

    @Override
    public DelegateDomain createDelegateDomain(String delegateURI, EPackage ePackage) {
        return new OclAstDelegateDomain(ePackage);
    }

}
