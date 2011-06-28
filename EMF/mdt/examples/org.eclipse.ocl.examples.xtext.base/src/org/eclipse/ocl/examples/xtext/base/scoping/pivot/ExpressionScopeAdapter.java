/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: ExpressionScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

public abstract class ExpressionScopeAdapter<P extends OclExpression> extends AbstractPivotScopeAdapter<P>
{
	public ExpressionScopeAdapter(TypeManager typeManager, P pivotElement) {
		super(typeManager, pivotElement);
	}
}
