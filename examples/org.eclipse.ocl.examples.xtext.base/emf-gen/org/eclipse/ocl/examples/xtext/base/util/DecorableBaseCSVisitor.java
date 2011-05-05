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
 * $Id: DecorableBaseCSVisitor.java,v 1.9 2011/05/05 17:53:02 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.base.util;

/**
 */
public interface DecorableBaseCSVisitor<R, C> extends BaseCSVisitor<R, C>
{
//	DecorableBaseCSVisitor<R, C> createNestedVisitor();
	void setUndecoratedVisitor(org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor<R, C> visitor);
}
