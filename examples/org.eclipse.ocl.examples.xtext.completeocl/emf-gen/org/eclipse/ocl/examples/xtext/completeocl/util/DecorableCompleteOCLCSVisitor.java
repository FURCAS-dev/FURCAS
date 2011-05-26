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
 * from: /org.eclipse.ocl.examples.xtext.completeocl/model/CompleteOCLCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: DecorableCompleteOCLCSVisitor.java,v 1.10 2011/05/20 15:26:49 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.completeocl.util;

/**
 */
public interface DecorableCompleteOCLCSVisitor<R, C> extends CompleteOCLCSVisitor<R, C>, org.eclipse.ocl.examples.xtext.essentialocl.util.DecorableEssentialOCLCSVisitor<R, C>
{
//	DecorableCompleteOCLCSVisitor<R, C> createNestedVisitor();
	void setUndecoratedVisitor(org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor<R, C> visitor);
}
