package de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation;

import org.eclipse.emf.common.notify.Notification;

import com.sap.emf.oppositeendfinder.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;

public interface PartialEvaluatorFactory {
    PartialEvaluator createPartialEvaluator(Notification atPre, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory);
    PartialEvaluator createPartialEvaluator(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory);
}
