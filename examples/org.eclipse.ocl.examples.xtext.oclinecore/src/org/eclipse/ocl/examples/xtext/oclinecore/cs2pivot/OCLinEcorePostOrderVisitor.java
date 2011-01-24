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
 * $Id: OCLinEcorePostOrderVisitor.java,v 1.3 2011/01/24 22:28:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.cs2pivot;

import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.util.AbstractExtendingDelegatingOCLinEcoreCSVisitor;

public class OCLinEcorePostOrderVisitor
	extends AbstractExtendingDelegatingOCLinEcoreCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPostOrderVisitor>
{
	protected static class ConstraintCSCompletion extends SingleContinuation<OCLinEcoreConstraintCS>
	{
		public ConstraintCSCompletion(CS2PivotConversion context, OCLinEcoreConstraintCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			context.visitLeft2Right(csElement);
			return null;
		}
	}

	public OCLinEcorePostOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPostOrderVisitor(context), context);
	}

	@Override
	public Continuation<?> visitOCLinEcoreConstraintCS(OCLinEcoreConstraintCS csConstraint) {
		super.visitOCLinEcoreConstraintCS(csConstraint);
		Constraint pivotConstraint = PivotUtil.getPivot(Constraint.class, csConstraint);
		pivotConstraint.setStereotype(csConstraint.getStereotype());
		ExpCS ownedExpression = csConstraint.getOwnedExpression();
		if (ownedExpression != null) {
			return new ConstraintCSCompletion(context, csConstraint);
		}
		else {
			return null;
		}
	}		  
}