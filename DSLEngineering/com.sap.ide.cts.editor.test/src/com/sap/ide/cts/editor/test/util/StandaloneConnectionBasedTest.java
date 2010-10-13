package com.sap.ide.cts.editor.test.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.BeforeClass;

public class StandaloneConnectionBasedTest {

	protected static ResourceSet connection = null;

	@BeforeClass
	public static void setUp() {
		if (connection == null) {
//			connection = MOINTCSMetaConnectionProvider.getTestConnection();
		    	connection = new ResourceSetImpl();
			Resource resource = connection.createResource(URI.createURI("http://some_uri.xmi"));
			connection.getResources().add(resource);
		}
	}

	@After
	public void tearDown() {

//		// should be @After and execute after every test
//		if (connection != null && connection.isAlive()) {
//		    while (connection.getCommandStack( ).isCommandRunning()) {
//			try {
//			    Thread.sleep(100 /*ms*/);
//			} catch (InterruptedException e) {
//			    throw new RuntimeException(e);
//			}
//		    }
//		    connection.revert();
//		}

	}

}
