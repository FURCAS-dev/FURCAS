/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;

/**
 * @author koehnlein - Initial contribution and API
 */
public class PriorizedList<E> {

	final class PriorizedElement {
		private final E element;
		private final int priority;

		public PriorizedElement(E element, int priority) {
			this.element = element;
			this.priority = priority;
		}

		public E getElement() {
			return element;
		}

		public int getPriority() {
			return priority;
		}
	}

	private SortedSet<PriorizedElement> elements;

	public PriorizedList() {
		elements = new TreeSet<PriorizedElement>(new Comparator<PriorizedElement>() {
			public int compare(PriorizedElement element0, PriorizedElement element1) {
				return element1.getPriority() - element0.getPriority();
			}
		});
	}

	public boolean add(E element, int priority) {
		return elements.add(new PriorizedElement(element, priority));
	}

	public void clear() {
		elements.clear();
	}

	public Iterator<E> iterator() {
		return Iterators.transform(elements.iterator(), new Function<PriorizedElement, E>() {
			public E apply(PriorizedElement from) {
				return from.getElement();
			}
		});
	}

	public boolean remove(final E element) {
		PriorizedElement match = Iterators.find(elements.iterator(), new Predicate<PriorizedElement>() {
			public boolean apply(PriorizedElement input) {
				return input.getElement().equals(element);
			}
		});
		return match != null && elements.remove(match);
	}
}
