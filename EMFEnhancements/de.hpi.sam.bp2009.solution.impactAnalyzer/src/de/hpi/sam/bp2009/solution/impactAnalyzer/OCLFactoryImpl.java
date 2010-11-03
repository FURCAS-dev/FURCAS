package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;


public class OCLFactoryImpl implements OCLFactory {

    public OCL createOCL(EcoreEnvironmentFactory environmentFactory) {
        return OCL.newInstance(environmentFactory);
    }

    public OCL createOCL(OppositeEndFinder oppositeEndFinder) {
        return OCL.newInstance();
    }

}
