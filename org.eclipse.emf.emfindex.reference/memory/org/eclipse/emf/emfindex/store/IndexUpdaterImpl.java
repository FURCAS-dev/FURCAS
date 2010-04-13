/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.store;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.EReferenceDescriptor;
import org.eclipse.emf.emfindex.MemoryIndexImpl;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.index.ecore.emfindex.EmfindexFactory;
import org.eclipse.emf.index.ecore.emfindex.impl.AbstractBaseDescriptorImpl;
import org.eclipse.emf.index.ecore.emfindex.impl.ContainerDescriptorImpl;
import org.eclipse.emf.index.ecore.emfindex.impl.EObjectDescriptorImpl;
import org.eclipse.emf.index.ecore.emfindex.impl.EReferenceDescriptorImpl;
import org.eclipse.emf.index.ecore.emfindex.impl.ResourceDescriptorImpl;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;

/**
 * @author koehnlein
 */
public class IndexUpdaterImpl implements IndexUpdater {

	protected MemoryIndexImpl index;

	@Inject
	public IndexUpdaterImpl(MemoryIndexImpl index) {
		this.index = index;
	}

	public void createContainer(String containerName,
			Map<String, String> userData) {
		assertNotNull(containerName);
		ContainerDescriptorImpl containerDescriptor = internalCreateOrUpdateContainer(containerName);
		updateUserData(containerDescriptor, userData);
	}

	private void assertNotNull(Object obj) {
		if (obj==null)
			throw new NullPointerException();
	}

	public void deleteContainer(String containerName) {
		final String normalizedContainerName = normalizeContainerName(containerName);
		ContainerDescriptor containerDescriptor = findContainerDescriptor(normalizedContainerName);
		if (containerDescriptor != null) {
			remove(containerDescriptor);
		}
	}

	public void createOrUpdateResource(String containerName, URI resourceURI,
			long version, Map<String, String> userData) {
		assertNotNull(resourceURI);
		ResourceDescriptorImpl resourceDescriptor = internalCreateOrUpdateResource(
				containerName, resourceURI, version);
		resourceDescriptor.getEObjectDescriptors().clear();
		resourceDescriptor.getEReferenceDescriptors().clear();
		updateUserData(resourceDescriptor, userData);
	}

	public void deleteResource(URI resourceURI) {
		assertNotNull(resourceURI);
		ResourceDescriptorImpl resourceDescriptor = findResourceDescriptor(resourceURI);
		remove(resourceDescriptor);
	}

	public void createOrUpdateEObject(URI resourceURI, String fragment,
			String name, EClass type, Map<String, String> userData) {
		assertNotNull(resourceURI);
		assertNotNull(fragment);
		EObjectDescriptorImpl eObjectDescriptor = internalCreateOrUpdateEObject(
				resourceURI, fragment, name, type);
		updateUserData(eObjectDescriptor, userData);
	}

	public void deleteEObject(URI resourceURI, String fragment) {
		assertNotNull(resourceURI);
		assertNotNull(fragment);
		ResourceDescriptorImpl resourceDescriptor = findResourceDescriptor(resourceURI);
		if (resourceDescriptor != null) {
			EObjectDescriptorImpl eObjectDescriptor = findEObjectDescriptor(
					resourceDescriptor, fragment);
			if (eObjectDescriptor != null) {
				remove(eObjectDescriptor);
			}
		}
	}

	public void createOrUpdateEReference(URI sourceResourceURI,
			String sourceFragment, URI targetEObjectURI, EReference reference,
			Map<String, String> userData) {
		assertNotNull(sourceResourceURI);
		assertNotNull(sourceFragment);
		assertNotNull(targetEObjectURI);
		assertNotNull(reference);
		EReferenceDescriptorImpl eReferenceDescriptor = internalCreateOrUpdateEReference(
				sourceResourceURI, sourceFragment, targetEObjectURI, reference);
		updateUserData(eReferenceDescriptor, userData);
	}

	public void deleteEReference(URI sourceResourceURI, String sourceFragment,
			URI targetEObjectURI, EReference reference) {
		assertNotNull(sourceResourceURI);
		assertNotNull(sourceFragment);
		assertNotNull(targetEObjectURI);
		assertNotNull(reference);
		ResourceDescriptorImpl sourceResourceDescriptor = findResourceDescriptor(sourceResourceURI);
		if (sourceResourceDescriptor != null) {
			EReferenceDescriptor eReferenceDescriptor = findEReferenceDescriptor(
					sourceResourceDescriptor, sourceFragment, targetEObjectURI,
					reference);
			if (eReferenceDescriptor != null) {
				remove(eReferenceDescriptor);
			}
		}
	}

	private String normalizeContainerName(String containerName) {
		final String realContainerName = (containerName != null) ? containerName
				: ContainerDescriptor.DEFAULT_CONTAINER_NAME;
		return realContainerName;
	}

	private ContainerDescriptorImpl internalCreateOrUpdateContainer(
			String containerName) {
		final String realContainerName = normalizeContainerName(containerName);
		ContainerDescriptorImpl exisitingContainerDescriptor = findContainerDescriptor(realContainerName);
		if (exisitingContainerDescriptor != null) {
			return exisitingContainerDescriptor;
		}
		ContainerDescriptorImpl newContainerDescriptor = (ContainerDescriptorImpl) EmfindexFactory.eINSTANCE
				.createContainerDescriptor();
		newContainerDescriptor.setName(realContainerName);
		index.createResource().getContents().add(newContainerDescriptor);
		return newContainerDescriptor;
	}

	private ResourceDescriptorImpl internalCreateOrUpdateResource(
			String containerName, URI resourceURI, long version) {
		ResourceDescriptorImpl resourceDescriptor = findResourceDescriptor(resourceURI);
		if (resourceDescriptor == null) {
			resourceDescriptor = (ResourceDescriptorImpl) EmfindexFactory.eINSTANCE
					.createResourceDescriptor();
			resourceDescriptor.setURI(resourceURI);
			resourceDescriptor.setIndexedVersion(version);
		}
		ContainerDescriptor existingContainerDescriptor = resourceDescriptor
			.getContainer();
		if(existingContainerDescriptor == null || containerName != null) {
			ContainerDescriptor newContainerDescriptor = internalCreateOrUpdateContainer(containerName);
			resourceDescriptor.setContainer(newContainerDescriptor);
		}
		return resourceDescriptor;
	}

	private EObjectDescriptorImpl internalCreateOrUpdateEObject(
			URI resourceURI, final String fragment, String name, EClass type) {
		ResourceDescriptorImpl resourceDescriptor = internalCreateOrUpdateResource(
				null, resourceURI, ResourceDescriptor.UNSPECIFIED_VERSION);
		EObjectDescriptorImpl existingEObjectDescriptor = findEObjectDescriptor(
				resourceDescriptor, fragment);
		if (existingEObjectDescriptor != null) {
			existingEObjectDescriptor.setName(name);
			existingEObjectDescriptor.setEClass(type);
			return existingEObjectDescriptor;
		}
		EObjectDescriptorImpl eObjectDescriptor = (EObjectDescriptorImpl) EmfindexFactory.eINSTANCE
				.createEObjectDescriptor();
		eObjectDescriptor.setName(name);
		eObjectDescriptor.setFragment(fragment);
		eObjectDescriptor.setResourceDescriptor(resourceDescriptor);
		eObjectDescriptor.setEClass(type);
		EObjectDescriptorImpl newEObjectDescriptor = eObjectDescriptor;
		return newEObjectDescriptor;
	}

	private EReferenceDescriptorImpl internalCreateOrUpdateEReference(
			URI sourceResourceURI, String sourceFragment, URI targetEObjectURI,
			EReference reference) {
		ResourceDescriptorImpl sourceResourceDescriptor = internalCreateOrUpdateResource(
				null, sourceResourceURI, ResourceDescriptor.UNSPECIFIED_VERSION);
		EReferenceDescriptorImpl existingEReferenceDescriptor = findEReferenceDescriptor(
				sourceResourceDescriptor, sourceFragment, targetEObjectURI,
				reference);
		if (existingEReferenceDescriptor != null) {
			return existingEReferenceDescriptor;
		}
		EReferenceDescriptorImpl eReferenceDescriptor = (EReferenceDescriptorImpl) EmfindexFactory.eINSTANCE
				.createEReferenceDescriptor();
		eReferenceDescriptor.setSourceFragment(sourceFragment);
		eReferenceDescriptor.setTargetFragment(targetEObjectURI.fragment());
		eReferenceDescriptor.setTargetResourceURI(targetEObjectURI
				.trimFragment());
		eReferenceDescriptor.setEReference(reference);
		eReferenceDescriptor
				.setSourceResourceDescriptor(sourceResourceDescriptor);
		EReferenceDescriptorImpl newEReferenceDescriptor = eReferenceDescriptor;
		return newEReferenceDescriptor;
	}

	private ContainerDescriptorImpl findContainerDescriptor(
			final String containerName) {
		Iterator<ContainerDescriptor> filter = Iterators.filter(index
				.allContainerDescriptors(),
				new Predicate<ContainerDescriptor>() {
					public boolean apply(ContainerDescriptor containerDescriptor) {
						return containerName.equals(containerDescriptor
								.getName());
					}
				});
		return (ContainerDescriptorImpl) ((filter.hasNext()) ? filter.next()
				: null);
	}

	private ResourceDescriptorImpl findResourceDescriptor(URI resourceURI) {
		Iterator<ResourceDescriptor> descriptors = index.allResourceDescriptors();
		while (descriptors.hasNext()) {
			ResourceDescriptor resourceDescriptor = descriptors.next();
			if (resourceDescriptor.getURI().equals(resourceURI))
				return (ResourceDescriptorImpl) resourceDescriptor;
		}
		return null;
	}

	private EObjectDescriptorImpl findEObjectDescriptor(
			ResourceDescriptor resourceDescriptor, final String fragment) {
		Iterator<EObjectDescriptor> filter = Iterators.filter(
				resourceDescriptor.getEObjectDescriptors().iterator(),
				new Predicate<EObjectDescriptor>() {
					public boolean apply(EObjectDescriptor eObjectDescriptor) {
						return eObjectDescriptor.equals(fragment);
					}
				});
		return (EObjectDescriptorImpl) ((filter.hasNext()) ? filter.next()
				: null);
	}

	private EReferenceDescriptorImpl findEReferenceDescriptor(
			ResourceDescriptorImpl sourceResourceDescriptor,
			final String sourceFragment, final URI targetEObjectURI,
			final EReference reference) {
		Iterator<EReferenceDescriptor> filter = Iterators.filter(
				sourceResourceDescriptor.getEReferenceDescriptors().iterator(),
				new Predicate<EReferenceDescriptor>() {
					public boolean apply(
							EReferenceDescriptor eReferenceDescriptor) {
						return eReferenceDescriptor.getSourceFragment().equals(
								sourceFragment)
								&& eReferenceDescriptor.getTargetFragmentURI()
										.equals(targetEObjectURI)
								&& eReferenceDescriptor.getEReference().equals(
										reference);
					}
				});
		return (EReferenceDescriptorImpl) ((filter.hasNext()) ? filter.next()
				: null);
	}

	private void remove(Object oldObject) {
		if (oldObject instanceof InternalEObject) {
			InternalEObject oldEObject = (InternalEObject) oldObject;
			Resource resource = ((InternalEObject) oldObject).eDirectResource();
			EcoreUtil.remove(oldEObject);
			if (resource != null) {
				if (resource.getContents().isEmpty()) {
					index.deleteResource(resource);
				} else {
					resource.setModified(true);
				}
			}
		}
	}

	private void updateUserData(AbstractBaseDescriptorImpl baseDescriptor,
			Map<String, String> userData) {
		baseDescriptor.unsetUserData();
		if (userData != null) {
			for (Map.Entry<String, String> userDataEntry : userData
					.entrySet()) {
				baseDescriptor.setUserData(userDataEntry.getKey(),
						userDataEntry.getValue());
			}
		}
	}

}
