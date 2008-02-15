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
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *
 * </copyright>
 *
 * $Id: OCL.java,v 1.5 2008/02/15 05:20:03 cdamus Exp $
 */
package org.eclipse.ocl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.internal.OCLDebugOptions;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.evaluation.QueryImpl;
import org.eclipse.ocl.internal.helper.HelperUtil;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.ValidationVisitor;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.utilities.ExpressionInOCL;

/**
 * <p>
 * The Fa&ccedil;ade for parsing and evaluation of OCL documents and constraints.
 * The <code>OCL</code> is initialized with an environment factory that supports
 * the metamodel of the model to which the OCL constraints are to be applied.
 * </p><p>
 * Since 1.2, the helper supplies {@linkplain #getProblems() diagnostics}
 * indicating any problems encountered while parsing.  The diagnostics pertain
 * always to the most recently executed parse operation.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * <p>
 * Providers of OCL bindings for metamodels may extend this class for the
 * convenience of their clients, to specify the type parameter substitutions.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public class OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

	private final EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	environmentFactory;
	private final Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	rootEnvironment;
	
	private EvaluationEnvironment<C, O, P, CLS, E> evalEnv;
	private Map<CLS, ? extends Set<? extends E>> extentMap;
	private List<CT> constraints = new java.util.ArrayList<CT>();
	private Diagnostic problems;
	
	private boolean traceParsing = OCLPlugin.shouldTrace(OCLDebugOptions.PARSING);
    private boolean traceEvaluation = OCLPlugin.shouldTrace(OCLDebugOptions.EVALUATION);
	
    /**
     * Initializes me with an environment factory, which I will use to create
     * a root environment.
     * 
     * @param envFactory my environment factory
     */
	protected OCL(EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> envFactory) {
		this(envFactory, envFactory.createEnvironment());
	}
	
    /**
     * Initializes me with a root environment.
     * 
     * @param env my root environment
     */
	protected OCL(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		this(env.getFactory(),  env);
	}
	
    /**
     * Initializes me with an environment factory and a resource in which my
     * environment is to be persisted, or from which it may be loaded if the
     * resource already has content.
     * 
     * @param envFactory an environment factory
     * @param resource a resource in which the root environment is persisted
     */
	protected OCL(
			EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> envFactory,
			Resource resource) {
		this(envFactory, envFactory.loadEnvironment(resource));
	}
    
    /**
     * Initializes me with my environment factory and root environment.
     * 
     * @param envFactory my environment factory
     * @param rootEnv my root environment
     */
    protected OCL(
            EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> envFactory,
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> rootEnv) {
        this.environmentFactory = envFactory;
        this.rootEnvironment = rootEnv;
        
        if (envFactory instanceof AbstractEnvironmentFactory) {
            AbstractEnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
            abstractFactory =
                (AbstractEnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) envFactory;
            
            abstractFactory.setEvaluationTracingEnabled(traceEvaluation);
        }
    }
	
    /**
     * Creates a new <code>OCL</code> with an environment factory, which it will
     * use to create a root environment.
     * 
     * @param envFactory an environment factory
     * @return the OCL fa&ccedil;ade
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	newInstance(EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> envFactory) {
		
		return new OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(envFactory);
	}
	
    /**
     * Creates a new <code>OCL</code> on the specified root environment.
     * 
     * @param env the root environment
     * @return the OCL fa&ccedil;ade
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	newInstance(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		
		return new OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(env);
	}
	
    /**
     * Creates a new <code>OCL</code> with an environment factory and a resource
     * in which its environment is to be persisted, or from which it may be
     * loaded if the resource already has content.
     * 
     * @param envFactory an environment factory
     * @param resource a resource in which the root environment is persisted
     * @return the OCL fa&ccedil;ade
     */
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	newInstance(
			EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> envFactory,
			Resource resource) {
		
		return new OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(envFactory, resource);
	}
	
	/**
	 * Obtains the OCL parsing environment.  Clients may manipulate this
     * environment to support custom requirements, such as adding variables to
     * it to define "global" values.  For any variables that are added, bindings
     * will have to provided, as well, in the
     * {@linkplain #getEvaluationEnvironment() evaluation environment}.
	 * 
	 * @return the parsing environment
	 * 
	 * @see #getEvaluationEnvironment()
	 */
	public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getEnvironment() {
		return rootEnvironment;
	}
	
    /**
     * Obtains the OCL evaluation environment.  Clients may manipulate this
     * environment to support custom requirements, such as binding the values
     * of "global" variables.
     * 
     * @return the evaluation environment
     * 
     * @see #getEnvironment()
     */
	public EvaluationEnvironment<C, O, P, CLS, E> getEvaluationEnvironment() {
		if (evalEnv == null) {
			evalEnv = environmentFactory.createEvaluationEnvironment();
		}
		
		return evalEnv;
	}
	
    /**
     * Obtains the extent map, if any, provided by the client to customize the
     * evaluation of constraints.
     * 
     * @return the client-provided custom extent map, or <code>null</code> if
     *    thie OCL is using the default dynamic extent map implementation
     */
	public Map<CLS, ? extends Set<? extends E>> getExtentMap() {
		return extentMap;
	}
	
    /**
     * Assigns a custom extent map to define the extents of classes in evaluation
     * of OCL constraints.  This is only needed if the default dynamic
     * extent-map implementation is not suitable.
     * 
     * @param extentMap a custom extent map, or <code>null</code> to use the
     *    default dynamic extent map implementation
     */
	public void setExtentMap(Map<CLS, ? extends Set<? extends E>> extentMap) {
		this.extentMap = extentMap;
	}
	
    /**
     * Parses an OCL document, returning the constraints parsed from it.
     * This <code>OCL</code> instance remembers these constraints; they can
     * be retrieved later via the {@link #getConstraints()} method.
     * 
     * @param input an OCL document as either a string or a stream
     * @return the constraints parsed from the document
     * 
     * @throws ParserException on failure to parse, either because of a
     *     syntactic or semantic problem or because of an I/O failure
     *     
     * @see #getConstraints()
     */
	public List<CT> parse(OCLInput input) throws ParserException {
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		analyzer = new OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
				rootEnvironment, input.getContentAsString());
		analyzer.setTraceFlag(isParseTracingEnabled());
		
		// clear out old diagnostics
		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment, ProblemHandler.class);
		if (ph != null) {
			ph.beginParse();
		}
		
		List<CT> result = new java.util.ArrayList<CT>();
		analyzer.parsePackageDeclarationCS(result);
		
		constraints.addAll(result);
		
		List<EObject> resContents = rootEnvironment.getTypeResolver().getResource().getContents();
		for (CT ct : result) {
			EObject constraintEObject = (EObject) ct;
			
			if (constraintEObject.eResource() == null) {
				resContents.add(constraintEObject);
			}
		}
		
		if (ph != null) {
			ph.endParse();
			
			try {
				problems = OCLUtil.checkForErrors(ph);
			} catch (ParserException e) {
				problems = e.getDiagnostic();
				throw e;
			}
		}
		
		return result;
	}
	
    /**
     * Obtains all of the constraints parsed hitherto by this OCL instance.
     * These accumulate with every document that is parsed.
     * 
     * @return the constraints that I have parsed
     * 
     * @see #parse(OCLInput)
     */
	public List<CT> getConstraints() {
		return constraints;
	}
	
    /**
     * Validates an OCL expression, which may have been loaded from some
     * resource or constructed via the API (perhaps by translation from some
     * other language).
     * 
     * @param expression an expression to validate
     * 
     * @throws SemanticException on detection of any well-formedness problem
     *     in the expression
     *     
     * @see #validate(Object)
     */
	public void validate(OCLExpression<C> expression) throws SemanticException {
		// clear out old diagnostics
		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment, ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}
		
		expression.accept(ValidationVisitor.getInstance(rootEnvironment));
		
		if (ph != null) {
			ph.endValidation();
			
			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		}
	}
	
    /**
     * Validates an OCL constraint, which may have been loaded from some
     * resource or constructed via the API (perhaps by translation from some
     * other language).
     * 
     * @param constraint a constraint to validate
     * 
     * @throws SemanticException on detection of any well-formedness problem
     *     in the constraint
     */
	public void validate(CT constraint) throws SemanticException {
		// clear out old diagnostics
		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment, ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}
		
		ValidationVisitor.getInstance(rootEnvironment).visitConstraint(constraint);
		
		if (ph != null) {
			ph.endValidation();
			
			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		}
	}
	
    /**
     * Evaluates a query expression on a context object (which is bound to the
     * <tt>self</tt> variable).  Clients should use the {@link #isInvalid(Object)}
     * method to check whether the evaluation result is <tt>OclInvalid</tt>.
     * 
     * @param context the context (self) object
     * @param expression the OCL expression to evaluate
     * 
     * @return the value of the expression, or <tt>OclInvalid</tt> if the
     *    evaluation fails for reasons other than a run-time exception
     *    
     * @see #isInvalid(Object)
     * @see #check(Object, Object)
     */
	public Object evaluate(Object context, OCLExpression<C> expression) {
		// can determine a more appropriate context from the context
		//   variable of the expression, to account for stereotype constraints
		context = HelperUtil.getConstraintContext(
				rootEnvironment, context, expression);
		
		EvaluationEnvironment<C, O, P, CLS, E> localEvalEnv = getEvaluationEnvironment();
		localEvalEnv.add(Environment.SELF_VARIABLE_NAME, context);
		
		Map<CLS, ? extends Set<? extends E>> extents = getExtentMap();
		if (extents == null) {
			// let the evaluation environment create one
			extents = localEvalEnv.createExtentMap(context);
		}
		
		EvaluationVisitor<?, C, O, P, ?, ?, ?, ?, ?, CT, CLS, E> ev =
			environmentFactory.createEvaluationVisitor(
					rootEnvironment,
					localEvalEnv,
					extents);
		
		Object result;
		
		try {
			result = ev.visitExpression(expression);
		} finally {
			localEvalEnv.remove(Environment.SELF_VARIABLE_NAME);
		}
		
		return result;
	}
	
    /**
     * Queries whether a value is the special <tt>OclInvalid</tt> token.
     * This is useful for determining whether the result of an expression
     * evaluation is valid.
     * 
     * @param value some OCL value
     * @return <code>true</code> if it is the <tt>OclInvalid</tt>;
     *    <code>false</code>, otherwise
     *    
     * @see #evaluate(Object, OCLExpression)
     */
	public boolean isInvalid(Object value) {
		return getEnvironment().getOCLStandardLibrary().getOclInvalid() ==
			value;
	}
	
    /**
     * Checks whether a constraint is satisfied by an object.  If the constraint
     * is an invariant constraint, then no additional variable bindings are
     * required.  If it is an operation precondition or postcondition, however,
     * then the appropriate parameter variables and (in the postcondition case)
     * result variable should be bound in the evaluation environment.
     * 
     * @param context the <tt>self</tt> object of the constraint
     * @param constraint the constraint to check
     * 
     * @return whether the context object satisfies the constraint
     * 
     * @see #check(Object, OCLExpression)
     * @see #evaluate(Object, OCLExpression)
     */
    public boolean check(Object context, CT constraint) {
        ExpressionInOCL<C, PM> specification =
            rootEnvironment.getUMLReflection().getSpecification(constraint);
        
        return check(context, specification.getBodyExpression());
    }
	
    /**
     * Checks whether a constraint, specified simply as an OCL expression,
     * is satisfied by an object.  If the constraint
     * is an invariant constraint, then no additional variable bindings are
     * required.  If it is an operation precondition or postcondition, however,
     * then the appropriate parameter variables and (in the postcondition case)
     * result variable should be bound in the evaluation environment.
     * 
     * @param context the <tt>self</tt> object of the constraint
     * @param constraint the constraint to check, which must be a boolean-valued
     *    expression
     * 
     * @return whether the context object satisfies the constraint
     * 
     * @see #check(Object, Object)
     * @see #evaluate(Object, OCLExpression)
     * 
     * @throws IllegalArgumentException if the constraint expression is not
     *     boolean-valued
     */
    public boolean check(Object context, OCLExpression<C> constraint) {
        OCLStandardLibrary<C> stdlib = getEnvironment().getOCLStandardLibrary();
        if (constraint.getType() != stdlib.getBoolean()) {
            throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
        }
        
        Object result = evaluate(context, constraint);
        
        return Boolean.TRUE.equals(result);
    }
	
    /**
     * Creates a new {@link OCLHelper} instance for convenient parsing of
     * embedded constraints and query expressions in this environment.  The
     * helper is particulary useful for parsing constraints embedded in the
     * model, in which case the context of a constraint is determined by its
     * placement and the textual context declarations are unnecessary.
     * 
     * @return a new helper object
     */
	public OCLHelper<C, O, P, CT> createOCLHelper() {
		return HelperUtil.createOCLHelper(this);
	}
	
    /**
     * Creates a new {@link Query} encapsulating a query expression with the
     * current environment and extent map.  This is convenient for repeated
     * evaluation of expressions and for filtering/transforming objects using
     * a query or constraint expression.
     * <p>
     * Every query maintains its own evaluation environment, which enables
     * concurrent evaluation (where this may be safe in an EMF-based model) and
     * different bindings for client-supplied "global" variables.
     * </p>
     * 
     * @param query the OCL query expression, which may be interpreted as a 
     *     constraint if it is boolean-valued
     *     
     * @return the new query object
     * 
     * @see #createQuery(Object)
     */
	public Query<C, CLS, E> createQuery(OCLExpression<C> query) {
		return new QueryImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
				rootEnvironment, query, extentMap);
	}
	
    /**
     * Creates a new {@link Query} encapsulating a constraint with the
     * current environment and extent map.  This is convenient for repeated
     * evaluation of constraints and for filtering objects using
     * the constraint expression.
     * <p>
     * Every query maintains its own evaluation environment, which enables
     * concurrent evaluation (where this may be safe in an EMF-based model) and
     * different bindings for client-supplied "global" variables.
     * </p>
     * 
     * @param constraint the OCL constraint
     *     
     * @return the new query object
     * 
     * @see #createQuery(OCLExpression)
     */
	public Query<C, CLS, E> createQuery(CT constraint) {
		return new QueryImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
				rootEnvironment,
				rootEnvironment.getUMLReflection().getSpecification(constraint).getBodyExpression(),
				extentMap);
	}
	
    /**
     * Queries whether tracing of parsingis enabled.  Tracing
     * logs the progress of parsing  to the console, which may
     * be of use in diagnosing problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/parsing</tt> debug option. 
     * </p>
     * 
     * @return whether parse tracing is enabled
     * 
     * @see #setParseTracingEnabled(boolean)
     */
	public boolean isParseTracingEnabled() {
		return traceParsing;
	}
	
    /**
     * Sets whether tracing of parsing is enabled.  Tracing logs
     * the progress of parsing to the console, which may be of use in diagnosing
     * problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/parsing</tt> debug option. 
     * </p>
     * 
     * param b whether parsing tracing is enabled
     * 
     * @see #isParseTracingEnabled()
     */
	public void setParseTracingEnabled(boolean b) {
		traceParsing = b;
	}
    
    /**
     * Queries whether tracing of evaluation is enabled.  Tracing
     * logs the progress of evaluation to the console, which may
     * be of use in diagnosing problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option. 
     * </p>
     * 
     * @return whether evaluation tracing is enabled
     * 
     * @see #setEvaluationTracingEnabled(boolean)
     */
    public boolean isEvaluationTracingEnabled() {
        return traceEvaluation;
    }
    
    /**
     * Sets whether tracing of evaluation is enabled.  Tracing logs
     * the progress of parsing to the console, which may be of use in diagnosing
     * problems.
     * <p>
     * In an Eclipse environment, tracing is also enabled by turning on the
     * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option. 
     * </p>
     * 
     * param b whether evaluation tracing is enabled
     * 
     * @see #isEvaluationTracingEnabled()
     */
    public void setEvaluationTracingEnabled(boolean b) {
        traceEvaluation = b;
        
        if (environmentFactory instanceof AbstractEnvironmentFactory) {
            AbstractEnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
            abstractFactory =
                (AbstractEnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) environmentFactory;
            
            abstractFactory.setEvaluationTracingEnabled(traceEvaluation);
        }
    }
    
    /**
     * Obtains problems, if any, found in parsing the last OCL constraint or
     * query expression.
     * 
     * @return parsing problems or <code>null</code> if all was OK
     * 
     * @since 1.2
     */
    public Diagnostic getProblems() {
    	return problems;
    }
    
    /**
     * Disposes any objects that I have created while I have been in use.
     * This includes disposing of any {@link #getConstraints() constraints} that
     * I have parsed and {@linkplain Environment.Internal#dispose() disposing}
     * of my environment.
     * 
     * @since 1.2
     */
    public void dispose() {
        // dispose of constraints by clearing their adapters
        for (CT constraint : getConstraints()) {
            EObject eObject = (EObject) constraint;

            if (eObject.eResource() == null) {
                ObjectUtil.dispose(constraint);
            }
        }
        
        // forget the constraints
        getConstraints().clear();
        
        // dispose of my environment
        if (getEnvironment() instanceof Environment.Internal) {
            Environment.Internal<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> env =
                (Environment.Internal<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?>) getEnvironment();
            env.dispose();
        }
    }
}
