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
 * $Id: OCLTypeChecker.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;

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
class OCLTypeChecker extends AbstractTypeChecker {

	OCLTypeChecker(Environment env) {
		super(env);
	}

	@Override
	protected CollectionType resolveCollectionType(CollectionKind kind,
			Type elementType) {
		return (CollectionType) TypeUtil.resolveCollectionType(
			getEnvironment(), kind, elementType);
	}

	@Override
	protected TupleType resolveTupleType(
			EList<? extends TypedElement> parts) {
		return (TupleType) TypeUtil.resolveTupleType(getEnvironment(),
			parts);
	}

	@Override
	protected Type resolve(Type type) {
		return TypeUtil.resolveType(getEnvironment(), type);
	}
}
