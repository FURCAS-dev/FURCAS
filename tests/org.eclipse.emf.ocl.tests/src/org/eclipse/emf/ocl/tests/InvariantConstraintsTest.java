/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.tests;

import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * Tests support for operation constraints (pre/post/body).
 *
 * @author Christian W. Damus (cdamus)
 */
public class InvariantConstraintsTest extends AbstractTestSuite {

	public InvariantConstraintsTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(InvariantConstraintsTest.class,
			"Invariant Constraints"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple invariant, with a package and classifier context
	 * not using any "self" variable.
	 */
	public void test_simpleInvariant() {
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple invariant, with a package and classifier context
	 * using the "self" variable.
	 */
	public void test_simpleInvariantWithSelf() {
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: self.color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests a very simple invariant, with a package and classifier context
	 * using a named "self" variable.
	 */
	public void test_simpleInvariantNamedSelf() {
		parseConstraint(
			"package ocltest context me : Fruit " + //$NON-NLS-1$
			"inv: me.color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Test a let expression.
	 */
	public void test_simpleInvariantWithLet() {
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: let myColor : Color = self.color in myColor <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
	
	/**
	 * Tests that local variables correctly hide attributes of the context
	 * classifier. 
	 */
	public void test_variablesHidingAttributes() {
		parseConstraint(
			"package ocltest context Fruit " + //$NON-NLS-1$
			"inv: let color : Boolean = (not self.color.oclIsUndefined()) in " + //$NON-NLS-1$
			"  color implies self.color <> Color::black " + //$NON-NLS-1$
			"endpackage"); //$NON-NLS-1$
	}
}
