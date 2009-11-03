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

package de.ikv.medini.ocl20.bridge4medini.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.constraint.ConstraintTestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.error.ErrorSuite;
import de.ikv.medini.ocl20.bridge4medini.test.exp.ExpTestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.lib.LibSuite;
import de.ikv.medini.ocl20.bridge4medini.test.lib.PredefinedPropertiesOnAllObjectsTestCase;
import de.ikv.medini.ocl20.bridge4medini.test.lib.collections.OclBagTestCase;
import de.ikv.medini.ocl20.bridge4medini.test.lib.collections.OclOrderedSetTestCase;
import de.ikv.medini.ocl20.bridge4medini.test.lib.collections.OclSequenceTestCase;
import de.ikv.medini.ocl20.bridge4medini.test.lib.collections.OclSetTestCase;

public class OclInterpreterTestSuite {

	public static Test suite() {

		TestSuite suite = new TestSuite("Test for de.ikv.medini.ocl20.bridge4medini.test");
		// $JUnit-BEGIN$
		suite.addTest(LibSuite.suite());
		suite.addTest(ConstraintTestSuite.suite());
		suite.addTest(ErrorSuite.suite());
		suite.addTest(ExpTestSuite.suite());

		suite.addTestSuite(OclBagTestCase.class);
		suite.addTestSuite(OclOrderedSetTestCase.class);
		suite.addTestSuite(OclSequenceTestCase.class);
		suite.addTestSuite(OclSetTestCase.class);
		suite.addTestSuite(PredefinedPropertiesOnAllObjectsTestCase.class);

		// $JUnit-END$
		return suite;
	}

}
