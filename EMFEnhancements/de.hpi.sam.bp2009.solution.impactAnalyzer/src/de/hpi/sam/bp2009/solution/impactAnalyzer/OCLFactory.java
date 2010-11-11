package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;


public interface OCLFactory {
    OCL createOCL(EcoreEnvironmentFactory environmentFactory);
    OCL createOCL(OppositeEndFinder oppositeEndFinder);
}
