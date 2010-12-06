/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.internal.impl;

import java.util.Iterator;

import org.eclipse.emf.query.index.internal.PagingStrategy;
import org.eclipse.emf.query.index.internal.ResourceDescriptorInternal;
import org.eclipse.emf.query.index.internal.ResourceDescriptorMap;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy;
import org.eclipse.emf.query.index.internal.maps.SingleMap;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class PagingResourceDescriptorMap<K, V extends ResourceDescriptorInternal> implements ResourceDescriptorMap<K, V> {

	private SingleMap<K, V> resourceMap;

	private PagingStrategy<V> pagingStrategy;

	public PagingResourceDescriptorMap(int keyNr, PagingStrategy<V> pStrategy) {
		this.pagingStrategy = pStrategy;
		this.resourceMap = new SingleMap<K, V>(keyNr);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.index.internal.impl.ResourceDescriptorMap#put(V)
	 */
	public void putAndAcquire(V resDesc) {
		this.resourceMap.put(resDesc);
		this.pagingStrategy.addLocked(resDesc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.index.internal.impl.ResourceDescriptorMap#delete(V)
	 */
	public void delete(V resDesc) {
		this.pagingStrategy.remove(resDesc);
		this.resourceMap.remove(resDesc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.index.internal.impl.ResourceDescriptorMap#aquire(K)
	 */
	public V acquire(K resDescKey) {
		V resDesc = this.resourceMap.getEqual(resDescKey);
		if (resDesc != null) {
			this.pagingStrategy.lock(resDesc);
		}
		return resDesc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.index.internal.impl.ResourceDescriptorMap#release(V)
	 */
	public void release(V resDesc) {
		this.pagingStrategy.unlock(resDesc);
	}

	@Override
	public Iterable<K> getKeys() {
		final SingleMap<K, V> map = this.resourceMap;
		return new Iterable<K>() {

			@Override
			public Iterator<K> iterator() {
				return map.keyIterator();
			}

		};
	}

	// FIXME hack!!!
	public SingleMap<K, V> getUnderlyingMap() {
		return this.resourceMap;
	}

	@Override
	public K getExistingKey(Object k) {
		return this.resourceMap.getExistingKey(k);
	}
	
	public void flush() {
		this.pagingStrategy.flush();
	}

	@Override
	public void serialize(SerializationStrategy<K, V> strategy) {
		this.resourceMap.serialize(strategy);
	}

	@Override
	public void deserialize(SerializationStrategy<K, V> strategy) {
		this.resourceMap.deserialize(strategy);
	}

}
