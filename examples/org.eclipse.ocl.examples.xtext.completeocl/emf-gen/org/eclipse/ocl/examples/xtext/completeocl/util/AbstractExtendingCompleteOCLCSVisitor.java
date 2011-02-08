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
 * $Id: AbstractExtendingCompleteOCLCSVisitor.java,v 1.3 2011/02/08 17:53:06 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.completeocl.util;

/**
 * An AbstractExtendingCompleteOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingCompleteOCLCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements CompleteOCLCSVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingCompleteOCLCSVisitor(C context) {
	    super(context);
	}	

	public R visitBodyCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS object) {
		return visitContextConstraintCS(object);
	}

	public R visitClassifierContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	public R visitCompleteOCLDocumentCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS object) {
		return visitRootPackageCS(object);
	}

	public R visitContextConstraintCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS object) {
		return visitExpConstraintCS(object);
	}

	public R visitContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS object) {
		return visitMonikeredElementCS(object);
	}

	public R visitDefCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS object) {
		return visitContextConstraintCS(object);
	}

	public R visitDerCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS object) {
		return visitContextConstraintCS(object);
	}

	public R visitFeatureContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS object) {
		return visitContextDeclCS(object);
	}

	public R visitInitCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS object) {
		return visitContextConstraintCS(object);
	}

	public R visitInvCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS object) {
		return visitContextConstraintCS(object);
	}

	public R visitOclMessageArgCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS object) {
		return visitExpCS(object);
	}

	public R visitOperationContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}

	public R visitPackageDeclarationCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS object) {
		return visitMonikeredElementCS(object);
	}

	public R visitPostCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS object) {
		return visitContextConstraintCS(object);
	}

	public R visitPreCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS object) {
		return visitContextConstraintCS(object);
	}

	public R visitPreExpCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreExpCS object) {
		return visitDecoratedNamedExpCS(object);
	}

	public R visitPropertyContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS object) {
		return visitFeatureContextDeclCS(object);
	}
}
