package org.eclipse.emf.query.index.internal;

import org.eclipse.emf.query.index.internal.maps.MapEntry;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
/**
 * Is an internal implementation of ResourceDescriptor
 * 
 */
public interface ResourceDescriptorInternal extends ResourceDescriptor, PageableElement, MapEntry {

	public static final long NOT_INDEXED = -2; //changing the not indexed constant from -1 to -2 because
	// unloading the resource makes the times stamp as -1.

	void addEObjectDescriptor(EObjectDescriptor eod);

	void addReferenceDescriptor(EReferenceDescriptor refDesc);

	EObjectDescriptor getEObjectDescriptor(String fragment);

}
