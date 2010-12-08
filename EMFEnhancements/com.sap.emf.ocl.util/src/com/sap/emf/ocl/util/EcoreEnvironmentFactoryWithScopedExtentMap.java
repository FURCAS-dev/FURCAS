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

public class EcoreEnvironmentFactoryWithScopedExtentMap extends EcoreEnvironmentFactory {
    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages.
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap() {
        this(EPackage.Registry.INSTANCE);
    }

    /**
     * Initializes me with an <code>EPackage.Registry</code> that the environments I create will use to look up
     * packages.
     * 
     * @param reg
     *            my package registry (must not be <code>null</code>)
     */
    public EcoreEnvironmentFactoryWithScopedExtentMap(EPackage.Registry reg) {
        super(reg);
    }

    @Override
    public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
        return new EcoreEvaluationEnvironmentWithScopedExtentMap();
    }

}
