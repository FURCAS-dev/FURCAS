/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PreExpCSImpl.java,v 1.2 2011/01/24 21:08:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PreExpCS;
import org.eclipse.ocl.examples.xtext.completeocl.util.CompleteOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DecoratedNamedExpCSImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pre Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PreExpCSImpl extends DecoratedNamedExpCSImpl implements PreExpCS
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PreExpCSImpl()
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
		return CompleteOCLCSTPackage.Literals.PRE_EXP_CS;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(CompleteOCLCSVisitor.class).visitPreExpCS(this);
	}
} //PreExpCSImpl
