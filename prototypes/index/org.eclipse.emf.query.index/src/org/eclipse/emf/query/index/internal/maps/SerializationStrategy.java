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
package org.eclipse.emf.query.index.internal.maps;

import java.util.List;
import java.util.Map;
/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public interface SerializationStrategy<K, E> {

	public interface Channel {
		public void putByte(byte b);

		public void putInt(int i);

		public void putLong(long l);

		public void putString(String s);
		
		public Map<String, Integer> putStringPool(List<String> strings);

		public byte getByte();

		public int getInt();

		public long getLong();

		public String getString();
		
		public String[] getStringPool();

		public void close();
	}

	public Channel getChannel();

	public void writeKey(K key);

	public void writeElement(E element);

	public K readKey();

	public E readElement(K key);
}
