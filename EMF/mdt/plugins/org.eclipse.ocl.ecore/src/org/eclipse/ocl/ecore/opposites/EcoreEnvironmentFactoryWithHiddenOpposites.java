/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.ecore.opposites;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;


/**
 * 
 * @author Axel Uhl (auhl)
 * @since 3.1
 */
public class EcoreEnvironmentFactoryWithHiddenOpposites
		extends EcoreEnvironmentFactory {

    private final OppositeEndFinder oppositeEndFinder;
    
    /**
     * Initializes me. Environments that I create will use the global package registry to look up packages.
     * Uses the result of {@link DefaultOppositeEndFinder#getInstance()} as opposite end finder.
     */
    public EcoreEnvironmentFactoryWithHiddenOpposites() {
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
    public EcoreEnvironmentFactoryWithHiddenOpposites(EPackage.Registry reg) {
        this(reg, DefaultOppositeEndFinder.getInstance(reg));
    }
    
    /**
     * Initializes me with the default <code>EPackage.Registry</code> that the environments I create will use to look up
     * packages. The {@link OppositeEndFinder} object specified is used. Callers should ensure that the
     * <code>oppositeEndFinder</code> is consistent with the default {@link EPackage.Registry}. Otherwise,
     * use {@link #EcoreEnvironmentFactoryWithScopedExtentMap(Registry, OppositeEndFinder)} and specify the
     * particular package registry used by your opposite end finder.
     */
    public EcoreEnvironmentFactoryWithHiddenOpposites(OppositeEndFinder oppositeEndFinder) {
        this(EPackage.Registry.INSTANCE, oppositeEndFinder);
    }
    
    /**
     * Configures both, a specific package registry as well as a dedicated opposite end finder to be used
     * by the OCL environment created by this factory.
     */
    public EcoreEnvironmentFactoryWithHiddenOpposites(EPackage.Registry reg, OppositeEndFinder oppositeEndFinder) {
        super(reg);
        this.oppositeEndFinder = oppositeEndFinder;
    }

    @Override
    protected OppositeEndFinder createOppositeEndFinder(Registry registry) {
        return oppositeEndFinder;
    }

}
