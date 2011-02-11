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
 * $Id: CompleteOCLCSVisitor.java,v 1.4 2011/02/11 20:59:28 ewillink Exp $
 */
package	org.eclipse.ocl.examples.xtext.completeocl.util;

/**
 */
public interface CompleteOCLCSVisitor<R, C> extends org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor<R, C>
{
	R visitBodyCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.BodyCS object);
	R visitClassifierContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS object);
	R visitCompleteOCLDocumentCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS object);
	R visitContextConstraintCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS object);
	R visitContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS object);
	R visitDefCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DefCS object);
	R visitDerCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DerCS object);
	R visitFeatureContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.FeatureContextDeclCS object);
	R visitInitCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InitCS object);
	R visitInvCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.InvCS object);
	R visitOclMessageArgCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OclMessageArgCS object);
	R visitOperationContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS object);
	R visitPackageDeclarationCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS object);
	R visitPostCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PostCS object);
	R visitPreCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreCS object);
	R visitPreExpCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreExpCS object);
	R visitPropertyContextDeclCS(org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS object);
}
