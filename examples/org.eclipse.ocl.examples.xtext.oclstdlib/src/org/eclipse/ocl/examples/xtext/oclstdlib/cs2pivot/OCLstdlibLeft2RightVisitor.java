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
 * $Id: OCLstdlibLeft2RightVisitor.java,v 1.2 2011/01/24 22:28:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibConstraintCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.AbstractExtendingDelegatingOCLstdlibCSVisitor;

public class OCLstdlibLeft2RightVisitor
	extends AbstractExtendingDelegatingOCLstdlibCSVisitor<MonikeredElement, CS2PivotConversion, EssentialOCLLeft2RightVisitor>
{
	public OCLstdlibLeft2RightVisitor(CS2PivotConversion context) {
		super(new EssentialOCLLeft2RightVisitor(context), context);
	}

	@Override
	public MonikeredElement visitLibConstraintCS(LibConstraintCS csLibConstraint) {
		ExpCS csExpression = csLibConstraint.getOwnedExpression();
		if (csExpression == null) {
			return null;
		}
		Constraint constraint = PivotUtil.getPivot(Constraint.class, csLibConstraint);
		OclExpression expression = context.refreshExpTree(OclExpression.class, csExpression);
		ExpressionInOcl specification = (ExpressionInOcl) constraint.getSpecification();
		specification.setBodyExpression(expression);
		return expression;
	}

	@Override
	public MonikeredElement visitPrecedenceCS(PrecedenceCS object) {
		return null;
	}
}