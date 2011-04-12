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

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;

/**
 * Use to react to model changes within a {@link ResourceSet} affecting the OCL-specified
 * constraints / invariants provided by one or more {@link EPackage}s. Clients will
 * subclass this abstract class and provide a meaningful implementation of
 * {@link #getAdapter(String, OCLExpression, ImpactAnalyzer)}.
 * 
 * @author Axel Uhl (d043530)
 *
 */
public abstract class Revalidator {
	private final EventManager eventManager;
    @SuppressWarnings("unused")
    // needed to hold on to event adapters to avoid their being GC'ed
    private final Collection<Adapter> adapters;
    private final OCLFactory oclFactory;
    private final OppositeEndFinder oppositeEndFinder;

    /**
     * Uses a {@link DefaultOppositeEndFinder}
     */
    public Revalidator(ResourceSet resourceSet, OCLFactory oclFactory, EPackage... pkgs) {
        this(resourceSet, oclFactory, DefaultOppositeEndFinder.getInstance(), pkgs);
    }
    
    /**
     * Uses the default {@link OCLFactory#INSTANCE} to create {@link OCL} objects, as well as a
     * {@link DefaultOppositeEndFinder}.
     */
    public Revalidator(ResourceSet resourceSet, EPackage... pkgs) {
        this(resourceSet, OCLFactory.getInstance(), pkgs);
    }
    
    /**
     * Uses the default {@link OCLFactory#INSTANCE} with the provided opposite end finder to create
     * {@link OCL} instances
     */
    public Revalidator(ResourceSet resourceSet, OppositeEndFinder oppositeEndFinder,
            EPackage... pkgs) {
        this(resourceSet, OCLFactory.getInstance(), oppositeEndFinder, pkgs);
    }
    
    /**
     * @param oclFactory used to create {@link OCL} instances
     * @param oppositeEndFinder used to instantiate an {@link OCL} object using
     * {@link OCLFactory#createOCL(OppositeEndFinder)}, and used for the {@link ImpactAnalyzer} when
     * retrieving and navigating hidden opposite references as well as for evaluating
     * <code>allInstances()</code> expressions
     * @param pkgs the metamodel packages whose invariants to observe
     */
    public Revalidator(ResourceSet resourceSet, OCLFactory oclFactory, OppositeEndFinder oppositeEndFinder,
            EPackage... pkgs) {
        eventManager = EventManagerFactory.eINSTANCE.createEventManagerFor(resourceSet);
        this.oclFactory = oclFactory;
        this.oppositeEndFinder = oppositeEndFinder;
        adapters = registerInvariants(pkgs);
    }

    private Collection<Adapter> registerInvariants(EPackage... pkgs) {
        Collection<Adapter> result = new LinkedList<Adapter>();
        for (EPackage pkg : pkgs) {
            for (final EClassifier cls : pkg.getEClassifiers()) {
                EAnnotation ann = cls.getEAnnotation(EcorePackage.eNS_URI);
                if (ann != null) {
                    String spaceSeparatedConstraintNames = ann.getDetails().get("constraints");
                    if (spaceSeparatedConstraintNames != null) {
                        String[] constraintNames = spaceSeparatedConstraintNames.split(" ");
                        for (final String constraintName : constraintNames) {
                            // TODO this is slightly unclean; what if a non-standard validation domain has been used?
                            // But there is no common base interface above ValidationBehavior that lets us extract the
                            // invariant
                            final OCLExpression invariant = ValidationBehavior.INSTANCE.getInvariant(cls,
                                    constraintName, oclFactory.createOCL(oppositeEndFinder));
                            final ImpactAnalyzer impactAnalyzer = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(
                                    invariant,
                                    /* notifyOnNewContextElements */true, oppositeEndFinder, oclFactory);
                            Adapter adapter = getAdapter(constraintName,
									invariant, impactAnalyzer);
                            result.add(adapter);
                            eventManager.subscribe(impactAnalyzer.createFilterForExpression(), adapter);
                        }
                    }
                }
            }
        }
        return result;
    }

    protected OCLFactory getOclFactory() {
		return oclFactory;
	}

	protected OppositeEndFinder getOppositeEndFinder() {
		return oppositeEndFinder;
	}

	/**
	 * Returns an adapter that will be
	 * {@link Adapter#notifyChanged(Notification) notified} when the constraint
	 * whose name is given by the <code>constraintName</code> parameter may have
	 * changed its value due to the change {@link Notification} delivered to the
	 * adapter. Using the <code>impactAnalyzer</code>'s
	 * {@link ImpactAnalyzer#getContextObjects(Notification)} operation the
	 * adapter can determine the context objects for which a re-evaluation may
	 * be necessary.
	 * 
	 * @param constraintName
	 *            name of the invariant / constraint that may have changed its
	 *            value based on a model change
	 * @param invariant
	 *            the OCL expression that defined the invariant / constraint
	 * @param impactAnalyzer
	 *            can be used by the adapter to infer the context objects on
	 *            which re-evaluation may be necessary
	 * @return an adapter that will be notified about model changes within the
	 *         {@link ResourceSet} specified during construction of this
	 *         {@link Revalidator} that may impact the value of the constraint /
	 *         invariant specified by <code>constraintName</code> and
	 *         <code>invariant</code>
	 */
	protected abstract Adapter getAdapter(final String constraintName,
			final OCLExpression invariant, final ImpactAnalyzer impactAnalyzer);

}
