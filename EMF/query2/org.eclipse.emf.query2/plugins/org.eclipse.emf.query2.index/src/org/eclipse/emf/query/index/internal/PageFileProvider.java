/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.internal;

import java.io.File;
/**
 * Represent provider that give the file to read and write PageableElement to file(s)
 * 
 */
public interface PageFileProvider {

	public File getOutputFile(String id);

	public File getInputFile(String id);
}
