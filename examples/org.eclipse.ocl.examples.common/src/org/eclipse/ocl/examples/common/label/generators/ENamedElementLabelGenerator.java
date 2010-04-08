/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
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
 * $Id: ENamedElementLabelGenerator.java,v 1.2 2010/04/08 06:27:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label.generators;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class ENamedElementLabelGenerator extends AbstractLabelGenerator<ENamedElement>
{
	public static void initialize(Registry registry) {
		registry.install(ENamedElement.class, new ENamedElementLabelGenerator());		
	}
	
	public ENamedElementLabelGenerator() {
		super(ENamedElement.class);
	}

	public void buildLabelFor(Builder labelBuilder, ENamedElement object) {
		EObject eContainer = object.eContainer();
		if (eContainer != null) {
			labelBuilder.getRegistry().buildSubLabelFor(labelBuilder, eContainer);
			labelBuilder.appendString("/");
		}
		String name = object.getName();
		if (name != null)
			labelBuilder.appendString(name);
		else {
			labelBuilder.appendString("<null-named-");
			labelBuilder.appendString(object.getClass().getSimpleName());
			labelBuilder.appendString(">");
		}
	}
}