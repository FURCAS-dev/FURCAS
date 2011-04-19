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
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

/**
 * Required by the Impact Analyzer to create {@link org.eclipse.ocl.ecore.OCL} objects
 * that are properly and consistently configured. This factory allows for the
 * customization and extension of the creation process.<p>
 * 
 * A default instance is exposed by {@link #getInstance()}.
 * 
 * @author Axel Uhl
 *
 */
public class OCLFactory {
	/**
	 * Default instance which produces {@link org.eclipse.ocl.examples.impactanalyzer.util.OCL} instances
	 * which use an extent map for <code>allInstances</code> evaluation that is consistent with the
	 * {@link OppositeEndFinder} being used.
	 */
    private static final OCLFactory INSTANCE = new OCLFactory(EPackage.Registry.INSTANCE);
    
    private final Registry registry;
    
    public static OCLFactory getInstance() {
		return INSTANCE;
	}
    
    public static OCLFactory getInstance(Registry registry) {
    	return new OCLFactory(registry);
    }
    
    protected OCLFactory(Registry registry) {
    	this.registry = registry;
    }

	/**
     * Creates an OCL instance that uses the environment factory provided. See also
     * {@link OCL#newInstance(org.eclipse.ocl.EnvironmentFactory)}.
     */
    public OCL createOCL(EcoreEnvironmentFactory environmentFactory) {
    	if (!(environmentFactory instanceof EcoreEnvironmentFactoryWithScopedExtentMap)) {
    		throw new IllegalArgumentException("Inconsistent environment factory type. "+
    				"Expected EcoreEnvironmentFactoryWithScopedExtentMap but found "+
    				environmentFactory.getClass().getName());
    	}
        return OCL.newInstance((EcoreEnvironmentFactoryWithScopedExtentMap) environmentFactory);
    }

    /**
     * Create an OCL instance that uses the {@link OppositeEndFinder} specified as parameter.
     * Implementations can achieve this, e.g., by using a {@link EcoreEnvironmentFactory factory}
     * which is initialized such that it returns the {@link OppositeEndFinder} specified here
     * from its {@link EcoreEnvironmentFactory#getOppositeEndFinder()} method.
     */
    public OCL createOCL(OppositeEndFinder oppositeEndFinder) {
        return org.eclipse.ocl.examples.impactanalyzer.util.OCL.newInstance(registry, oppositeEndFinder);
    }
    
}
