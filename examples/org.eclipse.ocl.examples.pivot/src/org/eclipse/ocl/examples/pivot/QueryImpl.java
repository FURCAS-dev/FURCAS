/**
 * <copyright>
 *
 * Copyright (c) 2007, 2009 IBM Corporation, Borland Software Corporation, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Radek Dvorak - Bug 261128
 *
 * </copyright>
 *
 * $Id: QueryImpl.java,v 1.3 2011/01/30 11:17:26 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.util.ProblemAware;


/**
 * Implementation of the {@link OCLBase.QueryBase} convenience interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
class QueryImpl implements OCL.Query, ProblemAware {
    private final QueryBase delegate;
    private final OCL ocl;
    
    QueryImpl(QueryBase delegate, OCL ocl) {
        this.delegate = delegate;
        this.ocl = ocl;
    }

    public OCL getOCL() {
    	return ocl;
    }
    
	public boolean check(List<?> objects) {
		return delegate.check(objects);
	}

	public boolean check(Object obj) {
		return delegate.check(obj);
	}

	public Object evaluate() {
		return delegate.evaluate();
	}

	public List<?> evaluate(List<?> objects) {
		return delegate.evaluate(objects);
	}

	public Value evaluate(Object obj) {
		return delegate.evaluate(obj);
	}

	public EvaluationEnvironment getEvaluationEnvironment() {
		return delegate.getEvaluationEnvironment();
	}

	public OclExpression getExpression() {
		return (OclExpression) delegate.getExpression();
	}

	public ModelManager getModelManager() {
		return delegate.getModelManager();
	}

	public String queryText() {
		return delegate.queryText();
	}

	public <T> List<T> reject(List<T> objects) {
		return delegate.reject(objects);
	}

	public Type resultType() {
		return delegate.resultType();
	}

	public <T> List<T> select(List<T> objects) {
		return delegate.select(objects);
	}

	public Diagnostic getProblems() {
		return OCLUtil.getEvaluationProblems(delegate);
	}
}
