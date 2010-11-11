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
package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.deltapropagation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;


import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;

/**
 * Can evaluate an OCL expression when the model is in some state which just got modified by a change indicated by an event
 * {@link Notification} such that the evaluation result is based on the state that the model was in <em>before</em> the
 * modification occurred. This is similar to the <code>@pre</code> operator in OCL.
 * <p>
 * 
 * Additionally, if the expression to evaluate is a {@link CallExp} expression, the evaluation result of its
 * {@link CallExp#getSource() source} expression can be provided, cutting short the evaluation of this source
 * expression. For this, it uses an adapted OCL evaluation environment.
 * 
 * TODO need to be able to accept a set of variable definitions for the starting scope that are added to the initial evaluation environment on the OCL instance being used
 * 
 * @author Axel Uhl
 * 
 */
public class PartialEvaluatorWithHiddenOpposites extends PartialEvaluator {
    /**
     * Uses a {@link DefaultOppositeEndFinder} to navigate hidden opposite properties and evaluates
     * the model based on its current state.
     */
    public PartialEvaluatorWithHiddenOpposites(OCLFactory oclFactory) {
        super(new PartialEcoreEnvironmentWithHiddenOppositesFactory(), oclFactory);
    }
    
    protected PartialEvaluatorWithHiddenOpposites(PartialEcoreEnvironmentWithHiddenOppositesFactory factory, OCLFactory oclFactory) {
        super(factory, oclFactory);
    }

    public PartialEvaluatorWithHiddenOpposites(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        super(new PartialEcoreEnvironmentWithHiddenOppositesFactory(oppositeEndFinder), oclFactory);
    }

    /**
     * Taking a {@link Notification} object such that an evaluation will be based on the state *before* the notification.
     * For example, if the notification indicates the removal of a reference from an element <tt>e1</tt> to an element <tt>e2</tt>
     * across reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is traversed starting from <tt>e1</tt>
     * then <tt>e2</tt> will show in the results although in the current version of the model it would not.<p>
     * 
     * A {@link DefaultOppositeEndFinder} is used for hidden opposite navigation.
     */
    public PartialEvaluatorWithHiddenOpposites(Notification atPre, OCLFactory oclFactory) {
        super(new PartialEcoreEnvironmentWithHiddenOppositesFactory(atPre), oclFactory);
    }
    
    /**
     * Taking a {@link Notification} object such that an evaluation will be based on the state *before* the notification.
     * For example, if the notification indicates the removal of a reference from an element <tt>e1</tt> to an element <tt>e2</tt>
     * across reference <tt>r</tt> then when during partial evaluation <tt>r</tt> is traversed starting from <tt>e1</tt>
     * then <tt>e2</tt> will show in the results although in the current version of the model it would not.<p>
     */
    public PartialEvaluatorWithHiddenOpposites(Notification atPre, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        super(new PartialEcoreEnvironmentWithHiddenOppositesFactory(atPre, oppositeEndFinder), oclFactory);
    }
}
