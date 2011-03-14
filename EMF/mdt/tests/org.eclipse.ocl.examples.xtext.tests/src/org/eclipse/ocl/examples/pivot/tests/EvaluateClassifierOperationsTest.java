/**
 * <copyright>
 * 
 * Copyright (c) 2009,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   L.Goubet, E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluateClassifierOperationsTest.java,v 1.1 2011/03/12 13:22:51 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.tests;

import org.eclipse.ocl.examples.pivot.messages.OCLMessages;

/**
 * Tests for OclAny operations.
 */
@SuppressWarnings("nls")
public class EvaluateClassifierOperationsTest extends PivotSimpleTestSuite
{
    @Override
    protected void setUp() {
        super.setUp();
        helper.setContext(getMetaclass("Classifier"));
    }

	/**
	 * Tests the allInstances() operator.
	 */
	public void test_allInstances() {
		assertQueryResults(null, "Set{true,false}", "Boolean.allInstances()");
		assertQueryResults(null, "Set{null}", "OclVoid.allInstances()");
		assertQueryResults(null, "Set{}", "pivot::Package.allInstances()");
		assertQueryEquals(pkg1, 8, "pivot::Package.allInstances()->size()");
		helper.setContext(getMetaclass("UnlimitedNatural"));	// FIXME this fudges NavigationOperatorCSScopeAdapter generosity
		assertSemanticErrorQuery("Integer.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Integer");
		assertSemanticErrorQuery("String.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "String");
		assertSemanticErrorQuery("Set(Integer).allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Set(Integer)");
		assertSemanticErrorQuery("OclAny.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "OclAny");
		assertQueryInvalid(null, "OclInvalid.allInstances()");
		// FIXME Subtest-not-implemented Enumeration
	}
	
	/**
	 * Tests the oclContainer() operator.
	 */
	public void test_oclContainer() {
		assertQueryInvalid(pkg2, "invalid.oclContainer()");
		assertQueryInvalid(pkg2, "null.oclContainer()");
		assertQueryResults(pkg1, "null", "oclContainer()");
		assertQueryEquals(pkg2, pkg1, "oclContainer()");
        helper.setContext(getMetaclass("UnlimitedNatural"));	// FIXME this fudges NavigationOperatorCSScopeAdapter generosity
		assertSemanticErrorQuery("1.oclContainer()", OCLMessages.UnresolvedOperation_ERROR_, "oclContainer", "UnlimitedNatural");
	}
	
	/**
	 * Tests the oclContents() operator.
	 */
	public void test_oclContents() {
		assertQueryInvalid(pkg2, "invalid.oclContents()");
		assertQueryInvalid(pkg2, "null.oclContents()");
		assertQueryEquals(pkg1, valueFactory.createSetOf(bob, pkg2, pkg3), "oclContents()");
		assertQueryEquals(pkg2, valueFactory.createSetOf(jim), "oclContents()");
		assertQueryEquals(george, valueFactory.createSetOf(), "oclContents()");
        helper.setContext(getMetaclass("UnlimitedNatural"));	// FIXME this fudges NavigationOperatorCSScopeAdapter generosity
		assertSemanticErrorQuery("1.oclContents()", OCLMessages.UnresolvedOperation_ERROR_, "oclContents", "UnlimitedNatural");
	}
}
