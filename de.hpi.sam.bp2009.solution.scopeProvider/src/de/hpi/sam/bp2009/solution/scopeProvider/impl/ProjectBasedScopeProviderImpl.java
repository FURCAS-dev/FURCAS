/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider.impl;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Project Based Scope Provider</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl#getInitialProjects <em>Initial Projects
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProjectBasedScopeProviderImpl implements ProjectBasedScopeProvider {

    protected Collection<IProject> initialProjects = new HashSet<IProject>();
    protected List<WeakReference<Resource>> inMemoryResourceList;
    private ResourceSet rs;

    protected ProjectBasedScopeProviderImpl() {
        super();
    }

    public ProjectBasedScopeProviderImpl(EObject... eObjects) {
        super();
        setupForEObjects(Arrays.asList(eObjects));
    }

    public ProjectBasedScopeProviderImpl(Resource... resources) {
        super();
        setupForResources(Arrays.asList(resources));
    }

    public ProjectBasedScopeProviderImpl(ResourceSet... resourceSets) {
        super();
        setupForResourceSets(Arrays.asList(resourceSets));
    }

    public Collection<Resource> getInMemoryResources() {
        Collection<Resource> result = new BasicEList<Resource>();
        if (inMemoryResourceList == null) {
            return result;
        }
        for (WeakReference<Resource> ref : inMemoryResourceList) {
            Resource r = ref.get();
            if (r != null) {
                result.add(r);
            }
        }
        return result;
    }

    public QueryContext getForwardScopeAsQueryContext() {
        return new QueryContext() {

            @Override
            public ResourceSet getResourceSet() {
                return rs;

            }

            @Override
            public URI[] getResourceScope() {
                Collection<URI> list = getForwardScopeAsURIs();
                return (URI[]) list.toArray(new URI[list.size()]);

            }
        };
    }

    public QueryContext getBackwardScopeAsQueryContext() {
        return new QueryContext() {

            @Override
            public ResourceSet getResourceSet() {
                ResourceSet set = new ResourceSetImpl();
                set.getResources().addAll(getBackwardScopeAsResources());
                return set;

            }

            @Override
            public URI[] getResourceScope() {
                Collection<URI> list = getBackwardScopeAsURIs();
                return (URI[]) list.toArray(new URI[list.size()]);
            }
        };
    }

    public Collection<IProject> getInitialProjects() {

        return initialProjects;
    }

    private void setupForEObjects(List<EObject> list) {
        Set<Resource> initialResources = new HashSet<Resource>();
        for (EObject eObject : list) {
            Resource r = eObject.eResource();
            if (r != null) {
                initialResources.add(r);
            }
        }
        setupForResources(initialResources);
    }

    private void setupForResources(Collection<Resource> list) {
        for (Resource res : list) {
            ResourceSet set = res.getResourceSet();
            if (rs == null && set != null) {
                rs = set;
            }
            URIConverter converter = set.getURIConverter();
            if (converter == null) {
                converter = URIConverter.INSTANCE;
            }
            /*
             * update inMemory Resources
             */
            Collection<Resource> inmem = getInMemoryResources();
            inmem.add(res);
            setInMemoryResources(inmem);

            IProject project = getProjectForResource(res, converter);
            if (project != null) {
                initialProjects.add(project);
            }
        }

    }

    private void setupForResourceSets(List<ResourceSet> list) {
        Set<Resource> initialResources = new HashSet<Resource>();
        for (ResourceSet set : list) {
            if (rs == null) {
                rs = set;
            }
            for (Resource r : set.getResources()) {
                initialResources.add(r);
            }
        }
        setupForResources(initialResources);

    }

    public Collection<EObject> getForwardScopeAsEObjects() {
        return scopeAsEObjects(getForwardScopeAsResources());
    }

    public Collection<IProject> getForwardScopeAsProjects() {
        return scopeAsProjects(true);
    }

    public Collection<Resource> getForwardScopeAsResources() {
        return scopeAsResources(getForwardScopeAsProjects());
    }

    public Collection<URI> getForwardScopeAsURIs() {
        return scopeAsUris(getForwardScopeAsResources());
    }

    public Collection<EObject> getBackwardScopeAsEObjects() {
        return scopeAsEObjects(getBackwardScopeAsResources());
    }

    public Collection<IProject> getBackwardScopeAsProjects() {
        return scopeAsProjects(false);

    }

    public Collection<Resource> getBackwardScopeAsResources() {
        return scopeAsResources(getBackwardScopeAsProjects());
    }

    public Collection<URI> getBackwardScopeAsURIs() {
        return scopeAsUris(getBackwardScopeAsResources());
    }

    public void setInMemoryResources(Collection<Resource> resources) {
        inMemoryResourceList = new ArrayList<WeakReference<Resource>>();
        for (Resource r : resources) {
            inMemoryResourceList.add(new WeakReference<Resource>(r));
        }
    }

    /**
     * Add a resource with the given URI to the given Set of resources if an resource with the same uri is in the inMemory List,
     * this resource will be added
     * 
     * @param resources
     *            Set to add in resource
     * @param uri
     *            uri of the resource to add
     */
    private void addNewOrInMemoryResource(final Set<Resource> resources, URI uri) {
        Resource inMemory = null;
        for (Resource r : getInMemoryResources())
            if (uri.equals(r.getURI()))
                inMemory = r;

        resources.add(inMemory == null ? new XMIResourceImpl(uri) : inMemory);
    }

    /**
     * @param resource
     * @param successful
     * @return
     */
    private boolean checkIfResourceIsValidLoadable(org.eclipse.emf.common.util.URI uri) {
        Boolean successful = false;

        ResourceSet load_resourceSet = new ResourceSetImpl();

        /*
         * Register XML Factory implementation using DEFAULT_EXTENSION
         */
        load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMLResourceFactoryImpl());
        /*
         * Load the resource using the URI
         */
        Resource r = load_resourceSet.getResource(uri, true);

        /*
         * FIXME, it is not clear if the LocationURI is the best one to give here, consider using an inputstream
         */
        try {
            r.load(null);
            successful = true;
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (r.getErrors().size() > 0)
            successful = false;
        return successful;
    }

    private IProject getProjectForResource(Resource res, URIConverter converter) throws IllegalArgumentException {
        URI uri = converter.normalize(res.getURI());
        java.net.URI netUri = java.net.URI.create(uri.toString());
        IContainer[] result = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(netUri);
        IProject project = null;
        for (IFile file : ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(netUri)) {
            project = file.getProject();
        }
        for (IContainer c : result)
            if (c instanceof IProject)
                project = (IProject) c;
        /*
         * TODO Think about a better way for resource without projects
         */
        // if(project==null)
        // throw new IllegalArgumentException(uri +" is no valid Resource because not in the workspace");
        return project;
    }

    private Set<Resource> getAllResourceFromDirectory(IFolder modelDirectory) throws CoreException {
        final Set<Resource> resources = new HashSet<Resource>();
        for (IResource f : modelDirectory.members()) {
            boolean successful = false;

            if (f.getFileExtension().endsWith("xmi")) {
                successful = checkIfResourceIsValidLoadable(org.eclipse.emf.common.util.URI.createURI(f.getLocationURI()
                        .toString()));
                XMIResourceImpl r = new XMIResourceImpl(URI.createURI(f.getLocationURI().toString()));
                /*
                 * FIXME, it is not clear if the LocationURI is the best one to give here, consider using an inputstream
                 */
                try {
                    r.load(null);
                    successful = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }

                if (r.getErrors().size() > 0)
                    successful = false;
            }

            if (successful)
                addNewOrInMemoryResource(resources, URI.createURI(f.getLocationURI().toString()));
            // r.unload();

        }

        return resources;
    }

    private IFolder getModelDirectoryFromProject(IProject project) throws IllegalArgumentException {
        // refresh if project is not totally loaded some resources should appear hear
        try {
            project.refreshLocal(IResource.DEPTH_INFINITE, null);
        } catch (CoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        IResource member = project.findMember("model", true);
        project.getLocation().toFile().listFiles();
        if (member == null || !(member instanceof IFolder))
            throw new IllegalArgumentException(project.getName() + " does not contain a model folder. It is invalid.");
        return (IFolder) member;
    }

    private Collection<EObject> iteratorToCollection(Iterator<?> treeIterator) {
        Collection<EObject> treeAsList = new BasicEList<EObject>();
        while (treeIterator.hasNext()) {
            Object next = treeIterator.next();
            if (next instanceof EObject)
                treeAsList.add((EObject) next);
        }
        return treeAsList;
    }

    /**
     * Computes recursively all referenced or referencing projects from a given pool and initial project
     * 
     * @param project
     *            project to compute the references for
     * @param referencedProjects
     *            list of all referenced projects, initial empty
     * @param pool
     *            pool of all projects which can be in the references
     * @param forward
     *            switch to decide if one get all reference projects of the given one or all referencing projects
     * @return the List of all references
     * @throws CoreException
     */
    private Collection<IProject> recursiveGetReferenceProjectsForProjects(IProject project,
            Collection<IProject> referencedProjects, Collection<IProject> pool, Boolean forward) throws CoreException {
        /*
         * referencing in both directions is reflexive
         */
        if (!referencedProjects.contains(project) && pool.contains(project))
            referencedProjects.add(project);

        IProject[] refProjects = null;
        if (forward)
            refProjects = project.getReferencedProjects();
        else
            refProjects = project.getReferencingProjects();

        for (IProject referenced : refProjects) {
            if (referencedProjects.contains(referenced))
                continue;
            if (!pool.contains(referenced))
                continue;
            referencedProjects.add(referenced);
            recursiveGetReferenceProjectsForProjects(referenced, referencedProjects, pool, forward);
        }
        return referencedProjects;
    }

    private Collection<EObject> scopeAsEObjects(Collection<Resource> resources) {
        Collection<EObject> result = new HashSet<EObject>();
        for (Resource resource : resources) {
            /*
             * FIXME unfortunately a memory leak
             */
            if (!resource.isLoaded())
                try {
                    resource.load(null);
                } catch (IOException e) {
                    // TODO Add Exception to an intern array of errors
                    e.printStackTrace();
                }
            result.addAll(iteratorToCollection(resource.getAllContents()));
        }
        return result;
    }

    private Collection<IProject> scopeAsProjects(Boolean forward) {
        Collection<IProject> result = new BasicEList<IProject>();
        Collection<IProject> pool = Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects());

        for (IProject project : getInitialProjects()) {
            try {
                result = recursiveGetReferenceProjectsForProjects(project, result, pool, forward);
            } catch (CoreException e) {
                // TODO Add Exception to an intern array of errors
                e.printStackTrace();
            }
        }
        return result;
    }

    private Collection<Resource> scopeAsResources(Collection<IProject> projects) throws IllegalArgumentException {
        Collection<Resource> result = new HashSet<Resource>();
        for (IProject project : projects) {
            IFolder modelDir = getModelDirectoryFromProject(project);
            try {
                result.addAll(getAllResourceFromDirectory(modelDir));
            } catch (CoreException e) {
                // TODO Add Exception to an intern array of errors
                e.printStackTrace();
            }
        }
        result.addAll(getInMemoryResources());

        return result;
    }

    private Collection<URI> scopeAsUris(Collection<Resource> resources) {
        Collection<URI> result = new BasicEList<URI>();
        for (Resource res : resources) {
            if (res.getURI() != null)
                result.add(res.getURI());
        }
        return result;
    }

} // ProjectBasedScopeProviderImpl
