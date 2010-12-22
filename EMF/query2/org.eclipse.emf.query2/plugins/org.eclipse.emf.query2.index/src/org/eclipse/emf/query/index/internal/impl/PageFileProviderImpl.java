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
package org.eclipse.emf.query.index.internal.impl;

import java.io.File;

import org.eclipse.emf.query.index.Messages;
import org.eclipse.emf.query.index.internal.PageFileProvider;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class PageFileProviderImpl implements PageFileProvider {

	private final String basePath;

	public PageFileProviderImpl(String pagePath) {
		this.basePath = pagePath;
	}

	public File getInputFile(String id) {
		return this.getFileForElement(id);
	}

	public File getOutputFile(String id) {
		return this.getFileForElement(id);
	}

	private File getFileForElement(String id) {
		if (basePath == null) {
			throw new IllegalStateException(Messages.Query2Index_PageFileProviderImpl_BasePathNotSet);
		}
		String path = basePath + id.replace(':', '_').replace('/', '_') + ".page"; //$NON-NLS-1$
		File file = new File(path);
		return file;
	}
}
