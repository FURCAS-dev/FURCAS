package org.eclipse.emf.query.index.update;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ResourceIndexer {

	public static final ResourceIndexer INSTANCE = new ResourceIndexer();

	public final void resourceChanged(IndexUpdater updater, final Resource... resources) {
		ResourceSet resourceSet = resources[0].getResourceSet();
		URIConverter uriConverter = (resourceSet != null) ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
		Map<Object, String> cache = new IdentityHashMap<Object, String>();
		for (Resource resource : resources) {
			String resourceUri = resource.getURI().toString();
			cache.put(resource, resourceUri);

			updater.insertResource(resourceUri, resource.getTimeStamp(), getResourceUserData(resource));

			for (EObject child : resource.getContents()) {
				addContent(updater, uriConverter, cache, resource, resourceUri, child);
			}
		}
	}

	private void addContent(IndexUpdater updater, URIConverter uriConverter, Map<Object, String> cache, Resource resource,
			String resourceUri, EObject element) {
		if (element.eResource() == resource && isIndexElement(element)) {

			String fragment;
			if ((fragment = cache.get(element)) == null) {
				cache.put(element, fragment = resource.getURIFragment(element));
			}
			EClass type = element.eClass();
			String typeUri;
			if ((typeUri = cache.get(type)) == null) {
				cache.put(type, typeUri = EcoreUtil.getURI(type).toString());
			}

			updater.insertEObject(resourceUri, fragment, typeUri, getEObjectName(element), getEObjectUserData(element));

			for (EReference eReference : element.eClass().getEAllReferences()) {
				if (isIndexReference(eReference, element)) {
					String refString;
					if ((refString = cache.get(eReference)) == null) {
						cache.put(eReference, refString = EcoreUtil.getURI(eReference).toString());
					}

					if (eReference.isMany()) {
						List<?> targets = (List<?>) element.eGet(eReference, false);
						for (int idx = 0; idx < targets.size(); ++idx) {
							Object target = targets.get(idx);
							createEReferenceDescriptor(updater, cache, uriConverter, resourceUri, fragment, refString, target);
						}
					} else {
						Object target = element.eGet(eReference, false);
						createEReferenceDescriptor(updater, cache, uriConverter, resourceUri, fragment, refString, target);
					}
				}
			}
			for (EObject child : element.eContents()) {
				this.addContent(updater, uriConverter, cache, resource, resourceUri, child);
			}
		}
	}

	private void createEReferenceDescriptor(IndexUpdater updater, Map<Object, String> cache, URIConverter uriConverter,
			String srcResourceUri, String sourceFragment, String reference, Object target) {
		if (target instanceof EObject) {
			String resUri;
			Resource eResource = ((EObject) target).eResource();
			String uriFragment;
			if (eResource != null) {
				if ((resUri = cache.get(eResource)) == null) {
					cache.put(eResource, resUri = uriConverter.normalize(eResource.getURI()).toString());
				}
				if ((uriFragment = cache.get(target)) == null) {
					cache.put(target, uriFragment = eResource.getURIFragment((EObject) target));
				}
			} else {
				URI normalizedUri = uriConverter.normalize(EcoreUtil.getURI((EObject) target));
				uriFragment = normalizedUri.fragment();
				resUri = normalizedUri.trimFragment().toString();
			}
			updater.insertEReference(srcResourceUri, sourceFragment, reference, resUri, uriFragment);
		}
	}

	protected boolean isIndexReference(EReference reference, EObject element) {
		return !reference.isContainment() && !reference.isDerived() && element.eIsSet(reference);
	}

	protected boolean isIndexElement(EObject element) {
		return true;
	}

	protected Map<String, String> getEObjectUserData(EObject element) {
		return null;
	}

	protected String getEObjectName(EObject element) {
		EStructuralFeature nameFeature = element.eClass().getEStructuralFeature("name");
		if (nameFeature != null && nameFeature.getEType() instanceof EDataType) {
			if (!nameFeature.isMany()) {
				Object nameFeatureValue = element.eGet(nameFeature);
				return (nameFeatureValue == null) ? null : nameFeatureValue.toString();
			} else {
				List<?> names = (List<?>) element.eGet(nameFeature);
				StringBuilder b = new StringBuilder();
				for (Iterator<?> nameIter = names.iterator(); nameIter.hasNext();) {
					b.append(nameIter.next().toString());
				}
				return b.toString();
			}
		}
		return null;
	}

	protected Map<String, String> getResourceUserData(Resource res) {
		return null;
	}
}
