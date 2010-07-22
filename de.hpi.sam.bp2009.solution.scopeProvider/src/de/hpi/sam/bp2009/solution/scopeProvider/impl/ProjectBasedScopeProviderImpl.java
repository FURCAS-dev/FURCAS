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
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider;

/**
 * <!-- begin-user-doc --> An implementation of the '<em><b>Project Based Scope Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link ProjectBasedScopeProvider#getInitialProjects <em>Initial Projects</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getInMemoryResources() <em>InMemory Resources</em>}</li>
 * 
 * <li>{@link ProjectBasedScopeProvider#getForwardScopeAsProjects() <em>Forward Scope as Projects</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getForwardScopeAsResources() <em>Forward Scope as Resources</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getForwardScopeAsURIs() <em>Forward Scope as URIs</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getForwardScopeAsEObjects() <em>Forward Scope as EObjects</em>}</li>
 * 
 * <li>{@link ProjectBasedScopeProvider#getBackwardScopeAsProjects() <em>Backward Scope as Projects</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getBackwardScopeAsResources() <em>Backward Scope as Resources</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getBackwardScopeAsURIs() <em>Backward Scope as URIs</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getBackwardScopeAsEObjects() <em>Backward Scope as EObjects</em>}</li>
 * </ul>
 * </p>
 * 
 */
public class ProjectBasedScopeProviderImpl implements ProjectBasedScopeProvider {

    private static final String WARNING_WORKSPACE_IS_CLOSED = "Attention: Workspace is closed. Only objects in the same resourceSet as the initial object(s) are returned as scope.";
    protected Collection<IProject> initialProjects = new HashSet<IProject>();
    protected List<WeakReference<Resource>> inMemoryResourceList;
    protected ResourceSet rs;

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
    
    public ProjectBasedScopeProviderImpl(Notifier notifier) {
        if (notifier instanceof EObject) {
            setupForEObjects(Arrays.asList((EObject) notifier));
        } else if (notifier instanceof Resource) {
            setupForResources(Arrays.asList((Resource) notifier));
        } else if (notifier instanceof ResourceSet) {
            setupForResourceSets(Arrays.asList((ResourceSet) notifier));
        } else {
            throw new RuntimeException("Expected Resource, ResourceSet or EObject but got "+notifier.getClass().getName());
        }
    }
    
    public Collection<IProject> getInitialProjects() {

        return initialProjects;
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

    public void setInMemoryResources(Collection<Resource> resources) {
        inMemoryResourceList = new ArrayList<WeakReference<Resource>>();
        for (Resource r : resources) {
            inMemoryResourceList.add(new WeakReference<Resource>(r));
        }
    }

    public Collection<IProject> getForwardScopeAsProjects() {
        return scopeAsProjects(true);
    }

    public Collection<Resource> getForwardScopeAsResources() {
        Collection<Resource> result = scopeAsResources(getForwardScopeAsProjects());
        return result;
    }

    public Collection<URI> getForwardScopeAsURIs() {
        return scopeAsUris(getForwardScopeAsResources());
    }

    public Collection<EObject> getForwardScopeAsEObjects() {
        return scopeAsEObjects(getForwardScopeAsResources());
    }

    public Collection<IProject> getBackwardScopeAsProjects() {
        return scopeAsProjects(false);

    }

    public Collection<Resource> getBackwardScopeAsResources() {
        Collection<Resource> result = scopeAsResources(getBackwardScopeAsProjects());
        return result;
    }

    public Collection<URI> getBackwardScopeAsURIs() {
        return scopeAsUris(getBackwardScopeAsResources());
    }

    public Collection<EObject> getBackwardScopeAsEObjects() {
        return scopeAsEObjects(getBackwardScopeAsResources());
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
            URIConverter converter = null;
            if (set != null) {
                converter = set.getURIConverter();
            }
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
        if (member == null || !(member instanceof IFolder)){
            System.err.println("WARNING!!"+ project.getName() + " does not contain a model folder. It is invalid.");
//            throw new IllegalArgumentException(project.getName() + " does not contain a model folder. It is invalid.");
            return null;
        }
        return (IFolder) member;
    }

    private Set<Resource> getAllResourcesFromDirectory(IFolder modelDirectory) throws CoreException {
        final Set<Resource> resources = new HashSet<Resource>();
        for (IResource f : modelDirectory.members()) {
            boolean successful = checkIfResourceIsValidLoadable(org.eclipse.emf.common.util.URI.createURI(f.getLocationURI()
                        .toString()));

            if (successful)
                addNewOrInMemoryResource(resources, URI.createURI(f.getLocationURI().toString()),f.getFileExtension());

        }

        return resources;
    }

    private IProject getProjectForResource(Resource res, URIConverter converter) throws IllegalArgumentException {
        URI uri = converter.normalize(res.getURI());
        java.net.URI netUri = java.net.URI.create(uri.toString());
        IProject project = null;
        
        if(Platform.isRunning()){
        IContainer[] result = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(netUri);
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
        }else{
        	workSpaceClosedWarning();
        }
        return project;
    }

    /**
     * Add a resource with the given URI to the given Set of resources if an resource with the same uri is in the inMemory List,
     * this resource will be added
     * 
     * @param resources
     *            Set to add in resource
     * @param uri
     *            uri of the resource to add
     * @param extension
     *            resource file extension to infer the appropriate ResourceImpl
     */
    private void addNewOrInMemoryResource(final Set<Resource> resources, URI uri, String extension) {
        Resource inMemory = null;
        for (Resource r : getInMemoryResources())
            if (uri.equals(r.getURI()))
                inMemory = r;
        if(inMemory == null){
                if(rs==null){            
                    System.err.println("WARNING!! New ResourceSet created for \""+uri+"\". This is usually unexpected");
                    resources.add(new ResourceSetImpl().getResource(uri, true));
                }else{
                    resources.add(rs.getResource(uri, true));
                }
        }else{
            resources.add(inMemory);
        }
    }

    private Collection<IProject> scopeAsProjects(Boolean forward) {
		Collection<IProject> result = new BasicEList<IProject>();
		Collection<IProject> pool = new ArrayList<IProject>();

		if (Platform.isRunning()) {
			pool = Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects());
		} else {
			workSpaceClosedWarning();
		}

		for (IProject project : getInitialProjects()) {
			try {
				result = recursiveGetReferenceProjectsForProjects(project,
						result, pool, forward);
			} catch (CoreException e) {
				// TODO Add Exception to an intern array of errors
				e.printStackTrace();
			}
		}
        return result;
    }

    private void workSpaceClosedWarning() {
        // the scope provider was not started as plugin that is why 
        // only objects in the same resourceSet as the initial object(s) are returned as scope.
    	System.err.println(WARNING_WORKSPACE_IS_CLOSED);
    }

    private Collection<Resource> scopeAsResources(Collection<IProject> projects) throws IllegalArgumentException {
        Collection<Resource> result = new HashSet<Resource>();
        for (IProject project : projects) {
            IFolder modelDir = getModelDirectoryFromProject(project);
            if(modelDir==null){
                continue;
            }
            try {
                result.addAll(getAllResourcesFromDirectory(modelDir));
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
        //Resource.Factory.Registry.INSTANCE.getFactory(uri);
        //load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMLResourceFactoryImpl());
        /*
         * Load the resource using the URI
         */
        try {
            Resource r = load_resourceSet.getResource(uri, true);

        /*
         * FIXME, it is not clear if the LocationURI is the best one to give here, consider using an inputstream
         */
        
            r.load(null);
            successful = true;
            if (r.getErrors().size() > 0)
                successful = false;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


        return successful;
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

} // ProjectBasedScopeProviderImpl
