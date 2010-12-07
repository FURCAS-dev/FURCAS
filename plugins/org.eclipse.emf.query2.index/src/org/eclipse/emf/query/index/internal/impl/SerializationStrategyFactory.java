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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.internal.EReferenceDescriptorInternal;
import org.eclipse.emf.query.index.internal.maps.ListMap;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy;
import org.eclipse.emf.query.index.internal.maps.SingleMap;
import org.eclipse.emf.query.index.internal.maps.SerializationStrategy.Channel;

/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class SerializationStrategyFactory {

	private static final int MAX_SIZE = 262144;

	private static final int INT_SIZE = Integer.SIZE / 8;

	private static final int SHORT_SIZE = Short.SIZE / 8;

	private static final int LONG_SIZE = Long.SIZE / 8;

	private static final int BYTE_SIZE = Byte.SIZE / 8;

	public static final int NO_INT = -1;

	// Java spec requires for UTF-8 to be available on all supported platforms
	private static final String STRING_ENCODING = "UTF-8"; //$NON-NLS-1$

	protected final static class DumpReadBuffer implements Channel {

		private ByteBuffer buffer;

		private ReadableByteChannel fc;

		private byte[] stringBuffer;

		/**
		 * @param input
		 * @param size
		 *            Size of the channel content
		 * @param bufMaxSize
		 *            maximum buffer size
		 * @throws IOException
		 */
		public DumpReadBuffer(ReadableByteChannel input, int size, int bufMaxSize, boolean direct) throws IOException {

			this(input, (size < bufMaxSize) ? size : bufMaxSize, direct);
		}

		/**
		 * @param input
		 * @param bufSize
		 *            fixed buffer size
		 * @throws IOException
		 */
		public DumpReadBuffer(ReadableByteChannel input, int bufSize, boolean direct) throws IOException {

			this.fc = input;
			if (direct) {
				this.buffer = ByteBuffer.allocateDirect(bufSize);
			} else {
				this.buffer = ByteBuffer.allocate(bufSize);
			}
			this.stringBuffer = new byte[bufSize];
			this.fc.read(this.buffer);
			this.buffer.flip();
		}

		public int getInt() {

			return getCompressedInt();

			// if (this.buffer.limit() - this.buffer.position() < INT_SIZE) {
			// this.adjustBuffer();
			// }
			// return this.buffer.getInt();
		}

		public int getCompressedInt() {
			byte initialByte = getByte();
			int code = (initialByte >> 6) & 0x3;
			switch (code) {
			case 0: {
				return initialByte - 1;
			}
			case 1: {
				return (initialByte << 8 & 0x3F00 | getByte() & 0xFF) - 1;
			}
			case 2: {
				return ((initialByte << 16) & 0x3F0000 | (getByte() << 8) & 0xFF00 | getByte() & 0xFF) - 1;
			}
			default: {
				return ((initialByte << 24) & 0x3F000000 | (getByte() << 16) & 0xFF0000 | (getByte() << 8) & 0xFF00 | getByte() & 0xFF) - 1;
			}
			}
		}

		private short getShort() {

			if (this.buffer.limit() - this.buffer.position() < SHORT_SIZE) {
				this.adjustBuffer();
			}
			return this.buffer.getShort();
		}

		public byte getByte() {

			if (this.buffer.limit() - this.buffer.position() < BYTE_SIZE) {
				this.adjustBuffer();
			}
			return this.buffer.get();
		}

		private void getBytes(byte[] buf, int offset, int length) {

			if (this.buffer.limit() - this.buffer.position() < BYTE_SIZE * length) {
				this.adjustBuffer();
			}
			this.buffer.get(buf, offset, length);
		}

		public long getLong() {

			if (this.buffer.limit() - this.buffer.position() < LONG_SIZE) {
				this.adjustBuffer();
			}
			return this.buffer.getLong();
		}

		public String getString() {

			int length = this.getInt();

			if (length == NO_INT) {
				return null;
			}

			if (this.buffer.limit() - this.buffer.position() < length) {
				this.adjustBuffer();
			}
			this.buffer.get(this.stringBuffer, 0, length);
			try {
				return new String(this.stringBuffer, 0, length, STRING_ENCODING);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e); // FIXME exceptino handling
			}
		}

		private void adjustBuffer() {

			this.buffer.compact();
			try {
				this.fc.read(this.buffer);
			} catch (IOException e) {
				throw new RuntimeException(e); // FIXME exception handling
			}
			this.buffer.flip();
		}

		public void putByte(byte b) {
			throw new UnsupportedOperationException();
		}

		public void putInt(int i) {
			throw new UnsupportedOperationException();
		}

		public void putLong(long l) {
			throw new UnsupportedOperationException();
		}

		public void putString(String s) {
			throw new UnsupportedOperationException();
		}

		public void close() {
		}

		public String[] getStringPool() {
			try {
				return getStringPoolImpl();
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}

		private String[] getStringPoolImpl() throws UnsupportedEncodingException {

			int nos = getInt();

			byte[] stringBuffer = new byte[MAX_SIZE];

			String[] ret = new String[nos];

			for (int i = 0; i < nos; i++) {
				short offset = getShort();
				short reset = getShort();

				getBytes(stringBuffer, reset, offset);

				ret[i] = new String(stringBuffer, 0, reset + offset, STRING_ENCODING);
			}

			return ret;
		}

		public Map<String, Integer> putStringPool(List<String> strings) {
			throw new UnsupportedOperationException();
		}

	}

	protected final static class DumpWriteBuffer implements Channel {

		private ByteBuffer buffer = null;

		private WritableByteChannel fc = null;

		public DumpWriteBuffer(WritableByteChannel output, int bufMaxSize, boolean direct) {

			this.fc = output;
			if (direct) {
				this.buffer = ByteBuffer.allocateDirect(bufMaxSize);
			} else {
				this.buffer = ByteBuffer.allocate(bufMaxSize);
			}
		}

		public void putInt(int value) {

			putCompressedInt(value);

			// if (this.buffer.limit() - this.buffer.position() < INT_SIZE) {
			// this.flushBuffer(INT_SIZE);
			// }
			// this.buffer.putInt(value);
		}

		public void putCompressedInt(int value) {
			++value;
			int firstByte = value >> 24 & 0xFF;
			int secondByte = value >> 16 & 0xFF;
			int thirdByte = value >> 8 & 0xFF;
			int fourthBtye = value & 0xFF;
			if (firstByte > 0x3F) {
				throw new RuntimeException("Unsupported value " + value); // FIXME
				// not_very_nice
			} else if (firstByte != 0 || secondByte > 0x3F) {
				putByte((byte) (firstByte | 0xC0));
				putByte((byte) (secondByte));
				putByte((byte) (thirdByte));
				putByte((byte) (fourthBtye));
			} else if (secondByte != 0 || thirdByte > 0x3F) {
				putByte((byte) (secondByte | 0x80));
				putByte((byte) (thirdByte));
				putByte((byte) (fourthBtye));
			} else if (thirdByte != 0 || fourthBtye > 0x3F) {
				putByte((byte) (thirdByte | 0x40));
				putByte((byte) (fourthBtye));
			} else {
				putByte((byte) (fourthBtye));
			}
		}

		private void putShort(short value) {
			if (this.buffer.limit() - this.buffer.position() < SHORT_SIZE) {
				this.flushBuffer(SHORT_SIZE);
			}
			this.buffer.putShort(value);
		}

		public void putString(String value) {

			if (value == null) {
				this.putInt(NO_INT);
				return;
			}

			byte[] bytes;
			try {
				bytes = value.getBytes(STRING_ENCODING);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e); // FIXME exception handling
			}

			this.putInt(bytes.length);

			if (this.buffer.limit() - this.buffer.position() < bytes.length) {
				this.flushBuffer(bytes.length);
			}
			this.buffer.put(bytes);
		}

		public void putLong(long value) {

			if (this.buffer.limit() - this.buffer.position() < LONG_SIZE) {
				this.flushBuffer(LONG_SIZE);
			}
			this.buffer.putLong(value);
		}

		public void putByte(byte value) {

			if (this.buffer.limit() - this.buffer.position() < BYTE_SIZE) {
				this.flushBuffer(BYTE_SIZE);
			}
			this.buffer.put(value);
		}

		private void putBytes(byte[] bytes) {
			if (this.buffer.limit() - this.buffer.position() < BYTE_SIZE * bytes.length) {
				this.flushBuffer(BYTE_SIZE);
			}
			this.buffer.put(bytes);

		}

		private void flushBuffer(int nextInputSize) {

			// set limit to position and position to 0
			this.buffer.flip();
			// write buffer content to file channel
			try {
				this.fc.write(this.buffer);
			} catch (IOException e) {
				throw new RuntimeException(e); // FIXME exception handling
			}
			// check if buffer is big enough to handle next input
			if (this.buffer.capacity() < nextInputSize) {
				throw new BufferOverflowException();
			}
			// set limit to capacity and position to 0
			this.buffer.clear();
		}

		public void flushBuffer() throws IOException {

			this.flushBuffer(0);
		}

		public byte getByte() {
			throw new UnsupportedOperationException();
		}

		public int getInt() {
			throw new UnsupportedOperationException();
		}

		public long getLong() {
			throw new UnsupportedOperationException();
		}

		public String getString() {
			throw new UnsupportedOperationException();
		}

		public void close() {
			try {
				this.flushBuffer();
			} catch (IOException e) {
				throw new RuntimeException(e); // FIXME exception handling
			}
		}

		public String[] getStringPool() {
			throw new UnsupportedOperationException();
		}

		public Map<String, Integer> putStringPool(List<String> in) {
			try {
				return putStringPoolImpl(in);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}

		private Map<String, Integer> putStringPoolImpl(List<String> in) throws UnsupportedEncodingException {

			// FIXME byte[] buf = new byte[4];

			// FIXME os.write( toByteArray( buf, in.size( ) ) );

			int inSize = in.size();

			putInt(inSize);

			Map<String, Integer> ret = new HashMap<String, Integer>(inSize);

			// compute offset and reset index
			String prevString = ""; //$NON-NLS-1$
			int longestString = 0;
			for (int i = 0; i < inSize; i++) {
				String s = in.get(i);

				ret.put(s, i);

				// don't need overflow checks, the strings are unique
				int resetIndexChars = commonPrefixAt(prevString, s);

				short resetIndexBytes = (short) s.substring(0, resetIndexChars).getBytes(STRING_ENCODING).length;

				// for now, the offset is just the number of chars after reset.
				// the byte offsets are computed later
				short offsetIndexBytes = (short) (s.getBytes(STRING_ENCODING).length - resetIndexBytes);

				longestString = Math.max(resetIndexBytes + offsetIndexBytes, longestString);

				prevString = s;

				String tail = s.substring(resetIndexBytes, s.length());

				// FIXME os.write( tail.getBytes( STRING_ENCODING ) );
				putShort(offsetIndexBytes);
				putShort(resetIndexBytes);
				putBytes(tail.getBytes(STRING_ENCODING));
			}

			// FIXME os.write( toByteArray( buf, longestString ) );
			// FIXME putInt(longestString);

			return ret;
		}

		private int commonPrefixAt(String s1, String s2) {

			int l1 = s1.length();
			int l2 = s2.length();

			int i = 0;
			for (i = 0; i < l1 && i < l2; i++) {
				if (s1.charAt(i) != s2.charAt(i)) {
					break;
				}
			}

			return i;
		}

	}

	private abstract static class BaseStrategy<K, E> implements SerializationStrategy<K, E> {

		protected Channel channel;

		public BaseStrategy(Channel ch) {
			this.channel = ch;
		}

		public Channel getChannel() {
			return this.channel;
		}
	}

	private static class EObjectMapStrategy extends BaseStrategy<String, EObjectDescriptorImpl> {

		private PageableResourceDescriptorImpl resourceDescriptor;

		private EObjectMapStrategy(Channel _channel, PageableResourceDescriptorImpl resDesc) {
			super(_channel);
			this.resourceDescriptor = resDesc;
		}

		public EObjectDescriptorImpl readElement(String key) {
			String name = this.channel.getString();
			int size = channel.getInt();
			if (size == NO_INT) {
				return new EObjectDescriptorImpl(null, this.resourceDescriptor, key, name, null);
			} else {
				Map<String, String> userData = new HashMap<String, String>(size);
				for (int i = 0; i < size; i++) {
					userData.put(channel.getString(), channel.getString());
				}
				return new EObjectDescriptorImpl(null, this.resourceDescriptor, key, name, userData);
			}
		}

		public String readKey() {
			return channel.getString();
		}

		public void writeElement(EObjectDescriptorImpl element) {
			channel.putString(element.getName());
			Map<String, String> userData = element.getUserData();
			if (userData == null) {
				channel.putInt(NO_INT);
			} else {
				channel.putInt(userData.size());
				for (Map.Entry<String, String> entry : userData.entrySet()) {
					channel.putString(entry.getKey());
					channel.putString(entry.getValue());
				}
			}
		}

		public void writeKey(String key) {
			channel.putString(key);
		}
	}

	private static class LocalTypeMapStrategy extends BaseStrategy<String, EObjectDescriptorImpl> {

		private SingleMap<String, EObjectDescriptorImpl> eObjectMap;

		private LocalTypeMapStrategy(Channel _channel, SingleMap<String, EObjectDescriptorImpl> eObjMap) {
			super(_channel);
			this.eObjectMap = eObjMap;
		}

		public EObjectDescriptorImpl readElement(String key) {
			int pos = channel.getInt();
			EObjectDescriptorImpl objectDescriptor = eObjectMap.get(pos);
			objectDescriptor.setEClass(key);
			return objectDescriptor;
		}

		public String readKey() {
			return channel.getString().intern();
		}

		public void writeElement(EObjectDescriptorImpl element) {
			channel.putInt(eObjectMap.getPosition(element.getFragment()));
		}

		public void writeKey(String key) {
			channel.putString(key);
		}
	}

	private static class OutgoingLinkMapStrategy extends BaseStrategy<String, ReferenceDescriptorImpl> {

		private SingleMap<URI, PageableResourceDescriptorImpl> resourceMap;

		private SingleMap<String, EObjectDescriptorImpl> eObjectMap;

		private Map<String, Integer> refAliasCacheWrite = new IdentityHashMap<String, Integer>();

		private Map<Integer, String> refAliasCacheRead = new HashMap<Integer, String>();

		private int counter = 0;

		private static final byte INTRA = 0;
		private static final byte CROSS = 1;

		private OutgoingLinkMapStrategy(Channel _channel, SingleMap<URI, PageableResourceDescriptorImpl> resDesc, SingleMap<String, EObjectDescriptorImpl> eObjMap) {
			super(_channel);
			this.resourceMap = resDesc;
			this.eObjectMap = eObjMap;
		}

		public ReferenceDescriptorImpl readElement(String key) {
			int typeAlias = channel.getInt();
			String typeURI = this.refAliasCacheRead.get(typeAlias);
			if (typeURI == null) {
				typeURI = channel.getString().intern();
				this.refAliasCacheRead.put(typeAlias, typeURI);
			}
			byte kind = channel.getByte();

			URI tarRes;
			String fragment;

			switch (kind) {
			case INTRA:
				int position = channel.getInt();
				if (position != -1) {
					EObjectDescriptorImpl target = eObjectMap.get(position);
					tarRes = target.getResourceURI();
					fragment = target.getFragment();
					break;
				} // else dangling intra link (process as cross link)
			case CROSS:
				tarRes = URI.createURI(channel.getString());
				fragment = channel.getString();
				tarRes = this.resourceMap.getEqual(tarRes).getURI();
				assert tarRes != null;
				break;
			default:
				throw new IllegalArgumentException("Unknown link kind " + kind);
			}

			return new ReferenceDescriptorImpl(eObjectMap.get(key), typeURI, tarRes, fragment);
		}

		public String readKey() {
			return eObjectMap.get(channel.getInt()).getFragment();
		}

		public void writeElement(ReferenceDescriptorImpl element) {
			Integer alias = this.refAliasCacheWrite.get(element.getEReferenceURI());
			if (alias == null) {
				channel.putInt(counter);
				channel.putString(element.getEReferenceURI());
				this.refAliasCacheWrite.put(element.getEReferenceURI(), counter);
				counter++;
			} else {
				channel.putInt(alias);
			}
			if (element.isIntraLink()) {
				channel.putByte(INTRA);
				int position = eObjectMap.getPosition(element.getTargetFragment());
				channel.putInt(position);
				if (position == -1) {
					// dangling intra link
					channel.putString(element.getTargetResourceURI().toString());
					channel.putString(element.getTargetFragment());
				}
			} else {
				channel.putByte(CROSS);
				channel.putString(element.getTargetResourceURI().toString());
				channel.putString(element.getTargetFragment());
			}
		}

		public void writeKey(String key) {
			channel.putInt(eObjectMap.getPosition(key));
		}
	}

	private static class IncomingLinkMapStrategy extends BaseStrategy<String, EReferenceDescriptorInternal> {

		private final SingleMap<URI, PageableResourceDescriptorImpl> resourceMap;

		private final SingleMap<String, EObjectDescriptorImpl> eObjectMap;

		private final ListMap<String, ReferenceDescriptorImpl> linkTable;

		private final PageableResourceDescriptorImpl resDesc;

		private IncomingLinkMapStrategy(Channel _channel, PageableResourceDescriptorImpl resDesc, SingleMap<URI, PageableResourceDescriptorImpl> resDescs,
				SingleMap<String, EObjectDescriptorImpl> eObjMap, ListMap<String, ReferenceDescriptorImpl> outgoingLinkTable) {
			super(_channel);
			this.resDesc = resDesc;
			this.resourceMap = resDescs;
			this.eObjectMap = eObjMap;
			this.linkTable = outgoingLinkTable;
		}

		private static final byte INTRA = 0;
		private static final byte CROSS = 1;
		private int[] position = new int[2];

		public EReferenceDescriptorInternal readElement(String key) {
			byte linkType = channel.getByte();
			switch (linkType) {
			case INTRA:
				position[0] = channel.getInt();
				position[1] = channel.getInt();
				return this.linkTable.get(position);
			case CROSS:
				URI tarRes = URI.createURI(channel.getString());
				String fragment = channel.getString();
				tarRes = this.resourceMap.getEqual(tarRes).getURI();
				String reference = channel.getString();
				return new IncomingReferenceDescriptorImpl(this.resDesc, key, tarRes, fragment, reference);
			default:
				throw new IllegalArgumentException("Unknown link type: " + linkType);
			}

		}

		public String readKey() {
			int pos = channel.getInt();
			if (pos == NO_INT) {
				return channel.getString();
			} else {
				return eObjectMap.get(pos).getFragment();
			}
		}

		public void writeElement(EReferenceDescriptorInternal element) {
			if (element.isIntraLink()) {
				channel.putByte(INTRA);
				this.linkTable.getPosition(element, position);
				channel.putInt(position[0]);
				channel.putInt(position[1]);
			} else {
				channel.putByte(CROSS);
				channel.putString(element.getSourceResourceURI().toString());
				channel.putString(element.getSourceFragment());
				channel.putString(element.getEReferenceURI());
			}
		}

		public void writeKey(String key) {
			if (eObjectMap == null) {
				channel.putInt(NO_INT);
				channel.putString(key);
			} else {
				int pos = eObjectMap.getPosition(key);
				if (pos == -1) {
					channel.putInt(NO_INT);
					channel.putString(key);
				} else {
					channel.putInt(pos);
				}
			}

		}
	}

	private static class ResourceMapStrategy extends BaseStrategy<URI, PageableResourceDescriptorImpl> {

		private final PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceMap;

		public ResourceMapStrategy(Channel ch, PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resDesc) {
			super(ch);
			this.resourceMap = resDesc;
		}

		public PageableResourceDescriptorImpl readElement(URI key) {
			long version = channel.getLong();
			PageableResourceDescriptorImpl impl = new PageableResourceDescriptorImpl(key, version, null, this.resourceMap, true /* pagedOut */);
			impl.deserializeData(channel);
			return impl;
		}

		public URI readKey() {
			return URI.createURI(channel.getString());
		}

		public void writeElement(PageableResourceDescriptorImpl element) {
			channel.putLong(element.getIndexedVersion());
			element.serializeData(channel);
		}

		public void writeKey(URI key) {
			channel.putString(key.toString());
		}

	}

	private static class GlobalTypeMapStrategy extends BaseStrategy<String, URI> {

		private final SingleMap<URI, PageableResourceDescriptorImpl> resourceMap;

		public GlobalTypeMapStrategy(Channel ch, SingleMap<URI, PageableResourceDescriptorImpl> resMap) {
			super(ch);
			this.resourceMap = resMap;
		}

		public URI readElement(String key) {
			return this.resourceMap.get(channel.getInt()).getURI();
		}

		public String readKey() {
			return channel.getString().intern();
		}

		public void writeElement(URI element) {
			int position = this.resourceMap.getPosition(element);
			channel.putInt(position);
		}

		public void writeKey(String key) {
			channel.putString(key);
		}

	}

	private Channel channel;

	public SerializationStrategyFactory(InputStream ch) {
		try {
			ReadableByteChannel newChannel = Channels.newChannel(ch);
			this.channel = new DumpReadBuffer(newChannel, MAX_SIZE, true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public SerializationStrategyFactory(OutputStream ch) {
		WritableByteChannel newChannel = Channels.newChannel(ch);
		this.channel = new DumpWriteBuffer(newChannel, MAX_SIZE, true);
	}

	public SerializationStrategy<String, EObjectDescriptorImpl> createEObjectMapStrategy(PageableResourceDescriptorImpl resDesc) {
		return new EObjectMapStrategy(this.getChannel(), resDesc);
	}

	public SerializationStrategy<String, EObjectDescriptorImpl> createTypeMapStrategy(SingleMap<String, EObjectDescriptorImpl> eObjectMap) {
		return new LocalTypeMapStrategy(this.getChannel(), eObjectMap);
	}

	public SerializationStrategy<String, ReferenceDescriptorImpl> createOutgoingLinkMapStrategy(SingleMap<String, EObjectDescriptorImpl> eObjectMap,
			SingleMap<URI, PageableResourceDescriptorImpl> resourceMap) {
		return new OutgoingLinkMapStrategy(this.getChannel(), resourceMap, eObjectMap);
	}

	public SerializationStrategy<String, EReferenceDescriptorInternal> createIncomingLinkMapStrategy(PageableResourceDescriptorImpl resDesc,
			SingleMap<String, EObjectDescriptorImpl> eObjectMap, SingleMap<URI, PageableResourceDescriptorImpl> resourceMap,
			ListMap<String, ReferenceDescriptorImpl> outgoingLinkTable) {
		return new IncomingLinkMapStrategy(this.getChannel(), resDesc, resourceMap, eObjectMap, outgoingLinkTable);
	}

	public SerializationStrategy<URI, PageableResourceDescriptorImpl> createResourceMapStrategy(PagingResourceDescriptorMap<URI, PageableResourceDescriptorImpl> resourceMap) {
		return new ResourceMapStrategy(this.getChannel(), resourceMap);
	}

	public SerializationStrategy<String, URI> createGlobalTypeMapStrategy(SingleMap<URI, PageableResourceDescriptorImpl> underlyingMap) {
		return new GlobalTypeMapStrategy(this.getChannel(), underlyingMap);
	}

	protected Channel getChannel() {
		return this.channel;
	}

	public void finalizePaging() {
		this.getChannel().close();
	}

}
