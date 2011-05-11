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
 * $Id: IllegalLibraryException.java,v 1.1 2011/05/11 19:45:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

@SuppressWarnings("serial")
public class IllegalLibraryException extends IllegalStateException
{
	public IllegalLibraryException(String string) {
		super(string);
	}
	
	public IllegalLibraryException(String string, Throwable e) {
		super(string, e);
	}
}