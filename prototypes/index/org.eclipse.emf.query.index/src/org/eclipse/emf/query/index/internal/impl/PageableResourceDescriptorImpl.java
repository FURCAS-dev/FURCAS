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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.IncomingReferenceDescriptor;
import org.eclipse.emf.query.index.internal.ResourceDescriptorInternal;
import org.eclipse.emf.query.index.internal.impl.query.EObjectQueryImpl;
import org.eclipse.emf.query.index.internal.impl.query.EReferenceQueryImpl;
import org.eclipse.emf.query.index.internal.impl.query.QueryUtil;
import org.eclipse.emf.query.index.internal.maps.ListMap;
import org.eclipse.emf.query.index.internal.maps.SingleMap;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;
import org.eclipse.emf.query.index.internal.util.FilteredIterable;
import org.eclipse.emf.query.index.internal.util.FilteredIterableMulti;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class PageableResourceDescriptorImpl implements ResourceDescriptorInternal {

	private URI uri;
	public static final int URI = 1;

	private long versionId = NOT_INDEXED;

	private byte flags = 0;
	private static final byte PAGED_OUT = 1 << 0;

	private PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceTable;

	private SingleMap<String, EObjectDescriptorImpl> eObjectTable;

	private ListMap<String, EObjectDescriptorImpl> typeTable;

	private ListMap<String, ReferenceDescriptorImpl> outgoingLinkTable;

	private ListMap<String, IncomingReferenceDescriptor> incomingLinkTable;

	private Map<String, String> userData;

	public PageableResourceDescriptorImpl(URI _uri, long versionId, Map<String, String> uData,
			PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resTable, boolean pagedOut) {
		this.userData = uData;
		this.versionId = versionId;
		this.uri = _uri;
		this.resourceTable = resTable;
		if (pagedOut) {
			this.markSwappedOut();
		} else {
			if (versionId != NOT_INDEXED) {
				this.initResourceContentTables();
			}
			this.initIncomingContentTables();
		}
	}

	private void initIncomingContentTables() {
		incomingLinkTable = new ListMap<String, IncomingReferenceDescriptor>(IncomingReferenceDescriptor.TARGET_FRAGMENT, 2);
	}

	private void initResourceContentTables() {
		eObjectTable = new SingleMap<String, EObjectDescriptorImpl>(EObjectDescriptorImpl.FRAGMENT);
		typeTable = new ListMap<String, EObjectDescriptorImpl>(EObjectDescriptorImpl.ECLASS, 2);
		outgoingLinkTable = new ListMap<String, ReferenceDescriptorImpl>(ReferenceDescriptorImpl.SOURCE_FRAGMENT, 2);
	}

	private void removeResourceContentTables() {
		eObjectTable = null;
		typeTable = null;
		outgoingLinkTable = null;
	}

	private void removeAllContentTables() {
		this.removeResourceContentTables();
		incomingLinkTable = null;
	}

	private void setIndexVersion(long time) {
		this.versionId = time;
	}

	@Override
	public Object getKeyElement(int keyNr) {
		switch (keyNr) {
		case URI:
			return uri;
		default:
			throw new IllegalArgumentException();
		}
	}

	public void addEObjectDescriptor(EObjectDescriptor desc) {
		assert desc instanceof EObjectDescriptorImpl;
		eObjectTable.put((EObjectDescriptorImpl) desc);
		typeTable.put((EObjectDescriptorImpl) desc);
	}

	public EObjectDescriptor getEObjectDescriptor(String fragment) {
		assert eObjectTable != null;
		return eObjectTable.getEqual(fragment);
	}

	public void addReferenceDescriptor(EReferenceDescriptor refDesc) {
		assert refDesc instanceof ReferenceDescriptorImpl;
		this.outgoingLinkTable.put((ReferenceDescriptorImpl) refDesc);
	}

	public URI getURI() {
		return this.uri;
	}

	private void setURI(URI value) {
		this.uri = value;
	}

	public Iterator<String> getEClassesOfContainedObjects() {
		return typeTable.keyIterator();
	}

	public void markNotIndexed() {
		this.setIndexVersion(NOT_INDEXED);
		this.removeResourceContentTables();
	}

	public boolean isIndexed() {
		return this.versionId != NOT_INDEXED;
	}

	public boolean isReferenced() {
		return this.incomingLinkTable.size() != 0;
	}

	public void makeIdentic(PageableResourceDescriptorImpl resDesc) {
		resDesc.setURI(this.getURI());
		resDesc.incomingLinkTable = this.incomingLinkTable;
	}

	public void addIncomingLink(ReferenceDescriptorImpl incomingLink, PageableResourceDescriptorImpl fromResDesc) {
		// TODO which way of unifying the targetFragment is the best one?
		// compact() required?
		if (fromResDesc == this) {
			String key = incomingLink.getTargetFragment();
			IncomingReferenceDescriptor exDesc = incomingLinkTable.getEqual(key);
			if (exDesc != null && exDesc.getTargetFragment() != key) {
				incomingLink.setTargetFragment(exDesc.getTargetFragment());
			}
			this.incomingLinkTable.put(incomingLink);
		} else {
			String key = incomingLink.getTargetFragment();
			EObjectDescriptorImpl targetDesc;
			if (eObjectTable == null || (targetDesc = eObjectTable.getEqual(key)) == null) {
				IncomingReferenceDescriptor exRef = incomingLinkTable.getEqual(key);
				if (exRef != null) {
					key = exRef.getTargetFragment();
				}
			} else {
				key = targetDesc.getFragment();
			}

			List<IncomingReferenceDescriptor> incLinks = this.incomingLinkTable.getAllWithEqualKey(key);
			for (int i = 0, n = incLinks.size(); i < n; i++) {
				IncomingReferenceDescriptor incLink = incLinks.get(i);
				if (incLink.getSourceFragment() == incomingLink.getSourceFragment()
						&& incLink.getSourceResourceURI() == fromResDesc.getURI()) {
					return;
				}
			} // is there a faster alternative?

			IncomingReferenceDescriptorImpl extRefDesc = new IncomingReferenceDescriptorImpl(key, fromResDesc.getURI(), incomingLink
					.getSource().getFragment());
			this.incomingLinkTable.put(extRefDesc);
		}
	}

	public void removeIncomingLink(ReferenceDescriptorImpl incomingLink, PageableResourceDescriptorImpl fromResDesc) {
		URI resDescUri = fromResDesc.getURI();

		for (Iterator<IncomingReferenceDescriptor> it = this.incomingLinkTable.iterator(incomingLink.getTargetFragment()); it.hasNext();) {
			IncomingReferenceDescriptor extRefDesc = it.next();
			if (extRefDesc.getSourceResourceURI() == resDescUri) {
				it.remove(); // TODO not completely correct since it deletes all
				// references of the fromResDesc
			}
		}
	}

	public Iterator<ReferenceDescriptorImpl> getReferences() {
		return this.outgoingLinkTable.iterator();
	}

	public void compact() {
		assert this.isIndexed();

		String key;
		for (Iterator<String> it = incomingLinkTable.keyIterator(); it.hasNext();) {
			key = it.next();
			EObjectDescriptorImpl eod = this.eObjectTable.getEqual(key);
			if (eod != null) {
				eod.setFragment(key);
			}
		}
	}

	private void serialize(SerializationStrategyFactory strategyFactory) {
		if (!this.isPagedOut()) { // FIXME this check should be done in the page
			// out method
			if (this.isIndexed()) {
				this.serializeData(strategyFactory.getChannel());
				this.eObjectTable.serialize(strategyFactory.createEObjectMapStrategy(this));
				this.typeTable.serialize(strategyFactory.createTypeMapStrategy(this.eObjectTable));
				this.outgoingLinkTable.serialize(strategyFactory.createOutgoingLinkMapStrategy(this.eObjectTable, this.resourceTable
						.getUnderlyingMap()));
			}
			this.incomingLinkTable.serialize(strategyFactory.createIncomingLinkMapStrategy(this.eObjectTable, this.resourceTable
					.getUnderlyingMap(), this.outgoingLinkTable));
			this.removeAllContentTables();
		}
	}

	private void serializeData(Channel channel) {
		if (this.userData == null) {
			channel.putInt(SerializationStrategyFactory.NO_SIZE); // FIXME constant position
			return;
		} else {
			channel.putInt(this.userData.size());
			for (Map.Entry<String, String> entry : this.userData.entrySet()) {
				channel.putString(entry.getKey());
				channel.putString(entry.getValue());
			}
			this.userData = null;
		}
	}

	private void deserialize(SerializationStrategyFactory strategyFactory) {
		if (this.isPagedOut()) {
			if (this.isIndexed()) {
				this.deserializeData(strategyFactory.getChannel());
				this.initResourceContentTables();
				this.eObjectTable.deserialize(strategyFactory.createEObjectMapStrategy(this));
				this.typeTable.deserialize(strategyFactory.createTypeMapStrategy(this.eObjectTable));
				this.outgoingLinkTable.deserialize(strategyFactory.createOutgoingLinkMapStrategy(this.eObjectTable, this.resourceTable
						.getUnderlyingMap()));
			}
			this.initIncomingContentTables();
			this.incomingLinkTable.deserialize(strategyFactory.createIncomingLinkMapStrategy(this.eObjectTable, this.resourceTable
					.getUnderlyingMap(), this.outgoingLinkTable));
		}
	}

	private void deserializeData(Channel channel) {
		int size = channel.getInt();
		if (size == SerializationStrategyFactory.NO_SIZE) {
			return;
		} else {
			Map<String, String> map = new HashMap<String, String>(size);
			for (int i = 0; i < size; i++) {
				map.put(channel.getString(), channel.getString());
			}
			this.userData = map;
		}
	}

	private void markSwappedOut() {
		this.flags |= PAGED_OUT;
	}

	private void markSwappedIn() {
		this.flags &= ~PAGED_OUT;
	}

	@Override
	public boolean isPagedOut() {
		return (this.flags & PAGED_OUT) != 0;
	}

	@Override
	public boolean pageIn(FileInputStream ch) {
		SerializationStrategyFactory strategyFactory = new SerializationStrategyFactory(ch);
		this.deserialize(strategyFactory);
		strategyFactory.finalizePaging();
		this.markSwappedIn();
		return true;
	}

	@Override
	public boolean pageOut(FileOutputStream ch) {
		SerializationStrategyFactory strategyFactory = new SerializationStrategyFactory(ch);
		this.serialize(strategyFactory);
		strategyFactory.finalizePaging();
		this.markSwappedOut();
		return true;
	}

	@Override
	public int size() {
		// TODO need proper size
		if (eObjectTable != null) {
			return eObjectTable.size();
		} else {
			return 0;
		}
	}

	@Override
	public String getId() {
		return this.uri.toString();
	}

	public Iterable<? extends EObjectDescriptor> queryEObjectDescriptor(EObjectQueryImpl<?> objectQuery) {
		final String frag = objectQuery.getFragment();
		final String type = objectQuery.getType();
		final String name = objectQuery.getName();
		final Map<String, String> uData = objectQuery.getUserData();

		if (frag != null) {
			if (frag.indexOf('*') == -1) { // concrete fragment
				EObjectDescriptorImpl obj = this.eObjectTable.getEqual(frag);
				if (obj == null) {
					return Collections.emptyList();
				} else {
					return new FilteredIterable<EObjectDescriptorImpl>(Collections.singletonList(obj)) {

						@Override
						protected boolean matches(EObjectDescriptorImpl e) {
							if (type == null)
								return matchesUserData(e, uData) && QueryUtil.matchesGlobbing(e.getName(), name);
							else
								return e.getEClassURI() == type && QueryUtil.matchesGlobbing(e.getName(), name)
										&& matchesUserData(e, uData);
						}

					};
				}
			} else { // fragment patters
				Iterable<EObjectDescriptorImpl> base = null;
				if (type != null) {
					base = this.typeTable.getAllWithEqualKey(type);
				} else {
					base = this.eObjectTable;
				}
				if (base == null) {
					return Collections.emptyList();
				} else {
					return new FilteredIterable<EObjectDescriptorImpl>(base) {

						@Override
						protected boolean matches(EObjectDescriptorImpl e) {
							return QueryUtil.matchesGlobbing(e.getFragment(), frag) && QueryUtil.matchesGlobbing(e.getName(), name)
									&& matchesUserData(e, uData);
						}

					};
				}
			}
		} else {
			Iterable<EObjectDescriptorImpl> base;
			if (type != null) {
				base = this.typeTable.getAllWithEqualKey(type);
			} else {
				base = this.eObjectTable;
			}
			return uData == null ? base : new FilteredIterable<EObjectDescriptorImpl>(base) {

				@Override
				protected boolean matches(EObjectDescriptorImpl e) {
					return matchesUserData(e, uData) && QueryUtil.matchesGlobbing(e.getName(), name);
				}

			};
		}
	}

	private boolean matchesUserData(EObjectDescriptorImpl e, Map<String, String> uData) {
		if (uData != null) {
			for (Map.Entry<String, String> entry : uData.entrySet()) {
				String userDataValue = e.getUserData(entry.getKey());
				if (userDataValue == null || !QueryUtil.matchesGlobbing(userDataValue, entry.getValue())) {
					return false;
				}
			}
		}
		return true;
	}

	public Iterable<? extends EReferenceDescriptor> queryEReferenceDescriptor(final EReferenceQueryImpl<?> refQuery) {
		EObjectQueryImpl<?> srcQuery = refQuery.getSrcObjectQuery();
		EObjectQueryImpl<?> tgtQuery = refQuery.getTgtObjectQuery();

		final String srcFragment = srcQuery == null ? null : srcQuery.getFragment();
		final String tgtFragment = tgtQuery == null ? null : tgtQuery.getFragment();

		switch (refQuery.getDirection()) {
		case BACKWARD:
			if (tgtFragment == null || tgtFragment.indexOf('*') > -1) {
				final Iterator<String> keyIterator = this.incomingLinkTable.keyIterator();

				return new FilteredIterableMulti<ReferenceDescriptorImpl>() {

					Iterator<IncomingReferenceDescriptor> scopeIterator;
					private IncomingReferenceDescriptor next;

					@Override
					protected Iterator<ReferenceDescriptorImpl> getNextIterator() {
						while (scopeIterator != null && scopeIterator.hasNext()) {
							next = scopeIterator.next();
							if (refQuery.getSourceScope() == null || refQuery.getSourceScope().contains(next.getSourceResourceURI())) {
								if (next.isIntraLink()) {
									return Arrays.asList((ReferenceDescriptorImpl) next).iterator();
								} else {
									PageableResourceDescriptorImpl resDesc = resourceTable.acquire(next.getSourceResourceURI()); // FIXME
									// is
									// identical
									// key
									Iterable<ReferenceDescriptorImpl> candidates = resDesc.outgoingLinkTable.getAllWithEqualKey(next
											.getSourceFragment());
									resourceTable.release(resDesc);
									if (candidates != null) {
										return candidates.iterator();
									}
								}
							}
						}

						while (keyIterator.hasNext()) {
							String next = keyIterator.next();
							if (QueryUtil.matchesGlobbing(next, tgtFragment)) {
								scopeIterator = incomingLinkTable.getAllWithEqualKey(next).iterator();
								assert scopeIterator != null;
								return getNextIterator();
							}
						}
						return null;
					}

					@Override
					protected boolean matches(ReferenceDescriptorImpl e) {
						if (e.getTargetResourceURI() == getURI()) {
							if (e.getTargetFragment().equals(next.getTargetFragment())) {
								if (refQuery.getType() == null || refQuery.getType() == e.getEReferenceURI()) {
									if (srcFragment == null || QueryUtil.matchesGlobbing(e.getSource().getFragment(), srcFragment)) { // FIXME
										// performance:
										// put
										// this
										// into
										// getNextIterator()
										return true;
									}
								}
							}
						}
						return false;
					}

				};
			} else {
				final Iterator<IncomingReferenceDescriptor> scopeIterator = this.incomingLinkTable.getAllWithEqualKey(tgtFragment)
						.iterator();

				return new FilteredIterableMulti<ReferenceDescriptorImpl>() {

					@Override
					protected Iterator<? extends ReferenceDescriptorImpl> getNextIterator() {
						while (scopeIterator.hasNext()) { // FIXME same loop as
							// above
							IncomingReferenceDescriptor next = scopeIterator.next();
							if (refQuery.getSourceScope() == null || refQuery.getSourceScope().contains(next)) {
								PageableResourceDescriptorImpl resDesc = resourceTable.acquire(next.getSourceResourceURI()); // FIXME
								// is
								// identical
								// key
								Iterable<ReferenceDescriptorImpl> candidates = resDesc.outgoingLinkTable.getAllWithEqualKey(next
										.getSourceFragment());
								resourceTable.release(resDesc);
								if (candidates != null) {
									return candidates.iterator();
								}
							}
						}
						return null;
					}

					@Override
					protected boolean matches(ReferenceDescriptorImpl e) {
						if (e.getTargetResourceURI() == getURI()) {
							if (refQuery.getType() == null || refQuery.getType() == e.getEReferenceURI()) {
								if (srcFragment == null || QueryUtil.matchesGlobbing(e.getSource().getFragment(), srcFragment)) {
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
				final Iterator<String> keyIterator = this.outgoingLinkTable.keyIterator();

				return new FilteredIterableMulti<ReferenceDescriptorImpl>() {

					@Override
					protected Iterator<ReferenceDescriptorImpl> getNextIterator() {
						while (keyIterator.hasNext()) {
							String next = keyIterator.next();
							if (QueryUtil.matchesGlobbing(next, srcFragment)) {
								return outgoingLinkTable.getAllWithEqualKey(next).iterator();
							}
						}
						return null;
					}

					@Override
					protected boolean matches(ReferenceDescriptorImpl e) {
						if (refQuery.getType() == null || refQuery.getType() == e.getEReferenceURI()) {
							if (refQuery.getTargetScope() == null || refQuery.getTargetScope().contains(e.getTargetResourceURI())) {
								if (tgtFragment == null || QueryUtil.matchesGlobbing(e.getTargetFragment(), tgtFragment)) {
									return true;
								}
							}
						}
						return false;
					}

				};
			} else {
				Iterator<ReferenceDescriptorImpl> scope = this.outgoingLinkTable.getAllWithEqualKey(srcFragment).iterator();
				return new FilteredIterable<ReferenceDescriptorImpl>(scope) {

					@Override
					protected boolean matches(ReferenceDescriptorImpl e) {
						if (refQuery.getType() == null || refQuery.getType() == e.getEReferenceURI()) {
							if (refQuery.getTargetScope() == null || refQuery.getTargetScope().contains(e.getTargetResourceURI())) {
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
			throw new IllegalArgumentException(refQuery.getDirection().name());
		}
	}

	@Override
	public String getUserData(String key) {
		if (this.userData == null) {
			return null;
		}
		return this.userData.get(key);
	}

	@Override
	public long getIndexedVersion() {
		return this.versionId;
	}
}
