package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

public interface OCLFactory {
    OCL createOCL(EcoreEnvironmentFactory environmentFactory);
    OCL createOCL(OppositeEndFinder oppositeEndFinder);
}
