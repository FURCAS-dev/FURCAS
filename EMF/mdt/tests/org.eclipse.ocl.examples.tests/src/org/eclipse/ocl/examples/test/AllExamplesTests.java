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
 * $Id: AllExamplesTests.java,v 1.2 2010/04/25 06:50:09 ewillink Exp $
 */
package org.eclipse.ocl.examples.test;

import java.lang.reflect.Method;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.ocl.examples.test.editor.AllEditorTests;
import org.eclipse.ocl.examples.test.label.AllLabelTests;
import org.eclipse.ocl.examples.test.modelregistry.AllRegistryTests;

public class AllExamplesTests extends TestCase
{
	public static void buildSuite(TestSuite suite) {
		AllLabelTests.buildSuite(suite);
		AllRegistryTests.buildSuite(suite);
		if (eclipseIsRunning()) {
			AllEditorTests.buildSuite(suite);
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
		TestSuite suite = new TestSuite("All Examples Tests");
		buildSuite(suite);
		return suite;
	}
}
