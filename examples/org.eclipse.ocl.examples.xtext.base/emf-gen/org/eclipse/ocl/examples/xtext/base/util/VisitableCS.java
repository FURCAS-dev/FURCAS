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
 * $Id: VisitableCS.java,v 1.2 2011/01/24 20:59:32 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.base.util;

import org.eclipse.emf.ecore.EClass;

public interface VisitableCS
{
	/**
	 * Returns the result of accepting a visit from a visitor.
	 * Implementations typically invoke a derived-class-specific
	 * variant of visitXXX() to facilitate derived-class-specific
	 * processing or just visit() when no such method is available.
	 * <p>
	 * Implementations of visit() may use the EcoreSwitch to perform
	 * derived-class-specific processing.
	 * <p>
	 * Derived implementations of accept() may use getAdapter() to obtain
	 * richer visitor interfaces.
	 * @param <R, C>
	 * @param visitor
	 * @return the result of the visit.
	 */
	<R, C> R accept(BaseCSVisitor<R, C> visitor);
	
	EClass eClass();
}
