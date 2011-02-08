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
package org.eclipse.ocl.examples.impactanalyzer.editor;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;

/**
 * Use at the end of your EMF sample editor's <code>createModel()</code> method to request
 * instant re-validation of your editor's EMF model with corresponding error marker creation/deletion.
 * Example:
 * <pre>
        public class MyEditor 
        extends MultiPageEditorPart
        implements IEditingDomainProvider, ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker {
            @SuppressWarnings("unused") // not read; just used to avoid GC from collecting re-validator 
            private Revalidator revalidator;
            ...
            public void createModel() {
                ...
                revalidator = new Revalidator(editingDomain, MyPackage.eINSTANCE);
            }
            ...
         }
 * </pre>
 * @author Axel Uhl (d043530)
 *
 */
public class Revalidator {
    private final EventManager eventManager;
    @SuppressWarnings("unused")
    // needed to hold on to event adapters to avoid their being GC'ed
    private final Collection<Adapter> adapters;
    private final OCLFactory oclFactory;
    private final OppositeEndFinder oppositeEndFinder;

    /**
     * Uses a {@link DefaultOppositeEndFinder}
     */
    public Revalidator(AdapterFactoryEditingDomain editingDomain, OCLFactory oclFactory, EPackage... pkgs) {
        this(editingDomain, oclFactory, DefaultOppositeEndFinder.getInstance(), pkgs);
    }
    
    /**
     * Uses the default {@link OCLFactory#INSTANCE} to create {@link OCL} objects, as well as a
     * {@link DefaultOppositeEndFinder}.
     */
    public Revalidator(AdapterFactoryEditingDomain editingDomain, EPackage... pkgs) {
        this(editingDomain, OCLFactory.INSTANCE, pkgs);
    }
    
    /**
     * Uses the default {@link OCLFactory#INSTANCE} with the provided opposite end finder to create
     * {@link OCL} instances
     */
    public Revalidator(AdapterFactoryEditingDomain editingDomain, OppositeEndFinder oppositeEndFinder,
            EPackage... pkgs) {
        this(editingDomain, OCLFactory.INSTANCE, oppositeEndFinder, pkgs);
    }
    
    /**
     * @param oclFactory used to create {@link OCL} instances
     * @param oppositeEndFinder used to instantiate an {@link OCL} object using
     * {@link OCLFactory#createOCL(OppositeEndFinder)}, and used for the {@link ImpactAnalyzer} when
     * retrieving and navigating hidden opposite references as well as for evaluating
     * <code>allInstances()</code> expressions
     * @param pkgs the metamodel packages whose invariants to observe
     */
    public Revalidator(AdapterFactoryEditingDomain editingDomain, OCLFactory oclFactory, OppositeEndFinder oppositeEndFinder,
            EPackage... pkgs) {
        eventManager = EventManagerFactory.eINSTANCE.createEventManagerFor(editingDomain.getResourceSet());
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
                            // But
                            // there is no common base interface above ValidationBehavior that lets us extract the
                            // invariant
                            final OCLExpression invariant = ValidationBehavior.INSTANCE.getInvariant(cls,
                                    constraintName, oclFactory.createOCL(oppositeEndFinder));
                            final ImpactAnalyzer impactAnalyzer = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(
                                    invariant,
                                    /* notifyOnNewContextElements */true, oppositeEndFinder, oclFactory);
                            Adapter adapter = new AdapterImpl() {
                                @Override
                                public void notifyChanged(Notification msg) {
                                    // revalidate invariant on context objects that impact analysis will produce:
                                    Collection<EObject> revalidateOn = impactAnalyzer.getContextObjects(msg);
                                    if (revalidateOn != null && !revalidateOn.isEmpty()) {
                                        new RevalidateAction(constraintName, revalidateOn, invariant, oclFactory,
                                                oppositeEndFinder).run();
                                    }
                                }
                            };
                            result.add(adapter);
                            eventManager.subscribe(impactAnalyzer.createFilterForExpression(), adapter);
                        }
                    }
                }
            }
        }
        return result;
    }

}
