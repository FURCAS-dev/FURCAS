package com.sap.mi.fwk.test.service;

import junit.framework.Test;

/**
 * Test that is called to dispose allocated resources
 *
 * @author d031150
 */
public interface DisposableTest extends Test {
	
	/**
	 * Dispose all resources that are currently allocated
	 * 
	 * @throws Exception if disposal failed
	 */
	void dispose() throws Exception;

}
