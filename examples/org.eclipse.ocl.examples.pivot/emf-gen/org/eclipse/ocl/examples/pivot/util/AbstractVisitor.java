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
 * from: /org.eclipse.ocl.examples.pivot/model/pivot.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: AbstractVisitor.java,v 1.2 2011/01/24 20:49:36 ewillink Exp $
 */
package	org.eclipse.ocl.examples.pivot.util;

/**
 */
public abstract class AbstractVisitor<R, C> implements Visitor<R, C>
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
	protected AbstractVisitor(C context) {
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
	public R safeVisit(org.eclipse.ocl.examples.pivot.util.Visitable v) {
		return (v == null) ? null : v.accept(this);
	}
	
	/**
	 * Perform a visit to the specified visitable.
	 * 
	 * @param v a visitable, or <code>null</code>
	 * @return <code>null</code> if the visitable is <code>null</code>;
	 *     otherwise, the result of visiting it
	 */
	public R visit(org.eclipse.ocl.examples.pivot.util.Visitable v) {
		return v.accept(this);
	}

//	public R visiting(org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
//		return null;
//	}
}
