/**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation, Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *   Borland - Bug 265066
 *   
 * </copyright>
 *
 * $Id: AbstractEnvironmentFactory.java,v 1.3 2011/01/30 11:17:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.lang.Class;
import java.util.List;

import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.evaluation.TracingEvaluationVisitor;
import org.eclipse.ocl.util.Adaptable;


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
public abstract class AbstractEnvironmentFactory implements EnvironmentFactory, Adaptable {

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
	protected Environment createPackageContext(Environment parent,
			org.eclipse.ocl.examples.pivot.Package context) {
		
		Environment result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result)
				.setContextPackage(context);
		}
		
		return result;
	}

    // implements the interface method
    public Environment
    createPackageContext(
            Environment parent,
            List<String> pathname) {
		org.eclipse.ocl.examples.pivot.Package contextPackage = lookupPackage(pathname);        
        return (contextPackage == null)? null : createPackageContext(parent, contextPackage);
    }
	
    /**
     * Looks up the package identified by the specified qualified name by
     * whatever means is appropriate to the particular environment implementation.
     * 
     * @param pathname the qualified name of the package to find
     * @return the matching package, or <code>null</code> if none is found
     */
	protected abstract org.eclipse.ocl.examples.pivot.Package lookupPackage(List<String> pathname);
	
    // implements the interface method
	public Environment
	createClassifierContext(
			Environment parent,
			Type context) {
        
        Environment result =
            createEnvironment(parent);
        
        // in case it corresponds to an OCL primitive type
        UMLReflection uml = parent.getUMLReflection();
        context = uml.asOCLType(context);

        Variable self = parent.getOCLFactory().createVariable();
        uml.setName(self, Environment.SELF_VARIABLE_NAME);
        uml.setType(self, context);
        
        result.addElement(self.getName(), self, true);
        result.setSelfVariable(self);
        
        return result;
	}
    
    // implements the interface method
    public Environment
    createInstanceContext(
            Environment parent,
            Object context) {
        
        return createClassifierContext(parent, getClassifier(context));
    }
	
    // implements the interface method
	public Environment createOperationContext(Environment parent, Operation operation) {		
		Environment result = createEnvironment(parent);		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result).setContextOperation(operation);
		}
		OCLFactory oclFactory = parent.getOCLFactory();		
        for (Parameter next : operation.getOwnedParameters()) {
			// ensure that we use the OCL primitive types wherever possible
			Variable var = oclFactory.createVariable();
			var.setName(next.getName());
			var.setType(next.getType());
			var.setRepresentedParameter(next);		
			result.addElement(var.getName(), var, true);
		}	
		return result;
	}
	
    // implements the interface method
	public Environment
	createAttributeContext(
			Environment parent,
			Property property) {
		
		Environment result =
			createEnvironment(parent);
		
		if (result instanceof AbstractEnvironment) {
			((AbstractEnvironment) result)
				.setContextProperty(property);
		}
		
		return result;
	}
	
    // implements the interface method
	public EvaluationVisitor createEvaluationVisitor(Environment env,
			EvaluationEnvironment evalEnv,
			ModelManager modelManager) {
        EvaluationVisitor result =
            new EvaluationVisitorImpl(env, evalEnv, modelManager);
        
        if (isEvaluationTracingEnabled()) {
            // decorate the evaluation visitor with tracing support
            result = new TracingEvaluationVisitor(result);
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
    protected abstract Type getClassifier(Object context);
    
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
