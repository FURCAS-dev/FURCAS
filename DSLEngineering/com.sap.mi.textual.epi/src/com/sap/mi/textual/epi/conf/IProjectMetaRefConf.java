package com.sap.mi.textual.epi.conf;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import com.sap.furcas.utils.projects.ReferenceScopeBean;



/**
 * Interface for one kind of having a DSL project configured to use a metamodel.
 * 
 * @author C5107456
 */
public interface IProjectMetaRefConf {

	
	/**
	 * stores information to the configuration storage that should allow restoring the configuration from the project later.
	 * 
	 * @param project the project
	 * 
	 * @throws CoreException the core exception
	 */
	public void configureProject(IProject project) throws CoreException;
	
	
	/**
	 * Gets the meta look up for project.
	 * 
	 * @return the meta look up for project
	 * 
	 * @throws CoreException the core exception
	 */
	public ReferenceScopeBean getMetaLookUpForProject() throws CoreException;
}
