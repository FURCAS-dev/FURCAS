/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope;

import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import de.hpi.sam.bp2009.solution.impactAnalyzer.impl.OperationBodyToCallMapper;



/**
 * All implementations must offer a constructor that takes a {@link CoreConnection} and a {@link OclExpression} impl
 * subclass of the type handled by them as argument. Furthermore, the implementing classes underly a naming convention.
 * If they handle an {@link OclExpression} type by the MOF name of <tt>X</tt> then the tracer implementation class name
 * must be <tt>XTracer</tt>.
 * 
 */
public interface Tracer {
    /**
     * Computes a navigation step that when executed, computes a set of elements containing at least all context elements such
     * that when the overall expression of which the expression represented by this tracer is a part, is evaluated for such an
     * element, the sub-expression represented by this tracer evaluates to the element passed to the navigation step's
     * {@link NavigationStep#navigate(Set, TracebackCache, Notification)} operation in the set parameter. The result may also contain elements for which
     * this does not hold. It hence represents a conservative estimate.
     * 
     * @param context
     *            the context type that defines the type of any <tt>self</tt> occurrence outside of operation bodies
     * @param pathCache
     *            a global cache that remembers the navigation steps already computed for some OCL expressions
     * @param filterSynthesizer
     *            the filter synthesizer that analyzed an overall expression that contains the expression to be handled by this
     *            tracer
     * @param classScopeAnalyzer
     *            retains the results of traversing the outermost expression's tree, a sub-expression of which this tracer will
     *            analyze in this method. The class scope analyzer in particular remembers the operation calls it found and
     *            thereby makes it possible to limit the analysis of operation bodies by the scope of those calls actually
     *            invoking the operation in the context of the outermost expression.
     */
    NavigationStep traceback(EClass context, PathCache pathCache, OperationBodyToCallMapper filterSynthesizer);
}
