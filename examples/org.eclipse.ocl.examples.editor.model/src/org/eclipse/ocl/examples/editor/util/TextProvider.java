/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TextProvider.java,v 1.1 2010/03/11 11:49:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.util;

public interface TextProvider 
{
	public String getText(Object object);
}
