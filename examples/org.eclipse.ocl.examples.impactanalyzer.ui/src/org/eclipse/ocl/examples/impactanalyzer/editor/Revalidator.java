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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;

/**
 * Use at the end of your EMF sample editor's <code>createModel()</code> method to request
 * instant re-validation of your editor's EMF model with corresponding error marker creation/deletion.
 * Example: "´"
 * <pre>
        public class MyEditor 
        extends MultiPageEditorPart
        implements IEditingDomainProvider, ISelectionProvider, IMenuListener, IViewerProvider, IGotoMarker {
            @SuppressWarnings("unused") // not read; just used to avoid GC from collecting re-validator 
            private Revalidator revalidator;
            ...
            public void createModel() {
                ...
                revalidator = new Revalidator(editingDomain.getResourceSet(), MyPackage.eINSTANCE);
            }
            ...
         }
 * </pre>
 * @author Axel Uhl (d043530)
 *
 */
public class Revalidator extends org.eclipse.ocl.examples.impactanalyzer.Revalidator {
    
    /**
     * Uses a {@link DefaultOppositeEndFinder}
     */
	public Revalidator(ResourceSet resourceSet, OCLFactory oclFactory,
			EPackage... pkgs) {
		super(resourceSet, oclFactory, pkgs);
	}

    /**
     * Uses the default {@link OCLFactory#INSTANCE} to create {@link OCL} objects, as well as a
     * {@link DefaultOppositeEndFinder}.
     */
    public Revalidator(ResourceSet resourceSet, EPackage... pkgs) {
        super(resourceSet, pkgs);
    }
    
    /**
     * Uses the default {@link OCLFactory#INSTANCE} with the provided opposite end finder to create
     * {@link OCL} instances
     */
	public Revalidator(ResourceSet resourceSet, OCLFactory oclFactory,
			OppositeEndFinder oppositeEndFinder, EPackage... pkgs) {
		super(resourceSet, oclFactory, oppositeEndFinder, pkgs);
	}

    /**
     * @param oclFactory used to create {@link OCL} instances
     * @param oppositeEndFinder used to instantiate an {@link OCL} object using
     * {@link OCLFactory#createOCL(OppositeEndFinder)}, and used for the {@link ImpactAnalyzer} when
     * retrieving and navigating hidden opposite references as well as for evaluating
     * <code>allInstances()</code> expressions
     * @param pkgs the metamodel packages whose invariants to observe
     */
	public Revalidator(ResourceSet resourceSet,
			OppositeEndFinder oppositeEndFinder, EPackage... pkgs) {
		super(resourceSet, oppositeEndFinder, pkgs);
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
	protected Adapter getAdapter(final String constraintName,
			final OCLExpression invariant, final ImpactAnalyzer impactAnalyzer) {
		Adapter adapter = new AdapterImpl() {
		    @Override
		    public void notifyChanged(Notification msg) {
		        // revalidate invariant on context objects that impact analysis will produce:
		        Collection<EObject> revalidateOn = impactAnalyzer.getContextObjects(msg);
		        if (revalidateOn != null && !revalidateOn.isEmpty()) {
		            new RevalidateAction(constraintName, revalidateOn, invariant, getOclFactory(),
		                    getOppositeEndFinder()).run();
		        }
		    }
		};
		return adapter;
	}

}
