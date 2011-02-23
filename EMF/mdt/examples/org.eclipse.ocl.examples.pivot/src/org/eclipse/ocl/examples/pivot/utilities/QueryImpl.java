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
 * $Id: QueryImpl.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.utilities;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OCLBase;
import org.eclipse.ocl.examples.pivot.OCLUtil;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.ProblemAware;
import org.eclipse.ocl.examples.pivot.QueryBase;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * Implementation of the {@link OCLBase.QueryBase} convenience interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class QueryImpl implements OCL.Query, ProblemAware {
    private final QueryBase delegate;
    private final OCL ocl;
    
    public QueryImpl(QueryBase delegate, OCL ocl) {
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
