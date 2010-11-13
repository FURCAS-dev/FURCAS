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
package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.instancescope;

import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import de.hpi.sam.bp2009.solution.eventManager.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEvaluator;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.deltapropagation.PartialEvaluatorWithHiddenOpposites;
import de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.traceback.TracebackStepCacheWithHiddenOpposites;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.AllInstancesNavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.InstanceScopeAnalysis;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.Tracer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.util.AnnotatedEObject;

public class InstanceScopeAnalysisWithHiddenOpposites extends InstanceScopeAnalysis {
    /**
     * @param expression
     *            the OCL expression for which to perform instance scope impact analysis
     * @param oppositeEndFinder
     *            used during partial evaluation and for metamodel queries, e.g., finding opposite role names, or finding all
     *            subclasses of a class; as well as for obtaining all instances of a type while performing an
     *            {@link AllInstancesNavigationStep}. It is handed to the {@link PathCache} object from where
     *            {@link Tracer}s can retrieve it using {@link PathCache#getOppositeEndFinder()}.
     */
    public InstanceScopeAnalysisWithHiddenOpposites(OCLExpression expression, EClass exprContext, FilterSynthesisImpl filterSynthesizer, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        super(expression, exprContext, filterSynthesizer, oppositeEndFinder, new PartialEvaluatorWithHiddenOpposites(oclFactory),
                configuration, oclFactory,
                /* pathCache */configuration.isTracebackStepISAActive() ? null : new PathCache(oppositeEndFinder, null),
                /* tracebackStepCache */ configuration.isTracebackStepISAActive() ? new TracebackStepCacheWithHiddenOpposites(oppositeEndFinder, null) : null);
    }

    /**
     * Factory method that creates an instance of some {@link Tracer}-implementing class specific to the type of the OCL
     * <tt>expression</tt>.
     * @param caller the calling tracer from which the list of tuple part names to look for are copied
     * unchanged to the new tracer created by this operation. May be <tt>null</tt> in which case the
     * new tracer does not look for any tuple literal parts initially.
     */
    protected Tracer createTracer(OCLExpression expression, Stack<String> tuplePartNames, OCLFactory oclFactory) {
        // Using the class loader is another option, but that would create implicit naming conventions.
        // Thats why we do the mapping "manually".
        switch (expression.eClass().getClassifierID()) {
        case ExpressionsPackage.OPPOSITE_PROPERTY_CALL_EXP:
            return new OppositePropertyCallExpTracer((OppositePropertyCallExp) expression, tuplePartNames, oclFactory);
        default:
            return super.createTracer(expression, tuplePartNames, oclFactory);
        }
    }

    /**
     * Handles the {@link OppositePropertyCallExp} case. If other case, delegates to <code>super</code>.
     */
    protected Collection<AnnotatedEObject> getSourceElement(Notification changeEvent, NavigationCallExp attributeOrAssociationEndCall) {
        assert NotificationHelper.isAttributeValueChangeEvent(changeEvent)
                || NotificationHelper.isLinkLifeCycleEvent(changeEvent);
        Collection<AnnotatedEObject> result;
        if (attributeOrAssociationEndCall instanceof OppositePropertyCallExp) {
            EClassifier sourceType = attributeOrAssociationEndCall.getSource().getType();
            result = new HashSet<AnnotatedEObject>();
            // the old and new object(s) are the source(s) of the opposite property call expression
            for (Object o : getSourceElementsForOppositePropertyCallExp(changeEvent)) {
                if (sourceType.isInstance(o)) {
                    result.add(new AnnotatedEObject((EObject) changeEvent.getNotifier(), "<start>"));
                }
            }
        } else {
            result = super.getSourceElement(changeEvent, attributeOrAssociationEndCall);
        }
        return result;
    }

    @Override
    public PartialEvaluator createPartialEvaluator(Notification atPre, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new PartialEvaluatorWithHiddenOpposites(atPre, oppositeEndFinder, oclFactory);
    }

    @Override
    public PartialEvaluator createPartialEvaluator(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new PartialEvaluatorWithHiddenOpposites(oppositeEndFinder, oclFactory);
    }
}
