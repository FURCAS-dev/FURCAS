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

import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.util.impl.OCLFactoryImpl;

/**
 * Required by the Impact Analyzer to create {@link org.eclipse.ocl.ecore.OCL} objects
 * that are properly and consistently configured. This factory interfaces allows for the
 * customization and extension of the creation process.<p>
 * 
 * A default instances is exposed by this interface: {@link #INSTANCE}.
 * 
 * @author Axel Uhl
 *
 */
public interface OCLFactory {
	/**
	 * Default instance which produces {@link org.eclipse.ocl.examples.impactanalyzer.util.OCL} instances
	 * which use an extent map for <code>allInstances</code> evaluation that is consistent with the
	 * {@link OppositeEndFinder} being used.
	 */
    static final OCLFactory INSTANCE = new OCLFactoryImpl();
    
    /**
     * Creates an OCL instance that uses the environment factory provided. See also
     * {@link OCL#newInstance(org.eclipse.ocl.EnvironmentFactory)}.
     */
    OCL createOCL(EcoreEnvironmentFactory environmentFactory);
    
    /**
     * Create an OCL instance that uses the {@link OppositeEndFinder} specified as parameter.
     * Implementations can achieve this, e.g., by using a {@link EcoreEnvironmentFactory factory}
     * which is initialized such that it returns the {@link OppositeEndFinder} specified here
     * from its {@link EcoreEnvironmentFactory#getOppositeEndFinder()} method.
     */
    OCL createOCL(OppositeEndFinder oppositeEndFinder);
}
