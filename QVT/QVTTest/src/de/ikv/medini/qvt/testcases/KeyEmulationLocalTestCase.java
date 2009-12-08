/**
 * Copyright (c) 2007 ikv++ technologies ag
 * All Rights Reserved
 */
package de.ikv.medini.qvt.testcases;

/**
 * Specializes {@link KeyEmulationTestCase} in that KeyEmulationLocal.qvt is used instead of KeyEmulation.qvt, to test local relations, which do not require artificial primary key
 * source domains. The local-relations-feature can be turned off at <code>Trace.enforcePrimaryKey</code>.
 * 
 * @author kiegeland
 * 
 */
public class KeyEmulationLocalTestCase extends KeyEmulationTestCase {

	@Override
	protected void setUp() throws Exception {
		this.qvtFile = "KeyEmulationLocal.qvt";
		super.setUp();
	}

}
