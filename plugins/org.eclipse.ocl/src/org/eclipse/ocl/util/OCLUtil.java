/**
 * <copyright> 
 *
 * Copyright (c) 2007, 2008 IBM Corporation and others.
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
 * $Id: OCLUtil.java,v 1.5 2008/04/27 23:16:03 cdamus Exp $
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
	public static <T> T getAdapter(
	        Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env,
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
			    final Environment<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> _env =
			        (Environment<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>) env;
			    
				result = (T) new Environment.Lookup<Object, Object, Object, Object>() {
				    public Object tryLookupPackage(List<String> names)
                        throws LookupException {
                        
                        return _env.lookupPackage(names);
                    }
    
                    public Object tryLookupClassifier(List<String> names)
						throws LookupException {
						
						return _env.lookupClassifier(names);
					}

                    public Object tryLookupOperation(Object owner, String name,
                            List<? extends TypedElement<Object>> args)
                        throws LookupException {
                        
                        return _env.lookupOperation(owner, name, args);
                    }

                    public Object tryLookupProperty(Object owner, String name)
                        throws LookupException {
                        
                        return _env.lookupProperty(owner, name);
                    }

                    public Object tryLookupAssociationClassReference(Object owner,
                            String name)
                        throws LookupException {
                        
                        return _env.lookupAssociationClassReference(owner, name);
                    }

                    public Object tryLookupSignal(Object owner, String name,
                            List<? extends TypedElement<Object>> args)
                        throws LookupException {
                        
                        return _env.lookupSignal(owner, name, args);
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
	private static BasicEnvironment getBasicEnvironment(
	        final Environment<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env) {
	    
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
	public static <T> T getAdapter(
	        EnvironmentFactory<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> factory,
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
			    final EnvironmentFactory<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> _factory =
			        (EnvironmentFactory<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>) factory;
			    
				result = (T) new EnvironmentFactory.Lookup<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object>() {
					public Environment<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> tryCreatePackageContext(
							Environment<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Object> parent,
							List<String> pathname)
						throws LookupException {
						
						return _factory.createPackageContext(parent, pathname);
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
	public static <T> T getAdapter(EvaluationEnvironment<?, ?, ?, ?, ?> env,
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
	
	/**
	 * Attempts to get an environment instance that is appropriate for introspection
	 * of the specified validation <tt>target</tt>.  If an environment is specified
	 * in the validation <tt>context</tt>, then it is used.  Otherwise, an
	 * environment is obtained from the registry.
	 * 
	 * @param target an object to be validated in an appropriate environment
	 * @param context the current validation context
	 * 
	 * @return the environment, or <code>null</code> if none can be found
	 * 
	 * @see Environment.Registry
	 */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getValidationEnvironment(
			Object target, Map<Object, Object> context) {
		
		@SuppressWarnings("unchecked")
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result = (Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) context
				.get(Environment.class);
		
		if (result == null) {
			// try the extension point
			result = Environment.Registry.INSTANCE.getEnvironmentFor(target);
			
			if (result != null) {
				context.put(Environment.class, result);
			}
		}
		
		return result;
	}
}
