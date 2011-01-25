/**
 * <copyright> 
 *
 * Copyright (c) 2007, 2009 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera - Bug 233673
 *   Zeligsoft - Bugs 233673, 261128
 *   E.D.Willink - Bug 242236
 *   Radek Dvorak - Bug 261128
 *
 * </copyright>
 *
 * $Id: OCLUtil.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.lang.Class;
import java.lang.ref.Reference;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.SyntaxException;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.lpg.AbstractBasicEnvironment;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.BasicEnvironment2;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.OCLProblemHandler;
import org.eclipse.ocl.util.Adaptable;
import org.eclipse.ocl.util.ProblemAware;



/**
 * Miscellaneous utilities for use by the OCL parser/interpreter and by clients.
 * 
 * @author Christian W. Damus (cdamus)
 * 
 * @since 1.2
 */
public final class OCLUtil {
    /** Use weak references as the keys to avoid memory leaks. */
	private static final Map<Environment, Reference<BasicEnvironment2>> environments = new java.util.WeakHashMap<Environment, Reference<BasicEnvironment2>>();

    /** Use weak references as the keys to avoid memory leaks. */
	private static final Map<Environment, Reference<TypeChecker>> typesCheckerEnvironments = new java.util.WeakHashMap<Environment, Reference<TypeChecker>>();
   
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
	        Environment env,
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
			if (adapterType == TypeChecker.class) {
				result = (T) getTypeChecker(env);
			} else if (adapterType == BasicEnvironment.class) {
				result = (T) getBasicEnvironment(env);
			} else if (adapterType == BasicEnvironment2.class) {
				result = (T) getBasicEnvironment(env);
			} else if (adapterType == ProblemHandler.class) {
				result = (T) getAdapter(env, BasicEnvironment.class).getProblemHandler();
			} else if (adapterType == Environment.Lookup.class) {
			    final PivotEnvironment _env = (PivotEnvironment) env;
			    
				result = (T) new Environment.Lookup() {
				    public org.eclipse.ocl.examples.pivot.Package tryLookupPackage(List<String> names)
                        throws LookupException {
                        
                        return _env.lookupPackage(names);
                    }
    
                    public Type tryLookupClassifier(List<String> names)
						throws LookupException {
						
						return _env.lookupClassifier(names);
					}

                    public Operation tryLookupOperation(Type owner, String name,
                            List<? extends TypedElement> args)
                        throws LookupException {
                        
                        return _env.lookupOperation(owner, name, args);
                    }

                    public Property tryLookupProperty(Type owner, String name)
                        throws LookupException {
                        
                        return _env.lookupProperty(owner, name);
                    }

                    public Type tryLookupAssociationClassReference(Type owner,
                            String name)
                        throws LookupException {
                        
                        return _env.lookupAssociationClassReference(owner, name);
                    }

                    public Signal tryLookupSignal(Type owner, String name,
                            List<? extends TypedElement> args)
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
	private static BasicEnvironment2 getBasicEnvironment(
	        final Environment env) {
	    
	    BasicEnvironment2 result = null;
	    Reference<BasicEnvironment2> ref = environments.get(env);
	    
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
            
            environments.put(env, new java.lang.ref.WeakReference<BasicEnvironment2>(result));
	    }
	    
	    return result;
	}
	
	/**
	 * Creates and caches a suitable {@link TypeChecker} from an Environment .
	 * This method will be called in case of the environment doesn't adapt to
	 * {@link TypeChecker}.
	 * 
	 * @param env
	 *            the Environment associated to the {@link TypeChecker}
	 * @return the TypeChecker
	 */
	private static TypeChecker getTypeChecker(Environment env) {

		TypeChecker result = null;

		Reference<TypeChecker> ref = typesCheckerEnvironments.get(env);

		if (ref != null) {
			result = (TypeChecker) ref.get();
		}

		if (result == null) {
			result = new OCLTypeChecker(env);
			typesCheckerEnvironments.put(env,
				new java.lang.ref.WeakReference<TypeChecker>(result));
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
	public static <T> T getAdapter(EnvironmentFactory factory,
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
			    final EnvironmentFactory _factory = (EnvironmentFactory) factory;
			    
				result = (T) new EnvironmentFactory.Lookup() {
					public Environment tryCreatePackageContext(
							Environment parent,
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
	public static <T> T getAdapter(EvaluationEnvironment env, Class<T> adapterType) {
	    
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
	public static Diagnostic checkForErrors(Environment env)
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
	 * Checks whether the specified environment's problem handler has any
	 * diagnostics of warnings severity or worse and, if so, throws a semantic
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
     * @since 3.0
	 *
	public static Diagnostic checkForErrorsOrWarnings(
			PivotEnvironment env)
			throws SyntaxException, SemanticException {
		
		return checkForErrorsOrWarnings(getAdapter(env, ProblemHandler.class));
	} */

	/**
	 * Checks whether the specified problem handler has any
	 * diagnostics of warning severity or worse and, if so, throws a semantic
	 * exception encapsulating these diagnostics.
	 * 
	 * @param problemHandler a problem handler
	 * 
	 * @throws SyntaxException if there are any errors in parsing the concrete
	 *    syntax
	 * @throws SemanticException if there are any errors in analyzing the
	 *    abstract syntax 
	 * @since 3.0
	 */
	public static Diagnostic checkForErrorsOrWarnings(ProblemHandler problemHandler)
			throws SyntaxException, SemanticException {
		
		Diagnostic result = null;
		
		if (problemHandler instanceof OCLProblemHandler) {
			result = ((OCLProblemHandler) problemHandler).getDiagnostic();
			
			if ((result != null) && (result.getSeverity() >= Diagnostic.WARNING)) {
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
	public static Environment getValidationEnvironment(Object target, Map<Object, Object> context) {
		Environment result = (Environment) context.get(Environment.class);
		
		if (result == null) {
			// try the extension point
			result = Environment.Registry.INSTANCE.getEnvironmentFor(target);
			
			if (result != null) {
				context.put(Environment.class, result);
			}
		}
		
		return result;
	}
	
	/**
	 * Attempts to get evaluation problems available from the last evaluation of
	 * the given query.
	 * 
	 * @param query
	 *            a query to check for evaluation problems
	 * @return the diagnostic object encapsulating the problem details or
	 *         <code>null</code> if no problems are available
	 * 
	 * @since 1.3
	 */
	public static Diagnostic getEvaluationProblems(QueryBase query) {

		if (query instanceof ProblemAware) {
			ProblemAware problemAware = (ProblemAware) query;
			return problemAware.getProblems();
		}

		return null;
	}
}
