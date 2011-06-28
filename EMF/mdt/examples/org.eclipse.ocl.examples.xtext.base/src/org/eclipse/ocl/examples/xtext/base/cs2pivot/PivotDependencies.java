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
 * $Id: PivotDependencies.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.util.Collection;

import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;

public class PivotDependencies extends AbstractDependency<Collection<? extends ModelElementCS>>
{
	public PivotDependencies(Collection<? extends ModelElementCS> csElements) {
		super(csElements);
	}

	@Override
	public boolean canExecute() {
		for (ModelElementCS csElement : element) {
			if (csElement.getPivot() == null) {
				return false;
			}
		}
		return true;
	}
}