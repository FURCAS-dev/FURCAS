package com.sap.mi.fwk.test.service;

import junit.framework.TestSuite;


/**
 * Test suite that calls {@link DisposableTest#dispose()} for all such tests
 * when it is teared down. Useful for scenarios where allocated resources, e.g.
 * projects, should be upheld until the whole suite finishes.
 * 
 * @author d031150
 */
public class DisposingTestSuite extends TestSuite {

	/**
	 * @see TestSuite#TestSuite()
	 */
	public DisposingTestSuite() {
		super();
	}

	/**
	 * @see TestSuite#TestSuite(String)
	 */
	public DisposingTestSuite(String name) {
		super(name);
	}

	/**
	 * @see TestSuite#TestSuite(Class)
	 */
	public DisposingTestSuite(Class clazz) {
		super(clazz);
	}

	/**
	 * @see TestSuite#TestSuite(Class, String)
	 */
	public DisposingTestSuite(Class clazz, String name) {
		super(clazz, name);
	}

	@Override
	protected void tearDown() throws Exception {
		try {
			TestUtil.disposeTests(this);
		} finally {
			super.suiteTearDown();
		}
	}

}
