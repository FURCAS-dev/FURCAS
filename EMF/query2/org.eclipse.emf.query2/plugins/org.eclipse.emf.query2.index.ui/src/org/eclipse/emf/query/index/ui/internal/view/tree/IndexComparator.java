package org.eclipse.emf.query.index.ui.internal.view.tree;

import java.util.Comparator;

import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.EObjectsGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IncomingLinksGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IndexTypeURI;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.OutgoingLinksGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceIndexGroup;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceType;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.TypeIndexGroup;

/**
 * @author Animesh Kumar, SAP Labs India Pvt. Ltd.
 * 
 */
@SuppressWarnings({ "rawtypes" })
public class IndexComparator implements Comparator {

	public int compare(Object arg0, Object o2) {
		if (arg0 instanceof ResourceIndexGroup && o2 instanceof ResourceIndexGroup) {
			if (((ResourceIndexGroup) arg0).getResourceIndexGroup().equals(((ResourceIndexGroup) o2).getResourceIndexGroup())) {
				return 0;
			}

		} else if (arg0 instanceof ResourceDescriptor && o2 instanceof ResourceDescriptor) {
			if (((ResourceDescriptor) arg0).getURI().equals(((ResourceDescriptor) o2).getURI())) {
				return 0;
			}
		} else if (arg0 instanceof EObjectDescriptor && o2 instanceof EObjectDescriptor) {
			if (((EObjectDescriptor) arg0).getEClassURI().equals(((EObjectDescriptor) o2).getEClassURI())) {
				return 0;
			}
		} else if (arg0 instanceof EReferenceDescriptor && o2 instanceof EReferenceDescriptor) {
			if (((EReferenceDescriptor) arg0).getEReferenceURI().equals(((EReferenceDescriptor) o2).getEReferenceURI())) {
				return 0;
			}
		} else if (arg0 instanceof EObjectsGroup && o2 instanceof EObjectsGroup) {
			if (((EObjectsGroup) arg0).getEObjectsGroup().equals(((EObjectsGroup) o2).getEObjectsGroup())) {
				return 0;
			}
		} else if (arg0 instanceof IncomingLinksGroup && o2 instanceof IncomingLinksGroup) {
			if (((IncomingLinksGroup) arg0).getIncomingLinksGroup().equals(((IncomingLinksGroup) o2).getIncomingLinksGroup())) {
				return 0;
			}
		} else if (arg0 instanceof OutgoingLinksGroup && o2 instanceof OutgoingLinksGroup) {
			if (((OutgoingLinksGroup) arg0).getOutgoingLinksGroup().equals(((OutgoingLinksGroup) o2).getOutgoingLinksGroup())) {
				return 0;
			}
		} else if (arg0 instanceof TypeIndexGroup && o2 instanceof TypeIndexGroup) {
			if (((TypeIndexGroup) arg0).getTypeIndexGroup().equals(((TypeIndexGroup) o2).getTypeIndexGroup())) {
				return 0;
			}
		} else if (arg0 instanceof ResourceType && o2 instanceof ResourceType) {
			if (((ResourceType) arg0).getElementType().equals(((ResourceType) o2).getElementType())) {
				return 0;
			}
		} else if (arg0 instanceof IndexTypeURI && o2 instanceof IndexTypeURI) {
			if (((IndexTypeURI) arg0).getURI().equals(((IndexTypeURI) o2).getURI())) {
				return 0;
			}
		}
		return -1;
	}


}
