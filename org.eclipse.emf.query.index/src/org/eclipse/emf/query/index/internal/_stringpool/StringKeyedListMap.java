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
package org.eclipse.emf.query.index.internal._stringpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.query.index.internal.maps.ListMap;
import org.eclipse.emf.query.index.internal.maps.MapEntry;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;

/**
 * List map keyed with strings. Keys will be output in a string pool.
 * 
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 * 
 */
public class StringKeyedListMap<E extends MapEntry> extends ListMap<String, E> {

	public StringKeyedListMap(int keyNr, int capacity) {
		super(keyNr, capacity);
	}

	@Override
	public void deserialize(SerializationStrategy<String, E> strategy) {

		Channel ch = strategy.getChannel();

		Object[] tab = new Object[ch.getInt()];
		int size = ch.getInt();

		String[] stringPool = ch.getStringPool();

		String key;
		int listPos;
		int listSize;
		MapEntry[] list;
		for (int i = 0; i < size; i++) {
			listPos = ch.getInt();
			key = stringPool[ch.getInt()];
			listSize = ch.getInt();
			list = new MapEntry[listSize];
			for (int j = 0; j < listSize; j++) {
				list[j] = strategy.readElement(key);
			}
			tab[listPos] = list;
		}

		this.initialize(tab, size);

	}

	@Override
	public void serialize(SerializationStrategy<String, E> strategy) {
		Object[] tab = table;
		int keyNr = this.keyNr;
		Channel ch = strategy.getChannel();

		// FIXME write arraySize OOME secure
		ch.putInt(table.length);
		ch.putInt(this.size());

		ArrayList<String> strings = new ArrayList<String>(table.length);

		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				E[] list = (E[]) tab[i];

				strings.add((String) list[0].getKeyElement(keyNr));
			}
		}

		Collections.sort(strings);

		Map<String, Integer> stringIndexes = ch.putStringPool(strings);

		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				ch.putInt(i);
				E[] list = (E[]) tab[i];
				String key = (String) list[0].getKeyElement(keyNr);

				Integer stringIndex = stringIndexes.get(key);

				assert stringIndex != null;

				ch.putInt(stringIndex);

				ch.putInt(list.length);
				for (int j = 0; j < list.length; j++) {
					strategy.writeElement(list[j]);
				}
			}
		}

	}

}
