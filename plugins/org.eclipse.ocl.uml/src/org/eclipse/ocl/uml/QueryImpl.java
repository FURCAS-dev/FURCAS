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
 * $Id: QueryImpl.java,v 1.2 2009/01/31 19:46:52 cdamus Exp $
 */

package org.eclipse.ocl.uml;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.ProblemAware;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;


/**
 * Implementation of the {@link OCL.Query} convenience interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
class QueryImpl implements OCL.Query, ProblemAware {
    private final Query<Classifier, Class, EObject> delegate;
    private final OCL ocl;
    
    QueryImpl(Query<Classifier, Class, EObject> delegate, OCL ocl) {
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

	public Object evaluate(Object obj) {
		return delegate.evaluate(obj);
	}

	public EvaluationEnvironment<Classifier, ?, ?, Class, EObject> getEvaluationEnvironment() {
		return delegate.getEvaluationEnvironment();
	}

	public OCLExpression getExpression() {
		return (OCLExpression) delegate.getExpression();
	}

	public Map<Class, ? extends Set<? extends EObject>> getExtentMap() {
		return delegate.getExtentMap();
	}

	public String queryText() {
		return delegate.queryText();
	}

	public <T> List<T> reject(List<T> objects) {
		return delegate.reject(objects);
	}

	public Classifier resultType() {
		return delegate.resultType();
	}

	public <T> List<T> select(List<T> objects) {
		return delegate.select(objects);
	}

	public Diagnostic getProblems() {
		return OCLUtil.getEvaluationProblems(delegate);
	}	
}
