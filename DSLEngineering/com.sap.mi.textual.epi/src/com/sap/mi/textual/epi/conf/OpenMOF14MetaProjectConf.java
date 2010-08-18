package com.sap.mi.textual.epi.conf;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.textual.epi.Constants;
import com.sap.mi.textual.epi.util.ExceptionHelper;



/**
 * configures a project to use an open MOF14 metamodel as reference.
 * 
 * @author C5107456
 */
public final class OpenMOF14MetaProjectConf implements IProjectMetaRefConf {

	/** The referenced project. */
	private IProject referencedProject;

	/**
	 * Instantiates a new open mo f14 meta project conf.
	 * 
	 * @param referencedProject the referenced project
	 * 
	 * @throws CoreException the core exception
	 */
	public OpenMOF14MetaProjectConf(IProject referencedProject) {
		this.referencedProject = referencedProject;
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
	public static OpenMOF14MetaProjectConf getConfigurationFromProject(IProject project) throws CoreException {
		String projectName = ProjectPropertiesStorageHelper.getProperty(project, Constants.REFERRED_PROJECT_NAME_KEY);
		if (projectName == null || projectName.trim().equals("")) {
            throw new CoreException(ExceptionHelper.getErrorStatus("Project "
                    + project.getName() + " not configured for use with "
                    + OpenMOF14MetaProjectConf.class.getName()));
        }
        IProject referencedProject = project.getWorkspace().getRoot()
                .getProject(projectName);
        if (referencedProject == null) {
            throw new CoreException(ExceptionHelper
                    .getErrorStatus("Referenced Project " + projectName
                            + " does not exist in Workspace."));
        }
        return new OpenMOF14MetaProjectConf(referencedProject);
	}
	

	/* (non-Javadoc)
	 * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#configureProject(org.eclipse.core.resources.IProject)
	 */
	public void configureProject(IProject project) throws CoreException {
		ProjectPropertiesStorageHelper.setProperty(project, Constants.REFERRED_PROJECT_NAME_KEY, referencedProject.getName());

	}

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.epi.conf.IProjectMetaRefConf#getMetaLookUpForProject()
     */
    public ReferenceScopeBean getMetaLookUpForProject() {
	ResourceSet connection = ConnectionManager.getInstance().getExistingDefaultConnection(referencedProject);
	if(connection == null) {
	    if (Display.getCurrent() != null) {
		//this means we are in the UI thread
		 final ResourceSet[] conn = new ResourceSet[1];
			IRunnableWithProgress operation = new IRunnableWithProgress() {
			    public void run(IProgressMonitor monitor)
				    throws InterruptedException {
				// non UI thread
				try {
				    referencedProject.open(/* progress monitor */null);
				} catch (CoreException e) {
				    throw new RuntimeException(e);
				}
				conn[0] = ConnectionManager.getInstance()
					.getOrCreateDefaultConnection(referencedProject);
			    }
			};
			IProgressService ps = PlatformUI.getWorkbench().getProgressService();
			try {
			    ps.busyCursorWhile(operation);
			} catch (Exception e) {
			    throw new RuntimeException(e);
			}
			connection = conn[0];
	    } else {
		ConnectionManager.getInstance()
			.getOrCreateDefaultConnection(referencedProject);
	    }
	}
        IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(connection, PartitionScope.VISIBLE);
        Set<PRI> partitionScope = partitionScopeProvider.getPartitions();
        HashSet<PRI> newPRIs = new HashSet<PRI>();
        newPRIs.addAll(partitionScope);
        Moin moin = MoinFactory.getMoinInstance();
        PRI pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
        newPRIs.add(pri);
        pri = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
        newPRIs.add(pri); 
	return new ReferenceScopeBean(connection, newPRIs);
    }

	/**
	 * Gets the ref project name.
	 * 
	 * @return the ref project name
	 */
	public String getRefProjectName() {
		return referencedProject.getName();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OpenMOF14MetaProjectConf) {
			OpenMOF14MetaProjectConf other = (OpenMOF14MetaProjectConf) obj;
			if (other.referencedProject.equals(this.referencedProject)) {
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
		return referencedProject.hashCode();
	}

	
}
