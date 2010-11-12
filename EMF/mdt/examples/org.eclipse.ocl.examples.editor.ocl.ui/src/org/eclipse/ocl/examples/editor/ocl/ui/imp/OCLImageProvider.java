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
 * $Id: OCLImageProvider.java,v 1.1 2010/03/11 14:52:54 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.imp;

import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.examples.editor.util.ImageProvider;
import org.eclipse.ocl.utilities.UMLReflection;

public class OCLImageProvider implements ImageProvider {

	public static final String EXTRA_OCL_ICONS_PATH = "/org.eclipse.ocl.examples.editor.ocl.ui/icons/full/obj16/";

	public String getImage(Object object) {
		if (object instanceof Constraint) {
			Constraint constraint = (Constraint) object;
			String stereotype = constraint.getStereotype();
			if (UMLReflection.INVARIANT.equals(stereotype))
				return EXTRA_OCL_ICONS_PATH + "InvariantConstraint.gif";
			else if (UMLReflection.POSTCONDITION.equals(stereotype))
				return EXTRA_OCL_ICONS_PATH + "PostconditionConstraint.gif";
			else if (UMLReflection.PRECONDITION.equals(stereotype))
				return EXTRA_OCL_ICONS_PATH + "PreconditionConstraint.gif";
			else if (UMLReflection.DEFINITION.equals(stereotype))
				return EXTRA_OCL_ICONS_PATH + "DefinitionConstraint.gif";
			else if (UMLReflection.DERIVATION.equals(stereotype))
				return EXTRA_OCL_ICONS_PATH + "DerivationConstraint.gif";
			else if (UMLReflection.INITIAL.equals(stereotype))
				return EXTRA_OCL_ICONS_PATH + "InitialConstraint.gif";
		}
		else if (object instanceof PrePostOrBodyDeclCS) {
			PrePostOrBodyDeclCS prePostOrBodyDeclCS = (PrePostOrBodyDeclCS) object;
			PrePostOrBodyEnum kind = prePostOrBodyDeclCS.getKind();
			if (kind == PrePostOrBodyEnum.PRE_LITERAL)
				return EXTRA_OCL_ICONS_PATH + "PreconditionConstraint.gif";
			else if (kind == PrePostOrBodyEnum.POST_LITERAL)
				return EXTRA_OCL_ICONS_PATH + "PostconditionConstraint.gif";
		}
		return null;
	}
}
