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
 * $Id: NoEObjectCompositeEValidator.java,v 1.2 2011/01/24 21:00:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.utilities;

import org.eclipse.xtext.validation.CompositeEValidator;

/**
 * NoEObjectCompositeEValidator worksaround Bug 322639 by ensuring the
 * that CompositeEValidator does not register an additional 
 * EObjectValidator.
 */
public class NoEObjectCompositeEValidator extends CompositeEValidator
{
	public NoEObjectCompositeEValidator() {
		setUseEObjectValidator(false);		// FIXME Find out how to inject at USE_EOBJECT_VALIDATOR
	}
}