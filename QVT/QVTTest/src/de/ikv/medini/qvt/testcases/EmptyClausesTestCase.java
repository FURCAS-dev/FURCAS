/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

import java.io.FileNotFoundException;

import de.ikv.medini.qvt.test.QVTTestCase;

/**
 * Test a relation with empty when/where clauses
 * 
 * @author kiegeland
 * 
 */
public class EmptyClausesTestCase extends QVTTestCase {

	public void testExtension() throws FileNotFoundException {
		this.checkTraces("EmptyClausesTestCase.qvt", "emptyClauses", "forward", "backward", 2/* two elements must be created! */);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.createModelElement(this.META_UMLInterface);
		this.createModelElement(this.META_UMLInterface);
	}

}
