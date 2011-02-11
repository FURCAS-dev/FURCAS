/**
 * <copyright>
 *
 * Copyright (c) 2007, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *   Zeligsoft - Bug 251349
 *   E.D.Willink - Bug 259818
 *   Radek Dvorak - Bug 261128
 *
 * </copyright>
 *
 * $Id: OCLBase.java,v 1.4 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.utilities.QueryBaseImpl;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * <p>
 * The Fa&ccedil;ade for parsing and evaluation of OCL documents and
 * constraints. The <code>OCL</code> is initialized with an environment factory
 * that supports the metamodel of the model to which the OCL constraints are to
 * be applied.
 * </p>
 * <p>
 * Since 1.2, the helper supplies {@linkplain #getProblems() diagnostics}
 * indicating any problems encountered while parsing. The diagnostics pertain
 * always to the most recently executed parse operation.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the generic type
 * parameters of this class.
 * </p>
 * <p>
 * Providers of OCL bindings for metamodels may extend this class for the
 * convenience of their clients, to specify the type parameter substitutions.
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class OCLBase {

	private final EnvironmentFactory environmentFactory;

	private final Environment rootEnvironment;

	private EvaluationEnvironment evalEnv;

	private ModelManager modelManager;

	private List<Constraint> constraints = new java.util.ArrayList<Constraint>();

	private Diagnostic problems;
	private Diagnostic evaluationProblems;	

	private int parserRepairCount = 0;

	private boolean traceParsing = PivotPlugin
		.shouldTrace(OCLDebugOptions.PARSING);

	private boolean traceEvaluation = PivotPlugin
		.shouldTrace(OCLDebugOptions.EVALUATION);

	/**
	 * Initializes me with an environment factory, which I will use to create a
	 * root environment.
	 * 
	 * @param envFactory
	 *            my environment factory
	 */
	protected OCLBase(
			EnvironmentFactory envFactory) {
		this(envFactory, envFactory.createEnvironment());
	}

	/**
	 * Initializes me with a root environment.
	 * 
	 * @param env
	 *            my root environment
	 */
	protected OCLBase(Environment env) {
		this(env.getFactory(), env);
	}

	/**
	 * Initializes me with an environment factory and a resource in which my
	 * environment is to be persisted, or from which it may be loaded if the
	 * resource already has content.
	 * 
	 * @param envFactory
	 *            an environment factory
	 * @param resource
	 *            a resource in which the root environment is persisted
	 */
	protected OCLBase(
			EnvironmentFactory envFactory,
			Resource resource) {
		this(envFactory, envFactory.loadEnvironment(resource));
	}

	/**
	 * Initializes me with my environment factory and root environment.
	 * 
	 * @param envFactory
	 *            my environment factory
	 * @param rootEnv
	 *            my root environment
	 */
	protected OCLBase(
			EnvironmentFactory envFactory,
			Environment rootEnv) {
		this.environmentFactory = envFactory;
		this.rootEnvironment = rootEnv;

		if (envFactory instanceof AbstractEnvironmentFactory) {
			AbstractEnvironmentFactory abstractFactory = (AbstractEnvironmentFactory) envFactory;

			abstractFactory.setEvaluationTracingEnabled(traceEvaluation);
		}
	}

	/**
	 * Creates a new <code>OCL</code> with an environment factory, which it will
	 * use to create a root environment.
	 * 
	 * @param envFactory
	 *            an environment factory
	 * @return the OCL fa&ccedil;ade
	 *
	public static  OCLBase newInstance(
			EnvironmentFactory envFactory) {

		return new OCLBase(envFactory);
	} */

	/**
	 * Creates a new <code>OCL</code> on the specified root environment.
	 * 
	 * @param env
	 *            the root environment
	 * @return the OCL fa&ccedil;ade
	 *
	public static  OCLBase newInstance(
			Environment env) {

		return new OCLBase(env);
	} */

	/**
	 * Creates a new <code>OCL</code> with an environment factory and a resource
	 * in which its environment is to be persisted, or from which it may be
	 * loaded if the resource already has content.
	 * 
	 * @param envFactory
	 *            an environment factory
	 * @param resource
	 *            a resource in which the root environment is persisted
	 * @return the OCL fa&ccedil;ade
	 *
	public static  OCLBase newInstance(
			EnvironmentFactory envFactory,
			Resource resource) {

		return new OCLBase(
			envFactory, resource);
	} */

	/**
	 * Obtains the OCL parsing environment. Clients may manipulate this
	 * environment to support custom requirements, such as adding variables to
	 * it to define "global" values. For any variables that are added, bindings
	 * will have to provided, as well, in the
	 * {@linkplain #getEvaluationEnvironment() evaluation environment}.
	 * 
	 * @return the parsing environment
	 * 
	 * @see #getEvaluationEnvironment()
	 */
	public Environment getEnvironment() {
		return rootEnvironment;
	}

	/**
	 * Obtains the OCL evaluation environment. Clients may manipulate this
	 * environment to support custom requirements, such as binding the values of
	 * "global" variables.
	 * 
	 * @return the evaluation environment
	 * 
	 * @see #getEnvironment()
	 */
	public EvaluationEnvironment getEvaluationEnvironment() {
		if (evalEnv == null) {
			evalEnv = environmentFactory.createEvaluationEnvironment();
		}

		return evalEnv;
	}

	/**
	 * Obtains the model manager, if any, provided by the client to customize the
	 * evaluation of constraints.
	 * 
	 * @return the client-provided custom model manager, or <code>null</code> if
	 *         thie OCL is using the default dynamic extent map implementation
	 */
	public ModelManager getModelManager() {
		return modelManager;
	}

	/**
	 * Assigns a custom extent map to define the extents of classes in
	 * evaluation of OCL constraints. This is only needed if the default dynamic
	 * extent-map implementation is not suitable.
	 * 
	 * @param modelManager
	 *            a custom extent map, or <code>null</code> to use the default
	 *            dynamic extent map implementation
	 */
	public void setModelManager(ModelManager modelManager) {
		this.modelManager = modelManager;
	}

	/**
	 * Obtains all of the constraints parsed hitherto by this OCL instance.
	 * These accumulate with every document that is parsed.
	 * 
	 * @return the constraints that I have parsed
	 * 
	 * @see #parse(OCLInput)
	 */
	public List<Constraint> getConstraints() {
		return constraints;
	}

	/**
	 * Validates an OCL expression, which may have been loaded from some
	 * resource or constructed via the API (perhaps by translation from some
	 * other language).
	 * 
	 * @param expression
	 *            an expression to validate
	 * 
	 * @throws SemanticException
	 *             on detection of any well-formedness problem in the expression
	 * 
	 * @see #validate(Object)
	 */
	public void validate(OclExpression expression) throws SemanticException {
		throw new UnsupportedOperationException(getClass().getName() + ".validate");
		// clear out old diagnostics
/*		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment,
			ProblemHandler.class);
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
		} */
	}

	/**
	 * Validates an OCL constraint, which may have been loaded from some
	 * resource or constructed via the API (perhaps by translation from some
	 * other language).
	 * 
	 * @param constraint
	 *            a constraint to validate
	 * 
	 * @throws SemanticException
	 *             on detection of any well-formedness problem in the constraint
	 */
	public void validate(Constraint constraint) throws SemanticException {
		throw new UnsupportedOperationException(getClass().getName() + ".validate");
		// clear out old diagnostics
/*		ProblemHandler ph = OCLUtil.getAdapter(rootEnvironment,
			ProblemHandler.class);
		if (ph != null) {
			ph.beginValidation();
		}

		ValidationVisitor.getInstance(rootEnvironment).visitConstraint(
			constraint);

		if (ph != null) {
			ph.endValidation();

			try {
				OCLUtil.checkForErrors(ph);
			} catch (SyntaxException e) {
				// shouldn't actually be able to get this from validation
				throw new SemanticException(e.getDiagnostic());
			}
		} */
	}

	/**
	 * Evaluates a query expression on a context object (which is bound to the
	 * <tt>self</tt> variable). Clients should use the
	 * {@link #isInvalid(Object)} method to check whether the evaluation result
	 * is <tt>OclInvalid</tt>.
	 * 
	 * @param context
	 *            the context (self) object
	 * @param expression
	 *            the OCL expression to evaluate
	 * 
	 * @return the value of the expression, or <tt>OclInvalid</tt> if the
	 *         evaluation fails for reasons other than a run-time exception
	 * 
	 * @see #isInvalid(Object)
	 * @see #check(Object, Object)
	 */
	public org.eclipse.ocl.examples.pivot.values.Value evaluate(Object context, ExpressionInOcl expression) {
		evaluationProblems = null;
		
		// can determine a more appropriate context from the context
		// variable of the expression, to account for stereotype constraints
//		context = HelperUtil.getConstraintContext(rootEnvironment, context, expression);
		EvaluationEnvironment localEvalEnv = getEvaluationEnvironment();
		ValueFactory valueFactory = localEvalEnv.getValueFactory();
		Value value = valueFactory.valueOf(context);
//		localEvalEnv.add(Environment.SELF_VARIABLE_NAME, value);
		localEvalEnv.add(expression.getContextVariable(), value);
//		if ((value != null) && !value.isUndefined()) {
//			expression.getContextVariable().setValue(value);
//		}
		ModelManager extents = getModelManager();
		if (extents == null) {
			// let the evaluation environment create one
			extents = localEvalEnv.createModelManager(context);
		}

		EvaluationVisitor ev = environmentFactory
			.createEvaluationVisitor(rootEnvironment, localEvalEnv, extents);

		org.eclipse.ocl.examples.pivot.values.Value result;

		try {
			result = expression.accept(ev);
		} catch (EvaluationHaltedException e) {
			evaluationProblems = e.getDiagnostic();
			result = null;
//		} finally {
//			localEvalEnv.remove(Environment.SELF_VARIABLE_NAME);
//			localEvalEnv.remove(expression.getContextVariable());
		}
		if (result == null) {
			result = valueFactory.createInvalidValue("Java-Null value");
		}
		return result;
	}

	/**
	 * Queries whether a value is the special <tt>invalid</tt> token. This is
	 * useful for determining whether the result of an expression evaluation is
	 * valid.
	 * 
	 * @param value
	 *            some OCL value
	 * @return <code>true</code> if it is the <tt>invalid</tt>;
	 *         <code>false</code>, otherwise
	 * 
	 * @see #evaluate(Object, OCLExpression)
	 */
//	public boolean isInvalid(Object value) {
//		return getEnvironment().getOCLStandardLibrary().getInvalidValue() == value;
//	}

	/**
	 * Checks whether a constraint is satisfied by an object. If the constraint
	 * is an invariant constraint, then no additional variable bindings are
	 * required. If it is an operation precondition or postcondition, however,
	 * then the appropriate parameter variables and (in the postcondition case)
	 * result variable should be bound in the evaluation environment.
	 * 
	 * @param context
	 *            the <tt>self</tt> object of the constraint
	 * @param constraint
	 *            the constraint to check
	 * 
	 * @return whether the context object satisfies the constraint
	 * 
	 * @see #check(Object, OCLExpression)
	 * @see #evaluate(Object, OCLExpression)
	 */
	public boolean check(Object context, Constraint constraint) {
		ExpressionInOcl specification = (ExpressionInOcl) constraint.getSpecification();

		return check(context, specification);
	}

	/**
	 * Checks whether a constraint, specified simply as an OCL expression, is
	 * satisfied by an object. If the constraint is an invariant constraint,
	 * then no additional variable bindings are required. If it is an operation
	 * precondition or postcondition, however, then the appropriate parameter
	 * variables and (in the postcondition case) result variable should be bound
	 * in the evaluation environment.
	 * 
	 * @param context
	 *            the <tt>self</tt> object of the constraint
	 * @param constraint
	 *            the constraint to check, which must be a boolean-valued
	 *            expression
	 * 
	 * @return whether the context object satisfies the constraint
	 * 
	 * @see #check(Object, Object)
	 * @see #evaluate(Object, OCLExpression)
	 * 
	 * @throws IllegalArgumentException
	 *             if the constraint expression is not boolean-valued
	 */
	public boolean check(Object context, ExpressionInOcl specification) {
		StandardLibrary stdlib = getEnvironment().getOCLStandardLibrary();
		if (specification.getBodyExpression().getType() != stdlib.getBooleanType()) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}

		Value result = evaluate(context, specification);
		return result.isTrue();
	}

	/**
	 * Creates a new {@link OCLHelper} instance for convenient parsing of
	 * embedded constraints and query expressions in this environment. The
	 * helper is particulary useful for parsing constraints embedded in the
	 * model, in which case the context of a constraint is determined by its
	 * placement and the textual context declarations are unnecessary.
	 * 
	 * @return a new helper object
	 */
//	public OCLHelper createOCLHelper() {
//		return HelperUtil.createOCLHelper(this);
//	}

	/**
	 * Creates a new {@link QueryBase} encapsulating a query expression with the
	 * current environment and extent map. This is convenient for repeated
	 * evaluation of expressions and for filtering/transforming objects using a
	 * query or constraint expression.
	 * <p>
	 * Every query maintains its own evaluation environment, which enables
	 * concurrent evaluation (where this may be safe in an EMF-based model) and
	 * different bindings for client-supplied "global" variables.
	 * </p>
	 * 
	 * @param query
	 *            the OCL query expression, which may be interpreted as a
	 *            constraint if it is boolean-valued
	 * 
	 * @return the new query object
	 * 
	 * @see #createQuery(Object)
	 */
	public QueryBase createQuery(ExpressionInOcl specification) {
		return new QueryBaseImpl(rootEnvironment, specification, modelManager);
	}

	/**
	 * Creates a new {@link QueryBase} encapsulating a constraint with the current
	 * environment and extent map. This is convenient for repeated evaluation of
	 * constraints and for filtering objects using the constraint expression.
	 * <p>
	 * Every query maintains its own evaluation environment, which enables
	 * concurrent evaluation (where this may be safe in an EMF-based model) and
	 * different bindings for client-supplied "global" variables.
	 * </p>
	 * 
	 * @param constraint
	 *            the OCL constraint
	 * 
	 * @return the new query object
	 * 
	 * @see #createQuery(OCLExpression)
	 */
	public QueryBase createQuery(Constraint constraint) {
		return new QueryBaseImpl(
			rootEnvironment, (ExpressionInOcl) constraint.getSpecification(), modelManager);
	}

	/**
	 * Queries whether tracing of parsingis enabled. Tracing logs the progress
	 * of parsing to the console, which may be of use in diagnosing problems.
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
	 * Sets whether tracing of parsing is enabled. Tracing logs the progress of
	 * parsing to the console, which may be of use in diagnosing problems.
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
	 * <p>
	 * Queries the number of repairs to be made by the parser.
	 * </p>
	 * <p>
	 * The default zero value selects use of the deterministic parser, which
	 * terminates after one serious syntax error is detected.
	 * </p>
	 * <p>
	 * A non-zero value selects the backtracking parser. The backtracking parser
	 * may be about three times slower.
	 * </p>
	 * 
	 * @return the number of repairs to be attempted
	 * 
	 * @see #setParserRepairCount(int)
	 * @since 1.3
	 */
	public int getParserRepairCount() {
		return parserRepairCount;
	}

	/**
	 * <p>
	 * Sets the number of repairs to be made by the parser.
	 * </p>
	 * <p>
	 * The default zero value selects use of the deterministic parser, which
	 * terminates after one serious syntax error is detected.
	 * </p>
	 * <p>
	 * A non-zero value selects the backtracking parser. The backtracking parser
	 * may be about three times slower.
	 * </p>
	 * 
	 * @param parserRepairCount
	 *            whether evaluation tracing is enabled
	 * 
	 * @throws IllegalArgumentException
	 *             if the <tt>parserRepairCount</tt> is negative
	 * 
	 * @see #getParserRepairCount()
	 * @since 1.3
	 */
	public void setParserRepairCount(int parserRepairCount) {
		if (parserRepairCount < 0) {
			throw new IllegalArgumentException("negative repair count"); //$NON-NLS-1$
		}

		this.parserRepairCount = parserRepairCount;
	}

	/**
	 * Queries whether tracing of evaluation is enabled. Tracing logs the
	 * progress of evaluation to the console, which may be of use in diagnosing
	 * problems.
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
	 * Sets whether tracing of evaluation is enabled. Tracing logs the progress
	 * of parsing to the console, which may be of use in diagnosing problems.
	 * <p>
	 * In an Eclipse environment, tracing is also enabled by turning on the
	 * <tt>org.eclipse.ocl/debug/evaluation</tt> debug option.
	 * </p>
	 * 
	 * @param b
	 *            whether evaluation tracing is enabled
	 * 
	 * @see #isEvaluationTracingEnabled()
	 */
	public void setEvaluationTracingEnabled(boolean b) {
		traceEvaluation = b;

		if (environmentFactory instanceof AbstractEnvironmentFactory) {
			AbstractEnvironmentFactory abstractFactory = (AbstractEnvironmentFactory) environmentFactory;

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

	public TypeManager getTypeManager() {
		return rootEnvironment.getTypeManager();
	}

	public ValueFactory getValueFactory() {
		return getTypeManager().getValueFactory();
	}
	
	/**
	 * Obtains problems, if any, occurred during evaluation of the last OCL
	 * constraint or query expression.
	 * 
	 * @return evaluation problems or <code>null</code> if all was OK
	 * 
	 * @since 1.3
	 */
	public Diagnostic getEvaluationProblems() {
		return evaluationProblems;
	}

	/**
	 * Disposes any objects that I have created while I have been in use. This
	 * includes disposing of any {@link #getConstraints() constraints} that I
	 * have parsed and {@linkplain Environment.Internal#dispose() disposing} of
	 * my environment.
	 * 
	 * @since 1.2
	 */
	public void dispose() {
		// dispose of constraints by clearing their adapters
		for (Constraint constraint : getConstraints()) {
			EObject eObject = (EObject) constraint;

			if (eObject.eResource() == null) {
				ObjectUtil.dispose(constraint);
			}
		}

		// forget the constraints
		getConstraints().clear();

		// dispose of my environment
		if (getEnvironment() instanceof Environment.Internal) {
			Environment.Internal env = (Environment.Internal) getEnvironment();
			env.dispose();
		}
	}
}
