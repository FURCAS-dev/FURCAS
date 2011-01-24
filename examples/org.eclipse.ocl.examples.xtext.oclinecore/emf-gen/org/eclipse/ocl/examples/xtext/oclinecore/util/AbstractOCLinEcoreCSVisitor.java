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
 * from: /org.eclipse.ocl.examples.xtext.oclinecore/model/OCLinEcoreCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: AbstractOCLinEcoreCSVisitor.java,v 1.3 2011/01/24 22:28:40 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.oclinecore.util;

/**
 */
public abstract class AbstractOCLinEcoreCSVisitor<R, C>
 extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractEssentialOCLCSVisitor<R, C>
	implements OCLinEcoreCSVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractOCLinEcoreCSVisitor(C context) {
	    super(context);
	}
}
