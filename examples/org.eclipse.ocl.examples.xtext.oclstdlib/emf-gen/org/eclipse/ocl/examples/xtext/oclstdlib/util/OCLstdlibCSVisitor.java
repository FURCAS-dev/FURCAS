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
 * from: /org.eclipse.ocl.examples.xtext.oclstdlib/model/OCLstdlibCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id: OCLstdlibCSVisitor.java,v 1.4 2011/02/11 20:59:23 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.oclstdlib.util;

/**
 */
public interface OCLstdlibCSVisitor<R, C> extends org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor<R, C>
{
	R visitLibAccumulatorCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibAccumulatorCS object);
	R visitLibClassCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS object);
	R visitLibConstraintCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS object);
	R visitLibIterationCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS object);
	R visitLibIteratorCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIteratorCS object);
	R visitLibOperationCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS object);
	R visitLibPropertyCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS object);
	R visitLibRootPackageCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS object);
	R visitPrecedenceCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS object);
}
