package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;

public class ImpactAnalyzerFactoryImpl implements ImpactAnalyzerFactory {

    @Override
    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression) {
        return new ImpactAnalyzerImpl(expression);
    }

    @Override
    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context) {
        return new ImpactAnalyzerImpl(expression, context);
    }

    @Override
    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder, OppositeEndFinder reverseOppositeEndFinder) {
        return new ImpactAnalyzerImpl(expression, context, oppositeEndFinder, reverseOppositeEndFinder);
    }

    @Override
    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, OppositeEndFinder oppositeEndFinder, OppositeEndFinder reverseOppositeEndFinder) {
        return new ImpactAnalyzerImpl(expression, oppositeEndFinder, reverseOppositeEndFinder);
    }

}
