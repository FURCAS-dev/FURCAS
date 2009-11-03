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

package de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp;

import de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.collectionliteralexp.CollectionLiteralExpTestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.enumliteralexp.EnumLiteralExpTestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.primitiveliteralexp.PrimitiveLiteralExpTestSuite;
import de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp.tupleliteralexp.TupleLiteralExpTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class LiteralExpTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for de.ikv.medini.ocl20.bridge4medini.test.exp.literalexp");
		//$JUnit-BEGIN$
		suite.addTest(TupleLiteralExpTestSuite.suite());
		suite.addTest(PrimitiveLiteralExpTestSuite.suite());		
		suite.addTest(EnumLiteralExpTestSuite.suite());		
		suite.addTest(CollectionLiteralExpTestSuite.suite());		
		//$JUnit-END$
		return suite;
	}

}
