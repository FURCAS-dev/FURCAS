package com.sap.mi.textual.epi.conf;

import java.io.IOException;
import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;

import com.sap.mi.textual.epi.Activator;
import com.sap.mi.textual.epi.Constants;
import com.sap.mi.textual.epi.util.ExceptionHelper;



/**
 * configures a project to use a deployed metamodel as reference.
 * 
 * @author C5107456
 */
public final class DeployedMetaProjectConf implements IProjectMetaRefConf {




	/** The meta info. */
	private String containerName;
	private final IProject configuredProject;

	/**
	 * Instantiates a new deployed meta project conf.
	 * @param project 
	 * 
	 * @param metaInfo the meta info
	 * 
	 * @throws CoreException the core exception
	 */
	public DeployedMetaProjectConf(String containerName, IProject project) {
		this.configuredProject = project;
		if (containerName == null) {
			throw new IllegalArgumentException("MetaModelInfo may not be null");
		}
		this.containerName = containerName;
	}
	

	/* (non-Javadoc)
	 * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#configureProject(org.eclipse.core.resources.IProject)
	 */
	public void configureProject(IProject project) throws CoreException {
		ProjectPropertiesStorageHelper.setProperty(project, Constants.DEPLOYED_METAMODEL_CONTAINER_NAME_KEY, containerName);
	}

	
	/* (non-Javadoc)
	 * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#getMetaLookUpForProject()
	 */
	public ReferenceScopeBean getMetaLookUpForProject() throws CoreException {

		try {
			ResourceSet connection = null;
			if(configuredProject != null && ModelManager.getInstance().isMoinProject(configuredProject)) {
				connection = ModelManager.getConnectionManager().getDefaultConnection(configuredProject);
			}else {
				connection = ConnectionManager.getInstance().createTransientConnection();
			}
		    HashSet<URI> newPRIs = getPRIs();
		    return new ReferenceScopeBean(connection, newPRIs);

		} catch (IOException e) {
			throw new CoreException(new Status(Status.ERROR,Activator.PLUGIN_ID, "IOException while trying to build a metamodelLookup for deployed metamodel " + containerName, e));
		}
	}


    /**
     * @return
     * @throws IOException
     * @throws CoreException 
     */
    private HashSet<URI> getPRIs() throws IOException, CoreException {
        HashSet<URI> newPRIs = null;
        Moin moin = MoinFactory.getMoinInstance();
        if ("sap.com/tc/moin/mof_1.4".equals(containerName)) {
          
            newPRIs = new HashSet<URI>();
            URI pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
            newPRIs.add(pri);
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/OCL.moinmm");
            newPRIs.add(pri);
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
            newPRIs.add(pri); 
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/CorbaIdlTypes.moinmm");
            newPRIs.add(pri); 
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Reflect.moinmm");
            newPRIs.add(pri); 
            pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/MOIN.moinmm");
            newPRIs.add(pri); 
        } else {
            MmDeploymentInfo mm = MetamodelManager.getInstance().getDeployedMetamodel(containerName);
            if (mm != null) {
                newPRIs = new HashSet<URI>(mm.getPRIs());
                URI pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
                newPRIs.add(pri);
                pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
                newPRIs.add(pri); 
            } else {
                throw new CoreException(new Status(Status.ERROR, Activator.PLUGIN_ID, "Metamodel Manager could not resolve metamodel: " + containerName + " configured in DSL Engineering nature." ));
            }
        }
        return newPRIs;
    }

	/**
	 * Gets the configuration from project.
	 * 
	 * @param project the project
	 * 
	 * @return the configuration from project
	 * 
	 * @throws CoreException the core exception
	 */
	public static IProjectMetaRefConf getConfigurationFromProject(
			IProject project) throws CoreException {
		String containerName = ProjectPropertiesStorageHelper.getProperty(project, Constants.DEPLOYED_METAMODEL_CONTAINER_NAME_KEY);
		if (containerName == null) {
			throw new CoreException(ExceptionHelper.getErrorStatus("Container name not configured for DSL Nature in project " + project.getName()));
		}
//		MetaModelInfo metaInfo = MoinIntegrationHelper.getMetaModelInfo(containerName);
//		if (metaInfo == null) {
//			throw new CoreException(ExceptionHelper.getErrorStatus("Container name " + containerName + " did not return MetaModelInfo for DSL nature of project " + project.getName()));
//		}
		return new DeployedMetaProjectConf(containerName, project);
	}


	/**
	 * Gets the container name.
	 * 
	 * @return the container name
	 */
	public String getContainerName() {
		return containerName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DeployedMetaProjectConf) {
			DeployedMetaProjectConf other = (DeployedMetaProjectConf) obj;
			if (other.getContainerName().equals(this.getContainerName())) {
				return true;
			}
		}
		return false;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getContainerName().hashCode();
	}
	

}
