package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.VariableExp;

import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;

/**
 * @author Tobias Hoppe
 *
 */
public class ModifiedFilterSynthesisImpl extends FilterSynthesisImpl {

    /**
     * Modified version of the {@link FilterSynthesisImpl} to benchmark time consumption
     * @param exp
     * @param notifyNewContextElements
     */
    public ModifiedFilterSynthesisImpl(OCLExpression exp, boolean notifyNewContextElements) {
        super(exp, notifyNewContextElements);
    }
    
    @Override
    public EPackage handlePropertyCallExp(PropertyCallExp<EClassifier, EStructuralFeature> propCallExp, EPackage sourceResult, List<EPackage> qualifierResults) {
        long before = System.nanoTime();
        super.handlePropertyCallExp(propCallExp, sourceResult, qualifierResults);
        long after = System.nanoTime();
        System.out.println("Time to handle PropertyCallExpression: " + (after - before) + "ns");
        return result;
    }
    
    @Override
    public EPackage handleOperationCallExp(org.eclipse.ocl.expressions.OperationCallExp<EClassifier, EOperation> opCallExp, EPackage sourceResult, List<EPackage> qualifierResults) {
        long before = System.nanoTime();
        super.handleOperationCallExp(opCallExp, sourceResult, qualifierResults);
        long after = System.nanoTime();
        System.out.println("Time to handle OperationCallExpression: " + (after - before) + "ns");
        return result;
    }

    @Override
    public EPackage visitVariableExp(VariableExp<EClassifier, EParameter> var) {
        long before = System.nanoTime();
        super.visitVariableExp(var);
        long after = System.nanoTime();
        System.out.println("Time to handle VariableExpression: " + (after - before) + "ns");
        return result;
    }

}
