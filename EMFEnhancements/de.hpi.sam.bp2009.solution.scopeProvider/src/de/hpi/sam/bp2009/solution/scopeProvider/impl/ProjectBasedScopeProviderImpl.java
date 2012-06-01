/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.scopeProvider.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;

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
 * 
 * <li>{@link ProjectBasedScopeProvider#getBackwardScopeAsProjects() <em>Backward Scope as Projects</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getBackwardScopeAsResources() <em>Backward Scope as Resources</em>}</li>
 * <li>{@link ProjectBasedScopeProvider#getBackwardScopeAsURIs() <em>Backward Scope as URIs</em>}</li>
 * </ul>
 * </p>
 * 
 */
public class ProjectBasedScopeProviderImpl implements ProjectBasedScopeProvider {

    private static final String WARNING_WORKSPACE_IS_CLOSED = "Attention: Workspace is closed. Only objects in the same resourceSet as the initial object(s) are returned as scope.";
    
    protected Collection<IProject> initialProjects = new HashSet<IProject>();
    protected WeakHashMap<URI, Object> inMemoryResources = new WeakHashMap<URI, Object>();
    protected ResourceSet rs;

    protected ProjectBasedScopeProviderImpl() {
        super();
    }
    
    public ProjectBasedScopeProviderImpl(Notifier... notifiers) {
        Collection<Resource> resources = new HashSet<Resource>();
        
        for (Notifier notifier : notifiers) {
            if (notifier instanceof EObject) {
                EObject eo = (EObject) notifier;
                if (eo.eResource() != null) {
                    resources.add(eo.eResource());
                }
            } else if (notifier instanceof Resource) {
                resources.add((Resource) notifier);
            } else if (notifier instanceof ResourceSet) {
                resources.addAll(((ResourceSet) notifier).getResources());
                rs = (ResourceSet) notifier;
            } else {
                throw new RuntimeException("Expected Resource, ResourceSet or EObject but got "
                        + notifier.getClass().getName());
            }
        }
        setupForResources(resources);
    }
    
    @Override
    public Collection<IProject> getInitialProjects() {
        return initialProjects;
    }

    @Override
    public Collection<Resource> getInMemoryResources() {
        return urisAsResources(inMemoryResources.keySet());
    }

    @Override
    public Collection<IProject> getForwardScopeAsProjects() {
        return scopeAsProjects(/*forward*/ true);
    }

    @Override
    public Collection<Resource> getForwardScopeAsResources() {
        Collection<Resource> result = urisAsResources(scopeAsUris(getForwardScopeAsProjects()));
        return result;
    }

    @Override
    public Collection<URI> getForwardScopeAsURIs() {
        return scopeAsUris(getForwardScopeAsProjects());
    }

    public Collection<EObject> getForwardScopeAsEObjects() {
        return scopeAsEObjects(getForwardScopeAsResources());
    }

    @Override
    public Collection<IProject> getBackwardScopeAsProjects() {
        return scopeAsProjects(/*forward*/ false);
    }

    @Override
    public Collection<Resource> getBackwardScopeAsResources() {
        Collection<Resource> result = urisAsResources(scopeAsUris(getBackwardScopeAsProjects()));
        return result;
    }

    @Override
    public Collection<URI> getBackwardScopeAsURIs() {
        return scopeAsUris(getBackwardScopeAsProjects());
    }

    public Collection<EObject> getBackwardScopeAsEObjects() {
        return scopeAsEObjects(getBackwardScopeAsResources());
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
            inMemoryResources.put(res.getURI(), null);

            IProject project = getProjectForResource(res, converter);
            if (project != null) {
                initialProjects.add(project);
            }
        }
    }

    private Collection<IFolder> getModelDirectoriesFromProject(IProject project) throws IllegalArgumentException {
        Collection<IFolder> folders = new ArrayList<IFolder>();
        try {
            // refresh: if project is not totally loaded some resources should appear hear
            project.refreshLocal(IResource.DEPTH_INFINITE, null);
            
            for (IResource member : project.members(false)) {
                if (member instanceof IFolder) {
                    folders.add((IFolder) member);
                }
            }
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return folders;
    }

    private Collection<URI> getAllResourcesFromDirectory(IFolder modelDirectory) throws CoreException {
        final Set<String> extensions = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().keySet();
        final Collection<URI> resources = new ArrayList<URI>();

        for (IResource f : modelDirectory.members()) {
            if (f instanceof IContainer) {
                continue;
            }
            // only files with extension 'xmi', 'xml' or one of the registered ones include a resource
            if ("xmi".equals(f.getFileExtension()) || "xml".equals(f.getFileExtension())
                    || extensions.contains(f.getFileExtension())) {
                
                URI uri = URI.createPlatformResourceURI(f.getProject().getName()+"/"+f.getProjectRelativePath().toString(), /*encoded*/ true);
                resources.add(uri);
            }
        }
        return resources;
    }

    /** 
     * Project can be null if the scope provider could not resolve project for resource, because resource not in the workspace.
     * This commonly happens for metamodels and resources which are in-memory only.
     */
    private IProject getProjectForResource(Resource res, URIConverter converter) throws IllegalArgumentException {
        if (!Platform.isRunning()) {
            workSpaceClosedWarning();
            return null;
        }
        URI uri = converter.normalize(res.getURI());
        
        if (uri.isPlatformResource()) {
            String projectName = uri.segment(1);
            return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

        } else if (uri.isFile()) {
            java.net.URI netUri = java.net.URI.create(uri.toString());
            IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
            for (IFile file : root.findFilesForLocationURI(netUri)) {
                if (file.getProject() != null) {
                    return file.getProject();
                }
            }
            for (IContainer c : root.findContainersForLocationURI(netUri)) {
                if (c instanceof IProject) {
                    return (IProject) c;
                }
            }
        }
        return null;
    }
    
    private Collection<Resource> urisAsResources(Collection<URI> uris) {
        if (rs == null) {
            throw new RuntimeException("ScopeProvider not given a ResourceSet. Cannot load resources.");
        }
        Collection<Resource> result = new ArrayList<Resource>();
        for (URI uri : uris) {
            result.add(rs.getResource(uri, /*loadOnDemand*/ true));
        }
        return result;
    }

    private Collection<IProject> scopeAsProjects(boolean forward) {
        Collection<IProject> result = new HashSet<IProject>();
        Collection<IProject> pool = new ArrayList<IProject>();

        if (Platform.isRunning()) {
            pool = Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects());
        } else {
            workSpaceClosedWarning();
        }
        for (IProject project : getInitialProjects()) {
            try {
                result.addAll(recursiveGetReferenceProjectsForProjects(project, result, pool, forward));
            } catch (CoreException e) {
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

    private Collection<URI> scopeAsUris(Collection<IProject> projects) throws IllegalArgumentException {
        Collection<URI> result = new HashSet<URI>();
        for (IProject project : projects) {
            for (IFolder modelDir : getModelDirectoriesFromProject(project)) {
                try {
                    result.addAll(getAllResourcesFromDirectory(modelDir));
                } catch (CoreException e) {
                    e.printStackTrace();
                }
            }
        }
        result.addAll(inMemoryResources.keySet());
        return result;
    }

    private Collection<EObject> scopeAsEObjects(Collection<Resource> resources) {
        Collection<EObject> result = new HashSet<EObject>();
        for (Resource resource : resources) {
            Iterator<EObject> iter = resource.getAllContents();
            while (iter.hasNext()) {
                result.add(iter.next());
            }
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
            Collection<IProject> referencedProjects, Collection<IProject> pool, boolean forward) throws CoreException {
        /*
         * referencing in both directions is reflexive
         */
        if (!referencedProjects.contains(project) && pool.contains(project)) {
            referencedProjects.add(project);
        }

        IProject[] refProjects = null;
        if (forward) {
            refProjects = project.getReferencedProjects();
        } else {
            refProjects = project.getReferencingProjects();
        }

        for (IProject referenced : refProjects) {
            if (referencedProjects.contains(referenced)) {
                continue;
            }
            if (!pool.contains(referenced)) {
                continue;
            }
            referencedProjects.add(referenced);
            recursiveGetReferenceProjectsForProjects(referenced, referencedProjects, pool, forward);
        }
        return referencedProjects;
    }

} // ProjectBasedScopeProviderImpl
