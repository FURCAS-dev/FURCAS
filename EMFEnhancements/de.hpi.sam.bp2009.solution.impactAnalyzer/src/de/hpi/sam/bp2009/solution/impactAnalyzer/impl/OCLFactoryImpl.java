package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;

import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;


public class OCLFactoryImpl implements OCLFactory {

    public OCL createOCL(EcoreEnvironmentFactory environmentFactory) {
        return OCL.newInstance(environmentFactory);
    }

    public OCL createOCL(OppositeEndFinder oppositeEndFinder) {
        return OCL.newInstance();
    }

}
