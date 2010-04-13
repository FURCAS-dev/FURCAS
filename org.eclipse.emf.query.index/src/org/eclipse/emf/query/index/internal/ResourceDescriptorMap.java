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
package org.eclipse.emf.query.index.internal;

import org.eclipse.emf.query.index.internal.maps.SerializableMap;
/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
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