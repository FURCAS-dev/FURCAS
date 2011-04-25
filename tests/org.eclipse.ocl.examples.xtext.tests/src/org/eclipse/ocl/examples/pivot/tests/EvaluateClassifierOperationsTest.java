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
 * $Id: EvaluateClassifierOperationsTest.java,v 1.4 2011/04/25 09:49:25 ewillink Exp $
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
		assertQueryResults(null, "Set{CollectionKind::Bag,CollectionKind::Collection,CollectionKind::_'OrderedSet',CollectionKind::_'Sequence',CollectionKind::_'Set'}", "CollectionKind.allInstances()");
		assertQueryResults(null, "Set{true,false}", "Boolean.allInstances()");
		assertQueryResults(null, "Set{null}", "OclVoid.allInstances()");
		assertQueryResults(null, "Set{}", "ocl::Package.allInstances()");
		assertQueryEquals(pkg1, 8, "Package.allInstances()->size()");
		assertSemanticErrorQuery("Integer.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Integer type");
		assertSemanticErrorQuery("String.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "String type");
		assertSemanticErrorQuery("Set(Integer).allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Set<Integer> type");
		assertSemanticErrorQuery("Tuple(a:Integer).allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Tuple(a:Integer) type");
		assertSemanticErrorQuery("OclAny.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "OclAny type");
		assertSemanticErrorQuery("4.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "UnlimitedNatural value");
		assertSemanticErrorQuery("true.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Boolean value");
		assertSemanticErrorQuery("Set{1}.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Set<UnlimitedNatural> value");
		assertSemanticErrorQuery("Tuple{a:Integer=1}.allInstances()", OCLMessages.UnresolvedOperation_ERROR_, "allInstances", "Tuple(a:Integer) value");
		assertQueryInvalid(null, "OclInvalid.allInstances()");
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
		assertSemanticErrorQuery("1.oclContainer()", OCLMessages.UnresolvedOperation_ERROR_, "oclContainer", "UnlimitedNatural value");
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
		assertSemanticErrorQuery("1.oclContents()", OCLMessages.UnresolvedOperation_ERROR_, "oclContents", "UnlimitedNatural value");
	}
}
