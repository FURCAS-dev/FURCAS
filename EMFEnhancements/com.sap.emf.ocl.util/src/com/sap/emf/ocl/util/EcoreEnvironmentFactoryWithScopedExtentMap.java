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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

public class EcoreEnvironmentFactoryWithScopedExtentMap extends EcoreEnvironmentFactory {
    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages.
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap() {
        this(EPackage.Registry.INSTANCE);
    }

    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages. Use the
     * {@link OppositeEndFinder} specified for hidden opposites look-up and navigation
     * 
     * @since 3.1
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap(OppositeEndFinder oppositeEndFinder) {
        this(EPackage.Registry.INSTANCE, oppositeEndFinder);
    }

    /**
     * Initializes me with an <code>EPackage.Registry</code> that the environments I create will use to look up
     * packages.
     * 
     * @param reg
     *            my package registry (must not be <code>null</code>)
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap(EPackage.Registry reg) {
        this(reg, new DefaultOppositeEndFinder(reg));
    }

    /**
     * Initializes me with an <code>EPackage.Registry</code> that the environments I create will use to look up
     * packages.
     * 
     * @param reg
     *            my package registry (must not be <code>null</code>)
     * @since 3.1
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap(EPackage.Registry reg, OppositeEndFinder oppositeEndFinder) {
        super(reg, oppositeEndFinder);
    }

    @Override
    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
        return new EcoreEvaluationEnvironmentWithScopedExtentMap(getOppositeEndFinder());
    }

}
