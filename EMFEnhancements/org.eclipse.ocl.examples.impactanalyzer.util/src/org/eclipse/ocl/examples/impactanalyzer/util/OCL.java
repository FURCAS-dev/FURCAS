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
package org.eclipse.ocl.examples.impactanalyzer.util;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.ExtentMap;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

/**
 * Eases the construction of an OCL instance configured with a specific {@link OppositeEndFinder}. The OCL environments
 * returned by the operations on this class use the {@link ExtentMap} which is consistently defined via the
 * {@link OppositeEndFinder#getAllInstancesSeenBy(org.eclipse.emf.ecore.EClass, org.eclipse.emf.common.notify.Notifier)}
 * operation definition of the {@link OppositeEndFinder} used.<p>
 * 
 * If no specific {@link OppositeEndFinder} is provided, e.g. by using {@link #newInstance()}, the
 * {@link DefaultOppositeEndFinder} will be used consistently, also for the definition of the
 * {@link ExtentMap}.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class OCL {
    /**
     * Constructs an OCL instance that uses a {@link DefaultOppositeEndFinder} and the default package
     * registry, yet uses the non-default {@link ExtentMap} which defines <code>allInstances</code>
     * results consistently with the opposite end finder being used.
     */
    public static org.eclipse.ocl.ecore.OCL newInstance() {
        return org.eclipse.ocl.ecore.OCL.newInstance(new EcoreEnvironmentFactoryWithScopedExtentMap());
    }
    
    /**
     * Constructs the OCL instance so that metamodel lookups are performed with the <code>registry</code>
     * provided. A {@link DefaultOppositeEndFinder} is used for hidden opposite retrieval/navigation as
     * well as for <code>allInstances</code> evaluation.
     */
    public static org.eclipse.ocl.ecore.OCL newInstance(EPackage.Registry registry) {
        return org.eclipse.ocl.ecore.OCL.newInstance(new EcoreEnvironmentFactoryWithScopedExtentMap(registry));
    }

    /**
     * Uses the specific opposite end finder to parameterize the OCL environment returned.
     * The opposite end finder is used consistently for all hidden opposite property retrievals
     * and navigations as well as for <code>allInstances</code> operation calls by means of an
     * {@link ExtentMap} parameterized with this opposite end finder.
     * 
     * @param oppositeEndFinder if <code>null</code>, a {@link DefaultOppositeEndFinder} is used instead.
     */
    public static org.eclipse.ocl.ecore.OCL newInstance(OppositeEndFinder oppositeEndFinder) {
        return org.eclipse.ocl.ecore.OCL.newInstance(new EcoreEnvironmentFactoryWithScopedExtentMap(
                oppositeEndFinder == null ? DefaultOppositeEndFinder.getInstance() : oppositeEndFinder));
    }
}
