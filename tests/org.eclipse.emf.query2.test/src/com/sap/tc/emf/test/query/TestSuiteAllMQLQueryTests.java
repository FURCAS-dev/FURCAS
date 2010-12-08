/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package com.sap.tc.emf.test.query;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { TestIndexQueryService.class, TestQuerySpreading.class,
		TestSuiteSyntheticWithNoSchedulingQueryTests.class, // formatting
		TestSuiteSyntheticInMemoryForCst.class, TestSuiteSyntheticWithSchedulingQueryTests.class, TestSuiteCompanyQueryTests.class,
		TestSuiteNegativeQueryTests.class, TestSuiteSmokeQueryTests.class, //
		//TestHasCrossPartitionLinks.class,
		TestQueryRegression.class,TestQueryBugs.class })
public class TestSuiteAllMQLQueryTests extends QueryTestCase {

}
