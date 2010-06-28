package org.eclipse.ocl;

import org.eclipse.ocl.expressions.OppositePropertyCallExp;
import org.eclipse.ocl.utilities.VisitorWithHiddenOpposite;


/**
 * Adds the capability to visit {@link OppositePropertyCallExp} expressions
 * 
 * @author Axel Uhl
 * @since 3.0
 */
public interface EvaluationVisitorWithHiddenOpposite<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends
		EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>,
		VisitorWithHiddenOpposite<Object, C, O, P, EL, PM, S, COA, SSA, CT> {

}
