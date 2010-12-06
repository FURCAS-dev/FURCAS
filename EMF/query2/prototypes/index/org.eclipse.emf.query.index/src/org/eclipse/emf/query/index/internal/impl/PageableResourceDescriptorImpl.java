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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.EReferenceDescriptorInternal;
import org.eclipse.emf.query.index.internal.ResourceDescriptorInternal;
import org.eclipse.emf.query.index.internal.maps.ListMap;
import org.eclipse.emf.query.index.internal.maps.SingleMap;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;
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

	private byte pagingFlag = 0;
	private static final byte PAGED_OUT = 1 << 0;

	private PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceTable;

	public SingleMap<String, EObjectDescriptorImpl> eObjectTable;

	public ListMap<String, EObjectDescriptorImpl> typeTable;

	public ListMap<String, ReferenceDescriptorImpl> outgoingLinkTable;

	public ListMap<String, EReferenceDescriptorInternal> incomingLinkTable;

	public Map<String, String> userData;

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
		incomingLinkTable = new ListMap<String, EReferenceDescriptorInternal>(EReferenceDescriptorInternal.TARGET_FRAGMENT, 2);
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
			EReferenceDescriptorInternal exDesc = incomingLinkTable.getEqual(key);
			if (exDesc != null && exDesc.getTargetFragment() != key) {
				incomingLink.setTargetFragment(exDesc.getTargetFragment());
			}
			this.incomingLinkTable.put(incomingLink);
		} else {
			String key = incomingLink.getTargetFragment();
			EObjectDescriptorImpl targetDesc;
			if (eObjectTable == null || (targetDesc = eObjectTable.getEqual(key)) == null) {
				EReferenceDescriptorInternal exRef = incomingLinkTable.getEqual(key);
				if (exRef != null) {
					key = exRef.getTargetFragment();
				}
			} else {
				key = targetDesc.getFragment();
			}

			List<EReferenceDescriptorInternal> incLinks = this.incomingLinkTable.getAllWithEqualKey(key);
			for (int i = 0, n = incLinks.size(); i < n; i++) {
				EReferenceDescriptorInternal incLink = incLinks.get(i);
				if (incLink.getSourceFragment() == incomingLink.getSourceFragment()
						&& incLink.getSourceResourceURI() == fromResDesc.getURI()) {
					return;
				}
			} // is there a faster alternative?

			IncomingReferenceDescriptorImpl extRefDesc = new IncomingReferenceDescriptorImpl(this, key, fromResDesc.getURI(), incomingLink
					.getSource().getFragment(), incomingLink.getEReferenceURI());
			this.incomingLinkTable.put(extRefDesc);
		}
	}

	public void removeIncomingLink(ReferenceDescriptorImpl incomingLink, PageableResourceDescriptorImpl fromResDesc) {
		URI resDescUri = fromResDesc.getURI();

		for (Iterator<EReferenceDescriptorInternal> it = this.incomingLinkTable.iterator(incomingLink.getTargetFragment()); it.hasNext();) {
			EReferenceDescriptorInternal extRefDesc = it.next();
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
				this.eObjectTable.serialize(strategyFactory.createEObjectMapStrategy(this));
				this.typeTable.serialize(strategyFactory.createTypeMapStrategy(this.eObjectTable));
				this.outgoingLinkTable.serialize(strategyFactory.createOutgoingLinkMapStrategy(this.eObjectTable, this.resourceTable
						.getUnderlyingMap()));
			}
			this.incomingLinkTable.serialize(strategyFactory.createIncomingLinkMapStrategy(this, this.eObjectTable, this.resourceTable
					.getUnderlyingMap(), this.outgoingLinkTable));
			this.removeAllContentTables();
		}
	}

	public void serializeData(Channel channel) {
		if (this.userData == null) {
			channel.putInt(SerializationStrategyFactory.NO_INT); // FIXME constant position
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
				this.initResourceContentTables();
				this.eObjectTable.deserialize(strategyFactory.createEObjectMapStrategy(this));
				this.typeTable.deserialize(strategyFactory.createTypeMapStrategy(this.eObjectTable));
				this.outgoingLinkTable.deserialize(strategyFactory.createOutgoingLinkMapStrategy(this.eObjectTable, this.resourceTable
						.getUnderlyingMap()));
			}
			this.initIncomingContentTables();
			this.incomingLinkTable.deserialize(strategyFactory.createIncomingLinkMapStrategy(this, this.eObjectTable, this.resourceTable
					.getUnderlyingMap(), this.outgoingLinkTable));
		}
	}

	public void deserializeData(Channel channel) {
		int size = channel.getInt();
		if (size == SerializationStrategyFactory.NO_INT) {
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
		this.pagingFlag |= PAGED_OUT;
	}

	private void markSwappedIn() {
		this.pagingFlag &= ~PAGED_OUT;
	}

	@Override
	public boolean isPagedOut() {
		return (this.pagingFlag & PAGED_OUT) != 0;
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

	@Override
	public String toString() {
		return String.valueOf(this.uri);
	}
}
