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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import junit.framework.TestCase;

public abstract class MediniTestCase extends TestCase {

	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	private boolean hasFailed = false;

	private Throwable hasFailedThrowable;

	/**
	 * Loads the properties from a given file either bundled as a resource with the <code>callerClass</code> class or not. An attempt is first made to load the properties from
	 * the file bundled as a resource. If not found the properties are loaded from the file system.
	 * 
	 * @param callerClass
	 *            the class invoking this method.
	 * @param propertiesFileName
	 *            the property file name.
	 * @return the loaded properties.
	 * @throws Exception
	 *             if an error occurs.
	 */
	public static Properties loadProperties(Class callerClass, String propertiesFileName) throws Exception {

		Properties properties = new Properties();
		InputStream is = callerClass.getResourceAsStream(propertiesFileName);

		if (is != null) {
			properties.load(is);
		} else {
			File propertiesFile = new File(propertiesFileName);
			if (propertiesFile.exists()) {
				properties.load(new FileInputStream(propertiesFile));
			} else {
				String relativePath = System.getProperty("user.dir");
				propertiesFile = new File(relativePath + MediniTestCase.FILE_SEPARATOR + propertiesFileName);
				properties.load(new FileInputStream(propertiesFile));
			}
		}

		return properties;
	}

	/**
	 * Runs the test case and collects the results in TestResult.
	 */
	@Override
	protected void runTest() throws Throwable {
		try {
			super.runTest();
		} catch (Throwable throwable) {
			this.hasFailed = true;
			this.hasFailedThrowable = throwable;
			throw throwable;
		}
	}

	/**
	 * The test-specific properties. It must be initialized by the subclass as stated above.
	 */
	private Properties testSpecificProperties;

	protected Properties getProperties() {
		return this.testSpecificProperties;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.loadProperties("config/testing.properties");

	}

	@Override
	protected void tearDown() throws Exception {
		this.testSpecificProperties = null;
		super.tearDown();
		if (this.hasFailed) {
			this.createTestFailureFile();
		}
	}

	/**
	 * Creates a file to indicate a test case failure
	 * 
	 * @throws IOException
	 */
	protected void createTestFailureFile() throws IOException {
		String testReportDirectory = this.getProperty("testreport.dir");
		if (testReportDirectory != null) {
			File failureFile = new File(testReportDirectory + this.getProperty("file.separator") + "testfailed.txt");
			failureFile.createNewFile();
		}
	}

	protected void loadProperties(String propertiesFileName) {
		try {
			this.testSpecificProperties = MediniTestCase.loadProperties(this.getClass(), propertiesFileName);
		} catch (Throwable e) {
			this.testSpecificProperties = null;
			// use system properties instead
		}
	}

	protected String getProperty(String key) {
		if (this.testSpecificProperties != null) {
			String result = this.testSpecificProperties.getProperty(key);
			if (result != null) {
				return result;
			}
		}
		return System.getProperty(key);
	}

}
