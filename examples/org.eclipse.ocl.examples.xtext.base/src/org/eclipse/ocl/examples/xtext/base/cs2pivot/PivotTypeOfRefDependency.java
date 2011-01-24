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
 * $Id: PivotTypeOfRefDependency.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;

public class PivotTypeOfRefDependency extends AbstractDependency<TypedRefCS>
{
	public PivotTypeOfRefDependency(TypedRefCS csElement) {
		super(csElement);
	}

	@Override
	public boolean canExecute() {
		if (element instanceof ParameterizedTypeRefCS) {
			Type type = ((ParameterizedTypeRefCS)element).getPivot();
			return type != null;
		}
		Element pivot = element.getPivot();
		if (pivot == null) {
			return false;
		}
		Type type = ((TypedElement)pivot).getType();
		return type != null;
	}
}