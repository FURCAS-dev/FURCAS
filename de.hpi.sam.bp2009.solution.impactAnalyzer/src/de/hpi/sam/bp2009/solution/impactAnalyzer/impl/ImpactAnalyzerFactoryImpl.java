package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;

public class ImpactAnalyzerFactoryImpl implements ImpactAnalyzerFactory {

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression) {
        return new ImpactAnalyzerImpl(expression, OptimizationActivation.getOption());
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context) {
        return new ImpactAnalyzerImpl(expression, context, OptimizationActivation.getOption());
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder) {
        return new ImpactAnalyzerImpl(expression, context, oppositeEndFinder, OptimizationActivation.getOption());
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, OppositeEndFinder oppositeEndFinder) {
        return new ImpactAnalyzerImpl(expression, oppositeEndFinder, OptimizationActivation.getOption());
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, ActivationOption configuration) {
        return new ImpactAnalyzerImpl(expression, configuration);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, ActivationOption configuration) {
        return new ImpactAnalyzerImpl(expression, context, configuration);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder, ActivationOption configuration) {
        return new ImpactAnalyzerImpl(expression, context, oppositeEndFinder, configuration);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, OppositeEndFinder oppositeEndFinder, ActivationOption configuration) {
        return new ImpactAnalyzerImpl(expression, oppositeEndFinder, configuration);
    }

}
