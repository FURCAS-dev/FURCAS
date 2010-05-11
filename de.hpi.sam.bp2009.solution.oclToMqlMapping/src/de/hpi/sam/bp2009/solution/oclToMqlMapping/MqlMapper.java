package de.hpi.sam.bp2009.solution.oclToMqlMapping;

import org.eclipse.ocl.expressions.OCLExpression;

public interface MqlMapper <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {
    
    Object oclToMqlMapping(Object context, OCLExpression<C> expression);
    
    boolean checkForExpression (OCLExpression<C> expression);
}
