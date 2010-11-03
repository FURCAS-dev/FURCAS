package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;

public class ImpactAnalyzerFactoryImpl implements ImpactAnalyzerFactory {

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, notifyOnNewContextElements, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, context, notifyOnNewContextElements, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, context, notifyOnNewContextElements, oppositeEndFinder, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, notifyOnNewContextElements, oppositeEndFinder, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, notifyOnNewContextElements, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, context, notifyOnNewContextElements, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, context, notifyOnNewContextElements, oppositeEndFinder, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, notifyOnNewContextElements, oppositeEndFinder, configuration, oclFactory);
    }

}
