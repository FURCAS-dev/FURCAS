package com.sap.emf.ocl.prepared.parameters;

import com.sap.emf.ocl.prepared.PreparedOCLExpression;

/**
 * A parameter of a {@link PreparedOCLExpression}. It encapsulates a {@link LiteralExp} subexpression of the prepared expression.
 * The literal's symbol can be set to a specific object before the evaluation which will modify the {@link LiteralExp} inside the
 * prepared expression.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public interface Parameter {
    void set(Object object);
}
