/**
 * <copyright> 
 *
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: OCLUtil.java,v 1.3 2007/11/06 19:47:11 cdamus Exp $
 */
package org.eclipse.ocl.util;

import java.lang.ref.Reference;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.SyntaxException;
import org.eclipse.ocl.lpg.AbstractBasicEnvironment;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.Customizable;
import org.eclipse.ocl.parser.OCLProblemHandler;
import org.eclipse.ocl.utilities.TypedElement;



/**
 * Miscellaneous utilities for use by the OCL parser/interpreter and by clients.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public final class OCLUtil {
    /** Use weak references as the keys to avoid memory leaks. */
    private static final Map<Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>, Reference<BasicEnvironment>> environments =
        new java.util.WeakHashMap<Environment<?,?,?,?,?,?,?,?,?,?,?,?>, Reference<BasicEnvironment>>();
    
	// prevent instantiation
	private OCLUtil() {
		super();
	}

	/**
	 * Obtains an adapter for the specified interface type.  Even for
	 * environments that do not adapt to the following interfaces, this method
	 * will provide a default implementation for convenience:
	 * <ul>
	 * <li>{@link BasicEnvironment}.  In the case that the environment is not
	 *     intrinsically adaptable to this interface and an extrinsic adapter
	 *     is provided, multiple adaptations of the same environment will
	 *     always return the same adapter instance</li>
     * <li>{@link Customizable}.  In the case that the environment is not
     *     intrinsically adaptable to this interface it is forcibly adapted to
     *     the {@link BasicEnvironment} protocol</li>
	 * <li>{@link ProblemHandler}</li>
	 * <li>{@link Environment.Lookup}</li>
	 * </ul>
	 * 
	 * @param <T> the requested adapter interface
	 * 
	 * @param env an environment to adapt
	 * @param adapterType the requested adapter interface
	 * @return an instance of the requested interface, or <code>null</code>
	 *     if this environment does not adapt to it
	 */
	@SuppressWarnings("unchecked")
	public static <T, PK, C, O, P>
	T getAdapter(final Environment<PK, C, O, P, ?, ?, ?, ?, ?, ?, ?, ?> env,
			Class<T> adapterType) {
		T result;
		
		if (env instanceof Adaptable) {
			result = ((Adaptable) env).getAdapter(adapterType);
		} else if (adapterType.isInstance(env)) {
			result = (T) env;
		} else {
			result = null;
		}
		
		if (result == null) {
			if (adapterType == BasicEnvironment.class) {
				result = (T) getBasicEnvironment(env);
			} else if (adapterType == ProblemHandler.class) {
				result = (T) getAdapter(env, BasicEnvironment.class).getProblemHandler();
			} else if (adapterType == Environment.Lookup.class) {
				result = (T) new Environment.Lookup<PK, C, O, P>() {
				    public PK tryLookupPackage(List<String> names)
                        throws LookupException {
                        
                        return env.lookupPackage(names);
                    }
    
                    public C tryLookupClassifier(List<String> names)
						throws LookupException {
						
						return env.lookupClassifier(names);
					}

                    public O tryLookupOperation(C owner, String name,
                            List<? extends TypedElement<C>> args)
                        throws LookupException {
                        
                        return env.lookupOperation(owner, name, args);
                    }

                    public P tryLookupProperty(C owner, String name)
                        throws LookupException {
                        
                        return env.lookupProperty(owner, name);
                    }

                    public C tryLookupAssociationClassReference(C owner,
                            String name)
                        throws LookupException {
                        
                        return env.lookupAssociationClassReference(owner, name);
                    }

                    public C tryLookupSignal(C owner, String name,
                            List<? extends TypedElement<C>> args)
                        throws LookupException {
                        
                        return env.lookupSignal(owner, name, args);
                    }};
			}
		}
		
		return result;
	}
	
	/**
	 * Gets the lazily cached basic-environment adapter for the specified OCL
	 * environment.  The cache is doubly weak to avoid leaking environment
	 * instances.
	 * 
	 * @param env the environment for which to define an external adapter
	 * @return the external adapter
	 */
	private static BasicEnvironment getBasicEnvironment(final Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env) {
	    BasicEnvironment result = null;
	    Reference<BasicEnvironment> ref = environments.get(env);
	    
	    if (ref != null) {
	        result = ref.get();
	    }
	    
	    if (result == null) {
	        result = new AbstractBasicEnvironment(null) {
                @SuppressWarnings("unchecked")
                @Override
                public <T> T getAdapter(Class<T> adapterType) {
                    if (adapterType == Environment.class) {
                        return (T) env;  // the reverse adaptation
                    } else {
                        return super.getAdapter(adapterType);
                    }
                }
            };
            
            environments.put(env, new java.lang.ref.WeakReference<BasicEnvironment>(result));
	    }
	    
	    return result;
	}

	/**
	 * Obtains an adapter for the specified interface type.  Even for
	 * environment factories that do not adapt to the following interfaces,
	 * this method will provide a default implementation for convenience:
	 * <ul>
	 * <li>{@link EnvironmentFactory.Lookup}</li>
	 * </ul>
	 * 
	 * @param <T> the requested adapter interface
	 * 
	 * @param factory an environment factory to adapt
	 * @param adapterType the requested adapter interface
	 * @return an instance of the requested interface, or <code>null</code>
	 *     if this environment factory does not adapt to it
	 */
	@SuppressWarnings("unchecked")
	public static <T, PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	T getAdapter(final EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> factory,
			Class<T> adapterType) {
		T result;
		
		if (factory instanceof Adaptable) {
			result = ((Adaptable) factory).getAdapter(adapterType);
		} else if (adapterType.isInstance(factory)) {
			result = (T) factory;
		} else {
			result = null;
		}
		
		if (result == null) {
			if (adapterType == EnvironmentFactory.Lookup.class) {
				result = (T) new EnvironmentFactory.Lookup<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>() {
					public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> tryCreatePackageContext(
							Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
							List<String> pathname)
						throws LookupException {
						
						return factory.createPackageContext(parent, pathname);
					}};
			}
		}
		
		return result;
	}

	/**
	 * Obtains an adapter for the specified interface type, if the evaluation
	 * environment is {@link Adaptable} to it.
	 * 
	 * @param <T> the requested adapter interface
	 * 
	 * @param env an evaluation environment to adapt
	 * @param adapterType the requested adapter interface
	 * @return an instance of the requested interface, or <code>null</code>
	 *     if this evaluation environment does not adapt to it
	 */
	@SuppressWarnings("unchecked")
	public static <T, C, O, P, CLS, E>
	T getAdapter(final EvaluationEnvironment<C, O, P, CLS, E> env,
			Class<T> adapterType) {
		T result;
		
		if (env instanceof Adaptable) {
			result = ((Adaptable) env).getAdapter(adapterType);
		} else if (adapterType.isInstance(env)) {
			result = (T) env;
		} else {
			result = null;
		}
		
		return result;
	}
    
    /**
	 * Checks whether the specified environment's problem handler has any
	 * diagnostics of error severity or worse and, if so, throws a semantic
	 * exception encapsulating these diagnostics.
	 * 
	 * @param env an environment in which we have parsed some OCL
	 * 
	 * @throws SyntaxException if there are any errors in parsing the concrete
	 *    syntax
	 * @throws SemanticException if there are any errors in analyzing the
	 *    abstract syntax 
	 * 
	 * @see #checkForErrors(ProblemHandler)
	 */
	public static Diagnostic checkForErrors(
			Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env)
			throws SyntaxException, SemanticException {
		
		return checkForErrors(getAdapter(env, ProblemHandler.class));
	}

	/**
	 * Checks whether the specified problem handler has any
	 * diagnostics of error severity or worse and, if so, throws a semantic
	 * exception encapsulating these diagnostics.
	 * 
	 * @param problemHandler a problem handler
	 * 
	 * @throws SyntaxException if there are any errors in parsing the concrete
	 *    syntax
	 * @throws SemanticException if there are any errors in analyzing the
	 *    abstract syntax 
	 */
	public static Diagnostic checkForErrors(ProblemHandler problemHandler)
			throws SyntaxException, SemanticException {
		
		Diagnostic result = null;
		
		if (problemHandler instanceof OCLProblemHandler) {
			result = ((OCLProblemHandler) problemHandler).getDiagnostic();
			
			if ((result != null) && (result.getSeverity() >= Diagnostic.ERROR)) {
				List<?> data = result.getData();
				
				if (data.contains(ProblemHandler.Phase.LEXER)
						|| data.contains(ProblemHandler.Phase.PARSER)) {
					throw new SyntaxException(result);
				} else {
					throw new SemanticException(result);
				}
			}
		}
		
		return result;
	}
}
