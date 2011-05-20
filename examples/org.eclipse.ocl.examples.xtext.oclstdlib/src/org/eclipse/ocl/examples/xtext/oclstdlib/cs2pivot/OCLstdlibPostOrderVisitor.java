/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: OCLstdlibPostOrderVisitor.java,v 1.7 2011/05/20 15:27:10 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.cs2pivot;

import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.AbstractExtendingDelegatingOCLstdlibCSVisitor;

public class OCLstdlibPostOrderVisitor
	extends AbstractExtendingDelegatingOCLstdlibCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPostOrderVisitor>
{		
	public OCLstdlibPostOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPostOrderVisitor(context), context);
	}

/*	@Override
	public Continuation<?> visitLibIterationCS(LibIterationCS csIteration) {
		Operation pivotElement = PivotUtil.getPivot(Iteration.class, csIteration);
//		pivotElement.setPrecedence(csIteration.getPrecedence());
//		pivotElement.setIsStatic(csIteration.isStatic());
		JvmType implementation = csIteration.getImplementation();
		if (implementation != null) {
			pivotElement.setImplementationClass(implementation.getIdentifier());
		}
		return super.visitLibIterationCS(csIteration);
	} */

/*	@Override
	public Continuation<?> visitLibOperationCS(LibOperationCS csOperation) {
		Operation pivotElement = PivotUtil.getPivot(Operation.class, csOperation);
		return super.visitLibOperationCS(csOperation);
	} */

/*	@Override
	public Continuation<?> visitLibPropertyCS(LibPropertyCS csProperty) {
		Property pivotElement = PivotUtil.getPivot(Property.class, csProperty);
		pivotElement.setIsStatic(csProperty.isStatic());
		JvmType implementation = csProperty.getImplementation();
		if (implementation != null) {
			pivotElement.setImplementationClass(implementation.getIdentifier());
		}
		return super.visitLibPropertyCS(csProperty);
	} */

	@Override
	public Continuation<?> visitPrecedenceCS(PrecedenceCS csPrecedence) {
		return null;
	}
}