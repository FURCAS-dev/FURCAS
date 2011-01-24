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
 * $Id: OCLinEcoreDeclarationVisitor.java,v 1.2 2011/01/24 21:43:57 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLDeclarationVisitor;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;

public class OCLinEcoreDeclarationVisitor extends EssentialOCLDeclarationVisitor
{
	static final Logger logger = Logger.getLogger(OCLinEcoreDeclarationVisitor.class);

	public OCLinEcoreDeclarationVisitor(Pivot2CSConversion context) {
		super(context);
	}	

	@Override
	public ElementCS visitConstraint(Constraint object) {
		ConstraintCS csElement = context.refreshNamedElement(OCLinEcoreConstraintCS.class, OCLinEcoreCSTPackage.Literals.OC_LIN_ECORE_CONSTRAINT_CS, object);
		handleConstraint(object, csElement);
		return csElement;
	}
}