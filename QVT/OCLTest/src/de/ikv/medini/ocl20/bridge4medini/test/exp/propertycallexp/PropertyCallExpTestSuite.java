/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp;

import de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.loopexp.LoopExpTestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.modelpropertycallexp.ModelPropertyCallExpTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class PropertyCallExpTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp");
		// $JUnit-BEGIN$
		suite.addTest(LoopExpTestSuite.suite());
		suite.addTest(ModelPropertyCallExpTestSuite.suite());
		// $JUnit-END$
		return suite;
	}

}
