/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.impl.memory;

import static org.eclipse.emf.index.util.CollectionUtils.isNotEmpty;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.index.IDAO;
import org.eclipse.emf.index.IGenericQuery;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.event.impl.IndexChangeEventImpl;

/**
 * @author Jan K�hnlein - Initial contribution and API
 */
public abstract class BasicMemoryDAOImpl<T> implements IDAO<T>, Serializable {

	private static final long serialVersionUID = -5346820953902280859L;

	protected Set<T> store;

	/**
	 * The index store is not injected but set through {@link #initialize(IndexStore)} to avoid dependency circle.
	 */
	protected transient IndexStore indexStore;

	protected BasicMemoryDAOImpl() {
		this.store = new HashSet<T>();
	}

	public void store(T element) {
		store.add(element);
		indexStore.fireIndexChangedEvent(new IndexChangeEventImpl(element, IndexChangeEvent.Type.ADDED));
	}

	public void delete(T element) {
		store.remove(element);
		indexStore.fireIndexChangedEvent(new IndexChangeEventImpl(element, IndexChangeEvent.Type.REMOVED));
	}

	public void modify(T element, Object modification) {
		if (doModify(element, modification))
			indexStore.fireIndexChangedEvent(new IndexChangeEventImpl(element, IndexChangeEvent.Type.MODIFIED));
	}

	public void initialize(IndexStore indexStore) {
		this.indexStore = indexStore;
	}

	protected abstract boolean doModify(T element, Object modification);

	protected abstract class Query implements IGenericQuery<T> {

		protected boolean matchesGlobbing(Serializable test, Serializable pattern) {
			if (test instanceof String && pattern instanceof String) {
				String testAsString = (String) test;
				String patternAsString = (String) pattern;
				matchesGlobbing(testAsString, patternAsString);
			}

			return test.equals(pattern);
		}

		protected boolean matchesGlobbing(String testString, String pattern) {
			if (pattern == null)
				return true;
			if (testString == null || "".equals(pattern))
				return false;
			int patternLength = pattern.length();
			if (pattern.charAt(0) == WILDCARD) {
				if (patternLength > 1 && pattern.charAt(patternLength - 1) == WILDCARD) {
					return testString.contains(pattern.substring(1, patternLength - 2));
				}
				return testString.endsWith(pattern.substring(1));
			}
			if (pattern.charAt(patternLength - 1) == WILDCARD) {
				return testString.startsWith(pattern.substring(0, patternLength - 1));
			}
			return testString.equals(pattern);
		}

		protected abstract boolean matches(T object);

		/**
		 * @return an empty list if the scope is specified but empty null it the scope is unspecified
		 */
		protected Collection<T> scope() {
			return store;
		}

		public T executeSingleResult() {
			try {
				indexStore.beginRead();
				Collection<T> queryScope = scope();
				if (queryScope != null)
					for (T candidate : queryScope) {
						if (matches(candidate)) {
							return candidate;
						}
					}
				return null;
			}
			finally {
				indexStore.endRead();
			}
		}

		public List<T> executeListResult() {
			try {
				indexStore.beginRead();
				List<T> result = null;
				Collection<T> queryScope = scope();
				if (queryScope != null) {
					for (T candidate : queryScope) {
						if (matches(candidate)) {
							if (result == null)
								result = new ArrayList<T>();
							result.add(candidate);
						}
					}
				}
				return (result == null) ? Collections.<T>emptyList() : result;
			}
			finally {
				indexStore.endRead();
			}
		}

		protected Collection<T> mergeScopes(Collection<T> scope0, Collection<T> scope1) {
			if (scope0 == null) {
				return scope1;
			}
			if (scope1 == null) {
				return scope0;
			}
			if (isNotEmpty(scope0)) {
				if (isNotEmpty(scope1)) {
					List<T> mergedScope = new ArrayList<T>(scope0);
					mergedScope.retainAll(scope1);
					return mergedScope;
				}
				return scope0;
			}
			return scope1;
		}
	}

	public void save(ObjectOutputStream out) throws IOException {
		out.writeInt(store.size());
		for (T descriptor : store) {
			out.writeObject(descriptor);
		}
	}

}
