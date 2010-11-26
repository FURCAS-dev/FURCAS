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
 * $Id: OCL.java,v 1.4 2009/08/26 05:57:41 ewillink Exp $
 */

package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.internal.helper.HelperUtil;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.parser.OCLAnalyzer;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.parser.backtracking.OCLBacktrackingParser;

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
public class OCL extends org.eclipse.ocl.OCL<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> {

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
	protected OCL(EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> envFactory) {
		super(envFactory);
	}

	/**
     * Initializes me with an initial environment for the Ecore metamodel.
     * 
	 * @param env my root environment
	 */
	protected OCL(Environment<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env) {
		super(env);
	}

	/**
     * Initializes me with an environment factory for the Ecore metamodel and
     * a resource from which to load my root environment.
     * 
	 * @param envFactory my environment factory
     * @param resource my persisted root environment
	 */
	protected OCL(EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> envFactory,
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
		return new OCL(EcoreEnvironmentFactory.INSTANCE);
	}
	
    /**
     * Creates a new <code>OCL</code> creating a new Ecore environment
     * factory instance that uses the <code>oppositeEndFinder</code>
     * specified.
     * 
     * @return the new <code>OCL</code>
     * @since 3.1
     */
	public static OCL newInstance(OppositeEndFinder oppositeEndFinder) {
		return new OCL(new EcoreEnvironmentFactory(oppositeEndFinder));
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified Ecore environment
     * factory.
     * 
     * @param envFactory an environment factory for Ecore
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> envFactory) {
		
		return new OCL(envFactory);
	}
	
    /**
     * Creates a new <code>OCL</code> using the specified initial Ecore
     * environment.
     * 
     * @param env an environment for Ecore
     * @return the new <code>OCL</code>
     */
	public static OCL newInstance(Environment<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env) {
		
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
	public static OCL newInstance(EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> envFactory,
			Resource resource) {
		
		return new OCL(envFactory, resource);
	}
    
	/**
	 * @since 3.1
	 */
	protected OCLAnalyzer createOCLAnalyzer(Environment<EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject,
			CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> rootEnvironment, String input) {
		return new OCLAnalyzer(rootEnvironment, input);
	}

	/**
	 * @since 3.1
	 */
	protected OCLAnalyzer createOCLAnalyzer(OCLBacktrackingParser parser) {
		return new OCLAnalyzer(parser);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The return type is narrowed to the Ecore binding for the generic
	 * <tt>OCLHelper&lt;C,O,P,CT&gt;</tt> type.
	 * </p>
	 */
    @Override
    public Helper createOCLHelper() {
       return new OCLHelperImpl(HelperUtil.createOCLHelper(this));
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
    public Query createQuery(org.eclipse.ocl.expressions.OCLExpression<EClassifier> query) {
    	return new QueryImpl(super.createQuery(query), this);
    }
    
    /**
     * Convenient interface aliasing the type parameter substitutions for the
     * Ecore environment, for ease of typing.
     * 
     * @author Christian W. Damus (cdamus)
     */
    public static interface Helper extends OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint> {
    	/**
    	 * {@inheritDoc}
    	 * <p>
    	 * The return type is narrowed to the Ecore binding for the generic
    	 * <tt>OCLExpression&lt;C&gt;</tt> type.
    	 * </p>
    	 */
        OCLExpression createQuery(String expression) throws ParserException;
        
    	/**
    	 * {@inheritDoc}
    	 * <p>
    	 * The return type is narrowed to the Ecore binding for the generic
    	 * <tt>OCLExpression&lt;PK,C,O,P,EL,PM,S,COA,SSA,CT,CLS,E&gt;</tt> type.
    	 * </p>
    	 */
        OCL getOCL();
    }
    
    /**
     * Convenient interface aliasing the type parameter substitutions for the
     * UML environment, for ease of typing.
     * 
     * @author Christian W. Damus (cdamus)
     */
    public static interface Query extends org.eclipse.ocl.Query<EClassifier, EClass, EObject> {
    	/**
    	 * {@inheritDoc}
    	 * <p>
    	 * The return type is narrowed to the Ecore binding for the generic
    	 * <tt>OCLExpression&lt;C&gt;</tt> type.
    	 * </p>
    	 */
    	OCLExpression getExpression();
        
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
