package com.sap.mi.textual.epi.util;

import java.util.Collection;

import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;


/**
 * helper clas for common tasks involving communicating with Moin integration.
 * 
 * @author C5107456
 */
public class MoinIntegrationHelper {

	/**
	 * Instantiates a new moin integration helper.
	 */
    private MoinIntegrationHelper() {
    }
	
	/**
	 * gets a metamodel for the given containername.
	 * 
	 * @param containerName the container name
	 * 
	 * @return the meta model info
	 */
	public static MmDeploymentInfo getMetaModelInfo(String containerName) {
		return MetamodelManager.getInstance().getDeployedMetamodel(containerName);
	}
	
	/**
	 * gets all Metamodels visible using Moin integration utils.
	 * 
	 * @return the visible meta models list
	 */
	public static Collection<MmDeploymentInfo> getVisibleMetaModelsList() {

		return MetamodelManager.getInstance().getDeployedMetamodels();
	}
	
}
