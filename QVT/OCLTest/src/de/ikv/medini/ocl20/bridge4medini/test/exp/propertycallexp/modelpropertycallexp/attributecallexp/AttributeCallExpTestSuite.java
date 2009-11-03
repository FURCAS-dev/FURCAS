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

package de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.modelpropertycallexp.attributecallexp;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AttributeCallExpTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for de.ikv.medini.ocl20.bridge4medini.test.exp.propertycallexp.modelpropertycallexp.attributecallexp");
		// $JUnit-BEGIN$
		suite.addTestSuite(FloatAttributeTestCase.class);
		suite.addTestSuite(EnumerationAttributeTestCase.class);
		suite.addTestSuite(DoubleAttributeTestCase.class);
		// suite.addTestSuite(PrimitiveAttributeTestCase.class);
		suite.addTestSuite(BooleanAttributeTestCase.class);
		suite.addTestSuite(StaticFloatAttributeTestCase.class);
		suite.addTestSuite(StaticIntegerAttributeTestCase.class);
		suite.addTestSuite(IntegerAttributeTestCase.class);
		// suite.addTestSuite(DataTypeAttributeTestCase.class);
		suite.addTestSuite(LongAttributeTestCase.class);
		suite.addTestSuite(StringAttributeTestCase.class);
		suite.addTestSuite(StaticDoubleAttributeTestCase.class);
		suite.addTestSuite(StructureAttributeTestCase.class);
		suite.addTestSuite(StaticBooleanAttributeTestCase.class);
		suite.addTestSuite(StaticLongAttributeTestCase.class);
		// $JUnit-END$
		return suite;
	}

}
