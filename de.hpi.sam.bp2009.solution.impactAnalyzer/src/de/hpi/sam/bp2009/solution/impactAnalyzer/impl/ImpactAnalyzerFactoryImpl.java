package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;

public class ImpactAnalyzerFactoryImpl implements ImpactAnalyzerFactory {

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression) {
        return new ImpactAnalyzerImpl(expression);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context) {
        return new ImpactAnalyzerImpl(expression, context);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder) {
        return new ImpactAnalyzerImpl(expression, context, oppositeEndFinder);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, OppositeEndFinder oppositeEndFinder) {
        return new ImpactAnalyzerImpl(expression, oppositeEndFinder);
    }

}
