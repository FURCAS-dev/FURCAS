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
 * $Id: DecorableVisitor.java,v 1.6 2011/02/15 19:58:28 ewillink Exp $
 */
package	org.eclipse.ocl.examples.pivot.util;

/**
 */
public interface DecorableVisitor<R, C> extends Visitor<R, C>
{
//	DecorableVisitor<R, C> createNestedVisitor();
	void setUndecoratedVisitor(Visitor<R, C> visitor);
}
