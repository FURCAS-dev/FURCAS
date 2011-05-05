package org.eclipse.emf.query.index.internal.maps;

/**
 * Represents a searializable Map. The Map is serialized according to the
 * {@link SerializationStrategy}
 * 
 */

public interface SerializableMap<K, E> {

	void serialize(SerializationStrategy<K, E> strategy);

	void deserialize(SerializationStrategy<K, E> strategy);
	
}
