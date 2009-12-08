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

package de.ikv.medini.qvt.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import de.ikv.medini.qvt.execution.QvtSemanticAnalyserThreadPool;
import de.ikv.medini.qvt.testcases.AbstractClassTestCase;
import de.ikv.medini.qvt.testcases.AddFeatureTestCase;
import de.ikv.medini.qvt.testcases.BindOrCreateTestCase;
import de.ikv.medini.qvt.testcases.BindSubclassInWhereClauseTestCase;
import de.ikv.medini.qvt.testcases.DebugTestCase;
import de.ikv.medini.qvt.testcases.DeleteTestCase;
import de.ikv.medini.qvt.testcases.EmptyClausesTestCase;
import de.ikv.medini.qvt.testcases.ImportTestCase;
import de.ikv.medini.qvt.testcases.InPlaceTestCase;
import de.ikv.medini.qvt.testcases.KeyConceptTestCase;
import de.ikv.medini.qvt.testcases.KeyEmulationLocalTestCase;
import de.ikv.medini.qvt.testcases.KeyEmulationTestCase;
import de.ikv.medini.qvt.testcases.MultipleDomainsAndMultipleSourceModelsTestCase;
import de.ikv.medini.qvt.testcases.MultipleDomainsTestCase;
import de.ikv.medini.qvt.testcases.NestedRelationCallTestCase;
import de.ikv.medini.qvt.testcases.OclAllInstancesTestCase;
import de.ikv.medini.qvt.testcases.OrderingTestCase;
import de.ikv.medini.qvt.testcases.PrimitiveDomainTestCase;
import de.ikv.medini.qvt.testcases.RandomActivityUITestCase;
import de.ikv.medini.qvt.testcases.RandomTestCase;
import de.ikv.medini.qvt.testcases.RuleChangeTestCase;
import de.ikv.medini.qvt.testcases.SetTestCase;
import de.ikv.medini.qvt.testcases.SimpleKeyConceptTestCase;

public class QVTTestSuite {

	public static Test suite() {

		TestSuite suite = new TestSuite("Test for QVT");
		// $JUnit-BEGIN$

		suite.addTestSuite(ImportTestCase.class);
		suite.addTestSuite(NestedRelationCallTestCase.class);
		suite.addTestSuite(PrimitiveDomainTestCase.class);
		suite.addTestSuite(RuleChangeTestCase.class);
		suite.addTestSuite(DeleteTestCase.class);
		suite.addTestSuite(OrderingTestCase.class);
		suite.addTestSuite(KeyConceptTestCase.class);
		if (QvtSemanticAnalyserThreadPool.CAN_REACTIVATE_FAILED_TASKS) {
			suite.addTestSuite(KeyEmulationTestCase.class);
			suite.addTestSuite(KeyEmulationLocalTestCase.class);
		}
		suite.addTestSuite(MultipleDomainsTestCase.class);
		suite.addTestSuite(MultipleDomainsAndMultipleSourceModelsTestCase.class);
		suite.addTestSuite(DebugTestCase.class);
		suite.addTestSuite(AddFeatureTestCase.class);
		suite.addTestSuite(InPlaceTestCase.class);
		suite.addTestSuite(BindSubclassInWhereClauseTestCase.class);
		suite.addTestSuite(OclAllInstancesTestCase.class);
		suite.addTestSuite(EmptyClausesTestCase.class);
		suite.addTestSuite(SimpleKeyConceptTestCase.class);
		suite.addTestSuite(RandomTestCase.class);
		suite.addTestSuite(RandomActivityUITestCase.class);
		suite.addTestSuite(AbstractClassTestCase.class);
		suite.addTestSuite(SetTestCase.class);
		suite.addTestSuite(BindOrCreateTestCase.class);

		// $JUnit-END$
		return suite;
	}

}
