/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ValidationWarning.java,v 1.3 2011/05/07 16:41:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.osgi.util.NLS;

public class ValidationWarning extends BasicDiagnostic
{
	public ValidationWarning(String messageTemplate, Object... bindings) {
		super(OCLMessages.Validation, WARNING, NLS.bind(messageTemplate, bindings), null);
	}
}