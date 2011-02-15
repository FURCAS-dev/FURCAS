/**
 * <copyright>
 *
 * Copyright (c) 2002, 2010 IBM Corporation and others.
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
 * $Id: OCLBaseHelperImpl.java,v 1.3 2011/02/11 20:00:29 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.helper;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OCLBase;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * Default implementation of the {@link OCLHelper} interface.
 * 
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
abstract class OCLBaseHelperImpl implements OCLHelper {
	
	private final EnvironmentFactory environmentFactory;
	private Environment env;

	private boolean validating = true;
    private final OCL ocl;
    
    private Diagnostic problems;
    
	/**
	 * Initializes me with my environment.
	 * 
	 * @param ocl the OCL environment
	 */
	OCLBaseHelperImpl(OCL ocl) {
        this.ocl = ocl;
        
		environmentFactory = ocl.getEnvironment().getFactory();
	}
	
	public Environment
	getEnvironment() {
		return env == null? ocl.getEnvironment() : env;
	}
	
    public OCLBase getOCL() {
        return ocl;
    }
    
	public boolean isValidating() {
		return validating;
	}
	
	public void setValidating(boolean validating) {
		this.validating = validating;
	}
	
	private void setEnvironment(Environment env) {
		this.env = env;
	}
	
	public void setContext(Type context) {
		setEnvironment(environmentFactory.createClassifierContext(
            ocl.getEnvironment(), context));
	}
	
	public void setOperationContext(Type context, Operation operation) {
        setContext(context);
		setEnvironment(environmentFactory.createOperationContext(env, operation));
	}
	
	public void setAttributeContext(Type context, Property property) {
        setContext(context);
		setEnvironment(environmentFactory.createAttributeContext(env, property));
	}
    
    public void setInstanceContext(Object instance) {
        setEnvironment(environmentFactory.createInstanceContext(
            ocl.getEnvironment(), instance));
    }
    
    public void setInstanceOperationContext(Object instance, Operation operation) {
        setInstanceContext(instance);
        setEnvironment(environmentFactory.createOperationContext(env, operation));
    }
    
    public void setInstanceAttributeContext(Object instance, Property property) {
        setInstanceContext(instance);
        setEnvironment(environmentFactory.createAttributeContext(env, property));
    }
	
//	public Type getContextClassifier() {
//		return env.getContextClassifier();
//	}
	
//	public Operation getContextOperation() {
//		return env.getContextOperation();
//	}
	
//	public Property getContextAttribute() {
//		return env.getContextProperty();
//	}
	
	public Diagnostic getProblems() {
		return problems;
	}
	
	void setProblems(Diagnostic problems) {
		this.problems = problems;
	}
}