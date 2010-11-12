/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl;

import org.eclipse.ocl.expressions.OppositePropertyCallExp;
import org.eclipse.ocl.utilities.VisitorWithHiddenOpposite;


/**
 * Adds the capability to visit {@link OppositePropertyCallExp} expressions
 * 
 * @author Axel Uhl
 * @since 3.1
 */
public interface EvaluationVisitorWithHiddenOpposite<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		extends
		EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>,
		VisitorWithHiddenOpposite<Object, C, O, P, EL, PM, S, COA, SSA, CT> {

}
