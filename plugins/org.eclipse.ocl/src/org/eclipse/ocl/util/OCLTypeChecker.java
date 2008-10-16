/**
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Open Canarias - initial API and implementation
 * 
 * $Id: OCLTypeChecker.java,v 1.1 2008/10/16 01:57:50 cdamus Exp $
 */
package org.eclipse.ocl.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.AbstractTypeChecker;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.TypeChecker;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.utilities.TypedElement;

/**
 * <p>
 * Default OCL implementation of the {@link TypeChecker} interface which,
 * indeed, extends the {@link AbstractTypeChecker} class.
 * </p>
 * <p>
 * If an environment cannot adapt to {@link TypeChecker}, by default an
 * instance of this class will be created and cached for it by {@link OCLUtil}.
 * This adaption mechanism ensures backward compatibility.
 * </p>
 * <p>
 * See {@link Environment} to for a description of the generic type parameters
 * of this class.
 * </p>
 * 
 * @author Adolfo Sanchez-Barbudo Herrera (adolfosbh)
 * 
 * @since 1.3
 */
class OCLTypeChecker<C, O, P, PM>
		extends AbstractTypeChecker<C, O, P, PM> {

	OCLTypeChecker(Environment<?, C, O, P, ?, PM, ?, ?, ?, ?, ?, ?> env) {
		super(env);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CollectionType<C, O> resolveCollectionType(CollectionKind kind,
			C elementType) {
		return (CollectionType<C, O>) TypeUtil.resolveCollectionType(
			getEnvironment(), kind, elementType);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected TupleType<O, P> resolveTupleType(
			EList<? extends TypedElement<C>> parts) {
		return (TupleType<O, P>) TypeUtil.resolveTupleType(getEnvironment(),
			parts);
	}

	@Override
	protected C resolve(C type) {
		return TypeUtil.resolveType(getEnvironment(), type);
	}
}
