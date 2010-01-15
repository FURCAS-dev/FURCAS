package com.sap.tc.moin.ocl.ia.instancescope;

import java.util.Set;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

/**
 * All implementations must offer a constructor that takes a {@link CoreConnection} and a {@link OclExpression} impl
 * subclass of the type handled by them as argument. Furthermore, the implementing classes underly a naming convention.
 * If they handle an {@link OclExpression} type by the MOF name of <tt>X</tt> then the tracer implementation class name
 * must be <tt>XTracer</tt>.
 * 
 * @author Axel Uhl D043530
 * 
 */
public interface Tracer {
    /**
     * Computes a set containing at least all context elements such that when the overall
     * expression of which the expression represented by this tracer is a part, is evaluated for such an
     * element, the sub-expression represented by this tracer evaluates to <tt>s</tt>. The result may
     * also contain more elements for which this does not hold. It hence represents a conservative
     * estimate.
     */
    Set<RefObjectImpl> traceback(RefObjectImpl s);
}
