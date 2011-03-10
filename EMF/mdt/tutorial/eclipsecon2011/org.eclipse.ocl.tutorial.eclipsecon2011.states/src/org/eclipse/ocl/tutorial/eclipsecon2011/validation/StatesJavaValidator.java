/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: StatesJavaValidator.java,v 1.1 2011/03/10 09:21:28 ewillink Exp $
 */
package org.eclipse.ocl.tutorial.eclipsecon2011.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.ocl.tutorial.eclipsecon2011.states.StatesPackage;
import org.eclipse.xtext.validation.EValidatorRegistrar;
 

public class StatesJavaValidator extends AbstractStatesJavaValidator
{
	@Override
	public void register(EValidatorRegistrar registrar) {
		super.register(registrar);
		StatesPackage ePackage = StatesPackage.eINSTANCE;
		URI oclURI = URI.createPlatformResourceURI("/org.eclipse.ocl.tutorial.eclipsecon2011.states.ocl/model/States.ocl", true);
		registrar.register(ePackage, new CompleteOCLEObjectValidator(ePackage, oclURI));
	}
}
