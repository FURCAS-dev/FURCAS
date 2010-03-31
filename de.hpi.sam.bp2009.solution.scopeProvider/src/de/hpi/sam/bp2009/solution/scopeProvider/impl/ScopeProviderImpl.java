/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider.impl;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;

import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.impl.ScopeProviderImpl#getInitialProjects <em>Initial Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScopeProviderImpl extends EObjectImpl implements ScopeProvider {
	/**
	 * The cached value of the '{@link #getInitialProjects() <em>Initial Projects</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<IProject> initialProjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScopeProviderPackage.Literals.SCOPE_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IProject> getInitialProjects() {
		if (initialProjects == null) {
			initialProjects = new EDataTypeUniqueEList<IProject>(IProject.class, this, ScopeProviderPackage.SCOPE_PROVIDER__INITIAL_PROJECTS);
		}
		return initialProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setupForEObjects(EList<EObject> initialObjects) {
		Set<Resource> initialResources = new HashSet<Resource>();
		for(EObject eObject: initialObjects){
			Resource r = eObject.eResource();
			if(r!=null){
				initialResources.add(r);
			}
		}
		setupForResources(convertSetToEList(initialResources));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setupForResources(EList<Resource> initialResources) {
		for(Resource res: initialResources){
			ResourceSet set=res.getResourceSet();
			URIConverter converter=set.getURIConverter();
			if(converter==null){
				converter= URIConverter.INSTANCE;
			}
			IProject project = getProjectForResource(res, converter);
			getInitialProjects().add(project);
		}



	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setupForResourceSets(EList<ResourceSet> initialResourceSets) {
		Set<Resource> initialResources= new HashSet<Resource>();
		for(ResourceSet set: initialResourceSets)
			for(Resource r: set.getResources())
				initialResources.add(r);
		setupForResources(convertSetToEList(initialResources));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EObject> getForwardScopeAsEObjects() {
		return scopeAsEObjects(getForwardScopeAsResources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<IProject> getForwardScopeAsProjects() {
		return scopeAsProjects(true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Resource> getForwardScopeAsResources() {
		return scopeAsResources(getForwardScopeAsProjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<URI> getForwardScopeAsURIs() {
		return scopeAsUris(getForwardScopeAsResources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EObject> getBackwardScopeAsEObjects() {
		return scopeAsEObjects(getBackwardScopeAsResources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<IProject> getBackwardScopeAsProjects() {
		return scopeAsProjects(false);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Resource> getBackwardScopeAsResources() {
		return scopeAsResources(getBackwardScopeAsProjects());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<URI> getBackwardScopeAsURIs() {
		return scopeAsUris(getBackwardScopeAsResources());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ScopeProviderPackage.SCOPE_PROVIDER__INITIAL_PROJECTS:
			return getInitialProjects();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ScopeProviderPackage.SCOPE_PROVIDER__INITIAL_PROJECTS:
			getInitialProjects().clear();
			getInitialProjects().addAll((Collection<? extends IProject>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ScopeProviderPackage.SCOPE_PROVIDER__INITIAL_PROJECTS:
			getInitialProjects().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ScopeProviderPackage.SCOPE_PROVIDER__INITIAL_PROJECTS:
			return initialProjects != null && !initialProjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (initialProjects: "); //$NON-NLS-1$
		result.append(initialProjects);
		result.append(')');
		return result.toString();
	}

	/**
	 * Creates a new EList containing all Elements of the given set
	 * @param initialResources given Set
	 * @return new EList
	 */
	private EList<Resource> convertSetToEList(Set<Resource> initialResources) {
		EList<Resource> list= new BasicEList<Resource>();
		list.addAll(initialResources);
		return list;
	}

	private IProject getProjectForResource(Resource res, URIConverter converter)
	throws IllegalArgumentException {
		URI uri=converter.normalize(res.getURI());
		java.net.URI netUri= java.net.URI.create(uri.toString());
		IContainer[] result = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(netUri);
		IProject project=null;
		for(IFile file:ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(netUri)){
			project=file.getProject();
		}
		for(IContainer c: result)
			if(c instanceof IProject)
				project=(IProject) c;
		/*
		 * Think about a better way for resource without projects
		 */
		if(project==null)
			throw new IllegalArgumentException(uri +" is no valid Resource because not in the workspace");
		return project;
	}
	private Set<Resource> getAllResourceFromDirectory(IFolder modelDirectory) throws CoreException {
		final Set<Resource> resources= new HashSet<Resource>();
		for(IResource f:modelDirectory.members()){
			boolean successful=false;

			if (f.getFileExtension().endsWith("xmi")) {
				successful = checkIfResourceIsValidLoadable(org.eclipse.emf.common.util.URI.createURI(f.getLocationURI().toString()));
				XMIResourceImpl r = new XMIResourceImpl(URI.createURI(f.getLocationURI().toString()));
				/*
				 * FIXME, it is not clear if the LocationURI is the best one to give here, consider using an inputstream
				 */
				try{
					r.load(null);
					successful=true;
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}

				if(r.getErrors().size()>0)
					successful=false;
			}

			if(successful)
				resources.add(new XMIResourceImpl(URI.createURI(f.getLocationURI().toString())));
			//r.unload();

		}

		return resources;
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
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"*", new XMLResourceFactoryImpl());
		/*
		 * Load the resource using the URI
		 */
		Resource r = load_resourceSet.getResource(uri,true);

		/*
		 * FIXME, it is not clear if the LocationURI is the best one to give here, consider using an inputstream
		 */
		try{
			r.load(null);
			successful=true;
		}catch (Exception e) {
			// TODO: handle exception
		}

		if(r.getErrors().size()>0)
			successful=false;
		return successful;
	}

	private IFolder getModelDirectoryFromProject(IProject project)throws IllegalArgumentException {
		//refresh if project is not totally loaded some resources should appear hear
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IResource member = project.findMember("model", true);
		project.getLocation().toFile().listFiles();
		if(member==null || !(member instanceof IFolder))
			throw new IllegalArgumentException(project.getName() +" does not contain a model folder. It is invalid.");
		return (IFolder)member;
	}

	private EList<EObject> iteratorToEList(Iterator<Object> treeIterator) {
		EList<EObject> treeAsList= new BasicEList<EObject>();
		while(treeIterator.hasNext()){
			Object next=treeIterator.next();
			if(next instanceof EObject)
				treeAsList.add((EObject) next);
		}
		return treeAsList;
	}

	/**
	 * Computes recursively all referenced or referencing projects from a given pool and initial project
	 * @param project project to compute the references for
	 * @param referencedProjects list of all referenced projects, initial empty
	 * @param pool pool of all projects which can be in the references
	 * @param forward switch to decide if one get all reference projects of the given one or all referencing projects
	 * @return the List of all references
	 * @throws CoreException
	 */
	private EList<IProject> recursiveGetReferenceProjectsForEList(IProject project,EList<IProject> referencedProjects, Collection<IProject> pool, Boolean forward) throws CoreException{
		/*
		 * referencing in both directions is reflexive
		 */
		if(!referencedProjects.contains(project) && pool.contains(project))
			referencedProjects.add(project);

		IProject[] refProjects = null;
		if(forward)
			refProjects=project.getReferencedProjects();
		else
			refProjects= project.getReferencingProjects();

		for(IProject referenced:refProjects ){
			if(referencedProjects.contains(referenced))
				continue;
			if(!pool.contains(referenced))
				continue;
			referencedProjects.add(referenced);
			recursiveGetReferenceProjectsForEList(referenced, referencedProjects, pool, forward);
		}
		return referencedProjects;		
	}

	private EList<EObject> scopeAsEObjects(EList<Resource> resources) {
		EList<EObject> result= new BasicEList<EObject>();
		for(Resource resource: resources){
			/*
			 * FIXME unfortunately a memory leak
			 */

			result.addAll(iteratorToEList(EcoreUtil.getAllContents(resource, true)));
		}
		return result;
	}

	private EList<IProject> scopeAsProjects(Boolean forward) {
		EList<IProject> result= new BasicEList<IProject>();
		Collection<IProject> pool = Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects());

		for(IProject project: getInitialProjects()){
			try {
				result = recursiveGetReferenceProjectsForEList(project, result, pool, forward);
			} catch (CoreException e) {
				// TODO Add Exception to an intern array of errors
				e.printStackTrace();
			}
		}
		return result;
	}

	private EList<Resource> scopeAsResources(EList<IProject> projects)
	throws IllegalArgumentException {
		EList<Resource> result= new BasicEList<Resource>();
		for(IProject project: projects){
			IFolder modelDir = getModelDirectoryFromProject(project);
			try {
				result.addAll(getAllResourceFromDirectory(modelDir));
			} catch (CoreException e) {
				// TODO Add Exception to an intern array of errors
				e.printStackTrace();
			}
		}
		return result;
	}

	private EList<URI> scopeAsUris(EList<Resource> resources) {
		EList<URI> result= new BasicEList<URI>();
		for(Resource res: resources){
			result.add(res.getURI());
		}
		return result;
	}

} //ScopeProviderImpl
