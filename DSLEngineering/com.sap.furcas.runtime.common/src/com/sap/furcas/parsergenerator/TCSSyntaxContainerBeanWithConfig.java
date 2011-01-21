package com.sap.furcas.parsergenerator;

import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration;

/**
 * 
 * Data Object to transport a syntax definition the keywords an the configuration used in that
 * syntax.
 * @author siani christian
 *
 */

public class TCSSyntaxContainerBeanWithConfig extends TCSSyntaxContainerBean {
	/*
	 * the configuration defined for an interface
	 */
	private Configuration configuration;
	
	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

}
