package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerFactoryImpl;

public interface ImpactAnalyzerFactory {
    static final ImpactAnalyzerFactory INSTANCE = new ImpactAnalyzerFactoryImpl();

    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression);
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context);
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, OppositeEndFinder oppositeEndFinder);
    ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, OppositeEndFinder oppositeEndFinder);
}
