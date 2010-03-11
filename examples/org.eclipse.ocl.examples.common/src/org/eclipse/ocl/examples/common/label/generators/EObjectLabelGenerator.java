/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
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
 * $Id: EObjectLabelGenerator.java,v 1.1 2010/03/11 13:54:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label.generators;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class EObjectLabelGenerator extends AbstractLabelGenerator<EObject>
{
	public static void initialize(Registry registry) {
		registry.install(EObject.class, new EObjectLabelGenerator());		
	}
	
	public EObjectLabelGenerator() {
		super(EObject.class);
	}

	public void buildLabelFor(Builder labelBuilder, EObject object) {
		if (object.eIsProxy()) {
			labelBuilder.appendObject(EcoreUtil.getURI(object));
			return;
		}
		if (object.eContainer() != null) {
			labelBuilder.appendObject(object.eContainer());
			labelBuilder.appendString("/");
		}
		labelBuilder.appendString("<unnamed-");
		labelBuilder.appendString(object.getClass().getSimpleName());
		labelBuilder.appendString(">");
	}
}