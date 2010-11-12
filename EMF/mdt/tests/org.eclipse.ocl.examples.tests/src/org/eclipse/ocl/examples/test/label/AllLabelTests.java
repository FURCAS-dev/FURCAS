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

import java.lang.reflect.Method;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllLabelTests extends TestCase
{
	public static void buildSuite(TestSuite suite) {
		suite.addTestSuite(LabelTests.class);
		if (eclipseIsRunning()) {
			suite.addTestSuite(PluginLabelTests.class);
		}
		else {
			suite.addTestSuite(StandaloneLabelTests.class);
		}
	}

	public static boolean eclipseIsRunning() {
		try {
			Class<?> platformClass = Class.forName("org.eclipse.core.runtime.Platform");
			Method isRunningMethod = platformClass.getDeclaredMethod("isRunning");
			return Boolean.TRUE.equals(isRunningMethod.invoke(null));
		} catch (Exception e) {
		}
		return false;
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All Label Tests");
		buildSuite(suite);
		return suite;
	}
}
