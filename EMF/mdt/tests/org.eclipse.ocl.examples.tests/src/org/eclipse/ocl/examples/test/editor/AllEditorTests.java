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
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AllEditorTests.java,v 1.4 2010/04/25 06:50:09 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.ocl.examples.test.AllExamplesTests;

public class AllEditorTests extends TestCase
{
	public static void buildSuite(TestSuite suite) {
		if (AllExamplesTests.eclipseIsRunning()) {
//			suite.addTestSuite(OCLInEcoreResourceTests.class);
//			suite.addTestSuite(OCLResourceTests.class);
		}
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All Editor Tests");
		buildSuite(suite);
		return suite;
	}
}
