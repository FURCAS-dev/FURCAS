package com.sap.furcas.ide.dslproject.conf;

import java.util.HashSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Constants;
import com.sap.furcas.ide.dslproject.builder.BuildHelper;
import com.sap.furcas.utils.exceptions.EclipseExceptionHelper;



/**
 * configures a project to use an open MOF14 metamodel as reference.
 * 
 * @author C5107456
 */
public final class EcoreMetaProjectConf implements IProjectMetaRefConf {

        /** The referenced project. */
        private final IProject referencedProject;
        private final String nsURI;

        /**
         * Instantiates a new open mo f14 meta project conf.
         * 
         * @param referencedProject the referenced project
         * 
         * @throws CoreException the core exception
         */
        public EcoreMetaProjectConf(IProject referencedProject, String nsURI) {
                this.referencedProject = referencedProject;
                this.nsURI = nsURI;
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
        public static EcoreMetaProjectConf getConfigurationFromProject(IProject project) throws CoreException {
                String projectName = ProjectPropertiesStorageHelper.getProperty(project, Constants.REFERRED_PROJECT_NAME_KEY);
                String nsURI = ProjectPropertiesStorageHelper.getProperty(project, "nsURI");
                if (projectName == null || projectName.trim().equals("")) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus("Project "
                    + project.getName() + " not configured for use with "
                    + EcoreMetaProjectConf.class.getName(), Activator.PLUGIN_ID));
        }
        IProject referencedProject = project.getWorkspace().getRoot()
                .getProject(projectName);
        if (referencedProject == null) {
            throw new CoreException(EclipseExceptionHelper
                    .getErrorStatus("Referenced Project " + projectName
                            + " does not exist in Workspace.", Activator.PLUGIN_ID));
        }
        return new EcoreMetaProjectConf(referencedProject, nsURI);
        }
        

        /* (non-Javadoc)
         * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#configureProject(org.eclipse.core.resources.IProject)
         */
        @Override
        public void configureProject(IProject project) throws CoreException {
                ProjectPropertiesStorageHelper.setProperty(project, Constants.REFERRED_PROJECT_NAME_KEY, referencedProject.getName());
                ProjectPropertiesStorageHelper.setProperty(project, "nsURI", nsURI);

        }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.sap.mi.textual.epi.conf.IProjectMetaRefConf#getMetaLookUpForProject()
     */
        @Override
        public ReferenceScopeBean getMetaLookUpForProject() {
                ResourceSet connection = BuildHelper
                                .getResourceSetForProject(referencedProject);
                if (connection == null) {
                        if (Display.getCurrent() != null) {
                                // this means we are in the UI thread
                                final ResourceSet[] conn = new ResourceSet[1];
                                IRunnableWithProgress operation = new IRunnableWithProgress() {
                                        @Override
                                        public void run(IProgressMonitor monitor)
                                                        throws InterruptedException {
                                                // non UI thread
                                                try {
                                                        referencedProject.open(/* progress monitor */null);
                                                } catch (CoreException e) {
                                                        throw new RuntimeException(e);
                                                }
                                                conn[0] = BuildHelper
                                                                .getResourceSetForProject(referencedProject);
                                        }
                                };
                                IProgressService ps = PlatformUI.getWorkbench()
                                                .getProgressService();
                                try {
                                        ps.busyCursorWhile(operation);
                                } catch (Exception e) {
                                        throw new RuntimeException(e);
                                }
                                connection = conn[0];
                        } else {
                                BuildHelper.getResourceSetForProject(referencedProject);
                        }
                }
                HashSet<URI> newPRIs = null;
                newPRIs = new HashSet<URI>();
                //TODO look if needed
/*                EPackage ePackage = EcorePackage.eINSTANCE;
                newPRIs.add(URI.createURI(ePackage.getNsURI()));*/
                newPRIs.add(URI.createURI(nsURI));
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
                if (obj instanceof EcoreMetaProjectConf) {
                        EcoreMetaProjectConf other = (EcoreMetaProjectConf) obj;
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
