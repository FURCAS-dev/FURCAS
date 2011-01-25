/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: OCL.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.helper.OCLHelperImpl;

/**
 * Convenient subclass of the <code>OCL</code> fa&ccedil;ade that binds the
 * Ecore metamodel to the superclass's generic type parameters.  This frees
 * client code from the long list of parameter substitutions.  This subclass
 * also provides a shortcut to creating an <code>OCL</code> on the shared
 * {@link EcoreEnvironmentFactory} instance.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @see EcoreEnvironmentFactory
 */
public class OCL extends OCLBase {

	/**
	 * Initialize registries to support OCL and Ecore usage. This method is
	 * intended for initialization of standalone behaviors for which plugin extension
	 * registrations have not been applied. 
	 *<p> 
	 * A null resourceSet may be provided to initialize the global package registry
	 * and global URI mapping registry.
	 *<p> 
	 * A non-null resourceSet may be provided to identify a specific package registry.
	 *<p>
	 * This method is used to configure the ResourceSet used to load the OCL Standard Library.

	 * @param resourceSet to be initialized or null for global initialization
	 * @return a failure reason, null if successful
	 * 
	 * @since 3.0
	 */
	public static String initialize(ResourceSet resourceSet) {
		Resource.Factory.Registry resourceFactoryRegistry = resourceSet != null
			? resourceSet.getResourceFactoryRegistry()
			: Resource.Factory.Registry.INSTANCE;
		resourceFactoryRegistry.getExtensionToFactoryMap().put(
			"ecore", new EcoreResourceFactoryImpl()); //$NON-NLS-1$
		return null;
	}

	/**
     * Initializes me with an environment factory for the Ecore metamodel.
     *  
	 * @param envFactory my environment factory
	 */
	protected OCL(EnvironmentFactory envFactory) {
		super(envFactory);
	}

	/**
     * Initializes me with an initial environment for the Ecore metamodel.
     * 
	 * @param env my root environment
	 */
	protected OCL(Environment env) {
		super(env);
	}

	/**
     * Initializes me with an environment factory for the Ecore metamodel and
     * a resource from which to load my root environment.
     * 
	 * @param envFactory my environment factory
     * @param resource my persisted root environment
	 */
	protected OCL(EnvironmentFactory envFactory,
			Resource resource) {
		super(envFactory, resource);
	}

    /**
     * Creates a new <code>OCL</code> using the shared Ecore environment
     * factory instance.
     * 
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance() {
		return new OCL(PivotEnvironmentFactory.INSTANCE);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory.
     * 
     * @param envFactory an environment factory for Ecore
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(EnvironmentFactory envFactory) {
		
		return new OCL(envFactory);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified initial Ecore
     * environment.
     * 
     * @param env an environment for Ecore
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(Environment env) {	
		return new OCL(env);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory and a resource from which to load the initial environment.
     * 
     * @param envFactory an environment factory for Ecore
     * @param resource the resource containing a persistent environment
     *    (which may be empty for an initially empty environment)
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(EnvironmentFactory envFactory,
			Resource resource) {
		
		return new OCL(envFactory, resource);
	}
    
	/**
	 * {@inheritDoc}
	 */
    public OCLHelper createOCLHelper() {
       return new OCLHelperImpl(this);
    }
    
	/**
	 * {@inheritDoc}
	 * <p>
	 * The return type is narrowed to the Ecore binding for the generic
	 * <tt>Query&lt;C,CLS,E&gt;</tt> type.
	 * </p>
	 */
    @Override
    public Query createQuery(Constraint constraint) {
    	return new QueryImpl(super.createQuery(constraint), this);
    }
    
	/**
	 * {@inheritDoc}
	 * <p>
	 * The return type is narrowed to the Ecore binding for the generic
	 * <tt>Query&lt;C,CLS,E&gt;</tt> type.
	 * </p>
	 */
    @Override
    public Query createQuery(OclExpression query) {
    	return new QueryImpl(super.createQuery(query), this);
    }
    
    /**
     * Convenient interface aliasing the type parameter substitutions for the
     * UML environment, for ease of typing.
     * 
     * @author Christian W. Damus (cdamus)
     */
    public static interface Query extends QueryBase {
    	/**
    	 * {@inheritDoc}
    	 * <p>
    	 * The return type is narrowed to the Ecore binding for the generic
    	 * <tt>OCLExpression&lt;C&gt;</tt> type.
    	 * </p>
    	 */
    	OclExpression getExpression();
        
    	/**
    	 * <p>
    	 * Obtains the {@link OCL} that created me.
    	 * </p>
         * 
         * @return my originating <tt>OCL</tt> instance
    	 */
        OCL getOCL();
    }
}
