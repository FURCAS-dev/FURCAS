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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.common.label.ILabelGenerator;
import org.eclipse.ocl.examples.common.label.LabelGeneratorRegistry;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
//import org.eclipse.ocl.examples.common.utils.DebugString;

public class LabelTests extends TestCase
{
	protected ILabelGenerator.Registry registry = new LabelGeneratorRegistry(ILabelGenerator.Registry.INSTANCE);
	
	@Override
	public void setUp() {
		if (!AllLabelTests.eclipseIsRunning()) {
			LabelGeneratorRegistry.initialize(registry);
		}
	}
	
/*	public void testEcoreURIDebugLabel() {
		String testURI = "http://xyzzy/jj";
		URI uri = URI.createURI(testURI);
		String actualLabel = DebugString.debugLabelFor(uri);
		String expectedLabel = "'" + testURI + "'";
		assertEquals(expectedLabel, actualLabel);
	} */
	
	public void testEcoreURILabel() {
		String testURI = "http://xyzzy/jj";
		URI uri = URI.createURI(testURI);
		String actualLabel = registry.labelFor(uri);
		String expectedLabel = testURI;
		assertEquals(expectedLabel, actualLabel);
	}
	
	public void testEcoreFeatureLabel() {
		String actualLabel = registry.labelFor(EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		String expectedLabel = "ecore/ENamedElement/name";
		assertEquals(expectedLabel, actualLabel);
	}
	
	public void testEcoreFeatureQualifiedName() {
		String actualLabel = EcoreUtils.qualifiedNameFor(EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		String expectedLabel = "ecore::ENamedElement::name";
		assertEquals(expectedLabel, actualLabel);
	}
	
	public void testEcoreFeatureName() {
		String actualLabel = EcoreUtils.simpleNameFor(EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		String expectedLabel = "name";
		assertEquals(expectedLabel, actualLabel);
	}
	
/*	public void testEcoreFeatureDebugLabel() {
		String actualLabel = DebugString.debugLabelFor(EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		String expectedLabel = "ecore/ENamedElement/name";
		assertEquals(expectedLabel, actualLabel);
	} */
}
