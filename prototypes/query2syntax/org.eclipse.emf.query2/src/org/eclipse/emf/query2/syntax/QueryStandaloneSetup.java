
package org.eclipse.emf.query2.syntax;


/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class QueryStandaloneSetup extends QueryStandaloneSetupGenerated{

	public static void doSetup() {
		new QueryStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

