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
 * $Id: AbstractNullOCLstdlibCSVisitor.java,v 1.10 2011/05/20 15:27:09 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.oclstdlib.util;

/**
 * An AbstractNullOCLstdlibCSVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullOCLstdlibCSVisitor<R, C>
	extends AbstractOCLstdlibCSVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullOCLstdlibCSVisitor(C context) {
	    super(context);
	}	

	public R visitLibClassCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS object) {
		return null;
	}

	public R visitLibConstraintCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS object) {
		return null;
	}

	public R visitLibIterationCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS object) {
		return null;
	}

	public R visitLibOperationCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibOperationCS object) {
		return null;
	}

	public R visitLibPropertyCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibPropertyCS object) {
		return null;
	}

	public R visitLibRootPackageCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibRootPackageCS object) {
		return null;
	}

	public R visitMetaTypeName(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.MetaTypeName object) {
		return null;
	}

	public R visitPrecedenceCS(org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS object) {
		return null;
	}
}
