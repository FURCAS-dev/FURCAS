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
 * $Id: ValidationDiagnostic.java,v 1.1 2011/02/11 20:59:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.nodemodel.INode;

public class ValidationDiagnostic extends AbstractDiagnostic
{
	protected final INode node;
	protected final String message;
	
	public ValidationDiagnostic(INode node, String message) {
		this.node = node;
		this.message = message;
	}

	@Override
	public String getCode() {
		return "FIXME-ValidationDiagnostic-CODE";
	}

	@Override
	public String[] getData() {
		return null;
	}		

	public String getMessage() {
		return message;
	}

	@Override
	protected INode getNode() {
		return node;
	}
}