/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: ContextSpecificationCSImpl.java,v 1.1 2011/03/01 08:47:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextSpecificationCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.CompleteOCLCSVisitor;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpSpecificationCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Specification CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ContextSpecificationCSImpl extends ExpSpecificationCSImpl implements ContextSpecificationCS
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextSpecificationCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return CompleteOCLCSTPackage.Literals.CONTEXT_SPECIFICATION_CS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(CompleteOCLCSVisitor.class).visitContextSpecificationCS(this);
	}

} //ContextSpecificationCSImpl
