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

import org.eclipse.emf.query.index.internal.impl.EObjectDescriptorImpl;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy;
import org.eclipse.emf.query.index.internal.maps.SingleMap;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;

/**
 * Table for EObject. Fragments will be saved in a string pool
 * 
 * @author Martin Strenge, SAP AG
 * @author Bernd Kolb, SAP AG
 *
 */
public class EObjectTable extends SingleMap<String, EObjectDescriptorImpl> {

	public EObjectTable(int keyNr) {
		super(keyNr);
	}

	@Override
	public void deserialize(
			SerializationStrategy<String, EObjectDescriptorImpl> strategy) {
		Channel ch = strategy.getChannel();

		Object[] tab = new Object[ch.getInt()];
		int size = ch.getInt();

		String[]	stringPool = ch.getStringPool();
		
		String key;
		int pos;
		for (int i = 0; i < size; i++) {
			pos = ch.getInt();
			key = stringPool[ch.getInt()];
			tab[pos] = strategy.readElement(key);
		}

		this.initialize(tab, size);
	}

	@Override
	public void serialize(
			SerializationStrategy<String, EObjectDescriptorImpl> strategy) {

		Object[] tab = table;
		Channel ch = strategy.getChannel();

		ch.putInt(table.length);
		ch.putInt(this.size());
		
		ArrayList<String> strings = new ArrayList<String>(table.length);
		
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				EObjectDescriptorImpl e = (EObjectDescriptorImpl) tab[i];
				strings.add((String) e.getKeyElement(keyNr));
			}
		}
		
		Collections.sort(strings);
		
		Map<String,Integer> stringIndexes = ch.putStringPool(strings);
		
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] != null) {
				ch.putInt(i);
				EObjectDescriptorImpl e = (EObjectDescriptorImpl) tab[i];
				String key = (String) e.getKeyElement(keyNr);

				Integer stringIndex = stringIndexes.get(key);
				
				assert stringIndex != null;
				
				ch.putInt(stringIndex);
			}
		}

	}

	
}
