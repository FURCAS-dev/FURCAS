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
 * $Id: PivotDiagnostician.java,v 1.1 2011/02/19 12:00:36 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.validation.CancelableDiagnostician;

import com.google.inject.Inject;

public class PivotDiagnostician extends CancelableDiagnostician
{
	@Inject
	public PivotDiagnostician(EValidator.Registry registry) {
		super(registry);
	}			
}
