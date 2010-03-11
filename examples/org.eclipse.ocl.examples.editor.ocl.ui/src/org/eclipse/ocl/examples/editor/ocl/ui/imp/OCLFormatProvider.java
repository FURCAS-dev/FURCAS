/**
 * <copyright>
 * 
 * Copyright (c) 2009,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLFormatProvider.java,v 1.1 2010/03/11 14:52:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.imp;

import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.examples.editor.util.FormatProvider;
import org.eclipse.ocl.utilities.UMLReflection;

public class OCLFormatProvider implements FormatProvider
{
	public String getFormat(Object object) {
		if (object instanceof Constraint) {
			Constraint constraint = (Constraint) object;
			String stereotype = constraint.getStereotype();
			if (UMLReflection.INVARIANT.equals(stereotype))
				return "{0}{1}{3}{4} - {5}";
			else if (UMLReflection.POSTCONDITION.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
			else if (UMLReflection.PRECONDITION.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
			else if (UMLReflection.DEFINITION.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
			else if (UMLReflection.DERIVATION.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
			else if (UMLReflection.INITIAL.equals(stereotype))
				return "{0}{1}::{2}{3}{4} - {5}";
		}
		return null;
	}
}
