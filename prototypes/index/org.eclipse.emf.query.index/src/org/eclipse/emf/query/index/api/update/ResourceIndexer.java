package org.eclipse.emf.query.index.api.update;

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
import org.eclipse.emf.query.index.api.Index;

public class ResourceIndexer {

	protected void resourceChanged(final Index index, IndexUpdater updater, final Resource... resources) {
		ResourceSet resourceSet = resources[0].getResourceSet();
		URIConverter uriConverter = (resourceSet != null) ? resourceSet.getURIConverter() : URIConverter.INSTANCE;
		Map<EClass, String> typeMap = new IdentityHashMap<EClass, String>();
		for (Resource resource : resources) {
			String resourceUri = resource.getURI().toString();

			updater.insertResource(resourceUri, System.currentTimeMillis(), getResourceUserData(resource));

			for (Iterator<EObject> i = EcoreUtil.getAllProperContents(resource, false); i.hasNext();) {
				EObject element = i.next();
				if (isIndexElement(element)) {

					String fragment = resource.getURIFragment(element);
					EClass type = element.eClass();
					String typeUri;
					if ((typeUri = typeMap.get(type)) == null) {
						typeMap.put(type, typeUri = EcoreUtil.getURI(type).fragment());
					}

					updater.insertEObject(resourceUri, fragment, typeUri, getEObjectName(element), getEObjectUserData(element));

					for (EReference eReference : element.eClass().getEAllReferences()) {
						if (isIndexReference(eReference, element)) {
							String refString = EcoreUtil.getURI(eReference).toString();

							if (eReference.isMany()) {
								List<?> targets = (List<?>) element.eGet(eReference, false);
								for (int idx = 0; idx < targets.size(); ++idx) {
									Object target = targets.get(idx);
									createEReferenceDescriptor(updater, uriConverter, resourceUri, fragment, refString, target);
								}
							} else {
								Object target = element.eGet(eReference, false);
								createEReferenceDescriptor(updater, uriConverter, resourceUri, fragment, refString, target);
							}
						}
					}
				}
			}
		}
	}

	private void createEReferenceDescriptor(IndexUpdater updater, URIConverter uriConverter, String srcResourceUri,
			String sourceFragment, String reference, Object target) {
		if (target instanceof EObject) {
			URI targetURI = uriConverter.normalize(EcoreUtil.getURI((EObject) target));
			if (targetURI != null) {
				updater.insertEReference(srcResourceUri, sourceFragment, reference, targetURI.trimFragment().toString(), targetURI
						.fragment());
			}
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

	private String getEObjectName(EObject element) {
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
