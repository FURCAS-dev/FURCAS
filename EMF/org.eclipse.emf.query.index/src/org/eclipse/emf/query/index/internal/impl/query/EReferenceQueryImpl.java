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
package org.eclipse.emf.query.index.internal.impl.query;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.EReferenceDescriptorInternal;
import org.eclipse.emf.query.index.internal.QueryExecutorInternal;
import org.eclipse.emf.query.index.internal.QueryInternal;
import org.eclipse.emf.query.index.internal.impl.GlobalTables;
import org.eclipse.emf.query.index.internal.impl.PageableResourceDescriptorImpl;
import org.eclipse.emf.query.index.internal.impl.PagingResourceDescriptorMap;
import org.eclipse.emf.query.index.internal.impl.ReferenceDescriptorImpl;
import org.eclipse.emf.query.index.internal.util.FilteredIterable;
import org.eclipse.emf.query.index.internal.util.FilteredIterableMulti;
import org.eclipse.emf.query.index.query.EObjectQuery;
import org.eclipse.emf.query.index.query.EReferenceQuery;
import org.eclipse.emf.query.index.query.QueryResult;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class EReferenceQueryImpl<RDType> implements EReferenceQuery<RDType>, QueryInternal<RDType, EReferenceDescriptor> {

	private EObjectQueryImpl<EObjectDescriptor> srcEObjectQuery;
	private String type;
	private EObjectQueryImpl<EObjectDescriptor> tgtEObjectQuery;

	private Set<URI> srcResScope;
	private Set<URI> tgtResScope;
	private Direction direction;

	public enum Direction {
		FORWARD, BACKWARD;
	}

	@Override
	public QueryResult<RDType> execute(QueryExecutorInternal queryExecutor, final GlobalTables globalTables) {
		final Iterator<URI> resourceScope = this.getResourceScope(globalTables).iterator();
		final PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceMap = globalTables.resourceIndex;
		return this.createQueryResult(queryExecutor, new FilteredIterableMulti<EReferenceDescriptor>() {

			@Override
			protected Iterator<? extends EReferenceDescriptor> getNextIterator() {
				while (resourceScope.hasNext()) {
					Iterable<? extends EReferenceDescriptor> posRet = null;
					PageableResourceDescriptorImpl resDesc = resourceMap.acquire(resourceScope.next());
					if (resDesc.isIndexed() || direction == Direction.BACKWARD) {
						posRet = queryEReferenceDescriptor(resDesc, globalTables);
					}
					resourceMap.release(resDesc);
					if (posRet != null) {
						return posRet.iterator();
					}
				}
				return null;
			}

			@Override
			protected boolean matches(EReferenceDescriptor e) {
				return true;
			}

		});

	}

	public Iterable<URI> getResourceScope(GlobalTables globalTables) {
		String tgtFragment = null;
		String srcFragment = null;

		this.srcResScope = null;
		this.tgtResScope = null;

		if (srcEObjectQuery != null) {
			this.srcResScope = new LinkedHashSet<URI>();
			for (URI next : srcEObjectQuery.getResourceScope(globalTables)) {
				srcResScope.add(next);
				// TODO set *ResScope to null if it is the whole resource table
			}
			srcFragment = srcEObjectQuery.getFragment();
		}
		if (tgtEObjectQuery != null) {
			this.tgtResScope = new LinkedHashSet<URI>();
			for (URI next : tgtEObjectQuery.getResourceScope(globalTables)) {
				tgtResScope.add(next);
			}
			tgtFragment = tgtEObjectQuery.getFragment();
		}

		if (srcResScope == null && tgtResScope == null) {
			if (tgtFragment == null || srcFragment != null) {
				this.direction = Direction.FORWARD;
			} else {
				this.direction = Direction.BACKWARD;
			}
			return globalTables.resourceIndex.getKeys();
		} else {
			if (size(srcResScope) >= size(tgtResScope)) {
				this.direction = Direction.FORWARD;
				return srcResScope;
			} else {
				this.direction = Direction.BACKWARD;
				return tgtResScope;
			}
		}
	}

	private int size(Set<?> set) {
		return set == null ? -1 : set.size();
	}

	public Direction getDirection() {
		return this.direction;
	}

	public EObjectQueryImpl<EObjectDescriptor> getSrcObjectQuery() {
		return this.srcEObjectQuery;
	}

	public EObjectQueryImpl<EObjectDescriptor> getTgtObjectQuery() {
		return this.tgtEObjectQuery;
	}

	public String getType() {
		return this.type;
	}

	public Set<URI> getTargetScope() {
		return this.tgtResScope;
	}

	public Set<URI> getSourceScope() {
		return this.srcResScope;
	}

	/*
	 * Query interface (non-Javadoc)
	 */

	@Override
	public void eReferenceURI(URI referenceURI) {
		this.type = referenceURI.toString().intern();
	}

	@Override
	public EObjectQuery<EObjectDescriptor> sourceEObject() {
		if (this.srcEObjectQuery == null) {
			this.srcEObjectQuery = new EObjectQueryImpl<EObjectDescriptor>();
		}
		return this.srcEObjectQuery;
	}

	@Override
	public EObjectQuery<EObjectDescriptor> targetEObject() {
		if (this.tgtEObjectQuery == null) {
			this.tgtEObjectQuery = new EObjectQueryImpl<EObjectDescriptor>();
		}
		return this.tgtEObjectQuery;
	}

	@Override
	public QueryResult<RDType> createQueryResult(QueryExecutorInternal queryExecutor, Iterable<? extends EReferenceDescriptor> result) {
		return new QueryResultImpl<RDType, EReferenceDescriptor>(queryExecutor, result);
	}

	public Iterable<? extends EReferenceDescriptor> queryEReferenceDescriptor(final PageableResourceDescriptorImpl resDesc,
			final GlobalTables globalTables) {
		EObjectQueryImpl<?> srcQuery = getSrcObjectQuery();
		EObjectQueryImpl<?> tgtQuery = getTgtObjectQuery();

		final String srcFragment = srcQuery == null ? null : srcQuery.getFragment();
		final String tgtFragment = tgtQuery == null ? null : tgtQuery.getFragment();

		switch (this.getDirection()) {
		case BACKWARD:
			if (tgtFragment == null || tgtFragment.indexOf('*') > -1) {
				final Iterator<String> keyIterator = resDesc.incomingLinkTable.keyIterator();

				return new FilteredIterableMulti<ReferenceDescriptorImpl>() {

					Iterator<EReferenceDescriptorInternal> scopeIterator;
					private EReferenceDescriptorInternal next;

					@Override
					protected Iterator<ReferenceDescriptorImpl> getNextIterator() {
						while (scopeIterator != null && scopeIterator.hasNext()) {
							next = scopeIterator.next();
							if ((getSourceScope() == null || getSourceScope().contains(next.getSourceResourceURI())) && //
									(srcFragment == null || QueryUtil.matchesGlobbing(next.getSourceFragment(), srcFragment)) && //
									(getType() == null || getType() == next.getEReferenceURI())) {
								if (next.isIntraLink()) {
									return Arrays.asList((ReferenceDescriptorImpl) next).iterator();
								} else {
									PageableResourceDescriptorImpl resDesc = globalTables.resourceIndex
											.acquire(next.getSourceResourceURI()); // FIXME
									// is
									// identical
									// key
									Iterable<ReferenceDescriptorImpl> candidates = resDesc.outgoingLinkTable.getAllWithEqualKey(next
											.getSourceFragment());
									globalTables.resourceIndex.release(resDesc);
									if (candidates != null) {
										return candidates.iterator();
									}
								}
							}
						}

						while (keyIterator.hasNext()) {
							String next = keyIterator.next();
							if (QueryUtil.matchesGlobbing(next, tgtFragment)) {
								scopeIterator = resDesc.incomingLinkTable.getAllWithEqualKey(next).iterator();
								assert scopeIterator != null;
								return getNextIterator();
							}
						}
						return null;
					}

					@Override
					protected boolean matches(ReferenceDescriptorImpl e) {
						if (e.getTargetResourceURI() == resDesc.getURI()) {
							if (e.getTargetFragment().equals(next.getTargetFragment())) {
								if (getType() == null || getType() == e.getEReferenceURI()) {
									//									if (srcFragment == null || QueryUtil.matchesGlobbing(e.getSource().getFragment(), srcFragment)) { 
									return true;
									//									}
								}
							}
						}
						return false;
					}

				};
			} else {
				final Iterator<EReferenceDescriptorInternal> scopeIterator = resDesc.incomingLinkTable.getAllWithEqualKey(tgtFragment)
						.iterator();

				return new FilteredIterable<EReferenceDescriptorInternal>(scopeIterator) {

					@Override
					protected boolean matches(EReferenceDescriptorInternal e) {
						if (getType() == null || getType() == e.getEReferenceURI()) {
							if (getSourceScope() == null || getSourceScope().contains(e.getSourceResourceURI())) {
								if (srcFragment == null || QueryUtil.matchesGlobbing(e.getSourceFragment(), srcFragment)) {
									return true;
								}
							}
						}
						return false;
					}

				};

			}
		case FORWARD:
			if (srcFragment == null || srcFragment.indexOf('*') > -1) {
				final Iterator<String> keyIterator = resDesc.outgoingLinkTable.keyIterator();

				return new FilteredIterableMulti<ReferenceDescriptorImpl>() {

					@Override
					protected Iterator<ReferenceDescriptorImpl> getNextIterator() {
						while (keyIterator.hasNext()) {
							String next = keyIterator.next();
							if (QueryUtil.matchesGlobbing(next, srcFragment)) {
								return resDesc.outgoingLinkTable.getAllWithEqualKey(next).iterator();
							}
						}
						return null;
					}

					@Override
					protected boolean matches(ReferenceDescriptorImpl e) {
						if (getType() == null || getType() == e.getEReferenceURI()) {
							if (getTargetScope() == null || getTargetScope().contains(e.getTargetResourceURI())) {
								if (tgtFragment == null || QueryUtil.matchesGlobbing(e.getTargetFragment(), tgtFragment)) {
									return true;
								}
							}
						}
						return false;
					}

				};
			} else {
				Iterator<ReferenceDescriptorImpl> scope = resDesc.outgoingLinkTable.getAllWithEqualKey(srcFragment).iterator();
				return new FilteredIterable<ReferenceDescriptorImpl>(scope) {

					@Override
					protected boolean matches(ReferenceDescriptorImpl e) {
						if (getType() == null || getType() == e.getEReferenceURI()) {
							if (getTargetScope() == null || getTargetScope().contains(e.getTargetResourceURI())) {
								if (tgtFragment == null || QueryUtil.matchesGlobbing(e.getTargetFragment(), tgtFragment)) {
									return true;
								}
							}
						}
						return false;
					}

				};
			}
		default:
			throw new IllegalArgumentException(getDirection().name());
		}
	}
}
