package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites;

import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;

import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;


public class OCLWithHiddenOppositesFactory implements OCLFactory {

    public OCL createOCL(EcoreEnvironmentFactory environmentFactory) {
        return OCLWithHiddenOpposites.newInstance(environmentFactory, /* dummy */ true);
    }

    public OCL createOCL(OppositeEndFinder oppositeEndFinder) {
        return OCLWithHiddenOpposites.newInstance(oppositeEndFinder);
    }

}
