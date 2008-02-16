/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation and others.
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
 * $Id: AbstractEnvironmentFactory.java,v 1.4 2008/02/16 00:07:21 cdamus Exp $
 */
package org.eclipse.ocl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.internal.evaluation.TracingEvaluationVisitor;
import org.eclipse.ocl.util.Adaptable;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflection;


/**
 * Partial implementation of the {@link EnvironmentFactory} interface, useful
 * for subclassing to define the OCL binding for a metamodel.  This abstract
 * class takes care of some of the more common (and mundane) chores, such as:
 * <ul>
 *   <li>defining the "self" variable in the classifier context</li>
 *   <li>creating variables for operation parameters in an operation context</li>
 * </ul>
 * <p>
 * The subclass's responsibility (in addition to implementing any other
 * interface methods not implemented here) is to define how to:
 * </p>
 * <ul>
 *   <li>{@linkplain #getClassifier obtain} the classifier in the
 *       user model of an input element (which may already be a classifier
 *       or an may be an M0 instance)</li>
 *   <li>{@linkplain #lookupPackage lookup} a package in the model associated
 *       with this environment factory</li>
 * </ul>
 * <p>
 * This class is intended to be extended by clients, for the purpose of
 * implementing metamodel-specific environment factories.
 * </p>
 * <p>
 * See the {@link EnvironmentFactory} class for a description of the
 * generic type parameters of this class. 
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	implements EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>,
		Adaptable {

    private boolean traceEvaluation;
    
	/**
	 * Initializes me.
	 */
	protected AbstractEnvironmentFactory() {
		super();
	}
	
    /**
     * Creates an environment for the specified package context.
     * 
     * @param parent the parent environment of the environment to be created
     * @param context the package context (must not be <code>null</code>)
     * @return the new nested environment
     */
	protected Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createPackageContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			PK context) {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) result)
				.setContextPackage(context);
		}
		
		return result;
	}

    // implements the interface method
    public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    createPackageContext(
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
            List<String> pathname) {
		PK contextPackage = lookupPackage(pathname);        
        return (contextPackage == null)? null : createPackageContext(parent, contextPackage);
    }
	
    /**
     * Looks up the package identified by the specified qualified name by
     * whatever means is appropriate to the particular environment implementation.
     * 
     * @param pathname the qualified name of the package to find
     * @return the matching package, or <code>null</code> if none is found
     */
	protected abstract PK lookupPackage(List<String> pathname);
	
    // implements the interface method
	public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createClassifierContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			C context) {
        
        Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
            createEnvironment(parent);
        
        // in case it corresponds to an OCL primitive type
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = parent.getUMLReflection();
        context = uml.asOCLType(context);

        Variable<C, PM> self = parent.getOCLFactory().createVariable();
        uml.setName(self, Environment.SELF_VARIABLE_NAME);
        uml.setType(self, context);
        
        result.addElement(self.getName(), self, true);
        result.setSelfVariable(self);
        
        return result;
	}
    
    // implements the interface method
    public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    createInstanceContext(
            Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
            Object context) {
        
        return createClassifierContext(parent, getClassifier(context));
    }
	
    // implements the interface method
	public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createOperationContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			O operation) {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) result)
				.setContextOperation(operation);
		}
		
        UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml = parent.getUMLReflection();
		OCLFactory oclFactory = parent.getOCLFactory();
		
        for (PM next : parent.getUMLReflection().getParameters(operation)) {
			// ensure that we use the OCL primitive types wherever possible
			Variable<C, PM> var = oclFactory.createVariable();
			uml.setName(var, uml.getName(next));
			uml.setType(var, TypeUtil.resolveType(result, uml.getOCLType(next)));
			var.setRepresentedParameter(next);
			
			result.addElement(var.getName(), var, true);
		}
		
		return result;
	}
	
    // implements the interface method
	public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createAttributeContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent,
			P property) {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>) result)
				.setContextProperty(property);
		}
		
		return result;
	}
	
    // implements the interface method
	public EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createEvaluationVisitor(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			EvaluationEnvironment<C, O, P, CLS, E> evalEnv,
			Map<? extends CLS, ? extends Set<? extends E>> extentMap) {
        EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> result =
            new EvaluationVisitorImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
				env, evalEnv, extentMap);
        
        if (isEvaluationTracingEnabled()) {
            // decorate the evaluation visitor with tracing support
            result = new TracingEvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
                    result);
        }
        
        return result;
	}

    /**
     * Obtains client metamodel's classifier for the specified
     * <code>context</code> object, which may be an instance of a classifier
     * in the user model or may actually be a classifier in the user model.
     * 
     * @param context a context object or classifier
     * @return the user model's classifier for this context object, or the
     *     context itself if it is a classifier
     */
    protected abstract C getClassifier(Object context);
    
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
    protected boolean isEvaluationTracingEnabled() {
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
    protected void setEvaluationTracingEnabled(boolean b) {
        traceEvaluation = b;
    }

	/**
	 * The abstract environment factory implementation is adaptable.  The
	 * default implementation adapts to and interface actually implemented by
	 * the receiver.
	 * <p>
	 * Subclasses may override or extend this implementation.
	 * </p>
	 * 
	 * @since 1.2
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapterType) {
		T result;
		
		if (adapterType.isAssignableFrom(getClass())) {
			result = (T) this;
		} else {
			result = null;
		}
		
		return result;
	}
}
