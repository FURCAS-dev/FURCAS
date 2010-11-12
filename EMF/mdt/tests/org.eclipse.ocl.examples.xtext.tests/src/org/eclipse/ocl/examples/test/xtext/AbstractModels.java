/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.xtext;

import java.io.File;
import java.net.URL;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;

/**
 * Supports loading model files.
 * <p>
 * A derived class with a singleton INSTANCE, may provide the URI of
 * a model within its folder using getURI().
 */
public class AbstractModels extends XtextTestCase
{
	public URI getURI(String modelName) {
		String projectName = getClass().getPackage().getName();
		String fileName = projectName.replace('.', '/') + "/" + modelName;
		URL fileURL = getTestResource(fileName);
		if (fileURL == null) {
			TestCase.fail("Missing file '" + fileName + "'");
			return null;
		}
		File file = new File(fileURL.getFile());
		URI uri = URI.createFileURI(file.toString());
		if (uri == null)
			fail("Cannot create URI for '" + file.toString() + "'");
		return uri;
	}
}
