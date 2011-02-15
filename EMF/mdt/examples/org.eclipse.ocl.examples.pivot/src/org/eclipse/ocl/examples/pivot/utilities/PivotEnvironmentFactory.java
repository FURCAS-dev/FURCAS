/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotEnvironmentFactory.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.AbstractEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.PivotEvaluationEnvironment;



/**
 * Implementation of the {@link EnvironmentFactory} for parsing OCL expressions
 * on Ecore models.
 *
 * @author Christian W. Damus (cdamus)
 */
public class PivotEnvironmentFactory extends AbstractEnvironmentFactory {
	
	/**
     * A convenient shared instance of the environment factory, that creates
     * environments using the global package registry.
	 */
    private static PivotEnvironmentFactory globalRegistryInstance = null;
	
	public static PivotEnvironmentFactory getGlobalRegistryInstance() {
		if (globalRegistryInstance == null) {
			globalRegistryInstance = new PivotEnvironmentFactory();
		}
		return globalRegistryInstance;
	}
	
    protected final TypeManager typeManager;

	private final EPackage.Registry registry;

	/**
	 * Initializes me.  Environments that I create will use the global package
     * registry to look up packages.
	 */
	public PivotEnvironmentFactory() {
		this(EPackage.Registry.INSTANCE, null);
	}
	
	/**
	 * Initializes me with an <code>EPackage.Registry</code> that the
     * environments I create will use to look up packages.
     * 
     * @param reg my package registry (must not be <code>null</code>)
	 * @param typeManager 
	 */
	public PivotEnvironmentFactory(EPackage.Registry reg, TypeManager typeManager) {
		super();
		this.registry = reg;
		this.typeManager = typeManager != null ? typeManager : new TypeManager();
	}
	
    // implements the inherited specification
    public PivotEnvironment createEnvironment() {
		PivotEnvironment result = new PivotEnvironment(this, null);
		return result;
	}
	
    // implements the inherited specification
    public PivotEnvironment loadEnvironment(Resource resource) {
    	PivotEnvironment result = new PivotEnvironment(this, resource);
		return result;
	}
	
    /**
     * Obtains the package registry used by environment that I create to look
     * up packages.
     * 
     * @return my package registry
     */
	public final EPackage.Registry getEPackageRegistry() {
		return registry;
	}

    // implements the inherited specification
	public PivotEnvironment createEnvironment(Environment parent) {
		if (!(parent instanceof PivotEnvironment)) {
			throw new IllegalArgumentException(
				"Parent environment must be a Pivot environment: " + parent); //$NON-NLS-1$
		}
		
		PivotEnvironment result = new PivotEnvironment((PivotEnvironment) parent);
		return result;
	}

    // implements the inherited specification
	public PivotEvaluationEnvironment createEvaluationEnvironment() {
		return new PivotEvaluationEnvironment(typeManager);
	}

    // implements the inherited specification
	public PivotEvaluationEnvironment createEvaluationEnvironment(EvaluationEnvironment parent) {
		return new PivotEvaluationEnvironment(parent);
	}
	
	public TypeManager getTypeManager() {
		return typeManager;
	}

	@Override
	protected Type getClassifier(Object context) {
		// TODO Auto-generated method stub
		return null;
	}
}
