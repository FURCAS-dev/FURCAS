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
 * $Id: LibraryDiagnostic.java,v 1.1 2011/05/11 19:49:38 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;

public class LibraryDiagnostic extends ExceptionDiagnostic
{
	public LibraryDiagnostic(Exception exception) {
		super(exception);
	}

	@Override
	public String getMessage() {
		return getException().getMessage();
	}
}