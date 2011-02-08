/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: /org.eclipse.ocl.examples.xtext.base/model/BaseCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: AbstractBaseCSVisitor.java,v 1.3 2011/02/08 17:43:58 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.base.util;

/**
 */
public abstract class AbstractBaseCSVisitor<R, C> implements BaseCSVisitor<R, C>
{    
    /**
     * Context for the AST visitation.
     */
    protected final C context;
	
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractBaseCSVisitor(C context) {
	    this.context = context;
	}

	@SuppressWarnings("unchecked")
	public <A> A getAdapter(Class<A> adapter) {
		if (adapter.isAssignableFrom(getClass())) {
			return (A) this;
		}
		else {
			return null;
		}
	}
	
	/**
	 * A null-safe visitation of the specified visitable.
	 * 
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *     otherwise, the result of visiting it
	 */
	public R safeVisit(org.eclipse.ocl.examples.xtext.base.util.VisitableCS v) {
		return (v == null) ? null : v.accept(this);
	}
	
	/**
	 * Perform a visit to the specified visitable.
	 * 
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *     otherwise, the result of visiting it
	 */
	public R visit(org.eclipse.ocl.examples.xtext.base.util.VisitableCS v) {
		return v.accept(this);
	}

//	public R visiting(org.eclipse.ocl.examples.xtext.base.util.VisitableCS visitable) {
//		return null;
//	}
}
