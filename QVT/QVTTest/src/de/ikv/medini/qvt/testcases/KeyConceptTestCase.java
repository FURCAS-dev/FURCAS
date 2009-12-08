/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

/**
 * Specializes {@link KeyEmulationTestCase} in that it is now tested with the implemented key concept of the engine!
 * 
 * @author kiegeland
 * 
 */
public class KeyConceptTestCase extends KeyEmulationTestCase {

	@Override
	protected void setUp() throws Exception {
		this.qvtFile = "KeyConceptTest.qvt";
		super.setUp();
	}

}
