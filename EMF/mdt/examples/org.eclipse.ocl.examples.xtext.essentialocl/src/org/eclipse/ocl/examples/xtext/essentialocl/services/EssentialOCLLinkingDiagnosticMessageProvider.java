/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: EssentialOCLLinkingDiagnosticMessageProvider.java,v 1.1 2011/02/11 20:00:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;

public class EssentialOCLLinkingDiagnosticMessageProvider extends LinkingDiagnosticMessageProvider
{
	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		EObject csContext = context.getContext();
		String linkText = context.getLinkText();
		EReference eReference = context.getReference();
		return CS2Pivot.getUnresolvedProxyMessage(eReference, csContext, linkText);
	}
}
