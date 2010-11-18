/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.eventManager.tests;

import de.hpi.sam.bp2009.solution.eventManager.tests.framework.CompositeSetTest;
import de.hpi.sam.bp2009.solution.eventManager.tests.framework.IncludeSubclassesTest;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>eventManager</b></em>' package.
 * <!-- end-user-doc -->
 */
public class EventManagerTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public static Test suite() {
		TestSuite suite = new EventManagerTests("eventManager Tests");
		suite.addTestSuite(EventManagerTest.class);
		suite.addTestSuite(EventTypeFilterTest.class);
		suite.addTestSuite(AndFilterTest.class);
		suite.addTestSuite(OrFilterTest.class);
		suite.addTestSuite(ClassFilterTest.class);
		suite.addTestSuite(AttributeFilterTest.class);
		suite.addTestSuite(AssociationFilterTest.class);
		suite.addTestSuite(OldValueClassFilterTest.class);
		suite.addTestSuite(OldValueClassIncludingSubclassesFilterTest.class);
		suite.addTestSuite(NewValueClassFilterTest.class);
		suite.addTestSuite(NewValueClassIncludingSubclassesFilterTest.class);
		suite.addTestSuite(ContainmentFilterTest.class);
		suite.addTestSuite(IncludeSubclassesTest.class);
		suite.addTestSuite(CompositeSetTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EventManagerTests(String name) {
		super(name);
	}

} //EventManagerTests
