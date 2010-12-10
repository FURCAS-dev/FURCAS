/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;


/**
 * An OCL environment factory that is parameterizable during construction with an
 * {@link OppositeEndFinder} in addition to the default parameterization of the
 * package {@link EPackage.Registry}. If no {@link OppositeEndFinder} is provided to
 * the constructor, a {@link DefaultOppositeEndFinder} instance is used.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class EcoreEnvironmentFactoryWithScopedExtentMap extends EcoreEnvironmentFactory {
    private final OppositeEndFinder oppositeEndFinder;
    
    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages.
     * Uses the result of {@link DefaultOppositeEndFinder#getInstance()} as opposite end finder.
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap() {
        this(EPackage.Registry.INSTANCE, DefaultOppositeEndFinder.getInstance());
    }

    /**
     * Initializes me with an <code>EPackage.Registry</code> that the environments I create will use to look up
     * packages. A new {@link DefaultOppositeEndFinder} object is created for the specific package registry
     * provided as <code>reg</code>.
     * 
     * @param reg
     *            my package registry (must not be <code>null</code>)
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap(EPackage.Registry reg) {
        this(reg, new DefaultOppositeEndFinder(reg));
    }
    
    /**
     * Initializes me with the default <code>EPackage.Registry</code> that the environments I create will use to look up
     * packages. The {@link OppositeEndFinder} object specified is used. Callers should ensure that the
     * <code>oppositeEndFinder</code> is consistent with the default {@link EPackage.Registry}. Otherwise,
     * use {@link #EcoreEnvironmentFactoryWithScopedExtentMap(Registry, OppositeEndFinder)} and specify the
     * particular package registry used by your opposite end finder.
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap(OppositeEndFinder oppositeEndFinder) {
        this(EPackage.Registry.INSTANCE, oppositeEndFinder);
    }
    
    /**
     * Configures both, a specific package registry as well as a dedicated opposite end finder to be used
     * by the OCL environment created by this factory.
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap(EPackage.Registry reg, OppositeEndFinder oppositeEndFinder) {
        super(reg);
        this.oppositeEndFinder = oppositeEndFinder;
    }

    @Override
    protected OppositeEndFinder createOppositeEndFinder(Registry registry) {
        return oppositeEndFinder;
    }

    @Override
    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
        return new EcoreEvaluationEnvironmentWithScopedExtentMap(this);
    }

}
