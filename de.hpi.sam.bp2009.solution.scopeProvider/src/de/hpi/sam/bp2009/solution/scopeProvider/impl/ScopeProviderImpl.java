/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderPackage;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scope Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ScopeProviderImpl extends EObjectImpl implements ScopeProvider {
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
	 * Creates a new EList containing all Elements of the given set
	 * @param initialResources given Set
	 * @return new EList
	 */
	private EList<Resource> convertSetToEList(Set<Resource> initialResources) {
		EList<Resource> list= new BasicEList<Resource>();
		list.addAll(initialResources);
		return list;
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
			URI uri=converter.normalize(res.getURI());
			java.net.URI netUri= java.net.URI.create(uri.toString());
			IContainer[] result = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(netUri);
			IProject project=null;

			for(IContainer c: result)
				if(c instanceof IProject)
					project=(IProject) c;
			/*
			 * Think about a better way for resource without projects
			 */
			if(project==null)
				throw new IllegalArgumentException(uri +" is no valid Resource because not in the workspace");

			IResource member = project.findMember("model");
			if(member==null || !(member instanceof IFolder))
				throw new IllegalArgumentException(project.getName() +" does not contain a model folder. It is invalid.");
			
			final Set<Resource> resources= new HashSet<Resource>();
			try {
				member.accept(new IResourceVisitor() {
					@Override
					public boolean visit(IResource resource)  {
						boolean successful=false;
						if ("xmi".equals(resource.getFileExtension())) {
							ResourceImpl r= new ResourceImpl(URI.createURI(resource.getLocationURI().toString()));
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
						}
						
						if(successful)
							resources.add(new ResourceImpl(URI.createURI(resource.getLocationURI().toString())));
						//r.unload();

						return true;
					}
				}
				);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(resources.size()>0){
				
			}
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
	 * @generated
	 */
	public EList<Resource> getForwardScopeAsResources() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getForwardScopeAsEObjects() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URI> getForwardScopeAsURIs() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getBackwardScopeAsResources() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getBackwardScopeAsEObjects() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<URI> getBackwardScopeAsURIs() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //ScopeProviderImpl
