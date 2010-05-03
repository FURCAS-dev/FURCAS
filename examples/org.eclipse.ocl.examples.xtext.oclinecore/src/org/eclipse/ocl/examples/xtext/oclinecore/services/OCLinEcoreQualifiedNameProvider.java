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
 * $Id: OCLinEcoreQualifiedNameProvider.java,v 1.1 2010/05/03 05:44:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.services;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;

public class OCLinEcoreQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider
{
	@Override
	public String getDelimiter() {
		return "::";
	}
}
