package de.hpi.sam.bp2009.solution.oclToAst.delegate;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OppositeEndFinder;
import org.eclipse.ocl.ecore.delegate.DelegateResourceAdapter;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;

import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.scopeProvider.ProjectDependencyQueryContextProvider;

public class OclAstDelegateDomain extends OCLDelegateDomain {
    private final OCL myOCL;

    public OclAstDelegateDomain(EPackage ePackage) {
        super(EAnnotationOCLParser.ANNOTATION_SOURCE, ePackage);
        ocl.dispose();
        Resource res = ePackage.eResource();
        ResourceSet resourceSet = res.getResourceSet();
        EcoreEnvironmentFactory envFactory;
        OppositeEndFinder oppositeEndFinder = new Query2OppositeEndFinder(new ProjectDependencyQueryContextProvider());
        if (res != null && resourceSet != null) {
            // it's a dynamic package. Use the local package registry
            EPackage.Registry packageRegistry = resourceSet.getPackageRegistry();
            envFactory = new EcoreEnvironmentFactory(packageRegistry, oppositeEndFinder);
            DelegateResourceAdapter.getAdapter(res);
        } else {
            // the shared instance uses the static package registry
            envFactory = new EcoreEnvironmentFactory(oppositeEndFinder);
        }
        myOCL = OCL.newInstance(envFactory);
    }
    
    @Override
    public OCL getOCL() {
        return myOCL;
    }

}
