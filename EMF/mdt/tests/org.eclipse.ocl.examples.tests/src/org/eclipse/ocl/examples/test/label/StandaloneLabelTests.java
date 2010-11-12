/*******************************************************************************
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.test.label;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.common.label.ILabelGenerator;
import org.eclipse.ocl.examples.common.label.LabelGeneratorRegistry;
import org.eclipse.ocl.examples.common.label.generators.EcoreURILabelGenerator;

public class StandaloneLabelTests extends TestCase
{
	public void testEcoreURILabel() {
		String testURI = "http://xyzzy/jj";
		URI uri = URI.createURI(testURI);
		ILabelGenerator.Registry myRegistry = new LabelGeneratorRegistry(ILabelGenerator.Registry.INSTANCE);
		String actualLabel = myRegistry.labelFor(uri);
		String expectedLabel = "<unknown-URI " + testURI + ">";
		assertEquals(expectedLabel, actualLabel);
		
		EcoreURILabelGenerator.initialize(myRegistry);
		actualLabel = myRegistry.labelFor(uri);
		expectedLabel = testURI;
		assertEquals(expectedLabel, actualLabel);
		
		EcoreURILabelGenerator.initialize(ILabelGenerator.Registry.INSTANCE);
		actualLabel = myRegistry.labelFor(uri);
		expectedLabel = testURI;
		assertEquals(expectedLabel, actualLabel);
		
		myRegistry.uninstall(URI.class.getName());
		actualLabel = myRegistry.labelFor(uri);
		expectedLabel = testURI;
		assertEquals(expectedLabel, actualLabel);
		
		ILabelGenerator.Registry.INSTANCE.uninstall(URI.class.getName());
		actualLabel = myRegistry.labelFor(uri);
		expectedLabel = "<unknown-URI " + testURI + ">";
		assertEquals(expectedLabel, actualLabel);
	}
}
