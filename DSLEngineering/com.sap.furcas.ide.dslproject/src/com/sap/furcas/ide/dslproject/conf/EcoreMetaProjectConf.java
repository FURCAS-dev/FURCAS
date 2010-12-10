package com.sap.furcas.ide.dslproject.conf;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Constants;
import com.sap.furcas.ide.dslproject.builder.BuildHelper;
import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
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
    private final String modelPath;

    /**
     * Instantiates a new ecore meta project conf.
     * 
     * @param referencedProject
     *            the referenced project
     * 
     * @throws CoreException
     *             the core exception
     */
    public EcoreMetaProjectConf(IProject referencedProject, String modelPath, String nsURI) {
        this.referencedProject = referencedProject;
        this.nsURI = nsURI;
        this.modelPath = modelPath;
    }

    /**
     * Gets the configuration from project.
     * 
     * @param project
     *            the project
     * 
     * @return the configuration from project
     * 
     * @throws CoreException
     *             the core exception
     */
    public static EcoreMetaProjectConf getConfigurationFromProject(IProject project) throws CoreException {
        String projectName = ProjectPropertiesStorageHelper.getProperty(project, Constants.REFERRED_PROJECT_NAME_KEY);
        String nsURI = ProjectPropertiesStorageHelper.getProperty(project, "nsURI");
        String modelPath = ProjectPropertiesStorageHelper.getProperty(project, "modelPath");
        if (projectName == null || projectName.trim().equals("")) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus("Project " + project.getName()
                    + " not configured for use with " + EcoreMetaProjectConf.class.getName(), Activator.PLUGIN_ID));
        }
        IProject referencedProject = project.getWorkspace().getRoot().getProject(projectName);
        if (referencedProject == null) {
            throw new CoreException(EclipseExceptionHelper.getErrorStatus("Referenced Project " + projectName
                    + " does not exist in Workspace.", Activator.PLUGIN_ID));
        }
        return new EcoreMetaProjectConf(referencedProject, modelPath, nsURI);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#configureProject(org.eclipse.core.resources.IProject)
     */
    @Override
    public void configureProject(IProject project) throws CoreException {
        ProjectPropertiesStorageHelper.setProperty(project, Constants.REFERRED_PROJECT_NAME_KEY, referencedProject.getName());
        ProjectPropertiesStorageHelper.setProperty(project, "nsURI", nsURI);
        ProjectPropertiesStorageHelper.setProperty(project, "modelPath", modelPath);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.epi.conf.IProjectMetaRefConf#getMetaLookUpForProject()
     */
    @Override
    public ReferenceScopeBean getMetaLookUpForProject() {
        HashSet<URI> newPRIs = null;
        newPRIs = new HashSet<URI>();
        ResourceSet connection = BuildHelper.getResourceSetForProject(referencedProject);
        if (!modelPath.matches("")) {
            connection = new ResourceSetImpl();
            String uri = URI.createPlatformResourceURI(modelPath, true).toString();
            Resource resource = connection.createResource(URI.createPlatformResourceURI(modelPath, true));
            Map<Object, Object> options = new HashMap<Object, Object>();
            options.put(XMLResource.OPTION_ENCODING, "UTF-8");
            try {
                resource.load(options);
            } catch (IOException e) {
                // TODO
            }
            EList<EObject> list = resource.getContents();
            for (EObject object : list) {
                if (object instanceof EPackage) {
                    EPackage new_package = (EPackage) object;
                    EPackage.Registry.INSTANCE.put(uri, new_package);
                }
            }

        } else
            newPRIs.add(URI.createURI(nsURI));
        newPRIs.add(URI.createURI(FURCASPackage.eINSTANCE.eClass().getEPackage().getNsURI()));
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

    /*
     * (non-Javadoc)
     * 
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return referencedProject.hashCode();
    }

}
