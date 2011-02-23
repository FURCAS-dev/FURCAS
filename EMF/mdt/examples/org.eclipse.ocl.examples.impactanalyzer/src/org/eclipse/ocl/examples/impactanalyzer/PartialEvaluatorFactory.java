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
package org.eclipse.ocl.examples.impactanalyzer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEcoreEnvironmentFactory;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorFactoryImpl;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;

/**
 * Used to create {@link PartialEvaluator} objects. A partial evaluator can
 * evaluate an OCL expression in the "pre"-state of a model before a given
 * change, described by an EMF {@link Notification} object, was performed. This
 * is similar to the OCL <code>@pre</code> evaluation, only that it applies to
 * the entire expression. This is similar to undoing the change described by the
 * notification, only that the model doesn't need to be changed for this.
 * <p>
 * 
 * A second use for a partial evaluator is that of a {@link CallExp} whose
 * {@link CallExp#getSource() source} expression's value is known up-front. This
 * value can be passed to the partial evaluator's
 * {@link PartialEvaluator#evaluate(Object, CallExp, Object)} method.<p>
 * 
 * A partial evaluator may also be used to attempt an expression's evaluation
 * if not all variable values required by the expression are known. For example,
 * if an operation body expression needs to be evaluated but for some reason not
 * all argument values have yet been determined, an evaluation attempt may still
 * succeed if the nature of the expressions leads to the unknown variables not
 * being accessed. However, if a variable with unknown value is accessed during
 * expression evaluation, a {@link ValueNotFoundException} is thrown.
 * 
 * A default factory instance can be obtained using the {@link #INSTANCE} field.
 * 
 * @author Axel Uhl
 */
public interface PartialEvaluatorFactory {
    PartialEvaluatorFactory INSTANCE = new PartialEvaluatorFactoryImpl();
    
	/**
	 * Taking a {@link Notification} object such that an evaluation will be
	 * based on the state *before* the notification. For example, if the
	 * notification indicates the removal of a reference from an element
	 * <tt>e1</tt> to an element <tt>e2</tt> across reference <tt>r</tt> then
	 * when during partial evaluation <tt>r</tt> is traversed starting from
	 * <tt>e1</tt> then <tt>e2</tt> will show in the results although in the
	 * current version of the model it would not.
	 * <p>
	 * 
	 * @param atPre
	 *            if <code>null</code>, the constructor behaves the same as
	 *            {@link #createPartialEvaluator(OppositeEndFinder, OCLFactory)}
	 */
    PartialEvaluator createPartialEvaluator(Notification atPre, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory);

    /**
     * Constructs the OCL instance using {@link OCLFactory#createOCL(OppositeEndFinder)}, passing the
     * <code>oppositeEndFinder</code> provided. A default {@link PartialEcoreEnvironmentFactory} is
     * used, configured as well with the <code>oppositeEndFinder</code> provided here.
     */
    PartialEvaluator createPartialEvaluator(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory);
}
