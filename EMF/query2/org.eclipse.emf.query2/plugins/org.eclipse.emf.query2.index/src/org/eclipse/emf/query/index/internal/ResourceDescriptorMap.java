package org.eclipse.emf.query.index.internal;

import org.eclipse.emf.query.index.internal.maps.SerializableMap;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
/**
 * Represents Map that assembles all the {@link ResourceDescriptor} internally.
 * 
 */
public interface ResourceDescriptorMap<K, V extends ResourceDescriptorInternal> extends SerializableMap<K, V> {

	public void putAndAcquire(V resDesc);

	public void delete(V resDesc);

	public V acquire(K resDescKey);

	public void release(V resDesc);

	public Iterable<K> getKeys();

	public K getExistingKey(Object k);
}